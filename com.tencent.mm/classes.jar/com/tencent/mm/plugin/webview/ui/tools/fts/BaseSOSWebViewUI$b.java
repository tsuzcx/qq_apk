package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

final class BaseSOSWebViewUI$b
  extends LoadDataWebviewUI.a
{
  private BaseSOSWebViewUI$b(BaseSOSWebViewUI paramBaseSOSWebViewUI)
  {
    super(paramBaseSOSWebViewUI);
  }
  
  private static m TE(String paramString)
  {
    m localm = null;
    y.i("MicroMsg.FTS.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
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
  
  public final void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    y.i("MicroMsg.FTS.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[] { Integer.valueOf(this.rtA.scene), paramString });
    this.rtA.showOptionMenu(false);
    if ((this.rtA.rtt != null) && (!BaseSOSWebViewUI.l(this.rtA)))
    {
      BaseSOSWebViewUI.cfs();
      this.rtA.rtt.kEp.clearFocus();
      this.rtA.XM();
    }
    BaseSOSWebViewUI.m(this.rtA);
    this.rtA.cfo();
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.b(paramWebView, paramString, paramBitmap);
    y.i("MicroMsg.FTS.BaseSOSWebViewUI", "onPageStarted %s", new Object[] { paramString });
    this.rtA.showOptionMenu(false);
    if ((this.rtA.rtt != null) && (!BaseSOSWebViewUI.l(this.rtA)))
    {
      BaseSOSWebViewUI.cft();
      this.rtA.rtt.kEp.clearFocus();
      this.rtA.XM();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */