package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.c.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.k.n.b;
import com.tencent.mm.plugin.webview.model.ag.a;
import com.tencent.mm.plugin.webview.model.ag.b;
import com.tencent.mm.plugin.webview.model.ag.c;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.av;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.b;
import com.tencent.mm.plugin.webview.model.ba.c;
import com.tencent.mm.plugin.webview.model.ba.f;
import com.tencent.mm.plugin.webview.model.ba.g;
import com.tencent.mm.plugin.webview.model.ba.k;
import com.tencent.mm.plugin.webview.model.ba.l;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.f.a.a;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.r;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import junit.framework.Assert;
import kotlin.a.ae;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "OauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "WC_TAG", "getWC_TAG", "()Ljava/lang/String;", "WC_TAG$delegate", "Lkotlin/Lazy;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;)V", "pageEndTime", "pageStarted", "getPageStarted", "setPageStarted", "(Z)V", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "kotlin.jvm.PlatformType", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "webTransNewFloatStoreInfo", "Lcom/tencent/mm/plugin/webview/WebTransNewFloatStoreInfo;", "getWebTransNewFloatStoreInfo", "()Lcom/tencent/mm/plugin/webview/WebTransNewFloatStoreInfo;", "setWebTransNewFloatStoreInfo", "(Lcom/tencent/mm/plugin/webview/WebTransNewFloatStoreInfo;)V", "webViewFloatBallInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "getWebViewFloatBallInfo", "()Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "webViewMenuHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "getWebViewMenuHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "setWebViewMenuHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;)V", "webViewUIProxyImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "getWebViewUIProxyImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "setWebViewUIProxyImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;)V", "webViewUIStyleHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "getWebViewUIStyleHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "setWebViewUIStyleHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;)V", "getWebviewReportMgr", "()Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "", "", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "dealWeixinScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getA8keyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getCachedAppId", "getScene", "username", "getWebViewPluginClientProxy", "handleUrl", "initEnviroment", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "loadUrl", "httpHeaders", "withoutCache", "needSyncGetA8Key", "onBinded", "onDestroy", "onFloatBallDestroy", "onJsReady", "onLoadResource", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "onWebViewUIDestroy", "overrideProcessResult", "resp", "overrideUrl", "webView", "releaseWebView", "removeSceneEnd", "requestSetFontSize", "fontSize", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "Companion", "SceneEndCallbacker", "VisitInfoReport", "WebViewControllerOnSceneEndDelegate", "WebViewUIDelegateImpl", "plugin-webview_release"})
public class i
  extends BaseWebViewController
{
  public static final d PIy;
  private final kotlin.f PHF;
  private final kotlin.f PHG;
  public com.tencent.mm.plugin.webview.ui.tools.k PHH;
  public com.tencent.mm.plugin.webview.ui.tools.p PHI;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h PHJ;
  public final com.tencent.mm.plugin.webview.ui.tools.floatball.c PHK;
  public com.tencent.mm.plugin.webview.j PHL;
  private final kotlin.f PHM;
  private final kotlin.f PHN;
  private final kotlin.f PHO;
  private final kotlin.f PHP;
  public final ar PHQ;
  private final kotlin.f PHR;
  private final kotlin.f PHS;
  public String PHT;
  private final kotlin.f PHU;
  public boolean PHV;
  private final String PHW;
  private final Set<String> PHX;
  private final kotlin.f PHY;
  public final ag.c PHZ;
  u PIa;
  private long PIb;
  private final List<com.tencent.mm.plugin.webview.d.d.a> PIc;
  private final l PId;
  private final j PIe;
  private final e PIf;
  private final k PIg;
  private final n PIh;
  private final a PIi;
  private String PIj;
  private final boolean PIk;
  private final r PIl;
  private final i PIm;
  private final q PIn;
  private final g PIp;
  private final b PIq;
  private final o PIr;
  private final c PIs;
  private long PIt;
  private final f PIu;
  private final h PIv;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c PIw;
  public final ba PIx;
  
  static
  {
    AppMethodBeat.i(230253);
    PIy = new d((byte)0);
    AppMethodBeat.o(230253);
  }
  
  public i(MMWebView paramMMWebView, ba paramba, BaseWebViewController.d paramd)
  {
    this(paramMMWebView, paramba, paramd, null, 16);
    AppMethodBeat.i(230247);
    AppMethodBeat.o(230247);
  }
  
  public i(final MMWebView paramMMWebView, ba paramba, BaseWebViewController.d paramd, Set<String> paramSet, com.tencent.mm.plugin.webview.d.e parame)
  {
    super(paramMMWebView, paramd, paramSet, parame);
    AppMethodBeat.i(230240);
    this.PIx = paramba;
    this.PHF = kotlin.g.ar((kotlin.g.a.a)new t(this));
    this.PHG = kotlin.g.ar((kotlin.g.a.a)aj.PJd);
    this.PHK = new com.tencent.mm.plugin.webview.ui.tools.floatball.c();
    this.PHM = kotlin.g.ar((kotlin.g.a.a)new x(this));
    this.PHN = kotlin.g.ar((kotlin.g.a.a)new z(this));
    this.PHO = kotlin.g.ar((kotlin.g.a.a)new y(this));
    this.PHP = kotlin.g.ar((kotlin.g.a.a)new ak(this));
    getContext();
    this.PHQ = new ar();
    this.PHR = kotlin.g.ar((kotlin.g.a.a)new aa(this));
    this.PHS = kotlin.g.ar((kotlin.g.a.a)new ai(paramMMWebView));
    this.PHU = kotlin.g.ar((kotlin.g.a.a)ag.PJc);
    this.PHW = "file:///android_asset/jsapi/wxjs.js";
    this.PHX = ((Set)new HashSet());
    this.PHY = kotlin.g.ar((kotlin.g.a.a)new ah(this));
    this.PHZ = ((ag.c)new v(new WeakReference(this)));
    this.PIa = new u(new WeakReference(this));
    this.PIc = ((List)new ArrayList());
    this.PId = new l(this);
    this.PIe = new j(this);
    this.PIf = new e(this);
    this.PIg = new k(this);
    this.PIh = new n(this);
    this.PIi = new a(this);
    this.PIk = true;
    this.PIl = new r(this, paramMMWebView);
    this.PIm = new i(this);
    this.PIn = new q(this);
    this.PIp = new g(this);
    this.PIq = new b(this);
    this.PIr = new o(this);
    this.PIs = new c(this);
    this.PIu = new f(this, paramMMWebView);
    this.PIv = new h(this);
    AppMethodBeat.o(230240);
  }
  
  private final boolean bIF(String paramString)
  {
    AppMethodBeat.i(293085);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(293085);
      return false;
    }
    for (;;)
    {
      try
      {
        if ((com.tencent.luggage.k.c.a(paramString, "weixin://jump/", true)) || (com.tencent.luggage.k.c.a(paramString, "weixin://scanqrcode/", true)))
        {
          bjA(paramString);
          AppMethodBeat.o(293085);
          return true;
        }
        if ((com.tencent.luggage.k.c.a(paramString, "weixin://dl/business", true)) && (com.tencent.mm.pluginsdk.g.n(Uri.parse(paramString))))
        {
          localObject1 = Uri.parse(cDu());
          kotlin.g.b.p.j(localObject1, "rawUrlUri");
          localObject2 = ((Uri)localObject1).getHost();
          localObject1 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject1).addCategory("android.intent.category.BROWSABLE");
          ((Intent)localObject1).setData(Uri.parse(paramString + "&domain=" + (String)localObject2));
          i = ((Intent)localObject1).getIntExtra("pay_channel", -1);
          if (i != -1)
          {
            Log.i(gSK(), "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
            ((Intent)localObject1).putExtra("pay_channel", i);
          }
          ((Intent)localObject1).putExtra("translate_link_scene", 13);
          localObject2 = getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealWeixinScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/webview/core/WebViewController", "dealWeixinScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(293085);
          return true;
        }
        if (!com.tencent.luggage.k.c.G(paramString, "weixinpreinject://iframe")) {
          continue;
        }
        Log.i(gSK(), "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
      }
      catch (Exception localException)
      {
        Object localObject2;
        Log.w(gSK(), "shouldOverride, jumpToActivity, ex = " + localException.getMessage());
        continue;
        if (!com.tencent.luggage.k.c.G(paramString, "weixin://")) {
          continue;
        }
        Log.e(gSK(), "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        AppMethodBeat.o(293085);
        return true;
        AppMethodBeat.o(293085);
      }
      if (bjE(paramString))
      {
        AppMethodBeat.o(293085);
        return true;
        if ((com.tencent.luggage.k.c.G(paramString, "weixin://dl/login/common_view")) || (com.tencent.luggage.k.c.G(paramString, "weixin://dl/login/phone_view")))
        {
          localObject1 = cDu();
          localObject2 = com.tencent.mm.pluginsdk.g.QRS;
          kotlin.g.b.p.j(localObject2, "DeepLinkHelper.PREFIX_SUPPORT_QQ");
          if (!com.tencent.luggage.k.c.G((String)localObject1, (String)localObject2))
          {
            localObject1 = com.tencent.mm.pluginsdk.g.QRT;
            kotlin.g.b.p.j(localObject1, "DeepLinkHelper.PREFIX_SUPPORT_WECHAT");
            if (!com.tencent.luggage.k.c.G(paramString, (String)localObject1)) {
              continue;
            }
          }
          if (!((Boolean)this.PHN.getValue()).booleanValue()) {
            continue;
          }
          com.tencent.mm.pluginsdk.g.cr(this.pHS.getActivityContextIfHas(), paramString);
          onFinish();
          AppMethodBeat.o(293085);
          return true;
        }
        if ((!com.tencent.luggage.k.c.G(paramString, "weixin://webview/initReady/")) && (!com.tencent.luggage.k.c.G(paramString, "weixin://webview/preInjectJSBridge/"))) {
          continue;
        }
        AppMethodBeat.o(293085);
        return true;
      }
    }
    return false;
  }
  
  private void bjA(String paramString)
  {
    AppMethodBeat.i(230195);
    kotlin.g.b.p.k(paramString, "url");
    boolean bool = getIntent().getBooleanExtra(f.r.VSY, false);
    if ((this.pGD.gWJ().hoS()) || (bool))
    {
      Log.i(gSK(), "allowJumpWithoutPerm: ".concat(String.valueOf(bool)));
      Bundle localBundle = new Bundle();
      localBundle.putInt("fromScene", 100);
      if (gSm().a(paramString, this.pGD.gWI().so(7), localBundle))
      {
        Log.i(gSK(), "shouldOverride, built in url handled, url = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(230195);
      }
    }
    else
    {
      Log.w(gSK(), "shouldOverride, allow inner open url, not allow");
    }
    AppMethodBeat.o(230195);
  }
  
  private final boolean bjB(String paramString)
  {
    AppMethodBeat.i(230207);
    if (Util.isNullOrNil(paramString))
    {
      Log.e(gSK(), "search contact err: null or nill url");
      AppMethodBeat.o(230207);
      return false;
    }
    gSR();
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", gSQ().gSo());
    try
    {
      gSm().z(106, localBundle);
      AppMethodBeat.o(230207);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w(gSK(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  private final boolean bjC(String paramString)
  {
    AppMethodBeat.i(230215);
    Log.i(gSK(), "dealCustomScheme, url = ".concat(String.valueOf(paramString)));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(230215);
      return false;
    }
    try
    {
      if (gSm().hh(paramString))
      {
        Log.i(gSK(), "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(paramString)));
        gSm().hb(paramString, gSo());
        AppMethodBeat.o(230215);
        return true;
      }
    }
    catch (Exception localException1)
    {
      Log.w(gSK(), "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      Object localObject5 = Uri.parse(paramString);
      label458:
      label482:
      label496:
      label633:
      label638:
      Object localObject2;
      if ((localObject5 != null) && (!kotlin.n.n.M(paramString, "weixin://", false)) && (!kotlin.n.n.M(paramString, "http", false)))
      {
        if (kotlin.n.n.M(paramString, "tel:", false))
        {
          paramString = kotlin.n.n.l(paramString, "tel:", "", false);
          if (!Util.isNullOrNil(paramString)) {}
          try
          {
            gSm().hd(paramString, gSo());
            AppMethodBeat.o(230215);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Log.w(gSK(), "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
            }
          }
        }
        Object localObject1;
        Object localObject4;
        Object localObject3;
        if ((kotlin.n.n.M(paramString, "sms:", false)) || (kotlin.n.n.M(paramString, "smsto:", false)))
        {
          if (this.pHS.getActivityContextIfHas() == null)
          {
            Log.e(gSK(), "sms, viewWV.activityContextIfHas = null");
            AppMethodBeat.o(230215);
            return true;
          }
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.f.QcA;
          localObject4 = this.pHS.getActivityContextIfHas();
          kotlin.g.b.p.j(localObject4, "viewWV.activityContextIfHas");
          kotlin.g.b.p.k(localObject4, "context");
          kotlin.g.b.p.k(paramString, "url");
          kotlin.g.b.p.k(localObject4, "context");
          kotlin.g.b.p.k(paramString, "url");
          localObject1 = new kotlin.n.k("sms:(\\d*)(\\?body=(.*))?");
          localObject3 = URLDecoder.decode(paramString, "UTF-8");
          kotlin.g.b.p.j(localObject3, "decodedUrl");
          localObject3 = ((kotlin.n.k)localObject1).aZ((CharSequence)localObject3);
          if (localObject3 != null)
          {
            localObject1 = ((kotlin.n.i)localObject3).iQA();
            if (localObject1 != null)
            {
              localObject1 = (String)kotlin.a.j.M((List)localObject1, 1);
              if (localObject3 == null) {
                break label536;
              }
              localObject3 = ((kotlin.n.i)localObject3).iQA();
              if (localObject3 == null) {
                break label536;
              }
              localObject3 = (String)kotlin.a.j.M((List)localObject3, 3);
              localObject5 = (CharSequence)localObject1;
              if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
                break label542;
              }
              i = 1;
              if (i == 0) {
                break label547;
              }
              localObject1 = ((Context)localObject4).getString(c.i.url_handler_sms_no_body_number);
              if (Util.isNullOrNil((String)localObject1)) {
                break label742;
              }
              com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f.a.a((Context)localObject4, (String)localObject1, paramString));
            }
          }
          for (;;)
          {
            AppMethodBeat.o(230215);
            return true;
            localObject1 = null;
            break;
            label536:
            localObject3 = null;
            break label458;
            label542:
            i = 0;
            break label482;
            label547:
            localObject5 = (CharSequence)localObject1;
            if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
            {
              i = 1;
              label571:
              if (i != 0) {
                break label638;
              }
              localObject5 = (CharSequence)localObject3;
              if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
                break label633;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label638;
              }
              localObject1 = Util.safeFormatString(((Context)localObject4).getString(c.i.url_handler_sms_no_body_with_number), new Object[] { localObject1 });
              break;
              i = 0;
              break label571;
            }
            localObject5 = (CharSequence)localObject1;
            if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
            {
              i = 1;
              label662:
              if (i != 0) {
                break label734;
              }
              localObject5 = (CharSequence)localObject3;
              if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
                break label729;
              }
            }
            label729:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label734;
              }
              localObject1 = Util.safeFormatString(((Context)localObject4).getString(c.i.url_handler_sms_with_body_number), new Object[] { localObject3, localObject1 });
              break;
              i = 0;
              break label662;
            }
            label734:
            localObject1 = "";
            break label496;
            label742:
            Log.e(com.tencent.mm.plugin.webview.ui.tools.f.access$getTAG$cp(), "sms, url is illegal, url = %s", new Object[] { paramString });
          }
        }
        if (kotlin.n.n.M(paramString, "mailto:", false))
        {
          paramString = new Intent("android.intent.action.SENDTO");
          paramString.addFlags(268435456);
          paramString.setData((Uri)localObject5);
          try
          {
            localObject1 = getContext();
            paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
            com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramString.aFh(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)paramString.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(230215);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Log.e(gSK(), "start mailto app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        try
        {
          if ((!this.pGD.gWJ().hoR()) && (gSm().gWY()))
          {
            Log.e(gSK(), "dealCustomScheme, not allow outer open url");
            AppMethodBeat.o(230215);
            return true;
          }
          i = getIntent().getIntExtra("key_download_restrict", 0);
          localObject1 = getIntent().getStringExtra("key_function_id");
          if (!Util.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.h.IzE.a(14596, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(1) });
          }
          if (i == 1)
          {
            Log.e(gSK(), "not allow launch app by custom scheme : %s", new Object[] { paramString });
            AppMethodBeat.o(230215);
            return true;
          }
        }
        catch (Exception localException2)
        {
          Log.printErrStackTrace(gSK(), (Throwable)localException2, "", new Object[0]);
          long l = Util.nowSecond() - this.PIb;
          Log.i(gSK(), "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
          if (l <= 2L)
          {
            localObject3 = getCurrentUrl();
            localObject2 = localObject3;
          }
          try
          {
            localObject3 = com.tencent.mm.compatible.util.q.an((String)localObject3, "UTF-8");
            localObject2 = localObject3;
            localObject4 = com.tencent.mm.compatible.util.q.an(paramString, "UTF-8");
            paramString = (String)localObject4;
            localObject2 = localObject3;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              boolean bool;
              Log.i(gSK(), "formate url failed");
            }
            localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject5);
            ((Intent)localObject2).addFlags(268435456);
            if (!Util.isIntentAvailable(getContext(), (Intent)localObject2)) {
              break label1359;
            }
            paramString = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(230215);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(13983, new Object[] { Integer.valueOf(4), localObject2, paramString });
          if (getIntent().getBooleanExtra("show_openapp_dialog", true))
          {
            bool = com.tencent.mm.co.a.post((Runnable)new w(this, (Uri)localObject5));
            AppMethodBeat.o(230215);
            return bool;
          }
        }
      }
      label1359:
      AppMethodBeat.o(230215);
    }
    return false;
  }
  
  private boolean bjE(String paramString)
  {
    AppMethodBeat.i(230219);
    kotlin.g.b.p.k(paramString, "url");
    Iterator localIterator = this.PIc.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.d.d.a locala = (com.tencent.mm.plugin.webview.d.d.a)localIterator.next();
      if (locala.bjF(paramString))
      {
        Log.i(gSK(), "url handled, url = ".concat(String.valueOf(paramString)));
        boolean bool = locala.bjE(paramString);
        Log.i(gSK(), "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(230219);
        return true;
      }
    }
    AppMethodBeat.o(230219);
    return false;
  }
  
  private final String gSL()
  {
    AppMethodBeat.i(230120);
    if (!anw(this.PGi))
    {
      AppMethodBeat.o(230120);
      return "";
    }
    String str = getIntent().getStringExtra("KPublisherId");
    AppMethodBeat.o(230120);
    return str;
  }
  
  private final s gSM()
  {
    AppMethodBeat.i(230122);
    s locals = (s)this.PHP.getValue();
    AppMethodBeat.o(230122);
    return locals;
  }
  
  private final p gSQ()
  {
    AppMethodBeat.i(230202);
    p localp = (p)this.PHY.getValue();
    AppMethodBeat.o(230202);
    return localp;
  }
  
  private final void gSR()
  {
    AppMethodBeat.i(230203);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 106);
      localBundle.putInt("scene_end_listener_hash_code", gSQ().gSo());
      gSm().a(5, localBundle, gSQ().gSo());
      AppMethodBeat.o(230203);
      return;
    }
    catch (Exception localException)
    {
      Log.e(gSK(), "addSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(230203);
    }
  }
  
  public void a(WebView paramWebView, final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230133);
    if (!anw(this.PGi))
    {
      Log.i(gSK(), "onReceivedError, intent not ready");
      AppMethodBeat.o(230133);
      return;
    }
    final String str = WeChatHosts.domainString(c.i.host_mp_weixin_qq_com);
    Object localObject = ac.PIY;
    localObject = new ad(this);
    com.tencent.xweb.util.h.IT(false);
    boolean bool = NetStatusUtil.isConnected(MMApplicationContext.getContext());
    Log.e(gSK(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(155L, com.tencent.mm.plugin.webview.i.a.anZ(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.i.gz(gSL(), 1);
    com.tencent.mm.plugin.topstory.a.i.gz(gSL(), com.tencent.mm.plugin.webview.i.a.anZ(paramInt));
    com.tencent.mm.plugin.topstory.a.i.g(gSL(), cDu(), com.tencent.mm.plugin.webview.i.a.anZ(paramInt), this.PIx.gWa().enterTime);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    com.tencent.mm.plugin.webview.ui.tools.m.Qer.aoB(paramInt);
    this.PIx.gWi().errCode = paramInt;
    com.tencent.mm.plugin.webview.ui.tools.o localo = com.tencent.mm.plugin.webview.ui.tools.o.QeQ;
    com.tencent.mm.plugin.webview.ui.tools.o.setErrCode(paramInt);
    if (((Boolean)this.PHO.getValue()).booleanValue()) {
      onFinish();
    }
    try
    {
      if (kotlin.g.b.p.h(new URL(paramString2).getHost(), str)) {
        com.tencent.e.h.ZvG.d((Runnable)new ae(paramString2, paramInt, (ad)localObject, str), "WebViewUI.CheckDNS");
      }
      super.a(paramWebView, paramInt, paramString1, paramString2);
      AppMethodBeat.o(230133);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Log.printErrStackTrace(gSK(), (Throwable)localMalformedURLException, "check mp url", new Object[0]);
      }
    }
  }
  
  public final void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(230129);
    if (!anw(this.PGi))
    {
      Log.i(gSK(), "onReceivedSslError, intent not ready");
      AppMethodBeat.o(230129);
      return;
    }
    com.tencent.xweb.util.h.IT(true);
    String str;
    if (paramWebView != null)
    {
      str = paramWebView.getUrl();
      if (str != null) {
        break label214;
      }
      str = this.PFK;
      label59:
      if (str == null) {
        break label223;
      }
      Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
      kotlin.g.b.p.j(localObject, "MMKernel.service(IBrandService::class.java)");
      localObject = ((com.tencent.mm.plugin.brandservice.a.c)localObject).cyC();
      kotlin.g.b.p.j(localObject, "MMKernel.service(IBrandS…::class.java).hardCodeUrl");
      if (!kotlin.n.n.M(str, (String)localObject, false)) {
        break label223;
      }
      str = cDu();
    }
    label214:
    label223:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.i.gz(gSL(), 1);
      com.tencent.mm.plugin.topstory.a.i.gz(gSL(), 30);
      com.tencent.mm.plugin.topstory.a.i.g(gSL(), cDu(), 30, this.PIx.gWa().enterTime);
      gSN().a(str, paramr, paramSslError);
      super.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(230129);
      return;
      str = null;
      break;
      str = paramWebView.getUrl();
      break label59;
    }
  }
  
  protected final boolean a(int paramInt, String paramString, bot parambot)
  {
    AppMethodBeat.i(230166);
    kotlin.g.b.p.k(paramString, "reqUrl");
    kotlin.g.b.p.k(parambot, "resp");
    int i = parambot.SZN;
    String str = parambot.Tao;
    switch (i)
    {
    default: 
      boolean bool = super.a(paramInt, paramString, parambot);
      AppMethodBeat.o(230166);
      return bool;
    case 3: 
      Log.i(gSK(), "getA8key-app: ".concat(String.valueOf(str)));
      paramString = (CharSequence)str;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        Log.e(gSK(), "getA8key-app, fullUrl is null");
        AppMethodBeat.o(230166);
        return false;
      }
      bjC(str);
      AppMethodBeat.o(230166);
      return true;
    case 4: 
      kotlin.g.b.p.j(str, "fullUrl");
      bjB(str);
      AppMethodBeat.o(230166);
      return true;
    }
    kotlin.g.b.p.j(str, "fullUrl");
    gSR();
    paramString = new Bundle();
    paramString.putString("emoji_store_jump_url", str);
    paramString.putInt("webview_binder_id", gSQ().gSo());
    try
    {
      gSm().z(666, paramString);
      AppMethodBeat.o(230166);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w(gSK(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  public final void any(int paramInt)
  {
    AppMethodBeat.i(230200);
    final int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramInt <= 8) {}
    }
    else
    {
      i = 2;
    }
    com.tencent.e.h.ZvG.bc((Runnable)new af(this, i));
    AppMethodBeat.o(230200);
  }
  
  protected boolean aqn(String paramString)
  {
    return false;
  }
  
  protected final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(230148);
    kotlin.g.b.p.k(paramWebView, "webview");
    kotlin.g.b.p.k(paramWebResourceRequest, "request");
    if ((isStarted()) && (anw(this.PGh)))
    {
      Object localObject = this.PHQ;
      String str = paramWebResourceRequest.getUrl().toString();
      if (!((Boolean)this.PHR.getValue()).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = ((ar)localObject).a(str, paramWebResourceRequest, bool, gSm());
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(230148);
        return localObject;
      }
    }
    paramWebView = super.b(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(230148);
    return paramWebView;
  }
  
  public final void b(com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(230173);
    String str = gSK();
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (parame != null) {
        break;
      }
      Log.f(gSK(), "service connect success, while invoker is null");
      onFinish();
      AppMethodBeat.o(230173);
      return;
    }
    try
    {
      parame.a((com.tencent.mm.plugin.webview.stub.f)gSQ(), gSQ().gSo());
      super.b(parame);
      AppMethodBeat.o(230173);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(gSK(), "addCallback fail, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(230147);
    super.b(paramWebView, paramString);
    this.PFY.bU("onPageFinished", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.b(this.pHS, paramString);
    if (aqn(paramString))
    {
      AppMethodBeat.o(230147);
      return;
    }
    Log.i(gSK(), "edw onPageFinished opt, url = %s", new Object[] { paramString });
    this.PIx.gWh().dw(paramString);
    com.tencent.mm.plugin.webview.ui.tools.m.Qer.OR();
    gSO().add(paramString);
    boolean bool = getIntent().getBooleanExtra("shouldForceViewPort", false);
    Log.d(gSK(), "hy: shouldForceViewPort: ".concat(String.valueOf(bool)));
    Object localObject;
    if (bool)
    {
      localObject = getIntent().getStringExtra("view_port_code");
      if (paramWebView == null) {
        kotlin.g.b.p.iCn();
      }
      paramWebView.evaluateJavascript((String)localObject, null);
    }
    if (paramString == null) {
      kotlin.g.b.p.iCn();
    }
    if (bjt(paramString))
    {
      Log.f(gSK(), "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(230147);
      return;
    }
    if (kotlin.g.b.p.h(paramString, this.PHW))
    {
      Log.i(gSK(), "onPageFinished, js is finished loaded");
      AppMethodBeat.o(230147);
      return;
    }
    this.PIx.gVX().blc(paramString);
    this.PIx.gVY().bla(paramString);
    this.PIx.gWb().report();
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      localObject = paramWebView.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.PIx.gWi().GZf = ((SnsAdClick)localObject);
        localObject = this.PIx.gWi();
        String str = String.valueOf(System.currentTimeMillis());
        kotlin.g.b.p.j(paramWebView, "uxInfo");
        ((av)localObject).V(new String[] { paramString, "1", str, paramWebView });
        this.PIx.gWi().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.o.QeQ;
    com.tencent.mm.plugin.webview.ui.tools.o.a(getIntent(), paramString, true);
    this.PIb = Util.nowSecond();
    AppMethodBeat.o(230147);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(230139);
    kotlin.g.b.p.k(paramWebView, "view");
    kotlin.g.b.p.k(paramString, "url");
    this.PHV = true;
    super.b(paramWebView, paramString, paramBitmap);
    this.PFY.bU("onPageStarted", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.b(this.pHS, paramString);
    if (aqn(paramString))
    {
      AppMethodBeat.o(230139);
      return;
    }
    if (!this.pHS.supportFeature(2006)) {
      getJsapi().gUd();
    }
    com.tencent.mm.plugin.webview.k.p.l(paramString, getContext());
    Log.i(gSK(), "edw onPageStarted opt, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.i.gz(gSL(), 0);
    if ((CrashReportFactory.hasDebuger()) && (kotlin.g.b.p.h("http://www.dktest-mmcrash.com/", paramString))) {
      Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    }
    this.PHT = this.PFK;
    long l = Util.nowSecond();
    paramWebView = gSM();
    kotlin.g.b.p.k(paramString, "targetUrl");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new i.s.a(paramWebView, paramString, l));
    this.PIx.gVZ().PVX = this.PHT;
    this.PFK = paramString;
    com.tencent.mm.plugin.webview.ui.tools.m.Qer.dv(paramString);
    Log.d(gSK(), "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { this.PHT, this.PFK });
    if (bjt(paramString))
    {
      Log.f(gSK(), "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(230139);
      return;
    }
    gSO().add(paramString);
    this.PIx.gVX().cU(bXC(), gSL()).blb(paramString);
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      paramBitmap = paramWebView.getParcelable("KSnsAdTag");
      if ((paramBitmap != null) && ((paramBitmap instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.PIx.gWi().GZf = ((SnsAdClick)paramBitmap);
        paramBitmap = this.PIx.gWi();
        String str = String.valueOf(System.currentTimeMillis());
        kotlin.g.b.p.j(paramWebView, "uxInfo");
        paramBitmap.V(new String[] { paramString, "0", str, paramWebView });
        this.PIx.gWi().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.o.QeQ;
    com.tencent.mm.plugin.webview.ui.tools.o.a(getIntent(), paramString, false);
    AppMethodBeat.o(230139);
  }
  
  public final void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(230142);
    kotlin.g.b.p.k(paramWebView, "view");
    kotlin.g.b.p.k(paramString, "url");
    this.PFK = paramString;
    super.b(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(230142);
  }
  
  public final boolean b(int paramInt, String paramString, bot parambot)
  {
    AppMethodBeat.i(230159);
    kotlin.g.b.p.k(paramString, "reqUrl");
    kotlin.g.b.p.k(parambot, "response");
    Object localObject = parambot.Tay;
    if (localObject != null) {}
    for (long l = ((afh)localObject).SrF;; l = -1L)
    {
      this.PIt = l;
      boolean bool = this.pHS.getIsX5Kernel();
      localObject = parambot.Tao;
      kotlin.g.b.p.j(localObject, "response.FullURL");
      ba.bg(bool, kotlin.n.n.M((String)localObject, "https://", false));
      this.PIx.gVW().da(paramString, true);
      this.PIx.gVY().cT(com.tencent.mm.plugin.webview.ui.tools.game.i.gco, gSL()).bkY(parambot.Tao);
      bool = super.b(paramInt, paramString, parambot);
      AppMethodBeat.o(230159);
      return bool;
    }
  }
  
  public final int bXC()
  {
    AppMethodBeat.i(230217);
    int i = bjD(getIntent().getStringExtra("geta8key_username"));
    AppMethodBeat.o(230217);
    return i;
  }
  
  protected void bXH()
  {
    AppMethodBeat.i(230123);
    a((k)new aw());
    super.bXH();
    a((k)new com.tencent.mm.plugin.webview.c.a());
    AppMethodBeat.o(230123);
  }
  
  protected void bXI()
  {
    AppMethodBeat.i(230157);
    int j = 2;
    int i = j;
    try
    {
      if (gSm().gWY()) {
        if (!this.PGK.PGU) {
          break label147;
        }
      }
      label147:
      for (i = com.tencent.mm.plugin.webview.k.i.a(getContext(), gSm(), cDu());; i = com.tencent.mm.plugin.webview.k.i.jg(getContext()))
      {
        any(i);
        String str = this.pHS.getUrl();
        if (Util.isNullOrNil(str)) {
          break label210;
        }
        Object localObject = this.PHX;
        if (str == null) {
          kotlin.g.b.p.iCn();
        }
        if (!((Set)localObject).add(str)) {
          break label210;
        }
        localObject = this.pGD.gWJ();
        kotlin.g.b.p.j(localObject, "wvPerm.genCtrl");
        if (((GeneralControlWrapper)localObject).hoU()) {
          getJsapi().gTY();
        }
        if (!((GeneralControlWrapper)localObject).hoV()) {
          break;
        }
        getJsapi().CU(false);
        AppMethodBeat.o(230157);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(gSK(), "onLoadJsApiFinished, ex = " + localException.getMessage());
        i = j;
      }
      if (this.PHQ.bkM(localException)) {
        getJsapi().CU(true);
      }
      label210:
      super.bXI();
      AppMethodBeat.o(230157);
    }
  }
  
  protected final void bXM()
  {
    AppMethodBeat.i(230183);
    if (gSx())
    {
      Log.e(gSK(), "onBinded call when activity has been finished");
      AppMethodBeat.o(230183);
      return;
    }
    Log.i(gSK(), "Abe-Debug onPostBindedStart");
    this.PFY.bU("onPostBindedStart", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.m.Qer.a(gSm());
    Object localObject1 = getIntent().getStringExtra("ad_info");
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = com.tencent.mm.plugin.webview.ui.tools.m.Qer;
      kotlin.g.b.p.j(localObject3, "WebViewReportUtil.INSTANCE");
      ((com.tencent.mm.plugin.webview.ui.tools.m)localObject3).setTraceId((String)localObject1);
    }
    this.PFY.bU("onJSAPIStart", System.currentTimeMillis());
    localObject1 = getIntent().getBundleExtra("jsapiargs");
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    label1717:
    for (;;)
    {
      ((Bundle)localObject1).putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
      ((Bundle)localObject1).putString("key_function_id", getIntent().getStringExtra("key_function_id"));
      Log.i(gSK(), "KDownloadRestrict = %d, KFunctionID = %s", new Object[] { Integer.valueOf(((Bundle)localObject1).getInt("key_download_restrict", 0)), ((Bundle)localObject1).getString("key_function_id", "") });
      localObject3 = new Bundle();
      ((Bundle)localObject3).putBundle("jsapiargs", (Bundle)localObject1);
      ((Bundle)localObject3).putCharSequence("bizofstartfrom", (CharSequence)getIntent().getStringExtra("bizofstartfrom"));
      ((Bundle)localObject3).putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
      ((Bundle)localObject3).putInt("screen_orientation", getScreenOrientation());
      label1597:
      try
      {
        gSm().a(20, (Bundle)localObject3, gSo());
        localObject4 = getIntent().getStringExtra("geta8key_username");
        i = getIntent().getIntExtra("preChatTYPE", 0);
        str1 = getIntent().getStringExtra("srcUsername");
        long l = getIntent().getLongExtra("message_id", 0L);
        int j = getIntent().getIntExtra("message_index", 0);
        localObject3 = getIntent().getStringExtra("KsnsViewId");
        String str2 = getIntent().getStringExtra("KPublisherId");
        String str4 = getIntent().getStringExtra("KAppId");
        String str5 = getIntent().getStringExtra("pre_username");
        String str3 = getIntent().getStringExtra("expid_str");
        localObject1 = ((Bundle)localObject1).getString("key_snsad_statextstr");
        ay localay = this.PIx.gVZ();
        localay.username = ((String)localObject4);
        localay.PVY = i;
        localay.fXu = cDu();
        localay.PVU = j;
        localay.scene = bjD((String)localObject4);
        localay.PVT = l;
        localay.PVV = new com.tencent.mm.b.p(l).toString();
        localay.POH = str1;
        localay.PVS = ((String)localObject3);
        localay.lpD = str2;
        localay.appId = str4;
        localay.PVW = str5;
        localay.PVX = this.PHT;
        localay.statExtStr = ((String)localObject1);
        localObject3 = getTitle();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localay.title = ((String)localObject1);
        localay.ilq = str3;
        localObject3 = getIntent().getStringExtra("share_report_pre_msg_desc");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = "";
        }
        localay.desc = ((String)localObject3);
        localObject1 = this.PIx.gWa();
        ((ak)localObject1).lpD = str2;
        ((ak)localObject1).scene = bjD((String)localObject4);
        this.PIx.gWc().bkX(cDu());
        if (!gSP()) {}
      }
      catch (RemoteException localRemoteException)
      {
        label731:
        label1894:
        try
        {
          for (;;)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("srcUsername", getIntent().getStringExtra("srcUsername"));
            gSm().a(29, (Bundle)localObject1, gSo());
            if (!Util.isNullOrNil(str1)) {}
            try
            {
              gSm().blR(str1);
              try
              {
                i = getIntent().getIntExtra("pay_channel", -1);
                if (i == -1) {
                  break label1526;
                }
                Log.i(gSK(), "hy: found channel in intent. pay channel: %d", new Object[] { Integer.valueOf(i) });
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Log.e(gSK(), "hy: init pay channel failed");
                  continue;
                  i = 0;
                  continue;
                  localObject4 = (CharSequence)str1;
                  if ((localObject4 == null) || (kotlin.n.n.ba((CharSequence)localObject4))) {}
                  for (i = 1; i == 0; i = 0)
                  {
                    localRemoteException.put("srcUsername", str1);
                    break;
                  }
                  i = 3;
                  Log.i(gSK(), "default pay scene to: %s", new Object[] { Integer.valueOf(3) });
                }
                if (!this.pHS.getIsX5Kernel()) {
                  break label1844;
                }
                t.rE(7);
                com.tencent.mm.plugin.report.service.h.IzE.a(64, 64, 1, 0, 1, 1, false);
                try
                {
                  i = Util.getInt(gSm().blQ("WebviewDisableDigestVerify"), 0);
                  Log.i(gSK(), "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
                  if (i != 0) {
                    break label1794;
                  }
                  localObject2 = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                  kotlin.g.b.p.j(localObject2, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
                  if ((!((SharedPreferences)localObject2).getBoolean("wvsha1", true)) || (!this.PGK.PGT)) {
                    break label1794;
                  }
                  getJsapi().gTL();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    Object localObject2 = n.PJr;
                    if (!((Boolean)n.PJq.getValue()).booleanValue()) {
                      break label1894;
                    }
                    bjA(cDu());
                    for (;;)
                    {
                      this.PFY.bU("onPostBindedEnd", System.currentTimeMillis());
                      AppMethodBeat.o(230183);
                      return;
                      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(64L, 0L, 1L, false);
                      break;
                      localException3 = localException3;
                      Log.w(gSK(), "getting js digest verification config fails, ex = " + localException3.getMessage());
                      i = 0;
                      break label1717;
                      gSm().a(cDu(), true, null);
                    }
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      Log.w(gSK(), "postBinded, jumpToActivity, ex = " + localException4.getMessage());
                    }
                  }
                }
              }
              this.PIc.clear();
              localObject1 = getJsapi();
              str1 = getIntent().getStringExtra("geta8key_username");
              localObject3 = ae.f(new kotlin.o[] { kotlin.s.M("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0L))), kotlin.s.M("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), kotlin.s.M("scene", Integer.valueOf(bjD(str1))), kotlin.s.M("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), kotlin.s.M("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), kotlin.s.M("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))) });
              localObject4 = (CharSequence)getIntent().getStringExtra("srcUsername");
              if ((localObject4 == null) || (kotlin.n.n.ba((CharSequence)localObject4)))
              {
                i = 1;
                if (i != 0) {
                  break label1597;
                }
                ((Map)localObject3).putAll((Map)ae.g(new kotlin.o[] { kotlin.s.M("srcUsername", getIntent().getStringExtra("srcUsername")), kotlin.s.M("srcDisplayname", getIntent().getStringExtra("srcDisplayname")) }));
                if (!Util.isNullOrNil(getIntent().getStringExtra("KTemplateId")))
                {
                  str1 = getIntent().getStringExtra("KTemplateId");
                  kotlin.g.b.p.j(str1, "intent.getStringExtra(Co…UI.WebViewUI.KTemplateId)");
                  ((Map)localObject3).put("KTemplateId", str1);
                }
                i = getIntent().getIntExtra("pay_scene", -1);
                if (i == -1) {
                  break label1644;
                }
                Log.i(gSK(), "get pay scene from extra: %s", new Object[] { Integer.valueOf(i) });
                ((Map)localObject3).put("pay_scene", Integer.valueOf(i));
                ((com.tencent.mm.plugin.webview.d.h)localObject1).bL((Map)localObject3);
                localObject1 = this.PIc;
                localObject3 = (List)new ArrayList();
                ((List)localObject3).add(getJsapi());
                ((List)localObject3).add(this.PId);
                ((List)localObject3).add(this.PIe);
                ((List)localObject3).add(this.PIf);
                ((List)localObject3).add(this.PIg);
                ((List)localObject3).add(this.PIh);
                ((List)localObject3).add(this.PIi);
                ((List)localObject3).add(this.PIl);
                ((List)localObject3).add(this.PIp);
                ((List)localObject3).add(this.PIq);
                ((List)localObject3).add(this.PIs);
                ((List)localObject3).add(this.PIn);
                ((List)localObject3).add(this.PIr);
                ((List)localObject3).add(this.PIm);
                if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
                  ((List)localObject3).add(this.PIv);
                }
                ((List)localObject3).add(this.PIu);
                ((List)localObject1).addAll((Collection)localObject3);
                Log.i(gSK(), "Abe-Debug controllerListeners call, size = %d", new Object[] { Integer.valueOf(this.PGb.size()) });
                localObject1 = ((Iterable)this.PGb).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  ((j)((Iterator)localObject1).next()).bXM();
                  continue;
                  localRemoteException = localRemoteException;
                  Log.e(gSK(), "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + localRemoteException.getMessage());
                }
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.e(gSK(), "postBinded, fail triggerGetContact, ex = " + localException1.getMessage());
                continue;
                label1526:
                i = gSm().getPayChannel();
                if (i != -1)
                {
                  Log.i(gSK(), "hy: found channel in channel helper. pay channel: %d", new Object[] { Integer.valueOf(i) });
                  getIntent().putExtra("pay_channel", i);
                }
              }
            }
          }
        }
        catch (Exception localException5)
        {
          Object localObject4;
          int i;
          String str1;
          label1644:
          break label731;
        }
      }
    }
  }
  
  public final int bjD(String paramString)
  {
    AppMethodBeat.i(230218);
    if (this.PGK.PGW != 0)
    {
      i = this.PGK.PGW;
      AppMethodBeat.o(230218);
      return i;
    }
    int j = getIntent().getIntExtra("geta8key_scene", 0);
    int i = j;
    Object localObject;
    if (j == 0)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label123;
      }
      i = 1;
      if (i != 0) {
        break label268;
      }
    }
    for (;;)
    {
      try
      {
        bool = anw(this.PGh);
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        label123:
        Log.e(gSK(), "getScene fail, ex = " + paramString.getMessage());
        i = 1;
        continue;
        i = 1;
        continue;
      }
      Log.i(gSK(), "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(230218);
      return i;
      i = 0;
      break;
      if (gSm().QX(paramString))
      {
        i = 8;
      }
      else
      {
        if (gSm().Qm(paramString))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("enterprise_biz_username", paramString);
          try
          {
            paramString = gSm().l(102, (Bundle)localObject);
            if (paramString != null)
            {
              bool = paramString.getBoolean("is_enterprise_username");
              if (!bool) {}
            }
          }
          catch (RemoteException paramString)
          {
            Log.e(gSK(), "invoke the check enterprise failed");
            continue;
          }
          i = 7;
          continue;
        }
        label268:
        i = 0;
      }
    }
  }
  
  /* Error */
  public final String bju(String paramString)
  {
    // Byte code:
    //   0: ldc_w 2171
    //   3: invokestatic 441	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 711	java/lang/CharSequence
    //   10: invokestatic 2176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +118 -> 131
    //   16: new 645	android/os/Bundle
    //   19: dup
    //   20: invokespecial 646	android/os/Bundle:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w 982
    //   28: aload_0
    //   29: invokevirtual 704	com/tencent/mm/plugin/webview/core/i:gSo	()I
    //   32: invokevirtual 652	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: aload_2
    //   36: ldc_w 2178
    //   39: aload_1
    //   40: invokevirtual 980	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 666	com/tencent/mm/plugin/webview/core/i:gSm	()Lcom/tencent/mm/plugin/webview/stub/e;
    //   47: bipush 76
    //   49: aload_2
    //   50: invokeinterface 2161 3 0
    //   55: ldc_w 2179
    //   58: invokevirtual 1921	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 2182	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 2184
    //   69: invokestatic 748	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokevirtual 639	com/tencent/mm/plugin/webview/core/i:gSK	()Ljava/lang/String;
    //   76: ldc_w 2186
    //   79: iconst_1
    //   80: anewarray 779	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 788	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 2171
    //   93: invokestatic 450	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: ldc_w 1012
    //   102: astore_1
    //   103: aload_0
    //   104: invokevirtual 639	com/tencent/mm/plugin/webview/core/i:gSK	()Ljava/lang/String;
    //   107: ldc_w 2188
    //   110: iconst_1
    //   111: anewarray 779	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: invokevirtual 2189	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 1023	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -34 -> 90
    //   127: astore_2
    //   128: goto -25 -> 103
    //   131: ldc_w 1012
    //   134: astore_1
    //   135: goto -45 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	i
    //   0	138	1	paramString	String
    //   23	27	2	localBundle	Bundle
    //   98	19	2	localThrowable1	Throwable
    //   127	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	72	98	java/lang/Throwable
    //   72	90	127	java/lang/Throwable
  }
  
  protected boolean cDA()
  {
    AppMethodBeat.i(230187);
    Object localObject = ((Iterable)this.PwK).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((k)((Iterator)localObject).next()).bjK(cDu()))
      {
        AppMethodBeat.o(230187);
        return false;
      }
    }
    localObject = (CharSequence)getIntent().getStringExtra("data");
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject))) {}
    for (int i = 1; (i != 0) && (!this.PGK.PGV); i = 0)
    {
      AppMethodBeat.o(230187);
      return true;
    }
    AppMethodBeat.o(230187);
    return false;
  }
  
  protected void cDz()
  {
    AppMethodBeat.i(230185);
    Object localObject1 = ((Iterable)this.PwK).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((k)((Iterator)localObject1).next()).e(cDu(), getIntent()))
      {
        AppMethodBeat.o(230185);
        return;
      }
    }
    if (bjE(cDu()))
    {
      AppMethodBeat.o(230185);
      return;
    }
    this.PFF.a(com.tencent.mm.plugin.webview.i.c.PZE);
    if (cDA())
    {
      Log.i(gSK(), "needSyncGetA8Key");
      localObject1 = com.tencent.mm.plugin.webview.k.o.QAC;
      com.tencent.mm.plugin.webview.k.o.a(this.PFF.PZC, cDu(), com.tencent.mm.plugin.webview.i.d.PZL, com.tencent.mm.plugin.webview.i.c.PZF, this.PFF.PZB);
      this.PFF.a(com.tencent.mm.plugin.webview.i.c.PZF);
      BaseWebViewController.a(this, cDu(), false, 0, 6);
      AppMethodBeat.o(230185);
      return;
    }
    Log.i(gSK(), "terry onStartLoad:" + cDu());
    Object localObject3 = gSr();
    localObject1 = (CharSequence)localObject3;
    int i;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1))) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i(gSK(), (String)localObject3);
        localObject1 = localObject3;
        if (getIntent().getBooleanExtra("QRDataFlag", true)) {}
        try
        {
          localObject1 = gSm().blM((String)localObject3);
          localObject3 = this.pHS.getSettings();
          kotlin.g.b.p.j(localObject3, "viewWV.settings");
          ((aa)localObject3).setUseWideViewPort(false);
          localObject3 = this.pHS.getSettings();
          kotlin.g.b.p.j(localObject3, "viewWV.settings");
          ((aa)localObject3).setLoadWithOverviewMode(false);
          localObject3 = this.pHS.getSettings();
          kotlin.g.b.p.j(localObject3, "viewWV.settings");
          ((aa)localObject3).setJavaScriptEnabled(false);
          CN(true);
          this.pHS.loadDataWithBaseURL(null, (String)localObject1, "text/html", "utf-8", null);
          Log.i(gSK(), "loadDataWithBaseUrl, data = ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(230185);
          return;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.w(gSK(), "postBinded, formatQRString, ex = " + localException.getMessage());
            localObject2 = localObject3;
          }
        }
      }
    }
    if (bjt(cDu()))
    {
      Log.f(gSK(), "postBinded 2, canLoadUrl fail, url = " + cDu());
      AppMethodBeat.o(230185);
      return;
    }
    if (this.PGK.PGV) {
      this.pGD.a(cDu(), null, null);
    }
    Object localObject2 = ((Iterable)this.PwK).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((k)((Iterator)localObject2).next()).bjJ(cDu()))
      {
        AppMethodBeat.o(230185);
        return;
      }
    }
    if (this.pHS.dwQ())
    {
      AppMethodBeat.o(230185);
      return;
    }
    CN(false);
    BaseWebViewController.a(this, cDu(), null, 6);
    AppMethodBeat.o(230185);
  }
  
  public void e(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(230145);
    super.e(paramWebView, paramString);
    this.PFY.bU("onPageCommit", System.currentTimeMillis());
    AppMethodBeat.o(230145);
  }
  
  protected final void gSA()
  {
    AppMethodBeat.i(230169);
    super.gSA();
    com.tencent.mm.plugin.webview.i.f.gWR();
    Object localObject = ((Iterable)this.PGb).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((j)((Iterator)localObject).next()).a(this.PFY);
    }
    localObject = this.PFY;
    MMWebView localMMWebView = this.pHS;
    kotlin.g.a.a locala = (kotlin.g.a.a)new ab(this);
    kotlin.g.b.p.k(localMMWebView, "webView");
    kotlin.g.b.p.k(locala, "callback");
    localMMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", (ValueCallback)new n.b((com.tencent.mm.plugin.webview.k.n)localObject, locala));
    AppMethodBeat.o(230169);
  }
  
  protected final void gSB()
  {
    AppMethodBeat.i(230228);
    Log.d(gSK(), "setGetA8KeyParams");
    Object localObject1 = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_req");
    Object localObject2 = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_resp");
    if ((localObject1 != null) && (localObject2 != null))
    {
      Log.i(gSK(), "set outer get A8key result");
      gSl().m((byte[])localObject1, (byte[])localObject2);
    }
    localObject1 = getIntent().getStringExtra("geta8key_username");
    localObject2 = getIntent().getStringExtra("msgUsername");
    String str = getIntent().getStringExtra("serverMsgID");
    gSl().blv((String)localObject2);
    gSl().blw(str);
    gSl().setUsername((String)localObject1);
    gSl().setScene(bjD((String)localObject1));
    gSl().setAppId(getIntent().getStringExtra("geta8key_open_webview_appid"));
    localObject1 = this.pHS;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((MMWebView)localObject1).getIsX5Kernel());
      if (!((Boolean)localObject1).booleanValue()) {
        break label273;
      }
      gSl().setFlag(1);
    }
    for (;;)
    {
      gSl().aG(getIntent().getByteArrayExtra("geta8key_cookie"));
      gSl().anT(getIntent().getIntExtra("key_wallet_region", 0));
      gSl().blu(getIntent().getStringExtra("key_function_id"));
      int i = getIntent().getIntExtra("geta8key_session_id", 0);
      if (i > 0) {
        gSl().Ht(i);
      }
      AppMethodBeat.o(230228);
      return;
      localObject1 = null;
      break;
      label273:
      gSl().setFlag(0);
    }
  }
  
  public final String gSK()
  {
    AppMethodBeat.i(230111);
    String str = (String)this.PHF.getValue();
    AppMethodBeat.o(230111);
    return str;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.c gSN()
  {
    AppMethodBeat.i(230125);
    com.tencent.mm.plugin.webview.ui.tools.c localc = (com.tencent.mm.plugin.webview.ui.tools.c)this.PHS.getValue();
    AppMethodBeat.o(230125);
    return localc;
  }
  
  public final com.tencent.mm.plugin.webview.modeltools.n gSO()
  {
    AppMethodBeat.i(230136);
    com.tencent.mm.plugin.webview.modeltools.n localn = (com.tencent.mm.plugin.webview.modeltools.n)this.PHU.getValue();
    AppMethodBeat.o(230136);
    return localn;
  }
  
  public final boolean gSP()
  {
    AppMethodBeat.i(230191);
    for (;;)
    {
      try
      {
        Object localObject = getIntent().getStringExtra("srcUsername");
        str = getIntent().getStringExtra("bizofstartfrom");
        localObject = (CharSequence)localObject;
        if (localObject == null) {
          break label86;
        }
        if (!kotlin.n.n.ba((CharSequence)localObject)) {
          break label91;
        }
      }
      catch (Exception localException)
      {
        String str;
        AppMethodBeat.o(230191);
        return false;
      }
      if ((i == 0) && (kotlin.g.b.p.h(str, "enterpriseHomeSubBrand")))
      {
        AppMethodBeat.o(230191);
        return true;
      }
      AppMethodBeat.o(230191);
      return false;
      label86:
      int i = 1;
      continue;
      label91:
      i = 0;
    }
  }
  
  public final boolean gSS()
  {
    AppMethodBeat.i(230231);
    if (!this.PFR)
    {
      AppMethodBeat.o(230231);
      return false;
    }
    gST();
    AppMethodBeat.o(230231);
    return true;
  }
  
  public final void gST()
  {
    AppMethodBeat.i(230234);
    boolean bool = com.tencent.mm.plugin.webview.modeltools.k.a(getJsapi(), this.pHS);
    Object localObject = this.PHJ;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject).onDestroy();
    }
    localObject = this.PHH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.k)localObject).onDestroy();
    }
    onDestroy();
    this.pHS.removeJavascriptInterface("MicroMsg");
    this.pHS.removeJavascriptInterface("JsApi");
    this.pHS.removeJavascriptInterface("__wx");
    this.pHS.removeJavascriptInterface("CustomFullscreenApi");
    this.pHS.removeJavascriptInterface("__wxtag");
    try
    {
      this.pHS.setWebChromeClient(null);
      this.pHS.setWebViewClient(null);
      this.pHS.setOnTouchListener(null);
      this.pHS.setOnLongClickListener(null);
      this.pHS.setVisibility(8);
      this.pHS.removeAllViews();
      this.pHS.clearView();
      if (!bool) {
        this.pHS.destroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(gSK(), "releaseWebView, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    this.PHJ = null;
    this.PHH = null;
    this.PHI = null;
    AppMethodBeat.o(230234);
  }
  
  public final com.tencent.mm.plugin.webview.f.c gSU()
  {
    AppMethodBeat.i(230236);
    com.tencent.mm.plugin.webview.f.c localc = gSl();
    AppMethodBeat.o(230236);
    return localc;
  }
  
  protected final Class<? extends Service> gSi()
  {
    AppMethodBeat.i(230113);
    Class localClass = (Class)this.PHG.getValue();
    AppMethodBeat.o(230113);
    return localClass;
  }
  
  protected final Set<String> gSj()
  {
    AppMethodBeat.i(230117);
    Set localSet = (Set)this.PHM.getValue();
    AppMethodBeat.o(230117);
    return localSet;
  }
  
  protected final void gSu()
  {
    AppMethodBeat.i(230224);
    if (this.PIw != null)
    {
      AppMethodBeat.o(230224);
      return;
    }
    Log.i(gSK(), "WebView-Trace setWebViewPluginClient");
    this.PIw = com.tencent.luggage.xweb_ext.extendplugin.d.a((WebView)this.pHS, (com.tencent.luggage.xweb_ext.extendplugin.b.d)com.tencent.luggage.xweb_ext.extendplugin.b.b.Us(), (com.tencent.luggage.xweb_ext.extendplugin.a.c)com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g.hbD(), null);
    AppMethodBeat.o(230224);
  }
  
  public final boolean gSv()
  {
    AppMethodBeat.i(230175);
    Log.i(gSK(), "edw onServiceDisconnected");
    Iterator localIterator = ((Iterable)this.PwK).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((k)localIterator.next()).gTa());
    for (int i = 1; i == 0; i = 0)
    {
      Log.i(gSK(), "maybe mm process crash, try rebind service");
      AppMethodBeat.o(230175);
      return true;
    }
    boolean bool = super.gSv();
    AppMethodBeat.o(230175);
    return bool;
  }
  
  public final void gSw()
  {
    AppMethodBeat.i(230116);
    super.gSw();
    gSN().aD(this.pHS.getActivityContextIfHas());
    Context localContext = this.pHS.getActivityContextIfHas();
    Object localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      kotlin.g.b.p.j(localObject, "it.intent");
      setIntent((Intent)localObject);
      AppMethodBeat.o(230116);
      return;
    }
    AppMethodBeat.o(230116);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(230119);
    Object localObject2 = this.pHS.getTitle();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getIntent().getStringExtra("title");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getIntent().getStringExtra("webpageTitle");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    AppMethodBeat.o(230119);
    return localObject1;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(230222);
    if (this.PIw == null) {
      gSu();
    }
    com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.PIw;
    AppMethodBeat.o(230222);
    return localc;
  }
  
  public final void i(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(230124);
    kotlin.g.b.p.k(paramString, "url");
    Log.i(gSK(), "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
    if (bjt(paramString))
    {
      Log.f(gSK(), "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      super.i(paramWebView, paramString);
      AppMethodBeat.o(230124);
      return;
    }
    this.PIx.gVY().bkZ(paramString);
    super.i(paramWebView, paramString);
    AppMethodBeat.o(230124);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(230188);
    kotlin.g.b.p.k(paramString, "url");
    com.tencent.mm.plugin.webview.model.a.b(this.pHS, paramString);
    super.loadUrl(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(230188);
  }
  
  protected final boolean m(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(230154);
    kotlin.g.b.p.k(paramWebView, "webView");
    kotlin.g.b.p.k(paramString, "url");
    Log.i(gSK(), "WebView-Trace shouldOverride url = ".concat(String.valueOf(paramString)));
    k.a locala = l(paramWebView, paramString);
    if (locala.PJg)
    {
      boolean bool = locala.result;
      AppMethodBeat.o(230154);
      return bool;
    }
    if (bjt(paramString))
    {
      Log.f(gSK(), "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(230154);
      return true;
    }
    if (com.tencent.luggage.k.c.a(paramString, "about:blank", true))
    {
      Log.e(gSK(), "shouldOverride, url is about:blank");
      AppMethodBeat.o(230154);
      return true;
    }
    if (DownloadChecker.a(paramString, gSL(), paramWebView))
    {
      Log.i(gSK(), "use the downloader to download");
      AppMethodBeat.o(230154);
      return true;
    }
    if ((com.tencent.luggage.k.c.a(paramString, "weixinping://iframe", true)) || (com.tencent.luggage.k.c.a(paramString, "weixinpreinject://iframe", true)))
    {
      AppMethodBeat.o(230154);
      return true;
    }
    if (bIF(paramString))
    {
      Log.i(gSK(), "weixin scheme url deal success, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(230154);
      return true;
    }
    if (bjC(paramString))
    {
      Log.i(gSK(), "custom scheme url deal success, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(230154);
      return true;
    }
    if (!(paramWebView instanceof MMWebView)) {
      paramWebView = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.model.a.b((MMWebView)paramWebView, paramString);
      AppMethodBeat.o(230154);
      return false;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(230221);
    if (anw(this.PGi)) {
      gSM().s("", Util.nowSecond(), 0);
    }
    gSN().detach();
    if (gSP()) {}
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
      gSm().a(30, localBundle, gSo());
      try
      {
        label86:
        gSm().aon(gSQ().gSo());
        super.onDestroy();
        AppMethodBeat.o(230221);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.i(gSK(), "onDestroy remove callbacker ex " + localException1.getMessage());
        }
      }
    }
    catch (Exception localException2)
    {
      break label86;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(221782);
      kotlin.g.b.p.k(paramString, "url");
      if (!this.PIz.pGD.gWJ().hoS())
      {
        Log.e(i.a(this.PIz), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
        AppMethodBeat.o(221782);
        return true;
      }
      try
      {
        this.PIz.gSm().dd(paramString, this.PIz.pGD.gWI().so(7));
        AppMethodBeat.o(221782);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(i.a(this.PIz), "ActivityJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(221779);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(221779);
        return false;
      }
      boolean bool = ab.J(paramString, "weixin://jump/");
      AppMethodBeat.o(221779);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    aa(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    ab(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"getNetWorkTypeName", "", "context", "Landroid/content/Context;", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Context, String>
  {
    public static final ac PIY;
    
    static
    {
      AppMethodBeat.i(268420);
      PIY = new ac();
      AppMethodBeat.o(268420);
    }
    
    ac()
    {
      super();
    }
    
    public static String iV(Context paramContext)
    {
      AppMethodBeat.i(268419);
      kotlin.g.b.p.k(paramContext, "context");
      if (NetStatusUtil.isWifi(paramContext))
      {
        AppMethodBeat.o(268419);
        return "wifi";
      }
      if (NetStatusUtil.is5G(paramContext))
      {
        AppMethodBeat.o(268419);
        return "5g";
      }
      if (NetStatusUtil.is4G(paramContext))
      {
        AppMethodBeat.o(268419);
        return "4g";
      }
      if (NetStatusUtil.is3G(paramContext))
      {
        AppMethodBeat.o(268419);
        return "3g";
      }
      if (NetStatusUtil.is2G(paramContext))
      {
        AppMethodBeat.o(268419);
        return "2g";
      }
      AppMethodBeat.o(268419);
      return "none";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"dnsIps", "", "host", "invoke"})
  static final class ad
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, String>
  {
    ad(i parami)
    {
      super();
    }
    
    public final String invoke(String paramString)
    {
      AppMethodBeat.i(268529);
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        paramString = InetAddress.getAllByName(paramString);
        if ((paramString != null) && (paramString.length > 0))
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramString[i];
            kotlin.g.b.p.j(localObject, "inetAddressArr[i]");
            localStringBuilder.append(localObject.getHostAddress());
            localStringBuilder.append(";");
            i += 1;
          }
        }
        paramString = localStringBuilder.toString();
      }
      catch (UnknownHostException paramString)
      {
        Log.printErrStackTrace(i.a(this.PIz), (Throwable)paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(268529);
        return null;
      }
      AppMethodBeat.o(268529);
      return paramString;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(String paramString1, int paramInt, i.ad paramad, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(242051);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      String str = this.PHt;
      int i = paramInt;
      Object localObject = i.ac.PIY;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      localh.a(17082, new Object[] { str, Integer.valueOf(i), i.ac.iV((Context)localObject), this.PIZ.invoke(str) });
      AppMethodBeat.o(242051);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(i parami, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(264833);
      this.PIz.getJsapi().anz(i);
      Object localObject = this.PIz;
      int i = i;
      localObject = ((Iterable)((BaseWebViewController)localObject).PGb).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((j)((Iterator)localObject).next()).anz(i);
      }
      AppMethodBeat.o(264833);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "invoke"})
  static final class ag
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.modeltools.n>
  {
    public static final ag PJc;
    
    static
    {
      AppMethodBeat.i(226238);
      PJc = new ag();
      AppMethodBeat.o(226238);
    }
    
    ag()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "invoke"})
  static final class ah
    extends kotlin.g.b.q
    implements kotlin.g.a.a<i.p>
  {
    ah(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "invoke"})
  static final class ai
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.ui.tools.c>
  {
    ai(MMWebView paramMMWebView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;", "invoke"})
  static final class aj
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Class<WebViewStubService>>
  {
    public static final aj PJd;
    
    static
    {
      AppMethodBeat.i(265939);
      PJd = new aj();
      AppMethodBeat.o(265939);
    }
    
    aj()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "invoke"})
  static final class ak
    extends kotlin.g.b.q
    implements kotlin.g.a.a<i.s>
  {
    ak(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIA = "weixin://addfriend/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(226873);
      kotlin.g.b.p.k(paramString, "url");
      if (!this.PIz.pGD.gWI().so(5))
      {
        Log.e(i.a(this.PIz), "AddFriendHandler, permission fail");
        AppMethodBeat.o(226873);
        return true;
      }
      paramString = paramString.substring(this.PIA.length());
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(226873);
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_webview", true);
      localBundle.putString("userName", paramString);
      try
      {
        this.PIz.gSm().a(8, localBundle, this.PIz.gSo());
        AppMethodBeat.o(226873);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(i.a(this.PIz), "AddFriendHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(226865);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(226865);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIA);
      AppMethodBeat.o(226865);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIB = "weixin://webview/close/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(226272);
      kotlin.g.b.p.k(paramString, "url");
      if (!this.PIz.pGD.gWI().so(17))
      {
        Log.e(i.a(this.PIz), "close window permission fail");
        AppMethodBeat.o(226272);
        return true;
      }
      this.PIz.onFinish();
      AppMethodBeat.o(226272);
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(226269);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(226269);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIB);
      AppMethodBeat.o(226269);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class e
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIC = "weixin://critical_update/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(253017);
      kotlin.g.b.p.k(paramString, "url");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 25L, 1L, true);
      i.b(this.PIz, 1);
      AppMethodBeat.o(253017);
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(253015);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(253015);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIC);
      AppMethodBeat.o(253015);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "urlOrig", "plugin-webview_release"})
  public static final class f
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    f(MMWebView paramMMWebView) {}
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(221895);
      kotlin.g.b.p.k(paramString, "urlOrig");
      int i = this.PIz.bjD(Util.nullAsNil(i.h(this.PIz)));
      Object localObject = com.tencent.mm.pluginsdk.g.boY(paramString);
      if (com.tencent.mm.pluginsdk.g.bT((String)localObject, i.i(this.PIz))) {}
      for (;;)
      {
        try
        {
          if (kotlin.g.b.p.h("weixin://dl/shopping", localObject))
          {
            paramString = this.PIz.gSm().gXc();
            kotlin.g.b.p.j(paramString, "invoker.getJDUrl()");
            if (!Util.isNullOrNil(paramString)) {
              BaseWebViewController.a(this.PIz, paramString, null, 6);
            }
            paramString = (List)new ArrayList();
            kotlin.g.b.p.j(localObject, "url");
            paramString.add(localObject);
            paramString.add("1");
            paramString.add(String.valueOf(i));
            localObject = Util.nullAsNil(i.h(this.PIz));
            kotlin.g.b.p.j(localObject, "Util.nullAsNil(sentUsername)");
            paramString.add(localObject);
            localObject = Util.nullAsNil(this.PIz.cDu());
            kotlin.g.b.p.j(localObject, "Util.nullAsNil(rawUrl)");
            paramString.add(localObject);
            localObject = com.tencent.mm.plugin.report.service.h.IzE;
            com.tencent.mm.plugin.report.service.h.u(11405, paramString);
            bool = true;
            AppMethodBeat.o(221895);
            return bool;
          }
          if (kotlin.g.b.p.h("weixin://dl/faq", localObject))
          {
            int j = this.PIz.gSm().gXe();
            int k = this.PIz.gSm().gXf();
            paramString = MMApplicationContext.getContext().getString(c.i.settings_system_notice_url, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            kotlin.g.b.p.j(paramString, "MMApplicationContext.get…otice_url, uin, newCount)");
            BaseWebViewController.a(this.PIz, paramString, null, 6);
            continue;
          }
        }
        catch (Exception paramString)
        {
          Log.e(i.a(this.PIz), "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          bool = true;
          continue;
          if (kotlin.g.b.p.h("weixin://dl/posts", localObject))
          {
            this.PIz.gSm().gXg();
            continue;
          }
          if (kotlin.g.b.p.h("weixin://dl/moments", localObject))
          {
            this.PIz.gSm().gXh();
            continue;
          }
          kotlin.g.b.p.j(localObject, "url");
          if (kotlin.n.n.M((String)localObject, "weixin://dl/feedback", false))
          {
            kotlin.g.b.p.j(this.PIz.gSm().blV((String)localObject), "invoker.getFeedbackUrl(url)");
            continue;
          }
          if (kotlin.g.b.p.h("weixin://dl/scan", localObject))
          {
            com.tencent.mm.by.c.c(this.PIz.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.g.cq(paramMMWebView.getActivityContextIfHas(), (String)localObject);
          continue;
        }
        boolean bool = false;
      }
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(221878);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(221878);
        return false;
      }
      boolean bool = ab.J(paramString, "weixin://");
      AppMethodBeat.o(221878);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PID = "weixin://feedback/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(216644);
      kotlin.g.b.p.k(paramString, "url");
      paramString = new Bundle();
      paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
      paramString.putInt("MMActivity.OverrideExitAnimation", c.a.push_down_out);
      try
      {
        this.PIz.gSm().a(7, paramString, this.PIz.gSo());
        AppMethodBeat.o(216644);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(i.a(this.PIz), "FeedbackJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(216643);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(216643);
        return false;
      }
      boolean bool = ab.J(paramString, this.PID);
      AppMethodBeat.o(216643);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIE = "weixin://connectToFreeWifi/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(217029);
      kotlin.g.b.p.k(paramString, "url");
      Log.w(i.a(this.PIz), "freewifi had Deprecated");
      AppMethodBeat.o(217029);
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(217028);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(217028);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIE);
      AppMethodBeat.o(217028);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class i
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIF = "weixin://gethtml/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(221478);
      kotlin.g.b.p.k(paramString, "url");
      if (!Util.isNullOrNil(paramString))
      {
        paramString = paramString.substring(this.PIF.length());
        kotlin.g.b.p.j(paramString, "(this as java.lang.String).substring(startIndex)");
        Log.i(i.a(this.PIz), "[oneliang]get html content :".concat(String.valueOf(paramString)));
        Object localObject = this.PIz;
        kotlin.g.b.p.k(paramString, "html");
        localObject = ((Iterable)((BaseWebViewController)localObject).PGb).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((j)((Iterator)localObject).next()).bjI(paramString);
        }
      }
      AppMethodBeat.o(221478);
      return false;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(221473);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(221473);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIF);
      AppMethodBeat.o(221473);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class j
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIG = "weixin://profile/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(235961);
      kotlin.g.b.p.k(paramString, "url");
      paramString = paramString.substring(this.PIG.length());
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(i.a(this.PIz), "handleUrl fail, username is null");
        AppMethodBeat.o(235961);
        return true;
      }
      if (this.PIz.pGD.gWI().so(2)) {
        this.PIz.getJsapi().bka(paramString);
      }
      AppMethodBeat.o(235961);
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(235957);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(235957);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIG);
      AppMethodBeat.o(235957);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class k
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIH = "weixin://manual_update/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(266834);
      kotlin.g.b.p.k(paramString, "url");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 26L, 1L, true);
      i.b(this.PIz, 3);
      AppMethodBeat.o(266834);
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(266833);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(266833);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIH);
      AppMethodBeat.o(266833);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class l
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(266868);
      kotlin.g.b.p.k(paramString, "url");
      String str = this.PIz.getIntent().getStringExtra("geta8key_username");
      boolean bool = ag.b.a(paramString, str, this.PIz.bjD(str), this.PIz.gSm(), i.c(this.PIz), (ag.a)this.PIz.PIa, i.d(this.PIz).gSo(), this.PIz.getContext());
      AppMethodBeat.o(266868);
      return bool;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(266867);
      kotlin.g.b.p.k(paramString, "url");
      boolean bool = ag.b.gZ(paramString, this.PIz.getIntent().getIntExtra("geta8key_scene", 0));
      AppMethodBeat.o(266867);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class n
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIK = "weixin://recommend_update/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(214848);
      kotlin.g.b.p.k(paramString, "url");
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 24L, 1L, true);
      i.b(this.PIz, 2);
      AppMethodBeat.o(214848);
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(214846);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(214846);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIK);
      AppMethodBeat.o(214846);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class o
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIL = "weixin://openapi/openwebview/result?";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(266824);
      kotlin.g.b.p.k(paramString, "url");
      Object localObject = new OpenWebview.Resp();
      paramString = Uri.parse(paramString);
      kotlin.g.b.p.j(paramString, "uri");
      ((OpenWebview.Resp)localObject).result = paramString.getQuery();
      ((OpenWebview.Resp)localObject).errCode = Util.getInt(paramString.getQueryParameter("errCode"), 0);
      ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
      ((OpenWebview.Resp)localObject).transaction = this.PIz.getIntent().getStringExtra("transaction_for_openapi_openwebview");
      paramString = paramString.getQueryParameter("appid");
      if (Util.isNullOrNil(paramString))
      {
        Log.e(i.a(this.PIz), "SDKOpenWebViewResultHandler handleUrl, appId is null");
        AppMethodBeat.o(266824);
        return true;
      }
      Bundle localBundle = new Bundle();
      ((OpenWebview.Resp)localObject).toBundle(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bm(localBundle);
      localObject = new MMessageActV2.Args();
      try
      {
        ((MMessageActV2.Args)localObject).targetPkgName = this.PIz.gSm().blO(paramString);
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        Log.d(i.a(this.PIz), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
        MMessageActV2.send(this.PIz.getContext(), (MMessageActV2.Args)localObject);
        this.PIz.onFinish();
        AppMethodBeat.o(266824);
        return true;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(i.a(this.PIz), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(266824);
      }
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(266820);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(266820);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIL);
      AppMethodBeat.o(266820);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"})
  static final class p
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    private final kotlin.f PFU;
    private final WeakReference<i> PIM;
    private final String TAG;
    
    public p(WeakReference<i> paramWeakReference)
    {
      AppMethodBeat.i(268038);
      this.PIM = paramWeakReference;
      this.PFU = kotlin.g.ar((kotlin.g.a.a)new a(this));
      this.TAG = ("MicroMsg.WebViewController.SceneEndCallbacker:" + gSo());
      AppMethodBeat.o(268038);
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      AppMethodBeat.i(268036);
      Log.i(this.TAG, "onSceneEnd, instance hashcode = " + hashCode());
      i locali;
      if (paramd != null)
      {
        int i = paramd.getData().getInt("scene_end_listener_hash_code");
        Log.i(this.TAG, "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(gSo()) });
        Log.i(this.TAG, "edw onSceneEnd, type = " + paramd.getType() + ", errCode = " + paramd.getErrCode() + ", errType = " + paramd.getErrType());
        if (i != gSo())
        {
          Log.e(this.TAG, "hash code not equal");
          AppMethodBeat.o(268036);
          return false;
        }
        locali = (i)this.PIM.get();
        if (locali != null) {
          switch (paramd.getType())
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(268036);
        return true;
        i.a(locali, 106);
        locali.onFinish();
        continue;
        i.a(locali, 666);
        locali.onFinish();
      }
    }
    
    public final int gSo()
    {
      AppMethodBeat.i(268035);
      int i = ((Number)this.PFU.getValue()).intValue();
      AppMethodBeat.o(268035);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<Integer>
    {
      a(i.p paramp)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class q
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    final String PIF = "weixin://private/gethtml/";
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(226768);
      kotlin.g.b.p.k(paramString, "url");
      paramString = paramString.substring(this.PIF.length());
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      try
      {
        paramString = URLDecoder.decode(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("nowUrl", i.e(this.PIz));
        localBundle.putString("tweetid", Util.nullAsNil(this.PIz.getIntent().getStringExtra("tweetid")));
        localBundle.putString("htmlData", paramString);
        localBundle.putInt("type", this.PIz.getIntent().getIntExtra("type", 0));
        this.PIz.gSm().a(3, localBundle, this.PIz.gSo());
        AppMethodBeat.o(226768);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e(i.a(this.PIz), "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(226768);
      }
      return false;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(226762);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(226762);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIF);
      AppMethodBeat.o(226762);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class r
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String PIO = "weixin://viewimage/";
    
    r(MMWebView paramMMWebView) {}
    
    public final boolean bjE(String paramString)
    {
      AppMethodBeat.i(250140);
      kotlin.g.b.p.k(paramString, "url");
      try
      {
        if (!this.PIz.gSm().isSDCardAvailable())
        {
          this.PIz.gSm().a(2, null, this.PIz.gSo());
          AppMethodBeat.o(250140);
          return true;
        }
      }
      catch (Exception paramString)
      {
        Log.e(i.a(this.PIz), "edw handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(250140);
        return false;
      }
      i locali = this.PIz;
      paramString = paramString.substring(this.PIO.length());
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      i.a(locali, paramString);
      Log.i(i.a(this.PIz), "viewimage currentUrl :" + i.e(this.PIz));
      ab.a((WebView)paramMMWebView, i.f(this.PIz).PIF, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", i.g(this.PIz));
      AppMethodBeat.o(250140);
      return true;
    }
    
    public final boolean bjF(String paramString)
    {
      AppMethodBeat.i(250137);
      kotlin.g.b.p.k(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(250137);
        return false;
      }
      boolean bool = ab.J(paramString, this.PIO);
      AppMethodBeat.o(250137);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"})
  final class s
  {
    private volatile String PIP;
    private final i PIQ;
    private int fromScene;
    private int networkType;
    private long pSM;
    private String userAgent;
    private volatile String xPg;
    
    public s()
    {
      AppMethodBeat.i(215982);
      this.PIQ = localObject;
      this$1 = this.PIQ.pHS.getSettings();
      kotlin.g.b.p.j(i.this, "controller.viewWV.settings");
      this$1 = i.this.getUserAgentString();
      kotlin.g.b.p.j(i.this, "controller.viewWV.settings.userAgentString");
      this.userAgent = i.this;
      this.fromScene = this.PIQ.getIntent().getIntExtra("from_scence", 0);
      this.PIP = "";
      this.xPg = "";
      AppMethodBeat.o(215982);
    }
    
    private void gSV()
    {
      AppMethodBeat.i(215980);
      Context localContext = MMApplicationContext.getContext();
      int i;
      if (NetStatusUtil.isConnected(localContext))
      {
        if (!NetStatusUtil.isWifi(localContext)) {
          break label65;
        }
        i = 1;
      }
      for (;;)
      {
        this.networkType = i;
        Log.i(i.a(i.this), "get networkType " + this.networkType);
        AppMethodBeat.o(215980);
        return;
        label65:
        if (NetStatusUtil.is5G(localContext)) {
          i = 5;
        } else if (NetStatusUtil.is4G(localContext)) {
          i = 4;
        } else if (NetStatusUtil.is3G(localContext)) {
          i = 3;
        } else if (NetStatusUtil.is2G(localContext)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
    
    public final void s(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(215981);
      kotlin.g.b.p.k(paramString, "targetUrl");
      gSV();
      String str5 = this.PIQ.bju(this.xPg);
      if (this.fromScene != 0) {
        this.PIP = " ";
      }
      boolean bool = this.PIQ.pGD.gWJ().hoW();
      Log.d(i.a(i.this), "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.pSM > 0L) && (i.b(i.this) > this.pSM) && (paramLong > i.b(i.this)) && (!TextUtils.isEmpty((CharSequence)str5)) && (bool))
      {
        l1 = i.b(i.this) - this.pSM;
        l2 = paramLong - i.b(i.this);
        Log.d(i.a(i.this), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.pSM), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.userAgent, this.xPg, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.PIP });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.q.an(Util.nullAsNil(this.userAgent), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.q.an(Util.nullAsNil(this.xPg), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.q.an(Util.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str4 = com.tencent.mm.compatible.util.q.an(Util.nullAsNil(this.PIP), "UTF-8");
        localObject1 = str4;
        localObject2 = localObject3;
        str1 = str3;
        localObject3 = localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject3;
          Log.printErrStackTrace(i.a(i.this), (Throwable)localUnsupportedEncodingException, "", new Object[0]);
          String str2 = "";
          localObject4 = localObject1;
        }
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13376, new Object[] { Long.valueOf(this.pSM), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.PIP = this.xPg;
        this.xPg = paramString;
        this.pSM = paramLong;
      }
      AppMethodBeat.o(215981);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(i.s params, String paramString, long paramLong) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(231718);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.PIR.s(this.PIS, this.PIT, this.PIU);
        AppMethodBeat.o(231718);
        return false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    t(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "weakController", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Ljava/lang/ref/WeakReference;)V", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"})
  public static final class u
    implements ag.a
  {
    private final WeakReference<i> PGQ;
    private final Map<Integer, Integer> PIV;
    
    public u(WeakReference<i> paramWeakReference)
    {
      AppMethodBeat.i(250509);
      this.PGQ = paramWeakReference;
      this.PIV = ((Map)new HashMap());
      AppMethodBeat.o(250509);
    }
    
    public final void eRX()
    {
      AppMethodBeat.i(250507);
      Object localObject = (i)this.PGQ.get();
      if (localObject != null) {
        i.a((i)localObject, 1373);
      }
      if (this.PIV.containsKey(Integer.valueOf(1373)))
      {
        localObject = this.PIV.get(Integer.valueOf(1373));
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        int i = ((Number)localObject).intValue();
        this.PIV.put(Integer.valueOf(1373), Integer.valueOf(i - 1));
        AppMethodBeat.o(250507);
        return;
      }
      this.PIV.put(Integer.valueOf(1373), Integer.valueOf(0));
      AppMethodBeat.o(250507);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewUIDelegateImpl;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "weakController", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Ljava/lang/ref/WeakReference;)V", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"})
  public static final class v
    implements ag.c
  {
    private final WeakReference<i> PGQ;
    private com.tencent.mm.ui.base.s PIW;
    
    public v(WeakReference<i> paramWeakReference)
    {
      AppMethodBeat.i(216333);
      this.PGQ = paramWeakReference;
      AppMethodBeat.o(216333);
    }
    
    private static void d(Dialog paramDialog)
    {
      AppMethodBeat.i(216331);
      if ((paramDialog != null) && (paramDialog.isShowing())) {
        paramDialog.dismiss();
      }
      if (paramDialog != null) {
        paramDialog.setCancelMessage(null);
      }
      if (paramDialog != null)
      {
        paramDialog.setDismissMessage(null);
        AppMethodBeat.o(216331);
        return;
      }
      AppMethodBeat.o(216331);
    }
    
    public final void bjG(String paramString)
    {
      AppMethodBeat.i(216325);
      kotlin.g.b.p.k(paramString, "url");
      i locali = (i)this.PGQ.get();
      if (locali == null)
      {
        AppMethodBeat.o(216325);
        return;
      }
      kotlin.g.b.p.j(locali, "weakController.get() ?: return");
      locali.n(paramString, true, 9);
      AppMethodBeat.o(216325);
    }
    
    public final void cVG()
    {
      AppMethodBeat.i(216329);
      d((Dialog)this.PIW);
      this.PIW = null;
      AppMethodBeat.o(216329);
    }
    
    public final void e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(216328);
      kotlin.g.b.p.k(paramOnCancelListener, "cancelListener");
      i locali = (i)this.PGQ.get();
      if (locali == null)
      {
        AppMethodBeat.o(216328);
        return;
      }
      kotlin.g.b.p.j(locali, "weakController.get() ?: return");
      d((Dialog)this.PIW);
      this.PIW = com.tencent.mm.ui.base.h.a(locali.pHS.getActivityContextIfHas(), locali.getContext().getString(c.i.oauth_logining), true, paramOnCancelListener);
      AppMethodBeat.o(216328);
    }
    
    public final void goBack()
    {
      AppMethodBeat.i(216327);
      Object localObject = (i)this.PGQ.get();
      if (localObject == null)
      {
        AppMethodBeat.o(216327);
        return;
      }
      kotlin.g.b.p.j(localObject, "weakController.get() ?: return");
      localObject = ((Iterable)((BaseWebViewController)localObject).PGb).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((j)((Iterator)localObject).next()).gSX();
      }
      AppMethodBeat.o(216327);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(i parami, Uri paramUri) {}
    
    public final void run()
    {
      AppMethodBeat.i(232126);
      com.tencent.mm.pluginsdk.model.app.h.h(this.PIz.pHS.getActivityContextIfHas(), this.PIX);
      AppMethodBeat.o(232126);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/HashSet;", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<HashSet<String>>
  {
    x(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    y(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    z(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.i
 * JD-Core Version:    0.7.0.1
 */