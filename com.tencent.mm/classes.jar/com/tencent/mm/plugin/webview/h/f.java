package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/reporter/PrefetchWebControllerReportInfo;", "", "()V", "bootWebViewUseTime", "", "getBootWebViewUseTime", "()J", "setBootWebViewUseTime", "(J)V", "hasReportedActionList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchReportNewAction;", "Lkotlin/collections/ArrayList;", "hasTriggerReportIllegalFlag", "", "isColdBootWebView", "Lcom/tencent/mm/plugin/webview/reporter/IsColdBootWebView;", "()Lcom/tencent/mm/plugin/webview/reporter/IsColdBootWebView;", "setColdBootWebView", "(Lcom/tencent/mm/plugin/webview/reporter/IsColdBootWebView;)V", "prefetchCompleteStatusRecordInController", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;", "getPrefetchCompleteStatusRecordInController", "()Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;", "setPrefetchCompleteStatusRecordInController", "(Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;)V", "reportUrl", "", "getReportUrl", "()Ljava/lang/String;", "setReportUrl", "(Ljava/lang/String;)V", "startActivityTimestamp", "getStartActivityTimestamp", "setStartActivityTimestamp", "webViewUICreateTimeStamp", "getWebViewUICreateTimeStamp", "setWebViewUICreateTimeStamp", "checkIsLegalAndUpdateReportStatus", "action", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public long WQN;
  public long WQO;
  private b WQP;
  public ArrayList<d> WQQ;
  public c WQR;
  public boolean WQS;
  public String ytX;
  
  public f()
  {
    AppMethodBeat.i(294684);
    this.ytX = "";
    this.WQP = b.WQs;
    this.WQQ = new ArrayList();
    this.WQR = c.WQw;
    AppMethodBeat.o(294684);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(294694);
    s.u(paramc, "<set-?>");
    this.WQR = paramc;
    AppMethodBeat.o(294694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.h.f
 * JD-Core Version:    0.7.0.1
 */