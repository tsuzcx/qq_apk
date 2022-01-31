package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;

final class WebViewUI$33
  implements h.c
{
  WebViewUI$33(WebViewUI paramWebViewUI, String paramString) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (!WebViewUI.g(this.rpH, this.val$url))
      {
        y.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + this.val$url);
        WebViewUI.P(this.rpH);
        return;
      }
      this.rpH.b(this.val$url, null, false);
      return;
    }
    a.a(this.rpH.getApplicationContext(), this.val$url, this.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.33
 * JD-Core Version:    0.7.0.1
 */