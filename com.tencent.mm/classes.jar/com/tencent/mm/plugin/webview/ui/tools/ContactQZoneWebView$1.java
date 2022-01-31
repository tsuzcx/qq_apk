package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

final class ContactQZoneWebView$1
  extends p
{
  ContactQZoneWebView$1(ContactQZoneWebView paramContactQZoneWebView) {}
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (paramString.startsWith("weixin://viewimage/"))
    {
      this.rkF.SX(paramString);
      paramWebView.stopLoading();
      return;
    }
    if (paramString.equals(ContactQZoneWebView.a(this.rkF)))
    {
      bk.I(this.rkF, paramString);
      paramWebView.stopLoading();
      return;
    }
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith("weixin://viewimage/"))
    {
      this.rkF.SX(paramString);
      paramWebView.stopLoading();
    }
    while ((paramString.startsWith("weixinping://iframe")) || (paramString.startsWith("weixinpreinject://iframe"))) {
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView.1
 * JD-Core Version:    0.7.0.1
 */