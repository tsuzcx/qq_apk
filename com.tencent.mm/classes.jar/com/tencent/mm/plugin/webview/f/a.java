package com.tencent.mm.plugin.webview.f;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.luggage.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.d.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.e;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.h.b;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "isPageCached", "", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "rawUrl", "getRawUrl", "()Ljava/lang/String;", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "getA8KeyReason", "", "url", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrlRedirect", "forceRedirect", "fullUrl", "webview-sdk_release"})
public final class a
  extends j
{
  private final e DIN;
  private final com.tencent.mm.plugin.webview.core.i DIO;
  d.b DXk;
  boolean DXl;
  boolean DXm;
  boolean DXn;
  private final f DXo;
  private final long DXp;
  boolean DXq;
  final String TAG;
  
  public a()
  {
    AppMethodBeat.i(214362);
    this.TAG = "MicroMsg.WebPrefetcherInterceptor";
    this.DXo = g.O((d.g.a.a)a.DXr);
    this.DXp = 500L;
    this.DIN = ((e)new b(this));
    this.DIO = ((com.tencent.mm.plugin.webview.core.i)new c(this));
    AppMethodBeat.o(214362);
  }
  
  private final boolean aIl(String paramString)
  {
    AppMethodBeat.i(214354);
    d locald = eRi();
    if ((locald != null) && (locald.eI(getController().bQm(), paramString) == true))
    {
      locald = eRi();
      if ((locald != null) && (locald.WS(paramString) == true))
      {
        AppMethodBeat.o(214354);
        return true;
      }
    }
    AppMethodBeat.o(214354);
    return false;
  }
  
  public final boolean XR(String paramString)
  {
    AppMethodBeat.i(214355);
    p.h(paramString, "url");
    Object localObject = this.DXk;
    if (localObject != null) {}
    for (localObject = ((d.b)localObject).url; (p.i(paramString, localObject)) && (getController().eNs()); localObject = null)
    {
      this.DXk = null;
      localObject = getController();
      p.h(paramString, "url");
      ad.i(((BaseWebViewController)localObject).eNe(), "reload for:".concat(String.valueOf(paramString)));
      ((BaseWebViewController)localObject).omW.loadUrl(paramString);
      ((BaseWebViewController)localObject).DGq = true;
      AppMethodBeat.o(214355);
      return true;
    }
    AppMethodBeat.o(214355);
    return false;
  }
  
  public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(214358);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    if (!paramBoolean)
    {
      paramString2 = eRi();
      if ((paramString2 != null) && (paramString2.eI(getController().bQm(), paramString1) == true) && (aIl(getController().bQm())))
      {
        AppMethodBeat.o(214358);
        return true;
      }
    }
    AppMethodBeat.o(214358);
    return false;
  }
  
  public final int aGg(String paramString)
  {
    AppMethodBeat.i(214359);
    p.h(paramString, "url");
    if (aIl(paramString))
    {
      AppMethodBeat.o(214359);
      return 10;
    }
    int i = super.aGg(paramString);
    AppMethodBeat.o(214359);
    return i;
  }
  
  public final boolean aGw(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(214356);
    p.h(paramString, "url");
    if (!aIl(paramString))
    {
      ad.i(this.TAG, "not match ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(214356);
      return false;
    }
    Object localObject1 = eRi();
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((d)localObject1).WW(paramString);
      if (localObject1 == null) {
        break label339;
      }
      ad.i(this.TAG, "url has been cached:%s", new Object[] { ((d.b)localObject1).url });
      this.DXk = ((d.b)localObject1);
      localObject2 = getController();
      String str = ((d.b)localObject1).url;
      p.g(str, "resp.url");
      WebResourceResponse localWebResourceResponse = ((d.b)localObject1).nWk;
      p.g(localWebResourceResponse, "resp.response");
      ((BaseWebViewController)localObject2).F(str, localWebResourceResponse.getResponseHeaders());
      localObject2 = getController();
      str = ((d.b)localObject1).url;
      p.g(str, "resp.url");
      BaseWebViewController.a((BaseWebViewController)localObject2, str, false, 0, 6);
      this.DXl = true;
      getController().DGl.DXl = this.DXl;
      localObject2 = getController().DGl.EtB;
      localObject1 = ((d.b)localObject1).nWk;
      p.g(localObject1, "resp.response");
      ((HashMap)localObject2).putAll(((WebResourceResponse)localObject1).getResponseHeaders());
      b.eRm();
      localObject1 = eRi();
      if (localObject1 == null) {
        break label334;
      }
      i = ((d)localObject1).WV(getController().bQm());
      label259:
      b.Xc(i);
    }
    for (;;)
    {
      this.DXm = true;
      getController().DGl.DXm = this.DXm;
      localObject1 = eRi();
      if (localObject1 != null) {
        bool = ((d)localObject1).WU(paramString);
      }
      this.DXn = bool;
      getController().DGl.DXn = this.DXn;
      AppMethodBeat.o(214356);
      return true;
      localObject1 = null;
      break;
      label334:
      i = 0;
      break label259;
      label339:
      ad.i(this.TAG, "async geta8key:".concat(String.valueOf(paramString)));
      localObject2 = eRi().WT(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramString;
      }
      ad.i(this.TAG, "async geta8key respUrl:".concat(String.valueOf(localObject1)));
      localObject2 = localObject1;
      if (!c.a((String)localObject1, "http", true)) {
        localObject2 = "http://".concat(String.valueOf(paramString));
      }
      getController().omW.loadUrl((String)localObject2);
      BaseWebViewController.a(getController(), (String)localObject2, false, 0, 6);
    }
  }
  
  public final boolean aGx(String paramString)
  {
    AppMethodBeat.i(214357);
    p.h(paramString, "url");
    if (!aIl(paramString))
    {
      AppMethodBeat.o(214357);
      return true;
    }
    AppMethodBeat.o(214357);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(214361);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    String str;
    if (this.DXk != null)
    {
      str = paramWebResourceRequest.getUrl().toString();
      p.g(str, "request.url.toString()");
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.DXk;
        if (paramWebView != null) {
          paramWebView = paramWebView.url;
        }
        while (p.i(str, paramWebView))
        {
          paramWebView = this.DXk;
          if (paramWebView != null)
          {
            paramWebView = paramWebView.nWk;
            if (paramWebView != null)
            {
              ad.v(this.TAG, "intercepted: " + str + ", " + paramWebView.getMimeType());
              AppMethodBeat.o(214361);
              return paramWebView;
              paramWebView = null;
              continue;
            }
          }
          AppMethodBeat.o(214361);
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
          break label407;
        }
        paramWebView = Uri.parse(paramWebView);
        p.g(paramWebView, "Uri.parse(url)");
        paramWebView = paramWebView.getHost();
        if (paramWebView == null) {
          break label407;
        }
        d locald = eRi();
        if (locald == null) {
          break label415;
        }
        paramWebView = locald.eJ(paramWebView, str);
        if (paramWebView == null) {
          break label407;
        }
        str = paramWebView.nWj;
        if (str == null)
        {
          if (paramWebView == null) {
            break label407;
          }
          paramWebView = paramWebView.nWk;
          AppMethodBeat.o(214361);
          return paramWebView;
        }
        switch (str.hashCode())
        {
        case 2377: 
          if (!str.equals("JS")) {
            continue;
          }
          getController().DGl.Etz.add(paramWebResourceRequest.getUrl().toString());
          b.eRn();
          b.Xc(eRi().WV(getController().bQm()));
          continue;
          AppMethodBeat.o(214361);
        }
      }
      catch (Exception paramWebView)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramWebView, "interceptRequest getCurrentUrl host", new Object[0]);
      }
      return null;
      if (str.equals("CSS"))
      {
        getController().DGl.EtA.add(paramWebResourceRequest.getUrl().toString());
        b.eRo();
        b.Xc(eRi().WV(getController().bQm()));
        continue;
        label407:
        AppMethodBeat.o(214361);
        return null;
        label415:
        paramWebView = null;
      }
    }
  }
  
  public final boolean d(String paramString, avj paramavj)
  {
    long l2 = 0L;
    AppMethodBeat.i(214360);
    p.h(paramString, "reqUrl");
    p.h(paramavj, "resp");
    if (paramavj.FqN == 38)
    {
      if (aIl(paramString))
      {
        paramavj = paramavj.Gun;
        if (paramavj == null) {
          break label204;
        }
        paramavj = z.a(paramavj);
      }
      for (;;)
      {
        try
        {
          avk localavk = new avk();
          localavk.parseFrom(paramavj);
          paramavj = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("overrideProcessResultL, prefetchVersion: ");
          d.b localb = this.DXk;
          if (localb == null) {
            continue;
          }
          l1 = localb.nWi;
          ad.i(paramavj, l1 + ", verifyInfo.Version: " + localavk.Guq);
          paramavj = this.DXk;
          l1 = l2;
          if (paramavj != null) {
            l1 = paramavj.nWi;
          }
          if (l1 < localavk.Guq)
          {
            paramavj = eRi();
            if (paramavj != null) {
              paramavj.WX(paramString);
            }
            getController().omW.loadUrl(localavk.Gup);
            getController().DGq = true;
          }
        }
        catch (IOException paramString)
        {
          long l1;
          label204:
          ad.printErrStackTrace(this.TAG, (Throwable)paramString, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
          continue;
        }
        AppMethodBeat.o(214360);
        return true;
        paramavj = null;
        continue;
        l1 = 0L;
      }
    }
    AppMethodBeat.o(214360);
    return false;
  }
  
  public final e eNP()
  {
    return this.DIN;
  }
  
  public final com.tencent.mm.plugin.webview.core.i eNQ()
  {
    return this.DIO;
  }
  
  final d eRi()
  {
    AppMethodBeat.i(214353);
    d locald = (d)this.DXo.getValue();
    AppMethodBeat.o(214353);
    return locald;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<d>
  {
    public static final a DXr;
    
    static
    {
      AppMethodBeat.i(214348);
      DXr = new a();
      AppMethodBeat.o(214348);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "writePrefetchInfo", "webview-sdk_release"})
  public static final class b
    extends e
  {
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(214350);
      ad.i(this.DXs.TAG, "onPageCommitVisible, url = %s", new Object[] { paramString });
      if (!this.DXs.DXq)
      {
        this.DXs.getController().omW.evaluateJavascript(n.bdc("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + this.DXs.getController().DGl.EtC + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + this.DXs.DXm + ",\n                    prefetch:" + this.DXs.DXl + ",\n                    predns:" + this.DXs.DXn + "\n                })\n                return p.wx.info;\n            })(window.performance);"), (ValueCallback)new a(this));
        this.DXs.DXq = true;
      }
      AppMethodBeat.o(214350);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(a.b paramb) {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "webview-sdk_release"})
  public static final class c
    extends com.tencent.mm.plugin.webview.core.i
  {
    public final void a(com.tencent.mm.plugin.webview.j.i parami)
    {
      AppMethodBeat.i(214351);
      p.h(parami, "performanceHelper");
      Object localObject = this.DXs;
      String str = ((a)localObject).getController().DFY;
      localObject = ((a)localObject).DXk;
      if (localObject != null) {}
      for (localObject = ((d.b)localObject).url;; localObject = null)
      {
        parami.DXl = p.i(str, localObject);
        AppMethodBeat.o(214351);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.webview.j.i parami)
    {
      AppMethodBeat.i(214352);
      p.h(parami, "performanceHelper");
      d locald = this.DXs.eRi();
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        p.bcb("controller");
      }
      b.a(parami, locald.WV(localBaseWebViewController.bQm()));
      AppMethodBeat.o(214352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.a
 * JD-Core Version:    0.7.0.1
 */