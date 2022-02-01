package com.tencent.mm.plugin.webview.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/reporter/PrefetchNewReportInfo;", "", "()V", "hasReportInClick", "", "getHasReportInClick", "()Z", "setHasReportInClick", "(Z)V", "prefetchCompleteStatus", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;", "getPrefetchCompleteStatus", "()Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;", "setPrefetchCompleteStatus", "(Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;)V", "prefetchTestClickStartTime", "", "getPrefetchTestClickStartTime", "()J", "setPrefetchTestClickStartTime", "(J)V", "webview-sdk_release"})
public final class b
{
  public long PZB;
  public boolean PZC;
  public c PZD = c.PZE;
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(205143);
    p.k(paramc, "<set-?>");
    this.PZD = paramc;
    AppMethodBeat.o(205143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.i.b
 * JD-Core Version:    0.7.0.1
 */