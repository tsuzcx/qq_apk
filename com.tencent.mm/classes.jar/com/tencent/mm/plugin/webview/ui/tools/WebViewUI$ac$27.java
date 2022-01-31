package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;

final class WebViewUI$ac$27
  implements Runnable
{
  WebViewUI$ac$27(WebViewUI.ac paramac, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    if (this.rqA)
    {
      if ((this.rqr.rpH.niQ != null) && (!bk.bl(this.rqr.rpH.niQ.getUrl()))) {
        WebViewUI.e(this.rqr.rpH).put(this.rqr.rpH.niQ.getUrl(), Boolean.valueOf(false));
      }
      this.rqr.rpH.lj(false);
      return;
    }
    if ((this.rqr.rpH.niQ != null) && (!bk.bl(this.rqr.rpH.niQ.getUrl()))) {
      WebViewUI.e(this.rqr.rpH).put(this.rqr.rpH.niQ.getUrl(), Boolean.valueOf(this.gUd));
    }
    this.rqr.rpH.lj(this.gUd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.27
 * JD-Core Version:    0.7.0.1
 */