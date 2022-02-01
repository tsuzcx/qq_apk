package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.webview.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.m;
import com.tencent.mm.vfs.q;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ag;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class i
{
  private static int Ckj;
  private static String Ckk;
  private static final String Ckl;
  private static String Ckm;
  public f Cjc;
  private WebView Ckf;
  private a Ckg;
  private boolean Ckh;
  private boolean Cki;
  
  static
  {
    AppMethodBeat.i(205311);
    Ckj = -1;
    Ckk = null;
    Ckl = com.tencent.mm.loader.j.b.aoZ() + "/jscache/";
    Ckm = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(205311);
  }
  
  public i(WebView paramWebView, f paramf, a parama)
  {
    this(paramWebView, paramf, parama, false);
  }
  
  public i(WebView paramWebView, f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(205302);
    this.Cki = false;
    this.Ckf = paramWebView;
    this.Cjc = paramf;
    this.Ckg = parama;
    this.Ckh = paramBoolean;
    ac.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ac.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramf.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(205302);
  }
  
  private String aBt(String paramString)
  {
    AppMethodBeat.i(205309);
    ac.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (Ckk != null) {
      localObject = Ckk;
    }
    String str;
    for (;;)
    {
      str = Ckl + (String)localObject + "/" + paramString;
      if (!com.tencent.mm.vfs.i.eA(str)) {
        break;
      }
      AppMethodBeat.o(205309);
      return str;
      localObject = com.tencent.mm.sdk.platformtools.h.REV.substring(0, Math.min(com.tencent.mm.sdk.platformtools.h.REV.length(), 8));
      Ckk = (String)localObject;
    }
    a.aA(86, 1L);
    Object localObject = new com.tencent.mm.vfs.e(Ckl).b(new m()
    {
      public final boolean ui(String paramAnonymousString)
      {
        AppMethodBeat.i(205301);
        if (!paramAnonymousString.equals(this.Ckr))
        {
          AppMethodBeat.o(205301);
          return true;
        }
        AppMethodBeat.o(205301);
        return false;
      }
    });
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.vfs.i.cU(q.B(localObject[i].mUri), true);
        i += 1;
      }
    }
    com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(str));
    try
    {
      ku(paramString, str);
      a.aA(87, 1L);
      AppMethodBeat.o(205309);
      return str;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(205309);
    }
    return null;
  }
  
  public static boolean b(WebView paramWebView)
  {
    AppMethodBeat.i(205307);
    if (Ckj == -1) {
      Ckj = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPo, 0);
    }
    if ((((Ckj & 0x1) != 0) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(205307);
      return true;
    }
    AppMethodBeat.o(205307);
    return false;
  }
  
  private String eAb()
  {
    AppMethodBeat.i(205308);
    ac.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(org.apache.commons.a.e.toByteArray(ai.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.Cjc.CjA))
      {
        ac.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.Cjc.CjA, Integer.valueOf(this.Cjc.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.Cjc.CjA).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(205308);
      return str1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(205308);
    }
    return "";
  }
  
  private static void ku(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205310);
    paramString1 = ai.getContext().getAssets().open(paramString1);
    OutputStream localOutputStream = com.tencent.mm.vfs.i.cS(paramString2, false);
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
    ac.i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(205310);
  }
  
  public final void Al()
  {
    AppMethodBeat.i(205304);
    if ((this.Ckf == null) || (this.Cjc == null))
    {
      ac.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
      AppMethodBeat.o(205304);
      return;
    }
    Object localObject = this.Cjc;
    ac.v("MicroMsg.JsApiHandler", "jsapi init");
    if (((f)localObject).Cjr == null) {
      ac.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
    }
    for (;;)
    {
      ac.i("MicroMsg.JsLoader", "jsapi init done");
      if (j.eAd()) {}
      try
      {
        localObject = new String(org.apache.commons.a.e.toByteArray(ai.getContext().getAssets().open("jsapi/vconsole.js")));
        if (this.Ckf != null) {
          this.Ckf.evaluateJavascript((String)localObject, null);
        }
        ac.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[] { Boolean.valueOf(this.Cki) });
        if ((this.Cki) && (this.Ckg != null)) {
          this.Ckg.eAc();
        }
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(156L, 1L, 1L, false);
        if (!this.Cki) {
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(156L, 0L, 1L, false);
        }
        AppMethodBeat.o(205304);
        return;
        ((f)localObject).Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:init", null, ((f)localObject).Cjz, ((f)localObject).CjA) + ")", new f.23((f)localObject));
        ((f)localObject).Cjr.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:bridged", null, ((f)localObject).Cjz, ((f)localObject).CjA) + ")", new f.33((f)localObject));
        ((f)localObject).ui(true);
        ((f)localObject).ezL();
        if ((bs.isNullOrNil(((f)localObject).CjK)) || (((f)localObject).Cjr == null)) {
          continue;
        }
        ((f)localObject).Cjr.evaluateJavascript(((f)localObject).fk(((f)localObject).CjK, ((f)localObject).CjL), null);
        ((f)localObject).CjK = null;
        ((f)localObject).CjL = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.JsLoader", localIOException, "openVConsole", new Object[0]);
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(205303);
    ac.v("MicroMsg.JsLoader", "detach");
    this.Ckf = null;
    this.Cjc = null;
    this.Ckg = null;
    AppMethodBeat.o(205303);
  }
  
  public final void eAa()
  {
    AppMethodBeat.i(205306);
    ac.i("MicroMsg.JsLoader", "inject");
    if (this.Ckh)
    {
      ac.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
      if (this.Cjc != null) {
        this.Cjc.ui(true);
      }
    }
    for (final boolean bool1 = true;; bool1 = false)
    {
      this.Cki = bool1;
      AppMethodBeat.o(205306);
      return;
      if ((this.Ckf != null) && (this.Cjc != null)) {
        break;
      }
      ac.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
    }
    final long l1 = System.currentTimeMillis();
    bool1 = WebView.isX5();
    final boolean bool2 = this.Ckf.isXWalkKernel();
    if (b(this.Ckf))
    {
      String str = aBt("jsapi/wxjs.js");
      if (str != null)
      {
        final long l2 = System.currentTimeMillis();
        if (l2 >= 0L)
        {
          a.aA(84, 1L);
          ag localag = new ag(3, 256, this.Ckf);
          localag.mD(str, "path");
          this.Ckf.evaluateJavascript(localag.toString(), new ValueCallback() {});
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      break;
      a.aA(82, 1L);
      this.Ckf.evaluateJavascript(eAb(), new ValueCallback() {});
    }
  }
  
  public final void ezZ()
  {
    AppMethodBeat.i(205305);
    if ((this.Ckf == null) || (this.Cjc == null))
    {
      ac.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(205305);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", "authorized");
    this.Cjc.ui(true);
    this.Cjc.b("sys:auth", localHashMap, null);
    AppMethodBeat.o(205305);
  }
  
  public static abstract interface a
  {
    public abstract void eAc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.i
 * JD-Core Version:    0.7.0.1
 */