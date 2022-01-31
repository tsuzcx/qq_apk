package com.tencent.mm.plugin.webview.ui.tools.fts;

import java.util.Iterator;
import java.util.List;

final class FTSSOSHomeWebViewUI$a$3
  implements Runnable
{
  FTSSOSHomeWebViewUI$a$3(FTSSOSHomeWebViewUI.a parama, List paramList) {}
  
  public final void run()
  {
    Iterator localIterator = this.ruI.iterator();
    while (localIterator.hasNext())
    {
      FTSSOSHomeWebViewUI.c localc = (FTSSOSHomeWebViewUI.c)localIterator.next();
      if (!FTSSOSHomeWebViewUI.a.a(this.ruJ).contains(localc)) {
        FTSSOSHomeWebViewUI.a.a(this.ruJ).add(localc);
      }
    }
    this.ruJ.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a.3
 * JD-Core Version:    0.7.0.1
 */