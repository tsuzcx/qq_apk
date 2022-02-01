package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "", "()V", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "screenOrientation", "", "getScreenOrientation", "()I", "attach", "", "enableMinimize", "", "getA8KeyReason", "url", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "interceptLoadError", "errorCode", "description", "failingUrl", "overrideGetA8Key", "force", "reason", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "fullUrl", "shouldBeFinished", "OverrideUrlResult", "webview-sdk_release"})
public class j
{
  private final e CfJ;
  private final i CfK;
  public BaseWebViewController controller;
  private final int screenOrientation = -1;
  
  public boolean Ui(String paramString)
  {
    AppMethodBeat.i(205511);
    k.h(paramString, "url");
    AppMethodBeat.o(205511);
    return false;
  }
  
  public int aAM(String paramString)
  {
    AppMethodBeat.i(205514);
    k.h(paramString, "url");
    AppMethodBeat.o(205514);
    return -1;
  }
  
  public boolean aBa(String paramString)
  {
    AppMethodBeat.i(205507);
    k.h(paramString, "url");
    AppMethodBeat.o(205507);
    return false;
  }
  
  public boolean aBb(String paramString)
  {
    AppMethodBeat.i(205508);
    k.h(paramString, "url");
    AppMethodBeat.o(205508);
    return false;
  }
  
  public boolean aBc(String paramString)
  {
    AppMethodBeat.i(205509);
    k.h(paramString, "url");
    AppMethodBeat.o(205509);
    return true;
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(205512);
    k.h(paramWebView, "webview");
    k.h(paramWebResourceRequest, "request");
    AppMethodBeat.o(205512);
    return null;
  }
  
  public a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(205505);
    k.h(paramWebView, "webView");
    k.h(paramWebResourceRequest, "request");
    paramWebView = new a(false, false);
    AppMethodBeat.o(205505);
    return paramWebView;
  }
  
  public boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(205513);
    k.h(paramWebView, "webview");
    k.h(paramString1, "description");
    k.h(paramString2, "failingUrl");
    AppMethodBeat.o(205513);
    return false;
  }
  
  public boolean d(String paramString, arn paramarn)
  {
    AppMethodBeat.i(205510);
    k.h(paramString, "reqUrl");
    k.h(paramarn, "resp");
    AppMethodBeat.o(205510);
    return false;
  }
  
  public boolean eyZ()
  {
    return false;
  }
  
  public e eza()
  {
    return this.CfJ;
  }
  
  public i ezb()
  {
    return this.CfK;
  }
  
  public final BaseWebViewController getController()
  {
    AppMethodBeat.i(205502);
    BaseWebViewController localBaseWebViewController = this.controller;
    if (localBaseWebViewController == null) {
      k.aVY("controller");
    }
    AppMethodBeat.o(205502);
    return localBaseWebViewController;
  }
  
  public int getScreenOrientation()
  {
    return this.screenOrientation;
  }
  
  public final void k(BaseWebViewController paramBaseWebViewController)
  {
    AppMethodBeat.i(205503);
    k.h(paramBaseWebViewController, "controller");
    this.controller = paramBaseWebViewController;
    AppMethodBeat.o(205503);
  }
  
  public a n(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(205504);
    k.h(paramWebView, "webView");
    k.h(paramString, "url");
    paramWebView = new a(false, false);
    AppMethodBeat.o(205504);
    return paramWebView;
  }
  
  public boolean u(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(205506);
    k.h(paramString1, "reqUrl");
    k.h(paramString2, "fullUrl");
    AppMethodBeat.o(205506);
    return false;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "", "override", "", "result", "(ZZ)V", "getOverride", "()Z", "getResult", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class a
  {
    final boolean CfL;
    final boolean result;
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.CfL = paramBoolean1;
      this.result = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.CfL != paramObject.CfL) || (this.result != paramObject.result)) {}
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
      AppMethodBeat.i(205501);
      String str = "OverrideUrlResult(override=" + this.CfL + ", result=" + this.result + ")";
      AppMethodBeat.o(205501);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.j
 * JD-Core Version:    0.7.0.1
 */