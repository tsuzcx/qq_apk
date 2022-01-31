package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.CountDownLatch;

final class PreLoadWebViewUI$2
  implements Runnable
{
  PreLoadWebViewUI$2(PreLoadWebViewUI paramPreLoadWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8560);
    try
    {
      PreLoadWebViewUI.b(this.vlu).await();
      if (PreLoadWebViewUI.c(this.vlu))
      {
        ab.i("MicroMsg.WebSearch.PreLoadWebViewUI", "send onUiInit to webview");
        this.vlu.dfG();
        this.vlu.uQS.aL(this.vlu.dfS());
      }
      AppMethodBeat.o(8560);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WebSearch.PreLoadWebViewUI", localInterruptedException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI.2
 * JD-Core Version:    0.7.0.1
 */