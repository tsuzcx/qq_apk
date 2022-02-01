package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
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
import com.tencent.mm.plugin.webview.k.j.b;
import com.tencent.mm.plugin.webview.model.ag.a;
import com.tencent.mm.plugin.webview.model.ag.b;
import com.tencent.mm.plugin.webview.model.ag.c;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.au;
import com.tencent.mm.plugin.webview.model.av;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.model.az.b;
import com.tencent.mm.plugin.webview.model.az.c;
import com.tencent.mm.plugin.webview.model.az.e;
import com.tencent.mm.plugin.webview.model.az.f;
import com.tencent.mm.plugin.webview.model.az.j;
import com.tencent.mm.plugin.webview.model.az.k;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.f.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
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
import kotlin.s;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "OauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1;", "ReaderShareHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;)V", "pageEndTime", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "kotlin.jvm.PlatformType", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "webViewFloatBallInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "getWebViewFloatBallInfo", "()Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "webViewMenuHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "getWebViewMenuHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "setWebViewMenuHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;)V", "webViewUIProxyImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "getWebViewUIProxyImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "setWebViewUIProxyImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;)V", "webViewUIStyleHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "getWebViewUIStyleHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "setWebViewUIStyleHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;)V", "getWebviewReportMgr", "()Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "", "", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getCachedAppId", "getScene", "username", "getWebViewPluginClientProxy", "handleUrl", "initEnviroment", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "loadUrl", "httpHeaders", "withoutCache", "needSyncGetA8Key", "onBinded", "onDestroy", "onFloatBallDestroy", "onJsReady", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "overrideProcessResult", "resp", "overrideUrl", "webView", "releaseWebView", "removeSceneEnd", "requestSetFontSize", "fontSize", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "Companion", "SceneEndCallbacker", "VisitInfoReport", "plugin-webview_release"})
public class i
  extends BaseWebViewController
{
  public static final d IMt;
  private final kotlin.f ILC;
  public com.tencent.mm.plugin.webview.ui.tools.j ILD;
  public com.tencent.mm.plugin.webview.ui.tools.o ILE;
  public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h ILF;
  public final com.tencent.mm.plugin.webview.ui.tools.floatball.c ILG;
  private final kotlin.f ILH;
  private final kotlin.f ILI;
  private final kotlin.f ILJ;
  private final kotlin.f ILK;
  public final ar ILL;
  private final kotlin.f ILM;
  private final kotlin.f ILN;
  public String ILO;
  private final kotlin.f ILP;
  private final String ILQ;
  private final Set<String> ILR;
  private final kotlin.f ILS;
  private com.tencent.mm.ui.base.q ILT;
  private final ag.c ILU;
  ag.a ILV;
  private long ILW;
  private final List<com.tencent.mm.plugin.webview.d.d.a> ILX;
  private final l ILY;
  private final j ILZ;
  private final e IMa;
  private final k IMb;
  private final n IMc;
  private final a IMd;
  private String IMe;
  private final boolean IMf;
  private final s IMg;
  private final i IMh;
  private final r IMi;
  private final m IMj;
  private final g IMk;
  private final b IMl;
  private final o IMm;
  private final c IMn;
  private long IMo;
  private final f IMp;
  private final h IMq;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c IMr;
  public final az IMs;
  private final kotlin.f pFA;
  
  static
  {
    AppMethodBeat.i(210280);
    IMt = new d((byte)0);
    AppMethodBeat.o(210280);
  }
  
  public i(MMWebView paramMMWebView, az paramaz, BaseWebViewController.c paramc, byte paramByte)
  {
    this(paramMMWebView, paramaz, paramc);
    AppMethodBeat.i(210278);
    AppMethodBeat.o(210278);
  }
  
  public i(final MMWebView paramMMWebView, az paramaz, BaseWebViewController.c paramc, Set<String> paramSet, com.tencent.mm.plugin.webview.d.e parame)
  {
    super(paramMMWebView, paramc, paramSet, parame);
    AppMethodBeat.i(210277);
    this.IMs = paramaz;
    this.pFA = kotlin.g.ah((kotlin.g.a.a)new q(this));
    this.ILC = kotlin.g.ah((kotlin.g.a.a)aj.IMX);
    this.ILG = new com.tencent.mm.plugin.webview.ui.tools.floatball.c();
    this.ILH = kotlin.g.ah((kotlin.g.a.a)new v(this));
    this.ILI = kotlin.g.ah((kotlin.g.a.a)new x(this));
    this.ILJ = kotlin.g.ah((kotlin.g.a.a)new w(this));
    this.ILK = kotlin.g.ah((kotlin.g.a.a)new ak(this));
    this.ILL = new ar(getContext());
    this.ILM = kotlin.g.ah((kotlin.g.a.a)new y(this));
    this.ILN = kotlin.g.ah((kotlin.g.a.a)new ai(paramMMWebView));
    this.ILP = kotlin.g.ah((kotlin.g.a.a)ag.IMW);
    this.ILQ = "file:///android_asset/jsapi/wxjs.js";
    this.ILR = ((Set)new HashSet());
    this.ILS = kotlin.g.ah((kotlin.g.a.a)new ah(this));
    this.ILU = ((ag.c)new z(this, paramMMWebView));
    this.ILV = ((ag.a)new aa(this));
    this.ILX = ((List)new ArrayList());
    this.ILY = new l(this);
    this.ILZ = new j(this);
    this.IMa = new e(this);
    this.IMb = new k(this);
    this.IMc = new n(this);
    this.IMd = new a(this);
    this.IMf = true;
    this.IMg = new s(this, paramMMWebView);
    this.IMh = new i(this);
    this.IMi = new r(this);
    this.IMj = new m(this, paramMMWebView);
    this.IMk = new g(this);
    this.IMl = new b(this);
    this.IMm = new o(this);
    this.IMn = new c(this);
    this.IMp = new f(this, paramMMWebView);
    this.IMq = new h(this);
    AppMethodBeat.o(210277);
  }
  
  private final boolean aXG(String paramString)
  {
    AppMethodBeat.i(210266);
    if (Util.isNullOrNil(paramString))
    {
      Log.e(getTAG(), "search contact err: null or nill url");
      AppMethodBeat.o(210266);
      return false;
    }
    fZX();
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", fZW().fZu());
    try
    {
      fZs().x(106, localBundle);
      AppMethodBeat.o(210266);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  private final boolean aXH(String paramString)
  {
    AppMethodBeat.i(210267);
    Log.i(getTAG(), "dealCustomScheme, url = ".concat(String.valueOf(paramString)));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(210267);
      return false;
    }
    try
    {
      if (fZs().gw(paramString))
      {
        Log.i(getTAG(), "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(paramString)));
        fZs().gt(paramString, fZu());
        AppMethodBeat.o(210267);
        return true;
      }
    }
    catch (Exception localException1)
    {
      Log.w(getTAG(), "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      Object localObject5 = Uri.parse(paramString);
      label436:
      label460:
      label474:
      label611:
      label616:
      Object localObject2;
      if ((localObject5 != null) && (!kotlin.n.n.J(paramString, "weixin://", false)) && (!kotlin.n.n.J(paramString, "http", false)))
      {
        if (kotlin.n.n.J(paramString, "tel:", false))
        {
          paramString = kotlin.n.n.j(paramString, "tel:", "", false);
          if (!Util.isNullOrNil(paramString)) {}
          try
          {
            fZs().gv(paramString, fZu());
            AppMethodBeat.o(210267);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Log.w(getTAG(), "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
            }
          }
        }
        Object localObject1;
        Object localObject4;
        Object localObject3;
        if ((kotlin.n.n.J(paramString, "sms:", false)) || (kotlin.n.n.J(paramString, "smsto:", false)))
        {
          if (this.pGj.getActivityContextIfHas() == null)
          {
            Log.e(getTAG(), "sms, viewWV.activityContextIfHas = null");
            AppMethodBeat.o(210267);
            return true;
          }
          localObject1 = com.tencent.mm.plugin.webview.ui.tools.f.Jfx;
          localObject4 = this.pGj.getActivityContextIfHas();
          kotlin.g.b.p.g(localObject4, "viewWV.activityContextIfHas");
          kotlin.g.b.p.h(localObject4, "context");
          kotlin.g.b.p.h(paramString, "url");
          kotlin.g.b.p.h(localObject4, "context");
          kotlin.g.b.p.h(paramString, "url");
          localObject3 = new kotlin.n.k("sms:(\\d*)(\\?body=(.*))?").aK((CharSequence)paramString);
          if (localObject3 != null)
          {
            localObject1 = ((kotlin.n.i)localObject3).hMi();
            if (localObject1 != null)
            {
              localObject1 = (String)kotlin.a.j.L((List)localObject1, 1);
              if (localObject3 == null) {
                break label514;
              }
              localObject3 = ((kotlin.n.i)localObject3).hMi();
              if (localObject3 == null) {
                break label514;
              }
              localObject3 = (String)kotlin.a.j.L((List)localObject3, 3);
              localObject5 = (CharSequence)localObject1;
              if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
                break label520;
              }
              i = 1;
              if (i == 0) {
                break label525;
              }
              localObject1 = ((Context)localObject4).getString(2131766962);
              if (Util.isNullOrNil((String)localObject1)) {
                break label720;
              }
              com.tencent.mm.ac.d.h((kotlin.g.a.a)new f.a.a((Context)localObject4, (String)localObject1, paramString));
            }
          }
          for (;;)
          {
            AppMethodBeat.o(210267);
            return true;
            localObject1 = null;
            break;
            label514:
            localObject3 = null;
            break label436;
            label520:
            i = 0;
            break label460;
            label525:
            localObject5 = (CharSequence)localObject1;
            if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
            {
              i = 1;
              label549:
              if (i != 0) {
                break label616;
              }
              localObject5 = (CharSequence)localObject3;
              if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
                break label611;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label616;
              }
              localObject1 = Util.safeFormatString(((Context)localObject4).getString(2131766963), new Object[] { localObject1 });
              break;
              i = 0;
              break label549;
            }
            localObject5 = (CharSequence)localObject1;
            if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0))
            {
              i = 1;
              label640:
              if (i != 0) {
                break label712;
              }
              localObject5 = (CharSequence)localObject3;
              if ((localObject5 != null) && (((CharSequence)localObject5).length() != 0)) {
                break label707;
              }
            }
            label707:
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label712;
              }
              localObject1 = Util.safeFormatString(((Context)localObject4).getString(2131766964), new Object[] { localObject3, localObject1 });
              break;
              i = 0;
              break label640;
            }
            label712:
            localObject1 = "";
            break label474;
            label720:
            Log.e(com.tencent.mm.plugin.webview.ui.tools.f.access$getTAG$cp(), "sms, url is illegal, url = %s", new Object[] { paramString });
          }
        }
        if (kotlin.n.n.J(paramString, "mailto:", false))
        {
          paramString = new Intent("android.intent.action.SENDTO");
          paramString.addFlags(268435456);
          paramString.setData((Uri)localObject5);
          try
          {
            localObject1 = getContext();
            paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.axQ(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)paramString.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(210267);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              Log.e(getTAG(), "start mailto app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        try
        {
          if ((!this.mHi.gdI().gtB()) && (fZs().gdW()))
          {
            Log.e(getTAG(), "dealCustomScheme, not allow outer open url");
            AppMethodBeat.o(210267);
            return true;
          }
          i = getIntent().getIntExtra("key_download_restrict", 0);
          localObject1 = getIntent().getStringExtra("key_function_id");
          if (!Util.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.h.CyF.a(14596, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(1) });
          }
          if (i == 1)
          {
            Log.e(getTAG(), "not allow launch app by custom scheme : %s", new Object[] { paramString });
            AppMethodBeat.o(210267);
            return true;
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.printErrStackTrace(getTAG(), (Throwable)localRemoteException, "", new Object[0]);
          long l = Util.nowSecond() - this.ILW;
          Log.i(getTAG(), "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
          if (l <= 2L)
          {
            localObject3 = getCurrentUrl();
            localObject2 = localObject3;
          }
          try
          {
            localObject3 = com.tencent.mm.compatible.util.q.encode((String)localObject3, "UTF-8");
            localObject2 = localObject3;
            localObject4 = com.tencent.mm.compatible.util.q.encode(paramString, "UTF-8");
            paramString = (String)localObject4;
            localObject2 = localObject3;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool;
              Log.i(getTAG(), "formate url failed");
            }
            localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject5);
            ((Intent)localObject2).addFlags(268435456);
            if (!Util.isIntentAvailable(getContext(), (Intent)localObject2)) {
              break label1337;
            }
            paramString = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(210267);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(13983, new Object[] { Integer.valueOf(4), localObject2, paramString });
          if (getIntent().getBooleanExtra("show_openapp_dialog", true))
          {
            bool = com.tencent.mm.ch.a.post((Runnable)new u(this, (Uri)localObject5));
            AppMethodBeat.o(210267);
            return bool;
          }
        }
      }
      label1337:
      AppMethodBeat.o(210267);
    }
    return false;
  }
  
  private boolean aXJ(String paramString)
  {
    AppMethodBeat.i(210270);
    kotlin.g.b.p.h(paramString, "url");
    Iterator localIterator = this.ILX.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.d.d.a locala = (com.tencent.mm.plugin.webview.d.d.a)localIterator.next();
      if (locala.aXK(paramString))
      {
        Log.i(getTAG(), "url handled, url = ".concat(String.valueOf(paramString)));
        boolean bool = locala.aXJ(paramString);
        Log.i(getTAG(), "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(210270);
        return true;
      }
    }
    AppMethodBeat.o(210270);
    return false;
  }
  
  private final String fZR()
  {
    AppMethodBeat.i(210237);
    if (!afI(this.IKk))
    {
      AppMethodBeat.o(210237);
      return "";
    }
    String str = getIntent().getStringExtra("KPublisherId");
    AppMethodBeat.o(210237);
    return str;
  }
  
  private final t fZS()
  {
    AppMethodBeat.i(210238);
    t localt = (t)this.ILK.getValue();
    AppMethodBeat.o(210238);
    return localt;
  }
  
  private final com.tencent.mm.plugin.webview.ui.tools.c fZT()
  {
    AppMethodBeat.i(210241);
    com.tencent.mm.plugin.webview.ui.tools.c localc = (com.tencent.mm.plugin.webview.ui.tools.c)this.ILN.getValue();
    AppMethodBeat.o(210241);
    return localc;
  }
  
  private final com.tencent.mm.plugin.webview.modeltools.n fZU()
  {
    AppMethodBeat.i(210244);
    com.tencent.mm.plugin.webview.modeltools.n localn = (com.tencent.mm.plugin.webview.modeltools.n)this.ILP.getValue();
    AppMethodBeat.o(210244);
    return localn;
  }
  
  private final p fZW()
  {
    AppMethodBeat.i(210264);
    p localp = (p)this.ILS.getValue();
    AppMethodBeat.o(210264);
    return localp;
  }
  
  private final void fZX()
  {
    AppMethodBeat.i(210265);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 106);
      localBundle.putInt("scene_end_listener_hash_code", fZW().fZu());
      fZs().a(5, localBundle, fZW().fZu());
      AppMethodBeat.o(210265);
      return;
    }
    catch (Exception localException)
    {
      Log.e(getTAG(), "addSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(210265);
    }
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(210232);
    String str = (String)this.pFA.getValue();
    AppMethodBeat.o(210232);
    return str;
  }
  
  public final void a(com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(210255);
    String str = getTAG();
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (parame != null) {
        break;
      }
      Log.f(getTAG(), "service connect success, while invoker is null");
      onFinish();
      AppMethodBeat.o(210255);
      return;
    }
    try
    {
      parame.a((com.tencent.mm.plugin.webview.stub.f)fZW(), fZW().fZu());
      super.a(parame);
      AppMethodBeat.o(210255);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(getTAG(), "addCallback fail, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void a(WebView paramWebView, final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210243);
    if (!afI(this.IKk))
    {
      Log.i(getTAG(), "onReceivedError, intent not ready");
      AppMethodBeat.o(210243);
      return;
    }
    final String str = WeChatHosts.domainString(2131761726);
    Object localObject = ac.IMS;
    localObject = new ad(this);
    com.tencent.xweb.util.h.Eq(false);
    boolean bool = NetStatusUtil.isConnected(getContext());
    Log.e(getTAG(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(155L, com.tencent.mm.plugin.webview.i.a.agk(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 1);
    com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), com.tencent.mm.plugin.webview.i.a.agk(paramInt));
    com.tencent.mm.plugin.topstory.a.i.g(fZR(), coX(), com.tencent.mm.plugin.webview.i.a.agk(paramInt), this.IMs.gdd().enterTime);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    com.tencent.mm.plugin.webview.ui.tools.l.Jhd.agL(paramInt);
    this.IMs.gdl().errCode = paramInt;
    com.tencent.mm.plugin.webview.ui.tools.n localn = com.tencent.mm.plugin.webview.ui.tools.n.JhS;
    com.tencent.mm.plugin.webview.ui.tools.n.setErrCode(paramInt);
    if (((Boolean)this.ILJ.getValue()).booleanValue()) {
      onFinish();
    }
    try
    {
      if (kotlin.g.b.p.j(new URL(paramString2).getHost(), str)) {
        com.tencent.f.h.RTc.b((Runnable)new ae(paramString2, paramInt, (ad)localObject, str), "WebViewUI.CheckDNS");
      }
      super.a(paramWebView, paramInt, paramString1, paramString2);
      AppMethodBeat.o(210243);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Log.printErrStackTrace(getTAG(), (Throwable)localMalformedURLException, "check mp url", new Object[0]);
      }
    }
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(210242);
    if (!afI(this.IKk))
    {
      Log.i(getTAG(), "onReceivedSslError, intent not ready");
      AppMethodBeat.o(210242);
      return;
    }
    com.tencent.xweb.util.h.Eq(true);
    String str;
    if (paramWebView != null)
    {
      str = paramWebView.getUrl();
      if (str != null) {
        break label214;
      }
      str = this.IJM;
      label59:
      if (str == null) {
        break label223;
      }
      Object localObject = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
      kotlin.g.b.p.g(localObject, "MMKernel.service(IBrandService::class.java)");
      localObject = ((com.tencent.mm.plugin.brandservice.a.b)localObject).clf();
      kotlin.g.b.p.g(localObject, "MMKernel.service(IBrandS…::class.java).hardCodeUrl");
      if (!kotlin.n.n.J(str, (String)localObject, false)) {
        break label223;
      }
      str = coX();
    }
    label214:
    label223:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 1);
      com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 30);
      com.tencent.mm.plugin.topstory.a.i.g(fZR(), coX(), 30, this.IMs.gdd().enterTime);
      fZT().a(str, paramr, paramSslError);
      super.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(210242);
      return;
      str = null;
      break;
      str = paramWebView.getUrl();
      break label59;
    }
  }
  
  protected final boolean a(int paramInt, String paramString, bhj parambhj)
  {
    AppMethodBeat.i(210253);
    kotlin.g.b.p.h(paramString, "reqUrl");
    kotlin.g.b.p.h(parambhj, "resp");
    int i = parambhj.KCD;
    String str = parambhj.LRH;
    switch (i)
    {
    default: 
      boolean bool = super.a(paramInt, paramString, parambhj);
      AppMethodBeat.o(210253);
      return bool;
    case 3: 
      Log.i(getTAG(), "getA8key-app: ".concat(String.valueOf(str)));
      paramString = (CharSequence)str;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        Log.e(getTAG(), "getA8key-app, fullUrl is null");
        AppMethodBeat.o(210253);
        return false;
      }
      aXH(str);
      AppMethodBeat.o(210253);
      return true;
    case 4: 
      kotlin.g.b.p.g(str, "fullUrl");
      aXG(str);
      AppMethodBeat.o(210253);
      return true;
    }
    kotlin.g.b.p.g(str, "fullUrl");
    fZX();
    paramString = new Bundle();
    paramString.putString("emoji_store_jump_url", str);
    paramString.putInt("webview_binder_id", fZW().fZu());
    try
    {
      fZs().x(666, paramString);
      AppMethodBeat.o(210253);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  /* Error */
  public final String aXD(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1325
    //   3: invokestatic 432	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 737	java/lang/CharSequence
    //   10: invokestatic 1331	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +118 -> 131
    //   16: new 634	android/os/Bundle
    //   19: dup
    //   20: invokespecial 635	android/os/Bundle:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w 708
    //   28: aload_0
    //   29: invokevirtual 746	com/tencent/mm/plugin/webview/core/i:fZu	()I
    //   32: invokevirtual 641	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: aload_2
    //   36: ldc_w 1333
    //   39: aload_1
    //   40: invokevirtual 706	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 655	com/tencent/mm/plugin/webview/core/i:fZs	()Lcom/tencent/mm/plugin/webview/stub/e;
    //   47: bipush 76
    //   49: aload_2
    //   50: invokeinterface 1336 3 0
    //   55: ldc_w 1338
    //   58: invokevirtual 1340	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 1343	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 1345
    //   69: invokestatic 808	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokespecial 628	com/tencent/mm/plugin/webview/core/i:getTAG	()Ljava/lang/String;
    //   76: ldc_w 1347
    //   79: iconst_1
    //   80: anewarray 780	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 987	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 1325
    //   93: invokestatic 441	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: ldc_w 769
    //   102: astore_1
    //   103: aload_0
    //   104: invokespecial 628	com/tencent/mm/plugin/webview/core/i:getTAG	()Ljava/lang/String;
    //   107: ldc_w 1349
    //   110: iconst_1
    //   111: anewarray 780	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: invokevirtual 1350	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 783	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -34 -> 90
    //   127: astore_2
    //   128: goto -25 -> 103
    //   131: ldc_w 769
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
  
  public final int aXI(String paramString)
  {
    AppMethodBeat.i(210269);
    if (this.IKM.IKX != 0)
    {
      i = this.IKM.IKX;
      AppMethodBeat.o(210269);
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
        bool = afI(this.IKj);
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        label123:
        Log.e(getTAG(), "getScene fail, ex = " + paramString.getMessage());
        i = 1;
        continue;
        i = 1;
        continue;
      }
      Log.i(getTAG(), "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(210269);
      return i;
      i = 0;
      break;
      if (fZs().JE(paramString))
      {
        i = 8;
      }
      else
      {
        if (fZs().IT(paramString))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("enterprise_biz_username", paramString);
          try
          {
            paramString = fZs().j(102, (Bundle)localObject);
            if (paramString != null)
            {
              bool = paramString.getBoolean("is_enterprise_username");
              if (!bool) {}
            }
          }
          catch (RemoteException paramString)
          {
            Log.e(getTAG(), "invoke the check enterprise failed");
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
  
  public final void afK(int paramInt)
  {
    AppMethodBeat.i(210263);
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
    com.tencent.f.h.RTc.aV((Runnable)new af(this, i));
    AppMethodBeat.o(210263);
  }
  
  protected boolean aiy(String paramString)
  {
    return false;
  }
  
  protected final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(210248);
    kotlin.g.b.p.h(paramWebView, "webview");
    kotlin.g.b.p.h(paramWebResourceRequest, "request");
    if ((isStarted()) && (afI(this.IKj)))
    {
      Object localObject = this.ILL;
      String str = paramWebResourceRequest.getUrl().toString();
      if (!((Boolean)this.ILM.getValue()).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = ((ar)localObject).a(str, paramWebResourceRequest, bool, fZs());
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(210248);
        return localObject;
      }
    }
    paramWebView = super.b(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(210248);
    return paramWebView;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(210247);
    super.b(paramWebView, paramString);
    this.IKa.bN("onPageFinished", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.pGj, paramString);
    if (aiy(paramString))
    {
      AppMethodBeat.o(210247);
      return;
    }
    Log.i(getTAG(), "edw onPageFinished opt, url = %s", new Object[] { paramString });
    this.IMs.gdk().cW(paramString);
    com.tencent.mm.plugin.webview.ui.tools.l.Jhd.LZ();
    fZU().add(paramString);
    boolean bool = getIntent().getBooleanExtra("shouldForceViewPort", false);
    Log.d(getTAG(), "hy: shouldForceViewPort: ".concat(String.valueOf(bool)));
    Object localObject;
    if (bool)
    {
      localObject = getIntent().getStringExtra("view_port_code");
      if (paramWebView == null) {
        kotlin.g.b.p.hyc();
      }
      paramWebView.evaluateJavascript((String)localObject, null);
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    if (aXC(paramString))
    {
      Log.f(getTAG(), "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(210247);
      return;
    }
    if (kotlin.g.b.p.j(paramString, this.ILQ))
    {
      Log.i(getTAG(), "onPageFinished, js is finished loaded");
      AppMethodBeat.o(210247);
      return;
    }
    this.IMs.gda().aZi(paramString);
    this.IMs.gdb().aZg(paramString);
    this.IMs.gde().report();
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      localObject = paramWebView.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.IMs.gdl().Bfh = ((SnsAdClick)localObject);
        localObject = this.IMs.gdl();
        String str = String.valueOf(System.currentTimeMillis());
        kotlin.g.b.p.g(paramWebView, "uxInfo");
        ((au)localObject).U(new String[] { paramString, "1", str, paramWebView });
        this.IMs.gdl().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.n.JhS;
    com.tencent.mm.plugin.webview.ui.tools.n.a(getIntent(), paramString, true);
    this.ILW = Util.nowSecond();
    AppMethodBeat.o(210247);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(210245);
    kotlin.g.b.p.h(paramWebView, "view");
    kotlin.g.b.p.h(paramString, "url");
    super.b(paramWebView, paramString, paramBitmap);
    this.IKa.bN("onPageStarted", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.pGj, paramString);
    if (aiy(paramString))
    {
      AppMethodBeat.o(210245);
      return;
    }
    if (!this.pGj.supportFeature(2006)) {
      getJsapi().gbj();
    }
    com.tencent.mm.plugin.webview.k.k.j(paramString, getContext());
    Log.i(getTAG(), "edw onPageStarted opt, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 0);
    if ((CrashReportFactory.hasDebuger()) && (kotlin.g.b.p.j("http://www.dktest-mmcrash.com/", paramString))) {
      Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    }
    this.ILO = this.IJM;
    long l = Util.nowSecond();
    paramWebView = fZS();
    kotlin.g.b.p.h(paramString, "targetUrl");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new i.t.a(paramWebView, paramString, l));
    this.IMs.gdc().IZG = this.ILO;
    this.IJM = paramString;
    com.tencent.mm.plugin.webview.ui.tools.l.Jhd.cV(paramString);
    Log.d(getTAG(), "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { this.ILO, this.IJM });
    if (aXC(paramString))
    {
      Log.f(getTAG(), "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(210245);
      return;
    }
    fZU().add(paramString);
    this.IMs.gda().cU(bLC(), fZR()).aZh(paramString);
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      paramBitmap = paramWebView.getParcelable("KSnsAdTag");
      if ((paramBitmap != null) && ((paramBitmap instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.IMs.gdl().Bfh = ((SnsAdClick)paramBitmap);
        paramBitmap = this.IMs.gdl();
        String str = String.valueOf(System.currentTimeMillis());
        kotlin.g.b.p.g(paramWebView, "uxInfo");
        paramBitmap.U(new String[] { paramString, "0", str, paramWebView });
        this.IMs.gdl().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.n.JhS;
    com.tencent.mm.plugin.webview.ui.tools.n.a(getIntent(), paramString, false);
    AppMethodBeat.o(210245);
  }
  
  public final void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(210246);
    kotlin.g.b.p.h(paramWebView, "view");
    kotlin.g.b.p.h(paramString, "url");
    this.IJM = paramString;
    super.b(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(210246);
  }
  
  public final boolean b(int paramInt, String paramString, bhj parambhj)
  {
    AppMethodBeat.i(210251);
    kotlin.g.b.p.h(paramString, "reqUrl");
    kotlin.g.b.p.h(parambhj, "response");
    Object localObject = parambhj.LRP;
    if (localObject != null) {}
    for (long l = ((aey)localObject).Lqi;; l = -1L)
    {
      this.IMo = l;
      boolean bool = this.pGj.getIsX5Kernel();
      localObject = parambhj.LRH;
      kotlin.g.b.p.g(localObject, "response.FullURL");
      az.aU(bool, kotlin.n.n.J((String)localObject, "https://", false));
      this.IMs.gcZ().cM(paramString, true);
      this.IMs.gdb().cT(com.tencent.mm.plugin.webview.ui.tools.game.h.ehX, fZR()).aZe(parambhj.LRH);
      bool = super.b(paramInt, paramString, parambhj);
      AppMethodBeat.o(210251);
      return bool;
    }
  }
  
  public final int bLC()
  {
    AppMethodBeat.i(210268);
    int i = aXI(getIntent().getStringExtra("geta8key_username"));
    AppMethodBeat.o(210268);
    return i;
  }
  
  protected final void cpR()
  {
    AppMethodBeat.i(210250);
    int j = 2;
    int i = j;
    try
    {
      if (fZs().gdW()) {
        if (!this.IKM.IKV) {
          break label147;
        }
      }
      label147:
      for (i = com.tencent.mm.plugin.webview.k.f.a(getContext(), fZs(), coX());; i = com.tencent.mm.plugin.webview.k.f.id(getContext()))
      {
        afK(i);
        String str = this.pGj.getUrl();
        if (Util.isNullOrNil(str)) {
          break label210;
        }
        Object localObject = this.ILR;
        if (str == null) {
          kotlin.g.b.p.hyc();
        }
        if (!((Set)localObject).add(str)) {
          break label210;
        }
        localObject = this.mHi.gdI();
        kotlin.g.b.p.g(localObject, "wvPerm.genCtrl");
        if (((GeneralControlWrapper)localObject).gtE()) {
          getJsapi().gbe();
        }
        if (!((GeneralControlWrapper)localObject).gtF()) {
          break;
        }
        getJsapi().yZ(false);
        AppMethodBeat.o(210250);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(getTAG(), "onLoadJsApiFinished, ex = " + localException.getMessage());
        i = j;
      }
      if (this.ILL.aYR(localException)) {
        getJsapi().yZ(true);
      }
      label210:
      super.cpR();
      AppMethodBeat.o(210250);
    }
  }
  
  protected void cpc()
  {
    AppMethodBeat.i(210239);
    a((k)new av());
    super.cpc();
    AppMethodBeat.o(210239);
  }
  
  protected void cpd()
  {
    AppMethodBeat.i(210258);
    Object localObject1 = ((Iterable)this.ICu).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((k)((Iterator)localObject1).next()).e(coX(), getIntent()))
      {
        AppMethodBeat.o(210258);
        return;
      }
    }
    if (aXJ(coX()))
    {
      AppMethodBeat.o(210258);
      return;
    }
    if (cpe())
    {
      BaseWebViewController.a(this, coX(), false, 0, 6);
      AppMethodBeat.o(210258);
      return;
    }
    Log.i(getTAG(), "terry onStartLoad:" + coX());
    Object localObject3 = fZx();
    localObject1 = (CharSequence)localObject3;
    int i;
    if ((localObject1 == null) || (kotlin.n.n.aL((CharSequence)localObject1))) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i(getTAG(), (String)localObject3);
        localObject1 = localObject3;
        if (getIntent().getBooleanExtra("QRDataFlag", true)) {}
        try
        {
          localObject1 = fZs().aZR((String)localObject3);
          localObject3 = this.pGj.getSettings();
          kotlin.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setUseWideViewPort(false);
          localObject3 = this.pGj.getSettings();
          kotlin.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setLoadWithOverviewMode(false);
          localObject3 = this.pGj.getSettings();
          kotlin.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setJavaScriptEnabled(false);
          yS(true);
          this.pGj.loadDataWithBaseURL(null, (String)localObject1, "text/html", "utf-8", null);
          Log.i(getTAG(), "loadDataWithBaseUrl, data = ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(210258);
          return;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.w(getTAG(), "postBinded, formatQRString, ex = " + localException.getMessage());
            localObject2 = localObject3;
          }
        }
      }
    }
    if (aXC(coX()))
    {
      Log.f(getTAG(), "postBinded 2, canLoadUrl fail, url = " + coX());
      AppMethodBeat.o(210258);
      return;
    }
    if (this.IKM.IKW) {
      this.mHi.a(coX(), null, null);
    }
    Object localObject2 = ((Iterable)this.ICu).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((k)((Iterator)localObject2).next()).aXQ(coX()))
      {
        AppMethodBeat.o(210258);
        return;
      }
    }
    if (this.pGj.gZa())
    {
      AppMethodBeat.o(210258);
      return;
    }
    yS(false);
    BaseWebViewController.a(this, coX(), null, 6);
    AppMethodBeat.o(210258);
  }
  
  protected boolean cpe()
  {
    AppMethodBeat.i(210259);
    Object localObject = ((Iterable)this.ICu).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((k)((Iterator)localObject).next()).aXR(coX()))
      {
        AppMethodBeat.o(210259);
        return false;
      }
    }
    localObject = (CharSequence)getIntent().getStringExtra("data");
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject))) {}
    for (int i = 1; (i != 0) && (!this.IKM.IKW); i = 0)
    {
      AppMethodBeat.o(210259);
      return true;
    }
    AppMethodBeat.o(210259);
    return false;
  }
  
  protected final void ePr()
  {
    AppMethodBeat.i(210257);
    if (fZD())
    {
      Log.e(getTAG(), "onBinded call when activity has been finished");
      AppMethodBeat.o(210257);
      return;
    }
    Log.i(getTAG(), "Abe-Debug onPostBindedStart");
    this.IKa.bN("onPostBindedStart", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.l.Jhd.b(fZs());
    Object localObject1 = getIntent().getStringExtra("ad_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.l.Jhd;
      kotlin.g.b.p.g(localObject2, "WebViewReportUtil.INSTANCE");
      ((com.tencent.mm.plugin.webview.ui.tools.l)localObject2).setTraceId((String)localObject1);
    }
    this.IKa.bN("onJSAPIStart", System.currentTimeMillis());
    localObject1 = getIntent().getBundleExtra("jsapiargs");
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    for (;;)
    {
      ((Bundle)localObject1).putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
      ((Bundle)localObject1).putString("key_function_id", getIntent().getStringExtra("key_function_id"));
      Log.i(getTAG(), "KDownloadRestrict = %d, KFunctionID = %s", new Object[] { Integer.valueOf(((Bundle)localObject1).getInt("key_download_restrict", 0)), ((Bundle)localObject1).getString("key_function_id", "") });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBundle("jsapiargs", (Bundle)localObject1);
      ((Bundle)localObject2).putCharSequence("bizofstartfrom", (CharSequence)getIntent().getStringExtra("bizofstartfrom"));
      ((Bundle)localObject2).putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
      ((Bundle)localObject2).putInt("screen_orientation", getScreenOrientation());
      try
      {
        fZs().a(20, (Bundle)localObject2, fZu());
        localObject3 = getIntent().getStringExtra("geta8key_username");
        i = getIntent().getIntExtra("preChatTYPE", 0);
        str1 = getIntent().getStringExtra("srcUsername");
        long l = getIntent().getLongExtra("message_id", 0L);
        int j = getIntent().getIntExtra("message_index", 0);
        localObject2 = getIntent().getStringExtra("KsnsViewId");
        String str2 = getIntent().getStringExtra("KPublisherId");
        String str4 = getIntent().getStringExtra("KAppId");
        String str5 = getIntent().getStringExtra("pre_username");
        String str3 = getIntent().getStringExtra("expid_str");
        localObject1 = ((Bundle)localObject1).getString("key_snsad_statextstr");
        ax localax = this.IMs.gdc();
        localax.username = ((String)localObject3);
        localax.IZH = i;
        localax.edo = coX();
        localax.IZD = j;
        localax.scene = aXI((String)localObject3);
        localax.IZC = l;
        localax.IZE = new com.tencent.mm.b.p(l).toString();
        localax.ISp = str1;
        localax.IZB = ((String)localObject2);
        localax.iAh = str2;
        localax.appId = str4;
        localax.IZF = str5;
        localax.IZG = this.ILO;
        localax.statExtStr = ((String)localObject1);
        localObject2 = getTitle();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localax.title = ((String)localObject1);
        localax.fRa = str3;
        localObject2 = getIntent().getStringExtra("share_report_pre_msg_desc");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localax.desc = ((String)localObject2);
        localObject1 = this.IMs.gdd();
        ((ak)localObject1).iAh = str2;
        ((ak)localObject1).scene = aXI((String)localObject3);
        this.IMs.gdf().aZd(coX());
        if (!fZV()) {}
      }
      catch (RemoteException localRemoteException)
      {
        label1538:
        label1806:
        label1842:
        try
        {
          for (;;)
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("srcUsername", getIntent().getStringExtra("srcUsername"));
            fZs().a(29, (Bundle)localObject1, fZu());
            label731:
            if (!Util.isNullOrNil(str1)) {}
            try
            {
              fZs().aZW(str1);
              try
              {
                i = getIntent().getIntExtra("pay_channel", -1);
                if (i == -1) {
                  break label1538;
                }
                Log.i(getTAG(), "hy: found channel in intent. pay channel: %d", new Object[] { Integer.valueOf(i) });
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Log.e(getTAG(), "hy: init pay channel failed");
                  continue;
                  i = 0;
                  continue;
                  localObject3 = (CharSequence)str1;
                  if ((localObject3 == null) || (kotlin.n.n.aL((CharSequence)localObject3))) {}
                  for (i = 1; i == 0; i = 0)
                  {
                    localRemoteException.put("srcUsername", str1);
                    break;
                  }
                  i = 3;
                  Log.i(getTAG(), "default pay scene to: %s", new Object[] { Integer.valueOf(3) });
                }
                if (!this.pGj.getIsX5Kernel()) {
                  break label1842;
                }
                com.tencent.mm.pluginsdk.ui.tools.r.pl(7);
                com.tencent.mm.plugin.report.service.h.CyF.a(64, 64, 1, 0, 1, 1, false);
                try
                {
                  i = Util.getInt(fZs().aZV("WebviewDisableDigestVerify"), 0);
                  Log.i(getTAG(), "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
                  if (i != 0) {
                    break label1806;
                  }
                  SharedPreferences localSharedPreferences = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                  kotlin.g.b.p.g(localSharedPreferences, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
                  if ((!localSharedPreferences.getBoolean("wvsha1", true)) || (!this.IKM.IKU)) {
                    break label1806;
                  }
                  getJsapi().gaT();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    for (;;)
                    {
                      fZs().a(coX(), true, null);
                      this.IKa.bN("onPostBindedEnd", System.currentTimeMillis());
                      AppMethodBeat.o(210257);
                      return;
                      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(64L, 0L, 1L, false);
                    }
                    localException3 = localException3;
                    Log.w(getTAG(), "getting js digest verification config fails, ex = " + localException3.getMessage());
                    i = 0;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      Log.w(getTAG(), "postBinded, jumpToActivity, ex = " + localException4.getMessage());
                    }
                  }
                }
              }
              this.ILX.clear();
              localObject1 = getJsapi();
              str1 = getIntent().getStringExtra("geta8key_username");
              localObject2 = ae.f(new kotlin.o[] { s.U("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0L))), s.U("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), s.U("scene", Integer.valueOf(aXI(str1))), s.U("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), s.U("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), s.U("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))) });
              localObject3 = (CharSequence)getIntent().getStringExtra("srcUsername");
              if ((localObject3 == null) || (kotlin.n.n.aL((CharSequence)localObject3)))
              {
                i = 1;
                if (i != 0) {
                  break label1609;
                }
                ((Map)localObject2).putAll((Map)ae.g(new kotlin.o[] { s.U("srcUsername", getIntent().getStringExtra("srcUsername")), s.U("srcDisplayname", getIntent().getStringExtra("srcDisplayname")) }));
                if (!Util.isNullOrNil(getIntent().getStringExtra("KTemplateId")))
                {
                  str1 = getIntent().getStringExtra("KTemplateId");
                  kotlin.g.b.p.g(str1, "intent.getStringExtra(Co…UI.WebViewUI.KTemplateId)");
                  ((Map)localObject2).put("KTemplateId", str1);
                }
                i = getIntent().getIntExtra("pay_scene", -1);
                if (i == -1) {
                  break label1656;
                }
                Log.i(getTAG(), "get pay scene from extra: %s", new Object[] { Integer.valueOf(i) });
                ((Map)localObject2).put("pay_scene", Integer.valueOf(i));
                ((com.tencent.mm.plugin.webview.d.h)localObject1).bG((Map)localObject2);
                localObject1 = this.ILX;
                localObject2 = (List)new ArrayList();
                ((List)localObject2).add(getJsapi());
                ((List)localObject2).add(this.ILY);
                ((List)localObject2).add(this.ILZ);
                ((List)localObject2).add(this.IMa);
                ((List)localObject2).add(this.IMb);
                ((List)localObject2).add(this.IMc);
                ((List)localObject2).add(this.IMd);
                ((List)localObject2).add(this.IMg);
                ((List)localObject2).add(this.IMj);
                ((List)localObject2).add(this.IMk);
                ((List)localObject2).add(this.IMl);
                ((List)localObject2).add(this.IMn);
                ((List)localObject2).add(this.IMi);
                ((List)localObject2).add(this.IMm);
                ((List)localObject2).add(this.IMh);
                if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
                  ((List)localObject2).add(this.IMq);
                }
                ((List)localObject2).add(this.IMp);
                ((List)localObject1).addAll((Collection)localObject2);
                Log.i(getTAG(), "Abe-Debug controllerListeners call, size = %d", new Object[] { Integer.valueOf(this.IKd.size()) });
                localObject1 = ((Iterable)this.IKd).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  ((j)((Iterator)localObject1).next()).ePr();
                  continue;
                  localRemoteException = localRemoteException;
                  Log.e(getTAG(), "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + localRemoteException.getMessage());
                }
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.e(getTAG(), "postBinded, fail triggerGetContact, ex = " + localException1.getMessage());
                continue;
                i = fZs().getPayChannel();
                if (i != -1)
                {
                  Log.i(getTAG(), "hy: found channel in channel helper. pay channel: %d", new Object[] { Integer.valueOf(i) });
                  getIntent().putExtra("pay_channel", i);
                }
              }
            }
          }
        }
        catch (Exception localException5)
        {
          Object localObject3;
          int i;
          String str1;
          label1609:
          label1656:
          break label731;
        }
      }
    }
  }
  
  protected final void fZA()
  {
    AppMethodBeat.i(210273);
    if (this.IMr != null)
    {
      AppMethodBeat.o(210273);
      return;
    }
    Log.i(getTAG(), "WebView-Trace setWebViewPluginClient");
    this.IMr = com.tencent.luggage.xweb_ext.extendplugin.d.a((WebView)this.pGj, (com.tencent.luggage.xweb_ext.extendplugin.b.d)com.tencent.luggage.xweb_ext.extendplugin.b.b.QL(), (com.tencent.luggage.xweb_ext.extendplugin.a.c)com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g.gie(), null);
    AppMethodBeat.o(210273);
  }
  
  public final boolean fZB()
  {
    AppMethodBeat.i(210256);
    Log.i(getTAG(), "edw onServiceDisconnected");
    Iterator localIterator = ((Iterable)this.ICu).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((k)localIterator.next()).gah());
    for (int i = 1; i == 0; i = 0)
    {
      Log.i(getTAG(), "maybe mm process crash, try rebind service");
      AppMethodBeat.o(210256);
      return true;
    }
    boolean bool = super.fZB();
    AppMethodBeat.o(210256);
    return bool;
  }
  
  public final void fZC()
  {
    AppMethodBeat.i(210234);
    super.fZC();
    fZT().aG(this.pGj.getActivityContextIfHas());
    Context localContext = this.pGj.getActivityContextIfHas();
    Object localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      kotlin.g.b.p.g(localObject, "it.intent");
      setIntent((Intent)localObject);
      AppMethodBeat.o(210234);
      return;
    }
    AppMethodBeat.o(210234);
  }
  
  protected final void fZG()
  {
    AppMethodBeat.i(210254);
    super.fZG();
    com.tencent.mm.plugin.webview.i.b.gdQ();
    Object localObject = ((Iterable)this.IKd).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((j)((Iterator)localObject).next()).a(this.IKa);
    }
    localObject = this.IKa;
    MMWebView localMMWebView = this.pGj;
    kotlin.g.a.a locala = (kotlin.g.a.a)new ab(this);
    kotlin.g.b.p.h(localMMWebView, "webView");
    kotlin.g.b.p.h(locala, "callback");
    localMMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", (ValueCallback)new j.b((com.tencent.mm.plugin.webview.k.j)localObject, locala));
    AppMethodBeat.o(210254);
  }
  
  protected final void fZH()
  {
    AppMethodBeat.i(210274);
    Log.d(getTAG(), "setGetA8KeyParams");
    Object localObject1 = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_req");
    Object localObject2 = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_resp");
    if ((localObject1 != null) && (localObject2 != null))
    {
      Log.i(getTAG(), "set outer get A8key result");
      fZr().k((byte[])localObject1, (byte[])localObject2);
    }
    localObject1 = getIntent().getStringExtra("geta8key_username");
    localObject2 = getIntent().getStringExtra("msgUsername");
    String str = getIntent().getStringExtra("serverMsgID");
    fZr().aZC((String)localObject2);
    fZr().aZD(str);
    fZr().setUsername((String)localObject1);
    fZr().setScene(aXI((String)localObject1));
    fZr().setAppId(getIntent().getStringExtra("geta8key_open_webview_appid"));
    localObject1 = this.pGj;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((MMWebView)localObject1).getIsX5Kernel());
      if (!((Boolean)localObject1).booleanValue()) {
        break label273;
      }
      fZr().setFlag(1);
    }
    for (;;)
    {
      fZr().av(getIntent().getByteArrayExtra("geta8key_cookie"));
      fZr().age(getIntent().getIntExtra("key_wallet_region", 0));
      fZr().aZB(getIntent().getStringExtra("key_function_id"));
      int i = getIntent().getIntExtra("geta8key_session_id", 0);
      if (i > 0) {
        fZr().DU(i);
      }
      AppMethodBeat.o(210274);
      return;
      localObject1 = null;
      break;
      label273:
      fZr().setFlag(0);
    }
  }
  
  public final boolean fZV()
  {
    AppMethodBeat.i(210261);
    Object localObject = getIntent().getStringExtra("srcUsername");
    String str = getIntent().getStringExtra("bizofstartfrom");
    localObject = (CharSequence)localObject;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject))) {}
    for (int i = 1; (i == 0) && (kotlin.g.b.p.j(str, "enterpriseHomeSubBrand")); i = 0)
    {
      AppMethodBeat.o(210261);
      return true;
    }
    AppMethodBeat.o(210261);
    return false;
  }
  
  public final boolean fZY()
  {
    AppMethodBeat.i(210275);
    if (!this.IJT)
    {
      AppMethodBeat.o(210275);
      return false;
    }
    fZZ();
    AppMethodBeat.o(210275);
    return true;
  }
  
  public final void fZZ()
  {
    AppMethodBeat.i(210276);
    boolean bool = com.tencent.mm.plugin.webview.modeltools.k.a(getJsapi(), this.pGj);
    Object localObject = this.ILF;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h)localObject).onDestroy();
    }
    localObject = this.ILD;
    if (localObject != null) {
      ((com.tencent.mm.plugin.webview.ui.tools.j)localObject).onDestroy();
    }
    onDestroy();
    this.pGj.removeJavascriptInterface("MicroMsg");
    this.pGj.removeJavascriptInterface("JsApi");
    this.pGj.removeJavascriptInterface("__wx");
    this.pGj.removeJavascriptInterface("CustomFullscreenApi");
    this.pGj.removeJavascriptInterface("__wxtag");
    try
    {
      this.pGj.setWebChromeClient(null);
      this.pGj.setWebViewClient(null);
      this.pGj.setOnTouchListener(null);
      this.pGj.setOnLongClickListener(null);
      this.pGj.setVisibility(8);
      this.pGj.removeAllViews();
      this.pGj.clearView();
      if (!bool)
      {
        this.pGj.destroy();
        AppMethodBeat.o(210276);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e(getTAG(), "releaseWebView, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(210276);
    }
  }
  
  protected final Class<? extends Service> fZp()
  {
    AppMethodBeat.i(210233);
    Class localClass = (Class)this.ILC.getValue();
    AppMethodBeat.o(210233);
    return localClass;
  }
  
  protected final Set<String> fZq()
  {
    AppMethodBeat.i(210235);
    Set localSet = (Set)this.ILH.getValue();
    AppMethodBeat.o(210235);
    return localSet;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(210236);
    Object localObject2 = this.pGj.getTitle();
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
    AppMethodBeat.o(210236);
    return localObject1;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(210272);
    if (this.IMr == null) {
      fZA();
    }
    com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.IMr;
    AppMethodBeat.o(210272);
    return localc;
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(210240);
    kotlin.g.b.p.h(paramString, "url");
    Log.i(getTAG(), "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
    if (aXC(paramString))
    {
      Log.f(getTAG(), "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      super.h(paramWebView, paramString);
      AppMethodBeat.o(210240);
      return;
    }
    this.IMs.gdb().aZf(paramString);
    super.h(paramWebView, paramString);
    AppMethodBeat.o(210240);
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(210260);
    kotlin.g.b.p.h(paramString, "url");
    com.tencent.mm.plugin.webview.model.a.a(this.pGj, paramString);
    super.loadUrl(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(210260);
  }
  
  protected final boolean m(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(210249);
    kotlin.g.b.p.h(paramWebView, "webView");
    kotlin.g.b.p.h(paramString, "url");
    Log.i(getTAG(), "WebView-Trace shouldOverride url = ".concat(String.valueOf(paramString)));
    Object localObject1 = l(paramWebView, paramString);
    boolean bool;
    if (((k.a)localObject1).INa)
    {
      bool = ((k.a)localObject1).result;
      AppMethodBeat.o(210249);
      return bool;
    }
    if (aXC(paramString))
    {
      Log.f(getTAG(), "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(210249);
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "about:blank", true))
    {
      Log.e(getTAG(), "shouldOverride, url is about:blank");
      AppMethodBeat.o(210249);
      return true;
    }
    if (DownloadChecker.a(paramString, fZR(), paramWebView))
    {
      Log.i(getTAG(), "use the downloader to download");
      AppMethodBeat.o(210249);
      return true;
    }
    try
    {
      if ((com.tencent.luggage.h.c.a(paramString, "weixin://jump/", true)) || (com.tencent.luggage.h.c.a(paramString, "weixin://scanqrcode/", true)))
      {
        kotlin.g.b.p.h(paramString, "url");
        bool = getIntent().getBooleanExtra(e.p.OzK, false);
        if ((this.mHi.gdI().gtC()) || (bool))
        {
          Log.i(getTAG(), "allowJumpWithoutPerm: ".concat(String.valueOf(bool)));
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("fromScene", 100);
          if (fZs().a(paramString, this.mHi.gdH().pP(7), (Bundle)localObject1)) {
            Log.i(getTAG(), "shouldOverride, built in url handled, url = ".concat(String.valueOf(paramString)));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(210249);
          return true;
          Log.w(getTAG(), "shouldOverride, allow inner open url, not allow");
        }
      }
      Object localObject2;
      Object localObject3;
      int i;
      paramWebView = null;
    }
    catch (Exception localException)
    {
      Log.w(getTAG(), "shouldOverride, jumpToActivity, ex = " + localException.getMessage());
      while (aXJ(paramString))
      {
        AppMethodBeat.o(210249);
        return true;
        if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/business")) && (com.tencent.mm.pluginsdk.g.w(Uri.parse(paramString))))
        {
          localObject2 = Uri.parse(coX());
          kotlin.g.b.p.g(localObject2, "rawUrlUri");
          localObject3 = ((Uri)localObject2).getHost();
          localObject2 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
          ((Intent)localObject2).setData(Uri.parse(paramString + "&domain=" + (String)localObject3));
          i = ((Intent)localObject2).getIntExtra("pay_channel", -1);
          if (i != -1)
          {
            Log.i(getTAG(), "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
            ((Intent)localObject2).putExtra("pay_channel", i);
          }
          ((Intent)localObject2).putExtra("translate_link_scene", 13);
          localObject3 = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(210249);
          return true;
        }
        if (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe"))
        {
          Log.i(getTAG(), "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
        }
        else if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/common_view")) || (com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/phone_view")))
        {
          localObject2 = coX();
          localObject3 = com.tencent.mm.pluginsdk.g.JSN;
          kotlin.g.b.p.g(localObject3, "DeepLinkHelper.PREFIX_SUPPORT_QQ");
          if (!com.tencent.luggage.h.c.A((String)localObject2, (String)localObject3))
          {
            localObject2 = com.tencent.mm.pluginsdk.g.JSO;
            kotlin.g.b.p.g(localObject2, "DeepLinkHelper.PREFIX_SUPPORT_WECHAT");
            if (!com.tencent.luggage.h.c.A(paramString, (String)localObject2)) {
              break;
            }
          }
          else if (((Boolean)this.ILI.getValue()).booleanValue())
          {
            com.tencent.mm.pluginsdk.g.cf(this.pGj.getActivityContextIfHas(), paramString);
            onFinish();
            AppMethodBeat.o(210249);
            return true;
          }
        }
        else if ((com.tencent.luggage.h.c.A(paramString, "weixin://webview/initReady/")) || (com.tencent.luggage.h.c.A(paramString, "weixin://webview/preInjectJSBridge/")))
        {
          AppMethodBeat.o(210249);
          return true;
        }
      }
      if (com.tencent.luggage.h.c.A(paramString, "weixin://"))
      {
        Log.e(getTAG(), "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        AppMethodBeat.o(210249);
        return true;
      }
      Log.i(getTAG(), "edw overrideUrl");
      if ((com.tencent.luggage.h.c.A(paramString, "weixinping://iframe")) || (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe")))
      {
        AppMethodBeat.o(210249);
        return true;
      }
      if (aXH(paramString))
      {
        Log.i(getTAG(), "custom scheme url deal success, url = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(210249);
        return true;
      }
      if ((paramWebView instanceof MMWebView)) {}
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.model.a.a((MMWebView)paramWebView, paramString);
      AppMethodBeat.o(210249);
      return false;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(210271);
    if (afI(this.IKk)) {
      fZS().r("", Util.nowSecond(), 0);
    }
    fZT().detach();
    if (fZV()) {}
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
      fZs().a(30, localBundle, fZu());
      try
      {
        label86:
        fZs().agy(fZW().fZu());
        super.onDestroy();
        AppMethodBeat.o(210271);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.i(getTAG(), "onDestroy remove callbacker ex " + localException1.getMessage());
        }
      }
    }
    catch (Exception localException2)
    {
      break label86;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210165);
      kotlin.g.b.p.h(paramString, "url");
      if (!this.IMu.mHi.gdI().gtC())
      {
        Log.e(i.a(this.IMu), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
        AppMethodBeat.o(210165);
        return true;
      }
      try
      {
        this.IMu.fZs().cP(paramString, this.IMu.mHi.gdH().pP(7));
        AppMethodBeat.o(210165);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(i.a(this.IMu), "ActivityJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210164);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210164);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, "weixin://jump/");
      AppMethodBeat.o(210164);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$oauthOnSceneEndDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"})
  public static final class aa
    implements ag.a
  {
    private final Map<Integer, Integer> IMR;
    
    aa()
    {
      AppMethodBeat.i(210217);
      this.IMR = ((Map)new HashMap());
      AppMethodBeat.o(210217);
    }
    
    public final void xr()
    {
      AppMethodBeat.i(210216);
      i.a(this.IMu, 1373);
      if (this.IMR.containsKey(Integer.valueOf(1373)))
      {
        Object localObject = this.IMR.get(Integer.valueOf(1373));
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        int i = ((Number)localObject).intValue();
        this.IMR.put(Integer.valueOf(1373), Integer.valueOf(i - 1));
        AppMethodBeat.o(210216);
        return;
      }
      this.IMR.put(Integer.valueOf(1373), Integer.valueOf(0));
      AppMethodBeat.o(210216);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    ab(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"getNetWorkTypeName", "", "context", "Landroid/content/Context;", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Context, String>
  {
    public static final ac IMS;
    
    static
    {
      AppMethodBeat.i(210221);
      IMS = new ac();
      AppMethodBeat.o(210221);
    }
    
    ac()
    {
      super();
    }
    
    public static String hQ(Context paramContext)
    {
      AppMethodBeat.i(210220);
      kotlin.g.b.p.h(paramContext, "context");
      if (NetStatusUtil.isWifi(paramContext))
      {
        AppMethodBeat.o(210220);
        return "wifi";
      }
      if (NetStatusUtil.is5G(paramContext))
      {
        AppMethodBeat.o(210220);
        return "5g";
      }
      if (NetStatusUtil.is4G(paramContext))
      {
        AppMethodBeat.o(210220);
        return "4g";
      }
      if (NetStatusUtil.is3G(paramContext))
      {
        AppMethodBeat.o(210220);
        return "3g";
      }
      if (NetStatusUtil.is2G(paramContext))
      {
        AppMethodBeat.o(210220);
        return "2g";
      }
      AppMethodBeat.o(210220);
      return "none";
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"dnsIps", "", "host", "invoke"})
  static final class ad
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, String>
  {
    ad(i parami)
    {
      super();
    }
    
    public final String aXM(String paramString)
    {
      AppMethodBeat.i(210223);
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
            kotlin.g.b.p.g(localObject, "inetAddressArr[i]");
            localStringBuilder.append(localObject.getHostAddress());
            localStringBuilder.append(";");
            i += 1;
          }
        }
        paramString = localStringBuilder.toString();
      }
      catch (UnknownHostException paramString)
      {
        Log.printErrStackTrace(i.a(this.IMu), (Throwable)paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(210223);
        return null;
      }
      AppMethodBeat.o(210223);
      return paramString;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(String paramString1, int paramInt, i.ad paramad, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(210224);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      String str = this.ILv;
      int i = paramInt;
      Object localObject = i.ac.IMS;
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject, "MMApplicationContext.getContext()");
      localh.a(17082, new Object[] { str, Integer.valueOf(i), i.ac.hQ((Context)localObject), this.IMT.aXM(str) });
      AppMethodBeat.o(210224);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(i parami, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(210225);
      this.IMu.getJsapi().afL(i);
      Object localObject = this.IMu;
      int i = i;
      localObject = ((Iterable)((BaseWebViewController)localObject).IKd).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((j)((Iterator)localObject).next()).afL(i);
      }
      AppMethodBeat.o(210225);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "invoke"})
  static final class ag
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.modeltools.n>
  {
    public static final ag IMW;
    
    static
    {
      AppMethodBeat.i(210227);
      IMW = new ag();
      AppMethodBeat.o(210227);
    }
    
    ag()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "invoke"})
  static final class ah
    extends kotlin.g.b.q
    implements kotlin.g.a.a<i.p>
  {
    ah(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "invoke"})
  static final class ai
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.ui.tools.c>
  {
    ai(MMWebView paramMMWebView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;", "invoke"})
  static final class aj
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Class<WebViewStubService>>
  {
    public static final aj IMX;
    
    static
    {
      AppMethodBeat.i(210230);
      IMX = new aj();
      AppMethodBeat.o(210230);
    }
    
    aj()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "invoke"})
  static final class ak
    extends kotlin.g.b.q
    implements kotlin.g.a.a<i.t>
  {
    ak(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMv = "weixin://addfriend/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210167);
      kotlin.g.b.p.h(paramString, "url");
      if (!this.IMu.mHi.gdH().pP(5))
      {
        Log.e(i.a(this.IMu), "AddFriendHandler, permission fail");
        AppMethodBeat.o(210167);
        return true;
      }
      paramString = paramString.substring(this.IMv.length());
      kotlin.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210167);
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_webview", true);
      localBundle.putString("userName", paramString);
      try
      {
        this.IMu.fZs().a(8, localBundle, this.IMu.fZu());
        AppMethodBeat.o(210167);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(i.a(this.IMu), "AddFriendHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210166);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210166);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMv);
      AppMethodBeat.o(210166);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMw = "weixin://webview/close/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210169);
      kotlin.g.b.p.h(paramString, "url");
      if (!this.IMu.mHi.gdH().pP(17))
      {
        Log.e(i.a(this.IMu), "close window permission fail");
        AppMethodBeat.o(210169);
        return true;
      }
      this.IMu.onFinish();
      AppMethodBeat.o(210169);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210168);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210168);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMw);
      AppMethodBeat.o(210168);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class e
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMx = "weixin://critical_update/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210171);
      kotlin.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 25L, 1L, true);
      i.b(this.IMu, 1);
      AppMethodBeat.o(210171);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210170);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210170);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMx);
      AppMethodBeat.o(210170);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "urlOrig", "plugin-webview_release"})
  public static final class f
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    f(MMWebView paramMMWebView) {}
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210173);
      kotlin.g.b.p.h(paramString, "urlOrig");
      int i = this.IMu.aXI(Util.nullAsNil(i.i(this.IMu)));
      Object localObject = com.tencent.mm.pluginsdk.g.bcY(paramString);
      if (com.tencent.mm.pluginsdk.g.bM((String)localObject, i.j(this.IMu))) {}
      for (;;)
      {
        try
        {
          if (kotlin.g.b.p.j("weixin://dl/shopping", localObject))
          {
            paramString = this.IMu.fZs().gea();
            kotlin.g.b.p.g(paramString, "invoker.getJDUrl()");
            if (!Util.isNullOrNil(paramString)) {
              BaseWebViewController.a(this.IMu, paramString, null, 6);
            }
            paramString = (List)new ArrayList();
            kotlin.g.b.p.g(localObject, "url");
            paramString.add(localObject);
            paramString.add("1");
            paramString.add(String.valueOf(i));
            localObject = Util.nullAsNil(i.i(this.IMu));
            kotlin.g.b.p.g(localObject, "Util.nullAsNil(sentUsername)");
            paramString.add(localObject);
            localObject = Util.nullAsNil(this.IMu.coX());
            kotlin.g.b.p.g(localObject, "Util.nullAsNil(rawUrl)");
            paramString.add(localObject);
            localObject = com.tencent.mm.plugin.report.service.h.CyF;
            com.tencent.mm.plugin.report.service.h.r(11405, paramString);
            bool = true;
            AppMethodBeat.o(210173);
            return bool;
          }
          if (kotlin.g.b.p.j("weixin://dl/faq", localObject))
          {
            int j = this.IMu.fZs().gec();
            int k = this.IMu.fZs().ged();
            paramString = MMApplicationContext.getContext().getString(2131765632, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            kotlin.g.b.p.g(paramString, "MMApplicationContext.get…otice_url, uin, newCount)");
            BaseWebViewController.a(this.IMu, paramString, null, 6);
            continue;
          }
        }
        catch (Exception paramString)
        {
          Log.e(i.a(this.IMu), "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          bool = true;
          continue;
          if (kotlin.g.b.p.j("weixin://dl/posts", localObject))
          {
            this.IMu.fZs().gee();
            continue;
          }
          if (kotlin.g.b.p.j("weixin://dl/moments", localObject))
          {
            this.IMu.fZs().gef();
            continue;
          }
          kotlin.g.b.p.g(localObject, "url");
          if (kotlin.n.n.J((String)localObject, "weixin://dl/feedback", false))
          {
            kotlin.g.b.p.g(this.IMu.fZs().baa((String)localObject), "invoker.getFeedbackUrl(url)");
            continue;
          }
          if (kotlin.g.b.p.j("weixin://dl/scan", localObject))
          {
            com.tencent.mm.br.c.c(this.IMu.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.g.ce(paramMMWebView.getActivityContextIfHas(), (String)localObject);
          continue;
        }
        boolean bool = false;
      }
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210172);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210172);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, "weixin://");
      AppMethodBeat.o(210172);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMy = "weixin://feedback/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210175);
      kotlin.g.b.p.h(paramString, "url");
      paramString = new Bundle();
      paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
      paramString.putInt("MMActivity.OverrideExitAnimation", 2130772130);
      try
      {
        this.IMu.fZs().a(7, paramString, this.IMu.fZu());
        AppMethodBeat.o(210175);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(i.a(this.IMu), "FeedbackJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210174);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210174);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMy);
      AppMethodBeat.o(210174);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMz = "weixin://connectToFreeWifi/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210177);
      kotlin.g.b.p.h(paramString, "url");
      paramString = Uri.parse(paramString);
      String str1 = paramString.getQueryParameter("apKey");
      Log.i(i.a(this.IMu), "apKey value = %s", new Object[] { str1 });
      String str2 = paramString.getQueryParameter("ticket");
      if (!Util.isNullOrNil(str1))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("free_wifi_schema_uri", paramString.toString());
        localIntent.putExtra("free_wifi_ap_key", str1);
        localIntent.putExtra("free_wifi_source", 5);
        if (!Util.isNullOrNil(str2)) {
          localIntent.putExtra("free_wifi_schema_ticket", str2);
        }
        localIntent.addFlags(67108864);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
      }
      AppMethodBeat.o(210177);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210176);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210176);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMz);
      AppMethodBeat.o(210176);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class i
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMA = "weixin://gethtml/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210179);
      kotlin.g.b.p.h(paramString, "url");
      if (!Util.isNullOrNil(paramString))
      {
        paramString = paramString.substring(this.IMA.length());
        kotlin.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        Log.i(i.a(this.IMu), "[oneliang]get html content :".concat(String.valueOf(paramString)));
        Object localObject = this.IMu;
        kotlin.g.b.p.h(paramString, "html");
        localObject = ((Iterable)((BaseWebViewController)localObject).IKd).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((j)((Iterator)localObject).next()).aXO(paramString);
        }
      }
      AppMethodBeat.o(210179);
      return false;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210178);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210178);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMA);
      AppMethodBeat.o(210178);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class j
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMB = "weixin://profile/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210181);
      kotlin.g.b.p.h(paramString, "url");
      paramString = paramString.substring(this.IMB.length());
      kotlin.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.e(i.a(this.IMu), "handleUrl fail, username is null");
        AppMethodBeat.o(210181);
        return true;
      }
      if (this.IMu.mHi.gdH().pP(2)) {
        this.IMu.getJsapi().aYf(paramString);
      }
      AppMethodBeat.o(210181);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210180);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210180);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMB);
      AppMethodBeat.o(210180);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class k
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMC = "weixin://manual_update/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210183);
      kotlin.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 26L, 1L, true);
      i.b(this.IMu, 3);
      AppMethodBeat.o(210183);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210182);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210182);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMC);
      AppMethodBeat.o(210182);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class l
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210185);
      kotlin.g.b.p.h(paramString, "url");
      String str = this.IMu.getIntent().getStringExtra("geta8key_username");
      boolean bool = ag.b.a(paramString, str, this.IMu.aXI(str), this.IMu.fZs(), i.d(this.IMu), this.IMu.ILV, i.e(this.IMu).fZu(), this.IMu.getContext());
      AppMethodBeat.o(210185);
      return bool;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210184);
      kotlin.g.b.p.h(paramString, "url");
      boolean bool = ag.b.gr(paramString, this.IMu.getIntent().getIntExtra("geta8key_scene", 0));
      AppMethodBeat.o(210184);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "READER_SHARE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "share", "", "plugin-webview_release"})
  public static final class m
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMD = "weixin://readershare/";
    
    m(MMWebView paramMMWebView) {}
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210188);
      kotlin.g.b.p.h(paramString, "url");
      paramString = this.IMu.getContext().getString(2131764204);
      kotlin.g.b.p.g(paramString, "context.getString(R.string.readerapp_share_weibo)");
      Context localContext = paramMMWebView.getActivityContextIfHas();
      h.d locald = (h.d)new a(this);
      com.tencent.mm.ui.base.h.a(localContext, "", new String[] { paramString }, "", locald);
      AppMethodBeat.o(210188);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210187);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210187);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMD);
      AppMethodBeat.o(210187);
      return bool;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "whichButton", "", "onClick"})
    static final class a
      implements h.d
    {
      a(i.m paramm) {}
      
      public final void oj(int paramInt)
      {
        AppMethodBeat.i(210186);
        if (paramInt == 0)
        {
          i.m localm = this.IME;
          try
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("shortUrl", localm.IMu.getIntent().getStringExtra("shortUrl"));
            localBundle.putInt("type", localm.IMu.getIntent().getIntExtra("type", 0));
            localm.IMu.fZs().a(4, localBundle, localm.IMu.fZu());
            AppMethodBeat.o(210186);
            return;
          }
          catch (Exception localException)
          {
            Log.e(i.a(localm.IMu), "share fail, ex = " + localException.getMessage());
          }
        }
        AppMethodBeat.o(210186);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class n
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMF = "weixin://recommend_update/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210190);
      kotlin.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 24L, 1L, true);
      i.b(this.IMu, 2);
      AppMethodBeat.o(210190);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210189);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210189);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMF);
      AppMethodBeat.o(210189);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class o
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMG = "weixin://openapi/openwebview/result?";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210192);
      kotlin.g.b.p.h(paramString, "url");
      Object localObject = new OpenWebview.Resp();
      paramString = Uri.parse(paramString);
      kotlin.g.b.p.g(paramString, "uri");
      ((OpenWebview.Resp)localObject).result = paramString.getQuery();
      ((OpenWebview.Resp)localObject).errCode = Util.getInt(paramString.getQueryParameter("errCode"), 0);
      ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
      ((OpenWebview.Resp)localObject).transaction = this.IMu.getIntent().getStringExtra("transaction_for_openapi_openwebview");
      paramString = paramString.getQueryParameter("appid");
      if (Util.isNullOrNil(paramString))
      {
        Log.e(i.a(this.IMu), "SDKOpenWebViewResultHandler handleUrl, appId is null");
        AppMethodBeat.o(210192);
        return true;
      }
      Bundle localBundle = new Bundle();
      ((OpenWebview.Resp)localObject).toBundle(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bo(localBundle);
      localObject = new MMessageActV2.Args();
      try
      {
        ((MMessageActV2.Args)localObject).targetPkgName = this.IMu.fZs().aZT(paramString);
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        Log.d(i.a(this.IMu), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
        MMessageActV2.send(this.IMu.getContext(), (MMessageActV2.Args)localObject);
        this.IMu.onFinish();
        AppMethodBeat.o(210192);
        return true;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(i.a(this.IMu), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(210192);
      }
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210191);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210191);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMG);
      AppMethodBeat.o(210191);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"})
  static final class p
    extends m
  {
    private final kotlin.f IJW;
    private final i IMH;
    private final String TAG;
    
    public p(i parami)
    {
      AppMethodBeat.i(210196);
      this.IMH = parami;
      this.TAG = ("MicroMsg.WebViewController.SceneEndCallbacker:" + this.IMH.fZu());
      this.IJW = kotlin.g.ah((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(210196);
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      AppMethodBeat.i(210195);
      Log.i(this.TAG, "onSceneEnd, instance hashcode = " + hashCode());
      i locali;
      if (paramd != null)
      {
        int i = paramd.getData().getInt("scene_end_listener_hash_code");
        Log.i(this.TAG, "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(fZu()) });
        Log.i(this.TAG, "edw onSceneEnd, type = " + paramd.getType() + ", errCode = " + paramd.getErrCode() + ", errType = " + paramd.getErrType());
        if (i != fZu())
        {
          Log.e(this.TAG, "hash code not equal");
          AppMethodBeat.o(210195);
          return false;
        }
        locali = this.IMH;
        switch (paramd.getType())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(210195);
        return true;
        i.a(locali, 106);
        locali.onFinish();
        continue;
        i.a(locali, 666);
        locali.onFinish();
      }
    }
    
    public final int fZu()
    {
      AppMethodBeat.i(210194);
      int i = ((Number)this.IJW.getValue()).intValue();
      AppMethodBeat.o(210194);
      return i;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    q(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class r
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    final String IMA = "weixin://private/gethtml/";
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210199);
      kotlin.g.b.p.h(paramString, "url");
      paramString = paramString.substring(this.IMA.length());
      kotlin.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      try
      {
        paramString = URLDecoder.decode(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("nowUrl", i.f(this.IMu));
        localBundle.putString("tweetid", Util.nullAsNil(this.IMu.getIntent().getStringExtra("tweetid")));
        localBundle.putString("htmlData", paramString);
        localBundle.putInt("type", this.IMu.getIntent().getIntExtra("type", 0));
        this.IMu.fZs().a(3, localBundle, this.IMu.fZu());
        AppMethodBeat.o(210199);
        return true;
      }
      catch (Exception paramString)
      {
        Log.e(i.a(this.IMu), "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(210199);
      }
      return false;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210198);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210198);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMA);
      AppMethodBeat.o(210198);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class s
    implements com.tencent.mm.plugin.webview.d.d.a
  {
    private final String IMJ = "weixin://viewimage/";
    
    s(MMWebView paramMMWebView) {}
    
    public final boolean aXJ(String paramString)
    {
      AppMethodBeat.i(210201);
      kotlin.g.b.p.h(paramString, "url");
      try
      {
        if (!this.IMu.fZs().isSDCardAvailable())
        {
          this.IMu.fZs().a(2, null, this.IMu.fZu());
          AppMethodBeat.o(210201);
          return true;
        }
      }
      catch (Exception paramString)
      {
        Log.e(i.a(this.IMu), "edw handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(210201);
        return false;
      }
      i locali = this.IMu;
      paramString = paramString.substring(this.IMJ.length());
      kotlin.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      i.a(locali, paramString);
      Log.i(i.a(this.IMu), "viewimage currentUrl :" + i.f(this.IMu));
      com.tencent.mm.pluginsdk.ui.tools.z.a((WebView)paramMMWebView, i.g(this.IMu).IMA, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", i.h(this.IMu));
      AppMethodBeat.o(210201);
      return true;
    }
    
    public final boolean aXK(String paramString)
    {
      AppMethodBeat.i(210200);
      kotlin.g.b.p.h(paramString, "url");
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(210200);
        return false;
      }
      boolean bool = com.tencent.mm.pluginsdk.ui.tools.z.C(paramString, this.IMJ);
      AppMethodBeat.o(210200);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"})
  final class t
  {
    private final i IMH;
    private volatile String IMK;
    private volatile String IML;
    private int fromScene;
    private long mRS;
    private int networkType;
    private String userAgent;
    
    public t()
    {
      AppMethodBeat.i(210205);
      this.IMH = localObject;
      this$1 = this.IMH.pGj.getSettings();
      kotlin.g.b.p.g(i.this, "controller.viewWV.settings");
      this$1 = i.this.getUserAgentString();
      kotlin.g.b.p.g(i.this, "controller.viewWV.settings.userAgentString");
      this.userAgent = i.this;
      this.fromScene = this.IMH.getIntent().getIntExtra("from_scence", 0);
      this.IMK = "";
      this.IML = "";
      AppMethodBeat.o(210205);
    }
    
    private void gaa()
    {
      AppMethodBeat.i(210203);
      Context localContext = this.IMH.getContext();
      Object localObject = localContext;
      if (!(localContext instanceof ContextWrapper)) {
        localObject = null;
      }
      localObject = (ContextWrapper)localObject;
      if (localObject != null)
      {
        localContext = ((ContextWrapper)localObject).getApplicationContext();
        localObject = localContext;
        if (localContext != null) {}
      }
      else
      {
        localObject = this.IMH.getContext();
      }
      int i;
      if (NetStatusUtil.isConnected((Context)localObject))
      {
        if (!NetStatusUtil.isWifi((Context)localObject)) {
          break label108;
        }
        i = 1;
      }
      for (;;)
      {
        this.networkType = i;
        Log.i(i.a(i.this), "get networkType " + this.networkType);
        AppMethodBeat.o(210203);
        return;
        label108:
        if (NetStatusUtil.is5G((Context)localObject)) {
          i = 5;
        } else if (NetStatusUtil.is4G((Context)localObject)) {
          i = 4;
        } else if (NetStatusUtil.is3G((Context)localObject)) {
          i = 3;
        } else if (NetStatusUtil.is2G((Context)localObject)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
    
    public final void r(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(210204);
      kotlin.g.b.p.h(paramString, "targetUrl");
      gaa();
      String str5 = this.IMH.aXD(this.IML);
      if (this.fromScene != 0) {
        this.IMK = " ";
      }
      boolean bool = this.IMH.mHi.gdI().gtG();
      Log.d(i.a(i.this), "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.mRS > 0L) && (i.b(i.this) > this.mRS) && (paramLong > i.b(i.this)) && (!TextUtils.isEmpty((CharSequence)str5)) && (bool))
      {
        l1 = i.b(i.this) - this.mRS;
        l2 = paramLong - i.b(i.this);
        Log.d(i.a(i.this), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.mRS), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.userAgent, this.IML, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.IMK });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(this.userAgent), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(this.IML), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(this.IMK), "UTF-8");
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
      com.tencent.mm.plugin.report.service.h.CyF.a(13376, new Object[] { Long.valueOf(this.mRS), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.IMK = this.IML;
        this.IML = paramString;
        this.mRS = paramLong;
      }
      AppMethodBeat.o(210204);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(i.t paramt, String paramString, long paramLong) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(210202);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.IMM.r(this.IMN, this.IMO, this.IMP);
        AppMethodBeat.o(210202);
        return false;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(i parami, Uri paramUri) {}
    
    public final void run()
    {
      AppMethodBeat.i(210206);
      com.tencent.mm.pluginsdk.model.app.h.k(this.IMu.pGj.getActivityContextIfHas(), this.IMQ);
      AppMethodBeat.o(210206);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/HashSet;", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<HashSet<String>>
  {
    v(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    w(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class x
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    x(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    y(i parami)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/core/WebViewController$oauthDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"})
  public static final class z
    implements ag.c
  {
    z(MMWebView paramMMWebView) {}
    
    private static void c(Dialog paramDialog)
    {
      AppMethodBeat.i(210215);
      if ((paramDialog != null) && (paramDialog.isShowing()))
      {
        paramDialog.dismiss();
        paramDialog.setCancelMessage(null);
        paramDialog.setDismissMessage(null);
      }
      AppMethodBeat.o(210215);
    }
    
    public final void aXL(String paramString)
    {
      AppMethodBeat.i(210211);
      kotlin.g.b.p.h(paramString, "url");
      this.IMu.k(paramString, true, 9);
      AppMethodBeat.o(210211);
    }
    
    public final void cGW()
    {
      AppMethodBeat.i(210214);
      c((Dialog)i.c(this.IMu));
      AppMethodBeat.o(210214);
    }
    
    public final void e(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(210213);
      kotlin.g.b.p.h(paramOnCancelListener, "cancelListener");
      c((Dialog)i.c(this.IMu));
      i.a(this.IMu, com.tencent.mm.ui.base.h.a(paramMMWebView.getActivityContextIfHas(), this.IMu.getContext().getString(2131763747), true, paramOnCancelListener));
      AppMethodBeat.o(210213);
    }
    
    public final void goBack()
    {
      AppMethodBeat.i(210212);
      Iterator localIterator = ((Iterable)this.IMu.IKd).iterator();
      while (localIterator.hasNext()) {
        ((j)localIterator.next()).gac();
      }
      AppMethodBeat.o(210212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.i
 * JD-Core Version:    0.7.0.1
 */