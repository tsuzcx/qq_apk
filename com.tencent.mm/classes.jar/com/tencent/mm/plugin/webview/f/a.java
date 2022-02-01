package com.tencent.mm.plugin.webview.f;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.e;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.h.b;
import com.tencent.mm.plugin.webview.j.h;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.f;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.n.n;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "isPageCached", "", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "rawUrl", "getRawUrl", "()Ljava/lang/String;", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "getA8KeyReason", "", "url", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrlRedirect", "fullUrl", "webview-sdk_release"})
public final class a
  extends j
{
  private final e ANr;
  private final i ANs;
  private d.b Bbr;
  private boolean Bbs;
  private boolean Bbt;
  private boolean Bbu;
  private final f Bbv;
  private final long Bbw;
  private boolean Bbx;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(189432);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "WebPrefetcher", "getWebPrefetcher()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;")) };
    AppMethodBeat.o(189432);
  }
  
  public a()
  {
    AppMethodBeat.i(189442);
    this.TAG = "MicroMsg.WebPrefetcherInterceptor";
    this.Bbv = g.E((d.g.a.a)a.Bby);
    this.Bbw = 500L;
    this.ANr = ((e)new b(this));
    this.ANs = ((i)new c(this));
    AppMethodBeat.o(189442);
  }
  
  private final boolean axr(String paramString)
  {
    AppMethodBeat.i(189434);
    d locald = emT();
    if ((locald != null) && (locald.en(getController().bEx(), paramString) == true))
    {
      locald = emT();
      if ((locald != null) && (locald.Pc(paramString) == true))
      {
        AppMethodBeat.o(189434);
        return true;
      }
    }
    AppMethodBeat.o(189434);
    return false;
  }
  
  private final d emT()
  {
    AppMethodBeat.i(189433);
    d locald = (d)this.Bbv.getValue();
    AppMethodBeat.o(189433);
    return locald;
  }
  
  public final boolean PW(String paramString)
  {
    AppMethodBeat.i(189435);
    d.g.b.k.h(paramString, "url");
    Object localObject = this.Bbr;
    if (localObject != null) {}
    for (localObject = ((d.b)localObject).url; (d.g.b.k.g(paramString, localObject)) && (getController().ejh()); localObject = null)
    {
      this.Bbr = null;
      localObject = getController();
      d.g.b.k.h(paramString, "url");
      ad.i(((BaseWebViewController)localObject).eiT(), "reload for:".concat(String.valueOf(paramString)));
      ((BaseWebViewController)localObject).nhy.loadUrl(paramString);
      ((BaseWebViewController)localObject).ALa = true;
      AppMethodBeat.o(189435);
      return true;
    }
    AppMethodBeat.o(189435);
    return false;
  }
  
  public final boolean avJ(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(189436);
    d.g.b.k.h(paramString, "url");
    if (!axr(paramString))
    {
      ad.i(this.TAG, "not match ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(189436);
      return false;
    }
    Object localObject1 = emT().Pf(paramString);
    if (localObject1 != null)
    {
      ad.i(this.TAG, "url has been cached:%s", new Object[] { ((d.b)localObject1).url });
      this.Bbr = ((d.b)localObject1);
      Object localObject2 = getController();
      String str = ((d.b)localObject1).url;
      d.g.b.k.g(str, "resp.url");
      WebResourceResponse localWebResourceResponse = ((d.b)localObject1).mSx;
      d.g.b.k.g(localWebResourceResponse, "resp.response");
      ((BaseWebViewController)localObject2).D(str, localWebResourceResponse.getResponseHeaders());
      localObject2 = getController();
      str = ((d.b)localObject1).url;
      d.g.b.k.g(str, "resp.url");
      BaseWebViewController.a((BaseWebViewController)localObject2, str, false, 0, 6);
      getController().AKU.finish();
      getController().AKU.uY(this.Bbw);
      this.Bbs = true;
      getController().AKV.Bbs = this.Bbs;
      localObject2 = getController().AKV.Bxr;
      localObject1 = ((d.b)localObject1).mSx;
      d.g.b.k.g(localObject1, "resp.response");
      ((HashMap)localObject2).putAll(((WebResourceResponse)localObject1).getResponseHeaders());
      b.emX();
      b.Te(emT().Pe(getController().bEx()));
    }
    for (;;)
    {
      this.Bbt = true;
      getController().AKV.Bbt = this.Bbt;
      localObject1 = emT();
      if (localObject1 != null) {
        bool = ((d)localObject1).Pd(paramString);
      }
      this.Bbu = bool;
      getController().AKV.Bbu = this.Bbu;
      AppMethodBeat.o(189436);
      return true;
      ad.i(this.TAG, "async geta8key:".concat(String.valueOf(paramString)));
      getController().nhy.loadUrl(paramString);
      BaseWebViewController.a(getController(), paramString, false, 0, 6);
    }
  }
  
  public final boolean avK(String paramString)
  {
    AppMethodBeat.i(189437);
    d.g.b.k.h(paramString, "url");
    if (!axr(paramString))
    {
      AppMethodBeat.o(189437);
      return true;
    }
    AppMethodBeat.o(189437);
    return false;
  }
  
  public final int avu(String paramString)
  {
    AppMethodBeat.i(189439);
    d.g.b.k.h(paramString, "url");
    if (axr(paramString))
    {
      AppMethodBeat.o(189439);
      return 10;
    }
    int i = super.avu(paramString);
    AppMethodBeat.o(189439);
    return i;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(189441);
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    String str;
    if (this.Bbr != null)
    {
      str = paramWebResourceRequest.getUrl().toString();
      d.g.b.k.g(str, "request.url.toString()");
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.Bbr;
        if (paramWebView != null) {
          paramWebView = paramWebView.url;
        }
        while (d.g.b.k.g(str, paramWebView))
        {
          paramWebView = this.Bbr;
          if (paramWebView != null)
          {
            paramWebView = paramWebView.mSx;
            if (paramWebView != null)
            {
              ad.v(this.TAG, "intercepted: " + str + ", " + paramWebView.getMimeType());
              AppMethodBeat.o(189441);
              return paramWebView;
              paramWebView = null;
              continue;
            }
          }
          AppMethodBeat.o(189441);
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
          break label399;
        }
        paramWebView = Uri.parse(paramWebView);
        d.g.b.k.g(paramWebView, "Uri.parse(url)");
        paramWebView = paramWebView.getHost();
        if (paramWebView == null) {
          break label399;
        }
        paramWebView = emT().eo(paramWebView, str);
        if (paramWebView == null) {
          break label399;
        }
        str = paramWebView.mSw;
        if (str == null)
        {
          if (paramWebView == null) {
            break label399;
          }
          paramWebView = paramWebView.mSx;
          AppMethodBeat.o(189441);
          return paramWebView;
        }
        switch (str.hashCode())
        {
        case 2377: 
          if (!str.equals("JS")) {
            continue;
          }
          getController().AKV.Bxp.add(paramWebResourceRequest.getUrl().toString());
          b.emY();
          b.Te(emT().Pe(getController().bEx()));
          continue;
          AppMethodBeat.o(189441);
        }
      }
      catch (Exception paramWebView)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramWebView, "interceptRequest getCurrentUrl host", new Object[0]);
      }
      return null;
      if (str.equals("CSS"))
      {
        getController().AKV.Bxq.add(paramWebResourceRequest.getUrl().toString());
        b.emZ();
        b.Te(emT().Pe(getController().bEx()));
        continue;
        label399:
        AppMethodBeat.o(189441);
        return null;
      }
    }
  }
  
  public final boolean d(String paramString, aoj paramaoj)
  {
    AppMethodBeat.i(189440);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramaoj, "resp");
    if (paramaoj.Ctr == 38)
    {
      if (axr(paramString))
      {
        paramaoj = paramaoj.Dqi;
        if (paramaoj == null) {
          break label132;
        }
        paramaoj = z.a(paramaoj);
      }
      for (;;)
      {
        try
        {
          aok localaok = new aok();
          localaok.parseFrom(paramaoj);
          paramaoj = this.Bbr;
          if (paramaoj == null) {
            continue;
          }
          l = paramaoj.mSv;
          if (l < localaok.Dql)
          {
            emT().Pg(paramString);
            getController().nhy.loadUrl(localaok.Dqk);
            getController().ALa = true;
          }
        }
        catch (IOException paramString)
        {
          long l;
          label132:
          ad.printErrStackTrace(this.TAG, (Throwable)paramString, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
          continue;
        }
        AppMethodBeat.o(189440);
        return true;
        paramaoj = null;
        continue;
        l = 0L;
      }
    }
    AppMethodBeat.o(189440);
    return false;
  }
  
  public final e ejF()
  {
    return this.ANr;
  }
  
  public final i ejG()
  {
    return this.ANs;
  }
  
  public final boolean u(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189438);
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "fullUrl");
    if ((emT().en(paramString1, paramString2)) && (emT().en(getController().bEx(), paramString1)) && (axr(getController().bEx())))
    {
      AppMethodBeat.o(189438);
      return true;
    }
    AppMethodBeat.o(189438);
    return false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<d>
  {
    public static final a Bby;
    
    static
    {
      AppMethodBeat.i(189427);
      Bby = new a();
      AppMethodBeat.o(189427);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "writePrefetchInfo", "webview-sdk_release"})
  public static final class b
    extends e
  {
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(189429);
      ad.i(a.a(this.Bbz), "onPageCommitVisible, url = %s", new Object[] { paramString });
      if (!a.b(this.Bbz))
      {
        a.d(this.Bbz).nhy.evaluateJavascript(n.aRa("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + a.d(this.Bbz).AKV.Bxs + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + a.e(this.Bbz) + ",\n                    prefetch:" + a.f(this.Bbz) + ",\n                    predns:" + a.g(this.Bbz) + "\n                })\n                return p.wx.info;\n            })(window.performance);"), (ValueCallback)new a(this));
        a.c(this.Bbz);
      }
      AppMethodBeat.o(189429);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(a.b paramb) {}
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "webview-sdk_release"})
  public static final class c
    extends i
  {
    public final void a(h paramh)
    {
      AppMethodBeat.i(189430);
      d.g.b.k.h(paramh, "performanceHelper");
      paramh.Bbs = a.h(this.Bbz);
      AppMethodBeat.o(189430);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(189431);
      d.g.b.k.h(paramh, "performanceHelper");
      d locald = a.i(this.Bbz);
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aPZ("controller");
      }
      b.a(paramh, locald.Pe(localBaseWebViewController.bEx()));
      AppMethodBeat.o(189431);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.a
 * JD-Core Version:    0.7.0.1
 */