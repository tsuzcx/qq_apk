package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.webview.e.g.b;
import com.tencent.mm.plugin.webview.k.j.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;
import com.tencent.xweb.ao;
import com.tencent.xweb.t;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
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
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.q;
import kotlin.g.b.u;
import kotlin.v;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_PROGRESS_CACHE_LOAD_START", "getCONTROLLER_PROGRESS_CACHE_LOAD_START", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_LOAD_PROGRESS_FULL", "getPAGE_LOAD_PROGRESS_FULL", "PAGE_PROGRESS_NO_FRAME_AUTH_START", "getPAGE_PROGRESS_NO_FRAME_AUTH_START", "PAGE_PROGRESS_SHOW_TIME_OUT", "getPAGE_PROGRESS_SHOW_TIME_OUT", "PAGE_PROGRESS_STATUS", "getPAGE_PROGRESS_STATUS", "()Ljava/util/Set;", "PAGE_PROGRESS_WEBVIEW_START", "getPAGE_PROGRESS_WEBVIEW_START", "PAGE_SPA_STATUS", "getPAGE_SPA_STATUS", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "browseHistoryWebControllerReportInfo", "Lcom/tencent/mm/plugin/webview/reporter/WebViewBrowseHistoryReportInfo;", "getBrowseHistoryWebControllerReportInfo", "()Lcom/tencent/mm/plugin/webview/reporter/WebViewBrowseHistoryReportInfo;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/concurrent/ConcurrentSkipListSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "fullRespUrl", "getFullRespUrl", "setFullRespUrl", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "hasStartCalled", "getHasStartCalled", "setHasStartCalled", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isInject", "isMarkRiskControl", "setMarkRiskControl", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "keyDownBackCount", "getKeyDownBackCount", "setKeyDownBackCount", "(I)V", "keyDownTime", "", "getKeyDownTime", "()J", "setKeyDownTime", "(J)V", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "openQuickAppIntercept", "getOpenQuickAppIntercept", "openQuickAppIntercept$delegate", "openQuickAppReport", "getOpenQuickAppReport", "openQuickAppReport$delegate", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageErrorMonitor", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "getPageErrorMonitor", "()Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "pageErrorMonitor$delegate", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "prefetchId", "getPrefetchId", "prefetchId$delegate", "prefetchWebControllerReportInfo", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchWebControllerReportInfo;", "getPrefetchWebControllerReportInfo", "()Lcom/tencent/mm/plugin/webview/reporter/PrefetchWebControllerReportInfo;", "setPrefetchWebControllerReportInfo", "(Lcom/tencent/mm/plugin/webview/reporter/PrefetchWebControllerReportInfo;)V", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "showTeenModeNoAccessView", "getShowTeenModeNoAccessView", "setShowTeenModeNoAccessView", "showTeenModeNoAccessViewUrl", "getShowTeenModeNoAccessViewUrl", "setShowTeenModeNoAccessViewUrl", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "textUrlShare", "getTextUrlShare", "setTextUrlShare", "uiDialog", "Landroid/app/Dialog;", "getUiDialog", "()Landroid/app/Dialog;", "setUiDialog", "(Landroid/app/Dialog;)V", "updateRandomStr", "getUpdateRandomStr", "updateRandomStr$delegate", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "webPrefetchPage", "getWebPrefetchPage", "setWebPrefetchPage", "webViewEnv", "Lcom/tencent/mm/plugin/webview/jsapi/media/WebViewEnv;", "getWebViewEnv", "()Lcom/tencent/mm/plugin/webview/jsapi/media/WebViewEnv;", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", "listener", "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canCheckStatus", "check", "url", "canLoadUrl", "canShowRefresh", "checkStatus", "dealSPAUpdate", "destroy", "doAuthCurrentUrl", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", "request", "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCachedAppId", "getCallBackUrl", "getPageLoadType", "getShareUrl", "getStatusListener", "hasA8KeyError", "hasCurrentPageFinished", "hasCurrentPageStarted", "hasStatus", "init", "initEnviroment", "initFont", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "localSetFontSize", "size", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onKeyDownBack", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", "error", "Lcom/tencent/xweb/WebResourceError;", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "Lcom/tencent/xweb/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onTeenModeStatusChange", "onUrlRedirect", "forceRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeClientListener", "removeControllerListener", "removeInterceptor", "removeInvoker", "floating", "removeStatus", "resetActions", "resetPageActions", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "updateDgtVerify", "updateUIStyle", "uiConfig", "jsApiPermission", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "BaseWebViewUIConnectionBinder", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "PageLoadEndForCommitNotSupport", "ProgressBarEnd", "ProgressBarStart", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseWebViewController
  extends ag
  implements com.tencent.mm.plugin.webview.e.a<cdf>
{
  public static final c Wwe = new c((byte)0);
  private static final String[] Wxx = { "https://statres.quickapp.cn/quickapp/js/routerinline.min.js", "http://fastappjump-drcn.hispace.hicloud.com/", "http://thefatherofsalmon.com/", "http://v2.thefatherofsalmon.com/" };
  public final ConcurrentLinkedDeque<m> WmV;
  private String WwA;
  String WwB;
  public boolean WwC;
  public boolean WwD;
  public boolean WwE;
  private final kotlin.j WwF;
  private final kotlin.j WwG;
  private final kotlin.j WwH;
  public final Map<String, String> WwI;
  private final kotlin.j WwJ;
  public final n WwK;
  public final com.tencent.mm.plugin.webview.k.r WwL;
  private final kotlin.j WwM;
  private final ConcurrentLinkedDeque<h> WwN;
  public final ConcurrentLinkedDeque<l> WwO;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<kotlin.g.a.a<ah>>> WwP;
  public boolean WwQ;
  boolean WwR;
  private final kotlin.j WwS;
  final int WwT;
  public final int WwU;
  public final int WwV;
  public final int WwW;
  protected final int WwX;
  final int WwY;
  public final int WwZ;
  public final d Wwf;
  private Set<String> Wwg;
  private com.tencent.mm.plugin.webview.jsapi.g Wwh;
  private final kotlin.j Wwi;
  public com.tencent.mm.plugin.webview.h.f Wwj;
  public final com.tencent.mm.plugin.webview.h.g Wwk;
  private final kotlin.j Wwl;
  public final com.tencent.mm.plugin.webview.jsapi.b.b Wwm;
  public boolean Wwn;
  public String Wwo;
  public Dialog Wwp;
  private int Wwq;
  private long Wwr;
  private boolean Wws;
  public boolean Wwt;
  private boolean Wwu;
  public final kotlin.j Wwv;
  public String Www;
  private final kotlin.j Wwx;
  String Wwy;
  public String Wwz;
  public final int Wxa;
  final int Wxb;
  final int Wxc;
  final int Wxd;
  public final int Wxe;
  final int Wxf;
  final int Wxg;
  private final Set<Integer> Wxh;
  final Set<Integer> Wxi;
  private final boolean Wxj;
  private final ConcurrentLinkedDeque<kotlin.r<ControllerAction, kotlin.g.a.a<ah>>> Wxk;
  private final ConcurrentLinkedDeque<kotlin.r<PageAction, kotlin.g.a.a<ah>>> Wxl;
  public final ConcurrentSkipListSet<Integer> Wxm;
  private final ConcurrentSkipListSet<Integer> Wxn;
  private final ConcurrentSkipListSet<String> Wxo;
  private final ConcurrentSkipListSet<String> Wxp;
  public final boolean Wxq;
  public e Wxr;
  private final kotlin.j Wxs;
  private boolean Wxt;
  private final kotlin.j Wxu;
  private final kotlin.j Wxv;
  private final kotlin.j Wxw;
  private String heA;
  protected Intent intent;
  private final kotlin.j rdm;
  public com.tencent.mm.plugin.webview.stub.e sLC;
  public final com.tencent.mm.plugin.webview.e.g sLD;
  public final MMWebView sMP;
  private final List<f> vWE;
  
  public BaseWebViewController(MMWebView paramMMWebView, d paramd, Set<String> paramSet, com.tencent.mm.plugin.webview.jsapi.g paramg)
  {
    this.sMP = paramMMWebView;
    this.Wwf = paramd;
    this.Wwg = paramSet;
    this.Wwh = paramg;
    this.Wwi = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.Wwj = new com.tencent.mm.plugin.webview.h.f();
    this.Wwk = new com.tencent.mm.plugin.webview.h.g();
    this.Wwl = kotlin.k.cm((kotlin.g.a.a)new s(this));
    this.Wwm = new com.tencent.mm.plugin.webview.jsapi.b.b();
    this.Wwv = kotlin.k.cm((kotlin.g.a.a)new ae(this));
    this.Wwx = kotlin.k.cm((kotlin.g.a.a)h.WxM);
    this.heA = "";
    this.Wwy = "";
    this.Wwz = "";
    this.WwA = "";
    this.WwB = "";
    this.WwF = kotlin.k.cm((kotlin.g.a.a)new z(this));
    this.WwG = kotlin.k.cm((kotlin.g.a.a)new aa(this));
    this.WwH = kotlin.k.cm((kotlin.g.a.a)new t(this));
    this.rdm = kotlin.k.cm((kotlin.g.a.a)y.WxO);
    this.sLD = new com.tencent.mm.plugin.webview.e.g((g.b)new ak(this));
    this.WwI = ((Map)new ConcurrentHashMap());
    this.WwJ = kotlin.k.cm((kotlin.g.a.a)new af(this));
    this.WwK = ((n)new ag(this));
    this.WwL = new com.tencent.mm.plugin.webview.k.r();
    this.WwM = kotlin.k.cm((kotlin.g.a.a)new ad(this));
    this.WmV = new ConcurrentLinkedDeque();
    this.WwN = new ConcurrentLinkedDeque();
    this.WwO = new ConcurrentLinkedDeque();
    this.WwP = new ConcurrentHashMap();
    this.WwS = kotlin.k.cm((kotlin.g.a.a)new v(this));
    this.WwT = -1;
    this.WwU = -2;
    this.WwV = -3;
    this.WwW = -10;
    this.WwX = -5;
    this.WwY = 1;
    this.WwZ = 2;
    this.Wxa = 3;
    this.Wxb = 4;
    this.Wxc = 6;
    this.Wxd = 10;
    this.Wxe = 11;
    this.Wxf = 12;
    this.Wxg = 13;
    this.Wxh = ar.setOf(new Integer[] { Integer.valueOf(this.Wxe), Integer.valueOf(this.Wxf), Integer.valueOf(this.Wxd), Integer.valueOf(this.Wxg) });
    this.Wxi = ar.setOf(new Integer[] { Integer.valueOf(this.Wxa), Integer.valueOf(this.Wxb), Integer.valueOf(this.Wxc) });
    this.Wxj = true;
    this.vWE = p.mutableListOf(new f[] { new f(ai.cz(Init.class), (kotlin.g.a.a)new i()), new f(ai.cz(PageLoadEndForCommitNotSupport.class), (kotlin.g.a.a)new k(this)), new f(ai.cz(Inject.class), (kotlin.g.a.a)new l(this)), new f(ai.cz(Bind.class), (kotlin.g.a.a)new m()), new f(ai.cz(Auth.class), (kotlin.g.a.a)new n(this)), new f(ai.cz(Ready.class), (kotlin.g.a.a)new o(this)), new f(ai.cz(Start.class), (kotlin.g.a.a)new p(this)), new f(ai.cz(SPAUpdated.class), (kotlin.g.a.a)new q(this)), new f(ai.cz(ProgressBarStart.class), (kotlin.g.a.a)new r(this)), new f(ai.cz(ProgressBarEnd.class), (kotlin.g.a.a)new j(this)) });
    this.Wxk = new ConcurrentLinkedDeque();
    this.Wxl = new ConcurrentLinkedDeque();
    this.Wxm = new ConcurrentSkipListSet();
    this.Wxn = new ConcurrentSkipListSet();
    this.Wxo = new ConcurrentSkipListSet();
    this.Wxp = new ConcurrentSkipListSet();
    if (irI().WOP.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.Wxq = bool;
      this.Wxs = kotlin.k.cm((kotlin.g.a.a)ai.WxR);
      this.Wxu = kotlin.k.cm((kotlin.g.a.a)aj.WxS);
      this.Wxv = kotlin.k.cm((kotlin.g.a.a)ac.WxQ);
      this.Wxw = kotlin.k.cm((kotlin.g.a.a)ab.WxP);
      return;
    }
  }
  
  private final String YM(String paramString)
  {
    if (!ajL(paramString)) {
      paramString = this.Wwz;
    }
    for (;;)
    {
      String str = paramString;
      if (kotlin.n.n.bp((CharSequence)paramString))
      {
        str = paramString;
        if (atn(this.WwV)) {
          str = dgY();
        }
      }
      return str;
    }
  }
  
  private static final void a(int paramInt, BaseWebViewController paramBaseWebViewController)
  {
    int j = 0;
    kotlin.g.b.s.u(paramBaseWebViewController, "this$0");
    if (paramInt < 0) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Log.i(paramBaseWebViewController.irB(), "checkStatus:" + paramInt + " to [" + p.a((Iterable)paramBaseWebViewController.Wxn, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + p.a((Iterable)paramBaseWebViewController.Wxm, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + p.a((Iterable)paramBaseWebViewController.Wxo, (CharSequence)",", null, null, 0, null, null, 62) + ']');
    paramBaseWebViewController.Wxn.add(Integer.valueOf(paramInt));
    paramBaseWebViewController.a((Iterable)paramBaseWebViewController.Wxk, (Set)paramBaseWebViewController.Wxp, null);
    CharSequence localCharSequence = (CharSequence)paramBaseWebViewController.Wwy;
    if (localCharSequence != null)
    {
      i = j;
      if (!kotlin.n.n.bp(localCharSequence)) {}
    }
    else
    {
      i = 1;
    }
    if (i == 0) {
      paramBaseWebViewController.a((Iterable)paramBaseWebViewController.Wxl, (Set)paramBaseWebViewController.Wxo, paramBaseWebViewController.Wwy);
    }
    p.a((Iterable)paramBaseWebViewController.atl(paramInt), (kotlin.g.a.b)u.WxN);
  }
  
  private static final void a(int paramInt, BaseWebViewController paramBaseWebViewController, String paramString)
  {
    kotlin.g.b.s.u(paramBaseWebViewController, "this$0");
    kotlin.g.b.s.u(paramString, "$url");
    if (paramInt > 0) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    if (paramBaseWebViewController.dH(paramInt, paramString))
    {
      Log.i(paramBaseWebViewController.irB(), "checkStatus:" + paramInt + ' ' + paramString + " to [" + p.a((Iterable)paramBaseWebViewController.Wxn, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + p.a((Iterable)paramBaseWebViewController.Wxm, (CharSequence)",", null, null, 0, null, null, 62) + "] [" + p.a((Iterable)paramBaseWebViewController.Wxo, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      paramBaseWebViewController.Wxm.add(Integer.valueOf(paramInt));
      paramBaseWebViewController.a((Iterable)paramBaseWebViewController.Wxl, (Set)paramBaseWebViewController.Wxo, paramBaseWebViewController.Wwy);
      return;
    }
    String str = paramBaseWebViewController.irB();
    paramString = new StringBuilder("checkStatus skip: ").append(paramInt).append(", url=").append(paramString).append(", startUrl=").append(paramBaseWebViewController.Wwy).append(' ');
    if (paramBaseWebViewController.Wxh.contains(Integer.valueOf(paramInt))) {}
    for (paramBaseWebViewController = kotlin.g.b.s.X(", spaUrl=", paramBaseWebViewController.WwA);; paramBaseWebViewController = "")
    {
      Log.w(str, paramBaseWebViewController);
      return;
    }
  }
  
  private static final void a(BaseWebViewController paramBaseWebViewController)
  {
    kotlin.g.b.s.u(paramBaseWebViewController, "this$0");
    paramBaseWebViewController.getHandler().postUIDelayed(paramBaseWebViewController.irM(), 500L);
  }
  
  private static final void a(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString)
  {
    kotlin.g.b.s.u(paramBaseWebViewController, "this$0");
    kotlin.g.b.s.u(paramString, "$reqUrl");
    paramBaseWebViewController = ((Iterable)paramBaseWebViewController.WwO).iterator();
    while (paramBaseWebViewController.hasNext()) {
      ((l)paramBaseWebViewController.next()).cb(paramInt, paramString);
    }
  }
  
  private final <T extends WebAction> void a(Iterable<? extends kotlin.r<? extends T, ? extends kotlin.g.a.a<ah>>> paramIterable, Set<String> paramSet, String paramString)
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
        paramIterable = (kotlin.r)localIterator.next();
        localWebAction = (WebAction)paramIterable.bsC;
        paramIterable = (kotlin.g.a.a)paramIterable.bsD;
        if (!(localWebAction instanceof PageAction)) {
          break label235;
        }
        if ((paramString != null) && (((PageAction)localWebAction).verify(paramString)))
        {
          bool = true;
          if (!bool) {
            continue;
          }
          Log.i(irB(), "verify WebAction: " + ai.cz(localWebAction.getClass()).klt() + " start");
          if (!localWebAction.getKeep()) {
            localIterator.remove();
          }
          paramIterable.invoke();
          String str = ai.cz(localWebAction.getClass()).klt();
          paramIterable = str;
          if (str == null) {
            paramIterable = "";
          }
          paramSet.add(paramIterable);
          Log.v(irB(), "verifyActions: " + ai.cz(localWebAction.getClass()).klt() + " end");
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
  
  private boolean ato(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!kotlin.ak.aiuY) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.Wxn.remove(Integer.valueOf(paramInt));
    return bool;
  }
  
  public static final String bK(Intent paramIntent)
  {
    return c.bK(paramIntent);
  }
  
  private final String biY(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!com.tencent.luggage.l.c.a(paramString, "about:blank", true)))
      {
        localObject = paramString;
        if (!com.tencent.luggage.l.c.a(paramString, "data:text/html;charset=utf-8", true)) {}
      }
      else
      {
        localObject = this.heA;
      }
      return localObject;
    }
  }
  
  private final void bjb(String paramString)
  {
    try
    {
      Log.i(irB(), "resetPageActions clear status:" + paramString + ", [" + p.a((Iterable)this.Wxm, (CharSequence)",", null, null, 0, null, null, 62) + "] actions: [" + p.a((Iterable)this.Wxo, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      this.Wxm.clear();
      this.Wxo.clear();
      this.Wxl.clear();
      this.WwR = false;
      Iterator localIterator = ((Iterable)dhc()).iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        Object localObject = kotlin.l.a.c.e(localf.WxH);
        ((WebAction)localObject).setController(this);
        localObject = (WebAction)localObject;
        if ((localObject instanceof PageAction)) {
          this.Wxl.add(v.Y(localObject, localf.nsP));
        }
      }
      biZ(paramString);
    }
    finally {}
    this.WwA = "";
  }
  
  private final int bjc(String paramString)
  {
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    while (localIterator.hasNext())
    {
      int i = ((m)localIterator.next()).bjc(paramString);
      if (i != -1) {
        return i;
      }
    }
    return irI().dJ(paramString, false);
  }
  
  private final void bji(String paramString)
  {
    if ((((Boolean)this.Wxs.getValue()).booleanValue()) && (!this.sMP.rsE) && (!atn(this.WwW)) && (paramString != null) && (!kotlin.n.n.U(paramString, "file:", false)) && (!irQ()))
    {
      paramString = getJsapi();
      if (paramString != null)
      {
        paramString.WDI = true;
        paramString.KQY = Util.getRandomString(16);
        paramString.WDz.setRandomStr(paramString.KQY);
        Log.i("MicroMsg.JsApiHandler", "WebView-Trace js digest updateDgtVerify randomStr = %s, hashCode: %d", new Object[] { paramString.KQY, Integer.valueOf(paramString.hashCode()) });
      }
    }
  }
  
  private boolean dH(int paramInt, String paramString)
  {
    kotlin.g.b.s.u(paramString, "url");
    return (kotlin.g.b.s.p(paramString, this.Wwy)) || ((this.Wxh.contains(Integer.valueOf(paramInt))) && (kotlin.g.b.s.p(paramString, this.WwA))) || (this.Wxi.contains(Integer.valueOf(paramInt)));
  }
  
  private final String irB()
  {
    return (String)this.Wwi.getValue();
  }
  
  private final com.tencent.mm.plugin.webview.e.f<cdf> irE()
  {
    return (com.tencent.mm.plugin.webview.e.f)this.Wwl.getValue();
  }
  
  private final g irN()
  {
    return (g)this.WwM.getValue();
  }
  
  /* Error */
  private final void irP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 1051	com/tencent/mm/plugin/webview/core/BaseWebViewController:irB	()Ljava/lang/String;
    //   6: ldc_w 1383
    //   9: invokestatic 1087	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 958	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxn	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   16: invokevirtual 1257	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   19: aload_0
    //   20: getfield 962	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxp	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   23: invokevirtual 1257	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   26: aload_0
    //   27: getfield 949	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxk	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   30: invokevirtual 1258	java/util/concurrent/ConcurrentLinkedDeque:clear	()V
    //   33: aload_0
    //   34: getfield 956	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxm	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   37: invokevirtual 1257	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   40: aload_0
    //   41: getfield 960	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxo	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   44: invokevirtual 1257	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   47: aload_0
    //   48: getfield 951	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxl	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   51: invokevirtual 1258	java/util/concurrent/ConcurrentLinkedDeque:clear	()V
    //   54: aload_0
    //   55: invokevirtual 1263	com/tencent/mm/plugin/webview/core/BaseWebViewController:dhc	()Ljava/util/List;
    //   58: checkcast 1068	java/lang/Iterable
    //   61: invokeinterface 1152 1 0
    //   66: astore_1
    //   67: aload_1
    //   68: invokeinterface 1157 1 0
    //   73: ifeq +78 -> 151
    //   76: aload_1
    //   77: invokeinterface 1161 1 0
    //   82: checkcast 84	com/tencent/mm/plugin/webview/core/BaseWebViewController$f
    //   85: astore_2
    //   86: aload_2
    //   87: getfield 1267	com/tencent/mm/plugin/webview/core/BaseWebViewController$f:WxH	Lkotlin/l/c;
    //   90: invokestatic 1272	kotlin/l/a/c:e	(Lkotlin/l/c;)Ljava/lang/Object;
    //   93: astore_3
    //   94: aload_3
    //   95: checkcast 45	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction
    //   98: aload_0
    //   99: invokevirtual 1275	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction:setController	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V
    //   102: aload_3
    //   103: checkcast 45	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction
    //   106: astore_3
    //   107: aload_3
    //   108: instanceof 15
    //   111: ifeq +43 -> 154
    //   114: aload_0
    //   115: getfield 949	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxk	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   118: aload_3
    //   119: aload_2
    //   120: getfield 1279	com/tencent/mm/plugin/webview/core/BaseWebViewController$f:nsP	Lkotlin/g/a/a;
    //   123: invokestatic 1285	kotlin/v:Y	(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/r;
    //   126: invokevirtual 1286	java/util/concurrent/ConcurrentLinkedDeque:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: goto -63 -> 67
    //   133: astore_1
    //   134: aload_0
    //   135: invokespecial 1051	com/tencent/mm/plugin/webview/core/BaseWebViewController:irB	()Ljava/lang/String;
    //   138: ldc_w 1385
    //   141: aload_1
    //   142: invokevirtual 1388	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   145: invokestatic 1130	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   148: invokestatic 1087	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: monitorexit
    //   153: return
    //   154: aload_3
    //   155: instanceof 24
    //   158: ifeq -91 -> 67
    //   161: aload_0
    //   162: getfield 951	com/tencent/mm/plugin/webview/core/BaseWebViewController:Wxl	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   165: aload_3
    //   166: aload_2
    //   167: getfield 1279	com/tencent/mm/plugin/webview/core/BaseWebViewController$f:nsP	Lkotlin/g/a/a;
    //   170: invokestatic 1285	kotlin/v:Y	(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/r;
    //   173: invokevirtual 1286	java/util/concurrent/ConcurrentLinkedDeque:add	(Ljava/lang/Object;)Z
    //   176: pop
    //   177: goto -110 -> 67
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	BaseWebViewController
    //   66	11	1	localIterator	Iterator
    //   133	9	1	localException	Exception
    //   180	4	1	localObject1	Object
    //   85	82	2	localf	f
    //   93	73	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   54	67	133	java/lang/Exception
    //   67	130	133	java/lang/Exception
    //   154	177	133	java/lang/Exception
    //   2	54	180	finally
    //   54	67	180	finally
    //   67	130	180	finally
    //   134	151	180	finally
    //   154	177	180	finally
  }
  
  private final int irW()
  {
    if (!dhh()) {
      return 0;
    }
    if (this.Wws) {
      return 2;
    }
    return 1;
  }
  
  private final void n(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (this.WwQ) && (paramWebView.canGoBack()))
    {
      Log.i(irB(), kotlin.g.b.s.X("clearHistory :", paramString));
      paramWebView.clearHistory();
      if (!Util.isEqual(paramString, "about:blank")) {
        this.WwQ = false;
      }
    }
  }
  
  public final void Ir(boolean paramBoolean)
  {
    try
    {
      if (irJ() != null)
      {
        if (!paramBoolean) {
          irJ().auf(irL());
        }
        irJ().cl(irL(), paramBoolean);
      }
      Log.i(irB(), "removeInvoker ok");
      return;
    }
    catch (Exception localException)
    {
      Log.w(irB(), kotlin.g.b.s.X("onDestroy, remove callback and invoke event on webview destroy, ex = ", localException));
    }
  }
  
  protected final void Is(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.WwO).iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).Is(paramBoolean);
    }
  }
  
  public final void J(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString1 = this.sMP.getSettings();
      if (paramString1 != null) {
        paramString1.setJavaScriptEnabled(false);
      }
      this.sMP.loadData(paramString2, "text/html", "utf-8");
    }
  }
  
  public final void X(String paramString, Map<String, String> paramMap)
  {
    kotlin.g.b.s.u(paramString, "baseUrl");
    Log.i(irB(), kotlin.g.b.s.X("WebView-Trace loadCacheUrl baseUrl ", paramString));
    this.heA = paramString;
    this.Wws = true;
    atm(this.WwX);
    this.sMP.loadUrl(paramString, paramMap);
    bja(paramString);
    atm(this.WwW);
    com.tencent.threadpool.h.ahAA.bk(new BaseWebViewController..ExternalSyntheticLambda2(this));
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    kotlin.g.b.s.u(paramWebView, "webview");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, null);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest);
    }
    return localWebResourceResponse1;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    kotlin.g.b.s.u(paramWebView, "webview");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, paramBundle);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    }
    return localWebResourceResponse1;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    kotlin.g.b.s.u(paramString1, "reqUrl");
    kotlin.g.b.s.u(paramString2, "errMsg");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.WwB = paramString1;
      dI(this.WwZ, paramString1);
      Iterator localIterator = ((Iterable)this.WwO).iterator();
      while (localIterator.hasNext()) {
        ((l)localIterator.next()).b(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
      }
      this.Www = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, cdf paramcdf)
  {
    boolean bool2 = true;
    kotlin.g.b.s.u(paramString1, "reqUrl");
    kotlin.g.b.s.u(paramString2, "fullUrl");
    kotlin.g.b.s.u(paramcdf, "response");
    Log.d(irB(), "WebView-Trace onPermissionUpdate reason:" + paramInt + ", :" + paramString1 + ", fullUrl:" + paramString2);
    if (irU())
    {
      Log.d(irB(), "onPermissionUpdate destroyCalled");
      return;
    }
    this.WwB = paramString2;
    this.sLD.a(paramString1, irI().blb(paramString1), irI().blc(paramString1));
    this.sLD.a(paramString2, irI().blb(paramString2), irI().blc(paramString2));
    Iterator localIterator = ((Iterable)this.WwO).iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).a(paramInt, paramString1, paramcdf);
    }
    dI(this.WwY, paramString1);
    dI(this.WwY, paramString2);
    if (!this.Wwt)
    {
      paramString2 = this.sLD.iwp();
      if (paramString2 == null)
      {
        bool1 = false;
        this.Wwt = bool1;
      }
    }
    else if (!this.Wwu)
    {
      paramString2 = irI().WPd;
      if ((paramString2 == null) || (paramString2.aanE != 1)) {
        break label345;
      }
    }
    label345:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.Wwu = bool1;
      if (!kotlin.g.b.s.p(paramString1, this.WwA)) {
        break;
      }
      dI(this.Wxf, paramString1);
      Log.i(irB(), kotlin.g.b.s.X("WebAction:Ready onPermissionUpdated Patch: ", this.WwA));
      return;
      if ((paramString2.YxC & 0x800000) > 0) {}
      for (bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.GeneralControlWrapper", "isMarkRiskControl, ret = ".concat(String.valueOf(bool1)));
        break;
      }
    }
  }
  
  public final void a(h paramh)
  {
    kotlin.g.b.s.u(paramh, "listener");
    if (!this.WwN.contains(paramh)) {
      this.WwN.add(paramh);
    }
  }
  
  public final void a(l paraml)
  {
    try
    {
      kotlin.g.b.s.u(paraml, "listener");
      if (!this.WwO.contains(paraml))
      {
        kotlin.g.b.s.u(this, "<set-?>");
        paraml.controller = this;
        this.WwO.add(paraml);
        if (this.Wxp.contains(ai.cz(Bind.class).klt()))
        {
          Log.i(irB(), "Abe-Debug Patch Call onBind");
          paraml.cxX();
        }
      }
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public final void a(m paramm)
  {
    kotlin.g.b.s.u(paramm, "interceptor");
    this.WmV.add(paramm);
    Object localObject = paramm.isN();
    if (localObject != null) {
      a((h)localObject);
    }
    localObject = paramm.cxU();
    if (localObject != null) {
      a((l)localObject);
    }
    paramm.k(this);
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (com.tencent.mm.compatible.util.d.rb(23)) {}
    for (;;)
    {
      return;
      if (!atn(this.WwV))
      {
        Log.i(irB(), "onReceivedError, intent not ready");
        return;
      }
      Log.i(irB(), "WebView-Trace onReceivedError-old, errCode:" + paramInt + ", description:" + paramString1 + ", failingUrl:" + paramString2);
      Object localObject2;
      if (atn(this.WwU))
      {
        localObject1 = irN();
        localObject2 = bjg(getCurrentUrl());
        g.a locala = g.WxV;
        g.a((g)localObject1, paramInt, paramString1, paramString2, (String)localObject2, g.a.g(this.sMP), irW());
      }
      Object localObject1 = ((Iterable)this.WwN).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (h)((Iterator)localObject1).next();
        if (isStarted()) {
          ((h)localObject2).a(paramWebView, paramInt, paramString1, paramString2);
        }
      }
    }
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    Object localObject2 = null;
    super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    if (!atn(this.WwV))
    {
      Log.i(irB(), "onReceivedHttpError, intent not ready");
      return;
    }
    Object localObject3 = irB();
    StringBuilder localStringBuilder = new StringBuilder("WebView-Trace onReceivedHttpError, errCode:");
    if (paramWebResourceResponse == null)
    {
      localObject1 = null;
      label57:
      localStringBuilder = localStringBuilder.append(localObject1).append(", description:");
      if (paramWebResourceResponse != null) {
        break label235;
      }
      localObject1 = null;
      label79:
      localStringBuilder = localStringBuilder.append(localObject1).append(", failingUrl:");
      if (paramWebResourceRequest != null) {
        break label244;
      }
    }
    label235:
    label244:
    for (Object localObject1 = localObject2;; localObject1 = paramWebResourceRequest.getUrl())
    {
      Log.i((String)localObject3, localObject1);
      if (atn(this.WwU))
      {
        localObject1 = irN();
        localObject2 = bjg(getCurrentUrl());
        localObject3 = g.WxV;
        ((g)localObject1).a(paramWebResourceRequest, paramWebResourceResponse, (String)localObject2, g.a.g(this.sMP), irW());
      }
      localObject1 = ((Iterable)this.WwN).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (h)((Iterator)localObject1).next();
        if (isStarted()) {
          ((h)localObject2).a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        }
      }
      break;
      localObject1 = Integer.valueOf(paramWebResourceResponse.mStatusCode);
      break label57;
      localObject1 = paramWebResourceResponse.mReasonPhrase;
      break label79;
    }
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, ac paramac)
  {
    super.a(paramWebView, paramWebResourceRequest, paramac);
    if ((paramWebResourceRequest == null) || (paramac == null) || (com.tencent.mm.compatible.util.d.rc(23))) {
      return;
    }
    if (!atn(this.WwV))
    {
      Log.i(irB(), "onReceivedError, intent not ready");
      return;
    }
    int i = paramac.getErrorCode();
    paramWebView = paramac.getDescription();
    if (paramWebView == null)
    {
      paramWebView = null;
      label63:
      localObject = paramWebResourceRequest.getUrl();
      if (localObject != null) {
        break label244;
      }
    }
    label244:
    for (Object localObject = null;; localObject = ((Uri)localObject).toString())
    {
      Log.i(irB(), "WebView-Trace onReceivedError, errCode:" + i + ", description:" + paramWebView + ", failingUrl:" + localObject);
      if (atn(this.WwU))
      {
        g localg = irN();
        String str = bjg(getCurrentUrl());
        g.a locala = g.WxV;
        localg.a(i, paramWebView, (String)localObject, str, g.a.g(this.sMP), irW(), paramWebResourceRequest.isForMainFrame());
      }
      paramWebView = ((Iterable)this.WwN).iterator();
      while (paramWebView.hasNext())
      {
        localObject = (h)paramWebView.next();
        if (isStarted()) {
          ((h)localObject).a(paramWebResourceRequest, paramac);
        }
      }
      break;
      paramWebView = paramWebView.toString();
      break label63;
    }
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.l paraml, String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paraml, "handler");
    super.a(paramWebView, paraml, paramString1, paramString2);
    com.tencent.mm.plugin.report.service.h.OAn.p(155L, 35L, 1L);
  }
  
  public void a(WebView paramWebView, t paramt, SslError paramSslError)
  {
    super.a(paramWebView, paramt, paramSslError);
    if (!atn(this.WwV))
    {
      Log.i(irB(), "onReceivedSslError, intent not ready");
      return;
    }
    Object localObject2 = irB();
    if (paramSslError == null) {}
    for (Object localObject1 = null;; localObject1 = paramSslError.toString())
    {
      Log.i((String)localObject2, kotlin.g.b.s.X("WebView-Trace onReceivedSslError, ", localObject1));
      if (atn(this.WwU))
      {
        localObject1 = irN();
        localObject2 = bjg(getCurrentUrl());
        g.a locala = g.WxV;
        ((g)localObject1).a(paramSslError, (String)localObject2, g.a.g(this.sMP), irW());
      }
      localObject1 = ((Iterable)this.WwN).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (h)((Iterator)localObject1).next();
        if (isStarted()) {
          ((h)localObject2).a(paramWebView, paramt, paramSslError);
        }
      }
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    kotlin.g.b.s.u(paramString, "uiConfig");
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    kotlin.g.b.s.u(paramWebView, "view");
    kotlin.g.b.s.u(paramString, "url");
    Log.i(irB(), kotlin.g.b.s.X("shouldOverrideUrlLoading: ", paramString));
    Log.d(irB(), kotlin.g.b.s.X("doShouldOverrideUrlLoading url:", paramString));
    boolean bool1;
    if (m(paramWebView, paramString))
    {
      bool1 = bool2;
      if (!bool1) {
        this.Www = paramString;
      }
      return bool1;
    }
    label146:
    if (bjc(paramString) == 2)
    {
      bool1 = true;
      label83:
      if (aY(paramString, bool1))
      {
        if (this.Wwf.WxE) {
          break label177;
        }
        switch (bjc(paramString))
        {
        default: 
          i = 0;
          if (i == 0) {
            break;
          }
        }
      }
    }
    label177:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        break;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label83;
      i = 1;
      break label146;
    }
  }
  
  protected boolean aY(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    kotlin.g.b.s.u(paramString, "url");
    if (a(this, paramString, paramBoolean, 0, 4) == com.tencent.mm.plugin.webview.e.c.a.WPn) {
      bool = true;
    }
    return bool;
  }
  
  protected boolean ajK(String paramString)
  {
    kotlin.g.b.s.u(paramString, "url");
    return true;
  }
  
  protected boolean ajL(String paramString)
  {
    kotlin.g.b.s.u(paramString, "url");
    if (!kotlin.n.n.bp((CharSequence)paramString)) {}
    for (int i = 1; (i != 0) && (!kotlin.n.n.U(paramString, "data:text/html;charset=utf-8", false)) && (!kotlin.n.n.U(paramString, "about:blank", false)); i = 0)
    {
      if (atn(this.WwW))
      {
        String str = com.tencent.mm.plugin.webview.g.a.vVP;
        kotlin.g.b.s.s(str, "HARDCODE_URL");
        if (kotlin.n.n.U(paramString, str, false)) {
          break;
        }
      }
      return true;
    }
    return false;
  }
  
  public final ConcurrentLinkedDeque<kotlin.g.a.a<ah>> atl(int paramInt)
  {
    ConcurrentLinkedDeque localConcurrentLinkedDeque2 = (ConcurrentLinkedDeque)this.WwP.get(Integer.valueOf(paramInt));
    ConcurrentLinkedDeque localConcurrentLinkedDeque1 = localConcurrentLinkedDeque2;
    if (localConcurrentLinkedDeque2 == null)
    {
      localConcurrentLinkedDeque1 = new ConcurrentLinkedDeque();
      ((Map)this.WwP).put(Integer.valueOf(paramInt), localConcurrentLinkedDeque1);
    }
    return localConcurrentLinkedDeque1;
  }
  
  /* Error */
  public final void atm(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1515	com/tencent/mm/plugin/webview/core/BaseWebViewController:irU	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 1471	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   17: new 1792	com/tencent/mm/plugin/webview/core/BaseWebViewController$$ExternalSyntheticLambda0
    //   20: dup
    //   21: iload_1
    //   22: aload_0
    //   23: invokespecial 1794	com/tencent/mm/plugin/webview/core/BaseWebViewController$$ExternalSyntheticLambda0:<init>	(ILcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V
    //   26: invokeinterface 1480 2 0
    //   31: pop
    //   32: goto -21 -> 11
    //   35: astore_3
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_3
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	BaseWebViewController
    //   0	40	1	paramInt	int
    //   6	2	2	bool	boolean
    //   35	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	35	finally
    //   14	32	35	finally
  }
  
  public final boolean atn(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!kotlin.ak.aiuY) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.Wxn.contains(Integer.valueOf(paramInt));
    return bool;
  }
  
  protected final void atp(int paramInt)
  {
    Iterator localIterator = ((Iterable)this.WwO).iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).atp(paramInt);
    }
  }
  
  public final void atq(int paramInt)
  {
    Object localObject = this.sMP;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((MMWebView)localObject).getSettings()) {
      return;
    }
    int i = paramInt;
    if (paramInt <= 0) {
      i = 2;
    }
    Log.i(irB(), kotlin.g.b.s.X("localSetFontSize, fontSize = ", Integer.valueOf(i)));
    switch (i)
    {
    default: 
      this.sMP.getSettings().setTextZoom(100);
    }
    for (;;)
    {
      this.Wwm.ni(i, this.sMP.getSettings().getTextZoom());
      return;
      this.sMP.getSettings().setTextZoom(80);
      continue;
      this.sMP.getSettings().setTextZoom(100);
      continue;
      this.sMP.getSettings().setTextZoom(110);
      continue;
      this.sMP.getSettings().setTextZoom(112);
      continue;
      this.sMP.getSettings().setTextZoom(113);
      continue;
      this.sMP.getSettings().setTextZoom(140);
      continue;
      this.sMP.getSettings().setTextZoom(155);
      continue;
      this.sMP.getSettings().setTextZoom(165);
    }
  }
  
  protected WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    kotlin.g.b.s.u(paramWebView, "webView");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    Log.i(irB(), "shouldInterceptRequest, url = " + paramWebResourceRequest.getUrl() + ", method = " + paramWebResourceRequest.getMethod() + ", isForMainFrame = " + paramWebResourceRequest.isForMainFrame());
    Object localObject = paramWebResourceRequest.getUrl().toString();
    kotlin.g.b.s.s(localObject, "request.url.toString()");
    if (bje((String)localObject)) {
      return null;
    }
    if ((com.tencent.mm.xwebutil.c.nV(getContext())) && (paramBundle != null)) {}
    for (;;)
    {
      try
      {
        i = paramBundle.getInt("resourceType");
        switch (i)
        {
        }
      }
      catch (Exception paramBundle)
      {
        Log.w(irB(), kotlin.g.b.s.X("get resource type failed Exception ; ", paramBundle.getMessage()));
        continue;
      }
      finally
      {
        Log.w(irB(), kotlin.g.b.s.X("get resource type failed Throwable ; ", paramBundle.getMessage()));
        continue;
        if (!((Boolean)this.Wxv.getValue()).booleanValue()) {
          break label530;
        }
        paramWebView = Wxx;
        int m = paramWebView.length;
        int j = 0;
        int i = 0;
        if (i >= m) {
          break label530;
        }
        paramBundle = paramWebView[i];
        localObject = paramWebResourceRequest.getUrl();
        if (localObject == null) {
          continue;
        }
        localObject = ((Uri)localObject).toString();
        if ((localObject == null) || (kotlin.n.n.U((String)localObject, paramBundle, false) != true)) {
          continue;
        }
        int k = 1;
        if (k == 0) {
          continue;
        }
        Log.i(irB(), kotlin.g.b.s.X("QuickAppInterceptor interceptor url = ", paramBundle));
        com.tencent.mm.plugin.report.service.h.OAn.p(1551L, j + 1, 1L);
        if (!((Boolean)this.Wxw.getValue()).booleanValue()) {
          continue;
        }
        Log.i(irB(), "QuickAppInterceptor interceptor WebResourceResponse");
        return new WebResourceResponse("", null, null);
        k = 0;
        continue;
        j += 1;
        i += 1;
        continue;
      }
      paramBundle = ((Iterable)this.WmV).iterator();
      if (!paramBundle.hasNext()) {
        continue;
      }
      localObject = ((m)paramBundle.next()).b(paramWebView, paramWebResourceRequest);
      if (localObject != null)
      {
        return localObject;
        Log.i(irB(), "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        paramBundle = irI();
        localObject = getCurrentUrl();
        Log.i("MicroMsg.LuggageGetA8Key", "setOuterUrlForIframe(%s)", new Object[] { localObject });
        paramBundle.WOX = ((String)localObject);
        paramBundle = paramWebResourceRequest.getUrl().toString();
        kotlin.g.b.s.s(paramBundle, "request.url.toString()");
        m(paramBundle, false, 5);
        if (this.Wwf.WxG) {
          com.tencent.mm.plugin.webview.modeltools.h.bkP(paramWebResourceRequest.getUrl().toString());
        }
      }
    }
    label530:
    return null;
  }
  
  public final void b(h paramh)
  {
    kotlin.g.b.s.u(paramh, "listener");
    if (this.WwN.contains(paramh)) {
      this.WwN.remove(paramh);
    }
  }
  
  public final void b(l paraml)
  {
    try
    {
      kotlin.g.b.s.u(paraml, "listener");
      if (this.WwO.contains(paraml)) {
        this.WwO.remove(paraml);
      }
      return;
    }
    finally
    {
      paraml = finally;
      throw paraml;
    }
  }
  
  public final void b(m paramm)
  {
    kotlin.g.b.s.u(paramm, "interceptor");
    this.WmV.remove(paramm);
    h localh = paramm.isN();
    if (localh != null) {
      b(localh);
    }
    paramm = paramm.cxU();
    if (paramm != null) {
      b(paramm);
    }
  }
  
  public void b(com.tencent.mm.plugin.webview.stub.e parame) {}
  
  public void b(WebView paramWebView, String paramString)
  {
    if (irU())
    {
      Log.w(irB(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = YM(str);
      Log.i(irB(), "WebView-Trace onPageFinished: " + paramString + ", callbackUrl:" + str);
      super.b(paramWebView, paramString);
      if ((!this.Wxm.contains(Integer.valueOf(this.Wxd))) && (!dhh()))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1200L, 104L, 1L, false);
        Log.i(irB(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
      }
      dI(this.Wxe, biY(paramString));
      Iterator localIterator = ((Iterable)this.WwN).iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (isStarted()) {
          localh.b(paramWebView, str);
        }
      }
    }
    n(paramWebView, paramString);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    kotlin.g.b.s.u(paramWebView, "view");
    kotlin.g.b.s.u(paramString, "url");
    if (irU())
    {
      Log.w(irB(), "ActivityFinished");
      return;
    }
    Object localObject = this.sMP.getActivityContextIfHas();
    if ((localObject instanceof Activity)) {}
    for (localObject = (Activity)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getIntent();
        kotlin.g.b.s.s(localObject, "it.intent");
        setIntent((Intent)localObject);
      }
      dI(this.Wxa, paramString);
      Log.i(irB(), kotlin.g.b.s.X("WebView-Trace onPageStarted: ", paramString));
      this.WwR = false;
      this.Www = paramString;
      bjb(paramString);
      localObject = ((Iterable)this.WwN).iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        if (isStarted()) {
          localh.h(paramWebView, YM(paramString));
        }
      }
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    kotlin.g.b.s.u(paramWebView, "view");
    kotlin.g.b.s.u(paramString, "url");
    Log.i(irB(), "WebView-Trace doUpdateVisitedHistory, url = " + paramString + ", wvUrl = " + paramWebView.getUrl() + ", isReload = " + paramBoolean);
    if (kotlin.n.n.U(paramString, "data:text/html;charset=utf-8", false))
    {
      Log.i(irB(), kotlin.g.b.s.X("url starts with data:text, url : ", paramString));
      return;
    }
    if ((com.tencent.luggage.l.c.K(paramString, "about:blank")) || (com.tencent.luggage.l.c.K(paramString, "file:///android_asset/")))
    {
      Log.e(irB(), "doUpdateVisitedHistory, url is invalid");
      return;
    }
    if (atn(this.WwW))
    {
      localObject1 = com.tencent.mm.plugin.webview.g.a.vVP;
      kotlin.g.b.s.s(localObject1, "HARDCODE_URL");
      if (com.tencent.luggage.l.c.K(paramString, (String)localObject1))
      {
        Log.i(irB(), "doUpdateVisitedHistory, url is HARDCODE_URL");
        return;
      }
    }
    super.b(paramWebView, paramString, paramBoolean);
    if (irX()) {
      paramString = paramWebView.getUrl();
    }
    kotlin.g.b.s.s(paramString, "url");
    if (!kotlin.g.b.s.p(this.Wwy, paramString))
    {
      localObject1 = (CharSequence)this.Wwz;
      if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
        break label442;
      }
      i = 1;
      if ((i != 0) || (kotlin.g.b.s.p(com.tencent.mm.plugin.webview.l.a.getHost(paramString), com.tencent.mm.plugin.webview.l.a.getHost(this.Wwz))))
      {
        localObject1 = (CharSequence)this.Wwy;
        if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
          break label448;
        }
      }
    }
    Object localObject2;
    label442:
    label448:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (kotlin.g.b.s.p(com.tencent.mm.plugin.webview.l.a.getHost(paramString), com.tencent.mm.plugin.webview.l.a.getHost(this.Wwy)))) {
        break label454;
      }
      Log.w(irB(), "dealSPAUpdate hot not equal, url=" + paramString + ", commitUrl=" + this.Wwz + ", startUrl=" + this.Wwy);
      if ((!this.Wwf.WxE) && (!irI().WOY.has(paramString))) {
        m(paramString, false, irI().dJ(paramString, true));
      }
      this.Www = paramString;
      localObject1 = ((Iterable)this.WwN).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (h)((Iterator)localObject1).next();
        if (isStarted()) {
          ((h)localObject2).b(paramWebView, paramString, paramBoolean);
        }
      }
      i = 0;
      break;
    }
    label454:
    Log.d(irB(), "dealSPAUpdate url=" + paramString + ", startUrl=" + this.Wwy);
    if (this.sLD.has(paramString)) {
      dI(this.Wxf, paramString);
    }
    Object localObject1 = irK();
    if ((((com.tencent.mm.plugin.webview.jsapi.m)localObject1).WEt == null) || (((com.tencent.mm.plugin.webview.jsapi.m)localObject1).WlX == null)) {
      Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
    }
    for (;;)
    {
      this.WwA = paramString;
      localObject1 = this.Wwk;
      localObject2 = this.WwA;
      long l = System.currentTimeMillis();
      String str = this.sMP.getTitle();
      kotlin.g.b.s.s(str, "viewWV.title");
      ((com.tencent.mm.plugin.webview.h.g)localObject1).a(new com.tencent.mm.plugin.webview.h.g.a((String)localObject2, l, str));
      break;
      Log.i("MicroMsg.JsLoader", "SPA-Trace, spaHistoryChanged");
      localObject2 = new HashMap();
      ((com.tencent.mm.plugin.webview.jsapi.m)localObject1).WlX.b("sys:spa:historyChanged", (Map)localObject2, null);
    }
    n(paramWebView, paramString);
  }
  
  protected boolean b(int paramInt, String paramString, cdf paramcdf)
  {
    kotlin.g.b.s.u(paramString, "reqUrl");
    kotlin.g.b.s.u(paramcdf, "resp");
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    while (localIterator.hasNext()) {
      if (((m)localIterator.next()).b(paramInt, paramString, paramcdf)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    kotlin.g.b.s.u(paramWebView, "webview");
    kotlin.g.b.s.u(paramString1, "description");
    kotlin.g.b.s.u(paramString2, "failingUrl");
    Log.e(irB(), "shouldInterceptLoadError, failingUrl = %s, errorCode = %d, desc = %s", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1 });
    Object localObject = bjg(getCurrentUrl());
    g.a locala = g.WxV;
    int i = g.a.g(this.sMP);
    irN().a(paramInt, paramString1, paramString2, (String)localObject, i, irW());
    localObject = ((Iterable)this.WmV).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((m)((Iterator)localObject).next()).a(paramWebView, paramString1, paramString2)) {
        return true;
      }
    }
    return super.b(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public final void bJ(Intent paramIntent)
  {
    kotlin.g.b.s.u(paramIntent, "intent");
    Log.i(irB(), "start");
    this.WwC = true;
    setIntent(paramIntent);
    com.tencent.mm.plugin.webview.e.g localg = this.sLD;
    Object localObject1 = paramIntent.getParcelableExtra("hardcode_jspermission");
    label73:
    String str;
    if ((localObject1 instanceof JsapiPermissionWrapper))
    {
      localObject1 = (JsapiPermissionWrapper)localObject1;
      localObject2 = paramIntent.getParcelableExtra("hardcode_general_ctrl");
      if (!(localObject2 instanceof GeneralControlWrapper)) {
        break label233;
      }
      localObject2 = (GeneralControlWrapper)localObject2;
      localg.a((JsapiPermissionWrapper)localObject1, (GeneralControlWrapper)localObject2);
      localg = this.sLD;
      str = dgY();
      localObject1 = paramIntent.getParcelableExtra("scan_jspermission");
      if (!(localObject1 instanceof JsapiPermissionWrapper)) {
        break label238;
      }
      localObject1 = (JsapiPermissionWrapper)localObject1;
      label112:
      localObject2 = paramIntent.getParcelableExtra("scan_general_ctrl");
      if (!(localObject2 instanceof GeneralControlWrapper)) {
        break label243;
      }
    }
    label233:
    label238:
    label243:
    for (Object localObject2 = (GeneralControlWrapper)localObject2;; localObject2 = null)
    {
      localg.a(str, (JsapiPermissionWrapper)localObject1, (GeneralControlWrapper)localObject2);
      kotlinx.coroutines.j.a((aq)bu.ajwo, null, null, (kotlin.g.a.m)new ah(this, null), 3);
      this.Wwj.WQO = System.currentTimeMillis();
      localObject1 = this.Wwj;
      localObject2 = dgY();
      kotlin.g.b.s.u(localObject2, "<set-?>");
      ((com.tencent.mm.plugin.webview.h.f)localObject1).ytX = ((String)localObject2);
      this.Wwj.WQN = paramIntent.getLongExtra("startTime", 0L);
      paramIntent = com.tencent.mm.plugin.webview.k.s.XtJ;
      com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQC, this.Wwj);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label73;
      localObject1 = null;
      break label112;
    }
  }
  
  public final String bLY()
  {
    com.tencent.mm.plugin.webview.e.c localc = irI();
    Object localObject = (CharSequence)getCurrentUrl();
    int i;
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label46;
      }
    }
    label46:
    for (localObject = dgY();; localObject = getCurrentUrl())
    {
      return localc.bkG((String)localObject);
      i = 0;
      break;
    }
  }
  
  protected final void biX(String paramString)
  {
    kotlin.g.b.s.u(paramString, "<set-?>");
    this.heA = paramString;
  }
  
  protected final void biZ(String paramString)
  {
    kotlin.g.b.s.u(paramString, "value");
    if (ajK(paramString))
    {
      Log.d(irB(), kotlin.g.b.s.X("WebView-Trace startUrl:", paramString));
      this.Wwy = paramString;
    }
  }
  
  protected final void bja(String paramString)
  {
    kotlin.g.b.s.u(paramString, "value");
    if (ajL(paramString))
    {
      Log.d(irB(), kotlin.g.b.s.X("WebView-Trace commitUrl:", paramString));
      this.Wwz = paramString;
    }
  }
  
  public final boolean bjd(String paramString)
  {
    kotlin.g.b.s.u(paramString, "url");
    if (z.pCj)
    {
      Log.w(irB(), "skipLoadUrlCheck");
      return true;
    }
    if (this.Wwf.WxB)
    {
      Log.i(irB(), "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    if (com.tencent.luggage.l.c.a(paramString, "file://", true))
    {
      Iterator localIterator = ((Iterable)irD()).iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.luggage.l.c.a(paramString, (String)localIterator.next(), true)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  protected final boolean bje(String paramString)
  {
    kotlin.g.b.s.u(paramString, "url");
    if (!bjd(paramString))
    {
      Log.f(irB(), kotlin.g.b.s.X("forceQuitOnUrlForbidden, canLoadUrl fail, url = ", paramString));
      paramString = ((Iterable)this.WwO).iterator();
      while (paramString.hasNext()) {
        ((l)paramString.next()).isI();
      }
      return true;
    }
    return false;
  }
  
  public final void bjf(String paramString)
  {
    kotlin.g.b.s.u(paramString, "url");
    try
    {
      if (irJ().iwU() == true) {
        atq(((ab)com.tencent.mm.kernel.h.ax(ab.class)).a(getContext(), irJ(), paramString));
      }
      return;
    }
    catch (Exception paramString)
    {
      Log.w(irB(), kotlin.g.b.s.X("initFont, ex = ", paramString.getMessage()));
    }
  }
  
  public String bjg(String paramString)
  {
    return "";
  }
  
  public final void bjh(String paramString)
  {
    kotlin.g.b.s.u(paramString, "url");
    Log.i(irB(), kotlin.g.b.s.X("reload for:", paramString));
    this.sMP.loadUrl(paramString);
    this.WwQ = true;
  }
  
  public boolean c(int paramInt, String paramString, cdf paramcdf)
  {
    boolean bool2 = false;
    kotlin.g.b.s.u(paramString, "reqUrl");
    kotlin.g.b.s.u(paramcdf, "response");
    Log.i(irB(), kotlin.g.b.s.X("edw geta8key onSceneEnd, req reason = ", Integer.valueOf(paramInt)));
    this.sMP.setA8keyReason(paramInt);
    Object localObject1 = this.WwI;
    ((Map)localObject1).clear();
    Object localObject2 = paramcdf.aamS;
    kotlin.g.b.s.s(localObject2, "response.HttpHeader");
    int i;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label141;
      }
      localObject2 = com.tencent.mm.plugin.webview.e.c.mi((List)paramcdf.aamS);
      kotlin.g.b.s.s(localObject2, "getHttpHeaders(response.HttpHeader)");
      ((Map)localObject1).putAll((Map)localObject2);
    }
    boolean bool1;
    label266:
    for (;;)
    {
      if (!b(paramInt, paramString, paramcdf)) {
        break label389;
      }
      bool1 = true;
      return bool1;
      i = 0;
      break;
      label141:
      if (getIntent().getBooleanExtra("k_has_http_header", false))
      {
        Log.i(irB(), "use intent httpheader info");
        localObject2 = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
        String[] arrayOfString = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
        getIntent().putExtra("k_has_http_header", false);
        getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        if ((localObject2 != null) && (arrayOfString != null))
        {
          if (localObject2.length == 0)
          {
            i = 1;
            label244:
            if (i != 0) {
              break label371;
            }
            i = 1;
            label252:
            if (i == 0) {
              break label375;
            }
            if (arrayOfString.length != 0) {
              break label377;
            }
            i = 1;
            if (i != 0) {
              break label383;
            }
          }
          label371:
          label375:
          label377:
          label383:
          for (i = 1;; i = 0)
          {
            if ((i == 0) || (localObject2.length != arrayOfString.length)) {
              break label387;
            }
            int k = localObject2.length - 1;
            if (k < 0) {
              break;
            }
            int j;
            for (i = 0;; i = j)
            {
              j = i + 1;
              Object localObject3 = localObject2[i];
              kotlin.g.b.s.s(localObject3, "httpHeaderKey[i]");
              String str = arrayOfString[i];
              kotlin.g.b.s.s(str, "httpHeaderValue[i]");
              ((Map)localObject1).put(localObject3, str);
              if (j > k) {
                break;
              }
            }
            i = 0;
            break label244;
            i = 0;
            break label252;
            break;
            i = 0;
            break label266;
          }
        }
      }
    }
    label387:
    label389:
    localObject1 = ((Iterable)this.WwO).iterator();
    for (;;)
    {
      bool1 = bool2;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      ((l)((Iterator)localObject1).next()).b(paramString, paramcdf);
    }
  }
  
  public final void ca(int paramInt, String paramString)
  {
    kotlin.g.b.s.u(paramString, "reqUrl");
    this.WwL.cf("getA8KeyEnd", System.currentTimeMillis());
    Iterator localIterator = ((Iterable)this.WwO).iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).bjt(paramString);
    }
  }
  
  public final void cb(int paramInt, String paramString)
  {
    kotlin.g.b.s.u(paramString, "reqUrl");
    this.WwL.cf("getA8KeyStart", System.currentTimeMillis());
    if (paramInt != 5) {
      dI(this.Wxb, paramString);
    }
    if (!kotlin.g.b.s.p(this.WwA, paramString)) {
      com.tencent.threadpool.h.ahAA.bk(new BaseWebViewController..ExternalSyntheticLambda3(this, paramInt, paramString));
    }
  }
  
  protected void cxS()
  {
    if (com.tencent.mm.plugin.expansions.e.aQh())
    {
      a((m)new com.tencent.mm.plugin.webview.f.a());
      a((m)new com.tencent.mm.plugin.webview.l.d());
    }
    this.sMP.setWebViewClient((ag)this);
    Object localObject3 = this.sMP;
    ad localad = ((MMWebView)localObject3).getSettings();
    localad.setJavaScriptEnabled(((Boolean)this.Wwf.WxA.WxK.getValue()).booleanValue());
    localad.setPluginsEnabled(((Boolean)this.Wwf.WxA.WxI.getValue()).booleanValue());
    localad.kfS();
    localad.setBuiltInZoomControls(((Boolean)this.Wwf.WxA.WxJ.getValue()).booleanValue());
    localad.setUseWideViewPort(true);
    localad.setLoadWithOverviewMode(true);
    localad.kfN();
    localad.kfM();
    localad.setGeolocationEnabled(true);
    localad.setJavaScriptCanOpenWindowsAutomatically(true);
    localad.kfU();
    localad.kfQ();
    localad.setAppCachePath(((MMWebView)localObject3).getContext().getDir("webviewcache", 0).getAbsolutePath());
    localad.kfP();
    localad.kfR();
    localad.setDatabasePath(kotlin.g.b.s.X(com.tencent.mm.loader.i.b.bmq(), "databases/"));
    String str = localad.getUserAgentString();
    kotlin.g.b.s.s(str, "currentUa");
    Object localObject2;
    if (!kotlin.n.n.a((CharSequence)str, (CharSequence)" MicroMessenger/", false))
    {
      localObject2 = (r.a)com.tencent.luggage.a.e.T(r.a.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (r.a)new com.tencent.mm.plugin.appbrand.luggage.b.e(((MMWebView)localObject3).getContext());
      }
      localObject2 = com.tencent.mm.plugin.webview.k.j.Xta;
      kotlin.g.b.s.u(str, "prefix");
      j.a.atj().putString("key_web_prefetch_ua", str);
      localad.setUserAgentString(com.tencent.mm.plugin.appbrand.af.r.a(((MMWebView)localObject3).getContext(), str, (r.a)localObject1));
    }
    if (!((Boolean)this.Wwf.WxA.WxL.getValue()).booleanValue())
    {
      ((MMWebView)localObject3).setVerticalScrollBarEnabled(false);
      ((MMWebView)localObject3).setHorizontalScrollBarEnabled(false);
    }
    ao.kfp();
    ao.g((WebView)localObject3);
    Object localObject1 = ((MMWebView)localObject3).getContext().getSystemService("window");
    if (localObject1 == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
    localObject1 = (WindowManager)localObject1;
    try
    {
      localObject3 = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      ((Field)localObject3).setAccessible(true);
      localObject2 = ((Field)localObject3).get(null);
      if (localObject2 != null)
      {
        localObject3 = ((Field)localObject3).getType().getDeclaredField("mWindowManager");
        ((Field)localObject3).setAccessible(true);
        ((Field)localObject3).set(localObject2, localObject1);
      }
    }
    catch (Exception localException)
    {
      label469:
      break label469;
    }
    if (this.sMP.rsE)
    {
      localObject2 = this.sMP.getUrl();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      bja((String)localObject1);
    }
    this.WwL.cf("onTryBindServiceStart", System.currentTimeMillis());
    Log.i(irB(), "WebView-Trace tryBindService");
    localObject1 = o.WzA;
    o.a(true, irC(), (f)new b(new WeakReference(this)));
    this.WwL.cf("onTryBindServiceEnd", System.currentTimeMillis());
  }
  
  protected void cxT()
  {
    if (!this.Wxt)
    {
      irZ();
      this.Wxt = true;
    }
    Iterator localIterator = ((Iterable)this.WwO).iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).cxT();
    }
  }
  
  protected void cxX() {}
  
  public final void dI(int paramInt, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        kotlin.g.b.s.u(paramString, "url");
        if (!irU())
        {
          if (kotlin.n.n.bp((CharSequence)paramString))
          {
            i = 1;
            break label80;
          }
        }
        else
        {
          Log.w(irB(), kotlin.g.b.s.X("checkStatus return url=", paramString));
          return;
        }
        i = 0;
      }
      finally {}
      com.tencent.threadpool.h.ahAA.bk(new BaseWebViewController..ExternalSyntheticLambda1(paramInt, this, paramString));
      continue;
      label80:
      if (i == 0) {}
    }
  }
  
  public final void destroy()
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new w(this));
  }
  
  public String dgY()
  {
    try
    {
      String str = c.bK(getIntent());
      return str;
    }
    catch (Exception localException)
    {
      Log.e(irB(), String.valueOf(localException.getMessage()));
      onFinish();
    }
    return "";
  }
  
  protected boolean dgZ()
  {
    return this.Wxj;
  }
  
  protected boolean dha()
  {
    return false;
  }
  
  protected boolean dhb()
  {
    return false;
  }
  
  protected List<f> dhc()
  {
    return this.vWE;
  }
  
  protected void dhd() {}
  
  protected boolean dhe()
  {
    return true;
  }
  
  public boolean dhh()
  {
    return (atn(this.WwW)) && (kotlin.g.b.s.p(this.heA, this.Wwz));
  }
  
  public void e(WebView paramWebView, String paramString)
  {
    if (irU())
    {
      Log.w(irB(), "ActivityFinished");
      return;
    }
    Object localObject1 = getJsapi();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).ioZ();
    }
    Object localObject2;
    if (paramString == null)
    {
      localObject1 = "";
      localObject1 = YM((String)localObject1);
      Log.i(irB(), "WebView-Trace onPageCommitVisible: " + paramString + ", callbackUrl:" + (String)localObject1);
      bja((String)localObject1);
      super.e(paramWebView, paramString);
      localObject2 = i.Wya;
      if (i.a.iso()) {
        break label273;
      }
      if (!dH(this.Wxd, biY(paramString))) {
        break label254;
      }
      bji(paramString);
      label130:
      dI(this.Wxd, biY(paramString));
    }
    for (;;)
    {
      Object localObject3;
      if (paramWebView != null)
      {
        localObject2 = this.Wwk;
        localObject3 = this.Wwz;
        long l = System.currentTimeMillis();
        String str = paramWebView.getTitle();
        kotlin.g.b.s.s(str, "view.title");
        ((com.tencent.mm.plugin.webview.h.g)localObject2).a(new com.tencent.mm.plugin.webview.h.g.a((String)localObject3, l, str));
      }
      localObject2 = ((Iterable)this.WwN).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h)((Iterator)localObject2).next();
        if (isStarted()) {
          ((h)localObject3).e(paramWebView, (String)localObject1);
        }
      }
      localObject1 = paramString;
      break;
      label254:
      localObject2 = getJsapi();
      if (localObject2 == null) {
        break label130;
      }
      ((com.tencent.mm.plugin.webview.jsapi.j)localObject2).ity();
      break label130;
      label273:
      Log.i(irB(), "WebView Page Commit Mock Enabled");
    }
    n(paramWebView, paramString);
  }
  
  public final boolean e(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    int i = 0;
    if ((paramWebResourceRequest == null) || (paramWebView == null)) {
      return false;
    }
    kotlin.g.b.s.u(paramWebView, "webView");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    kotlin.g.b.s.u(paramWebView, "webView");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    m.a locala;
    while (localIterator.hasNext())
    {
      locala = ((m)localIterator.next()).c(paramWebView, paramWebResourceRequest);
      if (locala.Wzz) {
        if (!locala.Wzz) {
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
      locala = new m.a(false, false);
      break;
    }
    label142:
    return true;
  }
  
  public final Context getContext()
  {
    Context localContext = this.sMP.getActivityContextIfHas();
    kotlin.g.b.s.s(localContext, "viewWV.activityContextIfHas");
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    if (kotlin.n.n.bp((CharSequence)this.WwA)) {
      return this.Wwz;
    }
    return this.WwA;
  }
  
  public final MMHandler getHandler()
  {
    return (MMHandler)this.rdm.getValue();
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = this.intent;
    if (localIntent != null) {
      return localIntent;
    }
    kotlin.g.b.s.bIx("intent");
    return null;
  }
  
  public final com.tencent.mm.plugin.webview.jsapi.j getJsapi()
  {
    return (com.tencent.mm.plugin.webview.jsapi.j)this.WwG.getValue();
  }
  
  protected final int getScreenOrientation()
  {
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.getScreenOrientation() != -1) {
        return localm.getScreenOrientation();
      }
    }
    return -1;
  }
  
  public final void init()
  {
    irP();
    atm(this.WwT);
    MMWebView localMMWebView = this.sMP;
    com.tencent.mm.ui.widget.m localm = (com.tencent.mm.ui.widget.m)new e();
    localMMWebView.afUw.add(localm);
    getJsapi().GXZ = this;
  }
  
  protected abstract Class<? extends Service> irC();
  
  protected abstract Set<String> irD();
  
  public final String irF()
  {
    return this.Wwo;
  }
  
  public final void irG()
  {
    this.Wwq += 1;
    this.Wwr = System.currentTimeMillis();
  }
  
  public final boolean irH()
  {
    return this.Wwu;
  }
  
  public final com.tencent.mm.plugin.webview.e.c irI()
  {
    return (com.tencent.mm.plugin.webview.e.c)this.Wwx.getValue();
  }
  
  public final com.tencent.mm.plugin.webview.stub.e irJ()
  {
    com.tencent.mm.plugin.webview.stub.e locale = this.sLC;
    if (locale != null) {
      return locale;
    }
    kotlin.g.b.s.bIx("invoker");
    return null;
  }
  
  public final com.tencent.mm.plugin.webview.jsapi.m irK()
  {
    return (com.tencent.mm.plugin.webview.jsapi.m)this.WwF.getValue();
  }
  
  public final int irL()
  {
    return ((Number)this.WwH.getValue()).intValue();
  }
  
  public final Runnable irM()
  {
    return (Runnable)this.WwJ.getValue();
  }
  
  public final String irO()
  {
    return (String)this.WwS.getValue();
  }
  
  protected final boolean irQ()
  {
    try
    {
      boolean bool = this.Wxo.contains(ai.cz(Inject.class).klt());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void irR() {}
  
  public boolean irS()
  {
    return false;
  }
  
  public void irT()
  {
    this.WwE = false;
  }
  
  public final boolean irU()
  {
    return (this.WwE) || (this.WwD);
  }
  
  public final void irV()
  {
    m(dgY(), true, 8);
  }
  
  public final boolean irX()
  {
    return ((Boolean)this.Wxu.getValue()).booleanValue();
  }
  
  public final boolean irY()
  {
    try
    {
      ato(this.WwX);
      boolean bool = ato(this.WwW);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void irZ() {}
  
  protected final boolean isStarted()
  {
    try
    {
      boolean bool = this.Wxp.contains(ai.cz(Start.class).klt());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void isa() {}
  
  public final boolean isb()
  {
    return this.Wxm.contains(Integer.valueOf(this.Wxe));
  }
  
  public final void isc()
  {
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    while ((localIterator.hasNext()) && (!((m)localIterator.next()).isJ())) {}
  }
  
  protected final m.a l(WebView paramWebView, String paramString)
  {
    kotlin.g.b.s.u(paramWebView, "webView");
    kotlin.g.b.s.u(paramString, "url");
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    while (localIterator.hasNext())
    {
      m.a locala = ((m)localIterator.next()).j(paramWebView, paramString);
      if (locala.Wzz) {
        return locala;
      }
    }
    return new m.a(false, false);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    kotlin.g.b.s.u(paramString, "url");
    Log.i(irB(), kotlin.g.b.s.X("WebView-Trace loadUrl url ", paramString));
    if (paramBoolean)
    {
      this.sMP.loadUrl(paramString, (Map)kotlin.a.ak.g(new kotlin.r[] { v.Y("Pragma", "no-cache"), v.Y("Cache-Control", "no-cache") }));
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    if (i != 0)
    {
      this.sMP.loadUrl(paramString);
      return;
    }
    this.sMP.loadUrl(paramString, paramMap);
  }
  
  public final com.tencent.mm.plugin.webview.e.c.a m(String paramString, boolean paramBoolean, int paramInt)
  {
    kotlin.g.b.s.u(paramString, "url");
    if (this.Wwf.WxE)
    {
      Log.w(irB(), kotlin.g.b.s.X("startGetA8Key neverGetA8Key ", paramString));
      return com.tencent.mm.plugin.webview.e.c.a.WPm;
    }
    Object localObject = ((Iterable)this.WmV).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((m)((Iterator)localObject).next()).f(paramString, paramBoolean, paramInt)) {
        return com.tencent.mm.plugin.webview.e.c.a.WPl;
      }
    }
    if (this.Wwq > 0)
    {
      localObject = irI();
      cdi localcdi = new cdi();
      localcdi.aanH = this.Wwq;
      localcdi.aanI = ((int)(System.currentTimeMillis() - this.Wwr));
      Log.i(irB(), "GetA8KeySecurityInfo KeyBackCounts=" + localcdi.aanH + ", KeyBackTimes=" + localcdi.aanI);
      ah localah = ah.aiuX;
      ((com.tencent.mm.plugin.webview.e.c)localObject).WPb = localcdi;
    }
    paramString = irI().a(paramString, paramBoolean, paramInt, (com.tencent.mm.plugin.webview.e.a)irE());
    kotlin.g.b.s.s(paramString, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
    return paramString;
  }
  
  protected boolean m(WebView paramWebView, String paramString)
  {
    kotlin.g.b.s.u(paramWebView, "webView");
    kotlin.g.b.s.u(paramString, "url");
    paramWebView = l(paramWebView, paramString);
    if (paramWebView.Wzz) {
      return paramWebView.result;
    }
    return false;
  }
  
  public void onDestroy()
  {
    this.WwD = true;
    if (!this.WwE) {
      Ir(false);
    }
    Object localObject1 = this.Wxr;
    if (localObject1 != null) {
      localObject1 = (Closeable)localObject1;
    }
    try
    {
      Log.i(irB(), "unbindService");
      ah localah = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      getHandler().removeCallbacksAndMessages(irM());
      getJsapi().detach();
      irK().detach();
      irI().WwD = true;
      return;
    }
    finally
    {
      try
      {
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, localThrowable);
      }
    }
  }
  
  protected final void onFinish()
  {
    Log.i(irB(), kotlin.g.b.s.X("onFinish ", Util.getStack()));
    Iterator localIterator = ((Iterable)this.WwO).iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).onFinish();
    }
  }
  
  public final void reload()
  {
    if ((this.sMP == null) || (Util.isNullOrNil(this.sMP.getUrl()))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      String str = this.sMP.getUrl();
      kotlin.g.b.s.s(str, "viewWV.url");
      if (localm.ajR(YM(str))) {
        return;
      }
    }
    Log.i(irB(), "reload");
    this.sMP.reload();
  }
  
  protected final void setIntent(Intent paramIntent)
  {
    kotlin.g.b.s.u(paramIntent, "<set-?>");
    this.intent = paramIntent;
  }
  
  public final void v(final String paramString, final kotlin.g.a.b<? super String, ah> paramb)
  {
    kotlin.g.b.s.u(paramString, "script");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new x(this, paramString, paramb));
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class Auth
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(294991);
      kotlin.g.b.s.u(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ai.cz(BaseWebViewController.Inject.class), paramString)) && (waitFor(localBaseWebViewController.WwU)) && ((localBaseWebViewController.Wwf.WxE) || (localBaseWebViewController.sLD.has(paramString)) || (waitFor(localBaseWebViewController.WwY, paramString))))
      {
        AppMethodBeat.o(294991);
        return true;
      }
      AppMethodBeat.o(294991);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class Bind
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(295118);
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(localBaseWebViewController.WwV)) && (waitFor(localBaseWebViewController.WwU)))
      {
        AppMethodBeat.o(295118);
        return true;
      }
      AppMethodBeat.o(295118);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class ControllerAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class Init
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(295053);
      boolean bool = waitFor(getController().WwT);
      AppMethodBeat.o(295053);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class Inject
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(294946);
      kotlin.g.b.s.u(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((!localBaseWebViewController.sMP.rsE) && (!waitFor(localBaseWebViewController.Wxd, paramString)) && (!waitFor(ai.cz(BaseWebViewController.PageLoadEndForCommitNotSupport.class), paramString))) || (((waitFor(localBaseWebViewController.WwU)) && ((localBaseWebViewController.Wwf.WxE) || (localBaseWebViewController.sLD.has(paramString)) || (waitFor(localBaseWebViewController.WwY, paramString)))) || (localBaseWebViewController.dha())))
      {
        AppMethodBeat.o(294946);
        return true;
      }
      AppMethodBeat.o(294946);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static abstract class PageAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify(String paramString);
    
    public final boolean waitFor(int paramInt, String paramString)
    {
      kotlin.g.b.s.u(paramString, "url");
      return ((kotlin.g.b.s.p(paramString, getController().Wwy)) || (getController().Wxi.contains(Integer.valueOf(paramInt)))) && (BaseWebViewController.c(getController()).contains(Integer.valueOf(paramInt)));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageLoadEndForCommitNotSupport;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class PageLoadEndForCommitNotSupport
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(295086);
      kotlin.g.b.s.u(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ai.cz(BaseWebViewController.Start.class))) && (waitFor(localBaseWebViewController.Wxe, paramString)) && (waitFor(localBaseWebViewController.Wxg, paramString)))
      {
        AppMethodBeat.o(295086);
        return true;
      }
      AppMethodBeat.o(295086);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarEnd;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class ProgressBarEnd
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(295082);
      kotlin.g.b.s.u(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((localBaseWebViewController.dgZ()) && ((localBaseWebViewController.dhb()) || (waitFor(ai.cz(BaseWebViewController.Ready.class), paramString)) || (waitFor(localBaseWebViewController.Wxe, paramString)) || (waitFor(localBaseWebViewController.Wxd, paramString)) || (waitFor(localBaseWebViewController.WwZ, paramString))))
      {
        AppMethodBeat.o(295082);
        return true;
      }
      AppMethodBeat.o(295082);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarStart;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class ProgressBarStart
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(295130);
      kotlin.g.b.s.u(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ai.cz(BaseWebViewController.Start.class))) && (((!localBaseWebViewController.atn(localBaseWebViewController.WwX)) && ((waitFor(localBaseWebViewController.Wxb, paramString)) || (waitFor(localBaseWebViewController.Wxa, paramString)))) || ((!waitFor(ai.cz(BaseWebViewController.ProgressBarEnd.class), paramString)) && (localBaseWebViewController.atn(localBaseWebViewController.WwX)) && (waitFor(localBaseWebViewController.Wxc, paramString)))))
      {
        AppMethodBeat.o(295130);
        return true;
      }
      AppMethodBeat.o(295130);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class Ready
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(295070);
      kotlin.g.b.s.u(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((waitFor(ai.cz(BaseWebViewController.Start.class))) && (waitFor(ai.cz(BaseWebViewController.Auth.class), paramString)) && ((waitFor(localBaseWebViewController.Wxe, paramString)) || (localBaseWebViewController.sMP.rsE))) || (localBaseWebViewController.dhb()))
      {
        AppMethodBeat.o(295070);
        return true;
      }
      AppMethodBeat.o(295070);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      AppMethodBeat.i(294953);
      kotlin.g.b.s.u(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(ai.cz(BaseWebViewController.Ready.class), paramString)) && (waitFor(localBaseWebViewController.Wxf, paramString)))
      {
        AppMethodBeat.o(294953);
        return true;
      }
      AppMethodBeat.o(294953);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  protected static final class Start
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(294943);
      Object localObject = getController();
      if ((waitFor(((BaseWebViewController)localObject).WwV)) && ((!((BaseWebViewController)localObject).dhe()) || (waitFor(((BaseWebViewController)localObject).WwU))))
      {
        if (((CharSequence)((BaseWebViewController)localObject).dgY()).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            localObject = (CharSequence)((BaseWebViewController)localObject).irO();
            if ((localObject != null) && (!kotlin.n.n.bp((CharSequence)localObject))) {
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
          AppMethodBeat.o(294943);
          return true;
          i = 0;
          break;
        }
      }
      label102:
      AppMethodBeat.o(294943);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class WebAction
  {
    public BaseWebViewController controller;
    private final boolean keep;
    
    public final BaseWebViewController getController()
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController != null) {
        return localBaseWebViewController;
      }
      kotlin.g.b.s.bIx("controller");
      return null;
    }
    
    public boolean getKeep()
    {
      return this.keep;
    }
    
    public final void setController(BaseWebViewController paramBaseWebViewController)
    {
      kotlin.g.b.s.u(paramBaseWebViewController, "<set-?>");
      this.controller = paramBaseWebViewController;
    }
    
    public final boolean waitFor(int paramInt)
    {
      return BaseWebViewController.d(getController()).contains(Integer.valueOf(paramInt));
    }
    
    public final boolean waitFor(kotlin.l.c<? extends BaseWebViewController.ControllerAction> paramc)
    {
      kotlin.g.b.s.u(paramc, "clazz");
      return BaseWebViewController.e(getController()).contains(paramc.klt());
    }
    
    public final boolean waitFor(kotlin.l.c<? extends BaseWebViewController.PageAction> paramc, String paramString)
    {
      kotlin.g.b.s.u(paramc, "clazz");
      kotlin.g.b.s.u(paramString, "url");
      return (kotlin.g.b.s.p(paramString, getController().Wwy)) && (BaseWebViewController.f(getController()).contains(paramc.klt()));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<String>
  {
    a(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.jsapi.j>
  {
    aa(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final ab WxP;
    
    static
    {
      AppMethodBeat.i(295020);
      WxP = new ab();
      AppMethodBeat.o(295020);
    }
    
    ab()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final ac WxQ;
    
    static
    {
      AppMethodBeat.i(295004);
      WxQ = new ac();
      AppMethodBeat.o(295004);
    }
    
    ac()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends u
    implements kotlin.g.a.a<g>
  {
    ad(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
    
    /* Error */
    private g isd()
    {
      // Byte code:
      //   0: ldc 37
      //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: ldc2_w 43
      //   8: lstore_2
      //   9: aload_0
      //   10: getfield 30	com/tencent/mm/plugin/webview/core/BaseWebViewController$ad:Wxy	Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;
      //   13: invokevirtual 48	com/tencent/mm/plugin/webview/core/BaseWebViewController:irJ	()Lcom/tencent/mm/plugin/webview/stub/e;
      //   16: invokeinterface 54 1 0
      //   21: ifeq +37 -> 58
      //   24: aload_0
      //   25: getfield 30	com/tencent/mm/plugin/webview/core/BaseWebViewController$ad:Wxy	Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;
      //   28: invokevirtual 48	com/tencent/mm/plugin/webview/core/BaseWebViewController:irJ	()Lcom/tencent/mm/plugin/webview/stub/e;
      //   31: invokeinterface 58 1 0
      //   36: istore_1
      //   37: iload_1
      //   38: i2l
      //   39: lstore_2
      //   40: new 60	com/tencent/mm/plugin/webview/core/g
      //   43: dup
      //   44: lload_2
      //   45: invokespecial 63	com/tencent/mm/plugin/webview/core/g:<init>	(J)V
      //   48: astore 4
      //   50: ldc 37
      //   52: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   55: aload 4
      //   57: areturn
      //   58: lconst_0
      //   59: lstore_2
      //   60: goto -20 -> 40
      //   63: astore 4
      //   65: aload_0
      //   66: getfield 30	com/tencent/mm/plugin/webview/core/BaseWebViewController$ad:Wxy	Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;
      //   69: invokestatic 70	com/tencent/mm/plugin/webview/core/BaseWebViewController:b	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)Ljava/lang/String;
      //   72: ldc 72
      //   74: aload 4
      //   76: invokevirtual 78	java/lang/Throwable:getLocalizedMessage	()Ljava/lang/String;
      //   79: invokestatic 84	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   82: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   85: goto -45 -> 40
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	88	0	this	ad
      //   36	2	1	i	int
      //   8	52	2	l	long
      //   48	8	4	localg	g
      //   63	12	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   9	37	63	finally
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ae
    extends u
    implements kotlin.g.a.a<String>
  {
    ae(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/Runnable;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class af
    extends u
    implements kotlin.g.a.a<Runnable>
  {
    af(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
    
    private static final void j(BaseWebViewController paramBaseWebViewController)
    {
      AppMethodBeat.i(295015);
      kotlin.g.b.s.u(paramBaseWebViewController, "this$0");
      int i = paramBaseWebViewController.Wxc;
      String str2 = paramBaseWebViewController.getCurrentUrl();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      paramBaseWebViewController.dI(i, str1);
      AppMethodBeat.o(295015);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ag
    extends n
  {
    ag(BaseWebViewController paramBaseWebViewController) {}
    
    public final void xK(long paramLong)
    {
      AppMethodBeat.i(294997);
      this.Wxy.getHandler().postDelayed(this.Wxy.irM(), paramLong);
      AppMethodBeat.o(294997);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ah
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    ah(BaseWebViewController paramBaseWebViewController, kotlin.d.d<? super ah> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(295025);
      paramObject = (kotlin.d.d)new ah(this.Wxy, paramd);
      AppMethodBeat.o(295025);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(295012);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(295012);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      this.Wxy.atm(this.Wxy.WwV);
      paramObject = ah.aiuX;
      AppMethodBeat.o(295012);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class ai
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final ai WxR;
    
    static
    {
      AppMethodBeat.i(295009);
      WxR = new ai();
      AppMethodBeat.o(295009);
    }
    
    ai()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class aj
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final aj WxS;
    
    static
    {
      AppMethodBeat.i(295002);
      WxS = new aj();
      AppMethodBeat.o(295002);
    }
    
    aj()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class ak
    implements g.b
  {
    ak(BaseWebViewController paramBaseWebViewController) {}
    
    public final String ise()
    {
      AppMethodBeat.i(294990);
      Object localObject = this.Wxy.getCurrentUrl();
      if (localObject != null) {
        if (((CharSequence)localObject).length() > 0)
        {
          i = 1;
          if (i != 1) {
            break label62;
          }
        }
      }
      label62:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label67;
        }
        localObject = this.Wxy.getCurrentUrl();
        AppMethodBeat.o(294990);
        return localObject;
        i = 0;
        break;
      }
      label67:
      localObject = this.Wxy.sMP.getUrl();
      if (localObject == null)
      {
        localObject = BaseWebViewController.Wwe;
        localObject = BaseWebViewController.c.bK(this.Wxy.getIntent());
        AppMethodBeat.o(294990);
        return localObject;
      }
      AppMethodBeat.o(294990);
      return localObject;
    }
    
    public final String isf()
    {
      return this.Wxy.Wwz;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$BaseWebViewUIConnectionBinder;", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "weakController", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "(Ljava/lang/ref/WeakReference;)V", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    private final WeakReference<BaseWebViewController> Wxz;
    
    public b(WeakReference<BaseWebViewController> paramWeakReference)
    {
      AppMethodBeat.i(294920);
      this.Wxz = paramWeakReference;
      AppMethodBeat.o(294920);
    }
    
    public final void a(e parame)
    {
      AppMethodBeat.i(294933);
      kotlin.g.b.s.u(parame, "conn");
      BaseWebViewController localBaseWebViewController = (BaseWebViewController)this.Wxz.get();
      if (localBaseWebViewController == null)
      {
        AppMethodBeat.o(294933);
        return;
      }
      if (localBaseWebViewController.irU())
      {
        Log.i(BaseWebViewController.b(localBaseWebViewController), "WebView-Trace onConnected when destroyCalled");
        AppMethodBeat.o(294933);
        return;
      }
      com.tencent.mm.plugin.webview.k.s locals = com.tencent.mm.plugin.webview.k.s.XtJ;
      com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQH, localBaseWebViewController.Wwj);
      localBaseWebViewController.Wxr = parame;
      parame = parame.irJ();
      kotlin.g.b.s.u(parame, "<set-?>");
      localBaseWebViewController.sLC = parame;
      localBaseWebViewController.getJsapi().sLC = localBaseWebViewController.irJ();
      localBaseWebViewController.b(localBaseWebViewController.irJ());
      Log.i(BaseWebViewController.b(localBaseWebViewController), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
      if (BaseWebViewController.e(localBaseWebViewController).contains(ai.cz(BaseWebViewController.Bind.class).klt()))
      {
        localBaseWebViewController.cxX();
        AppMethodBeat.o(294933);
        return;
      }
      localBaseWebViewController.atm(localBaseWebViewController.WwU);
      AppMethodBeat.o(294933);
    }
    
    public final boolean fTZ()
    {
      AppMethodBeat.i(294939);
      BaseWebViewController localBaseWebViewController = (BaseWebViewController)this.Wxz.get();
      if ((localBaseWebViewController != null) && (localBaseWebViewController.irS() == true))
      {
        AppMethodBeat.o(294939);
        return true;
      }
      AppMethodBeat.o(294939);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "FONT1", "", "FONT2", "FONT3", "FONT4", "FONT5", "FONT6", "FONT7", "FONT8", "QuickAppUrl", "", "[Ljava/lang/String;", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static String bK(Intent paramIntent)
    {
      AppMethodBeat.i(294932);
      kotlin.g.b.s.u(paramIntent, "intent");
      try
      {
        localObject3 = paramIntent.getStringExtra("rawUrl");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject3;
          Object localObject1;
          Log.e("MicroMsg.WebViewController", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
          if ((localException instanceof ClassNotFoundException))
          {
            AppMethodBeat.o(294932);
            throw localException;
          }
          Object localObject2 = null;
          continue;
          int i = 0;
        }
        label99:
        paramIntent = paramIntent.getData();
        if (paramIntent != null) {
          break label116;
        }
        AppMethodBeat.o(294932);
        return "";
        label116:
        paramIntent = paramIntent.toString();
        if (paramIntent != null) {
          break label133;
        }
        AppMethodBeat.o(294932);
        return "";
        label133:
        AppMethodBeat.o(294932);
      }
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 == null) || (kotlin.n.n.bp((CharSequence)localObject3)))
      {
        i = 1;
        if (i != 0) {
          break label99;
        }
        AppMethodBeat.o(294932);
        return localObject1;
      }
      return paramIntent;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "getA8keyScene", "", "snapShotMode", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZIZ)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getGetA8keyScene", "()I", "setGetA8keyScene", "(I)V", "getNeverGetA8Key", "getSnapShotMode", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    final BaseWebViewController.g WxA;
    final boolean WxB;
    final boolean WxC;
    final boolean WxD;
    final boolean WxE;
    public int WxF;
    final boolean WxG;
    
    public d()
    {
      this(null, false, false, false, false, false, 127);
    }
    
    public d(BaseWebViewController.g paramg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
    {
      AppMethodBeat.i(294928);
      this.WxA = paramg;
      this.WxB = paramBoolean1;
      this.WxC = paramBoolean2;
      this.WxD = paramBoolean3;
      this.WxE = paramBoolean4;
      this.WxF = 0;
      this.WxG = paramBoolean5;
      AppMethodBeat.o(294928);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class e
    extends com.tencent.mm.ui.widget.m
  {
    public e()
    {
      AppMethodBeat.i(294923);
      AppMethodBeat.o(294923);
    }
    
    public final void a(WebView paramWebView, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(294937);
      Object localObject;
      BaseWebViewController localBaseWebViewController1;
      BaseWebViewController localBaseWebViewController2;
      if ((paramInt >= 100) && (!this.Wxy.irU()))
      {
        this.Wxy.WwR = true;
        Log.i(BaseWebViewController.b(this.Wxy), "Abe-Debug Progress 100");
        localObject = com.tencent.mm.plugin.webview.k.o.Xtm;
        localObject = this.Wxy.sMP;
        kotlin.g.b.s.u(localObject, "webView");
        if (((MMWebView)localObject).supportFeature(2006)) {
          break label149;
        }
        paramInt = i;
        if (paramInt != 0)
        {
          localObject = i.Wya;
          if (!i.a.iso()) {}
        }
        else
        {
          Log.i(BaseWebViewController.b(this.Wxy), "WebView-Trace not support onPageCommitVisible");
          localBaseWebViewController1 = this.Wxy;
          paramInt = this.Wxy.Wxg;
          localBaseWebViewController2 = this.Wxy;
          if (paramWebView != null) {
            break label312;
          }
          paramWebView = "";
        }
      }
      for (;;)
      {
        localBaseWebViewController1.dI(paramInt, BaseWebViewController.c(localBaseWebViewController2, paramWebView));
        AppMethodBeat.o(294937);
        return;
        label149:
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yNn, 0) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt == 0) || (!((MMWebView)localObject).jES()) || (com.tencent.mm.plugin.webview.k.o.j((MMWebView)localObject) > 86)) {
            break label211;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable SysKernel86");
          paramInt = i;
          break;
        }
        label211:
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yNo, 1) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!((MMWebView)localObject).jES()) || (paramInt == 0)) {
            break label263;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable SysKernel");
          paramInt = i;
          break;
        }
        label263:
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yNp, 0) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label307;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable AllKernel");
          paramInt = i;
          break;
        }
        label307:
        paramInt = 1;
        break;
        label312:
        localObject = paramWebView.getUrl();
        paramWebView = (WebView)localObject;
        if (localObject == null) {
          paramWebView = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", "action", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
  {
    final kotlin.l.c<? extends BaseWebViewController.WebAction> WxH;
    final kotlin.g.a.a<ah> nsP;
    
    public f(kotlin.l.c<? extends BaseWebViewController.WebAction> paramc, kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(294898);
      this.WxH = paramc;
      this.nsP = parama;
      AppMethodBeat.o(294898);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(294934);
      if (this == paramObject)
      {
        AppMethodBeat.o(294934);
        return true;
      }
      if (!(paramObject instanceof f))
      {
        AppMethodBeat.o(294934);
        return false;
      }
      paramObject = (f)paramObject;
      if (!kotlin.g.b.s.p(this.WxH, paramObject.WxH))
      {
        AppMethodBeat.o(294934);
        return false;
      }
      if (!kotlin.g.b.s.p(this.nsP, paramObject.nsP))
      {
        AppMethodBeat.o(294934);
        return false;
      }
      AppMethodBeat.o(294934);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(294921);
      int i = this.WxH.hashCode();
      int j = this.nsP.hashCode();
      AppMethodBeat.o(294921);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(294912);
      String str = "WebEvent(action=" + this.WxH + ", block=" + this.nsP + ')';
      AppMethodBeat.o(294912);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
  {
    final kotlin.j WxI;
    final kotlin.j WxJ;
    final kotlin.j WxK;
    final kotlin.j WxL;
    
    public g(Intent paramIntent)
    {
      AppMethodBeat.i(294895);
      this.WxI = kotlin.k.cm((kotlin.g.a.a)new b(paramIntent));
      this.WxJ = kotlin.k.cm((kotlin.g.a.a)new d(paramIntent));
      this.WxK = kotlin.k.cm((kotlin.g.a.a)new a(paramIntent));
      this.WxL = kotlin.k.cm((kotlin.g.a.a)new c(paramIntent));
      AppMethodBeat.o(294895);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<Boolean>
    {
      a(Intent paramIntent)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<Boolean>
    {
      b(Intent paramIntent)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.a<Boolean>
    {
      c(Intent paramIntent)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<Boolean>
    {
      d(Intent paramIntent)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.e.c>
  {
    public static final h WxM;
    
    static
    {
      AppMethodBeat.i(294902);
      WxM = new h();
      AppMethodBeat.o(294902);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<ah>
  {
    k(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<ah>
  {
    l(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<ah>
  {
    n(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements kotlin.g.a.a<ah>
  {
    o(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements kotlin.g.a.a<ah>
  {
    p(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<ah>
  {
    q(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.a<ah>
  {
    r(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.e.f<cdf>>
  {
    s(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class t
    extends u
    implements kotlin.g.a.a<Integer>
  {
    t(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "callback", "Lkotlin/Function0;", "", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.b<kotlin.g.a.a<? extends ah>, Boolean>
  {
    public static final u WxN;
    
    static
    {
      AppMethodBeat.i(295037);
      WxN = new u();
      AppMethodBeat.o(295037);
    }
    
    u()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.a<String>
  {
    v(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends u
    implements kotlin.g.a.a<ah>
  {
    w(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends u
    implements kotlin.g.a.a<ah>
  {
    x(BaseWebViewController paramBaseWebViewController, String paramString, kotlin.g.a.b<? super String, ah> paramb)
    {
      super();
    }
    
    private static final void b(kotlin.g.a.b paramb, String paramString)
    {
      AppMethodBeat.i(295022);
      kotlin.g.b.s.s(paramString, "it");
      paramb.invoke(paramString);
      AppMethodBeat.o(295022);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    public static final y WxO;
    
    static
    {
      AppMethodBeat.i(295019);
      WxO = new y();
      AppMethodBeat.o(295019);
    }
    
    y()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.jsapi.m>
  {
    z(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController
 * JD-Core Version:    0.7.0.1
 */