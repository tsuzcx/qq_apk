package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class FTSSOSHomeWebViewUI$1
  implements KeyboardLinearLayout.a
{
  FTSSOSHomeWebViewUI$1(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final void sJ(int paramInt)
  {
    AppMethodBeat.i(153286);
    if (FTSSOSHomeWebViewUI.a(this.vkS) == null)
    {
      AppMethodBeat.o(153286);
      return;
    }
    if (paramInt == -2) {
      FTSSOSHomeWebViewUI.a(this.vkS).sendMessage(12);
    }
    FTSSOSHomeWebViewUI.a(this.vkS, paramInt);
    AppMethodBeat.o(153286);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */