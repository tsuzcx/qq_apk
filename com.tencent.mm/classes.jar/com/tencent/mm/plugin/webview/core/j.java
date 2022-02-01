package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.k.n;
import com.tencent.mm.protocal.protobuf.bot;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"})
public class j
{
  public BaseWebViewController controller;
  
  public void CN(boolean paramBoolean) {}
  
  public void a(n paramn)
  {
    AppMethodBeat.i(206415);
    p.k(paramn, "performanceHelper");
    AppMethodBeat.o(206415);
  }
  
  public void a(String paramString, bot parambot)
  {
    AppMethodBeat.i(206413);
    p.k(paramString, "reqUrl");
    p.k(parambot, "response");
    AppMethodBeat.o(206413);
  }
  
  public void anz(int paramInt) {}
  
  public void b(n paramn)
  {
    AppMethodBeat.i(206416);
    p.k(paramn, "performanceHelper");
    AppMethodBeat.o(206416);
  }
  
  public void b(String paramString, bot parambot)
  {
    AppMethodBeat.i(206411);
    p.k(paramString, "reqUrl");
    p.k(parambot, "response");
    AppMethodBeat.o(206411);
  }
  
  public void bXI() {}
  
  public void bXK() {}
  
  public void bXL() {}
  
  public void bXM() {}
  
  public void bjH(String paramString)
  {
    AppMethodBeat.i(206409);
    p.k(paramString, "reqUrl");
    AppMethodBeat.o(206409);
  }
  
  public void bjI(String paramString)
  {
    AppMethodBeat.i(206418);
    p.k(paramString, "html");
    AppMethodBeat.o(206418);
  }
  
  public void bv(int paramInt, String paramString)
  {
    AppMethodBeat.i(206407);
    p.k(paramString, "reqUrl");
    AppMethodBeat.o(206407);
  }
  
  public void c(String paramString, bot parambot)
  {
    AppMethodBeat.i(206412);
    p.k(paramString, "reqUrl");
    p.k(parambot, "response");
    AppMethodBeat.o(206412);
  }
  
  public void d(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(206414);
    p.k(paramString1, "reqUrl");
    p.k(paramString2, "errMsg");
    AppMethodBeat.o(206414);
  }
  
  public void gSW() {}
  
  public void gSX() {}
  
  public void gSY() {}
  
  public void onFinish() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.j
 * JD-Core Version:    0.7.0.1
 */