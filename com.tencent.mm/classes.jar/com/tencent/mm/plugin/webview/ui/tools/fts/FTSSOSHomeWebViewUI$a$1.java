package com.tencent.mm.plugin.webview.ui.tools.fts;

import java.util.Iterator;
import java.util.List;

final class FTSSOSHomeWebViewUI$a$1
  implements Runnable
{
  FTSSOSHomeWebViewUI$a$1(FTSSOSHomeWebViewUI.a parama, List paramList) {}
  
  public final void run()
  {
    if (FTSSOSHomeWebViewUI.a.a(this.ruJ).size() > 0)
    {
      Iterator localIterator = FTSSOSHomeWebViewUI.a.a(this.ruJ).iterator();
      while (localIterator.hasNext())
      {
        FTSSOSHomeWebViewUI.c localc = (FTSSOSHomeWebViewUI.c)localIterator.next();
        if (!this.ruI.contains(localc)) {
          this.ruI.add(localc);
        }
      }
    }
    FTSSOSHomeWebViewUI.a.a(this.ruJ, this.ruI);
    this.ruJ.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a.1
 * JD-Core Version:    0.7.0.1
 */