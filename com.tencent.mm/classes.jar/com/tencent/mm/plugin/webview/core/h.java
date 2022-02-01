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
import com.tencent.mm.plugin.webview.model.ag.a;
import com.tencent.mm.plugin.webview.model.ag.b;
import com.tencent.mm.plugin.webview.model.ag.c;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.at;
import com.tencent.mm.plugin.webview.model.av;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.ax.b;
import com.tencent.mm.plugin.webview.model.ax.c;
import com.tencent.mm.plugin.webview.model.ax.e;
import com.tencent.mm.plugin.webview.model.ax.f;
import com.tencent.mm.plugin.webview.model.ax.j;
import com.tencent.mm.plugin.webview.model.ax.k;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import d.a.ae;
import d.g.b.w;
import d.o;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "OauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1;", "ReaderShareHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;)V", "pageEndTime", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "kotlin.jvm.PlatformType", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "", "", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getCachedAppId", "getScene", "username", "getWebViewPluginClientProxy", "handleUrl", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "needSyncGetA8Key", "onBinded", "onDestroy", "onJsReady", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "overrideProcessResult", "resp", "overrideUrl", "webView", "removeSceneEnd", "requestSetFontSize", "fontSize", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "Companion", "SceneEndCallbacker", "VisitInfoReport", "plugin-webview_release"})
public class h
  extends BaseWebViewController
{
  public static final d AMK;
  private final d.f ALX;
  private final d.f ALY;
  private final d.f ALZ;
  private final m AMA;
  private final g AMB;
  private final b AMC;
  private final o AMD;
  private final c AME;
  private long AMF;
  private final f AMG;
  private final h AMH;
  public com.tencent.luggage.k.a.c.c AMI;
  private final ax AMJ;
  private final d.f AMa;
  private final d.f AMb;
  public final aq AMc;
  private final d.f AMd;
  private final d.f AMe;
  public String AMf;
  private final d.f AMg;
  private final String AMh;
  private final Set<String> AMi;
  private final d.f AMj;
  private com.tencent.mm.ui.base.p AMk;
  private final ag.c AMl;
  ag.a AMm;
  private long AMn;
  private final List<com.tencent.mm.plugin.webview.c.d.a> AMo;
  private final l AMp;
  private final j AMq;
  private final e AMr;
  private final k AMs;
  private final n AMt;
  private final a AMu;
  private String AMv;
  private final boolean AMw;
  private final s AMx;
  private final i AMy;
  private final r AMz;
  private final d.f ngR;
  
  static
  {
    AppMethodBeat.i(188824);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "TAG", "getTAG()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "stubService", "getStubService()Ljava/lang/Class;")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "fileUrlWhiteList", "getFileUrlWhiteList()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "isFromLoginHistory", "isFromLoginHistory()Z")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "finishIfLoadFailed", "getFinishIfLoadFailed()Z")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "visitInfoReport", "getVisitInfoReport()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "neverBlockLocalRequest", "getNeverBlockLocalRequest()Z")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "sslErrorHandler", "getSslErrorHandler()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "routeUrlMap", "getRouteUrlMap()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;")), (d.l.k)w.a(new d.g.b.u(w.bk(h.class), "sceneCallbacker", "getSceneCallbacker()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;")) };
    AMK = new d((byte)0);
    AppMethodBeat.o(188824);
  }
  
  public h(MMWebView paramMMWebView, ax paramax, BaseWebViewController.c paramc)
  {
    this(paramMMWebView, paramax, paramc, null);
    AppMethodBeat.i(188865);
    AppMethodBeat.o(188865);
  }
  
  public h(final MMWebView paramMMWebView, ax paramax, BaseWebViewController.c paramc, Set<String> paramSet)
  {
    super(paramMMWebView, paramc, paramSet);
    AppMethodBeat.i(188864);
    this.AMJ = paramax;
    this.ngR = d.g.E((d.g.a.a)new q(this));
    this.ALX = d.g.E((d.g.a.a)aj.ANq);
    this.ALY = d.g.E((d.g.a.a)new v(this));
    this.ALZ = d.g.E((d.g.a.a)new x(this));
    this.AMa = d.g.E((d.g.a.a)new w(this));
    this.AMb = d.g.E((d.g.a.a)new ak(this));
    this.AMc = new aq(getContext());
    this.AMd = d.g.E((d.g.a.a)new y(this));
    this.AMe = d.g.E((d.g.a.a)new ai(this, paramMMWebView));
    this.AMg = d.g.E((d.g.a.a)ag.ANp);
    this.AMh = "file:///android_asset/jsapi/wxjs.js";
    this.AMi = ((Set)new HashSet());
    this.AMj = d.g.E((d.g.a.a)new ah(this));
    this.AMl = ((ag.c)new z(this));
    this.AMm = ((ag.a)new aa(this));
    this.AMo = ((List)new ArrayList());
    this.AMp = new l(this);
    this.AMq = new j(this);
    this.AMr = new e(this);
    this.AMs = new k(this);
    this.AMt = new n(this);
    this.AMu = new a(this);
    this.AMw = true;
    this.AMx = new s(this, paramMMWebView);
    this.AMy = new i(this);
    this.AMz = new r(this);
    this.AMA = new m(this);
    this.AMB = new g(this);
    this.AMC = new b(this);
    this.AMD = new o(this);
    this.AME = new c(this);
    this.AMG = new f(this, paramMMWebView);
    this.AMH = new h(this);
    AppMethodBeat.o(188864);
  }
  
  private final boolean avA(String paramString)
  {
    AppMethodBeat.i(188857);
    ad.i(getTAG(), "dealCustomScheme, url = ".concat(String.valueOf(paramString)));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(188857);
      return false;
    }
    try
    {
      if (eiX().eT(paramString))
      {
        ad.i(getTAG(), "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(paramString)));
        eiX().fg(paramString, eiZ());
        AppMethodBeat.o(188857);
        return true;
      }
    }
    catch (Exception localException1)
    {
      ad.w(getTAG(), "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      final Uri localUri = Uri.parse(paramString);
      Object localObject2;
      if ((localUri != null) && (!d.n.n.mA(paramString, "weixin://")) && (!d.n.n.mA(paramString, "http")))
      {
        if (d.n.n.mA(paramString, "tel:"))
        {
          paramString = d.n.n.h(paramString, "tel:", "", false);
          if (!bt.isNullOrNil(paramString)) {}
          try
          {
            eiX().fi(paramString, eiZ());
            AppMethodBeat.o(188857);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ad.w(getTAG(), "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
            }
          }
        }
        Object localObject1;
        if ((d.n.n.mA(paramString, "sms:")) || (d.n.n.mA(paramString, "smsto:")))
        {
          localObject1 = new Intent("android.intent.action.SENDTO", localUri);
          ((Intent)localObject1).addFlags(268435456);
          try
          {
            paramString = getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(188857);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ad.e(getTAG(), "start sms app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        if (d.n.n.mA(paramString, "mailto:"))
        {
          paramString = new Intent("android.intent.action.SENDTO");
          paramString.addFlags(268435456);
          paramString.setData(localUri);
          try
          {
            localObject1 = getContext();
            paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.adn(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)paramString.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(188857);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ad.e(getTAG(), "start mailto app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        try
        {
          if ((!this.kxg.emS().eBL()) && (eiX().enj()))
          {
            ad.e(getTAG(), "dealCustomScheme, not allow outer open url");
            AppMethodBeat.o(188857);
            return true;
          }
          i = getIntent().getIntExtra("key_download_restrict", 0);
          localObject1 = getIntent().getStringExtra("key_function_id");
          if (!bt.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.h.vKh.f(14596, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(1) });
          }
          if (i == 1)
          {
            ad.e(getTAG(), "not allow launch app by custom scheme : %s", new Object[] { paramString });
            AppMethodBeat.o(188857);
            return true;
          }
        }
        catch (RemoteException localRemoteException)
        {
          ad.printErrStackTrace(getTAG(), (Throwable)localRemoteException, "", new Object[0]);
          long l = bt.aGK() - this.AMn;
          ad.i(getTAG(), "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
          String str1;
          if (l <= 2L)
          {
            str1 = getCurrentUrl();
            localObject2 = str1;
          }
          try
          {
            str1 = com.tencent.mm.compatible.util.p.encode(str1, "UTF-8");
            localObject2 = str1;
            String str2 = com.tencent.mm.compatible.util.p.encode(paramString, "UTF-8");
            paramString = str2;
            localObject2 = str1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              boolean bool;
              ad.i(getTAG(), "formate url failed");
            }
            localObject2 = new Intent("android.intent.action.VIEW", localUri);
            ((Intent)localObject2).addFlags(268435456);
            if (!bt.T(getContext(), (Intent)localObject2)) {
              break label1005;
            }
            paramString = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(188857);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(13983, new Object[] { Integer.valueOf(4), localObject2, paramString });
          if (getIntent().getBooleanExtra("show_openapp_dialog", true))
          {
            bool = com.tencent.mm.cj.a.post((Runnable)new u(this, localUri));
            AppMethodBeat.o(188857);
            return bool;
          }
        }
      }
      label1005:
      AppMethodBeat.o(188857);
    }
    return false;
  }
  
  private boolean avC(String paramString)
  {
    AppMethodBeat.i(188860);
    d.g.b.k.h(paramString, "url");
    Iterator localIterator = this.AMo.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.c.d.a locala = (com.tencent.mm.plugin.webview.c.d.a)localIterator.next();
      if (locala.avD(paramString))
      {
        ad.i(getTAG(), "url handled, url = ".concat(String.valueOf(paramString)));
        boolean bool = locala.avC(paramString);
        ad.i(getTAG(), "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(188860);
        return true;
      }
    }
    AppMethodBeat.o(188860);
    return false;
  }
  
  private final boolean avz(String paramString)
  {
    AppMethodBeat.i(188856);
    if (bt.isNullOrNil(paramString))
    {
      ad.e(getTAG(), "search contact err: null or nill url");
      AppMethodBeat.o(188856);
      return false;
    }
    ejx();
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", ejw().eiZ());
    try
    {
      eiX().w(106, localBundle);
      AppMethodBeat.o(188856);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  private final String ejr()
  {
    AppMethodBeat.i(188829);
    if (!Ss(this.ALf))
    {
      AppMethodBeat.o(188829);
      return "";
    }
    String str = getIntent().getStringExtra("KPublisherId");
    AppMethodBeat.o(188829);
    return str;
  }
  
  private final t ejs()
  {
    AppMethodBeat.i(188830);
    t localt = (t)this.AMb.getValue();
    AppMethodBeat.o(188830);
    return localt;
  }
  
  private final com.tencent.mm.plugin.webview.ui.tools.c ejt()
  {
    AppMethodBeat.i(188832);
    com.tencent.mm.plugin.webview.ui.tools.c localc = (com.tencent.mm.plugin.webview.ui.tools.c)this.AMe.getValue();
    AppMethodBeat.o(188832);
    return localc;
  }
  
  private final com.tencent.mm.plugin.webview.modeltools.n eju()
  {
    AppMethodBeat.i(188835);
    com.tencent.mm.plugin.webview.modeltools.n localn = (com.tencent.mm.plugin.webview.modeltools.n)this.AMg.getValue();
    AppMethodBeat.o(188835);
    return localn;
  }
  
  private final p ejw()
  {
    AppMethodBeat.i(188854);
    p localp = (p)this.AMj.getValue();
    AppMethodBeat.o(188854);
    return localp;
  }
  
  private final void ejx()
  {
    AppMethodBeat.i(188855);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 106);
      localBundle.putInt("scene_end_listener_hash_code", ejw().eiZ());
      eiX().a(5, localBundle, ejw().eiZ());
      AppMethodBeat.o(188855);
      return;
    }
    catch (Exception localException)
    {
      ad.e(getTAG(), "addSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(188855);
    }
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(188825);
    String str = (String)this.ngR.getValue();
    AppMethodBeat.o(188825);
    return str;
  }
  
  protected boolean PR(String paramString)
  {
    return false;
  }
  
  public final void Su(int paramInt)
  {
    AppMethodBeat.i(188853);
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
    com.tencent.e.h.Iye.aN((Runnable)new af(this, i));
    AppMethodBeat.o(188853);
  }
  
  public final void a(com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(188846);
    String str = getTAG();
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i(str, "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (parame != null) {
        break;
      }
      ad.f(getTAG(), "service connect success, while invoker is null");
      onFinish();
      AppMethodBeat.o(188846);
      return;
    }
    try
    {
      parame.a((com.tencent.mm.plugin.webview.stub.f)ejw(), ejw().eiZ());
      super.a(parame);
      AppMethodBeat.o(188846);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e(getTAG(), "addCallback fail, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void a(WebView paramWebView, final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188834);
    if (!Ss(this.ALf))
    {
      ad.i(getTAG(), "onReceivedError, intent not ready");
      AppMethodBeat.o(188834);
      return;
    }
    Object localObject = ac.ANk;
    localObject = new ad(this);
    com.tencent.xweb.util.g.xI(false);
    boolean bool = ay.isConnected(getContext());
    ad.e(getTAG(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(155L, com.tencent.mm.plugin.webview.h.a.SY(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.i.eI(ejr(), 1);
    com.tencent.mm.plugin.topstory.a.i.eI(ejr(), com.tencent.mm.plugin.webview.h.a.SY(paramInt));
    com.tencent.mm.plugin.topstory.a.i.c(ejr(), bEx(), com.tencent.mm.plugin.webview.h.a.SY(paramInt), this.AMJ.emn().enterTime);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    com.tencent.mm.plugin.webview.ui.tools.k.BfO.TA(paramInt);
    this.AMJ.emv().errCode = paramInt;
    com.tencent.mm.plugin.webview.ui.tools.m localm = com.tencent.mm.plugin.webview.ui.tools.m.BgC;
    com.tencent.mm.plugin.webview.ui.tools.m.setErrCode(paramInt);
    if (((Boolean)this.AMa.getValue()).booleanValue()) {
      onFinish();
    }
    try
    {
      if (d.g.b.k.g(new URL(paramString2).getHost(), "mp.weixin.qq.com")) {
        com.tencent.e.h.Iye.f((Runnable)new ae(paramString2, paramInt, (ad)localObject, "mp.weixin.qq.com"), "WebViewUI.CheckDNS");
      }
      super.a(paramWebView, paramInt, paramString1, paramString2);
      AppMethodBeat.o(188834);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        ad.printErrStackTrace(getTAG(), (Throwable)localMalformedURLException, "check mp url", new Object[0]);
      }
    }
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.q paramq, SslError paramSslError)
  {
    AppMethodBeat.i(188833);
    if (!Ss(this.ALf))
    {
      ad.i(getTAG(), "onReceivedSslError, intent not ready");
      AppMethodBeat.o(188833);
      return;
    }
    com.tencent.xweb.util.g.xI(true);
    String str;
    if (paramWebView != null)
    {
      str = paramWebView.getUrl();
      if (str != null) {
        break label213;
      }
      str = this.AKH;
      label59:
      if (str == null) {
        break label222;
      }
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      d.g.b.k.g(localObject, "MMKernel.service(IBrandService::class.java)");
      localObject = ((com.tencent.mm.plugin.brandservice.a.b)localObject).bBT();
      d.g.b.k.g(localObject, "MMKernel.service(IBrandS…::class.java).hardCodeUrl");
      if (!d.n.n.mA(str, (String)localObject)) {
        break label222;
      }
      str = bEx();
    }
    label213:
    label222:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.i.eI(ejr(), 1);
      com.tencent.mm.plugin.topstory.a.i.eI(ejr(), 30);
      com.tencent.mm.plugin.topstory.a.i.c(ejr(), bEx(), 30, this.AMJ.emn().enterTime);
      ejt().a(str, paramq, paramSslError);
      super.a(paramWebView, paramq, paramSslError);
      AppMethodBeat.o(188833);
      return;
      str = null;
      break;
      str = paramWebView.getUrl();
      break label59;
    }
  }
  
  public final void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(188837);
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    this.AKH = paramString;
    super.a(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(188837);
  }
  
  protected final boolean a(int paramInt, String paramString, aoj paramaoj)
  {
    AppMethodBeat.i(188844);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramaoj, "resp");
    int i = paramaoj.Ctr;
    String str = paramaoj.DpW;
    switch (i)
    {
    default: 
      boolean bool = super.a(paramInt, paramString, paramaoj);
      AppMethodBeat.o(188844);
      return bool;
    case 3: 
      ad.i(getTAG(), "getA8key-app: ".concat(String.valueOf(str)));
      paramString = (CharSequence)str;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        ad.e(getTAG(), "getA8key-app, fullUrl is null");
        AppMethodBeat.o(188844);
        return false;
      }
      avA(str);
      AppMethodBeat.o(188844);
      return true;
    case 4: 
      d.g.b.k.g(str, "fullUrl");
      avz(str);
      AppMethodBeat.o(188844);
      return true;
    }
    d.g.b.k.g(str, "fullUrl");
    ejx();
    paramString = new Bundle();
    paramString.putString("emoji_store_jump_url", str);
    paramString.putInt("webview_binder_id", ejw().eiZ());
    try
    {
      eiX().w(666, paramString);
      AppMethodBeat.o(188844);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  public final int avB(String paramString)
  {
    AppMethodBeat.i(188859);
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
        bool = Ss(this.ALe);
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        label97:
        ad.e(getTAG(), "getScene fail, ex = " + paramString.getMessage());
        i = 1;
        continue;
        i = 1;
        continue;
      }
      ad.i(getTAG(), "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(188859);
      return i;
      i = 0;
      break;
      if (eiX().to(paramString))
      {
        i = 8;
      }
      else
      {
        if (eiX().sE(paramString))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("enterprise_biz_username", paramString);
          try
          {
            paramString = eiX().j(102, (Bundle)localObject);
            if (paramString != null)
            {
              bool = paramString.getBoolean("is_enterprise_username");
              if (!bool) {}
            }
          }
          catch (RemoteException paramString)
          {
            ad.e(getTAG(), "invoke the check enterprise failed");
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
  
  /* Error */
  public final String avx(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1298
    //   3: invokestatic 393	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 707	java/lang/CharSequence
    //   10: invokestatic 1304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +118 -> 131
    //   16: new 632	android/os/Bundle
    //   19: dup
    //   20: invokespecial 633	android/os/Bundle:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w 984
    //   28: aload_0
    //   29: invokevirtual 716	com/tencent/mm/plugin/webview/core/h:eiZ	()I
    //   32: invokevirtual 639	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: aload_2
    //   36: ldc_w 1306
    //   39: aload_1
    //   40: invokevirtual 982	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 653	com/tencent/mm/plugin/webview/core/h:eiX	()Lcom/tencent/mm/plugin/webview/stub/e;
    //   47: bipush 76
    //   49: aload_2
    //   50: invokeinterface 1287 3 0
    //   55: ldc_w 1308
    //   58: invokevirtual 1311	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 1314	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 1316
    //   69: invokestatic 1222	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokespecial 626	com/tencent/mm/plugin/webview/core/h:getTAG	()Ljava/lang/String;
    //   76: ldc_w 1318
    //   79: iconst_1
    //   80: anewarray 758	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 900	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 1298
    //   93: invokestatic 451	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: ldc_w 743
    //   102: astore_1
    //   103: aload_0
    //   104: invokespecial 626	com/tencent/mm/plugin/webview/core/h:getTAG	()Ljava/lang/String;
    //   107: ldc_w 1320
    //   110: iconst_1
    //   111: anewarray 758	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: invokevirtual 1321	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 761	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -34 -> 90
    //   127: astore_2
    //   128: goto -25 -> 103
    //   131: ldc_w 743
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
  
  protected final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(188839);
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    if ((isStarted()) && (Ss(this.ALe)))
    {
      Object localObject = this.AMc;
      String str = paramWebResourceRequest.getUrl().toString();
      if (!((Boolean)this.AMd.getValue()).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = ((aq)localObject).a(str, paramWebResourceRequest, bool, eiX());
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(188839);
        return localObject;
      }
    }
    paramWebView = super.b(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(188839);
    return paramWebView;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(188838);
    super.b(paramWebView, paramString);
    this.AKV.bG("onPageFinished", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.e(this.nhy);
    if (PR(paramString))
    {
      AppMethodBeat.o(188838);
      return;
    }
    ad.i(getTAG(), "edw onPageFinished opt, url = %s", new Object[] { paramString });
    this.AMJ.emu().bV(paramString);
    com.tencent.mm.plugin.webview.ui.tools.k.BfO.Bx();
    eju().xe(paramString);
    boolean bool = getIntent().getBooleanExtra("shouldForceViewPort", false);
    ad.d(getTAG(), "hy: shouldForceViewPort: ".concat(String.valueOf(bool)));
    Object localObject;
    if (bool)
    {
      localObject = getIntent().getStringExtra("view_port_code");
      if (paramWebView == null) {
        d.g.b.k.fvU();
      }
      paramWebView.evaluateJavascript((String)localObject, null);
    }
    if (paramString == null) {
      d.g.b.k.fvU();
    }
    if (avw(paramString))
    {
      ad.f(getTAG(), "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(188838);
      return;
    }
    if (d.g.b.k.g(paramString, this.AMh))
    {
      ad.i(getTAG(), "onPageFinished, js is finished loaded");
      AppMethodBeat.o(188838);
      return;
    }
    this.AMJ.emk().awS(paramString);
    this.AMJ.eml().awQ(paramString);
    this.AMJ.emo().report();
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      localObject = paramWebView.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.AMJ.emv().uBA = ((SnsAdClick)localObject);
        localObject = this.AMJ.emv();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.k.g(paramWebView, "uxInfo");
        ((at)localObject).P(new String[] { paramString, "1", str, paramWebView });
        this.AMJ.emv().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.BgC;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, true);
    this.AMn = bt.aGK();
    AppMethodBeat.o(188838);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188836);
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    super.b(paramWebView, paramString, paramBitmap);
    this.AKV.bG("onPageStarted", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.e(this.nhy);
    if (PR(paramString))
    {
      AppMethodBeat.o(188836);
      return;
    }
    if (!this.nhy.supportFeature(2006)) {
      getJsapi().ekA();
    }
    com.tencent.mm.plugin.webview.j.i.h(paramString, getContext());
    ad.i(getTAG(), "edw onPageStarted opt, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.i.eI(ejr(), 0);
    if ((com.tencent.mm.sdk.a.b.eEQ()) && (d.g.b.k.g("http://www.dktest-mmcrash.com/", paramString))) {
      Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    }
    this.AMf = this.AKH;
    long l = bt.aGK();
    paramWebView = ejs();
    d.g.b.k.h(paramString, "targetUrl");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new h.t.a(paramWebView, paramString, l));
    this.AMJ.emm().AYN = this.AMf;
    this.AKH = paramString;
    com.tencent.mm.plugin.webview.ui.tools.k.BfO.bU(paramString);
    ad.d(getTAG(), "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { this.AMf, this.AKH });
    if (avw(paramString))
    {
      ad.f(getTAG(), "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(188836);
      return;
    }
    eju().xe(paramString);
    this.AMJ.emk().cs(beH(), ejr()).awR(paramString);
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      paramBitmap = paramWebView.getParcelable("KSnsAdTag");
      if ((paramBitmap != null) && ((paramBitmap instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.AMJ.emv().uBA = ((SnsAdClick)paramBitmap);
        paramBitmap = this.AMJ.emv();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.k.g(paramWebView, "uxInfo");
        paramBitmap.P(new String[] { paramString, "0", str, paramWebView });
        this.AMJ.emv().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.BgC;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, false);
    AppMethodBeat.o(188836);
  }
  
  public final boolean b(int paramInt, String paramString, aoj paramaoj)
  {
    AppMethodBeat.i(188842);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramaoj, "response");
    Object localObject = paramaoj.Dqe;
    if (localObject != null) {}
    for (long l = ((zn)localObject).Dbw;; l = -1L)
    {
      this.AMF = l;
      boolean bool = this.nhy.getIsX5Kernel();
      localObject = paramaoj.DpW;
      d.g.b.k.g(localObject, "response.FullURL");
      ax.ax(bool, d.n.n.mA((String)localObject, "https://"));
      this.AMJ.emj().cb(paramString, true);
      this.AMJ.eml().cr(com.tencent.mm.plugin.webview.ui.tools.game.i.dEF, ejr()).awO(paramaoj.DpW);
      bool = super.b(paramInt, paramString, paramaoj);
      AppMethodBeat.o(188842);
      return bool;
    }
  }
  
  protected void bED()
  {
    AppMethodBeat.i(188849);
    if (avC(bEx()))
    {
      AppMethodBeat.o(188849);
      return;
    }
    if (bEE())
    {
      BaseWebViewController.a(this, bEx(), false, 0, 6);
      AppMethodBeat.o(188849);
      return;
    }
    ad.i(getTAG(), "terry onStartLoad:" + bEx());
    Object localObject3 = ejb();
    Object localObject1 = (CharSequence)localObject3;
    int i;
    if ((localObject1 == null) || (d.n.n.aC((CharSequence)localObject1))) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        ad.i(getTAG(), (String)localObject3);
        localObject1 = localObject3;
        if (getIntent().getBooleanExtra("QRDataFlag", true)) {}
        try
        {
          localObject1 = eiX().axy((String)localObject3);
          localObject3 = this.nhy.getSettings();
          d.g.b.k.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.y)localObject3).setUseWideViewPort(false);
          localObject3 = this.nhy.getSettings();
          d.g.b.k.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.y)localObject3).setLoadWithOverviewMode(false);
          localObject3 = this.nhy.getSettings();
          d.g.b.k.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.y)localObject3).setJavaScriptEnabled(false);
          te(true);
          this.nhy.loadDataWithBaseURL(null, (String)localObject1, "text/html", "utf-8", null);
          ad.i(getTAG(), "loadDataWithBaseUrl, data = ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(188849);
          return;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.w(getTAG(), "postBinded, formatQRString, ex = " + localException.getMessage());
            localObject2 = localObject3;
          }
        }
      }
    }
    if (avw(bEx()))
    {
      ad.f(getTAG(), "postBinded 2, canLoadUrl fail, url = " + bEx());
      AppMethodBeat.o(188849);
      return;
    }
    if (this.ALx.ALF) {
      this.kxg.a(bEx(), null, null);
    }
    Object localObject2 = ((Iterable)this.AKW).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((j)((Iterator)localObject2).next()).avJ(bEx()))
      {
        AppMethodBeat.o(188849);
        return;
      }
    }
    if (this.nhy.feU())
    {
      AppMethodBeat.o(188849);
      return;
    }
    te(false);
    BaseWebViewController.a(this, bEx(), null, 6);
    AppMethodBeat.o(188849);
  }
  
  protected boolean bEE()
  {
    AppMethodBeat.i(188850);
    Object localObject = ((Iterable)this.AKW).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((j)((Iterator)localObject).next()).avK(bEx()))
      {
        AppMethodBeat.o(188850);
        return false;
      }
    }
    localObject = (CharSequence)getIntent().getStringExtra("data");
    if ((localObject == null) || (d.n.n.aC((CharSequence)localObject))) {}
    for (int i = 1; (i != 0) && (!this.ALx.ALF); i = 0)
    {
      AppMethodBeat.o(188850);
      return true;
    }
    AppMethodBeat.o(188850);
    return false;
  }
  
  protected final void bFs()
  {
    AppMethodBeat.i(188841);
    int j = 2;
    int i = j;
    try
    {
      if (eiX().enj()) {
        if (!this.ALx.ALE) {
          break label147;
        }
      }
      label147:
      for (i = com.tencent.mm.plugin.webview.j.e.a(getContext(), eiX(), bEx());; i = com.tencent.mm.plugin.webview.j.e.gN(getContext()))
      {
        Su(i);
        String str = this.nhy.getUrl();
        if (bt.isNullOrNil(str)) {
          break label210;
        }
        Object localObject = this.AMi;
        if (str == null) {
          d.g.b.k.fvU();
        }
        if (!((Set)localObject).add(str)) {
          break label210;
        }
        localObject = this.kxg.emS();
        d.g.b.k.g(localObject, "wvPerm.genCtrl");
        if (((GeneralControlWrapper)localObject).eBO()) {
          getJsapi().ekv();
        }
        if (!((GeneralControlWrapper)localObject).eBP()) {
          break;
        }
        getJsapi().tj(false);
        AppMethodBeat.o(188841);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e(getTAG(), "onLoadJsApiFinished, ex = " + localException.getMessage());
        i = j;
      }
      if (this.AMc.awE(localException)) {
        getJsapi().tj(true);
      }
      label210:
      super.bFs();
      AppMethodBeat.o(188841);
    }
  }
  
  public final int beH()
  {
    AppMethodBeat.i(188858);
    int i = avB(getIntent().getStringExtra("geta8key_username"));
    AppMethodBeat.o(188858);
    return i;
  }
  
  protected final void dvS()
  {
    AppMethodBeat.i(188848);
    if (ejf())
    {
      ad.e(getTAG(), "onBinded call when activity has been finished");
      AppMethodBeat.o(188848);
      return;
    }
    ad.i(getTAG(), "Abe-Debug onPostBindedStart");
    this.AKV.bG("onPostBindedStart", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.k.BfO.b(eiX());
    Object localObject1 = getIntent().getStringExtra("ad_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.k.BfO;
      d.g.b.k.g(localObject2, "WebViewReportUtil.INSTANCE");
      ((com.tencent.mm.plugin.webview.ui.tools.k)localObject2).setTraceId((String)localObject1);
    }
    this.AKV.bG("onJSAPIStart", System.currentTimeMillis());
    localObject1 = getIntent().getBundleExtra("jsapiargs");
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    for (;;)
    {
      ((Bundle)localObject1).putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
      ((Bundle)localObject1).putString("key_function_id", getIntent().getStringExtra("key_function_id"));
      ad.i(getTAG(), "KDownloadRestrict = %d, KFunctionID = %s", new Object[] { Integer.valueOf(((Bundle)localObject1).getInt("key_download_restrict", 0)), ((Bundle)localObject1).getString("key_function_id", "") });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBundle("jsapiargs", (Bundle)localObject1);
      ((Bundle)localObject2).putCharSequence("bizofstartfrom", (CharSequence)getIntent().getStringExtra("bizofstartfrom"));
      ((Bundle)localObject2).putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
      ((Bundle)localObject2).putInt("screen_orientation", getScreenOrientation());
      try
      {
        eiX().a(20, (Bundle)localObject2, eiZ());
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
        av localav = this.AMJ.emm();
        localav.username = ((String)localObject3);
        localav.AYO = i;
        localav.dAl = bEx();
        localav.AYK = j;
        localav.scene = avB((String)localObject3);
        localav.AYJ = l;
        localav.AYL = new com.tencent.mm.b.p(l).toString();
        localav.ASp = str1;
        localav.AYI = ((String)localObject2);
        localav.gKw = str2;
        localav.appId = str4;
        localav.AYM = str5;
        localav.AYN = this.AMf;
        localav.xns = ((String)localObject1);
        localObject2 = getTitle();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localav.title = ((String)localObject1);
        localav.ePc = str3;
        localObject2 = getIntent().getStringExtra("share_report_pre_msg_desc");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localav.desc = ((String)localObject2);
        localObject1 = this.AMJ.emn();
        ((com.tencent.mm.plugin.webview.model.aj)localObject1).gKw = str2;
        ((com.tencent.mm.plugin.webview.model.aj)localObject1).scene = avB((String)localObject3);
        this.AMJ.emp().awN(bEx());
        if (!ejv()) {}
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
            eiX().a(29, (Bundle)localObject1, eiZ());
            label731:
            if (!bt.isNullOrNil(str1)) {}
            try
            {
              eiX().axD(str1);
              try
              {
                i = getIntent().getIntExtra("pay_channel", -1);
                if (i == -1) {
                  break label1538;
                }
                ad.i(getTAG(), "hy: found channel in intent. pay channel: %d", new Object[] { Integer.valueOf(i) });
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ad.e(getTAG(), "hy: init pay channel failed");
                  continue;
                  i = 0;
                  continue;
                  localObject3 = (CharSequence)str1;
                  if ((localObject3 == null) || (d.n.n.aC((CharSequence)localObject3))) {}
                  for (i = 1; i == 0; i = 0)
                  {
                    localRemoteException.put("srcUsername", str1);
                    break;
                  }
                  i = 3;
                  ad.i(getTAG(), "default pay scene to: %s", new Object[] { Integer.valueOf(3) });
                }
                if (!this.nhy.getIsX5Kernel()) {
                  break label1842;
                }
                com.tencent.mm.pluginsdk.ui.tools.p.lI(7);
                com.tencent.mm.plugin.report.service.h.vKh.a(64, 64, 1, 0, 1, 1, false);
                try
                {
                  i = bt.getInt(eiX().axC("WebviewDisableDigestVerify"), 0);
                  ad.i(getTAG(), "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
                  if (i != 0) {
                    break label1806;
                  }
                  SharedPreferences localSharedPreferences = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                  d.g.b.k.g(localSharedPreferences, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
                  if ((!localSharedPreferences.getBoolean("wvsha1", true)) || (!this.ALx.ALD)) {
                    break label1806;
                  }
                  getJsapi().ekm();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    for (;;)
                    {
                      eiX().a(bEx(), true, null);
                      this.AKV.bG("onPostBindedEnd", System.currentTimeMillis());
                      AppMethodBeat.o(188848);
                      return;
                      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(64L, 0L, 1L, false);
                    }
                    localException3 = localException3;
                    ad.w(getTAG(), "getting js digest verification config fails, ex = " + localException3.getMessage());
                    i = 0;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      ad.w(getTAG(), "postBinded, jumpToActivity, ex = " + localException4.getMessage());
                    }
                  }
                }
              }
              this.AMo.clear();
              localObject1 = getJsapi();
              str1 = getIntent().getStringExtra("geta8key_username");
              localObject2 = ae.b(new o[] { d.u.P("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0L))), d.u.P("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), d.u.P("scene", Integer.valueOf(avB(str1))), d.u.P("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), d.u.P("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), d.u.P("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))) });
              localObject3 = (CharSequence)getIntent().getStringExtra("srcUsername");
              if ((localObject3 == null) || (d.n.n.aC((CharSequence)localObject3)))
              {
                i = 1;
                if (i != 0) {
                  break label1609;
                }
                ((Map)localObject2).putAll((Map)ae.c(new o[] { d.u.P("srcUsername", getIntent().getStringExtra("srcUsername")), d.u.P("srcDisplayname", getIntent().getStringExtra("srcDisplayname")) }));
                if (!bt.isNullOrNil(getIntent().getStringExtra("KTemplateId")))
                {
                  str1 = getIntent().getStringExtra("KTemplateId");
                  d.g.b.k.g(str1, "intent.getStringExtra(Co…UI.WebViewUI.KTemplateId)");
                  ((Map)localObject2).put("KTemplateId", str1);
                }
                i = getIntent().getIntExtra("pay_scene", -1);
                if (i == -1) {
                  break label1656;
                }
                ad.i(getTAG(), "get pay scene from extra: %s", new Object[] { Integer.valueOf(i) });
                ((Map)localObject2).put("pay_scene", Integer.valueOf(i));
                ((com.tencent.mm.plugin.webview.c.f)localObject1).bo((Map)localObject2);
                localObject1 = this.AMo;
                localObject2 = (List)new ArrayList();
                ((List)localObject2).add(getJsapi());
                ((List)localObject2).add(this.AMp);
                ((List)localObject2).add(this.AMq);
                ((List)localObject2).add(this.AMr);
                ((List)localObject2).add(this.AMs);
                ((List)localObject2).add(this.AMt);
                ((List)localObject2).add(this.AMu);
                ((List)localObject2).add(this.AMx);
                ((List)localObject2).add(this.AMA);
                ((List)localObject2).add(this.AMB);
                ((List)localObject2).add(this.AMC);
                ((List)localObject2).add(this.AME);
                ((List)localObject2).add(this.AMz);
                ((List)localObject2).add(this.AMD);
                ((List)localObject2).add(this.AMy);
                if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
                  ((List)localObject2).add(this.AMH);
                }
                ((List)localObject2).add(this.AMG);
                ((List)localObject1).addAll((Collection)localObject2);
                ad.i(getTAG(), "Abe-Debug controllerListeners call, size = %d", new Object[] { Integer.valueOf(this.AKY.size()) });
                localObject1 = ((Iterable)this.AKY).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  ((i)((Iterator)localObject1).next()).dvS();
                  continue;
                  localRemoteException = localRemoteException;
                  ad.e(getTAG(), "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + localRemoteException.getMessage());
                }
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ad.e(getTAG(), "postBinded, fail triggerGetContact, ex = " + localException1.getMessage());
                continue;
                i = eiX().enx();
                if (i != -1)
                {
                  ad.i(getTAG(), "hy: found channel in channel helper. pay channel: %d", new Object[] { Integer.valueOf(i) });
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
  
  protected final Class<? extends Service> eiU()
  {
    AppMethodBeat.i(188826);
    Class localClass = (Class)this.ALX.getValue();
    AppMethodBeat.o(188826);
    return localClass;
  }
  
  protected final Set<String> eiV()
  {
    AppMethodBeat.i(188827);
    Set localSet = (Set)this.ALY.getValue();
    AppMethodBeat.o(188827);
    return localSet;
  }
  
  protected final void ejd()
  {
    AppMethodBeat.i(188862);
    ad.i(getTAG(), "WebView-Trace setWebViewPluginClient");
    this.AMI = com.tencent.luggage.k.a.d.a((WebView)this.nhy, (com.tencent.luggage.k.a.c.d)com.tencent.luggage.k.a.c.b.FK(), (com.tencent.luggage.k.a.b.c)com.tencent.mm.plugin.webview.ui.tools.d.a.g.eqR(), null);
    AppMethodBeat.o(188862);
  }
  
  public final boolean eje()
  {
    AppMethodBeat.i(188847);
    ad.i(getTAG(), "edw onServiceDisconnected");
    Iterator localIterator = ((Iterable)this.AKW).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((j)localIterator.next()).ejE());
    for (int i = 1; i == 0; i = 0)
    {
      ad.i(getTAG(), "maybe mm process crash, try rebind service");
      AppMethodBeat.o(188847);
      return true;
    }
    boolean bool = super.eje();
    AppMethodBeat.o(188847);
    return bool;
  }
  
  protected final void eji()
  {
    AppMethodBeat.i(188845);
    super.eji();
    com.tencent.mm.plugin.webview.h.b.ena();
    Object localObject = ((Iterable)this.AKY).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((i)((Iterator)localObject).next()).a(this.AKV);
    }
    localObject = this.AKV;
    MMWebView localMMWebView = this.nhy;
    d.g.a.a locala = (d.g.a.a)new ab(this);
    d.g.b.k.h(localMMWebView, "webView");
    d.g.b.k.h(locala, "callback");
    localMMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", (ValueCallback)new com.tencent.mm.plugin.webview.j.h.b((com.tencent.mm.plugin.webview.j.h)localObject, locala));
    AppMethodBeat.o(188845);
  }
  
  protected final void ejj()
  {
    AppMethodBeat.i(188863);
    ad.d(getTAG(), "setGetA8KeyParams");
    Object localObject = getIntent().getStringExtra("geta8key_username");
    eiW().setUsername((String)localObject);
    eiW().setScene(avB((String)localObject));
    eiW().setAppId(getIntent().getStringExtra("geta8key_open_webview_appid"));
    localObject = this.nhy;
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((MMWebView)localObject).getIsX5Kernel());
      if (!((Boolean)localObject).booleanValue()) {
        break label184;
      }
      eiW().setFlag(1);
    }
    for (;;)
    {
      eiW().ah(getIntent().getByteArrayExtra("geta8key_cookie"));
      eiW().SS(getIntent().getIntExtra("key_wallet_region", 0));
      eiW().axj(getIntent().getStringExtra("key_function_id"));
      int i = getIntent().getIntExtra("geta8key_session_id", 0);
      if (i > 0) {
        eiW().SR(i);
      }
      AppMethodBeat.o(188863);
      return;
      localObject = null;
      break;
      label184:
      eiW().setFlag(0);
    }
  }
  
  public final boolean ejv()
  {
    AppMethodBeat.i(188851);
    Object localObject = getIntent().getStringExtra("srcUsername");
    String str = getIntent().getStringExtra("bizofstartfrom");
    localObject = (CharSequence)localObject;
    if ((localObject == null) || (d.n.n.aC((CharSequence)localObject))) {}
    for (int i = 1; (i == 0) && (d.g.b.k.g(str, "enterpriseHomeSubBrand")); i = 0)
    {
      AppMethodBeat.o(188851);
      return true;
    }
    AppMethodBeat.o(188851);
    return false;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(188828);
    Object localObject2 = this.nhy.getTitle();
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
    AppMethodBeat.o(188828);
    return localObject1;
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(188831);
    d.g.b.k.h(paramString, "url");
    ad.i(getTAG(), "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
    if (avw(paramString))
    {
      ad.f(getTAG(), "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      super.h(paramWebView, paramString);
      AppMethodBeat.o(188831);
      return;
    }
    this.AMJ.eml().awP(paramString);
    super.h(paramWebView, paramString);
    AppMethodBeat.o(188831);
  }
  
  protected final boolean k(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(188840);
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramString, "url");
    ad.i(getTAG(), "WebView-Trace shouldOverride url = ".concat(String.valueOf(paramString)));
    Object localObject = j(paramWebView, paramString);
    if (((j.a)localObject).ANt)
    {
      boolean bool = ((j.a)localObject).result;
      AppMethodBeat.o(188840);
      return bool;
    }
    if (avw(paramString))
    {
      ad.f(getTAG(), "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(188840);
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "about:blank", true))
    {
      ad.e(getTAG(), "shouldOverride, url is about:blank");
      AppMethodBeat.o(188840);
      return true;
    }
    if (DownloadChecker.a(paramString, ejr(), paramWebView))
    {
      ad.i(getTAG(), "use the downloader to download");
      AppMethodBeat.o(188840);
      return true;
    }
    try
    {
      if ((com.tencent.luggage.h.c.a(paramString, "weixin://jump/", true)) || (com.tencent.luggage.h.c.a(paramString, "weixin://scanqrcode/", true)))
      {
        d.g.b.k.h(paramString, "url");
        if (this.kxg.emS().eBM())
        {
          paramWebView = new Bundle();
          paramWebView.putInt("fromScene", 100);
          if (eiX().a(paramString, this.kxg.emR().mb(7), paramWebView)) {
            ad.i(getTAG(), "shouldOverride, built in url handled, url = ".concat(String.valueOf(paramString)));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(188840);
          return true;
          ad.w(getTAG(), "shouldOverride, allow inner open url, not allow");
        }
      }
      int i;
      return false;
    }
    catch (Exception paramWebView)
    {
      ad.w(getTAG(), "shouldOverride, jumpToActivity, ex = " + paramWebView.getMessage());
      while (avC(paramString))
      {
        AppMethodBeat.o(188840);
        return true;
        if ((com.tencent.luggage.h.c.z(paramString, "weixin://dl/business")) && (com.tencent.mm.pluginsdk.f.v(Uri.parse(paramString))))
        {
          paramWebView = Uri.parse(bEx());
          d.g.b.k.g(paramWebView, "rawUrlUri");
          localObject = paramWebView.getHost();
          paramWebView = new Intent("android.intent.action.VIEW");
          paramWebView.addCategory("android.intent.category.BROWSABLE");
          paramWebView.setData(Uri.parse(paramString + "&domain=" + (String)localObject));
          i = paramWebView.getIntExtra("pay_channel", -1);
          if (i != -1)
          {
            ad.i(getTAG(), "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
            paramWebView.putExtra("pay_channel", i);
          }
          paramWebView.putExtra("translate_link_scene", 13);
          localObject = getContext();
          paramWebView = new com.tencent.mm.hellhoundlib.b.a().bd(paramWebView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramWebView.adn(), "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject).startActivity((Intent)paramWebView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(188840);
          return true;
        }
        if (com.tencent.luggage.h.c.z(paramString, "weixinpreinject://iframe"))
        {
          ad.i(getTAG(), "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
        }
        else if ((com.tencent.luggage.h.c.z(paramString, "weixin://dl/login/common_view")) || (com.tencent.luggage.h.c.z(paramString, "weixin://dl/login/phone_view")))
        {
          if (((com.tencent.luggage.h.c.z(bEx(), "https://support.weixin.qq.com/security")) || (com.tencent.luggage.h.c.z(paramString, "https://support.wechat.com/security"))) && (((Boolean)this.ALZ.getValue()).booleanValue()))
          {
            com.tencent.mm.pluginsdk.f.bF(getContext(), paramString);
            onFinish();
            AppMethodBeat.o(188840);
            return true;
          }
        }
        else if ((com.tencent.luggage.h.c.z(paramString, "weixin://webview/initReady/")) || (com.tencent.luggage.h.c.z(paramString, "weixin://webview/preInjectJSBridge/")))
        {
          AppMethodBeat.o(188840);
          return true;
        }
      }
      if (com.tencent.luggage.h.c.z(paramString, "weixin://"))
      {
        ad.e(getTAG(), "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        AppMethodBeat.o(188840);
        return true;
      }
      ad.i(getTAG(), "edw overrideUrl");
      if ((com.tencent.luggage.h.c.z(paramString, "weixinping://iframe")) || (com.tencent.luggage.h.c.z(paramString, "weixinpreinject://iframe")))
      {
        AppMethodBeat.o(188840);
        return true;
      }
      if (avA(paramString))
      {
        ad.i(getTAG(), "custom scheme url deal success, url = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(188840);
        return true;
      }
      AppMethodBeat.o(188840);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(188861);
    ejs().n("", bt.aGK(), 0);
    ejt().detach();
    if (ejv()) {}
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
      eiX().a(30, localBundle, eiZ());
      try
      {
        label75:
        eiX().Tn(ejw().eiZ());
        super.onDestroy();
        AppMethodBeat.o(188861);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ad.i(getTAG(), "onDestroy remove callbacker ex " + localException1.getMessage());
        }
      }
    }
    catch (Exception localException2)
    {
      break label75;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188756);
      d.g.b.k.h(paramString, "url");
      if (!this.AML.kxg.emS().eBM())
      {
        ad.e(h.a(this.AML), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
        AppMethodBeat.o(188756);
        return true;
      }
      try
      {
        this.AML.eiX().cd(paramString, this.AML.kxg.emR().mb(7));
        AppMethodBeat.o(188756);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.w(h.a(this.AML), "ActivityJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188755);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188755);
        return false;
      }
      boolean bool = x.A(paramString, "weixin://jump/");
      AppMethodBeat.o(188755);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$oauthOnSceneEndDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"})
  public static final class aa
    implements ag.a
  {
    private final Map<Integer, Integer> ANj;
    
    aa()
    {
      AppMethodBeat.i(188809);
      this.ANj = ((Map)new HashMap());
      AppMethodBeat.o(188809);
    }
    
    public final void vX()
    {
      AppMethodBeat.i(188808);
      h.a(this.AML, 1373);
      if (this.ANj.containsKey(Integer.valueOf(1373)))
      {
        Object localObject = this.ANj.get(Integer.valueOf(1373));
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        int i = ((Number)localObject).intValue();
        this.ANj.put(Integer.valueOf(1373), Integer.valueOf(i - 1));
        AppMethodBeat.o(188808);
        return;
      }
      this.ANj.put(Integer.valueOf(1373), Integer.valueOf(0));
      AppMethodBeat.o(188808);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class ab
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    ab(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"getNetWorkTypeName", "", "context", "Landroid/content/Context;", "invoke"})
  static final class ac
    extends d.g.b.l
    implements d.g.a.b<Context, String>
  {
    public static final ac ANk;
    
    static
    {
      AppMethodBeat.i(188813);
      ANk = new ac();
      AppMethodBeat.o(188813);
    }
    
    ac()
    {
      super();
    }
    
    public static String gz(Context paramContext)
    {
      AppMethodBeat.i(188812);
      d.g.b.k.h(paramContext, "context");
      if (ay.isWifi(paramContext))
      {
        AppMethodBeat.o(188812);
        return "wifi";
      }
      if (ay.is4G(paramContext))
      {
        AppMethodBeat.o(188812);
        return "4g";
      }
      if (ay.is3G(paramContext))
      {
        AppMethodBeat.o(188812);
        return "3g";
      }
      if (ay.is2G(paramContext))
      {
        AppMethodBeat.o(188812);
        return "2g";
      }
      AppMethodBeat.o(188812);
      return "none";
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"dnsIps", "", "host", "invoke"})
  static final class ad
    extends d.g.b.l
    implements d.g.a.b<String, String>
  {
    ad(h paramh)
    {
      super();
    }
    
    public final String avF(String paramString)
    {
      AppMethodBeat.i(188815);
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
            d.g.b.k.g(localObject, "inetAddressArr[i]");
            localStringBuilder.append(localObject.getHostAddress());
            localStringBuilder.append(";");
            i += 1;
          }
        }
        paramString = localStringBuilder.toString();
      }
      catch (UnknownHostException paramString)
      {
        ad.printErrStackTrace(h.a(this.AML), (Throwable)paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(188815);
        return null;
      }
      AppMethodBeat.o(188815);
      return paramString;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(String paramString1, int paramInt, h.ad paramad, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(188816);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      String str = this.ANl;
      int i = paramInt;
      Object localObject = h.ac.ANk;
      localObject = com.tencent.mm.sdk.platformtools.aj.getContext();
      d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
      localh.f(17082, new Object[] { str, Integer.valueOf(i), h.ac.gz((Context)localObject), this.ANm.avF(this.ANn) });
      AppMethodBeat.o(188816);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(h paramh, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(188817);
      this.AML.getJsapi().Sv(i);
      Object localObject = this.AML;
      int i = i;
      localObject = ((Iterable)((BaseWebViewController)localObject).AKY).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).Sv(i);
      }
      AppMethodBeat.o(188817);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "invoke"})
  static final class ag
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.modeltools.n>
  {
    public static final ag ANp;
    
    static
    {
      AppMethodBeat.i(188819);
      ANp = new ag();
      AppMethodBeat.o(188819);
    }
    
    ag()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "invoke"})
  static final class ah
    extends d.g.b.l
    implements d.g.a.a<h.p>
  {
    ah(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "invoke"})
  static final class ai
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.ui.tools.c>
  {
    ai(h paramh, MMWebView paramMMWebView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;", "invoke"})
  static final class aj
    extends d.g.b.l
    implements d.g.a.a<Class<WebViewStubService>>
  {
    public static final aj ANq;
    
    static
    {
      AppMethodBeat.i(188822);
      ANq = new aj();
      AppMethodBeat.o(188822);
    }
    
    aj()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "invoke"})
  static final class ak
    extends d.g.b.l
    implements d.g.a.a<h.t>
  {
    ak(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMM = "weixin://addfriend/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188758);
      d.g.b.k.h(paramString, "url");
      if (!this.AML.kxg.emR().mb(5))
      {
        ad.e(h.a(this.AML), "AddFriendHandler, permission fail");
        AppMethodBeat.o(188758);
        return true;
      }
      paramString = paramString.substring(this.AMM.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188758);
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_webview", true);
      localBundle.putString("userName", paramString);
      try
      {
        this.AML.eiX().a(8, localBundle, this.AML.eiZ());
        AppMethodBeat.o(188758);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.w(h.a(this.AML), "AddFriendHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188757);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188757);
        return false;
      }
      boolean bool = x.A(paramString, this.AMM);
      AppMethodBeat.o(188757);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMN = "weixin://webview/close/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188760);
      d.g.b.k.h(paramString, "url");
      if (!this.AML.kxg.emR().mb(17))
      {
        ad.e(h.a(this.AML), "close window permission fail");
        AppMethodBeat.o(188760);
        return true;
      }
      this.AML.onFinish();
      AppMethodBeat.o(188760);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188759);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188759);
        return false;
      }
      boolean bool = x.A(paramString, this.AMN);
      AppMethodBeat.o(188759);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class e
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMO = "weixin://critical_update/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188762);
      d.g.b.k.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 25L, 1L, true);
      h.b(this.AML, 1);
      AppMethodBeat.o(188762);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188761);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188761);
        return false;
      }
      boolean bool = x.A(paramString, this.AMO);
      AppMethodBeat.o(188761);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class f
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    f(MMWebView paramMMWebView) {}
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188764);
      d.g.b.k.h(paramString, "url");
      int i = this.AML.avB(bt.nullAsNil(h.i(this.AML)));
      if (com.tencent.mm.pluginsdk.f.bF(paramString, h.j(this.AML))) {}
      for (;;)
      {
        try
        {
          Object localObject;
          if (d.g.b.k.g("weixin://dl/shopping", paramString))
          {
            localObject = this.AML.eiX().enn();
            d.g.b.k.g(localObject, "invoker.getJDUrl()");
            if (!bt.isNullOrNil((String)localObject)) {
              BaseWebViewController.a(this.AML, (String)localObject, null, 6);
            }
            localObject = (List)new ArrayList();
            ((List)localObject).add(paramString);
            ((List)localObject).add("1");
            ((List)localObject).add(String.valueOf(i));
            paramString = bt.nullAsNil(h.i(this.AML));
            d.g.b.k.g(paramString, "Util.nullAsNil(sentUsername)");
            ((List)localObject).add(paramString);
            paramString = bt.nullAsNil(this.AML.bEx());
            d.g.b.k.g(paramString, "Util.nullAsNil(rawUrl)");
            ((List)localObject).add(paramString);
            paramString = com.tencent.mm.plugin.report.service.h.vKh;
            com.tencent.mm.plugin.report.service.h.h(11405, (List)localObject);
            bool = true;
            AppMethodBeat.o(188764);
            return bool;
          }
          if (d.g.b.k.g("weixin://dl/faq", paramString))
          {
            int j = this.AML.eiX().enp();
            int k = this.AML.eiX().enq();
            localObject = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131763450, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            h localh = this.AML;
            d.g.b.k.g(localObject, "rawUrl");
            BaseWebViewController.a(localh, (String)localObject, null, 6);
            continue;
          }
        }
        catch (Exception paramString)
        {
          ad.e(h.a(this.AML), "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          bool = true;
          continue;
          if (d.g.b.k.g("weixin://dl/posts", paramString))
          {
            this.AML.eiX().enr();
            continue;
          }
          if (d.g.b.k.g("weixin://dl/moments", paramString))
          {
            this.AML.eiX().ens();
            continue;
          }
          if (d.n.n.mA(paramString, "weixin://dl/feedback"))
          {
            d.g.b.k.g(this.AML.eiX().axH(paramString), "invoker.getFeedbackUrl(url)");
            continue;
          }
          if (d.g.b.k.g("weixin://dl/scan", paramString))
          {
            com.tencent.mm.bs.d.c(this.AML.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.f.bE(paramMMWebView.getActivityContextIfHas(), paramString);
          continue;
        }
        boolean bool = false;
      }
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188763);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188763);
        return false;
      }
      boolean bool = x.A(paramString, "weixin://");
      AppMethodBeat.o(188763);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMP = "weixin://feedback/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188766);
      d.g.b.k.h(paramString, "url");
      paramString = new Bundle();
      paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
      paramString.putInt("MMActivity.OverrideExitAnimation", 2130772106);
      try
      {
        this.AML.eiX().a(7, paramString, this.AML.eiZ());
        AppMethodBeat.o(188766);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.w(h.a(this.AML), "FeedbackJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188765);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188765);
        return false;
      }
      boolean bool = x.A(paramString, this.AMP);
      AppMethodBeat.o(188765);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMQ = "weixin://connectToFreeWifi/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188768);
      d.g.b.k.h(paramString, "url");
      paramString = Uri.parse(paramString);
      String str1 = paramString.getQueryParameter("apKey");
      ad.i(h.a(this.AML), "apKey value = %s", new Object[] { str1 });
      String str2 = paramString.getQueryParameter("ticket");
      if (!bt.isNullOrNil(str1))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("free_wifi_schema_uri", paramString.toString());
        localIntent.putExtra("free_wifi_ap_key", str1);
        localIntent.putExtra("free_wifi_source", 5);
        if (!bt.isNullOrNil(str2)) {
          localIntent.putExtra("free_wifi_schema_ticket", str2);
        }
        localIntent.addFlags(67108864);
        com.tencent.mm.bs.d.b(com.tencent.mm.sdk.platformtools.aj.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
      }
      AppMethodBeat.o(188768);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188767);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188767);
        return false;
      }
      boolean bool = x.A(paramString, this.AMQ);
      AppMethodBeat.o(188767);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class i
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMS = "weixin://gethtml/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188770);
      d.g.b.k.h(paramString, "url");
      if (!bt.isNullOrNil(paramString))
      {
        paramString = paramString.substring(this.AMS.length());
        d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
        ad.i(h.a(this.AML), "[oneliang]get html content :".concat(String.valueOf(paramString)));
        Object localObject = this.AML;
        d.g.b.k.h(paramString, "html");
        localObject = ((Iterable)((BaseWebViewController)localObject).AKY).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).avH(paramString);
        }
      }
      AppMethodBeat.o(188770);
      return false;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188769);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188769);
        return false;
      }
      boolean bool = x.A(paramString, this.AMS);
      AppMethodBeat.o(188769);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class j
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMT = "weixin://profile/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188772);
      d.g.b.k.h(paramString, "url");
      paramString = paramString.substring(this.AMT.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        ad.e(h.a(this.AML), "handleUrl fail, username is null");
        AppMethodBeat.o(188772);
        return true;
      }
      if (this.AML.kxg.emR().mb(2)) {
        this.AML.getJsapi().avV(paramString);
      }
      AppMethodBeat.o(188772);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188771);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188771);
        return false;
      }
      boolean bool = x.A(paramString, this.AMT);
      AppMethodBeat.o(188771);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class k
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMU = "weixin://manual_update/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188774);
      d.g.b.k.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 26L, 1L, true);
      h.b(this.AML, 3);
      AppMethodBeat.o(188774);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188773);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188773);
        return false;
      }
      boolean bool = x.A(paramString, this.AMU);
      AppMethodBeat.o(188773);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class l
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188776);
      d.g.b.k.h(paramString, "url");
      String str = this.AML.getIntent().getStringExtra("geta8key_username");
      boolean bool = ag.b.a(paramString, str, this.AML.avB(str), this.AML.eiX(), h.d(this.AML), this.AML.AMm, h.e(this.AML).eiZ(), this.AML.getContext());
      AppMethodBeat.o(188776);
      return bool;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188775);
      d.g.b.k.h(paramString, "url");
      boolean bool = ag.b.fe(paramString, this.AML.getIntent().getIntExtra("geta8key_scene", 0));
      AppMethodBeat.o(188775);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "READER_SHARE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "share", "", "plugin-webview_release"})
  public static final class m
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMV = "weixin://readershare/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188779);
      d.g.b.k.h(paramString, "url");
      paramString = this.AML.getContext().getString(2131762183);
      d.g.b.k.g(paramString, "context.getString(R.string.readerapp_share_weibo)");
      Context localContext = this.AML.getContext();
      com.tencent.mm.ui.base.h.c localc = (com.tencent.mm.ui.base.h.c)new a(this);
      com.tencent.mm.ui.base.h.a(localContext, "", new String[] { paramString }, "", localc);
      AppMethodBeat.o(188779);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188778);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188778);
        return false;
      }
      boolean bool = x.A(paramString, this.AMV);
      AppMethodBeat.o(188778);
      return bool;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "whichButton", "", "onClick"})
    static final class a
      implements com.tencent.mm.ui.base.h.c
    {
      a(h.m paramm) {}
      
      public final void kM(int paramInt)
      {
        AppMethodBeat.i(188777);
        if (paramInt == 0)
        {
          h.m localm = this.AMW;
          try
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("shortUrl", localm.AML.getIntent().getStringExtra("shortUrl"));
            localBundle.putInt("type", localm.AML.getIntent().getIntExtra("type", 0));
            localm.AML.eiX().a(4, localBundle, localm.AML.eiZ());
            AppMethodBeat.o(188777);
            return;
          }
          catch (Exception localException)
          {
            ad.e(h.a(localm.AML), "share fail, ex = " + localException.getMessage());
          }
        }
        AppMethodBeat.o(188777);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class n
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMX = "weixin://recommend_update/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188781);
      d.g.b.k.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 24L, 1L, true);
      h.b(this.AML, 2);
      AppMethodBeat.o(188781);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188780);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188780);
        return false;
      }
      boolean bool = x.A(paramString, this.AMX);
      AppMethodBeat.o(188780);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class o
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String AMY = "weixin://openapi/openwebview/result?";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188783);
      d.g.b.k.h(paramString, "url");
      Object localObject = new OpenWebview.Resp();
      paramString = Uri.parse(paramString);
      d.g.b.k.g(paramString, "uri");
      ((OpenWebview.Resp)localObject).result = paramString.getQuery();
      ((OpenWebview.Resp)localObject).errCode = bt.getInt(paramString.getQueryParameter("errCode"), 0);
      ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
      ((OpenWebview.Resp)localObject).transaction = this.AML.getIntent().getStringExtra("transaction_for_openapi_openwebview");
      paramString = paramString.getQueryParameter("appid");
      if (bt.isNullOrNil(paramString))
      {
        ad.e(h.a(this.AML), "SDKOpenWebViewResultHandler handleUrl, appId is null");
        AppMethodBeat.o(188783);
        return true;
      }
      Bundle localBundle = new Bundle();
      ((OpenWebview.Resp)localObject).toBundle(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.aS(localBundle);
      localObject = new MMessageActV2.Args();
      try
      {
        ((MMessageActV2.Args)localObject).targetPkgName = this.AML.eiX().axA(paramString);
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        ad.d(h.a(this.AML), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
        MMessageActV2.send(this.AML.getContext(), (MMessageActV2.Args)localObject);
        this.AML.onFinish();
        AppMethodBeat.o(188783);
        return true;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace(h.a(this.AML), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(188783);
      }
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188782);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188782);
        return false;
      }
      boolean bool = x.A(paramString, this.AMY);
      AppMethodBeat.o(188782);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"})
  static final class p
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    private final d.f AKQ;
    private final h AMZ;
    private final String TAG;
    
    static
    {
      AppMethodBeat.i(188785);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(p.class), "binderId", "getBinderId()I")) };
      AppMethodBeat.o(188785);
    }
    
    public p(h paramh)
    {
      AppMethodBeat.i(188788);
      this.AMZ = paramh;
      this.TAG = ("MicroMsg.WebViewController.SceneEndCallbacker:" + this.AMZ.eiZ());
      this.AKQ = d.g.E((d.g.a.a)new a(this));
      AppMethodBeat.o(188788);
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      AppMethodBeat.i(188787);
      ad.i(this.TAG, "onSceneEnd, instance hashcode = " + hashCode());
      h localh;
      if (paramd != null)
      {
        int i = paramd.getData().getInt("scene_end_listener_hash_code");
        ad.i(this.TAG, "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(eiZ()) });
        ad.i(this.TAG, "edw onSceneEnd, type = " + paramd.getType() + ", errCode = " + paramd.getErrCode() + ", errType = " + paramd.getErrType());
        if (i != eiZ())
        {
          ad.e(this.TAG, "hash code not equal");
          AppMethodBeat.o(188787);
          return false;
        }
        localh = this.AMZ;
        switch (paramd.getType())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(188787);
        return true;
        h.a(localh, 106);
        localh.onFinish();
        continue;
        h.a(localh, 666);
        localh.onFinish();
      }
    }
    
    public final int eiZ()
    {
      AppMethodBeat.i(188786);
      int i = ((Number)this.AKQ.getValue()).intValue();
      AppMethodBeat.o(188786);
      return i;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Integer>
    {
      a(h.p paramp)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    q(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class r
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    final String AMS = "weixin://private/gethtml/";
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188791);
      d.g.b.k.h(paramString, "url");
      paramString = paramString.substring(this.AMS.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      try
      {
        paramString = URLDecoder.decode(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("nowUrl", h.f(this.AML));
        localBundle.putString("tweetid", bt.nullAsNil(this.AML.getIntent().getStringExtra("tweetid")));
        localBundle.putString("htmlData", paramString);
        localBundle.putInt("type", this.AML.getIntent().getIntExtra("type", 0));
        this.AML.eiX().a(3, localBundle, this.AML.eiZ());
        AppMethodBeat.o(188791);
        return true;
      }
      catch (Exception paramString)
      {
        ad.e(h.a(this.AML), "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(188791);
      }
      return false;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188790);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188790);
        return false;
      }
      boolean bool = x.A(paramString, this.AMS);
      AppMethodBeat.o(188790);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class s
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String ANb = "weixin://viewimage/";
    
    s(MMWebView paramMMWebView) {}
    
    public final boolean avC(String paramString)
    {
      AppMethodBeat.i(188793);
      d.g.b.k.h(paramString, "url");
      try
      {
        if (!this.AML.eiX().isSDCardAvailable())
        {
          this.AML.eiX().a(2, null, this.AML.eiZ());
          AppMethodBeat.o(188793);
          return true;
        }
      }
      catch (Exception paramString)
      {
        ad.e(h.a(this.AML), "edw handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(188793);
        return false;
      }
      h localh = this.AML;
      paramString = paramString.substring(this.ANb.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      h.a(localh, paramString);
      ad.i(h.a(this.AML), "viewimage currentUrl :" + h.f(this.AML));
      x.a((WebView)paramMMWebView, h.g(this.AML).AMS, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", h.h(this.AML));
      AppMethodBeat.o(188793);
      return true;
    }
    
    public final boolean avD(String paramString)
    {
      AppMethodBeat.i(188792);
      d.g.b.k.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(188792);
        return false;
      }
      boolean bool = x.A(paramString, this.ANb);
      AppMethodBeat.o(188792);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"})
  final class t
  {
    private final h AMZ;
    private volatile String ANc;
    private volatile String ANd;
    private int fromScene;
    private long lro;
    private int networkType;
    private String userAgent;
    
    public t()
    {
      AppMethodBeat.i(188797);
      this.AMZ = localObject;
      this$1 = this.AMZ.nhy.getSettings();
      d.g.b.k.g(h.this, "controller.viewWV.settings");
      this$1 = h.this.getUserAgentString();
      d.g.b.k.g(h.this, "controller.viewWV.settings.userAgentString");
      this.userAgent = h.this;
      this.fromScene = this.AMZ.getIntent().getIntExtra("from_scence", 0);
      this.ANc = "";
      this.ANd = "";
      AppMethodBeat.o(188797);
    }
    
    private void ejy()
    {
      AppMethodBeat.i(188795);
      Context localContext = this.AMZ.getContext();
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
        localObject = this.AMZ.getContext();
      }
      int i;
      if (ay.isConnected((Context)localObject))
      {
        if (!ay.isWifi((Context)localObject)) {
          break label108;
        }
        i = 1;
      }
      for (;;)
      {
        this.networkType = i;
        ad.i(h.a(h.this), "get networkType " + this.networkType);
        AppMethodBeat.o(188795);
        return;
        label108:
        if (ay.is4G((Context)localObject)) {
          i = 4;
        } else if (ay.is3G((Context)localObject)) {
          i = 3;
        } else if (ay.is2G((Context)localObject)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
    
    public final void n(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(188796);
      d.g.b.k.h(paramString, "targetUrl");
      ejy();
      String str5 = this.AMZ.avx(this.ANd);
      if (this.fromScene != 0) {
        this.ANc = " ";
      }
      boolean bool = this.AMZ.kxg.emS().eBQ();
      ad.d(h.a(h.this), "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.lro > 0L) && (h.b(h.this) > this.lro) && (paramLong > h.b(h.this)) && (!TextUtils.isEmpty((CharSequence)str5)) && (bool))
      {
        l1 = h.b(h.this) - this.lro;
        l2 = paramLong - h.b(h.this);
        ad.d(h.a(h.this), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.lro), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.userAgent, this.ANd, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.ANc });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.p.encode(bt.nullAsNil(this.userAgent), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.p.encode(bt.nullAsNil(this.ANd), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.p.encode(bt.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str4 = com.tencent.mm.compatible.util.p.encode(bt.nullAsNil(this.ANc), "UTF-8");
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
          ad.printErrStackTrace(h.a(h.this), (Throwable)localUnsupportedEncodingException, "", new Object[0]);
          String str2 = "";
          localObject4 = localObject1;
        }
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(13376, new Object[] { Long.valueOf(this.lro), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.ANc = this.ANd;
        this.ANd = paramString;
        this.lro = paramLong;
      }
      AppMethodBeat.o(188796);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(h.t paramt, String paramString, long paramLong) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(188794);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.ANe.n(this.ANf, this.ANg, this.ANh);
        AppMethodBeat.o(188794);
        return false;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(h paramh, Uri paramUri) {}
    
    public final void run()
    {
      AppMethodBeat.i(188798);
      com.tencent.mm.pluginsdk.model.app.h.h(this.AML.getContext(), localUri);
      AppMethodBeat.o(188798);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Ljava/util/HashSet;", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.a<HashSet<String>>
  {
    v(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    w(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    x(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    y(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/core/WebViewController$oauthDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"})
  public static final class z
    implements ag.c
  {
    private static void c(Dialog paramDialog)
    {
      AppMethodBeat.i(188807);
      if ((paramDialog != null) && (paramDialog.isShowing()))
      {
        paramDialog.dismiss();
        paramDialog.setCancelMessage(null);
        paramDialog.setDismissMessage(null);
      }
      AppMethodBeat.o(188807);
    }
    
    public final void avE(String paramString)
    {
      AppMethodBeat.i(188803);
      d.g.b.k.h(paramString, "url");
      this.AML.k(paramString, true, 9);
      AppMethodBeat.o(188803);
    }
    
    public final void bVS()
    {
      AppMethodBeat.i(188806);
      c((Dialog)h.c(this.AML));
      AppMethodBeat.o(188806);
    }
    
    public final void d(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(188805);
      d.g.b.k.h(paramOnCancelListener, "cancelListener");
      c((Dialog)h.c(this.AML));
      h.a(this.AML, com.tencent.mm.ui.base.h.b(this.AML.getContext(), this.AML.getContext().getString(2131761776), true, paramOnCancelListener));
      AppMethodBeat.o(188805);
    }
    
    public final void goBack()
    {
      AppMethodBeat.i(188804);
      Iterator localIterator = ((Iterable)this.AML.AKY).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).ejA();
      }
      AppMethodBeat.o(188804);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.h
 * JD-Core Version:    0.7.0.1
 */