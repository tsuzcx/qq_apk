package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$15
  implements Runnable
{
  FTSBaseWebViewUI$15(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(210074);
    if (this.CDb.Cjc != null) {
      this.CDb.Cjc.a(this.CDb.getTotalQuery(), this.CDb.getInEditTextQuery(), this.CDb.eEZ(), 1);
    }
    AppMethodBeat.o(210074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.15
 * JD-Core Version:    0.7.0.1
 */