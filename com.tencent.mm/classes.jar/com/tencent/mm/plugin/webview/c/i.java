package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static int DNp;
  private static String DNq;
  private static final String DNr;
  private static String DNs;
  private WebView DNl;
  private a DNm;
  private boolean DNn;
  private boolean DNo;
  public f DzP;
  
  static
  {
    AppMethodBeat.i(213913);
    DNp = -1;
    DNq = null;
    DNr = com.tencent.mm.loader.j.b.arM() + "/jscache/";
    DNs = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(213913);
  }
  
  public i(WebView paramWebView, f paramf, a parama)
  {
    this(paramWebView, paramf, parama, false);
  }
  
  public i(WebView paramWebView, f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(213904);
    this.DNo = false;
    this.DNl = paramWebView;
    this.DzP = paramf;
    this.DNm = parama;
    this.DNn = paramBoolean;
    ad.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramf.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(213904);
  }
  
  private String aGQ(String paramString)
  {
    AppMethodBeat.i(213911);
    ad.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (DNq != null) {
      localObject = DNq;
    }
    String str;
    for (;;)
    {
      str = DNr + (String)localObject + "/" + paramString;
      if (!com.tencent.mm.vfs.i.fv(str)) {
        break;
      }
      AppMethodBeat.o(213911);
      return str;
      localObject = com.tencent.mm.sdk.platformtools.i.REV.substring(0, Math.min(com.tencent.mm.sdk.platformtools.i.REV.length(), 8));
      DNq = (String)localObject;
    }
    a.aK(86, 1L);
    Object localObject = new com.tencent.mm.vfs.e(DNr).b(new m()
    {
      public final boolean wY(String paramAnonymousString)
      {
        AppMethodBeat.i(213903);
        if (!paramAnonymousString.equals(this.DNx))
        {
          AppMethodBeat.o(213903);
          return true;
        }
        AppMethodBeat.o(213903);
        return false;
      }
    });
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.vfs.i.cZ(q.B(localObject[i].mUri), true);
        i += 1;
      }
    }
    com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(str));
    try
    {
      kS(paramString, str);
      a.aK(87, 1L);
      AppMethodBeat.o(213911);
      return str;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(213911);
    }
    return null;
  }
  
  public static boolean b(WebView paramWebView)
  {
    AppMethodBeat.i(213909);
    if (DNp == -1) {
      DNp = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtn, 0);
    }
    if ((((DNp & 0x1) != 0) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(213909);
      return true;
    }
    AppMethodBeat.o(213909);
    return false;
  }
  
  private String eOP()
  {
    AppMethodBeat.i(213910);
    ad.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(org.apache.commons.a.e.toByteArray(aj.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.DzP.vJP))
      {
        ad.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.DzP.vJP, Integer.valueOf(this.DzP.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.DzP.vJP).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(213910);
      return str1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(213910);
    }
    return "";
  }
  
  private static void kS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213912);
    paramString1 = aj.getContext().getAssets().open(paramString1);
    OutputStream localOutputStream = com.tencent.mm.vfs.i.cX(paramString2, false);
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
    ad.i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(213912);
  }
  
  public final void BI()
  {
    AppMethodBeat.i(213906);
    if ((this.DNl == null) || (this.DzP == null))
    {
      ad.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
      AppMethodBeat.o(213906);
      return;
    }
    Object localObject = this.DzP;
    ad.v("MicroMsg.JsApiHandler", "jsapi init");
    if (((f)localObject).DMv == null) {
      ad.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
    }
    for (;;)
    {
      ad.i("MicroMsg.JsLoader", "jsapi init done");
      if (j.eOR()) {}
      try
      {
        localObject = new String(org.apache.commons.a.e.toByteArray(aj.getContext().getAssets().open("jsapi/vconsole.js")));
        if (this.DNl != null) {
          this.DNl.evaluateJavascript((String)localObject, null);
        }
        ad.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[] { Boolean.valueOf(this.DNo) });
        if ((this.DNo) && (this.DNm != null)) {
          this.DNm.eOQ();
        }
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(156L, 1L, 1L, false);
        if (!this.DNo) {
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(156L, 0L, 1L, false);
        }
        AppMethodBeat.o(213906);
        return;
        ((f)localObject).eOA();
        ((f)localObject).DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:init", null, ((f)localObject).DMD, ((f)localObject).vJP) + ")", new f.23((f)localObject));
        ((f)localObject).DMv.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:bridged", null, ((f)localObject).DMD, ((f)localObject).vJP) + ")", new f.33((f)localObject));
        ((f)localObject).uW(true);
        ((f)localObject).eOB();
        if ((bt.isNullOrNil(((f)localObject).DMR)) || (((f)localObject).DMv == null)) {
          continue;
        }
        ((f)localObject).DMv.evaluateJavascript(((f)localObject).fH(((f)localObject).DMR, ((f)localObject).DMS), null);
        ((f)localObject).DMR = null;
        ((f)localObject).DMS = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.JsLoader", localIOException, "openVConsole", new Object[0]);
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(213905);
    ad.v("MicroMsg.JsLoader", "detach");
    this.DNl = null;
    this.DzP = null;
    this.DNm = null;
    AppMethodBeat.o(213905);
  }
  
  public final void eON()
  {
    AppMethodBeat.i(213907);
    if ((this.DNl == null) || (this.DzP == null))
    {
      ad.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(213907);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", "authorized");
    this.DzP.uW(true);
    this.DzP.b("sys:auth", localHashMap, null);
    AppMethodBeat.o(213907);
  }
  
  public final void eOO()
  {
    AppMethodBeat.i(213908);
    ad.i("MicroMsg.JsLoader", "inject");
    if (this.DNn)
    {
      ad.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
      if (this.DzP != null) {
        this.DzP.uW(true);
      }
    }
    for (final boolean bool1 = true;; bool1 = false)
    {
      this.DNo = bool1;
      AppMethodBeat.o(213908);
      return;
      if ((this.DNl != null) && (this.DzP != null)) {
        break;
      }
      ad.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
    }
    this.DzP.DME = true;
    final long l1 = System.currentTimeMillis();
    bool1 = WebView.isX5();
    final boolean bool2 = this.DNl.isXWalkKernel();
    if (b(this.DNl))
    {
      String str = aGQ("jsapi/wxjs.js");
      if (str != null)
      {
        final long l2 = System.currentTimeMillis();
        if (l2 >= 0L)
        {
          a.aK(84, 1L);
          ag localag = new ag(3, 256, this.DNl);
          localag.nb(str, "path");
          this.DNl.evaluateJavascript(localag.toString(), new ValueCallback() {});
        }
      }
    }
    for (;;)
    {
      this.DzP.eOA();
      bool1 = true;
      break;
      a.aK(82, 1L);
      this.DNl.evaluateJavascript(eOP(), new ValueCallback() {});
    }
  }
  
  public static abstract interface a
  {
    public abstract void eOQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.i
 * JD-Core Version:    0.7.0.1
 */