package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSSOSHomeWebViewUI$4
  implements a.a
{
  FTSSOSHomeWebViewUI$4(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(8428);
    FTSSOSHomeWebViewUI.a(this.vkS).sendMessage(9);
    FTSSOSHomeWebViewUI.s(this.vkS);
    AppMethodBeat.o(8428);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(8429);
    FTSSOSHomeWebViewUI.t(this.vkS);
    AppMethodBeat.o(8429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */