package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.j.h;
import com.tencent.mm.protocal.protobuf.arn;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"})
public class i
{
  public BaseWebViewController controller;
  
  public void UD(int paramInt) {}
  
  public void a(h paramh)
  {
    AppMethodBeat.i(205498);
    k.h(paramh, "performanceHelper");
    AppMethodBeat.o(205498);
  }
  
  public void a(String paramString, arn paramarn)
  {
    AppMethodBeat.i(205494);
    k.h(paramString, "reqUrl");
    k.h(paramarn, "response");
    AppMethodBeat.o(205494);
  }
  
  public void aAY(String paramString)
  {
    AppMethodBeat.i(205493);
    k.h(paramString, "reqUrl");
    AppMethodBeat.o(205493);
  }
  
  public void aAZ(String paramString)
  {
    AppMethodBeat.i(205500);
    k.h(paramString, "html");
    AppMethodBeat.o(205500);
  }
  
  public void b(h paramh)
  {
    AppMethodBeat.i(205499);
    k.h(paramh, "performanceHelper");
    AppMethodBeat.o(205499);
  }
  
  public void b(String paramString, arn paramarn)
  {
    AppMethodBeat.i(205495);
    k.h(paramString, "reqUrl");
    k.h(paramarn, "response");
    AppMethodBeat.o(205495);
  }
  
  public void bMF() {}
  
  public void bk(int paramInt, String paramString)
  {
    AppMethodBeat.i(205492);
    k.h(paramString, "reqUrl");
    AppMethodBeat.o(205492);
  }
  
  public void c(String paramString, arn paramarn)
  {
    AppMethodBeat.i(205496);
    k.h(paramString, "reqUrl");
    k.h(paramarn, "response");
    AppMethodBeat.o(205496);
  }
  
  public void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(205497);
    k.h(paramString1, "reqUrl");
    k.h(paramString2, "errMsg");
    AppMethodBeat.o(205497);
  }
  
  public void dKr() {}
  
  public void eyU() {}
  
  public void eyV() {}
  
  public void eyW() {}
  
  public void eyX() {}
  
  public void eyY() {}
  
  public void onFinish() {}
  
  public void uf(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.i
 * JD-Core Version:    0.7.0.1
 */