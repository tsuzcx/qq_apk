package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
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
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.f.c.a;
import com.tencent.mm.plugin.webview.f.g.b;
import com.tencent.mm.plugin.webview.k.e.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.z;
import java.io.File;
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
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.g.b.q;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.bn;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_PROGRESS_CACHE_LOAD_START", "getCONTROLLER_PROGRESS_CACHE_LOAD_START", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_LOAD_PROGRESS_FULL", "getPAGE_LOAD_PROGRESS_FULL", "PAGE_PROGRESS_NO_FRAME_AUTH_START", "getPAGE_PROGRESS_NO_FRAME_AUTH_START", "PAGE_PROGRESS_SHOW_TIME_OUT", "getPAGE_PROGRESS_SHOW_TIME_OUT", "PAGE_PROGRESS_STATUS", "getPAGE_PROGRESS_STATUS", "()Ljava/util/Set;", "PAGE_PROGRESS_WEBVIEW_START", "getPAGE_PROGRESS_WEBVIEW_START", "PAGE_SPA_STATUS", "getPAGE_SPA_STATUS", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/concurrent/ConcurrentSkipListSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "hasStartCalled", "getHasStartCalled", "setHasStartCalled", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isInject", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader$webview_sdk_release", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "openQuickAppIntercept", "getOpenQuickAppIntercept", "openQuickAppIntercept$delegate", "openQuickAppReport", "getOpenQuickAppReport", "openQuickAppReport$delegate", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageErrorMonitor", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "getPageErrorMonitor", "()Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "pageErrorMonitor$delegate", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "updateRandomStr", "getUpdateRandomStr", "updateRandomStr$delegate", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", "listener", "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canLoadUrl", "url", "canShowRefresh", "checkStatus", "check", "dealSPAUpdate", "destroy", "doAuthCurrentUrl", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", "request", "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCallBackUrl", "getShareUrl", "getStatusListener", "hasStatus", "init", "initEnviroment", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "Lcom/tencent/xweb/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onUrlRedirect", "forceRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeClientListener", "removeControllerListener", "removeInterceptor", "removeInvoker", "floating", "removeStatus", "resetActions", "resetPageActions", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "PageLoadEndForCommitNotSupport", "ProgressBarEnd", "ProgressBarStart", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"})
public abstract class BaseWebViewController
  extends com.tencent.xweb.ac
  implements com.tencent.mm.plugin.webview.f.a<bhj>
{
  private static final String[] IKP = { "https://statres.quickapp.cn/quickapp/js/routerinline.min.js", "http://fastappjump-drcn.hispace.hicloud.com/", "http://thefatherofsalmon.com/", "http://v2.thefatherofsalmon.com/" };
  public static final b IKQ = new b((byte)0);
  public final ConcurrentLinkedDeque<k> ICu;
  private final kotlin.f IJK;
  private final kotlin.f IJL;
  public String IJM;
  private final kotlin.f IJN;
  String IJO;
  public String IJP;
  String IJQ;
  protected boolean IJR;
  private boolean IJS;
  public boolean IJT;
  private final kotlin.f IJU;
  private final kotlin.f IJV;
  private final kotlin.f IJW;
  public final Map<String, String> IJX;
  private final kotlin.f IJY;
  public final l IJZ;
  private final ConcurrentLinkedDeque<o<PageAction, kotlin.g.a.a<x>>> IKA;
  private final ConcurrentSkipListSet<Integer> IKB;
  private final ConcurrentSkipListSet<Integer> IKC;
  private final ConcurrentSkipListSet<String> IKD;
  private final ConcurrentSkipListSet<String> IKE;
  public final boolean IKF;
  c IKG;
  private final kotlin.f IKH;
  private boolean IKI;
  private final kotlin.f IKJ;
  private final kotlin.f IKK;
  private final kotlin.f IKL;
  final c IKM;
  private Set<String> IKN;
  private com.tencent.mm.plugin.webview.d.e IKO;
  public final com.tencent.mm.plugin.webview.k.j IKa;
  private final kotlin.f IKb;
  private final ConcurrentLinkedDeque<f> IKc;
  public final ConcurrentLinkedDeque<j> IKd;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<kotlin.g.a.a<x>>> IKe;
  public boolean IKf;
  boolean IKg;
  private final kotlin.f IKh;
  final int IKi;
  public final int IKj;
  public final int IKk;
  protected final int IKl;
  protected final int IKm;
  final int IKn;
  final int IKo;
  final int IKp;
  final int IKq;
  final int IKr;
  final int IKs;
  final int IKt;
  final int IKu;
  final int IKv;
  final Set<Integer> IKw;
  final Set<Integer> IKx;
  private final boolean IKy;
  private final ConcurrentLinkedDeque<o<ControllerAction, kotlin.g.a.a<x>>> IKz;
  protected String djt;
  protected Intent intent;
  private final kotlin.f lhN;
  public com.tencent.mm.plugin.webview.stub.e mHh;
  public final com.tencent.mm.plugin.webview.f.g mHi;
  private final List<e> pFO;
  public final MMWebView pGj;
  
  public BaseWebViewController(MMWebView paramMMWebView, c paramc, Set<String> paramSet, com.tencent.mm.plugin.webview.d.e parame)
  {
    this.pGj = paramMMWebView;
    this.IKM = paramc;
    this.IKN = paramSet;
    this.IKO = parame;
    this.IJK = kotlin.g.ah((kotlin.g.a.a)new a(this));
    this.IJL = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.IJN = kotlin.g.ah((kotlin.g.a.a)g.ILd);
    this.djt = "";
    this.IJO = "";
    this.IJP = "";
    this.IJQ = "";
    this.IJU = kotlin.g.ah((kotlin.g.a.a)new ab(this));
    this.IJV = kotlin.g.ah((kotlin.g.a.a)new ac(this));
    this.IJW = kotlin.g.ah((kotlin.g.a.a)new s(this));
    this.lhN = kotlin.g.ah((kotlin.g.a.a)y.ILh);
    this.mHi = new com.tencent.mm.plugin.webview.f.g((g.b)new ao(this));
    this.IJX = ((Map)new HashMap());
    this.IJY = kotlin.g.ah((kotlin.g.a.a)new ai(this));
    this.IJZ = ((l)new aj(this));
    this.IKa = new com.tencent.mm.plugin.webview.k.j();
    this.IKb = kotlin.g.ah((kotlin.g.a.a)new ah(this));
    this.ICu = new ConcurrentLinkedDeque();
    this.IKc = new ConcurrentLinkedDeque();
    this.IKd = new ConcurrentLinkedDeque();
    this.IKe = new ConcurrentHashMap();
    this.IKh = kotlin.g.ah((kotlin.g.a.a)new v(this));
    this.IKi = -1;
    this.IKj = -2;
    this.IKk = -3;
    this.IKl = -10;
    this.IKm = -5;
    this.IKn = 1;
    this.IKo = 2;
    this.IKp = 3;
    this.IKq = 4;
    this.IKr = 6;
    this.IKs = 10;
    this.IKt = 11;
    this.IKu = 12;
    this.IKv = 13;
    this.IKw = ak.setOf(new Integer[] { Integer.valueOf(this.IKt), Integer.valueOf(this.IKu), Integer.valueOf(this.IKv) });
    this.IKx = ak.setOf(new Integer[] { Integer.valueOf(this.IKp), Integer.valueOf(this.IKq), Integer.valueOf(this.IKr) });
    this.IKy = true;
    this.pFO = kotlin.a.j.mutableListOf(new e[] { new e(kotlin.g.b.aa.bp(Init.class), (kotlin.g.a.a)new h((BaseWebViewController)this)), new e(kotlin.g.b.aa.bp(Inject.class), (kotlin.g.a.a)new j(this)), new e(kotlin.g.b.aa.bp(Bind.class), (kotlin.g.a.a)new k((BaseWebViewController)this)), new e(kotlin.g.b.aa.bp(Auth.class), (kotlin.g.a.a)new l(this)), new e(kotlin.g.b.aa.bp(Ready.class), (kotlin.g.a.a)new m(this)), new e(kotlin.g.b.aa.bp(Start.class), (kotlin.g.a.a)new n(this)), new e(kotlin.g.b.aa.bp(SPAUpdated.class), (kotlin.g.a.a)new o(this)), new e(kotlin.g.b.aa.bp(ProgressBarStart.class), (kotlin.g.a.a)new p(this)), new e(kotlin.g.b.aa.bp(ProgressBarEnd.class), (kotlin.g.a.a)new q(this)), new e(kotlin.g.b.aa.bp(PageLoadEndForCommitNotSupport.class), (kotlin.g.a.a)new i(this)) });
    this.IKz = new ConcurrentLinkedDeque();
    this.IKA = new ConcurrentLinkedDeque();
    this.IKB = new ConcurrentSkipListSet();
    this.IKC = new ConcurrentSkipListSet();
    this.IKD = new ConcurrentSkipListSet();
    this.IKE = new ConcurrentSkipListSet();
    this.IKF = fZr().gbE();
    this.IKH = kotlin.g.ah((kotlin.g.a.a)am.ILn);
    this.IKJ = kotlin.g.ah((kotlin.g.a.a)an.ILo);
    this.IKK = kotlin.g.ah((kotlin.g.a.a)ag.ILl);
    this.IKL = kotlin.g.ah((kotlin.g.a.a)af.ILk);
  }
  
  private final String Yc(String paramString)
  {
    if (!aix(paramString)) {
      paramString = this.IJP;
    }
    for (;;)
    {
      String str = paramString;
      if (kotlin.n.n.aL((CharSequence)paramString))
      {
        str = paramString;
        if (afI(this.IKk)) {
          str = coX();
        }
      }
      return str;
    }
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
        localWebAction = (WebAction)paramIterable.first;
        paramIterable = (kotlin.g.a.a)paramIterable.second;
        if (!(localWebAction instanceof PageAction)) {
          break label235;
        }
        if ((paramString != null) && (((PageAction)localWebAction).verify(paramString)))
        {
          bool = true;
          if (!bool) {
            continue;
          }
          Log.i(fZo(), "verify WebAction: " + kotlin.g.b.aa.bp(localWebAction.getClass()).getSimpleName() + " start");
          if (!localWebAction.getKeep()) {
            localIterator.remove();
          }
          paramIterable.invoke();
          String str = kotlin.g.b.aa.bp(localWebAction.getClass()).getSimpleName();
          paramIterable = str;
          if (str == null) {
            paramIterable = "";
          }
          paramSet.add(paramIterable);
          Log.v(fZo(), "verifyActions: " + kotlin.g.b.aa.bp(localWebAction.getClass()).getSimpleName() + " end");
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
  
  private final int aXA(String paramString)
  {
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    while (localIterator.hasNext())
    {
      int i = ((k)localIterator.next()).aXA(paramString);
      if (i != -1) {
        return i;
      }
    }
    return fZr().aZH(paramString);
  }
  
  private final String aXw(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!com.tencent.luggage.h.c.a(paramString, "about:blank", true)))
      {
        localObject = paramString;
        if (!com.tencent.luggage.h.c.a(paramString, "data:text/html;charset=utf-8", true)) {}
      }
      else
      {
        localObject = this.djt;
      }
      return localObject;
    }
  }
  
  private final void aXz(String paramString)
  {
    try
    {
      Log.i(fZo(), "resetPageActions clear status:" + paramString + ", [" + kotlin.a.j.a((Iterable)this.IKB, (CharSequence)",", null, null, 0, null, null, 62) + "] actions: [" + kotlin.a.j.a((Iterable)this.IKD, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      this.IKB.clear();
      this.IKD.clear();
      this.IKA.clear();
      this.IKg = false;
      Iterator localIterator = ((Iterable)cpb()).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = kotlin.l.a.c.d(locale.IKY);
        ((WebAction)localObject).setController((BaseWebViewController)this);
        localObject = (WebAction)localObject;
        if ((localObject instanceof PageAction)) {
          this.IKA.add(s.U(localObject, locale.icG));
        }
      }
      aXx(paramString);
    }
    finally {}
    this.IJQ = "";
  }
  
  private boolean afJ(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!kotlin.aa.SXc) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.IKC.remove(Integer.valueOf(paramInt));
    return bool;
  }
  
  public static final String bj(Intent paramIntent)
  {
    return b.bj(paramIntent);
  }
  
  private final e fZw()
  {
    return (e)this.IKb.getValue();
  }
  
  /* Error */
  private final void fZy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 923	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZo	()Ljava/lang/String;
    //   6: ldc_w 1135
    //   9: invokestatic 995	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 847	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKC	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   16: invokevirtual 1059	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   19: aload_0
    //   20: getfield 851	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKE	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   23: invokevirtual 1059	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   26: aload_0
    //   27: getfield 838	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKz	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   30: invokevirtual 1060	java/util/concurrent/ConcurrentLinkedDeque:clear	()V
    //   33: aload_0
    //   34: getfield 845	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKB	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   37: invokevirtual 1059	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   40: aload_0
    //   41: getfield 849	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKD	Ljava/util/concurrent/ConcurrentSkipListSet;
    //   44: invokevirtual 1059	java/util/concurrent/ConcurrentSkipListSet:clear	()V
    //   47: aload_0
    //   48: getfield 840	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKA	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   51: invokevirtual 1060	java/util/concurrent/ConcurrentLinkedDeque:clear	()V
    //   54: aload_0
    //   55: invokevirtual 1065	com/tencent/mm/plugin/webview/core/BaseWebViewController:cpb	()Ljava/util/List;
    //   58: checkcast 939	java/lang/Iterable
    //   61: invokeinterface 943 1 0
    //   66: astore_1
    //   67: aload_1
    //   68: invokeinterface 948 1 0
    //   73: ifeq +91 -> 164
    //   76: aload_1
    //   77: invokeinterface 952 1 0
    //   82: checkcast 89	com/tencent/mm/plugin/webview/core/BaseWebViewController$e
    //   85: astore_2
    //   86: aload_2
    //   87: getfield 1069	com/tencent/mm/plugin/webview/core/BaseWebViewController$e:IKY	Lkotlin/l/b;
    //   90: invokestatic 1074	kotlin/l/a/c:d	(Lkotlin/l/b;)Ljava/lang/Object;
    //   93: astore_3
    //   94: aload_3
    //   95: checkcast 45	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction
    //   98: aload_0
    //   99: checkcast 2	com/tencent/mm/plugin/webview/core/BaseWebViewController
    //   102: invokevirtual 1077	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction:setController	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V
    //   105: aload_3
    //   106: checkcast 45	com/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction
    //   109: astore_3
    //   110: aload_3
    //   111: instanceof 15
    //   114: ifeq +53 -> 167
    //   117: aload_0
    //   118: getfield 838	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKz	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   121: aload_3
    //   122: aload_2
    //   123: getfield 1081	com/tencent/mm/plugin/webview/core/BaseWebViewController$e:icG	Lkotlin/g/a/a;
    //   126: invokestatic 1087	kotlin/s:U	(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/o;
    //   129: invokevirtual 1088	java/util/concurrent/ConcurrentLinkedDeque:add	(Ljava/lang/Object;)Z
    //   132: pop
    //   133: goto -66 -> 67
    //   136: astore_1
    //   137: aload_0
    //   138: invokevirtual 923	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZo	()Ljava/lang/String;
    //   141: new 966	java/lang/StringBuilder
    //   144: dup
    //   145: ldc_w 1137
    //   148: invokespecial 970	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_1
    //   152: invokevirtual 1140	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   155: invokevirtual 984	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 989	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 995	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_0
    //   165: monitorexit
    //   166: return
    //   167: aload_3
    //   168: instanceof 24
    //   171: ifeq -104 -> 67
    //   174: aload_0
    //   175: getfield 840	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKA	Ljava/util/concurrent/ConcurrentLinkedDeque;
    //   178: aload_3
    //   179: aload_2
    //   180: getfield 1081	com/tencent/mm/plugin/webview/core/BaseWebViewController$e:icG	Lkotlin/g/a/a;
    //   183: invokestatic 1087	kotlin/s:U	(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/o;
    //   186: invokevirtual 1088	java/util/concurrent/ConcurrentLinkedDeque:add	(Ljava/lang/Object;)Z
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
    //   85	95	2	locale	e
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
  
  private final void n(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (this.IKf) && (paramWebView.canGoBack()))
    {
      Log.i(fZo(), "clearHistory :".concat(String.valueOf(paramString)));
      paramWebView.clearHistory();
      this.IKf = false;
    }
  }
  
  public final void C(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString1 = this.pGj.getSettings();
      if (paramString1 != null) {
        paramString1.setJavaScriptEnabled(false);
      }
      this.pGj.loadData(paramString2, "text/html", "utf-8");
    }
  }
  
  public final void L(String paramString, Map<String, String> paramMap)
  {
    kotlin.g.b.p.h(paramString, "baseUrl");
    Log.i(fZo(), "WebView-Trace loadCacheUrl baseUrl ".concat(String.valueOf(paramString)));
    this.djt = paramString;
    afH(this.IKm);
    this.pGj.loadUrl(paramString, paramMap);
    aXy(paramString);
    afH(this.IKl);
    com.tencent.f.h.RTc.aV((Runnable)new ad(this));
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    kotlin.g.b.p.h(paramWebView, "webview");
    kotlin.g.b.p.h(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, null);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest);
    }
    return localWebResourceResponse1;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    kotlin.g.b.p.h(paramWebView, "webview");
    kotlin.g.b.p.h(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, paramBundle);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    }
    return localWebResourceResponse1;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    kotlin.g.b.p.h(paramString1, "reqUrl");
    kotlin.g.b.p.h(paramString2, "errMsg");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      cR(this.IKo, paramString1);
      Iterator localIterator = ((Iterable)this.IKd).iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).d(paramInt1, paramString1, paramInt2, paramString2);
      }
      this.IJM = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, bhj parambhj)
  {
    kotlin.g.b.p.h(paramString1, "reqUrl");
    kotlin.g.b.p.h(paramString2, "fullUrl");
    kotlin.g.b.p.h(parambhj, "response");
    Log.d(fZo(), "WebView-Trace onPermissionUpdate:" + paramString1 + ", fullUrl:" + paramString2);
    if (fZD()) {
      Log.d(fZo(), "onPermissionUpdate destroyCalled");
    }
    do
    {
      return;
      this.mHi.a(paramString1, fZr().aZE(paramString1), fZr().aZF(paramString1));
      this.mHi.a(paramString2, fZr().aZE(paramString2), fZr().aZF(paramString2));
      Iterator localIterator = ((Iterable)this.IKd).iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).c(paramString1, parambhj);
      }
      cR(this.IKn, paramString1);
      cR(this.IKn, paramString2);
    } while (!kotlin.g.b.p.j(paramString1, this.IJQ));
    cR(this.IKu, paramString1);
    Log.i(fZo(), "WebAction:Ready onPermissionUpdated Patch: " + this.IJQ);
  }
  
  public final void a(f paramf)
  {
    kotlin.g.b.p.h(paramf, "listener");
    if (!this.IKc.contains(paramf)) {
      this.IKc.add(paramf);
    }
  }
  
  public final void a(j paramj)
  {
    try
    {
      kotlin.g.b.p.h(paramj, "listener");
      if (!this.IKd.contains(paramj))
      {
        BaseWebViewController localBaseWebViewController = (BaseWebViewController)this;
        kotlin.g.b.p.h(localBaseWebViewController, "<set-?>");
        paramj.controller = localBaseWebViewController;
        this.IKd.add(paramj);
        if (this.IKE.contains(kotlin.g.b.aa.bp(Bind.class).getSimpleName()))
        {
          Log.i(fZo(), "Abe-Debug Patch Call onBind");
          paramj.ePr();
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
    kotlin.g.b.p.h(paramk, "interceptor");
    this.ICu.add(paramk);
    Object localObject = paramk.gai();
    if (localObject != null) {
      a((f)localObject);
    }
    localObject = paramk.gaj();
    if (localObject != null) {
      a((j)localObject);
    }
    paramk.k(this);
  }
  
  public void a(com.tencent.mm.plugin.webview.stub.e parame) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (!afI(this.IKk)) {
      Log.i(fZo(), "onReceivedError, intent not ready");
    }
    for (;;)
    {
      return;
      Log.i(fZo(), "WebView-Trace onReceivedError, errCode:" + paramInt + ", description:" + paramString1 + ", failingUrl:" + paramString2);
      if (afI(this.IKj))
      {
        localObject = fZw();
        if ((((e)localObject).bVc()) && (paramString2 != null)) {
          com.tencent.f.h.RTc.b((Runnable)new e.c((e)localObject, paramString2, paramInt, paramString1), "MicroMsg.WebPageErrorMonitor");
        }
      }
      Object localObject = ((Iterable)this.IKc).iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        if (isStarted()) {
          localf.a(paramWebView, paramInt, paramString1, paramString2);
        }
      }
    }
  }
  
  public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    f localf = null;
    super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    if (!afI(this.IKk))
    {
      Log.i(fZo(), "onReceivedHttpError, intent not ready");
      return;
    }
    String str = fZo();
    StringBuilder localStringBuilder = new StringBuilder("WebView-Trace onReceivedHttpError, errCode:");
    if (paramWebResourceResponse != null)
    {
      localObject = Integer.valueOf(paramWebResourceResponse.getStatusCode());
      label63:
      localStringBuilder = localStringBuilder.append(localObject).append(", description:");
      if (paramWebResourceResponse == null) {
        break label252;
      }
    }
    label252:
    for (Object localObject = paramWebResourceResponse.getReasonPhrase();; localObject = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject).append(", failingUrl:");
      localObject = localf;
      if (paramWebResourceRequest != null) {
        localObject = paramWebResourceRequest.getUrl();
      }
      Log.i(str, String.valueOf(localObject));
      if (afI(this.IKj))
      {
        localObject = fZw();
        if ((((e)localObject).bVc()) && (paramWebResourceRequest != null)) {
          com.tencent.f.h.RTc.b((Runnable)new e.d((e)localObject, paramWebResourceRequest, paramWebResourceResponse), "MicroMsg.WebPageErrorMonitor");
        }
      }
      localObject = ((Iterable)this.IKc).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localf = (f)((Iterator)localObject).next();
        if (isStarted()) {
          localf.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
        }
      }
      break;
      localObject = null;
      break label63;
    }
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.j paramj, String paramString1, String paramString2)
  {
    kotlin.g.b.p.h(paramj, "handler");
    super.a(paramWebView, paramj, paramString1, paramString2);
    com.tencent.mm.plugin.report.service.h.CyF.n(155L, 35L, 1L);
  }
  
  public void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    super.a(paramWebView, paramr, paramSslError);
    if (!afI(this.IKk))
    {
      Log.i(fZo(), "onReceivedSslError, intent not ready");
      return;
    }
    Object localObject2 = fZo();
    StringBuilder localStringBuilder = new StringBuilder("WebView-Trace onReceivedSslError, ");
    if (paramSslError != null) {}
    for (Object localObject1 = paramSslError.toString();; localObject1 = null)
    {
      Log.i((String)localObject2, (String)localObject1);
      if (afI(this.IKj))
      {
        localObject1 = fZw();
        if ((((e)localObject1).bVc()) && (paramSslError != null)) {
          com.tencent.f.h.RTc.b((Runnable)new e.e((e)localObject1, paramSslError), "MicroMsg.WebPageErrorMonitor");
        }
      }
      localObject1 = ((Iterable)this.IKc).iterator();
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
  
  protected boolean a(int paramInt, String paramString, bhj parambhj)
  {
    kotlin.g.b.p.h(paramString, "reqUrl");
    kotlin.g.b.p.h(parambhj, "resp");
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    while (localIterator.hasNext()) {
      if (((k)localIterator.next()).a(paramInt, paramString, parambhj)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    kotlin.g.b.p.h(paramWebView, "view");
    kotlin.g.b.p.h(paramString, "url");
    Log.i(fZo(), "shouldOverrideUrlLoading: ".concat(String.valueOf(paramString)));
    Log.d(fZo(), "doShouldOverrideUrlLoading url:".concat(String.valueOf(paramString)));
    boolean bool1;
    if (m(paramWebView, paramString))
    {
      bool1 = bool2;
      if (!bool1) {
        this.IJM = paramString;
      }
      return bool1;
    }
    label150:
    if (aXA(paramString) == 2)
    {
      bool1 = true;
      label89:
      if (aK(paramString, bool1))
      {
        if (this.IKM.IKW) {
          break label181;
        }
        switch (aXA(paramString))
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
  
  public final void aB(Intent paramIntent)
  {
    kotlin.g.b.p.h(paramIntent, "intent");
    Log.i(fZo(), "start");
    this.IJR = true;
    this.intent = paramIntent;
    com.tencent.mm.plugin.webview.f.g localg = this.mHi;
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
    this.IKa.JBP = paramIntent.getLongExtra("startTime", 0L);
    kotlinx.coroutines.f.b((ai)bn.TUK, null, (kotlin.g.a.m)new BaseWebViewController.ak(this, null), 3);
  }
  
  protected boolean aK(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    kotlin.g.b.p.h(paramString, "url");
    if (a(this, paramString, paramBoolean, 0, 4) == c.a.Jcb) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean aXB(String paramString)
  {
    kotlin.g.b.p.h(paramString, "url");
    if (com.tencent.mm.platformtools.ac.jOz)
    {
      Log.w(fZo(), "skipLoadUrlCheck");
      return true;
    }
    if (this.IKM.IKT)
    {
      Log.i(fZo(), "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "file://", true))
    {
      Iterator localIterator = ((Iterable)fZq()).iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.luggage.h.c.a(paramString, (String)localIterator.next(), true)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  protected final boolean aXC(String paramString)
  {
    kotlin.g.b.p.h(paramString, "url");
    if (!aXB(paramString))
    {
      Log.f(fZo(), "forceQuitOnUrlForbidden, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = ((Iterable)this.IKd).iterator();
      while (paramString.hasNext()) {
        ((j)paramString.next()).gad();
      }
      return true;
    }
    return false;
  }
  
  protected final void aXx(String paramString)
  {
    kotlin.g.b.p.h(paramString, "value");
    if (aiw(paramString))
    {
      Log.d(fZo(), "WebView-Trace startUrl:".concat(String.valueOf(paramString)));
      this.IJO = paramString;
    }
  }
  
  protected final void aXy(String paramString)
  {
    kotlin.g.b.p.h(paramString, "value");
    if (aix(paramString))
    {
      Log.d(fZo(), "WebView-Trace commitUrl:".concat(String.valueOf(paramString)));
      this.IJP = paramString;
    }
  }
  
  public final ConcurrentLinkedDeque<kotlin.g.a.a<x>> afG(int paramInt)
  {
    ConcurrentLinkedDeque localConcurrentLinkedDeque2 = (ConcurrentLinkedDeque)this.IKe.get(Integer.valueOf(paramInt));
    ConcurrentLinkedDeque localConcurrentLinkedDeque1 = localConcurrentLinkedDeque2;
    if (localConcurrentLinkedDeque2 == null)
    {
      localConcurrentLinkedDeque1 = new ConcurrentLinkedDeque();
      ((Map)this.IKe).put(Integer.valueOf(paramInt), localConcurrentLinkedDeque1);
    }
    return localConcurrentLinkedDeque1;
  }
  
  /* Error */
  public final void afH(final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1252	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZD	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 1208	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   17: new 129	com/tencent/mm/plugin/webview/core/BaseWebViewController$t
    //   20: dup
    //   21: aload_0
    //   22: iload_1
    //   23: invokespecial 1557	com/tencent/mm/plugin/webview/core/BaseWebViewController$t:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;I)V
    //   26: checkcast 1211	java/lang/Runnable
    //   29: invokeinterface 1217 2 0
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
  
  public final boolean afI(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!kotlin.aa.SXc) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.IKC.contains(Integer.valueOf(paramInt));
    return bool;
  }
  
  protected boolean aiw(String paramString)
  {
    kotlin.g.b.p.h(paramString, "url");
    return true;
  }
  
  protected boolean aix(String paramString)
  {
    kotlin.g.b.p.h(paramString, "url");
    if (!kotlin.n.n.aL((CharSequence)paramString)) {}
    for (int i = 1; (i != 0) && (!kotlin.n.n.J(paramString, "data:text/html;charset=utf-8", false)) && (!kotlin.n.n.J(paramString, "about:blank", false)); i = 0)
    {
      if (afI(this.IKl))
      {
        String str = com.tencent.mm.plugin.webview.h.a.pFm;
        kotlin.g.b.p.g(str, "ConstantsPreload.HARDCODE_URL");
        if (kotlin.n.n.J(paramString, str, false)) {
          break;
        }
      }
      return true;
    }
    return false;
  }
  
  protected WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    kotlin.g.b.p.h(paramWebView, "webView");
    kotlin.g.b.p.h(paramWebResourceRequest, "request");
    com.tencent.f.h.RTc.aX((Runnable)new aa(paramWebResourceRequest, this));
    Object localObject = paramWebResourceRequest.getUrl().toString();
    kotlin.g.b.p.g(localObject, "request.url.toString()");
    if (aXC((String)localObject)) {
      return null;
    }
    if ((com.tencent.mm.cr.d.kS(getContext())) && (paramBundle != null)) {}
    try
    {
      i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        Log.i(fZo(), "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        paramBundle = paramWebResourceRequest.getUrl().toString();
        kotlin.g.b.p.g(paramBundle, "request.url.toString()");
        k(paramBundle, false, 5);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.w(fZo(), "get resource type failed Exception ; " + paramBundle.getMessage());
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        Log.w(fZo(), "get resource type failed Throwable ; " + paramBundle.getMessage());
      }
      if (!((Boolean)this.IKK.getValue()).booleanValue()) {
        break label424;
      }
      paramWebView = IKP;
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
          if ((localObject != null) && (kotlin.n.n.J((String)localObject, paramBundle, false) == true))
          {
            Log.i(fZo(), "QuickAppInterceptor interceptor url = ".concat(String.valueOf(paramBundle)));
            com.tencent.mm.plugin.report.service.h.CyF.n(1551L, j + 1, 1L);
            if (((Boolean)this.IKL.getValue()).booleanValue())
            {
              Log.i(fZo(), "QuickAppInterceptor interceptor WebResourceResponse");
              return new WebResourceResponse("", null, null);
            }
          }
        }
        j += 1;
        i += 1;
      }
    }
    paramBundle = ((Iterable)this.ICu).iterator();
    while (paramBundle.hasNext())
    {
      localObject = ((k)paramBundle.next()).b(paramWebView, paramWebResourceRequest);
      if (localObject != null) {
        return localObject;
      }
    }
    label424:
    return null;
  }
  
  public final void b(f paramf)
  {
    kotlin.g.b.p.h(paramf, "listener");
    if (this.IKc.contains(paramf)) {
      this.IKc.remove(paramf);
    }
  }
  
  public final void b(j paramj)
  {
    try
    {
      kotlin.g.b.p.h(paramj, "listener");
      if (this.IKd.contains(paramj)) {
        this.IKd.remove(paramj);
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
    kotlin.g.b.p.h(paramk, "interceptor");
    this.ICu.remove(paramk);
    f localf = paramk.gai();
    if (localf != null) {
      b(localf);
    }
    paramk = paramk.gaj();
    if (paramk != null) {
      b(paramk);
    }
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    if (fZD())
    {
      Log.w(fZo(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = Yc(str);
      Log.i(fZo(), "WebView-Trace onPageFinished: " + paramString + ", callbackUrl:" + str);
      super.b(paramWebView, paramString);
      if ((!this.IKB.contains(Integer.valueOf(this.IKs))) && (!cph()))
      {
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1200L, 104L, 1L, false);
        Log.i(fZo(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
      }
      cR(this.IKt, aXw(paramString));
      Iterator localIterator = ((Iterable)this.IKc).iterator();
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
    kotlin.g.b.p.h(paramWebView, "view");
    kotlin.g.b.p.h(paramString, "url");
    if (fZD())
    {
      Log.w(fZo(), "ActivityFinished");
      return;
    }
    Object localObject2 = this.pGj.getActivityContextIfHas();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    localObject1 = (Activity)localObject1;
    if (localObject1 != null)
    {
      localObject1 = ((Activity)localObject1).getIntent();
      kotlin.g.b.p.g(localObject1, "it.intent");
      this.intent = ((Intent)localObject1);
    }
    cR(this.IKp, paramString);
    Log.i(fZo(), "WebView-Trace onPageStarted: ".concat(String.valueOf(paramString)));
    this.IKg = false;
    this.IJM = paramString;
    aXz(paramString);
    localObject1 = ((Iterable)this.IKc).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f)((Iterator)localObject1).next();
      if (isStarted()) {
        ((f)localObject2).i(paramWebView, Yc(paramString));
      }
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    kotlin.g.b.p.h(paramWebView, "view");
    kotlin.g.b.p.h(paramString, "url");
    Log.i(fZo(), "WebView-Trace doUpdateVisitedHistory, url = " + paramString + ", wvUrl = " + paramWebView.getUrl() + ", isReload = " + paramBoolean);
    if (kotlin.n.n.J(paramString, "data:text/html;charset=utf-8", false))
    {
      Log.i(fZo(), "url starts with data:text, url : ".concat(String.valueOf(paramString)));
      return;
    }
    if ((com.tencent.luggage.h.c.A(paramString, "about:blank")) || (com.tencent.luggage.h.c.A(paramString, "file:///android_asset/")))
    {
      Log.e(fZo(), "doUpdateVisitedHistory, url is invalid");
      return;
    }
    if (afI(this.IKl))
    {
      localObject = com.tencent.mm.plugin.webview.h.a.pFm;
      kotlin.g.b.p.g(localObject, "ConstantsPreload.HARDCODE_URL");
      if (com.tencent.luggage.h.c.A(paramString, (String)localObject))
      {
        Log.i(fZo(), "doUpdateVisitedHistory, url is HARDCODE_URL");
        return;
      }
    }
    super.b(paramWebView, paramString, paramBoolean);
    if (((Boolean)this.IKJ.getValue()).booleanValue()) {
      paramString = paramWebView.getUrl();
    }
    kotlin.g.b.p.g(paramString, "url");
    if (!kotlin.g.b.p.j(this.IJO, paramString))
    {
      if (this.mHi.has(paramString)) {
        cR(this.IKu, paramString);
      }
      fZt().gbk();
      this.IJQ = paramString;
    }
    if (!this.IKM.IKW) {
      k(paramString, false, fZr().cO(paramString, true));
    }
    this.IJM = paramString;
    Object localObject = ((Iterable)this.IKc).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f localf = (f)((Iterator)localObject).next();
      if (isStarted()) {
        localf.aXF(paramString);
      }
    }
    n(paramWebView, paramString);
  }
  
  public boolean b(int paramInt, String paramString, bhj parambhj)
  {
    kotlin.g.b.p.h(paramString, "reqUrl");
    kotlin.g.b.p.h(parambhj, "response");
    Log.i(fZo(), "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(paramInt)));
    this.pGj.setA8keyReason(paramInt);
    Object localObject1 = this.IJX;
    ((Map)localObject1).clear();
    Object localObject2 = parambhj.LRq;
    kotlin.g.b.p.g(localObject2, "response.HttpHeader");
    int i;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      localObject2 = com.tencent.mm.plugin.webview.f.c.ij((List)parambhj.LRq);
      kotlin.g.b.p.g(localObject2, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      ((Map)localObject1).putAll((Map)localObject2);
    }
    label134:
    label327:
    label459:
    for (;;)
    {
      if (!a(paramInt, paramString, parambhj)) {
        break label461;
      }
      return true;
      i = 0;
      break;
      localObject2 = this.intent;
      if (localObject2 == null) {
        kotlin.g.b.p.btv("intent");
      }
      if (((Intent)localObject2).getBooleanExtra("k_has_http_header", false))
      {
        Log.i(fZo(), "use intent httpheader info");
        localObject2 = this.intent;
        if (localObject2 == null) {
          kotlin.g.b.p.btv("intent");
        }
        localObject2 = ((Intent)localObject2).getStringArrayExtra("geta8key_result_http_header_key_list");
        Object localObject3 = this.intent;
        if (localObject3 == null) {
          kotlin.g.b.p.btv("intent");
        }
        localObject3 = ((Intent)localObject3).getStringArrayExtra("geta8key_result_http_header_value_list");
        Intent localIntent = this.intent;
        if (localIntent == null) {
          kotlin.g.b.p.btv("intent");
        }
        localIntent.putExtra("k_has_http_header", false);
        localIntent = this.intent;
        if (localIntent == null) {
          kotlin.g.b.p.btv("intent");
        }
        localIntent.putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        localIntent = this.intent;
        if (localIntent == null) {
          kotlin.g.b.p.btv("intent");
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
              kotlin.g.b.p.g(localIntent, "httpHeaderKey[i]");
              Object localObject4 = localObject3[i];
              kotlin.g.b.p.g(localObject4, "httpHeaderValue[i]");
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
    localObject1 = ((Iterable)this.IKd).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((j)((Iterator)localObject1).next()).b(paramString, parambhj);
    }
    return false;
  }
  
  public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    kotlin.g.b.p.h(paramWebView, "webview");
    kotlin.g.b.p.h(paramString1, "description");
    kotlin.g.b.p.h(paramString2, "failingUrl");
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    while (localIterator.hasNext()) {
      ((k)localIterator.next()).c(paramWebView, paramInt, paramString1, paramString2);
    }
    return super.b(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public final String beU()
  {
    return fZr().aZj(getCurrentUrl());
  }
  
  public final MMHandler bkj()
  {
    return (MMHandler)this.lhN.getValue();
  }
  
  public final void bx(int paramInt, String paramString)
  {
    kotlin.g.b.p.h(paramString, "reqUrl");
    this.IKa.bN("getA8KeyEnd", System.currentTimeMillis());
    Iterator localIterator = ((Iterable)this.IKd).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).aXN(paramString);
    }
  }
  
  public final void by(final int paramInt, final String paramString)
  {
    kotlin.g.b.p.h(paramString, "reqUrl");
    this.IKa.bN("getA8KeyStart", System.currentTimeMillis());
    if (paramInt != 5) {
      cR(this.IKq, paramString);
    }
    if ((kotlin.g.b.p.j(this.IJQ, paramString) ^ true)) {
      com.tencent.f.h.RTc.aV((Runnable)new ae(this, paramInt, paramString));
    }
  }
  
  /* Error */
  protected final void cR(final int paramInt, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ldc_w 1434
    //   6: invokestatic 656	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 1252	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZD	()Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: getstatic 1208	com/tencent/f/h:RTc	Lcom/tencent/f/i;
    //   24: new 133	com/tencent/mm/plugin/webview/core/BaseWebViewController$u
    //   27: dup
    //   28: aload_0
    //   29: iload_1
    //   30: aload_2
    //   31: invokespecial 1821	com/tencent/mm/plugin/webview/core/BaseWebViewController$u:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;ILjava/lang/String;)V
    //   34: checkcast 1211	java/lang/Runnable
    //   37: invokeinterface 1217 2 0
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
  
  public String coX()
  {
    try
    {
      Object localObject = this.intent;
      if (localObject == null) {
        kotlin.g.b.p.btv("intent");
      }
      localObject = b.bj((Intent)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e(fZo(), String.valueOf(localException.getMessage()));
      onFinish();
    }
    return "";
  }
  
  protected boolean coY()
  {
    return this.IKy;
  }
  
  protected boolean coZ()
  {
    return false;
  }
  
  protected void cpR()
  {
    if (!this.IKI)
    {
      fZG();
      this.IKI = true;
    }
    Iterator localIterator = ((Iterable)this.IKd).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).cpR();
    }
  }
  
  protected boolean cpa()
  {
    return false;
  }
  
  protected List<e> cpb()
  {
    return this.pFO;
  }
  
  protected void cpc()
  {
    com.tencent.mm.plugin.expansions.a.cMr();
    a((k)new com.tencent.mm.plugin.webview.c.a());
    a((k)new com.tencent.mm.plugin.webview.g.a());
    a((k)new com.tencent.mm.plugin.webview.l.e());
    this.pGj.setWebViewClient((com.tencent.xweb.ac)this);
    MMWebView localMMWebView = this.pGj;
    Object localObject1 = z.ILi;
    com.tencent.mm.plugin.webview.k.k.h(localMMWebView);
    z localz = localMMWebView.getSettings();
    localz.setJavaScriptEnabled(((Boolean)this.IKM.IKS.ILb.getValue()).booleanValue());
    localz.setPluginsEnabled(((Boolean)this.IKM.IKS.IKZ.getValue()).booleanValue());
    localz.hsU();
    localz.setBuiltInZoomControls(((Boolean)this.IKM.IKS.ILa.getValue()).booleanValue());
    localz.setUseWideViewPort(true);
    localz.setLoadWithOverviewMode(true);
    localz.hsN();
    localz.hsM();
    localz.setGeolocationEnabled(true);
    localz.setJavaScriptCanOpenWindowsAutomatically(true);
    localz.hsW();
    localz.hsS();
    localObject1 = localMMWebView.getContext().getDir("webviewcache", 0);
    kotlin.g.b.p.g(localObject1, "context.getDir(\"webviewc…e\", Context.MODE_PRIVATE)");
    localz.setAppCachePath(((File)localObject1).getAbsolutePath());
    localz.hsR();
    localz.hsT();
    localz.setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
    String str = localz.getUserAgentString();
    kotlin.g.b.p.g(str, "currentUa");
    Object localObject2;
    if (!kotlin.n.n.e((CharSequence)str, (CharSequence)" MicroMessenger/"))
    {
      localObject2 = (p.a)com.tencent.luggage.a.e.M(p.a.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (p.a)new com.tencent.mm.plugin.appbrand.luggage.b.f(localMMWebView.getContext());
      }
      localObject2 = com.tencent.mm.plugin.webview.k.e.JBw;
      kotlin.g.b.p.h(str, "prefix");
      e.a.aTI().putString("key_web_prefetch_ua", str);
      localz.setUserAgentString(com.tencent.mm.plugin.appbrand.ac.p.a(localMMWebView.getContext(), str, (p.a)localObject1));
    }
    if (!((Boolean)this.IKM.IKS.ILc.getValue()).booleanValue())
    {
      localMMWebView.setVerticalScrollBarEnabled(false);
      localMMWebView.setHorizontalScrollBarEnabled(false);
    }
    com.tencent.xweb.c.hsp().hsq();
    com.tencent.xweb.c.hsp().e((WebView)localMMWebView);
    localObject1 = z.ILi;
    localObject1 = localMMWebView.getContext().getSystemService("window");
    if (localObject1 == null) {
      throw new t("null cannot be cast to non-null type android.view.WindowManager");
    }
    z.b((WindowManager)localObject1);
    if (this.pGj.gZa())
    {
      localObject2 = this.pGj.getUrl();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      aXy((String)localObject1);
    }
    this.IKa.bN("onTryBindServiceStart", System.currentTimeMillis());
    Log.i(fZo(), "WebView-Trace tryBindService");
    localObject1 = m.INc;
    m.a(true, fZp(), (d)new al(this));
    this.IKa.bN("onTryBindServiceEnd", System.currentTimeMillis());
  }
  
  protected void cpd() {}
  
  protected boolean cpe()
  {
    return true;
  }
  
  public boolean cph()
  {
    return (afI(this.IKl)) && (kotlin.g.b.p.j(this.djt, this.IJP));
  }
  
  public final void destroy()
  {
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new w(this));
  }
  
  public final void e(WebView paramWebView, String paramString)
  {
    if (fZD())
    {
      Log.w(fZo(), "ActivityFinished");
      return;
    }
    Object localObject1 = getJsapi();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.d.h)localObject1).fWV();
    }
    if ((fZE()) && (!this.pGj.gZa()) && (!afI(this.IKl)) && (paramString != null) && (!kotlin.n.n.J(paramString, "file:", false)))
    {
      localObject1 = getJsapi();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.webview.d.h)localObject1).gaU();
      }
    }
    if (paramString == null) {}
    for (localObject1 = "";; localObject1 = paramString)
    {
      localObject1 = Yc((String)localObject1);
      Log.i(fZo(), "WebView-Trace onPageCommitVisible: " + paramString + ", callbackUrl:" + (String)localObject1);
      aXy((String)localObject1);
      super.e(paramWebView, paramString);
      Object localObject2 = g.ILB;
      if (!g.a.fZQ()) {
        cR(this.IKs, aXw(paramString));
      }
      for (;;)
      {
        localObject2 = ((Iterable)this.IKc).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          f localf = (f)((Iterator)localObject2).next();
          if (isStarted()) {
            localf.e(paramWebView, (String)localObject1);
          }
        }
        Log.i(fZo(), "WebView Page Commit Mock Enabled");
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
    kotlin.g.b.p.h(paramWebView, "webView");
    kotlin.g.b.p.h(paramWebResourceRequest, "request");
    kotlin.g.b.p.h(paramWebView, "webView");
    kotlin.g.b.p.h(paramWebResourceRequest, "request");
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    k.a locala;
    while (localIterator.hasNext())
    {
      locala = ((k)localIterator.next()).c(paramWebView, paramWebResourceRequest);
      if (locala.INa) {
        if (!locala.INa) {
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
  
  protected void ePr() {}
  
  protected void fZA() {}
  
  public boolean fZB()
  {
    return false;
  }
  
  public void fZC()
  {
    this.IJT = false;
  }
  
  public final boolean fZD()
  {
    return (this.IJT) || (this.IJS);
  }
  
  public final boolean fZE()
  {
    return ((Boolean)this.IKH.getValue()).booleanValue();
  }
  
  public final boolean fZF()
  {
    try
    {
      afJ(this.IKm);
      boolean bool = afJ(this.IKl);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void fZG() {}
  
  protected void fZH() {}
  
  public final boolean fZI()
  {
    return !afI(this.IKl);
  }
  
  public final String fZo()
  {
    return (String)this.IJK.getValue();
  }
  
  protected abstract Class<? extends Service> fZp();
  
  protected abstract Set<String> fZq();
  
  public final com.tencent.mm.plugin.webview.f.c fZr()
  {
    return (com.tencent.mm.plugin.webview.f.c)this.IJN.getValue();
  }
  
  public final com.tencent.mm.plugin.webview.stub.e fZs()
  {
    com.tencent.mm.plugin.webview.stub.e locale = this.mHh;
    if (locale == null) {
      kotlin.g.b.p.btv("invoker");
    }
    return locale;
  }
  
  public final com.tencent.mm.plugin.webview.d.k fZt()
  {
    return (com.tencent.mm.plugin.webview.d.k)this.IJU.getValue();
  }
  
  public final int fZu()
  {
    return ((Number)this.IJW.getValue()).intValue();
  }
  
  public final Runnable fZv()
  {
    return (Runnable)this.IJY.getValue();
  }
  
  public final String fZx()
  {
    return (String)this.IKh.getValue();
  }
  
  protected final boolean fZz()
  {
    try
    {
      boolean bool = this.IKD.contains(kotlin.g.b.aa.bp(Inject.class).getSimpleName());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final Context getContext()
  {
    Context localContext = this.pGj.getContext();
    kotlin.g.b.p.g(localContext, "viewWV.context");
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    if (kotlin.n.n.aL((CharSequence)this.IJQ)) {
      return this.IJP;
    }
    return this.IJQ;
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = this.intent;
    if (localIntent == null) {
      kotlin.g.b.p.btv("intent");
    }
    return localIntent;
  }
  
  public final com.tencent.mm.plugin.webview.d.h getJsapi()
  {
    return (com.tencent.mm.plugin.webview.d.h)this.IJV.getValue();
  }
  
  protected final int getScreenOrientation()
  {
    Iterator localIterator = ((Iterable)this.ICu).iterator();
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
    fZy();
    afH(this.IKi);
    this.pGj.a((com.tencent.mm.ui.widget.i)new d());
  }
  
  protected final boolean isStarted()
  {
    try
    {
      boolean bool = this.IKE.contains(kotlin.g.b.aa.bp(Start.class).getSimpleName());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final c.a k(String paramString, boolean paramBoolean, int paramInt)
  {
    kotlin.g.b.p.h(paramString, "url");
    if (this.IKM.IKW)
    {
      Log.w(fZo(), "startGetA8Key neverGetA8Key ".concat(String.valueOf(paramString)));
      return c.a.Jca;
    }
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    while (localIterator.hasNext()) {
      if (((k)localIterator.next()).aXP(paramString)) {
        return c.a.JbZ;
      }
    }
    paramString = fZr().a(paramString, paramBoolean, paramInt, (com.tencent.mm.plugin.webview.f.a)this.IJL.getValue());
    kotlin.g.b.p.g(paramString, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
    return paramString;
  }
  
  protected final k.a l(WebView paramWebView, String paramString)
  {
    kotlin.g.b.p.h(paramWebView, "webView");
    kotlin.g.b.p.h(paramString, "url");
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    while (localIterator.hasNext())
    {
      k.a locala = ((k)localIterator.next()).o(paramWebView, paramString);
      if (locala.INa) {
        return locala;
      }
    }
    return new k.a(false, false);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    kotlin.g.b.p.h(paramString, "url");
    Log.i(fZo(), "WebView-Trace loadUrl url ".concat(String.valueOf(paramString)));
    if (paramBoolean)
    {
      this.pGj.loadUrl(paramString, (Map)ae.g(new o[] { s.U("Pragma", "no-cache"), s.U("Cache-Control", "no-cache") }));
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    if (i != 0)
    {
      this.pGj.loadUrl(paramString);
      return;
    }
    this.pGj.loadUrl(paramString, paramMap);
  }
  
  protected boolean m(WebView paramWebView, String paramString)
  {
    kotlin.g.b.p.h(paramWebView, "webView");
    kotlin.g.b.p.h(paramString, "url");
    paramWebView = l(paramWebView, paramString);
    if (paramWebView.INa) {
      return paramWebView.result;
    }
    return false;
  }
  
  public final void n(final String paramString, final kotlin.g.a.b<? super String, x> paramb)
  {
    kotlin.g.b.p.h(paramString, "script");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new x(this, paramString, paramb));
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 2128	com/tencent/mm/plugin/webview/core/BaseWebViewController:IJS	Z
    //   7: aload_0
    //   8: getfield 2126	com/tencent/mm/plugin/webview/core/BaseWebViewController:IJT	Z
    //   11: ifne +8 -> 19
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 2209	com/tencent/mm/plugin/webview/core/BaseWebViewController:yR	(Z)V
    //   19: aload_0
    //   20: getfield 2211	com/tencent/mm/plugin/webview/core/BaseWebViewController:IKG	Lcom/tencent/mm/plugin/webview/core/c;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +27 -> 52
    //   28: aload_1
    //   29: checkcast 2213	java/io/Closeable
    //   32: astore_3
    //   33: aload_0
    //   34: invokevirtual 923	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZo	()Ljava/lang/String;
    //   37: ldc_w 2215
    //   40: invokestatic 995	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: getstatic 2221	kotlin/x:SXb	Lkotlin/x;
    //   46: astore_1
    //   47: aload_3
    //   48: aconst_null
    //   49: invokestatic 2226	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   52: aload_0
    //   53: invokevirtual 2228	com/tencent/mm/plugin/webview/core/BaseWebViewController:bkj	()Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   56: aload_0
    //   57: invokevirtual 2230	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZv	()Ljava/lang/Runnable;
    //   60: invokevirtual 2233	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   63: aload_0
    //   64: invokevirtual 2073	com/tencent/mm/plugin/webview/core/BaseWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/d/h;
    //   67: invokevirtual 2236	com/tencent/mm/plugin/webview/d/h:detach	()V
    //   70: aload_0
    //   71: invokevirtual 1702	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZt	()Lcom/tencent/mm/plugin/webview/d/k;
    //   74: invokevirtual 2237	com/tencent/mm/plugin/webview/d/k:detach	()V
    //   77: aload_0
    //   78: invokevirtual 855	com/tencent/mm/plugin/webview/core/BaseWebViewController:fZr	()Lcom/tencent/mm/plugin/webview/f/c;
    //   81: invokevirtual 2239	com/tencent/mm/plugin/webview/f/c:destroy	()V
    //   84: return
    //   85: astore_2
    //   86: aload_2
    //   87: athrow
    //   88: astore_1
    //   89: aload_3
    //   90: aload_2
    //   91: invokestatic 2226	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    Iterator localIterator = ((Iterable)this.IKd).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).onFinish();
    }
  }
  
  public final void reload()
  {
    if ((this.pGj == null) || (Util.isNullOrNil(this.pGj.getUrl()))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      String str = this.pGj.getUrl();
      kotlin.g.b.p.g(str, "viewWV.url");
      if (localk.aiD(Yc(str))) {
        return;
      }
    }
    Log.i(fZo(), "reload");
    this.pGj.reload();
  }
  
  protected final void setIntent(Intent paramIntent)
  {
    kotlin.g.b.p.h(paramIntent, "<set-?>");
    this.intent = paramIntent;
  }
  
  public final void yR(boolean paramBoolean)
  {
    try
    {
      com.tencent.mm.plugin.webview.stub.e locale = this.mHh;
      if (locale == null) {
        kotlin.g.b.p.btv("invoker");
      }
      if (locale != null)
      {
        if (!paramBoolean)
        {
          locale = this.mHh;
          if (locale == null) {
            kotlin.g.b.p.btv("invoker");
          }
          locale.agy(fZu());
        }
        locale = this.mHh;
        if (locale == null) {
          kotlin.g.b.p.btv("invoker");
        }
        locale.bs(fZu(), paramBoolean);
      }
      Log.i(fZo(), "removeInvoker ok");
      return;
    }
    catch (Exception localException)
    {
      Log.w(fZo(), "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException)));
    }
  }
  
  protected final void yS(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.IKd).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).yS(paramBoolean);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Auth
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(224952);
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(kotlin.g.b.aa.bp(BaseWebViewController.Inject.class), paramString)) && (waitFor(localBaseWebViewController.IKj)) && ((localBaseWebViewController.IKM.IKW) || (localBaseWebViewController.mHi.has(paramString)) || (waitFor(localBaseWebViewController.IKn, paramString))))
      {
        AppMethodBeat.o(224952);
        return true;
      }
      AppMethodBeat.o(224952);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Bind
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(224954);
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(localBaseWebViewController.IKk)) && (waitFor(localBaseWebViewController.IKj)))
      {
        AppMethodBeat.o(224954);
        return true;
      }
      AppMethodBeat.o(224954);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  public static abstract class ControllerAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Init
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(224956);
      boolean bool = waitFor(getController().IKi);
      AppMethodBeat.o(224956);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Inject
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(224957);
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((!localBaseWebViewController.pGj.gZa()) && (!waitFor(localBaseWebViewController.IKs, paramString)) && ((!waitFor(localBaseWebViewController.IKt, paramString)) || (!waitFor(localBaseWebViewController.IKv, paramString)))) || (((waitFor(localBaseWebViewController.IKj)) && ((localBaseWebViewController.IKM.IKW) || (localBaseWebViewController.mHi.has(paramString)) || (waitFor(localBaseWebViewController.IKn, paramString)))) || (localBaseWebViewController.coZ())))
      {
        AppMethodBeat.o(224957);
        return true;
      }
      AppMethodBeat.o(224957);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"})
  @Keep
  protected static abstract class PageAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify(String paramString);
    
    public final boolean waitFor(int paramInt, String paramString)
    {
      kotlin.g.b.p.h(paramString, "url");
      return ((kotlin.g.b.p.j(paramString, getController().IJO)) || (getController().IKx.contains(Integer.valueOf(paramInt)))) && (BaseWebViewController.b(getController()).contains(Integer.valueOf(paramInt)));
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageLoadEndForCommitNotSupport;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class PageLoadEndForCommitNotSupport
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(224960);
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(kotlin.g.b.aa.bp(BaseWebViewController.Start.class))) && (waitFor(localBaseWebViewController.IKt, paramString)) && (waitFor(localBaseWebViewController.IKv, paramString)))
      {
        AppMethodBeat.o(224960);
        return true;
      }
      AppMethodBeat.o(224960);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarEnd;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarEnd
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(224961);
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((localBaseWebViewController.coY()) && ((localBaseWebViewController.cpa()) || (waitFor(kotlin.g.b.aa.bp(BaseWebViewController.Ready.class), paramString)) || (waitFor(localBaseWebViewController.IKt, paramString)) || (waitFor(localBaseWebViewController.IKs, paramString)) || (waitFor(localBaseWebViewController.IKo, paramString))))
      {
        AppMethodBeat.o(224961);
        return true;
      }
      AppMethodBeat.o(224961);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarStart;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarStart
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(224962);
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(kotlin.g.b.aa.bp(BaseWebViewController.Start.class))) && (((!localBaseWebViewController.afI(localBaseWebViewController.IKm)) && ((waitFor(localBaseWebViewController.IKq, paramString)) || (waitFor(localBaseWebViewController.IKp, paramString)))) || ((!waitFor(kotlin.g.b.aa.bp(BaseWebViewController.ProgressBarEnd.class), paramString)) && (localBaseWebViewController.afI(localBaseWebViewController.IKm)) && (waitFor(localBaseWebViewController.IKr, paramString)))))
      {
        AppMethodBeat.o(224962);
        return true;
      }
      AppMethodBeat.o(224962);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Ready
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(224964);
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((waitFor(kotlin.g.b.aa.bp(BaseWebViewController.Start.class))) && (waitFor(kotlin.g.b.aa.bp(BaseWebViewController.Auth.class), paramString)) && ((waitFor(localBaseWebViewController.IKt, paramString)) || (localBaseWebViewController.pGj.gZa()))) || (localBaseWebViewController.cpa()))
      {
        AppMethodBeat.o(224964);
        return true;
      }
      AppMethodBeat.o(224964);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"})
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
      AppMethodBeat.i(224965);
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(kotlin.g.b.aa.bp(BaseWebViewController.Ready.class), paramString)) && (waitFor(localBaseWebViewController.IKu, paramString)))
      {
        AppMethodBeat.o(224965);
        return true;
      }
      AppMethodBeat.o(224965);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Start
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(224966);
      Object localObject = getController();
      if ((waitFor(((BaseWebViewController)localObject).IKk)) && ((!((BaseWebViewController)localObject).cpe()) || (waitFor(((BaseWebViewController)localObject).IKj))))
      {
        if (((CharSequence)((BaseWebViewController)localObject).coX()).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            localObject = (CharSequence)((BaseWebViewController)localObject).fZx();
            if ((localObject != null) && (!kotlin.n.n.aL((CharSequence)localObject))) {
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
          AppMethodBeat.o(224966);
          return true;
          i = 0;
          break;
        }
      }
      label102:
      AppMethodBeat.o(224966);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"})
  @Keep
  public static abstract class WebAction
  {
    public BaseWebViewController controller;
    private final boolean keep;
    
    public final BaseWebViewController getController()
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.btv("controller");
      }
      return localBaseWebViewController;
    }
    
    public boolean getKeep()
    {
      return this.keep;
    }
    
    public final void setController(BaseWebViewController paramBaseWebViewController)
    {
      kotlin.g.b.p.h(paramBaseWebViewController, "<set-?>");
      this.controller = paramBaseWebViewController;
    }
    
    public final boolean waitFor(int paramInt)
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.btv("controller");
      }
      return BaseWebViewController.c(localBaseWebViewController).contains(Integer.valueOf(paramInt));
    }
    
    public final boolean waitFor(kotlin.l.b<? extends BaseWebViewController.ControllerAction> paramb)
    {
      kotlin.g.b.p.h(paramb, "clazz");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.btv("controller");
      }
      return BaseWebViewController.d(localBaseWebViewController).contains(paramb.getSimpleName());
    }
    
    public final boolean waitFor(kotlin.l.b<? extends BaseWebViewController.PageAction> paramb, String paramString)
    {
      kotlin.g.b.p.h(paramb, "clazz");
      kotlin.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        kotlin.g.b.p.btv("controller");
      }
      if (kotlin.g.b.p.j(paramString, localBaseWebViewController.IJO))
      {
        paramString = this.controller;
        if (paramString == null) {
          kotlin.g.b.p.btv("controller");
        }
        if (BaseWebViewController.e(paramString).contains(paramb.getSimpleName())) {
          return true;
        }
      }
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<String>
  {
    a(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/webview/core/BaseWebViewController$intercept$1$1"})
  static final class aa
    implements Runnable
  {
    aa(WebResourceRequest paramWebResourceRequest, BaseWebViewController paramBaseWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(225006);
      Log.i(BaseWebViewController.a(jdField_this), "shouldInterceptRequest, url = " + this.ILj.getUrl() + ", method = " + this.ILj.getMethod() + ", isForMainFrame = " + this.ILj.isForMainFrame());
      AppMethodBeat.o(225006);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "invoke"})
  static final class ab
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.d.k>
  {
    ab(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "invoke"})
  static final class ac
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.d.h>
  {
    ac(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(BaseWebViewController paramBaseWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(225009);
      this.IKR.bkj().postUIDelayed(this.IKR.fZv(), 500L);
      AppMethodBeat.o(225009);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(225010);
      Iterator localIterator = ((Iterable)this.IKR.IKd).iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).by(paramInt, paramString);
      }
      AppMethodBeat.o(225010);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class af
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final af ILk;
    
    static
    {
      AppMethodBeat.i(225012);
      ILk = new af();
      AppMethodBeat.o(225012);
    }
    
    af()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ag
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final ag ILl;
    
    static
    {
      AppMethodBeat.i(225014);
      ILl = new ag();
      AppMethodBeat.o(225014);
    }
    
    ag()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "invoke"})
  static final class ah
    extends q
    implements kotlin.g.a.a<e>
  {
    ah(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
    
    private e fZJ()
    {
      AppMethodBeat.i(225016);
      for (long l = -1L;; l = 0L)
      {
        try
        {
          if (!this.IKR.fZs().gdW()) {
            continue;
          }
          int i = this.IKR.fZs().gec();
          l = i;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            e locale;
            Log.e(BaseWebViewController.a(this.IKR), "Get Uin Error:" + localThrowable.getLocalizedMessage());
          }
        }
        locale = new e(l);
        AppMethodBeat.o(225016);
        return locale;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
  static final class ai
    extends q
    implements kotlin.g.a.a<Runnable>
  {
    ai(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"})
  public static final class aj
    extends l
  {
    public final void Mc(long paramLong)
    {
      AppMethodBeat.i(225019);
      this.IKR.bkj().postDelayed(this.IKR.fZv(), paramLong);
      AppMethodBeat.o(225019);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/BaseWebViewController$tryBindService$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class al
    implements d
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(225023);
      kotlin.g.b.p.h(paramc, "conn");
      if (this.IKR.fZD())
      {
        Log.i(BaseWebViewController.a(this.IKR), "WebView-Trace onConnected whent destroyCalled");
        AppMethodBeat.o(225023);
        return;
      }
      this.IKR.IKG = paramc;
      BaseWebViewController localBaseWebViewController = this.IKR;
      paramc = paramc.fZs();
      kotlin.g.b.p.h(paramc, "<set-?>");
      localBaseWebViewController.mHh = paramc;
      this.IKR.getJsapi().b(this.IKR.fZs());
      this.IKR.a(this.IKR.fZs());
      Log.i(BaseWebViewController.a(this.IKR), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
      if (BaseWebViewController.d(this.IKR).contains(kotlin.g.b.aa.bp(BaseWebViewController.Bind.class).getSimpleName()))
      {
        this.IKR.ePr();
        AppMethodBeat.o(225023);
        return;
      }
      this.IKR.afH(this.IKR.IKj);
      AppMethodBeat.o(225023);
    }
    
    public final boolean fXa()
    {
      AppMethodBeat.i(225024);
      boolean bool = this.IKR.fZB();
      AppMethodBeat.o(225024);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class am
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final am ILn;
    
    static
    {
      AppMethodBeat.i(225026);
      ILn = new am();
      AppMethodBeat.o(225026);
    }
    
    am()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class an
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    public static final an ILo;
    
    static
    {
      AppMethodBeat.i(225028);
      ILo = new an();
      AppMethodBeat.o(225028);
    }
    
    an()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"})
  public static final class ao
    implements g.b
  {
    public final String fZK()
    {
      AppMethodBeat.i(225029);
      Object localObject = this.IKR.getCurrentUrl();
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() > 0) {}
        for (int i = 1; i == 1; i = 0)
        {
          localObject = this.IKR.getCurrentUrl();
          AppMethodBeat.o(225029);
          return localObject;
        }
      }
      String str = this.IKR.pGj.getUrl();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(225029);
      return localObject;
    }
    
    public final String fZL()
    {
      return this.IKR.IJP;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "QuickAppUrl", "", "[Ljava/lang/String;", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"})
  public static final class b
  {
    public static String bj(Intent paramIntent)
    {
      AppMethodBeat.i(224955);
      kotlin.g.b.p.h(paramIntent, "intent");
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
            AppMethodBeat.o(224955);
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
        AppMethodBeat.o(224955);
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (kotlin.n.n.aL((CharSequence)localObject2)))
      {
        i = 1;
        if (i != 0) {
          break label104;
        }
        AppMethodBeat.o(224955);
        return localObject1;
      }
      return paramIntent;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "getA8keyScene", "", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZI)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getGetA8keyScene", "()I", "setGetA8keyScene", "(I)V", "getNeverGetA8Key", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"})
  public static final class c
  {
    final BaseWebViewController.f IKS;
    final boolean IKT;
    final boolean IKU;
    final boolean IKV;
    final boolean IKW;
    public int IKX;
    
    public c()
    {
      this(null, false, false, false, false, 63);
    }
    
    public c(BaseWebViewController.f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      AppMethodBeat.i(224958);
      this.IKS = paramf;
      this.IKT = paramBoolean1;
      this.IKU = paramBoolean2;
      this.IKV = paramBoolean3;
      this.IKW = paramBoolean4;
      this.IKX = 0;
      AppMethodBeat.o(224958);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"})
  final class d
    extends com.tencent.mm.ui.widget.i
  {
    public final void a(WebView paramWebView, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(224963);
      Object localObject;
      if ((paramInt >= 100) && (!this.IKR.fZD()))
      {
        this.IKR.IKg = true;
        Log.i(BaseWebViewController.a(this.IKR), "Abe-Debug Progress 100");
        localObject = com.tencent.mm.plugin.webview.k.h.JBB;
        localObject = this.IKR.pGj;
        kotlin.g.b.p.h(localObject, "webView");
        if (((MMWebView)localObject).supportFeature(2006)) {
          break label163;
        }
        paramInt = i;
      }
      for (;;)
      {
        if (paramInt != 0)
        {
          localObject = g.ILB;
          if (!g.a.fZQ()) {}
        }
        else
        {
          Log.i(BaseWebViewController.a(this.IKR), "WebView-Trace not support onPageCommitVisible");
          BaseWebViewController localBaseWebViewController1 = this.IKR;
          paramInt = this.IKR.IKv;
          BaseWebViewController localBaseWebViewController2 = this.IKR;
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
        AppMethodBeat.o(224963);
        return;
        label163:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTh, 0) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt == 0) || (!((MMWebView)localObject).gYU()) || (com.tencent.mm.plugin.webview.k.h.g((MMWebView)localObject) > 86)) {
            break label225;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable SysKernel86");
          paramInt = i;
          break;
        }
        label225:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTi, 1) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if ((!((MMWebView)localObject).gYU()) || (paramInt == 0)) {
            break label277;
          }
          Log.i("MicroMsg.WebViewKernelUtil", "WebView-Trace, inject time enable SysKernel");
          paramInt = i;
          break;
        }
        label277:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rTj, 0) == 1) {}
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", "action", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class e
  {
    final kotlin.l.b<? extends BaseWebViewController.WebAction> IKY;
    final kotlin.g.a.a<x> icG;
    
    public e(kotlin.l.b<? extends BaseWebViewController.WebAction> paramb, kotlin.g.a.a<x> parama)
    {
      AppMethodBeat.i(224967);
      this.IKY = paramb;
      this.icG = parama;
      AppMethodBeat.o(224967);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(224970);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!kotlin.g.b.p.j(this.IKY, paramObject.IKY)) || (!kotlin.g.b.p.j(this.icG, paramObject.icG))) {}
        }
      }
      else
      {
        AppMethodBeat.o(224970);
        return true;
      }
      AppMethodBeat.o(224970);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(224969);
      Object localObject = this.IKY;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.icG;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(224969);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(224968);
      String str = "WebEvent(action=" + this.IKY + ", block=" + this.icG + ")";
      AppMethodBeat.o(224968);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"})
  public static final class f
  {
    final kotlin.f IKZ;
    final kotlin.f ILa;
    final kotlin.f ILb;
    final kotlin.f ILc;
    
    public f(Intent paramIntent)
    {
      AppMethodBeat.i(224975);
      this.IKZ = kotlin.g.ah((kotlin.g.a.a)new b(paramIntent));
      this.ILa = kotlin.g.ah((kotlin.g.a.a)new d(paramIntent));
      this.ILb = kotlin.g.ah((kotlin.g.a.a)new a(paramIntent));
      this.ILc = kotlin.g.ah((kotlin.g.a.a)new c(paramIntent));
      AppMethodBeat.o(224975);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      a(Intent paramIntent)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      b(Intent paramIntent)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements kotlin.g.a.a<Boolean>
    {
      c(Intent paramIntent)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.f.c>
  {
    public static final g ILd;
    
    static
    {
      AppMethodBeat.i(224978);
      ILd = new g();
      AppMethodBeat.o(224978);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<x>
  {
    i(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<x>
  {
    o(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<x>
  {
    p(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.f.f<bhj>>
  {
    r(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<Integer>
  {
    s(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(BaseWebViewController paramBaseWebViewController, int paramInt) {}
    
    public final void run()
    {
      int j = 0;
      AppMethodBeat.i(224995);
      if (paramInt < 0) {}
      for (int i = 1; (kotlin.aa.SXc) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(224995);
        throw ((Throwable)localObject);
      }
      Log.i(BaseWebViewController.a(this.IKR), "checkStatus:" + paramInt + " to [" + kotlin.a.j.a((Iterable)BaseWebViewController.c(this.IKR), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.b(this.IKR), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.e(this.IKR), (CharSequence)",", null, null, 0, null, null, 62) + ']');
      BaseWebViewController.c(this.IKR).add(Integer.valueOf(paramInt));
      BaseWebViewController.a(this.IKR, (Iterable)BaseWebViewController.f(this.IKR), (Set)BaseWebViewController.d(this.IKR));
      Object localObject = (CharSequence)this.IKR.IJO;
      if (localObject != null)
      {
        i = j;
        if (!kotlin.n.n.aL((CharSequence)localObject)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        BaseWebViewController.a(this.IKR, (Iterable)BaseWebViewController.g(this.IKR), (Set)BaseWebViewController.e(this.IKR), this.IKR.IJO);
      }
      kotlin.a.j.a((Iterable)BaseWebViewController.a(this.IKR, paramInt), (kotlin.g.a.b)1.ILf);
      AppMethodBeat.o(224995);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(224996);
      Object localObject;
      if (paramInt > 0)
      {
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject)))
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
        if ((!kotlin.aa.SXc) || (i != 0)) {
          break label79;
        }
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(224996);
        throw ((Throwable)localObject);
        i = 0;
        break;
      }
      label79:
      if ((kotlin.g.b.p.j(paramString, this.IKR.IJO)) || ((this.IKR.IKw.contains(Integer.valueOf(paramInt))) && (kotlin.g.b.p.j(paramString, this.IKR.IJQ))) || (this.IKR.IKx.contains(Integer.valueOf(paramInt))))
      {
        Log.i(BaseWebViewController.a(this.IKR), "checkStatus:" + paramInt + ' ' + paramString + " to [" + kotlin.a.j.a((Iterable)BaseWebViewController.c(this.IKR), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.b(this.IKR), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + kotlin.a.j.a((Iterable)BaseWebViewController.e(this.IKR), (CharSequence)",", null, null, 0, null, null, 62) + ']');
        BaseWebViewController.b(this.IKR).add(Integer.valueOf(paramInt));
        BaseWebViewController.a(this.IKR, (Iterable)BaseWebViewController.g(this.IKR), (Set)BaseWebViewController.e(this.IKR), this.IKR.IJO);
        AppMethodBeat.o(224996);
        return;
      }
      Log.w(BaseWebViewController.a(this.IKR), "checkStatus skip: " + paramInt + ", url=" + paramString + ", startUrl=" + this.IKR.IJO);
      AppMethodBeat.o(224996);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<String>
  {
    v(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements kotlin.g.a.a<x>
  {
    w(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class x
    extends q
    implements kotlin.g.a.a<x>
  {
    x(BaseWebViewController paramBaseWebViewController, String paramString, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class y
    extends q
    implements kotlin.g.a.a<MMHandler>
  {
    public static final y ILh;
    
    static
    {
      AppMethodBeat.i(225002);
      ILh = new y();
      AppMethodBeat.o(225002);
    }
    
    y()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"setConfigCallback", "", "windowManager", "Landroid/view/WindowManager;", "invoke"})
  static final class z
    extends q
    implements kotlin.g.a.b<WindowManager, x>
  {
    public static final z ILi;
    
    static
    {
      AppMethodBeat.i(225005);
      ILi = new z();
      AppMethodBeat.o(225005);
    }
    
    z()
    {
      super();
    }
    
    public static void b(WindowManager paramWindowManager)
    {
      AppMethodBeat.i(225004);
      kotlin.g.b.p.h(paramWindowManager, "windowManager");
      try
      {
        Object localObject = WebView.class.getDeclaredField("mWebViewCore");
        kotlin.g.b.p.g(localObject, "WebView::class.java.getD…aredField(\"mWebViewCore\")");
        localObject = ((Field)localObject).getType().getDeclaredField("mBrowserFrame");
        kotlin.g.b.p.g(localObject, "field.type.getDeclaredField(\"mBrowserFrame\")");
        Field localField = ((Field)localObject).getType().getDeclaredField("sConfigCallback");
        kotlin.g.b.p.g(localField, "field.type.getDeclaredField(\"sConfigCallback\")");
        localField.setAccessible(true);
        localObject = localField.get(null);
        if (localObject == null)
        {
          AppMethodBeat.o(225004);
          return;
        }
        localField = localField.getType().getDeclaredField("mWindowManager");
        kotlin.g.b.p.g(localField, "field.type.getDeclaredField(\"mWindowManager\")");
        localField.setAccessible(true);
        localField.set(localObject, paramWindowManager);
        AppMethodBeat.o(225004);
        return;
      }
      catch (Exception paramWindowManager)
      {
        AppMethodBeat.o(225004);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController
 * JD-Core Version:    0.7.0.1
 */