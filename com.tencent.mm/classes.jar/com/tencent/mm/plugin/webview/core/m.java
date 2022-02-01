package com.tencent.mm.plugin.webview.core;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "", "()V", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "screenOrientation", "", "getScreenOrientation", "()I", "attach", "", "enableMinimize", "", "getA8KeyReason", "url", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "interceptLoadError", "errorCode", "description", "failingUrl", "onAttachController", "onTeenModeStatusChange", "overrideGetA8Key", "force", "reason", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideRequestAuthCurrentUrl", "overrideStartLoad", "overrideStartLoadBefore", "intent", "Landroid/content/Intent;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "forceRedirect", "fullUrl", "restoreController", "shouldBeFinished", "OverrideUrlResult", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class m
{
  private final int Wzx = -1;
  private final h Wzy;
  public BaseWebViewController controller;
  private final l sMB;
  
  public boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(295088);
    s.u(paramString1, "reqUrl");
    s.u(paramString2, "fullUrl");
    AppMethodBeat.o(295088);
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(295139);
    s.u(paramWebView, "webview");
    s.u(paramString1, "description");
    s.u(paramString2, "failingUrl");
    AppMethodBeat.o(295139);
    return false;
  }
  
  public boolean ajR(String paramString)
  {
    AppMethodBeat.i(295127);
    s.u(paramString, "url");
    AppMethodBeat.o(295127);
    return false;
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(295133);
    s.u(paramWebView, "webview");
    s.u(paramWebResourceRequest, "request");
    AppMethodBeat.o(295133);
    return null;
  }
  
  public boolean b(int paramInt, String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(295119);
    s.u(paramString, "reqUrl");
    s.u(paramcdf, "resp");
    AppMethodBeat.o(295119);
    return false;
  }
  
  public int bjc(String paramString)
  {
    AppMethodBeat.i(295145);
    s.u(paramString, "url");
    AppMethodBeat.o(295145);
    return -1;
  }
  
  public boolean bjv(String paramString)
  {
    AppMethodBeat.i(295114);
    s.u(paramString, "url");
    AppMethodBeat.o(295114);
    return false;
  }
  
  public boolean bjw(String paramString)
  {
    AppMethodBeat.i(295116);
    s.u(paramString, "url");
    AppMethodBeat.o(295116);
    return true;
  }
  
  public a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(295083);
    s.u(paramWebView, "webView");
    s.u(paramWebResourceRequest, "request");
    paramWebView = new a(false, false);
    AppMethodBeat.o(295083);
    return paramWebView;
  }
  
  public l cxU()
  {
    return this.sMB;
  }
  
  public boolean f(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(295098);
    s.u(paramString, "url");
    AppMethodBeat.o(295098);
    return false;
  }
  
  public boolean f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(295092);
    s.u(paramString, "url");
    AppMethodBeat.o(295092);
    return false;
  }
  
  public final BaseWebViewController getController()
  {
    AppMethodBeat.i(295072);
    BaseWebViewController localBaseWebViewController = this.controller;
    if (localBaseWebViewController != null)
    {
      AppMethodBeat.o(295072);
      return localBaseWebViewController;
    }
    s.bIx("controller");
    AppMethodBeat.o(295072);
    return null;
  }
  
  public int getScreenOrientation()
  {
    return this.Wzx;
  }
  
  public boolean isJ()
  {
    return false;
  }
  
  public boolean isK()
  {
    return false;
  }
  
  public boolean isL()
  {
    return false;
  }
  
  public boolean isM()
  {
    return false;
  }
  
  public h isN()
  {
    return this.Wzy;
  }
  
  public a j(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(295078);
    s.u(paramWebView, "webView");
    s.u(paramString, "url");
    paramWebView = new a(false, false);
    AppMethodBeat.o(295078);
    return paramWebView;
  }
  
  public final void k(BaseWebViewController paramBaseWebViewController)
  {
    AppMethodBeat.i(295074);
    s.u(paramBaseWebViewController, "controller");
    s.u(paramBaseWebViewController, "<set-?>");
    this.controller = paramBaseWebViewController;
    AppMethodBeat.o(295074);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "", "override", "", "result", "(ZZ)V", "getOverride", "()Z", "getResult", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final boolean Wzz;
    final boolean result;
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.Wzz = paramBoolean1;
      this.result = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.Wzz != paramObject.Wzz) {
          return false;
        }
      } while (this.result == paramObject.result);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(294873);
      String str = "OverrideUrlResult(override=" + this.Wzz + ", result=" + this.result + ')';
      AppMethodBeat.o(294873);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.m
 * JD-Core Version:    0.7.0.1
 */