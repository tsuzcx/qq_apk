package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "", "()V", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "screenOrientation", "", "getScreenOrientation", "()I", "attach", "", "enableMinimize", "", "getA8KeyReason", "url", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "interceptLoadError", "errorCode", "description", "failingUrl", "overrideGetA8Key", "force", "reason", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "forceRedirect", "fullUrl", "shouldBeFinished", "OverrideUrlResult", "webview-sdk_release"})
public class j
{
  private final e DIN;
  private final i DIO;
  public BaseWebViewController controller;
  private final int screenOrientation = -1;
  
  public boolean XR(String paramString)
  {
    AppMethodBeat.i(214300);
    p.h(paramString, "url");
    AppMethodBeat.o(214300);
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(214295);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    AppMethodBeat.o(214295);
    return false;
  }
  
  public int aGg(String paramString)
  {
    AppMethodBeat.i(214303);
    p.h(paramString, "url");
    AppMethodBeat.o(214303);
    return -1;
  }
  
  public boolean aGv(String paramString)
  {
    AppMethodBeat.i(214296);
    p.h(paramString, "url");
    AppMethodBeat.o(214296);
    return false;
  }
  
  public boolean aGw(String paramString)
  {
    AppMethodBeat.i(214297);
    p.h(paramString, "url");
    AppMethodBeat.o(214297);
    return false;
  }
  
  public boolean aGx(String paramString)
  {
    AppMethodBeat.i(214298);
    p.h(paramString, "url");
    AppMethodBeat.o(214298);
    return true;
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(214301);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    AppMethodBeat.o(214301);
    return null;
  }
  
  public a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(214294);
    p.h(paramWebView, "webView");
    p.h(paramWebResourceRequest, "request");
    paramWebView = new a(false, false);
    AppMethodBeat.o(214294);
    return paramWebView;
  }
  
  public boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(214302);
    p.h(paramWebView, "webview");
    p.h(paramString1, "description");
    p.h(paramString2, "failingUrl");
    AppMethodBeat.o(214302);
    return false;
  }
  
  public boolean d(String paramString, avj paramavj)
  {
    AppMethodBeat.i(214299);
    p.h(paramString, "reqUrl");
    p.h(paramavj, "resp");
    AppMethodBeat.o(214299);
    return false;
  }
  
  public boolean eNO()
  {
    return false;
  }
  
  public e eNP()
  {
    return this.DIN;
  }
  
  public i eNQ()
  {
    return this.DIO;
  }
  
  public final BaseWebViewController getController()
  {
    AppMethodBeat.i(214291);
    BaseWebViewController localBaseWebViewController = this.controller;
    if (localBaseWebViewController == null) {
      p.bcb("controller");
    }
    AppMethodBeat.o(214291);
    return localBaseWebViewController;
  }
  
  public int getScreenOrientation()
  {
    return this.screenOrientation;
  }
  
  public final void k(BaseWebViewController paramBaseWebViewController)
  {
    AppMethodBeat.i(214292);
    p.h(paramBaseWebViewController, "controller");
    this.controller = paramBaseWebViewController;
    AppMethodBeat.o(214292);
  }
  
  public a m(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(214293);
    p.h(paramWebView, "webView");
    p.h(paramString, "url");
    paramWebView = new a(false, false);
    AppMethodBeat.o(214293);
    return paramWebView;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "", "override", "", "result", "(ZZ)V", "getOverride", "()Z", "getResult", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class a
  {
    final boolean DIP;
    final boolean result;
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.DIP = paramBoolean1;
      this.result = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.DIP != paramObject.DIP) || (this.result != paramObject.result)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214290);
      String str = "OverrideUrlResult(override=" + this.DIP + ", result=" + this.result + ")";
      AppMethodBeat.o(214290);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.j
 * JD-Core Version:    0.7.0.1
 */