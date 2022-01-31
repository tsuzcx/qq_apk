package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;

final class ContactQZoneWebView$1
  extends w
{
  ContactQZoneWebView$1(ContactQZoneWebView paramContactQZoneWebView) {}
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(7348);
    if (paramString.startsWith("weixin://viewimage/"))
    {
      this.vab.ahZ(paramString);
      paramWebView.stopLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(7348);
      return true;
      if ((paramString.startsWith("weixinping://iframe")) || (paramString.startsWith("weixinpreinject://iframe")))
      {
        AppMethodBeat.o(7348);
        return true;
      }
      paramWebView.loadUrl(paramString);
    }
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(7349);
    if (paramString.startsWith("weixin://viewimage/"))
    {
      this.vab.ahZ(paramString);
      paramWebView.stopLoading();
      AppMethodBeat.o(7349);
      return;
    }
    if (paramString.equals(ContactQZoneWebView.a(this.vab)))
    {
      bo.M(this.vab, paramString);
      paramWebView.stopLoading();
      AppMethodBeat.o(7349);
      return;
    }
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(7349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.ContactQZoneWebView.1
 * JD-Core Version:    0.7.0.1
 */