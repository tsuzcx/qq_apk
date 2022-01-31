package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class FTSBaseWebViewUI$6
  implements Runnable
{
  FTSBaseWebViewUI$6(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8389);
    if (this.vkg.uQS != null) {
      this.vkg.uQS.a(this.vkg.getTotalQuery(), this.vkg.getInEditTextQuery(), this.vkg.dfD(), 1);
    }
    AppMethodBeat.o(8389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */