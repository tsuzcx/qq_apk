package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.pluginsdk.ui.tools.s.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$29$1
  implements s.a
{
  WebViewUI$29$1(WebViewUI.29 param29) {}
  
  public final void uK(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.WebViewUI", "share image to friend fail, imgPath is null");
      return;
    }
    WebViewUI.e(this.rqa.rpH, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.29.1
 * JD-Core Version:    0.7.0.1
 */