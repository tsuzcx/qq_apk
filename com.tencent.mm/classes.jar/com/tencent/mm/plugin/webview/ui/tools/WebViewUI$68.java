package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class WebViewUI$68
  implements a.b
{
  WebViewUI$68(WebViewUI paramWebViewUI) {}
  
  public final void amw()
  {
    try
    {
      this.rpH.gGn.favEditTag();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.68
 * JD-Core Version:    0.7.0.1
 */