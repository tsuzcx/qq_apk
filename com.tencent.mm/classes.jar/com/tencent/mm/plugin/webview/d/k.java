package com.tencent.mm.plugin.webview.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.h.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.z;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ai;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.commons.a.d;

public final class k
{
  private static int POl;
  private static String POm;
  private static final String POn;
  private static String POo;
  private WebView POh;
  private a POi;
  private boolean POj;
  private boolean POk;
  public h PvJ;
  
  static
  {
    AppMethodBeat.i(206627);
    POl = -1;
    POm = null;
    POn = com.tencent.mm.loader.j.b.aSD() + "/jscache/";
    POo = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(206627);
  }
  
  public k(WebView paramWebView, h paramh, a parama)
  {
    this(paramWebView, paramh, parama, false);
  }
  
  public k(WebView paramWebView, h paramh, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(206605);
    this.POk = false;
    this.POh = paramWebView;
    this.PvJ = paramh;
    this.POi = parama;
    this.POj = paramBoolean;
    Log.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramh.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(206605);
  }
  
  private String bkh(String paramString)
  {
    AppMethodBeat.i(206620);
    Log.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (POm != null) {
      localObject = POm;
    }
    String str;
    for (;;)
    {
      str = POn + (String)localObject + "/" + paramString;
      if (!u.agG(str)) {
        break;
      }
      AppMethodBeat.o(206620);
      return str;
      localObject = BuildInfo.REV.substring(0, Math.min(BuildInfo.REV.length(), 8));
      POm = (String)localObject;
    }
    a.anX(86);
    Object localObject = new q(POn).b(new z()
    {
      public final boolean accept(q paramAnonymousq, String paramAnonymousString)
      {
        AppMethodBeat.i(205909);
        if (!paramAnonymousString.equals(this.tWk))
        {
          AppMethodBeat.o(205909);
          return true;
        }
        AppMethodBeat.o(205909);
        return false;
      }
    });
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        u.deleteDir(localObject[i].getPath());
        i += 1;
      }
    }
    u.bBD(u.bBT(str));
    try
    {
      my(paramString, str);
      a.anX(87);
      AppMethodBeat.o(206620);
      return str;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(206620);
    }
    return null;
  }
  
  public static boolean c(WebView paramWebView)
  {
    AppMethodBeat.i(206614);
    if (POl == -1) {
      POl = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vyM, 0);
    }
    if ((((POl & 0x1) != 0) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(206614);
      return true;
    }
    AppMethodBeat.o(206614);
    return false;
  }
  
  private String gUg()
  {
    AppMethodBeat.i(206617);
    Log.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(d.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.PvJ.EVx))
      {
        Log.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.PvJ.EVx, Integer.valueOf(this.PvJ.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.PvJ.EVx).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(206617);
      return str1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(206617);
    }
    return "";
  }
  
  private static void my(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206622);
    paramString1 = MMApplicationContext.getContext().getAssets().open(paramString1);
    OutputStream localOutputStream = u.Te(paramString2);
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
    AppMethodBeat.o(206622);
  }
  
  public final void NO()
  {
    AppMethodBeat.i(206607);
    if ((this.POh == null) || (this.PvJ == null))
    {
      Log.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
      AppMethodBeat.o(206607);
      return;
    }
    Object localObject = this.PvJ;
    Log.v("MicroMsg.JsApiHandler", "jsapi init");
    if (((h)localObject).PNp == null) {
      Log.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
    }
    for (;;)
    {
      Log.i("MicroMsg.JsLoader", "jsapi init done");
      if (l.gUi()) {}
      try
      {
        localObject = new String(d.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/vconsole.js")));
        if (this.POh != null) {
          this.POh.evaluateJavascript((String)localObject, null);
        }
        Log.i("MicroMsg.JsLoader", "onTimerExpired, js loaded ret = %b", new Object[] { Boolean.valueOf(this.POk) });
        if ((this.POk) && (this.POi != null)) {
          this.POi.gUh();
        }
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(156L, 1L, 1L, false);
        if (!this.POk) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(156L, 0L, 1L, false);
        }
        AppMethodBeat.o(206607);
        return;
        ((h)localObject).gTR();
        ((h)localObject).PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:init", null, ((h)localObject).PNx, ((h)localObject).EVx) + ")", new h.23((h)localObject));
        ((h)localObject).PNp.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:bridged", null, ((h)localObject).PNx, ((h)localObject).EVx) + ")", new h.33((h)localObject));
        ((h)localObject).CQ(true);
        ((h)localObject).gTS();
        if ((Util.isNullOrNil(((h)localObject).PNN)) || (((h)localObject).PNp == null)) {
          continue;
        }
        ((h)localObject).PNp.evaluateJavascript(((h)localObject).gX(((h)localObject).PNN, ((h)localObject).PNO), null);
        ((h)localObject).PNN = null;
        ((h)localObject).PNO = 0;
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
  
  public final void bkg(String paramString)
  {
    AppMethodBeat.i(206608);
    if ((this.POh == null) || (this.PvJ == null))
    {
      Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(206608);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("state", "authorized");
    if (paramString != null) {
      localHashMap.put("fullUrl", paramString);
    }
    this.PvJ.CQ(true);
    this.PvJ.b("sys:auth", localHashMap, null);
    AppMethodBeat.o(206608);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(206606);
    Log.v("MicroMsg.JsLoader", "detach");
    this.POh = null;
    this.PvJ = null;
    this.POi = null;
    AppMethodBeat.o(206606);
  }
  
  public final void gUe()
  {
    AppMethodBeat.i(206610);
    if ((this.POh == null) || (this.PvJ == null))
    {
      Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
      AppMethodBeat.o(206610);
      return;
    }
    Log.i("MicroMsg.JsLoader", "SPA-Trace, spaHistoryChanged");
    HashMap localHashMap = new HashMap();
    this.PvJ.b("sys:spa:historyChanged", localHashMap, null);
    AppMethodBeat.o(206610);
  }
  
  public final void gUf()
  {
    AppMethodBeat.i(206612);
    Log.i("MicroMsg.JsLoader", "inject");
    if (this.POj)
    {
      Log.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
      if (this.PvJ != null) {
        this.PvJ.CQ(true);
      }
    }
    for (final boolean bool1 = true;; bool1 = false)
    {
      this.POk = bool1;
      AppMethodBeat.o(206612);
      return;
      if ((this.POh != null) && (this.PvJ != null)) {
        break;
      }
      Log.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
    }
    this.PvJ.PNy = true;
    final long l1 = System.currentTimeMillis();
    bool1 = WebView.isX5();
    final boolean bool2 = this.POh.isXWalkKernel();
    if (c(this.POh))
    {
      String str = bkh("jsapi/wxjs.js");
      if (str != null)
      {
        final long l2 = System.currentTimeMillis();
        if (l2 >= 0L)
        {
          a.anX(84);
          ai localai = new ai(3, 256, this.POh);
          localai.oY(str, "path");
          this.POh.evaluateJavascript(localai.toString(), new ValueCallback() {});
        }
      }
    }
    for (;;)
    {
      this.PvJ.gTR();
      bool1 = true;
      break;
      a.anX(82);
      this.POh.evaluateJavascript(gUg(), new ValueCallback() {});
    }
  }
  
  public static abstract interface a
  {
    public abstract void gUh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.k
 * JD-Core Version:    0.7.0.1
 */