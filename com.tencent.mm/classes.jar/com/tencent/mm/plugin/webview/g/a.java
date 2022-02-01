package com.tencent.mm.plugin.webview.g;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ax.c.a;
import com.tencent.mm.plugin.brandservice.a.f.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.core.k.a;
import com.tencent.mm.plugin.webview.i.b;
import com.tencent.mm.plugin.webview.i.d;
import com.tencent.mm.plugin.webview.k.o;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "hasReportInPageCommit", "", "hasReportInPageFinish", "isPageCached", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "rawUrl", "getRawUrl", "()Ljava/lang/String;", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "attachPrefetchJsApi", "", "getA8KeyReason", "", "url", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideStartLoadBefore", "intent", "Landroid/content/Intent;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "forceRedirect", "fullUrl", "webview-sdk_release"})
public final class a
  extends k
{
  private final com.tencent.mm.plugin.webview.core.f PJf;
  f.b PZa;
  boolean PZb;
  boolean PZc;
  boolean PZd;
  private final kotlin.f PZe;
  private final long PZf;
  boolean PZg;
  boolean PZh;
  boolean PZi;
  final String TAG;
  private final j pHv;
  
  public a()
  {
    AppMethodBeat.i(207367);
    this.TAG = "MicroMsg.WebPrefetcherInterceptor";
    this.PZe = g.ar((kotlin.g.a.a)a.PZj);
    this.PZf = 500L;
    this.PJf = ((com.tencent.mm.plugin.webview.core.f)new c(this));
    this.pHv = ((j)new d(this));
    AppMethodBeat.o(207367);
  }
  
  private final boolean blG(String paramString)
  {
    AppMethodBeat.i(207349);
    com.tencent.mm.plugin.brandservice.a.f localf = gWK();
    if ((localf != null) && (localf.fr(getController().cDu(), paramString) == true))
    {
      localf = gWK();
      if ((localf != null) && (localf.apm(paramString) == true))
      {
        AppMethodBeat.o(207349);
        return true;
      }
    }
    AppMethodBeat.o(207349);
    return false;
  }
  
  public final boolean a(int paramInt, String paramString, bot parambot)
  {
    long l2 = 0L;
    AppMethodBeat.i(207365);
    p.k(paramString, "reqUrl");
    p.k(parambot, "resp");
    if (parambot.SZN == 38)
    {
      if (blG(paramString))
      {
        parambot = parambot.TaB;
        if (parambot == null) {
          break label204;
        }
        parambot = z.a(parambot);
      }
      for (;;)
      {
        try
        {
          bou localbou = new bou();
          localbou.parseFrom(parambot);
          parambot = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("overrideProcessResultL, prefetchVersion: ");
          f.b localb = this.PZa;
          if (localb == null) {
            continue;
          }
          l1 = localb.svx;
          Log.i(parambot, l1 + ", verifyInfo.Version: " + localbou.TaE);
          parambot = this.PZa;
          l1 = l2;
          if (parambot != null) {
            l1 = parambot.svx;
          }
          if (l1 < localbou.TaE)
          {
            parambot = gWK();
            if (parambot != null) {
              parambot.apr(paramString);
            }
            getController().pHS.loadUrl(localbou.TaD);
            getController().PGd = true;
          }
        }
        catch (IOException paramString)
        {
          long l1;
          label204:
          Log.printErrStackTrace(this.TAG, (Throwable)paramString, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
          continue;
        }
        AppMethodBeat.o(207365);
        return true;
        parambot = null;
        continue;
        l1 = 0L;
      }
    }
    if ((this.PZb) && (paramInt == 9)) {
      getController().PGd = true;
    }
    AppMethodBeat.o(207365);
    return false;
  }
  
  public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207359);
    p.k(paramString1, "reqUrl");
    p.k(paramString2, "fullUrl");
    if ((!paramBoolean) && (paramInt == 10))
    {
      AppMethodBeat.o(207359);
      return true;
    }
    AppMethodBeat.o(207359);
    return false;
  }
  
  public final boolean aqs(String paramString)
  {
    AppMethodBeat.i(207351);
    p.k(paramString, "url");
    Object localObject = this.PZa;
    if (localObject != null) {}
    for (localObject = ((f.b)localObject).url; (p.h(paramString, localObject)) && (getController().gSz()); localObject = null)
    {
      this.PZa = null;
      getController().bjv(paramString);
      AppMethodBeat.o(207351);
      return true;
    }
    AppMethodBeat.o(207351);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(207366);
    p.k(paramWebView, "webview");
    p.k(paramWebResourceRequest, "request");
    String str1;
    if (this.PZa != null)
    {
      str1 = paramWebResourceRequest.getUrl().toString();
      p.j(str1, "request.url.toString()");
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.PZa;
        if (paramWebView != null) {
          paramWebView = paramWebView.url;
        }
        while (p.h(str1, paramWebView))
        {
          paramWebView = this.PZa;
          if (paramWebView != null)
          {
            paramWebView = paramWebView.svz;
            if (paramWebView != null)
            {
              Log.v(this.TAG, "intercepted: " + str1 + ", " + paramWebView.getMimeType());
              AppMethodBeat.o(207366);
              return paramWebView;
              paramWebView = null;
              continue;
            }
          }
          AppMethodBeat.o(207366);
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
        p.j(paramWebView, "Uri.parse(url)");
        String str2 = paramWebView.getHost();
        if (str2 == null) {
          break label427;
        }
        com.tencent.mm.plugin.brandservice.a.f localf = gWK();
        if (localf == null) {
          break label440;
        }
        paramWebView = this.PZa;
        if (paramWebView == null) {
          break label435;
        }
        paramWebView = paramWebView.appId;
        paramWebView = localf.P(str2, str1, paramWebView);
        if (paramWebView == null) {
          break label427;
        }
        str1 = paramWebView.svy;
        if (str1 == null)
        {
          if (paramWebView == null) {
            break label427;
          }
          paramWebView = paramWebView.svz;
          AppMethodBeat.o(207366);
          return paramWebView;
        }
        switch (str1.hashCode())
        {
        case 2377: 
          if (!str1.equals("JS")) {
            continue;
          }
          getController().PFY.QAu.add(paramWebResourceRequest.getUrl().toString());
          com.tencent.mm.plugin.webview.i.f.gWP();
          com.tencent.mm.plugin.webview.i.f.aof(gWK().app(getController().cDu()));
          continue;
          AppMethodBeat.o(207366);
        }
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramWebView, "interceptRequest getCurrentUrl host", new Object[0]);
      }
      return null;
      if (str1.equals("CSS"))
      {
        getController().PFY.QAv.add(paramWebResourceRequest.getUrl().toString());
        com.tencent.mm.plugin.webview.i.f.gWQ();
        com.tencent.mm.plugin.webview.i.f.aof(gWK().app(getController().cDu()));
        continue;
        label427:
        AppMethodBeat.o(207366);
        return null;
        label435:
        paramWebView = null;
        continue;
        label440:
        paramWebView = null;
      }
    }
  }
  
  public final j bXJ()
  {
    return this.pHv;
  }
  
  public final boolean bjJ(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(207355);
    p.k(paramString, "url");
    if (!blG(paramString))
    {
      Log.i(this.TAG, "not match ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(207355);
      return false;
    }
    Object localObject1 = gWK();
    Object localObject2;
    label203:
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.brandservice.a.f)localObject1).apq(paramString);
      if (localObject1 == null) {
        break label564;
      }
      localObject2 = o.QAC;
      o.a(getController().PFF.PZC, paramString, d.PZL, com.tencent.mm.plugin.webview.i.c.PZH, getController().PFF.PZB);
      getController().PFF.a(com.tencent.mm.plugin.webview.i.c.PZH);
      Log.i(this.TAG, "url has been cached, bizScene:" + ((f.b)localObject1).kqZ + ", subBizScene:" + ((f.b)localObject1).svw + " ,url:" + ((f.b)localObject1).url);
      this.PZa = ((f.b)localObject1);
      localObject2 = this.PZa;
      if (localObject2 == null) {
        break label548;
      }
      localObject2 = ((f.b)localObject2).appId;
      Object localObject3 = (CharSequence)localObject2;
      if ((localObject3 != null) && (!kotlin.n.n.ba((CharSequence)localObject3))) {
        break label554;
      }
      i = 1;
      label225:
      if (i == 0) {
        getController().pHS.addJavascriptInterface(new b(this, (String)localObject2), "wxPrefetcherClient");
      }
      h.IzE.a(21075, new Object[] { Integer.valueOf(((f.b)localObject1).kqZ), paramString, ((f.b)localObject1).url, Integer.valueOf(4), Integer.valueOf(((f.b)localObject1).svw) });
      localObject2 = getController();
      localObject3 = ((f.b)localObject1).url;
      p.j(localObject3, "resp.url");
      WebResourceResponse localWebResourceResponse = ((f.b)localObject1).svz;
      p.j(localWebResourceResponse, "resp.response");
      ((BaseWebViewController)localObject2).N((String)localObject3, localWebResourceResponse.getResponseHeaders());
      localObject2 = getController();
      localObject3 = ((f.b)localObject1).url;
      p.j(localObject3, "resp.url");
      BaseWebViewController.a((BaseWebViewController)localObject2, (String)localObject3, false, 10, 2);
      this.PZb = true;
      getController().PFY.PZb = this.PZb;
      localObject2 = getController().PFY.QAw;
      localObject1 = ((f.b)localObject1).svz;
      p.j(localObject1, "resp.response");
      ((HashMap)localObject2).putAll(((WebResourceResponse)localObject1).getResponseHeaders());
      com.tencent.mm.plugin.webview.i.f.gWO();
      localObject1 = gWK();
      if (localObject1 == null) {
        break label559;
      }
      i = ((com.tencent.mm.plugin.brandservice.a.f)localObject1).app(getController().cDu());
      label472:
      com.tencent.mm.plugin.webview.i.f.aof(i);
    }
    for (;;)
    {
      this.PZc = true;
      getController().PFY.PZc = this.PZc;
      localObject1 = gWK();
      if (localObject1 != null) {
        bool = ((com.tencent.mm.plugin.brandservice.a.f)localObject1).apo(paramString);
      }
      this.PZd = bool;
      getController().PFY.PZd = this.PZd;
      AppMethodBeat.o(207355);
      return true;
      localObject1 = null;
      break;
      label548:
      localObject2 = null;
      break label203;
      label554:
      i = 0;
      break label225;
      label559:
      i = 0;
      break label472;
      label564:
      localObject1 = o.QAC;
      o.a(getController().PFF.PZC, paramString, d.PZL, com.tencent.mm.plugin.webview.i.c.PZG, getController().PFF.PZB);
      getController().PFF.a(com.tencent.mm.plugin.webview.i.c.PZG);
      Log.i(this.TAG, "async geta8key:".concat(String.valueOf(paramString)));
      localObject2 = gWK().apn(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramString;
      }
      Log.i(this.TAG, "async geta8key respUrl:".concat(String.valueOf(localObject1)));
      localObject2 = localObject1;
      if (!com.tencent.luggage.k.c.G((String)localObject1, "http")) {
        localObject2 = "http://".concat(String.valueOf(paramString));
      }
      h.IzE.a(21075, new Object[] { Integer.valueOf(0), paramString, localObject2, Integer.valueOf(5) });
      getController().pHS.loadUrl((String)localObject2);
      BaseWebViewController.a(getController(), (String)localObject2, false, 10, 2);
    }
  }
  
  public final boolean bjK(String paramString)
  {
    AppMethodBeat.i(207357);
    p.k(paramString, "url");
    if (!blG(paramString))
    {
      AppMethodBeat.o(207357);
      return true;
    }
    AppMethodBeat.o(207357);
    return false;
  }
  
  public final int bjr(String paramString)
  {
    AppMethodBeat.i(207361);
    p.k(paramString, "url");
    if (!blG(paramString))
    {
      localObject = this.PZa;
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (Object localObject = ((f.b)localObject).url; p.h(paramString, localObject); localObject = null)
    {
      AppMethodBeat.o(207361);
      return 10;
    }
    int i = super.bjr(paramString);
    AppMethodBeat.o(207361);
    return i;
  }
  
  public final k.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(207352);
    p.k(paramWebView, "webView");
    p.k(paramWebResourceRequest, "request");
    BaseWebViewController localBaseWebViewController = getController();
    if ((localBaseWebViewController != null) && (paramWebResourceRequest.isForMainFrame()) && (paramWebResourceRequest.getUrl() != null) && (localBaseWebViewController.gSz()))
    {
      this.PZa = null;
      Log.i(this.TAG, "shouldOverride url exitTmpl");
    }
    paramWebView = super.c(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(207352);
    return paramWebView;
  }
  
  public final boolean e(String paramString, Intent paramIntent)
  {
    long l2 = 0L;
    AppMethodBeat.i(207350);
    p.k(paramString, "url");
    paramString = getController().PFY;
    long l1;
    if (paramIntent != null)
    {
      l1 = paramIntent.getLongExtra("startTime", 0L);
      paramString.QAx = l1;
      paramString = getController().PFF;
      l1 = l2;
      if (paramIntent != null) {
        l1 = paramIntent.getLongExtra("startTime", 0L);
      }
      paramString.PZB = l1;
      paramString = getController().PFF;
      if (paramIntent == null) {
        break label112;
      }
    }
    label112:
    for (boolean bool = paramIntent.getBooleanExtra("prefetch_has_report_in_click", false);; bool = false)
    {
      paramString.PZC = bool;
      AppMethodBeat.o(207350);
      return false;
      l1 = 0L;
      break;
    }
  }
  
  public final com.tencent.mm.plugin.webview.core.f gTb()
  {
    return this.PJf;
  }
  
  final com.tencent.mm.plugin.brandservice.a.f gWK()
  {
    AppMethodBeat.i(207348);
    com.tencent.mm.plugin.brandservice.a.f localf = (com.tencent.mm.plugin.brandservice.a.f)this.PZe.getValue();
    AppMethodBeat.o(207348);
    return localf;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.brandservice.a.f>
  {
    public static final a PZj;
    
    static
    {
      AppMethodBeat.i(205275);
      PZj = new a();
      AppMethodBeat.o(205275);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$attachPrefetchJsApi$1", "", "forceH5", "", "newUrl", "", "getLocalData", "key", "setLocalData", "data", "webview-sdk_release"})
  public static final class b
  {
    b(String paramString) {}
    
    @JavascriptInterface
    public final void forceH5(String paramString)
    {
      AppMethodBeat.i(215584);
      this.PZk.PZa = null;
      this.PZk.getController().PGd = true;
      this.PZk.getController().gSz();
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (kotlin.n.n.ba(localCharSequence))) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.PZk.getController().reload();
        AppMethodBeat.o(215584);
        return;
      }
      this.PZk.getController().bjv(paramString);
      AppMethodBeat.o(215584);
    }
    
    @JavascriptInterface
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(215583);
      p.k(paramString, "key");
      try
      {
        Object localObject = com.tencent.mm.plugin.ax.c.PwQ;
        localObject = com.tencent.mm.plugin.ax.c.gPU().decodeString(this.cBD + '-' + paramString, "");
        Log.d(this.PZk.TAG, "getLocalData:" + paramString + ", " + (String)localObject);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.PZk.TAG, (Throwable)localException, "getLocalData:".concat(String.valueOf(paramString)), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(215583);
      return paramString;
    }
    
    @JavascriptInterface
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(215582);
      p.k(paramString1, "key");
      p.k(paramString2, "data");
      try
      {
        c.a locala = com.tencent.mm.plugin.ax.c.PwQ;
        ((MultiProcessMMKV)com.tencent.mm.plugin.ax.c.gPU().getSlotForWrite()).encode(this.cBD + '-' + paramString1, paramString2);
        Log.d(this.PZk.TAG, "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(215582);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(this.PZk.TAG, (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(215582);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageFinished", "writePrefetchInfo", "webview-sdk_release"})
  public static final class c
    extends com.tencent.mm.plugin.webview.core.f
  {
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(205641);
      super.b(paramWebView, paramString);
      Log.i(this.PZk.TAG, "onPageFinished, url = %s", new Object[] { paramString });
      if ((paramString != null) && (!this.PZk.PZh) && (this.PZk.getController().PFF.PZD != com.tencent.mm.plugin.webview.i.c.PZE))
      {
        paramWebView = o.QAC;
        o.a(this.PZk.getController().PFF.PZC, this.PZk.getController().cDu(), d.PZN, this.PZk.getController().PFF.PZD, this.PZk.getController().PFF.PZB);
        this.PZk.PZh = true;
      }
      AppMethodBeat.o(205641);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      Integer localInteger = null;
      AppMethodBeat.i(205640);
      Log.i(this.PZk.TAG, "onPageCommitVisible, url = %s", new Object[] { paramString });
      h localh;
      if (!this.PZk.PZg)
      {
        this.PZk.getController().pHS.evaluateJavascript(kotlin.n.n.bHx("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + this.PZk.getController().PFY.QAx + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + this.PZk.PZc + ",\n                    prefetch:" + this.PZk.PZb + ",\n                    predns:" + this.PZk.PZd + "\n                })\n                return p.wx.info;\n            })(window.performance);"), (ValueCallback)new a(this));
        this.PZk.PZg = true;
        if (this.PZk.PZa != null)
        {
          localh = h.IzE;
          paramWebView = this.PZk.PZa;
          if (paramWebView == null) {
            break label383;
          }
        }
      }
      label383:
      for (paramWebView = Integer.valueOf(paramWebView.kqZ);; paramWebView = null)
      {
        Object localObject1 = this.PZk.PZa;
        if (localObject1 != null)
        {
          localObject2 = ((f.b)localObject1).url;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        Object localObject2 = this.PZk.PZa;
        if (localObject2 != null) {
          localInteger = Integer.valueOf(((f.b)localObject2).svw);
        }
        localh.a(21075, new Object[] { paramWebView, paramString, localObject1, Integer.valueOf(6), localInteger });
        if ((paramString != null) && (!this.PZk.PZi) && (this.PZk.getController().PFF.PZD != com.tencent.mm.plugin.webview.i.c.PZE))
        {
          paramWebView = o.QAC;
          o.a(this.PZk.getController().PFF.PZC, this.PZk.getController().cDu(), d.PZM, this.PZk.getController().PFF.PZD, this.PZk.getController().PFF.PZB);
          this.PZk.PZi = true;
        }
        AppMethodBeat.o(205640);
        return;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    static final class a<T>
      implements ValueCallback<String>
    {
      a(a.c paramc) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "webview-sdk_release"})
  public static final class d
    extends j
  {
    public final void a(com.tencent.mm.plugin.webview.k.n paramn)
    {
      AppMethodBeat.i(205258);
      p.k(paramn, "performanceHelper");
      Object localObject = this.PZk;
      String str = ((a)localObject).getController().PFK;
      localObject = ((a)localObject).PZa;
      if (localObject != null) {}
      for (localObject = ((f.b)localObject).url;; localObject = null)
      {
        paramn.PZb = p.h(str, localObject);
        AppMethodBeat.o(205258);
        return;
      }
    }
    
    public final void b(com.tencent.mm.plugin.webview.k.n paramn)
    {
      AppMethodBeat.i(205259);
      p.k(paramn, "performanceHelper");
      com.tencent.mm.plugin.brandservice.a.f localf = this.PZk.gWK();
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        p.bGy("controller");
      }
      com.tencent.mm.plugin.webview.i.f.a(paramn, localf.app(localBaseWebViewController.cDu()));
      AppMethodBeat.o(205259);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.a
 * JD-Core Version:    0.7.0.1
 */