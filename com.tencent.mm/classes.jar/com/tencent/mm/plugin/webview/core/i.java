package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"})
public class i
{
  public BaseWebViewController controller;
  
  public void Wv(int paramInt) {}
  
  public void a(com.tencent.mm.plugin.webview.j.i parami)
  {
    AppMethodBeat.i(214287);
    p.h(parami, "performanceHelper");
    AppMethodBeat.o(214287);
  }
  
  public void a(String paramString, avj paramavj)
  {
    AppMethodBeat.i(214283);
    p.h(paramString, "reqUrl");
    p.h(paramavj, "response");
    AppMethodBeat.o(214283);
  }
  
  public void aGt(String paramString)
  {
    AppMethodBeat.i(214282);
    p.h(paramString, "reqUrl");
    AppMethodBeat.o(214282);
  }
  
  public void aGu(String paramString)
  {
    AppMethodBeat.i(214289);
    p.h(paramString, "html");
    AppMethodBeat.o(214289);
  }
  
  public void b(com.tencent.mm.plugin.webview.j.i parami)
  {
    AppMethodBeat.i(214288);
    p.h(parami, "performanceHelper");
    AppMethodBeat.o(214288);
  }
  
  public void b(String paramString, avj paramavj)
  {
    AppMethodBeat.i(214284);
    p.h(paramString, "reqUrl");
    p.h(paramavj, "response");
    AppMethodBeat.o(214284);
  }
  
  public void bRf() {}
  
  public void bn(int paramInt, String paramString)
  {
    AppMethodBeat.i(214281);
    p.h(paramString, "reqUrl");
    AppMethodBeat.o(214281);
  }
  
  public void c(String paramString, avj paramavj)
  {
    AppMethodBeat.i(214285);
    p.h(paramString, "reqUrl");
    p.h(paramavj, "response");
    AppMethodBeat.o(214285);
  }
  
  public void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(214286);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "errMsg");
    AppMethodBeat.o(214286);
  }
  
  public void dWE() {}
  
  public void eNJ() {}
  
  public void eNK() {}
  
  public void eNL() {}
  
  public void eNM() {}
  
  public void eNN() {}
  
  public void onFinish() {}
  
  public void uT(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.i
 * JD-Core Version:    0.7.0.1
 */