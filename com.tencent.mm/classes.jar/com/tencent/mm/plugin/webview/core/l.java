package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.k.r;
import com.tencent.mm.protocal.protobuf.cdf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class l
{
  public BaseWebViewController controller;
  
  public void Is(boolean paramBoolean) {}
  
  public void a(int paramInt, String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(295099);
    s.u(paramString, "reqUrl");
    s.u(paramcdf, "response");
    AppMethodBeat.o(295099);
  }
  
  public void a(r paramr)
  {
    AppMethodBeat.i(295109);
    s.u(paramr, "performanceHelper");
    AppMethodBeat.o(295109);
  }
  
  public void a(String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(295090);
    s.u(paramString, "reqUrl");
    s.u(paramcdf, "response");
    AppMethodBeat.o(295090);
  }
  
  public void atp(int paramInt) {}
  
  public void b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(295107);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "errMsg");
    AppMethodBeat.o(295107);
  }
  
  public void b(r paramr)
  {
    AppMethodBeat.i(295115);
    s.u(paramr, "performanceHelper");
    AppMethodBeat.o(295115);
  }
  
  public void b(String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(295096);
    s.u(paramString, "reqUrl");
    s.u(paramcdf, "response");
    AppMethodBeat.o(295096);
  }
  
  public void bjt(String paramString)
  {
    AppMethodBeat.i(295076);
    s.u(paramString, "reqUrl");
    AppMethodBeat.o(295076);
  }
  
  public void bju(String paramString)
  {
    AppMethodBeat.i(295134);
    s.u(paramString, "html");
    AppMethodBeat.o(295134);
  }
  
  public void cb(int paramInt, String paramString)
  {
    AppMethodBeat.i(295071);
    s.u(paramString, "reqUrl");
    AppMethodBeat.o(295071);
  }
  
  public void cxT() {}
  
  public void cxV() {}
  
  public void cxW() {}
  
  public void cxX() {}
  
  public void isG() {}
  
  public void isH() {}
  
  public void isI() {}
  
  public void onFinish() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.l
 * JD-Core Version:    0.7.0.1
 */