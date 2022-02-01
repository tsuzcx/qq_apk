package com.tencent.mm.plugin.webview.f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.az.c.a;
import com.tencent.mm.plugin.brandservice.api.h.b;
import com.tencent.mm.plugin.brandservice.api.h.c;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.i.a;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.core.m.a;
import com.tencent.mm.plugin.webview.h.f;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.k.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "canInjectPrefetcherJsBridge", "", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "hasReportInPageCommit", "hasReportInPageFinish", "hasShowDebugToast", "isPageCached", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchId", "getPrefetchId", "()Ljava/lang/String;", "prefetchId$delegate", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "prefetcherJsApiHandler", "Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherJsApiHandler;", "rawUrl", "getRawUrl", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "attachPrefetchJsApi", "", "getA8KeyReason", "", "url", "initPrefetcherJsApiHandler", "resp", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideStartLoadBefore", "intent", "Landroid/content/Intent;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "forceRedirect", "fullUrl", "resetPrefetchInfo", "showDebugToast", "isMainFrame", "delayShow", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends m
{
  final String TAG;
  h.b WPE;
  boolean WPF;
  boolean WPG;
  boolean WPH;
  private boolean WPI;
  private final j WPJ;
  private final long WPK;
  boolean WPL;
  c WPM;
  private boolean WPN;
  private final j Wwv;
  private final com.tencent.mm.plugin.webview.core.h Wzy;
  private final com.tencent.mm.plugin.webview.core.l sMB;
  
  public a()
  {
    AppMethodBeat.i(294619);
    this.TAG = "MicroMsg.WebPrefetcherInterceptor";
    this.WPJ = k.cm((kotlin.g.a.a)a.WPO);
    this.WPK = 500L;
    this.Wwv = k.cm((kotlin.g.a.a)new e(this));
    this.Wzy = ((com.tencent.mm.plugin.webview.core.h)new c(this));
    this.sMB = ((com.tencent.mm.plugin.webview.core.l)new d(this));
    AppMethodBeat.o(294619);
  }
  
  private static final void a(Context paramContext, boolean paramBoolean, h.b paramb)
  {
    AppMethodBeat.i(294643);
    kotlin.g.b.s.u(paramContext, "$it");
    kotlin.g.b.s.u(paramb, "$prefetchResp");
    Object localObject1 = am.aixg;
    String str = paramContext.getString(com.tencent.mm.plugin.ba.a.e.webview_debug_web_prefetch_hit_toast);
    kotlin.g.b.s.s(str, "it.getString(R.string.we…g_web_prefetch_hit_toast)");
    long l;
    Object localObject2;
    int i;
    if (paramBoolean)
    {
      localObject1 = "HTML";
      l = paramb.vBb;
      localObject2 = paramb.vBd;
      if (localObject2 != null) {
        break label147;
      }
      i = -1;
      label65:
      paramb = paramb.vBd;
      if (paramb != null) {
        break label156;
      }
      paramb = "null";
    }
    for (;;)
    {
      paramb = String.format(str, Arrays.copyOf(new Object[] { localObject1, Long.valueOf(l), Integer.valueOf(i), paramb }, 4));
      kotlin.g.b.s.s(paramb, "java.lang.String.format(format, *args)");
      Toast.makeText(paramContext, (CharSequence)paramb, 0).show();
      AppMethodBeat.o(294643);
      return;
      localObject1 = "JS/CSS";
      break;
      label147:
      i = ((h.c)localObject2).pkgVersion;
      break label65;
      label156:
      localObject2 = paramb.vBj;
      paramb = (h.b)localObject2;
      if (localObject2 == null) {
        paramb = "null";
      }
    }
  }
  
  private final void a(boolean paramBoolean, h.b paramb, long paramLong)
  {
    AppMethodBeat.i(294635);
    Object localObject = com.tencent.mm.plugin.webview.core.i.Wya;
    if (i.a.isq())
    {
      localObject = getController().sMP.getActivityContextIfHas();
      if (localObject != null) {
        com.tencent.threadpool.h.ahAA.o(new a..ExternalSyntheticLambda0((Context)localObject, paramBoolean, paramb), paramLong);
      }
    }
    AppMethodBeat.o(294635);
  }
  
  private final boolean bli(String paramString)
  {
    AppMethodBeat.i(294630);
    com.tencent.mm.plugin.brandservice.api.h localh = iws();
    if ((localh != null) && (localh.fI(getController().dgY(), paramString) == true))
    {
      i = 1;
      if (i == 0) {
        break label87;
      }
      localh = iws();
      if ((localh == null) || (localh.fJ(paramString, iwt()) != true)) {
        break label82;
      }
    }
    label82:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label87;
      }
      AppMethodBeat.o(294630);
      return true;
      i = 0;
      break;
    }
    label87:
    AppMethodBeat.o(294630);
    return false;
  }
  
  private final String iwt()
  {
    AppMethodBeat.i(294623);
    String str = (String)this.Wwv.getValue();
    AppMethodBeat.o(294623);
    return str;
  }
  
  public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(294713);
    kotlin.g.b.s.u(paramString1, "reqUrl");
    kotlin.g.b.s.u(paramString2, "fullUrl");
    if ((!paramBoolean) && (paramInt == 10))
    {
      AppMethodBeat.o(294713);
      return true;
    }
    AppMethodBeat.o(294713);
    return false;
  }
  
  public final boolean ajR(String paramString)
  {
    AppMethodBeat.i(294667);
    kotlin.g.b.s.u(paramString, "url");
    Object localObject = this.WPE;
    if (localObject == null) {}
    for (localObject = null; ((kotlin.g.b.s.p(paramString, localObject)) || (this.WPF)) && (getController().irY()); localObject = ((h.b)localObject).url)
    {
      Log.i(this.TAG, "overrideReload url: %s", new Object[] { paramString });
      iwu();
      getController().WwQ = true;
      getController().m(paramString, true, 8);
      AppMethodBeat.o(294667);
      return true;
    }
    AppMethodBeat.o(294667);
    return false;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    Object localObject1 = null;
    AppMethodBeat.i(294740);
    kotlin.g.b.s.u(paramWebView, "webview");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    String str1;
    if (this.WPE != null)
    {
      str1 = paramWebResourceRequest.getUrl().toString();
      kotlin.g.b.s.s(str1, "request.url.toString()");
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.WPE;
        if (paramWebView == null)
        {
          paramWebView = null;
          if (!kotlin.g.b.s.p(str1, paramWebView))
          {
            paramWebView = this.WPE;
            if ((paramWebView == null) || (paramWebView.vBg != true)) {
              break label126;
            }
          }
        }
        label126:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label307;
          }
          paramWebView = this.WPE;
          if (paramWebView != null) {
            break label131;
          }
          AppMethodBeat.o(294740);
          return null;
          paramWebView = paramWebView.url;
          break;
        }
        label131:
        paramWebView = paramWebView.vBd;
        if (paramWebView == null)
        {
          AppMethodBeat.o(294740);
          return null;
        }
        paramWebResourceRequest = paramWebView.vBi;
        if (paramWebResourceRequest == null)
        {
          AppMethodBeat.o(294740);
          return null;
        }
        str2 = this.TAG;
        localObject2 = new StringBuilder("webPrefetch intercepted hitByPrefetchId: ");
        paramWebView = this.WPE;
        if (paramWebView == null) {}
        for (paramWebView = (WebView)localObject1;; paramWebView = Boolean.valueOf(paramWebView.vBg))
        {
          Log.v(str2, paramWebView + ", " + str1 + ", " + paramWebResourceRequest.mMimeType);
          paramWebView = this.WPE;
          kotlin.g.b.s.checkNotNull(paramWebView);
          a(true, paramWebView, 0L);
          AppMethodBeat.o(294740);
          return paramWebResourceRequest;
        }
      }
      try
      {
        paramWebView = getController().getCurrentUrl();
        if (paramWebView != null) {
          break label315;
        }
        AppMethodBeat.o(294740);
        return null;
      }
      catch (Exception paramWebView)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramWebView, "interceptRequest getCurrentUrl host", new Object[0]);
      }
    }
    else
    {
      label307:
      AppMethodBeat.o(294740);
      return null;
    }
    label315:
    String str2 = Uri.parse(paramWebView).getHost();
    if (str2 == null)
    {
      AppMethodBeat.o(294740);
      return null;
    }
    Object localObject2 = iws();
    if (localObject2 == null)
    {
      paramWebView = null;
      if (paramWebView == null)
      {
        AppMethodBeat.o(294740);
        return null;
      }
    }
    else
    {
      paramWebView = this.WPE;
      if (paramWebView == null)
      {
        paramWebView = null;
        label373:
        localObject1 = this.WPE;
        if (localObject1 != null) {
          break label413;
        }
      }
      label413:
      for (localObject1 = null;; localObject1 = ((h.b)localObject1).vBf)
      {
        paramWebView = ((com.tencent.mm.plugin.brandservice.api.h)localObject2).n(str2, str1, paramWebView, (String)localObject1);
        break;
        paramWebView = paramWebView.appId;
        break label373;
      }
    }
    if (!this.WPN)
    {
      this.WPN = true;
      a(false, paramWebView, 1000L);
    }
    localObject1 = paramWebView.vBc;
    if (kotlin.g.b.s.p(localObject1, "JS"))
    {
      getController().WwL.XtC.add(paramWebResourceRequest.getUrl().toString());
      com.tencent.mm.plugin.webview.h.h.iwG();
      com.tencent.mm.plugin.webview.h.h.atX(iws().aiL(getController().dgY()));
    }
    for (;;)
    {
      paramWebView = paramWebView.vBd;
      if (paramWebView != null) {
        break;
      }
      AppMethodBeat.o(294740);
      return null;
      if (kotlin.g.b.s.p(localObject1, "CSS"))
      {
        getController().WwL.XtD.add(paramWebResourceRequest.getUrl().toString());
        com.tencent.mm.plugin.webview.h.h.iwH();
        com.tencent.mm.plugin.webview.h.h.atX(iws().aiL(getController().dgY()));
      }
    }
    paramWebView = paramWebView.vBi;
    AppMethodBeat.o(294740);
    return paramWebView;
  }
  
  public final boolean b(int paramInt, String paramString, cdf paramcdf)
  {
    long l2 = 0L;
    AppMethodBeat.i(294730);
    kotlin.g.b.s.u(paramString, "reqUrl");
    kotlin.g.b.s.u(paramcdf, "resp");
    if (paramcdf.aamK == 38)
    {
      if (bli(paramString))
      {
        paramcdf = paramcdf.aanz;
        if (paramcdf != null) {
          break label197;
        }
        paramcdf = null;
      }
      for (;;)
      {
        try
        {
          cdg localcdg = new cdg();
          localcdg.parseFrom(paramcdf);
          paramcdf = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder("overrideProcessResultL, prefetchVersion: ");
          localb = this.WPE;
          if (localb != null) {
            continue;
          }
          l1 = 0L;
          Log.i(paramcdf, l1 + ", verifyInfo.Version: " + localcdg.aanC);
          paramcdf = this.WPE;
          if (paramcdf != null) {
            continue;
          }
          l1 = l2;
          if (l1 < localcdg.aanC)
          {
            paramcdf = iws();
            if (paramcdf != null) {
              paramcdf.aiM(paramString);
            }
            getController().sMP.loadUrl(localcdg.aanB);
            getController().WwQ = true;
          }
        }
        catch (IOException paramString)
        {
          h.b localb;
          long l1;
          label197:
          Log.printErrStackTrace(this.TAG, (Throwable)paramString, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
          continue;
        }
        AppMethodBeat.o(294730);
        return true;
        paramcdf = w.a(paramcdf);
        continue;
        l1 = localb.vBb;
        continue;
        l1 = paramcdf.vBb;
      }
    }
    if ((this.WPF) && (paramInt == 9)) {
      getController().WwQ = true;
    }
    AppMethodBeat.o(294730);
    return false;
  }
  
  public final int bjc(String paramString)
  {
    AppMethodBeat.i(294718);
    kotlin.g.b.s.u(paramString, "url");
    if (!bli(paramString))
    {
      localObject = this.WPE;
      if (localObject != null) {
        break label49;
      }
    }
    label49:
    for (Object localObject = null; kotlin.g.b.s.p(paramString, localObject); localObject = ((h.b)localObject).url)
    {
      AppMethodBeat.o(294718);
      return 10;
    }
    int i = super.bjc(paramString);
    AppMethodBeat.o(294718);
    return i;
  }
  
  public final boolean bjv(String paramString)
  {
    Object localObject3 = null;
    boolean bool2 = false;
    AppMethodBeat.i(294700);
    kotlin.g.b.s.u(paramString, "url");
    if (!bli(paramString))
    {
      Log.i(this.TAG, "not match " + paramString + ", rawUrl: " + getController().dgY() + ", prefetchResp: " + this.WPE);
      iwu();
      AppMethodBeat.o(294700);
      return false;
    }
    this.WPN = false;
    Object localObject1 = iws();
    Object localObject2;
    label251:
    int i;
    if (localObject1 == null)
    {
      localObject2 = null;
      if ((localObject2 == null) || (((h.b)localObject2).vBd == null)) {
        break label1281;
      }
      getController().Wwj.a(com.tencent.mm.plugin.webview.h.c.WQz);
      localObject1 = com.tencent.mm.plugin.webview.k.s.XtJ;
      com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQD, getController().Wwj);
      Log.i(this.TAG, "url has been cached, bizScene:" + ((h.b)localObject2).mUU + ", subBizScene:" + ((h.b)localObject2).vBa + ", prefetchId: " + iwt() + ", resp.url: %s", new Object[] { ((h.b)localObject2).url });
      localObject4 = (g)d.WPX;
      localObject1 = ((h.b)localObject2).vBe;
      if (localObject1 != null) {
        break label665;
      }
      localObject1 = null;
      this.WPM = new c((g)localObject4, new JsapiPermissionWrapper((byte[])localObject1), getController().sMP);
      localObject1 = this.WPM;
      if (localObject1 == null) {
        break label687;
      }
      localObject1 = ((c)localObject1).WlV;
      if (localObject1 != null) {
        break label675;
      }
      bool1 = false;
      label305:
      if (bool1 != true) {
        break label687;
      }
      i = 1;
      label312:
      if (i != 0) {
        this.WPI = true;
      }
      localObject4 = this.TAG;
      localObject5 = new StringBuilder("initPrefetcherJsApiHandler canInjectPrefetcherJsBridge: ").append(this.WPI).append(", controlBytes size: ");
      localObject1 = ((h.b)localObject2).vBe;
      if (localObject1 != null) {
        break label692;
      }
      localObject1 = null;
      label367:
      Log.i((String)localObject4, localObject1);
      if (!this.WPI) {
        break label1229;
      }
      localObject5 = this.WPM;
      if ((localObject5 != null) && (((c)localObject5).WPU) && (((c)localObject5).WDI != true))
      {
        ((c)localObject5).WDI = true;
        localObject1 = ((c)localObject5).WDz;
        if (localObject1 != null) {
          break label706;
        }
        localObject1 = null;
        label438:
        localObject1 = (CharSequence)localObject1;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label716;
        }
        i = 1;
        label462:
        if (i != 0) {
          break label721;
        }
        localObject1 = ((c)localObject5).WDz;
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject4 = ((MMWebView)localObject1).getRandomStr();
        localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = "";
        }
      }
    }
    for (;;)
    {
      ((c)localObject5).KQY = ((String)localObject1);
      Log.i("MicroMsg.WebPrefetcherJsApiHandler", "setDigestVerify isDigestVerify: " + ((c)localObject5).WDI + ", randomStr: " + ((c)localObject5).KQY + ", hashCode: " + ((c)localObject5).hashCode());
      localObject1 = this.WPM;
      if (localObject1 != null) {
        ((c)localObject1).WDJ = true;
      }
      localObject1 = this.WPM;
      kotlin.g.b.s.checkNotNull(localObject1);
      e.a((c)localObject1, getController().sMP);
      localObject1 = ((h.b)localObject2).vBd.vBi.mInputStream;
      localObject4 = e.iwz();
      localObject5 = kotlin.n.d.UTF_8;
      if (localObject4 != null) {
        break label739;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(294700);
      throw paramString;
      localObject2 = ((com.tencent.mm.plugin.brandservice.api.h)localObject1).fK(paramString, iwt());
      break;
      label665:
      localObject1 = ((b)localObject1).Op;
      break label251;
      label675:
      bool1 = ((JsapiPermissionWrapper)localObject1).sk(434);
      break label305;
      label687:
      i = 0;
      break label312;
      label692:
      localObject1 = Integer.valueOf(((b)localObject1).Op.length);
      break label367;
      label706:
      localObject1 = ((MMWebView)localObject1).getRandomStr();
      break label438;
      label716:
      i = 0;
      break label462;
      label721:
      localObject1 = Util.getRandomString(16);
      kotlin.g.b.s.s(localObject1, "getRandomString(16)");
    }
    label739:
    Object localObject4 = ((String)localObject4).getBytes((Charset)localObject5);
    kotlin.g.b.s.s(localObject4, "(this as java.lang.String).getBytes(charset)");
    localObject4 = new ByteArrayInputStream((byte[])localObject4);
    Object localObject5 = (InputStream)localObject4;
    kotlin.g.b.s.s(localObject1, "originInputStream");
    localObject5 = new com.tencent.mm.pluginsdk.ui.tools.l((InputStream)localObject5, (InputStream)localObject1);
    Log.i(this.TAG, "updatePrefetchResp origin: %s, prefetch: %s, merged: %s", new Object[] { Integer.valueOf(((InputStream)localObject1).available()), Integer.valueOf(((ByteArrayInputStream)localObject4).available()), Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.l)localObject5).available()) });
    ((h.b)localObject2).vBd.vBi.mInputStream = ((InputStream)localObject5);
    localObject1 = ah.aiuX;
    this.WPE = ((h.b)localObject2);
    localObject1 = this.WPE;
    if (localObject1 == null)
    {
      localObject1 = null;
      label883:
      localObject4 = (CharSequence)localObject1;
      if ((localObject4 != null) && (!n.bp((CharSequence)localObject4))) {
        break label1248;
      }
      i = 1;
      label905:
      if (i == 0) {
        getController().sMP.addJavascriptInterface(new b((String)localObject1, this), "wxPrefetcherClient");
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(21075, new Object[] { Integer.valueOf(((h.b)localObject2).mUU), paramString, ((h.b)localObject2).url, Integer.valueOf(4), Integer.valueOf(((h.b)localObject2).vBa) });
      localObject5 = getController();
      localObject4 = ((h.b)localObject2).vBh;
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = "";
      }
      localObject4 = this.WPM;
      if (localObject4 != null) {
        break label1253;
      }
      label1024:
      ((BaseWebViewController)localObject5).a(true, (String)localObject1, (JsapiPermissionWrapper)localObject3);
      localObject1 = getController();
      localObject3 = ((h.b)localObject2).url;
      kotlin.g.b.s.s(localObject3, "resp.url");
      ((BaseWebViewController)localObject1).X((String)localObject3, ((h.b)localObject2).vBd.vBi.mResponseHeaders);
      localObject1 = getController();
      localObject3 = ((h.b)localObject2).url;
      kotlin.g.b.s.s(localObject3, "resp.url");
      BaseWebViewController.a((BaseWebViewController)localObject1, (String)localObject3, false, 10, 2);
      this.WPF = true;
      getController().WwL.WPF = this.WPF;
      getController().WwL.XtE.putAll(((h.b)localObject2).vBd.vBi.mResponseHeaders);
      com.tencent.mm.plugin.webview.h.h.iwF();
      localObject1 = iws();
      if (localObject1 != null) {
        break label1263;
      }
      i = 0;
      label1165:
      com.tencent.mm.plugin.webview.h.h.atX(i);
      this.WPG = true;
      getController().WwL.WPG = this.WPG;
      localObject1 = iws();
      if (localObject1 != null) {
        break label1481;
      }
    }
    label1281:
    label1481:
    for (boolean bool1 = bool2;; bool1 = ((com.tencent.mm.plugin.brandservice.api.h)localObject1).aiK(paramString))
    {
      this.WPH = bool1;
      getController().WwL.WPH = this.WPH;
      AppMethodBeat.o(294700);
      return true;
      label1229:
      this.WPE = ((h.b)localObject2);
      break;
      localObject1 = ((h.b)localObject1).appId;
      break label883;
      label1248:
      i = 0;
      break label905;
      label1253:
      localObject3 = ((c)localObject4).WlV;
      break label1024;
      label1263:
      i = ((com.tencent.mm.plugin.brandservice.api.h)localObject1).aiL(getController().dgY());
      break label1165;
      getController().Wwj.a(com.tencent.mm.plugin.webview.h.c.WQy);
      localObject1 = com.tencent.mm.plugin.webview.k.s.XtJ;
      com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQD, getController().Wwj);
      Log.i(this.TAG, kotlin.g.b.s.X("async geta8key:", paramString));
      localObject2 = iws().aiJ(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = paramString;
      }
      if (((CharSequence)localObject1).length() == 0) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          localObject1 = paramString;
        }
        Log.i(this.TAG, kotlin.g.b.s.X("async geta8key respUrl:", localObject1));
        localObject2 = localObject1;
        if (!com.tencent.luggage.l.c.K((String)localObject1, "http")) {
          localObject2 = kotlin.g.b.s.X("http://", paramString);
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(21075, new Object[] { Integer.valueOf(0), paramString, localObject2, Integer.valueOf(5) });
        getController().sMP.loadUrl((String)localObject2);
        BaseWebViewController.a(getController(), (String)localObject2, false, 10, 2);
        break;
      }
    }
  }
  
  public final boolean bjw(String paramString)
  {
    AppMethodBeat.i(294710);
    kotlin.g.b.s.u(paramString, "url");
    if (!bli(paramString))
    {
      AppMethodBeat.o(294710);
      return true;
    }
    AppMethodBeat.o(294710);
    return false;
  }
  
  public final m.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(294671);
    kotlin.g.b.s.u(paramWebView, "webView");
    kotlin.g.b.s.u(paramWebResourceRequest, "request");
    BaseWebViewController localBaseWebViewController = getController();
    if ((localBaseWebViewController != null) && (paramWebResourceRequest.isForMainFrame()) && (paramWebResourceRequest.getUrl() != null) && (localBaseWebViewController.irY()))
    {
      Log.i(this.TAG, "shouldOverride url exitTmpl %s", new Object[] { paramWebResourceRequest.getUrl() });
      iwu();
    }
    paramWebView = super.c(paramWebView, paramWebResourceRequest);
    AppMethodBeat.o(294671);
    return paramWebView;
  }
  
  public final com.tencent.mm.plugin.webview.core.l cxU()
  {
    return this.sMB;
  }
  
  public final boolean f(String paramString, Intent paramIntent)
  {
    long l = 0L;
    AppMethodBeat.i(294663);
    kotlin.g.b.s.u(paramString, "url");
    paramString = getController().WwL;
    if (paramIntent == null) {}
    for (;;)
    {
      paramString.XtF = l;
      AppMethodBeat.o(294663);
      return false;
      l = paramIntent.getLongExtra("startTime", 0L);
    }
  }
  
  public final com.tencent.mm.plugin.webview.core.h isN()
  {
    return this.Wzy;
  }
  
  final com.tencent.mm.plugin.brandservice.api.h iws()
  {
    AppMethodBeat.i(294652);
    com.tencent.mm.plugin.brandservice.api.h localh = (com.tencent.mm.plugin.brandservice.api.h)this.WPJ.getValue();
    AppMethodBeat.o(294652);
    return localh;
  }
  
  final void iwu()
  {
    AppMethodBeat.i(294706);
    Log.i(this.TAG, "resetPrefetchInfo");
    this.WPE = null;
    this.WPF = false;
    this.WPG = false;
    this.WPH = false;
    this.WPI = false;
    c localc = this.WPM;
    if (localc != null) {
      localc.destroy();
    }
    this.WPM = null;
    AppMethodBeat.o(294706);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.brandservice.api.h>
  {
    public static final a WPO;
    
    static
    {
      AppMethodBeat.i(294602);
      WPO = new a();
      AppMethodBeat.o(294602);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$attachPrefetchJsApi$1", "", "forceH5", "", "newUrl", "", "getLocalData", "key", "setLocalData", "data", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    b(String paramString, a parama) {}
    
    @JavascriptInterface
    public final void forceH5(String paramString)
    {
      AppMethodBeat.i(294622);
      jdField_this.iwu();
      jdField_this.getController().WwQ = true;
      jdField_this.getController().irY();
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
      for (int i = 1; i != 0; i = 0)
      {
        jdField_this.getController().reload();
        AppMethodBeat.o(294622);
        return;
      }
      jdField_this.getController().bjh(paramString);
      AppMethodBeat.o(294622);
    }
    
    @JavascriptInterface
    public final String getLocalData(String paramString)
    {
      AppMethodBeat.i(294615);
      kotlin.g.b.s.u(paramString, "key");
      try
      {
        Object localObject = com.tencent.mm.plugin.az.c.WmU;
        localObject = com.tencent.mm.plugin.az.c.ipk().decodeString(this.eug + '-' + paramString, "");
        Log.d(jdField_this.TAG, "getLocalData:" + paramString + ", " + localObject);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(jdField_this.TAG, (Throwable)localException, kotlin.g.b.s.X("getLocalData:", paramString), new Object[0]);
          paramString = null;
        }
      }
      AppMethodBeat.o(294615);
      return paramString;
    }
    
    @JavascriptInterface
    public final void setLocalData(String paramString1, String paramString2)
    {
      AppMethodBeat.i(294605);
      kotlin.g.b.s.u(paramString1, "key");
      kotlin.g.b.s.u(paramString2, "data");
      try
      {
        c.a locala = com.tencent.mm.plugin.az.c.WmU;
        ((MultiProcessMMKV)com.tencent.mm.plugin.az.c.ipk().getSlotForWrite()).encode(this.eug + '-' + paramString1, paramString2);
        Log.d(jdField_this.TAG, "setLocalData:" + paramString1 + ", " + paramString2);
        AppMethodBeat.o(294605);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace(jdField_this.TAG, (Throwable)localException, "setLocalData:" + paramString1 + ", " + paramString2, new Object[0]);
        AppMethodBeat.o(294605);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageFinished", "onPageStarted", "writePrefetchInfo", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.plugin.webview.core.h
  {
    c(a parama) {}
    
    private static final void a(a parama, String paramString)
    {
      AppMethodBeat.i(294616);
      kotlin.g.b.s.u(parama, "this$0");
      Log.v(parama.TAG, kotlin.g.b.s.X("write performance:", paramString));
      AppMethodBeat.o(294616);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(294658);
      super.b(paramWebView, paramString);
      Log.i(this.WPP.TAG, "onPageFinished, url = %s", new Object[] { paramString });
      paramWebView = com.tencent.mm.plugin.webview.k.s.XtJ;
      com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQG, this.WPP.getController().Wwj);
      AppMethodBeat.o(294658);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      Integer localInteger2 = null;
      AppMethodBeat.i(294653);
      Log.i(this.WPP.TAG, "onPageCommitVisible, url = %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h localh;
      Integer localInteger1;
      label195:
      Object localObject;
      if (!this.WPP.WPL)
      {
        this.WPP.getController().sMP.evaluateJavascript(n.bJB("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + this.WPP.getController().WwL.XtF + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + this.WPP.WPG + ",\n                    prefetch:" + this.WPP.WPF + ",\n                    predns:" + this.WPP.WPH + "\n                })\n                return p.wx.info;\n            })(window.performance);"), new a.c..ExternalSyntheticLambda0(this.WPP));
        this.WPP.WPL = true;
        if (this.WPP.WPE != null)
        {
          localh = com.tencent.mm.plugin.report.service.h.OAn;
          paramWebView = this.WPP.WPE;
          if (paramWebView != null) {
            break label289;
          }
          localInteger1 = null;
          paramWebView = this.WPP.WPE;
          if (paramWebView != null) {
            break label300;
          }
          paramWebView = "";
          localObject = this.WPP.WPE;
          if (localObject != null) {
            break label320;
          }
        }
      }
      for (;;)
      {
        localh.b(21075, new Object[] { localInteger1, paramString, paramWebView, Integer.valueOf(6), localInteger2 });
        paramWebView = com.tencent.mm.plugin.webview.k.s.XtJ;
        com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQF, this.WPP.getController().Wwj);
        paramWebView = this.WPP.WPM;
        if (paramWebView != null) {
          paramWebView.WDJ = false;
        }
        AppMethodBeat.o(294653);
        return;
        label289:
        localInteger1 = Integer.valueOf(paramWebView.mUU);
        break;
        label300:
        localObject = paramWebView.url;
        paramWebView = (WebView)localObject;
        if (localObject != null) {
          break label195;
        }
        paramWebView = "";
        break label195;
        label320:
        localInteger2 = Integer.valueOf(((h.b)localObject).vBa);
      }
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(294636);
      super.h(paramWebView, paramString);
      Log.i(this.WPP.TAG, "onPageStarted, prefetch: " + this.WPP.WPF + ", url = %s", new Object[] { paramString });
      paramWebView = com.tencent.mm.plugin.webview.k.s.XtJ;
      com.tencent.mm.plugin.webview.k.s.a(com.tencent.mm.plugin.webview.h.d.WQE, this.WPP.getController().Wwj);
      if (this.WPP.WPF)
      {
        paramString = this.WPP.WPM;
        if (paramString != null)
        {
          Log.i("MicroMsg.WebPrefetcherJsApiHandler", kotlin.g.b.s.X("updateRandomStr isDgtVerify: ", Boolean.valueOf(paramString.WDI)));
          if ((paramString.WPV) && (paramString.WDI))
          {
            paramWebView = new JSONObject();
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("__event_id", "sys:updateRandomStr");
              localJSONObject.put("randomStr", paramString.KQY);
              paramWebView.put("__json_message", localJSONObject);
              paramString = paramString.WDz;
              kotlin.g.b.s.checkNotNull(paramString);
              paramString.evaluateJavascript("javascript:WeixinPrefecherJSBridge._handleMessageFromWeixin(" + paramWebView + ')', (ValueCallback)new c.d());
              AppMethodBeat.o(294636);
              return;
            }
            catch (JSONException paramWebView)
            {
              Log.printErrStackTrace("MicroMsg.WebPrefetcherJsApiHandler", (Throwable)paramWebView, "updateRandomStr exception", new Object[0]);
            }
          }
        }
      }
      AppMethodBeat.o(294636);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "reason", "", "reqUrl", "", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.webview.core.l
  {
    d(a parama) {}
    
    public final void a(int paramInt, String paramString, cdf paramcdf)
    {
      AppMethodBeat.i(294633);
      kotlin.g.b.s.u(paramString, "reqUrl");
      kotlin.g.b.s.u(paramcdf, "response");
      super.a(paramInt, paramString, paramcdf);
      String str = paramcdf.aanm;
      paramcdf = str;
      if (str == null) {
        paramcdf = "";
      }
      Log.v(this.WPP.TAG, "onPermissionUpdate reason: " + paramInt + ", prefetch: " + this.WPP.WPF + ", reqUrl: %s, fullUrl: %s", new Object[] { paramString, paramcdf });
      AppMethodBeat.o(294633);
    }
    
    public final void a(r paramr)
    {
      AppMethodBeat.i(294614);
      kotlin.g.b.s.u(paramr, "performanceHelper");
      Object localObject = this.WPP;
      String str = ((a)localObject).getController().Www;
      localObject = ((a)localObject).WPE;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((h.b)localObject).url)
      {
        paramr.WPF = kotlin.g.b.s.p(str, localObject);
        AppMethodBeat.o(294614);
        return;
      }
    }
    
    public final void b(r paramr)
    {
      AppMethodBeat.i(294625);
      kotlin.g.b.s.u(paramr, "performanceHelper");
      com.tencent.mm.plugin.brandservice.api.h localh = this.WPP.iws();
      BaseWebViewController localBaseWebViewController = this.controller;
      if (localBaseWebViewController != null) {}
      for (;;)
      {
        com.tencent.mm.plugin.webview.h.h.a(paramr, localh.aiL(localBaseWebViewController.dgY()));
        AppMethodBeat.o(294625);
        return;
        kotlin.g.b.s.bIx("controller");
        localBaseWebViewController = null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<String>
  {
    e(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.a
 * JD-Core Version:    0.7.0.1
 */