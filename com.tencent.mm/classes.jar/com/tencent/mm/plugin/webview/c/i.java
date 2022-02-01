package com.tencent.mm.plugin.webview.c;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.webview.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.m;
import com.tencent.mm.vfs.q;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ae;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.commons.a.d;

public final class i
{
  private static int ARW;
  private static String ARX;
  private static final String ARY;
  private static String ARZ;
  public f AQP;
  private WebView ARS;
  private a ART;
  private boolean ARU;
  private boolean ARV;
  
  static
  {
    AppMethodBeat.i(189682);
    ARW = -1;
    ARX = null;
    ARY = com.tencent.mm.loader.j.b.ahZ() + "/jscache/";
    ARZ = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(189682);
  }
  
  public i(WebView paramWebView, f paramf, a parama)
  {
    this(paramWebView, paramf, parama, false);
  }
  
  public i(WebView paramWebView, f paramf, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(189673);
    this.ARV = false;
    this.ARS = paramWebView;
    this.AQP = paramf;
    this.ART = parama;
    this.ARU = paramBoolean;
    ad.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramf.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(189673);
  }
  
  private String awb(String paramString)
  {
    AppMethodBeat.i(189680);
    ad.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (ARX != null) {
      localObject = ARX;
    }
    String str;
    for (;;)
    {
      str = ARY + (String)localObject + "/" + paramString;
      if (!com.tencent.mm.vfs.i.eK(str)) {
        break;
      }
      AppMethodBeat.o(189680);
      return str;
      localObject = com.tencent.mm.sdk.platformtools.h.REV.substring(0, Math.min(com.tencent.mm.sdk.platformtools.h.REV.length(), 8));
      ARX = (String)localObject;
    }
    a.aA(86, 1L);
    Object localObject = new e(ARY).b(new m()
    {
      public final boolean qT(String paramAnonymousString)
      {
        AppMethodBeat.i(189672);
        if (!paramAnonymousString.equals(this.ASe))
        {
          AppMethodBeat.o(189672);
          return true;
        }
        AppMethodBeat.o(189672);
        return false;
      }
    });
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        com.tencent.mm.vfs.i.cO(q.B(localObject[i].mUri), true);
        i += 1;
      }
    }
    com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(str));
    try
    {
      jY(paramString, str);
      a.aA(87, 1L);
      AppMethodBeat.o(189680);
      return str;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(189680);
    }
    return null;
  }
  
  public static boolean b(WebView paramWebView)
  {
    AppMethodBeat.i(189678);
    if (ARW == -1) {
      ARW = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.plS, 0);
    }
    if ((((ARW & 0x1) != 0) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.h.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(189678);
      return true;
    }
    AppMethodBeat.o(189678);
    return false;
  }
  
  private String ekF()
  {
    AppMethodBeat.i(189679);
    ad.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(d.toByteArray(aj.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.AQP.ARn))
      {
        ad.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.AQP.ARn, Integer.valueOf(this.AQP.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.AQP.ARn).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(189679);
      return str1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(189679);
    }
    return "";
  }
  
  private static void jY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189681);
    paramString1 = aj.getContext().getAssets().open(paramString1);
    OutputStream localOutputStream = com.tencent.mm.vfs.i.cM(paramString2, false);
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
    AppMethodBeat.o(189681);
  }
  
  public final void AH()
  {
    AppMethodBeat.i(189675);
    if ((this.ARS == null) || (this.AQP == null))
    {
      ad.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
      AppMethodBeat.o(189675);
      return;
    }
    Object localObject = this.AQP;
    ad.v("MicroMsg.JsApiHandler", "jsapi init");
    if (((f)localObject).ARe == null) {
      ad.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
    }
    for (;;)
    {
      ad.i("MicroMsg.JsLoader", "jsapi init done");
      if (j.ekH()) {}
      try
      {
        localObject = new String(d.toByteArray(aj.getContext().getAssets().open("jsapi/vconsole.js")));
        if (this.ARS != null) {
          this.ARS.evaluateJavascript((String)localObject, null);
        }
        ad.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[] { Boolean.valueOf(this.ARV) });
        if ((this.ARV) && (this.ART != null)) {
          this.ART.ekG();
        }
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(156L, 1L, 1L, false);
        if (!this.ARV) {
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(156L, 0L, 1L, false);
        }
        AppMethodBeat.o(189675);
        return;
        ((f)localObject).ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:init", null, ((f)localObject).ARm, ((f)localObject).ARn) + ")", new f.23((f)localObject));
        ((f)localObject).ARe.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + l.a.b("sys:bridged", null, ((f)localObject).ARm, ((f)localObject).ARn) + ")", new f.33((f)localObject));
        ((f)localObject).yZR = true;
        ((f)localObject).ekp();
        if ((bt.isNullOrNil(((f)localObject).ARx)) || (((f)localObject).ARe == null)) {
          continue;
        }
        ((f)localObject).ARe.evaluateJavascript(((f)localObject).fc(((f)localObject).ARx, ((f)localObject).ARy), null);
        ((f)localObject).ARx = null;
        ((f)localObject).ARy = 0;
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
    AppMethodBeat.i(189674);
    ad.v("MicroMsg.JsLoader", "detach");
    this.ARS = null;
    this.AQP = null;
    this.ART = null;
    AppMethodBeat.o(189674);
  }
  
  public final void ekD()
  {
    AppMethodBeat.i(189676);
    if ((this.ARS == null) || (this.AQP == null))
    {
      ad.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(189676);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", "authorized");
    this.AQP.yZR = true;
    this.AQP.b("sys:auth", localHashMap, null);
    AppMethodBeat.o(189676);
  }
  
  public final void ekE()
  {
    AppMethodBeat.i(189677);
    ad.i("MicroMsg.JsLoader", "inject");
    if (this.ARU)
    {
      ad.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
      if (this.AQP != null) {
        this.AQP.yZR = true;
      }
    }
    for (final boolean bool1 = true;; bool1 = false)
    {
      this.ARV = bool1;
      AppMethodBeat.o(189677);
      return;
      if ((this.ARS != null) && (this.AQP != null)) {
        break;
      }
      ad.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
    }
    final long l1 = System.currentTimeMillis();
    bool1 = WebView.isX5();
    final boolean bool2 = this.ARS.isXWalkKernel();
    if (b(this.ARS))
    {
      String str = awb("jsapi/wxjs.js");
      if (str != null)
      {
        final long l2 = System.currentTimeMillis();
        if (l2 >= 0L)
        {
          a.aA(84, 1L);
          ae localae = new ae(3, 256, this.ARS);
          localae.mc(str, "path");
          this.ARS.evaluateJavascript(localae.toString(), new ValueCallback() {});
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      break;
      a.aA(82, 1L);
      this.ARS.evaluateJavascript(ekF(), new ValueCallback() {});
    }
  }
  
  public static abstract interface a
  {
    public abstract void ekG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.c.i
 * JD-Core Version:    0.7.0.1
 */