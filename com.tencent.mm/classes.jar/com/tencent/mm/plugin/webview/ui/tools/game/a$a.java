package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;

final class a$a
  extends b
{
  public a$a(a parama, MMWebView paramMMWebView)
  {
    super(paramMMWebView);
  }
  
  protected final void TH(String paramString)
  {
    if (this.rwe.rwa.cjI())
    {
      this.dYF.loadUrl(paramString);
      return;
    }
    super.TH(paramString);
  }
  
  public final boolean TI(String paramString)
  {
    return super.TI(paramString);
  }
  
  protected final void TJ(String paramString)
  {
    try
    {
      y.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[] { paramString });
      this.rwe.MY.removeView(this.dYF);
      return;
    }
    catch (Exception paramString) {}
  }
  
  protected final boolean Tl(String paramString)
  {
    return this.rwe.rwa.UQ(paramString);
  }
  
  public final com.tencent.xweb.m a(WebView paramWebView, l paraml)
  {
    Object localObject;
    if ((paraml == null) || (paraml.getUrl() == null)) {
      localObject = super.a(paramWebView, paraml);
    }
    com.tencent.xweb.m localm;
    do
    {
      return localObject;
      localm = this.rwe.rwa.UP(paraml.getUrl().toString());
      localObject = localm;
    } while (localm != null);
    return super.a(paramWebView, paraml);
  }
  
  public final com.tencent.xweb.m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    Object localObject;
    if ((paraml == null) || (paraml.getUrl() == null)) {
      localObject = super.a(paramWebView, paraml);
    }
    com.tencent.xweb.m localm;
    do
    {
      return localObject;
      localm = this.rwe.rwa.UP(paraml.getUrl().toString());
      localObject = localm;
    } while (localm != null);
    return super.a(paramWebView, paraml, paramBundle);
  }
  
  protected final void a(com.tencent.mm.plugin.webview.stub.d paramd, com.tencent.mm.plugin.webview.ui.tools.f paramf)
  {
    this.rwe.rsT = paramd;
  }
  
  protected final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d paramd)
  {
    y.i("MicroMsg.GameFloatWebView", "jsapi ready");
    this.rwe.rvZ = paramd;
  }
  
  protected final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.f paramf)
  {
    y.i("MicroMsg.GameFloatWebView", "jsloader ready");
    this.rwe.rwc = paramf;
  }
  
  protected final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    y.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = " + paramString);
    this.rwe.kMB.rwj.cfP();
    this.rwe.rwa.g(paramWebView, paramString);
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.widget.m all()
  {
    return this.rwe.rwd;
  }
  
  public final com.tencent.xweb.m c(WebView paramWebView, String paramString)
  {
    com.tencent.xweb.m localm = this.rwe.rwa.UP(paramString);
    if (localm != null) {
      return localm;
    }
    return super.c(paramWebView, paramString);
  }
  
  protected final void cfN()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.dYF.removeJavascriptInterface("MicroMsg");
      this.dYF.removeJavascriptInterface("JsApi");
    }
    try
    {
      this.dYF.setWebChromeClient(null);
      this.dYF.setWebViewClient(null);
      this.dYF.setOnTouchListener(null);
      this.dYF.setOnLongClickListener(null);
      this.dYF.setVisibility(8);
      this.dYF.removeAllViews();
      this.dYF.clearView();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.dYF.destroy();
          return;
        }
        catch (Exception localException2)
        {
          y.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[] { localException2.getMessage() });
        }
        localException1 = localException1;
        y.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[] { localException1.getMessage() });
      }
    }
  }
  
  protected final void e(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s", new Object[] { paramString });
    this.dYF.setVisibility(0);
    this.rwe.rwa.h(paramWebView, paramString);
    this.rwe.kMB.rwj.cfQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.a.a
 * JD-Core Version:    0.7.0.1
 */