package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.ui.widget.a.c;

final class WebViewUI$ac$47
  implements Runnable
{
  WebViewUI$ac$47(WebViewUI.ac paramac) {}
  
  public final void run()
  {
    if ((WebViewUI.s(this.rqr.rpH) != null) && (WebViewUI.s(this.rqr.rpH).isShowing())) {
      WebViewUI.s(this.rqr.rpH).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.47
 * JD-Core Version:    0.7.0.1
 */