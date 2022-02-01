package com.tencent.mm.plugin.webview.jsapi;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.webview.g.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.an;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.commons.b.d;

public final class m
{
  private static String WEA;
  private static int WEx;
  private static String WEy;
  private static final String WEz;
  public WebView WEt;
  private a WEu;
  private boolean WEv;
  private boolean WEw;
  public j WlX;
  
  static
  {
    AppMethodBeat.i(295297);
    WEx = -1;
    WEy = null;
    WEz = b.bmr() + "/jscache/";
    WEA = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(295297);
  }
  
  public m(WebView paramWebView, j paramj, a parama)
  {
    this(paramWebView, paramj, parama, false);
  }
  
  public m(WebView paramWebView, j paramj, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(295246);
    this.WEw = false;
    this.WEt = paramWebView;
    this.WlX = paramj;
    this.WEu = parama;
    this.WEv = paramBoolean;
    Log.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramj.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(295246);
  }
  
  private String bjR(String paramString)
  {
    AppMethodBeat.i(295281);
    Log.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (WEy != null) {
      localObject = WEy;
    }
    String str;
    for (;;)
    {
      str = WEz + (String)localObject + "/" + paramString;
      if (!y.ZC(str)) {
        break;
      }
      AppMethodBeat.o(295281);
      return str;
      localObject = BuildInfo.REV.substring(0, Math.min(BuildInfo.REV.length(), 8));
      WEy = (String)localObject;
    }
    a.atP(86);
    Object localObject = new u(WEz).b(new ad()
    {
      public final boolean accept(u paramAnonymousu, String paramAnonymousString)
      {
        AppMethodBeat.i(295172);
        if (!paramAnonymousString.equals(this.wZE))
        {
          AppMethodBeat.o(295172);
          return true;
        }
        AppMethodBeat.o(295172);
        return false;
      }
    });
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        y.ew(ah.v(localObject[i].mUri), true);
        i += 1;
      }
    }
    y.bDX(y.bEo(str));
    try
    {
      oo(paramString, str);
      a.atP(87);
      AppMethodBeat.o(295281);
      return str;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(295281);
    }
    return null;
  }
  
  public static boolean c(WebView paramWebView)
  {
    AppMethodBeat.i(295255);
    if (WEx == -1) {
      WEx = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yMt, 0);
    }
    if ((((WEx & 0x1) != 0) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(295255);
      return true;
    }
    AppMethodBeat.o(295255);
    return false;
  }
  
  private boolean itM()
  {
    AppMethodBeat.i(295261);
    if (this.WEv)
    {
      Log.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
      if (this.WlX != null) {
        this.WlX.Iy(true);
      }
      AppMethodBeat.o(295261);
      return true;
    }
    if ((this.WEt == null) || (this.WlX == null))
    {
      Log.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
      AppMethodBeat.o(295261);
      return false;
    }
    this.WlX.WDJ = true;
    final long l1 = System.currentTimeMillis();
    final boolean bool1 = WebView.isX5();
    final boolean bool2 = this.WEt.isXWalkKernel();
    if (c(this.WEt))
    {
      String str = bjR("jsapi/wxjs.js");
      if (str != null)
      {
        final long l2 = System.currentTimeMillis();
        if (l2 >= 0L)
        {
          a.atP(84);
          an localan = new an(3, 256, this.WEt);
          localan.qU(str, "path");
          this.WEt.evaluateJavascript(localan.toString(), new ValueCallback() {});
        }
      }
    }
    for (;;)
    {
      this.WlX.ity();
      AppMethodBeat.o(295261);
      return true;
      a.atP(82);
      this.WEt.evaluateJavascript(itN(), new ValueCallback() {});
    }
  }
  
  private String itN()
  {
    AppMethodBeat.i(295272);
    Log.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(d.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.WlX.KQY))
      {
        Log.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.WlX.KQY, Integer.valueOf(this.WlX.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.WlX.KQY).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(295272);
      return str1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(295272);
    }
    return "";
  }
  
  private static void oo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(295286);
    paramString1 = MMApplicationContext.getContext().getAssets().open(paramString1);
    OutputStream localOutputStream = y.ev(paramString2, false);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramString1.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localOutputStream.write(arrayOfByte, 0, i);
    }
    paramString1.close();
    localOutputStream.close();
    Log.i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(295286);
  }
  
  public final void bjQ(String paramString)
  {
    AppMethodBeat.i(295319);
    Log.i("MicroMsg.JsLoader", "auth url: %s", new Object[] { paramString });
    if ((this.WEt == null) || (this.WlX == null))
    {
      Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(295319);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", "authorized");
    if (paramString != null) {
      localHashMap.put("fullUrl", paramString);
    }
    this.WlX.Iy(true);
    this.WlX.b("sys:auth", localHashMap, null);
    AppMethodBeat.o(295319);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(295304);
    Log.v("MicroMsg.JsLoader", "detach");
    this.WEt = null;
    this.WlX = null;
    this.WEu = null;
    AppMethodBeat.o(295304);
  }
  
  public final void itL()
  {
    AppMethodBeat.i(295325);
    Log.i("MicroMsg.JsLoader", "inject");
    this.WEw = itM();
    AppMethodBeat.o(295325);
  }
  
  public final void ready()
  {
    AppMethodBeat.i(295311);
    if ((this.WEt == null) || (this.WlX == null))
    {
      Log.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
      AppMethodBeat.o(295311);
      return;
    }
    this.WlX.init();
    Log.i("MicroMsg.JsLoader", "jsapi init done");
    if (n.itP()) {}
    try
    {
      String str = new String(d.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/vconsole.js")));
      if (this.WEt != null) {
        this.WEt.evaluateJavascript(str, null);
      }
      Log.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[] { Boolean.valueOf(this.WEw) });
      if ((this.WEw) && (this.WEu != null)) {
        this.WEu.itO();
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(156L, 1L, 1L, false);
      if (!this.WEw) {
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(156L, 0L, 1L, false);
      }
      AppMethodBeat.o(295311);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsLoader", localIOException, "openVConsole", new Object[0]);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void itO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.m
 * JD-Core Version:    0.7.0.1
 */