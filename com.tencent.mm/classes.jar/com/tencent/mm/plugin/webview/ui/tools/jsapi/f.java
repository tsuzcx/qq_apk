package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mm.plugin.webview.ui.tools.preload.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;

public final class f
{
  private static String ryk = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
  private com.tencent.mm.plugin.webview.stub.d gGn;
  private d rbk;
  private WebView rlh;
  public boolean rvc;
  private f.a ryf;
  private boolean ryg = false;
  public boolean ryh = false;
  public String ryi = null;
  private final am ryj = new am(new f.2(this), true);
  
  public f(WebView paramWebView, com.tencent.mm.plugin.webview.stub.d paramd, d paramd1, f.a parama, boolean paramBoolean)
  {
    this(paramWebView, paramd, paramd1, parama, paramBoolean, false);
  }
  
  public f(WebView paramWebView, com.tencent.mm.plugin.webview.stub.d paramd, d paramd1, f.a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.rlh = paramWebView;
    this.gGn = paramd;
    this.rbk = paramd1;
    this.ryf = parama;
    this.ryg = paramBoolean1;
    this.rvc = paramBoolean2;
    y.d("MicroMsg.JsLoader", "JsLoader <init>, withoutDelay = %b,isWebViewPreload %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  public f(WebView paramWebView, d paramd, f.a parama)
  {
    this(paramWebView, null, paramd, parama, true);
  }
  
  private String cgf()
  {
    for (;;)
    {
      try
      {
        localObject = this.gGn.f(98, null);
        if (localObject != null) {
          break label144;
        }
        i = 0;
      }
      catch (Exception localException1)
      {
        try
        {
          String str2 = bk.convertStreamToString(ae.getContext().getAssets().open((String)localObject));
          Object localObject = str2;
          if (!TextUtils.isEmpty(this.rbk.rxJ)) {
            localObject = str2.replace("__wx._getDgtVerifyRandomStr()", this.rbk.rxJ).replace("__wx._isDgtVerifyEnabled()", "true");
          }
          return localObject;
        }
        catch (Exception localException2)
        {
          String str1;
          y.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", new Object[] { localException2 });
          return "";
        }
        localException1 = localException1;
        i = 0;
        continue;
        str1 = "jsapi/wxjs_fallback.js";
        continue;
      }
      if ((this.rlh instanceof c)) {
        i = 1;
      }
      if (i != 0)
      {
        localObject = "jsapi/wxjs.js";
        y.i("MicroMsg.JsLoader", "WXJS: %s", new Object[] { localObject });
      }
      label144:
      int i = 1;
    }
  }
  
  public final void cfP()
  {
    y.v("MicroMsg.JsLoader", "onPageStarted");
    if (!this.ryj.crl())
    {
      this.ryj.stopTimer();
      y.i("MicroMsg.JsLoader", "tryStopTimer success");
    }
  }
  
  public final void cfQ()
  {
    y.v("MicroMsg.JsLoader", "onPageFinished");
    cgg();
  }
  
  public final void cgg()
  {
    if (this.ryj.crl())
    {
      am localam = this.ryj;
      if (this.ryg) {}
      for (long l = 0L;; l = 1000L)
      {
        localam.S(l, l);
        y.i("MicroMsg.JsLoader", "tryStartTimer success");
        return;
      }
    }
    y.i("MicroMsg.JsLoader", "timer running");
  }
  
  public final void detach()
  {
    y.v("MicroMsg.JsLoader", "detach");
    this.rlh = null;
    this.rbk = null;
    this.ryf = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f
 * JD-Core Version:    0.7.0.1
 */