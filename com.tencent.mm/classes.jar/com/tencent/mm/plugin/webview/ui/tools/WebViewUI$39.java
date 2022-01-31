package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.d;

final class WebViewUI$39
  implements Runnable
{
  WebViewUI$39(WebViewUI paramWebViewUI, d paramd) {}
  
  public final void run()
  {
    if ((this.rpH.isFinishing()) || (this.rpH.roY))
    {
      y.i("MicroMsg.WebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
      return;
    }
    this.fnd.cfU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.39
 * JD-Core Version:    0.7.0.1
 */