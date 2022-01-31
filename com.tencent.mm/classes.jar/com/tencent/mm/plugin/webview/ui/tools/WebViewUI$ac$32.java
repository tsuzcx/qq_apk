package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;

final class WebViewUI$ac$32
  implements Runnable
{
  WebViewUI$ac$32(WebViewUI.ac paramac, String paramString) {}
  
  public final void run()
  {
    if (!bk.bl(this.rqr.rpH.niQ.getUrl()))
    {
      y.i("MicroMsg.WebViewUI", "setPageOwner, userName = " + this.egy);
      WebViewUI.h(this.rqr.rpH).put(this.rqr.rpH.niQ.getUrl(), this.egy);
      return;
    }
    y.i("MicroMsg.WebViewUI", "setPageOwner, null url");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.32
 * JD-Core Version:    0.7.0.1
 */