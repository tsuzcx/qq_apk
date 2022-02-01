package com.tencent.mm.plugin.webview.g;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.a.e.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.i.b;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "isPageCached", "", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "rawUrl", "getRawUrl", "()Ljava/lang/String;", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "getA8KeyReason", "", "url", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrlRedirect", "forceRedirect", "fullUrl", "webview-sdk_release"})
public final class a
  extends k
{
  private final com.tencent.mm.plugin.webview.core.f IMY;
  private final com.tencent.mm.plugin.webview.core.j IMZ;
  e.b Jcs;
  boolean Jct;
  boolean Jcu;
  boolean Jcv;
  private final kotlin.f Jcw;
  private final long Jcx;
  boolean Jcy;
  final String TAG;
  
  public a()
  {
    AppMethodBeat.i(225157);
    this.TAG = "MicroMsg.WebPrefetcherInterceptor";
    this.Jcw = g.ah((kotlin.g.a.a)a.Jcz);
    this.Jcx = 500L;
    this.IMY = ((com.tencent.mm.plugin.webview.core.f)new b(this));
    this.IMZ = ((com.tencent.mm.plugin.webview.core.j)new c(this));
    AppMethodBeat.o(225157);
  }
  
  private final boolean aZL(String paramString)
  {
    AppMethodBeat.i(225149);
    e locale = gdJ();
    if ((locale != null) && (locale.fd(getController().coX(), paramString) == true))
    {
      locale = gdJ();
      if ((locale != null) && (locale.ahB(paramString) == true))
      {
        AppMethodBeat.o(225149);
        return true;
      }
    }
    AppMethodBeat.o(225149);
    return false;
  }
  
  public final boolean a(int paramInt, String paramString, bhj parambhj)
  {
    long l2 = 0L;
    AppMethodBeat.i(225155);
    p.h(paramString, "reqUrl");
    p.h(parambhj, "resp");
    if (parambhj.KCD == 38)
    {
      if (aZL(paramString))
      {
        parambhj = parambhj.LRS;
        if (parambhj == null) {
          break label204;
        }
        parambhj = z.a(parambhj);
      }
      for (;;)
      {
        try
        {
          bhk localbhk = new bhk();
          localbhk.parseFrom(parambhj);
          parambhj = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("overrideProcessResultL, prefetchVersion: ");
          e.b localb = this.Jcs;
          if (localb == null) {
            continue;
          }
          l1 = localb.pmO;
          Log.i(parambhj, l1 + ", verifyInfo.Version: " + localbhk.LRV);
          parambhj = this.Jcs;
          l1 = l2;
          if (parambhj != null) {
            l1 = parambhj.pmO;
          }
          if (l1 < localbhk.LRV)
          {
            parambhj = gdJ();
            if (parambhj != null) {
              parambhj.ahG(paramString);
            }
            getController().pGj.loadUrl(localbhk.LRU);
            getController().IKf = true;
          }
        }
        catch (IOException paramString)
        {
          long l1;
          label204:
          Log.printErrStackTrace(this.TAG, (Throwable)paramString, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
          continue;
        }
        AppMethodBeat.o(225155);
        return true;
        parambhj = null;
        continue;
        l1 = 0L;
      }
    }
    AppMethodBeat.o(225155);
    return false;
  }
  
  public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(225153);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    if ((!paramBoolean) && (paramInt == 10))
    {
      AppMethodBeat.o(225153);
      return true;
    }
    AppMethodBeat.o(225153);
    return false;
  }
  
  public final int aXA(String paramString)
  {
    AppMethodBeat.i(225154);
    p.h(paramString, "url");
    if (!aZL(paramString))
    {
      localObject = this.Jcs;
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (Object localObject = ((e.b)localObject).url; p.j(paramString, localObject); localObject = null)
    {
      AppMethodBeat.o(225154);
      return 10;
    }
    int i = super.aXA(paramString);
    AppMethodBeat.o(225154);
    return i;
  }
  
  public final boolean aXQ(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(225151);
    p.h(paramString, "url");
    if (!aZL(paramString))
    {
      Log.i(this.TAG, "not match ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(225151);
      return false;
    }
    Object localObject1 = gdJ();
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).ahF(paramString);
      if (localObject1 == null) {
        break label459;
      }
      Log.i(this.TAG, "url has been cached:%s", new Object[] { ((e.b)localObject1).url });
      Log.i(this.TAG, "url has been cached, bizScene:" + ((e.b)localObject1).hDa + ", subBizScene:" + ((e.b)localObject1).pmN + " ,url:" + ((e.b)localObject1).url);
      this.Jcs = ((e.b)localObject1);
      h.CyF.a(21075, new Object[] { Integer.valueOf(((e.b)localObject1).hDa), paramString, ((e.b)localObject1).url, Integer.valueOf(4), Integer.valueOf(((e.b)localObject1).hDa) });
      localObject2 = getController();
      String str = ((e.b)localObject1).url;
      p.g(str, "resp.url");
      WebResourceResponse localWebResourceResponse = ((e.b)localObject1).pmQ;
      p.g(localWebResourceResponse, "resp.response");
      ((BaseWebViewController)localObject2).L(str, localWebResourceResponse.getResponseHeaders());
      localObject2 = getController();
      str = ((e.b)localObject1).url;
      p.g(str, "resp.url");
      BaseWebViewController.a((BaseWebViewController)localObject2, str, false, 10, 2);
      this.Jct = true;
      getController().IKa.Jct = this.Jct;
      localObject2 = getController().IKa.JBO;
      localObject1 = ((e.b)localObject1).pmQ;
      p.g(localObject1, "resp.response");
      ((HashMap)localObject2).putAll(((WebResourceResponse)localObject1).getResponseHeaders());
      b.gdN();
      localObject1 = gdJ();
      if (localObject1 == null) {
        break label454;
      }
      i = ((e)localObject1).ahE(getController().coX());
      label378:
      b.agq(i);
    }
    for (;;)
    {
      this.Jcu = true;
      getController().IKa.Jcu = this.Jcu;
      localObject1 = gdJ();
      if (localObject1 != null) {
        bool = ((e)localObject1).ahD(paramString);
      }
      this.Jcv = bool;
      getController().IKa.Jcv = this.Jcv;
      AppMethodBeat.o(225151);
      return true;
      localObject1 = null;
      break;
      label454:
      i = 0;
      break label378;
      label459:
      Log.i(this.TAG, "async geta8key:".concat(String.valueOf(paramString)));
      localObject2 = gdJ().ahC(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramString;
      }
      Log.i(this.TAG, "async geta8key respUrl:".concat(String.valueOf(localObject1)));
      localObject2 = localObject1;
      if (!c.A((String)localObject1, "http")) {
        localObject2 = "http://".concat(String.valueOf(paramString));
      }
      h.CyF.a(21075, new Object[] { Integer.valueOf(0), paramString, localObject2, Integer.valueOf(5) });
      getController().pGj.loadUrl((String)localObject2);
      BaseWebViewController.a(getController(), (String)localObject2, false, 10, 2);
    }
  }
  
  public final boolean aXR(String paramString)
  {
    AppMethodBeat.i(225152);
    p.h(paramString, "url");
    if (!aZL(paramString))
    {
      AppMethodBeat.o(225152);
      return true;
    }
    AppMethodBeat.o(225152);
    return false;
  }
  
  public final boolean aiD(String paramString)
  {
    AppMethodBeat.i(225150);
    p.h(paramString, "url");
    Object localObject = this.Jcs;
    if (localObject != null) {}
    for (localObject = ((e.b)localObject).url; (p.j(paramString, localObject)) && (getController().fZF()); localObject = null)
    {
      this.Jcs = null;
      localObject = getController();
      p.h(paramString, "url");
      Log.i(((BaseWebViewController)localObject).fZo(), "reload for:".concat(String.valueOf(paramString)));
      ((BaseWebViewController)localObject).pGj.loadUrl(paramString);
      ((BaseWebViewController)localObject).IKf = true;
      AppMethodBeat.o(225150);
      return true;
    }
    AppMethodBeat.o(225150);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(225156);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    String str1;
    if (this.Jcs != null)
    {
      str1 = paramWebResourceRequest.getUrl().toString();
      p.g(str1, "request.url.toString()");
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.Jcs;
        if (paramWebView != null) {
          paramWebView = paramWebView.url;
        }
        while (p.j(str1, paramWebView))
        {
          paramWebView = this.Jcs;
          if (paramWebView != null)
          {
            paramWebView = paramWebView.pmQ;
            if (paramWebView != null)
            {
              Log.v(this.TAG, "intercepted: " + str1 + ", " + paramWebView.getMimeType());
              AppMethodBeat.o(225156);
              return paramWebView;
              paramWebView = null;
              continue;
            }
          }
          AppMethodBeat.o(225156);
          return null;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramWebView = getController().getCurrentUrl();
        if (paramWebView == null) {
          break label427;
        }
        paramWebView = Uri.parse(paramWebView);
        p.g(paramWebView, "Uri.parse(url)");
        String str2 = paramWebView.getHost();
        if (str2 == null) {
          break label427;
        }
        e locale = gdJ();
        if (locale == null) {
          break label440;
        }
        paramWebView = this.Jcs;
        if (paramWebView == null) {
          break label435;
        }
        paramWebView = paramWebView.appId;
        paramWebView = locale.R(str2, str1, paramWebView);
        if (paramWebView == null) {
          break label427;
        }
        str1 = paramWebView.pmP;
        if (str1 == null)
        {
          if (paramWebView == null) {
            break label427;
          }
          paramWebView = paramWebView.pmQ;
          AppMethodBeat.o(225156);
          return paramWebView;
        }
        switch (str1.hashCode())
        {
        case 2377: 
          if (!str1.equals("JS")) {
            continue;
          }
          getController().IKa.JBM.add(paramWebResourceRequest.getUrl().toString());
          b.gdO();
          b.agq(gdJ().ahE(getController().coX()));
          continue;
          AppMethodBeat.o(225156);
        }
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramWebView, "interceptRequest getCurrentUrl host", new Object[0]);
      }
      return null;
      if (str1.equals("CSS"))
      {
        getController().IKa.JBN.add(paramWebResourceRequest.getUrl().toString());
        b.gdP();
        b.agq(gdJ().ahE(getController().coX()));
        continue;
        label427:
        AppMethodBeat.o(225156);
        return null;
        label435:
        paramWebView = null;
        continue;
        label440:
        paramWebView = null;
      }
    }
  }
  
  public final com.tencent.mm.plugin.webview.core.f gai()
  {
    return this.IMY;
  }
  
  public final com.tencent.mm.plugin.webview.core.j gaj()
  {
    return this.IMZ;
  }
  
  final e gdJ()
  {
    AppMethodBeat.i(225148);
    e locale = (e)this.Jcw.getValue();
    AppMethodBeat.o(225148);
    return locale;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<e>
  {
    public static final a Jcz;
    
    static
    {
      AppMethodBeat.i(225143);
      Jcz = new a();
      AppMethodBeat.o(225143);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "writePrefetchInfo", "webview-sdk_release"})
  public static final class b
    extends com.tencent.mm.plugin.webview.core.f
  {
    public final void e(WebView paramWebView, String paramString)
    {
      Integer localInteger = null;
      AppMethodBeat.i(225145);
      Log.i(this.JcA.TAG, "onPageCommitVisible, url = %s", new Object[] { paramString });
      h localh;
      if (!this.JcA.Jcy)
      {
        this.JcA.getController().pGj.evaluateJavascript(n.buv("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + this.JcA.getController().IKa.JBP + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + this.JcA.Jcu + ",\n                    prefetch:" + this.JcA.Jct + ",\n                    predns:" + this.JcA.Jcv + "\n                })\n                return p.wx.info;\n            })(window.performance);"), (ValueCallback)new a(this));
        this.JcA.Jcy = true;
        if (this.JcA.Jcs != null)
        {
          localh = h.CyF;
          paramWebView = this.JcA.Jcs;
          if (paramWebView == null) {
            break label282;
          }
        }
      }
      label282:
      for (paramWebView = Integer.valueOf(paramWebView.hDa);; paramWebView = null)
      {
        Object localObject1 = this.JcA.Jcs;
        if (localObject1 != null)
        {
          localObject2 = ((e.b)localObject1).url;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        Object localObject2 = this.JcA.Jcs;
        if (localObject2 != null) {
          localInteger = Integer.valueOf(((e.b)localObject2).hDa);
        }
        localh.a(21075, new Object[] { paramWebView, paramString, localObject1, Integer.valueOf(6), localInteger });
        AppMethodBeat.o(225145);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(a.b paramb) {}
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "webview-sdk_release"})
  public static final class c
    extends com.tencent.mm.plugin.webview.core.j
  {
    public final void a(com.tencent.mm.plugin.webview.k.j paramj)
    {
      AppMethodBeat.i(225146);
      p.h(paramj, "performanceHelper");
      Object localObject = this.JcA;
      String str = ((a)localObject).getController().IJM;
      localObject = ((a)localObject).Jcs;
      if (localObject != null) {}
      for (localObject = ((e.b)localObject).url;; localObject = null)
      {
        paramj.Jct = p.j(str, localObject);
        AppMethodBeat.o(225146);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.webview.k.j paramj)
    {
      AppMethodBeat.i(225147);
      p.h(paramj, "performanceHelper");
      e locale = this.JcA.gdJ();
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        p.btv("controller");
      }
      b.a(paramj, locale.ahE(localBaseWebViewController.coX()));
      AppMethodBeat.o(225147);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.a
 * JD-Core Version:    0.7.0.1
 */