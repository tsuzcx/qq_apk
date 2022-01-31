package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class FTSSOSHomeWebViewUI$a$4
  implements Runnable
{
  FTSSOSHomeWebViewUI$a$4(FTSSOSHomeWebViewUI.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(8451);
    FTSSOSHomeWebViewUI.a.a(this.vkY).clear();
    this.vkY.notifyDataSetChanged();
    AppMethodBeat.o(8451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a.4
 * JD-Core Version:    0.7.0.1
 */