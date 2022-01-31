package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class FTSSOSHomeWebViewUI$a$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$a$1(FTSSOSHomeWebViewUI.a parama, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(8448);
    if (FTSSOSHomeWebViewUI.a.a(this.vkY).size() > 0)
    {
      Iterator localIterator = FTSSOSHomeWebViewUI.a.a(this.vkY).iterator();
      while (localIterator.hasNext())
      {
        FTSSOSHomeWebViewUI.c localc = (FTSSOSHomeWebViewUI.c)localIterator.next();
        if (!this.vkX.contains(localc)) {
          this.vkX.add(localc);
        }
      }
    }
    FTSSOSHomeWebViewUI.a.a(this.vkY, this.vkX);
    this.vkY.notifyDataSetChanged();
    AppMethodBeat.o(8448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a.1
 * JD-Core Version:    0.7.0.1
 */