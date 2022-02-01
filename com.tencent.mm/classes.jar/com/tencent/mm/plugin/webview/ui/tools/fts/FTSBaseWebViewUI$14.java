package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$14
  implements Runnable
{
  FTSBaseWebViewUI$14(FTSBaseWebViewUI paramFTSBaseWebViewUI, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80593);
    if (this.CDb.Cjc != null) {
      this.CDb.Cjc.ct(this.oRg, this.jWh);
    }
    AppMethodBeat.o(80593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.14
 * JD-Core Version:    0.7.0.1
 */