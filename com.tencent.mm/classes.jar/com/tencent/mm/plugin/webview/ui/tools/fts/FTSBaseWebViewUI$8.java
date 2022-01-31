package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class FTSBaseWebViewUI$8
  implements Runnable
{
  FTSBaseWebViewUI$8(FTSBaseWebViewUI paramFTSBaseWebViewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(8390);
    if (this.vkg.uQS != null) {
      this.vkg.uQS.a(this.vkg.getTotalQuery(), this.vkg.getInEditTextQuery(), this.vkg.dfD(), 0);
    }
    AppMethodBeat.o(8390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.8
 * JD-Core Version:    0.7.0.1
 */