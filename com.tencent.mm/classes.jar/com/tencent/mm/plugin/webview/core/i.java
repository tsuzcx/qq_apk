package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avz;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"})
public class i
{
  public BaseWebViewController controller;
  
  public void Xc(int paramInt) {}
  
  public void a(com.tencent.mm.plugin.webview.j.i parami)
  {
    AppMethodBeat.i(214128);
    p.h(parami, "performanceHelper");
    AppMethodBeat.o(214128);
  }
  
  public void a(String paramString, avz paramavz)
  {
    AppMethodBeat.i(214124);
    p.h(paramString, "reqUrl");
    p.h(paramavz, "response");
    AppMethodBeat.o(214124);
  }
  
  public void aHN(String paramString)
  {
    AppMethodBeat.i(214123);
    p.h(paramString, "reqUrl");
    AppMethodBeat.o(214123);
  }
  
  public void aHO(String paramString)
  {
    AppMethodBeat.i(214130);
    p.h(paramString, "html");
    AppMethodBeat.o(214130);
  }
  
  public void b(com.tencent.mm.plugin.webview.j.i parami)
  {
    AppMethodBeat.i(214129);
    p.h(parami, "performanceHelper");
    AppMethodBeat.o(214129);
  }
  
  public void b(String paramString, avz paramavz)
  {
    AppMethodBeat.i(214125);
    p.h(paramString, "reqUrl");
    p.h(paramavz, "response");
    AppMethodBeat.o(214125);
  }
  
  public void bSg() {}
  
  public void bm(int paramInt, String paramString)
  {
    AppMethodBeat.i(214122);
    p.h(paramString, "reqUrl");
    AppMethodBeat.o(214122);
  }
  
  public void c(String paramString, avz paramavz)
  {
    AppMethodBeat.i(214126);
    p.h(paramString, "reqUrl");
    p.h(paramavz, "response");
    AppMethodBeat.o(214126);
  }
  
  public void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(214127);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "errMsg");
    AppMethodBeat.o(214127);
  }
  
  public void eRu() {}
  
  public void eRv() {}
  
  public void eRw() {}
  
  public void eRx() {}
  
  public void eRy() {}
  
  public void eag() {}
  
  public void onFinish() {}
  
  public void vb(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.i
 * JD-Core Version:    0.7.0.1
 */