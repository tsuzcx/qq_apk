package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$5
  implements Runnable
{
  FTSBaseWebViewUI$5(FTSBaseWebViewUI paramFTSBaseWebViewUI, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(80585);
    if (this.CDb.Cjc != null) {
      this.CDb.Cjc.fl(this.CCE, this.hXk);
    }
    AppMethodBeat.o(80585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */