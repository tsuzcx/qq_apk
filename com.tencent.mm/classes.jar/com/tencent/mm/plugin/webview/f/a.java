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
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.awa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "isPageCached", "", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "rawUrl", "getRawUrl", "()Ljava/lang/String;", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "getA8KeyReason", "", "url", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrlRedirect", "forceRedirect", "fullUrl", "webview-sdk_release"})
public final class a
  extends j
{
  private final e EaL;
  private final com.tencent.mm.plugin.webview.core.i EaM;
  d.b Epm;
  boolean Epn;
  boolean Epo;
  boolean Epp;
  private final f Epq;
  private final long Epr;
  boolean Eps;
  final String TAG;
  
  public a()
  {
    AppMethodBeat.i(214203);
    this.TAG = "MicroMsg.WebPrefetcherInterceptor";
    this.Epq = d.g.O((d.g.a.a)a.Ept);
    this.Epr = 500L;
    this.EaL = ((e)new b(this));
    this.EaM = ((com.tencent.mm.plugin.webview.core.i)new c(this));
    AppMethodBeat.o(214203);
  }
  
  private final boolean aJE(String paramString)
  {
    AppMethodBeat.i(214195);
    d locald = eUU();
    if ((locald != null) && (locald.eL(getController().bRn(), paramString) == true))
    {
      locald = eUU();
      if ((locald != null) && (locald.XE(paramString) == true))
      {
        AppMethodBeat.o(214195);
        return true;
      }
    }
    AppMethodBeat.o(214195);
    return false;
  }
  
  public final boolean YE(String paramString)
  {
    AppMethodBeat.i(214196);
    p.h(paramString, "url");
    Object localObject = this.Epm;
    if (localObject != null) {}
    for (localObject = ((d.b)localObject).url; (p.i(paramString, localObject)) && (getController().eRd()); localObject = null)
    {
      this.Epm = null;
      localObject = getController();
      p.h(paramString, "url");
      ae.i(((BaseWebViewController)localObject).eQP(), "reload for:".concat(String.valueOf(paramString)));
      ((BaseWebViewController)localObject).osM.loadUrl(paramString);
      ((BaseWebViewController)localObject).DYo = true;
      AppMethodBeat.o(214196);
      return true;
    }
    AppMethodBeat.o(214196);
    return false;
  }
  
  public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(214199);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    if ((!paramBoolean) && (paramInt == 10))
    {
      AppMethodBeat.o(214199);
      return true;
    }
    AppMethodBeat.o(214199);
    return false;
  }
  
  public final int aHA(String paramString)
  {
    AppMethodBeat.i(214200);
    p.h(paramString, "url");
    Object localObject = this.Epm;
    if (localObject != null) {}
    for (localObject = ((d.b)localObject).url; p.i(paramString, localObject); localObject = null)
    {
      AppMethodBeat.o(214200);
      return 10;
    }
    int i = super.aHA(paramString);
    AppMethodBeat.o(214200);
    return i;
  }
  
  public final boolean aHQ(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(214197);
    p.h(paramString, "url");
    if (!aJE(paramString))
    {
      ae.i(this.TAG, "not match ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(214197);
      return false;
    }
    Object localObject1 = eUU();
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((d)localObject1).XI(paramString);
      if (localObject1 == null) {
        break label427;
      }
      ae.i(this.TAG, "url has been cached:%s", new Object[] { ((d.b)localObject1).url });
      ae.i(this.TAG, "url has been cached, bizScene:" + ((d.b)localObject1).nLC + ", url:" + ((d.b)localObject1).url);
      this.Epm = ((d.b)localObject1);
      com.tencent.mm.plugin.report.service.g.yxI.f(21075, new Object[] { Integer.valueOf(((d.b)localObject1).nLC), paramString, ((d.b)localObject1).url, Integer.valueOf(4) });
      localObject2 = getController();
      String str = ((d.b)localObject1).url;
      p.g(str, "resp.url");
      WebResourceResponse localWebResourceResponse = ((d.b)localObject1).obT;
      p.g(localWebResourceResponse, "resp.response");
      ((BaseWebViewController)localObject2).G(str, localWebResourceResponse.getResponseHeaders());
      localObject2 = getController();
      str = ((d.b)localObject1).url;
      p.g(str, "resp.url");
      BaseWebViewController.a((BaseWebViewController)localObject2, str, false, 0, 6);
      this.Epn = true;
      getController().DYj.Epn = this.Epn;
      localObject2 = getController().DYj.ELV;
      localObject1 = ((d.b)localObject1).obT;
      p.g(localObject1, "resp.response");
      ((HashMap)localObject2).putAll(((WebResourceResponse)localObject1).getResponseHeaders());
      b.eUY();
      localObject1 = eUU();
      if (localObject1 == null) {
        break label422;
      }
      i = ((d)localObject1).XH(getController().bRn());
      label347:
      b.XI(i);
    }
    for (;;)
    {
      this.Epo = true;
      getController().DYj.Epo = this.Epo;
      localObject1 = eUU();
      if (localObject1 != null) {
        bool = ((d)localObject1).XG(paramString);
      }
      this.Epp = bool;
      getController().DYj.Epp = this.Epp;
      AppMethodBeat.o(214197);
      return true;
      localObject1 = null;
      break;
      label422:
      i = 0;
      break label347;
      label427:
      ae.i(this.TAG, "async geta8key:".concat(String.valueOf(paramString)));
      localObject2 = eUU().XF(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramString;
      }
      ae.i(this.TAG, "async geta8key respUrl:".concat(String.valueOf(localObject1)));
      localObject2 = localObject1;
      if (!c.A((String)localObject1, "http")) {
        localObject2 = "http://".concat(String.valueOf(paramString));
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(21075, new Object[] { Integer.valueOf(0), paramString, localObject2, Integer.valueOf(5) });
      getController().osM.loadUrl((String)localObject2);
      BaseWebViewController.a(getController(), (String)localObject2, false, 0, 6);
    }
  }
  
  public final boolean aHR(String paramString)
  {
    AppMethodBeat.i(214198);
    p.h(paramString, "url");
    if (!aJE(paramString))
    {
      AppMethodBeat.o(214198);
      return true;
    }
    AppMethodBeat.o(214198);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(214202);
    p.h(paramWebView, "webview");
    p.h(paramWebResourceRequest, "request");
    String str;
    if (this.Epm != null)
    {
      str = paramWebResourceRequest.getUrl().toString();
      p.g(str, "request.url.toString()");
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.Epm;
        if (paramWebView != null) {
          paramWebView = paramWebView.url;
        }
        while (p.i(str, paramWebView))
        {
          paramWebView = this.Epm;
          if (paramWebView != null)
          {
            paramWebView = paramWebView.obT;
            if (paramWebView != null)
            {
              ae.v(this.TAG, "intercepted: " + str + ", " + paramWebView.getMimeType());
              AppMethodBeat.o(214202);
              return paramWebView;
              paramWebView = null;
              continue;
            }
          }
          AppMethodBeat.o(214202);
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
        d locald = eUU();
        if (locald == null) {
          break label415;
        }
        paramWebView = locald.eM(paramWebView, str);
        if (paramWebView == null) {
          break label407;
        }
        str = paramWebView.obS;
        if (str == null)
        {
          if (paramWebView == null) {
            break label407;
          }
          paramWebView = paramWebView.obT;
          AppMethodBeat.o(214202);
          return paramWebView;
        }
        switch (str.hashCode())
        {
        case 2377: 
          if (!str.equals("JS")) {
            continue;
          }
          getController().DYj.ELT.add(paramWebResourceRequest.getUrl().toString());
          b.eUZ();
          b.XI(eUU().XH(getController().bRn()));
          continue;
          AppMethodBeat.o(214202);
        }
      }
      catch (Exception paramWebView)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)paramWebView, "interceptRequest getCurrentUrl host", new Object[0]);
      }
      return null;
      if (str.equals("CSS"))
      {
        getController().DYj.ELU.add(paramWebResourceRequest.getUrl().toString());
        b.eVa();
        b.XI(eUU().XH(getController().bRn()));
        continue;
        label407:
        AppMethodBeat.o(214202);
        return null;
        label415:
        paramWebView = null;
      }
    }
  }
  
  public final boolean d(String paramString, avz paramavz)
  {
    long l2 = 0L;
    AppMethodBeat.i(214201);
    p.h(paramString, "reqUrl");
    p.h(paramavz, "resp");
    if (paramavz.FJl == 38)
    {
      if (aJE(paramString))
      {
        paramavz = paramavz.GNM;
        if (paramavz == null) {
          break label204;
        }
        paramavz = z.a(paramavz);
      }
      for (;;)
      {
        try
        {
          awa localawa = new awa();
          localawa.parseFrom(paramavz);
          paramavz = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("overrideProcessResultL, prefetchVersion: ");
          d.b localb = this.Epm;
          if (localb == null) {
            continue;
          }
          l1 = localb.obR;
          ae.i(paramavz, l1 + ", verifyInfo.Version: " + localawa.GNP);
          paramavz = this.Epm;
          l1 = l2;
          if (paramavz != null) {
            l1 = paramavz.obR;
          }
          if (l1 < localawa.GNP)
          {
            paramavz = eUU();
            if (paramavz != null) {
              paramavz.XJ(paramString);
            }
            getController().osM.loadUrl(localawa.GNO);
            getController().DYo = true;
          }
        }
        catch (IOException paramString)
        {
          long l1;
          label204:
          ae.printErrStackTrace(this.TAG, (Throwable)paramString, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
          continue;
        }
        AppMethodBeat.o(214201);
        return true;
        paramavz = null;
        continue;
        l1 = 0L;
      }
    }
    AppMethodBeat.o(214201);
    return false;
  }
  
  public final e eRA()
  {
    return this.EaL;
  }
  
  public final com.tencent.mm.plugin.webview.core.i eRB()
  {
    return this.EaM;
  }
  
  final d eUU()
  {
    AppMethodBeat.i(214194);
    d locald = (d)this.Epq.getValue();
    AppMethodBeat.o(214194);
    return locald;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<d>
  {
    public static final a Ept;
    
    static
    {
      AppMethodBeat.i(214189);
      Ept = new a();
      AppMethodBeat.o(214189);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "writePrefetchInfo", "webview-sdk_release"})
  public static final class b
    extends e
  {
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(214191);
      ae.i(this.Epu.TAG, "onPageCommitVisible, url = %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g localg;
      if (!this.Epu.Eps)
      {
        this.Epu.getController().osM.evaluateJavascript(n.beG("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + this.Epu.getController().DYj.ELW + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + this.Epu.Epo + ",\n                    prefetch:" + this.Epu.Epn + ",\n                    predns:" + this.Epu.Epp + "\n                })\n                return p.wx.info;\n            })(window.performance);"), (ValueCallback)new a(this));
        this.Epu.Eps = true;
        if (this.Epu.Epm != null)
        {
          localg = com.tencent.mm.plugin.report.service.g.yxI;
          paramWebView = this.Epu.Epm;
          if (paramWebView == null) {
            break label250;
          }
        }
      }
      label250:
      for (paramWebView = Integer.valueOf(paramWebView.nLC);; paramWebView = null)
      {
        Object localObject = this.Epu.Epm;
        if (localObject != null)
        {
          String str = ((d.b)localObject).url;
          localObject = str;
          if (str != null) {}
        }
        else
        {
          localObject = "";
        }
        localg.f(21075, new Object[] { paramWebView, paramString, localObject, Integer.valueOf(6) });
        AppMethodBeat.o(214191);
        return;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(a.b paramb) {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "webview-sdk_release"})
  public static final class c
    extends com.tencent.mm.plugin.webview.core.i
  {
    public final void a(com.tencent.mm.plugin.webview.j.i parami)
    {
      AppMethodBeat.i(214192);
      p.h(parami, "performanceHelper");
      Object localObject = this.Epu;
      String str = ((a)localObject).getController().DXV;
      localObject = ((a)localObject).Epm;
      if (localObject != null) {}
      for (localObject = ((d.b)localObject).url;; localObject = null)
      {
        parami.Epn = p.i(str, localObject);
        AppMethodBeat.o(214192);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.webview.j.i parami)
    {
      AppMethodBeat.i(214193);
      p.h(parami, "performanceHelper");
      d locald = this.Epu.eUU();
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        p.bdF("controller");
      }
      b.a(parami, locald.XH(localBaseWebViewController.bRn()));
      AppMethodBeat.o(214193);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.a
 * JD-Core Version:    0.7.0.1
 */