package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;

final class FTSBaseWebViewUI$4
  implements Runnable
{
  FTSBaseWebViewUI$4(FTSBaseWebViewUI paramFTSBaseWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80584);
    if (this.CDb.Cjc != null) {
      this.CDb.Cjc.aBp(this.meg);
    }
    AppMethodBeat.o(80584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */