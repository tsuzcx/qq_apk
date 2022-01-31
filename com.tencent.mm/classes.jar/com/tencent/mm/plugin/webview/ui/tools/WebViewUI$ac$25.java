package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMFalseProgressBar;

final class WebViewUI$ac$25
  implements Runnable
{
  WebViewUI$ac$25(WebViewUI.ac paramac, int paramInt) {}
  
  public final void run()
  {
    this.rqr.rpH.setProgressBarIndeterminateVisibility(false);
    y.d("MicroMsg.WebViewUI", "[cpan] set title pb visibility:%d", new Object[] { Integer.valueOf(this.amW) });
    if (this.amW == 0)
    {
      if ((!WebViewUI.c(this.rqr.rpH)) && (!this.rqr.rpH.roN)) {
        this.rqr.rpH.rns.start();
      }
      return;
    }
    this.rqr.rpH.rns.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.25
 * JD-Core Version:    0.7.0.1
 */