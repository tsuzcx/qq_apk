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
import com.tencent.mm.plugin.appbrand.z.p.a;
import com.tencent.mm.plugin.webview.e.c.a;
import com.tencent.mm.plugin.webview.e.g.b;
import com.tencent.mm.plugin.webview.j.e.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import d.a.ae;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_PROGRESS_CACHE_LOAD_START", "getCONTROLLER_PROGRESS_CACHE_LOAD_START", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_PROGRESS_NO_FRAME_AUTH_START", "getPAGE_PROGRESS_NO_FRAME_AUTH_START", "PAGE_PROGRESS_SHOW_TIME_OUT", "getPAGE_PROGRESS_SHOW_TIME_OUT", "PAGE_PROGRESS_STATUS", "getPAGE_PROGRESS_STATUS", "()Ljava/util/Set;", "PAGE_PROGRESS_WEBVIEW_START", "getPAGE_PROGRESS_WEBVIEW_START", "PAGE_SPA_STATUS", "getPAGE_SPA_STATUS", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/concurrent/ConcurrentSkipListSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isInject", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "updateRandomStr", "getUpdateRandomStr", "updateRandomStr$delegate", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", "listener", "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canLoadUrl", "url", "canShowRefresh", "checkStatus", "check", "dealSPAUpdate", "destroy", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", "request", "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCallBackUrl", "getShareUrl", "getStatusListener", "hasStatus", "init", "initEnviroment", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "Lcom/tencent/xweb/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onUrlRedirect", "forceRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeInvoker", "removeStatus", "resetActions", "resetPageActions", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "ProgressBarEnd", "ProgressBarStart", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"})
public abstract class BaseWebViewController
  extends com.tencent.xweb.ac
  implements com.tencent.mm.plugin.webview.e.a<avj>
{
  public static final b DGW = new b((byte)0);
  private final d.f DFW;
  private final d.f DFX;
  public String DFY;
  private final d.f DFZ;
  final int DGA;
  final int DGB;
  final int DGC;
  final int DGD;
  final int DGE;
  final int DGF;
  final Set<Integer> DGG;
  final Set<Integer> DGH;
  private final boolean DGI;
  private final ConcurrentLinkedDeque<o<ControllerAction, d.g.a.a<d.z>>> DGJ;
  private final ConcurrentLinkedDeque<o<PageAction, d.g.a.a<d.z>>> DGK;
  private final ConcurrentSkipListSet<Integer> DGL;
  private final ConcurrentSkipListSet<Integer> DGM;
  private final ConcurrentSkipListSet<String> DGN;
  private final ConcurrentSkipListSet<String> DGO;
  public final boolean DGP;
  c DGQ;
  private final d.f DGR;
  private boolean DGS;
  private final d.f DGT;
  final c DGU;
  private Set<String> DGV;
  String DGa;
  public String DGb;
  String DGc;
  private boolean DGd;
  public boolean DGe;
  private final d.f DGf;
  private final d.f DGg;
  private final d.f DGh;
  public final Map<String, String> DGi;
  private final d.f DGj;
  public final k DGk;
  public final com.tencent.mm.plugin.webview.j.i DGl;
  final ConcurrentLinkedDeque<j> DGm;
  private final ConcurrentLinkedDeque<e> DGn;
  public final ConcurrentLinkedDeque<i> DGo;
  private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<d.g.a.a<d.z>>> DGp;
  public boolean DGq;
  boolean DGr;
  private final d.f DGs;
  final int DGt;
  public final int DGu;
  public final int DGv;
  protected final int DGw;
  protected final int DGx;
  final int DGy;
  final int DGz;
  protected String cSr;
  protected Intent intent;
  private final d.f kaL;
  public com.tencent.mm.plugin.webview.stub.e lvv;
  public final com.tencent.mm.plugin.webview.e.g lvw;
  private final List<e> omB;
  public final MMWebView omW;
  
  public BaseWebViewController(MMWebView paramMMWebView, c paramc, Set<String> paramSet)
  {
    this.omW = paramMMWebView;
    this.DGU = paramc;
    this.DGV = paramSet;
    this.DFW = d.g.O((d.g.a.a)new a(this));
    this.DFX = d.g.O((d.g.a.a)new q(this));
    this.DFZ = d.g.O((d.g.a.a)g.DHi);
    this.cSr = "";
    this.DGa = "";
    this.DGb = "";
    this.DGc = "";
    this.DGf = d.g.O((d.g.a.a)new aa(this));
    this.DGg = d.g.O((d.g.a.a)new ab(this));
    this.DGh = d.g.O((d.g.a.a)new r(this));
    this.kaL = d.g.O((d.g.a.a)x.DHm);
    this.lvw = new com.tencent.mm.plugin.webview.e.g((g.b)new aj(this));
    this.DGi = ((Map)new HashMap());
    this.DGj = d.g.O((d.g.a.a)new ad(this));
    this.DGk = ((k)new ae(this));
    this.DGl = new com.tencent.mm.plugin.webview.j.i();
    this.DGm = new ConcurrentLinkedDeque();
    this.DGn = new ConcurrentLinkedDeque();
    this.DGo = new ConcurrentLinkedDeque();
    this.DGp = new ConcurrentHashMap();
    this.DGs = d.g.O((d.g.a.a)new u(this));
    this.DGt = -1;
    this.DGu = -2;
    this.DGv = -3;
    this.DGw = -10;
    this.DGx = -5;
    this.DGy = 1;
    this.DGz = 2;
    this.DGA = 3;
    this.DGB = 4;
    this.DGC = 6;
    this.DGD = 10;
    this.DGE = 11;
    this.DGF = 12;
    this.DGG = ak.setOf(new Integer[] { Integer.valueOf(this.DGE), Integer.valueOf(this.DGF) });
    this.DGH = ak.setOf(new Integer[] { Integer.valueOf(this.DGA), Integer.valueOf(this.DGB), Integer.valueOf(this.DGC) });
    this.DGI = true;
    this.omB = d.a.j.mutableListOf(new e[] { new e(d.g.b.z.bp(Init.class), (d.g.a.a)new h((BaseWebViewController)this)), new e(d.g.b.z.bp(Inject.class), (d.g.a.a)new i(this)), new e(d.g.b.z.bp(Bind.class), (d.g.a.a)new j((BaseWebViewController)this)), new e(d.g.b.z.bp(Auth.class), (d.g.a.a)new k(this)), new e(d.g.b.z.bp(Ready.class), (d.g.a.a)new l(this)), new e(d.g.b.z.bp(Start.class), (d.g.a.a)new m(this)), new e(d.g.b.z.bp(SPAUpdated.class), (d.g.a.a)new n(this)), new e(d.g.b.z.bp(ProgressBarStart.class), (d.g.a.a)new o(this)), new e(d.g.b.z.bp(ProgressBarEnd.class), (d.g.a.a)new p(this)) });
    this.DGJ = new ConcurrentLinkedDeque();
    this.DGK = new ConcurrentLinkedDeque();
    this.DGL = new ConcurrentSkipListSet();
    this.DGM = new ConcurrentSkipListSet();
    this.DGN = new ConcurrentSkipListSet();
    this.DGO = new ConcurrentSkipListSet();
    this.DGP = eNg().ePg();
    this.DGR = d.g.O((d.g.a.a)ah.DHq);
    this.DGT = d.g.O((d.g.a.a)ai.DHr);
  }
  
  private final String Ok(String paramString)
  {
    if (!XL(paramString)) {
      paramString = this.DGb;
    }
    for (;;)
    {
      String str = paramString;
      if (d.n.n.aE((CharSequence)paramString))
      {
        str = paramString;
        if (Ws(this.DGv)) {
          str = bQm();
        }
      }
      return str;
    }
  }
  
  private boolean Wt(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!d.ac.MKp) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.DGM.remove(Integer.valueOf(paramInt));
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
          ad.i(eNe(), "verify WebAction: " + d.g.b.z.bp(localWebAction.getClass()).getSimpleName() + " start");
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
          ad.v(eNe(), "verifyActions: " + d.g.b.z.bp(localWebAction.getClass()).getSimpleName() + " end");
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
  
  private final String aGc(String paramString)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (d.n.n.aE((CharSequence)localObject))) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!com.tencent.luggage.h.c.a(paramString, "about:blank", true)))
      {
        localObject = paramString;
        if (!com.tencent.luggage.h.c.a(paramString, "data:text/html;charset=utf-8", true)) {}
      }
      else
      {
        localObject = this.cSr;
      }
      return localObject;
    }
  }
  
  private final void aGf(String paramString)
  {
    try
    {
      ad.i(eNe(), "resetPageActions clear status:" + paramString + ", [" + d.a.j.a((Iterable)this.DGL, (CharSequence)",", null, null, 0, null, null, 62) + "] actions: [" + d.a.j.a((Iterable)this.DGN, (CharSequence)",", null, null, 0, null, null, 62) + ']');
      this.DGL.clear();
      this.DGN.clear();
      this.DGK.clear();
      Iterator localIterator = ((Iterable)bQq()).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        Object localObject = d.l.a.c.d(locale.DHd);
        ((WebAction)localObject).setController((BaseWebViewController)this);
        localObject = (WebAction)localObject;
        if ((localObject instanceof PageAction)) {
          this.DGK.add(u.S(localObject, locale.hgV));
        }
      }
      aGd(paramString);
    }
    finally {}
    this.DGc = "";
  }
  
  private final int aGg(String paramString)
  {
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    while (localIterator.hasNext())
    {
      int i = ((j)localIterator.next()).aGg(paramString);
      if (i != -1) {
        return i;
      }
    }
    return eNg().aIh(paramString);
  }
  
  public static final String aX(Intent paramIntent)
  {
    return b.aX(paramIntent);
  }
  
  private final com.tencent.mm.plugin.webview.c.i eNi()
  {
    return (com.tencent.mm.plugin.webview.c.i)this.DGf.getValue();
  }
  
  private final void eNm()
  {
    for (;;)
    {
      e locale;
      Object localObject2;
      try
      {
        ad.i(eNe(), "resetActions");
        this.DGM.clear();
        this.DGO.clear();
        this.DGJ.clear();
        this.DGL.clear();
        this.DGN.clear();
        this.DGK.clear();
        Iterator localIterator = ((Iterable)bQq()).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        locale = (e)localIterator.next();
        localObject2 = d.l.a.c.d(locale.DHd);
        ((WebAction)localObject2).setController((BaseWebViewController)this);
        localObject2 = (WebAction)localObject2;
        if ((localObject2 instanceof ControllerAction))
        {
          this.DGJ.add(u.S(localObject2, locale.hgV));
          continue;
        }
        if (!(localObject2 instanceof PageAction)) {
          continue;
        }
      }
      finally {}
      this.DGK.add(u.S(localObject2, locale.hgV));
    }
  }
  
  private final void l(WebView paramWebView, String paramString)
  {
    if ((paramWebView != null) && (this.DGq) && (paramWebView.canGoBack()))
    {
      ad.i(eNe(), "clearHistory :".concat(String.valueOf(paramString)));
      paramWebView.clearHistory();
      this.DGq = false;
    }
  }
  
  public final void F(String paramString, Map<String, String> paramMap)
  {
    d.g.b.p.h(paramString, "baseUrl");
    ad.i(eNe(), "WebView-Trace loadCacheUrl baseUrl ".concat(String.valueOf(paramString)));
    this.cSr = paramString;
    Wr(this.DGx);
    this.omW.loadUrl(paramString, paramMap);
    aGe(paramString);
    Wr(this.DGw);
    aPk().postUIDelayed(eNk(), 500L);
  }
  
  public final ConcurrentLinkedDeque<d.g.a.a<d.z>> Wq(int paramInt)
  {
    ConcurrentLinkedDeque localConcurrentLinkedDeque2 = (ConcurrentLinkedDeque)this.DGp.get(Integer.valueOf(paramInt));
    ConcurrentLinkedDeque localConcurrentLinkedDeque1 = localConcurrentLinkedDeque2;
    if (localConcurrentLinkedDeque2 == null)
    {
      localConcurrentLinkedDeque1 = new ConcurrentLinkedDeque();
      ((Map)this.DGp).put(Integer.valueOf(paramInt), localConcurrentLinkedDeque1);
    }
    return localConcurrentLinkedDeque1;
  }
  
  /* Error */
  public final void Wr(final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 1130	com/tencent/mm/plugin/webview/core/BaseWebViewController:eNq	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 1136	com/tencent/e/h:LTJ	Lcom/tencent/e/i;
    //   17: new 116	com/tencent/mm/plugin/webview/core/BaseWebViewController$s
    //   20: dup
    //   21: aload_0
    //   22: iload_1
    //   23: invokespecial 1139	com/tencent/mm/plugin/webview/core/BaseWebViewController$s:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;I)V
    //   26: checkcast 1141	java/lang/Runnable
    //   29: invokeinterface 1147 2 0
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
  
  public final boolean Ws(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 1;; i = 0) {
      try
      {
        if ((!d.ac.MKp) || (i != 0)) {
          break;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
      }
      finally {}
    }
    boolean bool = this.DGM.contains(Integer.valueOf(paramInt));
    return bool;
  }
  
  protected boolean XK(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    return true;
  }
  
  protected boolean XL(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    if (!d.n.n.aE((CharSequence)paramString)) {}
    for (int i = 1; (i != 0) && (!d.n.n.nz(paramString, "data:text/html;charset=utf-8")) && (!d.n.n.nz(paramString, "about:blank")) && ((!Ws(this.DGw)) || (!d.n.n.nz(paramString, "https://mp.weixin.qq.com/__tmpl__/"))); i = 0) {
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
      cx(this.DGz, paramString1);
      Iterator localIterator = ((Iterable)this.DGo).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).d(paramInt1, paramString1, paramInt2, paramString2);
      }
      this.DFY = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, avj paramavj)
  {
    d.g.b.p.h(paramString1, "reqUrl");
    d.g.b.p.h(paramString2, "fullUrl");
    d.g.b.p.h(paramavj, "response");
    ad.d(eNe(), "WebView-Trace onPermissionUpdate:" + paramString1 + ", fullUrl:" + paramString2);
    if (eNq()) {
      ad.d(eNe(), "onPermissionUpdate destroyCalled");
    }
    do
    {
      return;
      this.lvw.a(paramString1, eNg().aIe(paramString1), eNg().aIf(paramString1));
      this.lvw.a(paramString2, eNg().aIe(paramString2), eNg().aIf(paramString2));
      Iterator localIterator = ((Iterable)this.DGo).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).c(paramString1, paramavj);
      }
      cx(this.DGy, paramString1);
      cx(this.DGy, paramString2);
    } while (!d.g.b.p.i(paramString1, this.DGc));
    cx(this.DGF, paramString1);
    ad.i(eNe(), "WebAction:Ready onPermissionUpdated Patch: " + this.DGc);
  }
  
  public final void a(e parame)
  {
    d.g.b.p.h(parame, "listener");
    if (!this.DGn.contains(parame)) {
      this.DGn.add(parame);
    }
  }
  
  public final void a(i parami)
  {
    try
    {
      d.g.b.p.h(parami, "listener");
      if (!this.DGo.contains(parami))
      {
        BaseWebViewController localBaseWebViewController = (BaseWebViewController)this;
        d.g.b.p.h(localBaseWebViewController, "<set-?>");
        parami.controller = localBaseWebViewController;
        this.DGo.add(parami);
        if (this.DGO.contains(d.g.b.z.bp(Bind.class).getSimpleName()))
        {
          ad.i(eNe(), "Abe-Debug Patch Call onBind");
          parami.dWE();
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
    this.DGm.add(paramj);
    Object localObject = paramj.eNP();
    if (localObject != null) {
      a((e)localObject);
    }
    localObject = paramj.eNQ();
    if (localObject != null) {
      a((i)localObject);
    }
    paramj.k(this);
  }
  
  public void a(com.tencent.mm.plugin.webview.stub.e parame) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (!Ws(this.DGv)) {
      ad.i(eNe(), "onReceivedError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.DGn).iterator();
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
    if (!Ws(this.DGv)) {
      ad.i(eNe(), "onReceivedHttpError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.DGn).iterator();
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
    com.tencent.mm.plugin.report.service.g.yhR.n(155L, 35L, 1L);
  }
  
  public void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    super.a(paramWebView, paramr, paramSslError);
    if (!Ws(this.DGv)) {
      ad.i(eNe(), "onReceivedSslError, intent not ready");
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.DGn).iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (isStarted()) {
          locale.a(paramWebView, paramr, paramSslError);
        }
      }
    }
  }
  
  protected boolean a(int paramInt, String paramString, avj paramavj)
  {
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavj, "resp");
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).d(paramString, paramavj)) {
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
    ad.i(eNe(), "shouldOverrideUrlLoading: ".concat(String.valueOf(paramString)));
    ad.d(eNe(), "doShouldOverrideUrlLoading url:".concat(String.valueOf(paramString)));
    boolean bool1;
    if (k(paramWebView, paramString))
    {
      bool1 = bool2;
      if (!bool1) {
        this.DFY = paramString;
      }
      return bool1;
    }
    label150:
    if (aGg(paramString) == 2)
    {
      bool1 = true;
      label89:
      if (aG(paramString, bool1))
      {
        if (this.DGU.DHc) {
          break label181;
        }
        switch (aGg(paramString))
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
  
  protected boolean aG(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    d.g.b.p.h(paramString, "url");
    if (a(this, paramString, paramBoolean, 0, 4) == c.a.DWT) {
      bool = true;
    }
    return bool;
  }
  
  protected final void aGd(String paramString)
  {
    d.g.b.p.h(paramString, "value");
    if (XK(paramString))
    {
      ad.d(eNe(), "WebView-Trace startUrl:".concat(String.valueOf(paramString)));
      this.DGa = paramString;
    }
  }
  
  protected final void aGe(String paramString)
  {
    d.g.b.p.h(paramString, "value");
    if (XL(paramString))
    {
      ad.d(eNe(), "WebView-Trace commitUrl:".concat(String.valueOf(paramString)));
      this.DGb = paramString;
    }
  }
  
  public final boolean aGh(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    if (com.tencent.mm.platformtools.ac.iOK)
    {
      ad.w(eNe(), "skipLoadUrlCheck");
      return true;
    }
    if (this.DGU.DGZ)
    {
      ad.i(eNe(), "albie: trust this url(%s)", new Object[] { paramString });
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "file://", true))
    {
      Iterator localIterator = ((Iterable)eNf()).iterator();
      while (localIterator.hasNext()) {
        if (com.tencent.luggage.h.c.a(paramString, (String)localIterator.next(), true)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  protected final boolean aGi(String paramString)
  {
    d.g.b.p.h(paramString, "url");
    if (!aGh(paramString))
    {
      ad.f(eNe(), "forceQuitOnUrlForbidden, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      paramString = ((Iterable)this.DGo).iterator();
      while (paramString.hasNext()) {
        ((i)paramString.next()).eNL();
      }
      return true;
    }
    return false;
  }
  
  public final String aKv()
  {
    return eNg().aHL(getCurrentUrl());
  }
  
  public final ap aPk()
  {
    return (ap)this.kaL.getValue();
  }
  
  public final void at(Intent paramIntent)
  {
    d.g.b.p.h(paramIntent, "intent");
    ad.i(eNe(), "start");
    this.intent = paramIntent;
    com.tencent.mm.plugin.webview.e.g localg = this.lvw;
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
    this.DGl.EtC = paramIntent.getLongExtra("startTime", 0L);
    kotlinx.coroutines.f.b((ah)bk.NII, null, (m)new af(this, null), 3);
  }
  
  protected WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramWebResourceRequest, "request");
    h.LTJ.aR((Runnable)new z(paramWebResourceRequest, this));
    Object localObject = paramWebResourceRequest.getUrl().toString();
    d.g.b.p.g(localObject, "request.url.toString()");
    if (aGi((String)localObject)) {
      return null;
    }
    if ((com.tencent.mm.cq.d.kP(getContext())) && (paramBundle != null)) {}
    try
    {
      int i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        ad.i(eNe(), "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        paramBundle = paramWebResourceRequest.getUrl().toString();
        d.g.b.p.g(paramBundle, "request.url.toString()");
        k(paramBundle, false, 5);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ad.w(eNe(), "get resource type failed Exception ; " + paramBundle.getMessage());
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        ad.w(eNe(), "get resource type failed Throwable ; " + paramBundle.getMessage());
      }
    }
    paramBundle = ((Iterable)this.DGm).iterator();
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
    if (eNq())
    {
      ad.w(eNe(), "ActivityFinished");
      return;
    }
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      str = Ok(str);
      ad.i(eNe(), "WebView-Trace onPageFinished: " + paramString + ", callbackUrl:" + str);
      if (((paramWebView == null) || (paramWebView.supportFeature(2006) != true)) && (this.DGr)) {
        aGe(str);
      }
      super.b(paramWebView, paramString);
      if ((!this.DGL.contains(Integer.valueOf(this.DGD))) && (!bQw()))
      {
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1200L, 104L, 1L, false);
        ad.i(eNe(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
      }
      cx(this.DGE, aGc(paramString));
      Iterator localIterator = ((Iterable)this.DGn).iterator();
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
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    if (eNq())
    {
      ad.w(eNe(), "ActivityFinished");
      return;
    }
    cx(this.DGA, paramString);
    ad.i(eNe(), "WebView-Trace onPageStarted: ".concat(String.valueOf(paramString)));
    this.DGr = false;
    this.DFY = paramString;
    aGf(paramString);
    Iterator localIterator = ((Iterable)this.DGn).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (isStarted()) {
        locale.aGk(Ok(paramString));
      }
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    ad.i(eNe(), "WebView-Trace doUpdateVisitedHistory, url = " + paramString + ", wvUrl = " + paramWebView.getUrl() + ", isReload = " + paramBoolean);
    if (d.n.n.nz(paramString, "data:text/html;charset=utf-8"))
    {
      ad.i(eNe(), "url starts with data:text, url : ".concat(String.valueOf(paramString)));
      return;
    }
    if ((com.tencent.luggage.h.c.A(paramString, "about:blank")) || (com.tencent.luggage.h.c.A(paramString, "file:///android_asset/")))
    {
      ad.e(eNe(), "doUpdateVisitedHistory, url is invalid");
      return;
    }
    if ((Ws(this.DGw)) && (com.tencent.luggage.h.c.A(paramString, "https://mp.weixin.qq.com/__tmpl__/")))
    {
      ad.i(eNe(), "doUpdateVisitedHistory, url is HARDCODE_URL");
      return;
    }
    super.b(paramWebView, paramString, paramBoolean);
    if (((Boolean)this.DGT.getValue()).booleanValue()) {
      paramString = paramWebView.getUrl();
    }
    d.g.b.p.g(paramString, "url");
    if (!d.g.b.p.i(this.DGa, paramString))
    {
      if (this.lvw.has(paramString)) {
        cx(this.DGF, paramString);
      }
      this.DGc = paramString;
    }
    if (!this.DGU.DHc) {
      aG(paramString, false);
    }
    this.DFY = paramString;
    Iterator localIterator = ((Iterable)this.DGn).iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      if (isStarted()) {
        locale.aGl(paramString);
      }
    }
    l(paramWebView, paramString);
  }
  
  public boolean b(int paramInt, String paramString, avj paramavj)
  {
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavj, "response");
    ad.i(eNe(), "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(paramInt)));
    this.omW.setA8keyReason(paramInt);
    Object localObject1 = this.DGi;
    ((Map)localObject1).clear();
    Object localObject2 = paramavj.GtM;
    d.g.b.p.g(localObject2, "response.HttpHeader");
    int i;
    if (!((Collection)localObject2).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      localObject2 = com.tencent.mm.plugin.webview.e.c.gU((List)paramavj.GtM);
      d.g.b.p.g(localObject2, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      ((Map)localObject1).putAll((Map)localObject2);
    }
    label134:
    label327:
    label459:
    for (;;)
    {
      if (!a(paramInt, paramString, paramavj)) {
        break label461;
      }
      return true;
      i = 0;
      break;
      localObject2 = this.intent;
      if (localObject2 == null) {
        d.g.b.p.bcb("intent");
      }
      if (((Intent)localObject2).getBooleanExtra("k_has_http_header", false))
      {
        ad.i(eNe(), "use intent httpheader info");
        localObject2 = this.intent;
        if (localObject2 == null) {
          d.g.b.p.bcb("intent");
        }
        localObject2 = ((Intent)localObject2).getStringArrayExtra("geta8key_result_http_header_key_list");
        Object localObject3 = this.intent;
        if (localObject3 == null) {
          d.g.b.p.bcb("intent");
        }
        localObject3 = ((Intent)localObject3).getStringArrayExtra("geta8key_result_http_header_value_list");
        Intent localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.p.bcb("intent");
        }
        localIntent.putExtra("k_has_http_header", false);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.p.bcb("intent");
        }
        localIntent.putStringArrayListExtra("geta8key_result_http_header_key_list", null);
        localIntent = this.intent;
        if (localIntent == null) {
          d.g.b.p.bcb("intent");
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
    localObject1 = ((Iterable)this.DGo).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((i)((Iterator)localObject1).next()).b(paramString, paramavj);
    }
    return false;
  }
  
  public final boolean b(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    d.g.b.p.h(paramWebView, "webview");
    d.g.b.p.h(paramString1, "description");
    d.g.b.p.h(paramString2, "failingUrl");
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    while (localIterator.hasNext()) {
      ((j)localIterator.next()).c(paramWebView, paramInt, paramString1, paramString2);
    }
    return super.b(paramWebView, paramInt, paramString1, paramString2);
  }
  
  protected abstract Class<? extends Service> bOJ();
  
  public String bQm()
  {
    try
    {
      Object localObject = this.intent;
      if (localObject == null) {
        d.g.b.p.bcb("intent");
      }
      localObject = b.aX((Intent)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e(eNe(), String.valueOf(localException.getMessage()));
      onFinish();
    }
    return "";
  }
  
  protected boolean bQn()
  {
    return this.DGI;
  }
  
  protected boolean bQo()
  {
    return false;
  }
  
  protected boolean bQp()
  {
    return false;
  }
  
  protected List<e> bQq()
  {
    return this.omB;
  }
  
  protected void bQr()
  {
    a((j)new com.tencent.mm.plugin.webview.f.a());
    a((j)new com.tencent.mm.plugin.webview.k.e());
    this.omW.setWebViewClient((com.tencent.xweb.ac)this);
    MMWebView localMMWebView = this.omW;
    Object localObject1 = y.DHn;
    com.tencent.mm.plugin.webview.j.j.g(localMMWebView);
    com.tencent.xweb.z localz = localMMWebView.getSettings();
    localz.setJavaScriptEnabled(((Boolean)this.DGU.DGY.DHg.getValue()).booleanValue());
    localz.setPluginsEnabled(((Boolean)this.DGU.DGY.DHe.getValue()).booleanValue());
    localz.gbb();
    localz.setBuiltInZoomControls(((Boolean)this.DGU.DGY.DHf.getValue()).booleanValue());
    localz.setUseWideViewPort(true);
    localz.setLoadWithOverviewMode(true);
    localz.gaU();
    localz.gaT();
    localz.setGeolocationEnabled(true);
    localz.setJavaScriptCanOpenWindowsAutomatically(true);
    localz.gbd();
    localz.gaZ();
    localObject1 = localMMWebView.getContext().getDir("webviewcache", 0);
    d.g.b.p.g(localObject1, "context.getDir(\"webviewc…e\", Context.MODE_PRIVATE)");
    localz.setAppCachePath(((File)localObject1).getAbsolutePath());
    localz.gaY();
    localz.gba();
    localz.setDatabasePath(com.tencent.mm.loader.j.b.arL() + "databases/");
    String str = localz.getUserAgentString();
    d.g.b.p.g(str, "currentUa");
    Object localObject2;
    if (!d.n.n.e((CharSequence)str, (CharSequence)" MicroMessenger/"))
    {
      localObject2 = (p.a)com.tencent.luggage.a.e.K(p.a.class);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (p.a)new com.tencent.mm.plugin.appbrand.luggage.b.f(localMMWebView.getContext());
      }
      localObject2 = com.tencent.mm.plugin.webview.j.e.Etl;
      d.g.b.p.h(str, "prefix");
      e.a.bNe().putString("key_web_prefetch_ua", str);
      localz.setUserAgentString(com.tencent.mm.plugin.appbrand.z.p.a(localMMWebView.getContext(), str, (p.a)localObject1));
    }
    if (!((Boolean)this.DGU.DGY.DHh.getValue()).booleanValue())
    {
      localMMWebView.setVerticalScrollBarEnabled(false);
      localMMWebView.setHorizontalScrollBarEnabled(false);
    }
    com.tencent.xweb.c.gaw().gax();
    com.tencent.xweb.c.gaw().e((WebView)localMMWebView);
    localObject1 = y.DHn;
    localObject1 = localMMWebView.getContext().getSystemService("window");
    if (localObject1 == null) {
      throw new v("null cannot be cast to non-null type android.view.WindowManager");
    }
    y.b((WindowManager)localObject1);
    if (this.omW.fLC())
    {
      localObject2 = this.omW.getUrl();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      aGe((String)localObject1);
    }
    this.DGl.bL("onTryBindServiceStart", System.currentTimeMillis());
    ad.i(eNe(), "WebView-Trace tryBindService");
    localObject1 = l.DIR;
    l.a(true, bOJ(), (d)new ag(this));
    this.DGl.bL("onTryBindServiceEnd", System.currentTimeMillis());
  }
  
  protected void bQs() {}
  
  protected boolean bQt()
  {
    return true;
  }
  
  public boolean bQw()
  {
    return (Ws(this.DGw)) && (d.g.b.p.i(this.cSr, this.DGb));
  }
  
  protected void bRf()
  {
    if (!this.DGS)
    {
      eNt();
      this.DGS = true;
    }
    Iterator localIterator = ((Iterable)this.DGo).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bRf();
    }
  }
  
  public final void bm(int paramInt, String paramString)
  {
    d.g.b.p.h(paramString, "reqUrl");
    this.DGl.bL("getA8KeyEnd", System.currentTimeMillis());
    Iterator localIterator = ((Iterable)this.DGo).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).aGt(paramString);
    }
  }
  
  public final void bn(final int paramInt, final String paramString)
  {
    d.g.b.p.h(paramString, "reqUrl");
    this.DGl.bL("getA8KeyStart", System.currentTimeMillis());
    if (paramInt != 5) {
      cx(this.DGB, paramString);
    }
    if ((d.g.b.p.i(this.DGc, paramString) ^ true)) {
      h.LTJ.aP((Runnable)new ac(this, paramInt, paramString));
    }
  }
  
  /* Error */
  protected final void cx(final int paramInt, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ldc_w 1152
    //   6: invokestatic 600	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 1130	com/tencent/mm/plugin/webview/core/BaseWebViewController:eNq	()Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: getstatic 1136	com/tencent/e/h:LTJ	Lcom/tencent/e/i;
    //   24: new 120	com/tencent/mm/plugin/webview/core/BaseWebViewController$t
    //   27: dup
    //   28: aload_0
    //   29: iload_1
    //   30: aload_2
    //   31: invokespecial 1893	com/tencent/mm/plugin/webview/core/BaseWebViewController$t:<init>	(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;ILjava/lang/String;)V
    //   34: checkcast 1141	java/lang/Runnable
    //   37: invokeinterface 1147 2 0
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
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    j.a locala;
    while (localIterator.hasNext())
    {
      locala = ((j)localIterator.next()).c(paramWebView, paramWebResourceRequest);
      if (locala.DIP) {
        if (!locala.DIP) {
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
  
  protected void dWE() {}
  
  public final void destroy()
  {
    com.tencent.mm.ad.c.g((d.g.a.a)new v(this));
  }
  
  public final void e(WebView paramWebView, String paramString)
  {
    if (eNq())
    {
      ad.w(eNe(), "ActivityFinished");
      return;
    }
    Object localObject1 = getJsapi();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.webview.c.f)localObject1).eLu();
    }
    if ((((Boolean)this.DGR.getValue()).booleanValue()) && (!this.omW.fLC()) && (!Ws(this.DGw)) && (paramString != null) && (!d.n.n.nz(paramString, "file:")))
    {
      localObject1 = getJsapi();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.webview.c.f)localObject1).eOx();
      }
    }
    if (paramString == null) {}
    for (localObject1 = "";; localObject1 = paramString)
    {
      localObject1 = Ok((String)localObject1);
      ad.i(eNe(), "WebView-Trace onPageCommitVisible: " + paramString + ", callbackUrl:" + (String)localObject1);
      aGe((String)localObject1);
      super.e(paramWebView, paramString);
      Object localObject2 = f.DHt;
      if (!f.a.eNA()) {
        cx(this.DGD, aGc(paramString));
      }
      for (;;)
      {
        localObject2 = ((Iterable)this.DGn).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          e locale = (e)((Iterator)localObject2).next();
          if (isStarted()) {
            locale.e(paramWebView, (String)localObject1);
          }
        }
        ad.i(eNe(), "WebView Page Commit Mock Enabled");
      }
      l(paramWebView, paramString);
      return;
    }
  }
  
  public final String eNe()
  {
    return (String)this.DFW.getValue();
  }
  
  protected abstract Set<String> eNf();
  
  public final com.tencent.mm.plugin.webview.e.c eNg()
  {
    return (com.tencent.mm.plugin.webview.e.c)this.DFZ.getValue();
  }
  
  public final com.tencent.mm.plugin.webview.stub.e eNh()
  {
    com.tencent.mm.plugin.webview.stub.e locale = this.lvv;
    if (locale == null) {
      d.g.b.p.bcb("invoker");
    }
    return locale;
  }
  
  public final int eNj()
  {
    return ((Number)this.DGh.getValue()).intValue();
  }
  
  public final Runnable eNk()
  {
    return (Runnable)this.DGj.getValue();
  }
  
  public final String eNl()
  {
    return (String)this.DGs.getValue();
  }
  
  protected final boolean eNn()
  {
    try
    {
      boolean bool = this.DGN.contains(d.g.b.z.bp(Inject.class).getSimpleName());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void eNo() {}
  
  public boolean eNp()
  {
    return false;
  }
  
  public final boolean eNq()
  {
    return (this.DGe) || (this.DGd);
  }
  
  public final void eNr()
  {
    try
    {
      com.tencent.mm.plugin.webview.stub.e locale = this.lvv;
      if (locale == null) {
        d.g.b.p.bcb("invoker");
      }
      if (locale != null)
      {
        locale = this.lvv;
        if (locale == null) {
          d.g.b.p.bcb("invoker");
        }
        locale.Xk(eNj());
        locale = this.lvv;
        if (locale == null) {
          d.g.b.p.bcb("invoker");
        }
        locale.Xl(eNj());
      }
      ad.i(eNe(), "removeInvoker ok");
      return;
    }
    catch (Exception localException)
    {
      ad.w(eNe(), "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(localException)));
    }
  }
  
  public final boolean eNs()
  {
    try
    {
      Wt(this.DGx);
      boolean bool = Wt(this.DGw);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void eNt() {}
  
  protected void eNu() {}
  
  public final boolean eNv()
  {
    return !Ws(this.DGw);
  }
  
  public final void g(final String paramString, final d.g.a.b<? super String, d.z> paramb)
  {
    d.g.b.p.h(paramString, "script");
    com.tencent.mm.ad.c.g((d.g.a.a)new w(this, paramString, paramb));
  }
  
  protected final Context getContext()
  {
    Context localContext = this.omW.getContext();
    d.g.b.p.g(localContext, "viewWV.context");
    return localContext;
  }
  
  public final String getCurrentUrl()
  {
    if (d.n.n.aE((CharSequence)this.DGc)) {
      return this.DGb;
    }
    return this.DGc;
  }
  
  public final Intent getIntent()
  {
    Intent localIntent = this.intent;
    if (localIntent == null) {
      d.g.b.p.bcb("intent");
    }
    return localIntent;
  }
  
  public final com.tencent.mm.plugin.webview.c.f getJsapi()
  {
    return (com.tencent.mm.plugin.webview.c.f)this.DGg.getValue();
  }
  
  protected final int getScreenOrientation()
  {
    Iterator localIterator = ((Iterable)this.DGm).iterator();
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
    eNm();
    Wr(this.DGt);
    this.omW.a((com.tencent.mm.ui.widget.i)new d());
  }
  
  protected final boolean isStarted()
  {
    try
    {
      boolean bool = this.DGO.contains(d.g.b.z.bp(Start.class).getSimpleName());
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
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramString, "url");
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    while (localIterator.hasNext())
    {
      j.a locala = ((j)localIterator.next()).m(paramWebView, paramString);
      if (locala.DIP) {
        return locala;
      }
    }
    return new j.a(false, false);
  }
  
  public final c.a k(String paramString, boolean paramBoolean, int paramInt)
  {
    d.g.b.p.h(paramString, "url");
    if (this.DGU.DHc)
    {
      ad.w(eNe(), "startGetA8Key neverGetA8Key ".concat(String.valueOf(paramString)));
      return c.a.DWS;
    }
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    while (localIterator.hasNext()) {
      if (((j)localIterator.next()).aGv(paramString)) {
        return c.a.DWR;
      }
    }
    paramString = eNg().a(paramString, paramBoolean, paramInt, (com.tencent.mm.plugin.webview.e.a)this.DFX.getValue());
    d.g.b.p.g(paramString, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
    return paramString;
  }
  
  protected boolean k(WebView paramWebView, String paramString)
  {
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramString, "url");
    paramWebView = j(paramWebView, paramString);
    if (paramWebView.DIP) {
      return paramWebView.result;
    }
    return false;
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    int i = 0;
    d.g.b.p.h(paramString, "url");
    ad.i(eNe(), "WebView-Trace loadUrl url ".concat(String.valueOf(paramString)));
    if (paramBoolean)
    {
      this.omW.loadUrl(paramString, (Map)ae.c(new o[] { u.S("Pragma", "no-cache"), u.S("Cache-Control", "no-cache") }));
      return;
    }
    if ((paramMap == null) || (paramMap.isEmpty())) {
      i = 1;
    }
    if (i != 0)
    {
      this.omW.loadUrl(paramString);
      return;
    }
    this.omW.loadUrl(paramString, paramMap);
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 1966	com/tencent/mm/plugin/webview/core/BaseWebViewController:DGd	Z
    //   7: aload_0
    //   8: getfield 1964	com/tencent/mm/plugin/webview/core/BaseWebViewController:DGe	Z
    //   11: ifne +7 -> 18
    //   14: aload_0
    //   15: invokevirtual 2046	com/tencent/mm/plugin/webview/core/BaseWebViewController:eNr	()V
    //   18: aload_0
    //   19: getfield 2048	com/tencent/mm/plugin/webview/core/BaseWebViewController:DGQ	Lcom/tencent/mm/plugin/webview/core/c;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +27 -> 51
    //   27: aload_1
    //   28: checkcast 2050	java/io/Closeable
    //   31: astore_3
    //   32: aload_0
    //   33: invokevirtual 866	com/tencent/mm/plugin/webview/core/BaseWebViewController:eNe	()Ljava/lang/String;
    //   36: ldc_w 2052
    //   39: invokestatic 938	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 2058	d/z:MKo	Ld/z;
    //   45: astore_1
    //   46: aload_3
    //   47: aconst_null
    //   48: invokestatic 2063	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   51: aload_0
    //   52: invokevirtual 1106	com/tencent/mm/plugin/webview/core/BaseWebViewController:aPk	()Lcom/tencent/mm/sdk/platformtools/ap;
    //   55: aload_0
    //   56: invokevirtual 1109	com/tencent/mm/plugin/webview/core/BaseWebViewController:eNk	()Ljava/lang/Runnable;
    //   59: invokevirtual 2066	com/tencent/mm/sdk/platformtools/ap:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   62: aload_0
    //   63: invokevirtual 1919	com/tencent/mm/plugin/webview/core/BaseWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   66: invokevirtual 2069	com/tencent/mm/plugin/webview/c/f:detach	()V
    //   69: aload_0
    //   70: invokespecial 1059	com/tencent/mm/plugin/webview/core/BaseWebViewController:eNi	()Lcom/tencent/mm/plugin/webview/c/i;
    //   73: invokevirtual 2070	com/tencent/mm/plugin/webview/c/i:detach	()V
    //   76: aload_0
    //   77: invokevirtual 791	com/tencent/mm/plugin/webview/core/BaseWebViewController:eNg	()Lcom/tencent/mm/plugin/webview/e/c;
    //   80: invokevirtual 2072	com/tencent/mm/plugin/webview/e/c:destroy	()V
    //   83: return
    //   84: astore_2
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_3
    //   89: aload_2
    //   90: invokestatic 2063	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
    Iterator localIterator = ((Iterable)this.DGo).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).onFinish();
    }
  }
  
  public final void reload()
  {
    if ((this.omW == null) || (bt.isNullOrNil(this.omW.getUrl()))) {
      return;
    }
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      String str = this.omW.getUrl();
      d.g.b.p.g(str, "viewWV.url");
      if (localj.XR(Ok(str))) {
        return;
      }
    }
    ad.i(eNe(), "reload");
    this.omW.reload();
  }
  
  protected final void setIntent(Intent paramIntent)
  {
    d.g.b.p.h(paramIntent, "<set-?>");
    this.intent = paramIntent;
  }
  
  protected final void uT(boolean paramBoolean)
  {
    Iterator localIterator = ((Iterable)this.DGo).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).uT(paramBoolean);
    }
  }
  
  public final void z(int paramInt, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramString1 = this.omW.getSettings();
      if (paramString1 != null) {
        paramString1.setJavaScriptEnabled(false);
      }
      this.omW.loadData(paramString2, "text/html", "utf-8");
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Auth
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214204);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(d.g.b.z.bp(BaseWebViewController.Inject.class), paramString)) && (waitFor(localBaseWebViewController.DGu)) && ((localBaseWebViewController.DGU.DHc) || (localBaseWebViewController.lvw.has(paramString)) || (waitFor(localBaseWebViewController.DGy, paramString))))
      {
        AppMethodBeat.o(214204);
        return true;
      }
      AppMethodBeat.o(214204);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Bind
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(214206);
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(localBaseWebViewController.DGv)) && (waitFor(localBaseWebViewController.DGu)))
      {
        AppMethodBeat.o(214206);
        return true;
      }
      AppMethodBeat.o(214206);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  public static abstract class ControllerAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify();
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Init
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(214208);
      boolean bool = waitFor(getController().DGt);
      AppMethodBeat.o(214208);
      return bool;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Inject
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214209);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((!localBaseWebViewController.omW.fLC()) && (!waitFor(localBaseWebViewController.DGD, paramString))) || (((waitFor(localBaseWebViewController.DGu)) && ((localBaseWebViewController.DGU.DHc) || (localBaseWebViewController.lvw.has(paramString)) || (waitFor(localBaseWebViewController.DGy, paramString)))) || (localBaseWebViewController.bQo())))
      {
        AppMethodBeat.o(214209);
        return true;
      }
      AppMethodBeat.o(214209);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"})
  @Keep
  protected static abstract class PageAction
    extends BaseWebViewController.WebAction
  {
    public abstract boolean verify(String paramString);
    
    public final boolean waitFor(int paramInt, String paramString)
    {
      d.g.b.p.h(paramString, "url");
      return ((d.g.b.p.i(paramString, getController().DGa)) || (getController().DGH.contains(Integer.valueOf(paramInt)))) && (BaseWebViewController.b(getController()).contains(Integer.valueOf(paramInt)));
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarEnd;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarEnd
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214212);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((localBaseWebViewController.bQn()) && ((localBaseWebViewController.bQp()) || (waitFor(d.g.b.z.bp(BaseWebViewController.Ready.class), paramString)) || (waitFor(localBaseWebViewController.DGE, paramString)) || (waitFor(localBaseWebViewController.DGD, paramString)) || (waitFor(localBaseWebViewController.DGz, paramString))))
      {
        AppMethodBeat.o(214212);
        return true;
      }
      AppMethodBeat.o(214212);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarStart;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class ProgressBarStart
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214213);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(d.g.b.z.bp(BaseWebViewController.Start.class))) && (((!localBaseWebViewController.Ws(localBaseWebViewController.DGx)) && ((waitFor(localBaseWebViewController.DGB, paramString)) || (waitFor(localBaseWebViewController.DGA, paramString)))) || ((!waitFor(d.g.b.z.bp(BaseWebViewController.ProgressBarEnd.class), paramString)) && (localBaseWebViewController.Ws(localBaseWebViewController.DGx)) && (waitFor(localBaseWebViewController.DGC, paramString)))))
      {
        AppMethodBeat.o(214213);
        return true;
      }
      AppMethodBeat.o(214213);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
  @Keep
  protected static final class Ready
    extends BaseWebViewController.PageAction
  {
    public final boolean verify(String paramString)
    {
      AppMethodBeat.i(214215);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if (((waitFor(d.g.b.z.bp(BaseWebViewController.Start.class))) && (waitFor(d.g.b.z.bp(BaseWebViewController.Auth.class), paramString)) && ((waitFor(localBaseWebViewController.DGE, paramString)) || (localBaseWebViewController.omW.fLC()))) || (localBaseWebViewController.bQp()))
      {
        AppMethodBeat.o(214215);
        return true;
      }
      AppMethodBeat.o(214215);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"})
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
      AppMethodBeat.i(214216);
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = getController();
      if ((waitFor(d.g.b.z.bp(BaseWebViewController.Ready.class), paramString)) && (waitFor(localBaseWebViewController.DGF, paramString)))
      {
        AppMethodBeat.o(214216);
        return true;
      }
      AppMethodBeat.o(214216);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
  @Keep
  protected static final class Start
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(214217);
      Object localObject = getController();
      if ((waitFor(((BaseWebViewController)localObject).DGv)) && ((!((BaseWebViewController)localObject).bQt()) || (waitFor(((BaseWebViewController)localObject).DGu))))
      {
        if (((CharSequence)((BaseWebViewController)localObject).bQm()).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            localObject = (CharSequence)((BaseWebViewController)localObject).eNl();
            if ((localObject != null) && (!d.n.n.aE((CharSequence)localObject))) {
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
          AppMethodBeat.o(214217);
          return true;
          i = 0;
          break;
        }
      }
      label102:
      AppMethodBeat.o(214217);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"})
  @Keep
  public static abstract class WebAction
  {
    public BaseWebViewController controller;
    private final boolean keep;
    
    public final BaseWebViewController getController()
    {
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.p.bcb("controller");
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
        d.g.b.p.bcb("controller");
      }
      return BaseWebViewController.c(localBaseWebViewController).contains(Integer.valueOf(paramInt));
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.ControllerAction> paramb)
    {
      d.g.b.p.h(paramb, "clazz");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.p.bcb("controller");
      }
      return BaseWebViewController.d(localBaseWebViewController).contains(paramb.getSimpleName());
    }
    
    public final boolean waitFor(d.l.b<? extends BaseWebViewController.PageAction> paramb, String paramString)
    {
      d.g.b.p.h(paramb, "clazz");
      d.g.b.p.h(paramString, "url");
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController == null) {
        d.g.b.p.bcb("controller");
      }
      if (d.g.b.p.i(paramString, localBaseWebViewController.DGa))
      {
        paramString = this.controller;
        if (paramString == null) {
          d.g.b.p.bcb("controller");
        }
        if (BaseWebViewController.e(paramString).contains(paramb.getSimpleName())) {
          return true;
        }
      }
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<String>
  {
    a(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "invoke"})
  static final class aa
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.i>
  {
    aa(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "invoke"})
  static final class ab
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.c.f>
  {
    ab(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class ac
    implements Runnable
  {
    ac(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(214259);
      Iterator localIterator = ((Iterable)this.DGX.DGo).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).bn(paramInt, paramString);
      }
      AppMethodBeat.o(214259);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
  static final class ad
    extends q
    implements d.g.a.a<Runnable>
  {
    ad(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"})
  public static final class ae
    extends k
  {
    public final void Cp(long paramLong)
    {
      AppMethodBeat.i(214262);
      this.DGX.aPk().postDelayed(this.DGX.eNk(), paramLong);
      AppMethodBeat.o(214262);
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.webview.core.BaseWebViewController$start$1", f="BaseWebViewController.kt", gfL={}, m="invokeSuspend")
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class af
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    int label;
    private ah nWQ;
    
    af(BaseWebViewController paramBaseWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(214264);
      d.g.b.p.h(paramd, "completion");
      paramd = new af(this.DGX, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(214264);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(214263);
      paramObject = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(214263);
        throw paramObject;
      }
      this.DGX.Wr(this.DGX.DGv);
      paramObject = d.z.MKo;
      AppMethodBeat.o(214263);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(214265);
      paramObject1 = ((af)a(paramObject1, (d.d.d)paramObject2)).cQ(d.z.MKo);
      AppMethodBeat.o(214265);
      return paramObject1;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/BaseWebViewController$tryBindService$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
  public static final class ag
    implements d
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(214266);
      d.g.b.p.h(paramc, "conn");
      if (this.DGX.eNq())
      {
        ad.i(BaseWebViewController.a(this.DGX), "WebView-Trace onConnected whent destroyCalled");
        AppMethodBeat.o(214266);
        return;
      }
      this.DGX.DGQ = paramc;
      BaseWebViewController localBaseWebViewController = this.DGX;
      paramc = paramc.eNh();
      d.g.b.p.h(paramc, "<set-?>");
      localBaseWebViewController.lvv = paramc;
      this.DGX.getJsapi().b(this.DGX.eNh());
      this.DGX.a(this.DGX.eNh());
      ad.i(BaseWebViewController.a(this.DGX), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
      if (BaseWebViewController.d(this.DGX).contains(d.g.b.z.bp(BaseWebViewController.Bind.class).getSimpleName()))
      {
        this.DGX.dWE();
        AppMethodBeat.o(214266);
        return;
      }
      this.DGX.Wr(this.DGX.DGu);
      AppMethodBeat.o(214266);
    }
    
    public final boolean eLz()
    {
      AppMethodBeat.i(214267);
      boolean bool = this.DGX.eNp();
      AppMethodBeat.o(214267);
      return bool;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class ah
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final ah DHq;
    
    static
    {
      AppMethodBeat.i(214269);
      DHq = new ah();
      AppMethodBeat.o(214269);
    }
    
    ah()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class ai
    extends q
    implements d.g.a.a<Boolean>
  {
    public static final ai DHr;
    
    static
    {
      AppMethodBeat.i(214271);
      DHr = new ai();
      AppMethodBeat.o(214271);
    }
    
    ai()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"})
  public static final class aj
    implements g.b
  {
    public final String eNw()
    {
      AppMethodBeat.i(214272);
      String str = this.DGX.getCurrentUrl();
      AppMethodBeat.o(214272);
      return str;
    }
    
    public final String eNx()
    {
      return this.DGX.DGb;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"})
  public static final class b
  {
    public static String aX(Intent paramIntent)
    {
      AppMethodBeat.i(214207);
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
          ad.e("MicroMsg.WebViewController", "getRawUrl exception:%s", new Object[] { localException.getMessage() });
          if ((localException instanceof ClassNotFoundException))
          {
            paramIntent = (Throwable)localException;
            AppMethodBeat.o(214207);
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
        AppMethodBeat.o(214207);
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (d.n.n.aE((CharSequence)localObject2)))
      {
        i = 1;
        if (i != 0) {
          break label104;
        }
        AppMethodBeat.o(214207);
        return localObject1;
      }
      return paramIntent;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZ)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getNeverGetA8Key", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"})
  public static final class c
  {
    final BaseWebViewController.f DGY;
    final boolean DGZ;
    final boolean DHa;
    final boolean DHb;
    final boolean DHc;
    
    public c(byte paramByte)
    {
      this();
    }
    
    public c(BaseWebViewController.f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      AppMethodBeat.i(214210);
      this.DGY = paramf;
      this.DGZ = paramBoolean1;
      this.DHa = paramBoolean2;
      this.DHb = paramBoolean3;
      this.DHc = paramBoolean4;
      AppMethodBeat.o(214210);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"})
  final class d
    extends com.tencent.mm.ui.widget.i
  {
    public final void a(WebView paramWebView, int paramInt)
    {
      AppMethodBeat.i(214214);
      if ((paramInt >= 100) && (!this.DGX.eNq()))
      {
        this.DGX.DGr = true;
        ad.i(BaseWebViewController.a(this.DGX), "Abe-Debug Progress 100");
        if (paramWebView != null)
        {
          Object localObject;
          if (paramWebView.supportFeature(2006))
          {
            localObject = f.DHt;
            if (!f.a.eNA()) {}
          }
          else
          {
            localObject = paramWebView.getUrl();
            if (localObject != null)
            {
              if (((CharSequence)localObject).length() == 0) {}
              for (paramInt = 1; paramInt == 0; paramInt = 0)
              {
                localObject = this.DGX;
                paramInt = this.DGX.DGD;
                BaseWebViewController localBaseWebViewController = this.DGX;
                paramWebView = paramWebView.getUrl();
                d.g.b.p.g(paramWebView, "url");
                ((BaseWebViewController)localObject).cx(paramInt, BaseWebViewController.c(localBaseWebViewController, paramWebView));
                AppMethodBeat.o(214214);
                return;
              }
            }
            ad.i(BaseWebViewController.a(this.DGX), "WebView-Trace not support PAGE_COMMIT_VISIBLE, url = null, skip check");
          }
          AppMethodBeat.o(214214);
          return;
        }
      }
      AppMethodBeat.o(214214);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", "action", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview-sdk_release"})
  public static final class e
  {
    final d.l.b<? extends BaseWebViewController.WebAction> DHd;
    final d.g.a.a<d.z> hgV;
    
    public e(d.l.b<? extends BaseWebViewController.WebAction> paramb, d.g.a.a<d.z> parama)
    {
      AppMethodBeat.i(214218);
      this.DHd = paramb;
      this.hgV = parama;
      AppMethodBeat.o(214218);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(214221);
      if (this != paramObject)
      {
        if ((paramObject instanceof e))
        {
          paramObject = (e)paramObject;
          if ((!d.g.b.p.i(this.DHd, paramObject.DHd)) || (!d.g.b.p.i(this.hgV, paramObject.hgV))) {}
        }
      }
      else
      {
        AppMethodBeat.o(214221);
        return true;
      }
      AppMethodBeat.o(214221);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(214220);
      Object localObject = this.DHd;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.hgV;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(214220);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(214219);
      String str = "WebEvent(action=" + this.DHd + ", block=" + this.hgV + ")";
      AppMethodBeat.o(214219);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"})
  public static final class f
  {
    final d.f DHe;
    final d.f DHf;
    final d.f DHg;
    final d.f DHh;
    
    public f(Intent paramIntent)
    {
      AppMethodBeat.i(214226);
      this.DHe = d.g.O((d.g.a.a)new b(paramIntent));
      this.DHf = d.g.O((d.g.a.a)new d(paramIntent));
      this.DHg = d.g.O((d.g.a.a)new a(paramIntent));
      this.DHh = d.g.O((d.g.a.a)new c(paramIntent));
      AppMethodBeat.o(214226);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<Boolean>
    {
      a(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<Boolean>
    {
      b(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class c
      extends q
      implements d.g.a.a<Boolean>
    {
      c(Intent paramIntent)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.c>
  {
    public static final g DHi;
    
    static
    {
      AppMethodBeat.i(214229);
      DHi = new g();
      AppMethodBeat.o(214229);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements d.g.a.a<d.z>
  {
    i(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements d.g.a.a<d.z>
  {
    k(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements d.g.a.a<d.z>
  {
    l(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements d.g.a.a<d.z>
  {
    m(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements d.g.a.a<d.z>
  {
    n(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class o
    extends q
    implements d.g.a.a<d.z>
  {
    o(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class p
    extends q
    implements d.g.a.a<d.z>
  {
    p(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "invoke"})
  static final class q
    extends q
    implements d.g.a.a<com.tencent.mm.plugin.webview.e.f<avj>>
  {
    q(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class r
    extends q
    implements d.g.a.a<Integer>
  {
    r(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(BaseWebViewController paramBaseWebViewController, int paramInt) {}
    
    public final void run()
    {
      int j = 0;
      AppMethodBeat.i(214245);
      if (paramInt < 0) {}
      for (int i = 1; (d.ac.MKp) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(214245);
        throw ((Throwable)localObject);
      }
      ad.i(BaseWebViewController.a(this.DGX), "checkStatus:" + paramInt + " to [" + d.a.j.a((Iterable)BaseWebViewController.c(this.DGX), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.b(this.DGX), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.e(this.DGX), (CharSequence)",", null, null, 0, null, null, 62) + ']');
      BaseWebViewController.c(this.DGX).add(Integer.valueOf(paramInt));
      BaseWebViewController.a(this.DGX, (Iterable)BaseWebViewController.f(this.DGX), (Set)BaseWebViewController.d(this.DGX));
      Object localObject = (CharSequence)this.DGX.DGa;
      if (localObject != null)
      {
        i = j;
        if (!d.n.n.aE((CharSequence)localObject)) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        BaseWebViewController.a(this.DGX, (Iterable)BaseWebViewController.g(this.DGX), (Set)BaseWebViewController.e(this.DGX), this.DGX.DGa);
      }
      d.a.j.a((Iterable)BaseWebViewController.a(this.DGX, paramInt), (d.g.a.b)1.DHk);
      AppMethodBeat.o(214245);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(214246);
      Object localObject;
      if (paramInt > 0)
      {
        localObject = (CharSequence)paramString;
        if ((localObject == null) || (d.n.n.aE((CharSequence)localObject)))
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
        if ((!d.ac.MKp) || (i != 0)) {
          break label79;
        }
        localObject = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(214246);
        throw ((Throwable)localObject);
        i = 0;
        break;
      }
      label79:
      if ((d.g.b.p.i(paramString, this.DGX.DGa)) || ((this.DGX.DGG.contains(Integer.valueOf(paramInt))) && (d.g.b.p.i(paramString, this.DGX.DGc))) || (this.DGX.DGH.contains(Integer.valueOf(paramInt))))
      {
        ad.i(BaseWebViewController.a(this.DGX), "checkStatus:" + paramInt + ' ' + paramString + " to [" + d.a.j.a((Iterable)BaseWebViewController.c(this.DGX), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.b(this.DGX), (CharSequence)",", null, null, 0, null, null, 62) + "] [" + d.a.j.a((Iterable)BaseWebViewController.e(this.DGX), (CharSequence)",", null, null, 0, null, null, 62) + ']');
        BaseWebViewController.b(this.DGX).add(Integer.valueOf(paramInt));
        BaseWebViewController.a(this.DGX, (Iterable)BaseWebViewController.g(this.DGX), (Set)BaseWebViewController.e(this.DGX), this.DGX.DGa);
        AppMethodBeat.o(214246);
        return;
      }
      ad.w(BaseWebViewController.a(this.DGX), "checkStatus skip: " + paramInt + ", url=" + paramString + ", startUrl=" + this.DGX.DGa);
      AppMethodBeat.o(214246);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements d.g.a.a<String>
  {
    u(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class v
    extends q
    implements d.g.a.a<d.z>
  {
    v(BaseWebViewController paramBaseWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class w
    extends q
    implements d.g.a.a<d.z>
  {
    w(BaseWebViewController paramBaseWebViewController, String paramString, d.g.a.b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
  static final class x
    extends q
    implements d.g.a.a<ap>
  {
    public static final x DHm;
    
    static
    {
      AppMethodBeat.i(214252);
      DHm = new x();
      AppMethodBeat.o(214252);
    }
    
    x()
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"setConfigCallback", "", "windowManager", "Landroid/view/WindowManager;", "invoke"})
  static final class y
    extends q
    implements d.g.a.b<WindowManager, d.z>
  {
    public static final y DHn;
    
    static
    {
      AppMethodBeat.i(214255);
      DHn = new y();
      AppMethodBeat.o(214255);
    }
    
    y()
    {
      super();
    }
    
    public static void b(WindowManager paramWindowManager)
    {
      AppMethodBeat.i(214254);
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
          AppMethodBeat.o(214254);
          return;
        }
        localField = localField.getType().getDeclaredField("mWindowManager");
        d.g.b.p.g(localField, "field");
        localField.setAccessible(true);
        localField.set(localObject, paramWindowManager);
        AppMethodBeat.o(214254);
        return;
      }
      catch (Exception paramWindowManager)
      {
        AppMethodBeat.o(214254);
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/webview/core/BaseWebViewController$intercept$1$1"})
  static final class z
    implements Runnable
  {
    z(WebResourceRequest paramWebResourceRequest, BaseWebViewController paramBaseWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(214256);
      ad.i(BaseWebViewController.a(jdField_this), "shouldInterceptRequest, url = " + this.DHo.getUrl() + ", method = " + this.DHo.getMethod() + ", isForMainFrame = " + this.DHo.isForMainFrame());
      AppMethodBeat.o(214256);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController
 * JD-Core Version:    0.7.0.1
 */