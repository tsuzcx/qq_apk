package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import androidx.annotation.Keep;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.f.c.a;
import com.tencent.mm.plugin.webview.f.g.b;
import com.tencent.mm.plugin.webview.k.h.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ad;
import com.tencent.xweb.r;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.g.b.ab;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.br;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_PROGRESS_CACHE_LOAD_START", "getCONTROLLER_PROGRESS_CACHE_LOAD_START", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_LOAD_PROGRESS_FULL", "getPAGE_LOAD_PROGRESS_FULL", "PAGE_PROGRESS_NO_FRAME_AUTH_START", "getPAGE_PROGRESS_NO_FRAME_AUTH_START", "PAGE_PROGRESS_SHOW_TIME_OUT", "getPAGE_PROGRESS_SHOW_TIME_OUT", "PAGE_PROGRESS_STATUS", "getPAGE_PROGRESS_STATUS", "()Ljava/util/Set;", "PAGE_PROGRESS_WEBVIEW_START", "getPAGE_PROGRESS_WEBVIEW_START", "PAGE_SPA_STATUS", "getPAGE_SPA_STATUS", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/concurrent/ConcurrentSkipListSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "hasStartCalled", "getHasStartCalled", "setHasStartCalled", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isInject", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "keyDownBackCount", "getKeyDownBackCount", "setKeyDownBackCount", "(I)V", "keyDownTime", "", "getKeyDownTime", "()J", "setKeyDownTime", "(J)V", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "openQuickAppIntercept", "getOpenQuickAppIntercept", "openQuickAppIntercept$delegate", "openQuickAppReport", "getOpenQuickAppReport", "openQuickAppReport$delegate", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageErrorMonitor", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "getPageErrorMonitor", "()Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "pageErrorMonitor$delegate", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "prefetchNewReportInfo", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchNewReportInfo;", "getPrefetchNewReportInfo", "()Lcom/tencent/mm/plugin/webview/reporter/PrefetchNewReportInfo;", "setPrefetchNewReportInfo", "(Lcom/tencent/mm/plugin/webview/reporter/PrefetchNewReportInfo;)V", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "updateRandomStr", "getUpdateRandomStr", "updateRandomStr$delegate", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "webPrefetchPage", "getWebPrefetchPage", "setWebPrefetchPage", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", "listener", "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canLoadUrl", "url", "canShowRefresh", "checkStatus", "check", "dealSPAUpdate", "destroy", "doAuthCurrentUrl", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", "request", "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCachedAppId", "getCallBackUrl", "getPageLoadType", "getShareUrl", "getStatusListener", "hasCurrentPageFinished", "hasCurrentPageStarted", "hasStatus", "init", "initEnviroment", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onKeyDownBack", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", "error", "Lcom/tencent/xweb/WebResourceError;", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "Lcom/tencent/xweb/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onUrlRedirect", "forceRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeClientListener", "removeControllerListener", "removeInterceptor", "removeInvoker", "floating", "removeStatus", "resetActions", "resetPageActions", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "updateDgtVerify", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "BaseWebViewUIConnectionBinder", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "PageLoadEndForCommitNotSupport", "ProgressBarEnd", "ProgressBarStart", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"})
public abstract class BaseWebViewController
  extends ad
  implements com.tencent.mm.plugin.webview.f.a<bot>
{
  private static final String[] PGN = { "https://statres.quickapp.cn/quickapp/js/routerinline.min.js", "http://fastappjump-drcn.hispace.hicloud.com/", "http://thefatherofsalmon.com/", "http://v2.thefatherofsalmon.com/" };
  public static final c PGO = new c((byte)0);
  private final kotlin.f PFE;
  public com.tencent.mm.plugin.webview.i.b PFF;
  private final kotlin.f PFG;
  private int PFH;
  private long PFI;
  private boolean PFJ;
  public String PFK;
  private final kotlin.f PFL;
  String PFM;
  public String PFN;
  String PFO;
  public boolean PFP;
  private boolean PFQ;
  public boolean PFR;
  private final kotlin.f PFS;
  private final kotlin.f PFT;
  private final kotlin.f PFU;
  public final Map<String, String> PFV;
  private final kotlin.f PFW;
  public final l PFX;
  public final com.tencent.mm.plugin.webview.k.n PFY;
  private final kotlin.f PFZ;
  private final ConcurrentSkipListSet<Integer> PGA;
  private final ConcurrentSkipListSet<String> PGB;
  private final ConcurrentSkipListSet<String> PGC;
  public final boolean PGD;
  c PGE;
  private final kotlin.f PGF;
  private boolean PGG;
  private final kotlin.f PGH;
  private final kotlin.f PGI;
  private final kotlin.f PGJ;
  public final d PGK;
  private Set<String> PGL;
  private com.tencent.mm.plugin.webview.d.e PGM;
  private final ConcurrentLinkedDeque<f> PGa;
  public final ConcurrentLinkedDeque<j> PGb;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<kotlin.g.a.a<x>>> PGc;
  public boolean PGd;
  boolean PGe;
  private final kotlin.f PGf;
  final int PGg;
  public final int PGh;
  public final int PGi;
  public final int PGj;
  protected final int PGk;
  final int PGl;
  final int PGm;
  public final int PGn;
  final int PGo;
  final int PGp;
  final int PGq;
  public final int PGr;
  final int PGs;
  final int PGt;
  final Set<Integer> PGu;
  final Set<Integer> PGv;
  private final boolean PGw;
  private final ConcurrentLinkedDeque<o<ControllerAction, kotlin.g.a.a<x>>> PGx;
  private final ConcurrentLinkedDeque<o<PageAction, kotlin.g.a.a<x>>> PGy;
  public final ConcurrentSkipListSet<Integer> PGz;
  public final ConcurrentLinkedDeque<k> PwK;
  private String fba;
  protected Intent intent;
  private final kotlin.f ocu;
  public com.tencent.mm.plugin.webview.stub.e pGC;
  public final com.tencent.mm.plugin.webview.f.g pGD;
  public final MMWebView pHS;
  private final List<f> sRc;
  
  public BaseWebViewController(MMWebView paramMMWebView, d paramd, Set<String> paramSet, com.tencent.mm.plugin.webview.d.e parame)
  {
    this.pHS = paramMMWebView;
    this.PGK = paramd;
    this.PGL = paramSet;
    this.PGM = parame;
    this.PFE = kotlin.g.ar((kotlin.g.a.a)new a(this));
    this.PFF = new com.tencent.mm.plugin.webview.i.b();
    this.PFG = kotlin.g.ar((kotlin.g.a.a)new s(this));
    this.PFL = kotlin.g.ar((kotlin.g.a.a)h.PHc);
    this.fba = "";
    this.PFM = "";
    this.PFN = "";
    this.PFO = "";
    this.PFS = kotlin.g.ar((kotlin.g.a.a)new ab(this));
    this.PFT = kotlin.g.ar((kotlin.g.a.a)new ac(this));
    this.PFU = kotlin.g.ar((kotlin.g.a.a)new t(this));
    this.ocu = kotlin.g.ar((kotlin.g.a.a)z.PHg);
    this.pGD = new com.tencent.mm.plugin.webview.f.g((g.b)new an(this));
    this.PFV = ((Map)new HashMap());
    this.PFW = kotlin.g.ar((kotlin.g.a.a)new ai(this));
    this.PFX = ((l)new aj(this));
    this.PFY = new com.tencent.mm.plugin.webview.k.n();
    this.PFZ = kotlin.g.ar((kotlin.g.a.a)new ah(this));
    this.PwK = new ConcurrentLinkedDeque();
    this.PGa = new ConcurrentLinkedDeque();
    this.PGb = new ConcurrentLinkedDeque();
    this.PGc = new ConcurrentHashMap();
    this.PGf = kotlin.g.ar((kotlin.g.a.a)new w(this));
    this.PGg = -1;
    this.PGh = -2;
    this.PGi = -3;
    this.PGj = -10;
    this.PGk = -5;
    this.PGl = 1;
    this.PGm = 2;
    this.PGn = 3;
    this.PGo = 4;
    this.PGp = 6;
    this.PGq = 10;
    this.PGr = 11;
    this.PGs = 12;
    this.PGt = 13;
    this.PGu = kotlin.a.ak.setOf(new Integer[] { Integer.valueOf(this.PGr), Integer.valueOf(this.PGs), Integer.valueOf(this.PGq), Integer.valueOf(this.PGt) });
    this.PGv = kotlin.a.ak.setOf(new Integer[] { Integer.valueOf(this.PGn), Integer.valueOf(this.PGo), Integer.valueOf(this.PGp) });
    this.PGw = true;
    this.sRc = kotlin.a.j.mutableListOf(new f[] { new f(ab.bO(Init.class), (kotlin.g.a.a)new i((BaseWebViewController)this)), new f(ab.bO(PageLoadEndForCommitNotSupport.class), (kotlin.g.a.a)new k(this)), new f(ab.bO(Inject.class), (kotlin.g.a.a)new l(this)), new f(ab.bO(Bind.class), (kotlin.g.a.a)new m((BaseWebViewController)this)), new f(ab.bO(Auth.class), (kotlin.g.a.a)new n(this)), new f(ab.bO(Ready.class), (kotlin.g.a.a)new o(this)), new f(ab.bO(Start.class), (kotlin.g.a.a)new p(this)), new f(ab.bO(SPAUpdated.class), (kotlin.g.a.a)new q(this)), new f(ab.bO(ProgressBarStart.class), (kotlin.g.a.a)new r(this)), new f(ab.bO(ProgressBarEnd.class), (kotlin.g.a.a)new j(this)) });
    this.PGx = new ConcurrentLinkedDeque();
    this.PGy = new ConcurrentLinkedDeque();
    this.PGz = new ConcurrentSkipListSet();
    this.PGA = new ConcurrentSkipListSet();
    this.PGB = new ConcurrentSkipListSet();
    this.PGC = new ConcurrentSkipListSet();
    this.PGD = gSl().gUz();
    this.PGF = kotlin.g.ar((kotlin.g.a.a)al.PHl);
    this.PGH = kotlin.g.ar((kotlin.g.a.a)am.PHm);
    this.PGI = kotlin.g.ar((kotlin.g.a.a)ag.PHj);
    this.PGJ = kotlin.g.ar((kotlin.g.a.a)af.PHi);
  }
  
  private final <T extends WebAction> void a(Iterable<? extends o<? extends T, ? extends kotlin.g.a.a<x>>> paramIterable, Set<String> paramSet, String paramString)
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
        paramIterable = (o)localIterator.next();
        localWebAction = (WebAction)paramIterable.Mx;
        paramIterable = (kotlin.g.a.a)paramIterable.My;
        if (!(localWebAction instanceof PageAction)) {
          break label235;
        }
        if ((paramString != null) && (((PageAction)localWebAction).verify(paramString)))
        {
          bool = true;
          if (!bool) {
            continue;
          }
          Log.i(gSh(), "verify WebAction: " + ab.bO(localWebAction.getClass()).iCe() + " start");
          if (!localWebAction.getKeep()) {
            localIterator.remove();
          }
          paramIterable.invoke();
          String str = ab.bO(localWebAction.getClass()).iCe();
          paramIterable = str;
          if (str == null) {
            paramIterable = "";
          }
          paramSet.add(paramIterable);
          Log.v(gSh(), "verifyActions: " + ab.bO(localWebAction.getClass()).iCe() + " end");
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
  
  private final String afQ(String paramString)
  {
    if (!aqm(paramString)) {
      paramString = this.PFN;
    }
    for (;;)
    {
      String str = paramString;
      if (kotlin.n.n.ba((CharSequence)paramString))
      {
        str = paramString;
        if (anw(this.PGi)) {
          str = cDu();
        }
      }
      return str;
    }
  }
  
  private boolean anx(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!kotlin.z.aazO) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.PGA.remove(Integer.valueOf(paramInt));
    return bool;
  }
  
  private final String bjn(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!com.tencent.luggage.k.c.a(paramString, "about:blank", true)))
      {
        localObject = paramString;
        if (!com.tencent.luggage.k.c.a(paramString, "data:text/html;charset=utf-8", true)) {}
      }
      else
      {
        localObject = this.fba;
      }
      return localObject;
    }
  }
  
  private final void bjq(String paramString)
  {
    try
    {
      Log.i(gSh(), "resetPageActions clear status:" + paramString + ", [" + kotlin.a.j.a((Iterable)this.PGz, (CharSequence)",", null, null, 0, null, null, 62) + "] actions: [" + kotlin.a.j.a((Iterable)this.PGB, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      this.PGz.clear();
      this.PGB.clear();
      this.PGy.clear();
      this.PGe = false;
      Iterator localIterator = ((Iterable)cDy()).iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        Object localObject = kotlin.l.a.c.d(localf.PGX);
        ((WebAction)localObject).setController((BaseWebViewController)this);
        localObject = (WebAction)localObject;
        if ((localObject instanceof PageAction)) {
          this.PGy.add(s.M(localObject, localf.kRn));
        }
      }
      bjo(paramString);
    }
    finally {}
    this.PFO = "";
  }
  
  private final int bjr(String paramString)
  {
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    while (localIterator.hasNext())
    {
      int i = ((k)localIterator.next()).bjr(paramString);
      if (i != -1) {
        return i;
      }
    }
    return gSl().blC(paramString);
  }
  
  private final void bjw(String paramString)
  {
    if ((((Boolean)this.PGF.getValue()).booleanValue()) && (!this.pHS.dwQ()) && (!anw(this.PGj)) && (paramString != null) && (!kotlin.n.n.M(paramString, "file:", false)) && (!gSt()))
    {
      paramString = getJsapi();
      if (paramString != null) {
        paramString.gTM();
      }
    }
  }
  
  public static final String bk(Intent paramIntent)
  {
    return c.bk(paramIntent);
  }
  
  private final String gSh()
  {
    return (String)this.PFE.getValue();
  }
  
  private final e gSq()
  {
    return (e)this.PFZ.getValue();
  }
  
  /* Error */
  private final void gSs()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 940	com/tencent/mm/plugin/webview/core/BaseWebViewController:gSh	()Ljava/lang/String;
    //   6: ldc_w 1201
    //   9: invokestatic 1013	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 885	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGA	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   16: invokevirtual 1114	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   19: aload_0
    //   20: getfield 889	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGC	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   23: invokevirtual 1114	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   26: aload_0
    //   27: getfield 876	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGx	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   30: invokevirtual 1115	java/util/concurrent/ConcurrentLinkedDeque:clear	()V
    //   33: aload_0
    //   34: getfield 883	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGz	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   37: invokevirtual 1114	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   40: aload_0
    //   41: getfield 887	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGB	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   44: invokevirtual 1114	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   47: aload_0
    //   48: getfield 878	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGy	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   51: invokevirtual 1115	java/util/concurrent/ConcurrentLinkedDeque:clear	()V
    //   54: aload_0
    //   55: invokevirtual 1120	com/tencent/mm/plugin/webview/core/BaseWebViewController:cDy	()Ljava/util/List;
    //   58: checkcast 956	java/lang/Iterable
    //   61: invokeinterface 960 1 0
    //   66: astore_1
    //   67: aload_1
    //   68: invokeinterface 965 1 0
    //   73: ifeq +91 -> 164
    //   76: aload_1
    //   77: invokeinterface 969 1 0
    //   82: checkcast 92	com/tencent/mm/plugin/webview/core/BaseWebViewController$f
    //   85: astore_2
    //   86: aload_2
    //   87: getfield 1124	com/tencent/mm/plugin/webview/core/BaseWebViewController$f:PGX	Lkotlin/l/b;
    //   90: invokestatic 1129	kotlin/l/a/c:d	(Lkotlin/l/b;)Ljava/lang/Object;
    //   93: astore_3
    //   94: aload_3
    //   95: checkcast 45	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction
    //   98: aload_0
    //   99: checkcast 2	com/tencent/mm/plugin/webview/core/BaseWebViewController
    //   102: invokevirtual 1132	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction:setController	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V
    //   105: aload_3
    //   106: checkcast 45	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction
    //   109: astore_3
    //   110: aload_3
    //   111: instanceof 15
    //   114: ifeq +53 -> 167
    //   117: aload_0
    //   118: getfield 876	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGx	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   121: aload_3
    //   122: aload_2
    //   123: getfield 1136	com/tencent/mm/plugin/webview/core/BaseWebViewController$f:kRn	Lkotlin/g/a/a;
    //   126: invokestatic 1142	kotlin/s:M	(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/o;
    //   129: invokevirtual 1143	java/util/concurrent/ConcurrentLinkedDeque:add	(Ljava/lang/Object;)Z
    //   132: pop
    //   133: goto -66 -> 67
    //   136: astore_1
    //   137: aload_0
    //   138: invokespecial 940	com/tencent/mm/plugin/webview/core/BaseWebViewController:gSh	()Ljava/lang/String;
    //   141: new 984	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 1203
    //   148: invokespecial 988	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_1
    //   152: invokevirtual 1206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 1002	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 1007	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 1013	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_0
    //   165: monitorexit
    //   166: return
    //   167: aload_3
    //   168: instanceof 24
    //   171: ifeq -104 -> 67
    //   174: aload_0
    //   175: getfield 878	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGy	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   178: aload_3
    //   179: aload_2
    //   180: getfield 1136	com/tencent/mm/plugin/webview/core/BaseWebViewController$f:kRn	Lkotlin/g/a/a;
    //   183: invokestatic 1142	kotlin/s:M	(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/o;
    //   186: invokevirtual 1143	java/util/concurrent/ConcurrentLinkedDeque:add	(Ljava/lang/Object;)Z
    //   189: pop
    //   190: goto -123 -> 67
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	BaseWebViewController
    //   66	11	1	localIterator	Iterator
    //   136	16	1	localException	Exception
    //   193	4	1	localObject1	Object
    //   85	95	2	localf	f
    //   93	86	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   54	67	136	java/lang/Exception
    //   67	133	136	java/lang/Exception
    //   167	190	136	java/lang/Exception
    //   2	54	193	finally
    //   54	67	193	finally
    //   67	133	193	finally
    //   137	164	193	finally
    //   167	190	193	finally
  }
  
  private final int gSy()
  {
    if (!cDD()) {
      return 0;
    }
    if (this.PFJ) {
      return 2;
    }
    return 1;
  }
  
  private final void n(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (this.PGd) && (paramWebView.canGoBack()))
    {
      Log.i(gSh(), "clearHistory :".concat(String.valueOf(paramString)));
      paramWebView.clearHistory();
      this.PGd = false;
    }
  }
  
  public final void CM(boolean paramBoolean)
  {
    try
    {
      com.tencent.mm.plugin.webview.stub.e locale = this.pGC;
      if (locale == null) {
        kotlin.g.b.p.bGy("invoker");
      }
      if (locale != null)
      {
        if (!paramBoolean)
        {
          locale = this.pGC;
          if (locale == null) {
            kotlin.g.b.p.bGy("invoker");
          }
          locale.aon(gSo());
        }
        locale = this.pGC;
        if (locale == null) {
          kotlin.g.b.p.bGy("invoker");
        }
        locale.bD(gSo(), paramBoolean);
      }
      Log.i(gSh(), "removeInvoker ok");
      return;
    }
    catch (Exception localException)
    {
      Log.w(gSh(), "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException)));
    }
  }
  
  protected final void CN(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.PGb).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).CN(paramBoolean);
    }
  }
  
  public final void F(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString1 = this.pHS.getSettings();
      if (paramString1 != null) {
        paramString1.setJavaScriptEnabled(false);
      }
      this.pHS.loadData(paramString2, "text/html", "utf-8");
    }
  }
  
  public final void N(String paramString, Map<String, String> paramMap)
  {
    kotlin.g.b.p.k(paramString, "baseUrl");
    Log.i(gSh(), "WebView-Trace loadCacheUrl baseUrl ".concat(String.valueOf(paramString)));
    this.fba = paramString;
    this.PFJ = true;
    anv(this.PGk);
    this.pHS.loadUrl(paramString, paramMap);
    bjp(paramString);
    anv(this.PGj);
    com.tencent.e.h.ZvG.bc((Runnable)new ad(this));
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    kotlin.g.b.p.k(paramWebView, "webview");
    kotlin.g.b.p.k(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, null);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest);
    }
    return localWebResourceResponse1;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    kotlin.g.b.p.k(paramWebView, "webview");
    kotlin.g.b.p.k(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, paramBundle);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    }
    return localWebResourceResponse1;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    kotlin.g.b.p.k(paramString1, "reqUrl");
    kotlin.g.b.p.k(paramString2, "errMsg");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      cR(this.PGm, paramString1);
      Iterator localIterator = ((Iterable)this.PGb).iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).d(paramInt1, paramString1, paramInt2, paramString2);
      }
      this.PFK = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, bot parambot)
  {
    kotlin.g.b.p.k(paramString1, "reqUrl");
    kotlin.g.b.p.k(paramString2, "fullUrl");
    kotlin.g.b.p.k(parambot, "response");
    Log.d(gSh(), "WebView-Trace onPermissionUpdate:" + paramString1 + ", fullUrl:" + paramString2);
    if (gSx()) {
      Log.d(gSh(), "onPermissionUpdate destroyCalled");
    }
    do
    {
      return;
      this.pGD.a(paramString1, gSl().bly(paramString1), gSl().blA(paramString1));
      this.pGD.a(paramString2, gSl().bly(paramString2), gSl().blA(paramString2));
      Iterator localIterator = ((Iterable)this.PGb).iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).a(paramString1, parambot);
      }
      cR(this.PGl, paramString1);
      cR(this.PGl, paramString2);
    } while (!kotlin.g.b.p.h(paramString1, this.PFO));
    cR(this.PGs, paramString1);
    Log.i(gSh(), "WebAction:Ready onPermissionUpdated Patch: " + this.PFO);
  }
  
  public final void a(f paramf)
  {
    kotlin.g.b.p.k(paramf, "listener");
    if (!this.PGa.contains(paramf)) {
      this.PGa.add(paramf);
    }
  }
  
  public final void a(j paramj)
  {
    try
    {
      kotlin.g.b.p.k(paramj, "listener");
      if (!this.PGb.contains(paramj))
      {
        BaseWebViewController localBaseWebViewController = (BaseWebViewController)this;
        kotlin.g.b.p.k(localBaseWebViewController, "<set-?>");
        paramj.controller = localBaseWebViewController;
        this.PGb.add(paramj);
        if (this.PGC.contains(ab.bO(Bind.class).iCe()))
        {
          Log.i(gSh(), "Abe-Debug Patch Call onBind");
          paramj.bXM();
        }
      }
      return;
    }
    finally
    {
      paramj = finally;
      throw paramj;
    }
  }
  
  public final void a(k paramk)
  {
    kotlin.g.b.p.k(paramk, "interceptor");
    this.PwK.add(paramk);
    Object localObject = paramk.gTb();
    if (localObject != null) {
      a((f)localObject);
    }
    localObject = paramk.bXJ();
    if (localObject != null) {
      a((j)localObject);
    }
    paramk.k(this);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (com.tencent.mm.compatible.util.d.qV(23)) {}
    for (;;)
    {
      return;
      if (!anw(this.PGi))
      {
        Log.i(gSh(), "onReceivedError, intent not ready");
        return;
      }
      Log.i(gSh(), "WebView-Trace onReceivedError-old, errCode:" + paramInt + ", description:" + paramString1 + ", failingUrl:" + paramString2);
      Object localObject2;
      if (anw(this.PGh))
      {
        localObject1 = gSq();
        localObject2 = bju(getCurrentUrl());
        e.a locala = e.PHr;
        e.a((e)localObject1, paramInt, paramString1, paramString2, (String)localObject2, e.a.e(this.pHS), gSy());
      }
      Object localObject1 = ((Iterable)this.PGa).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if (isStarted()) {
          ((f)localObject2).a(paramWebView, paramInt, paramString1, paramString2);
        }
      }
    }
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    Object localObject2 = null;
    super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    if (!anw(this.PGi))
    {
      Log.i(gSh(), "onReceivedHttpError, intent not ready");
      return;
    }
    Object localObject3 = gSh();
    StringBuilder localStringBuilder = new StringBuilder("WebView-Trace onReceivedHttpError, errCode:");
    if (paramWebResourceResponse != null)
    {
      localObject1 = Integer.valueOf(paramWebResourceResponse.getStatusCode());
      label63:
      localStringBuilder = localStringBuilder.append(localObject1).append(", description:");
      if (paramWebResourceResponse == null) {
        break label288;
      }
    }
    label288:
    for (Object localObject1 = paramWebResourceResponse.getReasonPhrase();; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(", failingUrl:");
      localObject1 = localObject2;
      if (paramWebResourceRequest != null) {
        localObject1 = paramWebResourceRequest.getUrl();
      }
      Log.i((String)localObject3, String.valueOf(localObject1));
      if (anw(this.PGh))
      {
        localObject1 = gSq();
        localObject2 = bju(getCurrentUrl());
        localObject3 = e.PHr;
        int i = e.a.e(this.pHS);
        int j = gSy();
        if ((((e)localObject1).cin()) && (paramWebResourceRequest != null)) {
          com.tencent.e.h.ZvG.d((Runnable)new e.e((e)localObject1, paramWebResourceRequest, paramWebResourceResponse, (String)localObject2, i, j), "MicroMsg.WebPageErrorMonitor");
        }
      }
      localObject1 = ((Iterable)this.PGa).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if (isStarted()) {
          ((f)localObject2).a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        }
      }
      break;
      localObject1 = null;
      break label63;
    }
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, com.tencent.xweb.z paramz)
  {
    super.a(paramWebView, paramWebResourceRequest, paramz);
    if ((paramWebResourceRequest == null) || (paramz == null) || (com.tencent.mm.compatible.util.d.qW(23))) {
      return;
    }
    if (!anw(this.PGi))
    {
      Log.i(gSh(), "onReceivedError, intent not ready");
      return;
    }
    int i = paramz.getErrorCode();
    paramz = paramz.getDescription();
    if (paramz != null)
    {
      paramz = paramz.toString();
      label66:
      localObject1 = paramWebResourceRequest.getUrl();
      if (localObject1 == null) {
        break label252;
      }
    }
    label252:
    for (Object localObject1 = ((Uri)localObject1).toString();; localObject1 = null)
    {
      Log.i(gSh(), "WebView-Trace onReceivedError, errCode:" + i + ", description:" + paramz + ", failingUrl:" + (String)localObject1);
      Object localObject2;
      if (anw(this.PGh))
      {
        localObject2 = gSq();
        String str = bju(getCurrentUrl());
        e.a locala = e.PHr;
        ((e)localObject2).a(i, paramz, (String)localObject1, str, e.a.e(this.pHS), gSy(), paramWebResourceRequest.isForMainFrame());
      }
      paramWebResourceRequest = ((Iterable)this.PGa).iterator();
      while (paramWebResourceRequest.hasNext())
      {
        localObject2 = (f)paramWebResourceRequest.next();
        if (isStarted()) {
          ((f)localObject2).a(paramWebView, i, paramz, (String)localObject1);
        }
      }
      break;
      paramz = null;
      break label66;
    }
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.j paramj, String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramj, "handler");
    super.a(paramWebView, paramj, paramString1, paramString2);
    com.tencent.mm.plugin.report.service.h.IzE.p(155L, 35L, 1L);
  }
  
  public void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    super.a(paramWebView, paramr, paramSslError);
    if (!anw(this.PGi))
    {
      Log.i(gSh(), "onReceivedSslError, intent not ready");
      return;
    }
    Object localObject2 = gSh();
    Object localObject3 = new StringBuilder("WebView-Trace onReceivedSslError, ");
    if (paramSslError != null) {}
    for (Object localObject1 = paramSslError.toString();; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1);
      if (anw(this.PGh))
      {
        localObject1 = gSq();
        localObject2 = bju(getCurrentUrl());
        localObject3 = e.PHr;
        int i = e.a.e(this.pHS);
        int j = gSy();
        if ((((e)localObject1).cin()) && (paramSslError != null)) {
          com.tencent.e.h.ZvG.d((Runnable)new e.f((e)localObject1, paramSslError, (String)localObject2, i, j), "MicroMsg.WebPageErrorMonitor");
        }
      }
      localObject1 = ((Iterable)this.PGa).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        if (isStarted()) {
          ((f)localObject2).a(paramWebView, paramr, paramSslError);
        }
      }
      break;
    }
  }
  
  protected boolean a(int paramInt, String paramString, bot parambot)
  {
    kotlin.g.b.p.k(paramString, "reqUrl");
    kotlin.g.b.p.k(parambot, "resp");
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    while (localIterator.hasNext()) {
      if (((k)localIterator.next()).a(paramInt, paramString, parambot)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    kotlin.g.b.p.k(paramWebView, "view");
    kotlin.g.b.p.k(paramString, "url");
    Log.i(gSh(), "shouldOverrideUrlLoading: ".concat(String.valueOf(paramString)));
    Log.d(gSh(), "doShouldOverrideUrlLoading url:".concat(String.valueOf(paramString)));
    boolean bool1;
    if (m(paramWebView, paramString))
    {
      bool1 = bool2;
      if (!bool1) {
        this.PFK = paramString;
      }
      return bool1;
    }
    label150:
    if (bjr(paramString) == 2)
    {
      bool1 = true;
      label89:
      if (aM(paramString, bool1))
      {
        if (this.PGK.PGV) {
          break label181;
        }
        switch (bjr(paramString))
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
  
  protected boolean aM(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    kotlin.g.b.p.k(paramString, "url");
    if (a(this, paramString, paramBoolean, 0, 4) == c.a.PYJ) {
      bool = true;
    }
    return bool;
  }
  
  public final ConcurrentLinkedDeque<kotlin.g.a.a<x>> anu(int paramInt)
  {
    ConcurrentLinkedDeque localConcurrentLinkedDeque2 = (ConcurrentLinkedDeque)this.PGc.get(Integer.valueOf(paramInt));
    ConcurrentLinkedDeque localConcurrentLinkedDeque1 = localConcurrentLinkedDeque2;
    if (localConcurrentLinkedDeque2 == null)
    {
      localConcurrentLinkedDeque1 = new ConcurrentLinkedDeque();
      ((Map)this.PGc).put(Integer.valueOf(paramInt), localConcurrentLinkedDeque1);
    }
    return localConcurrentLinkedDeque1;
  }
  
  /* Error */
  public final void anv(final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1350	com/tencent/mm/plugin/webview/core/BaseWebViewController:gSx	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 1306	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   17: new 132	com/tencent/mm/plugin/webview/core/BaseWebViewController$u
    //   20: dup
    //   21: aload_0
    //   22: iload_1
    //   23: invokespecial 1607	com/tencent/mm/plugin/webview/core/BaseWebViewController$u:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;I)V
    //   26: checkcast 1309	java/lang/Runnable
    //   29: invokeinterface 1315 2 0
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
  
  public final boolean anw(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!kotlin.z.aazO) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.PGA.contains(Integer.valueOf(paramInt));
    return bool;
  }
  
  protected boolean aql(String paramString)
  {
    kotlin.g.b.p.k(paramString, "url");
    return true;
  }
  
  protected boolean aqm(String paramString)
  {
    kotlin.g.b.p.k(paramString, "url");
    if (!kotlin.n.n.ba((CharSequence)paramString)) {}
    for (int i = 1; (i != 0) && (!kotlin.n.n.M(paramString, "data:text/html;charset=utf-8", false)) && (!kotlin.n.n.M(paramString, "about:blank", false)); i = 0)
    {
      if (anw(this.PGj))
      {
        String str = com.tencent.mm.plugin.webview.h.a.sQA;
        kotlin.g.b.p.j(str, "ConstantsPreload.HARDCODE_URL");
        if (kotlin.n.n.M(paramString, str, false)) {
          break;
        }
      }
      return true;
    }
    return false;
  }
  
  protected WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    kotlin.g.b.p.k(paramWebView, "webView");
    kotlin.g.b.p.k(paramWebResourceRequest, "request");
    Log.i(gSh(), "shouldInterceptRequest, url = " + paramWebResourceRequest.getUrl() + ", method = " + paramWebResourceRequest.getMethod() + ", isForMainFrame = " + paramWebResourceRequest.isForMainFrame());
    Object localObject = paramWebResourceRequest.getUrl().toString();
    kotlin.g.b.p.j(localObject, "request.url.toString()");
    if (bjt((String)localObject)) {
      return null;
    }
    if ((com.tencent.mm.xwebutil.c.lP(getContext())) && (paramBundle != null)) {}
    try
    {
      i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        Log.i(gSh(), "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        gSl().blx(getCurrentUrl());
        paramBundle = paramWebResourceRequest.getUrl().toString();
        kotlin.g.b.p.j(paramBundle, "request.url.toString()");
        n(paramBundle, false, 5);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.w(gSh(), "get resource type failed Exception ; " + paramBundle.getMessage());
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        Log.w(gSh(), "get resource type failed Throwable ; " + paramBundle.getMessage());
      }
      if (!((Boolean)this.PGI.getValue()).booleanValue()) {
        break label473;
      }
      paramWebView = PGN;
      int j = 0;
      int k = paramWebView.length;
      int i = 0;
      while (i < k)
      {
        paramBundle = paramWebView[i];
        localObject = paramWebResourceRequest.getUrl();
        if (localObject != null)
        {
          localObject = ((Uri)localObject).toString();
          if ((localObject != null) && (kotlin.n.n.M((String)localObject, paramBundle, false) == true))
          {
            Log.i(gSh(), "QuickAppInterceptor interceptor url = ".concat(String.valueOf(paramBundle)));
            com.tencent.mm.plugin.report.service.h.IzE.p(1551L, j + 1, 1L);
            if (((Boolean)this.PGJ.getValue()).booleanValue())
            {
              Log.i(gSh(), "QuickAppInterceptor interceptor WebResourceResponse");
              return new WebResourceResponse("", null, null);
            }
          }
        }
        j += 1;
        i += 1;
      }
    }
    paramBundle = ((Iterable)this.PwK).iterator();
    while (paramBundle.hasNext())
    {
      localObject = ((k)paramBundle.next()).b(paramWebView, paramWebResourceRequest);
      if (localObject != null) {
        return localObject;
      }
    }
    label473:
    return null;
  }
  
  public final void b(f paramf)
  {
    kotlin.g.b.p.k(paramf, "listener");
    if (this.PGa.contains(paramf)) {
      this.PGa.remove(paramf);
    }
  }
  
  public final void b(j paramj)
  {
    try
    {
      kotlin.g.b.p.k(paramj, "listener");
      if (this.PGb.contains(paramj)) {
        this.PGb.remove(paramj);
      }
      return;
    }
    finally
    {
      paramj = finally;
      throw paramj;
    }
  }
  
  public final void b(k paramk)
  {
    kotlin.g.b.p.k(paramk, "interceptor");
    this.PwK.remove(paramk);
    f localf = paramk.gTb();
    if (localf != null) {
      b(localf);
    }
    paramk = paramk.bXJ();
    if (paramk != null) {
      b(paramk);
    }
  }
  
  public void b(com.tencent.mm.plugin.webview.stub.e parame) {}
  
  public void b(WebView paramWebView, String paramString)
  {
    if (gSx())
    {
      Log.w(gSh(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = afQ(str);
      Log.i(gSh(), "WebView-Trace onPageFinished: " + paramString + ", callbackUrl:" + str);
      super.b(paramWebView, paramString);
      if ((!this.PGz.contains(Integer.valueOf(this.PGq))) && (!cDD()))
      {
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1200L, 104L, 1L, false);
        Log.i(gSh(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
      }
      cR(this.PGr, bjn(paramString));
      Iterator localIterator = ((Iterable)this.PGa).iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (isStarted()) {
          localf.b(paramWebView, str);
        }
      }
      n(paramWebView, paramString);
      return;
    }
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    kotlin.g.b.p.k(paramWebView, "view");
    kotlin.g.b.p.k(paramString, "url");
    if (gSx())
    {
      Log.w(gSh(), "ActivityFinished");
      return;
    }
    Object localObject2 = this.pHS.getActivityContextIfHas();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    localObject1 = (Activity)localObject1;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      kotlin.g.b.p.j(localObject1, "it.intent");
      this.intent = ((Intent)localObject1);
    }
    cR(this.PGn, paramString);
    Log.i(gSh(), "WebView-Trace onPageStarted: ".concat(String.valueOf(paramString)));
    this.PGe = false;
    this.PFK = paramString;
    bjq(paramString);
    localObject1 = ((Iterable)this.PGa).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f)((Iterator)localObject1).next();
      if (isStarted()) {
        ((f)localObject2).h(paramWebView, afQ(paramString));
      }
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    kotlin.g.b.p.k(paramWebView, "view");
    kotlin.g.b.p.k(paramString, "url");
    Log.i(gSh(), "WebView-Trace doUpdateVisitedHistory, url = " + paramString + ", wvUrl = " + paramWebView.getUrl() + ", isReload = " + paramBoolean);
    if (kotlin.n.n.M(paramString, "data:text/html;charset=utf-8", false))
    {
      Log.i(gSh(), "url starts with data:text, url : ".concat(String.valueOf(paramString)));
      return;
    }
    if ((com.tencent.luggage.k.c.G(paramString, "about:blank")) || (com.tencent.luggage.k.c.G(paramString, "file:///android_asset/")))
    {
      Log.e(gSh(), "doUpdateVisitedHistory, url is invalid");
      return;
    }
    Object localObject;
    if (anw(this.PGj))
    {
      localObject = com.tencent.mm.plugin.webview.h.a.sQA;
      kotlin.g.b.p.j(localObject, "ConstantsPreload.HARDCODE_URL");
      if (com.tencent.luggage.k.c.G(paramString, (String)localObject))
      {
        Log.i(gSh(), "doUpdateVisitedHistory, url is HARDCODE_URL");
        return;
      }
    }
    super.b(paramWebView, paramString, paramBoolean);
    if (((Boolean)this.PGH.getValue()).booleanValue()) {
      paramString = paramWebView.getUrl();
    }
    kotlin.g.b.p.j(paramString, "url");
    int i;
    if (!kotlin.g.b.p.h(this.PFM, paramString))
    {
      localObject = (CharSequence)this.PFN;
      if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
        break label455;
      }
      i = 1;
      if ((i != 0) || (!(kotlin.g.b.p.h(com.tencent.mm.plugin.webview.l.a.getHost(paramString), com.tencent.mm.plugin.webview.l.a.getHost(this.PFN)) ^ true)))
      {
        localObject = (CharSequence)this.PFM;
        if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
          break label461;
        }
        i = 1;
        label287:
        if ((i != 0) || (!(kotlin.g.b.p.h(com.tencent.mm.plugin.webview.l.a.getHost(paramString), com.tencent.mm.plugin.webview.l.a.getHost(this.PFM)) ^ true))) {
          break label467;
        }
      }
      Log.w(gSh(), "dealSPAUpdate hot not equal, url=" + paramString + ", commitUrl=" + this.PFN + ", startUrl=" + this.PFM);
    }
    for (;;)
    {
      if ((!this.PGK.PGV) && (!gSl().blz(paramString))) {
        n(paramString, false, gSl().dc(paramString, true));
      }
      this.PFK = paramString;
      localObject = ((Iterable)this.PGa).iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        if (isStarted()) {
          localf.bjz(paramString);
        }
      }
      label455:
      i = 0;
      break;
      label461:
      i = 0;
      break label287;
      label467:
      Log.d(gSh(), "dealSPAUpdate url=" + paramString + ", startUrl=" + this.PFM);
      if (this.pGD.has(paramString)) {
        cR(this.PGs, paramString);
      }
      gSn().gUe();
      this.PFO = paramString;
    }
    n(paramWebView, paramString);
  }
  
  public boolean b(int paramInt, String paramString, bot parambot)
  {
    kotlin.g.b.p.k(paramString, "reqUrl");
    kotlin.g.b.p.k(parambot, "response");
    Log.i(gSh(), "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(paramInt)));
    this.pHS.setA8keyReason(paramInt);
    Object localObject1 = this.PFV;
    ((Map)localObject1).clear();
    Object localObject2 = parambot.SZV;
    kotlin.g.b.p.j(localObject2, "response.HttpHeader");
    int i;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      localObject2 = com.tencent.mm.plugin.webview.f.c.iZ((List)parambot.SZV);
      kotlin.g.b.p.j(localObject2, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      ((Map)localObject1).putAll((Map)localObject2);
    }
    label134:
    label327:
    label459:
    for (;;)
    {
      if (!a(paramInt, paramString, parambot)) {
        break label461;
      }
      return true;
      i = 0;
      break;
      localObject2 = this.intent;
      if (localObject2 == null) {
        kotlin.g.b.p.bGy("intent");
      }
      if (((Intent)localObject2).getBooleanExtra("k_has_http_header", false))
      {
        Log.i(gSh(), "use intent httpheader info");
        localObject2 = this.intent;
        if (localObject2 == null) {
          kotlin.g.b.p.bGy("intent");
        }
        localObject2 = ((Intent)localObject2).getStringArrayExtra("geta8key_result_http_header_key_list");
        Object localObject3 = this.intent;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("intent");
        }
        localObject3 = ((Intent)localObject3).getStringArrayExtra("geta8key_result_http_header_value_list");
        Intent localIntent = this.intent;
        if (localIntent == null) {
          kotlin.g.b.p.bGy("intent");
        }
        localIntent.putExtra("k_has_http_header", false);
        localIntent = this.intent;
        if (localIntent == null) {
          kotlin.g.b.p.bGy("intent");
        }
        localIntent.putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        localIntent = this.intent;
        if (localIntent == null) {
          kotlin.g.b.p.bGy("intent");
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
              kotlin.g.b.p.j(localIntent, "httpHeaderKey[i]");
              Object localObject4 = localObject3[i];
              kotlin.g.b.p.j(localObject4, "httpHeaderValue[i]");
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
    localObject1 = ((Iterable)this.PGb).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((j)((Iterator)localObject1).next()).c(paramString, parambot);
    }
    return false;
  }
  
  public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    kotlin.g.b.p.k(paramWebView, "webview");
    kotlin.g.b.p.k(paramString1, "description");
    kotlin.g.b.p.k(paramString2, "failingUrl");
    Log.e(gSh(), "shouldInterceptLoadError, failingUrl = %s, errorCode = %d, desc = %s", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1 });
    Object localObject1 = bju(getCurrentUrl());
    Object localObject2 = e.PHr;
    int i = e.a.e(this.pHS);
    localObject2 = gSq();
    int j = gSy();
    if ((((e)localObject2).cin()) && (paramString2 != null)) {
      com.tencent.e.h.ZvG.d((Runnable)new e.c((e)localObject2, paramString2, paramInt, paramString1, (String)localObject1, i, j), "MicroMsg.WebPageErrorMonitor");
    }
    localObject1 = ((Iterable)this.PwK).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((k)((Iterator)localObject1).next()).a(paramWebView, paramString1, paramString2);
    }
    return super.b(paramWebView, paramInt, paramString1, paramString2);
  }
  
  protected void bXH()
  {
    com.tencent.mm.plugin.expansions.a.dbf();
    a((k)new com.tencent.mm.plugin.webview.g.a());
    a((k)new com.tencent.mm.plugin.webview.l.e());
    this.pHS.setWebViewClient((ad)this);
    MMWebView localMMWebView = this.pHS;
    Object localObject1 = aa.PHh;
    com.tencent.mm.plugin.webview.k.p.h(localMMWebView);
    aa localaa = localMMWebView.getSettings();
    localaa.setJavaScriptEnabled(((Boolean)this.PGK.PGR.PHa.getValue()).booleanValue());
    localaa.setPluginsEnabled(((Boolean)this.PGK.PGR.PGY.getValue()).booleanValue());
    localaa.iwC();
    localaa.setBuiltInZoomControls(((Boolean)this.PGK.PGR.PGZ.getValue()).booleanValue());
    localaa.setUseWideViewPort(true);
    localaa.setLoadWithOverviewMode(true);
    localaa.iwx();
    localaa.iww();
    localaa.setGeolocationEnabled(true);
    localaa.setJavaScriptCanOpenWindowsAutomatically(true);
    localaa.iwE();
    localaa.iwA();
    localObject1 = localMMWebView.getContext().getDir("webviewcache", 0);
    kotlin.g.b.p.j(localObject1, "context.getDir(\"webviewc…e\", Context.MODE_PRIVATE)");
    localaa.setAppCachePath(((File)localObject1).getAbsolutePath());
    localaa.iwz();
    localaa.iwB();
    localaa.setDatabasePath(com.tencent.mm.loader.j.b.aSC() + "databases/");
    String str = localaa.getUserAgentString();
    kotlin.g.b.p.j(str, "currentUa");
    Object localObject2;
    if (!kotlin.n.n.g((CharSequence)str, (CharSequence)" MicroMessenger/"))
    {
      localObject2 = (p.a)com.tencent.luggage.a.e.K(p.a.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (p.a)new com.tencent.mm.plugin.appbrand.luggage.b.e(localMMWebView.getContext());
      }
      localObject2 = com.tencent.mm.plugin.webview.k.h.QAa;
      kotlin.g.b.p.k(str, "prefix");
      h.a.bcJ().putString("key_web_prefetch_ua", str);
      localaa.setUserAgentString(com.tencent.mm.plugin.appbrand.ac.p.a(localMMWebView.getContext(), str, (p.a)localObject1));
    }
    if (!((Boolean)this.PGK.PGR.PHb.getValue()).booleanValue())
    {
      localMMWebView.setVerticalScrollBarEnabled(false);
      localMMWebView.setHorizontalScrollBarEnabled(false);
    }
    com.tencent.xweb.c.ivX().ivY();
    com.tencent.xweb.c.ivX().f((WebView)localMMWebView);
    localObject1 = aa.PHh;
    localObject1 = localMMWebView.getContext().getSystemService("window");
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type android.view.WindowManager");
    }
    aa.b((WindowManager)localObject1);
    if (this.pHS.dwQ())
    {
      localObject2 = this.pHS.getUrl();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      bjp((String)localObject1);
    }
    this.PFY.bU("onTryBindServiceStart", System.currentTimeMillis());
    Log.i(gSh(), "WebView-Trace tryBindService");
    localObject1 = m.PJj;
    m.a(true, gSi(), (d)new b(new WeakReference(this)));
    this.PFY.bU("onTryBindServiceEnd", System.currentTimeMillis());
  }
  
  protected void bXI()
  {
    if (!this.PGG)
    {
      gSA();
      this.PGG = true;
    }
    Iterator localIterator = ((Iterable)this.PGb).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).bXI();
    }
  }
  
  protected void bXM() {}
  
  public final void bj(Intent paramIntent)
  {
    kotlin.g.b.p.k(paramIntent, "intent");
    Log.i(gSh(), "start");
    this.PFP = true;
    this.intent = paramIntent;
    com.tencent.mm.plugin.webview.f.g localg = this.pGD;
    Object localObject2 = paramIntent.getParcelableExtra("hardcode_jspermission");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof JsapiPermissionWrapper)) {
      localObject1 = null;
    }
    Object localObject3 = (JsapiPermissionWrapper)localObject1;
    localObject2 = paramIntent.getParcelableExtra("hardcode_general_ctrl");
    localObject1 = localObject2;
    if (!(localObject2 instanceof GeneralControlWrapper)) {
      localObject1 = null;
    }
    localg.a((JsapiPermissionWrapper)localObject3, (GeneralControlWrapper)localObject1);
    localg = this.pGD;
    localObject3 = cDu();
    localObject2 = paramIntent.getParcelableExtra("scan_jspermission");
    localObject1 = localObject2;
    if (!(localObject2 instanceof JsapiPermissionWrapper)) {
      localObject1 = null;
    }
    localObject2 = (JsapiPermissionWrapper)localObject1;
    localObject1 = paramIntent.getParcelableExtra("scan_general_ctrl");
    paramIntent = (Intent)localObject1;
    if (!(localObject1 instanceof GeneralControlWrapper)) {
      paramIntent = null;
    }
    localg.a((String)localObject3, (JsapiPermissionWrapper)localObject2, (GeneralControlWrapper)paramIntent);
    kotlinx.coroutines.g.b((kotlinx.coroutines.ak)br.abxo, null, (kotlin.g.a.m)new ak(this, null), 3);
  }
  
  protected final void bjm(String paramString)
  {
    kotlin.g.b.p.k(paramString, "<set-?>");
    this.fba = paramString;
  }
  
  protected final void bjo(String paramString)
  {
    kotlin.g.b.p.k(paramString, "value");
    if (aql(paramString))
    {
      Log.d(gSh(), "WebView-Trace startUrl:".concat(String.valueOf(paramString)));
      this.PFM = paramString;
    }
  }
  
  protected final void bjp(String paramString)
  {
    kotlin.g.b.p.k(paramString, "value");
    if (aqm(paramString))
    {
      Log.d(gSh(), "WebView-Trace commitUrl:".concat(String.valueOf(paramString)));
      this.PFN = paramString;
    }
  }
  
  public final boolean bjs(String paramString)
  {
    kotlin.g.b.p.k(paramString, "url");
    if (ac.mFJ)
    {
      Log.w(gSh(), "skipLoadUrlCheck");
      return true;
    }
    if (this.PGK.PGS)
    {
      Log.i(gSh(), "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    if (com.tencent.luggage.k.c.a(paramString, "file://", true))
    {
      Iterator localIterator = ((Iterable)gSj()).iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.luggage.k.c.a(paramString, (String)localIterator.next(), true)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  protected final boolean bjt(String paramString)
  {
    kotlin.g.b.p.k(paramString, "url");
    if (!bjs(paramString))
    {
      Log.f(gSh(), "forceQuitOnUrlForbidden, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = ((Iterable)this.PGb).iterator();
      while (paramString.hasNext()) {
        ((j)paramString.next()).gSY();
      }
      return true;
    }
    return false;
  }
  
  public String bju(String paramString)
  {
    return "";
  }
  
  public final void bjv(String paramString)
  {
    kotlin.g.b.p.k(paramString, "url");
    Log.i(gSh(), "reload for:".concat(String.valueOf(paramString)));
    this.pHS.loadUrl(paramString);
    this.PGd = true;
  }
  
  public final String boj()
  {
    com.tencent.mm.plugin.webview.f.c localc = gSl();
    Object localObject = (CharSequence)getCurrentUrl();
    int i;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
    }
    label46:
    for (localObject = cDu();; localObject = getCurrentUrl())
    {
      return localc.bld((String)localObject);
      i = 0;
      break;
    }
  }
  
  public final MMHandler btS()
  {
    return (MMHandler)this.ocu.getValue();
  }
  
  public final void bu(int paramInt, String paramString)
  {
    kotlin.g.b.p.k(paramString, "reqUrl");
    this.PFY.bU("getA8KeyEnd", System.currentTimeMillis());
    Iterator localIterator = ((Iterable)this.PGb).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).bjH(paramString);
    }
  }
  
  public final void bv(final int paramInt, final String paramString)
  {
    kotlin.g.b.p.k(paramString, "reqUrl");
    this.PFY.bU("getA8KeyStart", System.currentTimeMillis());
    if (paramInt != 5) {
      cR(this.PGo, paramString);
    }
    if ((kotlin.g.b.p.h(this.PFO, paramString) ^ true)) {
      com.tencent.e.h.ZvG.bc((Runnable)new ae(this, paramInt, paramString));
    }
  }
  
  protected boolean cDA()
  {
    return true;
  }
  
  public boolean cDD()
  {
    return (anw(this.PGj)) && (kotlin.g.b.p.h(this.fba, this.PFN));
  }
  
  public String cDu()
  {
    try
    {
      Object localObject = this.intent;
      if (localObject == null) {
        kotlin.g.b.p.bGy("intent");
      }
      localObject = c.bk((Intent)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e(gSh(), String.valueOf(localException.getMessage()));
      onFinish();
    }
    return "";
  }
  
  protected boolean cDv()
  {
    return this.PGw;
  }
  
  protected boolean cDw()
  {
    return false;
  }
  
  protected boolean cDx()
  {
    return false;
  }
  
  protected List<f> cDy()
  {
    return this.sRc;
  }
  
  protected void cDz() {}
  
  protected final void cR(final int paramInt, final String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        kotlin.g.b.p.k(paramString, "url");
        if (!gSx())
        {
          if (kotlin.n.n.ba((CharSequence)paramString))
          {
            i = 1;
            break label86;
          }
        }
        else
        {
          Log.w(gSh(), "checkStatus return url=".concat(String.valueOf(paramString)));
          return;
        }
        i = 0;
      }
      finally {}
      com.tencent.e.h.ZvG.bc((Runnable)new v(this, paramInt, paramString));
      continue;
      label86:
      if (i == 0) {}
    }
  }
  
  public final void destroy()
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new x(this));
  }
  
  public void e(WebView paramWebView, String paramString)
  {
    if (gSx())
    {
      Log.w(gSh(), "ActivityFinished");
      return;
    }
    Object localObject1 = getJsapi();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.d.h)localObject1).gPF();
    }
    bjw(paramString);
    if (paramString == null) {}
    for (localObject1 = "";; localObject1 = paramString)
    {
      localObject1 = afQ((String)localObject1);
      Log.i(gSh(), "WebView-Trace onPageCommitVisible: " + paramString + ", callbackUrl:" + (String)localObject1);
      bjp((String)localObject1);
      super.e(paramWebView, paramString);
      Object localObject2 = g.PHD;
      if (!g.a.gSJ()) {
        cR(this.PGq, bjn(paramString));
      }
      for (;;)
      {
        localObject2 = ((Iterable)this.PGa).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          f localf = (f)((Iterator)localObject2).next();
          if (isStarted()) {
            localf.e(paramWebView, (String)localObject1);
          }
        }
        Log.i(gSh(), "WebView Page Commit Mock Enabled");
      }
      n(paramWebView, paramString);
      return;
    }
  }
  
  public final boolean e(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    int i = 0;
    if ((paramWebResourceRequest == null) || (paramWebView == null)) {
      return false;
    }
    kotlin.g.b.p.k(paramWebView, "webView");
    kotlin.g.b.p.k(paramWebResourceRequest, "request");
    kotlin.g.b.p.k(paramWebView, "webView");
    kotlin.g.b.p.k(paramWebResourceRequest, "request");
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    k.a locala;
    while (localIterator.hasNext())
    {
      locala = ((k)localIterator.next()).c(paramWebView, paramWebResourceRequest);
      if (locala.PJg) {
        if (!locala.PJg) {
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
      return super.e(paramWebView, paramWebResourceRequest);
      locala = new k.a(false, false);
      break;
    }
    label142:
    return true;
  }
  
  protected void gSA() {}
  
  protected void gSB() {}
  
  protected abstract Class<? extends Service> gSi();
  
  protected abstract Set<String> gSj();
  
  public final void gSk()
  {
    this.PFH += 1;
    this.PFI = System.currentTimeMillis();
  }
  
  public final com.tencent.mm.plugin.webview.f.c gSl()
  {
    return (com.tencent.mm.plugin.webview.f.c)this.PFL.getValue();
  }
  
  public final com.tencent.mm.plugin.webview.stub.e gSm()
  {
    com.tencent.mm.plugin.webview.stub.e locale = this.pGC;
    if (locale == null) {
      kotlin.g.b.p.bGy("invoker");
    }
    return locale;
  }
  
  public final com.tencent.mm.plugin.webview.d.k gSn()
  {
    return (com.tencent.mm.plugin.webview.d.k)this.PFS.getValue();
  }
  
  public final int gSo()
  {
    return ((Number)this.PFU.getValue()).intValue();
  }
  
  public final Runnable gSp()
  {
    return (Runnable)this.PFW.getValue();
  }
  
  public final String gSr()
  {
    return (String)this.PGf.getValue();
  }
  
  protected final boolean gSt()
  {
    try
    {
      boolean bool = this.PGB.contains(ab.bO(Inject.class).iCe());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void gSu() {}
  
  public boolean gSv()
  {
    return false;
  }
  
  public void gSw()
  {
    this.PFR = false;
  }
  
  public final boolean gSx()
  {
    return (this.PFR) || (this.PFQ);
  }
  
  public final boolean gSz()
  {
    try
    {
      anx(this.PGk);
      boolean bool = anx(this.PGj);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Context getContext()
  {
    Context localContext = this.pHS.getContext();
    kotlin.g.b.p.j(localContext, "viewWV.context");
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    if (kotlin.n.n.ba((CharSequence)this.PFO)) {
      return this.PFN;
    }
    return this.PFO;
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = this.intent;
    if (localIntent == null) {
      kotlin.g.b.p.bGy("intent");
    }
    return localIntent;
  }
  
  public final com.tencent.mm.plugin.webview.d.h getJsapi()
  {
    return (com.tencent.mm.plugin.webview.d.h)this.PFT.getValue();
  }
  
  protected final int getScreenOrientation()
  {
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      if (localk.getScreenOrientation() != -1) {
        return localk.getScreenOrientation();
      }
    }
    return -1;
  }
  
  public final void init()
  {
    gSs();
    anv(this.PGg);
    this.pHS.a((com.tencent.mm.ui.widget.k)new e());
  }
  
  protected final boolean isStarted()
  {
    try
    {
      boolean bool = this.PGC.contains(ab.bO(Start.class).iCe());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final k.a l(WebView paramWebView, String paramString)
  {
    kotlin.g.b.p.k(paramWebView, "webView");
    kotlin.g.b.p.k(paramString, "url");
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    while (localIterator.hasNext())
    {
      k.a locala = ((k)localIterator.next()).o(paramWebView, paramString);
      if (locala.PJg) {
        return locala;
      }
    }
    return new k.a(false, false);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    kotlin.g.b.p.k(paramString, "url");
    Log.i(gSh(), "WebView-Trace loadUrl url ".concat(String.valueOf(paramString)));
    if (paramBoolean)
    {
      this.pHS.loadUrl(paramString, (Map)ae.g(new o[] { s.M("Pragma", "no-cache"), s.M("Cache-Control", "no-cache") }));
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    if (i != 0)
    {
      this.pHS.loadUrl(paramString);
      return;
    }
    this.pHS.loadUrl(paramString, paramMap);
  }
  
  protected boolean m(WebView paramWebView, String paramString)
  {
    kotlin.g.b.p.k(paramWebView, "webView");
    kotlin.g.b.p.k(paramString, "url");
    paramWebView = l(paramWebView, paramString);
    if (paramWebView.PJg) {
      return paramWebView.result;
    }
    return false;
  }
  
  public final c.a n(String paramString, boolean paramBoolean, int paramInt)
  {
    kotlin.g.b.p.k(paramString, "url");
    if (this.PGK.PGV)
    {
      Log.w(gSh(), "startGetA8Key neverGetA8Key ".concat(String.valueOf(paramString)));
      return c.a.PYI;
    }
    Object localObject = ((Iterable)this.PwK).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((k)((Iterator)localObject).next()).g(paramString, paramBoolean, paramInt)) {
        return c.a.PYH;
      }
    }
    if (this.PFH > 0)
    {
      localObject = gSl();
      bov localbov = new bov();
      localbov.TaF = this.PFH;
      localbov.TaG = ((int)(System.currentTimeMillis() - this.PFI));
      Log.i(gSh(), "GetA8KeySecurityInfo KeyBackCounts=" + localbov.TaF + ", KeyBackTimes=" + localbov.TaG);
      ((com.tencent.mm.plugin.webview.f.c)localObject).a(localbov);
    }
    paramString = gSl().a(paramString, paramBoolean, paramInt, (com.tencent.mm.plugin.webview.f.a)this.PFG.getValue());
    kotlin.g.b.p.j(paramString, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
    return paramString;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 2284	com/tencent/mm/plugin/webview/core/BaseWebViewController:PFQ	Z
    //   7: aload_0
    //   8: getfield 2282	com/tencent/mm/plugin/webview/core/BaseWebViewController:PFR	Z
    //   11: ifne +8 -> 19
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 2357	com/tencent/mm/plugin/webview/core/BaseWebViewController:CM	(Z)V
    //   19: aload_0
    //   20: getfield 2359	com/tencent/mm/plugin/webview/core/BaseWebViewController:PGE	Lcom/tencent/mm/plugin/webview/core/c;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +27 -> 52
    //   28: aload_1
    //   29: checkcast 2361	java/io/Closeable
    //   32: astore_3
    //   33: aload_0
    //   34: invokespecial 940	com/tencent/mm/plugin/webview/core/BaseWebViewController:gSh	()Ljava/lang/String;
    //   37: ldc_w 2363
    //   40: invokestatic 1013	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: getstatic 2369	kotlin/x:aazN	Lkotlin/x;
    //   46: astore_1
    //   47: aload_3
    //   48: aconst_null
    //   49: invokestatic 2374	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   52: aload_0
    //   53: invokevirtual 2376	com/tencent/mm/plugin/webview/core/BaseWebViewController:btS	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   56: aload_0
    //   57: invokevirtual 2378	com/tencent/mm/plugin/webview/core/BaseWebViewController:gSp	()Ljava/lang/Runnable;
    //   60: invokevirtual 2381	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   63: aload_0
    //   64: invokevirtual 1178	com/tencent/mm/plugin/webview/core/BaseWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/d/h;
    //   67: invokevirtual 2384	com/tencent/mm/plugin/webview/d/h:detach	()V
    //   70: aload_0
    //   71: invokevirtual 1775	com/tencent/mm/plugin/webview/core/BaseWebViewController:gSn	()Lcom/tencent/mm/plugin/webview/d/k;
    //   74: invokevirtual 2385	com/tencent/mm/plugin/webview/d/k:detach	()V
    //   77: aload_0
    //   78: invokevirtual 893	com/tencent/mm/plugin/webview/core/BaseWebViewController:gSl	()Lcom/tencent/mm/plugin/webview/f/c;
    //   81: invokevirtual 2387	com/tencent/mm/plugin/webview/f/c:destroy	()V
    //   84: return
    //   85: astore_2
    //   86: aload_2
    //   87: athrow
    //   88: astore_1
    //   89: aload_3
    //   90: aload_2
    //   91: invokestatic 2374	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: goto -8 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	BaseWebViewController
    //   23	24	1	localObject1	Object
    //   88	7	1	localObject2	Object
    //   96	1	1	localObject3	Object
    //   1	1	2	localObject4	Object
    //   85	6	2	localThrowable	Throwable
    //   32	58	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   33	47	85	java/lang/Throwable
    //   86	88	88	finally
    //   33	47	96	finally
  }
  
  protected final void onFinish()
  {
    Log.i(gSh(), "onFinish " + Util.getStack());
    Iterator localIterator = ((Iterable)this.PGb).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).onFinish();
    }
  }
  
  public final void p(final String paramString, final kotlin.g.a.b<? super String, x> paramb)
  {
    kotlin.g.b.p.k(paramString, "script");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new y(this, paramString, paramb));
  }
  
  public final void reload()
  {
    if ((this.pHS == null) || (Util.isNullOrNil(this.pHS.getUrl()))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      String str = this.pHS.getUrl();
      kotlin.g.b.p.j(str, "viewWV.url");
      if (localk.aqs(afQ(str))) {
        return;
      }
    }
    Log.i(gSh(), "reload");
    this.pHS.reload();
  }
  
  protected final void setIntent(Intent paramIntent)
  {
    kotlin.g.b.p.k(paramIntent, "<set-?>");
    this.intent = paramIntent;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Auth
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(205381);
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ab.bO(BaseWebViewController.Inject.class), paramString)) && (waitFor(localBaseWebViewController.PGh)) && ((localBaseWebViewController.PGK.PGV) || (localBaseWebViewController.pGD.has(paramString)) || (waitFor(localBaseWebViewController.PGl, paramString))))
      {
        AppMethodBeat.o(205381);
        return true;
      }
      AppMethodBeat.o(205381);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Bind
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(205305);
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(localBaseWebViewController.PGi)) && (waitFor(localBaseWebViewController.PGh)))
      {
        AppMethodBeat.o(205305);
        return true;
      }
      AppMethodBeat.o(205305);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  public static abstract class ControllerAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Init
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(205483);
      boolean bool = waitFor(getController().PGg);
      AppMethodBeat.o(205483);
      return bool;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Inject
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(207227);
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((!localBaseWebViewController.pHS.dwQ()) && (!waitFor(localBaseWebViewController.PGq, paramString)) && (!waitFor(ab.bO(BaseWebViewController.PageLoadEndForCommitNotSupport.class), paramString))) || (((waitFor(localBaseWebViewController.PGh)) && ((localBaseWebViewController.PGK.PGV) || (localBaseWebViewController.pGD.has(paramString)) || (waitFor(localBaseWebViewController.PGl, paramString)))) || (localBaseWebViewController.cDw())))
      {
        AppMethodBeat.o(207227);
        return true;
      }
      AppMethodBeat.o(207227);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"})
  @Keep
  protected static abstract class PageAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify(String paramString);
    
    public final boolean waitFor(int paramInt, String paramString)
    {
      kotlin.g.b.p.k(paramString, "url");
      return ((kotlin.g.b.p.h(paramString, getController().PFM)) || (getController().PGv.contains(Integer.valueOf(paramInt)))) && (BaseWebViewController.b(getController()).contains(Integer.valueOf(paramInt)));
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageLoadEndForCommitNotSupport;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class PageLoadEndForCommitNotSupport
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(215865);
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ab.bO(BaseWebViewController.Start.class))) && (waitFor(localBaseWebViewController.PGr, paramString)) && (waitFor(localBaseWebViewController.PGt, paramString)))
      {
        AppMethodBeat.o(215865);
        return true;
      }
      AppMethodBeat.o(215865);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarEnd;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarEnd
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(207050);
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((localBaseWebViewController.cDv()) && ((localBaseWebViewController.cDx()) || (waitFor(ab.bO(BaseWebViewController.Ready.class), paramString)) || (waitFor(localBaseWebViewController.PGr, paramString)) || (waitFor(localBaseWebViewController.PGq, paramString)) || (waitFor(localBaseWebViewController.PGm, paramString))))
      {
        AppMethodBeat.o(207050);
        return true;
      }
      AppMethodBeat.o(207050);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarStart;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarStart
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(205920);
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ab.bO(BaseWebViewController.Start.class))) && (((!localBaseWebViewController.anw(localBaseWebViewController.PGk)) && ((waitFor(localBaseWebViewController.PGo, paramString)) || (waitFor(localBaseWebViewController.PGn, paramString)))) || ((!waitFor(ab.bO(BaseWebViewController.ProgressBarEnd.class), paramString)) && (localBaseWebViewController.anw(localBaseWebViewController.PGk)) && (waitFor(localBaseWebViewController.PGp, paramString)))))
      {
        AppMethodBeat.o(205920);
        return true;
      }
      AppMethodBeat.o(205920);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Ready
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(216014);
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((waitFor(ab.bO(BaseWebViewController.Start.class))) && (waitFor(ab.bO(BaseWebViewController.Auth.class), paramString)) && ((waitFor(localBaseWebViewController.PGr, paramString)) || (localBaseWebViewController.pHS.dwQ()))) || (localBaseWebViewController.cDx()))
      {
        AppMethodBeat.o(216014);
        return true;
      }
      AppMethodBeat.o(216014);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"})
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
      AppMethodBeat.i(205199);
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ab.bO(BaseWebViewController.Ready.class), paramString)) && (waitFor(localBaseWebViewController.PGs, paramString)))
      {
        AppMethodBeat.o(205199);
        return true;
      }
      AppMethodBeat.o(205199);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Start
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(206370);
      Object localObject = getController();
      if ((waitFor(((BaseWebViewController)localObject).PGi)) && ((!((BaseWebViewController)localObject).cDA()) || (waitFor(((BaseWebViewController)localObject).PGh))))
      {
        if (((CharSequence)((BaseWebViewController)localObject).cDu()).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            localObject = (CharSequence)((BaseWebViewController)localObject).gSr();
            if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
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
          AppMethodBeat.o(206370);
          return true;
          i = 0;
          break;
        }
      }
      label102:
      AppMethodBeat.o(206370);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"})
  @Keep
  public static abstract class WebAction
  {
    public BaseWebViewController controller;
    private final boolean keep;
    
    public final BaseWebViewController getController()
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.bGy("controller");
      }
      return localBaseWebViewController;
    }
    
    public boolean getKeep()
    {
      return this.keep;
    }
    
    public final void setController(BaseWebViewController paramBaseWebViewController)
    {
      kotlin.g.b.p.k(paramBaseWebViewController, "<set-?>");
      this.controller = paramBaseWebViewController;
    }
    
    public final boolean waitFor(int paramInt)
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.bGy("controller");
      }
      return BaseWebViewController.c(localBaseWebViewController).contains(Integer.valueOf(paramInt));
    }
    
    public final boolean waitFor(kotlin.l.b<? extends BaseWebViewController.ControllerAction> paramb)
    {
      kotlin.g.b.p.k(paramb, "clazz");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.bGy("controller");
      }
      return BaseWebViewController.d(localBaseWebViewController).contains(paramb.iCe());
    }
    
    public final boolean waitFor(kotlin.l.b<? extends BaseWebViewController.PageAction> paramb, String paramString)
    {
      kotlin.g.b.p.k(paramb, "clazz");
      kotlin.g.b.p.k(paramString, "url");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.bGy("controller");
      }
      if (kotlin.g.b.p.h(paramString, localBaseWebViewController.PFM))
      {
        paramString = this.controller;
        if (paramString == null) {
          kotlin.g.b.p.bGy("controller");
        }
        if (BaseWebViewController.e(paramString).contains(paramb.iCe())) {
          return true;
        }
      }
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<String>
  {
    a(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"setConfigCallback", "", "windowManager", "Landroid/view/WindowManager;", "invoke"})
  static final class aa
    extends q
    implements kotlin.g.a.b<WindowManager, x>
  {
    public static final aa PHh;
    
    static
    {
      AppMethodBeat.i(215657);
      PHh = new aa();
      AppMethodBeat.o(215657);
    }
    
    aa()
    {
      super();
    }
    
    public static void b(WindowManager paramWindowManager)
    {
      AppMethodBeat.i(215656);
      kotlin.g.b.p.k(paramWindowManager, "windowManager");
      try
      {
        Object localObject = WebView.class.getDeclaredField("mWebViewCore");
        kotlin.g.b.p.j(localObject, "WebView::class.java.getD…aredField(\"mWebViewCore\")");
        localObject = ((Field)localObject).getType().getDeclaredField("mBrowserFrame");
        kotlin.g.b.p.j(localObject, "field.type.getDeclaredField(\"mBrowserFrame\")");
        Field localField = ((Field)localObject).getType().getDeclaredField("sConfigCallback");
        kotlin.g.b.p.j(localField, "field.type.getDeclaredField(\"sConfigCallback\")");
        localField.setAccessible(true);
        localObject = localField.get(null);
        if (localObject == null)
        {
          AppMethodBeat.o(215656);
          return;
        }
        localField = localField.getType().getDeclaredField("mWindowManager");
        kotlin.g.b.p.j(localField, "field.type.getDeclaredField(\"mWindowManager\")");
        localField.setAccessible(true);
        localField.set(localObject, paramWindowManager);
        AppMethodBeat.o(215656);
        return;
      }
      catch (Exception paramWindowManager)
      {
        AppMethodBeat.o(215656);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "invoke"})
  static final class ab
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.d.k>
  {
    ab(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "invoke"})
  static final class ac
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.d.h>
  {
    ac(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(BaseWebViewController paramBaseWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(209537);
      this.PGP.btS().postUIDelayed(this.PGP.gSp(), 500L);
      AppMethodBeat.o(209537);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(205651);
      Iterator localIterator = ((Iterable)this.PGP.PGb).iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).bv(paramInt, paramString);
      }
      AppMethodBeat.o(205651);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final af PHi;
    
    static
    {
      AppMethodBeat.i(205987);
      PHi = new af();
      AppMethodBeat.o(205987);
    }
    
    af()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ag
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final ag PHj;
    
    static
    {
      AppMethodBeat.i(216164);
      PHj = new ag();
      AppMethodBeat.o(216164);
    }
    
    ag()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "invoke"})
  static final class ah
    extends q
    implements kotlin.g.a.a<e>
  {
    ah(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
    
    private e gSC()
    {
      AppMethodBeat.i(205213);
      for (long l = -1L;; l = 0L)
      {
        try
        {
          if (!this.PGP.gSm().gWY()) {
            continue;
          }
          int i = this.PGP.gSm().gXe();
          l = i;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            e locale;
            Log.e(BaseWebViewController.a(this.PGP), "Get Uin Error:" + localThrowable.getLocalizedMessage());
          }
        }
        locale = new e(l);
        AppMethodBeat.o(205213);
        return locale;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
  static final class ai
    extends q
    implements kotlin.g.a.a<Runnable>
  {
    ai(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"})
  public static final class aj
    extends l
  {
    public final void TA(long paramLong)
    {
      AppMethodBeat.i(208793);
      this.PGP.btS().postDelayed(this.PGP.gSp(), paramLong);
      AppMethodBeat.o(208793);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class ak
    extends kotlin.d.b.a.j
    implements kotlin.g.a.m<kotlinx.coroutines.ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private kotlinx.coroutines.ak p$;
    
    ak(BaseWebViewController paramBaseWebViewController, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(214821);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new ak(this.PGP, paramd);
      paramd.p$ = ((kotlinx.coroutines.ak)paramObject);
      AppMethodBeat.o(214821);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(214822);
      paramObject1 = ((ak)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(214822);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(214815);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(214815);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      this.PGP.anv(this.PGP.PGi);
      paramObject = x.aazN;
      AppMethodBeat.o(214815);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class al
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final al PHl;
    
    static
    {
      AppMethodBeat.i(206995);
      PHl = new al();
      AppMethodBeat.o(206995);
    }
    
    al()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class am
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final am PHm;
    
    static
    {
      AppMethodBeat.i(215741);
      PHm = new am();
      AppMethodBeat.o(215741);
    }
    
    am()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"})
  public static final class an
    implements g.b
  {
    public final String gSD()
    {
      AppMethodBeat.i(206786);
      Object localObject = this.PGP.getCurrentUrl();
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() > 0) {}
        for (int i = 1; i == 1; i = 0)
        {
          localObject = this.PGP.getCurrentUrl();
          AppMethodBeat.o(206786);
          return localObject;
        }
      }
      String str = this.PGP.pHS.getUrl();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(206786);
      return localObject;
    }
    
    public final String gSE()
    {
      return this.PGP.PFN;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$BaseWebViewUIConnectionBinder;", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "weakController", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "(Ljava/lang/ref/WeakReference;)V", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class b
    implements d
  {
    private final WeakReference<BaseWebViewController> PGQ;
    
    public b(WeakReference<BaseWebViewController> paramWeakReference)
    {
      AppMethodBeat.i(210873);
      this.PGQ = paramWeakReference;
      AppMethodBeat.o(210873);
    }
    
    public final void a(c paramc)
    {
      AppMethodBeat.i(210869);
      kotlin.g.b.p.k(paramc, "conn");
      BaseWebViewController localBaseWebViewController = (BaseWebViewController)this.PGQ.get();
      if (localBaseWebViewController == null)
      {
        AppMethodBeat.o(210869);
        return;
      }
      kotlin.g.b.p.j(localBaseWebViewController, "weakController.get() ?: return");
      if (localBaseWebViewController.gSx())
      {
        Log.i(BaseWebViewController.a(localBaseWebViewController), "WebView-Trace onConnected when destroyCalled");
        AppMethodBeat.o(210869);
        return;
      }
      localBaseWebViewController.PGE = paramc;
      paramc = paramc.gSm();
      kotlin.g.b.p.k(paramc, "<set-?>");
      localBaseWebViewController.pGC = paramc;
      localBaseWebViewController.getJsapi().a(localBaseWebViewController.gSm());
      localBaseWebViewController.b(localBaseWebViewController.gSm());
      Log.i(BaseWebViewController.a(localBaseWebViewController), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
      if (BaseWebViewController.d(localBaseWebViewController).contains(ab.bO(BaseWebViewController.Bind.class).iCe()))
      {
        localBaseWebViewController.bXM();
        AppMethodBeat.o(210869);
        return;
      }
      localBaseWebViewController.anv(localBaseWebViewController.PGh);
      AppMethodBeat.o(210869);
    }
    
    public final boolean gPK()
    {
      AppMethodBeat.i(210871);
      BaseWebViewController localBaseWebViewController = (BaseWebViewController)this.PGQ.get();
      if ((localBaseWebViewController != null) && (localBaseWebViewController.gSv() == true))
      {
        AppMethodBeat.o(210871);
        return true;
      }
      AppMethodBeat.o(210871);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "QuickAppUrl", "", "[Ljava/lang/String;", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"})
  public static final class c
  {
    public static String bk(Intent paramIntent)
    {
      AppMethodBeat.i(216413);
      kotlin.g.b.p.k(paramIntent, "intent");
      try
      {
        localObject2 = paramIntent.getStringExtra("rawUrl");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject1;
          Log.e("MicroMsg.WebViewController", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
          if ((localException instanceof ClassNotFoundException))
          {
            paramIntent = (Throwable)localException;
            AppMethodBeat.o(216413);
            throw paramIntent;
          }
          str = null;
          continue;
          int i = 0;
        }
        label104:
        paramIntent = paramIntent.getData();
        if (paramIntent == null) {
          break label124;
        }
        String str = paramIntent.toString();
        paramIntent = str;
        if (str != null) {
          break label127;
        }
        label124:
        paramIntent = "";
        label127:
        AppMethodBeat.o(216413);
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (kotlin.n.n.ba((CharSequence)localObject2)))
      {
        i = 1;
        if (i != 0) {
          break label104;
        }
        AppMethodBeat.o(216413);
        return localObject1;
      }
      return paramIntent;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "getA8keyScene", "", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZI)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getGetA8keyScene", "()I", "setGetA8keyScene", "(I)V", "getNeverGetA8Key", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"})
  public static final class d
  {
    final BaseWebViewController.g PGR;
    final boolean PGS;
    final boolean PGT;
    final boolean PGU;
    final boolean PGV;
    public int PGW;
    
    public d()
    {
      this(null, false, false, false, false, 63);
    }
    
    public d(BaseWebViewController.g paramg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      AppMethodBeat.i(206502);
      this.PGR = paramg;
      this.PGS = paramBoolean1;
      this.PGT = paramBoolean2;
      this.PGU = paramBoolean3;
      this.PGV = paramBoolean4;
      this.PGW = 0;
      AppMethodBeat.o(206502);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"})
  final class e
    extends com.tencent.mm.ui.widget.k
  {
    public final void a(WebView paramWebView, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(215325);
      Object localObject;
      if ((paramInt >= 100) && (!this.PGP.gSx()))
      {
        this.PGP.PGe = true;
        Log.i(BaseWebViewController.a(this.PGP), "Abe-Debug Progress 100");
        localObject = com.tencent.mm.plugin.webview.k.k.QAg;
        localObject = this.PGP.pHS;
        kotlin.g.b.p.k(localObject, "webView");
        if (((MMWebView)localObject).supportFeature(2006)) {
          break label163;
        }
        paramInt = i;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          localObject = g.PHD;
          if (!g.a.gSJ()) {}
        }
        else
        {
          Log.i(BaseWebViewController.a(this.PGP), "WebView-Trace not support onPageCommitVisible");
          BaseWebViewController localBaseWebViewController1 = this.PGP;
          paramInt = this.PGP.PGt;
          BaseWebViewController localBaseWebViewController2 = this.PGP;
          if (paramWebView != null)
          {
            localObject = paramWebView.getUrl();
            paramWebView = (WebView)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramWebView = "";
          }
          localBaseWebViewController1.cR(paramInt, BaseWebViewController.c(localBaseWebViewController2, paramWebView));
        }
        AppMethodBeat.o(215325);
        return;
        label163:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzH, 0) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt == 0) || (!((MMWebView)localObject).hZL()) || (com.tencent.mm.plugin.webview.k.k.g((MMWebView)localObject) > 86)) {
            break label225;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable SysKernel86");
          paramInt = i;
          break;
        }
        label225:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzI, 1) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!((MMWebView)localObject).hZL()) || (paramInt == 0)) {
            break label277;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable SysKernel");
          paramInt = i;
          break;
        }
        label277:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vzJ, 0) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label321;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable AllKernel");
          paramInt = i;
          break;
        }
        label321:
        paramInt = 1;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", "action", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class f
  {
    final kotlin.l.b<? extends BaseWebViewController.WebAction> PGX;
    final kotlin.g.a.a<x> kRn;
    
    public f(kotlin.l.b<? extends BaseWebViewController.WebAction> paramb, kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(205150);
      this.PGX = paramb;
      this.kRn = parama;
      AppMethodBeat.o(205150);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(205157);
      if (this != paramObject)
      {
        if ((paramObject instanceof f))
        {
          paramObject = (f)paramObject;
          if ((!kotlin.g.b.p.h(this.PGX, paramObject.PGX)) || (!kotlin.g.b.p.h(this.kRn, paramObject.kRn))) {}
        }
      }
      else
      {
        AppMethodBeat.o(205157);
        return true;
      }
      AppMethodBeat.o(205157);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(205155);
      Object localObject = this.PGX;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.kRn;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(205155);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(205153);
      String str = "WebEvent(action=" + this.PGX + ", block=" + this.kRn + ")";
      AppMethodBeat.o(205153);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"})
  public static final class g
  {
    final kotlin.f PGY;
    final kotlin.f PGZ;
    final kotlin.f PHa;
    final kotlin.f PHb;
    
    public g(Intent paramIntent)
    {
      AppMethodBeat.i(210623);
      this.PGY = kotlin.g.ar((kotlin.g.a.a)new b(paramIntent));
      this.PGZ = kotlin.g.ar((kotlin.g.a.a)new d(paramIntent));
      this.PHa = kotlin.g.ar((kotlin.g.a.a)new a(paramIntent));
      this.PHb = kotlin.g.ar((kotlin.g.a.a)new c(paramIntent));
      AppMethodBeat.o(210623);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      a(Intent paramIntent)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      b(Intent paramIntent)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      c(Intent paramIntent)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      d(Intent paramIntent)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.f.c>
  {
    public static final h PHc;
    
    static
    {
      AppMethodBeat.i(206837);
      PHc = new h();
      AppMethodBeat.o(206837);
    }
    
    h()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<x>
  {
    r(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.f.f<bot>>
  {
    s(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<Integer>
  {
    t(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(BaseWebViewController paramBaseWebViewController, int paramInt) {}
    
    public final void run()
    {
      int j = 0;
      AppMethodBeat.i(205711);
      if (paramInt < 0) {}
      for (int i = 1; (kotlin.z.aazO) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(205711);
        throw ((Throwable)localObject);
      }
      Log.i(BaseWebViewController.a(this.PGP), "checkStatus:" + paramInt + " to [" + kotlin.a.j.a((Iterable)BaseWebViewController.c(this.PGP), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.b(this.PGP), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.e(this.PGP), (CharSequence)",", null, null, 0, null, null, 62) + ']');
      BaseWebViewController.c(this.PGP).add(Integer.valueOf(paramInt));
      BaseWebViewController.a(this.PGP, (Iterable)BaseWebViewController.f(this.PGP), (Set)BaseWebViewController.d(this.PGP));
      Object localObject = (CharSequence)this.PGP.PFM;
      if (localObject != null)
      {
        i = j;
        if (!kotlin.n.n.ba((CharSequence)localObject)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        BaseWebViewController.a(this.PGP, (Iterable)BaseWebViewController.g(this.PGP), (Set)BaseWebViewController.e(this.PGP), this.PGP.PFM);
      }
      kotlin.a.j.a((Iterable)BaseWebViewController.a(this.PGP, paramInt), (kotlin.g.a.b)1.PHe);
      AppMethodBeat.o(205711);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class v
    implements Runnable
  {
    v(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(211073);
      if (paramInt > 0) {}
      for (int i = 1; (kotlin.z.aazO) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(211073);
        throw ((Throwable)localObject);
      }
      if ((kotlin.g.b.p.h(paramString, this.PGP.PFM)) || ((this.PGP.PGu.contains(Integer.valueOf(paramInt))) && (kotlin.g.b.p.h(paramString, this.PGP.PFO))) || (this.PGP.PGv.contains(Integer.valueOf(paramInt))))
      {
        Log.i(BaseWebViewController.a(this.PGP), "checkStatus:" + paramInt + ' ' + paramString + " to [" + kotlin.a.j.a((Iterable)BaseWebViewController.c(this.PGP), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.b(this.PGP), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.e(this.PGP), (CharSequence)",", null, null, 0, null, null, 62) + ']');
        BaseWebViewController.b(this.PGP).add(Integer.valueOf(paramInt));
        BaseWebViewController.a(this.PGP, (Iterable)BaseWebViewController.g(this.PGP), (Set)BaseWebViewController.e(this.PGP), this.PGP.PFM);
        AppMethodBeat.o(211073);
        return;
      }
      String str = BaseWebViewController.a(this.PGP);
      StringBuilder localStringBuilder = new StringBuilder("checkStatus skip: ").append(paramInt).append(", url=").append(paramString).append(", startUrl=").append(this.PGP.PFM).append(' ');
      if (this.PGP.PGu.contains(Integer.valueOf(paramInt))) {}
      for (Object localObject = ", spaUrl=" + this.PGP.PFO;; localObject = "")
      {
        Log.w(str, (String)localObject);
        AppMethodBeat.o(211073);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<String>
  {
    w(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.a<x>
  {
    x(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class y
    extends q
    implements kotlin.g.a.a<x>
  {
    y(BaseWebViewController paramBaseWebViewController, String paramString, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    public static final z PHg;
    
    static
    {
      AppMethodBeat.i(206255);
      PHg = new z();
      AppMethodBeat.o(206255);
    }
    
    z()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController
 * JD-Core Version:    0.7.0.1
 */