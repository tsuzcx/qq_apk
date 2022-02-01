package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.luggage.xweb_ext.extendplugin.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.c.a;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.model.ag.a;
import com.tencent.mm.plugin.webview.model.ag.b;
import com.tencent.mm.plugin.webview.model.ag.c;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.av;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ba;
import com.tencent.mm.plugin.webview.model.ba.c;
import com.tencent.mm.plugin.webview.model.ba.f;
import com.tencent.mm.plugin.webview.model.ba.g;
import com.tencent.mm.plugin.webview.model.ba.k;
import com.tencent.mm.plugin.webview.model.ba.l;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUIStyleHelper;
import com.tencent.mm.plugin.webview.ui.tools.i.a.a;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.n.n;
import kotlin.v;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "WC_TAG", "getWC_TAG", "()Ljava/lang/String;", "WC_TAG$delegate", "Lkotlin/Lazy;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "getOauthDelegate", "()Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$oauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$oauthHandler$1;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;)V", "pageEndTime", "pageStarted", "getPageStarted", "setPageStarted", "(Z)V", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "webOAuthSnapShotUI", "Lcom/tencent/mm/plugin/webview/snapshot/IWebOAuthSnapshotUI;", "getWebOAuthSnapShotUI", "()Lcom/tencent/mm/plugin/webview/snapshot/IWebOAuthSnapshotUI;", "setWebOAuthSnapShotUI", "(Lcom/tencent/mm/plugin/webview/snapshot/IWebOAuthSnapshotUI;)V", "webTransNewFloatStoreInfo", "Lcom/tencent/mm/plugin/webview/WebTransNewFloatStoreInfo;", "getWebTransNewFloatStoreInfo", "()Lcom/tencent/mm/plugin/webview/WebTransNewFloatStoreInfo;", "setWebTransNewFloatStoreInfo", "(Lcom/tencent/mm/plugin/webview/WebTransNewFloatStoreInfo;)V", "webViewFloatBallInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "getWebViewFloatBallInfo", "()Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "webViewMenuHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "getWebViewMenuHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "setWebViewMenuHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;)V", "webViewUIProxyImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "getWebViewUIProxyImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "setWebViewUIProxyImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;)V", "webViewUIStyleHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "getWebViewUIStyleHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "setWebViewUIStyleHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;)V", "getWebviewReportMgr", "()Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "dealWeixinScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getA8keyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getCachedAppId", "getScene", "username", "getWebViewPluginClientProxy", "handleUrl", "initEnviroment", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "loadUrl", "httpHeaders", "", "withoutCache", "needSyncGetA8Key", "onBinded", "onDestroy", "onFloatBallDestroy", "onJsReady", "onLoadResource", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "onWebViewUIDestroy", "overrideProcessResult", "resp", "overrideUrl", "webView", "reOauth", "releaseWebView", "removeSceneEnd", "requestSetFontSize", "fontSize", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "updateSnapShotOauthStatus", "updateTouchStatus", "hasTouch", "updateUIStyle", "webPrefetchPage", "uiConfig", "jsApiPermission", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "Companion", "SceneEndCallbacker", "VisitInfoReport", "WebViewControllerOnSceneEndDelegate", "WebViewUIDelegateImpl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public class k
  extends BaseWebViewController
{
  public static final d Wyd;
  public final ag.c WyA;
  s WyB;
  private long WyC;
  private final List<com.tencent.mm.plugin.webview.jsapi.d.a> WyD;
  private final y WyE;
  private final j WyF;
  private final e WyG;
  private final k WyH;
  private final l WyI;
  private final a WyJ;
  private String WyK;
  private final boolean WyL;
  private final p WyM;
  private final i WyN;
  private final o WyO;
  private final g WyP;
  private final b WyQ;
  private final m WyR;
  private final c WyS;
  private long WyT;
  private final f WyU;
  private final h WyV;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c WyW;
  public final ba Wye;
  private final kotlin.j Wyf;
  private final kotlin.j Wyg;
  public com.tencent.mm.plugin.webview.ui.tools.o Wyh;
  public WebViewUIStyleHelper Wyi;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h Wyj;
  public final com.tencent.mm.plugin.webview.ui.tools.floatball.c Wyk;
  public com.tencent.mm.plugin.webview.j Wyl;
  public com.tencent.mm.plugin.webview.j.a Wym;
  private final kotlin.j Wyn;
  private final kotlin.j Wyo;
  private final kotlin.j Wyp;
  private final kotlin.j Wyq;
  public final ar Wyr;
  private final kotlin.j Wys;
  private final kotlin.j Wyt;
  public String Wyu;
  private final kotlin.j Wyv;
  public boolean Wyw;
  private final String Wyx;
  private final Set<String> Wyy;
  private final kotlin.j Wyz;
  
  static
  {
    AppMethodBeat.i(295346);
    Wyd = new d((byte)0);
    AppMethodBeat.o(295346);
  }
  
  public k(MMWebView paramMMWebView, ba paramba, BaseWebViewController.d paramd)
  {
    this(paramMMWebView, paramba, paramd, null, null, 16);
    AppMethodBeat.i(295173);
    AppMethodBeat.o(295173);
  }
  
  public k(final MMWebView paramMMWebView, ba paramba, BaseWebViewController.d paramd, Set<String> paramSet, com.tencent.mm.plugin.webview.jsapi.g paramg)
  {
    super(paramMMWebView, paramd, paramSet, paramg);
    AppMethodBeat.i(295161);
    this.Wye = paramba;
    this.Wyf = kotlin.k.cm((kotlin.g.a.a)new r(this));
    this.Wyg = kotlin.k.cm((kotlin.g.a.a)ad.Wzw);
    this.Wyk = new com.tencent.mm.plugin.webview.ui.tools.floatball.c();
    this.Wyn = kotlin.k.cm((kotlin.g.a.a)new u(this));
    this.Wyo = kotlin.k.cm((kotlin.g.a.a)new w(this));
    this.Wyp = kotlin.k.cm((kotlin.g.a.a)new v(this));
    this.Wyq = kotlin.k.cm((kotlin.g.a.a)new ae(this));
    getContext();
    this.Wyr = new ar();
    this.Wys = kotlin.k.cm((kotlin.g.a.a)new x(this));
    this.Wyt = kotlin.k.cm((kotlin.g.a.a)new ac(paramMMWebView));
    this.Wyv = kotlin.k.cm((kotlin.g.a.a)aa.Wzv);
    this.Wyx = "file:///android_asset/jsapi/wxjs.js";
    this.Wyy = ((Set)new HashSet());
    this.Wyz = kotlin.k.cm((kotlin.g.a.a)new ab(this));
    this.WyA = ((ag.c)new t(new WeakReference(this)));
    this.WyB = new s(new WeakReference(this));
    this.WyD = ((List)new ArrayList());
    this.WyE = new y(paramd, this);
    this.WyF = new j(this);
    this.WyG = new e(this);
    this.WyH = new k(this);
    this.WyI = new l(this);
    this.WyJ = new a(this);
    this.WyL = true;
    this.WyM = new p(this, paramMMWebView);
    this.WyN = new i(this);
    this.WyO = new o(this);
    this.WyP = new g(this);
    this.WyQ = new b(this);
    this.WyR = new m(this);
    this.WyS = new c(this);
    this.WyU = new f(this, paramMMWebView);
    this.WyV = new h(this);
    AppMethodBeat.o(295161);
  }
  
  private static final String a(k paramk, String paramString)
  {
    AppMethodBeat.i(295260);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int j;
      try
      {
        paramString = InetAddress.getAllByName(paramString);
        if ((paramString != null) && (paramString.length > 0))
        {
          int k = paramString.length - 1;
          if (k >= 0)
          {
            i = 0;
            j = i + 1;
            localStringBuilder.append(paramString[i].getHostAddress());
            localStringBuilder.append(";");
            if (j <= k) {
              break label114;
            }
          }
        }
        paramk = localStringBuilder.toString();
        AppMethodBeat.o(295260);
        return paramk;
      }
      catch (UnknownHostException paramString)
      {
        Log.printErrStackTrace(paramk.iss(), (Throwable)paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(295260);
        return null;
      }
      label114:
      int i = j;
    }
  }
  
  private static final void a(k paramk, int paramInt)
  {
    AppMethodBeat.i(295276);
    kotlin.g.b.s.u(paramk, "this$0");
    com.tencent.mm.plugin.webview.jsapi.j localj = paramk.getJsapi();
    if (!localj.UcS) {
      Log.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
    }
    for (;;)
    {
      paramk.atp(paramInt);
      AppMethodBeat.o(295276);
      return;
      Object localObject = new HashMap();
      ((Map)localObject).put("fontSize", String.valueOf(paramInt));
      localObject = p.a.b("menu:setfont", (Map)localObject, localj.WDI, localj.KQY);
      localj.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + (String)localObject + ")", null);
    }
  }
  
  private static final void a(k paramk, Uri paramUri)
  {
    AppMethodBeat.i(295283);
    kotlin.g.b.s.u(paramk, "this$0");
    paramk = paramk.sMP.getActivityContextIfHas();
    if ((paramk == null) || (paramUri == null))
    {
      Log.i("MicroMsg.AppInfoLogic", "launchApp failed, context or uri is null.");
      AppMethodBeat.o(295283);
      return;
    }
    Log.i("MicroMsg.AppInfoLogic", "try to launchApp with uri.");
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.addFlags(268435456);
    com.tencent.mm.pluginsdk.model.app.h.a(paramk, paramUri, null, null, null);
    AppMethodBeat.o(295283);
  }
  
  private static final void a(String paramString1, int paramInt, String paramString2, k paramk)
  {
    AppMethodBeat.i(295268);
    kotlin.g.b.s.u(paramk, "this$0");
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    Object localObject = MMApplicationContext.getContext();
    kotlin.g.b.s.s(localObject, "getContext()");
    if (NetStatusUtil.isWifi((Context)localObject)) {
      localObject = "wifi";
    }
    for (;;)
    {
      localh.b(17082, new Object[] { paramString1, Integer.valueOf(paramInt), localObject, a(paramk, paramString2) });
      AppMethodBeat.o(295268);
      return;
      if (NetStatusUtil.is5G((Context)localObject)) {
        localObject = "5g";
      } else if (NetStatusUtil.is4G((Context)localObject)) {
        localObject = "4g";
      } else if (NetStatusUtil.is3G((Context)localObject)) {
        localObject = "3g";
      } else if (NetStatusUtil.is2G((Context)localObject)) {
        localObject = "2g";
      } else {
        localObject = "none";
      }
    }
  }
  
  private void bjk(String paramString)
  {
    AppMethodBeat.i(295196);
    kotlin.g.b.s.u(paramString, "url");
    boolean bool = getIntent().getBooleanExtra(f.s.adxg, false);
    if ((this.sLD.iwp().iPO()) || (bool))
    {
      Log.i(iss(), kotlin.g.b.s.X("allowJumpWithoutPerm: ", Boolean.valueOf(bool)));
      Bundle localBundle = new Bundle();
      localBundle.putInt("fromScene", 100);
      if (irJ().a(paramString, this.sLD.iwo().sk(7), localBundle))
      {
        Log.i(iss(), kotlin.g.b.s.X("shouldOverride, built in url handled, url = ", paramString));
        AppMethodBeat.o(295196);
      }
    }
    else
    {
      Log.w(iss(), "shouldOverride, allow inner open url, not allow");
    }
    AppMethodBeat.o(295196);
  }
  
  private final boolean bjl(String paramString)
  {
    AppMethodBeat.i(295211);
    if (Util.isNullOrNil(paramString))
    {
      Log.e(iss(), "search contact err: null or nill url");
      AppMethodBeat.o(295211);
      return false;
    }
    isz();
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", isy().irL());
    try
    {
      irJ().C(106, localBundle);
      AppMethodBeat.o(295211);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w(iss(), kotlin.g.b.s.X("startSearchContact, ex = ", paramString.getMessage()));
      }
    }
  }
  
  private final boolean bjm(String paramString)
  {
    AppMethodBeat.i(295223);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(295223);
      return false;
    }
    for (;;)
    {
      try
      {
        if ((com.tencent.luggage.l.c.a(paramString, "weixin://jump/", true)) || (com.tencent.luggage.l.c.a(paramString, "weixin://scanqrcode/", true)))
        {
          bjk(paramString);
          AppMethodBeat.o(295223);
          return true;
        }
        if ((com.tencent.luggage.l.c.a(paramString, "weixin://dl/business", true)) && (com.tencent.mm.pluginsdk.g.p(Uri.parse(paramString))))
        {
          localObject2 = Uri.parse(dgY()).getHost();
          localObject1 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject1).addCategory("android.intent.category.BROWSABLE");
          ((Intent)localObject1).setData(Uri.parse(paramString + "&domain=" + localObject2));
          i = ((Intent)localObject1).getIntExtra("pay_channel", -1);
          if (i != -1)
          {
            Log.i(iss(), "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
            ((Intent)localObject1).putExtra("pay_channel", i);
          }
          ((Intent)localObject1).putExtra("translate_link_scene", 13);
          localObject2 = getContext();
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealWeixinScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/webview/core/WebViewController", "dealWeixinScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(295223);
          return true;
        }
        if (!com.tencent.luggage.l.c.K(paramString, "weixinpreinject://iframe")) {
          continue;
        }
        Log.i(iss(), "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
      }
      catch (Exception localException)
      {
        Object localObject2;
        Log.w(iss(), kotlin.g.b.s.X("shouldOverride, jumpToActivity, ex = ", localException.getMessage()));
        continue;
        if (!com.tencent.luggage.l.c.K(paramString, "weixin://")) {
          continue;
        }
        Log.e(iss(), "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        AppMethodBeat.o(295223);
        return true;
        AppMethodBeat.o(295223);
      }
      if (bjo(paramString))
      {
        AppMethodBeat.o(295223);
        return true;
        if ((com.tencent.luggage.l.c.K(paramString, "weixin://dl/login/common_view")) || (com.tencent.luggage.l.c.K(paramString, "weixin://dl/login/phone_view")))
        {
          localObject1 = dgY();
          localObject2 = com.tencent.mm.pluginsdk.g.XNG;
          kotlin.g.b.s.s(localObject2, "PREFIX_SUPPORT_QQ");
          if (!com.tencent.luggage.l.c.K((String)localObject1, (String)localObject2))
          {
            localObject1 = com.tencent.mm.pluginsdk.g.XNH;
            kotlin.g.b.s.s(localObject1, "PREFIX_SUPPORT_WECHAT");
            if (!com.tencent.luggage.l.c.K(paramString, (String)localObject1)) {
              continue;
            }
          }
          if (!((Boolean)this.Wyo.getValue()).booleanValue()) {
            continue;
          }
          com.tencent.mm.pluginsdk.g.cC(this.sMP.getActivityContextIfHas(), paramString);
          onFinish();
          AppMethodBeat.o(295223);
          return true;
        }
        if ((!com.tencent.luggage.l.c.K(paramString, "weixin://webview/initReady/")) && (!com.tencent.luggage.l.c.K(paramString, "weixin://webview/preInjectJSBridge/"))) {
          continue;
        }
        AppMethodBeat.o(295223);
        return true;
      }
    }
    return false;
  }
  
  private final boolean bjn(String paramString)
  {
    String str = null;
    AppMethodBeat.i(295242);
    Log.i(iss(), kotlin.g.b.s.X("dealCustomScheme, url = ", paramString));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(295242);
      return false;
    }
    Object localObject4;
    try
    {
      if (irJ().iI(paramString))
      {
        Log.i(iss(), kotlin.g.b.s.X("dealCustomScheme, url is handled by QrCodeURLHelper, url = ", paramString));
        irJ().ib(paramString, irL());
        AppMethodBeat.o(295242);
        return true;
      }
    }
    catch (Exception localException1)
    {
      Log.w(iss(), kotlin.g.b.s.X("dealCustomScheme, tryHandleEvents, ex = ", localException1.getMessage()));
      localObject4 = Uri.parse(paramString);
      if (localObject4 == null) {
        break label1373;
      }
    }
    Object localObject1;
    Object localObject3;
    if ((!n.U(paramString, "weixin://", false)) && (!n.U(paramString, "http", false)))
    {
      if (n.U(paramString, "tel:", false))
      {
        paramString = n.m(paramString, "tel:", "", false);
        if (!Util.isNullOrNil(paramString)) {}
        try
        {
          irJ().id(paramString, irL());
          AppMethodBeat.o(295242);
          return true;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.w(iss(), "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
          }
        }
      }
      if ((n.U(paramString, "sms:", false)) || (n.U(paramString, "smsto:", false)))
      {
        if (this.sMP.getActivityContextIfHas() == null)
        {
          Log.e(iss(), "sms, viewWV.activityContextIfHas = null");
          AppMethodBeat.o(295242);
          return true;
        }
        localObject1 = com.tencent.mm.plugin.webview.ui.tools.i.WUj;
        localObject3 = this.sMP.getActivityContextIfHas();
        kotlin.g.b.s.s(localObject3, "viewWV.activityContextIfHas");
        kotlin.g.b.s.u(localObject3, "context");
        kotlin.g.b.s.u(paramString, "url");
        kotlin.g.b.s.u(localObject3, "context");
        kotlin.g.b.s.u(paramString, "url");
        localObject1 = new kotlin.n.k("sms:(\\d*)(\\?body=(.*))?");
        localObject4 = URLDecoder.decode(paramString, "UTF-8");
        kotlin.g.b.s.s(localObject4, "decodedUrl");
        localObject4 = ((kotlin.n.k)localObject1).bo((CharSequence)localObject4);
        if (localObject4 == null)
        {
          localObject1 = null;
          if (localObject4 != null) {
            break label504;
          }
          label398:
          localObject4 = (CharSequence)localObject1;
          if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
            break label532;
          }
          i = 1;
          label422:
          if (i == 0) {
            break label537;
          }
          localObject1 = ((Context)localObject3).getString(c.i.url_handler_sms_no_body_number);
          label436:
          if (Util.isNullOrNil((String)localObject1)) {
            break label732;
          }
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i.a.a((Context)localObject3, (String)localObject1, paramString));
        }
        for (;;)
        {
          AppMethodBeat.o(295242);
          return true;
          localObject1 = ((kotlin.n.i)localObject4).kBp();
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = (String)kotlin.a.p.ae((List)localObject1, 1);
          break;
          label504:
          localObject4 = ((kotlin.n.i)localObject4).kBp();
          if (localObject4 == null) {
            break label398;
          }
          str = (String)kotlin.a.p.ae((List)localObject4, 3);
          break label398;
          label532:
          i = 0;
          break label422;
          label537:
          localObject4 = (CharSequence)localObject1;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
          {
            i = 1;
            label561:
            if (i != 0) {
              break label628;
            }
            localObject4 = (CharSequence)str;
            if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
              break label623;
            }
          }
          label623:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label628;
            }
            localObject1 = Util.safeFormatString(((Context)localObject3).getString(c.i.url_handler_sms_no_body_with_number), new Object[] { localObject1 });
            break;
            i = 0;
            break label561;
          }
          label628:
          localObject4 = (CharSequence)localObject1;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
          {
            i = 1;
            label652:
            if (i != 0) {
              break label724;
            }
            localObject4 = (CharSequence)str;
            if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
              break label719;
            }
          }
          label719:
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label724;
            }
            localObject1 = Util.safeFormatString(((Context)localObject3).getString(c.i.url_handler_sms_with_body_number), new Object[] { str, localObject1 });
            break;
            i = 0;
            break label652;
          }
          label724:
          localObject1 = "";
          break label436;
          label732:
          Log.e(com.tencent.mm.plugin.webview.ui.tools.i.access$getTAG$cp(), "sms, url is illegal, url = %s", new Object[] { paramString });
        }
      }
      if (n.U(paramString, "mailto:", false))
      {
        paramString = new Intent("android.intent.action.SENDTO");
        paramString.addFlags(268435456);
        paramString.setData((Uri)localObject4);
        try
        {
          localObject1 = getContext();
          paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramString.aYi(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)paramString.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(295242);
          return true;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e(iss(), "start mailto app failed:[%s]", new Object[] { paramString.getMessage() });
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if ((this.sLD.iwp().YxC & 0x2000) == 0) {
          break label1381;
        }
        bool = true;
        Log.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = ".concat(String.valueOf(bool)));
        if ((!bool) && (irJ().iwU()))
        {
          Log.e(iss(), "dealCustomScheme, not allow outer open url");
          AppMethodBeat.o(295242);
          return true;
        }
        i = getIntent().getIntExtra("key_download_restrict", 0);
        localObject1 = getIntent().getStringExtra("key_function_id");
        if (!Util.isNullOrNil((String)localObject1)) {
          com.tencent.mm.plugin.report.service.h.OAn.b(14596, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (i == 1)
        {
          Log.e(iss(), "not allow launch app by custom scheme : %s", new Object[] { paramString });
          AppMethodBeat.o(295242);
          return true;
        }
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace(iss(), (Throwable)localException2, "", new Object[0]);
        long l = Util.nowSecond() - this.WyC;
        Log.i(iss(), "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
        if (l <= 2L)
        {
          str = getCurrentUrl();
          localObject2 = str;
        }
        try
        {
          str = com.tencent.mm.compatible.util.r.as(str, "UTF-8");
          localObject2 = str;
          localObject3 = com.tencent.mm.compatible.util.r.as(paramString, "UTF-8");
          paramString = (String)localObject3;
          localObject2 = str;
        }
        catch (Exception localException3)
        {
          Log.i(iss(), "formate url failed");
          continue;
          localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject4);
          ((Intent)localObject2).addFlags(268435456);
          if (!Util.isIntentAvailable(getContext(), (Intent)localObject2)) {
            break label1373;
          }
          paramString = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(295242);
          return true;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(13983, new Object[] { Integer.valueOf(4), localObject2, paramString });
        if (getIntent().getBooleanExtra("show_openapp_dialog", true))
        {
          bool = com.tencent.mm.ci.a.post(new k..ExternalSyntheticLambda1(this, (Uri)localObject4));
          AppMethodBeat.o(295242);
          return bool;
        }
      }
      label1373:
      AppMethodBeat.o(295242);
      return false;
      label1381:
      boolean bool = false;
    }
  }
  
  private boolean bjo(String paramString)
  {
    AppMethodBeat.i(295248);
    kotlin.g.b.s.u(paramString, "url");
    Iterator localIterator = this.WyD.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.jsapi.d.a locala = (com.tencent.mm.plugin.webview.jsapi.d.a)localIterator.next();
      if (locala.bjq(paramString))
      {
        Log.i(iss(), kotlin.g.b.s.X("url handled, url = ", paramString));
        boolean bool = locala.bjo(paramString);
        Log.i(iss(), "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(295248);
        return true;
      }
    }
    AppMethodBeat.o(295248);
    return false;
  }
  
  private final void bjp(String paramString)
  {
    AppMethodBeat.i(295256);
    if (!this.WyE.bjs(paramString))
    {
      It(false);
      if (this.Wwf.WxG) {
        com.tencent.mm.plugin.webview.modeltools.h.bkP(paramString);
      }
    }
    AppMethodBeat.o(295256);
  }
  
  private final String ist()
  {
    AppMethodBeat.i(295181);
    if (!atn(this.WwV))
    {
      AppMethodBeat.o(295181);
      return "";
    }
    String str = getIntent().getStringExtra("KPublisherId");
    AppMethodBeat.o(295181);
    return str;
  }
  
  private final q isu()
  {
    AppMethodBeat.i(295189);
    q localq = (q)this.Wyq.getValue();
    AppMethodBeat.o(295189);
    return localq;
  }
  
  private final n isy()
  {
    AppMethodBeat.i(295199);
    n localn = (n)this.Wyz.getValue();
    AppMethodBeat.o(295199);
    return localn;
  }
  
  private final void isz()
  {
    AppMethodBeat.i(295206);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 106);
      localBundle.putInt("scene_end_listener_hash_code", isy().irL());
      irJ().a(5, localBundle, isy().irL());
      AppMethodBeat.o(295206);
      return;
    }
    catch (Exception localException)
    {
      Log.e(iss(), kotlin.g.b.s.X("addSceneEnd, ex = ", localException.getMessage()));
      AppMethodBeat.o(295206);
    }
  }
  
  public final void It(boolean paramBoolean)
  {
    this.WyE.Wzs = paramBoolean;
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(295419);
    if (!atn(this.WwV))
    {
      Log.i(iss(), "onReceivedError, intent not ready");
      AppMethodBeat.o(295419);
      return;
    }
    String str = WeChatHosts.domainString(c.i.host_mp_weixin_qq_com);
    com.tencent.xweb.util.l.OZ(false);
    boolean bool = NetStatusUtil.isConnected(MMApplicationContext.getContext());
    Log.e(iss(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(155L, com.tencent.mm.plugin.webview.h.a.atR(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.h.hw(ist(), 1);
    com.tencent.mm.plugin.topstory.a.h.hw(ist(), com.tencent.mm.plugin.webview.h.a.atR(paramInt));
    com.tencent.mm.plugin.topstory.a.h.g(ist(), dgY(), com.tencent.mm.plugin.webview.h.a.atR(paramInt), this.Wye.ivH().enterTime);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    com.tencent.mm.plugin.webview.ui.tools.r.WWq.auu(paramInt);
    this.Wye.ivP().errCode = paramInt;
    com.tencent.mm.plugin.webview.ui.tools.t localt = com.tencent.mm.plugin.webview.ui.tools.t.WWO;
    com.tencent.mm.plugin.webview.ui.tools.t.setErrCode(paramInt);
    if (((Boolean)this.Wyp.getValue()).booleanValue()) {
      onFinish();
    }
    try
    {
      if (kotlin.g.b.s.p(new URL(paramString2).getHost(), str)) {
        com.tencent.threadpool.h.ahAA.g(new k..ExternalSyntheticLambda2(paramString2, paramInt, str, this), "WebViewUI.CheckDNS");
      }
      super.a(paramWebView, paramInt, paramString1, paramString2);
      AppMethodBeat.o(295419);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Log.printErrStackTrace(iss(), (Throwable)localMalformedURLException, "check mp url", new Object[0]);
      }
    }
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.t paramt, SslError paramSslError)
  {
    AppMethodBeat.i(295411);
    if (!atn(this.WwV))
    {
      Log.i(iss(), "onReceivedSslError, intent not ready");
      AppMethodBeat.o(295411);
      return;
    }
    com.tencent.xweb.util.l.OZ(true);
    String str1;
    if (paramWebView == null)
    {
      str1 = null;
      if (str1 != null) {
        break label202;
      }
      str1 = this.Www;
      label56:
      if (str1 == null) {
        break label211;
      }
      String str2 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbz();
      kotlin.g.b.s.s(str2, "service(IBrandService::class.java).hardCodeUrl");
      if (!n.U(str1, str2, false)) {
        break label211;
      }
      str1 = dgY();
    }
    label202:
    label211:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.h.hw(ist(), 1);
      com.tencent.mm.plugin.topstory.a.h.hw(ist(), 30);
      com.tencent.mm.plugin.topstory.a.h.g(ist(), dgY(), 30, this.Wye.ivH().enterTime);
      isv().a(str1, paramt, paramSslError);
      super.a(paramWebView, paramt, paramSslError);
      AppMethodBeat.o(295411);
      return;
      str1 = paramWebView.getUrl();
      break;
      str1 = paramWebView.getUrl();
      break label56;
    }
  }
  
  public final void a(boolean paramBoolean, String paramString, JsapiPermissionWrapper paramJsapiPermissionWrapper)
  {
    AppMethodBeat.i(295548);
    kotlin.g.b.s.u(paramString, "uiConfig");
    super.a(paramBoolean, paramString, paramJsapiPermissionWrapper);
    int i;
    WebViewUIStyleHelper localWebViewUIStyleHelper;
    if (paramBoolean)
    {
      if (((CharSequence)paramString).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label627;
        }
        localWebViewUIStyleHelper = this.Wyi;
        if (localWebViewUIStyleHelper == null) {
          break label627;
        }
        if ((localWebViewUIStyleHelper.WUm != null) && (localWebViewUIStyleHelper.WZl != null) && (localWebViewUIStyleHelper.WUm.WYp != null) && (paramJsapiPermissionWrapper != null)) {
          break;
        }
        AppMethodBeat.o(295548);
        return;
      }
    }
    Object localObject1;
    Object localObject2;
    label468:
    int n;
    label513:
    label559:
    label627:
    do
    {
      do
      {
        do
        {
          int m;
          for (;;)
          {
            try
            {
              JSONArray localJSONArray = new JSONObject(paramString).optJSONArray("uiConfigs");
              if (localJSONArray != null)
              {
                i = localJSONArray.length();
                if (i > 0) {}
              }
              else
              {
                AppMethodBeat.o(295548);
                return;
              }
              int i1 = localJSONArray.length();
              int k = 0;
              if (k >= i1) {
                break label911;
              }
              localObject1 = localJSONArray.optJSONObject(k);
              if (localObject1 != null)
              {
                paramString = ((JSONObject)localObject1).optString("func");
                localObject2 = ((JSONObject)localObject1).optJSONObject("data");
                Log.d("MicroMsg.WebViewUIStyleHelper", "configWebPrefetchUIStyle funcName: %s", new Object[] { paramString });
                if (localWebViewUIStyleHelper.WUm != null)
                {
                  localObject1 = com.tencent.mm.plugin.webview.ui.tools.newjsapi.ak.Xoa;
                  if (!paramString.equals(com.tencent.mm.plugin.webview.ui.tools.newjsapi.ak.idA)) {
                    break label681;
                  }
                  localObject1 = com.tencent.mm.plugin.webview.ui.tools.newjsapi.ak.Xoa;
                  if (!paramJsapiPermissionWrapper.sk(com.tencent.mm.plugin.webview.ui.tools.newjsapi.ak.OOk)) {
                    break label681;
                  }
                  if (!localWebViewUIStyleHelper.WUm.WYp.WUq)
                  {
                    localWebViewUIStyleHelper.WZk = true;
                    localWebViewUIStyleHelper.WZj = true;
                    com.tencent.mm.plugin.webview.ui.tools.l locall = localWebViewUIStyleHelper.WZl;
                    if ((locall.WUm != null) && (localObject2 != null))
                    {
                      Log.i("MicroMsg.WebPrefetcherUIStyleHelper", "setNavigationBarColor");
                      paramBoolean = kotlin.g.b.s.p("1", ((JSONObject)localObject2).optString("actionCode", ""));
                      localObject3 = new Bundle();
                      if (!paramBoolean) {
                        continue;
                      }
                      ((Bundle)localObject3).putBoolean("set_navigation_bar_color_reset", true);
                      paramString = locall.WUm;
                      if (paramString != null) {
                        paramString.bl((Bundle)localObject3);
                      }
                    }
                  }
                }
              }
              k += 1;
              continue;
              i = 255;
            }
            catch (Exception paramString)
            {
              int j;
              Log.printErrStackTrace("MicroMsg.WebViewUIStyleHelper", paramString, "configWebPrefetchUIStyle exception", new Object[0]);
            }
            try
            {
              localObject1 = aa.brW(((JSONObject)localObject2).optString("wxcolor", ""));
              paramString = (String)localObject1;
              if (Util.isNullOrNil((String)localObject1)) {
                paramString = ((JSONObject)localObject2).optString("color", "");
              }
              j = Color.parseColor(paramString);
              m = j | 0xFF000000;
            }
            catch (Exception paramString)
            {
              Log.printErrStackTrace("MicroMsg.WebPrefetcherUIStyleHelper", (Throwable)paramString, "", new Object[0]);
              ((Bundle)localObject3).putBoolean("set_navigation_bar_color_reset", true);
              m = -1;
              continue;
            }
            j = i;
            try
            {
              paramString = ((JSONObject)localObject2).optString("alpha", "");
              j = i;
              localObject1 = (CharSequence)paramString;
              if (localObject1 == null) {
                break label918;
              }
              j = i;
              if (!n.bp((CharSequence)localObject1)) {
                break label938;
              }
            }
            catch (Exception paramString)
            {
              Log.e("MicroMsg.WebPrefetcherUIStyleHelper", paramString.getMessage());
              continue;
            }
            j = i;
            if (n == 0)
            {
              j = i;
              n = (int)(Util.getFloat(paramString, 1.0F) * 255.0F);
              if (n < 0) {
                break label924;
              }
              i = n;
              if (n > 255) {
                break label924;
              }
              j = i;
              paramString = ((JSONObject)localObject2).optString("titleAlphaAdjustment", "");
              j = i;
              localObject1 = (CharSequence)paramString;
              if (localObject1 == null) {
                break label932;
              }
              j = i;
              if (!n.bp((CharSequence)localObject1)) {
                break label944;
              }
              break label932;
              j = i;
              if (n == 0)
              {
                j = i;
                ((Bundle)localObject3).putBoolean("set_navigation_bar_color_titleAlphaAdjustment", Util.getBoolean(paramString, false));
                j = i;
              }
            }
            ((Bundle)localObject3).putInt("set_navigation_bar_color_color", m);
            ((Bundle)localObject3).putInt("set_navigation_bar_color_alpha", j);
            continue;
            AppMethodBeat.o(295548);
            return;
          }
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.newjsapi.ah.XnX;
        } while (!paramString.equals(com.tencent.mm.plugin.webview.ui.tools.newjsapi.ah.idA));
        paramString = com.tencent.mm.plugin.webview.ui.tools.newjsapi.ah.XnX;
      } while (!paramJsapiPermissionWrapper.sk(com.tencent.mm.plugin.webview.ui.tools.newjsapi.ah.OOk));
      localObject1 = localWebViewUIStyleHelper.WZl;
    } while ((((com.tencent.mm.plugin.webview.ui.tools.l)localObject1).WUm == null) || (localObject2 == null));
    label681:
    Log.i("MicroMsg.WebPrefetcherUIStyleHelper", "setBounceBackground data: %s", new Object[] { localObject2 });
    paramString = aa.brW(((JSONObject)localObject2).optString("wxbackgroundColor", ""));
    Object localObject3 = (CharSequence)paramString;
    if (localObject3 != null) {
      if (((CharSequence)localObject3).length() == 0) {
        break label950;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (i != 0) {
          paramString = ((JSONObject)localObject2).optString("backgroundColor", "");
        }
        try
        {
          localObject2 = ((com.tencent.mm.plugin.webview.ui.tools.l)localObject1).WUm;
          kotlin.g.b.s.checkNotNull(localObject2);
          i = com.tencent.mm.plugin.webview.ui.tools.f.fo(paramString, ((WebViewUI)localObject2).getResources().getColor(c.c.webview_logo_bg_color));
          paramString = ((com.tencent.mm.plugin.webview.ui.tools.l)localObject1).WUm;
          if (paramString != null) {
            paramString.auv(i);
          }
          paramString = ((com.tencent.mm.plugin.webview.ui.tools.l)localObject1).WUm;
          if ((paramString != null) && (paramString.sMP != null)) {
            paramString.sMP.setBackgroundColor(i);
          }
          ((com.tencent.mm.plugin.webview.ui.tools.l)localObject1).WUn = true;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.WebPrefetcherUIStyleHelper", (Throwable)paramString, "setBounceBackground exception", new Object[0]);
        }
      }
      break;
      i = 0;
      continue;
      label911:
      AppMethodBeat.o(295548);
      return;
      label918:
      n = 1;
      break label468;
      label924:
      i = 255;
      break label513;
      label932:
      n = 1;
      break label559;
      label938:
      n = 0;
      break label468;
      label944:
      n = 0;
      break label559;
      label950:
      i = 1;
    }
  }
  
  protected boolean ajM(String paramString)
  {
    return false;
  }
  
  public final void att(int paramInt)
  {
    AppMethodBeat.i(295557);
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (paramInt <= 8) {}
    }
    else
    {
      i = 2;
    }
    com.tencent.threadpool.h.ahAA.bk(new k..ExternalSyntheticLambda0(this, i));
    AppMethodBeat.o(295557);
  }
  
  public final int avS(String paramString)
  {
    AppMethodBeat.i(295571);
    if (this.Wwf.WxF != 0)
    {
      i = this.Wwf.WxF;
      AppMethodBeat.o(295571);
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
        break label258;
      }
    }
    for (;;)
    {
      try
      {
        bool = atn(this.WwU);
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        label123:
        Log.e(iss(), kotlin.g.b.s.X("getScene fail, ex = ", paramString.getMessage()));
        i = 1;
        continue;
        i = 1;
        continue;
      }
      Log.i(iss(), "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(295571);
      return i;
      i = 0;
      break;
      if (irJ().IV(paramString))
      {
        i = 8;
      }
      else
      {
        if (irJ().IS(paramString))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("enterprise_biz_username", paramString);
          try
          {
            paramString = irJ().m(102, (Bundle)localObject);
            if (paramString != null)
            {
              bool = paramString.getBoolean("is_enterprise_username");
              if (!bool) {}
            }
          }
          catch (RemoteException paramString)
          {
            Log.e(iss(), "invoke the check enterprise failed");
            continue;
          }
          i = 7;
          continue;
        }
        label258:
        i = 0;
      }
    }
  }
  
  protected final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(295464);
    kotlin.g.b.s.u(paramWebView, "webview");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    if ((isStarted()) && (atn(this.WwU)))
    {
      Object localObject = this.Wyr;
      String str = paramWebResourceRequest.getUrl().toString();
      if (!((Boolean)this.Wys.getValue()).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = ((ar)localObject).a(str, paramWebResourceRequest, bool, irJ());
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(295464);
        return localObject;
      }
    }
    paramWebView = super.b(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(295464);
    return paramWebView;
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(295489);
    String str = iss();
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (parame != null) {
        break;
      }
      Log.f(iss(), "service connect success, while invoker is null");
      onFinish();
      AppMethodBeat.o(295489);
      return;
    }
    try
    {
      parame.a((com.tencent.mm.plugin.webview.stub.f)isy(), isy().irL());
      super.b(parame);
      AppMethodBeat.o(295489);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(iss(), "addCallback fail, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(295459);
    super.b(paramWebView, paramString);
    this.WwL.cf("onPageFinished", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.c(this.sMP, paramString);
    if (ajM(paramString))
    {
      AppMethodBeat.o(295459);
      return;
    }
    Log.i(iss(), "edw onPageFinished opt, url = %s", new Object[] { paramString });
    Object localObject1 = this.Wye.ivO();
    if ((!((ba.c)localObject1).Akx) || (((ba.c)localObject1).FrG)) {}
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.webview.ui.tools.r.WWq;
      Log.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { ((com.tencent.mm.plugin.webview.ui.tools.r)localObject1).traceid });
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.webview.ui.tools.r)localObject1).traceid)) {
        ((com.tencent.mm.plugin.webview.ui.tools.r)localObject1).rG(2);
      }
      isw().add(paramString);
      boolean bool = getIntent().getBooleanExtra("shouldForceViewPort", false);
      Log.d(iss(), kotlin.g.b.s.X("hy: shouldForceViewPort: ", Boolean.valueOf(bool)));
      if (bool)
      {
        localObject1 = getIntent().getStringExtra("view_port_code");
        kotlin.g.b.s.checkNotNull(paramWebView);
        paramWebView.evaluateJavascript((String)localObject1, null);
      }
      kotlin.g.b.s.checkNotNull(paramString);
      if (!bje(paramString)) {
        break;
      }
      Log.f(iss(), kotlin.g.b.s.X("onPageFinished, canLoadUrl fail, url = ", paramString));
      AppMethodBeat.o(295459);
      return;
      try
      {
        localObject3 = Uri.parse(paramString);
        if (paramString.startsWith("http")) {
          break label284;
        }
        Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
      }
      continue;
      label284:
      localObject3 = ((Uri)localObject3).getHost();
      if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase("v.html5.qq.com")))
      {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(283L, 0L, 1L, true);
        localException.FrG = true;
        Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
      }
    }
    if (kotlin.g.b.s.p(paramString, this.Wyx))
    {
      Log.i(iss(), "onPageFinished, js is finished loaded");
      AppMethodBeat.o(295459);
      return;
    }
    paramWebView = this.Wye.ivE();
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
      paramWebView = this.Wye.ivF();
      if (!Util.isNullOrNil(paramString)) {
        break label692;
      }
      Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
    }
    Object localObject2;
    int i;
    long l1;
    for (;;)
    {
      localObject2 = this.Wye.ivI();
      if (!((ba.g)localObject2).eoc)
      {
        ((ba.g)localObject2).eoc = true;
        i = ba.ctm();
        l1 = Util.nowMilliSecond() - ((ba.g)localObject2).startTime;
        if ((l1 >= 0L) && (l1 <= 180000L)) {
          break label762;
        }
      }
      paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
      if (paramWebView != null)
      {
        localObject2 = paramWebView.getParcelable("KSnsAdTag");
        if ((localObject2 != null) && ((localObject2 instanceof SnsAdClick)))
        {
          paramWebView = paramWebView.getString("KAnsUxInfo", "");
          this.Wye.ivP().MXi = ((SnsAdClick)localObject2);
          localObject2 = this.Wye.ivP();
          localObject3 = System.currentTimeMillis();
          kotlin.g.b.s.s(paramWebView, "uxInfo");
          ((av)localObject2).W(new String[] { paramString, "1", localObject3, paramWebView });
          this.Wye.ivP().report();
        }
      }
      paramWebView = com.tencent.mm.plugin.webview.ui.tools.t.WWO;
      com.tencent.mm.plugin.webview.ui.tools.t.a(getIntent(), paramString, true);
      this.WyC = Util.nowSecond();
      AppMethodBeat.o(295459);
      return;
      if (!paramWebView.WNk.containsKey(paramString)) {
        break;
      }
      l1 = ((Long)paramWebView.WNk.get(paramString)).longValue();
      long l2 = Util.nowMilliSecond();
      paramWebView.WNk.put(paramString, Long.valueOf(l2 - l1));
      break;
      try
      {
        label692:
        if (paramWebView.WNf.containsKey(paramString))
        {
          l1 = ((Long)paramWebView.WNf.get(paramString)).longValue();
          l2 = Util.nowMilliSecond();
          paramWebView.WNf.put(paramString, Long.valueOf(l2 - l1));
        }
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace("MicroMsg.WebviewReporter", paramWebView, "onPageFinish", new Object[0]);
      }
    }
    label762:
    Object localObject3 = ((ba.g)localObject2).WNh;
    if (((ba.g)localObject2).url == null) {}
    for (paramWebView = ((ba.g)localObject2).url;; paramWebView = ((ba.g)localObject2).url.replace(",", "!"))
    {
      ba.r((String)localObject3, new Object[] { Integer.valueOf(4), Long.valueOf(l1), Integer.valueOf(i), paramWebView, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(((ba.g)localObject2).iiA), ((ba.g)localObject2).WNh });
      Log.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { ((ba.g)localObject2).url, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(ba.access$000()), Integer.valueOf(ba.access$100()), Integer.valueOf(((ba.g)localObject2).iiA), ((ba.g)localObject2).WNh });
      break;
    }
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(295441);
    kotlin.g.b.s.u(paramWebView, "view");
    kotlin.g.b.s.u(paramString, "url");
    this.Wyw = true;
    super.b(paramWebView, paramString, paramBitmap);
    this.WwL.cf("onPageStarted", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.c(this.sMP, paramString);
    if (ajM(paramString))
    {
      AppMethodBeat.o(295441);
      return;
    }
    if (!this.sMP.supportFeature(2006)) {
      getJsapi().itK();
    }
    com.tencent.mm.plugin.webview.k.t.bna(paramString);
    Log.i(iss(), kotlin.g.b.s.X("edw onPageStarted opt, url = ", paramString));
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.h.hw(ist(), 0);
    if ((CrashReportFactory.hasDebuger()) && (kotlin.g.b.s.p("http://www.dktest-mmcrash.com/", paramString))) {
      Assert.assertTrue(kotlin.g.b.s.X("test errlog in tools ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())), false);
    }
    this.Wyu = this.Www;
    long l = Util.nowSecond();
    paramWebView = isu();
    kotlin.g.b.s.u(paramString, "targetUrl");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new k.q.a(paramWebView, paramString, l));
    this.Wye.ivG().WMF = this.Wyu;
    this.Www = paramString;
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.r.WWq;
    Log.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, paramWebView.WWr, paramWebView.traceid });
    paramBitmap = paramWebView.WWr;
    paramWebView.WWr = paramString;
    if (!Util.isNullOrNil(paramWebView.traceid)) {
      paramWebView.x(1, paramBitmap, 0);
    }
    Log.d(iss(), "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { this.Wyu, this.Www });
    if (bje(paramString))
    {
      Log.f(iss(), kotlin.g.b.s.X("onPageStarted, canLoadUrl fail, url = ", paramString));
      AppMethodBeat.o(295441);
      return;
    }
    isw().add(paramString);
    paramWebView = this.Wye.ivE();
    int i = cxN();
    paramBitmap = ist();
    paramWebView.iiA = i;
    paramWebView.WNh = paramBitmap;
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
    }
    for (;;)
    {
      paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
      if (paramWebView != null)
      {
        paramBitmap = paramWebView.getParcelable("KSnsAdTag");
        if ((paramBitmap != null) && ((paramBitmap instanceof SnsAdClick)))
        {
          paramWebView = paramWebView.getString("KAnsUxInfo", "");
          this.Wye.ivP().MXi = ((SnsAdClick)paramBitmap);
          paramBitmap = this.Wye.ivP();
          String str = System.currentTimeMillis();
          kotlin.g.b.s.s(paramWebView, "uxInfo");
          paramBitmap.W(new String[] { paramString, "0", str, paramWebView });
          this.Wye.ivP().report();
        }
      }
      paramWebView = com.tencent.mm.plugin.webview.ui.tools.t.WWO;
      com.tencent.mm.plugin.webview.ui.tools.t.a(getIntent(), paramString, false);
      bjp(paramString);
      AppMethodBeat.o(295441);
      return;
      if (!paramWebView.WNk.containsKey(paramString)) {
        paramWebView.WNk.put(paramString, Long.valueOf(Util.nowMilliSecond()));
      }
    }
  }
  
  public void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(295447);
    kotlin.g.b.s.u(paramWebView, "view");
    kotlin.g.b.s.u(paramString, "url");
    this.Www = paramString;
    super.b(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(295447);
  }
  
  protected final boolean b(int paramInt, String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(295481);
    kotlin.g.b.s.u(paramString, "reqUrl");
    kotlin.g.b.s.u(paramcdf, "resp");
    int i = paramcdf.aamK;
    String str = paramcdf.aanm;
    switch (i)
    {
    default: 
      boolean bool = super.b(paramInt, paramString, paramcdf);
      AppMethodBeat.o(295481);
      return bool;
    case 3: 
      Log.i(iss(), kotlin.g.b.s.X("getA8key-app: ", str));
      paramString = (CharSequence)str;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        Log.e(iss(), "getA8key-app, fullUrl is null");
        AppMethodBeat.o(295481);
        return false;
      }
      bjn(str);
      AppMethodBeat.o(295481);
      return true;
    case 4: 
      kotlin.g.b.s.s(str, "fullUrl");
      bjl(str);
      AppMethodBeat.o(295481);
      return true;
    }
    kotlin.g.b.s.s(str, "fullUrl");
    isz();
    paramString = new Bundle();
    paramString.putString("emoji_store_jump_url", str);
    paramString.putInt("webview_binder_id", isy().irL());
    try
    {
      irJ().C(666, paramString);
      AppMethodBeat.o(295481);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w(iss(), kotlin.g.b.s.X("startSearchContact, ex = ", paramString.getMessage()));
      }
    }
  }
  
  /* Error */
  public final String bjg(String paramString)
  {
    // Byte code:
    //   0: ldc_w 2211
    //   3: invokestatic 453	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 995	java/lang/CharSequence
    //   10: invokestatic 2216	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +118 -> 131
    //   16: new 867	android/os/Bundle
    //   19: dup
    //   20: invokespecial 868	android/os/Bundle:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w 985
    //   28: aload_0
    //   29: invokevirtual 1163	com/tencent/mm/plugin/webview/core/k:irL	()I
    //   32: invokevirtual 874	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: aload_2
    //   36: ldc_w 2218
    //   39: aload_1
    //   40: invokevirtual 983	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 888	com/tencent/mm/plugin/webview/core/k:irJ	()Lcom/tencent/mm/plugin/webview/stub/e;
    //   47: bipush 76
    //   49: aload_2
    //   50: invokeinterface 1808 3 0
    //   55: ldc_w 2220
    //   58: invokevirtual 2222	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 2225	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 2227
    //   69: invokestatic 819	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokevirtual 668	com/tencent/mm/plugin/webview/core/k:iss	()Ljava/lang/String;
    //   76: ldc_w 2229
    //   79: iconst_1
    //   80: anewarray 699	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 1056	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 2211
    //   93: invokestatic 459	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: ldc_w 1178
    //   102: astore_1
    //   103: aload_0
    //   104: invokevirtual 668	com/tencent/mm/plugin/webview/core/k:iss	()Ljava/lang/String;
    //   107: ldc_w 2231
    //   110: iconst_1
    //   111: anewarray 699	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: invokevirtual 2232	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 1189	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -34 -> 90
    //   127: astore_2
    //   128: goto -25 -> 103
    //   131: ldc_w 1178
    //   134: astore_1
    //   135: goto -45 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	k
    //   0	138	1	paramString	String
    //   23	27	2	localBundle	Bundle
    //   98	19	2	localObject1	Object
    //   127	1	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   43	72	98	finally
    //   72	90	127	finally
  }
  
  public final boolean c(int paramInt, String paramString, cdf paramcdf)
  {
    AppMethodBeat.i(295477);
    kotlin.g.b.s.u(paramString, "reqUrl");
    kotlin.g.b.s.u(paramcdf, "response");
    Object localObject = paramcdf.aanw;
    long l;
    boolean bool;
    String str;
    if (localObject == null)
    {
      l = -1L;
      this.WyT = l;
      bool = this.sMP.getIsX5Kernel();
      localObject = paramcdf.aanm;
      kotlin.g.b.s.s(localObject, "response.FullURL");
      ba.bC(bool, n.U((String)localObject, "https://", false));
      this.Wye.ivD().dH(paramString, true);
      localObject = this.Wye.ivF();
      int i = com.tencent.mm.plugin.webview.ui.tools.game.i.iiA;
      str = ist();
      ((ba.f)localObject).iiA = i;
      ((ba.f)localObject).WNh = str;
      str = paramcdf.aanm;
      if (!Util.isNullOrNil(str)) {
        break label176;
      }
      Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
    }
    for (;;)
    {
      bool = super.c(paramInt, paramString, paramcdf);
      AppMethodBeat.o(295477);
      return bool;
      l = ((aht)localObject).ZqI;
      break;
      label176:
      ((ba.f)localObject).sML = str;
      ((ba.f)localObject).WNg = true;
      if (!((ba.f)localObject).WNe.containsKey(str)) {
        ((ba.f)localObject).WNe.put(str, Long.valueOf(Util.nowMilliSecond()));
      }
      if (!((ba.f)localObject).WNf.containsKey(str)) {
        ((ba.f)localObject).WNf.put(str, Long.valueOf(Util.nowMilliSecond()));
      }
    }
  }
  
  public final int cxN()
  {
    AppMethodBeat.i(295563);
    int i = avS(getIntent().getStringExtra("geta8key_username"));
    AppMethodBeat.o(295563);
    return i;
  }
  
  protected void cxS()
  {
    AppMethodBeat.i(295392);
    a((m)new aw());
    super.cxS();
    a((m)new com.tencent.mm.plugin.webview.c.a());
    AppMethodBeat.o(295392);
  }
  
  protected void cxT()
  {
    boolean bool2 = false;
    AppMethodBeat.i(295474);
    int j = 2;
    int i = j;
    Object localObject;
    try
    {
      if (irJ().iwU()) {
        if (!this.Wwf.WxD) {
          break label296;
        }
      }
      label296:
      for (i = com.tencent.mm.plugin.webview.k.m.a(getContext(), irJ(), dgY());; i = com.tencent.mm.plugin.webview.k.m.lg(getContext()))
      {
        att(i);
        String str1 = this.sMP.getUrl();
        if (Util.isNullOrNil(str1)) {
          break label371;
        }
        localObject = this.Wyy;
        kotlin.g.b.s.checkNotNull(str1);
        if (!((Set)localObject).add(str1)) {
          break label371;
        }
        localObject = this.sLD.iwp();
        kotlin.g.b.s.s(localObject, "wvPerm.genCtrl");
        if ((((GeneralControlWrapper)localObject).YxC & 0x200) <= 0) {
          break;
        }
        bool1 = true;
        Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = ".concat(String.valueOf(bool1)));
        if (bool1)
        {
          com.tencent.mm.plugin.webview.jsapi.j localj = getJsapi();
          Log.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[] { Boolean.valueOf(localj.UcS) });
          if ((localj.WDz != null) && (localj.UcS)) {
            localj.WDz.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + p.a.b("sys:get_all_hosts", new HashMap(), localj.WDI, localj.KQY) + ")", null);
          }
        }
        if ((((GeneralControlWrapper)localObject).YxC & 0x400) <= 0) {
          break label337;
        }
        bool1 = true;
        Log.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = ".concat(String.valueOf(bool1)));
        if (!bool1) {
          break label342;
        }
        getJsapi().IC(false);
        AppMethodBeat.o(295474);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(iss(), kotlin.g.b.s.X("onLoadJsApiFinished, ex = ", localException.getMessage()));
        i = j;
        continue;
        bool1 = false;
        continue;
        label337:
        bool1 = false;
      }
      label342:
      localObject = this.Wyr;
      if (!Util.isNullOrNil(localException)) {
        break label382;
      }
    }
    boolean bool1 = bool2;
    for (;;)
    {
      if (bool1) {
        getJsapi().IC(true);
      }
      label371:
      super.cxT();
      AppMethodBeat.o(295474);
      return;
      label382:
      String str2 = Uri.parse(localException).getHost();
      bool1 = bool2;
      if (!Util.isNullOrNil(str2)) {
        bool1 = ((ar)localObject).WMn.remove(str2);
      }
    }
  }
  
  protected final void cxX()
  {
    AppMethodBeat.i(295514);
    if (irU())
    {
      Log.e(iss(), "onBinded call when activity has been finished");
      AppMethodBeat.o(295514);
      return;
    }
    Log.i(iss(), "Abe-Debug onPostBindedStart");
    this.WwL.cf("onPostBindedStart", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.r.WWq.sLC = irJ();
    Object localObject5 = getIntent().getStringExtra("ad_info");
    Object localObject6;
    Object localObject4;
    Object localObject1;
    if (localObject5 != null)
    {
      localObject6 = com.tencent.mm.plugin.webview.ui.tools.r.WWq;
      localObject4 = "";
      localObject1 = localObject4;
      if (((com.tencent.mm.plugin.webview.ui.tools.r)localObject6).sLC == null) {}
    }
    label1801:
    try
    {
      localObject1 = ((com.tencent.mm.plugin.webview.ui.tools.r)localObject6).sLC.m(23, null).getString("config_info_username");
      ((com.tencent.mm.plugin.webview.ui.tools.r)localObject6).ow((String)localObject5, (String)localObject1);
      this.WwL.cf("onJSAPIStart", System.currentTimeMillis());
      localObject1 = getIntent().getBundleExtra("jsapiargs");
      if (localObject1 == null)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
        ((Bundle)localObject1).putString("key_function_id", getIntent().getStringExtra("key_function_id"));
        Log.i(iss(), "KDownloadRestrict = %d, KFunctionID = %s", new Object[] { Integer.valueOf(((Bundle)localObject1).getInt("key_download_restrict", 0)), ((Bundle)localObject1).getString("key_function_id", "") });
        localObject4 = new Bundle();
        ((Bundle)localObject4).putBundle("jsapiargs", (Bundle)localObject1);
        ((Bundle)localObject4).putCharSequence("bizofstartfrom", (CharSequence)getIntent().getStringExtra("bizofstartfrom"));
        ((Bundle)localObject4).putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        ((Bundle)localObject4).putInt("screen_orientation", getScreenOrientation());
      }
    }
    catch (RemoteException localRemoteException2)
    {
      label1678:
      try
      {
        irJ().a(20, (Bundle)localObject4, irL());
        String str1 = getIntent().getStringExtra("geta8key_username");
        i = getIntent().getIntExtra("preChatTYPE", 0);
        localObject6 = getIntent().getStringExtra("srcUsername");
        long l = getIntent().getLongExtra("message_id", 0L);
        int j = getIntent().getIntExtra("message_index", 0);
        String str4 = getIntent().getStringExtra("KsnsViewId");
        String str2 = getIntent().getStringExtra("KPublisherId");
        localObject5 = getIntent().getStringExtra("KAppId");
        localObject4 = localObject5;
        if (localObject5 == null) {
          localObject4 = getIntent().getStringExtra("geta8key_open_webview_appid");
        }
        String str5 = getIntent().getStringExtra("pre_username");
        String str3 = getIntent().getStringExtra("expid_str");
        localObject1 = ((Bundle)localObject1).getString("key_snsad_statextstr");
        localObject5 = this.Wye.ivG();
        ((ay)localObject5).username = str1;
        ((ay)localObject5).WMG = i;
        ((ay)localObject5).idu = dgY();
        ((ay)localObject5).WMC = j;
        ((ay)localObject5).scene = avS(str1);
        ((ay)localObject5).WMB = l;
        ((ay)localObject5).WMD = new com.tencent.mm.b.p(l).toString();
        ((ay)localObject5).WEU = ((String)localObject6);
        ((ay)localObject5).WMz = str4;
        ((ay)localObject5).mso = str2;
        ((ay)localObject5).appId = ((String)localObject4);
        ((ay)localObject5).WME = str5;
        ((ay)localObject5).WMF = this.Wyu;
        ((ay)localObject5).statExtStr = ((String)localObject1);
        localObject4 = getTitle();
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
        ((ay)localObject5).title = ((String)localObject1);
        ((ay)localObject5).kLp = str3;
        localObject4 = getIntent().getStringExtra("share_report_pre_msg_desc");
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
        localObject4 = localObject1;
        if (localObject1 == null) {
          localObject4 = "";
        }
        ((ay)localObject5).desc = ((String)localObject4);
        localObject1 = this.Wwk;
        kotlin.g.b.s.u(localObject1, "browseInfo");
        ((ay)localObject5).Wwk = ((com.tencent.mm.plugin.webview.h.g)localObject1);
        localObject1 = this.Wye.ivH();
        ((com.tencent.mm.plugin.webview.model.ak)localObject1).mso = str2;
        ((com.tencent.mm.plugin.webview.model.ak)localObject1).scene = avS(str1);
        this.Wye.ivJ().idu = dgY();
        if (!isx()) {}
      }
      catch (RemoteException localRemoteException2)
      {
        label804:
        label1957:
        try
        {
          for (;;)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("srcUsername", getIntent().getStringExtra("srcUsername"));
            irJ().a(29, (Bundle)localObject1, irL());
            if (!Util.isNullOrNil((String)localObject6)) {}
            try
            {
              irJ().bls((String)localObject6);
              try
              {
                i = getIntent().getIntExtra("pay_channel", -1);
                if (i == -1) {
                  break label1607;
                }
                Log.i(iss(), "hy: found channel in intent. pay channel: %d", new Object[] { Integer.valueOf(i) });
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Object localObject2;
                  Log.e(iss(), "hy: init pay channel failed");
                  continue;
                  i = 0;
                  continue;
                  localObject6 = (CharSequence)localRemoteException2;
                  if ((localObject6 == null) || (n.bp((CharSequence)localObject6))) {}
                  for (i = 1; i == 0; i = 0)
                  {
                    ((Map)localObject5).put("srcUsername", localRemoteException2);
                    break;
                  }
                  Log.i(iss(), "default pay scene to: %s", new Object[] { Integer.valueOf(3) });
                  i = 3;
                }
                if (!this.sMP.getIsX5Kernel()) {
                  break label1917;
                }
                com.tencent.mm.pluginsdk.ui.tools.s.rG(7);
                com.tencent.mm.plugin.report.service.h.OAn.a(64, 64, 1, 0, 1, 1, false);
                try
                {
                  i = Util.getInt(irJ().blr("WebviewDisableDigestVerify"), 0);
                  Log.i(iss(), "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
                  if (i != 0) {
                    break label1878;
                  }
                  localObject3 = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                  kotlin.g.b.s.s(localObject3, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
                  if ((!((SharedPreferences)localObject3).getBoolean("wvsha1", true)) || (!this.Wwf.WxC)) {
                    break label1878;
                  }
                  getJsapi().itv();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    Object localObject3 = p.WzF;
                    if (!p.isT()) {
                      break label1957;
                    }
                    bjk(dgY());
                    for (;;)
                    {
                      this.WwL.cf("onPostBindedEnd", System.currentTimeMillis());
                      AppMethodBeat.o(295514);
                      return;
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(64L, 0L, 1L, false);
                      break;
                      localException3 = localException3;
                      Log.w(iss(), kotlin.g.b.s.X("getting js digest verification config fails, ex = ", localException3.getMessage()));
                      i = 0;
                      break label1801;
                      irJ().a(dgY(), true, null);
                    }
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      Log.w(iss(), kotlin.g.b.s.X("postBinded, jumpToActivity, ex = ", localException4.getMessage()));
                    }
                  }
                }
              }
              this.WyD.clear();
              localObject1 = getJsapi();
              localObject4 = getIntent().getStringExtra("geta8key_username");
              localObject5 = kotlin.a.ak.g(new kotlin.r[] { v.Y("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0L))), v.Y("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), v.Y("scene", Integer.valueOf(avS((String)localObject4))), v.Y("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), v.Y("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), v.Y("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))) });
              localObject6 = (CharSequence)getIntent().getStringExtra("srcUsername");
              if ((localObject6 == null) || (n.bp((CharSequence)localObject6)))
              {
                i = 1;
                if (i != 0) {
                  break label1678;
                }
                ((HashMap)localObject5).putAll((Map)kotlin.a.ak.g(new kotlin.r[] { v.Y("srcUsername", getIntent().getStringExtra("srcUsername")), v.Y("srcDisplayname", getIntent().getStringExtra("srcDisplayname")) }));
                if (!Util.isNullOrNil(getIntent().getStringExtra("KTemplateId"))) {
                  ((Map)localObject5).put("KTemplateId", String.valueOf(getIntent().getStringExtra("KTemplateId")));
                }
                i = getIntent().getIntExtra("pay_scene", -1);
                if (i == -1) {
                  break label1728;
                }
                Log.i(iss(), "get pay scene from extra: %s", new Object[] { Integer.valueOf(i) });
                ((Map)localObject5).put("pay_scene", Integer.valueOf(i));
                ((com.tencent.mm.plugin.webview.jsapi.j)localObject1).hVt = ((Map)localObject5);
                localObject1 = this.WyD;
                localObject4 = (List)new ArrayList();
                ((List)localObject4).add(getJsapi());
                ((List)localObject4).add(this.WyE);
                ((List)localObject4).add(this.WyF);
                ((List)localObject4).add(this.WyG);
                ((List)localObject4).add(this.WyH);
                ((List)localObject4).add(this.WyI);
                ((List)localObject4).add(this.WyJ);
                ((List)localObject4).add(this.WyM);
                ((List)localObject4).add(this.WyP);
                ((List)localObject4).add(this.WyQ);
                ((List)localObject4).add(this.WyS);
                ((List)localObject4).add(this.WyO);
                ((List)localObject4).add(this.WyR);
                ((List)localObject4).add(this.WyN);
                if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
                  ((List)localObject4).add(this.WyV);
                }
                ((List)localObject4).add(this.WyU);
                ((List)localObject1).addAll((Collection)localObject4);
                Log.i(iss(), "Abe-Debug controllerListeners call, size = %d", new Object[] { Integer.valueOf(this.WwO.size()) });
                localObject1 = ((Iterable)this.WwO).iterator();
                while (((Iterator)localObject1).hasNext()) {
                  ((l)((Iterator)localObject1).next()).cxX();
                }
                localRemoteException1 = localRemoteException1;
                Log.e("MicroMsg.WebViewReportUtil", "setTraceId getConfigInfo exp:%s", new Object[] { localRemoteException1 });
                localObject2 = localObject4;
                continue;
                continue;
                localRemoteException2 = localRemoteException2;
                Log.e(iss(), kotlin.g.b.s.X("postBinded, invoke AC_SET_INITIAL_ARGS, ex = ", localRemoteException2.getMessage()));
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.e(iss(), kotlin.g.b.s.X("postBinded, fail triggerGetContact, ex = ", localException1.getMessage()));
                continue;
                label1607:
                i = irJ().getPayChannel();
                if (i != -1)
                {
                  Log.i(iss(), "hy: found channel in channel helper. pay channel: %d", new Object[] { Integer.valueOf(i) });
                  getIntent().putExtra("pay_channel", i);
                }
              }
            }
          }
        }
        catch (Exception localException5)
        {
          int i;
          label1728:
          label1878:
          label1917:
          break label804;
        }
      }
    }
  }
  
  protected void dhd()
  {
    AppMethodBeat.i(295530);
    Object localObject1 = ((Iterable)this.WmV).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((m)((Iterator)localObject1).next()).f(dgY(), getIntent()))
      {
        AppMethodBeat.o(295530);
        return;
      }
    }
    if (bjo(dgY()))
    {
      AppMethodBeat.o(295530);
      return;
    }
    if (dhe())
    {
      Log.i(iss(), "needSyncGetA8Key");
      this.Wwj.a(com.tencent.mm.plugin.webview.h.c.WQx);
      localObject1 = com.tencent.mm.plugin.webview.k.s.XtJ;
      com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQD, this.Wwj);
      BaseWebViewController.a((BaseWebViewController)this, dgY(), false, 0, 6);
      AppMethodBeat.o(295530);
      return;
    }
    Log.i(iss(), kotlin.g.b.s.X("terry onStartLoad:", dgY()));
    String str = irO();
    localObject1 = (CharSequence)str;
    int i;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i(iss(), str);
        localObject1 = str;
        if (getIntent().getBooleanExtra("QRDataFlag", true)) {}
        try
        {
          localObject1 = irJ().bln(str);
          this.sMP.getSettings().setUseWideViewPort(false);
          this.sMP.getSettings().setLoadWithOverviewMode(false);
          this.sMP.getSettings().setJavaScriptEnabled(false);
          Is(true);
          this.sMP.loadDataWithBaseURL(null, (String)localObject1, "text/html", "utf-8", null);
          Log.i(iss(), kotlin.g.b.s.X("loadDataWithBaseUrl, data = ", localObject1));
          AppMethodBeat.o(295530);
          return;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.w(iss(), kotlin.g.b.s.X("postBinded, formatQRString, ex = ", localException.getMessage()));
            localObject2 = str;
          }
        }
      }
    }
    if (bje(dgY()))
    {
      Log.f(iss(), kotlin.g.b.s.X("postBinded 2, canLoadUrl fail, url = ", dgY()));
      AppMethodBeat.o(295530);
      return;
    }
    if (this.Wwf.WxE) {
      this.sLD.a(dgY(), null, null);
    }
    Object localObject2 = ((Iterable)this.WmV).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((m)((Iterator)localObject2).next()).bjv(dgY()))
      {
        AppMethodBeat.o(295530);
        return;
      }
    }
    if (this.sMP.rsE)
    {
      AppMethodBeat.o(295530);
      return;
    }
    Is(false);
    BaseWebViewController.a((BaseWebViewController)this, dgY(), null, 6);
    AppMethodBeat.o(295530);
  }
  
  protected boolean dhe()
  {
    AppMethodBeat.i(295535);
    Object localObject = ((Iterable)this.WmV).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((m)((Iterator)localObject).next()).bjw(dgY()))
      {
        AppMethodBeat.o(295535);
        return false;
      }
    }
    localObject = (CharSequence)getIntent().getStringExtra("data");
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; (i != 0) && (!this.Wwf.WxE); i = 0)
    {
      AppMethodBeat.o(295535);
      return true;
    }
    AppMethodBeat.o(295535);
    return false;
  }
  
  public void e(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(295452);
    super.e(paramWebView, paramString);
    this.WwL.cf("onPageCommit", System.currentTimeMillis());
    AppMethodBeat.o(295452);
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(295389);
    String str = this.sMP.getTitle();
    if (str == null)
    {
      str = getIntent().getStringExtra("title");
      if (str == null)
      {
        str = getIntent().getStringExtra("webpageTitle");
        if (str == null)
        {
          AppMethodBeat.o(295389);
          return "";
        }
        AppMethodBeat.o(295389);
        return str;
      }
      AppMethodBeat.o(295389);
      return str;
    }
    AppMethodBeat.o(295389);
    return str;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(295586);
    if (this.WyW == null) {
      irR();
    }
    com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.WyW;
    AppMethodBeat.o(295586);
    return localc;
  }
  
  public final void i(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(295398);
    kotlin.g.b.s.u(paramString, "url");
    Log.i(iss(), kotlin.g.b.s.X("edw onLoadResource opt, url = ", paramString));
    if (bje(paramString))
    {
      Log.f(iss(), kotlin.g.b.s.X("onLoadResource, canLoadUrl fail, url = ", paramString));
      super.i(paramWebView, paramString);
      AppMethodBeat.o(295398);
      return;
    }
    ba.f localf = this.Wye.ivF();
    if (Util.isNullOrNil(paramString)) {
      Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
    }
    for (;;)
    {
      super.i(paramWebView, paramString);
      AppMethodBeat.o(295398);
      return;
      try
      {
        if ((!Util.isNullOrNil(localf.sML)) && (!paramString.equals(localf.sML)) && (localf.WNg))
        {
          if (localf.WNe.containsKey(localf.sML))
          {
            long l1 = ((Long)localf.WNe.get(localf.sML)).longValue();
            long l2 = Util.nowMilliSecond();
            localf.WNe.put(localf.sML, Long.valueOf(l2 - l1));
          }
          localf.WNg = false;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.WebviewReporter", localException, "onLoadResource", new Object[0]);
      }
    }
  }
  
  protected final Class<? extends Service> irC()
  {
    AppMethodBeat.i(295374);
    Class localClass = (Class)this.Wyg.getValue();
    AppMethodBeat.o(295374);
    return localClass;
  }
  
  protected final Set<String> irD()
  {
    AppMethodBeat.i(295386);
    Set localSet = (Set)this.Wyn.getValue();
    AppMethodBeat.o(295386);
    return localSet;
  }
  
  protected final void irR()
  {
    AppMethodBeat.i(295589);
    if (this.WyW != null)
    {
      AppMethodBeat.o(295589);
      return;
    }
    Log.i(iss(), "WebView-Trace setWebViewPluginClient");
    this.WyW = com.tencent.luggage.xweb_ext.extendplugin.d.a((WebView)this.sMP, (com.tencent.luggage.xweb_ext.extendplugin.b.d)b.auV(), (com.tencent.luggage.xweb_ext.extendplugin.a.c)com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g.iBQ(), null);
    AppMethodBeat.o(295589);
  }
  
  public final boolean irS()
  {
    AppMethodBeat.i(295495);
    Log.i(iss(), "edw onServiceDisconnected");
    Iterator localIterator = ((Iterable)this.WmV).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((m)localIterator.next()).isM());
    for (int i = 1; i == 0; i = 0)
    {
      Log.i(iss(), "maybe mm process crash, try rebind service");
      AppMethodBeat.o(295495);
      return true;
    }
    boolean bool = super.irS();
    AppMethodBeat.o(295495);
    return bool;
  }
  
  public final void irT()
  {
    AppMethodBeat.i(295379);
    super.irT();
    Object localObject = ((Iterable)this.WmV).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((m)((Iterator)localObject).next()).isK())
      {
        AppMethodBeat.o(295379);
        return;
      }
    }
    isv().context = this.sMP.getActivityContextIfHas();
    localObject = this.sMP.getActivityContextIfHas();
    if ((localObject instanceof Activity)) {}
    for (localObject = (Activity)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getIntent();
        kotlin.g.b.s.s(localObject, "it.intent");
        setIntent((Intent)localObject);
      }
      AppMethodBeat.o(295379);
      return;
    }
  }
  
  protected final void irZ()
  {
    AppMethodBeat.i(295485);
    super.irZ();
    com.tencent.mm.plugin.webview.h.h.iwI();
    Iterator localIterator = ((Iterable)this.WwO).iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).a(this.WwL);
    }
    this.WwL.a(this.sMP, (kotlin.g.a.a)new z(this));
    AppMethodBeat.o(295485);
  }
  
  public final void isA()
  {
    AppMethodBeat.i(295579);
    y localy = this.WyE;
    localy.Wzs = true;
    CharSequence localCharSequence = (CharSequence)localy.Wzt;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localy.hO(localy.Wzt, 3);
      }
      AppMethodBeat.o(295579);
      return;
    }
  }
  
  public final boolean isB()
  {
    AppMethodBeat.i(295596);
    if (!this.WwE)
    {
      AppMethodBeat.o(295596);
      return false;
    }
    isC();
    AppMethodBeat.o(295596);
    return true;
  }
  
  public final void isC()
  {
    AppMethodBeat.i(295602);
    boolean bool = com.tencent.mm.plugin.webview.modeltools.l.a(getJsapi(), this.sMP);
    Object localObject = this.Wyj;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject).onDestroy();
    }
    localObject = this.Wyh;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.o)localObject).onDestroy();
    }
    onDestroy();
    this.sMP.removeJavascriptInterface("MicroMsg");
    this.sMP.removeJavascriptInterface("JsApi");
    this.sMP.removeJavascriptInterface("__wx");
    this.sMP.removeJavascriptInterface("CustomFullscreenApi");
    this.sMP.removeJavascriptInterface("__wxtag");
    try
    {
      this.sMP.setWebChromeClient(null);
      this.sMP.setWebViewClient(null);
      this.sMP.setOnTouchListener(null);
      this.sMP.setOnLongClickListener(null);
      this.sMP.setVisibility(8);
      this.sMP.removeAllViews();
      this.sMP.clearView();
      if (!bool) {
        this.sMP.destroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(iss(), "releaseWebView, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    this.Wyj = null;
    this.Wyh = null;
    this.Wyi = null;
    this.Wym = null;
    AppMethodBeat.o(295602);
  }
  
  public final com.tencent.mm.plugin.webview.e.c isD()
  {
    AppMethodBeat.i(295605);
    com.tencent.mm.plugin.webview.e.c localc = irI();
    AppMethodBeat.o(295605);
    return localc;
  }
  
  protected final void isa()
  {
    AppMethodBeat.i(295593);
    Log.d(iss(), "setGetA8KeyParams");
    Object localObject3 = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_req");
    Object localObject4 = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_resp");
    Object localObject1;
    if ((localObject3 != null) && (localObject4 != null))
    {
      Log.i(iss(), "set outer get A8key result");
      localObject1 = irI();
      if ((localObject3 != null) && (localObject4 != null)) {
        break label341;
      }
    }
    for (;;)
    {
      localObject3 = getIntent().getStringExtra("geta8key_username");
      Object localObject2 = getIntent().getStringExtra("msgUsername");
      localObject4 = getIntent().getStringExtra("serverMsgID");
      Object localObject5 = irI();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((com.tencent.mm.plugin.webview.e.c)localObject5).WOZ = ((String)localObject1);
      irI().WPa = ((String)localObject4);
      irI().setUsername((String)localObject3);
      irI().mScene = avS((String)localObject3);
      irI().mAppId = getIntent().getStringExtra("geta8key_open_webview_appid");
      localObject1 = this.sMP;
      if (localObject1 == null)
      {
        localObject1 = null;
        label191:
        if (!((Boolean)localObject1).booleanValue()) {
          break label445;
        }
        irI().MEW = 1;
        irI().JZn = getIntent().getByteArrayExtra("geta8key_cookie");
        irI().WOU = getIntent().getIntExtra("key_wallet_region", 0);
        localObject3 = irI();
        localObject2 = getIntent().getStringExtra("key_function_id");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((com.tencent.mm.plugin.webview.e.c)localObject3).KJc = ((String)localObject1);
        irI().WPe = getIntent().getIntExtra("KMsgType", 0);
        irI().OqQ = getIntent().getIntExtra("KAppMsgType", 0);
        int i = getIntent().getIntExtra("geta8key_session_id", 0);
        if (i > 0) {
          irI().WOQ = i;
        }
        AppMethodBeat.o(295593);
        return;
        label341:
        if ((localObject3.length <= 0) || (localObject4.length <= 0)) {
          continue;
        }
        localObject5 = new cde();
        localObject2 = new cdf();
      }
      try
      {
        ((cde)localObject5).parseFrom((byte[])localObject3);
        ((cdf)localObject2).parseFrom((byte[])localObject4);
        ((com.tencent.mm.plugin.webview.e.c)localObject1).WOV = ((cde)localObject5).aana.abwM;
        label397:
        if ((Util.isNullOrNil(((com.tencent.mm.plugin.webview.e.c)localObject1).WOV)) || (((cdf)localObject2).aanm == null))
        {
          Log.e("MicroMsg.LuggageGetA8Key", "ReqUrl or FullUrl is null");
          continue;
        }
        ((com.tencent.mm.plugin.webview.e.c)localObject1).WOW = ((cdf)localObject2);
        continue;
        localObject1 = Boolean.valueOf(((MMWebView)localObject1).getIsX5Kernel());
        break label191;
        label445:
        irI().MEW = 0;
      }
      catch (Exception localException)
      {
        break label397;
      }
    }
  }
  
  public final String iss()
  {
    AppMethodBeat.i(295369);
    String str = (String)this.Wyf.getValue();
    AppMethodBeat.o(295369);
    return str;
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.d isv()
  {
    AppMethodBeat.i(295402);
    com.tencent.mm.plugin.webview.ui.tools.d locald = (com.tencent.mm.plugin.webview.ui.tools.d)this.Wyt.getValue();
    AppMethodBeat.o(295402);
    return locald;
  }
  
  public final com.tencent.mm.plugin.webview.modeltools.o isw()
  {
    AppMethodBeat.i(295425);
    com.tencent.mm.plugin.webview.modeltools.o localo = (com.tencent.mm.plugin.webview.modeltools.o)this.Wyv.getValue();
    AppMethodBeat.o(295425);
    return localo;
  }
  
  public final boolean isx()
  {
    AppMethodBeat.i(295552);
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
        if (!n.bp((CharSequence)localObject)) {
          break label91;
        }
      }
      catch (Exception localException)
      {
        String str;
        AppMethodBeat.o(295552);
        return false;
      }
      if ((i == 0) && (kotlin.g.b.s.p(str, "enterpriseHomeSubBrand")))
      {
        AppMethodBeat.o(295552);
        return true;
      }
      AppMethodBeat.o(295552);
      return false;
      label86:
      int i = 1;
      continue;
      label91:
      i = 0;
    }
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(295540);
    kotlin.g.b.s.u(paramString, "url");
    com.tencent.mm.plugin.webview.model.a.c(this.sMP, paramString);
    super.loadUrl(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(295540);
  }
  
  protected final boolean m(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(295468);
    kotlin.g.b.s.u(paramWebView, "webView");
    kotlin.g.b.s.u(paramString, "url");
    Log.i(iss(), kotlin.g.b.s.X("WebView-Trace shouldOverride url = ", paramString));
    bjp(paramString);
    m.a locala = l(paramWebView, paramString);
    if (locala.Wzz)
    {
      boolean bool = locala.result;
      AppMethodBeat.o(295468);
      return bool;
    }
    if (bje(paramString))
    {
      Log.f(iss(), kotlin.g.b.s.X("shouldOverrideUrlLoading, canLoadUrl fail, url = ", paramString));
      AppMethodBeat.o(295468);
      return true;
    }
    if (com.tencent.luggage.l.c.a(paramString, "about:blank", true))
    {
      Log.e(iss(), "shouldOverride, url is about:blank");
      AppMethodBeat.o(295468);
      return true;
    }
    if (DownloadChecker.a(paramString, ist(), paramWebView))
    {
      Log.i(iss(), "use the downloader to download");
      AppMethodBeat.o(295468);
      return true;
    }
    if ((com.tencent.luggage.l.c.a(paramString, "weixinping://iframe", true)) || (com.tencent.luggage.l.c.a(paramString, "weixinpreinject://iframe", true)))
    {
      AppMethodBeat.o(295468);
      return true;
    }
    if (bjm(paramString))
    {
      Log.i(iss(), kotlin.g.b.s.X("weixin scheme url deal success, url = ", paramString));
      AppMethodBeat.o(295468);
      return true;
    }
    if (bjn(paramString))
    {
      Log.i(iss(), kotlin.g.b.s.X("custom scheme url deal success, url = ", paramString));
      AppMethodBeat.o(295468);
      return true;
    }
    if ((paramWebView instanceof MMWebView)) {}
    for (paramWebView = (MMWebView)paramWebView;; paramWebView = null)
    {
      com.tencent.mm.plugin.webview.model.a.c(paramWebView, paramString);
      AppMethodBeat.o(295468);
      return false;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(295583);
    if (atn(this.WwV)) {
      isu().x("", Util.nowSecond(), 0);
    }
    isv().detach();
    if (isx()) {}
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
      irJ().a(30, localBundle, irL());
      try
      {
        label86:
        irJ().auf(isy().irL());
        super.onDestroy();
        AppMethodBeat.o(295583);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.i(iss(), kotlin.g.b.s.X("onDestroy remove callbacker ex ", localException1.getMessage()));
        }
      }
    }
    catch (Exception localException2)
    {
      break label86;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    a(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294980);
      kotlin.g.b.s.u(paramString, "url");
      if (!this.WyX.sLD.iwp().iPO())
      {
        Log.e(k.a(this.WyX), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
        AppMethodBeat.o(294980);
        return true;
      }
      try
      {
        this.WyX.irJ().dK(paramString, this.WyX.sLD.iwo().sk(7));
        AppMethodBeat.o(294980);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(k.a(this.WyX), kotlin.g.b.s.X("ActivityJumpHandler, ex = ", paramString.getMessage()));
        }
      }
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294967);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294967);
        return false;
      }
      boolean bool = aa.M(paramString, "weixin://jump/");
      AppMethodBeat.o(294967);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class aa
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.modeltools.o>
  {
    public static final aa Wzv;
    
    static
    {
      AppMethodBeat.i(294970);
      Wzv = new aa();
      AppMethodBeat.o(294970);
    }
    
    aa()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ab
    extends kotlin.g.b.u
    implements kotlin.g.a.a<k.n>
  {
    ab(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ac
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.ui.tools.d>
  {
    ac(MMWebView paramMMWebView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ad
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Class<WebViewStubService>>
  {
    public static final ad Wzw;
    
    static
    {
      AppMethodBeat.i(294954);
      Wzw = new ad();
      AppMethodBeat.o(294954);
    }
    
    ad()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class ae
    extends kotlin.g.b.u
    implements kotlin.g.a.a<k.q>
  {
    ae(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String WyY = "weixin://addfriend/";
    
    b(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294962);
      kotlin.g.b.s.u(paramString, "url");
      if (!this.WyX.sLD.iwo().sk(5))
      {
        Log.e(k.a(this.WyX), "AddFriendHandler, permission fail");
        AppMethodBeat.o(294962);
        return true;
      }
      paramString = paramString.substring(this.WyY.length());
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294962);
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_webview", true);
      localBundle.putString("userName", paramString);
      try
      {
        this.WyX.irJ().a(8, localBundle, this.WyX.irL());
        AppMethodBeat.o(294962);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(k.a(this.WyX), kotlin.g.b.s.X("AddFriendHandler, ex = ", paramString.getMessage()));
        }
      }
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294952);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294952);
        return false;
      }
      boolean bool = aa.M(paramString, this.WyY);
      AppMethodBeat.o(294952);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String WyZ = "weixin://webview/close/";
    
    c(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294974);
      kotlin.g.b.s.u(paramString, "url");
      if (!this.WyX.sLD.iwo().sk(17))
      {
        Log.e(k.a(this.WyX), "close window permission fail");
        AppMethodBeat.o(294974);
        return true;
      }
      this.WyX.onFinish();
      AppMethodBeat.o(294974);
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294959);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294959);
        return false;
      }
      boolean bool = aa.M(paramString, this.WyZ);
      AppMethodBeat.o(294959);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wza = "weixin://critical_update/";
    
    e(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294969);
      kotlin.g.b.s.u(paramString, "url");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 25L, 1L, true);
      k.c(this.WyX, 1);
      AppMethodBeat.o(294969);
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294960);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294960);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wza);
      AppMethodBeat.o(294960);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "urlOrig", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    f(k paramk, MMWebView paramMMWebView) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294984);
      kotlin.g.b.s.u(paramString, "urlOrig");
      int i = this.WyX.avS(Util.nullAsNil(k.g(this.WyX)));
      Object localObject = com.tencent.mm.pluginsdk.g.boS(paramString);
      if (com.tencent.mm.pluginsdk.g.ce((String)localObject, k.h(this.WyX))) {}
      for (;;)
      {
        try
        {
          if (kotlin.g.b.s.p("weixin://dl/shopping", localObject))
          {
            paramString = this.WyX.irJ().iwY();
            kotlin.g.b.s.s(paramString, "invoker.getJDUrl()");
            if (!Util.isNullOrNil(paramString)) {
              BaseWebViewController.a((BaseWebViewController)this.WyX, paramString, null, 6);
            }
            paramString = (List)new ArrayList();
            kotlin.g.b.s.s(localObject, "url");
            paramString.add(localObject);
            paramString.add("1");
            paramString.add(String.valueOf(i));
            localObject = Util.nullAsNil(k.g(this.WyX));
            kotlin.g.b.s.s(localObject, "nullAsNil(sentUsername)");
            paramString.add(localObject);
            localObject = Util.nullAsNil(this.WyX.dgY());
            kotlin.g.b.s.s(localObject, "nullAsNil(rawUrl)");
            paramString.add(localObject);
            localObject = com.tencent.mm.plugin.report.service.h.OAn;
            com.tencent.mm.plugin.report.service.h.P(11405, paramString);
            bool = true;
            AppMethodBeat.o(294984);
            return bool;
          }
          if (kotlin.g.b.s.p("weixin://dl/faq", localObject))
          {
            int j = this.WyX.irJ().ixa();
            int k = this.WyX.irJ().ixb();
            paramString = MMApplicationContext.getContext().getString(c.i.settings_system_notice_url, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            kotlin.g.b.s.s(paramString, "getContext().getString(R…otice_url, uin, newCount)");
            BaseWebViewController.a((BaseWebViewController)this.WyX, paramString, null, 6);
            continue;
          }
        }
        catch (Exception paramString)
        {
          Log.e(k.a(this.WyX), "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          bool = true;
          continue;
          if (kotlin.g.b.s.p("weixin://dl/posts", localObject))
          {
            this.WyX.irJ().ixc();
            continue;
          }
          if (kotlin.g.b.s.p("weixin://dl/moments", localObject))
          {
            this.WyX.irJ().ixd();
            continue;
          }
          kotlin.g.b.s.s(localObject, "url");
          if (n.U((String)localObject, "weixin://dl/feedback", false))
          {
            kotlin.g.b.s.s(this.WyX.irJ().blw((String)localObject), "invoker.getFeedbackUrl(url)");
            continue;
          }
          if (kotlin.g.b.s.p("weixin://dl/scan", localObject))
          {
            com.tencent.mm.br.c.c(this.WyX.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.g.cB(paramMMWebView.getActivityContextIfHas(), (String)localObject);
          continue;
        }
        boolean bool = false;
      }
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294972);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294972);
        return false;
      }
      boolean bool = aa.M(paramString, "weixin://");
      AppMethodBeat.o(294972);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wzb = "weixin://feedback/";
    
    g(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294966);
      kotlin.g.b.s.u(paramString, "url");
      paramString = new Bundle();
      paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
      paramString.putInt("MMActivity.OverrideExitAnimation", c.a.push_down_out);
      try
      {
        this.WyX.irJ().a(7, paramString, this.WyX.irL());
        AppMethodBeat.o(294966);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(k.a(this.WyX), kotlin.g.b.s.X("FeedbackJumpHandler, ex = ", paramString.getMessage()));
        }
      }
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294956);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294956);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzb);
      AppMethodBeat.o(294956);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wzc = "weixin://connectToFreeWifi/";
    
    h(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294973);
      kotlin.g.b.s.u(paramString, "url");
      Log.w(k.a(this.WyX), "freewifi had Deprecated");
      AppMethodBeat.o(294973);
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294965);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294965);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzc);
      AppMethodBeat.o(294965);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wzd = "weixin://gethtml/";
    
    i(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294992);
      kotlin.g.b.s.u(paramString, "url");
      if (!Util.isNullOrNil(paramString))
      {
        paramString = paramString.substring(this.Wzd.length());
        kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
        Log.i(k.a(this.WyX), kotlin.g.b.s.X("[oneliang]get html content :", paramString));
        Object localObject = this.WyX;
        kotlin.g.b.s.u(paramString, "html");
        localObject = ((Iterable)((BaseWebViewController)localObject).WwO).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((l)((Iterator)localObject).next()).bju(paramString);
        }
      }
      AppMethodBeat.o(294992);
      return false;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294985);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294985);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzd);
      AppMethodBeat.o(294985);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wze = "weixin://profile/";
    
    j(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294994);
      kotlin.g.b.s.u(paramString, "url");
      paramString = paramString.substring(this.Wze.length());
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(k.a(this.WyX), "handleUrl fail, username is null");
        AppMethodBeat.o(294994);
        return true;
      }
      if (this.WyX.sLD.iwo().sk(2)) {
        this.WyX.getJsapi().bjK(paramString);
      }
      AppMethodBeat.o(294994);
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294988);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294988);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wze);
      AppMethodBeat.o(294988);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wzf = "weixin://manual_update/";
    
    k(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294983);
      kotlin.g.b.s.u(paramString, "url");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 26L, 1L, true);
      k.c(this.WyX, 3);
      AppMethodBeat.o(294983);
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294979);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294979);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzf);
      AppMethodBeat.o(294979);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wzg = "weixin://recommend_update/";
    
    l(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294989);
      kotlin.g.b.s.u(paramString, "url");
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 24L, 1L, true);
      k.c(this.WyX, 2);
      AppMethodBeat.o(294989);
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294981);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294981);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzg);
      AppMethodBeat.o(294981);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wzh = "weixin://openapi/openwebview/result?";
    
    m(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294996);
      kotlin.g.b.s.u(paramString, "url");
      Object localObject = new OpenWebview.Resp();
      paramString = Uri.parse(paramString);
      ((OpenWebview.Resp)localObject).result = paramString.getQuery();
      ((OpenWebview.Resp)localObject).errCode = Util.getInt(paramString.getQueryParameter("errCode"), 0);
      ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
      ((OpenWebview.Resp)localObject).transaction = this.WyX.getIntent().getStringExtra("transaction_for_openapi_openwebview");
      paramString = paramString.getQueryParameter("appid");
      if (Util.isNullOrNil(paramString))
      {
        Log.e(k.a(this.WyX), "SDKOpenWebViewResultHandler handleUrl, appId is null");
        AppMethodBeat.o(294996);
        return true;
      }
      Bundle localBundle = new Bundle();
      ((OpenWebview.Resp)localObject).toBundle(localBundle);
      com.tencent.mm.pluginsdk.model.app.u.bS(localBundle);
      localObject = new MMessageActV2.Args();
      try
      {
        ((MMessageActV2.Args)localObject).targetPkgName = this.WyX.irJ().blp(paramString);
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        Log.d(k.a(this.WyX), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
        MMessageActV2.send(this.WyX.getContext(), (MMessageActV2.Args)localObject);
        this.WyX.onFinish();
        AppMethodBeat.o(294996);
        return true;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(k.a(this.WyX), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(294996);
      }
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294986);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294986);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzh);
      AppMethodBeat.o(294986);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class n
    extends com.tencent.mm.plugin.webview.ui.tools.widget.p
  {
    private final String TAG;
    private final kotlin.j WwH;
    private final WeakReference<k> Wzi;
    
    public n(WeakReference<k> paramWeakReference)
    {
      AppMethodBeat.i(294879);
      this.Wzi = paramWeakReference;
      this.WwH = kotlin.k.cm((kotlin.g.a.a)new a(this));
      this.TAG = kotlin.g.b.s.X("MicroMsg.WebViewController.SceneEndCallbacker:", Integer.valueOf(irL()));
      AppMethodBeat.o(294879);
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      AppMethodBeat.i(294896);
      Log.i(this.TAG, kotlin.g.b.s.X("onSceneEnd, instance hashcode = ", Integer.valueOf(hashCode())));
      k localk;
      if (paramd != null)
      {
        int i = paramd.fqx().getInt("scene_end_listener_hash_code");
        Log.i(this.TAG, "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(irL()) });
        Log.i(this.TAG, "edw onSceneEnd, type = " + paramd.getType() + ", errCode = " + paramd.getErrCode() + ", errType = " + paramd.getErrType());
        if (i != irL())
        {
          Log.e(this.TAG, "hash code not equal");
          AppMethodBeat.o(294896);
          return false;
        }
        localk = (k)this.Wzi.get();
        if (localk != null) {
          switch (paramd.getType())
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(294896);
        return true;
        k.b(localk, 106);
        localk.onFinish();
        continue;
        k.b(localk, 666);
        localk.onFinish();
      }
    }
    
    public final int irL()
    {
      AppMethodBeat.i(294885);
      int i = ((Number)this.WwH.getValue()).intValue();
      AppMethodBeat.o(294885);
      return i;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<Integer>
    {
      a(k.n paramn)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    final String Wzd = "weixin://private/gethtml/";
    
    o(k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294892);
      kotlin.g.b.s.u(paramString, "url");
      paramString = paramString.substring(this.Wzd.length());
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      try
      {
        paramString = URLDecoder.decode(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("nowUrl", k.d(this.WyX));
        localBundle.putString("tweetid", Util.nullAsNil(this.WyX.getIntent().getStringExtra("tweetid")));
        localBundle.putString("htmlData", paramString);
        localBundle.putInt("type", this.WyX.getIntent().getIntExtra("type", 0));
        this.WyX.irJ().a(3, localBundle, this.WyX.irL());
        AppMethodBeat.o(294892);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e(k.a(this.WyX), kotlin.g.b.s.X("edw ViewImageGetHtmlHandler handleUrl, ex = ", paramString.getMessage()));
        AppMethodBeat.o(294892);
      }
      return false;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294884);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294884);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzd);
      AppMethodBeat.o(294884);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    private final String Wzk = "weixin://viewimage/";
    
    p(k paramk, MMWebView paramMMWebView) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294888);
      kotlin.g.b.s.u(paramString, "url");
      try
      {
        if (!this.WyX.irJ().isSDCardAvailable())
        {
          this.WyX.irJ().a(2, null, this.WyX.irL());
          AppMethodBeat.o(294888);
          return true;
        }
      }
      catch (Exception paramString)
      {
        Log.e(k.a(this.WyX), kotlin.g.b.s.X("edw handleUrl, ex = ", paramString.getMessage()));
        AppMethodBeat.o(294888);
        return false;
      }
      k localk = this.WyX;
      paramString = paramString.substring(this.Wzk.length());
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      k.b(localk, paramString);
      Log.i(k.a(this.WyX), kotlin.g.b.s.X("viewimage currentUrl :", k.d(this.WyX)));
      aa.a((WebView)paramMMWebView, k.e(this.WyX).Wzd, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", k.f(this.WyX));
      AppMethodBeat.o(294888);
      return true;
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294875);
      kotlin.g.b.s.u(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(294875);
        return false;
      }
      boolean bool = aa.M(paramString, this.Wzk);
      AppMethodBeat.o(294875);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class q
  {
    private volatile String BoZ;
    private final k Wzl;
    private volatile String Wzm;
    private int fromScene;
    private int networkType;
    private long sXL;
    private String userAgent;
    
    public q()
    {
      AppMethodBeat.i(294877);
      this.Wzl = localObject;
      this$1 = this.Wzl.sMP.getSettings().getUserAgentString();
      kotlin.g.b.s.s(k.this, "controller.viewWV.settings.userAgentString");
      this.userAgent = k.this;
      this.fromScene = this.Wzl.getIntent().getIntExtra("from_scence", 0);
      this.Wzm = "";
      this.BoZ = "";
      AppMethodBeat.o(294877);
    }
    
    private void isE()
    {
      AppMethodBeat.i(294886);
      Context localContext = MMApplicationContext.getContext();
      int i;
      if (NetStatusUtil.isConnected(localContext))
      {
        if (!NetStatusUtil.isWifi(localContext)) {
          break label58;
        }
        i = 1;
      }
      for (;;)
      {
        this.networkType = i;
        Log.i(k.a(k.this), kotlin.g.b.s.X("get networkType ", Integer.valueOf(this.networkType)));
        AppMethodBeat.o(294886);
        return;
        label58:
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
    
    public final void x(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(294899);
      kotlin.g.b.s.u(paramString, "targetUrl");
      isE();
      String str5 = this.Wzl.bjg(this.BoZ);
      if (this.fromScene != 0) {
        this.Wzm = " ";
      }
      boolean bool = this.Wzl.sLD.iwp().iPQ();
      Log.d(k.a(k.this), "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.sXL > 0L) && (k.b(k.this) > this.sXL) && (paramLong > k.b(k.this)) && (!TextUtils.isEmpty((CharSequence)str5)) && (bool))
      {
        l1 = k.b(k.this) - this.sXL;
        l2 = paramLong - k.b(k.this);
        Log.d(k.a(k.this), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.sXL), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.userAgent, this.BoZ, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.Wzm });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(this.userAgent), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(this.BoZ), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str4 = com.tencent.mm.compatible.util.r.as(Util.nullAsNil(this.Wzm), "UTF-8");
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
          Log.printErrStackTrace(k.a(k.this), (Throwable)localUnsupportedEncodingException, "", new Object[0]);
          String str2 = "";
          localObject4 = localObject1;
        }
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(13376, new Object[] { Long.valueOf(this.sXL), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.Wzm = this.BoZ;
        this.BoZ = paramString;
        this.sXL = paramLong;
      }
      AppMethodBeat.o(294899);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(k.q paramq, String paramString, long paramLong) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(295065);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.Wzn.x(this.Wzo, this.Wzp, this.Wzq);
        AppMethodBeat.o(295065);
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<String>
  {
    r(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewControllerOnSceneEndDelegate;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "weakController", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Ljava/lang/ref/WeakReference;)V", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements ag.a
  {
    private final WeakReference<k> Wxz;
    private final Map<Integer, Integer> Wzr;
    
    public s(WeakReference<k> paramWeakReference)
    {
      AppMethodBeat.i(294913);
      this.Wxz = paramWeakReference;
      this.Wzr = ((Map)new HashMap());
      AppMethodBeat.o(294913);
    }
    
    public final void gaS()
    {
      AppMethodBeat.i(294919);
      Object localObject = (k)this.Wxz.get();
      if (localObject != null) {
        k.b((k)localObject, 1373);
      }
      if (this.Wzr.containsKey(Integer.valueOf(1373)))
      {
        localObject = this.Wzr.get(Integer.valueOf(1373));
        kotlin.g.b.s.checkNotNull(localObject);
        int i = ((Number)localObject).intValue();
        this.Wzr.put(Integer.valueOf(1373), Integer.valueOf(i - 1));
        AppMethodBeat.o(294919);
        return;
      }
      this.Wzr.put(Integer.valueOf(1373), Integer.valueOf(0));
      AppMethodBeat.o(294919);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/core/WebViewController$WebViewUIDelegateImpl;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "weakController", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Ljava/lang/ref/WeakReference;)V", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "onEnterSnapshotOauthPage", "pageUrl", "wording", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "shouldEnterSnapshotOauth", "", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    implements ag.c
  {
    private w RSB;
    private final WeakReference<k> Wxz;
    
    public t(WeakReference<k> paramWeakReference)
    {
      AppMethodBeat.i(294894);
      this.Wxz = paramWeakReference;
      AppMethodBeat.o(294894);
    }
    
    private static void d(Dialog paramDialog)
    {
      AppMethodBeat.i(294900);
      if ((paramDialog != null) && (paramDialog.isShowing())) {
        paramDialog.dismiss();
      }
      if (paramDialog != null) {
        paramDialog.setCancelMessage(null);
      }
      if (paramDialog != null) {
        paramDialog.setDismissMessage(null);
      }
      AppMethodBeat.o(294900);
    }
    
    public final void bjr(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(294909);
      kotlin.g.b.s.u(paramString, "url");
      k localk = (k)this.Wxz.get();
      if (localk == null)
      {
        AppMethodBeat.o(294909);
        return;
      }
      localk.m(paramString, true, 9);
      paramString = localk.Wym;
      if ((paramString != null) && (paramString.iwN() == true)) {}
      for (;;)
      {
        if (i != 0)
        {
          paramString = localk.Wym;
          if (paramString != null) {
            paramString.iwM();
          }
        }
        AppMethodBeat.o(294909);
        return;
        i = 0;
      }
    }
    
    public final void d(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(294922);
      kotlin.g.b.s.u(paramOnCancelListener, "cancelListener");
      k localk = (k)this.Wxz.get();
      if (localk == null)
      {
        AppMethodBeat.o(294922);
        return;
      }
      d((Dialog)this.RSB);
      this.RSB = com.tencent.mm.ui.base.k.a(localk.sMP.getActivityContextIfHas(), localk.getContext().getString(c.i.oauth_logining), true, paramOnCancelListener);
      AppMethodBeat.o(294922);
    }
    
    public final void dismissLoadingDialog()
    {
      AppMethodBeat.i(294930);
      d((Dialog)this.RSB);
      this.RSB = null;
      AppMethodBeat.o(294930);
    }
    
    public final void goBack()
    {
      AppMethodBeat.i(294914);
      Object localObject = (k)this.Wxz.get();
      if (localObject == null)
      {
        AppMethodBeat.o(294914);
        return;
      }
      localObject = ((Iterable)((BaseWebViewController)localObject).WwO).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((l)((Iterator)localObject).next()).isH();
      }
      AppMethodBeat.o(294914);
    }
    
    public final boolean isF()
    {
      AppMethodBeat.i(294935);
      Object localObject = (k)this.Wxz.get();
      if (localObject == null)
      {
        AppMethodBeat.o(294935);
        return false;
      }
      localObject = ((k)localObject).Wym;
      if ((localObject != null) && (((com.tencent.mm.plugin.webview.j.a)localObject).iwL() == true))
      {
        AppMethodBeat.o(294935);
        return true;
      }
      AppMethodBeat.o(294935);
      return false;
    }
    
    public final void nZ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(294940);
      kotlin.g.b.s.u(paramString1, "pageUrl");
      Object localObject = (k)this.Wxz.get();
      if (localObject == null)
      {
        AppMethodBeat.o(294940);
        return;
      }
      localObject = ((k)localObject).Wym;
      if (localObject != null) {
        ((com.tencent.mm.plugin.webview.j.a)localObject).ot(paramString1, paramString2);
      }
      AppMethodBeat.o(294940);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashSet;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends kotlin.g.b.u
    implements kotlin.g.a.a<HashSet<String>>
  {
    u(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    v(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class w
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    w(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class x
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    x(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/core/WebViewController$oauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "hasTouch", "", "getHasTouch", "()Z", "setHasTouch", "(Z)V", "oauthUrl", "", "getOauthUrl", "()Ljava/lang/String;", "setOauthUrl", "(Ljava/lang/String;)V", "canHandleUrl", "url", "handleUrl", "autoAuth", "", "reOauth", "", "shouldNativeOauthIntercept", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class y
    implements com.tencent.mm.plugin.webview.jsapi.d.a
  {
    boolean Wzs;
    String Wzt = "";
    
    y(BaseWebViewController.d paramd, k paramk) {}
    
    public final boolean bjo(String paramString)
    {
      AppMethodBeat.i(294961);
      kotlin.g.b.s.u(paramString, "url");
      if ((this.Wzs) || (!jdField_this.WyA.isF())) {}
      for (int i = 0;; i = 1)
      {
        boolean bool = hO(paramString, i);
        AppMethodBeat.o(294961);
        return bool;
      }
    }
    
    public final boolean bjq(String paramString)
    {
      AppMethodBeat.i(294945);
      kotlin.g.b.s.u(paramString, "url");
      if ((!this.Wzu.WxG) && (bjs(paramString)))
      {
        AppMethodBeat.o(294945);
        return true;
      }
      AppMethodBeat.o(294945);
      return false;
    }
    
    public final boolean bjs(String paramString)
    {
      AppMethodBeat.i(294950);
      kotlin.g.b.s.u(paramString, "url");
      boolean bool = ag.b.hZ(paramString, jdField_this.getIntent().getIntExtra("geta8key_scene", 0));
      AppMethodBeat.o(294950);
      return bool;
    }
    
    public final boolean hO(String paramString, int paramInt)
    {
      AppMethodBeat.i(294976);
      kotlin.g.b.s.u(paramString, "url");
      String str = jdField_this.getIntent().getStringExtra("geta8key_username");
      int i = jdField_this.avS(str);
      if (!this.Wzs) {
        this.Wzt = paramString;
      }
      boolean bool = ag.b.a(paramString, str, i, jdField_this.irJ(), jdField_this.WyA, (ag.a)jdField_this.WyB, k.c(jdField_this).irL(), jdField_this.getContext(), paramInt, jdField_this.Wwp);
      AppMethodBeat.o(294976);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class z
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    z(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.k
 * JD-Core Version:    0.7.0.1
 */