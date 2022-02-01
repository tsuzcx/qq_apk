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
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.plugin.webview.e.c.a;
import com.tencent.mm.plugin.webview.e.g.b;
import com.tencent.mm.plugin.webview.j.e.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import d.a.ak;
import d.g.a.m;
import d.g.b.q;
import d.o;
import d.u;
import d.v;
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
import kotlinx.coroutines.ah;
import kotlinx.coroutines.bk;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_PROGRESS_CACHE_LOAD_START", "getCONTROLLER_PROGRESS_CACHE_LOAD_START", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_PROGRESS_NO_FRAME_AUTH_START", "getPAGE_PROGRESS_NO_FRAME_AUTH_START", "PAGE_PROGRESS_SHOW_TIME_OUT", "getPAGE_PROGRESS_SHOW_TIME_OUT", "PAGE_PROGRESS_STATUS", "getPAGE_PROGRESS_STATUS", "()Ljava/util/Set;", "PAGE_PROGRESS_WEBVIEW_START", "getPAGE_PROGRESS_WEBVIEW_START", "PAGE_SPA_STATUS", "getPAGE_SPA_STATUS", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/concurrent/ConcurrentSkipListSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "hasStartCalled", "getHasStartCalled", "setHasStartCalled", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isInject", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "updateRandomStr", "getUpdateRandomStr", "updateRandomStr$delegate", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", "listener", "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canLoadUrl", "url", "canShowRefresh", "checkStatus", "check", "dealSPAUpdate", "destroy", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", "request", "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCallBackUrl", "getShareUrl", "getStatusListener", "hasStatus", "init", "initEnviroment", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "Lcom/tencent/xweb/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onUrlRedirect", "forceRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeInvoker", "removeStatus", "resetActions", "resetPageActions", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "ProgressBarEnd", "ProgressBarStart", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"})
public abstract class BaseWebViewController
  extends com.tencent.xweb.ac
  implements com.tencent.mm.plugin.webview.e.a<avz>
{
  public static final b DYU = new b((byte)0);
  private final d.f DXT;
  private final d.f DXU;
  public String DXV;
  private final d.f DXW;
  String DXX;
  public String DXY;
  String DXZ;
  final int DYA;
  final int DYB;
  final int DYC;
  final int DYD;
  final Set<Integer> DYE;
  final Set<Integer> DYF;
  private final boolean DYG;
  private final ConcurrentLinkedDeque<o<ControllerAction, d.g.a.a<d.z>>> DYH;
  private final ConcurrentLinkedDeque<o<PageAction, d.g.a.a<d.z>>> DYI;
  private final ConcurrentSkipListSet<Integer> DYJ;
  private final ConcurrentSkipListSet<Integer> DYK;
  private final ConcurrentSkipListSet<String> DYL;
  private final ConcurrentSkipListSet<String> DYM;
  public final boolean DYN;
  c DYO;
  private final d.f DYP;
  private boolean DYQ;
  private final d.f DYR;
  final c DYS;
  private Set<String> DYT;
  protected boolean DYa;
  private boolean DYb;
  public boolean DYc;
  private final d.f DYd;
  private final d.f DYe;
  private final d.f DYf;
  public final Map<String, String> DYg;
  private final d.f DYh;
  public final k DYi;
  public final com.tencent.mm.plugin.webview.j.i DYj;
  final ConcurrentLinkedDeque<j> DYk;
  private final ConcurrentLinkedDeque<e> DYl;
  public final ConcurrentLinkedDeque<i> DYm;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<d.g.a.a<d.z>>> DYn;
  public boolean DYo;
  boolean DYp;
  private final d.f DYq;
  final int DYr;
  public final int DYs;
  public final int DYt;
  protected final int DYu;
  protected final int DYv;
  final int DYw;
  final int DYx;
  final int DYy;
  final int DYz;
  protected String cTb;
  protected Intent intent;
  private final d.f keb;
  public com.tencent.mm.plugin.webview.stub.e lzT;
  public final com.tencent.mm.plugin.webview.e.g lzU;
  public final MMWebView osM;
  private final List<e> osr;
  
  public BaseWebViewController(MMWebView paramMMWebView, c paramc, Set<String> paramSet)
  {
    this.osM = paramMMWebView;
    this.DYS = paramc;
    this.DYT = paramSet;
    this.DXT = d.g.O((d.g.a.a)new a(this));
    this.DXU = d.g.O((d.g.a.a)new q(this));
    this.DXW = d.g.O((d.g.a.a)g.DZg);
    this.cTb = "";
    this.DXX = "";
    this.DXY = "";
    this.DXZ = "";
    this.DYd = d.g.O((d.g.a.a)new aa(this));
    this.DYe = d.g.O((d.g.a.a)new ab(this));
    this.DYf = d.g.O((d.g.a.a)new r(this));
    this.keb = d.g.O((d.g.a.a)x.DZk);
    this.lzU = new com.tencent.mm.plugin.webview.e.g((g.b)new ak(this));
    this.DYg = ((Map)new HashMap());
    this.DYh = d.g.O((d.g.a.a)new ae(this));
    this.DYi = ((k)new af(this));
    this.DYj = new com.tencent.mm.plugin.webview.j.i();
    this.DYk = new ConcurrentLinkedDeque();
    this.DYl = new ConcurrentLinkedDeque();
    this.DYm = new ConcurrentLinkedDeque();
    this.DYn = new ConcurrentHashMap();
    this.DYq = d.g.O((d.g.a.a)new u(this));
    this.DYr = -1;
    this.DYs = -2;
    this.DYt = -3;
    this.DYu = -10;
    this.DYv = -5;
    this.DYw = 1;
    this.DYx = 2;
    this.DYy = 3;
    this.DYz = 4;
    this.DYA = 6;
    this.DYB = 10;
    this.DYC = 11;
    this.DYD = 12;
    this.DYE = ak.setOf(new Integer[] { Integer.valueOf(this.DYC), Integer.valueOf(this.DYD) });
    this.DYF = ak.setOf(new Integer[] { Integer.valueOf(this.DYy), Integer.valueOf(this.DYz), Integer.valueOf(this.DYA) });
    this.DYG = true;
    this.osr = d.a.j.mutableListOf(new e[] { new e(d.g.b.z.bp(Init.class), (d.g.a.a)new h((BaseWebViewController)this)), new e(d.g.b.z.bp(Inject.class), (d.g.a.a)new i(this)), new e(d.g.b.z.bp(Bind.class), (d.g.a.a)new j((BaseWebViewController)this)), new e(d.g.b.z.bp(Auth.class), (d.g.a.a)new k(this)), new e(d.g.b.z.bp(Ready.class), (d.g.a.a)new l(this)), new e(d.g.b.z.bp(Start.class), (d.g.a.a)new m(this)), new e(d.g.b.z.bp(SPAUpdated.class), (d.g.a.a)new n(this)), new e(d.g.b.z.bp(ProgressBarStart.class), (d.g.a.a)new o(this)), new e(d.g.b.z.bp(ProgressBarEnd.class), (d.g.a.a)new p(this)) });
    this.DYH = new ConcurrentLinkedDeque();
    this.DYI = new ConcurrentLinkedDeque();
    this.DYJ = new ConcurrentSkipListSet();
    this.DYK = new ConcurrentSkipListSet();
    this.DYL = new ConcurrentSkipListSet();
    this.DYM = new ConcurrentSkipListSet();
    this.DYN = eQR().eSS();
    this.DYP = d.g.O((d.g.a.a)ai.DZo);
    this.DYR = d.g.O((d.g.a.a)aj.DZp);
  }
  
  private final String OR(String paramString)
  {
    if (!Yy(paramString)) {
      paramString = this.DXY;
    }
    for (;;)
    {
      String str = paramString;
      if (d.n.n.aD((CharSequence)paramString))
      {
        str = paramString;
        if (WZ(this.DYt)) {
          str = bRn();
        }
      }
      return str;
    }
  }
  
  private boolean Xa(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!d.ac.Nhs) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.DYK.remove(Integer.valueOf(paramInt));
    return bool;
  }
  
  private final <T extends WebAction> void a(Iterable<? extends o<? extends T, ? extends d.g.a.a<d.z>>> paramIterable, Set<String> paramSet, String paramString)
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
          com.tencent.mm.sdk.platformtools.ae.i(eQP(), "verify WebAction: " + d.g.b.z.bp(localWebAction.getClass()).getSimpleName() + " start");
          if (!localWebAction.getKeep()) {
            localIterator.remove();
          }
          paramIterable.invoke();
          String str = d.g.b.z.bp(localWebAction.getClass()).getSimpleName();
          paramIterable = str;
          if (str == null) {
            paramIterable = "";
          }
          paramSet.add(paramIterable);
          com.tencent.mm.sdk.platformtools.ae.v(eQP(), "verifyActions: " + d.g.b.z.bp(localWebAction.getClass()).getSimpleName() + " end");
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
  
  private final int aHA(String paramString)
  {
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    while (localIterator.hasNext())
    {
      int i = ((j)localIterator.next()).aHA(paramString);
      if (i != -1) {
        return i;
      }
    }
    return eQR().aJA(paramString);
  }
  
  private final String aHw(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (d.n.n.aD((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!com.tencent.luggage.h.c.a(paramString, "about:blank", true)))
      {
        localObject = paramString;
        if (!com.tencent.luggage.h.c.a(paramString, "data:text/html;charset=utf-8", true)) {}
      }
      else
      {
        localObject = this.cTb;
      }
      return localObject;
    }
  }
  
  private final void aHz(String paramString)
  {
    try
    {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "resetPageActions clear status:" + paramString + ", [" + d.a.j.a((Iterable)this.DYJ, (CharSequence)",", null, null, 0, null, null, 62) + "] actions: [" + d.a.j.a((Iterable)this.DYL, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      this.DYJ.clear();
      this.DYL.clear();
      this.DYI.clear();
      Iterator localIterator = ((Iterable)bRr()).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = d.l.a.c.d(locale.DZb);
        ((WebAction)localObject).setController((BaseWebViewController)this);
        localObject = (WebAction)localObject;
        if ((localObject instanceof PageAction)) {
          this.DYI.add(u.R(localObject, locale.hjJ));
        }
      }
      aHx(paramString);
    }
    finally {}
    this.DXZ = "";
  }
  
  public static final String aY(Intent paramIntent)
  {
    return b.aY(paramIntent);
  }
  
  private final com.tencent.mm.plugin.webview.c.i eQT()
  {
    return (com.tencent.mm.plugin.webview.c.i)this.DYd.getValue();
  }
  
  private final void eQX()
  {
    for (;;)
    {
      e locale;
      Object localObject2;
      try
      {
        com.tencent.mm.sdk.platformtools.ae.i(eQP(), "resetActions");
        this.DYK.clear();
        this.DYM.clear();
        this.DYH.clear();
        this.DYJ.clear();
        this.DYL.clear();
        this.DYI.clear();
        Iterator localIterator = ((Iterable)bRr()).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locale = (e)localIterator.next();
        localObject2 = d.l.a.c.d(locale.DZb);
        ((WebAction)localObject2).setController((BaseWebViewController)this);
        localObject2 = (WebAction)localObject2;
        if ((localObject2 instanceof ControllerAction))
        {
          this.DYH.add(u.R(localObject2, locale.hjJ));
          continue;
        }
        if (!(localObject2 instanceof PageAction)) {
          continue;
        }
      }
      finally {}
      this.DYI.add(u.R(localObject2, locale.hjJ));
    }
  }
  
  private final void m(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (this.DYo) && (paramWebView.canGoBack()))
    {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "clearHistory :".concat(String.valueOf(paramString)));
      paramWebView.clearHistory();
      this.DYo = false;
    }
  }
  
  public final void G(String paramString, Map<String, String> paramMap)
  {
    d.g.b.p.h(paramString, "baseUrl");
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace loadCacheUrl baseUrl ".concat(String.valueOf(paramString)));
    this.cTb = paramString;
    WY(this.DYv);
    this.osM.loadUrl(paramString, paramMap);
    aHy(paramString);
    WY(this.DYu);
    h.MqF.aM((Runnable)new ac(this));
  }
  
  public final ConcurrentLinkedDeque<d.g.a.a<d.z>> WX(int paramInt)
  {
    ConcurrentLinkedDeque localConcurrentLinkedDeque2 = (ConcurrentLinkedDeque)this.DYn.get(Integer.valueOf(paramInt));
    ConcurrentLinkedDeque localConcurrentLinkedDeque1 = localConcurrentLinkedDeque2;
    if (localConcurrentLinkedDeque2 == null)
    {
      localConcurrentLinkedDeque1 = new ConcurrentLinkedDeque();
      ((Map)this.DYn).put(Integer.valueOf(paramInt), localConcurrentLinkedDeque1);
    }
    return localConcurrentLinkedDeque1;
  }
  
  /* Error */
  public final void WY(final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1136	com/tencent/mm/plugin/webview/core/BaseWebViewController:eRb	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 1114	com/tencent/e/h:MqF	Lcom/tencent/e/i;
    //   17: new 118	com/tencent/mm/plugin/webview/core/BaseWebViewController$s
    //   20: dup
    //   21: aload_0
    //   22: iload_1
    //   23: invokespecial 1139	com/tencent/mm/plugin/webview/core/BaseWebViewController$s:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;I)V
    //   26: checkcast 1117	java/lang/Runnable
    //   29: invokeinterface 1123 2 0
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
  
  public final boolean WZ(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!d.ac.Nhs) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.DYK.contains(Integer.valueOf(paramInt));
    return bool;
  }
  
  protected boolean Yx(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    return true;
  }
  
  protected boolean Yy(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    if (!d.n.n.aD((CharSequence)paramString)) {}
    for (int i = 1; (i != 0) && (!d.n.n.nF(paramString, "data:text/html;charset=utf-8")) && (!d.n.n.nF(paramString, "about:blank")) && ((!WZ(this.DYu)) || (!d.n.n.nF(paramString, "https://mp.weixin.qq.com/__tmpl__/"))); i = 0) {
      return true;
    }
    return false;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    d.g.b.p.h(paramWebView, "webview");
    d.g.b.p.h(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, null);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest);
    }
    return localWebResourceResponse1;
  }
  
  public final WebResourceResponse a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    d.g.b.p.h(paramWebView, "webview");
    d.g.b.p.h(paramWebResourceRequest, "request");
    WebResourceResponse localWebResourceResponse2 = b(paramWebView, paramWebResourceRequest, paramBundle);
    WebResourceResponse localWebResourceResponse1 = localWebResourceResponse2;
    if (localWebResourceResponse2 == null) {
      localWebResourceResponse1 = super.a(paramWebView, paramWebResourceRequest, paramBundle);
    }
    return localWebResourceResponse1;
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    d.g.b.p.h(paramString1, "reqUrl");
    d.g.b.p.h(paramString2, "errMsg");
    switch (paramInt1)
    {
    }
    for (;;)
    {
      cx(this.DYx, paramString1);
      Iterator localIterator = ((Iterable)this.DYm).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).d(paramInt1, paramString1, paramInt2, paramString2);
      }
      this.DXV = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, avz paramavz)
  {
    d.g.b.p.h(paramString1, "reqUrl");
    d.g.b.p.h(paramString2, "fullUrl");
    d.g.b.p.h(paramavz, "response");
    com.tencent.mm.sdk.platformtools.ae.d(eQP(), "WebView-Trace onPermissionUpdate:" + paramString1 + ", fullUrl:" + paramString2);
    if (eRb()) {
      com.tencent.mm.sdk.platformtools.ae.d(eQP(), "onPermissionUpdate destroyCalled");
    }
    do
    {
      return;
      this.lzU.a(paramString1, eQR().aJx(paramString1), eQR().aJy(paramString1));
      this.lzU.a(paramString2, eQR().aJx(paramString2), eQR().aJy(paramString2));
      Iterator localIterator = ((Iterable)this.DYm).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).c(paramString1, paramavz);
      }
      cx(this.DYw, paramString1);
      cx(this.DYw, paramString2);
    } while (!d.g.b.p.i(paramString1, this.DXZ));
    cx(this.DYD, paramString1);
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebAction:Ready onPermissionUpdated Patch: " + this.DXZ);
  }
  
  public final void a(e parame)
  {
    d.g.b.p.h(parame, "listener");
    if (!this.DYl.contains(parame)) {
      this.DYl.add(parame);
    }
  }
  
  public final void a(i parami)
  {
    try
    {
      d.g.b.p.h(parami, "listener");
      if (!this.DYm.contains(parami))
      {
        BaseWebViewController localBaseWebViewController = (BaseWebViewController)this;
        d.g.b.p.h(localBaseWebViewController, "<set-?>");
        parami.controller = localBaseWebViewController;
        this.DYm.add(parami);
        if (this.DYM.contains(d.g.b.z.bp(Bind.class).getSimpleName()))
        {
          com.tencent.mm.sdk.platformtools.ae.i(eQP(), "Abe-Debug Patch Call onBind");
          parami.eag();
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
    d.g.b.p.h(paramj, "interceptor");
    this.DYk.add(paramj);
    Object localObject = paramj.eRA();
    if (localObject != null) {
      a((e)localObject);
    }
    localObject = paramj.eRB();
    if (localObject != null) {
      a((i)localObject);
    }
    paramj.k(this);
  }
  
  public void a(com.tencent.mm.plugin.webview.stub.e parame) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (!WZ(this.DYt)) {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "onReceivedError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.DYl).iterator();
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
    if (!WZ(this.DYt)) {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "onReceivedHttpError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.DYl).iterator();
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
    d.g.b.p.h(paramj, "handler");
    super.a(paramWebView, paramj, paramString1, paramString2);
    com.tencent.mm.plugin.report.service.g.yxI.n(155L, 35L, 1L);
  }
  
  public void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    super.a(paramWebView, paramr, paramSslError);
    if (!WZ(this.DYt)) {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "onReceivedSslError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.DYl).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.a(paramWebView, paramr, paramSslError);
        }
      }
    }
  }
  
  protected boolean a(int paramInt, String paramString, avz paramavz)
  {
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavz, "resp");
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).d(paramString, paramavz)) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    boolean bool2 = true;
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "shouldOverrideUrlLoading: ".concat(String.valueOf(paramString)));
    com.tencent.mm.sdk.platformtools.ae.d(eQP(), "doShouldOverrideUrlLoading url:".concat(String.valueOf(paramString)));
    boolean bool1;
    if (l(paramWebView, paramString))
    {
      bool1 = bool2;
      if (!bool1) {
        this.DXV = paramString;
      }
      return bool1;
    }
    label150:
    if (aHA(paramString) == 2)
    {
      bool1 = true;
      label89:
      if (aI(paramString, bool1))
      {
        if (this.DYS.DZa) {
          break label181;
        }
        switch (aHA(paramString))
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
  
  public final boolean aHB(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    if (com.tencent.mm.platformtools.ac.iRE)
    {
      com.tencent.mm.sdk.platformtools.ae.w(eQP(), "skipLoadUrlCheck");
      return true;
    }
    if (this.DYS.DYX)
    {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "file://", true))
    {
      Iterator localIterator = ((Iterable)eQQ()).iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.luggage.h.c.a(paramString, (String)localIterator.next(), true)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  protected final boolean aHC(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    if (!aHB(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.f(eQP(), "forceQuitOnUrlForbidden, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = ((Iterable)this.DYm).iterator();
      while (paramString.hasNext()) {
        ((i)paramString.next()).eRw();
      }
      return true;
    }
    return false;
  }
  
  protected final void aHx(String paramString)
  {
    d.g.b.p.h(paramString, "value");
    if (Yx(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.d(eQP(), "WebView-Trace startUrl:".concat(String.valueOf(paramString)));
      this.DXX = paramString;
    }
  }
  
  protected final void aHy(String paramString)
  {
    d.g.b.p.h(paramString, "value");
    if (Yy(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.d(eQP(), "WebView-Trace commitUrl:".concat(String.valueOf(paramString)));
      this.DXY = paramString;
    }
  }
  
  protected boolean aI(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    d.g.b.p.h(paramString, "url");
    if (a(this, paramString, paramBoolean, 0, 4) == c.a.EoV) {
      bool = true;
    }
    return bool;
  }
  
  public final String aKS()
  {
    return eQR().aJe(getCurrentUrl());
  }
  
  public final aq aPI()
  {
    return (aq)this.keb.getValue();
  }
  
  public final void au(Intent paramIntent)
  {
    d.g.b.p.h(paramIntent, "intent");
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "start");
    this.DYa = true;
    this.intent = paramIntent;
    com.tencent.mm.plugin.webview.e.g localg = this.lzU;
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
    this.DYj.ELW = paramIntent.getLongExtra("startTime", 0L);
    kotlinx.coroutines.f.b((ah)bk.OfO, null, (m)new ag(this, null), 3);
  }
  
  protected WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramWebResourceRequest, "request");
    h.MqF.aO((Runnable)new z(paramWebResourceRequest, this));
    Object localObject = paramWebResourceRequest.getUrl().toString();
    d.g.b.p.g(localObject, "request.url.toString()");
    if (aHC((String)localObject)) {
      return null;
    }
    if ((com.tencent.mm.cp.d.kW(getContext())) && (paramBundle != null)) {}
    try
    {
      int i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        com.tencent.mm.sdk.platformtools.ae.i(eQP(), "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        paramBundle = paramWebResourceRequest.getUrl().toString();
        d.g.b.p.g(paramBundle, "request.url.toString()");
        k(paramBundle, false, 5);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.w(eQP(), "get resource type failed Exception ; " + paramBundle.getMessage());
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.w(eQP(), "get resource type failed Throwable ; " + paramBundle.getMessage());
      }
    }
    paramBundle = ((Iterable)this.DYk).iterator();
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
    if (eRb())
    {
      com.tencent.mm.sdk.platformtools.ae.w(eQP(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = OR(str);
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace onPageFinished: " + paramString + ", callbackUrl:" + str);
      if (((paramWebView == null) || (paramWebView.supportFeature(2006) != true)) && (this.DYp)) {
        aHy(str);
      }
      super.b(paramWebView, paramString);
      if ((!this.DYJ.contains(Integer.valueOf(this.DYB))) && (!bRx()))
      {
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1200L, 104L, 1L, false);
        com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
      }
      cx(this.DYC, aHw(paramString));
      Iterator localIterator = ((Iterable)this.DYl).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.b(paramWebView, str);
        }
      }
      m(paramWebView, paramString);
      return;
    }
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    if (eRb())
    {
      com.tencent.mm.sdk.platformtools.ae.w(eQP(), "ActivityFinished");
      return;
    }
    cx(this.DYy, paramString);
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace onPageStarted: ".concat(String.valueOf(paramString)));
    this.DYp = false;
    this.DXV = paramString;
    aHz(paramString);
    Iterator localIterator = ((Iterable)this.DYl).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (isStarted()) {
        locale.aHE(OR(paramString));
      }
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace doUpdateVisitedHistory, url = " + paramString + ", wvUrl = " + paramWebView.getUrl() + ", isReload = " + paramBoolean);
    if (d.n.n.nF(paramString, "data:text/html;charset=utf-8"))
    {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "url starts with data:text, url : ".concat(String.valueOf(paramString)));
      return;
    }
    if ((com.tencent.luggage.h.c.A(paramString, "about:blank")) || (com.tencent.luggage.h.c.A(paramString, "file:///android_asset/")))
    {
      com.tencent.mm.sdk.platformtools.ae.e(eQP(), "doUpdateVisitedHistory, url is invalid");
      return;
    }
    if ((WZ(this.DYu)) && (com.tencent.luggage.h.c.A(paramString, "https://mp.weixin.qq.com/__tmpl__/")))
    {
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "doUpdateVisitedHistory, url is HARDCODE_URL");
      return;
    }
    super.b(paramWebView, paramString, paramBoolean);
    if (((Boolean)this.DYR.getValue()).booleanValue()) {
      paramString = paramWebView.getUrl();
    }
    d.g.b.p.g(paramString, "url");
    if (!d.g.b.p.i(this.DXX, paramString))
    {
      if (this.lzU.has(paramString)) {
        cx(this.DYD, paramString);
      }
      this.DXZ = paramString;
    }
    if (!this.DYS.DZa) {
      aI(paramString, false);
    }
    this.DXV = paramString;
    Iterator localIterator = ((Iterable)this.DYl).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (isStarted()) {
        locale.aHF(paramString);
      }
    }
    m(paramWebView, paramString);
  }
  
  public boolean b(int paramInt, String paramString, avz paramavz)
  {
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavz, "response");
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(paramInt)));
    this.osM.setA8keyReason(paramInt);
    Object localObject1 = this.DYg;
    ((Map)localObject1).clear();
    Object localObject2 = paramavz.GNl;
    d.g.b.p.g(localObject2, "response.HttpHeader");
    int i;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      localObject2 = com.tencent.mm.plugin.webview.e.c.he((List)paramavz.GNl);
      d.g.b.p.g(localObject2, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      ((Map)localObject1).putAll((Map)localObject2);
    }
    label134:
    label327:
    label459:
    for (;;)
    {
      if (!a(paramInt, paramString, paramavz)) {
        break label461;
      }
      return true;
      i = 0;
      break;
      localObject2 = this.intent;
      if (localObject2 == null) {
        d.g.b.p.bdF("intent");
      }
      if (((Intent)localObject2).getBooleanExtra("k_has_http_header", false))
      {
        com.tencent.mm.sdk.platformtools.ae.i(eQP(), "use intent httpheader info");
        localObject2 = this.intent;
        if (localObject2 == null) {
          d.g.b.p.bdF("intent");
        }
        localObject2 = ((Intent)localObject2).getStringArrayExtra("geta8key_result_http_header_key_list");
        Object localObject3 = this.intent;
        if (localObject3 == null) {
          d.g.b.p.bdF("intent");
        }
        localObject3 = ((Intent)localObject3).getStringArrayExtra("geta8key_result_http_header_value_list");
        Intent localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.p.bdF("intent");
        }
        localIntent.putExtra("k_has_http_header", false);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.p.bdF("intent");
        }
        localIntent.putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.p.bdF("intent");
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
              d.g.b.p.g(localIntent, "httpHeaderKey[i]");
              Object localObject4 = localObject3[i];
              d.g.b.p.g(localObject4, "httpHeaderValue[i]");
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
    localObject1 = ((Iterable)this.DYm).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((i)((Iterator)localObject1).next()).b(paramString, paramavz);
    }
    return false;
  }
  
  public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    d.g.b.p.h(paramWebView, "webview");
    d.g.b.p.h(paramString1, "description");
    d.g.b.p.h(paramString2, "failingUrl");
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).c(paramWebView, paramInt, paramString1, paramString2);
    }
    return super.b(paramWebView, paramInt, paramString1, paramString2);
  }
  
  protected abstract Class<? extends Service> bPH();
  
  public String bRn()
  {
    try
    {
      Object localObject = this.intent;
      if (localObject == null) {
        d.g.b.p.bdF("intent");
      }
      localObject = b.aY((Intent)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e(eQP(), String.valueOf(localException.getMessage()));
      onFinish();
    }
    return "";
  }
  
  protected boolean bRo()
  {
    return this.DYG;
  }
  
  protected boolean bRp()
  {
    return false;
  }
  
  protected boolean bRq()
  {
    return false;
  }
  
  protected List<e> bRr()
  {
    return this.osr;
  }
  
  protected void bRs()
  {
    a((j)new com.tencent.mm.plugin.webview.f.a());
    a((j)new com.tencent.mm.plugin.webview.k.e());
    this.osM.setWebViewClient((com.tencent.xweb.ac)this);
    MMWebView localMMWebView = this.osM;
    Object localObject1 = y.DZl;
    com.tencent.mm.plugin.webview.j.j.g(localMMWebView);
    com.tencent.xweb.z localz = localMMWebView.getSettings();
    localz.setJavaScriptEnabled(((Boolean)this.DYS.DYW.DZe.getValue()).booleanValue());
    localz.setPluginsEnabled(((Boolean)this.DYS.DYW.DZc.getValue()).booleanValue());
    localz.gfD();
    localz.setBuiltInZoomControls(((Boolean)this.DYS.DYW.DZd.getValue()).booleanValue());
    localz.setUseWideViewPort(true);
    localz.setLoadWithOverviewMode(true);
    localz.gfw();
    localz.gfv();
    localz.setGeolocationEnabled(true);
    localz.setJavaScriptCanOpenWindowsAutomatically(true);
    localz.gfF();
    localz.gfB();
    localObject1 = localMMWebView.getContext().getDir("webviewcache", 0);
    d.g.b.p.g(localObject1, "context.getDir(\"webviewc…e\", Context.MODE_PRIVATE)");
    localz.setAppCachePath(((File)localObject1).getAbsolutePath());
    localz.gfA();
    localz.gfC();
    localz.setDatabasePath(com.tencent.mm.loader.j.b.asa() + "databases/");
    String str = localz.getUserAgentString();
    d.g.b.p.g(str, "currentUa");
    Object localObject2;
    if (!d.n.n.f((CharSequence)str, (CharSequence)" MicroMessenger/"))
    {
      localObject2 = (p.a)com.tencent.luggage.a.e.K(p.a.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (p.a)new com.tencent.mm.plugin.appbrand.luggage.b.f(localMMWebView.getContext());
      }
      localObject2 = com.tencent.mm.plugin.webview.j.e.ELF;
      d.g.b.p.h(str, "prefix");
      e.a.bOc().putString("key_web_prefetch_ua", str);
      localz.setUserAgentString(com.tencent.mm.plugin.appbrand.y.p.a(localMMWebView.getContext(), str, (p.a)localObject1));
    }
    if (!((Boolean)this.DYS.DYW.DZf.getValue()).booleanValue())
    {
      localMMWebView.setVerticalScrollBarEnabled(false);
      localMMWebView.setHorizontalScrollBarEnabled(false);
    }
    com.tencent.xweb.c.geY().geZ();
    com.tencent.xweb.c.geY().e((WebView)localMMWebView);
    localObject1 = y.DZl;
    localObject1 = localMMWebView.getContext().getSystemService("window");
    if (localObject1 == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    y.b((WindowManager)localObject1);
    if (this.osM.fPW())
    {
      localObject2 = this.osM.getUrl();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      aHy((String)localObject1);
    }
    this.DYj.bM("onTryBindServiceStart", System.currentTimeMillis());
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace tryBindService");
    localObject1 = l.EaP;
    l.a(true, bPH(), (d)new ah(this));
    this.DYj.bM("onTryBindServiceEnd", System.currentTimeMillis());
  }
  
  protected void bRt() {}
  
  protected boolean bRu()
  {
    return true;
  }
  
  public boolean bRx()
  {
    return (WZ(this.DYu)) && (d.g.b.p.i(this.cTb, this.DXY));
  }
  
  protected void bSg()
  {
    if (!this.DYQ)
    {
      eRe();
      this.DYQ = true;
    }
    Iterator localIterator = ((Iterable)this.DYm).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bSg();
    }
  }
  
  public final void bl(int paramInt, String paramString)
  {
    d.g.b.p.h(paramString, "reqUrl");
    this.DYj.bM("getA8KeyEnd", System.currentTimeMillis());
    Iterator localIterator = ((Iterable)this.DYm).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).aHN(paramString);
    }
  }
  
  public final void bm(final int paramInt, final String paramString)
  {
    d.g.b.p.h(paramString, "reqUrl");
    this.DYj.bM("getA8KeyStart", System.currentTimeMillis());
    if (paramInt != 5) {
      cx(this.DYz, paramString);
    }
    if ((d.g.b.p.i(this.DXZ, paramString) ^ true)) {
      h.MqF.aM((Runnable)new ad(this, paramInt, paramString));
    }
  }
  
  /* Error */
  protected final void cx(final int paramInt, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ldc_w 1144
    //   6: invokestatic 606	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 1136	com/tencent/mm/plugin/webview/core/BaseWebViewController:eRb	()Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: getstatic 1114	com/tencent/e/h:MqF	Lcom/tencent/e/i;
    //   24: new 122	com/tencent/mm/plugin/webview/core/BaseWebViewController$t
    //   27: dup
    //   28: aload_0
    //   29: iload_1
    //   30: aload_2
    //   31: invokespecial 1892	com/tencent/mm/plugin/webview/core/BaseWebViewController$t:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;ILjava/lang/String;)V
    //   34: checkcast 1117	java/lang/Runnable
    //   37: invokeinterface 1123 2 0
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
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramWebResourceRequest, "request");
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramWebResourceRequest, "request");
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    j.a locala;
    while (localIterator.hasNext())
    {
      locala = ((j)localIterator.next()).c(paramWebView, paramWebResourceRequest);
      if (locala.EaN) {
        if (!locala.EaN) {
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
    com.tencent.mm.ac.c.h((d.g.a.a)new v(this));
  }
  
  public final void e(WebView paramWebView, String paramString)
  {
    if (eRb())
    {
      com.tencent.mm.sdk.platformtools.ae.w(eQP(), "ActivityFinished");
      return;
    }
    Object localObject1 = getJsapi();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject1).ePd();
    }
    if ((((Boolean)this.DYP.getValue()).booleanValue()) && (!this.osM.fPW()) && (!WZ(this.DYu)) && (paramString != null) && (!d.n.n.nF(paramString, "file:")))
    {
      localObject1 = getJsapi();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject1).eSi();
      }
    }
    if (paramString == null) {}
    for (localObject1 = "";; localObject1 = paramString)
    {
      localObject1 = OR((String)localObject1);
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace onPageCommitVisible: " + paramString + ", callbackUrl:" + (String)localObject1);
      aHy((String)localObject1);
      super.e(paramWebView, paramString);
      Object localObject2 = f.DZr;
      if (!f.a.eRl()) {
        cx(this.DYB, aHw(paramString));
      }
      for (;;)
      {
        localObject2 = ((Iterable)this.DYl).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          e locale = (e)((Iterator)localObject2).next();
          if (isStarted()) {
            locale.e(paramWebView, (String)localObject1);
          }
        }
        com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView Page Commit Mock Enabled");
      }
      m(paramWebView, paramString);
      return;
    }
  }
  
  public final String eQP()
  {
    return (String)this.DXT.getValue();
  }
  
  protected abstract Set<String> eQQ();
  
  public final com.tencent.mm.plugin.webview.e.c eQR()
  {
    return (com.tencent.mm.plugin.webview.e.c)this.DXW.getValue();
  }
  
  public final com.tencent.mm.plugin.webview.stub.e eQS()
  {
    com.tencent.mm.plugin.webview.stub.e locale = this.lzT;
    if (locale == null) {
      d.g.b.p.bdF("invoker");
    }
    return locale;
  }
  
  public final int eQU()
  {
    return ((Number)this.DYf.getValue()).intValue();
  }
  
  public final Runnable eQV()
  {
    return (Runnable)this.DYh.getValue();
  }
  
  public final String eQW()
  {
    return (String)this.DYq.getValue();
  }
  
  protected final boolean eQY()
  {
    try
    {
      boolean bool = this.DYL.contains(d.g.b.z.bp(Inject.class).getSimpleName());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void eQZ() {}
  
  public boolean eRa()
  {
    return false;
  }
  
  public final boolean eRb()
  {
    return (this.DYc) || (this.DYb);
  }
  
  public final void eRc()
  {
    try
    {
      com.tencent.mm.plugin.webview.stub.e locale = this.lzT;
      if (locale == null) {
        d.g.b.p.bdF("invoker");
      }
      if (locale != null)
      {
        locale = this.lzT;
        if (locale == null) {
          d.g.b.p.bdF("invoker");
        }
        locale.XQ(eQU());
        locale = this.lzT;
        if (locale == null) {
          d.g.b.p.bdF("invoker");
        }
        locale.XR(eQU());
      }
      com.tencent.mm.sdk.platformtools.ae.i(eQP(), "removeInvoker ok");
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.w(eQP(), "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException)));
    }
  }
  
  public final boolean eRd()
  {
    try
    {
      Xa(this.DYv);
      boolean bool = Xa(this.DYu);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void eRe() {}
  
  protected void eRf() {}
  
  public final boolean eRg()
  {
    return !WZ(this.DYu);
  }
  
  protected void eag() {}
  
  protected final Context getContext()
  {
    Context localContext = this.osM.getContext();
    d.g.b.p.g(localContext, "viewWV.context");
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    if (d.n.n.aD((CharSequence)this.DXZ)) {
      return this.DXY;
    }
    return this.DXZ;
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = this.intent;
    if (localIntent == null) {
      d.g.b.p.bdF("intent");
    }
    return localIntent;
  }
  
  public final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    return (com.tencent.mm.plugin.webview.c.f)this.DYe.getValue();
  }
  
  protected final int getScreenOrientation()
  {
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (localj.getScreenOrientation() != -1) {
        return localj.getScreenOrientation();
      }
    }
    return -1;
  }
  
  public final void h(final String paramString, final d.g.a.b<? super String, d.z> paramb)
  {
    d.g.b.p.h(paramString, "script");
    com.tencent.mm.ac.c.h((d.g.a.a)new w(this, paramString, paramb));
  }
  
  public final void init()
  {
    eQX();
    WY(this.DYr);
    this.osM.a((com.tencent.mm.ui.widget.i)new d());
  }
  
  protected final boolean isStarted()
  {
    try
    {
      boolean bool = this.DYM.contains(d.g.b.z.bp(Start.class).getSimpleName());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final j.a k(WebView paramWebView, String paramString)
  {
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramString, "url");
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    while (localIterator.hasNext())
    {
      j.a locala = ((j)localIterator.next()).n(paramWebView, paramString);
      if (locala.EaN) {
        return locala;
      }
    }
    return new j.a(false, false);
  }
  
  public final c.a k(String paramString, boolean paramBoolean, int paramInt)
  {
    d.g.b.p.h(paramString, "url");
    if (this.DYS.DZa)
    {
      com.tencent.mm.sdk.platformtools.ae.w(eQP(), "startGetA8Key neverGetA8Key ".concat(String.valueOf(paramString)));
      return c.a.EoU;
    }
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).aHP(paramString)) {
        return c.a.EoT;
      }
    }
    paramString = eQR().a(paramString, paramBoolean, paramInt, (com.tencent.mm.plugin.webview.e.a)this.DXU.getValue());
    d.g.b.p.g(paramString, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
    return paramString;
  }
  
  protected boolean l(WebView paramWebView, String paramString)
  {
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramString, "url");
    paramWebView = k(paramWebView, paramString);
    if (paramWebView.EaN) {
      return paramWebView.result;
    }
    return false;
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    d.g.b.p.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "WebView-Trace loadUrl url ".concat(String.valueOf(paramString)));
    if (paramBoolean)
    {
      this.osM.loadUrl(paramString, (Map)d.a.ae.c(new o[] { u.R("Pragma", "no-cache"), u.R("Cache-Control", "no-cache") }));
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    if (i != 0)
    {
      this.osM.loadUrl(paramString);
      return;
    }
    this.osM.loadUrl(paramString, paramMap);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 1966	com/tencent/mm/plugin/webview/core/BaseWebViewController:DYb	Z
    //   7: aload_0
    //   8: getfield 1964	com/tencent/mm/plugin/webview/core/BaseWebViewController:DYc	Z
    //   11: ifne +7 -> 18
    //   14: aload_0
    //   15: invokevirtual 2045	com/tencent/mm/plugin/webview/core/BaseWebViewController:eRc	()V
    //   18: aload_0
    //   19: getfield 2047	com/tencent/mm/plugin/webview/core/BaseWebViewController:DYO	Lcom/tencent/mm/plugin/webview/core/c;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +27 -> 51
    //   27: aload_1
    //   28: checkcast 2049	java/io/Closeable
    //   31: astore_3
    //   32: aload_0
    //   33: invokevirtual 872	com/tencent/mm/plugin/webview/core/BaseWebViewController:eQP	()Ljava/lang/String;
    //   36: ldc_w 2051
    //   39: invokestatic 944	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 2057	d/z:Nhr	Ld/z;
    //   45: astore_1
    //   46: aload_3
    //   47: aconst_null
    //   48: invokestatic 2062	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   51: aload_0
    //   52: invokevirtual 2064	com/tencent/mm/plugin/webview/core/BaseWebViewController:aPI	()Lcom/tencent/mm/sdk/platformtools/aq;
    //   55: aload_0
    //   56: invokevirtual 2066	com/tencent/mm/plugin/webview/core/BaseWebViewController:eQV	()Ljava/lang/Runnable;
    //   59: invokevirtual 2069	com/tencent/mm/sdk/platformtools/aq:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   62: aload_0
    //   63: invokevirtual 1918	com/tencent/mm/plugin/webview/core/BaseWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   66: invokevirtual 2072	com/tencent/mm/plugin/webview/c/f:detach	()V
    //   69: aload_0
    //   70: invokespecial 1065	com/tencent/mm/plugin/webview/core/BaseWebViewController:eQT	()Lcom/tencent/mm/plugin/webview/c/i;
    //   73: invokevirtual 2073	com/tencent/mm/plugin/webview/c/i:detach	()V
    //   76: aload_0
    //   77: invokevirtual 797	com/tencent/mm/plugin/webview/core/BaseWebViewController:eQR	()Lcom/tencent/mm/plugin/webview/e/c;
    //   80: invokevirtual 2075	com/tencent/mm/plugin/webview/e/c:destroy	()V
    //   83: return
    //   84: astore_2
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_3
    //   89: aload_2
    //   90: invokestatic 2062	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    Iterator localIterator = ((Iterable)this.DYm).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onFinish();
    }
  }
  
  public final void reload()
  {
    if ((this.osM == null) || (bu.isNullOrNil(this.osM.getUrl()))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      String str = this.osM.getUrl();
      d.g.b.p.g(str, "viewWV.url");
      if (localj.YE(OR(str))) {
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i(eQP(), "reload");
    this.osM.reload();
  }
  
  protected final void setIntent(Intent paramIntent)
  {
    d.g.b.p.h(paramIntent, "<set-?>");
    this.intent = paramIntent;
  }
  
  protected final void vb(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.DYm).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).vb(paramBoolean);
    }
  }
  
  public final void z(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString1 = this.osM.getSettings();
      if (paramString1 != null) {
        paramString1.setJavaScriptEnabled(false);
      }
      this.osM.loadData(paramString2, "text/html", "utf-8");
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Auth
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214044);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(d.g.b.z.bp(BaseWebViewController.Inject.class), paramString)) && (waitFor(localBaseWebViewController.DYs)) && ((localBaseWebViewController.DYS.DZa) || (localBaseWebViewController.lzU.has(paramString)) || (waitFor(localBaseWebViewController.DYw, paramString))))
      {
        AppMethodBeat.o(214044);
        return true;
      }
      AppMethodBeat.o(214044);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Bind
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(214046);
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(localBaseWebViewController.DYt)) && (waitFor(localBaseWebViewController.DYs)))
      {
        AppMethodBeat.o(214046);
        return true;
      }
      AppMethodBeat.o(214046);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  public static abstract class ControllerAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify();
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Init
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(214048);
      boolean bool = waitFor(getController().DYr);
      AppMethodBeat.o(214048);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Inject
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214049);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((!localBaseWebViewController.osM.fPW()) && (!waitFor(localBaseWebViewController.DYB, paramString))) || (((waitFor(localBaseWebViewController.DYs)) && ((localBaseWebViewController.DYS.DZa) || (localBaseWebViewController.lzU.has(paramString)) || (waitFor(localBaseWebViewController.DYw, paramString)))) || (localBaseWebViewController.bRp())))
      {
        AppMethodBeat.o(214049);
        return true;
      }
      AppMethodBeat.o(214049);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"})
  @Keep
  protected static abstract class PageAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify(String paramString);
    
    public final boolean waitFor(int paramInt, String paramString)
    {
      d.g.b.p.h(paramString, "url");
      return ((d.g.b.p.i(paramString, getController().DXX)) || (getController().DYF.contains(Integer.valueOf(paramInt)))) && (BaseWebViewController.b(getController()).contains(Integer.valueOf(paramInt)));
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarEnd;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarEnd
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214052);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((localBaseWebViewController.bRo()) && ((localBaseWebViewController.bRq()) || (waitFor(d.g.b.z.bp(BaseWebViewController.Ready.class), paramString)) || (waitFor(localBaseWebViewController.DYC, paramString)) || (waitFor(localBaseWebViewController.DYB, paramString)) || (waitFor(localBaseWebViewController.DYx, paramString))))
      {
        AppMethodBeat.o(214052);
        return true;
      }
      AppMethodBeat.o(214052);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarStart;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarStart
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214053);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(d.g.b.z.bp(BaseWebViewController.Start.class))) && (((!localBaseWebViewController.WZ(localBaseWebViewController.DYv)) && ((waitFor(localBaseWebViewController.DYz, paramString)) || (waitFor(localBaseWebViewController.DYy, paramString)))) || ((!waitFor(d.g.b.z.bp(BaseWebViewController.ProgressBarEnd.class), paramString)) && (localBaseWebViewController.WZ(localBaseWebViewController.DYv)) && (waitFor(localBaseWebViewController.DYA, paramString)))))
      {
        AppMethodBeat.o(214053);
        return true;
      }
      AppMethodBeat.o(214053);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Ready
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214055);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((waitFor(d.g.b.z.bp(BaseWebViewController.Start.class))) && (waitFor(d.g.b.z.bp(BaseWebViewController.Auth.class), paramString)) && ((waitFor(localBaseWebViewController.DYC, paramString)) || (localBaseWebViewController.osM.fPW()))) || (localBaseWebViewController.bRq()))
      {
        AppMethodBeat.o(214055);
        return true;
      }
      AppMethodBeat.o(214055);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"})
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
      AppMethodBeat.i(214056);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(d.g.b.z.bp(BaseWebViewController.Ready.class), paramString)) && (waitFor(localBaseWebViewController.DYD, paramString)))
      {
        AppMethodBeat.o(214056);
        return true;
      }
      AppMethodBeat.o(214056);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Start
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(214057);
      Object localObject = getController();
      if ((waitFor(((BaseWebViewController)localObject).DYt)) && ((!((BaseWebViewController)localObject).bRu()) || (waitFor(((BaseWebViewController)localObject).DYs))))
      {
        if (((CharSequence)((BaseWebViewController)localObject).bRn()).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            localObject = (CharSequence)((BaseWebViewController)localObject).eQW();
            if ((localObject != null) && (!d.n.n.aD((CharSequence)localObject))) {
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
          AppMethodBeat.o(214057);
          return true;
          i = 0;
          break;
        }
      }
      label102:
      AppMethodBeat.o(214057);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"})
  @Keep
  public static abstract class WebAction
  {
    public BaseWebViewController controller;
    private final boolean keep;
    
    public final BaseWebViewController getController()
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.p.bdF("controller");
      }
      return localBaseWebViewController;
    }
    
    public boolean getKeep()
    {
      return this.keep;
    }
    
    public final void setController(BaseWebViewController paramBaseWebViewController)
    {
      d.g.b.p.h(paramBaseWebViewController, "<set-?>");
      this.controller = paramBaseWebViewController;
    }
    
    public final boolean waitFor(int paramInt)
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.p.bdF("controller");
      }
      return BaseWebViewController.c(localBaseWebViewController).contains(Integer.valueOf(paramInt));
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.ControllerAction> paramb)
    {
      d.g.b.p.h(paramb, "clazz");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.p.bdF("controller");
      }
      return BaseWebViewController.d(localBaseWebViewController).contains(paramb.getSimpleName());
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.PageAction> paramb, String paramString)
    {
      d.g.b.p.h(paramb, "clazz");
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.p.bdF("controller");
      }
      if (d.g.b.p.i(paramString, localBaseWebViewController.DXX))
      {
        paramString = this.controller;
        if (paramString == null) {
          d.g.b.p.bdF("controller");
        }
        if (BaseWebViewController.e(paramString).contains(paramb.getSimpleName())) {
          return true;
        }
      }
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<String>
  {
    a(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "invoke"})
  static final class aa
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.i>
  {
    aa(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "invoke"})
  static final class ab
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.f>
  {
    ab(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class ac
    implements Runnable
  {
    ac(BaseWebViewController paramBaseWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(214099);
      this.DYV.aPI().postUIDelayed(this.DYV.eQV(), 500L);
      AppMethodBeat.o(214099);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class ad
    implements Runnable
  {
    ad(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(214100);
      Iterator localIterator = ((Iterable)this.DYV.DYm).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).bm(paramInt, paramString);
      }
      AppMethodBeat.o(214100);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
  static final class ae
    extends q
    implements d.g.a.a<Runnable>
  {
    ae(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"})
  public static final class af
    extends k
  {
    public final void CN(long paramLong)
    {
      AppMethodBeat.i(214103);
      this.DYV.aPI().postDelayed(this.DYV.eQV(), paramLong);
      AppMethodBeat.o(214103);
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.webview.core.BaseWebViewController$start$1", f="BaseWebViewController.kt", gkn={}, m="invokeSuspend")
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class ag
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    int label;
    private ah ocz;
    
    ag(BaseWebViewController paramBaseWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(214105);
      d.g.b.p.h(paramd, "completion");
      paramd = new ag(this.DYV, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(214105);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(214104);
      paramObject = d.d.a.a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(214104);
        throw paramObject;
      }
      this.DYV.WY(this.DYV.DYt);
      paramObject = d.z.Nhr;
      AppMethodBeat.o(214104);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(214106);
      paramObject1 = ((ag)a(paramObject1, (d.d.d)paramObject2)).cR(d.z.Nhr);
      AppMethodBeat.o(214106);
      return paramObject1;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/BaseWebViewController$tryBindService$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class ah
    implements d
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(214107);
      d.g.b.p.h(paramc, "conn");
      if (this.DYV.eRb())
      {
        com.tencent.mm.sdk.platformtools.ae.i(BaseWebViewController.a(this.DYV), "WebView-Trace onConnected whent destroyCalled");
        AppMethodBeat.o(214107);
        return;
      }
      this.DYV.DYO = paramc;
      BaseWebViewController localBaseWebViewController = this.DYV;
      paramc = paramc.eQS();
      d.g.b.p.h(paramc, "<set-?>");
      localBaseWebViewController.lzT = paramc;
      this.DYV.getJsapi().b(this.DYV.eQS());
      this.DYV.a(this.DYV.eQS());
      com.tencent.mm.sdk.platformtools.ae.i(BaseWebViewController.a(this.DYV), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
      if (BaseWebViewController.d(this.DYV).contains(d.g.b.z.bp(BaseWebViewController.Bind.class).getSimpleName()))
      {
        this.DYV.eag();
        AppMethodBeat.o(214107);
        return;
      }
      this.DYV.WY(this.DYV.DYs);
      AppMethodBeat.o(214107);
    }
    
    public final boolean ePi()
    {
      AppMethodBeat.i(214108);
      boolean bool = this.DYV.eRa();
      AppMethodBeat.o(214108);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class ai
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final ai DZo;
    
    static
    {
      AppMethodBeat.i(214110);
      DZo = new ai();
      AppMethodBeat.o(214110);
    }
    
    ai()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class aj
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final aj DZp;
    
    static
    {
      AppMethodBeat.i(214112);
      DZp = new aj();
      AppMethodBeat.o(214112);
    }
    
    aj()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"})
  public static final class ak
    implements g.b
  {
    public final String eRh()
    {
      AppMethodBeat.i(214113);
      String str = this.DYV.getCurrentUrl();
      AppMethodBeat.o(214113);
      return str;
    }
    
    public final String eRi()
    {
      return this.DYV.DXY;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"})
  public static final class b
  {
    public static String aY(Intent paramIntent)
    {
      AppMethodBeat.i(214047);
      d.g.b.p.h(paramIntent, "intent");
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
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.WebViewController", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
          if ((localException instanceof ClassNotFoundException))
          {
            paramIntent = (Throwable)localException;
            AppMethodBeat.o(214047);
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
        AppMethodBeat.o(214047);
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (d.n.n.aD((CharSequence)localObject2)))
      {
        i = 1;
        if (i != 0) {
          break label104;
        }
        AppMethodBeat.o(214047);
        return localObject1;
      }
      return paramIntent;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZ)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getNeverGetA8Key", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"})
  public static final class c
  {
    final BaseWebViewController.f DYW;
    final boolean DYX;
    final boolean DYY;
    final boolean DYZ;
    final boolean DZa;
    
    public c(byte paramByte)
    {
      this();
    }
    
    public c(BaseWebViewController.f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      AppMethodBeat.i(214050);
      this.DYW = paramf;
      this.DYX = paramBoolean1;
      this.DYY = paramBoolean2;
      this.DYZ = paramBoolean3;
      this.DZa = paramBoolean4;
      AppMethodBeat.o(214050);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"})
  final class d
    extends com.tencent.mm.ui.widget.i
  {
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(214054);
      if ((paramInt >= 100) && (!this.DYV.eRb()))
      {
        this.DYV.DYp = true;
        com.tencent.mm.sdk.platformtools.ae.i(BaseWebViewController.a(this.DYV), "Abe-Debug Progress 100");
        if (paramWebView != null)
        {
          Object localObject;
          if (paramWebView.supportFeature(2006))
          {
            localObject = f.DZr;
            if (!f.a.eRl()) {}
          }
          else
          {
            localObject = paramWebView.getUrl();
            if (localObject != null)
            {
              if (((CharSequence)localObject).length() == 0) {}
              for (paramInt = 1; paramInt == 0; paramInt = 0)
              {
                localObject = this.DYV;
                paramInt = this.DYV.DYB;
                BaseWebViewController localBaseWebViewController = this.DYV;
                paramWebView = paramWebView.getUrl();
                d.g.b.p.g(paramWebView, "url");
                ((BaseWebViewController)localObject).cx(paramInt, BaseWebViewController.c(localBaseWebViewController, paramWebView));
                AppMethodBeat.o(214054);
                return;
              }
            }
            com.tencent.mm.sdk.platformtools.ae.i(BaseWebViewController.a(this.DYV), "WebView-Trace not support PAGE_COMMIT_VISIBLE, url = null, skip check");
          }
          AppMethodBeat.o(214054);
          return;
        }
      }
      AppMethodBeat.o(214054);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", "action", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class e
  {
    final d.l.b<? extends BaseWebViewController.WebAction> DZb;
    final d.g.a.a<d.z> hjJ;
    
    public e(d.l.b<? extends BaseWebViewController.WebAction> paramb, d.g.a.a<d.z> parama)
    {
      AppMethodBeat.i(214058);
      this.DZb = paramb;
      this.hjJ = parama;
      AppMethodBeat.o(214058);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214061);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!d.g.b.p.i(this.DZb, paramObject.DZb)) || (!d.g.b.p.i(this.hjJ, paramObject.hjJ))) {}
        }
      }
      else
      {
        AppMethodBeat.o(214061);
        return true;
      }
      AppMethodBeat.o(214061);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(214060);
      Object localObject = this.DZb;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.hjJ;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(214060);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214059);
      String str = "WebEvent(action=" + this.DZb + ", block=" + this.hjJ + ")";
      AppMethodBeat.o(214059);
      return str;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"})
  public static final class f
  {
    final d.f DZc;
    final d.f DZd;
    final d.f DZe;
    final d.f DZf;
    
    public f(Intent paramIntent)
    {
      AppMethodBeat.i(214066);
      this.DZc = d.g.O((d.g.a.a)new b(paramIntent));
      this.DZd = d.g.O((d.g.a.a)new d(paramIntent));
      this.DZe = d.g.O((d.g.a.a)new a(paramIntent));
      this.DZf = d.g.O((d.g.a.a)new c(paramIntent));
      AppMethodBeat.o(214066);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<Boolean>
    {
      a(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<Boolean>
    {
      b(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<Boolean>
    {
      c(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class d
      extends q
      implements d.g.a.a<Boolean>
    {
      d(Intent paramIntent)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.c>
  {
    public static final g DZg;
    
    static
    {
      AppMethodBeat.i(214069);
      DZg = new g();
      AppMethodBeat.o(214069);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<d.z>
  {
    i(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<d.z>
  {
    k(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<d.z>
  {
    l(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<d.z>
  {
    m(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<d.z>
  {
    n(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements d.g.a.a<d.z>
  {
    o(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<d.z>
  {
    p(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.f<avz>>
  {
    q(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements d.g.a.a<Integer>
  {
    r(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(BaseWebViewController paramBaseWebViewController, int paramInt) {}
    
    public final void run()
    {
      int j = 0;
      AppMethodBeat.i(214085);
      if (paramInt < 0) {}
      for (int i = 1; (d.ac.Nhs) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(214085);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.sdk.platformtools.ae.i(BaseWebViewController.a(this.DYV), "checkStatus:" + paramInt + " to [" + d.a.j.a((Iterable)BaseWebViewController.c(this.DYV), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.b(this.DYV), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.e(this.DYV), (CharSequence)",", null, null, 0, null, null, 62) + ']');
      BaseWebViewController.c(this.DYV).add(Integer.valueOf(paramInt));
      BaseWebViewController.a(this.DYV, (Iterable)BaseWebViewController.f(this.DYV), (Set)BaseWebViewController.d(this.DYV));
      Object localObject = (CharSequence)this.DYV.DXX;
      if (localObject != null)
      {
        i = j;
        if (!d.n.n.aD((CharSequence)localObject)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        BaseWebViewController.a(this.DYV, (Iterable)BaseWebViewController.g(this.DYV), (Set)BaseWebViewController.e(this.DYV), this.DYV.DXX);
      }
      d.a.j.a((Iterable)BaseWebViewController.a(this.DYV, paramInt), (d.g.a.b)1.DZi);
      AppMethodBeat.o(214085);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(214086);
      Object localObject;
      if (paramInt > 0)
      {
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (d.n.n.aD((CharSequence)localObject)))
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
        if ((!d.ac.Nhs) || (i != 0)) {
          break label79;
        }
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(214086);
        throw ((Throwable)localObject);
        i = 0;
        break;
      }
      label79:
      if ((d.g.b.p.i(paramString, this.DYV.DXX)) || ((this.DYV.DYE.contains(Integer.valueOf(paramInt))) && (d.g.b.p.i(paramString, this.DYV.DXZ))) || (this.DYV.DYF.contains(Integer.valueOf(paramInt))))
      {
        com.tencent.mm.sdk.platformtools.ae.i(BaseWebViewController.a(this.DYV), "checkStatus:" + paramInt + ' ' + paramString + " to [" + d.a.j.a((Iterable)BaseWebViewController.c(this.DYV), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.b(this.DYV), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.e(this.DYV), (CharSequence)",", null, null, 0, null, null, 62) + ']');
        BaseWebViewController.b(this.DYV).add(Integer.valueOf(paramInt));
        BaseWebViewController.a(this.DYV, (Iterable)BaseWebViewController.g(this.DYV), (Set)BaseWebViewController.e(this.DYV), this.DYV.DXX);
        AppMethodBeat.o(214086);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.w(BaseWebViewController.a(this.DYV), "checkStatus skip: " + paramInt + ", url=" + paramString + ", startUrl=" + this.DYV.DXX);
      AppMethodBeat.o(214086);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements d.g.a.a<String>
  {
    u(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements d.g.a.a<d.z>
  {
    v(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements d.g.a.a<d.z>
  {
    w(BaseWebViewController paramBaseWebViewController, String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class x
    extends q
    implements d.g.a.a<aq>
  {
    public static final x DZk;
    
    static
    {
      AppMethodBeat.i(214092);
      DZk = new x();
      AppMethodBeat.o(214092);
    }
    
    x()
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"setConfigCallback", "", "windowManager", "Landroid/view/WindowManager;", "invoke"})
  static final class y
    extends q
    implements d.g.a.b<WindowManager, d.z>
  {
    public static final y DZl;
    
    static
    {
      AppMethodBeat.i(214095);
      DZl = new y();
      AppMethodBeat.o(214095);
    }
    
    y()
    {
      super();
    }
    
    public static void b(WindowManager paramWindowManager)
    {
      AppMethodBeat.i(214094);
      d.g.b.p.h(paramWindowManager, "windowManager");
      try
      {
        Object localObject = WebView.class.getDeclaredField("mWebViewCore");
        d.g.b.p.g(localObject, "field");
        localObject = ((Field)localObject).getType().getDeclaredField("mBrowserFrame");
        d.g.b.p.g(localObject, "field");
        Field localField = ((Field)localObject).getType().getDeclaredField("sConfigCallback");
        d.g.b.p.g(localField, "field");
        localField.setAccessible(true);
        localObject = localField.get(null);
        if (localObject == null)
        {
          AppMethodBeat.o(214094);
          return;
        }
        localField = localField.getType().getDeclaredField("mWindowManager");
        d.g.b.p.g(localField, "field");
        localField.setAccessible(true);
        localField.set(localObject, paramWindowManager);
        AppMethodBeat.o(214094);
        return;
      }
      catch (Exception paramWindowManager)
      {
        AppMethodBeat.o(214094);
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/webview/core/BaseWebViewController$intercept$1$1"})
  static final class z
    implements Runnable
  {
    z(WebResourceRequest paramWebResourceRequest, BaseWebViewController paramBaseWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(214096);
      com.tencent.mm.sdk.platformtools.ae.i(BaseWebViewController.a(jdField_this), "shouldInterceptRequest, url = " + this.DZm.getUrl() + ", method = " + this.DZm.getMethod() + ", isForMainFrame = " + this.DZm.isForMainFrame());
      AppMethodBeat.o(214096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController
 * JD-Core Version:    0.7.0.1
 */