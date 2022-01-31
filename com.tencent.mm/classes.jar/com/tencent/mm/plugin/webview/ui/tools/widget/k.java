package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.a;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.ap;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import com.tencent.xweb.w;
import java.lang.ref.WeakReference;
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
  extends w
{
  public MMWebView foJ;
  protected Activity gQx;
  ak mHandler;
  protected String nji;
  private final Map<String, Map<String, String>> vfB;
  public com.tencent.mm.plugin.webview.stub.d viZ;
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.d vmp;
  private f vmt;
  public com.tencent.mm.plugin.webview.ui.tools.k voA;
  private final Map<String, String> vsA;
  protected boolean vsB;
  protected boolean vsC;
  private boolean vsD;
  protected Map<String, String> vsE;
  protected k.c vsF;
  public m vsG;
  final Bundle vsp;
  protected boolean vsq;
  private String vsr;
  private Set<String> vss;
  protected k.b vst;
  protected k.a vsu;
  private ap vsv;
  protected String vsw;
  protected String vsx;
  private String vsy;
  private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> vsz;
  
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
    AppMethodBeat.i(9990);
    this.vmt = null;
    this.vmp = null;
    this.vsq = false;
    this.vsr = "";
    this.vss = new HashSet();
    this.vst = new k.b(this);
    this.vsu = new k.a(null);
    this.vsw = null;
    this.vsx = null;
    this.vsy = null;
    this.vsz = new ArrayList();
    this.vsA = new HashMap();
    this.vfB = new ConcurrentHashMap();
    this.vsB = false;
    this.vsC = false;
    this.vsD = false;
    this.vsF = new k.c(this);
    this.vsG = new k.5(this);
    this.gQx = ((Activity)paramMMWebView.getContext());
    this.foJ = paramMMWebView;
    this.mHandler = new ak();
    this.voA = new com.tencent.mm.plugin.webview.ui.tools.k((JsapiPermissionWrapper)this.gQx.getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper)this.gQx.getIntent().getParcelableExtra("hardcode_general_ctrl"), new k.1(this));
    this.vsq = paramBoolean;
    this.vsp = paramBundle;
    this.vsv = new ap(this.gQx);
    ab.i("MicroMsg.MMWebViewClient", "MMWebViewClient init, webview: %d, resourceInterrupter: %d", new Object[] { Integer.valueOf(this.foJ.hashCode()), Integer.valueOf(this.vsv.hashCode()) });
    AppMethodBeat.o(9990);
  }
  
  private void F(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(10012);
    String str1 = bo.bf(dek(), this.vsw);
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
      this.foJ.loadUrl(paramString);
      AppMethodBeat.o(10012);
      return;
    }
    if (this.vmp == null)
    {
      if (paramMap.size() > 0)
      {
        this.foJ.loadUrl(paramString, paramMap);
        AppMethodBeat.o(10012);
        return;
      }
      this.foJ.loadUrl(paramString);
      AppMethodBeat.o(10012);
      return;
    }
    if (bo.nullAsNil(paramString).contains("#wechat_redirect"))
    {
      if (paramMap.size() > 0)
      {
        this.foJ.loadUrl(paramString, paramMap);
        AppMethodBeat.o(10012);
        return;
      }
      this.foJ.loadUrl(paramString);
      AppMethodBeat.o(10012);
      return;
    }
    if (!hy(str1, paramString))
    {
      String str2 = com.tencent.mm.plugin.webview.d.b.asL(str1);
      String str3 = com.tencent.mm.plugin.webview.d.b.asL(paramString);
      if ((bo.isNullOrNil(str3)) || (bo.isNullOrNil(str2)) || (!str3.equals(str2)) || (this.viZ == null) || (!aip(str1))) {
        break label262;
      }
    }
    label262:
    for (int i = 1; i != 0; i = 0)
    {
      this.vsA.put(str1, paramString);
      this.vfB.put(str1, paramMap);
      this.vmp.B(paramString, paramMap);
      AppMethodBeat.o(10012);
      return;
    }
    if (paramMap.size() > 0)
    {
      this.foJ.loadUrl(paramString, paramMap);
      AppMethodBeat.o(10012);
      return;
    }
    this.foJ.loadUrl(paramString);
    AppMethodBeat.o(10012);
  }
  
  private void a(String paramString1, String paramString2, JsapiPermissionWrapper paramJsapiPermissionWrapper, GeneralControlWrapper paramGeneralControlWrapper)
  {
    AppMethodBeat.i(10015);
    if (!bo.isNullOrNil(paramString2))
    {
      this.voA.a(paramString2, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.vss.remove(paramString2);
      this.vsC = false;
      this.nji = paramString2;
    }
    if (hy(paramString1, paramString2))
    {
      this.voA.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
      this.vss.remove(paramString1);
      AppMethodBeat.o(10015);
      return;
    }
    if ((this.viZ == null) || (bo.isNullOrNil(paramString1)) || (!aip(paramString2)))
    {
      AppMethodBeat.o(10015);
      return;
    }
    this.voA.a(paramString1, paramJsapiPermissionWrapper, paramGeneralControlWrapper);
    this.vss.remove(paramString1);
    AppMethodBeat.o(10015);
  }
  
  private void def()
  {
    AppMethodBeat.i(10006);
    ab.i("MicroMsg.MMWebViewClient", "tryBindService");
    Intent localIntent = new Intent(this.gQx, WebViewStubService.class);
    this.gQx.bindService(localIntent, this.vsF, 1);
    AppMethodBeat.o(10006);
  }
  
  private String dek()
  {
    AppMethodBeat.i(10016);
    if (!bo.isNullOrNil(this.vsx))
    {
      str = this.vsx;
      AppMethodBeat.o(10016);
      return str;
    }
    if (this.mHandler == null)
    {
      AppMethodBeat.o(10016);
      return null;
    }
    if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId())
    {
      if (this.foJ == null)
      {
        AppMethodBeat.o(10016);
        return "";
      }
      str = this.foJ.getUrl();
      AppMethodBeat.o(10016);
      return str;
    }
    String str = (String)new k.4(this, "").b(this.mHandler);
    AppMethodBeat.o(10016);
    return str;
  }
  
  private void dgX()
  {
    AppMethodBeat.i(10011);
    try
    {
      if (this.viZ != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("scene_end_type", 233);
        localBundle.putInt("scene_end_listener_hash_code", this.foJ.hashCode());
        this.viZ.a(6, localBundle, this.foJ.hashCode());
      }
      AppMethodBeat.o(10011);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + localException.getMessage());
      AppMethodBeat.o(10011);
    }
  }
  
  private boolean hy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10013);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(10013);
      return false;
    }
    if ((a.uNB.matcher(paramString1).matches()) && (a.uNB.matcher(paramString2).matches()))
    {
      String str2 = paramString1.replaceFirst("http://", "").replaceFirst("https://", "");
      int i = str2.indexOf('#');
      String str1 = str2;
      if (i > 0) {
        str1 = str2.substring(0, i);
      }
      if ((paramString2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(str1)) && (this.viZ != null) && (aip(paramString1)))
      {
        AppMethodBeat.o(10013);
        return true;
      }
    }
    AppMethodBeat.o(10013);
    return false;
  }
  
  private void l(String paramString, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10010);
    if (this.gQx.isFinishing())
    {
      AppMethodBeat.o(10010);
      return;
    }
    if (this.voA == null)
    {
      ab.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
      AppMethodBeat.o(10010);
      return;
    }
    if (this.vsq)
    {
      ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
      this.voA.a(paramString, null, null);
      AppMethodBeat.o(10010);
      return;
    }
    if (this.viZ == null) {}
    for (boolean bool1 = false; ((this.voA.has(paramString)) || (bool1)) && (!paramBoolean); bool1 = this.vss.contains(paramString))
    {
      ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(10010);
      return;
    }
    int i = this.vsu.agV(paramString);
    ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + paramString + ", scene = " + paramInt + ", username = " + "" + ", reason = " + i + ", force = " + paramBoolean);
    ab.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
    this.vss.add(paramString);
    this.voA.a(paramString, null, null);
    this.vsC = true;
    this.vst.deQ();
    Bundle localBundle = new Bundle();
    localBundle.putString("geta8key_data_req_url", paramString);
    localBundle.putString("geta8key_data_username", "");
    localBundle.putInt("geta8key_data_scene", paramInt);
    localBundle.putInt("geta8key_data_reason", i);
    if (this.foJ.getIsX5Kernel()) {
      localBundle.putInt("geta8key_data_flag", 1);
    }
    for (;;)
    {
      localBundle.putString("geta8key_data_net_type", u.dcf());
      localBundle.putInt("webview_binder_id", this.foJ.hashCode());
      localBundle.putString("geta8key_outer_url", De(paramString));
      this.vsr = paramString;
      g(localBundle, paramString);
      try
      {
        paramBoolean = this.viZ.v(233, localBundle);
        ab.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(10010);
        return;
        localBundle.putInt("geta8key_data_flag", 0);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ab.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + paramString.getMessage());
          paramBoolean = bool2;
        }
      }
    }
  }
  
  protected String De(String paramString)
  {
    return "";
  }
  
  protected void PW(String paramString)
  {
    AppMethodBeat.i(10008);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("Pragma", "no-cache");
    localHashMap.put("Cache-Control", "no-cache");
    this.foJ.loadUrl(paramString, localHashMap);
    AppMethodBeat.o(10008);
  }
  
  public s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(10001);
    if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
    {
      paramWebView = super.a(paramWebView, paramr);
      AppMethodBeat.o(10001);
      return paramWebView;
    }
    ab.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramr.getUrl(), paramr.getMethod(), Boolean.valueOf(paramr.isForMainFrame()) });
    paramWebView = this.vsv.a(paramr.getUrl().toString(), false, this.viZ);
    AppMethodBeat.o(10001);
    return paramWebView;
  }
  
  public s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(10002);
    if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
    {
      paramWebView = super.a(paramWebView, paramr, paramBundle);
      AppMethodBeat.o(10002);
      return paramWebView;
    }
    ab.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramr.getUrl(), paramr.getMethod(), Boolean.valueOf(paramr.isForMainFrame()) });
    if (com.tencent.mm.cn.d.iN(this.gQx)) {}
    try
    {
      int i = paramBundle.getInt("resourceType");
      if ((i == 1) || (i == 7))
      {
        ab.i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", new Object[] { Integer.valueOf(i) });
        l(paramr.getUrl().toString(), false, aGo());
      }
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        ab.w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", new Object[] { paramWebView.getMessage() });
      }
    }
    catch (Throwable paramWebView)
    {
      for (;;)
      {
        ab.w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", new Object[] { paramWebView.getMessage() });
      }
    }
    paramWebView = this.vsv.a(paramr.getUrl().toString(), true, this.viZ);
    AppMethodBeat.o(10002);
    return paramWebView;
  }
  
  public void a(com.tencent.mm.plugin.webview.stub.d paramd, com.tencent.mm.plugin.webview.ui.tools.k paramk) {}
  
  protected void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd) {}
  
  protected void a(f paramf) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9998);
    super.a(paramWebView, paramInt, paramString1, paramString2);
    AppMethodBeat.o(9998);
  }
  
  public final void a(WebView paramWebView, com.tencent.xweb.m paramm, SslError paramSslError)
  {
    AppMethodBeat.i(9997);
    super.a(paramWebView, paramm, paramSslError);
    AppMethodBeat.o(9997);
  }
  
  protected void a(WebView paramWebView, String paramString, Bitmap paramBitmap) {}
  
  public final void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(9994);
    ab.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    super.a(paramWebView, paramString, paramBoolean);
    paramWebView = paramWebView.getUrl();
    if (this.vsq) {
      bP(paramWebView, false);
    }
    if ((this.voA != null) && (!this.voA.has(paramWebView)))
    {
      ab.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { paramWebView });
      bP(paramWebView, false);
    }
    AppMethodBeat.o(9994);
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(9993);
    ab.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = ".concat(String.valueOf(paramString)));
    if (this.viZ == null)
    {
      ab.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
      AppMethodBeat.o(9993);
      return true;
    }
    if (!aj.ahc(paramString))
    {
      ab.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = ".concat(String.valueOf(paramString)));
      aiK(paramString);
      AppMethodBeat.o(9993);
      return true;
    }
    if (paramString.equals(this.vsy))
    {
      this.vsy = "";
      AppMethodBeat.o(9993);
      return true;
    }
    if (DownloadChecker.a(paramString, getSource(), paramWebView))
    {
      ab.i("MicroMsg.MMWebViewClient", "use the downloader to download");
      AppMethodBeat.o(9993);
      return true;
    }
    boolean bool = ajn(paramString);
    if ((!bool) && (paramString.startsWith("weixin://")))
    {
      ab.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[] { paramString });
      AppMethodBeat.o(9993);
      return true;
    }
    if (bool)
    {
      AppMethodBeat.o(9993);
      return true;
    }
    int i = this.vsu.agV(paramString);
    if (((i == 0) || (i == 2)) && (!this.vsq))
    {
      ab.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = ".concat(String.valueOf(i)));
      if (aip(paramString))
      {
        this.foJ.stopLoading();
        this.foJ.post(new k.2(this, paramString));
      }
      while (paramString.equals(this.vsr))
      {
        ab.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
        AppMethodBeat.o(9993);
        return false;
        this.foJ.stopLoading();
      }
      bP(paramString, true);
      AppMethodBeat.o(9993);
      return true;
    }
    AppMethodBeat.o(9993);
    return false;
  }
  
  protected m aGm()
  {
    return null;
  }
  
  protected int aGn()
  {
    return 0;
  }
  
  protected int aGo()
  {
    return 5;
  }
  
  protected boolean aiJ(String paramString)
  {
    AppMethodBeat.i(10007);
    if (this.viZ == null)
    {
      this.vsw = paramString;
      def();
      AppMethodBeat.o(10007);
      return true;
    }
    AppMethodBeat.o(10007);
    return false;
  }
  
  protected void aiK(String paramString) {}
  
  protected boolean aip(String paramString)
  {
    AppMethodBeat.i(9991);
    if (this.foJ != null)
    {
      AppMethodBeat.o(9991);
      return false;
    }
    AppMethodBeat.o(9991);
    return false;
  }
  
  protected final boolean ajn(String paramString)
  {
    AppMethodBeat.i(9992);
    Iterator localIterator = this.vsz.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.b localb = (com.tencent.mm.plugin.webview.ui.tools.jsapi.b)localIterator.next();
      if (localb.aiz(paramString))
      {
        bool = localb.ait(paramString);
        ab.i("MicroMsg.MMWebViewClient", "url handled, ret = " + bool + ", url = " + paramString);
        AppMethodBeat.o(9992);
        return true;
      }
    }
    boolean bool = pV(paramString);
    AppMethodBeat.o(9992);
    return bool;
  }
  
  protected boolean av(Bundle paramBundle)
  {
    AppMethodBeat.i(10014);
    ab.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    int j = paramBundle.getInt("geta8key_result_action_code");
    String str1 = paramBundle.getString("geta8key_result_title");
    String str2 = paramBundle.getString("geta8key_result_full_url");
    String str3 = paramBundle.getString("geta8key_result_content");
    ab.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + j + ", title = " + str1 + ", fullUrl = " + str2 + ", content = " + str3);
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
    this.vsE = localHashMap;
    switch (j)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      ab.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = ".concat(String.valueOf(j)));
      AppMethodBeat.o(10014);
      return false;
    case 1: 
      ab.i("MicroMsg.MMWebViewClient", "getA8key-text: ".concat(String.valueOf(str3)));
      if ((str3 == null) || (str3.length() == 0))
      {
        ab.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
        AppMethodBeat.o(10014);
        return false;
      }
      this.foJ.getSettings().setJavaScriptEnabled(false);
      this.foJ.loadData(str3, "text/html", "utf-8");
      AppMethodBeat.o(10014);
      return true;
    case 2: 
    case 7: 
      ab.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + str1 + ", fullUrl = " + str2);
      if ((str2 == null) || (str2.length() == 0))
      {
        ab.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
        AppMethodBeat.o(10014);
        return false;
      }
      if (!aj.ahc(str2))
      {
        ab.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(str2)));
        aiK(str2);
        AppMethodBeat.o(10014);
        return true;
      }
      F(str2, localHashMap);
      AppMethodBeat.o(10014);
      return true;
    }
    ab.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = ".concat(String.valueOf(str2)));
    if ((str2 == null) || (str2.length() == 0))
    {
      ab.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
      AppMethodBeat.o(10014);
      return false;
    }
    if (!aj.ahc(str2))
    {
      ab.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = ".concat(String.valueOf(str2)));
      aiK(str2);
      AppMethodBeat.o(10014);
      return true;
    }
    this.foJ.loadUrl(str2);
    AppMethodBeat.o(10014);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(9996);
    ab.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", new Object[] { paramString });
    if (this.viZ == null)
    {
      AppMethodBeat.o(9996);
      return;
    }
    super.b(paramWebView, paramString);
    if (!aj.ahc(paramString))
    {
      ab.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      aiK(paramString);
      AppMethodBeat.o(9996);
      return;
    }
    this.vsy = "";
    if (paramString.equals("file:///android_asset/jsapi/wxjs.js"))
    {
      ab.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
      e(paramWebView, paramString);
      AppMethodBeat.o(9996);
      return;
    }
    this.vmt.uG();
    e(paramWebView, paramString);
    AppMethodBeat.o(9996);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(9995);
    ab.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", new Object[] { paramString });
    if ((this.viZ == null) || (this.vsB))
    {
      this.vsB = false;
      AppMethodBeat.o(9995);
      return;
    }
    if (!aj.ahc(paramString))
    {
      ab.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(paramString)));
      aiK(paramString);
      AppMethodBeat.o(9995);
      return;
    }
    if (ajn(paramString))
    {
      this.vsy = paramString;
      AppMethodBeat.o(9995);
      return;
    }
    this.vsx = paramString;
    super.b(paramWebView, paramString, paramBitmap);
    this.vmt.dgb();
    if (aip(paramString))
    {
      this.foJ.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
      if (this.vmp != null) {
        this.vmp.B((String)this.vsA.get(paramString), (Map)this.vfB.get(paramString));
      }
    }
    bP(paramString, false);
    a(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(9995);
  }
  
  public void bP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(10009);
    l(paramString, paramBoolean, aGn());
    AppMethodBeat.o(10009);
  }
  
  public s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(10000);
    ab.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", new Object[] { paramString });
    paramWebView = this.vsv.a(paramString, true, this.viZ);
    AppMethodBeat.o(10000);
    return paramWebView;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(10003);
    try
    {
      this.viZ.Kh(this.foJ.hashCode());
      if (this.vsF == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.gQx.unbindService(this.vsF);
        if (this.vmp != null) {
          this.vmp.detach();
        }
        if (this.vmt != null) {
          this.vmt.detach();
        }
        dgX();
        this.vsG = null;
        dfW();
        AppMethodBeat.o(10003);
        return;
        localException1 = localException1;
        ab.printErrStackTrace("MicroMsg.MMWebViewClient", localException1, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMWebViewClient", localException2.getMessage());
        }
      }
    }
  }
  
  protected void dfW() {}
  
  protected void dfX()
  {
    AppMethodBeat.i(10005);
    if (TextUtils.isEmpty(this.vsw))
    {
      AppMethodBeat.o(10005);
      return;
    }
    try
    {
      this.viZ.a(this.vsw, true, null);
      if (ajn(this.vsw))
      {
        AppMethodBeat.o(10005);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + localException.getMessage());
      }
      Uri localUri = Uri.parse(this.vsw);
      Object localObject = localUri;
      if (localUri.getScheme() == null)
      {
        this.vsw += "http://";
        localObject = Uri.parse(this.vsw);
      }
      if (((Uri)localObject).getScheme().startsWith("http"))
      {
        ab.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + ((Uri)localObject).getScheme());
        this.vsu = new k.a(this.vsw);
        if ((this.vsq) || (this.voA.has(this.vsw)))
        {
          this.foJ.loadUrl(this.vsw);
          AppMethodBeat.o(10005);
          return;
        }
        bP(this.vsw, false);
        AppMethodBeat.o(10005);
        return;
      }
      if (!aj.ahc(this.vsw))
      {
        aiK(this.vsw);
        AppMethodBeat.o(10005);
        return;
      }
      this.foJ.loadUrl(this.vsw);
      AppMethodBeat.o(10005);
    }
  }
  
  public final void dgW()
  {
    AppMethodBeat.i(10004);
    HashMap localHashMap = new HashMap();
    localHashMap.put("init_url", this.vsw);
    localHashMap.put("webview_type", "1");
    localHashMap.put("init_font_size", "1");
    this.vmp = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(this.foJ, this.voA, localHashMap, this.viZ, this.foJ.hashCode());
    ab.i("MicroMsg.MMWebViewClient", "initJsApi， webview: %d, jsapi: %d", new Object[] { Integer.valueOf(this.foJ.hashCode()), Integer.valueOf(this.vmp.hashCode()) });
    this.vmp.voz = null;
    this.foJ.addJavascriptInterface(this.vmp, "__wx");
    this.vsz.add(this.vmp);
    this.vsz.add(new e(this.foJ, this.vmp));
    this.vmt = new f(this.foJ, this.viZ, this.vmp, new k.3(this), false);
    a(this.vmt);
    try
    {
      i = bo.getInt(this.viZ.ahS("WebviewDisableDigestVerify"), 0);
      ab.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", new Object[] { Integer.valueOf(i) });
      if ((i == 0) && (this.gQx.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)))
      {
        this.vmp.dgj();
        this.vsv.ahj(this.vmp.voC);
      }
      AppMethodBeat.o(10004);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + localException.getMessage());
        int i = 0;
      }
    }
  }
  
  protected void e(WebView paramWebView, String paramString) {}
  
  protected void g(Bundle paramBundle, String paramString) {}
  
  protected String getSource()
  {
    return "";
  }
  
  public final void h(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(9999);
    ab.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = ".concat(String.valueOf(paramString)));
    super.h(paramWebView, paramString);
    AppMethodBeat.o(9999);
  }
  
  public final void oI(boolean paramBoolean)
  {
    this.vsB = paramBoolean;
  }
  
  protected boolean pV(String paramString)
  {
    return false;
  }
  
  protected static final class d
    extends m
  {
    private WeakReference<m> iyQ;
    
    public d(WeakReference<m> paramWeakReference)
    {
      this.iyQ = paramWeakReference;
    }
    
    public final boolean Ke(int paramInt)
    {
      AppMethodBeat.i(9969);
      m localm = (m)this.iyQ.get();
      if (localm != null)
      {
        boolean bool = localm.Ke(paramInt);
        AppMethodBeat.o(9969);
        return bool;
      }
      AppMethodBeat.o(9969);
      return false;
    }
    
    public final boolean a(c paramc)
    {
      AppMethodBeat.i(9971);
      m localm = (m)this.iyQ.get();
      if (localm != null)
      {
        boolean bool = localm.a(paramc);
        AppMethodBeat.o(9971);
        return bool;
      }
      AppMethodBeat.o(9971);
      return false;
    }
    
    public final boolean a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
    {
      AppMethodBeat.i(9972);
      m localm = (m)this.iyQ.get();
      if (localm != null)
      {
        paramBoolean = localm.a(paramString1, paramString2, paramBundle, paramBoolean);
        AppMethodBeat.o(9972);
        return paramBoolean;
      }
      AppMethodBeat.o(9972);
      return false;
    }
    
    public final void af(Bundle paramBundle)
    {
      AppMethodBeat.i(9980);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.af(paramBundle);
      }
      AppMethodBeat.o(9980);
    }
    
    public final void ag(Bundle paramBundle)
    {
      AppMethodBeat.i(9986);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.ag(paramBundle);
      }
      AppMethodBeat.o(9986);
    }
    
    public final void ahL(String paramString)
    {
      AppMethodBeat.i(9981);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.ahL(paramString);
      }
      AppMethodBeat.o(9981);
    }
    
    public final String dcW()
    {
      AppMethodBeat.i(9973);
      Object localObject = (m)this.iyQ.get();
      if (localObject != null)
      {
        localObject = ((m)localObject).dcW();
        AppMethodBeat.o(9973);
        return localObject;
      }
      AppMethodBeat.o(9973);
      return "";
    }
    
    public final String dcX()
    {
      AppMethodBeat.i(9975);
      Object localObject = (m)this.iyQ.get();
      if (localObject != null)
      {
        localObject = ((m)localObject).dcX();
        AppMethodBeat.o(9975);
        return localObject;
      }
      AppMethodBeat.o(9975);
      return "";
    }
    
    public final void dcZ()
    {
      AppMethodBeat.i(9979);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.dcZ();
      }
      AppMethodBeat.o(9979);
    }
    
    public final void dda()
    {
      AppMethodBeat.i(9983);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.dda();
      }
      AppMethodBeat.o(9983);
    }
    
    public final Bundle dm(String paramString1, String paramString2)
    {
      AppMethodBeat.i(9989);
      m localm = (m)this.iyQ.get();
      if (localm != null)
      {
        paramString1 = localm.dm(paramString1, paramString2);
        AppMethodBeat.o(9989);
        return paramString1;
      }
      AppMethodBeat.o(9989);
      return null;
    }
    
    public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(9984);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.e(paramString1, paramString2, paramInt1, paramInt2);
      }
      AppMethodBeat.o(9984);
    }
    
    public final boolean e(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(9970);
      m localm = (m)this.iyQ.get();
      if (localm != null)
      {
        boolean bool = localm.e(paramInt, paramBundle);
        AppMethodBeat.o(9970);
        return bool;
      }
      AppMethodBeat.o(9970);
      return false;
    }
    
    public final String getCurrentUrl()
    {
      AppMethodBeat.i(9974);
      Object localObject = (m)this.iyQ.get();
      if (localObject != null)
      {
        localObject = ((m)localObject).getCurrentUrl();
        AppMethodBeat.o(9974);
        return localObject;
      }
      AppMethodBeat.o(9974);
      return "";
    }
    
    public final void hu(String paramString1, String paramString2)
    {
      AppMethodBeat.i(9982);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.hu(paramString1, paramString2);
      }
      AppMethodBeat.o(9982);
    }
    
    public final void hv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(9988);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.hv(paramString1, paramString2);
      }
      AppMethodBeat.o(9988);
    }
    
    public final Bundle i(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(9985);
      m localm = (m)this.iyQ.get();
      if (localm != null)
      {
        paramBundle = localm.i(paramInt, paramBundle);
        AppMethodBeat.o(9985);
        return paramBundle;
      }
      paramBundle = new Bundle();
      AppMethodBeat.o(9985);
      return paramBundle;
    }
    
    public final void om(boolean paramBoolean)
    {
      AppMethodBeat.i(9976);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.om(paramBoolean);
      }
      AppMethodBeat.o(9976);
    }
    
    public final void on(boolean paramBoolean)
    {
      AppMethodBeat.i(9977);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.on(paramBoolean);
      }
      AppMethodBeat.o(9977);
    }
    
    public final void oo(boolean paramBoolean)
    {
      AppMethodBeat.i(9987);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.oo(paramBoolean);
      }
      AppMethodBeat.o(9987);
    }
    
    public final void t(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(9978);
      m localm = (m)this.iyQ.get();
      if (localm != null) {
        localm.t(paramInt, paramBundle);
      }
      AppMethodBeat.o(9978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k
 * JD-Core Version:    0.7.0.1
 */