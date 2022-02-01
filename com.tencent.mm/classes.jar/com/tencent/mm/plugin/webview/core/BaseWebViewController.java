package com.tencent.mm.plugin.webview.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.o.a;
import com.tencent.mm.plugin.webview.e.c.a;
import com.tencent.mm.plugin.webview.e.g.b;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.q;
import d.a.ae;
import d.a.ak;
import d.aa;
import d.g.a.m;
import d.g.b.w;
import d.n.n;
import d.v;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlinx.coroutines.bc;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_SAP_STATUS", "getPAGE_SAP_STATUS", "()Ljava/util/Set;", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", "listener", "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canLoadUrl", "url", "canShowRefresh", "checkStatus", "check", "dealSPAUpdate", "destroy", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", "request", "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCallBackUrl", "getShareUrl", "getStatusListener", "hasStatus", "init", "initEnviroment", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onUrlRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeInvoker", "removeStatus", "resetActions", "resetPageActions", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"})
public abstract class BaseWebViewController
  extends com.tencent.xweb.ab
  implements com.tencent.mm.plugin.webview.e.a<aoj>
{
  public static final b ALz = new b((byte)0);
  private final d.f AKF;
  private final d.f AKG;
  public String AKH;
  private final d.f AKI;
  String AKJ;
  public String AKK;
  private String AKL;
  private boolean AKM;
  public boolean AKN;
  private final d.f AKO;
  private final d.f AKP;
  private final d.f AKQ;
  public final Map<String, String> AKR;
  private final d.f AKS;
  private final boolean AKT;
  public final k AKU;
  public final com.tencent.mm.plugin.webview.j.h AKV;
  final ConcurrentLinkedDeque<j> AKW;
  private final ConcurrentLinkedDeque<e> AKX;
  public final ConcurrentLinkedDeque<i> AKY;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<d.g.a.a<d.y>>> AKZ;
  public boolean ALa;
  boolean ALb;
  private final d.f ALc;
  final int ALd;
  public final int ALe;
  public final int ALf;
  protected final int ALg;
  final int ALh;
  private final int ALi;
  final int ALj;
  final int ALk;
  final int ALl;
  private final Set<Integer> ALm;
  private final ConcurrentLinkedDeque<d.o<ControllerAction, d.g.a.a<d.y>>> ALn;
  private final ConcurrentLinkedDeque<d.o<PageAction, d.g.a.a<d.y>>> ALo;
  private final HashSet<Integer> ALp;
  private final HashSet<Integer> ALq;
  private final HashSet<String> ALr;
  private final HashSet<String> ALs;
  public final boolean ALt;
  c ALu;
  private boolean ALv;
  private final d.f ALw;
  final c ALx;
  private Set<String> ALy;
  protected String bob;
  protected Intent intent;
  private final d.f jgk;
  public com.tencent.mm.plugin.webview.stub.e kxf;
  public final com.tencent.mm.plugin.webview.e.g kxg;
  private final List<e> nhe;
  public final MMWebView nhy;
  
  public BaseWebViewController(MMWebView paramMMWebView, c paramc, Set<String> paramSet)
  {
    this.nhy = paramMMWebView;
    this.ALx = paramc;
    this.ALy = paramSet;
    this.AKF = d.g.E((d.g.a.a)new a(this));
    this.AKG = d.g.E((d.g.a.a)new o(this));
    this.AKI = d.g.E((d.g.a.a)g.ALM);
    this.bob = "";
    this.AKJ = "";
    this.AKK = "";
    this.AKL = "";
    this.AKO = d.g.E((d.g.a.a)new w(this));
    this.AKP = d.g.E((d.g.a.a)new x(this));
    this.AKQ = d.g.E((d.g.a.a)new p(this));
    this.jgk = d.g.E((d.g.a.a)u.ALP);
    this.kxg = new com.tencent.mm.plugin.webview.e.g((g.b)new ad(this));
    this.AKR = ((Map)new HashMap());
    this.AKS = d.g.E((d.g.a.a)new y(this));
    this.AKT = true;
    this.AKU = ((k)new z(this));
    this.AKV = new com.tencent.mm.plugin.webview.j.h();
    this.AKW = new ConcurrentLinkedDeque();
    this.AKX = new ConcurrentLinkedDeque();
    this.AKY = new ConcurrentLinkedDeque();
    this.AKZ = new ConcurrentHashMap();
    this.ALc = d.g.E((d.g.a.a)new r(this));
    this.ALd = -1;
    this.ALe = -2;
    this.ALf = -3;
    this.ALg = -10;
    this.ALh = 1;
    this.ALi = 2;
    this.ALj = 10;
    this.ALk = 11;
    this.ALl = 12;
    this.ALm = ak.setOf(new Integer[] { Integer.valueOf(this.ALk), Integer.valueOf(this.ALl) });
    this.nhe = d.a.j.mutableListOf(new e[] { new e(w.bk(Init.class), (d.g.a.a)new h((BaseWebViewController)this)), new e(w.bk(Inject.class), (d.g.a.a)new i(this)), new e(w.bk(Bind.class), (d.g.a.a)new j((BaseWebViewController)this)), new e(w.bk(Auth.class), (d.g.a.a)new k(this)), new e(w.bk(Ready.class), (d.g.a.a)new l(this)), new e(w.bk(Start.class), (d.g.a.a)new m(this)), new e(w.bk(SPAUpdated.class), (d.g.a.a)new n(this)) });
    this.ALn = new ConcurrentLinkedDeque();
    this.ALo = new ConcurrentLinkedDeque();
    this.ALp = new HashSet();
    this.ALq = new HashSet();
    this.ALr = new HashSet();
    this.ALs = new HashSet();
    this.ALt = eiW().ekU();
    this.ALw = d.g.E((d.g.a.a)ac.ALU);
  }
  
  private final String GM(String paramString)
  {
    if (!PQ(paramString)) {
      paramString = this.AKK;
    }
    for (;;)
    {
      String str = paramString;
      if (n.aC((CharSequence)paramString))
      {
        str = paramString;
        if (Ss(this.ALf)) {
          str = bEx();
        }
      }
      return str;
    }
  }
  
  private boolean St(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!aa.JfW) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.ALq.remove(Integer.valueOf(paramInt));
    return bool;
  }
  
  private final <T extends WebAction> void a(Iterable<? extends d.o<? extends T, ? extends d.g.a.a<d.y>>> paramIterable, Set<String> paramSet, String paramString)
  {
    for (;;)
    {
      WebAction localWebAction;
      boolean bool;
      try
      {
        Iterator localIterator = paramIterable.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        paramIterable = (d.o)localIterator.next();
        localWebAction = (WebAction)paramIterable.first;
        paramIterable = (d.g.a.a)paramIterable.second;
        if (!(localWebAction instanceof PageAction)) {
          break label232;
        }
        if ((paramString != null) && (((PageAction)localWebAction).verify(paramString)))
        {
          bool = true;
          if (!bool) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ad.i(eiT(), "verify WebAction: " + w.bk(localWebAction.getClass()).getSimpleName() + " start");
          if (!localWebAction.getKeep()) {
            localIterator.remove();
          }
          com.tencent.mm.ad.c.g(paramIterable);
          String str = w.bk(localWebAction.getClass()).getSimpleName();
          paramIterable = str;
          if (str == null) {
            paramIterable = "";
          }
          paramSet.add(paramIterable);
          com.tencent.mm.sdk.platformtools.ad.v(eiT(), "verifyActions: " + w.bk(localWebAction.getClass()).getSimpleName() + " end");
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label232:
      if ((localWebAction instanceof ControllerAction)) {
        bool = ((ControllerAction)localWebAction).verify();
      } else {
        bool = false;
      }
    }
  }
  
  public static final String aQ(Intent paramIntent)
  {
    return b.aQ(paramIntent);
  }
  
  private final String avq(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aC((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!com.tencent.luggage.h.c.a(paramString, "about:blank", true)))
      {
        localObject = paramString;
        if (!com.tencent.luggage.h.c.a(paramString, "data:text/html;charset=utf-8", true)) {}
      }
      else
      {
        localObject = this.bob;
      }
      return localObject;
    }
  }
  
  private final void avt(String paramString)
  {
    try
    {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "resetPageActions clear status:" + paramString + ", [" + d.a.j.a((Iterable)this.ALp, (CharSequence)",", null, null, 0, null, null, 62) + "] actions: [" + d.a.j.a((Iterable)this.ALr, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      this.ALp.clear();
      this.ALr.clear();
      this.ALo.clear();
      Iterator localIterator = ((Iterable)bEB()).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = d.l.a.c.d(locale.ALG);
        ((WebAction)localObject).setController((BaseWebViewController)this);
        localObject = (WebAction)localObject;
        if ((localObject instanceof PageAction)) {
          this.ALo.add(d.u.P(localObject, locale.gml));
        }
      }
      avr(paramString);
    }
    finally {}
    this.AKL = "";
  }
  
  private final int avu(String paramString)
  {
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    while (localIterator.hasNext())
    {
      int i = ((j)localIterator.next()).avu(paramString);
      if (i != -1) {
        return i;
      }
    }
    return eiW().axn(paramString);
  }
  
  private final com.tencent.mm.plugin.webview.c.i eiY()
  {
    return (com.tencent.mm.plugin.webview.c.i)this.AKO.getValue();
  }
  
  private final void ejc()
  {
    for (;;)
    {
      e locale;
      Object localObject2;
      try
      {
        com.tencent.mm.sdk.platformtools.ad.i(eiT(), "resetActions");
        this.ALq.clear();
        this.ALs.clear();
        this.ALn.clear();
        this.ALp.clear();
        this.ALr.clear();
        this.ALo.clear();
        Iterator localIterator = ((Iterable)bEB()).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locale = (e)localIterator.next();
        localObject2 = d.l.a.c.d(locale.ALG);
        ((WebAction)localObject2).setController((BaseWebViewController)this);
        localObject2 = (WebAction)localObject2;
        if ((localObject2 instanceof ControllerAction))
        {
          this.ALn.add(d.u.P(localObject2, locale.gml));
          continue;
        }
        if (!(localObject2 instanceof PageAction)) {
          continue;
        }
      }
      finally {}
      this.ALo.add(d.u.P(localObject2, locale.gml));
    }
  }
  
  private final void l(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (this.ALa) && (paramWebView.canGoBack()))
    {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "clearHistory :".concat(String.valueOf(paramString)));
      paramWebView.clearHistory();
      this.ALa = false;
    }
  }
  
  public final void A(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString1 = this.nhy.getSettings();
      if (paramString1 != null) {
        paramString1.setJavaScriptEnabled(false);
      }
      this.nhy.loadData(paramString2, "text/html", "utf-8");
    }
  }
  
  public final void D(String paramString, Map<String, String> paramMap)
  {
    d.g.b.k.h(paramString, "baseUrl");
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace loadCacheUrl baseUrl ".concat(String.valueOf(paramString)));
    this.bob = paramString;
    this.nhy.loadUrl(paramString, paramMap);
    avs(paramString);
    Sr(this.ALg);
  }
  
  protected boolean PP(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    return true;
  }
  
  protected boolean PQ(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    if (!n.aC((CharSequence)paramString)) {}
    for (int i = 1; (i != 0) && (!n.mA(paramString, "data:text/html;charset=utf-8")) && (!n.mA(paramString, "about:blank")) && ((!Ss(this.ALg)) || (!n.mA(paramString, "https://mp.weixin.qq.com/__tmpl__/"))); i = 0) {
      return true;
    }
    return false;
  }
  
  public final ConcurrentLinkedDeque<d.g.a.a<d.y>> Sq(int paramInt)
  {
    ConcurrentLinkedDeque localConcurrentLinkedDeque2 = (ConcurrentLinkedDeque)this.AKZ.get(Integer.valueOf(paramInt));
    ConcurrentLinkedDeque localConcurrentLinkedDeque1 = localConcurrentLinkedDeque2;
    if (localConcurrentLinkedDeque2 == null)
    {
      localConcurrentLinkedDeque1 = new ConcurrentLinkedDeque();
      ((Map)this.AKZ).put(Integer.valueOf(paramInt), localConcurrentLinkedDeque1);
    }
    return localConcurrentLinkedDeque1;
  }
  
  public final void Sr(int paramInt)
  {
    int i;
    for (;;)
    {
      try
      {
        boolean bool = ejf();
        if (bool) {
          return;
        }
        if (paramInt < 0)
        {
          i = 1;
          if ((!aa.JfW) || (i != 0)) {
            break;
          }
          throw ((Throwable)new AssertionError("Assertion failed"));
        }
      }
      finally {}
      i = 0;
    }
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "checkStatus:" + paramInt + " to [" + d.a.j.a((Iterable)this.ALq, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)this.ALp, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)this.ALr, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    this.ALq.add(Integer.valueOf(paramInt));
    a((Iterable)this.ALn, (Set)this.ALs, null);
    CharSequence localCharSequence = (CharSequence)this.AKJ;
    if (localCharSequence != null) {
      if (n.aC(localCharSequence)) {
        break label289;
      }
    }
    for (;;)
    {
      if (i == 0) {
        a((Iterable)this.ALo, (Set)this.ALr, this.AKJ);
      }
      d.a.j.a((Iterable)Sq(paramInt), (d.g.a.b)q.ALN);
      break;
      i = 0;
      continue;
      label289:
      i = 1;
    }
  }
  
  public final boolean Ss(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!aa.JfW) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.ALq.contains(Integer.valueOf(paramInt));
    return bool;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, null);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest);
    }
    return localWebResourceResponse1;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, paramBundle);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    }
    return localWebResourceResponse1;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "errMsg");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      co(this.ALi, paramString1);
      Iterator localIterator = ((Iterable)this.AKY).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).d(paramInt1, paramString1, paramInt2, paramString2);
      }
      this.AKH = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, aoj paramaoj)
  {
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "fullUrl");
    d.g.b.k.h(paramaoj, "response");
    com.tencent.mm.sdk.platformtools.ad.d(eiT(), "WebView-Trace onPermissionUpdate:" + paramString1 + ", fullUrl:" + paramString2);
    if (ejf()) {
      com.tencent.mm.sdk.platformtools.ad.d(eiT(), "onPermissionUpdate destroyCalled");
    }
    do
    {
      return;
      this.kxg.a(paramString1, eiW().axk(paramString1), eiW().axl(paramString1));
      this.kxg.a(paramString2, eiW().axk(paramString2), eiW().axl(paramString2));
      Iterator localIterator = ((Iterable)this.AKY).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).c(paramString1, paramaoj);
      }
      co(this.ALh, paramString1);
      co(this.ALh, paramString2);
    } while (!d.g.b.k.g(paramString1, this.AKL));
    co(this.ALl, paramString1);
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebAction:Ready onPermissionUpdated Patch: " + this.AKL);
  }
  
  public final void a(e parame)
  {
    d.g.b.k.h(parame, "listener");
    if (!this.AKX.contains(parame)) {
      this.AKX.add(parame);
    }
  }
  
  public final void a(i parami)
  {
    try
    {
      d.g.b.k.h(parami, "listener");
      if (!this.AKY.contains(parami))
      {
        BaseWebViewController localBaseWebViewController = (BaseWebViewController)this;
        d.g.b.k.h(localBaseWebViewController, "<set-?>");
        parami.controller = localBaseWebViewController;
        this.AKY.add(parami);
        if (d.a.j.a((Iterable)this.ALs, w.bk(Bind.class).getSimpleName()))
        {
          com.tencent.mm.sdk.platformtools.ad.i(eiT(), "Abe-Debug Patch Call onBind");
          parami.dvS();
        }
      }
      return;
    }
    finally
    {
      parami = finally;
      throw parami;
    }
  }
  
  public final void a(j paramj)
  {
    d.g.b.k.h(paramj, "interceptor");
    this.AKW.add(paramj);
    Object localObject = paramj.ejF();
    if (localObject != null) {
      a((e)localObject);
    }
    localObject = paramj.ejG();
    if (localObject != null) {
      a((i)localObject);
    }
    paramj.i(this);
  }
  
  public void a(com.tencent.mm.plugin.webview.stub.e parame) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (!Ss(this.ALf)) {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "onReceivedError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.AKX).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.a(paramWebView, paramInt, paramString1, paramString2);
        }
      }
    }
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    if (!Ss(this.ALf)) {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "onReceivedHttpError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.AKX).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        }
      }
    }
  }
  
  public void a(WebView paramWebView, q paramq, SslError paramSslError)
  {
    super.a(paramWebView, paramq, paramSslError);
    if (!Ss(this.ALf)) {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "onReceivedSslError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.AKX).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.a(paramWebView, paramq, paramSslError);
        }
      }
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace doUpdateVisitedHistory, url = " + paramString + ", isReload = " + paramBoolean);
    if (n.mA(paramString, "data:text/html;charset=utf-8"))
    {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "url starts with data:text, url : ".concat(String.valueOf(paramString)));
      return;
    }
    if ((com.tencent.luggage.h.c.z(paramString, "about:blank")) || (com.tencent.luggage.h.c.z(paramString, "file:///android_asset/")))
    {
      com.tencent.mm.sdk.platformtools.ad.e(eiT(), "doUpdateVisitedHistory, url is invalid");
      return;
    }
    if ((Ss(this.ALg)) && (com.tencent.luggage.h.c.z(paramString, "https://mp.weixin.qq.com/__tmpl__/")))
    {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "doUpdateVisitedHistory, url is HARDCODE_URL");
      return;
    }
    super.a(paramWebView, paramString, paramBoolean);
    paramBoolean = x.aCS(paramString);
    String str = paramString;
    if (paramBoolean)
    {
      str = paramString;
      if (((Boolean)this.ALw.getValue()).booleanValue()) {
        str = paramWebView.getUrl();
      }
    }
    if (paramBoolean) {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace doUpdateVisitedHistory isBaseUrl:" + paramBoolean + ", url=" + str);
    }
    d.g.b.k.g(str, "url");
    if (!d.g.b.k.g(this.AKJ, str))
    {
      if (this.kxg.has(str)) {
        co(this.ALl, str);
      }
      this.AKL = str;
    }
    if (!this.ALx.ALF) {
      aD(str, false);
    }
    this.AKH = str;
    paramString = ((Iterable)this.AKX).iterator();
    while (paramString.hasNext())
    {
      e locale = (e)paramString.next();
      if (isStarted()) {
        locale.avy(str);
      }
    }
    l(paramWebView, str);
  }
  
  protected boolean a(int paramInt, String paramString, aoj paramaoj)
  {
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramaoj, "resp");
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).d(paramString, paramaoj)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "shouldOverrideUrlLoading: ".concat(String.valueOf(paramString)));
    com.tencent.mm.sdk.platformtools.ad.d(eiT(), "doShouldOverrideUrlLoading url:".concat(String.valueOf(paramString)));
    boolean bool1;
    if (k(paramWebView, paramString))
    {
      bool1 = bool2;
      if (!bool1) {
        this.AKH = paramString;
      }
      return bool1;
    }
    label150:
    if (avu(paramString) == 2)
    {
      bool1 = true;
      label89:
      if (aD(paramString, bool1))
      {
        if (this.ALx.ALF) {
          break label181;
        }
        switch (avu(paramString))
        {
        default: 
          i = 0;
          if (i == 0) {
            break;
          }
        }
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        break;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label89;
      i = 1;
      break label150;
    }
  }
  
  public final String aAu()
  {
    return eiW().awT(getCurrentUrl());
  }
  
  protected boolean aD(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    d.g.b.k.h(paramString, "url");
    if (a(this, paramString, paramBoolean, 0, 4) == c.a.Bbb) {
      bool = true;
    }
    return bool;
  }
  
  public final ap aFm()
  {
    return (ap)this.jgk.getValue();
  }
  
  public final void an(Intent paramIntent)
  {
    d.g.b.k.h(paramIntent, "intent");
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "start");
    this.intent = paramIntent;
    com.tencent.mm.plugin.webview.e.g localg = this.kxg;
    Parcelable localParcelable2 = paramIntent.getParcelableExtra("hardcode_jspermission");
    Parcelable localParcelable1 = localParcelable2;
    if (!(localParcelable2 instanceof JsapiPermissionWrapper)) {
      localParcelable1 = null;
    }
    JsapiPermissionWrapper localJsapiPermissionWrapper = (JsapiPermissionWrapper)localParcelable1;
    localParcelable2 = paramIntent.getParcelableExtra("hardcode_general_ctrl");
    localParcelable1 = localParcelable2;
    if (!(localParcelable2 instanceof GeneralControlWrapper)) {
      localParcelable1 = null;
    }
    localg.a(localJsapiPermissionWrapper, (GeneralControlWrapper)localParcelable1);
    this.AKV.Bxs = paramIntent.getLongExtra("startTime", 0L);
    kotlinx.coroutines.d.a((kotlinx.coroutines.ad)bc.Kem, null, (m)new aa(this, null), 3);
  }
  
  protected final void avr(String paramString)
  {
    d.g.b.k.h(paramString, "value");
    if (PP(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.d(eiT(), "WebView-Trace startUrl:".concat(String.valueOf(paramString)));
      this.AKJ = paramString;
    }
  }
  
  protected final void avs(String paramString)
  {
    d.g.b.k.h(paramString, "value");
    if (PQ(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.d(eiT(), "WebView-Trace commitUrl:".concat(String.valueOf(paramString)));
      this.AKK = paramString;
    }
  }
  
  public final boolean avv(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    if (com.tencent.mm.platformtools.ab.hVz)
    {
      com.tencent.mm.sdk.platformtools.ad.w(eiT(), "skipLoadUrlCheck");
      return true;
    }
    if (this.ALx.ALC)
    {
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "file://", true))
    {
      Iterator localIterator = ((Iterable)eiV()).iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.luggage.h.c.a(paramString, (String)localIterator.next(), true)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  protected final boolean avw(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    if (!avv(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.f(eiT(), "forceQuitOnUrlForbidden, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = ((Iterable)this.AKY).iterator();
      while (paramString.hasNext()) {
        ((i)paramString.next()).ejB();
      }
      return true;
    }
    return false;
  }
  
  protected WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramWebResourceRequest, "request");
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "shouldInterceptRequest, url = " + paramWebResourceRequest.getUrl() + ", method = " + paramWebResourceRequest.getMethod() + ", isForMainFrame = " + paramWebResourceRequest.isForMainFrame());
    Object localObject = paramWebResourceRequest.getUrl().toString();
    d.g.b.k.g(localObject, "request.url.toString()");
    if (avw((String)localObject)) {
      return null;
    }
    if ((com.tencent.mm.cr.d.kr(getContext())) && (paramBundle != null)) {}
    try
    {
      int i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        com.tencent.mm.sdk.platformtools.ad.i(eiT(), "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        paramBundle = paramWebResourceRequest.getUrl().toString();
        d.g.b.k.g(paramBundle, "request.url.toString()");
        k(paramBundle, false, 5);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.w(eiT(), "get resource type failed Exception ; " + paramBundle.getMessage());
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.w(eiT(), "get resource type failed Throwable ; " + paramBundle.getMessage());
      }
    }
    paramBundle = ((Iterable)this.AKW).iterator();
    while (paramBundle.hasNext())
    {
      localObject = ((j)paramBundle.next()).b(paramWebView, paramWebResourceRequest);
      if (localObject != null) {
        return localObject;
      }
    }
    return null;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    if (ejf())
    {
      com.tencent.mm.sdk.platformtools.ad.w(eiT(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = GM(str);
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace onPageFinished: " + paramString + ", callbackUrl:" + str);
      if (((paramWebView == null) || (paramWebView.supportFeature(2006) != true)) && (this.ALb)) {
        avs(str);
      }
      super.b(paramWebView, paramString);
      if ((!Ss(this.ALj)) && (!bEH()))
      {
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1200L, 104L, 1L, false);
        com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
      }
      co(this.ALk, avq(paramString));
      Iterator localIterator = ((Iterable)this.AKX).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.b(paramWebView, str);
        }
      }
      l(paramWebView, paramString);
      return;
    }
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    if (ejf())
    {
      com.tencent.mm.sdk.platformtools.ad.w(eiT(), "ActivityFinished");
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace onPageStarted: ".concat(String.valueOf(paramString)));
    this.ALb = false;
    this.AKH = paramString;
    avt(paramString);
    Iterator localIterator = ((Iterable)this.AKX).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (isStarted()) {
        locale.m(paramWebView, GM(paramString));
      }
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public boolean b(int paramInt, String paramString, aoj paramaoj)
  {
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramaoj, "response");
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(paramInt)));
    this.nhy.setA8keyReason(paramInt);
    Object localObject1 = this.AKR;
    ((Map)localObject1).clear();
    Object localObject2 = paramaoj.Dqh;
    d.g.b.k.g(localObject2, "response.HttpHeader");
    int i;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      localObject2 = com.tencent.mm.plugin.webview.e.c.gx((List)paramaoj.Dqh);
      d.g.b.k.g(localObject2, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      ((Map)localObject1).putAll((Map)localObject2);
    }
    label134:
    label327:
    label459:
    for (;;)
    {
      if (!a(paramInt, paramString, paramaoj)) {
        break label461;
      }
      return true;
      i = 0;
      break;
      localObject2 = this.intent;
      if (localObject2 == null) {
        d.g.b.k.aPZ("intent");
      }
      if (((Intent)localObject2).getBooleanExtra("k_has_http_header", false))
      {
        com.tencent.mm.sdk.platformtools.ad.i(eiT(), "use intent httpheader info");
        localObject2 = this.intent;
        if (localObject2 == null) {
          d.g.b.k.aPZ("intent");
        }
        localObject2 = ((Intent)localObject2).getStringArrayExtra("geta8key_result_http_header_key_list");
        Object localObject3 = this.intent;
        if (localObject3 == null) {
          d.g.b.k.aPZ("intent");
        }
        localObject3 = ((Intent)localObject3).getStringArrayExtra("geta8key_result_http_header_value_list");
        Intent localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.k.aPZ("intent");
        }
        localIntent.putExtra("k_has_http_header", false);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.k.aPZ("intent");
        }
        localIntent.putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.k.aPZ("intent");
        }
        localIntent.putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        if ((localObject2 != null) && (localObject3 != null))
        {
          if (localObject2.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label443;
            }
            i = 1;
            label335:
            if (i == 0) {
              break label447;
            }
            if (localObject3.length != 0) {
              break label449;
            }
            i = 1;
            label349:
            if (i != 0) {
              break label455;
            }
          }
          for (i = 1;; i = 0)
          {
            if ((i == 0) || (localObject2.length != localObject3.length)) {
              break label459;
            }
            int j = localObject2.length;
            i = 0;
            while (i < j)
            {
              localIntent = localObject2[i];
              d.g.b.k.g(localIntent, "httpHeaderKey[i]");
              Object localObject4 = localObject3[i];
              d.g.b.k.g(localObject4, "httpHeaderValue[i]");
              ((Map)localObject1).put(localIntent, localObject4);
              i += 1;
            }
            break;
            i = 0;
            break label327;
            i = 0;
            break label335;
            break;
            i = 0;
            break label349;
          }
        }
      }
    }
    label443:
    label447:
    label449:
    label455:
    label461:
    localObject1 = ((Iterable)this.AKY).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((i)((Iterator)localObject1).next()).b(paramString, paramaoj);
    }
    return false;
  }
  
  public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramString1, "description");
    d.g.b.k.h(paramString2, "failingUrl");
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).c(paramWebView, paramInt, paramString1, paramString2);
    }
    return super.b(paramWebView, paramInt, paramString1, paramString2);
  }
  
  protected boolean bEA()
  {
    return false;
  }
  
  protected List<e> bEB()
  {
    return this.nhe;
  }
  
  protected void bEC()
  {
    a((j)new com.tencent.mm.plugin.webview.f.a());
    a((j)new com.tencent.mm.plugin.webview.k.e());
    this.nhy.setWebViewClient((com.tencent.xweb.ab)this);
    MMWebView localMMWebView = this.nhy;
    Object localObject = v.ALQ;
    com.tencent.mm.plugin.webview.j.i.f(localMMWebView);
    com.tencent.xweb.y localy = localMMWebView.getSettings();
    localy.setJavaScriptEnabled(((Boolean)this.ALx.ALB.ALJ.getValue()).booleanValue());
    localy.setPluginsEnabled(((Boolean)this.ALx.ALB.ALH.getValue()).booleanValue());
    localy.frg();
    localy.setBuiltInZoomControls(((Boolean)this.ALx.ALB.ALI.getValue()).booleanValue());
    localy.setUseWideViewPort(true);
    localy.setLoadWithOverviewMode(true);
    localy.fqZ();
    localy.fqY();
    localy.setGeolocationEnabled(true);
    localy.setJavaScriptCanOpenWindowsAutomatically(true);
    localy.fri();
    localy.fre();
    localObject = localMMWebView.getContext().getDir("webviewcache", 0);
    d.g.b.k.g(localObject, "context.getDir(\"webviewc…e\", Context.MODE_PRIVATE)");
    localy.setAppCachePath(((File)localObject).getAbsolutePath());
    localy.frd();
    localy.frf();
    localy.setDatabasePath(com.tencent.mm.loader.j.b.ahY() + "databases/");
    String str = localy.getUserAgentString();
    d.g.b.k.g(str, "currentUa");
    if (!n.f((CharSequence)str, (CharSequence)" MicroMessenger/"))
    {
      o.a locala = (o.a)com.tencent.luggage.a.e.K(o.a.class);
      localObject = locala;
      if (locala == null) {
        localObject = (o.a)new com.tencent.mm.plugin.appbrand.luggage.b.f(localMMWebView.getContext());
      }
      localy.setUserAgentString(com.tencent.mm.plugin.appbrand.aa.o.a(localMMWebView.getContext(), str, (o.a)localObject));
    }
    if (!((Boolean)this.ALx.ALB.ALK.getValue()).booleanValue())
    {
      localMMWebView.setVerticalScrollBarEnabled(false);
      localMMWebView.setHorizontalScrollBarEnabled(false);
    }
    com.tencent.xweb.c.fqC().fqD();
    com.tencent.xweb.c.fqC().e((WebView)localMMWebView);
    localObject = v.ALQ;
    localObject = localMMWebView.getContext().getSystemService("window");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    v.b((WindowManager)localObject);
    if (this.nhy.feU())
    {
      localObject = this.nhy.getUrl();
      d.g.b.k.g(localObject, "viewWV.url");
      avs((String)localObject);
    }
    this.AKV.bG("onTryBindServiceStart", System.currentTimeMillis());
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace tryBindService");
    localObject = l.ANv;
    l.a(true, eiU(), (d)new ab(this));
    this.AKV.bG("onTryBindServiceEnd", System.currentTimeMillis());
  }
  
  protected void bED() {}
  
  protected boolean bEE()
  {
    return true;
  }
  
  public boolean bEH()
  {
    return (Ss(this.ALg)) && (d.g.b.k.g(this.bob, this.AKK));
  }
  
  public String bEx()
  {
    try
    {
      Object localObject = this.intent;
      if (localObject == null) {
        d.g.b.k.aPZ("intent");
      }
      localObject = b.aQ((Intent)localObject);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      onFinish();
    }
    return "";
  }
  
  protected boolean bEy()
  {
    return this.AKT;
  }
  
  protected boolean bEz()
  {
    return false;
  }
  
  protected void bFs()
  {
    if (!this.ALv)
    {
      eji();
      this.ALv = true;
    }
    Iterator localIterator = ((Iterable)this.AKY).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bFs();
    }
  }
  
  public final void be(int paramInt, String paramString)
  {
    d.g.b.k.h(paramString, "reqUrl");
    this.AKV.bG("getA8KeyEnd", System.currentTimeMillis());
    Iterator localIterator = ((Iterable)this.AKY).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).avG(paramString);
    }
  }
  
  public final void bf(int paramInt, String paramString)
  {
    d.g.b.k.h(paramString, "reqUrl");
    this.AKV.bG("getA8KeyStart", System.currentTimeMillis());
    if ((d.g.b.k.g(this.AKL, paramString) ^ true))
    {
      Iterator localIterator = ((Iterable)this.AKY).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).bf(paramInt, paramString);
      }
    }
  }
  
  protected final void co(int paramInt, String paramString)
  {
    for (;;)
    {
      label42:
      try
      {
        d.g.b.k.h(paramString, "url");
        boolean bool = ejf();
        if (bool) {
          return;
        }
        if (paramInt <= 0) {
          break label76;
        }
        if (!n.aC((CharSequence)paramString)) {
          break label71;
        }
        i = 1;
      }
      finally {}
      if ((aa.JfW) && (i == 0))
      {
        throw ((Throwable)new AssertionError("Assertion failed"));
        label71:
        i = 0;
      }
      label76:
      while (i != 0)
      {
        i = 0;
        break label42;
        if ((d.g.b.k.g(paramString, this.AKJ)) || ((this.ALm.contains(Integer.valueOf(paramInt))) && (d.g.b.k.g(paramString, this.AKL))))
        {
          com.tencent.mm.sdk.platformtools.ad.i(eiT(), "checkStatus:" + paramInt + ' ' + paramString + " to [" + d.a.j.a((Iterable)this.ALq, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)this.ALp, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)this.ALr, (CharSequence)",", null, null, 0, null, null, 62) + ']');
          this.ALp.add(Integer.valueOf(paramInt));
          a((Iterable)this.ALo, (Set)this.ALr, this.AKJ);
          break;
        }
        com.tencent.mm.sdk.platformtools.ad.w(eiT(), "checkStatus skip: " + paramInt + ", url=" + paramString + ", startUrl=" + this.AKJ);
        break;
      }
      int i = 1;
    }
  }
  
  public final boolean d(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    int i = 0;
    if ((paramWebResourceRequest == null) || (paramWebView == null)) {
      return false;
    }
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramWebResourceRequest, "request");
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramWebResourceRequest, "request");
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    j.a locala;
    while (localIterator.hasNext())
    {
      locala = ((j)localIterator.next()).c(paramWebView, paramWebResourceRequest);
      if (locala.ANt) {
        if (!locala.ANt) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = locala.result;; bool = false)
    {
      if (bool) {
        i = 1;
      }
      if (i != 0) {
        break label142;
      }
      return super.d(paramWebView, paramWebResourceRequest);
      locala = new j.a(false, false);
      break;
    }
    label142:
    return true;
  }
  
  public final void destroy()
  {
    com.tencent.mm.ad.c.g((d.g.a.a)new s(this));
  }
  
  protected void dvS() {}
  
  public final void e(WebView paramWebView, String paramString)
  {
    if (ejf())
    {
      com.tencent.mm.sdk.platformtools.ad.w(eiT(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = GM(str);
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace onPageCommitVisible: " + paramString + ", callbackUrl:" + str);
      avs(str);
      super.e(paramWebView, paramString);
      Object localObject = f.ALW;
      if (!f.a.ejq()) {
        co(this.ALj, avq(paramString));
      }
      for (;;)
      {
        this.AKU.finish();
        localObject = ((Iterable)this.AKX).iterator();
        while (((Iterator)localObject).hasNext())
        {
          e locale = (e)((Iterator)localObject).next();
          if (isStarted()) {
            locale.e(paramWebView, str);
          }
        }
        com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView Page Commit Mock Enabled");
      }
      l(paramWebView, paramString);
      return;
    }
  }
  
  public final String eiT()
  {
    return (String)this.AKF.getValue();
  }
  
  protected abstract Class<? extends Service> eiU();
  
  protected abstract Set<String> eiV();
  
  public final com.tencent.mm.plugin.webview.e.c eiW()
  {
    return (com.tencent.mm.plugin.webview.e.c)this.AKI.getValue();
  }
  
  public final com.tencent.mm.plugin.webview.stub.e eiX()
  {
    com.tencent.mm.plugin.webview.stub.e locale = this.kxf;
    if (locale == null) {
      d.g.b.k.aPZ("invoker");
    }
    return locale;
  }
  
  public final int eiZ()
  {
    return ((Number)this.AKQ.getValue()).intValue();
  }
  
  public final Runnable eja()
  {
    return (Runnable)this.AKS.getValue();
  }
  
  public final String ejb()
  {
    return (String)this.ALc.getValue();
  }
  
  protected void ejd() {}
  
  public boolean eje()
  {
    return false;
  }
  
  public final boolean ejf()
  {
    return (this.AKN) || (this.AKM);
  }
  
  public final void ejg()
  {
    try
    {
      com.tencent.mm.plugin.webview.stub.e locale = this.kxf;
      if (locale == null) {
        d.g.b.k.aPZ("invoker");
      }
      if (locale != null)
      {
        locale = this.kxf;
        if (locale == null) {
          d.g.b.k.aPZ("invoker");
        }
        locale.Tn(eiZ());
        locale = this.kxf;
        if (locale == null) {
          d.g.b.k.aPZ("invoker");
        }
        locale.To(eiZ());
      }
      com.tencent.mm.sdk.platformtools.ad.i(eiT(), "removeInvoker ok");
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.w(eiT(), "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException)));
    }
  }
  
  public final boolean ejh()
  {
    return St(this.ALg);
  }
  
  protected void eji() {}
  
  protected void ejj() {}
  
  public final boolean ejk()
  {
    return !Ss(this.ALg);
  }
  
  public final void f(final String paramString, final d.g.a.b<? super String, d.y> paramb)
  {
    d.g.b.k.h(paramString, "script");
    com.tencent.mm.ad.c.g((d.g.a.a)new t(this, paramString, paramb));
  }
  
  protected final Context getContext()
  {
    Context localContext = this.nhy.getContext();
    d.g.b.k.g(localContext, "viewWV.context");
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    if (n.aC((CharSequence)this.AKL)) {
      return this.AKK;
    }
    return this.AKL;
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = this.intent;
    if (localIntent == null) {
      d.g.b.k.aPZ("intent");
    }
    return localIntent;
  }
  
  public final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    return (com.tencent.mm.plugin.webview.c.f)this.AKP.getValue();
  }
  
  protected final int getScreenOrientation()
  {
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.getScreenOrientation() != -1) {
        return localj.getScreenOrientation();
      }
    }
    return -1;
  }
  
  public final void init()
  {
    ejc();
    Sr(this.ALd);
    this.nhy.a((com.tencent.mm.ui.widget.i)new d());
  }
  
  protected final boolean isStarted()
  {
    try
    {
      boolean bool = d.a.j.a((Iterable)this.ALs, w.bk(Start.class).getSimpleName());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final j.a j(WebView paramWebView, String paramString)
  {
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramString, "url");
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    while (localIterator.hasNext())
    {
      j.a locala = ((j)localIterator.next()).n(paramWebView, paramString);
      if (locala.ANt) {
        return locala;
      }
    }
    return new j.a(false, false);
  }
  
  public final c.a k(String paramString, boolean paramBoolean, int paramInt)
  {
    d.g.b.k.h(paramString, "url");
    if (this.ALx.ALF)
    {
      com.tencent.mm.sdk.platformtools.ad.w(eiT(), "startGetA8Key neverGetA8Key ".concat(String.valueOf(paramString)));
      return c.a.Bba;
    }
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).avI(paramString)) {
        return c.a.BaZ;
      }
    }
    paramString = eiW().a(paramString, paramBoolean, paramInt, (com.tencent.mm.plugin.webview.e.a)this.AKG.getValue());
    d.g.b.k.g(paramString, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
    return paramString;
  }
  
  protected boolean k(WebView paramWebView, String paramString)
  {
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramString, "url");
    paramWebView = j(paramWebView, paramString);
    if (paramWebView.ANt) {
      return paramWebView.result;
    }
    return false;
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "WebView-Trace loadUrl url ".concat(String.valueOf(paramString)));
    if (paramBoolean)
    {
      this.nhy.loadUrl(paramString, (Map)ae.c(new d.o[] { d.u.P("Pragma", "no-cache"), d.u.P("Cache-Control", "no-cache") }));
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    if (i != 0)
    {
      this.nhy.loadUrl(paramString);
      return;
    }
    this.nhy.loadUrl(paramString, paramMap);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 1929	com/tencent/mm/plugin/webview/core/BaseWebViewController:AKM	Z
    //   7: aload_0
    //   8: getfield 1927	com/tencent/mm/plugin/webview/core/BaseWebViewController:AKN	Z
    //   11: ifne +7 -> 18
    //   14: aload_0
    //   15: invokevirtual 2013	com/tencent/mm/plugin/webview/core/BaseWebViewController:ejg	()V
    //   18: aload_0
    //   19: getfield 2015	com/tencent/mm/plugin/webview/core/BaseWebViewController:ALu	Lcom/tencent/mm/plugin/webview/core/c;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +27 -> 51
    //   27: aload_1
    //   28: checkcast 2017	java/io/Closeable
    //   31: astore_3
    //   32: aload_0
    //   33: invokevirtual 852	com/tencent/mm/plugin/webview/core/BaseWebViewController:eiT	()Ljava/lang/String;
    //   36: ldc_w 2019
    //   39: invokestatic 915	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 2025	d/y:JfV	Ld/y;
    //   45: astore_1
    //   46: aload_3
    //   47: aconst_null
    //   48: invokestatic 2030	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   51: aload_0
    //   52: invokevirtual 2032	com/tencent/mm/plugin/webview/core/BaseWebViewController:aFm	()Lcom/tencent/mm/sdk/platformtools/ap;
    //   55: aload_0
    //   56: invokevirtual 2034	com/tencent/mm/plugin/webview/core/BaseWebViewController:eja	()Ljava/lang/Runnable;
    //   59: invokevirtual 2037	com/tencent/mm/sdk/platformtools/ap:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   62: aload_0
    //   63: invokevirtual 2039	com/tencent/mm/plugin/webview/core/BaseWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   66: invokevirtual 2042	com/tencent/mm/plugin/webview/c/f:detach	()V
    //   69: aload_0
    //   70: invokespecial 1037	com/tencent/mm/plugin/webview/core/BaseWebViewController:eiY	()Lcom/tencent/mm/plugin/webview/c/i;
    //   73: invokevirtual 2043	com/tencent/mm/plugin/webview/c/i:detach	()V
    //   76: aload_0
    //   77: invokevirtual 784	com/tencent/mm/plugin/webview/core/BaseWebViewController:eiW	()Lcom/tencent/mm/plugin/webview/e/c;
    //   80: invokevirtual 2045	com/tencent/mm/plugin/webview/e/c:destroy	()V
    //   83: return
    //   84: astore_2
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_3
    //   89: aload_2
    //   90: invokestatic 2030	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: goto -8 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	BaseWebViewController
    //   22	24	1	localObject1	Object
    //   87	7	1	localObject2	Object
    //   95	1	1	localObject3	Object
    //   1	1	2	localObject4	Object
    //   84	6	2	localThrowable	Throwable
    //   31	58	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   32	46	84	java/lang/Throwable
    //   85	87	87	finally
    //   32	46	95	finally
  }
  
  protected final void onFinish()
  {
    Iterator localIterator = ((Iterable)this.AKY).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onFinish();
    }
  }
  
  public final void reload()
  {
    if ((this.nhy == null) || (bt.isNullOrNil(this.nhy.getUrl()))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      String str = this.nhy.getUrl();
      d.g.b.k.g(str, "viewWV.url");
      if (localj.PW(GM(str))) {
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ad.i(eiT(), "reload");
    this.nhy.reload();
  }
  
  protected final void setIntent(Intent paramIntent)
  {
    d.g.b.k.h(paramIntent, "<set-?>");
    this.intent = paramIntent;
  }
  
  protected final void te(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.AKY).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).te(paramBoolean);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Auth
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(189289);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(w.bk(BaseWebViewController.Inject.class), paramString)) && (waitFor(localBaseWebViewController.ALe)) && ((localBaseWebViewController.ALx.ALF) || (localBaseWebViewController.kxg.has(paramString)) || (waitFor(localBaseWebViewController.ALh, paramString))))
      {
        AppMethodBeat.o(189289);
        return true;
      }
      AppMethodBeat.o(189289);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Bind
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(189291);
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(localBaseWebViewController.ALf)) && (waitFor(localBaseWebViewController.ALe)))
      {
        AppMethodBeat.o(189291);
        return true;
      }
      AppMethodBeat.o(189291);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  public static abstract class ControllerAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Init
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(189293);
      boolean bool = waitFor(getController().ALd);
      AppMethodBeat.o(189293);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Inject
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(189294);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((!localBaseWebViewController.nhy.feU()) && (!waitFor(localBaseWebViewController.ALj, paramString))) || (((waitFor(localBaseWebViewController.ALe)) && ((localBaseWebViewController.ALx.ALF) || (localBaseWebViewController.kxg.has(paramString)) || (waitFor(localBaseWebViewController.ALh, paramString)))) || (localBaseWebViewController.bEz())))
      {
        AppMethodBeat.o(189294);
        return true;
      }
      AppMethodBeat.o(189294);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"})
  @Keep
  protected static abstract class PageAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify(String paramString);
    
    public final boolean waitFor(int paramInt, String paramString)
    {
      d.g.b.k.h(paramString, "url");
      return (d.g.b.k.g(paramString, getController().AKJ)) && (BaseWebViewController.b(getController()).contains(Integer.valueOf(paramInt)));
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Ready
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(189298);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((waitFor(w.bk(BaseWebViewController.Start.class))) && (waitFor(w.bk(BaseWebViewController.Auth.class), paramString)) && ((waitFor(localBaseWebViewController.ALk, paramString)) || (localBaseWebViewController.nhy.feU()))) || (localBaseWebViewController.bEA()))
      {
        AppMethodBeat.o(189298);
        return true;
      }
      AppMethodBeat.o(189298);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class SPAUpdated
    extends BaseWebViewController.PageAction
  {
    private final boolean keep = true;
    
    public final boolean getKeep()
    {
      return this.keep;
    }
    
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(189299);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(w.bk(BaseWebViewController.Ready.class), paramString)) && (waitFor(localBaseWebViewController.ALl, paramString)))
      {
        AppMethodBeat.o(189299);
        return true;
      }
      AppMethodBeat.o(189299);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Start
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(189300);
      Object localObject = getController();
      if ((waitFor(((BaseWebViewController)localObject).ALf)) && ((!((BaseWebViewController)localObject).bEE()) || (waitFor(((BaseWebViewController)localObject).ALe))))
      {
        if (((CharSequence)((BaseWebViewController)localObject).bEx()).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            localObject = (CharSequence)((BaseWebViewController)localObject).ejb();
            if ((localObject != null) && (!n.aC((CharSequence)localObject))) {
              break label97;
            }
          }
        }
        label97:
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label102;
          }
          AppMethodBeat.o(189300);
          return true;
          i = 0;
          break;
        }
      }
      label102:
      AppMethodBeat.o(189300);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"})
  @Keep
  public static abstract class WebAction
  {
    public BaseWebViewController controller;
    private final boolean keep;
    
    public final BaseWebViewController getController()
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aPZ("controller");
      }
      return localBaseWebViewController;
    }
    
    public boolean getKeep()
    {
      return this.keep;
    }
    
    public final void setController(BaseWebViewController paramBaseWebViewController)
    {
      d.g.b.k.h(paramBaseWebViewController, "<set-?>");
      this.controller = paramBaseWebViewController;
    }
    
    public final boolean waitFor(int paramInt)
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aPZ("controller");
      }
      return BaseWebViewController.c(localBaseWebViewController).contains(Integer.valueOf(paramInt));
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.ControllerAction> paramb)
    {
      d.g.b.k.h(paramb, "clazz");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aPZ("controller");
      }
      return d.a.j.a((Iterable)BaseWebViewController.d(localBaseWebViewController), paramb.getSimpleName());
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.PageAction> paramb, String paramString)
    {
      d.g.b.k.h(paramb, "clazz");
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aPZ("controller");
      }
      if (d.g.b.k.g(paramString, localBaseWebViewController.AKJ))
      {
        paramString = this.controller;
        if (paramString == null) {
          d.g.b.k.aPZ("controller");
        }
        if (d.a.j.a((Iterable)BaseWebViewController.e(paramString), paramb.getSimpleName())) {
          return true;
        }
      }
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    a(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.webview.core.BaseWebViewController$start$1", f="BaseWebViewController.kt", l={}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class aa
    extends d.d.b.a.j
    implements m<kotlinx.coroutines.ad, d.d.d<? super d.y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    
    aa(BaseWebViewController paramBaseWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(189345);
      d.g.b.k.h(paramd, "completion");
      paramd = new aa(this.ALA, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(189345);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(189344);
      paramObject = d.d.a.a.JgJ;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189344);
        throw paramObject;
      }
      this.ALA.Sr(this.ALA.ALf);
      paramObject = d.y.JfV;
      AppMethodBeat.o(189344);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(189346);
      paramObject1 = ((aa)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(189346);
      return paramObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/BaseWebViewController$tryBindService$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class ab
    implements d
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(189347);
      d.g.b.k.h(paramc, "conn");
      if (this.ALA.ejf())
      {
        com.tencent.mm.sdk.platformtools.ad.i(BaseWebViewController.a(this.ALA), "WebView-Trace onConnected whent destroyCalled");
        AppMethodBeat.o(189347);
        return;
      }
      this.ALA.ALu = paramc;
      BaseWebViewController localBaseWebViewController = this.ALA;
      paramc = paramc.eiX();
      d.g.b.k.h(paramc, "<set-?>");
      localBaseWebViewController.kxf = paramc;
      this.ALA.getJsapi().b(this.ALA.eiX());
      this.ALA.a(this.ALA.eiX());
      com.tencent.mm.sdk.platformtools.ad.i(BaseWebViewController.a(this.ALA), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
      if (d.a.j.a((Iterable)BaseWebViewController.d(this.ALA), w.bk(BaseWebViewController.Bind.class).getSimpleName()))
      {
        this.ALA.dvS();
        AppMethodBeat.o(189347);
        return;
      }
      this.ALA.Sr(this.ALA.ALe);
      AppMethodBeat.o(189347);
    }
    
    public final boolean ejl()
    {
      AppMethodBeat.i(189348);
      boolean bool = this.ALA.eje();
      AppMethodBeat.o(189348);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class ac
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public static final ac ALU;
    
    static
    {
      AppMethodBeat.i(189350);
      ALU = new ac();
      AppMethodBeat.o(189350);
    }
    
    ac()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"})
  public static final class ad
    implements g.b
  {
    public final String ejm()
    {
      AppMethodBeat.i(189351);
      String str = this.ALA.getCurrentUrl();
      AppMethodBeat.o(189351);
      return str;
    }
    
    public final String ejn()
    {
      return this.ALA.AKK;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"})
  public static final class b
  {
    public static String aQ(Intent paramIntent)
    {
      AppMethodBeat.i(189292);
      d.g.b.k.h(paramIntent, "intent");
      try
      {
        String str1 = paramIntent.getStringExtra("rawUrl");
        CharSequence localCharSequence = (CharSequence)str1;
        if ((localCharSequence == null) || (n.aC(localCharSequence)))
        {
          i = 1;
          if (i != 0) {
            break label95;
          }
          AppMethodBeat.o(189292);
          return str1;
        }
      }
      catch (Exception localException)
      {
        String str2;
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WebViewController", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
          if ((localException instanceof ClassNotFoundException))
          {
            paramIntent = (Throwable)localException;
            AppMethodBeat.o(189292);
            throw paramIntent;
          }
          str2 = null;
          continue;
          int i = 0;
        }
        label95:
        paramIntent = paramIntent.getData();
        if (paramIntent != null)
        {
          str2 = paramIntent.toString();
          paramIntent = str2;
          if (str2 != null) {}
        }
        else
        {
          paramIntent = "";
        }
        AppMethodBeat.o(189292);
      }
      return paramIntent;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZ)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getNeverGetA8Key", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"})
  public static final class c
  {
    final BaseWebViewController.f ALB;
    final boolean ALC;
    final boolean ALD;
    final boolean ALE;
    final boolean ALF;
    
    public c(byte paramByte)
    {
      this();
    }
    
    public c(BaseWebViewController.f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      AppMethodBeat.i(189295);
      this.ALB = paramf;
      this.ALC = paramBoolean1;
      this.ALD = paramBoolean2;
      this.ALE = paramBoolean3;
      this.ALF = paramBoolean4;
      AppMethodBeat.o(189295);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"})
  final class d
    extends com.tencent.mm.ui.widget.i
  {
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(189297);
      if ((paramInt >= 100) && (!this.ALA.ejf()))
      {
        this.ALA.ALb = true;
        com.tencent.mm.sdk.platformtools.ad.i(BaseWebViewController.a(this.ALA), "Abe-Debug Progress 100");
        if (paramWebView != null)
        {
          Object localObject;
          if (paramWebView.supportFeature(2006))
          {
            localObject = f.ALW;
            if (!f.a.ejq()) {}
          }
          else
          {
            localObject = paramWebView.getUrl();
            if (localObject != null)
            {
              if (((CharSequence)localObject).length() == 0) {}
              for (paramInt = 1; paramInt == 0; paramInt = 0)
              {
                localObject = this.ALA;
                paramInt = this.ALA.ALj;
                BaseWebViewController localBaseWebViewController = this.ALA;
                paramWebView = paramWebView.getUrl();
                d.g.b.k.g(paramWebView, "url");
                ((BaseWebViewController)localObject).co(paramInt, BaseWebViewController.c(localBaseWebViewController, paramWebView));
                AppMethodBeat.o(189297);
                return;
              }
            }
            com.tencent.mm.sdk.platformtools.ad.i(BaseWebViewController.a(this.ALA), "WebView-Trace not support PAGE_COMMIT_VISIBLE, url = null, skip check");
          }
          AppMethodBeat.o(189297);
          return;
        }
      }
      AppMethodBeat.o(189297);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", "action", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class e
  {
    final d.l.b<? extends BaseWebViewController.WebAction> ALG;
    final d.g.a.a<d.y> gml;
    
    public e(d.l.b<? extends BaseWebViewController.WebAction> paramb, d.g.a.a<d.y> parama)
    {
      AppMethodBeat.i(189301);
      this.ALG = paramb;
      this.gml = parama;
      AppMethodBeat.o(189301);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(189304);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!d.g.b.k.g(this.ALG, paramObject.ALG)) || (!d.g.b.k.g(this.gml, paramObject.gml))) {}
        }
      }
      else
      {
        AppMethodBeat.o(189304);
        return true;
      }
      AppMethodBeat.o(189304);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(189303);
      Object localObject = this.ALG;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.gml;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(189303);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(189302);
      String str = "WebEvent(action=" + this.ALG + ", block=" + this.gml + ")";
      AppMethodBeat.o(189302);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"})
  public static final class f
  {
    final d.f ALH;
    final d.f ALI;
    final d.f ALJ;
    final d.f ALK;
    
    static
    {
      AppMethodBeat.i(189309);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "enablePlugin", "getEnablePlugin()Z")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "enableZoom", "getEnableZoom()Z")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "enableJavascript", "getEnableJavascript()Z")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "enableVerticalScroll", "getEnableVerticalScroll()Z")) };
      AppMethodBeat.o(189309);
    }
    
    public f(Intent paramIntent)
    {
      AppMethodBeat.i(189310);
      this.ALH = d.g.E((d.g.a.a)new b(paramIntent));
      this.ALI = d.g.E((d.g.a.a)new d(paramIntent));
      this.ALJ = d.g.E((d.g.a.a)new a(paramIntent));
      this.ALK = d.g.E((d.g.a.a)new c(paramIntent));
      AppMethodBeat.o(189310);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      a(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      b(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      c(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      d(Intent paramIntent)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.c>
  {
    public static final g ALM;
    
    static
    {
      AppMethodBeat.i(189313);
      ALM = new g();
      AppMethodBeat.o(189313);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    i(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    k(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    l(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    m(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    n(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.f<aoj>>
  {
    o(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    p(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "callback", "Lkotlin/Function0;", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.b<d.g.a.a<? extends d.y>, Boolean>
  {
    public static final q ALN;
    
    static
    {
      AppMethodBeat.i(189326);
      ALN = new q();
      AppMethodBeat.o(189326);
    }
    
    q()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    r(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    s(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    t(BaseWebViewController paramBaseWebViewController, String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.a<ap>
  {
    public static final u ALP;
    
    static
    {
      AppMethodBeat.i(189332);
      ALP = new u();
      AppMethodBeat.o(189332);
    }
    
    u()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"setConfigCallback", "", "windowManager", "Landroid/view/WindowManager;", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.b<WindowManager, d.y>
  {
    public static final v ALQ;
    
    static
    {
      AppMethodBeat.i(189335);
      ALQ = new v();
      AppMethodBeat.o(189335);
    }
    
    v()
    {
      super();
    }
    
    public static void b(WindowManager paramWindowManager)
    {
      AppMethodBeat.i(189334);
      d.g.b.k.h(paramWindowManager, "windowManager");
      try
      {
        Object localObject = WebView.class.getDeclaredField("mWebViewCore");
        d.g.b.k.g(localObject, "field");
        localObject = ((Field)localObject).getType().getDeclaredField("mBrowserFrame");
        d.g.b.k.g(localObject, "field");
        Field localField = ((Field)localObject).getType().getDeclaredField("sConfigCallback");
        d.g.b.k.g(localField, "field");
        localField.setAccessible(true);
        localObject = localField.get(null);
        if (localObject == null)
        {
          AppMethodBeat.o(189334);
          return;
        }
        localField = localField.getType().getDeclaredField("mWindowManager");
        d.g.b.k.g(localField, "field");
        localField.setAccessible(true);
        localField.set(localObject, paramWindowManager);
        AppMethodBeat.o(189334);
        return;
      }
      catch (Exception paramWindowManager)
      {
        AppMethodBeat.o(189334);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.i>
  {
    w(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.f>
  {
    x(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.a<Runnable>
  {
    y(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"})
  public static final class z
    extends k
  {
    public final void finish()
    {
      AppMethodBeat.i(189342);
      if (!this.ALA.bEy())
      {
        AppMethodBeat.o(189342);
        return;
      }
      this.ALA.aFm().removeCallbacks(this.ALA.eja());
      com.tencent.e.h.Iye.aN((Runnable)new a(this));
      AppMethodBeat.o(189342);
    }
    
    public final void uY(long paramLong)
    {
      AppMethodBeat.i(189343);
      this.ALA.aFm().postDelayed(this.ALA.eja(), paramLong);
      AppMethodBeat.o(189343);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BaseWebViewController.z paramz) {}
      
      public final void run()
      {
        AppMethodBeat.i(189341);
        Iterator localIterator = ((Iterable)this.ALT.ALA.AKY).iterator();
        while (localIterator.hasNext()) {
          ((i)localIterator.next()).ejD();
        }
        AppMethodBeat.o(189341);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController
 * JD-Core Version:    0.7.0.1
 */