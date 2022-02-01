package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ag;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.commons.a.e;

public final class i
{
  private static int Efo;
  private static String Efp;
  private static final String Efq;
  private static String Efr;
  public f DRx;
  private WebView Efk;
  private a Efl;
  private boolean Efm;
  private boolean Efn;
  
  static
  {
    AppMethodBeat.i(213742);
    Efo = -1;
    Efp = null;
    Efq = com.tencent.mm.loader.j.b.asb() + "/jscache/";
    Efr = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(213742);
  }
  
  public i(WebView paramWebView, f paramf, a parama)
  {
    this(paramWebView, paramf, parama, false);
  }
  
  public i(WebView paramWebView, f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(213733);
    this.Efn = false;
    this.Efk = paramWebView;
    this.DRx = paramf;
    this.Efl = parama;
    this.Efm = paramBoolean;
    ae.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ae.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramf.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(213733);
  }
  
  private String aIk(String paramString)
  {
    AppMethodBeat.i(213740);
    ae.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (Efp != null) {
      localObject = Efp;
    }
    String str;
    for (;;)
    {
      str = Efq + (String)localObject + "/" + paramString;
      if (!o.fB(str)) {
        break;
      }
      AppMethodBeat.o(213740);
      return str;
      localObject = com.tencent.mm.sdk.platformtools.j.REV.substring(0, Math.min(com.tencent.mm.sdk.platformtools.j.REV.length(), 8));
      Efp = (String)localObject;
    }
    a.aK(86, 1L);
    Object localObject = new k(Efq).b(new s()
    {
      public final boolean xH(String paramAnonymousString)
      {
        AppMethodBeat.i(213732);
        if (!paramAnonymousString.equals(this.Efw))
        {
          AppMethodBeat.o(213732);
          return true;
        }
        AppMethodBeat.o(213732);
        return false;
      }
    });
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        o.dd(w.B(localObject[i].mUri), true);
        i += 1;
      }
    }
    o.aZI(o.aZU(str));
    try
    {
      kZ(paramString, str);
      a.aK(87, 1L);
      AppMethodBeat.o(213740);
      return str;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(213740);
    }
    return null;
  }
  
  public static boolean b(WebView paramWebView)
  {
    AppMethodBeat.i(213738);
    if (Efo == -1) {
      Efo = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAc, 0);
    }
    if ((((Efo & 0x1) != 0) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(213738);
      return true;
    }
    AppMethodBeat.o(213738);
    return false;
  }
  
  private String eSA()
  {
    AppMethodBeat.i(213739);
    ae.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(e.toByteArray(ak.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.DRx.vVT))
      {
        ae.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.DRx.vVT, Integer.valueOf(this.DRx.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.DRx.vVT).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(213739);
      return str1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(213739);
    }
    return "";
  }
  
  private static void kZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213741);
    paramString1 = ak.getContext().getAssets().open(paramString1);
    OutputStream localOutputStream = o.db(paramString2, false);
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
    ae.i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(213741);
  }
  
  public final void BJ()
  {
    AppMethodBeat.i(213735);
    if ((this.Efk == null) || (this.DRx == null))
    {
      ae.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
      AppMethodBeat.o(213735);
      return;
    }
    Object localObject = this.DRx;
    ae.v("MicroMsg.JsApiHandler", "jsapi init");
    if (((f)localObject).Eet == null) {
      ae.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
    }
    for (;;)
    {
      ae.i("MicroMsg.JsLoader", "jsapi init done");
      if (j.eSC()) {}
      try
      {
        localObject = new String(e.toByteArray(ak.getContext().getAssets().open("jsapi/vconsole.js")));
        if (this.Efk != null) {
          this.Efk.evaluateJavascript((String)localObject, null);
        }
        ae.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[] { Boolean.valueOf(this.Efn) });
        if ((this.Efn) && (this.Efl != null)) {
          this.Efl.eSB();
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(156L, 1L, 1L, false);
        if (!this.Efn) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(156L, 0L, 1L, false);
        }
        AppMethodBeat.o(213735);
        return;
        ((f)localObject).eSl();
        ((f)localObject).Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:init", null, ((f)localObject).EeC, ((f)localObject).vVT) + ")", new f.23((f)localObject));
        ((f)localObject).Eet.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:bridged", null, ((f)localObject).EeC, ((f)localObject).vVT) + ")", new f.33((f)localObject));
        ((f)localObject).ve(true);
        ((f)localObject).eSm();
        if ((bu.isNullOrNil(((f)localObject).EeQ)) || (((f)localObject).Eet == null)) {
          continue;
        }
        ((f)localObject).Eet.evaluateJavascript(((f)localObject).fS(((f)localObject).EeQ, ((f)localObject).EeR), null);
        ((f)localObject).EeQ = null;
        ((f)localObject).EeR = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.JsLoader", localIOException, "openVConsole", new Object[0]);
        }
      }
    }
  }
  
  public final void detach()
  {
    AppMethodBeat.i(213734);
    ae.v("MicroMsg.JsLoader", "detach");
    this.Efk = null;
    this.DRx = null;
    this.Efl = null;
    AppMethodBeat.o(213734);
  }
  
  public final void eSy()
  {
    AppMethodBeat.i(213736);
    if ((this.Efk == null) || (this.DRx == null))
    {
      ae.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(213736);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", "authorized");
    this.DRx.ve(true);
    this.DRx.b("sys:auth", localHashMap, null);
    AppMethodBeat.o(213736);
  }
  
  public final void eSz()
  {
    AppMethodBeat.i(213737);
    ae.i("MicroMsg.JsLoader", "inject");
    if (this.Efm)
    {
      ae.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
      if (this.DRx != null) {
        this.DRx.ve(true);
      }
    }
    for (final boolean bool1 = true;; bool1 = false)
    {
      this.Efn = bool1;
      AppMethodBeat.o(213737);
      return;
      if ((this.Efk != null) && (this.DRx != null)) {
        break;
      }
      ae.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
    }
    this.DRx.EeD = true;
    final long l1 = System.currentTimeMillis();
    bool1 = WebView.isX5();
    final boolean bool2 = this.Efk.isXWalkKernel();
    if (b(this.Efk))
    {
      String str = aIk("jsapi/wxjs.js");
      if (str != null)
      {
        final long l2 = System.currentTimeMillis();
        if (l2 >= 0L)
        {
          a.aK(84, 1L);
          ag localag = new ag(3, 256, this.Efk);
          localag.nh(str, "path");
          this.Efk.evaluateJavascript(localag.toString(), new ValueCallback() {});
        }
      }
    }
    for (;;)
    {
      this.DRx.eSl();
      bool1 = true;
      break;
      a.aK(82, 1L);
      this.Efk.evaluateJavascript(eSA(), new ValueCallback() {});
    }
  }
  
  public static abstract interface a
  {
    public abstract void eSB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.i
 * JD-Core Version:    0.7.0.1
 */