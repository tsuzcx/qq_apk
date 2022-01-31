package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements com.tencent.mm.plugin.fts.a.l
{
  b$1(b paramb) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(5673);
    b.f localf = (b.f)paramj.mPi;
    ab.i("MicroMsg.WebSearch.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", new Object[] { Integer.valueOf(paramj.bpE), Integer.valueOf(localf.uOY) });
    if (paramj.bpE == 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramj.mSW.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.fts.a.a.l)localIterator.next()).content);
      }
      al.d(new b.1.1(this, localf, paramj, localArrayList));
    }
    AppMethodBeat.o(5673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.1
 * JD-Core Version:    0.7.0.1
 */