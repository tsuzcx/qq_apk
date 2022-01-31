package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSSOSHomeWebViewUI$3
  implements a.a
{
  FTSSOSHomeWebViewUI$3(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(153287);
    FTSSOSHomeWebViewUI.a(this.vkS).sendMessage(4);
    FTSSOSHomeWebViewUI.s(this.vkS);
    AppMethodBeat.o(153287);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(153288);
    FTSSOSHomeWebViewUI.t(this.vkS);
    AppMethodBeat.o(153288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.3
 * JD-Core Version:    0.7.0.1
 */