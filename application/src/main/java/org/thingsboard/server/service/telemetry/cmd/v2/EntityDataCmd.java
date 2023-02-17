/**
 * Copyright © 2016-2022 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.service.telemetry.cmd.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.thingsboard.server.common.data.query.EntityDataQuery;

public class EntityDataCmd extends DataCmd {

    @Getter
    private final EntityDataQuery query;
    @Getter
    private final EntityHistoryCmd historyCmd;
    @Getter
    private final LatestValueCmd latestCmd;
    @Getter
    private final TimeSeriesCmd tsCmd;
    @Getter
    private final AggHistoryCmd aggHistoryCmd;
    @Getter
    private final AggTimeSeriesCmd aggTsCmd;

    @Getter
    private final String tempDeviceName;

    @Getter
    private final boolean temp;

    public EntityDataCmd(int cmdId, EntityDataQuery query, EntityHistoryCmd historyCmd, LatestValueCmd latestCmd, TimeSeriesCmd tsCmd) {
        this(cmdId, query, historyCmd, latestCmd, tsCmd, null, null,false,null);
    }

    @JsonCreator
    public EntityDataCmd(@JsonProperty("cmdId") int cmdId,
                         @JsonProperty("query") EntityDataQuery query,
                         @JsonProperty("historyCmd") EntityHistoryCmd historyCmd,
                         @JsonProperty("latestCmd") LatestValueCmd latestCmd,
                         @JsonProperty("tsCmd") TimeSeriesCmd tsCmd,
                         @JsonProperty("aggHistoryCmd") AggHistoryCmd aggHistoryCmd,
                         @JsonProperty("aggTsCmd") AggTimeSeriesCmd aggTsCmd,
                         @JsonProperty("temp") boolean temp,
                         @JsonProperty("tempDeviceName") String tempDeviceName) {
        super(cmdId);
        this.query = query;
        this.historyCmd = historyCmd;
        this.latestCmd = latestCmd;
        this.tsCmd = tsCmd;
        this.aggHistoryCmd = aggHistoryCmd;
        this.aggTsCmd = aggTsCmd;
        this.temp = temp;
        this.tempDeviceName = tempDeviceName;
    }

    @JsonIgnore
    public boolean hasAnyCmd() {
        return historyCmd != null || latestCmd != null || tsCmd != null || aggHistoryCmd != null || aggTsCmd != null;
    }

}
