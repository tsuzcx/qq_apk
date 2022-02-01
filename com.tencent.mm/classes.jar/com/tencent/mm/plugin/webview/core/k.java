package com.tencent.mm.plugin.webview.core;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "", "()V", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "screenOrientation", "", "getScreenOrientation", "()I", "attach", "", "enableMinimize", "", "getA8KeyReason", "url", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "interceptLoadError", "errorCode", "description", "failingUrl", "overrideGetA8Key", "force", "reason", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideRequestAuthCurrentUrl", "overrideStartLoad", "overrideStartLoadBefore", "intent", "Landroid/content/Intent;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "forceRedirect", "fullUrl", "shouldBeFinished", "OverrideUrlResult", "webview-sdk_release"})
public class k
{
  private final int PJe = -1;
  private final f PJf;
  public BaseWebViewController controller;
  private final j pHv;
  
  public boolean a(int paramInt, String paramString, bot parambot)
  {
    AppMethodBeat.i(205622);
    p.k(paramString, "reqUrl");
    p.k(parambot, "resp");
    AppMethodBeat.o(205622);
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(205617);
    p.k(paramString1, "reqUrl");
    p.k(paramString2, "fullUrl");
    AppMethodBeat.o(205617);
    return false;
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(205625);
    p.k(paramWebView, "webview");
    p.k(paramString1, "description");
    p.k(paramString2, "failingUrl");
    AppMethodBeat.o(205625);
    return false;
  }
  
  public boolean aqs(String paramString)
  {
    AppMethodBeat.i(205623);
    p.k(paramString, "url");
    AppMethodBeat.o(205623);
    return false;
  }
  
  public WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(205624);
    p.k(paramWebView, "webview");
    p.k(paramWebResourceRequest, "request");
    AppMethodBeat.o(205624);
    return null;
  }
  
  public j bXJ()
  {
    return this.pHv;
  }
  
  public boolean bjJ(String paramString)
  {
    AppMethodBeat.i(205620);
    p.k(paramString, "url");
    AppMethodBeat.o(205620);
    return false;
  }
  
  public boolean bjK(String paramString)
  {
    AppMethodBeat.i(205621);
    p.k(paramString, "url");
    AppMethodBeat.o(205621);
    return true;
  }
  
  public int bjr(String paramString)
  {
    AppMethodBeat.i(205626);
    p.k(paramString, "url");
    AppMethodBeat.o(205626);
    return -1;
  }
  
  public a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(205616);
    p.k(paramWebView, "webView");
    p.k(paramWebResourceRequest, "request");
    paramWebView = new a(false, false);
    AppMethodBeat.o(205616);
    return paramWebView;
  }
  
  public boolean e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(205619);
    p.k(paramString, "url");
    AppMethodBeat.o(205619);
    return false;
  }
  
  public boolean g(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(205618);
    p.k(paramString, "url");
    AppMethodBeat.o(205618);
    return false;
  }
  
  public boolean gSZ()
  {
    return false;
  }
  
  public boolean gTa()
  {
    return false;
  }
  
  public f gTb()
  {
    return this.PJf;
  }
  
  public final BaseWebViewController getController()
  {
    AppMethodBeat.i(205613);
    BaseWebViewController localBaseWebViewController = this.controller;
    if (localBaseWebViewController == null) {
      p.bGy("controller");
    }
    AppMethodBeat.o(205613);
    return localBaseWebViewController;
  }
  
  public int getScreenOrientation()
  {
    return this.PJe;
  }
  
  public final void k(BaseWebViewController paramBaseWebViewController)
  {
    AppMethodBeat.i(205614);
    p.k(paramBaseWebViewController, "controller");
    this.controller = paramBaseWebViewController;
    AppMethodBeat.o(205614);
  }
  
  public a o(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(205615);
    p.k(paramWebView, "webView");
    p.k(paramString, "url");
    paramWebView = new a(false, false);
    AppMethodBeat.o(205615);
    return paramWebView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "", "override", "", "result", "(ZZ)V", "getOverride", "()Z", "getResult", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class a
  {
    final boolean PJg;
    final boolean result;
    
    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.PJg = paramBoolean1;
      this.result = paramBoolean2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.PJg != paramObject.PJg) || (this.result != paramObject.result)) {}
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
      AppMethodBeat.i(205386);
      String str = "OverrideUrlResult(override=" + this.PJg + ", result=" + this.result + ")";
      AppMethodBeat.o(205386);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.k
 * JD-Core Version:    0.7.0.1
 */