package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class BaseWebViewController$ah
  implements Runnable
{
  BaseWebViewController$ah(BaseWebViewController paramBaseWebViewController, int paramInt, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(210493);
    Iterator localIterator = ((Iterable)this.CdS.Cdp).iterator();
    while (localIterator.hasNext()) {
      ((i)localIterator.next()).bk(this.jvZ, this.nKx);
    }
    AppMethodBeat.o(210493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.BaseWebViewController.ah
 * JD-Core Version:    0.7.0.1
 */