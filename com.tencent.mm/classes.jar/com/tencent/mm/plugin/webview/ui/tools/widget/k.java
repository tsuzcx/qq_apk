package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.plugin.webview.a;
import com.tencent.mm.plugin.webview.model.ae;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k
  extends com.tencent.xweb.p
{
  public MMWebView dYF;
  protected Activity fyk;
  public String kMT;
  ah mHandler;
  final Bundle rCd;
  public boolean rCe = false;
  private String rCf = "";
  private Set<String> rCg = new HashSet();
  protected k.b rCh = new k.b(this);
  public k.a rCi = new k.a(null);
  private ak rCj = new ak();
  public String rCk = null;
  public String rCl = null;
  private String rCm = null;
  private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> rCn = new ArrayList();
  private final Map<String, String> rCo = new HashMap();
  public boolean rCp = false;
  public boolean rCq = false;
  private boolean rCr = false;
  public Map<String, String> rCs;
  public k.c rCt = new k.c(this);
  public m rCu = new k.5(this);
  private final Map<String, Map<String, String>> roP = new ConcurrentHashMap();
  public com.tencent.mm.plugin.webview.stub.d rsT;
  com.tencent.mm.plugin.webview.ui.tools.jsapi.d rvZ = null;
  private com.tencent.mm.plugin.webview.ui.tools.jsapi.f rwc = null;
  public com.tencent.mm.plugin.webview.ui.tools.f rxH;
  
  public k(MMWebView paramMMWebView)
  {
    this(paramMMWebView, (byte)0);
  }
  
  public k(MMWebView paramMMWebView, byte paramByte)
  {
    this(paramMMWebView, false, null);
  }
  
  public k(MMWebView paramMMWebView, boolean paramBoolean, Bundle paramBundle)
  {
    this.fyk = ((Activity)paramMMWebView.getContext());
    this.dYF = paramMMWebView;
    this.mHandler = new ah();
    this.rxH = new com.tencent.mm.plugin.webview.ui.tools.f((JsapiPermissionWrapper)this.fyk.getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)this.fyk.getIntent().getParcelableExtra("hardcode_general_ctrl"), new k.1(this));
    this.rCe = paramBoolean;
    this.rCd = paramBundle;
  }
  
  private void a(String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    if (!bk.bl(paramString2))
    {
      this.rxH.a(paramString2, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.rCg.remove(paramString2);
      this.rCq = false;
      this.kMT = paramString2;
    }
    if (fB(paramString1, paramString2))
    {
      this.rxH.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.rCg.remove(paramString1);
    }
    while ((this.rsT == null) || (bk.bl(paramString1)) || (!Tl(paramString2))) {
      return;
    }
    this.rxH.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
    this.rCg.remove(paramString1);
  }
  
  private boolean ah(Bundle paramBundle)
  {
    y.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    int j = paramBundle.getInt("geta8key_result_action_code");
    String str1 = paramBundle.getString("geta8key_result_title");
    String str2 = paramBundle.getString("geta8key_result_full_url");
    String str3 = paramBundle.getString("geta8key_result_content");
    y.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + j + ", title = " + str1 + ", fullUrl = " + str2 + ", content = " + str3);
    String[] arrayOfString = paramBundle.getStringArray("geta8key_result_http_header_key_list");
    paramBundle = paramBundle.getStringArray("geta8key_result_http_header_value_list");
    HashMap localHashMap = new HashMap();
    if ((arrayOfString != null) && (paramBundle != null) && (arrayOfString.length > 0) && (paramBundle.length > 0) && (arrayOfString.length == paramBundle.length))
    {
      int i = 0;
      while (i < arrayOfString.length)
      {
        localHashMap.put(arrayOfString[i], paramBundle[i]);
        i += 1;
      }
    }
    this.rCs = localHashMap;
    switch (j)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      y.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = " + j);
      return false;
    case 1: 
      y.i("MicroMsg.MMWebViewClient", "getA8key-text: " + str3);
      if ((str3 == null) || (str3.length() == 0))
      {
        y.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
        return false;
      }
      this.dYF.getSettings().setJavaScriptEnabled(false);
      this.dYF.loadData(str3, "text/html", "utf-8");
      return true;
    case 2: 
    case 7: 
      y.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + str1 + ", fullUrl = " + str2);
      if ((str2 == null) || (str2.length() == 0))
      {
        y.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
        return false;
      }
      if (!ae.Sg(str2))
      {
        y.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = " + str2);
        TJ(str2);
        return true;
      }
      w(str2, localHashMap);
      return true;
    }
    y.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = " + str2);
    if ((str2 == null) || (str2.length() == 0))
    {
      y.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
      return false;
    }
    if (!ae.Sg(str2))
    {
      y.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = " + str2);
      TJ(str2);
      return true;
    }
    this.dYF.loadUrl(str2);
    return true;
  }
  
  private void cdN()
  {
    y.i("MicroMsg.MMWebViewClient", "tryBindService");
    Intent localIntent = new Intent(this.fyk, WebViewStubService.class);
    this.fyk.bindService(localIntent, this.rCt, 1);
  }
  
  private void cgQ()
  {
    try
    {
      if (this.rsT != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("scene_end_type", 233);
        localBundle.putInt("scene_end_listener_hash_code", this.dYF.hashCode());
        this.rsT.a(6, localBundle, this.dYF.hashCode());
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + localException.getMessage());
    }
  }
  
  private boolean fB(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return false;
    }
    if ((a.qYo.matcher(paramString1).matches()) && (a.qYo.matcher(paramString2).matches()))
    {
      String str2 = paramString1.replaceFirst("http://", "").replaceFirst("https://", "");
      int i = str2.indexOf('#');
      String str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
      if ((paramString2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(str1)) && (this.rsT != null) && (Tl(paramString1))) {
        return true;
      }
    }
    return false;
  }
  
  private void j(String paramString, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    if (this.fyk.isFinishing()) {
      return;
    }
    if (this.rxH == null)
    {
      y.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
      return;
    }
    if (this.rCe)
    {
      y.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
      this.rxH.a(paramString, null, null);
      return;
    }
    if (this.rsT == null) {}
    for (boolean bool1 = false; ((this.rxH.has(paramString)) || (bool1)) && (!paramBoolean); bool1 = this.rCg.contains(paramString))
    {
      y.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = " + paramString);
      return;
    }
    int i = this.rCi.TB(paramString);
    y.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + paramString + ", scene = " + paramInt + ", username = " + "" + ", reason = " + i + ", force = " + paramBoolean);
    y.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
    this.rCg.add(paramString);
    this.rxH.a(paramString, null, null);
    this.rCq = true;
    Object localObject = this.rCh;
    k localk;
    if (((k.b)localObject).rqP == 0) {
      localk = ((k.b)localObject).rCv;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("scene_end_type", 233);
      localBundle.putInt("scene_end_listener_hash_code", localk.dYF.hashCode());
      localk.rsT.a(5, localBundle, localk.dYF.hashCode());
      ((k.b)localObject).rqP += 1;
      localObject = new Bundle();
      ((Bundle)localObject).putString("geta8key_data_req_url", paramString);
      ((Bundle)localObject).putString("geta8key_data_username", "");
      ((Bundle)localObject).putInt("geta8key_data_scene", paramInt);
      ((Bundle)localObject).putInt("geta8key_data_reason", i);
      if (this.dYF.getIsX5Kernel())
      {
        ((Bundle)localObject).putInt("geta8key_data_flag", 1);
        ((Bundle)localObject).putString("geta8key_data_net_type", s.ccc());
        ((Bundle)localObject).putInt("webview_binder_id", this.dYF.hashCode());
        this.rCf = paramString;
        f((Bundle)localObject, paramString);
      }
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          paramBoolean = this.rsT.r(233, (Bundle)localObject);
          y.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = " + paramBoolean);
          return;
          localException = localException;
          y.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + localException.getMessage());
        }
        ((Bundle)localObject).putInt("geta8key_data_flag", 0);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          y.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + paramString.getMessage());
          paramBoolean = bool2;
        }
      }
    }
  }
  
  private void w(String paramString, Map<String, String> paramMap)
  {
    String str1 = bk.aM(cdR(), this.rCk);
    if (bk.bl(str1))
    {
      y.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
      this.dYF.loadUrl(paramString);
      return;
    }
    if (this.rvZ == null)
    {
      if (paramMap.size() > 0)
      {
        this.dYF.loadUrl(paramString, paramMap);
        return;
      }
      this.dYF.loadUrl(paramString);
      return;
    }
    if (bk.pm(paramString).contains("#wechat_redirect"))
    {
      if (paramMap.size() > 0)
      {
        this.dYF.loadUrl(paramString, paramMap);
        return;
      }
      this.dYF.loadUrl(paramString);
      return;
    }
    if (!fB(str1, paramString))
    {
      String str2 = com.tencent.mm.plugin.webview.modelcache.p.SA(str1);
      String str3 = com.tencent.mm.plugin.webview.modelcache.p.SA(paramString);
      if ((bk.bl(str3)) || (bk.bl(str2)) || (!str3.equals(str2)) || (this.rsT == null) || (!Tl(str1))) {
        break label221;
      }
    }
    label221:
    for (int i = 1; i != 0; i = 0)
    {
      this.rCo.put(str1, paramString);
      this.roP.put(str1, paramMap);
      this.rvZ.s(paramString, paramMap);
      return;
    }
    if (paramMap.size() > 0)
    {
      this.dYF.loadUrl(paramString, paramMap);
      return;
    }
    this.dYF.loadUrl(paramString);
  }
  
  public void TH(String paramString)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.dYF.loadUrl(paramString, localHashMap);
  }
  
  public boolean TI(String paramString)
  {
    if (this.rsT == null)
    {
      this.rCk = paramString;
      cdN();
      return true;
    }
    return false;
  }
  
  public void TJ(String paramString) {}
  
  public boolean Tl(String paramString)
  {
    if (this.dYF != null)
    {
      this.dYF.hashCode();
      return o.Sv(paramString);
    }
    return false;
  }
  
  public final boolean Ud(String paramString)
  {
    Iterator localIterator = this.rCn.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.b localb = (com.tencent.mm.plugin.webview.ui.tools.jsapi.b)localIterator.next();
      if (localb.Ty(paramString))
      {
        boolean bool = localb.Tq(paramString);
        y.i("MicroMsg.MMWebViewClient", "url handled, ret = " + bool + ", url = " + paramString);
        return true;
      }
    }
    return jh(paramString);
  }
  
  public com.tencent.xweb.m a(WebView paramWebView, l paraml)
  {
    if ((paraml == null) || (paraml.getUrl() == null) || (bk.bl(paraml.getUrl().toString()))) {
      return super.a(paramWebView, paraml);
    }
    y.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paraml.getUrl(), paraml.getMethod(), Boolean.valueOf(paraml.isForMainFrame()) });
    return this.rCj.a(paraml.getUrl().toString(), false, this.rsT);
  }
  
  public com.tencent.xweb.m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    if ((paraml == null) || (paraml.getUrl() == null) || (bk.bl(paraml.getUrl().toString()))) {
      return super.a(paramWebView, paraml, paramBundle);
    }
    y.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paraml.getUrl(), paraml.getMethod(), Boolean.valueOf(paraml.isForMainFrame()) });
    if (com.tencent.mm.cl.b.ho(this.fyk)) {}
    try
    {
      int i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        y.i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        j(paraml.getUrl().toString(), false, 5);
      }
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        y.w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", new Object[] { paramWebView.getMessage() });
      }
    }
    catch (Throwable paramWebView)
    {
      for (;;)
      {
        y.w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", new Object[] { paramWebView.getMessage() });
      }
    }
    return this.rCj.a(paraml.getUrl().toString(), true, this.rsT);
  }
  
  public void a(com.tencent.mm.plugin.webview.stub.d paramd, com.tencent.mm.plugin.webview.ui.tools.f paramf) {}
  
  public void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd) {}
  
  public void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public final void a(WebView paramWebView, h paramh, SslError paramSslError)
  {
    super.a(paramWebView, paramh, paramSslError);
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    y.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", new Object[] { paramString });
    if (this.rsT == null) {
      return;
    }
    super.a(paramWebView, paramString);
    if (!ae.Sg(paramString))
    {
      y.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = " + paramString);
      TJ(paramString);
      return;
    }
    this.rCm = "";
    if (paramString.equals("file:///android_asset/jsapi/wxjs.js"))
    {
      y.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
      e(paramWebView, paramString);
      return;
    }
    this.rwc.cfQ();
    e(paramWebView, paramString);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public final void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    super.a(paramWebView, paramString, paramBoolean);
    paramWebView = paramWebView.getUrl();
    if (this.rCe) {
      bq(paramWebView, false);
    }
    if ((this.rxH != null) && (!this.rxH.has(paramWebView)))
    {
      y.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { paramWebView });
      bq(paramWebView, false);
    }
  }
  
  public m all()
  {
    return null;
  }
  
  public int alm()
  {
    return 0;
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    y.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", new Object[] { paramString });
    if ((this.rsT == null) || (this.rCp))
    {
      this.rCp = false;
      return;
    }
    if (!ae.Sg(paramString))
    {
      y.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = " + paramString);
      TJ(paramString);
      return;
    }
    if (Ud(paramString))
    {
      this.rCm = paramString;
      return;
    }
    this.rCl = paramString;
    super.b(paramWebView, paramString, paramBitmap);
    this.rwc.cfP();
    if (Tl(paramString))
    {
      this.dYF.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
      if (this.rvZ != null) {
        this.rvZ.s((String)this.rCo.get(paramString), (Map)this.roP.get(paramString));
      }
    }
    bq(paramString, false);
    a(paramWebView, paramString, paramBitmap);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = " + paramString);
    if (this.rsT == null) {
      y.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
    }
    boolean bool;
    do
    {
      return true;
      if (!ae.Sg(paramString))
      {
        y.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = " + paramString);
        TJ(paramString);
        return true;
      }
      if (paramString.equals(this.rCm))
      {
        this.rCm = "";
        return true;
      }
      bool = Ud(paramString);
      if ((!bool) && (paramString.startsWith("weixin://")))
      {
        y.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
        return true;
      }
    } while (bool);
    int i = this.rCi.TB(paramString);
    if (((i == 0) || (i == 2)) && (!this.rCe))
    {
      y.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = " + i);
      if (Tl(paramString))
      {
        this.dYF.stopLoading();
        this.dYF.post(new k.2(this, paramString));
      }
      while (paramString.equals(this.rCf))
      {
        y.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
        return false;
        this.dYF.stopLoading();
      }
      bq(paramString, true);
      return true;
    }
    return false;
  }
  
  public final void bq(String paramString, boolean paramBoolean)
  {
    j(paramString, paramBoolean, alm());
  }
  
  public com.tencent.xweb.m c(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", new Object[] { paramString });
    return this.rCj.a(paramString, true, this.rsT);
  }
  
  final String cdR()
  {
    if (!bk.bl(this.rCl)) {
      return this.rCl;
    }
    if (this.mHandler == null) {
      return null;
    }
    if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId())
    {
      if (this.dYF == null) {
        return "";
      }
      return this.dYF.getUrl();
    }
    return (String)new k.4(this, "").b(this.mHandler);
  }
  
  public void cfN() {}
  
  public void cfO()
  {
    try
    {
      this.rsT.a(this.rCk, true, null);
      if (Ud(this.rCk)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.rCk);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.rCk += "http://";
        localObject = Uri.parse(this.rCk);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        y.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        this.rCi = new k.a(this.rCk);
        if ((this.rCe) || (this.rxH.has(this.rCk)))
        {
          this.dYF.loadUrl(this.rCk);
          return;
        }
        bq(this.rCk, false);
        return;
      }
      if (!ae.Sg(this.rCk))
      {
        TJ(this.rCk);
        return;
      }
      this.dYF.loadUrl(this.rCk);
    }
  }
  
  public final void cgP()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("init_url", this.rCk);
    localHashMap.put("webview_type", "1");
    localHashMap.put("init_font_size", "1");
    this.rvZ = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(this.dYF, this.rxH, localHashMap, this.rsT, this.dYF.hashCode());
    this.rvZ.rxG = null;
    this.dYF.addJavascriptInterface(this.rvZ, "__wx");
    this.rCn.add(this.rvZ);
    this.rCn.add(new e(this.dYF, this.rvZ));
    this.rwc = new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(this.dYF, this.rsT, this.rvZ, new k.3(this), false);
    a(this.rwc);
    try
    {
      i = bk.getInt(this.rsT.SQ("WebviewDisableDigestVerify"), 0);
      y.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
      if ((i == 0) && (this.fyk.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)))
      {
        this.rvZ.cfX();
        this.rCj.rgf = this.rvZ.rxJ;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + localException.getMessage());
        int i = 0;
      }
    }
  }
  
  public final void cleanup()
  {
    if (this.rCt != null) {}
    try
    {
      this.fyk.unbindService(this.rCt);
      if (this.rvZ != null) {
        this.rvZ.detach();
      }
      if (this.rwc != null) {
        this.rwc.detach();
      }
      cgQ();
    }
    catch (Exception localException1)
    {
      try
      {
        this.rsT.Co(this.dYF.hashCode());
        cfN();
        return;
        localException1 = localException1;
        y.e("MicroMsg.MMWebViewClient", localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.MMWebViewClient", localException2, "", new Object[0]);
        }
      }
    }
  }
  
  public void e(WebView paramWebView, String paramString) {}
  
  public void f(Bundle paramBundle, String paramString) {}
  
  public final void f(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = " + paramString);
    super.f(paramWebView, paramString);
  }
  
  public boolean jh(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k
 * JD-Core Version:    0.7.0.1
 */