package com.tencent.mm.plugin.webview.core;

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
import com.tencent.mm.plugin.webview.j.i.b;
import com.tencent.mm.plugin.webview.model.ag.a;
import com.tencent.mm.plugin.webview.model.ag.b;
import com.tencent.mm.plugin.webview.model.ag.c;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.au;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.model.ay.b;
import com.tencent.mm.plugin.webview.model.ay.c;
import com.tencent.mm.plugin.webview.model.ay.e;
import com.tencent.mm.plugin.webview.model.ay.f;
import com.tencent.mm.plugin.webview.model.ay.j;
import com.tencent.mm.plugin.webview.model.ay.k;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import d.l;
import d.o;
import d.u;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "OauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1;", "ReaderShareHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;)V", "pageEndTime", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "kotlin.jvm.PlatformType", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "getWebviewReportMgr", "()Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "", "", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getCachedAppId", "getScene", "username", "getWebViewPluginClientProxy", "handleUrl", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "loadUrl", "httpHeaders", "withoutCache", "needSyncGetA8Key", "onBinded", "onDestroy", "onJsReady", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "overrideProcessResult", "resp", "overrideUrl", "webView", "removeSceneEnd", "requestSetFontSize", "fontSize", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "Companion", "SceneEndCallbacker", "VisitInfoReport", "plugin-webview_release"})
public class h
  extends BaseWebViewController
{
  public static final d Eaf;
  public String DZA;
  private final d.f DZB;
  private final String DZC;
  private final Set<String> DZD;
  private final d.f DZE;
  private com.tencent.mm.ui.base.p DZF;
  private final ag.c DZG;
  ag.a DZH;
  private long DZI;
  private final List<com.tencent.mm.plugin.webview.c.d.a> DZJ;
  private final l DZK;
  private final j DZL;
  private final e DZM;
  private final k DZN;
  private final n DZO;
  private final a DZP;
  private String DZQ;
  private final boolean DZR;
  private final s DZS;
  private final i DZT;
  private final r DZU;
  private final m DZV;
  private final g DZW;
  private final b DZX;
  private final o DZY;
  private final c DZZ;
  private final d.f DZs;
  private final d.f DZt;
  private final d.f DZu;
  private final d.f DZv;
  private final d.f DZw;
  public final ar DZx;
  private final d.f DZy;
  private final d.f DZz;
  private long Eaa;
  private final f Eab;
  private final h Eac;
  private com.tencent.luggage.xweb_ext.extendplugin.b.c Ead;
  public final ay Eae;
  private final d.f osd;
  
  static
  {
    AppMethodBeat.i(199318);
    Eaf = new d((byte)0);
    AppMethodBeat.o(199318);
  }
  
  public h(MMWebView paramMMWebView, ay paramay, BaseWebViewController.c paramc)
  {
    this(paramMMWebView, paramay, paramc, null);
    AppMethodBeat.i(199316);
    AppMethodBeat.o(199316);
  }
  
  public h(final MMWebView paramMMWebView, ay paramay, BaseWebViewController.c paramc, Set<String> paramSet)
  {
    super(paramMMWebView, paramc, paramSet);
    AppMethodBeat.i(199315);
    this.Eae = paramay;
    this.osd = d.g.O((d.g.a.a)new q(this));
    this.DZs = d.g.O((d.g.a.a)aj.EaK);
    this.DZt = d.g.O((d.g.a.a)new v(this));
    this.DZu = d.g.O((d.g.a.a)new x(this));
    this.DZv = d.g.O((d.g.a.a)new w(this));
    this.DZw = d.g.O((d.g.a.a)new ak(this));
    this.DZx = new ar(getContext());
    this.DZy = d.g.O((d.g.a.a)new y(this));
    this.DZz = d.g.O((d.g.a.a)new ai(this, paramMMWebView));
    this.DZB = d.g.O((d.g.a.a)ag.EaJ);
    this.DZC = "file:///android_asset/jsapi/wxjs.js";
    this.DZD = ((Set)new HashSet());
    this.DZE = d.g.O((d.g.a.a)new ah(this));
    this.DZG = ((ag.c)new z(this));
    this.DZH = ((ag.a)new aa(this));
    this.DZJ = ((List)new ArrayList());
    this.DZK = new l(this);
    this.DZL = new j(this);
    this.DZM = new e(this);
    this.DZN = new k(this);
    this.DZO = new n(this);
    this.DZP = new a(this);
    this.DZR = true;
    this.DZS = new s(this, paramMMWebView);
    this.DZT = new i(this);
    this.DZU = new r(this);
    this.DZV = new m(this);
    this.DZW = new g(this);
    this.DZX = new b(this);
    this.DZY = new o(this);
    this.DZZ = new c(this);
    this.Eab = new f(this, paramMMWebView);
    this.Eac = new h(this);
    AppMethodBeat.o(199315);
  }
  
  private final boolean aHG(String paramString)
  {
    AppMethodBeat.i(199306);
    if (bu.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "search contact err: null or nill url");
      AppMethodBeat.o(199306);
      return false;
    }
    eRs();
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", eRr().eQU());
    try
    {
      eQS().y(106, localBundle);
      AppMethodBeat.o(199306);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  private final boolean aHH(String paramString)
  {
    AppMethodBeat.i(199307);
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "dealCustomScheme, url = ".concat(String.valueOf(paramString)));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(199307);
      return false;
    }
    try
    {
      if (eQS().fK(paramString))
      {
        com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(paramString)));
        eQS().fW(paramString, eQU());
        AppMethodBeat.o(199307);
        return true;
      }
    }
    catch (Exception localException1)
    {
      com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      final Uri localUri = Uri.parse(paramString);
      Object localObject2;
      if ((localUri != null) && (!d.n.n.nF(paramString, "weixin://")) && (!d.n.n.nF(paramString, "http")))
      {
        if (d.n.n.nF(paramString, "tel:"))
        {
          paramString = d.n.n.h(paramString, "tel:", "", false);
          if (!bu.isNullOrNil(paramString)) {}
          try
          {
            eQS().fY(paramString, eQU());
            AppMethodBeat.o(199307);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
            }
          }
        }
        Object localObject1;
        if ((d.n.n.nF(paramString, "sms:")) || (d.n.n.nF(paramString, "smsto:")))
        {
          localObject1 = new Intent("android.intent.action.SENDTO", localUri);
          ((Intent)localObject1).addFlags(268435456);
          try
          {
            paramString = getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(199307);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "start sms app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        if (d.n.n.nF(paramString, "mailto:"))
        {
          paramString = new Intent("android.intent.action.SENDTO");
          paramString.addFlags(268435456);
          paramString.setData(localUri);
          try
          {
            localObject1 = getContext();
            paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahE(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)paramString.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(199307);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "start mailto app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        try
        {
          if ((!this.lzU.eUT().fka()) && (eQS().eVf()))
          {
            com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "dealCustomScheme, not allow outer open url");
            AppMethodBeat.o(199307);
            return true;
          }
          i = getIntent().getIntExtra("key_download_restrict", 0);
          localObject1 = getIntent().getStringExtra("key_function_id");
          if (!bu.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.g.yxI.f(14596, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(1) });
          }
          if (i == 1)
          {
            com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "not allow launch app by custom scheme : %s", new Object[] { paramString });
            AppMethodBeat.o(199307);
            return true;
          }
        }
        catch (RemoteException localRemoteException)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(getTAG(), (Throwable)localRemoteException, "", new Object[0]);
          long l = bu.aRi() - this.DZI;
          com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
          String str1;
          if (l <= 2L)
          {
            str1 = getCurrentUrl();
            localObject2 = str1;
          }
          try
          {
            str1 = com.tencent.mm.compatible.util.q.encode(str1, "UTF-8");
            localObject2 = str1;
            String str2 = com.tencent.mm.compatible.util.q.encode(paramString, "UTF-8");
            paramString = str2;
            localObject2 = str1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool;
              com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "formate url failed");
            }
            localObject2 = new Intent("android.intent.action.VIEW", localUri);
            ((Intent)localObject2).addFlags(268435456);
            if (!bu.aj(getContext(), (Intent)localObject2)) {
              break label1005;
            }
            paramString = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(199307);
            return true;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(13983, new Object[] { Integer.valueOf(4), localObject2, paramString });
          if (getIntent().getBooleanExtra("show_openapp_dialog", true))
          {
            bool = com.tencent.mm.ch.a.post((Runnable)new u(this, localUri));
            AppMethodBeat.o(199307);
            return bool;
          }
        }
      }
      label1005:
      AppMethodBeat.o(199307);
    }
    return false;
  }
  
  private boolean aHJ(String paramString)
  {
    AppMethodBeat.i(199310);
    d.g.b.p.h(paramString, "url");
    Iterator localIterator = this.DZJ.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.c.d.a locala = (com.tencent.mm.plugin.webview.c.d.a)localIterator.next();
      if (locala.aHK(paramString))
      {
        com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "url handled, url = ".concat(String.valueOf(paramString)));
        boolean bool = locala.aHJ(paramString);
        com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(199310);
        return true;
      }
    }
    AppMethodBeat.o(199310);
    return false;
  }
  
  private final String eRm()
  {
    AppMethodBeat.i(199278);
    if (!WZ(this.DYt))
    {
      AppMethodBeat.o(199278);
      return "";
    }
    String str = getIntent().getStringExtra("KPublisherId");
    AppMethodBeat.o(199278);
    return str;
  }
  
  private final t eRn()
  {
    AppMethodBeat.i(199279);
    t localt = (t)this.DZw.getValue();
    AppMethodBeat.o(199279);
    return localt;
  }
  
  private final com.tencent.mm.plugin.webview.ui.tools.c eRo()
  {
    AppMethodBeat.i(199281);
    com.tencent.mm.plugin.webview.ui.tools.c localc = (com.tencent.mm.plugin.webview.ui.tools.c)this.DZz.getValue();
    AppMethodBeat.o(199281);
    return localc;
  }
  
  private final com.tencent.mm.plugin.webview.modeltools.n eRp()
  {
    AppMethodBeat.i(199284);
    com.tencent.mm.plugin.webview.modeltools.n localn = (com.tencent.mm.plugin.webview.modeltools.n)this.DZB.getValue();
    AppMethodBeat.o(199284);
    return localn;
  }
  
  private final p eRr()
  {
    AppMethodBeat.i(199304);
    p localp = (p)this.DZE.getValue();
    AppMethodBeat.o(199304);
    return localp;
  }
  
  private final void eRs()
  {
    AppMethodBeat.i(199305);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 106);
      localBundle.putInt("scene_end_listener_hash_code", eRr().eQU());
      eQS().a(5, localBundle, eRr().eQU());
      AppMethodBeat.o(199305);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "addSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(199305);
    }
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(199274);
    String str = (String)this.osd.getValue();
    AppMethodBeat.o(199274);
    return str;
  }
  
  public final void Xb(int paramInt)
  {
    AppMethodBeat.i(199303);
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
    com.tencent.e.h.MqF.aM((Runnable)new af(this, i));
    AppMethodBeat.o(199303);
  }
  
  protected boolean Yz(String paramString)
  {
    return false;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(199295);
    String str = getTAG();
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i(str, "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (parame != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.f(getTAG(), "service connect success, while invoker is null");
      onFinish();
      AppMethodBeat.o(199295);
      return;
    }
    try
    {
      parame.a((com.tencent.mm.plugin.webview.stub.f)eRr(), eRr().eQU());
      super.a(parame);
      AppMethodBeat.o(199295);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "addCallback fail, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void a(WebView paramWebView, final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(199283);
    if (!WZ(this.DYt))
    {
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "onReceivedError, intent not ready");
      AppMethodBeat.o(199283);
      return;
    }
    Object localObject = ac.EaE;
    localObject = new ad(this);
    com.tencent.xweb.util.g.Aa(false);
    boolean bool = az.isConnected(getContext());
    com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(155L, com.tencent.mm.plugin.webview.h.a.XC(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.i.fr(eRm(), 1);
    com.tencent.mm.plugin.topstory.a.i.fr(eRm(), com.tencent.mm.plugin.webview.h.a.XC(paramInt));
    com.tencent.mm.plugin.topstory.a.i.g(eRm(), bRn(), com.tencent.mm.plugin.webview.h.a.XC(paramInt), this.Eae.eUo().enterTime);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    k.EtK.Yd(paramInt);
    this.Eae.eUw().errCode = paramInt;
    com.tencent.mm.plugin.webview.ui.tools.m localm = com.tencent.mm.plugin.webview.ui.tools.m.Euz;
    com.tencent.mm.plugin.webview.ui.tools.m.setErrCode(paramInt);
    if (((Boolean)this.DZv.getValue()).booleanValue()) {
      onFinish();
    }
    try
    {
      if (d.g.b.p.i(new URL(paramString2).getHost(), "mp.weixin.qq.com")) {
        com.tencent.e.h.MqF.f((Runnable)new ae(paramString2, paramInt, (ad)localObject, "mp.weixin.qq.com"), "WebViewUI.CheckDNS");
      }
      super.a(paramWebView, paramInt, paramString1, paramString2);
      AppMethodBeat.o(199283);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(getTAG(), (Throwable)localMalformedURLException, "check mp url", new Object[0]);
      }
    }
  }
  
  public final void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(199282);
    if (!WZ(this.DYt))
    {
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "onReceivedSslError, intent not ready");
      AppMethodBeat.o(199282);
      return;
    }
    com.tencent.xweb.util.g.Aa(true);
    String str;
    if (paramWebView != null)
    {
      str = paramWebView.getUrl();
      if (str != null) {
        break label213;
      }
      str = this.DXV;
      label59:
      if (str == null) {
        break label222;
      }
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      d.g.b.p.g(localObject, "MMKernel.service(IBrandService::class.java)");
      localObject = ((com.tencent.mm.plugin.brandservice.a.b)localObject).bOg();
      d.g.b.p.g(localObject, "MMKernel.service(IBrandS…::class.java).hardCodeUrl");
      if (!d.n.n.nF(str, (String)localObject)) {
        break label222;
      }
      str = bRn();
    }
    label213:
    label222:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.i.fr(eRm(), 1);
      com.tencent.mm.plugin.topstory.a.i.fr(eRm(), 30);
      com.tencent.mm.plugin.topstory.a.i.g(eRm(), bRn(), 30, this.Eae.eUo().enterTime);
      eRo().a(str, paramr, paramSslError);
      super.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(199282);
      return;
      str = null;
      break;
      str = paramWebView.getUrl();
      break label59;
    }
  }
  
  protected final boolean a(int paramInt, String paramString, avz paramavz)
  {
    AppMethodBeat.i(199293);
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavz, "resp");
    int i = paramavz.FJl;
    String str = paramavz.GNB;
    switch (i)
    {
    default: 
      boolean bool = super.a(paramInt, paramString, paramavz);
      AppMethodBeat.o(199293);
      return bool;
    case 3: 
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "getA8key-app: ".concat(String.valueOf(str)));
      paramString = (CharSequence)str;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "getA8key-app, fullUrl is null");
        AppMethodBeat.o(199293);
        return false;
      }
      aHH(str);
      AppMethodBeat.o(199293);
      return true;
    case 4: 
      d.g.b.p.g(str, "fullUrl");
      aHG(str);
      AppMethodBeat.o(199293);
      return true;
    }
    d.g.b.p.g(str, "fullUrl");
    eRs();
    paramString = new Bundle();
    paramString.putString("emoji_store_jump_url", str);
    paramString.putInt("webview_binder_id", eRr().eQU());
    try
    {
      eQS().y(666, paramString);
      AppMethodBeat.o(199293);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  /* Error */
  public final String aHD(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1219
    //   3: invokestatic 396	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 690	java/lang/CharSequence
    //   10: invokestatic 1225	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +118 -> 131
    //   16: new 587	android/os/Bundle
    //   19: dup
    //   20: invokespecial 588	android/os/Bundle:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w 661
    //   28: aload_0
    //   29: invokevirtual 699	com/tencent/mm/plugin/webview/core/h:eQU	()I
    //   32: invokevirtual 594	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: aload_2
    //   36: ldc_w 1227
    //   39: aload_1
    //   40: invokevirtual 659	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 608	com/tencent/mm/plugin/webview/core/h:eQS	()Lcom/tencent/mm/plugin/webview/stub/e;
    //   47: bipush 76
    //   49: aload_2
    //   50: invokeinterface 1231 3 0
    //   55: ldc_w 1233
    //   58: invokevirtual 1236	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 1239	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 1241
    //   69: invokestatic 1178	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokespecial 581	com/tencent/mm/plugin/webview/core/h:getTAG	()Ljava/lang/String;
    //   76: ldc_w 1243
    //   79: iconst_1
    //   80: anewarray 733	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 875	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 1219
    //   93: invokestatic 405	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: ldc_w 723
    //   102: astore_1
    //   103: aload_0
    //   104: invokespecial 581	com/tencent/mm/plugin/webview/core/h:getTAG	()Ljava/lang/String;
    //   107: ldc_w 1245
    //   110: iconst_1
    //   111: anewarray 733	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: invokevirtual 1246	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 736	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -34 -> 90
    //   127: astore_2
    //   128: goto -25 -> 103
    //   131: ldc_w 723
    //   134: astore_1
    //   135: goto -45 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	h
    //   0	138	1	paramString	String
    //   23	27	2	localBundle	Bundle
    //   98	19	2	localThrowable1	Throwable
    //   127	1	2	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	72	98	java/lang/Throwable
    //   72	90	127	java/lang/Throwable
  }
  
  public final int aHI(String paramString)
  {
    AppMethodBeat.i(199309);
    int j = getIntent().getIntExtra("geta8key_scene", 0);
    int i = j;
    Object localObject;
    if (j == 0)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label97;
      }
      i = 1;
      if (i != 0) {
        break label242;
      }
    }
    for (;;)
    {
      try
      {
        bool = WZ(this.DYs);
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        label97:
        com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "getScene fail, ex = " + paramString.getMessage());
        i = 1;
        continue;
        i = 1;
        continue;
      }
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(199309);
      return i;
      i = 0;
      break;
      if (eQS().AZ(paramString))
      {
        i = 8;
      }
      else
      {
        if (eQS().Ao(paramString))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("enterprise_biz_username", paramString);
          try
          {
            paramString = eQS().k(102, (Bundle)localObject);
            if (paramString != null)
            {
              bool = paramString.getBoolean("is_enterprise_username");
              if (!bool) {}
            }
          }
          catch (RemoteException paramString)
          {
            com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "invoke the check enterprise failed");
            continue;
          }
          i = 7;
          continue;
        }
        label242:
        i = 0;
      }
    }
  }
  
  protected final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(199288);
    d.g.b.p.h(paramWebView, "webview");
    d.g.b.p.h(paramWebResourceRequest, "request");
    if ((isStarted()) && (WZ(this.DYs)))
    {
      Object localObject = this.DZx;
      String str = paramWebResourceRequest.getUrl().toString();
      if (!((Boolean)this.DZy.getValue()).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = ((ar)localObject).a(str, paramWebResourceRequest, bool, eQS());
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(199288);
        return localObject;
      }
    }
    paramWebView = super.b(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(199288);
    return paramWebView;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(199287);
    super.b(paramWebView, paramString);
    this.DYj.bM("onPageFinished", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.osM, paramString);
    if (Yz(paramString))
    {
      AppMethodBeat.o(199287);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "edw onPageFinished opt, url = %s", new Object[] { paramString });
    this.Eae.eUv().cF(paramString);
    k.EtK.CD();
    eRp().EL(paramString);
    boolean bool = getIntent().getBooleanExtra("shouldForceViewPort", false);
    com.tencent.mm.sdk.platformtools.ae.d(getTAG(), "hy: shouldForceViewPort: ".concat(String.valueOf(bool)));
    Object localObject;
    if (bool)
    {
      localObject = getIntent().getStringExtra("view_port_code");
      if (paramWebView == null) {
        d.g.b.p.gkB();
      }
      paramWebView.evaluateJavascript((String)localObject, null);
    }
    if (paramString == null) {
      d.g.b.p.gkB();
    }
    if (aHC(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.f(getTAG(), "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(199287);
      return;
    }
    if (d.g.b.p.i(paramString, this.DZC))
    {
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "onPageFinished, js is finished loaded");
      AppMethodBeat.o(199287);
      return;
    }
    this.Eae.eUl().aJd(paramString);
    this.Eae.eUm().aJb(paramString);
    this.Eae.eUp().report();
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      localObject = paramWebView.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.Eae.eUw().xht = ((SnsAdClick)localObject);
        localObject = this.Eae.eUw();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.p.g(paramWebView, "uxInfo");
        ((au)localObject).R(new String[] { paramString, "1", str, paramWebView });
        this.Eae.eUw().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.Euz;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, true);
    this.DZI = bu.aRi();
    AppMethodBeat.o(199287);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(199285);
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    super.b(paramWebView, paramString, paramBitmap);
    this.DYj.bM("onPageStarted", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.osM, paramString);
    if (Yz(paramString))
    {
      AppMethodBeat.o(199285);
      return;
    }
    if (!this.osM.supportFeature(2006)) {
      getJsapi().eSv();
    }
    com.tencent.mm.plugin.webview.j.j.h(paramString, getContext());
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "edw onPageStarted opt, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.i.fr(eRm(), 0);
    if ((com.tencent.mm.sdk.a.b.fnF()) && (d.g.b.p.i("http://www.dktest-mmcrash.com/", paramString))) {
      Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    }
    this.DZA = this.DXV;
    long l = bu.aRi();
    paramWebView = eRn();
    d.g.b.p.h(paramString, "targetUrl");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new h.t.a(paramWebView, paramString, l));
    this.Eae.eUn().EmD = this.DZA;
    this.DXV = paramString;
    k.EtK.cE(paramString);
    com.tencent.mm.sdk.platformtools.ae.d(getTAG(), "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { this.DZA, this.DXV });
    if (aHC(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.f(getTAG(), "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(199285);
      return;
    }
    eRp().EL(paramString);
    this.Eae.eUl().cB(bpW(), eRm()).aJc(paramString);
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      paramBitmap = paramWebView.getParcelable("KSnsAdTag");
      if ((paramBitmap != null) && ((paramBitmap instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.Eae.eUw().xht = ((SnsAdClick)paramBitmap);
        paramBitmap = this.Eae.eUw();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.p.g(paramWebView, "uxInfo");
        paramBitmap.R(new String[] { paramString, "0", str, paramWebView });
        this.Eae.eUw().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.Euz;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, false);
    AppMethodBeat.o(199285);
  }
  
  public final void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(199286);
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    this.DXV = paramString;
    super.b(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(199286);
  }
  
  public final boolean b(int paramInt, String paramString, avz paramavz)
  {
    AppMethodBeat.i(199291);
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavz, "response");
    Object localObject = paramavz.GNJ;
    if (localObject != null) {}
    for (long l = ((acv)localObject).GuD;; l = -1L)
    {
      this.Eaa = l;
      boolean bool = this.osM.getIsX5Kernel();
      localObject = paramavz.GNB;
      d.g.b.p.g(localObject, "response.FullURL");
      ay.aH(bool, d.n.n.nF((String)localObject, "https://"));
      this.Eae.eUk().cs(paramString, true);
      this.Eae.eUm().cA(com.tencent.mm.plugin.webview.ui.tools.game.h.dPU, eRm()).aIZ(paramavz.GNB);
      bool = super.b(paramInt, paramString, paramavz);
      AppMethodBeat.o(199291);
      return bool;
    }
  }
  
  protected final Class<? extends Service> bPH()
  {
    AppMethodBeat.i(199275);
    Class localClass = (Class)this.DZs.getValue();
    AppMethodBeat.o(199275);
    return localClass;
  }
  
  protected void bRt()
  {
    AppMethodBeat.i(199298);
    if (aHJ(bRn()))
    {
      AppMethodBeat.o(199298);
      return;
    }
    if (bRu())
    {
      BaseWebViewController.a(this, bRn(), false, 0, 6);
      AppMethodBeat.o(199298);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "terry onStartLoad:" + bRn());
    Object localObject3 = eQW();
    Object localObject1 = (CharSequence)localObject3;
    int i;
    if ((localObject1 == null) || (d.n.n.aD((CharSequence)localObject1))) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.ae.i(getTAG(), (String)localObject3);
        localObject1 = localObject3;
        if (getIntent().getBooleanExtra("QRDataFlag", true)) {}
        try
        {
          localObject1 = eQS().aJK((String)localObject3);
          localObject3 = this.osM.getSettings();
          d.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setUseWideViewPort(false);
          localObject3 = this.osM.getSettings();
          d.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setLoadWithOverviewMode(false);
          localObject3 = this.osM.getSettings();
          d.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setJavaScriptEnabled(false);
          vb(true);
          this.osM.loadDataWithBaseURL(null, (String)localObject1, "text/html", "utf-8", null);
          com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "loadDataWithBaseUrl, data = ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(199298);
          return;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "postBinded, formatQRString, ex = " + localException.getMessage());
            localObject2 = localObject3;
          }
        }
      }
    }
    if (aHC(bRn()))
    {
      com.tencent.mm.sdk.platformtools.ae.f(getTAG(), "postBinded 2, canLoadUrl fail, url = " + bRn());
      AppMethodBeat.o(199298);
      return;
    }
    if (this.DYS.DZa) {
      this.lzU.a(bRn(), null, null);
    }
    Object localObject2 = ((Iterable)this.DYk).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((j)((Iterator)localObject2).next()).aHQ(bRn()))
      {
        AppMethodBeat.o(199298);
        return;
      }
    }
    if (this.osM.fPW())
    {
      AppMethodBeat.o(199298);
      return;
    }
    vb(false);
    BaseWebViewController.a(this, bRn(), null, 6);
    AppMethodBeat.o(199298);
  }
  
  protected boolean bRu()
  {
    AppMethodBeat.i(199299);
    Object localObject = ((Iterable)this.DYk).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((j)((Iterator)localObject).next()).aHR(bRn()))
      {
        AppMethodBeat.o(199299);
        return false;
      }
    }
    localObject = (CharSequence)getIntent().getStringExtra("data");
    if ((localObject == null) || (d.n.n.aD((CharSequence)localObject))) {}
    for (int i = 1; (i != 0) && (!this.DYS.DZa); i = 0)
    {
      AppMethodBeat.o(199299);
      return true;
    }
    AppMethodBeat.o(199299);
    return false;
  }
  
  protected final void bSg()
  {
    AppMethodBeat.i(199290);
    int j = 2;
    int i = j;
    try
    {
      if (eQS().eVf()) {
        if (!this.DYS.DYZ) {
          break label147;
        }
      }
      label147:
      for (i = com.tencent.mm.plugin.webview.j.f.a(getContext(), eQS(), bRn());; i = com.tencent.mm.plugin.webview.j.f.hj(getContext()))
      {
        Xb(i);
        String str = this.osM.getUrl();
        if (bu.isNullOrNil(str)) {
          break label210;
        }
        Object localObject = this.DZD;
        if (str == null) {
          d.g.b.p.gkB();
        }
        if (!((Set)localObject).add(str)) {
          break label210;
        }
        localObject = this.lzU.eUT();
        d.g.b.p.g(localObject, "wvPerm.genCtrl");
        if (((GeneralControlWrapper)localObject).fkd()) {
          getJsapi().eSq();
        }
        if (!((GeneralControlWrapper)localObject).fke()) {
          break;
        }
        getJsapi().vh(false);
        AppMethodBeat.o(199290);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "onLoadJsApiFinished, ex = " + localException.getMessage());
        i = j;
      }
      if (this.DZx.aIQ(localException)) {
        getJsapi().vh(true);
      }
      label210:
      super.bSg();
      AppMethodBeat.o(199290);
    }
  }
  
  public final int bpW()
  {
    AppMethodBeat.i(199308);
    int i = aHI(getIntent().getStringExtra("geta8key_username"));
    AppMethodBeat.o(199308);
    return i;
  }
  
  protected final Set<String> eQQ()
  {
    AppMethodBeat.i(199276);
    Set localSet = (Set)this.DZt.getValue();
    AppMethodBeat.o(199276);
    return localSet;
  }
  
  protected final void eQZ()
  {
    AppMethodBeat.i(199313);
    if (this.Ead != null)
    {
      AppMethodBeat.o(199313);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "WebView-Trace setWebViewPluginClient");
    this.Ead = com.tencent.luggage.xweb_ext.extendplugin.d.a((WebView)this.osM, (com.tencent.luggage.xweb_ext.extendplugin.b.d)com.tencent.luggage.xweb_ext.extendplugin.b.b.GS(), (com.tencent.luggage.xweb_ext.extendplugin.a.c)com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g.eYW(), null);
    AppMethodBeat.o(199313);
  }
  
  public final boolean eRa()
  {
    AppMethodBeat.i(199296);
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "edw onServiceDisconnected");
    Iterator localIterator = ((Iterable)this.DYk).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((j)localIterator.next()).eRz());
    for (int i = 1; i == 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "maybe mm process crash, try rebind service");
      AppMethodBeat.o(199296);
      return true;
    }
    boolean bool = super.eRa();
    AppMethodBeat.o(199296);
    return bool;
  }
  
  protected final void eRe()
  {
    AppMethodBeat.i(199294);
    super.eRe();
    com.tencent.mm.plugin.webview.h.b.eVb();
    Object localObject = ((Iterable)this.DYm).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((i)((Iterator)localObject).next()).a(this.DYj);
    }
    localObject = this.DYj;
    MMWebView localMMWebView = this.osM;
    d.g.a.a locala = (d.g.a.a)new ab(this);
    d.g.b.p.h(localMMWebView, "webView");
    d.g.b.p.h(locala, "callback");
    localMMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", (ValueCallback)new i.b((com.tencent.mm.plugin.webview.j.i)localObject, locala));
    AppMethodBeat.o(199294);
  }
  
  protected final void eRf()
  {
    AppMethodBeat.i(199314);
    com.tencent.mm.sdk.platformtools.ae.d(getTAG(), "setGetA8KeyParams");
    Object localObject = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_req");
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_resp");
    if ((localObject != null) && (arrayOfByte != null))
    {
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "set outer get A8key result");
      eQR().k((byte[])localObject, arrayOfByte);
    }
    localObject = getIntent().getStringExtra("geta8key_username");
    eQR().setUsername((String)localObject);
    eQR().setScene(aHI((String)localObject));
    eQR().setAppId(getIntent().getStringExtra("geta8key_open_webview_appid"));
    localObject = this.osM;
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((MMWebView)localObject).getIsX5Kernel());
      if (!((Boolean)localObject).booleanValue()) {
        break label233;
      }
      eQR().setFlag(1);
    }
    for (;;)
    {
      eQR().ag(getIntent().getByteArrayExtra("geta8key_cookie"));
      eQR().Xw(getIntent().getIntExtra("key_wallet_region", 0));
      eQR().aJw(getIntent().getStringExtra("key_function_id"));
      int i = getIntent().getIntExtra("geta8key_session_id", 0);
      if (i > 0) {
        eQR().Ap(i);
      }
      AppMethodBeat.o(199314);
      return;
      localObject = null;
      break;
      label233:
      eQR().setFlag(0);
    }
  }
  
  public final boolean eRq()
  {
    AppMethodBeat.i(199301);
    Object localObject = getIntent().getStringExtra("srcUsername");
    String str = getIntent().getStringExtra("bizofstartfrom");
    localObject = (CharSequence)localObject;
    if ((localObject == null) || (d.n.n.aD((CharSequence)localObject))) {}
    for (int i = 1; (i == 0) && (d.g.b.p.i(str, "enterpriseHomeSubBrand")); i = 0)
    {
      AppMethodBeat.o(199301);
      return true;
    }
    AppMethodBeat.o(199301);
    return false;
  }
  
  protected final void eag()
  {
    AppMethodBeat.i(199297);
    if (eRb())
    {
      com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "onBinded call when activity has been finished");
      AppMethodBeat.o(199297);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "Abe-Debug onPostBindedStart");
    this.DYj.bM("onPostBindedStart", System.currentTimeMillis());
    k.EtK.b(eQS());
    Object localObject1 = getIntent().getStringExtra("ad_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = k.EtK;
      d.g.b.p.g(localObject2, "WebViewReportUtil.INSTANCE");
      ((k)localObject2).setTraceId((String)localObject1);
    }
    this.DYj.bM("onJSAPIStart", System.currentTimeMillis());
    localObject1 = getIntent().getBundleExtra("jsapiargs");
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    for (;;)
    {
      ((Bundle)localObject1).putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
      ((Bundle)localObject1).putString("key_function_id", getIntent().getStringExtra("key_function_id"));
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "KDownloadRestrict = %d, KFunctionID = %s", new Object[] { Integer.valueOf(((Bundle)localObject1).getInt("key_download_restrict", 0)), ((Bundle)localObject1).getString("key_function_id", "") });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBundle("jsapiargs", (Bundle)localObject1);
      ((Bundle)localObject2).putCharSequence("bizofstartfrom", (CharSequence)getIntent().getStringExtra("bizofstartfrom"));
      ((Bundle)localObject2).putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
      ((Bundle)localObject2).putInt("screen_orientation", getScreenOrientation());
      try
      {
        eQS().a(20, (Bundle)localObject2, eQU());
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
        aw localaw = this.Eae.eUn();
        localaw.username = ((String)localObject3);
        localaw.EmE = i;
        localaw.dLz = bRn();
        localaw.EmA = j;
        localaw.scene = aHI((String)localObject3);
        localaw.Emz = l;
        localaw.EmB = new com.tencent.mm.b.p(l).toString();
        localaw.EfG = str1;
        localaw.Emy = ((String)localObject2);
        localaw.hFX = str2;
        localaw.appId = str4;
        localaw.EmC = str5;
        localaw.EmD = this.DZA;
        localaw.AiG = ((String)localObject1);
        localObject2 = getTitle();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localaw.title = ((String)localObject1);
        localaw.fmw = str3;
        localObject2 = getIntent().getStringExtra("share_report_pre_msg_desc");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localaw.desc = ((String)localObject2);
        localObject1 = this.Eae.eUo();
        ((com.tencent.mm.plugin.webview.model.ak)localObject1).hFX = str2;
        ((com.tencent.mm.plugin.webview.model.ak)localObject1).scene = aHI((String)localObject3);
        this.Eae.eUq().aIY(bRn());
        if (!eRq()) {}
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
            eQS().a(29, (Bundle)localObject1, eQU());
            label731:
            if (!bu.isNullOrNil(str1)) {}
            try
            {
              eQS().aJP(str1);
              try
              {
                i = getIntent().getIntExtra("pay_channel", -1);
                if (i == -1) {
                  break label1538;
                }
                com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "hy: found channel in intent. pay channel: %d", new Object[] { Integer.valueOf(i) });
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "hy: init pay channel failed");
                  continue;
                  i = 0;
                  continue;
                  localObject3 = (CharSequence)str1;
                  if ((localObject3 == null) || (d.n.n.aD((CharSequence)localObject3))) {}
                  for (i = 1; i == 0; i = 0)
                  {
                    localRemoteException.put("srcUsername", str1);
                    break;
                  }
                  i = 3;
                  com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "default pay scene to: %s", new Object[] { Integer.valueOf(3) });
                }
                if (!this.osM.getIsX5Kernel()) {
                  break label1842;
                }
                com.tencent.mm.pluginsdk.ui.tools.p.md(7);
                com.tencent.mm.plugin.report.service.g.yxI.a(64, 64, 1, 0, 1, 1, false);
                try
                {
                  i = bu.getInt(eQS().aJO("WebviewDisableDigestVerify"), 0);
                  com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
                  if (i != 0) {
                    break label1806;
                  }
                  SharedPreferences localSharedPreferences = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                  d.g.b.p.g(localSharedPreferences, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
                  if ((!localSharedPreferences.getBoolean("wvsha1", true)) || (!this.DYS.DYY)) {
                    break label1806;
                  }
                  getJsapi().eSh();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    for (;;)
                    {
                      eQS().a(bRn(), true, null);
                      this.DYj.bM("onPostBindedEnd", System.currentTimeMillis());
                      AppMethodBeat.o(199297);
                      return;
                      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(64L, 0L, 1L, false);
                    }
                    localException3 = localException3;
                    com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "getting js digest verification config fails, ex = " + localException3.getMessage());
                    i = 0;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "postBinded, jumpToActivity, ex = " + localException4.getMessage());
                    }
                  }
                }
              }
              this.DZJ.clear();
              localObject1 = getJsapi();
              str1 = getIntent().getStringExtra("geta8key_username");
              localObject2 = d.a.ae.b(new o[] { u.R("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0L))), u.R("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), u.R("scene", Integer.valueOf(aHI(str1))), u.R("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), u.R("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), u.R("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))) });
              localObject3 = (CharSequence)getIntent().getStringExtra("srcUsername");
              if ((localObject3 == null) || (d.n.n.aD((CharSequence)localObject3)))
              {
                i = 1;
                if (i != 0) {
                  break label1609;
                }
                ((Map)localObject2).putAll((Map)d.a.ae.c(new o[] { u.R("srcUsername", getIntent().getStringExtra("srcUsername")), u.R("srcDisplayname", getIntent().getStringExtra("srcDisplayname")) }));
                if (!bu.isNullOrNil(getIntent().getStringExtra("KTemplateId")))
                {
                  str1 = getIntent().getStringExtra("KTemplateId");
                  d.g.b.p.g(str1, "intent.getStringExtra(Co…UI.WebViewUI.KTemplateId)");
                  ((Map)localObject2).put("KTemplateId", str1);
                }
                i = getIntent().getIntExtra("pay_scene", -1);
                if (i == -1) {
                  break label1656;
                }
                com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "get pay scene from extra: %s", new Object[] { Integer.valueOf(i) });
                ((Map)localObject2).put("pay_scene", Integer.valueOf(i));
                ((com.tencent.mm.plugin.webview.c.f)localObject1).bC((Map)localObject2);
                localObject1 = this.DZJ;
                localObject2 = (List)new ArrayList();
                ((List)localObject2).add(getJsapi());
                ((List)localObject2).add(this.DZK);
                ((List)localObject2).add(this.DZL);
                ((List)localObject2).add(this.DZM);
                ((List)localObject2).add(this.DZN);
                ((List)localObject2).add(this.DZO);
                ((List)localObject2).add(this.DZP);
                ((List)localObject2).add(this.DZS);
                ((List)localObject2).add(this.DZV);
                ((List)localObject2).add(this.DZW);
                ((List)localObject2).add(this.DZX);
                ((List)localObject2).add(this.DZZ);
                ((List)localObject2).add(this.DZU);
                ((List)localObject2).add(this.DZY);
                ((List)localObject2).add(this.DZT);
                if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
                  ((List)localObject2).add(this.Eac);
                }
                ((List)localObject2).add(this.Eab);
                ((List)localObject1).addAll((Collection)localObject2);
                com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "Abe-Debug controllerListeners call, size = %d", new Object[] { Integer.valueOf(this.DYm.size()) });
                localObject1 = ((Iterable)this.DYm).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  ((i)((Iterator)localObject1).next()).eag();
                  continue;
                  localRemoteException = localRemoteException;
                  com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + localRemoteException.getMessage());
                }
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "postBinded, fail triggerGetContact, ex = " + localException1.getMessage());
                continue;
                i = eQS().eVt();
                if (i != -1)
                {
                  com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "hy: found channel in channel helper. pay channel: %d", new Object[] { Integer.valueOf(i) });
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
  
  public final String getTitle()
  {
    AppMethodBeat.i(199277);
    Object localObject2 = this.osM.getTitle();
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
    AppMethodBeat.o(199277);
    return localObject1;
  }
  
  public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy()
  {
    AppMethodBeat.i(199312);
    if (this.Ead == null) {
      eQZ();
    }
    com.tencent.luggage.xweb_ext.extendplugin.b.c localc = this.Ead;
    AppMethodBeat.o(199312);
    return localc;
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(199280);
    d.g.b.p.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
    if (aHC(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.f(getTAG(), "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      super.h(paramWebView, paramString);
      AppMethodBeat.o(199280);
      return;
    }
    this.Eae.eUm().aJa(paramString);
    super.h(paramWebView, paramString);
    AppMethodBeat.o(199280);
  }
  
  protected final boolean l(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(199289);
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramString, "url");
    com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "WebView-Trace shouldOverride url = ".concat(String.valueOf(paramString)));
    Object localObject1 = k(paramWebView, paramString);
    boolean bool;
    if (((j.a)localObject1).EaN)
    {
      bool = ((j.a)localObject1).result;
      AppMethodBeat.o(199289);
      return bool;
    }
    if (aHC(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.f(getTAG(), "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(199289);
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "about:blank", true))
    {
      com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "shouldOverride, url is about:blank");
      AppMethodBeat.o(199289);
      return true;
    }
    if (DownloadChecker.a(paramString, eRm(), paramWebView))
    {
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "use the downloader to download");
      AppMethodBeat.o(199289);
      return true;
    }
    try
    {
      if ((com.tencent.luggage.h.c.a(paramString, "weixin://jump/", true)) || (com.tencent.luggage.h.c.a(paramString, "weixin://scanqrcode/", true)))
      {
        d.g.b.p.h(paramString, "url");
        bool = getIntent().getBooleanExtra(e.m.JpJ, false);
        if ((this.lzU.eUT().fkb()) || (bool))
        {
          com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "allowJumpWithoutPerm: ".concat(String.valueOf(bool)));
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("fromScene", 100);
          if (eQS().a(paramString, this.lzU.eUS().mC(7), (Bundle)localObject1)) {
            com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "shouldOverride, built in url handled, url = ".concat(String.valueOf(paramString)));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(199289);
          return true;
          com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "shouldOverride, allow inner open url, not allow");
        }
      }
      Object localObject2;
      Object localObject3;
      int i;
      paramWebView = null;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.w(getTAG(), "shouldOverride, jumpToActivity, ex = " + localException.getMessage());
      while (aHJ(paramString))
      {
        AppMethodBeat.o(199289);
        return true;
        if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/business")) && (com.tencent.mm.pluginsdk.g.v(Uri.parse(paramString))))
        {
          localObject2 = Uri.parse(bRn());
          d.g.b.p.g(localObject2, "rawUrlUri");
          localObject3 = ((Uri)localObject2).getHost();
          localObject2 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
          ((Intent)localObject2).setData(Uri.parse(paramString + "&domain=" + (String)localObject3));
          i = ((Intent)localObject2).getIntExtra("pay_channel", -1);
          if (i != -1)
          {
            com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
            ((Intent)localObject2).putExtra("pay_channel", i);
          }
          ((Intent)localObject2).putExtra("translate_link_scene", 13);
          localObject3 = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(199289);
          return true;
        }
        if (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe"))
        {
          com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
        }
        else if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/common_view")) || (com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/phone_view")))
        {
          if (((com.tencent.luggage.h.c.A(bRn(), "https://support.weixin.qq.com/security")) || (com.tencent.luggage.h.c.A(paramString, "https://support.wechat.com/security"))) && (((Boolean)this.DZu.getValue()).booleanValue()))
          {
            com.tencent.mm.pluginsdk.g.bL(getContext(), paramString);
            onFinish();
            AppMethodBeat.o(199289);
            return true;
          }
        }
        else if ((com.tencent.luggage.h.c.A(paramString, "weixin://webview/initReady/")) || (com.tencent.luggage.h.c.A(paramString, "weixin://webview/preInjectJSBridge/")))
        {
          AppMethodBeat.o(199289);
          return true;
        }
      }
      if (com.tencent.luggage.h.c.A(paramString, "weixin://"))
      {
        com.tencent.mm.sdk.platformtools.ae.e(getTAG(), "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        AppMethodBeat.o(199289);
        return true;
      }
      com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "edw overrideUrl");
      if ((com.tencent.luggage.h.c.A(paramString, "weixinping://iframe")) || (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe")))
      {
        AppMethodBeat.o(199289);
        return true;
      }
      if (aHH(paramString))
      {
        com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "custom scheme url deal success, url = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(199289);
        return true;
      }
      if ((paramWebView instanceof MMWebView)) {}
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.model.a.a((MMWebView)paramWebView, paramString);
      AppMethodBeat.o(199289);
      return false;
    }
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(199300);
    d.g.b.p.h(paramString, "url");
    com.tencent.mm.plugin.webview.model.a.a(this.osM, paramString);
    super.loadUrl(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(199300);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199311);
    eRn().p("", bu.aRi(), 0);
    eRo().detach();
    if (eRq()) {}
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
      eQS().a(30, localBundle, eQU());
      try
      {
        label75:
        eQS().XQ(eRr().eQU());
        super.onDestroy();
        AppMethodBeat.o(199311);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.i(getTAG(), "onDestroy remove callbacker ex " + localException1.getMessage());
        }
      }
    }
    catch (Exception localException2)
    {
      break label75;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199207);
      d.g.b.p.h(paramString, "url");
      if (!this.Eag.lzU.eUT().fkb())
      {
        com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
        AppMethodBeat.o(199207);
        return true;
      }
      try
      {
        this.Eag.eQS().cu(paramString, this.Eag.lzU.eUS().mC(7));
        AppMethodBeat.o(199207);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.w(h.a(this.Eag), "ActivityJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199206);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199206);
        return false;
      }
      boolean bool = x.C(paramString, "weixin://jump/");
      AppMethodBeat.o(199206);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$oauthOnSceneEndDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"})
  public static final class aa
    implements ag.a
  {
    private final Map<Integer, Integer> EaD;
    
    aa()
    {
      AppMethodBeat.i(199259);
      this.EaD = ((Map)new HashMap());
      AppMethodBeat.o(199259);
    }
    
    public final void xj()
    {
      AppMethodBeat.i(199258);
      h.a(this.Eag, 1373);
      if (this.EaD.containsKey(Integer.valueOf(1373)))
      {
        Object localObject = this.EaD.get(Integer.valueOf(1373));
        if (localObject == null) {
          d.g.b.p.gkB();
        }
        int i = ((Number)localObject).intValue();
        this.EaD.put(Integer.valueOf(1373), Integer.valueOf(i - 1));
        AppMethodBeat.o(199258);
        return;
      }
      this.EaD.put(Integer.valueOf(1373), Integer.valueOf(0));
      AppMethodBeat.o(199258);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class ab
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    ab(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"getNetWorkTypeName", "", "context", "Landroid/content/Context;", "invoke"})
  static final class ac
    extends d.g.b.q
    implements d.g.a.b<Context, String>
  {
    public static final ac EaE;
    
    static
    {
      AppMethodBeat.i(199263);
      EaE = new ac();
      AppMethodBeat.o(199263);
    }
    
    ac()
    {
      super();
    }
    
    public static String gU(Context paramContext)
    {
      AppMethodBeat.i(199262);
      d.g.b.p.h(paramContext, "context");
      if (az.isWifi(paramContext))
      {
        AppMethodBeat.o(199262);
        return "wifi";
      }
      if (az.is5G(paramContext))
      {
        AppMethodBeat.o(199262);
        return "5g";
      }
      if (az.is4G(paramContext))
      {
        AppMethodBeat.o(199262);
        return "4g";
      }
      if (az.is3G(paramContext))
      {
        AppMethodBeat.o(199262);
        return "3g";
      }
      if (az.is2G(paramContext))
      {
        AppMethodBeat.o(199262);
        return "2g";
      }
      AppMethodBeat.o(199262);
      return "none";
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"dnsIps", "", "host", "invoke"})
  static final class ad
    extends d.g.b.q
    implements d.g.a.b<String, String>
  {
    ad(h paramh)
    {
      super();
    }
    
    public final String aHM(String paramString)
    {
      AppMethodBeat.i(199265);
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
            d.g.b.p.g(localObject, "inetAddressArr[i]");
            localStringBuilder.append(localObject.getHostAddress());
            localStringBuilder.append(";");
            i += 1;
          }
        }
        paramString = localStringBuilder.toString();
      }
      catch (UnknownHostException paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(h.a(this.Eag), (Throwable)paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(199265);
        return null;
      }
      AppMethodBeat.o(199265);
      return paramString;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(String paramString1, int paramInt, h.ad paramad, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(199266);
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
      String str = this.EaF;
      int i = paramInt;
      Object localObject = h.ac.EaE;
      localObject = com.tencent.mm.sdk.platformtools.ak.getContext();
      d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
      localg.f(17082, new Object[] { str, Integer.valueOf(i), h.ac.gU((Context)localObject), this.EaG.aHM(this.EaH) });
      AppMethodBeat.o(199266);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(h paramh, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(199267);
      this.Eag.getJsapi().Xc(i);
      Object localObject = this.Eag;
      int i = i;
      localObject = ((Iterable)((BaseWebViewController)localObject).DYm).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).Xc(i);
      }
      AppMethodBeat.o(199267);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "invoke"})
  static final class ag
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.webview.modeltools.n>
  {
    public static final ag EaJ;
    
    static
    {
      AppMethodBeat.i(199269);
      EaJ = new ag();
      AppMethodBeat.o(199269);
    }
    
    ag()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "invoke"})
  static final class ah
    extends d.g.b.q
    implements d.g.a.a<h.p>
  {
    ah(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "invoke"})
  static final class ai
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.webview.ui.tools.c>
  {
    ai(h paramh, MMWebView paramMMWebView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;", "invoke"})
  static final class aj
    extends d.g.b.q
    implements d.g.a.a<Class<WebViewStubService>>
  {
    public static final aj EaK;
    
    static
    {
      AppMethodBeat.i(199272);
      EaK = new aj();
      AppMethodBeat.o(199272);
    }
    
    aj()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "invoke"})
  static final class ak
    extends d.g.b.q
    implements d.g.a.a<h.t>
  {
    ak(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eah = "weixin://addfriend/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199209);
      d.g.b.p.h(paramString, "url");
      if (!this.Eag.lzU.eUS().mC(5))
      {
        com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "AddFriendHandler, permission fail");
        AppMethodBeat.o(199209);
        return true;
      }
      paramString = paramString.substring(this.Eah.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199209);
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_webview", true);
      localBundle.putString("userName", paramString);
      try
      {
        this.Eag.eQS().a(8, localBundle, this.Eag.eQU());
        AppMethodBeat.o(199209);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.w(h.a(this.Eag), "AddFriendHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199208);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199208);
        return false;
      }
      boolean bool = x.C(paramString, this.Eah);
      AppMethodBeat.o(199208);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eai = "weixin://webview/close/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199211);
      d.g.b.p.h(paramString, "url");
      if (!this.Eag.lzU.eUS().mC(17))
      {
        com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "close window permission fail");
        AppMethodBeat.o(199211);
        return true;
      }
      this.Eag.onFinish();
      AppMethodBeat.o(199211);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199210);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199210);
        return false;
      }
      boolean bool = x.C(paramString, this.Eai);
      AppMethodBeat.o(199210);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class e
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eaj = "weixin://critical_update/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199213);
      d.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 25L, 1L, true);
      h.b(this.Eag, 1);
      AppMethodBeat.o(199213);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199212);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199212);
        return false;
      }
      boolean bool = x.C(paramString, this.Eaj);
      AppMethodBeat.o(199212);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class f
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    f(MMWebView paramMMWebView) {}
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199215);
      d.g.b.p.h(paramString, "url");
      int i = this.Eag.aHI(bu.nullAsNil(h.i(this.Eag)));
      if (com.tencent.mm.pluginsdk.g.bL(paramString, h.j(this.Eag))) {}
      for (;;)
      {
        try
        {
          Object localObject;
          if (d.g.b.p.i("weixin://dl/shopping", paramString))
          {
            localObject = this.Eag.eQS().eVj();
            d.g.b.p.g(localObject, "invoker.getJDUrl()");
            if (!bu.isNullOrNil((String)localObject)) {
              BaseWebViewController.a(this.Eag, (String)localObject, null, 6);
            }
            localObject = (List)new ArrayList();
            ((List)localObject).add(paramString);
            ((List)localObject).add("1");
            ((List)localObject).add(String.valueOf(i));
            paramString = bu.nullAsNil(h.i(this.Eag));
            d.g.b.p.g(paramString, "Util.nullAsNil(sentUsername)");
            ((List)localObject).add(paramString);
            paramString = bu.nullAsNil(this.Eag.bRn());
            d.g.b.p.g(paramString, "Util.nullAsNil(rawUrl)");
            ((List)localObject).add(paramString);
            paramString = com.tencent.mm.plugin.report.service.g.yxI;
            com.tencent.mm.plugin.report.service.g.m(11405, (List)localObject);
            bool = true;
            AppMethodBeat.o(199215);
            return bool;
          }
          if (d.g.b.p.i("weixin://dl/faq", paramString))
          {
            int j = this.Eag.eQS().eVl();
            int k = this.Eag.eQS().eVm();
            localObject = com.tencent.mm.sdk.platformtools.ak.getContext().getString(2131763450, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            h localh = this.Eag;
            d.g.b.p.g(localObject, "rawUrl");
            BaseWebViewController.a(localh, (String)localObject, null, 6);
            continue;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          bool = true;
          continue;
          if (d.g.b.p.i("weixin://dl/posts", paramString))
          {
            this.Eag.eQS().eVn();
            continue;
          }
          if (d.g.b.p.i("weixin://dl/moments", paramString))
          {
            this.Eag.eQS().eVo();
            continue;
          }
          if (d.n.n.nF(paramString, "weixin://dl/feedback"))
          {
            d.g.b.p.g(this.Eag.eQS().aJT(paramString), "invoker.getFeedbackUrl(url)");
            continue;
          }
          if (d.g.b.p.i("weixin://dl/scan", paramString))
          {
            com.tencent.mm.br.d.c(this.Eag.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.g.bK(paramMMWebView.getActivityContextIfHas(), paramString);
          continue;
        }
        boolean bool = false;
      }
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199214);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199214);
        return false;
      }
      boolean bool = x.C(paramString, "weixin://");
      AppMethodBeat.o(199214);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eak = "weixin://feedback/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199217);
      d.g.b.p.h(paramString, "url");
      paramString = new Bundle();
      paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
      paramString.putInt("MMActivity.OverrideExitAnimation", 2130772106);
      try
      {
        this.Eag.eQS().a(7, paramString, this.Eag.eQU());
        AppMethodBeat.o(199217);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.w(h.a(this.Eag), "FeedbackJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199216);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199216);
        return false;
      }
      boolean bool = x.C(paramString, this.Eak);
      AppMethodBeat.o(199216);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eal = "weixin://connectToFreeWifi/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199219);
      d.g.b.p.h(paramString, "url");
      paramString = Uri.parse(paramString);
      String str1 = paramString.getQueryParameter("apKey");
      com.tencent.mm.sdk.platformtools.ae.i(h.a(this.Eag), "apKey value = %s", new Object[] { str1 });
      String str2 = paramString.getQueryParameter("ticket");
      if (!bu.isNullOrNil(str1))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("free_wifi_schema_uri", paramString.toString());
        localIntent.putExtra("free_wifi_ap_key", str1);
        localIntent.putExtra("free_wifi_source", 5);
        if (!bu.isNullOrNil(str2)) {
          localIntent.putExtra("free_wifi_schema_ticket", str2);
        }
        localIntent.addFlags(67108864);
        com.tencent.mm.br.d.b(com.tencent.mm.sdk.platformtools.ak.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
      }
      AppMethodBeat.o(199219);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199218);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199218);
        return false;
      }
      boolean bool = x.C(paramString, this.Eal);
      AppMethodBeat.o(199218);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class i
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eam = "weixin://gethtml/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199221);
      d.g.b.p.h(paramString, "url");
      if (!bu.isNullOrNil(paramString))
      {
        paramString = paramString.substring(this.Eam.length());
        d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        com.tencent.mm.sdk.platformtools.ae.i(h.a(this.Eag), "[oneliang]get html content :".concat(String.valueOf(paramString)));
        Object localObject = this.Eag;
        d.g.b.p.h(paramString, "html");
        localObject = ((Iterable)((BaseWebViewController)localObject).DYm).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).aHO(paramString);
        }
      }
      AppMethodBeat.o(199221);
      return false;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199220);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199220);
        return false;
      }
      boolean bool = x.C(paramString, this.Eam);
      AppMethodBeat.o(199220);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class j
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Ean = "weixin://profile/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199223);
      d.g.b.p.h(paramString, "url");
      paramString = paramString.substring(this.Ean.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "handleUrl fail, username is null");
        AppMethodBeat.o(199223);
        return true;
      }
      if (this.Eag.lzU.eUS().mC(2)) {
        this.Eag.getJsapi().aId(paramString);
      }
      AppMethodBeat.o(199223);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199222);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199222);
        return false;
      }
      boolean bool = x.C(paramString, this.Ean);
      AppMethodBeat.o(199222);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class k
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eao = "weixin://manual_update/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199225);
      d.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 26L, 1L, true);
      h.b(this.Eag, 3);
      AppMethodBeat.o(199225);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199224);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199224);
        return false;
      }
      boolean bool = x.C(paramString, this.Eao);
      AppMethodBeat.o(199224);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class l
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199227);
      d.g.b.p.h(paramString, "url");
      String str = this.Eag.getIntent().getStringExtra("geta8key_username");
      boolean bool = ag.b.a(paramString, str, this.Eag.aHI(str), this.Eag.eQS(), h.d(this.Eag), this.Eag.DZH, h.e(this.Eag).eQU(), this.Eag.getContext());
      AppMethodBeat.o(199227);
      return bool;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199226);
      d.g.b.p.h(paramString, "url");
      boolean bool = ag.b.fU(paramString, this.Eag.getIntent().getIntExtra("geta8key_scene", 0));
      AppMethodBeat.o(199226);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "READER_SHARE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "share", "", "plugin-webview_release"})
  public static final class m
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eap = "weixin://readershare/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199230);
      d.g.b.p.h(paramString, "url");
      paramString = this.Eag.getContext().getString(2131762183);
      d.g.b.p.g(paramString, "context.getString(R.string.readerapp_share_weibo)");
      Context localContext = this.Eag.getContext();
      com.tencent.mm.ui.base.h.c localc = (com.tencent.mm.ui.base.h.c)new a(this);
      com.tencent.mm.ui.base.h.a(localContext, "", new String[] { paramString }, "", localc);
      AppMethodBeat.o(199230);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199229);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199229);
        return false;
      }
      boolean bool = x.C(paramString, this.Eap);
      AppMethodBeat.o(199229);
      return bool;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "whichButton", "", "onClick"})
    static final class a
      implements com.tencent.mm.ui.base.h.c
    {
      a(h.m paramm) {}
      
      public final void lh(int paramInt)
      {
        AppMethodBeat.i(199228);
        if (paramInt == 0)
        {
          h.m localm = this.Eaq;
          try
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("shortUrl", localm.Eag.getIntent().getStringExtra("shortUrl"));
            localBundle.putInt("type", localm.Eag.getIntent().getIntExtra("type", 0));
            localm.Eag.eQS().a(4, localBundle, localm.Eag.eQU());
            AppMethodBeat.o(199228);
            return;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ae.e(h.a(localm.Eag), "share fail, ex = " + localException.getMessage());
          }
        }
        AppMethodBeat.o(199228);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class n
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Ear = "weixin://recommend_update/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199232);
      d.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 24L, 1L, true);
      h.b(this.Eag, 2);
      AppMethodBeat.o(199232);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199231);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199231);
        return false;
      }
      boolean bool = x.C(paramString, this.Ear);
      AppMethodBeat.o(199231);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class o
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eas = "weixin://openapi/openwebview/result?";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199234);
      d.g.b.p.h(paramString, "url");
      Object localObject = new OpenWebview.Resp();
      paramString = Uri.parse(paramString);
      d.g.b.p.g(paramString, "uri");
      ((OpenWebview.Resp)localObject).result = paramString.getQuery();
      ((OpenWebview.Resp)localObject).errCode = bu.getInt(paramString.getQueryParameter("errCode"), 0);
      ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
      ((OpenWebview.Resp)localObject).transaction = this.Eag.getIntent().getStringExtra("transaction_for_openapi_openwebview");
      paramString = paramString.getQueryParameter("appid");
      if (bu.isNullOrNil(paramString))
      {
        com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "SDKOpenWebViewResultHandler handleUrl, appId is null");
        AppMethodBeat.o(199234);
        return true;
      }
      Bundle localBundle = new Bundle();
      ((OpenWebview.Resp)localObject).toBundle(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bc(localBundle);
      localObject = new MMessageActV2.Args();
      try
      {
        ((MMessageActV2.Args)localObject).targetPkgName = this.Eag.eQS().aJM(paramString);
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        com.tencent.mm.sdk.platformtools.ae.d(h.a(this.Eag), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
        MMessageActV2.send(this.Eag.getContext(), (MMessageActV2.Args)localObject);
        this.Eag.onFinish();
        AppMethodBeat.o(199234);
        return true;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(h.a(this.Eag), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(199234);
      }
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199233);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199233);
        return false;
      }
      boolean bool = x.C(paramString, this.Eas);
      AppMethodBeat.o(199233);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"})
  static final class p
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    private final d.f DYf;
    private final h Eat;
    private final String TAG;
    
    public p(h paramh)
    {
      AppMethodBeat.i(199238);
      this.Eat = paramh;
      this.TAG = ("MicroMsg.WebViewController.SceneEndCallbacker:" + this.Eat.eQU());
      this.DYf = d.g.O((d.g.a.a)new a(this));
      AppMethodBeat.o(199238);
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      AppMethodBeat.i(199237);
      com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "onSceneEnd, instance hashcode = " + hashCode());
      h localh;
      if (paramd != null)
      {
        int i = paramd.getData().getInt("scene_end_listener_hash_code");
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(eQU()) });
        com.tencent.mm.sdk.platformtools.ae.i(this.TAG, "edw onSceneEnd, type = " + paramd.getType() + ", errCode = " + paramd.getErrCode() + ", errType = " + paramd.getErrType());
        if (i != eQU())
        {
          com.tencent.mm.sdk.platformtools.ae.e(this.TAG, "hash code not equal");
          AppMethodBeat.o(199237);
          return false;
        }
        localh = this.Eat;
        switch (paramd.getType())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(199237);
        return true;
        h.a(localh, 106);
        localh.onFinish();
        continue;
        h.a(localh, 666);
        localh.onFinish();
      }
    }
    
    public final int eQU()
    {
      AppMethodBeat.i(199236);
      int i = ((Number)this.DYf.getValue()).intValue();
      AppMethodBeat.o(199236);
      return i;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<Integer>
    {
      a(h.p paramp)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    q(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class r
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    final String Eam = "weixin://private/gethtml/";
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199241);
      d.g.b.p.h(paramString, "url");
      paramString = paramString.substring(this.Eam.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      try
      {
        paramString = URLDecoder.decode(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("nowUrl", h.f(this.Eag));
        localBundle.putString("tweetid", bu.nullAsNil(this.Eag.getIntent().getStringExtra("tweetid")));
        localBundle.putString("htmlData", paramString);
        localBundle.putInt("type", this.Eag.getIntent().getIntExtra("type", 0));
        this.Eag.eQS().a(3, localBundle, this.Eag.eQU());
        AppMethodBeat.o(199241);
        return true;
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(199241);
      }
      return false;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199240);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199240);
        return false;
      }
      boolean bool = x.C(paramString, this.Eam);
      AppMethodBeat.o(199240);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class s
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Eav = "weixin://viewimage/";
    
    s(MMWebView paramMMWebView) {}
    
    public final boolean aHJ(String paramString)
    {
      AppMethodBeat.i(199243);
      d.g.b.p.h(paramString, "url");
      try
      {
        if (!this.Eag.eQS().isSDCardAvailable())
        {
          this.Eag.eQS().a(2, null, this.Eag.eQU());
          AppMethodBeat.o(199243);
          return true;
        }
      }
      catch (Exception paramString)
      {
        com.tencent.mm.sdk.platformtools.ae.e(h.a(this.Eag), "edw handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(199243);
        return false;
      }
      h localh = this.Eag;
      paramString = paramString.substring(this.Eav.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      h.a(localh, paramString);
      com.tencent.mm.sdk.platformtools.ae.i(h.a(this.Eag), "viewimage currentUrl :" + h.f(this.Eag));
      x.a((WebView)paramMMWebView, h.g(this.Eag).Eam, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", h.h(this.Eag));
      AppMethodBeat.o(199243);
      return true;
    }
    
    public final boolean aHK(String paramString)
    {
      AppMethodBeat.i(199242);
      d.g.b.p.h(paramString, "url");
      if (bu.isNullOrNil(paramString))
      {
        AppMethodBeat.o(199242);
        return false;
      }
      boolean bool = x.C(paramString, this.Eav);
      AppMethodBeat.o(199242);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"})
  final class t
  {
    private final h Eat;
    private volatile String Eaw;
    private volatile String Eax;
    private int fromScene;
    private long lKd;
    private int networkType;
    private String userAgent;
    
    public t()
    {
      AppMethodBeat.i(199247);
      this.Eat = localObject;
      this$1 = this.Eat.osM.getSettings();
      d.g.b.p.g(h.this, "controller.viewWV.settings");
      this$1 = h.this.getUserAgentString();
      d.g.b.p.g(h.this, "controller.viewWV.settings.userAgentString");
      this.userAgent = h.this;
      this.fromScene = this.Eat.getIntent().getIntExtra("from_scence", 0);
      this.Eaw = "";
      this.Eax = "";
      AppMethodBeat.o(199247);
    }
    
    private void eRt()
    {
      AppMethodBeat.i(199245);
      Context localContext = this.Eat.getContext();
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
        localObject = this.Eat.getContext();
      }
      int i;
      if (az.isConnected((Context)localObject))
      {
        if (!az.isWifi((Context)localObject)) {
          break label108;
        }
        i = 1;
      }
      for (;;)
      {
        this.networkType = i;
        com.tencent.mm.sdk.platformtools.ae.i(h.a(h.this), "get networkType " + this.networkType);
        AppMethodBeat.o(199245);
        return;
        label108:
        if (az.is5G((Context)localObject)) {
          i = 5;
        } else if (az.is4G((Context)localObject)) {
          i = 4;
        } else if (az.is3G((Context)localObject)) {
          i = 3;
        } else if (az.is2G((Context)localObject)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
    
    public final void p(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(199246);
      d.g.b.p.h(paramString, "targetUrl");
      eRt();
      String str5 = this.Eat.aHD(this.Eax);
      if (this.fromScene != 0) {
        this.Eaw = " ";
      }
      boolean bool = this.Eat.lzU.eUT().fkf();
      com.tencent.mm.sdk.platformtools.ae.d(h.a(h.this), "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.lKd > 0L) && (h.b(h.this) > this.lKd) && (paramLong > h.b(h.this)) && (!TextUtils.isEmpty((CharSequence)str5)) && (bool))
      {
        l1 = h.b(h.this) - this.lKd;
        l2 = paramLong - h.b(h.this);
        com.tencent.mm.sdk.platformtools.ae.d(h.a(h.this), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.lKd), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.userAgent, this.Eax, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.Eaw });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(this.userAgent), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(this.Eax), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str4 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(this.Eaw), "UTF-8");
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
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace(h.a(h.this), (Throwable)localUnsupportedEncodingException, "", new Object[0]);
          String str2 = "";
          localObject4 = localObject1;
        }
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(13376, new Object[] { Long.valueOf(this.lKd), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.Eaw = this.Eax;
        this.Eax = paramString;
        this.lKd = paramLong;
      }
      AppMethodBeat.o(199246);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(h.t paramt, String paramString, long paramLong) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(199244);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.Eay.p(this.Eaz, this.EaA, this.EaB);
        AppMethodBeat.o(199244);
        return false;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(h paramh, Uri paramUri) {}
    
    public final void run()
    {
      AppMethodBeat.i(199248);
      com.tencent.mm.pluginsdk.model.app.h.i(this.Eag.getContext(), localUri);
      AppMethodBeat.o(199248);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/HashSet;", "", "invoke"})
  static final class v
    extends d.g.b.q
    implements d.g.a.a<HashSet<String>>
  {
    v(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.a<Boolean>
  {
    w(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.q
    implements d.g.a.a<Boolean>
  {
    x(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class y
    extends d.g.b.q
    implements d.g.a.a<Boolean>
  {
    y(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/core/WebViewController$oauthDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"})
  public static final class z
    implements ag.c
  {
    private static void c(Dialog paramDialog)
    {
      AppMethodBeat.i(199257);
      if ((paramDialog != null) && (paramDialog.isShowing()))
      {
        paramDialog.dismiss();
        paramDialog.setCancelMessage(null);
        paramDialog.setDismissMessage(null);
      }
      AppMethodBeat.o(199257);
    }
    
    public final void aHL(String paramString)
    {
      AppMethodBeat.i(199253);
      d.g.b.p.h(paramString, "url");
      this.Eag.k(paramString, true, 9);
      AppMethodBeat.o(199253);
    }
    
    public final void ciY()
    {
      AppMethodBeat.i(199256);
      c((Dialog)h.c(this.Eag));
      AppMethodBeat.o(199256);
    }
    
    public final void d(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(199255);
      d.g.b.p.h(paramOnCancelListener, "cancelListener");
      c((Dialog)h.c(this.Eag));
      h.a(this.Eag, com.tencent.mm.ui.base.h.b(this.Eag.getContext(), this.Eag.getContext().getString(2131761776), true, paramOnCancelListener));
      AppMethodBeat.o(199255);
    }
    
    public final void goBack()
    {
      AppMethodBeat.i(199254);
      Iterator localIterator = ((Iterable)this.Eag.DYm).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).eRv();
      }
      AppMethodBeat.o(199254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.h
 * JD-Core Version:    0.7.0.1
 */