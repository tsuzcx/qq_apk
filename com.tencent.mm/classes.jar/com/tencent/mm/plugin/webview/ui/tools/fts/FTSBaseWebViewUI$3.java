package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$3
  implements Runnable
{
  FTSBaseWebViewUI$3(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(80583);
    if (this.CDb.Cjc != null) {
      this.CDb.Cjc.a(this.CDb.getTotalQuery(), this.CDb.getInEditTextQuery(), this.CDb.eEZ(), 0);
    }
    AppMethodBeat.o(80583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */