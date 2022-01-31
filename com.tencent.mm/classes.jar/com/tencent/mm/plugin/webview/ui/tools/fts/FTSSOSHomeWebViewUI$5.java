package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class FTSSOSHomeWebViewUI$5
  implements a.a
{
  FTSSOSHomeWebViewUI$5(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(8430);
    FTSSOSHomeWebViewUI.a(this.vkS).sendMessage(3);
    FTSSOSHomeWebViewUI.s(this.vkS);
    AppMethodBeat.o(8430);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(8431);
    FTSSOSHomeWebViewUI.t(this.vkS);
    AppMethodBeat.o(8431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */