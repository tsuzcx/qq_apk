package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$1
  implements com.tencent.mm.plugin.fts.a.l
{
  b$1(b paramb) {}
  
  public final void b(j paramj)
  {
    b.f localf = (b.f)paramj.ktu;
    y.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", new Object[] { Integer.valueOf(paramj.aYY), Integer.valueOf(localf.qZt) });
    if (paramj.aYY == 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramj.kxh.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.fts.a.a.l)localIterator.next()).content);
      }
      ai.d(new b.1.1(this, localf, paramj, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.1
 * JD-Core Version:    0.7.0.1
 */