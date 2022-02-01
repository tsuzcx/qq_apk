package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.j.h;
import com.tencent.mm.protocal.protobuf.aoj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"})
public class i
{
  public BaseWebViewController controller;
  
  public void Sv(int paramInt) {}
  
  public void a(h paramh)
  {
    AppMethodBeat.i(189366);
    k.h(paramh, "performanceHelper");
    AppMethodBeat.o(189366);
  }
  
  public void a(String paramString, aoj paramaoj)
  {
    AppMethodBeat.i(189362);
    k.h(paramString, "reqUrl");
    k.h(paramaoj, "response");
    AppMethodBeat.o(189362);
  }
  
  public void avG(String paramString)
  {
    AppMethodBeat.i(189361);
    k.h(paramString, "reqUrl");
    AppMethodBeat.o(189361);
  }
  
  public void avH(String paramString)
  {
    AppMethodBeat.i(189368);
    k.h(paramString, "html");
    AppMethodBeat.o(189368);
  }
  
  public void b(h paramh)
  {
    AppMethodBeat.i(189367);
    k.h(paramh, "performanceHelper");
    AppMethodBeat.o(189367);
  }
  
  public void b(String paramString, aoj paramaoj)
  {
    AppMethodBeat.i(189363);
    k.h(paramString, "reqUrl");
    k.h(paramaoj, "response");
    AppMethodBeat.o(189363);
  }
  
  public void bFs() {}
  
  public void bf(int paramInt, String paramString)
  {
    AppMethodBeat.i(189360);
    k.h(paramString, "reqUrl");
    AppMethodBeat.o(189360);
  }
  
  public void c(String paramString, aoj paramaoj)
  {
    AppMethodBeat.i(189364);
    k.h(paramString, "reqUrl");
    k.h(paramaoj, "response");
    AppMethodBeat.o(189364);
  }
  
  public void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(189365);
    k.h(paramString1, "reqUrl");
    k.h(paramString2, "errMsg");
    AppMethodBeat.o(189365);
  }
  
  public void dvS() {}
  
  public void ejA() {}
  
  public void ejB() {}
  
  public void ejC() {}
  
  public void ejD() {}
  
  public void ejz() {}
  
  public void onFinish() {}
  
  public void te(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.i
 * JD-Core Version:    0.7.0.1
 */