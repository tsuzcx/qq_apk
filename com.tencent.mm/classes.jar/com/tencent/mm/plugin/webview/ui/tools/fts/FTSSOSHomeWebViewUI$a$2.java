package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class FTSSOSHomeWebViewUI$a$2
  implements Runnable
{
  FTSSOSHomeWebViewUI$a$2(FTSSOSHomeWebViewUI.a parama, FTSSOSHomeWebViewUI.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(8449);
    FTSSOSHomeWebViewUI.a.a(this.vkY).remove(this.vkZ);
    this.vkY.notifyDataSetChanged();
    AppMethodBeat.o(8449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a.2
 * JD-Core Version:    0.7.0.1
 */