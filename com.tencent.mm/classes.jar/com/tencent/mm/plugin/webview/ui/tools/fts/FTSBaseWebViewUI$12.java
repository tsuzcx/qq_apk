package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import java.util.Map;

final class FTSBaseWebViewUI$12
  implements Runnable
{
  FTSBaseWebViewUI$12(FTSBaseWebViewUI paramFTSBaseWebViewUI, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(80591);
    if (this.CDb.Cjc != null) {
      this.CDb.Cjc.bx(this.BAd);
    }
    AppMethodBeat.o(80591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.12
 * JD-Core Version:    0.7.0.1
 */