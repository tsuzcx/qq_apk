package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.plugin.fts.ui.widget.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

final class FTSBaseWebViewUI$b
  extends PreLoadWebViewUI.a
{
  private FTSBaseWebViewUI$b(FTSBaseWebViewUI paramFTSBaseWebViewUI)
  {
    super(paramFTSBaseWebViewUI);
  }
  
  private static m TE(String paramString)
  {
    m localm = null;
    y.i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = e.openRead(paramString.getQueryParameter("path"));
      if (paramString != null) {
        localm = new m("image/*", "utf8", paramString);
      }
      return localm;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public final m a(WebView paramWebView, l paraml)
  {
    if ((paraml != null) && (paraml.getUrl() != null) && (paraml.getUrl().toString().startsWith("weixin://fts")))
    {
      m localm = TE(paraml.getUrl().toString());
      if (localm != null) {
        return localm;
      }
    }
    return super.a(paramWebView, paraml);
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    if ((paraml != null) && (paraml.getUrl() != null) && (paraml.getUrl().toString().startsWith("weixin://fts")))
    {
      paramBundle = TE(paraml.getUrl().toString());
      if (paramBundle != null) {
        return paramBundle;
      }
    }
    return super.a(paramWebView, paraml);
  }
  
  public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if ((paramString2 != null) && (paramString2.equals(this.rtV.caS))) {
      ao.reportIdKey649ForLook(FTSBaseWebViewUI.g(this.rtV), 16);
    }
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    y.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageFinished %s", new Object[] { paramString });
    this.rtV.showOptionMenu(false);
    if ((FTSBaseWebViewUI.i(this.rtV) != null) && (!FTSBaseWebViewUI.j(this.rtV)))
    {
      FTSBaseWebViewUI.cfs();
      FTSBaseWebViewUI.i(this.rtV).getFtsEditText().kEp.clearFocus();
      this.rtV.XM();
    }
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.b(paramWebView, paramString, paramBitmap);
    y.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageStarted %s", new Object[] { paramString });
    this.rtV.showOptionMenu(false);
    if ((FTSBaseWebViewUI.i(this.rtV) != null) && (!FTSBaseWebViewUI.j(this.rtV)))
    {
      FTSBaseWebViewUI.cft();
      FTSBaseWebViewUI.i(this.rtV).getFtsEditText().kEp.clearFocus();
      this.rtV.XM();
    }
    ao.reportIdKey649ForLook(FTSBaseWebViewUI.g(this.rtV), 1);
    ao.eB(FTSBaseWebViewUI.g(this.rtV), 1);
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith("weixin://fts"))
    {
      m localm = TE(paramString);
      if (localm != null) {
        return localm;
      }
    }
    return super.c(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */