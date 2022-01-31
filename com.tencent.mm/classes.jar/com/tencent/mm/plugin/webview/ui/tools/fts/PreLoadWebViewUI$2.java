package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;

final class PreLoadWebViewUI$2
  implements Runnable
{
  PreLoadWebViewUI$2(PreLoadWebViewUI paramPreLoadWebViewUI) {}
  
  public final void run()
  {
    try
    {
      PreLoadWebViewUI.b(this.rvf).await();
      if (PreLoadWebViewUI.c(this.rvf))
      {
        y.i("PreLoadWebViewUI", "send onUiInit to webview");
        this.rvf.cfy();
        PreLoadWebViewUI.d(this.rvf).am(this.rvf.cfJ());
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        y.printErrStackTrace("PreLoadWebViewUI", localInterruptedException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */