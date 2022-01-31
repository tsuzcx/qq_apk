package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.a.c;

public final class f
{
  private static int vpd;
  private static String vpe;
  private static final String vpf;
  private static String vph;
  private com.tencent.mm.plugin.webview.stub.d igU;
  private d uQS;
  private WebView vaK;
  public boolean vlr;
  private f.a voZ;
  private boolean vpa;
  public boolean vpb;
  public String vpc;
  private final ap vpg;
  
  static
  {
    AppMethodBeat.i(9036);
    vpd = -1;
    vpe = null;
    vpf = b.eQv + "/jscache/";
    vph = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    AppMethodBeat.o(9036);
  }
  
  public f(WebView paramWebView, com.tencent.mm.plugin.webview.stub.d paramd, d paramd1, f.a parama, boolean paramBoolean)
  {
    this(paramWebView, paramd, paramd1, parama, paramBoolean, false);
  }
  
  public f(WebView paramWebView, com.tencent.mm.plugin.webview.stub.d paramd, d paramd1, f.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(9024);
    this.vpa = false;
    this.vpb = false;
    this.vpc = null;
    this.vpg = new ap(new f.4(this), true);
    this.vaK = paramWebView;
    this.igU = paramd;
    this.uQS = paramd1;
    this.voZ = parama;
    this.vpa = paramBoolean1;
    this.vlr = paramBoolean2;
    ab.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b,isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    ab.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", new Object[] { Integer.valueOf(paramd1.hashCode()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(9024);
  }
  
  public f(WebView paramWebView, d paramd, f.a parama)
  {
    this(paramWebView, null, paramd, parama, true);
  }
  
  private String ajd(String paramString)
  {
    AppMethodBeat.i(9030);
    ab.i("MicroMsg.JsLoader", "tryCopyAsset: %s", new Object[] { paramString });
    if (vpe != null) {
      localObject = vpe;
    }
    String str;
    for (;;)
    {
      str = vpf + (String)localObject + "/" + paramString;
      if (!e.cN(str)) {
        break;
      }
      AppMethodBeat.o(9030);
      return str;
      localObject = com.tencent.mm.sdk.platformtools.f.REV.substring(0, Math.min(com.tencent.mm.sdk.platformtools.f.REV.length(), 8));
      vpe = (String)localObject;
    }
    com.tencent.mm.plugin.webview.preload.a.ai(86, 1L);
    Object localObject = new File(vpf).listFiles(new f.3(this, (String)localObject));
    if ((localObject != null) && (localObject.length > 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        e.o(localObject[i]);
        i += 1;
      }
    }
    e.cR(str);
    try
    {
      hC(paramString, str);
      com.tencent.mm.plugin.webview.preload.a.ai(87, 1L);
      AppMethodBeat.o(9030);
      return str;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", new Object[] { paramString });
      AppMethodBeat.o(9030);
    }
    return null;
  }
  
  public static boolean c(WebView paramWebView)
  {
    AppMethodBeat.i(9028);
    if (vpd == -1) {
      vpd = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lUj, 0);
    }
    if ((((vpd & 0x1) != 0) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.DEBUG)) && (paramWebView.supportFeature(2002)))
    {
      AppMethodBeat.o(9028);
      return true;
    }
    AppMethodBeat.o(9028);
    return false;
  }
  
  private String dgs()
  {
    AppMethodBeat.i(9029);
    ab.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { "jsapi/wxjs.js" });
    try
    {
      String str2 = new String(c.toByteArray(ah.getContext().getAssets().open("jsapi/wxjs.js")));
      String str1 = str2;
      if (!TextUtils.isEmpty(this.uQS.voC))
      {
        ab.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", new Object[] { this.uQS.voC, Integer.valueOf(this.uQS.hashCode()), Integer.valueOf(hashCode()) });
        str1 = str2.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.uQS.voC).replaceFirst("\\$\\{dgtVerifyEnabled\\}", "true");
      }
      AppMethodBeat.o(9029);
      return str1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException });
      AppMethodBeat.o(9029);
    }
    return "";
  }
  
  private void dgu()
  {
    AppMethodBeat.i(9033);
    if (!this.vpg.dtj())
    {
      this.vpg.stopTimer();
      ab.i("MicroMsg.JsLoader", "tryStopTimer success");
    }
    AppMethodBeat.o(9033);
  }
  
  private static void hC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9031);
    paramString1 = ah.getContext().getAssets().open(paramString1);
    FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramString1.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      localFileOutputStream.write(arrayOfByte, 0, i);
    }
    paramString1.close();
    localFileOutputStream.close();
    ab.i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(9031);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(9025);
    ab.v("MicroMsg.JsLoader", "detach");
    this.vaK = null;
    this.uQS = null;
    this.voZ = null;
    AppMethodBeat.o(9025);
  }
  
  public final void dgb()
  {
    AppMethodBeat.i(9026);
    ab.v("MicroMsg.JsLoader", "onPageStarted");
    dgu();
    if (this.uQS != null) {
      this.uQS.oC(false);
    }
    AppMethodBeat.o(9026);
  }
  
  public final void dgr()
  {
    this.vlr = false;
  }
  
  public final void dgt()
  {
    AppMethodBeat.i(9032);
    if ((!this.vpg.dtj()) || (!this.vpa)) {}
    try
    {
      if (this.igU.i(106, null) != null) {
        this.vpa = true;
      }
      label43:
      ap localap = this.vpg;
      if (this.vpa) {}
      for (long l = 0L;; l = 1000L)
      {
        localap.ag(l, l);
        ab.i("MicroMsg.JsLoader", "tryStartTimer success %b", new Object[] { Boolean.valueOf(this.vpa) });
        AppMethodBeat.o(9032);
        return;
      }
      ab.i("MicroMsg.JsLoader", "timer running");
      AppMethodBeat.o(9032);
      return;
    }
    catch (Exception localException)
    {
      break label43;
    }
  }
  
  public final void uG()
  {
    AppMethodBeat.i(9027);
    ab.v("MicroMsg.JsLoader", "onPageFinished");
    dgt();
    AppMethodBeat.o(9027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f
 * JD-Core Version:    0.7.0.1
 */