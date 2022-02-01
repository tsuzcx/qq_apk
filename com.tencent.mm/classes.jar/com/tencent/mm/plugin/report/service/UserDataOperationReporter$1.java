package com.tencent.mm.plugin.report.service;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dd;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/report/service/UserDataOperationReporter$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializedEvent;", "callback", "", "event", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UserDataOperationReporter$1
  extends IListener<dd>
{
  UserDataOperationReporter$1(f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(369714);
    AppMethodBeat.o(369714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.UserDataOperationReporter.1
 * JD-Core Version:    0.7.0.1
 */