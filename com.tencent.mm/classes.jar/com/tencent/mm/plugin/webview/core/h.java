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
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.au;
import com.tencent.mm.plugin.webview.model.aw;
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
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import d.a.ae;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "OauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1;", "ReaderShareHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;)V", "pageEndTime", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "kotlin.jvm.PlatformType", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "getWebviewReportMgr", "()Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "", "", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getCachedAppId", "getScene", "username", "getWebViewPluginClientProxy", "handleUrl", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "loadUrl", "httpHeaders", "withoutCache", "needSyncGetA8Key", "onBinded", "onDestroy", "onJsReady", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "overrideProcessResult", "resp", "overrideUrl", "webView", "removeSceneEnd", "requestSetFontSize", "fontSize", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "Companion", "SceneEndCallbacker", "VisitInfoReport", "plugin-webview_release"})
public class h
  extends BaseWebViewController
{
  public static final d DIh;
  private final d.f DHA;
  private final d.f DHB;
  public String DHC;
  private final d.f DHD;
  private final String DHE;
  private final Set<String> DHF;
  private final d.f DHG;
  private com.tencent.mm.ui.base.p DHH;
  private final ag.c DHI;
  ag.a DHJ;
  private long DHK;
  private final List<com.tencent.mm.plugin.webview.c.d.a> DHL;
  private final l DHM;
  private final j DHN;
  private final e DHO;
  private final k DHP;
  private final n DHQ;
  private final a DHR;
  private String DHS;
  private final boolean DHT;
  private final s DHU;
  private final i DHV;
  private final r DHW;
  private final m DHX;
  private final g DHY;
  private final b DHZ;
  private final d.f DHu;
  private final d.f DHv;
  private final d.f DHw;
  private final d.f DHx;
  private final d.f DHy;
  public final ar DHz;
  private final o DIa;
  private final c DIb;
  private long DIc;
  private final f DId;
  private final h DIe;
  public com.tencent.luggage.xweb_ext.extendplugin.b.c DIf;
  public final com.tencent.mm.plugin.webview.model.ay DIg;
  private final d.f omn;
  
  static
  {
    AppMethodBeat.i(207562);
    DIh = new d((byte)0);
    AppMethodBeat.o(207562);
  }
  
  public h(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.model.ay paramay, BaseWebViewController.c paramc)
  {
    this(paramMMWebView, paramay, paramc, null);
    AppMethodBeat.i(207560);
    AppMethodBeat.o(207560);
  }
  
  public h(final MMWebView paramMMWebView, com.tencent.mm.plugin.webview.model.ay paramay, BaseWebViewController.c paramc, Set<String> paramSet)
  {
    super(paramMMWebView, paramc, paramSet);
    AppMethodBeat.i(207559);
    this.DIg = paramay;
    this.omn = d.g.O((d.g.a.a)new q(this));
    this.DHu = d.g.O((d.g.a.a)aj.DIM);
    this.DHv = d.g.O((d.g.a.a)new v(this));
    this.DHw = d.g.O((d.g.a.a)new x(this));
    this.DHx = d.g.O((d.g.a.a)new w(this));
    this.DHy = d.g.O((d.g.a.a)new ak(this));
    this.DHz = new ar(getContext());
    this.DHA = d.g.O((d.g.a.a)new y(this));
    this.DHB = d.g.O((d.g.a.a)new ai(this, paramMMWebView));
    this.DHD = d.g.O((d.g.a.a)ag.DIL);
    this.DHE = "file:///android_asset/jsapi/wxjs.js";
    this.DHF = ((Set)new HashSet());
    this.DHG = d.g.O((d.g.a.a)new ah(this));
    this.DHI = ((ag.c)new z(this));
    this.DHJ = ((ag.a)new aa(this));
    this.DHL = ((List)new ArrayList());
    this.DHM = new l(this);
    this.DHN = new j(this);
    this.DHO = new e(this);
    this.DHP = new k(this);
    this.DHQ = new n(this);
    this.DHR = new a(this);
    this.DHT = true;
    this.DHU = new s(this, paramMMWebView);
    this.DHV = new i(this);
    this.DHW = new r(this);
    this.DHX = new m(this);
    this.DHY = new g(this);
    this.DHZ = new b(this);
    this.DIa = new o(this);
    this.DIb = new c(this);
    this.DId = new f(this, paramMMWebView);
    this.DIe = new h(this);
    AppMethodBeat.o(207559);
  }
  
  private final boolean aGm(String paramString)
  {
    AppMethodBeat.i(207551);
    if (bt.isNullOrNil(paramString))
    {
      ad.e(getTAG(), "search contact err: null or nill url");
      AppMethodBeat.o(207551);
      return false;
    }
    eNH();
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", eNG().eNj());
    try
    {
      eNh().y(106, localBundle);
      AppMethodBeat.o(207551);
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
  
  private final boolean aGn(String paramString)
  {
    AppMethodBeat.i(207552);
    ad.i(getTAG(), "dealCustomScheme, url = ".concat(String.valueOf(paramString)));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(207552);
      return false;
    }
    try
    {
      if (eNh().fE(paramString))
      {
        ad.i(getTAG(), "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(paramString)));
        eNh().fL(paramString, eNj());
        AppMethodBeat.o(207552);
        return true;
      }
    }
    catch (Exception localException1)
    {
      ad.w(getTAG(), "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      final Uri localUri = Uri.parse(paramString);
      Object localObject2;
      if ((localUri != null) && (!d.n.n.nz(paramString, "weixin://")) && (!d.n.n.nz(paramString, "http")))
      {
        if (d.n.n.nz(paramString, "tel:"))
        {
          paramString = d.n.n.h(paramString, "tel:", "", false);
          if (!bt.isNullOrNil(paramString)) {}
          try
          {
            eNh().fN(paramString, eNj());
            AppMethodBeat.o(207552);
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
        if ((d.n.n.nz(paramString, "sms:")) || (d.n.n.nz(paramString, "smsto:")))
        {
          localObject1 = new Intent("android.intent.action.SENDTO", localUri);
          ((Intent)localObject1).addFlags(268435456);
          try
          {
            paramString = getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(207552);
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
        if (d.n.n.nz(paramString, "mailto:"))
        {
          paramString = new Intent("android.intent.action.SENDTO");
          paramString.addFlags(268435456);
          paramString.setData(localUri);
          try
          {
            localObject1 = getContext();
            paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahp(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)paramString.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(207552);
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
          if ((!this.lvw.eRh().fgk()) && (eNh().eRt()))
          {
            ad.e(getTAG(), "dealCustomScheme, not allow outer open url");
            AppMethodBeat.o(207552);
            return true;
          }
          i = getIntent().getIntExtra("key_download_restrict", 0);
          localObject1 = getIntent().getStringExtra("key_function_id");
          if (!bt.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.g.yhR.f(14596, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(1) });
          }
          if (i == 1)
          {
            ad.e(getTAG(), "not allow launch app by custom scheme : %s", new Object[] { paramString });
            AppMethodBeat.o(207552);
            return true;
          }
        }
        catch (RemoteException localRemoteException)
        {
          ad.printErrStackTrace(getTAG(), (Throwable)localRemoteException, "", new Object[0]);
          long l = bt.aQJ() - this.DHK;
          ad.i(getTAG(), "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
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
              ad.i(getTAG(), "formate url failed");
            }
            localObject2 = new Intent("android.intent.action.VIEW", localUri);
            ((Intent)localObject2).addFlags(268435456);
            if (!bt.aj(getContext(), (Intent)localObject2)) {
              break label1005;
            }
            paramString = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(207552);
            return true;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(13983, new Object[] { Integer.valueOf(4), localObject2, paramString });
          if (getIntent().getBooleanExtra("show_openapp_dialog", true))
          {
            bool = com.tencent.mm.ci.a.post((Runnable)new u(this, localUri));
            AppMethodBeat.o(207552);
            return bool;
          }
        }
      }
      label1005:
      AppMethodBeat.o(207552);
    }
    return false;
  }
  
  private boolean aGp(String paramString)
  {
    AppMethodBeat.i(207555);
    d.g.b.p.h(paramString, "url");
    Iterator localIterator = this.DHL.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.c.d.a locala = (com.tencent.mm.plugin.webview.c.d.a)localIterator.next();
      if (locala.aGq(paramString))
      {
        ad.i(getTAG(), "url handled, url = ".concat(String.valueOf(paramString)));
        boolean bool = locala.aGp(paramString);
        ad.i(getTAG(), "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(207555);
        return true;
      }
    }
    AppMethodBeat.o(207555);
    return false;
  }
  
  private final String eNB()
  {
    AppMethodBeat.i(207523);
    if (!Ws(this.DGv))
    {
      AppMethodBeat.o(207523);
      return "";
    }
    String str = getIntent().getStringExtra("KPublisherId");
    AppMethodBeat.o(207523);
    return str;
  }
  
  private final t eNC()
  {
    AppMethodBeat.i(207524);
    t localt = (t)this.DHy.getValue();
    AppMethodBeat.o(207524);
    return localt;
  }
  
  private final com.tencent.mm.plugin.webview.ui.tools.c eND()
  {
    AppMethodBeat.i(207526);
    com.tencent.mm.plugin.webview.ui.tools.c localc = (com.tencent.mm.plugin.webview.ui.tools.c)this.DHB.getValue();
    AppMethodBeat.o(207526);
    return localc;
  }
  
  private final com.tencent.mm.plugin.webview.modeltools.n eNE()
  {
    AppMethodBeat.i(207529);
    com.tencent.mm.plugin.webview.modeltools.n localn = (com.tencent.mm.plugin.webview.modeltools.n)this.DHD.getValue();
    AppMethodBeat.o(207529);
    return localn;
  }
  
  private final p eNG()
  {
    AppMethodBeat.i(207549);
    p localp = (p)this.DHG.getValue();
    AppMethodBeat.o(207549);
    return localp;
  }
  
  private final void eNH()
  {
    AppMethodBeat.i(207550);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 106);
      localBundle.putInt("scene_end_listener_hash_code", eNG().eNj());
      eNh().a(5, localBundle, eNG().eNj());
      AppMethodBeat.o(207550);
      return;
    }
    catch (Exception localException)
    {
      ad.e(getTAG(), "addSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(207550);
    }
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(207519);
    String str = (String)this.omn.getValue();
    AppMethodBeat.o(207519);
    return str;
  }
  
  public final void Wu(int paramInt)
  {
    AppMethodBeat.i(207548);
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
    com.tencent.e.h.LTJ.aP((Runnable)new af(this, i));
    AppMethodBeat.o(207548);
  }
  
  protected boolean XM(String paramString)
  {
    return false;
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(207540);
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
      AppMethodBeat.o(207540);
      return;
    }
    try
    {
      parame.a((com.tencent.mm.plugin.webview.stub.f)eNG(), eNG().eNj());
      super.a(parame);
      AppMethodBeat.o(207540);
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
    AppMethodBeat.i(207528);
    if (!Ws(this.DGv))
    {
      ad.i(getTAG(), "onReceivedError, intent not ready");
      AppMethodBeat.o(207528);
      return;
    }
    Object localObject = ac.DIG;
    localObject = new ad(this);
    com.tencent.xweb.util.g.zN(false);
    boolean bool = com.tencent.mm.sdk.platformtools.ay.isConnected(getContext());
    ad.e(getTAG(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(155L, com.tencent.mm.plugin.webview.h.a.WW(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.i.fi(eNB(), 1);
    com.tencent.mm.plugin.topstory.a.i.fi(eNB(), com.tencent.mm.plugin.webview.h.a.WW(paramInt));
    com.tencent.mm.plugin.topstory.a.i.g(eNB(), bQm(), com.tencent.mm.plugin.webview.h.a.WW(paramInt), this.DIg.eQC().enterTime);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    k.EbJ.Xx(paramInt);
    this.DIg.eQK().errCode = paramInt;
    com.tencent.mm.plugin.webview.ui.tools.m localm = com.tencent.mm.plugin.webview.ui.tools.m.Ecx;
    com.tencent.mm.plugin.webview.ui.tools.m.setErrCode(paramInt);
    if (((Boolean)this.DHx.getValue()).booleanValue()) {
      onFinish();
    }
    try
    {
      if (d.g.b.p.i(new URL(paramString2).getHost(), "mp.weixin.qq.com")) {
        com.tencent.e.h.LTJ.f((Runnable)new ae(paramString2, paramInt, (ad)localObject, "mp.weixin.qq.com"), "WebViewUI.CheckDNS");
      }
      super.a(paramWebView, paramInt, paramString1, paramString2);
      AppMethodBeat.o(207528);
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
  
  public final void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(207527);
    if (!Ws(this.DGv))
    {
      ad.i(getTAG(), "onReceivedSslError, intent not ready");
      AppMethodBeat.o(207527);
      return;
    }
    com.tencent.xweb.util.g.zN(true);
    String str;
    if (paramWebView != null)
    {
      str = paramWebView.getUrl();
      if (str != null) {
        break label213;
      }
      str = this.DFY;
      label59:
      if (str == null) {
        break label222;
      }
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      d.g.b.p.g(localObject, "MMKernel.service(IBrandService::class.java)");
      localObject = ((com.tencent.mm.plugin.brandservice.a.b)localObject).bNi();
      d.g.b.p.g(localObject, "MMKernel.service(IBrandS…::class.java).hardCodeUrl");
      if (!d.n.n.nz(str, (String)localObject)) {
        break label222;
      }
      str = bQm();
    }
    label213:
    label222:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.i.fi(eNB(), 1);
      com.tencent.mm.plugin.topstory.a.i.fi(eNB(), 30);
      com.tencent.mm.plugin.topstory.a.i.g(eNB(), bQm(), 30, this.DIg.eQC().enterTime);
      eND().a(str, paramr, paramSslError);
      super.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(207527);
      return;
      str = null;
      break;
      str = paramWebView.getUrl();
      break label59;
    }
  }
  
  protected final boolean a(int paramInt, String paramString, avj paramavj)
  {
    AppMethodBeat.i(207538);
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavj, "resp");
    int i = paramavj.FqN;
    String str = paramavj.Guc;
    switch (i)
    {
    default: 
      boolean bool = super.a(paramInt, paramString, paramavj);
      AppMethodBeat.o(207538);
      return bool;
    case 3: 
      ad.i(getTAG(), "getA8key-app: ".concat(String.valueOf(str)));
      paramString = (CharSequence)str;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        ad.e(getTAG(), "getA8key-app, fullUrl is null");
        AppMethodBeat.o(207538);
        return false;
      }
      aGn(str);
      AppMethodBeat.o(207538);
      return true;
    case 4: 
      d.g.b.p.g(str, "fullUrl");
      aGm(str);
      AppMethodBeat.o(207538);
      return true;
    }
    d.g.b.p.g(str, "fullUrl");
    eNH();
    paramString = new Bundle();
    paramString.putString("emoji_store_jump_url", str);
    paramString.putInt("webview_binder_id", eNG().eNj());
    try
    {
      eNh().y(666, paramString);
      AppMethodBeat.o(207538);
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
  
  /* Error */
  public final String aGj(String paramString)
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
    //   29: invokevirtual 699	com/tencent/mm/plugin/webview/core/h:eNj	()I
    //   32: invokevirtual 594	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: aload_2
    //   36: ldc_w 1227
    //   39: aload_1
    //   40: invokevirtual 659	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 608	com/tencent/mm/plugin/webview/core/h:eNh	()Lcom/tencent/mm/plugin/webview/stub/e;
    //   47: bipush 76
    //   49: aload_2
    //   50: invokeinterface 1231 3 0
    //   55: ldc_w 1233
    //   58: invokevirtual 1236	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 1239	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
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
    //   87: invokestatic 875	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   121: invokestatic 736	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final int aGo(String paramString)
  {
    AppMethodBeat.i(207554);
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
        bool = Ws(this.DGu);
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
      AppMethodBeat.o(207554);
      return i;
      i = 0;
      break;
      if (eNh().Ap(paramString))
      {
        i = 8;
      }
      else
      {
        if (eNh().zE(paramString))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("enterprise_biz_username", paramString);
          try
          {
            paramString = eNh().k(102, (Bundle)localObject);
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
  
  protected final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest, Bundle paramBundle)
  {
    AppMethodBeat.i(207533);
    d.g.b.p.h(paramWebView, "webview");
    d.g.b.p.h(paramWebResourceRequest, "request");
    if ((isStarted()) && (Ws(this.DGu)))
    {
      Object localObject = this.DHz;
      String str = paramWebResourceRequest.getUrl().toString();
      if (!((Boolean)this.DHA.getValue()).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = ((ar)localObject).a(str, paramWebResourceRequest, bool, eNh());
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(207533);
        return localObject;
      }
    }
    paramWebView = super.b(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(207533);
    return paramWebView;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(207532);
    super.b(paramWebView, paramString);
    this.DGl.bL("onPageFinished", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.omW, paramString);
    if (XM(paramString))
    {
      AppMethodBeat.o(207532);
      return;
    }
    ad.i(getTAG(), "edw onPageFinished opt, url = %s", new Object[] { paramString });
    this.DIg.eQJ().cE(paramString);
    k.EbJ.CA();
    eNE().Ej(paramString);
    boolean bool = getIntent().getBooleanExtra("shouldForceViewPort", false);
    ad.d(getTAG(), "hy: shouldForceViewPort: ".concat(String.valueOf(bool)));
    Object localObject;
    if (bool)
    {
      localObject = getIntent().getStringExtra("view_port_code");
      if (paramWebView == null) {
        d.g.b.p.gfZ();
      }
      paramWebView.evaluateJavascript((String)localObject, null);
    }
    if (paramString == null) {
      d.g.b.p.gfZ();
    }
    if (aGi(paramString))
    {
      ad.f(getTAG(), "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(207532);
      return;
    }
    if (d.g.b.p.i(paramString, this.DHE))
    {
      ad.i(getTAG(), "onPageFinished, js is finished loaded");
      AppMethodBeat.o(207532);
      return;
    }
    this.DIg.eQz().aHK(paramString);
    this.DIg.eQA().aHI(paramString);
    this.DIg.eQD().report();
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      localObject = paramWebView.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.DIg.eQK().wRC = ((SnsAdClick)localObject);
        localObject = this.DIg.eQK();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.p.g(paramWebView, "uxInfo");
        ((au)localObject).R(new String[] { paramString, "1", str, paramWebView });
        this.DIg.eQK().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.Ecx;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, true);
    this.DHK = bt.aQJ();
    AppMethodBeat.o(207532);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(207530);
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    super.b(paramWebView, paramString, paramBitmap);
    this.DGl.bL("onPageStarted", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.omW, paramString);
    if (XM(paramString))
    {
      AppMethodBeat.o(207530);
      return;
    }
    if (!this.omW.supportFeature(2006)) {
      getJsapi().eOK();
    }
    com.tencent.mm.plugin.webview.j.j.h(paramString, getContext());
    ad.i(getTAG(), "edw onPageStarted opt, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.i.fi(eNB(), 0);
    if ((com.tencent.mm.sdk.a.b.fjN()) && (d.g.b.p.i("http://www.dktest-mmcrash.com/", paramString))) {
      Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    }
    this.DHC = this.DFY;
    long l = bt.aQJ();
    paramWebView = eNC();
    d.g.b.p.h(paramString, "targetUrl");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new h.t.a(paramWebView, paramString, l));
    this.DIg.eQB().DUE = this.DHC;
    this.DFY = paramString;
    k.EbJ.cD(paramString);
    ad.d(getTAG(), "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { this.DHC, this.DFY });
    if (aGi(paramString))
    {
      ad.f(getTAG(), "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(207530);
      return;
    }
    eNE().Ej(paramString);
    this.DIg.eQz().cB(bpm(), eNB()).aHJ(paramString);
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      paramBitmap = paramWebView.getParcelable("KSnsAdTag");
      if ((paramBitmap != null) && ((paramBitmap instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.DIg.eQK().wRC = ((SnsAdClick)paramBitmap);
        paramBitmap = this.DIg.eQK();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.p.g(paramWebView, "uxInfo");
        paramBitmap.R(new String[] { paramString, "0", str, paramWebView });
        this.DIg.eQK().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.Ecx;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, false);
    AppMethodBeat.o(207530);
  }
  
  public final void b(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207531);
    d.g.b.p.h(paramWebView, "view");
    d.g.b.p.h(paramString, "url");
    this.DFY = paramString;
    super.b(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(207531);
  }
  
  public final boolean b(int paramInt, String paramString, avj paramavj)
  {
    AppMethodBeat.i(207536);
    d.g.b.p.h(paramString, "reqUrl");
    d.g.b.p.h(paramavj, "response");
    Object localObject = paramavj.Guk;
    if (localObject != null) {}
    for (long l = ((acm)localObject).GbW;; l = -1L)
    {
      this.DIc = l;
      boolean bool = this.omW.getIsX5Kernel();
      localObject = paramavj.Guc;
      d.g.b.p.g(localObject, "response.FullURL");
      com.tencent.mm.plugin.webview.model.ay.aI(bool, d.n.n.nz((String)localObject, "https://"));
      this.DIg.eQy().co(paramString, true);
      this.DIg.eQA().cA(com.tencent.mm.plugin.webview.ui.tools.game.h.dOE, eNB()).aHG(paramavj.Guc);
      bool = super.b(paramInt, paramString, paramavj);
      AppMethodBeat.o(207536);
      return bool;
    }
  }
  
  protected final Class<? extends Service> bOJ()
  {
    AppMethodBeat.i(207520);
    Class localClass = (Class)this.DHu.getValue();
    AppMethodBeat.o(207520);
    return localClass;
  }
  
  protected void bQs()
  {
    AppMethodBeat.i(207543);
    if (aGp(bQm()))
    {
      AppMethodBeat.o(207543);
      return;
    }
    if (bQt())
    {
      BaseWebViewController.a(this, bQm(), false, 0, 6);
      AppMethodBeat.o(207543);
      return;
    }
    ad.i(getTAG(), "terry onStartLoad:" + bQm());
    Object localObject3 = eNl();
    Object localObject1 = (CharSequence)localObject3;
    int i;
    if ((localObject1 == null) || (d.n.n.aE((CharSequence)localObject1))) {
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
          localObject1 = eNh().aIr((String)localObject3);
          localObject3 = this.omW.getSettings();
          d.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setUseWideViewPort(false);
          localObject3 = this.omW.getSettings();
          d.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setLoadWithOverviewMode(false);
          localObject3 = this.omW.getSettings();
          d.g.b.p.g(localObject3, "viewWV.settings");
          ((com.tencent.xweb.z)localObject3).setJavaScriptEnabled(false);
          uT(true);
          this.omW.loadDataWithBaseURL(null, (String)localObject1, "text/html", "utf-8", null);
          ad.i(getTAG(), "loadDataWithBaseUrl, data = ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(207543);
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
    if (aGi(bQm()))
    {
      ad.f(getTAG(), "postBinded 2, canLoadUrl fail, url = " + bQm());
      AppMethodBeat.o(207543);
      return;
    }
    if (this.DGU.DHc) {
      this.lvw.a(bQm(), null, null);
    }
    Object localObject2 = ((Iterable)this.DGm).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((j)((Iterator)localObject2).next()).aGw(bQm()))
      {
        AppMethodBeat.o(207543);
        return;
      }
    }
    if (this.omW.fLC())
    {
      AppMethodBeat.o(207543);
      return;
    }
    uT(false);
    BaseWebViewController.a(this, bQm(), null, 6);
    AppMethodBeat.o(207543);
  }
  
  protected boolean bQt()
  {
    AppMethodBeat.i(207544);
    Object localObject = ((Iterable)this.DGm).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((j)((Iterator)localObject).next()).aGx(bQm()))
      {
        AppMethodBeat.o(207544);
        return false;
      }
    }
    localObject = (CharSequence)getIntent().getStringExtra("data");
    if ((localObject == null) || (d.n.n.aE((CharSequence)localObject))) {}
    for (int i = 1; (i != 0) && (!this.DGU.DHc); i = 0)
    {
      AppMethodBeat.o(207544);
      return true;
    }
    AppMethodBeat.o(207544);
    return false;
  }
  
  protected final void bRf()
  {
    AppMethodBeat.i(207535);
    int j = 2;
    int i = j;
    try
    {
      if (eNh().eRt()) {
        if (!this.DGU.DHb) {
          break label147;
        }
      }
      label147:
      for (i = com.tencent.mm.plugin.webview.j.f.a(getContext(), eNh(), bQm());; i = com.tencent.mm.plugin.webview.j.f.hd(getContext()))
      {
        Wu(i);
        String str = this.omW.getUrl();
        if (bt.isNullOrNil(str)) {
          break label210;
        }
        Object localObject = this.DHF;
        if (str == null) {
          d.g.b.p.gfZ();
        }
        if (!((Set)localObject).add(str)) {
          break label210;
        }
        localObject = this.lvw.eRh();
        d.g.b.p.g(localObject, "wvPerm.genCtrl");
        if (((GeneralControlWrapper)localObject).fgn()) {
          getJsapi().eOF();
        }
        if (!((GeneralControlWrapper)localObject).fgo()) {
          break;
        }
        getJsapi().uZ(false);
        AppMethodBeat.o(207535);
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
      if (this.DHz.aHx(localException)) {
        getJsapi().uZ(true);
      }
      label210:
      super.bRf();
      AppMethodBeat.o(207535);
    }
  }
  
  public final int bpm()
  {
    AppMethodBeat.i(207553);
    int i = aGo(getIntent().getStringExtra("geta8key_username"));
    AppMethodBeat.o(207553);
    return i;
  }
  
  protected final void dWE()
  {
    AppMethodBeat.i(207542);
    if (eNq())
    {
      ad.e(getTAG(), "onBinded call when activity has been finished");
      AppMethodBeat.o(207542);
      return;
    }
    ad.i(getTAG(), "Abe-Debug onPostBindedStart");
    this.DGl.bL("onPostBindedStart", System.currentTimeMillis());
    k.EbJ.b(eNh());
    Object localObject1 = getIntent().getStringExtra("ad_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = k.EbJ;
      d.g.b.p.g(localObject2, "WebViewReportUtil.INSTANCE");
      ((k)localObject2).setTraceId((String)localObject1);
    }
    this.DGl.bL("onJSAPIStart", System.currentTimeMillis());
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
        eNh().a(20, (Bundle)localObject2, eNj());
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
        aw localaw = this.DIg.eQB();
        localaw.username = ((String)localObject3);
        localaw.DUF = i;
        localaw.dKk = bQm();
        localaw.DUB = j;
        localaw.scene = aGo((String)localObject3);
        localaw.DUA = l;
        localaw.DUC = new com.tencent.mm.b.p(l).toString();
        localaw.DNH = str1;
        localaw.DUz = ((String)localObject2);
        localaw.hDf = str2;
        localaw.appId = str4;
        localaw.DUD = str5;
        localaw.DUE = this.DHC;
        localaw.zRz = ((String)localObject1);
        localObject2 = getTitle();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localaw.title = ((String)localObject1);
        localaw.fkz = str3;
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
        localObject1 = this.DIg.eQC();
        ((ak)localObject1).hDf = str2;
        ((ak)localObject1).scene = aGo((String)localObject3);
        this.DIg.eQE().aHF(bQm());
        if (!eNF()) {}
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
            eNh().a(29, (Bundle)localObject1, eNj());
            label731:
            if (!bt.isNullOrNil(str1)) {}
            try
            {
              eNh().aIw(str1);
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
                  if ((localObject3 == null) || (d.n.n.aE((CharSequence)localObject3))) {}
                  for (i = 1; i == 0; i = 0)
                  {
                    localRemoteException.put("srcUsername", str1);
                    break;
                  }
                  i = 3;
                  ad.i(getTAG(), "default pay scene to: %s", new Object[] { Integer.valueOf(3) });
                }
                if (!this.omW.getIsX5Kernel()) {
                  break label1842;
                }
                com.tencent.mm.pluginsdk.ui.tools.p.ma(7);
                com.tencent.mm.plugin.report.service.g.yhR.a(64, 64, 1, 0, 1, 1, false);
                try
                {
                  i = bt.getInt(eNh().aIv("WebviewDisableDigestVerify"), 0);
                  ad.i(getTAG(), "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
                  if (i != 0) {
                    break label1806;
                  }
                  SharedPreferences localSharedPreferences = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                  d.g.b.p.g(localSharedPreferences, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
                  if ((!localSharedPreferences.getBoolean("wvsha1", true)) || (!this.DGU.DHa)) {
                    break label1806;
                  }
                  getJsapi().eOw();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    for (;;)
                    {
                      eNh().a(bQm(), true, null);
                      this.DGl.bL("onPostBindedEnd", System.currentTimeMillis());
                      AppMethodBeat.o(207542);
                      return;
                      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(64L, 0L, 1L, false);
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
              this.DHL.clear();
              localObject1 = getJsapi();
              str1 = getIntent().getStringExtra("geta8key_username");
              localObject2 = ae.b(new o[] { u.S("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0L))), u.S("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), u.S("scene", Integer.valueOf(aGo(str1))), u.S("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), u.S("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), u.S("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))) });
              localObject3 = (CharSequence)getIntent().getStringExtra("srcUsername");
              if ((localObject3 == null) || (d.n.n.aE((CharSequence)localObject3)))
              {
                i = 1;
                if (i != 0) {
                  break label1609;
                }
                ((Map)localObject2).putAll((Map)ae.c(new o[] { u.S("srcUsername", getIntent().getStringExtra("srcUsername")), u.S("srcDisplayname", getIntent().getStringExtra("srcDisplayname")) }));
                if (!bt.isNullOrNil(getIntent().getStringExtra("KTemplateId")))
                {
                  str1 = getIntent().getStringExtra("KTemplateId");
                  d.g.b.p.g(str1, "intent.getStringExtra(Co…UI.WebViewUI.KTemplateId)");
                  ((Map)localObject2).put("KTemplateId", str1);
                }
                i = getIntent().getIntExtra("pay_scene", -1);
                if (i == -1) {
                  break label1656;
                }
                ad.i(getTAG(), "get pay scene from extra: %s", new Object[] { Integer.valueOf(i) });
                ((Map)localObject2).put("pay_scene", Integer.valueOf(i));
                ((com.tencent.mm.plugin.webview.c.f)localObject1).bw((Map)localObject2);
                localObject1 = this.DHL;
                localObject2 = (List)new ArrayList();
                ((List)localObject2).add(getJsapi());
                ((List)localObject2).add(this.DHM);
                ((List)localObject2).add(this.DHN);
                ((List)localObject2).add(this.DHO);
                ((List)localObject2).add(this.DHP);
                ((List)localObject2).add(this.DHQ);
                ((List)localObject2).add(this.DHR);
                ((List)localObject2).add(this.DHU);
                ((List)localObject2).add(this.DHX);
                ((List)localObject2).add(this.DHY);
                ((List)localObject2).add(this.DHZ);
                ((List)localObject2).add(this.DIb);
                ((List)localObject2).add(this.DHW);
                ((List)localObject2).add(this.DIa);
                ((List)localObject2).add(this.DHV);
                if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
                  ((List)localObject2).add(this.DIe);
                }
                ((List)localObject2).add(this.DId);
                ((List)localObject1).addAll((Collection)localObject2);
                ad.i(getTAG(), "Abe-Debug controllerListeners call, size = %d", new Object[] { Integer.valueOf(this.DGo.size()) });
                localObject1 = ((Iterable)this.DGo).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  ((i)((Iterator)localObject1).next()).dWE();
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
                i = eNh().eRH();
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
  
  public final boolean eNF()
  {
    AppMethodBeat.i(207546);
    Object localObject = getIntent().getStringExtra("srcUsername");
    String str = getIntent().getStringExtra("bizofstartfrom");
    localObject = (CharSequence)localObject;
    if ((localObject == null) || (d.n.n.aE((CharSequence)localObject))) {}
    for (int i = 1; (i == 0) && (d.g.b.p.i(str, "enterpriseHomeSubBrand")); i = 0)
    {
      AppMethodBeat.o(207546);
      return true;
    }
    AppMethodBeat.o(207546);
    return false;
  }
  
  protected final Set<String> eNf()
  {
    AppMethodBeat.i(207521);
    Set localSet = (Set)this.DHv.getValue();
    AppMethodBeat.o(207521);
    return localSet;
  }
  
  protected final void eNo()
  {
    AppMethodBeat.i(207557);
    ad.i(getTAG(), "WebView-Trace setWebViewPluginClient");
    this.DIf = com.tencent.luggage.xweb_ext.extendplugin.d.a((WebView)this.omW, (com.tencent.luggage.xweb_ext.extendplugin.b.d)com.tencent.luggage.xweb_ext.extendplugin.b.b.GM(), (com.tencent.luggage.xweb_ext.extendplugin.a.c)com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g.eVj(), null);
    AppMethodBeat.o(207557);
  }
  
  public final boolean eNp()
  {
    AppMethodBeat.i(207541);
    ad.i(getTAG(), "edw onServiceDisconnected");
    Iterator localIterator = ((Iterable)this.DGm).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((j)localIterator.next()).eNO());
    for (int i = 1; i == 0; i = 0)
    {
      ad.i(getTAG(), "maybe mm process crash, try rebind service");
      AppMethodBeat.o(207541);
      return true;
    }
    boolean bool = super.eNp();
    AppMethodBeat.o(207541);
    return bool;
  }
  
  protected final void eNt()
  {
    AppMethodBeat.i(207539);
    super.eNt();
    com.tencent.mm.plugin.webview.h.b.eRp();
    Object localObject = ((Iterable)this.DGo).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((i)((Iterator)localObject).next()).a(this.DGl);
    }
    localObject = this.DGl;
    MMWebView localMMWebView = this.omW;
    d.g.a.a locala = (d.g.a.a)new ab(this);
    d.g.b.p.h(localMMWebView, "webView");
    d.g.b.p.h(locala, "callback");
    localMMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", (ValueCallback)new i.b((com.tencent.mm.plugin.webview.j.i)localObject, locala));
    AppMethodBeat.o(207539);
  }
  
  protected final void eNu()
  {
    AppMethodBeat.i(207558);
    ad.d(getTAG(), "setGetA8KeyParams");
    Object localObject = getIntent().getStringExtra("geta8key_username");
    eNg().setUsername((String)localObject);
    eNg().setScene(aGo((String)localObject));
    eNg().setAppId(getIntent().getStringExtra("geta8key_open_webview_appid"));
    localObject = this.omW;
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((MMWebView)localObject).getIsX5Kernel());
      if (!((Boolean)localObject).booleanValue()) {
        break label184;
      }
      eNg().setFlag(1);
    }
    for (;;)
    {
      eNg().ag(getIntent().getByteArrayExtra("geta8key_cookie"));
      eNg().WQ(getIntent().getIntExtra("key_wallet_region", 0));
      eNg().aId(getIntent().getStringExtra("key_function_id"));
      int i = getIntent().getIntExtra("geta8key_session_id", 0);
      if (i > 0) {
        eNg().WP(i);
      }
      AppMethodBeat.o(207558);
      return;
      localObject = null;
      break;
      label184:
      eNg().setFlag(0);
    }
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(207522);
    Object localObject2 = this.omW.getTitle();
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
    AppMethodBeat.o(207522);
    return localObject1;
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(207525);
    d.g.b.p.h(paramString, "url");
    ad.i(getTAG(), "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
    if (aGi(paramString))
    {
      ad.f(getTAG(), "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      super.h(paramWebView, paramString);
      AppMethodBeat.o(207525);
      return;
    }
    this.DIg.eQA().aHH(paramString);
    super.h(paramWebView, paramString);
    AppMethodBeat.o(207525);
  }
  
  protected final boolean k(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(207534);
    d.g.b.p.h(paramWebView, "webView");
    d.g.b.p.h(paramString, "url");
    ad.i(getTAG(), "WebView-Trace shouldOverride url = ".concat(String.valueOf(paramString)));
    Object localObject1 = j(paramWebView, paramString);
    boolean bool;
    if (((j.a)localObject1).DIP)
    {
      bool = ((j.a)localObject1).result;
      AppMethodBeat.o(207534);
      return bool;
    }
    if (aGi(paramString))
    {
      ad.f(getTAG(), "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(207534);
      return true;
    }
    if (com.tencent.luggage.h.c.a(paramString, "about:blank", true))
    {
      ad.e(getTAG(), "shouldOverride, url is about:blank");
      AppMethodBeat.o(207534);
      return true;
    }
    if (DownloadChecker.a(paramString, eNB(), paramWebView))
    {
      ad.i(getTAG(), "use the downloader to download");
      AppMethodBeat.o(207534);
      return true;
    }
    try
    {
      if ((com.tencent.luggage.h.c.a(paramString, "weixin://jump/", true)) || (com.tencent.luggage.h.c.a(paramString, "weixin://scanqrcode/", true)))
      {
        d.g.b.p.h(paramString, "url");
        bool = getIntent().getBooleanExtra(e.m.IVb, false);
        if ((this.lvw.eRh().fgl()) || (bool))
        {
          ad.i(getTAG(), "allowJumpWithoutPerm: ".concat(String.valueOf(bool)));
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("fromScene", 100);
          if (eNh().a(paramString, this.lvw.eRg().mz(7), (Bundle)localObject1)) {
            ad.i(getTAG(), "shouldOverride, built in url handled, url = ".concat(String.valueOf(paramString)));
          }
        }
        for (;;)
        {
          AppMethodBeat.o(207534);
          return true;
          ad.w(getTAG(), "shouldOverride, allow inner open url, not allow");
        }
      }
      Object localObject2;
      Object localObject3;
      int i;
      paramWebView = null;
    }
    catch (Exception localException)
    {
      ad.w(getTAG(), "shouldOverride, jumpToActivity, ex = " + localException.getMessage());
      while (aGp(paramString))
      {
        AppMethodBeat.o(207534);
        return true;
        if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/business")) && (com.tencent.mm.pluginsdk.g.v(Uri.parse(paramString))))
        {
          localObject2 = Uri.parse(bQm());
          d.g.b.p.g(localObject2, "rawUrlUri");
          localObject3 = ((Uri)localObject2).getHost();
          localObject2 = new Intent("android.intent.action.VIEW");
          ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
          ((Intent)localObject2).setData(Uri.parse(paramString + "&domain=" + (String)localObject3));
          i = ((Intent)localObject2).getIntExtra("pay_channel", -1);
          if (i != -1)
          {
            ad.i(getTAG(), "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
            ((Intent)localObject2).putExtra("pay_channel", i);
          }
          ((Intent)localObject2).putExtra("translate_link_scene", 13);
          localObject3 = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(207534);
          return true;
        }
        if (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe"))
        {
          ad.i(getTAG(), "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
        }
        else if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/common_view")) || (com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/phone_view")))
        {
          if (((com.tencent.luggage.h.c.A(bQm(), "https://support.weixin.qq.com/security")) || (com.tencent.luggage.h.c.A(paramString, "https://support.wechat.com/security"))) && (((Boolean)this.DHw.getValue()).booleanValue()))
          {
            com.tencent.mm.pluginsdk.g.bK(getContext(), paramString);
            onFinish();
            AppMethodBeat.o(207534);
            return true;
          }
        }
        else if ((com.tencent.luggage.h.c.A(paramString, "weixin://webview/initReady/")) || (com.tencent.luggage.h.c.A(paramString, "weixin://webview/preInjectJSBridge/")))
        {
          AppMethodBeat.o(207534);
          return true;
        }
      }
      if (com.tencent.luggage.h.c.A(paramString, "weixin://"))
      {
        ad.e(getTAG(), "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        AppMethodBeat.o(207534);
        return true;
      }
      ad.i(getTAG(), "edw overrideUrl");
      if ((com.tencent.luggage.h.c.A(paramString, "weixinping://iframe")) || (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe")))
      {
        AppMethodBeat.o(207534);
        return true;
      }
      if (aGn(paramString))
      {
        ad.i(getTAG(), "custom scheme url deal success, url = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(207534);
        return true;
      }
      if ((paramWebView instanceof MMWebView)) {}
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.model.a.a((MMWebView)paramWebView, paramString);
      AppMethodBeat.o(207534);
      return false;
    }
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(207545);
    d.g.b.p.h(paramString, "url");
    com.tencent.mm.plugin.webview.model.a.a(this.omW, paramString);
    super.loadUrl(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(207545);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(207556);
    eNC().p("", bt.aQJ(), 0);
    eND().detach();
    if (eNF()) {}
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
      eNh().a(30, localBundle, eNj());
      try
      {
        label75:
        eNh().Xk(eNG().eNj());
        super.onDestroy();
        AppMethodBeat.o(207556);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207452);
      d.g.b.p.h(paramString, "url");
      if (!this.DIi.lvw.eRh().fgl())
      {
        ad.e(h.a(this.DIi), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
        AppMethodBeat.o(207452);
        return true;
      }
      try
      {
        this.DIi.eNh().cq(paramString, this.DIi.lvw.eRg().mz(7));
        AppMethodBeat.o(207452);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.w(h.a(this.DIi), "ActivityJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207451);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207451);
        return false;
      }
      boolean bool = x.C(paramString, "weixin://jump/");
      AppMethodBeat.o(207451);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$oauthOnSceneEndDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"})
  public static final class aa
    implements ag.a
  {
    private final Map<Integer, Integer> DIF;
    
    aa()
    {
      AppMethodBeat.i(207504);
      this.DIF = ((Map)new HashMap());
      AppMethodBeat.o(207504);
    }
    
    public final void xj()
    {
      AppMethodBeat.i(207503);
      h.a(this.DIi, 1373);
      if (this.DIF.containsKey(Integer.valueOf(1373)))
      {
        Object localObject = this.DIF.get(Integer.valueOf(1373));
        if (localObject == null) {
          d.g.b.p.gfZ();
        }
        int i = ((Number)localObject).intValue();
        this.DIF.put(Integer.valueOf(1373), Integer.valueOf(i - 1));
        AppMethodBeat.o(207503);
        return;
      }
      this.DIF.put(Integer.valueOf(1373), Integer.valueOf(0));
      AppMethodBeat.o(207503);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class ab
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    ab(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"getNetWorkTypeName", "", "context", "Landroid/content/Context;", "invoke"})
  static final class ac
    extends d.g.b.q
    implements d.g.a.b<Context, String>
  {
    public static final ac DIG;
    
    static
    {
      AppMethodBeat.i(207508);
      DIG = new ac();
      AppMethodBeat.o(207508);
    }
    
    ac()
    {
      super();
    }
    
    public static String gP(Context paramContext)
    {
      AppMethodBeat.i(207507);
      d.g.b.p.h(paramContext, "context");
      if (com.tencent.mm.sdk.platformtools.ay.isWifi(paramContext))
      {
        AppMethodBeat.o(207507);
        return "wifi";
      }
      if (com.tencent.mm.sdk.platformtools.ay.is5G(paramContext))
      {
        AppMethodBeat.o(207507);
        return "5g";
      }
      if (com.tencent.mm.sdk.platformtools.ay.is4G(paramContext))
      {
        AppMethodBeat.o(207507);
        return "4g";
      }
      if (com.tencent.mm.sdk.platformtools.ay.is3G(paramContext))
      {
        AppMethodBeat.o(207507);
        return "3g";
      }
      if (com.tencent.mm.sdk.platformtools.ay.is2G(paramContext))
      {
        AppMethodBeat.o(207507);
        return "2g";
      }
      AppMethodBeat.o(207507);
      return "none";
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"dnsIps", "", "host", "invoke"})
  static final class ad
    extends d.g.b.q
    implements d.g.a.b<String, String>
  {
    ad(h paramh)
    {
      super();
    }
    
    public final String aGs(String paramString)
    {
      AppMethodBeat.i(207510);
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
        ad.printErrStackTrace(h.a(this.DIi), (Throwable)paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(207510);
        return null;
      }
      AppMethodBeat.o(207510);
      return paramString;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(String paramString1, int paramInt, h.ad paramad, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(207511);
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
      String str = this.DIH;
      int i = paramInt;
      Object localObject = h.ac.DIG;
      localObject = aj.getContext();
      d.g.b.p.g(localObject, "MMApplicationContext.getContext()");
      localg.f(17082, new Object[] { str, Integer.valueOf(i), h.ac.gP((Context)localObject), this.DII.aGs(this.DIJ) });
      AppMethodBeat.o(207511);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(h paramh, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(207512);
      this.DIi.getJsapi().Wv(i);
      Object localObject = this.DIi;
      int i = i;
      localObject = ((Iterable)((BaseWebViewController)localObject).DGo).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).Wv(i);
      }
      AppMethodBeat.o(207512);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "invoke"})
  static final class ag
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.webview.modeltools.n>
  {
    public static final ag DIL;
    
    static
    {
      AppMethodBeat.i(207514);
      DIL = new ag();
      AppMethodBeat.o(207514);
    }
    
    ag()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "invoke"})
  static final class ah
    extends d.g.b.q
    implements d.g.a.a<h.p>
  {
    ah(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "invoke"})
  static final class ai
    extends d.g.b.q
    implements d.g.a.a<com.tencent.mm.plugin.webview.ui.tools.c>
  {
    ai(h paramh, MMWebView paramMMWebView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;", "invoke"})
  static final class aj
    extends d.g.b.q
    implements d.g.a.a<Class<WebViewStubService>>
  {
    public static final aj DIM;
    
    static
    {
      AppMethodBeat.i(207517);
      DIM = new aj();
      AppMethodBeat.o(207517);
    }
    
    aj()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "invoke"})
  static final class ak
    extends d.g.b.q
    implements d.g.a.a<h.t>
  {
    ak(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIj = "weixin://addfriend/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207454);
      d.g.b.p.h(paramString, "url");
      if (!this.DIi.lvw.eRg().mz(5))
      {
        ad.e(h.a(this.DIi), "AddFriendHandler, permission fail");
        AppMethodBeat.o(207454);
        return true;
      }
      paramString = paramString.substring(this.DIj.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207454);
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_webview", true);
      localBundle.putString("userName", paramString);
      try
      {
        this.DIi.eNh().a(8, localBundle, this.DIi.eNj());
        AppMethodBeat.o(207454);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.w(h.a(this.DIi), "AddFriendHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207453);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207453);
        return false;
      }
      boolean bool = x.C(paramString, this.DIj);
      AppMethodBeat.o(207453);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIk = "weixin://webview/close/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207456);
      d.g.b.p.h(paramString, "url");
      if (!this.DIi.lvw.eRg().mz(17))
      {
        ad.e(h.a(this.DIi), "close window permission fail");
        AppMethodBeat.o(207456);
        return true;
      }
      this.DIi.onFinish();
      AppMethodBeat.o(207456);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207455);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207455);
        return false;
      }
      boolean bool = x.C(paramString, this.DIk);
      AppMethodBeat.o(207455);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class e
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIl = "weixin://critical_update/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207458);
      d.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 25L, 1L, true);
      h.b(this.DIi, 1);
      AppMethodBeat.o(207458);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207457);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207457);
        return false;
      }
      boolean bool = x.C(paramString, this.DIl);
      AppMethodBeat.o(207457);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class f
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    f(MMWebView paramMMWebView) {}
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207460);
      d.g.b.p.h(paramString, "url");
      int i = this.DIi.aGo(bt.nullAsNil(h.i(this.DIi)));
      if (com.tencent.mm.pluginsdk.g.bK(paramString, h.j(this.DIi))) {}
      for (;;)
      {
        try
        {
          Object localObject;
          if (d.g.b.p.i("weixin://dl/shopping", paramString))
          {
            localObject = this.DIi.eNh().eRx();
            d.g.b.p.g(localObject, "invoker.getJDUrl()");
            if (!bt.isNullOrNil((String)localObject)) {
              BaseWebViewController.a(this.DIi, (String)localObject, null, 6);
            }
            localObject = (List)new ArrayList();
            ((List)localObject).add(paramString);
            ((List)localObject).add("1");
            ((List)localObject).add(String.valueOf(i));
            paramString = bt.nullAsNil(h.i(this.DIi));
            d.g.b.p.g(paramString, "Util.nullAsNil(sentUsername)");
            ((List)localObject).add(paramString);
            paramString = bt.nullAsNil(this.DIi.bQm());
            d.g.b.p.g(paramString, "Util.nullAsNil(rawUrl)");
            ((List)localObject).add(paramString);
            paramString = com.tencent.mm.plugin.report.service.g.yhR;
            com.tencent.mm.plugin.report.service.g.l(11405, (List)localObject);
            bool = true;
            AppMethodBeat.o(207460);
            return bool;
          }
          if (d.g.b.p.i("weixin://dl/faq", paramString))
          {
            int j = this.DIi.eNh().eRz();
            int k = this.DIi.eNh().eRA();
            localObject = aj.getContext().getString(2131763450, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            h localh = this.DIi;
            d.g.b.p.g(localObject, "rawUrl");
            BaseWebViewController.a(localh, (String)localObject, null, 6);
            continue;
          }
        }
        catch (Exception paramString)
        {
          ad.e(h.a(this.DIi), "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          bool = true;
          continue;
          if (d.g.b.p.i("weixin://dl/posts", paramString))
          {
            this.DIi.eNh().eRB();
            continue;
          }
          if (d.g.b.p.i("weixin://dl/moments", paramString))
          {
            this.DIi.eNh().eRC();
            continue;
          }
          if (d.n.n.nz(paramString, "weixin://dl/feedback"))
          {
            d.g.b.p.g(this.DIi.eNh().aIA(paramString), "invoker.getFeedbackUrl(url)");
            continue;
          }
          if (d.g.b.p.i("weixin://dl/scan", paramString))
          {
            com.tencent.mm.bs.d.c(this.DIi.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.g.bJ(paramMMWebView.getActivityContextIfHas(), paramString);
          continue;
        }
        boolean bool = false;
      }
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207459);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207459);
        return false;
      }
      boolean bool = x.C(paramString, "weixin://");
      AppMethodBeat.o(207459);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIm = "weixin://feedback/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207462);
      d.g.b.p.h(paramString, "url");
      paramString = new Bundle();
      paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
      paramString.putInt("MMActivity.OverrideExitAnimation", 2130772106);
      try
      {
        this.DIi.eNh().a(7, paramString, this.DIi.eNj());
        AppMethodBeat.o(207462);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.w(h.a(this.DIi), "FeedbackJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207461);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207461);
        return false;
      }
      boolean bool = x.C(paramString, this.DIm);
      AppMethodBeat.o(207461);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIn = "weixin://connectToFreeWifi/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207464);
      d.g.b.p.h(paramString, "url");
      paramString = Uri.parse(paramString);
      String str1 = paramString.getQueryParameter("apKey");
      ad.i(h.a(this.DIi), "apKey value = %s", new Object[] { str1 });
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
        com.tencent.mm.bs.d.b(aj.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
      }
      AppMethodBeat.o(207464);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207463);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207463);
        return false;
      }
      boolean bool = x.C(paramString, this.DIn);
      AppMethodBeat.o(207463);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class i
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIo = "weixin://gethtml/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207466);
      d.g.b.p.h(paramString, "url");
      if (!bt.isNullOrNil(paramString))
      {
        paramString = paramString.substring(this.DIo.length());
        d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
        ad.i(h.a(this.DIi), "[oneliang]get html content :".concat(String.valueOf(paramString)));
        Object localObject = this.DIi;
        d.g.b.p.h(paramString, "html");
        localObject = ((Iterable)((BaseWebViewController)localObject).DGo).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).aGu(paramString);
        }
      }
      AppMethodBeat.o(207466);
      return false;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207465);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207465);
        return false;
      }
      boolean bool = x.C(paramString, this.DIo);
      AppMethodBeat.o(207465);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class j
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIp = "weixin://profile/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207468);
      d.g.b.p.h(paramString, "url");
      paramString = paramString.substring(this.DIp.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        ad.e(h.a(this.DIi), "handleUrl fail, username is null");
        AppMethodBeat.o(207468);
        return true;
      }
      if (this.DIi.lvw.eRg().mz(2)) {
        this.DIi.getJsapi().aGJ(paramString);
      }
      AppMethodBeat.o(207468);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207467);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207467);
        return false;
      }
      boolean bool = x.C(paramString, this.DIp);
      AppMethodBeat.o(207467);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class k
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIq = "weixin://manual_update/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207470);
      d.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 26L, 1L, true);
      h.b(this.DIi, 3);
      AppMethodBeat.o(207470);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207469);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207469);
        return false;
      }
      boolean bool = x.C(paramString, this.DIq);
      AppMethodBeat.o(207469);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class l
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207472);
      d.g.b.p.h(paramString, "url");
      String str = this.DIi.getIntent().getStringExtra("geta8key_username");
      boolean bool = ag.b.a(paramString, str, this.DIi.aGo(str), this.DIi.eNh(), h.d(this.DIi), this.DIi.DHJ, h.e(this.DIi).eNj(), this.DIi.getContext());
      AppMethodBeat.o(207472);
      return bool;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207471);
      d.g.b.p.h(paramString, "url");
      boolean bool = ag.b.fJ(paramString, this.DIi.getIntent().getIntExtra("geta8key_scene", 0));
      AppMethodBeat.o(207471);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "READER_SHARE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "share", "", "plugin-webview_release"})
  public static final class m
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIr = "weixin://readershare/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207475);
      d.g.b.p.h(paramString, "url");
      paramString = this.DIi.getContext().getString(2131762183);
      d.g.b.p.g(paramString, "context.getString(R.string.readerapp_share_weibo)");
      Context localContext = this.DIi.getContext();
      com.tencent.mm.ui.base.h.c localc = (com.tencent.mm.ui.base.h.c)new a(this);
      com.tencent.mm.ui.base.h.a(localContext, "", new String[] { paramString }, "", localc);
      AppMethodBeat.o(207475);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207474);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207474);
        return false;
      }
      boolean bool = x.C(paramString, this.DIr);
      AppMethodBeat.o(207474);
      return bool;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "whichButton", "", "onClick"})
    static final class a
      implements com.tencent.mm.ui.base.h.c
    {
      a(h.m paramm) {}
      
      public final void lf(int paramInt)
      {
        AppMethodBeat.i(207473);
        if (paramInt == 0)
        {
          h.m localm = this.DIs;
          try
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("shortUrl", localm.DIi.getIntent().getStringExtra("shortUrl"));
            localBundle.putInt("type", localm.DIi.getIntent().getIntExtra("type", 0));
            localm.DIi.eNh().a(4, localBundle, localm.DIi.eNj());
            AppMethodBeat.o(207473);
            return;
          }
          catch (Exception localException)
          {
            ad.e(h.a(localm.DIi), "share fail, ex = " + localException.getMessage());
          }
        }
        AppMethodBeat.o(207473);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class n
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIt = "weixin://recommend_update/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207477);
      d.g.b.p.h(paramString, "url");
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 24L, 1L, true);
      h.b(this.DIi, 2);
      AppMethodBeat.o(207477);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207476);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207476);
        return false;
      }
      boolean bool = x.C(paramString, this.DIt);
      AppMethodBeat.o(207476);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class o
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIu = "weixin://openapi/openwebview/result?";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207479);
      d.g.b.p.h(paramString, "url");
      Object localObject = new OpenWebview.Resp();
      paramString = Uri.parse(paramString);
      d.g.b.p.g(paramString, "uri");
      ((OpenWebview.Resp)localObject).result = paramString.getQuery();
      ((OpenWebview.Resp)localObject).errCode = bt.getInt(paramString.getQueryParameter("errCode"), 0);
      ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
      ((OpenWebview.Resp)localObject).transaction = this.DIi.getIntent().getStringExtra("transaction_for_openapi_openwebview");
      paramString = paramString.getQueryParameter("appid");
      if (bt.isNullOrNil(paramString))
      {
        ad.e(h.a(this.DIi), "SDKOpenWebViewResultHandler handleUrl, appId is null");
        AppMethodBeat.o(207479);
        return true;
      }
      Bundle localBundle = new Bundle();
      ((OpenWebview.Resp)localObject).toBundle(localBundle);
      com.tencent.mm.pluginsdk.model.app.q.bb(localBundle);
      localObject = new MMessageActV2.Args();
      try
      {
        ((MMessageActV2.Args)localObject).targetPkgName = this.DIi.eNh().aIt(paramString);
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        ad.d(h.a(this.DIi), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
        MMessageActV2.send(this.DIi.getContext(), (MMessageActV2.Args)localObject);
        this.DIi.onFinish();
        AppMethodBeat.o(207479);
        return true;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace(h.a(this.DIi), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(207479);
      }
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207478);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207478);
        return false;
      }
      boolean bool = x.C(paramString, this.DIu);
      AppMethodBeat.o(207478);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"})
  static final class p
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    private final d.f DGh;
    private final h DIv;
    private final String TAG;
    
    public p(h paramh)
    {
      AppMethodBeat.i(207483);
      this.DIv = paramh;
      this.TAG = ("MicroMsg.WebViewController.SceneEndCallbacker:" + this.DIv.eNj());
      this.DGh = d.g.O((d.g.a.a)new a(this));
      AppMethodBeat.o(207483);
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      AppMethodBeat.i(207482);
      ad.i(this.TAG, "onSceneEnd, instance hashcode = " + hashCode());
      h localh;
      if (paramd != null)
      {
        int i = paramd.getData().getInt("scene_end_listener_hash_code");
        ad.i(this.TAG, "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(eNj()) });
        ad.i(this.TAG, "edw onSceneEnd, type = " + paramd.getType() + ", errCode = " + paramd.getErrCode() + ", errType = " + paramd.getErrType());
        if (i != eNj())
        {
          ad.e(this.TAG, "hash code not equal");
          AppMethodBeat.o(207482);
          return false;
        }
        localh = this.DIv;
        switch (paramd.getType())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(207482);
        return true;
        h.a(localh, 106);
        localh.onFinish();
        continue;
        h.a(localh, 666);
        localh.onFinish();
      }
    }
    
    public final int eNj()
    {
      AppMethodBeat.i(207481);
      int i = ((Number)this.DGh.getValue()).intValue();
      AppMethodBeat.o(207481);
      return i;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    q(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class r
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    final String DIo = "weixin://private/gethtml/";
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207486);
      d.g.b.p.h(paramString, "url");
      paramString = paramString.substring(this.DIo.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      try
      {
        paramString = URLDecoder.decode(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("nowUrl", h.f(this.DIi));
        localBundle.putString("tweetid", bt.nullAsNil(this.DIi.getIntent().getStringExtra("tweetid")));
        localBundle.putString("htmlData", paramString);
        localBundle.putInt("type", this.DIi.getIntent().getIntExtra("type", 0));
        this.DIi.eNh().a(3, localBundle, this.DIi.eNj());
        AppMethodBeat.o(207486);
        return true;
      }
      catch (Exception paramString)
      {
        ad.e(h.a(this.DIi), "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(207486);
      }
      return false;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207485);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207485);
        return false;
      }
      boolean bool = x.C(paramString, this.DIo);
      AppMethodBeat.o(207485);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class s
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String DIx = "weixin://viewimage/";
    
    s(MMWebView paramMMWebView) {}
    
    public final boolean aGp(String paramString)
    {
      AppMethodBeat.i(207488);
      d.g.b.p.h(paramString, "url");
      try
      {
        if (!this.DIi.eNh().isSDCardAvailable())
        {
          this.DIi.eNh().a(2, null, this.DIi.eNj());
          AppMethodBeat.o(207488);
          return true;
        }
      }
      catch (Exception paramString)
      {
        ad.e(h.a(this.DIi), "edw handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(207488);
        return false;
      }
      h localh = this.DIi;
      paramString = paramString.substring(this.DIx.length());
      d.g.b.p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      h.a(localh, paramString);
      ad.i(h.a(this.DIi), "viewimage currentUrl :" + h.f(this.DIi));
      x.a((WebView)paramMMWebView, h.g(this.DIi).DIo, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", h.h(this.DIi));
      AppMethodBeat.o(207488);
      return true;
    }
    
    public final boolean aGq(String paramString)
    {
      AppMethodBeat.i(207487);
      d.g.b.p.h(paramString, "url");
      if (bt.isNullOrNil(paramString))
      {
        AppMethodBeat.o(207487);
        return false;
      }
      boolean bool = x.C(paramString, this.DIx);
      AppMethodBeat.o(207487);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"})
  final class t
  {
    private final h DIv;
    private volatile String DIy;
    private volatile String DIz;
    private int fromScene;
    private long lFE;
    private int networkType;
    private String userAgent;
    
    public t()
    {
      AppMethodBeat.i(207492);
      this.DIv = localObject;
      this$1 = this.DIv.omW.getSettings();
      d.g.b.p.g(h.this, "controller.viewWV.settings");
      this$1 = h.this.getUserAgentString();
      d.g.b.p.g(h.this, "controller.viewWV.settings.userAgentString");
      this.userAgent = h.this;
      this.fromScene = this.DIv.getIntent().getIntExtra("from_scence", 0);
      this.DIy = "";
      this.DIz = "";
      AppMethodBeat.o(207492);
    }
    
    private void eNI()
    {
      AppMethodBeat.i(207490);
      Context localContext = this.DIv.getContext();
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
        localObject = this.DIv.getContext();
      }
      int i;
      if (com.tencent.mm.sdk.platformtools.ay.isConnected((Context)localObject))
      {
        if (!com.tencent.mm.sdk.platformtools.ay.isWifi((Context)localObject)) {
          break label108;
        }
        i = 1;
      }
      for (;;)
      {
        this.networkType = i;
        ad.i(h.a(h.this), "get networkType " + this.networkType);
        AppMethodBeat.o(207490);
        return;
        label108:
        if (com.tencent.mm.sdk.platformtools.ay.is5G((Context)localObject)) {
          i = 5;
        } else if (com.tencent.mm.sdk.platformtools.ay.is4G((Context)localObject)) {
          i = 4;
        } else if (com.tencent.mm.sdk.platformtools.ay.is3G((Context)localObject)) {
          i = 3;
        } else if (com.tencent.mm.sdk.platformtools.ay.is2G((Context)localObject)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
    
    public final void p(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(207491);
      d.g.b.p.h(paramString, "targetUrl");
      eNI();
      String str5 = this.DIv.aGj(this.DIz);
      if (this.fromScene != 0) {
        this.DIy = " ";
      }
      boolean bool = this.DIv.lvw.eRh().fgp();
      ad.d(h.a(h.this), "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.lFE > 0L) && (h.b(h.this) > this.lFE) && (paramLong > h.b(h.this)) && (!TextUtils.isEmpty((CharSequence)str5)) && (bool))
      {
        l1 = h.b(h.this) - this.lFE;
        l2 = paramLong - h.b(h.this);
        ad.d(h.a(h.this), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.lFE), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.userAgent, this.DIz, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.DIy });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(this.userAgent), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(this.DIz), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str4 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(this.DIy), "UTF-8");
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
      com.tencent.mm.plugin.report.service.g.yhR.f(13376, new Object[] { Long.valueOf(this.lFE), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.DIy = this.DIz;
        this.DIz = paramString;
        this.lFE = paramLong;
      }
      AppMethodBeat.o(207491);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(h.t paramt, String paramString, long paramLong) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(207489);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.DIA.p(this.DIB, this.DIC, this.DID);
        AppMethodBeat.o(207489);
        return false;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(h paramh, Uri paramUri) {}
    
    public final void run()
    {
      AppMethodBeat.i(207493);
      com.tencent.mm.pluginsdk.model.app.h.i(this.DIi.getContext(), localUri);
      AppMethodBeat.o(207493);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Ljava/util/HashSet;", "", "invoke"})
  static final class v
    extends d.g.b.q
    implements d.g.a.a<HashSet<String>>
  {
    v(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.a<Boolean>
  {
    w(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.q
    implements d.g.a.a<Boolean>
  {
    x(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class y
    extends d.g.b.q
    implements d.g.a.a<Boolean>
  {
    y(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/core/WebViewController$oauthDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"})
  public static final class z
    implements ag.c
  {
    private static void c(Dialog paramDialog)
    {
      AppMethodBeat.i(207502);
      if ((paramDialog != null) && (paramDialog.isShowing()))
      {
        paramDialog.dismiss();
        paramDialog.setCancelMessage(null);
        paramDialog.setDismissMessage(null);
      }
      AppMethodBeat.o(207502);
    }
    
    public final void aGr(String paramString)
    {
      AppMethodBeat.i(207498);
      d.g.b.p.h(paramString, "url");
      this.DIi.k(paramString, true, 9);
      AppMethodBeat.o(207498);
    }
    
    public final void chI()
    {
      AppMethodBeat.i(207501);
      c((Dialog)h.c(this.DIi));
      AppMethodBeat.o(207501);
    }
    
    public final void d(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(207500);
      d.g.b.p.h(paramOnCancelListener, "cancelListener");
      c((Dialog)h.c(this.DIi));
      h.a(this.DIi, com.tencent.mm.ui.base.h.b(this.DIi.getContext(), this.DIi.getContext().getString(2131761776), true, paramOnCancelListener));
      AppMethodBeat.o(207500);
    }
    
    public final void goBack()
    {
      AppMethodBeat.i(207499);
      Iterator localIterator = ((Iterable)this.DIi.DGo).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).eNK();
      }
      AppMethodBeat.o(207499);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.h
 * JD-Core Version:    0.7.0.1
 */