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
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.sdk.platformtools.ac;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "isPageCached", "", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "rawUrl", "getRawUrl", "()Ljava/lang/String;", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "getA8KeyReason", "", "url", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrlRedirect", "fullUrl", "webview-sdk_release"})
public final class a
  extends j
{
  private final e CfJ;
  private final i CfK;
  private d.b CtD;
  private boolean CtE;
  private boolean CtF;
  private boolean CtG;
  private final f CtH;
  private final long CtI;
  private boolean CtJ;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(205564);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "WebPrefetcher", "getWebPrefetcher()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;")) };
    AppMethodBeat.o(205564);
  }
  
  public a()
  {
    AppMethodBeat.i(205574);
    this.TAG = "MicroMsg.WebPrefetcherInterceptor";
    this.CtH = g.K((d.g.a.a)a.CtK);
    this.CtI = 500L;
    this.CfJ = ((e)new b(this));
    this.CfK = ((i)new c(this));
    AppMethodBeat.o(205574);
  }
  
  private final boolean aCJ(String paramString)
  {
    AppMethodBeat.i(205566);
    d locald = eCo();
    if ((locald != null) && (locald.ez(getController().bLL(), paramString) == true))
    {
      locald = eCo();
      if ((locald != null) && (locald.Tm(paramString) == true))
      {
        AppMethodBeat.o(205566);
        return true;
      }
    }
    AppMethodBeat.o(205566);
    return false;
  }
  
  private final d eCo()
  {
    AppMethodBeat.i(205565);
    d locald = (d)this.CtH.getValue();
    AppMethodBeat.o(205565);
    return locald;
  }
  
  public final boolean Ui(String paramString)
  {
    AppMethodBeat.i(205567);
    d.g.b.k.h(paramString, "url");
    Object localObject = this.CtD;
    if (localObject != null) {}
    for (localObject = ((d.b)localObject).url; (d.g.b.k.g(paramString, localObject)) && (getController().eyC()); localObject = null)
    {
      this.CtD = null;
      localObject = getController();
      d.g.b.k.h(paramString, "url");
      ac.i(((BaseWebViewController)localObject).eyn(), "reload for:".concat(String.valueOf(paramString)));
      ((BaseWebViewController)localObject).nKq.loadUrl(paramString);
      ((BaseWebViewController)localObject).Cdr = true;
      AppMethodBeat.o(205567);
      return true;
    }
    AppMethodBeat.o(205567);
    return false;
  }
  
  public final int aAM(String paramString)
  {
    AppMethodBeat.i(205571);
    d.g.b.k.h(paramString, "url");
    if (aCJ(paramString))
    {
      AppMethodBeat.o(205571);
      return 10;
    }
    int i = super.aAM(paramString);
    AppMethodBeat.o(205571);
    return i;
  }
  
  public final boolean aBb(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(205568);
    d.g.b.k.h(paramString, "url");
    if (!aCJ(paramString))
    {
      ac.i(this.TAG, "not match ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(205568);
      return false;
    }
    Object localObject1 = eCo();
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((d)localObject1).Tp(paramString);
      if (localObject1 == null) {
        break label372;
      }
      ac.i(this.TAG, "url has been cached:%s", new Object[] { ((d.b)localObject1).url });
      this.CtD = ((d.b)localObject1);
      Object localObject2 = getController();
      String str = ((d.b)localObject1).url;
      d.g.b.k.g(str, "resp.url");
      WebResourceResponse localWebResourceResponse = ((d.b)localObject1).nuM;
      d.g.b.k.g(localWebResourceResponse, "resp.response");
      ((BaseWebViewController)localObject2).E(str, localWebResourceResponse.getResponseHeaders());
      localObject2 = getController();
      str = ((d.b)localObject1).url;
      d.g.b.k.g(str, "resp.url");
      BaseWebViewController.a((BaseWebViewController)localObject2, str, false, 0, 6);
      getController().Cdl.finish();
      getController().Cdl.zB(this.CtI);
      this.CtE = true;
      getController().Cdm.CtE = this.CtE;
      localObject2 = getController().Cdm.CPz;
      localObject1 = ((d.b)localObject1).nuM;
      d.g.b.k.g(localObject1, "resp.response");
      ((HashMap)localObject2).putAll(((WebResourceResponse)localObject1).getResponseHeaders());
      b.eCs();
      localObject1 = eCo();
      if (localObject1 == null) {
        break label367;
      }
      i = ((d)localObject1).To(getController().bLL());
      label291:
      b.Vm(i);
    }
    for (;;)
    {
      this.CtF = true;
      getController().Cdm.CtF = this.CtF;
      localObject1 = eCo();
      if (localObject1 != null) {
        bool = ((d)localObject1).Tn(paramString);
      }
      this.CtG = bool;
      getController().Cdm.CtG = this.CtG;
      AppMethodBeat.o(205568);
      return true;
      localObject1 = null;
      break;
      label367:
      i = 0;
      break label291;
      label372:
      ac.i(this.TAG, "async geta8key:".concat(String.valueOf(paramString)));
      getController().nKq.loadUrl(paramString);
      BaseWebViewController.a(getController(), paramString, false, 0, 6);
    }
  }
  
  public final boolean aBc(String paramString)
  {
    AppMethodBeat.i(205569);
    d.g.b.k.h(paramString, "url");
    if (!aCJ(paramString))
    {
      AppMethodBeat.o(205569);
      return true;
    }
    AppMethodBeat.o(205569);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(205573);
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    String str;
    if (this.CtD != null)
    {
      str = paramWebResourceRequest.getUrl().toString();
      d.g.b.k.g(str, "request.url.toString()");
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.CtD;
        if (paramWebView != null) {
          paramWebView = paramWebView.url;
        }
        while (d.g.b.k.g(str, paramWebView))
        {
          paramWebView = this.CtD;
          if (paramWebView != null)
          {
            paramWebView = paramWebView.nuM;
            if (paramWebView != null)
            {
              ac.v(this.TAG, "intercepted: " + str + ", " + paramWebView.getMimeType());
              AppMethodBeat.o(205573);
              return paramWebView;
              paramWebView = null;
              continue;
            }
          }
          AppMethodBeat.o(205573);
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
        d.g.b.k.g(paramWebView, "Uri.parse(url)");
        paramWebView = paramWebView.getHost();
        if (paramWebView == null) {
          break label407;
        }
        d locald = eCo();
        if (locald == null) {
          break label415;
        }
        paramWebView = locald.eA(paramWebView, str);
        if (paramWebView == null) {
          break label407;
        }
        str = paramWebView.nuL;
        if (str == null)
        {
          if (paramWebView == null) {
            break label407;
          }
          paramWebView = paramWebView.nuM;
          AppMethodBeat.o(205573);
          return paramWebView;
        }
        switch (str.hashCode())
        {
        case 2377: 
          if (!str.equals("JS")) {
            continue;
          }
          getController().Cdm.CPx.add(paramWebResourceRequest.getUrl().toString());
          b.eCt();
          b.Vm(eCo().To(getController().bLL()));
          continue;
          AppMethodBeat.o(205573);
        }
      }
      catch (Exception paramWebView)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)paramWebView, "interceptRequest getCurrentUrl host", new Object[0]);
      }
      return null;
      if (str.equals("CSS"))
      {
        getController().Cdm.CPy.add(paramWebResourceRequest.getUrl().toString());
        b.eCu();
        b.Vm(eCo().To(getController().bLL()));
        continue;
        label407:
        AppMethodBeat.o(205573);
        return null;
        label415:
        paramWebView = null;
      }
    }
  }
  
  public final boolean d(String paramString, arn paramarn)
  {
    long l2 = 0L;
    AppMethodBeat.i(205572);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramarn, "resp");
    if (paramarn.DLI == 38)
    {
      if (aCJ(paramString))
      {
        paramarn = paramarn.ELk;
        if (paramarn == null) {
          break label205;
        }
        paramarn = z.a(paramarn);
      }
      for (;;)
      {
        try
        {
          aro localaro = new aro();
          localaro.parseFrom(paramarn);
          paramarn = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("overrideProcessResultL, prefetchVersion: ");
          d.b localb = this.CtD;
          if (localb == null) {
            continue;
          }
          l1 = localb.nuK;
          ac.i(paramarn, l1 + ", verifyInfo.Version: " + localaro.ELn);
          paramarn = this.CtD;
          l1 = l2;
          if (paramarn != null) {
            l1 = paramarn.nuK;
          }
          if (l1 < localaro.ELn)
          {
            paramarn = eCo();
            if (paramarn != null) {
              paramarn.Tq(paramString);
            }
            getController().nKq.loadUrl(localaro.ELm);
            getController().Cdr = true;
          }
        }
        catch (IOException paramString)
        {
          long l1;
          label205:
          ac.printErrStackTrace(this.TAG, (Throwable)paramString, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
          continue;
        }
        AppMethodBeat.o(205572);
        return true;
        paramarn = null;
        continue;
        l1 = 0L;
      }
    }
    AppMethodBeat.o(205572);
    return false;
  }
  
  public final e eza()
  {
    return this.CfJ;
  }
  
  public final i ezb()
  {
    return this.CfK;
  }
  
  public final boolean u(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(205570);
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "fullUrl");
    d locald = eCo();
    if ((locald != null) && (locald.ez(paramString1, paramString2) == true))
    {
      paramString2 = eCo();
      if ((paramString2 != null) && (paramString2.ez(getController().bLL(), paramString1) == true) && (aCJ(getController().bLL())))
      {
        AppMethodBeat.o(205570);
        return true;
      }
    }
    AppMethodBeat.o(205570);
    return false;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<d>
  {
    public static final a CtK;
    
    static
    {
      AppMethodBeat.i(205559);
      CtK = new a();
      AppMethodBeat.o(205559);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "writePrefetchInfo", "webview-sdk_release"})
  public static final class b
    extends e
  {
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(205561);
      ac.i(a.a(this.CtL), "onPageCommitVisible, url = %s", new Object[] { paramString });
      if (!a.b(this.CtL))
      {
        a.d(this.CtL).nKq.evaluateJavascript(n.aWZ("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + a.d(this.CtL).Cdm.CPA + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + a.e(this.CtL) + ",\n                    prefetch:" + a.f(this.CtL) + ",\n                    predns:" + a.g(this.CtL) + "\n                })\n                return p.wx.info;\n            })(window.performance);"), (ValueCallback)new a(this));
        a.c(this.CtL);
      }
      AppMethodBeat.o(205561);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(a.b paramb) {}
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "webview-sdk_release"})
  public static final class c
    extends i
  {
    public final void a(h paramh)
    {
      AppMethodBeat.i(205562);
      d.g.b.k.h(paramh, "performanceHelper");
      paramh.CtE = a.h(this.CtL);
      AppMethodBeat.o(205562);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(205563);
      d.g.b.k.h(paramh, "performanceHelper");
      d locald = a.i(this.CtL);
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aVY("controller");
      }
      b.a(paramh, locald.To(localBaseWebViewController.bLL()));
      AppMethodBeat.o(205563);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.a
 * JD-Core Version:    0.7.0.1
 */