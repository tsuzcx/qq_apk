package com.tencent.mm.plugin.webview.core;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "", "()V", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "screenOrientation", "", "getScreenOrientation", "()I", "attach", "", "enableMinimize", "", "getA8KeyReason", "url", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "interceptLoadError", "errorCode", "description", "failingUrl", "overrideGetA8Key", "force", "reason", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideRequestAuthCurrentUrl", "overrideStartLoad", "overrideStartLoadBefore", "intent", "Landroid/content/Intent;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "forceRedirect", "fullUrl", "shouldBeFinished", "OverrideUrlResult", "webview-sdk_release"})
public class k
{
  private final f IMY;
  private final j IMZ;
  public BaseWebViewController controller;
  private final int screenOrientation = -1;
  
  public boolean a(int paramInt, String paramString, bhj parambhj)
  {
    AppMethodBeat.i(225071);
    p.h(paramString, "reqUrl");
    p.h(parambhj, "resp");
    AppMethodBeat.o(225071);
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(225066);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    AppMethodBeat.o(225066);
    return false;
  }
  
  public int aXA(String paramString)
  {
    AppMethodBeat.i(225075);
    p.h(paramString, "url");
    AppMethodBeat.o(225075);
    return -1;
  }
  
  public boolean aXP(String paramString)
  {
    AppMethodBeat.i(225067);
    p.h(paramString, "url");
    AppMethodBeat.o(225067);
    return false;
  }
  
  public boolean aXQ(String paramString)
  {
    AppMethodBeat.i(225069);
    p.h(paramString, "url");
    AppMethodBeat.o(225069);
    return false;
  }
  
  public boolean aXR(String paramString)
  {
    AppMethodBeat.i(225070);
    p.h(paramString, "url");
    AppMethodBeat.o(225070);
    return true;
  }
  
  public boolean aiD(String paramString)
  {
    AppMethodBeat.i(225072);
    p.h(paramString, "url");
    AppMethodBeat.o(225072);
    return false;
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(225073);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    AppMethodBeat.o(225073);
    return null;
  }
  
  public a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(225065);
    p.h(paramWebView, "webView");
    p.h(paramWebResourceRequest, "request");
    paramWebView = new a(false, false);
    AppMethodBeat.o(225065);
    return paramWebView;
  }
  
  public boolean c(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(225074);
    p.h(paramWebView, "webview");
    p.h(paramString1, "description");
    p.h(paramString2, "failingUrl");
    AppMethodBeat.o(225074);
    return false;
  }
  
  public boolean e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(225068);
    p.h(paramString, "url");
    AppMethodBeat.o(225068);
    return false;
  }
  
  public boolean gag()
  {
    return false;
  }
  
  public boolean gah()
  {
    return false;
  }
  
  public f gai()
  {
    return this.IMY;
  }
  
  public j gaj()
  {
    return this.IMZ;
  }
  
  public final BaseWebViewController getController()
  {
    AppMethodBeat.i(225062);
    BaseWebViewController localBaseWebViewController = this.controller;
    if (localBaseWebViewController == null) {
      p.btv("controller");
    }
    AppMethodBeat.o(225062);
    return localBaseWebViewController;
  }
  
  public int getScreenOrientation()
  {
    return this.screenOrientation;
  }
  
  public final void k(BaseWebViewController paramBaseWebViewController)
  {
    AppMethodBeat.i(225063);
    p.h(paramBaseWebViewController, "controller");
    this.controller = paramBaseWebViewController;
    AppMethodBeat.o(225063);
  }
  
  public a o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(225064);
    p.h(paramWebView, "webView");
    p.h(paramString, "url");
    paramWebView = new a(false, false);
    AppMethodBeat.o(225064);
    return paramWebView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "", "override", "", "result", "(ZZ)V", "getOverride", "()Z", "getResult", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class a
  {
    final boolean INa;
    final boolean result;
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.INa = paramBoolean1;
      this.result = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.INa != paramObject.INa) || (this.result != paramObject.result)) {}
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
      AppMethodBeat.i(225061);
      String str = "OverrideUrlResult(override=" + this.INa + ", result=" + this.result + ")";
      AppMethodBeat.o(225061);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.k
 * JD-Core Version:    0.7.0.1
 */