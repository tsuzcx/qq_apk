package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhj;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"})
public class j
{
  public BaseWebViewController controller;
  
  public void a(com.tencent.mm.plugin.webview.k.j paramj)
  {
    AppMethodBeat.i(225058);
    p.h(paramj, "performanceHelper");
    AppMethodBeat.o(225058);
  }
  
  public void a(String paramString, bhj parambhj)
  {
    AppMethodBeat.i(225054);
    p.h(paramString, "reqUrl");
    p.h(parambhj, "response");
    AppMethodBeat.o(225054);
  }
  
  public void aXN(String paramString)
  {
    AppMethodBeat.i(225053);
    p.h(paramString, "reqUrl");
    AppMethodBeat.o(225053);
  }
  
  public void aXO(String paramString)
  {
    AppMethodBeat.i(225060);
    p.h(paramString, "html");
    AppMethodBeat.o(225060);
  }
  
  public void afL(int paramInt) {}
  
  public void b(com.tencent.mm.plugin.webview.k.j paramj)
  {
    AppMethodBeat.i(225059);
    p.h(paramj, "performanceHelper");
    AppMethodBeat.o(225059);
  }
  
  public void b(String paramString, bhj parambhj)
  {
    AppMethodBeat.i(225055);
    p.h(paramString, "reqUrl");
    p.h(parambhj, "response");
    AppMethodBeat.o(225055);
  }
  
  public void by(int paramInt, String paramString)
  {
    AppMethodBeat.i(225052);
    p.h(paramString, "reqUrl");
    AppMethodBeat.o(225052);
  }
  
  public void c(String paramString, bhj parambhj)
  {
    AppMethodBeat.i(225056);
    p.h(paramString, "reqUrl");
    p.h(parambhj, "response");
    AppMethodBeat.o(225056);
  }
  
  public void cpR() {}
  
  public void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(225057);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "errMsg");
    AppMethodBeat.o(225057);
  }
  
  public void ePr() {}
  
  public void gab() {}
  
  public void gac() {}
  
  public void gad() {}
  
  public void gae() {}
  
  public void gaf() {}
  
  public void onFinish() {}
  
  public void yS(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.j
 * JD-Core Version:    0.7.0.1
 */