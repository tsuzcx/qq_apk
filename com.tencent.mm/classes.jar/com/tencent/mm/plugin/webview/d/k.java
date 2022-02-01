package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.h.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.aa;
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

public final class k
{
  private static int IRV;
  private static String IRW;
  private static final String IRX;
  private static String IRY;
  public h IBw;
  private WebView IRR;
  private a IRS;
  private boolean IRT;
  private boolean IRU;
  
  static
  {
    AppMethodBeat.i(224419);
    IRV = -1;
    IRW = null;
    IRX = com.tencent.mm.loader.j.b.aKB() + "/jscache/";
    IRY = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(224419);
  }
  
  public k(WebView paramWebView, h paramh, a parama)
  {
    this(paramWebView, paramh, parama, false);
  }
  
  public k(WebView paramWebView, h paramh, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(224409);
    this.IRU = false;
    this.IRR = paramWebView;
    this.IBw = paramh;
    this.IRS = parama;
    this.IRT = paramBoolean;
    Log.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramh.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(224409);
  }
  
  private String aYm(String paramString)
  {
    AppMethodBeat.i(224417);
    Log.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (IRW != null) {
      localObject = IRW;
    }
    String str;
    for (;;)
    {
      str = IRX + (String)localObject + "/" + paramString;
      if (!s.YS(str)) {
        break;
      }
      AppMethodBeat.o(224417);
      return str;
      localObject = BuildInfo.REV.substring(0, Math.min(BuildInfo.REV.length(), 8));
      IRW = (String)localObject;
    }
    a.agi(86);
    Object localObject = new o(IRX).b(new w()
    {
      public final boolean accept(o paramAnonymouso, String paramAnonymousString)
      {
        AppMethodBeat.i(224408);
        if (!paramAnonymousString.equals(this.qxk))
        {
          AppMethodBeat.o(224408);
          return true;
        }
        AppMethodBeat.o(224408);
        return false;
      }
    });
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        s.dy(aa.z(localObject[i].mUri), true);
        i += 1;
      }
    }
    s.boN(s.boZ(str));
    try
    {
      lX(paramString, str);
      a.agi(87);
      AppMethodBeat.o(224417);
      return str;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(224417);
    }
    return null;
  }
  
  public static boolean b(WebView paramWebView)
  {
    AppMethodBeat.i(224415);
    if (IRV == -1) {
      IRV = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rSn, 0);
    }
    if ((((IRV & 0x1) != 0) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(224415);
      return true;
    }
    AppMethodBeat.o(224415);
    return false;
  }
  
  private String gbm()
  {
    AppMethodBeat.i(224416);
    Log.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(e.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.IBw.zpY))
      {
        Log.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.IBw.zpY, Integer.valueOf(this.IBw.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.IBw.zpY).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(224416);
      return str1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(224416);
    }
    return "";
  }
  
  private static void lX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224418);
    paramString1 = MMApplicationContext.getContext().getAssets().open(paramString1);
    OutputStream localOutputStream = s.dw(paramString2, false);
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
    AppMethodBeat.o(224418);
  }
  
  public final void KY()
  {
    AppMethodBeat.i(224411);
    if ((this.IRR == null) || (this.IBw == null))
    {
      Log.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
      AppMethodBeat.o(224411);
      return;
    }
    Object localObject = this.IBw;
    Log.v("MicroMsg.JsApiHandler", "jsapi init");
    if (((h)localObject).IRa == null) {
      Log.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
    }
    for (;;)
    {
      Log.i("MicroMsg.JsLoader", "jsapi init done");
      if (l.gbo()) {}
      try
      {
        localObject = new String(e.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/vconsole.js")));
        if (this.IRR != null) {
          this.IRR.evaluateJavascript((String)localObject, null);
        }
        Log.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[] { Boolean.valueOf(this.IRU) });
        if ((this.IRU) && (this.IRS != null)) {
          this.IRS.gbn();
        }
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(156L, 1L, 1L, false);
        if (!this.IRU) {
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(156L, 0L, 1L, false);
        }
        AppMethodBeat.o(224411);
        return;
        ((h)localObject).gaX();
        ((h)localObject).IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:init", null, ((h)localObject).IRj, ((h)localObject).zpY) + ")", new h.23((h)localObject));
        ((h)localObject).IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:bridged", null, ((h)localObject).IRj, ((h)localObject).zpY) + ")", new h.33((h)localObject));
        ((h)localObject).yV(true);
        ((h)localObject).gaY();
        if ((Util.isNullOrNil(((h)localObject).IRx)) || (((h)localObject).IRa == null)) {
          continue;
        }
        ((h)localObject).IRa.evaluateJavascript(((h)localObject).gp(((h)localObject).IRx, ((h)localObject).IRy), null);
        ((h)localObject).IRx = null;
        ((h)localObject).IRy = 0;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.JsLoader", localIOException, "openVConsole", new Object[0]);
        }
      }
    }
  }
  
  public final void aYl(String paramString)
  {
    AppMethodBeat.i(224412);
    if ((this.IRR == null) || (this.IBw == null))
    {
      Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(224412);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", "authorized");
    if (paramString != null) {
      localHashMap.put("fullUrl", paramString);
    }
    this.IBw.yV(true);
    this.IBw.b("sys:auth", localHashMap, null);
    AppMethodBeat.o(224412);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(224410);
    Log.v("MicroMsg.JsLoader", "detach");
    this.IRR = null;
    this.IBw = null;
    this.IRS = null;
    AppMethodBeat.o(224410);
  }
  
  public final void gbk()
  {
    AppMethodBeat.i(224413);
    if ((this.IRR == null) || (this.IBw == null))
    {
      Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(224413);
      return;
    }
    Log.i("MicroMsg.JsLoader", "SPA-Trace, spaHistoryChanged");
    HashMap localHashMap = new HashMap();
    this.IBw.b("sys:spa:historyChanged", localHashMap, null);
    AppMethodBeat.o(224413);
  }
  
  public final void gbl()
  {
    AppMethodBeat.i(224414);
    Log.i("MicroMsg.JsLoader", "inject");
    if (this.IRT)
    {
      Log.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
      if (this.IBw != null) {
        this.IBw.yV(true);
      }
    }
    for (final boolean bool1 = true;; bool1 = false)
    {
      this.IRU = bool1;
      AppMethodBeat.o(224414);
      return;
      if ((this.IRR != null) && (this.IBw != null)) {
        break;
      }
      Log.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
    }
    this.IBw.IRk = true;
    final long l1 = System.currentTimeMillis();
    bool1 = WebView.isX5();
    final boolean bool2 = this.IRR.isXWalkKernel();
    if (b(this.IRR))
    {
      String str = aYm("jsapi/wxjs.js");
      if (str != null)
      {
        final long l2 = System.currentTimeMillis();
        if (l2 >= 0L)
        {
          a.agi(84);
          ag localag = new ag(3, 256, this.IRR);
          localag.oc(str, "path");
          this.IRR.evaluateJavascript(localag.toString(), new ValueCallback() {});
        }
      }
    }
    for (;;)
    {
      this.IBw.gaX();
      bool1 = true;
      break;
      a.agi(82);
      this.IRR.evaluateJavascript(gbm(), new ValueCallback() {});
    }
  }
  
  public static abstract interface a
  {
    public abstract void gbn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.k
 * JD-Core Version:    0.7.0.1
 */