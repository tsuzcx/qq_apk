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
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.at;
import com.tencent.mm.plugin.webview.model.av;
import com.tencent.mm.plugin.webview.model.ax.b;
import com.tencent.mm.plugin.webview.model.ax.c;
import com.tencent.mm.plugin.webview.model.ax.e;
import com.tencent.mm.plugin.webview.model.ax.f;
import com.tencent.mm.plugin.webview.model.ax.j;
import com.tencent.mm.plugin.webview.model.ax.k;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.z;
import d.a.ae;
import d.g.b.w;
import d.o;
import d.y;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "OauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1;", "ReaderShareHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;)V", "pageEndTime", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "kotlin.jvm.PlatformType", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "getWebviewReportMgr", "()Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "", "", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getCachedAppId", "getScene", "username", "getWebViewPluginClientProxy", "handleUrl", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "loadUrl", "httpHeaders", "withoutCache", "needSyncGetA8Key", "onBinded", "onDestroy", "onJsReady", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", "errorCode", "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "overrideProcessResult", "resp", "overrideUrl", "webView", "removeSceneEnd", "requestSetFontSize", "fontSize", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "Companion", "SceneEndCallbacker", "VisitInfoReport", "plugin-webview_release"})
public class h
  extends BaseWebViewController
{
  public static final d Cfd;
  private final String CeA;
  private final Set<String> CeB;
  private final d.f CeC;
  private com.tencent.mm.ui.base.p CeD;
  private final ag.c CeE;
  ag.a CeF;
  private long CeG;
  private final List<com.tencent.mm.plugin.webview.c.d.a> CeH;
  private final l CeI;
  private final j CeJ;
  private final e CeK;
  private final k CeL;
  private final n CeM;
  private final a CeN;
  private String CeO;
  private final boolean CeP;
  private final s CeQ;
  private final i CeR;
  private final r CeS;
  private final m CeT;
  private final g CeU;
  private final b CeV;
  private final o CeW;
  private final c CeX;
  private long CeY;
  private final f CeZ;
  private final d.f Ceq;
  private final d.f Cer;
  private final d.f Ces;
  private final d.f Cet;
  private final d.f Ceu;
  public final aq Cev;
  private final d.f Cew;
  private final d.f Cex;
  public String Cey;
  private final d.f Cez;
  private final h Cfa;
  public com.tencent.luggage.k.a.c.c Cfb;
  public final com.tencent.mm.plugin.webview.model.ax Cfc;
  private final d.f nJH;
  
  static
  {
    AppMethodBeat.i(189392);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "TAG", "getTAG()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "stubService", "getStubService()Ljava/lang/Class;")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "fileUrlWhiteList", "getFileUrlWhiteList()Ljava/util/Set;")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "isFromLoginHistory", "isFromLoginHistory()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "finishIfLoadFailed", "getFinishIfLoadFailed()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "visitInfoReport", "getVisitInfoReport()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "neverBlockLocalRequest", "getNeverBlockLocalRequest()Z")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "sslErrorHandler", "getSslErrorHandler()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "routeUrlMap", "getRouteUrlMap()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;")), (d.l.k)w.a(new d.g.b.u(w.bn(h.class), "sceneCallbacker", "getSceneCallbacker()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;")) };
    Cfd = new d((byte)0);
    AppMethodBeat.o(189392);
  }
  
  public h(MMWebView paramMMWebView, com.tencent.mm.plugin.webview.model.ax paramax, BaseWebViewController.c paramc)
  {
    this(paramMMWebView, paramax, paramc, null);
    AppMethodBeat.i(189434);
    AppMethodBeat.o(189434);
  }
  
  public h(final MMWebView paramMMWebView, com.tencent.mm.plugin.webview.model.ax paramax, BaseWebViewController.c paramc, Set<String> paramSet)
  {
    super(paramMMWebView, paramc, paramSet);
    AppMethodBeat.i(189433);
    this.Cfc = paramax;
    this.nJH = d.g.K((d.g.a.a)new q(this));
    this.Ceq = d.g.K((d.g.a.a)aj.CfI);
    this.Cer = d.g.K((d.g.a.a)new v(this));
    this.Ces = d.g.K((d.g.a.a)new x(this));
    this.Cet = d.g.K((d.g.a.a)new w(this));
    this.Ceu = d.g.K((d.g.a.a)new ak(this));
    this.Cev = new aq(getContext());
    this.Cew = d.g.K((d.g.a.a)new y(this));
    this.Cex = d.g.K((d.g.a.a)new ai(this, paramMMWebView));
    this.Cez = d.g.K((d.g.a.a)ag.CfH);
    this.CeA = "file:///android_asset/jsapi/wxjs.js";
    this.CeB = ((Set)new HashSet());
    this.CeC = d.g.K((d.g.a.a)new ah(this));
    this.CeE = ((ag.c)new z(this));
    this.CeF = ((ag.a)new aa(this));
    this.CeH = ((List)new ArrayList());
    this.CeI = new l(this);
    this.CeJ = new j(this);
    this.CeK = new e(this);
    this.CeL = new k(this);
    this.CeM = new n(this);
    this.CeN = new a(this);
    this.CeP = true;
    this.CeQ = new s(this, paramMMWebView);
    this.CeR = new i(this);
    this.CeS = new r(this);
    this.CeT = new m(this);
    this.CeU = new g(this);
    this.CeV = new b(this);
    this.CeW = new o(this);
    this.CeX = new c(this);
    this.CeZ = new f(this, paramMMWebView);
    this.Cfa = new h(this);
    AppMethodBeat.o(189433);
  }
  
  private final boolean aAR(String paramString)
  {
    AppMethodBeat.i(189425);
    if (bs.isNullOrNil(paramString))
    {
      ac.e(getTAG(), "search contact err: null or nill url");
      AppMethodBeat.o(189425);
      return false;
    }
    eyS();
    Bundle localBundle = new Bundle();
    localBundle.putString("search_contact_data_url", paramString);
    localBundle.putInt("webview_binder_id", eyR().eyt());
    try
    {
      eyr().x(106, localBundle);
      AppMethodBeat.o(189425);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  private final boolean aAS(String paramString)
  {
    AppMethodBeat.i(189426);
    ac.i(getTAG(), "dealCustomScheme, url = ".concat(String.valueOf(paramString)));
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(189426);
      return false;
    }
    try
    {
      if (eyr().eJ(paramString))
      {
        ac.i(getTAG(), "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(paramString)));
        eyr().fo(paramString, eyt());
        AppMethodBeat.o(189426);
        return true;
      }
    }
    catch (Exception localException1)
    {
      ac.w(getTAG(), "dealCustomScheme, tryHandleEvents, ex = " + localException1.getMessage());
      final Uri localUri = Uri.parse(paramString);
      Object localObject2;
      if ((localUri != null) && (!d.n.n.nb(paramString, "weixin://")) && (!d.n.n.nb(paramString, "http")))
      {
        if (d.n.n.nb(paramString, "tel:"))
        {
          paramString = d.n.n.h(paramString, "tel:", "", false);
          if (!bs.isNullOrNil(paramString)) {}
          try
          {
            eyr().fq(paramString, eyt());
            AppMethodBeat.o(189426);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ac.w(getTAG(), "showPhoneSpanDialog, ex = %s", new Object[] { paramString.getMessage() });
            }
          }
        }
        Object localObject1;
        if ((d.n.n.nb(paramString, "sms:")) || (d.n.n.nb(paramString, "smsto:")))
        {
          localObject1 = new Intent("android.intent.action.SENDTO", localUri);
          ((Intent)localObject1).addFlags(268435456);
          try
          {
            paramString = getContext();
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(189426);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ac.e(getTAG(), "start sms app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        if (d.n.n.nb(paramString, "mailto:"))
        {
          paramString = new Intent("android.intent.action.SENDTO");
          paramString.addFlags(268435456);
          paramString.setData(localUri);
          try
          {
            localObject1 = getContext();
            paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.aeD(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)paramString.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(189426);
            return true;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              ac.e(getTAG(), "start mailto app failed:[%s]", new Object[] { paramString.getMessage() });
            }
          }
        }
        try
        {
          if ((!this.kYu.eCn().eRg()) && (eyr().eCC()))
          {
            ac.e(getTAG(), "dealCustomScheme, not allow outer open url");
            AppMethodBeat.o(189426);
            return true;
          }
          i = getIntent().getIntExtra("key_download_restrict", 0);
          localObject1 = getIntent().getStringExtra("key_function_id");
          if (!bs.isNullOrNil((String)localObject1)) {
            com.tencent.mm.plugin.report.service.h.wUl.f(14596, new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(1) });
          }
          if (i == 1)
          {
            ac.e(getTAG(), "not allow launch app by custom scheme : %s", new Object[] { paramString });
            AppMethodBeat.o(189426);
            return true;
          }
        }
        catch (RemoteException localRemoteException)
        {
          ac.printErrStackTrace(getTAG(), (Throwable)localRemoteException, "", new Object[0]);
          long l = bs.aNx() - this.CeG;
          ac.i(getTAG(), "scheme launch interval ; %d", new Object[] { Long.valueOf(l) });
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
              ac.i(getTAG(), "formate url failed");
            }
            localObject2 = new Intent("android.intent.action.VIEW", localUri);
            ((Intent)localObject2).addFlags(268435456);
            if (!bs.ah(getContext(), (Intent)localObject2)) {
              break label1005;
            }
            paramString = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(189426);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(13983, new Object[] { Integer.valueOf(4), localObject2, paramString });
          if (getIntent().getBooleanExtra("show_openapp_dialog", true))
          {
            bool = com.tencent.mm.ci.a.post((Runnable)new u(this, localUri));
            AppMethodBeat.o(189426);
            return bool;
          }
        }
      }
      label1005:
      AppMethodBeat.o(189426);
    }
    return false;
  }
  
  private boolean aAU(String paramString)
  {
    AppMethodBeat.i(189429);
    d.g.b.k.h(paramString, "url");
    Iterator localIterator = this.CeH.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.c.d.a locala = (com.tencent.mm.plugin.webview.c.d.a)localIterator.next();
      if (locala.aAV(paramString))
      {
        ac.i(getTAG(), "url handled, url = ".concat(String.valueOf(paramString)));
        boolean bool = locala.aAU(paramString);
        ac.i(getTAG(), "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(189429);
        return true;
      }
    }
    AppMethodBeat.o(189429);
    return false;
  }
  
  private final String eyM()
  {
    AppMethodBeat.i(189397);
    if (!UA(this.Cdw))
    {
      AppMethodBeat.o(189397);
      return "";
    }
    String str = getIntent().getStringExtra("KPublisherId");
    AppMethodBeat.o(189397);
    return str;
  }
  
  private final t eyN()
  {
    AppMethodBeat.i(189398);
    t localt = (t)this.Ceu.getValue();
    AppMethodBeat.o(189398);
    return localt;
  }
  
  private final com.tencent.mm.plugin.webview.ui.tools.c eyO()
  {
    AppMethodBeat.i(189400);
    com.tencent.mm.plugin.webview.ui.tools.c localc = (com.tencent.mm.plugin.webview.ui.tools.c)this.Cex.getValue();
    AppMethodBeat.o(189400);
    return localc;
  }
  
  private final com.tencent.mm.plugin.webview.modeltools.n eyP()
  {
    AppMethodBeat.i(189403);
    com.tencent.mm.plugin.webview.modeltools.n localn = (com.tencent.mm.plugin.webview.modeltools.n)this.Cez.getValue();
    AppMethodBeat.o(189403);
    return localn;
  }
  
  private final p eyR()
  {
    AppMethodBeat.i(189423);
    p localp = (p)this.CeC.getValue();
    AppMethodBeat.o(189423);
    return localp;
  }
  
  private final void eyS()
  {
    AppMethodBeat.i(189424);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 106);
      localBundle.putInt("scene_end_listener_hash_code", eyR().eyt());
      eyr().a(5, localBundle, eyR().eyt());
      AppMethodBeat.o(189424);
      return;
    }
    catch (Exception localException)
    {
      ac.e(getTAG(), "addSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(189424);
    }
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(189393);
    String str = (String)this.nJH.getValue();
    AppMethodBeat.o(189393);
    return str;
  }
  
  public final void UC(int paramInt)
  {
    AppMethodBeat.i(189422);
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
    com.tencent.e.h.JZN.aQ((Runnable)new af(this, i));
    AppMethodBeat.o(189422);
  }
  
  protected boolean Ud(String paramString)
  {
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.webview.stub.e parame)
  {
    AppMethodBeat.i(189414);
    String str = getTAG();
    if (parame == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i(str, "onServiceConnected, invoker == null ? %b", new Object[] { Boolean.valueOf(bool) });
      if (parame != null) {
        break;
      }
      ac.f(getTAG(), "service connect success, while invoker is null");
      onFinish();
      AppMethodBeat.o(189414);
      return;
    }
    try
    {
      parame.a((com.tencent.mm.plugin.webview.stub.f)eyR(), eyR().eyt());
      super.a(parame);
      AppMethodBeat.o(189414);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e(getTAG(), "addCallback fail, ex = %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void a(WebView paramWebView, final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(189402);
    if (!UA(this.Cdw))
    {
      ac.i(getTAG(), "onReceivedError, intent not ready");
      AppMethodBeat.o(189402);
      return;
    }
    Object localObject = ac.CfC;
    localObject = new ad(this);
    com.tencent.xweb.util.g.za(false);
    boolean bool = com.tencent.mm.sdk.platformtools.ax.isConnected(getContext());
    ac.e(getTAG(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(155L, com.tencent.mm.plugin.webview.h.a.Vg(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.i.eQ(eyM(), 1);
    com.tencent.mm.plugin.topstory.a.i.eQ(eyM(), com.tencent.mm.plugin.webview.h.a.Vg(paramInt));
    com.tencent.mm.plugin.topstory.a.i.c(eyM(), bLL(), com.tencent.mm.plugin.webview.h.a.Vg(paramInt), this.Cfc.eBI().enterTime);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    com.tencent.mm.plugin.webview.ui.tools.k.Cya.VI(paramInt);
    this.Cfc.eBQ().errCode = paramInt;
    com.tencent.mm.plugin.webview.ui.tools.m localm = com.tencent.mm.plugin.webview.ui.tools.m.CyO;
    com.tencent.mm.plugin.webview.ui.tools.m.setErrCode(paramInt);
    if (((Boolean)this.Cet.getValue()).booleanValue()) {
      onFinish();
    }
    try
    {
      if (d.g.b.k.g(new URL(paramString2).getHost(), "mp.weixin.qq.com")) {
        com.tencent.e.h.JZN.f((Runnable)new ae(paramString2, paramInt, (ad)localObject, "mp.weixin.qq.com"), "WebViewUI.CheckDNS");
      }
      super.a(paramWebView, paramInt, paramString1, paramString2);
      AppMethodBeat.o(189402);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        ac.printErrStackTrace(getTAG(), (Throwable)localMalformedURLException, "check mp url", new Object[0]);
      }
    }
  }
  
  public final void a(WebView paramWebView, r paramr, SslError paramSslError)
  {
    AppMethodBeat.i(189401);
    if (!UA(this.Cdw))
    {
      ac.i(getTAG(), "onReceivedSslError, intent not ready");
      AppMethodBeat.o(189401);
      return;
    }
    com.tencent.xweb.util.g.za(true);
    String str;
    if (paramWebView != null)
    {
      str = paramWebView.getUrl();
      if (str != null) {
        break label213;
      }
      str = this.CcY;
      label59:
      if (str == null) {
        break label222;
      }
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class);
      d.g.b.k.g(localObject, "MMKernel.service(IBrandService::class.java)");
      localObject = ((com.tencent.mm.plugin.brandservice.a.b)localObject).bIR();
      d.g.b.k.g(localObject, "MMKernel.service(IBrandS…::class.java).hardCodeUrl");
      if (!d.n.n.nb(str, (String)localObject)) {
        break label222;
      }
      str = bLL();
    }
    label213:
    label222:
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.i.eQ(eyM(), 1);
      com.tencent.mm.plugin.topstory.a.i.eQ(eyM(), 30);
      com.tencent.mm.plugin.topstory.a.i.c(eyM(), bLL(), 30, this.Cfc.eBI().enterTime);
      eyO().a(str, paramr, paramSslError);
      super.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(189401);
      return;
      str = null;
      break;
      str = paramWebView.getUrl();
      break label59;
    }
  }
  
  public final void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189405);
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    this.CcY = paramString;
    super.a(paramWebView, paramString, paramBoolean);
    AppMethodBeat.o(189405);
  }
  
  protected final boolean a(int paramInt, String paramString, arn paramarn)
  {
    AppMethodBeat.i(189412);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramarn, "resp");
    int i = paramarn.DLI;
    String str = paramarn.EKZ;
    switch (i)
    {
    default: 
      boolean bool = super.a(paramInt, paramString, paramarn);
      AppMethodBeat.o(189412);
      return bool;
    case 3: 
      ac.i(getTAG(), "getA8key-app: ".concat(String.valueOf(str)));
      paramString = (CharSequence)str;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        ac.e(getTAG(), "getA8key-app, fullUrl is null");
        AppMethodBeat.o(189412);
        return false;
      }
      aAS(str);
      AppMethodBeat.o(189412);
      return true;
    case 4: 
      d.g.b.k.g(str, "fullUrl");
      aAR(str);
      AppMethodBeat.o(189412);
      return true;
    }
    d.g.b.k.g(str, "fullUrl");
    eyS();
    paramString = new Bundle();
    paramString.putString("emoji_store_jump_url", str);
    paramString.putInt("webview_binder_id", eyR().eyt());
    try
    {
      eyr().x(666, paramString);
      AppMethodBeat.o(189412);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.w(getTAG(), "startSearchContact, ex = " + paramString.getMessage());
      }
    }
  }
  
  /* Error */
  public final String aAP(String paramString)
  {
    // Byte code:
    //   0: ldc_w 1274
    //   3: invokestatic 398	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: checkcast 740	java/lang/CharSequence
    //   10: invokestatic 1280	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +118 -> 131
    //   16: new 637	android/os/Bundle
    //   19: dup
    //   20: invokespecial 638	android/os/Bundle:<init>	()V
    //   23: astore_2
    //   24: aload_2
    //   25: ldc_w 711
    //   28: aload_0
    //   29: invokevirtual 749	com/tencent/mm/plugin/webview/core/h:eyt	()I
    //   32: invokevirtual 644	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   35: aload_2
    //   36: ldc_w 1282
    //   39: aload_1
    //   40: invokevirtual 709	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 658	com/tencent/mm/plugin/webview/core/h:eyr	()Lcom/tencent/mm/plugin/webview/stub/e;
    //   47: bipush 76
    //   49: aload_2
    //   50: invokeinterface 1286 3 0
    //   55: ldc_w 1288
    //   58: invokevirtual 1291	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokestatic 1294	com/tencent/mm/sdk/platformtools/bs:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 1296
    //   69: invokestatic 1228	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: aload_0
    //   73: invokespecial 631	com/tencent/mm/plugin/webview/core/h:getTAG	()Ljava/lang/String;
    //   76: ldc_w 1298
    //   79: iconst_1
    //   80: anewarray 783	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 925	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 1274
    //   93: invokestatic 456	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: ldc_w 773
    //   102: astore_1
    //   103: aload_0
    //   104: invokespecial 631	com/tencent/mm/plugin/webview/core/h:getTAG	()Ljava/lang/String;
    //   107: ldc_w 1300
    //   110: iconst_1
    //   111: anewarray 783	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_2
    //   117: invokevirtual 1301	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 786	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -34 -> 90
    //   127: astore_2
    //   128: goto -25 -> 103
    //   131: ldc_w 773
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
  
  public final int aAT(String paramString)
  {
    AppMethodBeat.i(189428);
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
        bool = UA(this.Cdv);
        if (bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        boolean bool;
        label97:
        ac.e(getTAG(), "getScene fail, ex = " + paramString.getMessage());
        i = 1;
        continue;
        i = 1;
        continue;
      }
      ac.i(getTAG(), "KGetA8KeyScene = %s", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(189428);
      return i;
      i = 0;
      break;
      if (eyr().xr(paramString))
      {
        i = 8;
      }
      else
      {
        if (eyr().wH(paramString))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("enterprise_biz_username", paramString);
          try
          {
            paramString = eyr().k(102, (Bundle)localObject);
            if (paramString != null)
            {
              bool = paramString.getBoolean("is_enterprise_username");
              if (!bool) {}
            }
          }
          catch (RemoteException paramString)
          {
            ac.e(getTAG(), "invoke the check enterprise failed");
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
    AppMethodBeat.i(189407);
    d.g.b.k.h(paramWebView, "webview");
    d.g.b.k.h(paramWebResourceRequest, "request");
    if ((isStarted()) && (UA(this.Cdv)))
    {
      Object localObject = this.Cev;
      String str = paramWebResourceRequest.getUrl().toString();
      if (!((Boolean)this.Cew.getValue()).booleanValue()) {}
      for (boolean bool = true;; bool = false)
      {
        localObject = ((aq)localObject).a(str, paramWebResourceRequest, bool, eyr());
        if (localObject == null) {
          break;
        }
        AppMethodBeat.o(189407);
        return localObject;
      }
    }
    paramWebView = super.b(paramWebView, paramWebResourceRequest, paramBundle);
    AppMethodBeat.o(189407);
    return paramWebView;
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(189406);
    super.b(paramWebView, paramString);
    this.Cdm.bI("onPageFinished", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.nKq, paramString);
    if (Ud(paramString))
    {
      AppMethodBeat.o(189406);
      return;
    }
    ac.i(getTAG(), "edw onPageFinished opt, url = %s", new Object[] { paramString });
    this.Cfc.eBP().bL(paramString);
    com.tencent.mm.plugin.webview.ui.tools.k.Cya.Bb();
    eyP().Bk(paramString);
    boolean bool = getIntent().getBooleanExtra("shouldForceViewPort", false);
    ac.d(getTAG(), "hy: shouldForceViewPort: ".concat(String.valueOf(bool)));
    Object localObject;
    if (bool)
    {
      localObject = getIntent().getStringExtra("view_port_code");
      if (paramWebView == null) {
        d.g.b.k.fOy();
      }
      paramWebView.evaluateJavascript((String)localObject, null);
    }
    if (paramString == null) {
      d.g.b.k.fOy();
    }
    if (aAO(paramString))
    {
      ac.f(getTAG(), "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(189406);
      return;
    }
    if (d.g.b.k.g(paramString, this.CeA))
    {
      ac.i(getTAG(), "onPageFinished, js is finished loaded");
      AppMethodBeat.o(189406);
      return;
    }
    this.Cfc.eBF().aCk(paramString);
    this.Cfc.eBG().aCi(paramString);
    this.Cfc.eBJ().report();
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      localObject = paramWebView.getParcelable("KSnsAdTag");
      if ((localObject != null) && ((localObject instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.Cfc.eBQ().vKt = ((SnsAdClick)localObject);
        localObject = this.Cfc.eBQ();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.k.g(paramWebView, "uxInfo");
        ((at)localObject).P(new String[] { paramString, "1", str, paramWebView });
        this.Cfc.eBQ().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.CyO;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, true);
    this.CeG = bs.aNx();
    AppMethodBeat.o(189406);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(189404);
    d.g.b.k.h(paramWebView, "view");
    d.g.b.k.h(paramString, "url");
    super.b(paramWebView, paramString, paramBitmap);
    this.Cdm.bI("onPageStarted", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.model.a.a(this.nKq, paramString);
    if (Ud(paramString))
    {
      AppMethodBeat.o(189404);
      return;
    }
    if (!this.nKq.supportFeature(2006)) {
      getJsapi().ezW();
    }
    com.tencent.mm.plugin.webview.j.i.h(paramString, getContext());
    ac.i(getTAG(), "edw onPageStarted opt, url = ".concat(String.valueOf(paramString)));
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.i.eQ(eyM(), 0);
    if ((com.tencent.mm.sdk.a.b.eUk()) && (d.g.b.k.g("http://www.dktest-mmcrash.com/", paramString))) {
      Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
    }
    this.Cey = this.CcY;
    long l = bs.aNx();
    paramWebView = eyN();
    d.g.b.k.h(paramString, "targetUrl");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new h.t.a(paramWebView, paramString, l));
    this.Cfc.eBH().Cra = this.Cey;
    this.CcY = paramString;
    com.tencent.mm.plugin.webview.ui.tools.k.Cya.bK(paramString);
    ac.d(getTAG(), "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { this.Cey, this.CcY });
    if (aAO(paramString))
    {
      ac.f(getTAG(), "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(189404);
      return;
    }
    eyP().Bk(paramString);
    this.Cfc.eBF().cv(blB(), eyM()).aCj(paramString);
    paramWebView = (Bundle)getIntent().getParcelableExtra("jsapiargs");
    if (paramWebView != null)
    {
      paramBitmap = paramWebView.getParcelable("KSnsAdTag");
      if ((paramBitmap != null) && ((paramBitmap instanceof SnsAdClick)))
      {
        paramWebView = paramWebView.getString("KAnsUxInfo", "");
        this.Cfc.eBQ().vKt = ((SnsAdClick)paramBitmap);
        paramBitmap = this.Cfc.eBQ();
        String str = String.valueOf(System.currentTimeMillis());
        d.g.b.k.g(paramWebView, "uxInfo");
        paramBitmap.P(new String[] { paramString, "0", str, paramWebView });
        this.Cfc.eBQ().report();
      }
    }
    paramWebView = com.tencent.mm.plugin.webview.ui.tools.m.CyO;
    com.tencent.mm.plugin.webview.ui.tools.m.a(getIntent(), paramString, false);
    AppMethodBeat.o(189404);
  }
  
  public final boolean b(int paramInt, String paramString, arn paramarn)
  {
    AppMethodBeat.i(189410);
    d.g.b.k.h(paramString, "reqUrl");
    d.g.b.k.h(paramarn, "response");
    Object localObject = paramarn.ELh;
    if (localObject != null) {}
    for (long l = ((aam)localObject).EuC;; l = -1L)
    {
      this.CeY = l;
      boolean bool = this.nKq.getIsX5Kernel();
      localObject = paramarn.EKZ;
      d.g.b.k.g(localObject, "response.FullURL");
      com.tencent.mm.plugin.webview.model.ax.aB(bool, d.n.n.nb((String)localObject, "https://"));
      this.Cfc.eBE().ch(paramString, true);
      this.Cfc.eBG().cu(com.tencent.mm.plugin.webview.ui.tools.game.i.dCr, eyM()).aCg(paramarn.EKZ);
      bool = super.b(paramInt, paramString, paramarn);
      AppMethodBeat.o(189410);
      return bool;
    }
  }
  
  protected void bLR()
  {
    AppMethodBeat.i(189417);
    if (aAU(bLL()))
    {
      AppMethodBeat.o(189417);
      return;
    }
    if (bLS())
    {
      BaseWebViewController.a(this, bLL(), false, 0, 6);
      AppMethodBeat.o(189417);
      return;
    }
    ac.i(getTAG(), "terry onStartLoad:" + bLL());
    Object localObject3 = eyv();
    Object localObject1 = (CharSequence)localObject3;
    int i;
    if ((localObject1 == null) || (d.n.n.aD((CharSequence)localObject1))) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        ac.i(getTAG(), (String)localObject3);
        localObject1 = localObject3;
        if (getIntent().getBooleanExtra("QRDataFlag", true)) {}
        try
        {
          localObject1 = eyr().aCQ((String)localObject3);
          localObject3 = this.nKq.getSettings();
          d.g.b.k.g(localObject3, "viewWV.settings");
          ((z)localObject3).setUseWideViewPort(false);
          localObject3 = this.nKq.getSettings();
          d.g.b.k.g(localObject3, "viewWV.settings");
          ((z)localObject3).setLoadWithOverviewMode(false);
          localObject3 = this.nKq.getSettings();
          d.g.b.k.g(localObject3, "viewWV.settings");
          ((z)localObject3).setJavaScriptEnabled(false);
          uf(true);
          this.nKq.loadDataWithBaseURL(null, (String)localObject1, "text/html", "utf-8", null);
          ac.i(getTAG(), "loadDataWithBaseUrl, data = ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(189417);
          return;
          i = 0;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.w(getTAG(), "postBinded, formatQRString, ex = " + localException.getMessage());
            localObject2 = localObject3;
          }
        }
      }
    }
    if (aAO(bLL()))
    {
      ac.f(getTAG(), "postBinded 2, canLoadUrl fail, url = " + bLL());
      AppMethodBeat.o(189417);
      return;
    }
    if (this.CdP.CdX) {
      this.kYu.a(bLL(), null, null);
    }
    Object localObject2 = ((Iterable)this.Cdn).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((j)((Iterator)localObject2).next()).aBb(bLL()))
      {
        AppMethodBeat.o(189417);
        return;
      }
    }
    if (this.nKq.fuP())
    {
      AppMethodBeat.o(189417);
      return;
    }
    uf(false);
    BaseWebViewController.a(this, bLL(), null, 6);
    AppMethodBeat.o(189417);
  }
  
  protected boolean bLS()
  {
    AppMethodBeat.i(189418);
    Object localObject = ((Iterable)this.Cdn).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((j)((Iterator)localObject).next()).aBc(bLL()))
      {
        AppMethodBeat.o(189418);
        return false;
      }
    }
    localObject = (CharSequence)getIntent().getStringExtra("data");
    if ((localObject == null) || (d.n.n.aD((CharSequence)localObject))) {}
    for (int i = 1; (i != 0) && (!this.CdP.CdX); i = 0)
    {
      AppMethodBeat.o(189418);
      return true;
    }
    AppMethodBeat.o(189418);
    return false;
  }
  
  protected final void bMF()
  {
    AppMethodBeat.i(189409);
    int j = 2;
    int i = j;
    try
    {
      if (eyr().eCC()) {
        if (!this.CdP.CdW) {
          break label147;
        }
      }
      label147:
      for (i = com.tencent.mm.plugin.webview.j.e.a(getContext(), eyr(), bLL());; i = com.tencent.mm.plugin.webview.j.e.gY(getContext()))
      {
        UC(i);
        String str = this.nKq.getUrl();
        if (bs.isNullOrNil(str)) {
          break label210;
        }
        Object localObject = this.CeB;
        if (str == null) {
          d.g.b.k.fOy();
        }
        if (!((Set)localObject).add(str)) {
          break label210;
        }
        localObject = this.kYu.eCn();
        d.g.b.k.g(localObject, "wvPerm.genCtrl");
        if (((GeneralControlWrapper)localObject).eRj()) {
          getJsapi().ezR();
        }
        if (!((GeneralControlWrapper)localObject).eRk()) {
          break;
        }
        getJsapi().ul(false);
        AppMethodBeat.o(189409);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e(getTAG(), "onLoadJsApiFinished, ex = " + localException.getMessage());
        i = j;
      }
      if (this.Cev.aBW(localException)) {
        getJsapi().ul(true);
      }
      label210:
      super.bMF();
      AppMethodBeat.o(189409);
    }
  }
  
  public final int blB()
  {
    AppMethodBeat.i(189427);
    int i = aAT(getIntent().getStringExtra("geta8key_username"));
    AppMethodBeat.o(189427);
    return i;
  }
  
  protected final void dKr()
  {
    AppMethodBeat.i(189416);
    if (eyA())
    {
      ac.e(getTAG(), "onBinded call when activity has been finished");
      AppMethodBeat.o(189416);
      return;
    }
    ac.i(getTAG(), "Abe-Debug onPostBindedStart");
    this.Cdm.bI("onPostBindedStart", System.currentTimeMillis());
    com.tencent.mm.plugin.webview.ui.tools.k.Cya.b(eyr());
    Object localObject1 = getIntent().getStringExtra("ad_info");
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.k.Cya;
      d.g.b.k.g(localObject2, "WebViewReportUtil.INSTANCE");
      ((com.tencent.mm.plugin.webview.ui.tools.k)localObject2).setTraceId((String)localObject1);
    }
    this.Cdm.bI("onJSAPIStart", System.currentTimeMillis());
    localObject1 = getIntent().getBundleExtra("jsapiargs");
    if (localObject1 == null) {
      localObject1 = new Bundle();
    }
    for (;;)
    {
      ((Bundle)localObject1).putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
      ((Bundle)localObject1).putString("key_function_id", getIntent().getStringExtra("key_function_id"));
      ac.i(getTAG(), "KDownloadRestrict = %d, KFunctionID = %s", new Object[] { Integer.valueOf(((Bundle)localObject1).getInt("key_download_restrict", 0)), ((Bundle)localObject1).getString("key_function_id", "") });
      localObject2 = new Bundle();
      ((Bundle)localObject2).putBundle("jsapiargs", (Bundle)localObject1);
      ((Bundle)localObject2).putCharSequence("bizofstartfrom", (CharSequence)getIntent().getStringExtra("bizofstartfrom"));
      ((Bundle)localObject2).putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
      ((Bundle)localObject2).putInt("screen_orientation", getScreenOrientation());
      try
      {
        eyr().a(20, (Bundle)localObject2, eyt());
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
        av localav = this.Cfc.eBH();
        localav.username = ((String)localObject3);
        localav.Crb = i;
        localav.dxX = bLL();
        localav.CqX = j;
        localav.scene = aAT((String)localObject3);
        localav.CqW = l;
        localav.CqY = new com.tencent.mm.b.p(l).toString();
        localav.CkC = str1;
        localav.CqV = ((String)localObject2);
        localav.hkW = str2;
        localav.appId = str4;
        localav.CqZ = str5;
        localav.Cra = this.Cey;
        localav.yAj = ((String)localObject1);
        localObject2 = getTitle();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localav.title = ((String)localObject1);
        localav.eSk = str3;
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
        localObject1 = this.Cfc.eBI();
        ((aj)localObject1).hkW = str2;
        ((aj)localObject1).scene = aAT((String)localObject3);
        this.Cfc.eBK().aCf(bLL());
        if (!eyQ()) {}
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
            eyr().a(29, (Bundle)localObject1, eyt());
            label731:
            if (!bs.isNullOrNil(str1)) {}
            try
            {
              eyr().aCV(str1);
              try
              {
                i = getIntent().getIntExtra("pay_channel", -1);
                if (i == -1) {
                  break label1538;
                }
                ac.i(getTAG(), "hy: found channel in intent. pay channel: %d", new Object[] { Integer.valueOf(i) });
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ac.e(getTAG(), "hy: init pay channel failed");
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
                  ac.i(getTAG(), "default pay scene to: %s", new Object[] { Integer.valueOf(3) });
                }
                if (!this.nKq.getIsX5Kernel()) {
                  break label1842;
                }
                com.tencent.mm.pluginsdk.ui.tools.p.lA(7);
                com.tencent.mm.plugin.report.service.h.wUl.a(64, 64, 1, 0, 1, 1, false);
                try
                {
                  i = bs.getInt(eyr().aCU("WebviewDisableDigestVerify"), 0);
                  ac.i(getTAG(), "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
                  if (i != 0) {
                    break label1806;
                  }
                  SharedPreferences localSharedPreferences = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                  d.g.b.k.g(localSharedPreferences, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
                  if ((!localSharedPreferences.getBoolean("wvsha1", true)) || (!this.CdP.CdV)) {
                    break label1806;
                  }
                  getJsapi().ezH();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    for (;;)
                    {
                      eyr().a(bLL(), true, null);
                      this.Cdm.bI("onPostBindedEnd", System.currentTimeMillis());
                      AppMethodBeat.o(189416);
                      return;
                      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(64L, 0L, 1L, false);
                    }
                    localException3 = localException3;
                    ac.w(getTAG(), "getting js digest verification config fails, ex = " + localException3.getMessage());
                    i = 0;
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      ac.w(getTAG(), "postBinded, jumpToActivity, ex = " + localException4.getMessage());
                    }
                  }
                }
              }
              this.CeH.clear();
              localObject1 = getJsapi();
              str1 = getIntent().getStringExtra("geta8key_username");
              localObject2 = ae.b(new o[] { d.u.Q("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0L))), d.u.Q("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), d.u.Q("scene", Integer.valueOf(aAT(str1))), d.u.Q("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), d.u.Q("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), d.u.Q("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))) });
              localObject3 = (CharSequence)getIntent().getStringExtra("srcUsername");
              if ((localObject3 == null) || (d.n.n.aD((CharSequence)localObject3)))
              {
                i = 1;
                if (i != 0) {
                  break label1609;
                }
                ((Map)localObject2).putAll((Map)ae.c(new o[] { d.u.Q("srcUsername", getIntent().getStringExtra("srcUsername")), d.u.Q("srcDisplayname", getIntent().getStringExtra("srcDisplayname")) }));
                if (!bs.isNullOrNil(getIntent().getStringExtra("KTemplateId")))
                {
                  str1 = getIntent().getStringExtra("KTemplateId");
                  d.g.b.k.g(str1, "intent.getStringExtra(Co…UI.WebViewUI.KTemplateId)");
                  ((Map)localObject2).put("KTemplateId", str1);
                }
                i = getIntent().getIntExtra("pay_scene", -1);
                if (i == -1) {
                  break label1656;
                }
                ac.i(getTAG(), "get pay scene from extra: %s", new Object[] { Integer.valueOf(i) });
                ((Map)localObject2).put("pay_scene", Integer.valueOf(i));
                ((com.tencent.mm.plugin.webview.c.f)localObject1).bt((Map)localObject2);
                localObject1 = this.CeH;
                localObject2 = (List)new ArrayList();
                ((List)localObject2).add(getJsapi());
                ((List)localObject2).add(this.CeI);
                ((List)localObject2).add(this.CeJ);
                ((List)localObject2).add(this.CeK);
                ((List)localObject2).add(this.CeL);
                ((List)localObject2).add(this.CeM);
                ((List)localObject2).add(this.CeN);
                ((List)localObject2).add(this.CeQ);
                ((List)localObject2).add(this.CeT);
                ((List)localObject2).add(this.CeU);
                ((List)localObject2).add(this.CeV);
                ((List)localObject2).add(this.CeX);
                ((List)localObject2).add(this.CeS);
                ((List)localObject2).add(this.CeW);
                ((List)localObject2).add(this.CeR);
                if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
                  ((List)localObject2).add(this.Cfa);
                }
                ((List)localObject2).add(this.CeZ);
                ((List)localObject1).addAll((Collection)localObject2);
                ac.i(getTAG(), "Abe-Debug controllerListeners call, size = %d", new Object[] { Integer.valueOf(this.Cdp.size()) });
                localObject1 = ((Iterable)this.Cdp).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  ((i)((Iterator)localObject1).next()).dKr();
                  continue;
                  localRemoteException = localRemoteException;
                  ac.e(getTAG(), "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + localRemoteException.getMessage());
                }
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ac.e(getTAG(), "postBinded, fail triggerGetContact, ex = " + localException1.getMessage());
                continue;
                i = eyr().eCQ();
                if (i != -1)
                {
                  ac.i(getTAG(), "hy: found channel in channel helper. pay channel: %d", new Object[] { Integer.valueOf(i) });
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
  
  protected final void eyD()
  {
    AppMethodBeat.i(189413);
    super.eyD();
    com.tencent.mm.plugin.webview.h.b.eCv();
    Object localObject = ((Iterable)this.Cdp).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((i)((Iterator)localObject).next()).a(this.Cdm);
    }
    localObject = this.Cdm;
    MMWebView localMMWebView = this.nKq;
    d.g.a.a locala = (d.g.a.a)new ab(this);
    d.g.b.k.h(localMMWebView, "webView");
    d.g.b.k.h(locala, "callback");
    localMMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", (ValueCallback)new com.tencent.mm.plugin.webview.j.h.b((com.tencent.mm.plugin.webview.j.h)localObject, locala));
    AppMethodBeat.o(189413);
  }
  
  protected final void eyE()
  {
    AppMethodBeat.i(189432);
    ac.d(getTAG(), "setGetA8KeyParams");
    Object localObject = getIntent().getStringExtra("geta8key_username");
    eyq().setUsername((String)localObject);
    eyq().setScene(aAT((String)localObject));
    eyq().setAppId(getIntent().getStringExtra("geta8key_open_webview_appid"));
    localObject = this.nKq;
    if (localObject != null)
    {
      localObject = Boolean.valueOf(((MMWebView)localObject).getIsX5Kernel());
      if (!((Boolean)localObject).booleanValue()) {
        break label184;
      }
      eyq().setFlag(1);
    }
    for (;;)
    {
      eyq().ag(getIntent().getByteArrayExtra("geta8key_cookie"));
      eyq().Va(getIntent().getIntExtra("key_wallet_region", 0));
      eyq().aCB(getIntent().getStringExtra("key_function_id"));
      int i = getIntent().getIntExtra("geta8key_session_id", 0);
      if (i > 0) {
        eyq().UZ(i);
      }
      AppMethodBeat.o(189432);
      return;
      localObject = null;
      break;
      label184:
      eyq().setFlag(0);
    }
  }
  
  public final boolean eyQ()
  {
    AppMethodBeat.i(189420);
    Object localObject = getIntent().getStringExtra("srcUsername");
    String str = getIntent().getStringExtra("bizofstartfrom");
    localObject = (CharSequence)localObject;
    if ((localObject == null) || (d.n.n.aD((CharSequence)localObject))) {}
    for (int i = 1; (i == 0) && (d.g.b.k.g(str, "enterpriseHomeSubBrand")); i = 0)
    {
      AppMethodBeat.o(189420);
      return true;
    }
    AppMethodBeat.o(189420);
    return false;
  }
  
  protected final Class<? extends Service> eyo()
  {
    AppMethodBeat.i(189394);
    Class localClass = (Class)this.Ceq.getValue();
    AppMethodBeat.o(189394);
    return localClass;
  }
  
  protected final Set<String> eyp()
  {
    AppMethodBeat.i(189395);
    Set localSet = (Set)this.Cer.getValue();
    AppMethodBeat.o(189395);
    return localSet;
  }
  
  protected final void eyy()
  {
    AppMethodBeat.i(189431);
    ac.i(getTAG(), "WebView-Trace setWebViewPluginClient");
    this.Cfb = com.tencent.luggage.k.a.d.a((WebView)this.nKq, (com.tencent.luggage.k.a.c.d)com.tencent.luggage.k.a.c.b.Fs(), (com.tencent.luggage.k.a.b.c)com.tencent.mm.plugin.webview.ui.tools.c.a.g.eGl(), null);
    AppMethodBeat.o(189431);
  }
  
  public final boolean eyz()
  {
    AppMethodBeat.i(189415);
    ac.i(getTAG(), "edw onServiceDisconnected");
    Iterator localIterator = ((Iterable)this.Cdn).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((j)localIterator.next()).eyZ());
    for (int i = 1; i == 0; i = 0)
    {
      ac.i(getTAG(), "maybe mm process crash, try rebind service");
      AppMethodBeat.o(189415);
      return true;
    }
    boolean bool = super.eyz();
    AppMethodBeat.o(189415);
    return bool;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(189396);
    Object localObject2 = this.nKq.getTitle();
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
    AppMethodBeat.o(189396);
    return localObject1;
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(189399);
    d.g.b.k.h(paramString, "url");
    ac.i(getTAG(), "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
    if (aAO(paramString))
    {
      ac.f(getTAG(), "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      super.h(paramWebView, paramString);
      AppMethodBeat.o(189399);
      return;
    }
    this.Cfc.eBG().aCh(paramString);
    super.h(paramWebView, paramString);
    AppMethodBeat.o(189399);
  }
  
  protected final boolean k(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(189408);
    d.g.b.k.h(paramWebView, "webView");
    d.g.b.k.h(paramString, "url");
    ac.i(getTAG(), "WebView-Trace shouldOverride url = ".concat(String.valueOf(paramString)));
    Object localObject;
    if (!(paramWebView instanceof MMWebView)) {
      localObject = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.model.a.a((MMWebView)localObject, paramString);
      localObject = j(paramWebView, paramString);
      if (((j.a)localObject).CfL)
      {
        boolean bool = ((j.a)localObject).result;
        AppMethodBeat.o(189408);
        return bool;
      }
      if (aAO(paramString))
      {
        ac.f(getTAG(), "shouldOverrideUrlLoading, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(189408);
        return true;
      }
      if (com.tencent.luggage.h.c.a(paramString, "about:blank", true))
      {
        ac.e(getTAG(), "shouldOverride, url is about:blank");
        AppMethodBeat.o(189408);
        return true;
      }
      if (DownloadChecker.a(paramString, eyM(), paramWebView))
      {
        ac.i(getTAG(), "use the downloader to download");
        AppMethodBeat.o(189408);
        return true;
      }
      try
      {
        if ((com.tencent.luggage.h.c.a(paramString, "weixin://jump/", true)) || (com.tencent.luggage.h.c.a(paramString, "weixin://scanqrcode/", true)))
        {
          d.g.b.k.h(paramString, "url");
          if (this.kYu.eCn().eRh())
          {
            paramWebView = new Bundle();
            paramWebView.putInt("fromScene", 100);
            if (eyr().a(paramString, this.kYu.eCm().ma(7), paramWebView)) {
              ac.i(getTAG(), "shouldOverride, built in url handled, url = ".concat(String.valueOf(paramString)));
            }
          }
          for (;;)
          {
            AppMethodBeat.o(189408);
            return true;
            ac.w(getTAG(), "shouldOverride, allow inner open url, not allow");
          }
        }
        int i;
        localObject = paramWebView;
      }
      catch (Exception paramWebView)
      {
        ac.w(getTAG(), "shouldOverride, jumpToActivity, ex = " + paramWebView.getMessage());
        while (aAU(paramString))
        {
          AppMethodBeat.o(189408);
          return true;
          if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/business")) && (com.tencent.mm.pluginsdk.f.v(Uri.parse(paramString))))
          {
            paramWebView = Uri.parse(bLL());
            d.g.b.k.g(paramWebView, "rawUrlUri");
            localObject = paramWebView.getHost();
            paramWebView = new Intent("android.intent.action.VIEW");
            paramWebView.addCategory("android.intent.category.BROWSABLE");
            paramWebView.setData(Uri.parse(paramString + "&domain=" + (String)localObject));
            i = paramWebView.getIntExtra("pay_channel", -1);
            if (i != -1)
            {
              ac.i(getTAG(), "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
              paramWebView.putExtra("pay_channel", i);
            }
            paramWebView.putExtra("translate_link_scene", 13);
            localObject = getContext();
            paramWebView = new com.tencent.mm.hellhoundlib.b.a().ba(paramWebView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject, paramWebView.aeD(), "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject).startActivity((Intent)paramWebView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/webview/core/WebViewController", "overrideUrl", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(189408);
            return true;
          }
          if (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe"))
          {
            ac.i(getTAG(), "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
          }
          else if ((com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/common_view")) || (com.tencent.luggage.h.c.A(paramString, "weixin://dl/login/phone_view")))
          {
            if (((com.tencent.luggage.h.c.A(bLL(), "https://support.weixin.qq.com/security")) || (com.tencent.luggage.h.c.A(paramString, "https://support.wechat.com/security"))) && (((Boolean)this.Ces.getValue()).booleanValue()))
            {
              com.tencent.mm.pluginsdk.f.bG(getContext(), paramString);
              onFinish();
              AppMethodBeat.o(189408);
              return true;
            }
          }
          else if ((com.tencent.luggage.h.c.A(paramString, "weixin://webview/initReady/")) || (com.tencent.luggage.h.c.A(paramString, "weixin://webview/preInjectJSBridge/")))
          {
            AppMethodBeat.o(189408);
            return true;
          }
        }
        if (com.tencent.luggage.h.c.A(paramString, "weixin://"))
        {
          ac.e(getTAG(), "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
          AppMethodBeat.o(189408);
          return true;
        }
        ac.i(getTAG(), "edw overrideUrl");
        if ((com.tencent.luggage.h.c.A(paramString, "weixinping://iframe")) || (com.tencent.luggage.h.c.A(paramString, "weixinpreinject://iframe")))
        {
          AppMethodBeat.o(189408);
          return true;
        }
        if (aAS(paramString))
        {
          ac.i(getTAG(), "custom scheme url deal success, url = ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(189408);
          return true;
        }
        AppMethodBeat.o(189408);
        return false;
      }
    }
  }
  
  public final void loadUrl(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(189419);
    d.g.b.k.h(paramString, "url");
    com.tencent.mm.plugin.webview.model.a.a(this.nKq, paramString);
    super.loadUrl(paramString, paramMap, paramBoolean);
    AppMethodBeat.o(189419);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(189430);
    eyN().n("", bs.aNx(), 0);
    eyO().detach();
    if (eyQ()) {}
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
      eyr().a(30, localBundle, eyt());
      try
      {
        label75:
        eyr().Vv(eyR().eyt());
        super.onDestroy();
        AppMethodBeat.o(189430);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          ac.i(getTAG(), "onDestroy remove callbacker ex " + localException1.getMessage());
        }
      }
    }
    catch (Exception localException2)
    {
      break label75;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189324);
      d.g.b.k.h(paramString, "url");
      if (!this.Cfe.kYu.eCn().eRh())
      {
        ac.e(h.a(this.Cfe), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
        AppMethodBeat.o(189324);
        return true;
      }
      try
      {
        this.Cfe.eyr().cj(paramString, this.Cfe.kYu.eCm().ma(7));
        AppMethodBeat.o(189324);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.w(h.a(this.Cfe), "ActivityJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189323);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189323);
        return false;
      }
      boolean bool = x.B(paramString, "weixin://jump/");
      AppMethodBeat.o(189323);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$oauthOnSceneEndDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"})
  public static final class aa
    implements ag.a
  {
    private final Map<Integer, Integer> CfB;
    
    aa()
    {
      AppMethodBeat.i(189377);
      this.CfB = ((Map)new HashMap());
      AppMethodBeat.o(189377);
    }
    
    public final void vM()
    {
      AppMethodBeat.i(189376);
      h.a(this.Cfe, 1373);
      if (this.CfB.containsKey(Integer.valueOf(1373)))
      {
        Object localObject = this.CfB.get(Integer.valueOf(1373));
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        int i = ((Number)localObject).intValue();
        this.CfB.put(Integer.valueOf(1373), Integer.valueOf(i - 1));
        AppMethodBeat.o(189376);
        return;
      }
      this.CfB.put(Integer.valueOf(1373), Integer.valueOf(0));
      AppMethodBeat.o(189376);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class ab
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    ab(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getNetWorkTypeName", "", "context", "Landroid/content/Context;", "invoke"})
  static final class ac
    extends d.g.b.l
    implements d.g.a.b<Context, String>
  {
    public static final ac CfC;
    
    static
    {
      AppMethodBeat.i(189381);
      CfC = new ac();
      AppMethodBeat.o(189381);
    }
    
    ac()
    {
      super();
    }
    
    public static String gK(Context paramContext)
    {
      AppMethodBeat.i(189380);
      d.g.b.k.h(paramContext, "context");
      if (com.tencent.mm.sdk.platformtools.ax.isWifi(paramContext))
      {
        AppMethodBeat.o(189380);
        return "wifi";
      }
      if (com.tencent.mm.sdk.platformtools.ax.is4G(paramContext))
      {
        AppMethodBeat.o(189380);
        return "4g";
      }
      if (com.tencent.mm.sdk.platformtools.ax.is3G(paramContext))
      {
        AppMethodBeat.o(189380);
        return "3g";
      }
      if (com.tencent.mm.sdk.platformtools.ax.is2G(paramContext))
      {
        AppMethodBeat.o(189380);
        return "2g";
      }
      AppMethodBeat.o(189380);
      return "none";
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"dnsIps", "", "host", "invoke"})
  static final class ad
    extends d.g.b.l
    implements d.g.a.b<String, String>
  {
    ad(h paramh)
    {
      super();
    }
    
    public final String aAX(String paramString)
    {
      AppMethodBeat.i(189383);
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
        ac.printErrStackTrace(h.a(this.Cfe), (Throwable)paramString, "dnsIps", new Object[0]);
        AppMethodBeat.o(189383);
        return null;
      }
      AppMethodBeat.o(189383);
      return paramString;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class ae
    implements Runnable
  {
    ae(String paramString1, int paramInt, h.ad paramad, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(189384);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      String str = this.CfD;
      int i = paramInt;
      Object localObject = h.ac.CfC;
      localObject = ai.getContext();
      d.g.b.k.g(localObject, "MMApplicationContext.getContext()");
      localh.f(17082, new Object[] { str, Integer.valueOf(i), h.ac.gK((Context)localObject), this.CfE.aAX(this.CfF) });
      AppMethodBeat.o(189384);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class af
    implements Runnable
  {
    af(h paramh, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(189385);
      this.Cfe.getJsapi().UD(i);
      Object localObject = this.Cfe;
      int i = i;
      localObject = ((Iterable)((BaseWebViewController)localObject).Cdp).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((i)((Iterator)localObject).next()).UD(i);
      }
      AppMethodBeat.o(189385);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "invoke"})
  static final class ag
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.modeltools.n>
  {
    public static final ag CfH;
    
    static
    {
      AppMethodBeat.i(189387);
      CfH = new ag();
      AppMethodBeat.o(189387);
    }
    
    ag()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "invoke"})
  static final class ah
    extends d.g.b.l
    implements d.g.a.a<h.p>
  {
    ah(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "invoke"})
  static final class ai
    extends d.g.b.l
    implements d.g.a.a<com.tencent.mm.plugin.webview.ui.tools.c>
  {
    ai(h paramh, MMWebView paramMMWebView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;", "invoke"})
  static final class aj
    extends d.g.b.l
    implements d.g.a.a<Class<WebViewStubService>>
  {
    public static final aj CfI;
    
    static
    {
      AppMethodBeat.i(189390);
      CfI = new aj();
      AppMethodBeat.o(189390);
    }
    
    aj()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "invoke"})
  static final class ak
    extends d.g.b.l
    implements d.g.a.a<h.t>
  {
    ak(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class b
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cff = "weixin://addfriend/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189326);
      d.g.b.k.h(paramString, "url");
      if (!this.Cfe.kYu.eCm().ma(5))
      {
        ac.e(h.a(this.Cfe), "AddFriendHandler, permission fail");
        AppMethodBeat.o(189326);
        return true;
      }
      paramString = paramString.substring(this.Cff.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189326);
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_webview", true);
      localBundle.putString("userName", paramString);
      try
      {
        this.Cfe.eyr().a(8, localBundle, this.Cfe.eyt());
        AppMethodBeat.o(189326);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.w(h.a(this.Cfe), "AddFriendHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189325);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189325);
        return false;
      }
      boolean bool = x.B(paramString, this.Cff);
      AppMethodBeat.o(189325);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class c
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfg = "weixin://webview/close/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189328);
      d.g.b.k.h(paramString, "url");
      if (!this.Cfe.kYu.eCm().ma(17))
      {
        ac.e(h.a(this.Cfe), "close window permission fail");
        AppMethodBeat.o(189328);
        return true;
      }
      this.Cfe.onFinish();
      AppMethodBeat.o(189328);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189327);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189327);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfg);
      AppMethodBeat.o(189327);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"})
  public static final class d {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class e
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfh = "weixin://critical_update/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189330);
      d.g.b.k.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 25L, 1L, true);
      h.b(this.Cfe, 1);
      AppMethodBeat.o(189330);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189329);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189329);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfh);
      AppMethodBeat.o(189329);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class f
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    f(MMWebView paramMMWebView) {}
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189332);
      d.g.b.k.h(paramString, "url");
      int i = this.Cfe.aAT(bs.nullAsNil(h.i(this.Cfe)));
      if (com.tencent.mm.pluginsdk.f.bH(paramString, h.j(this.Cfe))) {}
      for (;;)
      {
        try
        {
          Object localObject;
          if (d.g.b.k.g("weixin://dl/shopping", paramString))
          {
            localObject = this.Cfe.eyr().eCG();
            d.g.b.k.g(localObject, "invoker.getJDUrl()");
            if (!bs.isNullOrNil((String)localObject)) {
              BaseWebViewController.a(this.Cfe, (String)localObject, null, 6);
            }
            localObject = (List)new ArrayList();
            ((List)localObject).add(paramString);
            ((List)localObject).add("1");
            ((List)localObject).add(String.valueOf(i));
            paramString = bs.nullAsNil(h.i(this.Cfe));
            d.g.b.k.g(paramString, "Util.nullAsNil(sentUsername)");
            ((List)localObject).add(paramString);
            paramString = bs.nullAsNil(this.Cfe.bLL());
            d.g.b.k.g(paramString, "Util.nullAsNil(rawUrl)");
            ((List)localObject).add(paramString);
            paramString = com.tencent.mm.plugin.report.service.h.wUl;
            com.tencent.mm.plugin.report.service.h.k(11405, (List)localObject);
            bool = true;
            AppMethodBeat.o(189332);
            return bool;
          }
          if (d.g.b.k.g("weixin://dl/faq", paramString))
          {
            int j = this.Cfe.eyr().eCI();
            int k = this.Cfe.eyr().eCJ();
            localObject = ai.getContext().getString(2131763450, new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
            h localh = this.Cfe;
            d.g.b.k.g(localObject, "rawUrl");
            BaseWebViewController.a(localh, (String)localObject, null, 6);
            continue;
          }
        }
        catch (Exception paramString)
        {
          ac.e(h.a(this.Cfe), "kv report fail, ex = %s", new Object[] { paramString.getMessage() });
          bool = true;
          continue;
          if (d.g.b.k.g("weixin://dl/posts", paramString))
          {
            this.Cfe.eyr().eCK();
            continue;
          }
          if (d.g.b.k.g("weixin://dl/moments", paramString))
          {
            this.Cfe.eyr().eCL();
            continue;
          }
          if (d.n.n.nb(paramString, "weixin://dl/feedback"))
          {
            d.g.b.k.g(this.Cfe.eyr().aCZ(paramString), "invoker.getFeedbackUrl(url)");
            continue;
          }
          if (d.g.b.k.g("weixin://dl/scan", paramString))
          {
            com.tencent.mm.br.d.c(this.Cfe.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
            continue;
          }
          com.tencent.mm.pluginsdk.f.bF(paramMMWebView.getActivityContextIfHas(), paramString);
          continue;
        }
        boolean bool = false;
      }
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189331);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189331);
        return false;
      }
      boolean bool = x.B(paramString, "weixin://");
      AppMethodBeat.o(189331);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class g
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfi = "weixin://feedback/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189334);
      d.g.b.k.h(paramString, "url");
      paramString = new Bundle();
      paramString.putInt("MMActivity.OverrideEnterAnimation", 0);
      paramString.putInt("MMActivity.OverrideExitAnimation", 2130772106);
      try
      {
        this.Cfe.eyr().a(7, paramString, this.Cfe.eyt());
        AppMethodBeat.o(189334);
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.w(h.a(this.Cfe), "FeedbackJumpHandler, ex = " + paramString.getMessage());
        }
      }
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189333);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189333);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfi);
      AppMethodBeat.o(189333);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class h
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfj = "weixin://connectToFreeWifi/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189336);
      d.g.b.k.h(paramString, "url");
      paramString = Uri.parse(paramString);
      String str1 = paramString.getQueryParameter("apKey");
      ac.i(h.a(this.Cfe), "apKey value = %s", new Object[] { str1 });
      String str2 = paramString.getQueryParameter("ticket");
      if (!bs.isNullOrNil(str1))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("free_wifi_schema_uri", paramString.toString());
        localIntent.putExtra("free_wifi_ap_key", str1);
        localIntent.putExtra("free_wifi_source", 5);
        if (!bs.isNullOrNil(str2)) {
          localIntent.putExtra("free_wifi_schema_ticket", str2);
        }
        localIntent.addFlags(67108864);
        com.tencent.mm.br.d.b(ai.getContext(), "freewifi", ".ui.FreeWifiEntryUI", localIntent);
      }
      AppMethodBeat.o(189336);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189335);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189335);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfj);
      AppMethodBeat.o(189335);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class i
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfk = "weixin://gethtml/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189338);
      d.g.b.k.h(paramString, "url");
      if (!bs.isNullOrNil(paramString))
      {
        paramString = paramString.substring(this.Cfk.length());
        d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
        ac.i(h.a(this.Cfe), "[oneliang]get html content :".concat(String.valueOf(paramString)));
        Object localObject = this.Cfe;
        d.g.b.k.h(paramString, "html");
        localObject = ((Iterable)((BaseWebViewController)localObject).Cdp).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((i)((Iterator)localObject).next()).aAZ(paramString);
        }
      }
      AppMethodBeat.o(189338);
      return false;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189337);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189337);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfk);
      AppMethodBeat.o(189337);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class j
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfl = "weixin://profile/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189340);
      d.g.b.k.h(paramString, "url");
      paramString = paramString.substring(this.Cfl.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        ac.e(h.a(this.Cfe), "handleUrl fail, username is null");
        AppMethodBeat.o(189340);
        return true;
      }
      if (this.Cfe.kYu.eCm().ma(2)) {
        this.Cfe.getJsapi().aBn(paramString);
      }
      AppMethodBeat.o(189340);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189339);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189339);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfl);
      AppMethodBeat.o(189339);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class k
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfm = "weixin://manual_update/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189342);
      d.g.b.k.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 26L, 1L, true);
      h.b(this.Cfe, 3);
      AppMethodBeat.o(189342);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189341);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189341);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfm);
      AppMethodBeat.o(189341);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
  public static final class l
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189344);
      d.g.b.k.h(paramString, "url");
      String str = this.Cfe.getIntent().getStringExtra("geta8key_username");
      boolean bool = ag.b.a(paramString, str, this.Cfe.aAT(str), this.Cfe.eyr(), h.d(this.Cfe), this.Cfe.CeF, h.e(this.Cfe).eyt(), this.Cfe.getContext());
      AppMethodBeat.o(189344);
      return bool;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189343);
      d.g.b.k.h(paramString, "url");
      boolean bool = ag.b.fm(paramString, this.Cfe.getIntent().getIntExtra("geta8key_scene", 0));
      AppMethodBeat.o(189343);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "READER_SHARE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "share", "", "plugin-webview_release"})
  public static final class m
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfn = "weixin://readershare/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189347);
      d.g.b.k.h(paramString, "url");
      paramString = this.Cfe.getContext().getString(2131762183);
      d.g.b.k.g(paramString, "context.getString(R.string.readerapp_share_weibo)");
      Context localContext = this.Cfe.getContext();
      com.tencent.mm.ui.base.h.c localc = (com.tencent.mm.ui.base.h.c)new a(this);
      com.tencent.mm.ui.base.h.a(localContext, "", new String[] { paramString }, "", localc);
      AppMethodBeat.o(189347);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189346);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189346);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfn);
      AppMethodBeat.o(189346);
      return bool;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "whichButton", "", "onClick"})
    static final class a
      implements com.tencent.mm.ui.base.h.c
    {
      a(h.m paramm) {}
      
      public final void kG(int paramInt)
      {
        AppMethodBeat.i(189345);
        if (paramInt == 0)
        {
          h.m localm = this.Cfo;
          try
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("shortUrl", localm.Cfe.getIntent().getStringExtra("shortUrl"));
            localBundle.putInt("type", localm.Cfe.getIntent().getIntExtra("type", 0));
            localm.Cfe.eyr().a(4, localBundle, localm.Cfe.eyt());
            AppMethodBeat.o(189345);
            return;
          }
          catch (Exception localException)
          {
            ac.e(h.a(localm.Cfe), "share fail, ex = " + localException.getMessage());
          }
        }
        AppMethodBeat.o(189345);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class n
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfp = "weixin://recommend_update/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189349);
      d.g.b.k.h(paramString, "url");
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 24L, 1L, true);
      h.b(this.Cfe, 2);
      AppMethodBeat.o(189349);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189348);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189348);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfp);
      AppMethodBeat.o(189348);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class o
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cfq = "weixin://openapi/openwebview/result?";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189351);
      d.g.b.k.h(paramString, "url");
      Object localObject = new OpenWebview.Resp();
      paramString = Uri.parse(paramString);
      d.g.b.k.g(paramString, "uri");
      ((OpenWebview.Resp)localObject).result = paramString.getQuery();
      ((OpenWebview.Resp)localObject).errCode = bs.getInt(paramString.getQueryParameter("errCode"), 0);
      ((OpenWebview.Resp)localObject).errStr = paramString.getQueryParameter("errMsg");
      ((OpenWebview.Resp)localObject).transaction = this.Cfe.getIntent().getStringExtra("transaction_for_openapi_openwebview");
      paramString = paramString.getQueryParameter("appid");
      if (bs.isNullOrNil(paramString))
      {
        ac.e(h.a(this.Cfe), "SDKOpenWebViewResultHandler handleUrl, appId is null");
        AppMethodBeat.o(189351);
        return true;
      }
      Bundle localBundle = new Bundle();
      ((OpenWebview.Resp)localObject).toBundle(localBundle);
      q.aW(localBundle);
      localObject = new MMessageActV2.Args();
      try
      {
        ((MMessageActV2.Args)localObject).targetPkgName = this.Cfe.eyr().aCS(paramString);
        ((MMessageActV2.Args)localObject).bundle = localBundle;
        ac.d(h.a(this.Cfe), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[] { localObject });
        MMessageActV2.send(this.Cfe.getContext(), (MMessageActV2.Args)localObject);
        this.Cfe.onFinish();
        AppMethodBeat.o(189351);
        return true;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace(h.a(this.Cfe), (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(189351);
      }
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189350);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189350);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfq);
      AppMethodBeat.o(189350);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"})
  static final class p
    extends com.tencent.mm.plugin.webview.ui.tools.widget.m
  {
    private final d.f Cdh;
    private final h Cfr;
    private final String TAG;
    
    static
    {
      AppMethodBeat.i(189353);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(p.class), "binderId", "getBinderId()I")) };
      AppMethodBeat.o(189353);
    }
    
    public p(h paramh)
    {
      AppMethodBeat.i(189356);
      this.Cfr = paramh;
      this.TAG = ("MicroMsg.WebViewController.SceneEndCallbacker:" + this.Cfr.eyt());
      this.Cdh = d.g.K((d.g.a.a)new a(this));
      AppMethodBeat.o(189356);
    }
    
    public final boolean a(com.tencent.mm.plugin.webview.stub.d paramd)
    {
      AppMethodBeat.i(189355);
      ac.i(this.TAG, "onSceneEnd, instance hashcode = " + hashCode());
      h localh;
      if (paramd != null)
      {
        int i = paramd.getData().getInt("scene_end_listener_hash_code");
        ac.i(this.TAG, "get hash code = %d, self hash code = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(eyt()) });
        ac.i(this.TAG, "edw onSceneEnd, type = " + paramd.getType() + ", errCode = " + paramd.getErrCode() + ", errType = " + paramd.getErrType());
        if (i != eyt())
        {
          ac.e(this.TAG, "hash code not equal");
          AppMethodBeat.o(189355);
          return false;
        }
        localh = this.Cfr;
        switch (paramd.getType())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(189355);
        return true;
        h.a(localh, 106);
        localh.onFinish();
        continue;
        h.a(localh, 666);
        localh.onFinish();
      }
    }
    
    public final int eyt()
    {
      AppMethodBeat.i(189354);
      int i = ((Number)this.Cdh.getValue()).intValue();
      AppMethodBeat.o(189354);
      return i;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class q
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    q(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class r
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    final String Cfk = "weixin://private/gethtml/";
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189359);
      d.g.b.k.h(paramString, "url");
      paramString = paramString.substring(this.Cfk.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      try
      {
        paramString = URLDecoder.decode(paramString);
        Bundle localBundle = new Bundle();
        localBundle.putString("nowUrl", h.f(this.Cfe));
        localBundle.putString("tweetid", bs.nullAsNil(this.Cfe.getIntent().getStringExtra("tweetid")));
        localBundle.putString("htmlData", paramString);
        localBundle.putInt("type", this.Cfe.getIntent().getIntExtra("type", 0));
        this.Cfe.eyr().a(3, localBundle, this.Cfe.eyt());
        AppMethodBeat.o(189359);
        return true;
      }
      catch (Exception paramString)
      {
        ac.e(h.a(this.Cfe), "edw ViewImageGetHtmlHandler handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(189359);
      }
      return false;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189358);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189358);
        return false;
      }
      boolean bool = x.B(paramString, this.Cfk);
      AppMethodBeat.o(189358);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
  public static final class s
    implements com.tencent.mm.plugin.webview.c.d.a
  {
    private final String Cft = "weixin://viewimage/";
    
    s(MMWebView paramMMWebView) {}
    
    public final boolean aAU(String paramString)
    {
      AppMethodBeat.i(189361);
      d.g.b.k.h(paramString, "url");
      try
      {
        if (!this.Cfe.eyr().isSDCardAvailable())
        {
          this.Cfe.eyr().a(2, null, this.Cfe.eyt());
          AppMethodBeat.o(189361);
          return true;
        }
      }
      catch (Exception paramString)
      {
        ac.e(h.a(this.Cfe), "edw handleUrl, ex = " + paramString.getMessage());
        AppMethodBeat.o(189361);
        return false;
      }
      h localh = this.Cfe;
      paramString = paramString.substring(this.Cft.length());
      d.g.b.k.g(paramString, "(this as java.lang.String).substring(startIndex)");
      h.a(localh, paramString);
      ac.i(h.a(this.Cfe), "viewimage currentUrl :" + h.f(this.Cfe));
      x.a((WebView)paramMMWebView, h.g(this.Cfe).Cfk, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", h.h(this.Cfe));
      AppMethodBeat.o(189361);
      return true;
    }
    
    public final boolean aAV(String paramString)
    {
      AppMethodBeat.i(189360);
      d.g.b.k.h(paramString, "url");
      if (bs.isNullOrNil(paramString))
      {
        AppMethodBeat.o(189360);
        return false;
      }
      boolean bool = x.B(paramString, this.Cft);
      AppMethodBeat.o(189360);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"})
  final class t
  {
    private final h Cfr;
    private volatile String Cfu;
    private volatile String Cfv;
    private int fromScene;
    private long lTj;
    private int networkType;
    private String userAgent;
    
    public t()
    {
      AppMethodBeat.i(189365);
      this.Cfr = localObject;
      this$1 = this.Cfr.nKq.getSettings();
      d.g.b.k.g(h.this, "controller.viewWV.settings");
      this$1 = h.this.getUserAgentString();
      d.g.b.k.g(h.this, "controller.viewWV.settings.userAgentString");
      this.userAgent = h.this;
      this.fromScene = this.Cfr.getIntent().getIntExtra("from_scence", 0);
      this.Cfu = "";
      this.Cfv = "";
      AppMethodBeat.o(189365);
    }
    
    private void eyT()
    {
      AppMethodBeat.i(189363);
      Context localContext = this.Cfr.getContext();
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
        localObject = this.Cfr.getContext();
      }
      int i;
      if (com.tencent.mm.sdk.platformtools.ax.isConnected((Context)localObject))
      {
        if (!com.tencent.mm.sdk.platformtools.ax.isWifi((Context)localObject)) {
          break label108;
        }
        i = 1;
      }
      for (;;)
      {
        this.networkType = i;
        ac.i(h.a(h.this), "get networkType " + this.networkType);
        AppMethodBeat.o(189363);
        return;
        label108:
        if (com.tencent.mm.sdk.platformtools.ax.is4G((Context)localObject)) {
          i = 4;
        } else if (com.tencent.mm.sdk.platformtools.ax.is3G((Context)localObject)) {
          i = 3;
        } else if (com.tencent.mm.sdk.platformtools.ax.is2G((Context)localObject)) {
          i = 2;
        } else {
          i = 0;
        }
      }
    }
    
    public final void n(String paramString, long paramLong, int paramInt)
    {
      AppMethodBeat.i(189364);
      d.g.b.k.h(paramString, "targetUrl");
      eyT();
      String str5 = this.Cfr.aAP(this.Cfv);
      if (this.fromScene != 0) {
        this.Cfu = " ";
      }
      boolean bool = this.Cfr.kYu.eCn().eRl();
      ac.d(h.a(h.this), "webpageVisitInfoReport enableReportPageEvent %s", new Object[] { Boolean.valueOf(bool) });
      long l1;
      long l2;
      Object localObject2;
      String str3;
      String str1;
      if ((this.lTj > 0L) && (h.b(h.this) > this.lTj) && (paramLong > h.b(h.this)) && (!TextUtils.isEmpty((CharSequence)str5)) && (bool))
      {
        l1 = h.b(h.this) - this.lTj;
        l2 = paramLong - h.b(h.this);
        ac.d(h.a(h.this), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[] { Integer.valueOf(13376), Long.valueOf(this.lTj), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), this.userAgent, this.Cfv, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), paramString, Integer.valueOf(this.fromScene), this.Cfu });
        localObject2 = "";
        localObject4 = "";
        str3 = "";
        str1 = str3;
        localObject1 = localObject4;
      }
      try
      {
        localObject3 = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(this.userAgent), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        localObject4 = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(this.Cfv), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        str3 = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString), "UTF-8");
        str1 = str3;
        localObject1 = localObject4;
        localObject2 = localObject3;
        String str4 = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(this.Cfu), "UTF-8");
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
          ac.printErrStackTrace(h.a(h.this), (Throwable)localUnsupportedEncodingException, "", new Object[0]);
          String str2 = "";
          localObject4 = localObject1;
        }
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(13376, new Object[] { Long.valueOf(this.lTj), str5, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(this.networkType), localObject2, localObject4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(paramInt), str1, Integer.valueOf(this.fromScene), localObject3 });
      this.fromScene = 0;
      if (paramInt == 1)
      {
        this.Cfu = this.Cfv;
        this.Cfv = paramString;
        this.lTj = paramLong;
      }
      AppMethodBeat.o(189364);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(h.t paramt, String paramString, long paramLong) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(189362);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.Cfw.n(this.Cfx, this.Cfy, this.Cfz);
        AppMethodBeat.o(189362);
        return false;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class u
    implements Runnable
  {
    u(h paramh, Uri paramUri) {}
    
    public final void run()
    {
      AppMethodBeat.i(189366);
      com.tencent.mm.pluginsdk.model.app.h.h(this.Cfe.getContext(), localUri);
      AppMethodBeat.o(189366);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/HashSet;", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.a<HashSet<String>>
  {
    v(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    w(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    x(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class y
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    y(h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/core/WebViewController$oauthDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"})
  public static final class z
    implements ag.c
  {
    private static void c(Dialog paramDialog)
    {
      AppMethodBeat.i(189375);
      if ((paramDialog != null) && (paramDialog.isShowing()))
      {
        paramDialog.dismiss();
        paramDialog.setCancelMessage(null);
        paramDialog.setDismissMessage(null);
      }
      AppMethodBeat.o(189375);
    }
    
    public final void aAW(String paramString)
    {
      AppMethodBeat.i(189371);
      d.g.b.k.h(paramString, "url");
      this.Cfe.k(paramString, true, 9);
      AppMethodBeat.o(189371);
    }
    
    public final void cdf()
    {
      AppMethodBeat.i(189374);
      c((Dialog)h.c(this.Cfe));
      AppMethodBeat.o(189374);
    }
    
    public final void d(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      AppMethodBeat.i(189373);
      d.g.b.k.h(paramOnCancelListener, "cancelListener");
      c((Dialog)h.c(this.Cfe));
      h.a(this.Cfe, com.tencent.mm.ui.base.h.b(this.Cfe.getContext(), this.Cfe.getContext().getString(2131761776), true, paramOnCancelListener));
      AppMethodBeat.o(189373);
    }
    
    public final void goBack()
    {
      AppMethodBeat.i(189372);
      Iterator localIterator = ((Iterable)this.Cfe.Cdp).iterator();
      while (localIterator.hasNext()) {
        ((i)localIterator.next()).eyV();
      }
      AppMethodBeat.o(189372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.h
 * JD-Core Version:    0.7.0.1
 */