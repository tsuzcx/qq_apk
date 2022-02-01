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
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.z.o.a;
import com.tencent.mm.plugin.webview.e.c.a;
import com.tencent.mm.plugin.webview.e.g.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.z;
import d.a.ae;
import d.a.ak;
import d.aa;
import d.g.a.m;
import d.g.b.w;
import d.n.n;
import d.v;
import d.y;
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
import kotlinx.coroutines.ag;
import kotlinx.coroutines.bh;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_SAP_STATUS", "getPAGE_SAP_STATUS", "()Ljava/util/Set;", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isInject", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "updateRandomStr", "getUpdateRandomStr", "updateRandomStr$delegate", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", "listener", "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canLoadUrl", "url", "canShowRefresh", "checkStatus", "check", "dealSPAUpdate", "destroy", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", "request", "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCallBackUrl", "getShareUrl", "getStatusListener", "hasStatus", "init", "initEnviroment", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "Lcom/tencent/xweb/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onUrlRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeInvoker", "removeStatus", "resetActions", "resetPageActions", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"})
public abstract class BaseWebViewController
  extends com.tencent.xweb.ac
  implements com.tencent.mm.plugin.webview.e.a<arn>
{
  public static final b CdR = new b((byte)0);
  private final d.f CcW;
  private final d.f CcX;
  public String CcY;
  private final d.f CcZ;
  final int CdA;
  final int CdB;
  final int CdC;
  final Set<Integer> CdD;
  private final ConcurrentLinkedDeque<d.o<ControllerAction, d.g.a.a<y>>> CdE;
  private final ConcurrentLinkedDeque<d.o<PageAction, d.g.a.a<y>>> CdF;
  private final HashSet<Integer> CdG;
  private final HashSet<Integer> CdH;
  private final HashSet<String> CdI;
  private final HashSet<String> CdJ;
  public final boolean CdK;
  c CdL;
  private final d.f CdM;
  private boolean CdN;
  private final d.f CdO;
  final c CdP;
  private Set<String> CdQ;
  String Cda;
  public String Cdb;
  String Cdc;
  private boolean Cdd;
  public boolean Cde;
  private final d.f Cdf;
  private final d.f Cdg;
  private final d.f Cdh;
  public final Map<String, String> Cdi;
  private final d.f Cdj;
  private final boolean Cdk;
  public final k Cdl;
  public final com.tencent.mm.plugin.webview.j.h Cdm;
  final ConcurrentLinkedDeque<j> Cdn;
  private final ConcurrentLinkedDeque<e> Cdo;
  public final ConcurrentLinkedDeque<i> Cdp;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<d.g.a.a<y>>> Cdq;
  public boolean Cdr;
  boolean Cds;
  private final d.f Cdt;
  final int Cdu;
  public final int Cdv;
  public final int Cdw;
  protected final int Cdx;
  final int Cdy;
  private final int Cdz;
  protected String cHn;
  protected Intent intent;
  private final d.f jGz;
  public com.tencent.mm.plugin.webview.stub.e kYt;
  public final com.tencent.mm.plugin.webview.e.g kYu;
  private final List<e> nJV;
  public final MMWebView nKq;
  
  public BaseWebViewController(MMWebView paramMMWebView, c paramc, Set<String> paramSet)
  {
    this.nKq = paramMMWebView;
    this.CdP = paramc;
    this.CdQ = paramSet;
    this.CcW = d.g.K((d.g.a.a)new a(this));
    this.CcX = d.g.K((d.g.a.a)new o(this));
    this.CcZ = d.g.K((d.g.a.a)g.Ced);
    this.cHn = "";
    this.Cda = "";
    this.Cdb = "";
    this.Cdc = "";
    this.Cdf = d.g.K((d.g.a.a)new x(this));
    this.Cdg = d.g.K((d.g.a.a)new y(this));
    this.Cdh = d.g.K((d.g.a.a)new p(this));
    this.jGz = d.g.K((d.g.a.a)v.Ceh);
    this.kYu = new com.tencent.mm.plugin.webview.e.g((g.b)new ag(this));
    this.Cdi = ((Map)new HashMap());
    this.Cdj = d.g.K((d.g.a.a)new aa(this));
    this.Cdk = true;
    this.Cdl = ((k)new ab(this));
    this.Cdm = new com.tencent.mm.plugin.webview.j.h();
    this.Cdn = new ConcurrentLinkedDeque();
    this.Cdo = new ConcurrentLinkedDeque();
    this.Cdp = new ConcurrentLinkedDeque();
    this.Cdq = new ConcurrentHashMap();
    this.Cdt = d.g.K((d.g.a.a)new s(this));
    this.Cdu = -1;
    this.Cdv = -2;
    this.Cdw = -3;
    this.Cdx = -10;
    this.Cdy = 1;
    this.Cdz = 2;
    this.CdA = 10;
    this.CdB = 11;
    this.CdC = 12;
    this.CdD = ak.setOf(new Integer[] { Integer.valueOf(this.CdB), Integer.valueOf(this.CdC) });
    this.nJV = d.a.j.mutableListOf(new e[] { new e(w.bn(Init.class), (d.g.a.a)new h((BaseWebViewController)this)), new e(w.bn(Inject.class), (d.g.a.a)new i(this)), new e(w.bn(Bind.class), (d.g.a.a)new j((BaseWebViewController)this)), new e(w.bn(Auth.class), (d.g.a.a)new k(this)), new e(w.bn(Ready.class), (d.g.a.a)new l(this)), new e(w.bn(Start.class), (d.g.a.a)new m(this)), new e(w.bn(SPAUpdated.class), (d.g.a.a)new n(this)) });
    this.CdE = new ConcurrentLinkedDeque();
    this.CdF = new ConcurrentLinkedDeque();
    this.CdG = new HashSet();
    this.CdH = new HashSet();
    this.CdI = new HashSet();
    this.CdJ = new HashSet();
    this.CdK = eyq().eAq();
    this.CdM = d.g.K((d.g.a.a)ae.Cem);
    this.CdO = d.g.K((d.g.a.a)af.Cen);
  }
  
  private final String KQ(String paramString)
  {
    if (!Uc(paramString)) {
      paramString = this.Cdb;
    }
    for (;;)
    {
      String str = paramString;
      if (n.aD((CharSequence)paramString))
      {
        str = paramString;
        if (UA(this.Cdw)) {
          str = bLL();
        }
      }
      return str;
    }
  }
  
  private boolean UB(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!aa.KTq) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.CdH.remove(Integer.valueOf(paramInt));
    return bool;
  }
  
  private final <T extends WebAction> void a(Iterable<? extends d.o<? extends T, ? extends d.g.a.a<y>>> paramIterable, Set<String> paramSet, String paramString)
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
          break label235;
        }
        if ((paramString != null) && (((PageAction)localWebAction).verify(paramString)))
        {
          bool = true;
          if (!bool) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.ac.i(eyn(), "verify WebAction: " + w.bn(localWebAction.getClass()).getSimpleName() + " start");
          if (!localWebAction.getKeep()) {
            localIterator.remove();
          }
          paramIterable.invoke();
          String str = w.bn(localWebAction.getClass()).getSimpleName();
          paramIterable = str;
          if (str == null) {
            paramIterable = "";
          }
          paramSet.add(paramIterable);
          com.tencent.mm.sdk.platformtools.ac.v(eyn(), "verifyActions: " + w.bn(localWebAction.getClass()).getSimpleName() + " end");
          continue;
        }
        bool = false;
      }
      finally {}
      continue;
      label235:
      if ((localWebAction instanceof ControllerAction)) {
        bool = ((ControllerAction)localWebAction).verify();
      } else {
        bool = false;
      }
    }
  }
  
  private final String aAI(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aD((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!com.tencent.luggage.h.c.a(paramString, "about:blank", true)))
      {
        localObject = paramString;
        if (!com.tencent.luggage.h.c.a(paramString, "data:text/html;charset=utf-8", true)) {}
      }
      else
      {
        localObject = this.cHn;
      }
      return localObject;
    }
  }
  
  private final void aAL(String paramString)
  {
    try
    {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "resetPageActions clear status:" + paramString + ", [" + d.a.j.a((Iterable)this.CdG, (CharSequence)",", null, null, 0, null, null, 62) + "] actions: [" + d.a.j.a((Iterable)this.CdI, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      this.CdG.clear();
      this.CdI.clear();
      this.CdF.clear();
      Iterator localIterator = ((Iterable)bLP()).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = d.l.a.c.d(locale.CdY);
        ((WebAction)localObject).setController((BaseWebViewController)this);
        localObject = (WebAction)localObject;
        if ((localObject instanceof PageAction)) {
          this.CdF.add(d.u.Q(localObject, locale.gMY));
        }
      }
      aAJ(paramString);
    }
    finally {}
    this.Cdc = "";
  }
  
  private final int aAM(String paramString)
  {
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    while (localIterator.hasNext())
    {
      int i = ((j)localIterator.next()).aAM(paramString);
      if (i != -1) {
        return i;
      }
    }
    return eyq().aCF(paramString);
  }
  
  public static final String aS(Intent paramIntent)
  {
    return b.aS(paramIntent);
  }
  
  private final com.tencent.mm.plugin.webview.c.i eys()
  {
    return (com.tencent.mm.plugin.webview.c.i)this.Cdf.getValue();
  }
  
  private final void eyw()
  {
    for (;;)
    {
      e locale;
      Object localObject2;
      try
      {
        com.tencent.mm.sdk.platformtools.ac.i(eyn(), "resetActions");
        this.CdH.clear();
        this.CdJ.clear();
        this.CdE.clear();
        this.CdG.clear();
        this.CdI.clear();
        this.CdF.clear();
        Iterator localIterator = ((Iterable)bLP()).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locale = (e)localIterator.next();
        localObject2 = d.l.a.c.d(locale.CdY);
        ((WebAction)localObject2).setController((BaseWebViewController)this);
        localObject2 = (WebAction)localObject2;
        if ((localObject2 instanceof ControllerAction))
        {
          this.CdE.add(d.u.Q(localObject2, locale.gMY));
          continue;
        }
        if (!(localObject2 instanceof PageAction)) {
          continue;
        }
      }
      finally {}
      this.CdF.add(d.u.Q(localObject2, locale.gMY));
    }
  }
  
  private final void l(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (this.Cdr) && (paramWebView.canGoBack()))
    {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "clearHistory :".concat(String.valueOf(paramString)));
      paramWebView.clearHistory();
      this.Cdr = false;
    }
  }
  
  public final void A(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString1 = this.nKq.getSettings();
      if (paramString1 != null) {
        paramString1.setJavaScriptEnabled(false);
      }
      this.nKq.loadData(paramString2, "text/html", "utf-8");
    }
  }
  
  public final void E(String paramString, Map<String, String> paramMap)
  {
    d.g.b.k.h(paramString, "baseUrl");
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace loadCacheUrl baseUrl ".concat(String.valueOf(paramString)));
    this.cHn = paramString;
    this.nKq.loadUrl(paramString, paramMap);
    aAK(paramString);
    Uz(this.Cdx);
  }
  
  public final boolean UA(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!aa.KTq) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.CdH.contains(Integer.valueOf(paramInt));
    return bool;
  }
  
  protected boolean Ub(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    return true;
  }
  
  protected boolean Uc(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    if (!n.aD((CharSequence)paramString)) {}
    for (int i = 1; (i != 0) && (!n.nb(paramString, "data:text/html;charset=utf-8")) && (!n.nb(paramString, "about:blank")) && ((!UA(this.Cdx)) || (!n.nb(paramString, "https://mp.weixin.qq.com/__tmpl__/"))); i = 0) {
      return true;
    }
    return false;
  }
  
  public final ConcurrentLinkedDeque<d.g.a.a<y>> Uy(int paramInt)
  {
    ConcurrentLinkedDeque localConcurrentLinkedDeque2 = (ConcurrentLinkedDeque)this.Cdq.get(Integer.valueOf(paramInt));
    ConcurrentLinkedDeque localConcurrentLinkedDeque1 = localConcurrentLinkedDeque2;
    if (localConcurrentLinkedDeque2 == null)
    {
      localConcurrentLinkedDeque1 = new ConcurrentLinkedDeque();
      ((Map)this.Cdq).put(Integer.valueOf(paramInt), localConcurrentLinkedDeque1);
    }
    return localConcurrentLinkedDeque1;
  }
  
  /* Error */
  public final void Uz(final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1157	com/tencent/mm/plugin/webview/core/BaseWebViewController:eyA	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 1163	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   17: new 104	com/tencent/mm/plugin/webview/core/BaseWebViewController$q
    //   20: dup
    //   21: aload_0
    //   22: iload_1
    //   23: invokespecial 1166	com/tencent/mm/plugin/webview/core/BaseWebViewController$q:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;I)V
    //   26: checkcast 1168	java/lang/Runnable
    //   29: invokeinterface 1174 2 0
    //   34: pop
    //   35: goto -24 -> 11
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	BaseWebViewController
    //   0	43	1	paramInt	int
    //   6	2	2	bool	boolean
    //   38	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   14	35	38	finally
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
      cr(this.Cdz, paramString1);
      Iterator localIterator = ((Iterable)this.Cdp).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).d(paramInt1, paramString1, paramInt2, paramString2);
      }
      this.CcY = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, arn paramarn)
  {
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "fullUrl");
    d.g.b.k.h(paramarn, "response");
    com.tencent.mm.sdk.platformtools.ac.d(eyn(), "WebView-Trace onPermissionUpdate:" + paramString1 + ", fullUrl:" + paramString2);
    if (eyA()) {
      com.tencent.mm.sdk.platformtools.ac.d(eyn(), "onPermissionUpdate destroyCalled");
    }
    do
    {
      return;
      this.kYu.a(paramString1, eyq().aCC(paramString1), eyq().aCD(paramString1));
      this.kYu.a(paramString2, eyq().aCC(paramString2), eyq().aCD(paramString2));
      Iterator localIterator = ((Iterable)this.Cdp).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).c(paramString1, paramarn);
      }
      cr(this.Cdy, paramString1);
      cr(this.Cdy, paramString2);
    } while (!d.g.b.k.g(paramString1, this.Cdc));
    cr(this.CdC, paramString1);
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebAction:Ready onPermissionUpdated Patch: " + this.Cdc);
  }
  
  public final void a(e parame)
  {
    d.g.b.k.h(parame, "listener");
    if (!this.Cdo.contains(parame)) {
      this.Cdo.add(parame);
    }
  }
  
  public final void a(i parami)
  {
    try
    {
      d.g.b.k.h(parami, "listener");
      if (!this.Cdp.contains(parami))
      {
        BaseWebViewController localBaseWebViewController = (BaseWebViewController)this;
        d.g.b.k.h(localBaseWebViewController, "<set-?>");
        parami.controller = localBaseWebViewController;
        this.Cdp.add(parami);
        if (d.a.j.a((Iterable)this.CdJ, w.bn(Bind.class).getSimpleName()))
        {
          com.tencent.mm.sdk.platformtools.ac.i(eyn(), "Abe-Debug Patch Call onBind");
          parami.dKr();
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
    this.Cdn.add(paramj);
    Object localObject = paramj.eza();
    if (localObject != null) {
      a((e)localObject);
    }
    localObject = paramj.ezb();
    if (localObject != null) {
      a((i)localObject);
    }
    paramj.k(this);
  }
  
  public void a(com.tencent.mm.plugin.webview.stub.e parame) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (!UA(this.Cdw)) {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "onReceivedError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.Cdo).iterator();
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
    if (!UA(this.Cdw)) {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "onReceivedHttpError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.Cdo).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        }
      }
    }
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.j paramj, String paramString1, String paramString2)
  {
    d.g.b.k.h(paramj, "handler");
    super.a(paramWebView, paramj, paramString1, paramString2);
    com.tencent.mm.plugin.report.service.h.wUl.n(155L, 35L, 1L);
  }
  
  public void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    super.a(paramWebView, paramr, paramSslError);
    if (!UA(this.Cdw)) {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "onReceivedSslError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.Cdo).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.a(paramWebView, paramr, paramSslError);
        }
      }
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace doUpdateVisitedHistory, url = " + paramString + ", wvUrl = " + paramWebView.getUrl() + ", isReload = " + paramBoolean);
    if (n.nb(paramString, "data:text/html;charset=utf-8"))
    {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "url starts with data:text, url : ".concat(String.valueOf(paramString)));
      return;
    }
    if ((com.tencent.luggage.h.c.A(paramString, "about:blank")) || (com.tencent.luggage.h.c.A(paramString, "file:///android_asset/")))
    {
      com.tencent.mm.sdk.platformtools.ac.e(eyn(), "doUpdateVisitedHistory, url is invalid");
      return;
    }
    if ((UA(this.Cdx)) && (com.tencent.luggage.h.c.A(paramString, "https://mp.weixin.qq.com/__tmpl__/")))
    {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "doUpdateVisitedHistory, url is HARDCODE_URL");
      return;
    }
    super.a(paramWebView, paramString, paramBoolean);
    if (((Boolean)this.CdO.getValue()).booleanValue()) {
      paramString = paramWebView.getUrl();
    }
    d.g.b.k.g(paramString, "url");
    if (!d.g.b.k.g(this.Cda, paramString))
    {
      if (this.kYu.has(paramString)) {
        cr(this.CdC, paramString);
      }
      this.Cdc = paramString;
    }
    if (!this.CdP.CdX) {
      aE(paramString, false);
    }
    this.CcY = paramString;
    Iterator localIterator = ((Iterable)this.Cdo).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (isStarted()) {
        locale.aAQ(paramString);
      }
    }
    l(paramWebView, paramString);
  }
  
  protected boolean a(int paramInt, String paramString, arn paramarn)
  {
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramarn, "resp");
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).d(paramString, paramarn)) {
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
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "shouldOverrideUrlLoading: ".concat(String.valueOf(paramString)));
    com.tencent.mm.sdk.platformtools.ac.d(eyn(), "doShouldOverrideUrlLoading url:".concat(String.valueOf(paramString)));
    boolean bool1;
    if (k(paramWebView, paramString))
    {
      bool1 = bool2;
      if (!bool1) {
        this.CcY = paramString;
      }
      return bool1;
    }
    label150:
    if (aAM(paramString) == 2)
    {
      bool1 = true;
      label89:
      if (aE(paramString, bool1))
      {
        if (this.CdP.CdX) {
          break label181;
        }
        switch (aAM(paramString))
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
  
  protected final void aAJ(String paramString)
  {
    d.g.b.k.h(paramString, "value");
    if (Ub(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.d(eyn(), "WebView-Trace startUrl:".concat(String.valueOf(paramString)));
      this.Cda = paramString;
    }
  }
  
  protected final void aAK(String paramString)
  {
    d.g.b.k.h(paramString, "value");
    if (Uc(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.d(eyn(), "WebView-Trace commitUrl:".concat(String.valueOf(paramString)));
      this.Cdb = paramString;
    }
  }
  
  public final boolean aAN(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    if (ab.ivD)
    {
      com.tencent.mm.sdk.platformtools.ac.w(eyn(), "skipLoadUrlCheck");
      return true;
    }
    if (this.CdP.CdU)
    {
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "file://", true))
    {
      Iterator localIterator = ((Iterable)eyp()).iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.luggage.h.c.a(paramString, (String)localIterator.next(), true)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  protected final boolean aAO(String paramString)
  {
    d.g.b.k.h(paramString, "url");
    if (!aAN(paramString))
    {
      com.tencent.mm.sdk.platformtools.ac.f(eyn(), "forceQuitOnUrlForbidden, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = ((Iterable)this.Cdp).iterator();
      while (paramString.hasNext()) {
        ((i)paramString.next()).eyW();
      }
      return true;
    }
    return false;
  }
  
  protected boolean aE(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    d.g.b.k.h(paramString, "url");
    if (a(this, paramString, paramBoolean, 0, 4) == c.a.Ctn) {
      bool = true;
    }
    return bool;
  }
  
  public final String aHk()
  {
    return eyq().aCl(getCurrentUrl());
  }
  
  public final ao aMd()
  {
    return (ao)this.jGz.getValue();
  }
  
  public final void ao(Intent paramIntent)
  {
    d.g.b.k.h(paramIntent, "intent");
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "start");
    this.intent = paramIntent;
    com.tencent.mm.plugin.webview.e.g localg = this.kYu;
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
    this.Cdm.CPA = paramIntent.getLongExtra("startTime", 0L);
    kotlinx.coroutines.f.b((ag)bh.LRM, null, (m)new ac(this, null), 3);
  }
  
  protected WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramWebResourceRequest, "request");
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "shouldInterceptRequest, url = " + paramWebResourceRequest.getUrl() + ", method = " + paramWebResourceRequest.getMethod() + ", isForMainFrame = " + paramWebResourceRequest.isForMainFrame());
    Object localObject = paramWebResourceRequest.getUrl().toString();
    d.g.b.k.g(localObject, "request.url.toString()");
    if (aAO((String)localObject)) {
      return null;
    }
    if ((com.tencent.mm.cq.d.kD(getContext())) && (paramBundle != null)) {}
    try
    {
      int i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        com.tencent.mm.sdk.platformtools.ac.i(eyn(), "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        paramBundle = paramWebResourceRequest.getUrl().toString();
        d.g.b.k.g(paramBundle, "request.url.toString()");
        k(paramBundle, false, 5);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.w(eyn(), "get resource type failed Exception ; " + paramBundle.getMessage());
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ac.w(eyn(), "get resource type failed Throwable ; " + paramBundle.getMessage());
      }
    }
    paramBundle = ((Iterable)this.Cdn).iterator();
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
    if (eyA())
    {
      com.tencent.mm.sdk.platformtools.ac.w(eyn(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = KQ(str);
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace onPageFinished: " + paramString + ", callbackUrl:" + str);
      if (((paramWebView == null) || (paramWebView.supportFeature(2006) != true)) && (this.Cds)) {
        aAK(str);
      }
      super.b(paramWebView, paramString);
      if ((!UA(this.CdA)) && (!bLV()))
      {
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1200L, 104L, 1L, false);
        com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
      }
      cr(this.CdB, aAI(paramString));
      Iterator localIterator = ((Iterable)this.Cdo).iterator();
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
    if (eyA())
    {
      com.tencent.mm.sdk.platformtools.ac.w(eyn(), "ActivityFinished");
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace onPageStarted: ".concat(String.valueOf(paramString)));
    this.Cds = false;
    this.CcY = paramString;
    aAL(paramString);
    Iterator localIterator = ((Iterable)this.Cdo).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (isStarted()) {
        locale.m(paramWebView, KQ(paramString));
      }
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public boolean b(int paramInt, String paramString, arn paramarn)
  {
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramarn, "response");
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(paramInt)));
    this.nKq.setA8keyReason(paramInt);
    Object localObject1 = this.Cdi;
    ((Map)localObject1).clear();
    Object localObject2 = paramarn.EKJ;
    d.g.b.k.g(localObject2, "response.HttpHeader");
    int i;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      localObject2 = com.tencent.mm.plugin.webview.e.c.gI((List)paramarn.EKJ);
      d.g.b.k.g(localObject2, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      ((Map)localObject1).putAll((Map)localObject2);
    }
    label134:
    label327:
    label459:
    for (;;)
    {
      if (!a(paramInt, paramString, paramarn)) {
        break label461;
      }
      return true;
      i = 0;
      break;
      localObject2 = this.intent;
      if (localObject2 == null) {
        d.g.b.k.aVY("intent");
      }
      if (((Intent)localObject2).getBooleanExtra("k_has_http_header", false))
      {
        com.tencent.mm.sdk.platformtools.ac.i(eyn(), "use intent httpheader info");
        localObject2 = this.intent;
        if (localObject2 == null) {
          d.g.b.k.aVY("intent");
        }
        localObject2 = ((Intent)localObject2).getStringArrayExtra("geta8key_result_http_header_key_list");
        Object localObject3 = this.intent;
        if (localObject3 == null) {
          d.g.b.k.aVY("intent");
        }
        localObject3 = ((Intent)localObject3).getStringArrayExtra("geta8key_result_http_header_value_list");
        Intent localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.k.aVY("intent");
        }
        localIntent.putExtra("k_has_http_header", false);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.k.aVY("intent");
        }
        localIntent.putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.k.aVY("intent");
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
    localObject1 = ((Iterable)this.Cdp).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((i)((Iterator)localObject1).next()).b(paramString, paramarn);
    }
    return false;
  }
  
  public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramString1, "description");
    d.g.b.k.h(paramString2, "failingUrl");
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).c(paramWebView, paramInt, paramString1, paramString2);
    }
    return super.b(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public String bLL()
  {
    try
    {
      Object localObject = this.intent;
      if (localObject == null) {
        d.g.b.k.aVY("intent");
      }
      localObject = b.aS((Intent)localObject);
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      onFinish();
    }
    return "";
  }
  
  protected boolean bLM()
  {
    return this.Cdk;
  }
  
  protected boolean bLN()
  {
    return false;
  }
  
  protected boolean bLO()
  {
    return false;
  }
  
  protected List<e> bLP()
  {
    return this.nJV;
  }
  
  protected void bLQ()
  {
    a((j)new com.tencent.mm.plugin.webview.f.a());
    a((j)new com.tencent.mm.plugin.webview.k.e());
    this.nKq.setWebViewClient((com.tencent.xweb.ac)this);
    MMWebView localMMWebView = this.nKq;
    Object localObject = w.Cei;
    com.tencent.mm.plugin.webview.j.i.f(localMMWebView);
    z localz = localMMWebView.getSettings();
    localz.setJavaScriptEnabled(((Boolean)this.CdP.CdT.Ceb.getValue()).booleanValue());
    localz.setPluginsEnabled(((Boolean)this.CdP.CdT.CdZ.getValue()).booleanValue());
    localz.fJH();
    localz.setBuiltInZoomControls(((Boolean)this.CdP.CdT.Cea.getValue()).booleanValue());
    localz.setUseWideViewPort(true);
    localz.setLoadWithOverviewMode(true);
    localz.fJA();
    localz.fJz();
    localz.setGeolocationEnabled(true);
    localz.setJavaScriptCanOpenWindowsAutomatically(true);
    localz.fJJ();
    localz.fJF();
    localObject = localMMWebView.getContext().getDir("webviewcache", 0);
    d.g.b.k.g(localObject, "context.getDir(\"webviewc…e\", Context.MODE_PRIVATE)");
    localz.setAppCachePath(((File)localObject).getAbsolutePath());
    localz.fJE();
    localz.fJG();
    localz.setDatabasePath(com.tencent.mm.loader.j.b.aoY() + "databases/");
    String str = localz.getUserAgentString();
    d.g.b.k.g(str, "currentUa");
    if (!n.e((CharSequence)str, (CharSequence)" MicroMessenger/"))
    {
      o.a locala = (o.a)com.tencent.luggage.a.e.K(o.a.class);
      localObject = locala;
      if (locala == null) {
        localObject = (o.a)new com.tencent.mm.plugin.appbrand.luggage.b.f(localMMWebView.getContext());
      }
      localz.setUserAgentString(com.tencent.mm.plugin.appbrand.z.o.a(localMMWebView.getContext(), str, (o.a)localObject));
    }
    if (!((Boolean)this.CdP.CdT.Cec.getValue()).booleanValue())
    {
      localMMWebView.setVerticalScrollBarEnabled(false);
      localMMWebView.setHorizontalScrollBarEnabled(false);
    }
    com.tencent.xweb.c.fJa().fJb();
    com.tencent.xweb.c.fJa().e((WebView)localMMWebView);
    localObject = w.Cei;
    localObject = localMMWebView.getContext().getSystemService("window");
    if (localObject == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    w.b((WindowManager)localObject);
    if (this.nKq.fuP())
    {
      localObject = this.nKq.getUrl();
      d.g.b.k.g(localObject, "viewWV.url");
      aAK((String)localObject);
    }
    this.Cdm.bI("onTryBindServiceStart", System.currentTimeMillis());
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace tryBindService");
    localObject = l.CfN;
    l.a(true, eyo(), (d)new ad(this));
    this.Cdm.bI("onTryBindServiceEnd", System.currentTimeMillis());
  }
  
  protected void bLR() {}
  
  protected boolean bLS()
  {
    return true;
  }
  
  public boolean bLV()
  {
    return (UA(this.Cdx)) && (d.g.b.k.g(this.cHn, this.Cdb));
  }
  
  protected void bMF()
  {
    if (!this.CdN)
    {
      eyD();
      this.CdN = true;
    }
    Iterator localIterator = ((Iterable)this.Cdp).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bMF();
    }
  }
  
  public final void bj(int paramInt, String paramString)
  {
    d.g.b.k.h(paramString, "reqUrl");
    this.Cdm.bI("getA8KeyEnd", System.currentTimeMillis());
    Iterator localIterator = ((Iterable)this.Cdp).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).aAY(paramString);
    }
  }
  
  public final void bk(int paramInt, String paramString)
  {
    d.g.b.k.h(paramString, "reqUrl");
    this.Cdm.bI("getA8KeyStart", System.currentTimeMillis());
    if ((d.g.b.k.g(this.Cdc, paramString) ^ true)) {
      com.tencent.e.h.JZN.aQ((Runnable)new BaseWebViewController.ah(this, paramInt, paramString));
    }
  }
  
  /* Error */
  protected final void cr(final int paramInt, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ldc_w 1139
    //   6: invokestatic 631	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 1157	com/tencent/mm/plugin/webview/core/BaseWebViewController:eyA	()Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: getstatic 1163	com/tencent/e/h:JZN	Lcom/tencent/e/i;
    //   24: new 108	com/tencent/mm/plugin/webview/core/BaseWebViewController$r
    //   27: dup
    //   28: aload_0
    //   29: iload_1
    //   30: aload_2
    //   31: invokespecial 1897	com/tencent/mm/plugin/webview/core/BaseWebViewController$r:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;ILjava/lang/String;)V
    //   34: checkcast 1168	java/lang/Runnable
    //   37: invokeinterface 1174 2 0
    //   42: pop
    //   43: goto -25 -> 18
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	BaseWebViewController
    //   0	51	1	paramInt	int
    //   0	51	2	paramString	String
    //   13	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	46	finally
    //   21	43	46	finally
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
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    j.a locala;
    while (localIterator.hasNext())
    {
      locala = ((j)localIterator.next()).c(paramWebView, paramWebResourceRequest);
      if (locala.CfL) {
        if (!locala.CfL) {
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
  
  protected void dKr() {}
  
  public final void destroy()
  {
    com.tencent.mm.ac.c.g((d.g.a.a)new t(this));
  }
  
  public final void e(WebView paramWebView, String paramString)
  {
    if (eyA())
    {
      com.tencent.mm.sdk.platformtools.ac.w(eyn(), "ActivityFinished");
      return;
    }
    Object localObject1 = getJsapi();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject1).ezQ();
    }
    if ((((Boolean)this.CdM.getValue()).booleanValue()) && (!this.nKq.fuP()) && (!UA(this.Cdx)) && (paramString != null) && (!n.nb(paramString, "file:")))
    {
      localObject1 = getJsapi();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject1).ezI();
      }
    }
    if (paramString == null) {}
    for (localObject1 = "";; localObject1 = paramString)
    {
      localObject1 = KQ((String)localObject1);
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace onPageCommitVisible: " + paramString + ", callbackUrl:" + (String)localObject1);
      aAK((String)localObject1);
      super.e(paramWebView, paramString);
      Object localObject2 = f.Cep;
      if (!f.a.eyL()) {
        cr(this.CdA, aAI(paramString));
      }
      for (;;)
      {
        com.tencent.e.h.JZN.aQ((Runnable)new z(this));
        localObject2 = ((Iterable)this.Cdo).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          e locale = (e)((Iterator)localObject2).next();
          if (isStarted()) {
            locale.e(paramWebView, (String)localObject1);
          }
        }
        com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView Page Commit Mock Enabled");
      }
      l(paramWebView, paramString);
      return;
    }
  }
  
  public final boolean eyA()
  {
    return (this.Cde) || (this.Cdd);
  }
  
  public final void eyB()
  {
    try
    {
      com.tencent.mm.plugin.webview.stub.e locale = this.kYt;
      if (locale == null) {
        d.g.b.k.aVY("invoker");
      }
      if (locale != null)
      {
        locale = this.kYt;
        if (locale == null) {
          d.g.b.k.aVY("invoker");
        }
        locale.Vv(eyt());
        locale = this.kYt;
        if (locale == null) {
          d.g.b.k.aVY("invoker");
        }
        locale.Vw(eyt());
      }
      com.tencent.mm.sdk.platformtools.ac.i(eyn(), "removeInvoker ok");
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.w(eyn(), "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException)));
    }
  }
  
  public final boolean eyC()
  {
    return UB(this.Cdx);
  }
  
  protected void eyD() {}
  
  protected void eyE() {}
  
  public final boolean eyF()
  {
    return !UA(this.Cdx);
  }
  
  public final String eyn()
  {
    return (String)this.CcW.getValue();
  }
  
  protected abstract Class<? extends Service> eyo();
  
  protected abstract Set<String> eyp();
  
  public final com.tencent.mm.plugin.webview.e.c eyq()
  {
    return (com.tencent.mm.plugin.webview.e.c)this.CcZ.getValue();
  }
  
  public final com.tencent.mm.plugin.webview.stub.e eyr()
  {
    com.tencent.mm.plugin.webview.stub.e locale = this.kYt;
    if (locale == null) {
      d.g.b.k.aVY("invoker");
    }
    return locale;
  }
  
  public final int eyt()
  {
    return ((Number)this.Cdh.getValue()).intValue();
  }
  
  public final Runnable eyu()
  {
    return (Runnable)this.Cdj.getValue();
  }
  
  public final String eyv()
  {
    return (String)this.Cdt.getValue();
  }
  
  protected final boolean eyx()
  {
    try
    {
      boolean bool = d.a.j.a((Iterable)this.CdI, w.bn(Inject.class).getSimpleName());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void eyy() {}
  
  public boolean eyz()
  {
    return false;
  }
  
  public final void g(final String paramString, final d.g.a.b<? super String, y> paramb)
  {
    d.g.b.k.h(paramString, "script");
    com.tencent.mm.ac.c.g((d.g.a.a)new u(this, paramString, paramb));
  }
  
  protected final Context getContext()
  {
    Context localContext = this.nKq.getContext();
    d.g.b.k.g(localContext, "viewWV.context");
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    if (n.aD((CharSequence)this.Cdc)) {
      return this.Cdb;
    }
    return this.Cdc;
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = this.intent;
    if (localIntent == null) {
      d.g.b.k.aVY("intent");
    }
    return localIntent;
  }
  
  public final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    return (com.tencent.mm.plugin.webview.c.f)this.Cdg.getValue();
  }
  
  protected final int getScreenOrientation()
  {
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
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
    eyw();
    Uz(this.Cdu);
    this.nKq.a((com.tencent.mm.ui.widget.i)new d());
  }
  
  protected final boolean isStarted()
  {
    try
    {
      boolean bool = d.a.j.a((Iterable)this.CdJ, w.bn(Start.class).getSimpleName());
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
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    while (localIterator.hasNext())
    {
      j.a locala = ((j)localIterator.next()).n(paramWebView, paramString);
      if (locala.CfL) {
        return locala;
      }
    }
    return new j.a(false, false);
  }
  
  public final c.a k(String paramString, boolean paramBoolean, int paramInt)
  {
    d.g.b.k.h(paramString, "url");
    if (this.CdP.CdX)
    {
      com.tencent.mm.sdk.platformtools.ac.w(eyn(), "startGetA8Key neverGetA8Key ".concat(String.valueOf(paramString)));
      return c.a.Ctm;
    }
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).aBa(paramString)) {
        return c.a.Ctl;
      }
    }
    paramString = eyq().a(paramString, paramBoolean, paramInt, (com.tencent.mm.plugin.webview.e.a)this.CcX.getValue());
    d.g.b.k.g(paramString, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
    return paramString;
  }
  
  protected boolean k(WebView paramWebView, String paramString)
  {
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramString, "url");
    paramWebView = j(paramWebView, paramString);
    if (paramWebView.CfL) {
      return paramWebView.result;
    }
    return false;
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "WebView-Trace loadUrl url ".concat(String.valueOf(paramString)));
    if (paramBoolean)
    {
      this.nKq.loadUrl(paramString, (Map)ae.c(new d.o[] { d.u.Q("Pragma", "no-cache"), d.u.Q("Cache-Control", "no-cache") }));
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    if (i != 0)
    {
      this.nKq.loadUrl(paramString);
      return;
    }
    this.nKq.loadUrl(paramString, paramMap);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 1956	com/tencent/mm/plugin/webview/core/BaseWebViewController:Cdd	Z
    //   7: aload_0
    //   8: getfield 1954	com/tencent/mm/plugin/webview/core/BaseWebViewController:Cde	Z
    //   11: ifne +7 -> 18
    //   14: aload_0
    //   15: invokevirtual 2051	com/tencent/mm/plugin/webview/core/BaseWebViewController:eyB	()V
    //   18: aload_0
    //   19: getfield 2053	com/tencent/mm/plugin/webview/core/BaseWebViewController:CdL	Lcom/tencent/mm/plugin/webview/core/c;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +27 -> 51
    //   27: aload_1
    //   28: checkcast 2055	java/io/Closeable
    //   31: astore_3
    //   32: aload_0
    //   33: invokevirtual 878	com/tencent/mm/plugin/webview/core/BaseWebViewController:eyn	()Ljava/lang/String;
    //   36: ldc_w 2057
    //   39: invokestatic 950	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 2063	d/y:KTp	Ld/y;
    //   45: astore_1
    //   46: aload_3
    //   47: aconst_null
    //   48: invokestatic 2068	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   51: aload_0
    //   52: invokevirtual 2070	com/tencent/mm/plugin/webview/core/BaseWebViewController:aMd	()Lcom/tencent/mm/sdk/platformtools/ao;
    //   55: aload_0
    //   56: invokevirtual 2072	com/tencent/mm/plugin/webview/core/BaseWebViewController:eyu	()Ljava/lang/Runnable;
    //   59: invokevirtual 2075	com/tencent/mm/sdk/platformtools/ao:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   62: aload_0
    //   63: invokevirtual 1923	com/tencent/mm/plugin/webview/core/BaseWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   66: invokevirtual 2078	com/tencent/mm/plugin/webview/c/f:detach	()V
    //   69: aload_0
    //   70: invokespecial 1071	com/tencent/mm/plugin/webview/core/BaseWebViewController:eys	()Lcom/tencent/mm/plugin/webview/c/i;
    //   73: invokevirtual 2079	com/tencent/mm/plugin/webview/c/i:detach	()V
    //   76: aload_0
    //   77: invokevirtual 804	com/tencent/mm/plugin/webview/core/BaseWebViewController:eyq	()Lcom/tencent/mm/plugin/webview/e/c;
    //   80: invokevirtual 2081	com/tencent/mm/plugin/webview/e/c:destroy	()V
    //   83: return
    //   84: astore_2
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_3
    //   89: aload_2
    //   90: invokestatic 2068	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    Iterator localIterator = ((Iterable)this.Cdp).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onFinish();
    }
  }
  
  public final void reload()
  {
    if ((this.nKq == null) || (bs.isNullOrNil(this.nKq.getUrl()))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      String str = this.nKq.getUrl();
      d.g.b.k.g(str, "viewWV.url");
      if (localj.Ui(KQ(str))) {
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ac.i(eyn(), "reload");
    this.nKq.reload();
  }
  
  protected final void setIntent(Intent paramIntent)
  {
    d.g.b.k.h(paramIntent, "<set-?>");
    this.intent = paramIntent;
  }
  
  protected final void uf(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.Cdp).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).uf(paramBoolean);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Auth
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(205416);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(w.bn(BaseWebViewController.Inject.class), paramString)) && (waitFor(localBaseWebViewController.Cdv)) && ((localBaseWebViewController.CdP.CdX) || (localBaseWebViewController.kYu.has(paramString)) || (waitFor(localBaseWebViewController.Cdy, paramString))))
      {
        AppMethodBeat.o(205416);
        return true;
      }
      AppMethodBeat.o(205416);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Bind
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(205418);
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(localBaseWebViewController.Cdw)) && (waitFor(localBaseWebViewController.Cdv)))
      {
        AppMethodBeat.o(205418);
        return true;
      }
      AppMethodBeat.o(205418);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  public static abstract class ControllerAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Init
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(205420);
      boolean bool = waitFor(getController().Cdu);
      AppMethodBeat.o(205420);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Inject
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(205421);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((!localBaseWebViewController.nKq.fuP()) && (!waitFor(localBaseWebViewController.CdA, paramString))) || (((waitFor(localBaseWebViewController.Cdv)) && ((localBaseWebViewController.CdP.CdX) || (localBaseWebViewController.kYu.has(paramString)) || (waitFor(localBaseWebViewController.Cdy, paramString)))) || (localBaseWebViewController.bLN())))
      {
        AppMethodBeat.o(205421);
        return true;
      }
      AppMethodBeat.o(205421);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"})
  @Keep
  protected static abstract class PageAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify(String paramString);
    
    public final boolean waitFor(int paramInt, String paramString)
    {
      d.g.b.k.h(paramString, "url");
      return (d.g.b.k.g(paramString, getController().Cda)) && (BaseWebViewController.b(getController()).contains(Integer.valueOf(paramInt)));
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Ready
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(205425);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((waitFor(w.bn(BaseWebViewController.Start.class))) && (waitFor(w.bn(BaseWebViewController.Auth.class), paramString)) && ((waitFor(localBaseWebViewController.CdB, paramString)) || (localBaseWebViewController.nKq.fuP()))) || (localBaseWebViewController.bLO()))
      {
        AppMethodBeat.o(205425);
        return true;
      }
      AppMethodBeat.o(205425);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"})
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
      AppMethodBeat.i(205426);
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(w.bn(BaseWebViewController.Ready.class), paramString)) && (waitFor(localBaseWebViewController.CdC, paramString)))
      {
        AppMethodBeat.o(205426);
        return true;
      }
      AppMethodBeat.o(205426);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Start
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(205427);
      Object localObject = getController();
      if ((waitFor(((BaseWebViewController)localObject).Cdw)) && ((!((BaseWebViewController)localObject).bLS()) || (waitFor(((BaseWebViewController)localObject).Cdv))))
      {
        if (((CharSequence)((BaseWebViewController)localObject).bLL()).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            localObject = (CharSequence)((BaseWebViewController)localObject).eyv();
            if ((localObject != null) && (!n.aD((CharSequence)localObject))) {
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
          AppMethodBeat.o(205427);
          return true;
          i = 0;
          break;
        }
      }
      label102:
      AppMethodBeat.o(205427);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"})
  @Keep
  public static abstract class WebAction
  {
    public BaseWebViewController controller;
    private final boolean keep;
    
    public final BaseWebViewController getController()
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aVY("controller");
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
        d.g.b.k.aVY("controller");
      }
      return BaseWebViewController.c(localBaseWebViewController).contains(Integer.valueOf(paramInt));
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.ControllerAction> paramb)
    {
      d.g.b.k.h(paramb, "clazz");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aVY("controller");
      }
      return d.a.j.a((Iterable)BaseWebViewController.d(localBaseWebViewController), paramb.getSimpleName());
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.PageAction> paramb, String paramString)
    {
      d.g.b.k.h(paramb, "clazz");
      d.g.b.k.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.k.aVY("controller");
      }
      if (d.g.b.k.g(paramString, localBaseWebViewController.Cda))
      {
        paramString = this.controller;
        if (paramString == null) {
          d.g.b.k.aVY("controller");
        }
        if (d.a.j.a((Iterable)BaseWebViewController.e(paramString), paramb.getSimpleName())) {
          return true;
        }
      }
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    a(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
  static final class aa
    extends d.g.b.l
    implements d.g.a.a<Runnable>
  {
    aa(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"})
  public static final class ab
    extends k
  {
    public final void finish()
    {
      AppMethodBeat.i(205472);
      if (!this.CdS.bLM())
      {
        AppMethodBeat.o(205472);
        return;
      }
      this.CdS.aMd().removeCallbacks(this.CdS.eyu());
      com.tencent.e.h.JZN.aQ((Runnable)new a(this));
      AppMethodBeat.o(205472);
    }
    
    public final void zB(long paramLong)
    {
      AppMethodBeat.i(205473);
      this.CdS.aMd().postDelayed(this.CdS.eyu(), paramLong);
      AppMethodBeat.o(205473);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BaseWebViewController.ab paramab) {}
      
      public final void run()
      {
        AppMethodBeat.i(205471);
        Iterator localIterator = ((Iterable)this.Cel.CdS.Cdp).iterator();
        while (localIterator.hasNext()) {
          ((i)localIterator.next()).eyY();
        }
        AppMethodBeat.o(205471);
      }
    }
  }
  
  @d.d.b.a.e(c="com.tencent.mm.plugin.webview.core.BaseWebViewController$start$1", f="BaseWebViewController.kt", l={}, m="invokeSuspend")
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class ac
    extends d.d.b.a.i
    implements m<ag, d.d.d<? super y>, Object>
  {
    int label;
    private ag nvs;
    
    ac(BaseWebViewController paramBaseWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(205475);
      d.g.b.k.h(paramd, "completion");
      paramd = new ac(this.CdS, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(205475);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(205474);
      paramObject = d.d.a.a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(205474);
        throw paramObject;
      }
      this.CdS.Uz(this.CdS.Cdw);
      paramObject = y.KTp;
      AppMethodBeat.o(205474);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(205476);
      paramObject1 = ((ac)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(205476);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/BaseWebViewController$tryBindService$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class ad
    implements d
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(205477);
      d.g.b.k.h(paramc, "conn");
      if (this.CdS.eyA())
      {
        com.tencent.mm.sdk.platformtools.ac.i(BaseWebViewController.a(this.CdS), "WebView-Trace onConnected whent destroyCalled");
        AppMethodBeat.o(205477);
        return;
      }
      this.CdS.CdL = paramc;
      BaseWebViewController localBaseWebViewController = this.CdS;
      paramc = paramc.eyr();
      d.g.b.k.h(paramc, "<set-?>");
      localBaseWebViewController.kYt = paramc;
      this.CdS.getJsapi().b(this.CdS.eyr());
      this.CdS.a(this.CdS.eyr());
      com.tencent.mm.sdk.platformtools.ac.i(BaseWebViewController.a(this.CdS), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
      if (d.a.j.a((Iterable)BaseWebViewController.d(this.CdS), w.bn(BaseWebViewController.Bind.class).getSimpleName()))
      {
        this.CdS.dKr();
        AppMethodBeat.o(205477);
        return;
      }
      this.CdS.Uz(this.CdS.Cdv);
      AppMethodBeat.o(205477);
    }
    
    public final boolean eyG()
    {
      AppMethodBeat.i(205478);
      boolean bool = this.CdS.eyz();
      AppMethodBeat.o(205478);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class ae
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public static final ae Cem;
    
    static
    {
      AppMethodBeat.i(205480);
      Cem = new ae();
      AppMethodBeat.o(205480);
    }
    
    ae()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class af
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    public static final af Cen;
    
    static
    {
      AppMethodBeat.i(205482);
      Cen = new af();
      AppMethodBeat.o(205482);
    }
    
    af()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"})
  public static final class ag
    implements g.b
  {
    public final String eyH()
    {
      AppMethodBeat.i(205483);
      String str = this.CdS.getCurrentUrl();
      AppMethodBeat.o(205483);
      return str;
    }
    
    public final String eyI()
    {
      return this.CdS.Cdb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"})
  public static final class b
  {
    public static String aS(Intent paramIntent)
    {
      AppMethodBeat.i(205419);
      d.g.b.k.h(paramIntent, "intent");
      try
      {
        String str1 = paramIntent.getStringExtra("rawUrl");
        CharSequence localCharSequence = (CharSequence)str1;
        if ((localCharSequence == null) || (n.aD(localCharSequence)))
        {
          i = 1;
          if (i != 0) {
            break label95;
          }
          AppMethodBeat.o(205419);
          return str1;
        }
      }
      catch (Exception localException)
      {
        String str2;
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.WebViewController", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
          if ((localException instanceof ClassNotFoundException))
          {
            paramIntent = (Throwable)localException;
            AppMethodBeat.o(205419);
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
        AppMethodBeat.o(205419);
      }
      return paramIntent;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZ)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getNeverGetA8Key", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"})
  public static final class c
  {
    final BaseWebViewController.f CdT;
    final boolean CdU;
    final boolean CdV;
    final boolean CdW;
    final boolean CdX;
    
    public c(byte paramByte)
    {
      this();
    }
    
    public c(BaseWebViewController.f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      AppMethodBeat.i(205422);
      this.CdT = paramf;
      this.CdU = paramBoolean1;
      this.CdV = paramBoolean2;
      this.CdW = paramBoolean3;
      this.CdX = paramBoolean4;
      AppMethodBeat.o(205422);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"})
  final class d
    extends com.tencent.mm.ui.widget.i
  {
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(205424);
      if ((paramInt >= 100) && (!this.CdS.eyA()))
      {
        this.CdS.Cds = true;
        com.tencent.mm.sdk.platformtools.ac.i(BaseWebViewController.a(this.CdS), "Abe-Debug Progress 100");
        if (paramWebView != null)
        {
          Object localObject;
          if (paramWebView.supportFeature(2006))
          {
            localObject = f.Cep;
            if (!f.a.eyL()) {}
          }
          else
          {
            localObject = paramWebView.getUrl();
            if (localObject != null)
            {
              if (((CharSequence)localObject).length() == 0) {}
              for (paramInt = 1; paramInt == 0; paramInt = 0)
              {
                localObject = this.CdS;
                paramInt = this.CdS.CdA;
                BaseWebViewController localBaseWebViewController = this.CdS;
                paramWebView = paramWebView.getUrl();
                d.g.b.k.g(paramWebView, "url");
                ((BaseWebViewController)localObject).cr(paramInt, BaseWebViewController.c(localBaseWebViewController, paramWebView));
                AppMethodBeat.o(205424);
                return;
              }
            }
            com.tencent.mm.sdk.platformtools.ac.i(BaseWebViewController.a(this.CdS), "WebView-Trace not support PAGE_COMMIT_VISIBLE, url = null, skip check");
          }
          AppMethodBeat.o(205424);
          return;
        }
      }
      AppMethodBeat.o(205424);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", "action", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class e
  {
    final d.l.b<? extends BaseWebViewController.WebAction> CdY;
    final d.g.a.a<y> gMY;
    
    public e(d.l.b<? extends BaseWebViewController.WebAction> paramb, d.g.a.a<y> parama)
    {
      AppMethodBeat.i(205428);
      this.CdY = paramb;
      this.gMY = parama;
      AppMethodBeat.o(205428);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205431);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!d.g.b.k.g(this.CdY, paramObject.CdY)) || (!d.g.b.k.g(this.gMY, paramObject.gMY))) {}
        }
      }
      else
      {
        AppMethodBeat.o(205431);
        return true;
      }
      AppMethodBeat.o(205431);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(205430);
      Object localObject = this.CdY;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.gMY;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(205430);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205429);
      String str = "WebEvent(action=" + this.CdY + ", block=" + this.gMY + ")";
      AppMethodBeat.o(205429);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"})
  public static final class f
  {
    final d.f CdZ;
    final d.f Cea;
    final d.f Ceb;
    final d.f Cec;
    
    static
    {
      AppMethodBeat.i(205436);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(f.class), "enablePlugin", "getEnablePlugin()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(f.class), "enableZoom", "getEnableZoom()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(f.class), "enableJavascript", "getEnableJavascript()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(f.class), "enableVerticalScroll", "getEnableVerticalScroll()Z")) };
      AppMethodBeat.o(205436);
    }
    
    public f(Intent paramIntent)
    {
      AppMethodBeat.i(205437);
      this.CdZ = d.g.K((d.g.a.a)new b(paramIntent));
      this.Cea = d.g.K((d.g.a.a)new d(paramIntent));
      this.Ceb = d.g.K((d.g.a.a)new a(paramIntent));
      this.Cec = d.g.K((d.g.a.a)new c(paramIntent));
      AppMethodBeat.o(205437);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      a(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      b(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<Boolean>
    {
      c(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.c>
  {
    public static final g Ced;
    
    static
    {
      AppMethodBeat.i(205440);
      Ced = new g();
      AppMethodBeat.o(205440);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    l(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    n(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.f<arn>>
  {
    o(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class p
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    p(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class q
    implements Runnable
  {
    q(BaseWebViewController paramBaseWebViewController, int paramInt) {}
    
    public final void run()
    {
      int j = 0;
      AppMethodBeat.i(205454);
      if (paramInt < 0) {}
      for (int i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(205454);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.sdk.platformtools.ac.i(BaseWebViewController.a(this.CdS), "checkStatus:" + paramInt + " to [" + d.a.j.a((Iterable)BaseWebViewController.c(this.CdS), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.b(this.CdS), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.e(this.CdS), (CharSequence)",", null, null, 0, null, null, 62) + ']');
      BaseWebViewController.c(this.CdS).add(Integer.valueOf(paramInt));
      BaseWebViewController.a(this.CdS, (Iterable)BaseWebViewController.f(this.CdS), (Set)BaseWebViewController.d(this.CdS));
      Object localObject = (CharSequence)this.CdS.Cda;
      if (localObject != null)
      {
        i = j;
        if (!n.aD((CharSequence)localObject)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        BaseWebViewController.a(this.CdS, (Iterable)BaseWebViewController.g(this.CdS), (Set)BaseWebViewController.e(this.CdS), this.CdS.Cda);
      }
      d.a.j.a((Iterable)BaseWebViewController.a(this.CdS, paramInt), (d.g.a.b)1.Cef);
      AppMethodBeat.o(205454);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(205455);
      Object localObject;
      if (paramInt > 0)
      {
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (n.aD((CharSequence)localObject)))
        {
          i = 1;
          if (i != 0) {
            break label74;
          }
        }
      }
      label74:
      for (int i = 1;; i = 0)
      {
        if ((!aa.KTq) || (i != 0)) {
          break label79;
        }
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(205455);
        throw ((Throwable)localObject);
        i = 0;
        break;
      }
      label79:
      if ((d.g.b.k.g(paramString, this.CdS.Cda)) || ((this.CdS.CdD.contains(Integer.valueOf(paramInt))) && (d.g.b.k.g(paramString, this.CdS.Cdc))))
      {
        com.tencent.mm.sdk.platformtools.ac.i(BaseWebViewController.a(this.CdS), "checkStatus:" + paramInt + ' ' + paramString + " to [" + d.a.j.a((Iterable)BaseWebViewController.c(this.CdS), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.b(this.CdS), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.e(this.CdS), (CharSequence)",", null, null, 0, null, null, 62) + ']');
        BaseWebViewController.b(this.CdS).add(Integer.valueOf(paramInt));
        BaseWebViewController.a(this.CdS, (Iterable)BaseWebViewController.g(this.CdS), (Set)BaseWebViewController.e(this.CdS), this.CdS.Cda);
        AppMethodBeat.o(205455);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.w(BaseWebViewController.a(this.CdS), "checkStatus skip: " + paramInt + ", url=" + paramString + ", startUrl=" + this.CdS.Cda);
      AppMethodBeat.o(205455);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    s(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    t(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    u(BaseWebViewController paramBaseWebViewController, String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.a<ao>
  {
    public static final v Ceh;
    
    static
    {
      AppMethodBeat.i(205461);
      Ceh = new v();
      AppMethodBeat.o(205461);
    }
    
    v()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"setConfigCallback", "", "windowManager", "Landroid/view/WindowManager;", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.b<WindowManager, y>
  {
    public static final w Cei;
    
    static
    {
      AppMethodBeat.i(205464);
      Cei = new w();
      AppMethodBeat.o(205464);
    }
    
    w()
    {
      super();
    }
    
    public static void b(WindowManager paramWindowManager)
    {
      AppMethodBeat.i(205463);
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
          AppMethodBeat.o(205463);
          return;
        }
        localField = localField.getType().getDeclaredField("mWindowManager");
        d.g.b.k.g(localField, "field");
        localField.setAccessible(true);
        localField.set(localObject, paramWindowManager);
        AppMethodBeat.o(205463);
        return;
      }
      catch (Exception paramWindowManager)
      {
        AppMethodBeat.o(205463);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.i>
  {
    x(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.f>
  {
    y(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class z
    implements Runnable
  {
    z(BaseWebViewController paramBaseWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(205467);
      this.CdS.Cdl.finish();
      AppMethodBeat.o(205467);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController
 * JD-Core Version:    0.7.0.1
 */