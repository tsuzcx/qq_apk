package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.ui;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.an.a;
import com.tencent.mm.plugin.webview.model.an.d;
import com.tencent.mm.plugin.webview.model.an.f;
import com.tencent.mm.plugin.webview.model.an.g;
import com.tencent.mm.plugin.webview.model.an.m;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class WebViewUI$i
  extends p
{
  public WebViewUI$i(WebViewUI paramWebViewUI) {}
  
  private m TA(String paramString)
  {
    String str = this.rpH.cdR();
    Object localObject = WebViewUI.m(this.rpH);
    if (!WebViewUI.aP(this.rpH)) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = ((ak)localObject).a(paramString, bool, this.rpH.gGn);
      if (localObject == null) {
        break;
      }
      if ((paramString.equals(str)) || (WebViewUI.a(this.rpH, str, paramString))) {
        WebViewUI.a(this.rpH).post(new Runnable()
        {
          public final void run()
          {
            if (WebViewUI.i.this.rpH.niQ != null) {
              WebViewUI.i.this.rpH.niQ.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
            }
            WebViewUI localWebViewUI = WebViewUI.i.this.rpH;
            WebViewUI.71 local71 = new WebViewUI.71(localWebViewUI);
            if (Thread.currentThread().getId() == localWebViewUI.handler.getLooper().getThread().getId())
            {
              local71.run();
              return;
            }
            localWebViewUI.handler.post(local71);
          }
        });
      }
      return localObject;
    }
    return null;
  }
  
  private boolean Tz(String paramString)
  {
    if (!WebViewUI.g(this.rpH, paramString))
    {
      y.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + paramString);
      WebViewUI.P(this.rpH);
      return true;
    }
    return false;
  }
  
  public boolean SZ(String paramString)
  {
    y.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
    if ((paramString.startsWith("weixinping://iframe")) || (paramString.startsWith("weixinpreinject://iframe"))) {
      return true;
    }
    if (WebViewUI.m(this.rpH, paramString))
    {
      y.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = " + paramString);
      return true;
    }
    WebViewUI.n(this.rpH, paramString);
    return false;
  }
  
  public m a(WebView paramWebView, com.tencent.xweb.l paraml)
  {
    if ((paraml == null) || (paraml.getUrl() == null) || (bk.bl(paraml.getUrl().toString()))) {
      return super.a(paramWebView, paraml);
    }
    y.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paraml.getUrl(), paraml.getMethod(), Boolean.valueOf(paraml.isForMainFrame()) });
    if (Tz(paraml.getUrl().toString())) {
      return null;
    }
    return TA(paraml.getUrl().toString());
  }
  
  public m a(WebView paramWebView, com.tencent.xweb.l paraml, Bundle paramBundle)
  {
    if ((paraml == null) || (paraml.getUrl() == null) || (bk.bl(paraml.getUrl().toString()))) {
      return super.a(paramWebView, paraml);
    }
    y.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paraml.getUrl(), paraml.getMethod(), Boolean.valueOf(paraml.isForMainFrame()) });
    if (Tz(paraml.getUrl().toString())) {
      return null;
    }
    if (com.tencent.mm.cl.b.ho(this.rpH)) {}
    try
    {
      int i = paramBundle.getInt("resourceType");
      if (((i == 1) || (i == 7)) && (!WebViewUI.aO(this.rpH)))
      {
        y.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        WebViewUI.a(this.rpH, paraml.getUrl().toString(), false, 5);
      }
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        y.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", new Object[] { paramWebView.getMessage() });
      }
    }
    catch (Throwable paramWebView)
    {
      for (;;)
      {
        y.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", new Object[] { paramWebView.getMessage() });
      }
    }
    return TA(paraml.getUrl().toString());
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    y.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1, Boolean.valueOf(aq.isConnected(this.rpH)) });
    com.tencent.mm.plugin.report.service.h.nFQ.a(155L, 1L, 1L, false);
    com.tencent.mm.plugin.report.service.h.nFQ.a(155L, a.Cr(paramInt), 1L, false);
    com.tencent.mm.plugin.topstory.a.h.cB(this.rpH.bYM, 1);
    com.tencent.mm.plugin.topstory.a.h.cB(this.rpH.bYM, a.Cr(paramInt));
    com.tencent.mm.plugin.topstory.a.h.b(this.rpH.bYM, this.rpH.caS, a.Cr(paramInt), this.rpH.rfg.cci().diQ);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    h.rnm.CD(paramInt);
    if (WebViewUI.aN(this.rpH)) {
      this.rpH.finish();
    }
  }
  
  @TargetApi(8)
  public final void a(WebView paramWebView, com.tencent.xweb.h paramh, SslError paramSslError)
  {
    if (paramWebView.getUrl() == null) {}
    b localb;
    for (paramWebView = WebViewUI.am(this.rpH);; paramWebView = paramWebView.getUrl())
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(155L, 1L, 1L, false);
      com.tencent.mm.plugin.report.service.h.nFQ.a(155L, 30L, 1L, false);
      com.tencent.mm.plugin.topstory.a.h.cB(this.rpH.bYM, 1);
      com.tencent.mm.plugin.topstory.a.h.cB(this.rpH.bYM, 30);
      com.tencent.mm.plugin.topstory.a.h.b(this.rpH.bYM, this.rpH.caS, 30, this.rpH.rfg.cci().diQ);
      if (WebViewUI.aM(this.rpH) == null) {
        WebViewUI.a(this.rpH, new b(this.rpH, this.rpH.niQ));
      }
      localb = WebViewUI.aM(this.rpH);
      y.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", new Object[] { paramWebView });
      if (localb.rlh != null) {
        break;
      }
      y.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
      return;
    }
    if (bk.bl(paramWebView))
    {
      paramh.cancel();
      return;
    }
    URL localURL;
    try
    {
      localURL = new URL(paramWebView);
      if ((!localURL.getHost().endsWith(".qq.com")) && (!localURL.getHost().endsWith(".linkedin.com"))) {
        break label555;
      }
      localObject = (Boolean)localb.rlj.get(paramWebView);
      if (localObject == null) {
        break label325;
      }
      y.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", new Object[] { localObject });
      if (((Boolean)localObject).booleanValue())
      {
        paramh.proceed();
        return;
      }
    }
    catch (Exception paramWebView)
    {
      y.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + paramWebView.getLocalizedMessage());
      return;
    }
    paramh.cancel();
    return;
    label325:
    Object localObject = (List)localb.rli.get(paramWebView);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1");
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(localb.a(paramWebView, paramSslError));
      paramSslError = ((StringBuilder)localObject).toString();
      y.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", new Object[] { paramSslError });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(11098, paramSslError);
      paramSslError = new ArrayList();
      paramSslError.add(paramh);
      localb.rli.put(paramWebView, paramSslError);
      com.tencent.mm.ui.base.h.a(localb.context, false, localb.context.getString(R.l.wv_alert_certificate_err, new Object[] { localURL.getHost() }), localb.context.getString(R.l.wv_alert_certificate_err_title), localb.context.getString(R.l.app_continue), localb.context.getString(R.l.app_back), new b.1(localb, paramWebView), new b.2(localb, paramWebView));
      return;
    }
    ((List)localObject).add(paramh);
    return;
    label555:
    y.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + localURL.getHost() + ", but it not end with '.qq.com' or '.linkedin.com'");
    paramh.cancel();
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    WebViewUI.aH(this.rpH);
    com.tencent.mm.plugin.webview.model.a.a(this.rpH.niQ, this.rpH.gGn);
    this.rpH.rbN.TD(paramString);
    if (!WebViewUI.aI(this.rpH))
    {
      WebViewUI.aJ(this.rpH);
      this.rpH.rfg.cck().loadFinished = true;
    }
    y.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", new Object[] { paramString });
    Object localObject1 = this.rpH.rfg.ccp();
    if ((!((an.d)localObject1).keZ) || (((an.d)localObject1).rgC)) {}
    Object localObject3;
    for (;;)
    {
      localObject1 = h.rnm;
      y.v("MicroMsg.WebViewReportUtil", "onPageFinished traceid %s", new Object[] { ((h)localObject1).oAk });
      if (!bk.bl(((h)localObject1).oAk)) {
        ((h)localObject1).jdMethod_if(2);
      }
      if (this.rpH.niQ != null) {
        break;
      }
      y.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
      return;
      try
      {
        localObject3 = Uri.parse(paramString);
        if (paramString.startsWith("http")) {
          break label232;
        }
        y.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[] { paramString });
      }
      continue;
      label232:
      localObject3 = ((Uri)localObject3).getHost();
      if ((localObject3 != null) && (((String)localObject3).equalsIgnoreCase("v.html5.qq.com")))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(283L, 0L, 1L, true);
        localException.rgC = true;
        y.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[] { paramString });
      }
    }
    WebViewUI.t(this.rpH).qh(paramString);
    Object localObject2 = this.rpH.niQ.getTitle();
    y.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[] { this.rpH.mController.getMMTitle(), localObject2, Boolean.valueOf(this.rpH.rnr), Boolean.valueOf(WebViewUI.q(this.rpH)), WebViewUI.am(this.rpH) });
    if ((this.rpH.niQ.getIsX5Kernel()) && (!bk.bl((String)localObject2)) && (((String)localObject2).length() > 0) && (!((String)localObject2).equals(this.rpH.mController.getMMTitle())) && (!((String)localObject2).startsWith("http")) && ((WebViewUI.am(this.rpH) == null) || (!WebViewUI.am(this.rpH).equals(localObject2))) && (!this.rpH.rnr) && (WebViewUI.q(this.rpH)))
    {
      y.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
      this.rpH.setMMTitle((String)localObject2);
    }
    WebViewUI.n(this.rpH).setCurrentURL(this.rpH.cdR());
    boolean bool = this.rpH.getIntent().getBooleanExtra("shouldForceViewPort", false);
    y.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: " + bool);
    if (bool) {
      paramWebView.evaluateJavascript(this.rpH.getIntent().getStringExtra("view_port_code"), null);
    }
    WebViewUI.aK(this.rpH);
    if (!WebViewUI.g(this.rpH, paramString))
    {
      y.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = " + paramString);
      WebViewUI.P(this.rpH);
      return;
    }
    this.rpH.setProgressBarIndeterminateVisibility(false);
    this.rpH.rns.finish();
    WebViewUI.o(this.rpH, "");
    if (paramString.equals("file:///android_asset/jsapi/wxjs.js"))
    {
      y.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
      return;
    }
    y.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + WebViewUI.aL(this.rpH));
    this.rpH.ror.ryh = this.rpH.getIntent().getBooleanExtra("inject_city_service_js", false);
    this.rpH.ror.ryi = this.rpH.getIntent().getStringExtra("city_service_ext_info");
    this.rpH.ror.cfQ();
    if ((this.rpH.gGo != null) && (this.rpH.gGo.RP(paramString) != null)) {
      WebViewUI.a(this.rpH, this.rpH.gGo.RP(paramString).hi(34), this.rpH.gGo.RP(paramString).hi(75));
    }
    WebViewUI.a(this.rpH, WebViewUI.ceG());
    paramWebView = this.rpH.rfg.ccf();
    label862:
    label889:
    int i;
    long l1;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
      paramWebView = this.rpH.rfg.ccg();
      if (!bk.bl(paramString)) {
        break label1224;
      }
      y.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
      localObject2 = this.rpH.rfg.ccj();
      localObject3 = this.rpH.gGn;
      if ((localObject3 != null) && (!((an.g)localObject2).bCk))
      {
        ((an.g)localObject2).bCk = true;
        i = an.ccb();
        l1 = bk.UY() - ((an.g)localObject2).startTime;
        if ((l1 >= 0L) && (l1 <= 180000L)) {
          break label1276;
        }
      }
      if (!WebViewUI.e(this.rpH).containsKey(paramString)) {
        WebViewUI.e(this.rpH).put(paramString, Boolean.valueOf(this.rpH.czm()));
      }
      this.rpH.lj(((Boolean)WebViewUI.e(this.rpH).get(paramString)).booleanValue());
      paramWebView = (Boolean)WebViewUI.r(this.rpH).get(paramString);
      if ((paramWebView != null) && (paramWebView.booleanValue())) {
        break label1494;
      }
      this.rpH.showOptionMenu(0, true);
    }
    for (;;)
    {
      if ((WebViewUI.al(this.rpH)) && (bk.bl(WebViewUI.an(this.rpH)))) {
        WebViewUI.r(this.rpH, WebViewUI.am(this.rpH));
      }
      WebViewUI.b(this.rpH, bk.UX());
      com.tencent.mm.sdk.b.a.udP.m(new ui());
      if ((WebViewUI.aG(this.rpH) == null) || (WebViewUI.aG(this.rpH).rqY)) {
        break;
      }
      paramWebView = WebViewUI.aG(this.rpH);
      y.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageFinished, url:%s", new Object[] { paramString });
      paramWebView.gZO = paramString;
      return;
      if (!paramWebView.rgT.containsKey(paramString)) {
        break label862;
      }
      l1 = ((Long)paramWebView.rgT.get(paramString)).longValue();
      long l2 = bk.UY();
      paramWebView.rgT.put(paramString, Long.valueOf(l2 - l1));
      break label862;
      label1224:
      if (!paramWebView.rgF.containsKey(paramString)) {
        break label889;
      }
      l1 = ((Long)paramWebView.rgF.get(paramString)).longValue();
      l2 = bk.UY();
      paramWebView.rgF.put(paramString, Long.valueOf(l2 - l1));
      break label889;
      label1276:
      String str = ((an.g)localObject2).rgH;
      if (((an.g)localObject2).url == null) {}
      for (paramWebView = ((an.g)localObject2).url;; paramWebView = ((an.g)localObject2).url.replace(",", "!"))
      {
        an.a((com.tencent.mm.plugin.webview.stub.d)localObject3, str, new Object[] { Integer.valueOf(4), Long.valueOf(l1), Integer.valueOf(i), paramWebView, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(((an.g)localObject2).cfb), ((an.g)localObject2).rgH });
        y.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[] { ((an.g)localObject2).url, Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(an.access$000()), Integer.valueOf(an.access$100()), Integer.valueOf(((an.g)localObject2).cfb), ((an.g)localObject2).rgH });
        break;
      }
      label1494:
      this.rpH.showOptionMenu(0, false);
    }
  }
  
  public void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    super.a(paramWebView, paramString, paramBoolean);
    if (com.tencent.mm.pluginsdk.ui.tools.s.n(paramString, "about:blank"))
    {
      y.e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
      return;
    }
    paramWebView = paramWebView.getUrl();
    if (WebViewUI.aC(this.rpH)) {
      this.rpH.bo(paramWebView, false);
    }
    if ((this.rpH.gGo != null) && (!this.rpH.gGo.has(paramWebView)))
    {
      y.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { paramWebView });
      this.rpH.bo(paramWebView, false);
      this.rpH.O(true, false);
      WebViewUI.e(this.rpH, true);
    }
    WebViewUI.n(this.rpH).cdL();
    WebViewUI.n(this.rpH, paramString);
    this.rpH.rbN.TD(paramString);
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.b(paramWebView, paramString, paramBitmap);
    WebViewUI.p(this.rpH, paramString);
    y.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = " + paramString);
    com.tencent.mm.plugin.report.service.h.nFQ.a(155L, 0L, 1L, false);
    com.tencent.mm.plugin.topstory.a.h.cB(this.rpH.bYM, 0);
    if (this.rpH.cef())
    {
      if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(paramWebView.getUrl()))) {
        break label382;
      }
      y.i("MicroMsg.WebViewUI", "onPageStarted call with same url when preload");
      this.rpH.ceg();
      if (this.rpH.ror != null) {
        this.rpH.ror.rvc = false;
      }
      this.rpH.ceB();
    }
    for (;;)
    {
      if ((com.tencent.mm.sdk.a.b.cqk()) && ("http://www.dktest-mmcrash.com/".equals(paramString))) {
        Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
      }
      WebViewUI.q(this.rpH, WebViewUI.am(this.rpH));
      long l = bk.UX();
      this.rpH.i(paramString, l, 1);
      this.rpH.rfg.cch().rgP = WebViewUI.i(this.rpH);
      WebViewUI.n(this.rpH, paramString);
      paramWebView = h.rnm;
      y.v("MicroMsg.WebViewReportUtil", "onPageStarted url %s, currUrl %s, traceid %s", new Object[] { paramString, paramWebView.rnn, paramWebView.oAk });
      paramBitmap = paramWebView.rnn;
      paramWebView.rnn = paramString;
      if (!bk.bl(paramWebView.oAk)) {
        paramWebView.f(1, paramBitmap, 0);
      }
      y.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", new Object[] { WebViewUI.i(this.rpH), WebViewUI.am(this.rpH) });
      if (WebViewUI.g(this.rpH, paramString)) {
        break;
      }
      y.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = " + paramString);
      WebViewUI.P(this.rpH);
      return;
      label382:
      y.v("MicroMsg.WebViewUI", "onPageStarted call when preload url %s, webview.url %s", new Object[] { paramString, paramWebView.getUrl() });
    }
    WebViewUI.n(this.rpH).cdL();
    WebViewUI.n(this.rpH).setCurrentURL(paramString);
    if (this.rpH.Tq(paramString))
    {
      WebViewUI.o(this.rpH, paramString);
      return;
    }
    this.rpH.ror.cfP();
    this.rpH.setProgressBarIndeterminateVisibility(false);
    if (!this.rpH.Tl(paramString))
    {
      WebViewUI.f(this.rpH, false);
      if (!this.rpH.roN) {
        this.rpH.rns.start();
      }
      label508:
      this.rpH.Tn(paramString);
      paramWebView = this.rpH.bo(paramString, false);
      if (WebViewUI.x.rqU.equals(paramWebView)) {
        WebViewUI.t(this.rpH).qh(paramString);
      }
      this.rpH.O(true, false);
      WebViewUI.e(this.rpH, false);
      paramWebView = this.rpH.rfg.ccf();
      int i = WebViewUI.d(this.rpH);
      paramBitmap = this.rpH.bYM;
      paramWebView.cfb = i;
      paramWebView.rgH = paramBitmap;
      if (!bk.bl(paramString)) {
        break label774;
      }
      y.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
    }
    for (;;)
    {
      WebViewUI.aF(this.rpH);
      if ((WebViewUI.aG(this.rpH) == null) || (WebViewUI.aG(this.rpH).rqY)) {
        break;
      }
      paramWebView = WebViewUI.aG(this.rpH);
      y.i("MicroMsg.WebViewUIStyleHelper", "onWebViewPageStart, url:%s", new Object[] { paramString });
      paramWebView.gZO = paramString;
      paramWebView.ceO();
      return;
      WebViewUI.f(this.rpH, true);
      this.rpH.rns.finish();
      this.rpH.niQ.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
      if (this.rpH.rbk == null) {
        break label508;
      }
      this.rpH.rbk.s((String)WebViewUI.aD(this.rpH).get(paramString), (Map)WebViewUI.aE(this.rpH).get(paramString));
      break label508;
      label774:
      if (!paramWebView.rgT.containsKey(paramString)) {
        paramWebView.rgT.put(paramString, Long.valueOf(bk.UY()));
      }
    }
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = " + paramString);
    if (!WebViewUI.g(this.rpH, paramString))
    {
      y.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + paramString);
      WebViewUI.P(this.rpH);
    }
    label376:
    do
    {
      for (;;)
      {
        return true;
        if (com.tencent.mm.pluginsdk.ui.tools.s.n(paramString, "about:blank"))
        {
          y.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
          return true;
        }
        try
        {
          if ((paramString.startsWith("weixin://jump/")) || (paramString.startsWith("weixin://scanqrcode/")))
          {
            this.rpH.Tp(paramString);
            return true;
          }
        }
        catch (Exception paramWebView)
        {
          y.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + paramWebView.getMessage());
          if (this.rpH.gGo == null)
          {
            y.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
            return true;
            if ((paramString.startsWith("weixin://dl/business")) && (com.tencent.mm.pluginsdk.d.j(Uri.parse(paramString))))
            {
              paramWebView = Uri.parse(this.rpH.caS).getHost();
              Intent localIntent = new Intent("android.intent.action.VIEW");
              localIntent.addCategory("android.intent.category.BROWSABLE");
              localIntent.setData(Uri.parse(paramString + "&domain=" + paramWebView));
              i = this.rpH.getIntent().getIntExtra("pay_channel", -1);
              if (i != -1)
              {
                y.i("MicroMsg.WebViewUI", "%s do deeplink, bypass pay channel: %s", new Object[] { paramString, Integer.valueOf(i) });
                localIntent.putExtra("pay_channel", i);
              }
              localIntent.putExtra("translate_link_scene", 13);
              this.rpH.startActivity(localIntent);
              return true;
            }
            if ((!paramString.startsWith("weixinpreinject://iframe")) || (this.rpH.ror == null)) {
              break label376;
            }
            y.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
          }
          for (;;)
          {
            if (paramString.equals(WebViewUI.aB(this.rpH)))
            {
              WebViewUI.o(this.rpH, "");
              return true;
              if ((paramString.startsWith("weixin://dl/login/common_view")) || (paramString.startsWith("weixin://dl/login/phone_view")))
              {
                if (((this.rpH.caS.startsWith("https://support.weixin.qq.com/security")) || (paramString.startsWith("https://support.wechat.com/security"))) && (WebViewUI.aA(this.rpH)))
                {
                  com.tencent.mm.pluginsdk.d.bf(this.rpH.mController.uMN, paramString);
                  this.rpH.finish();
                  return true;
                }
              }
              else
              {
                if (paramString.startsWith("weixin://webview/initReady/")) {
                  break;
                }
                boolean bool = paramString.startsWith("weixin://webview/preInjectJSBridge/");
                if (bool) {
                  return true;
                }
              }
            }
          }
        }
      }
    } while (this.rpH.Tq(paramString));
    if (paramString.startsWith("weixin://"))
    {
      y.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
      return true;
    }
    int i = this.rpH.roh.TB(paramString);
    if ((i == 0) || (i == 2) || ((i == 8) && (!WebViewUI.aC(this.rpH))))
    {
      y.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + i);
      if (this.rpH.Tl(paramString))
      {
        this.rpH.niQ.stopLoading();
        this.rpH.niQ.post(new WebViewUI.i.1(this, paramString));
      }
      while (paramString.equals(WebViewUI.F(this.rpH)))
      {
        y.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
        return SZ(paramString);
        this.rpH.niQ.stopLoading();
      }
      WebViewUI.a(this.rpH, paramString, true, i);
      return true;
    }
    return SZ(paramString);
  }
  
  public m c(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", new Object[] { paramString });
    if (Tz(paramString)) {
      return null;
    }
    return TA(paramString);
  }
  
  public final void f(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = " + paramString);
    if (!WebViewUI.g(this.rpH, paramString))
    {
      y.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = " + paramString);
      super.f(paramWebView, paramString);
      WebViewUI.P(this.rpH);
      return;
    }
    an.f localf = this.rpH.rfg.ccg();
    if (bk.bl(paramString)) {
      y.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
    }
    for (;;)
    {
      super.f(paramWebView, paramString);
      return;
      if ((!bk.bl(localf.gZO)) && (!paramString.equals(localf.gZO)) && (localf.rgG))
      {
        if (localf.rgE.containsKey(localf.gZO))
        {
          long l1 = ((Long)localf.rgE.get(localf.gZO)).longValue();
          long l2 = bk.UY();
          localf.rgE.put(localf.gZO, Long.valueOf(l2 - l1));
        }
        localf.rgG = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i
 * JD-Core Version:    0.7.0.1
 */