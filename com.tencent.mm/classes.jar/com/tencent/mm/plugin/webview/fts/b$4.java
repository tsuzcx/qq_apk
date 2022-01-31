package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$4
  implements com.tencent.mm.plugin.fts.a.l
{
  b$4(b paramb) {}
  
  public final void b(j paramj)
  {
    if (paramj.aYY == 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramj.kxh.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((com.tencent.mm.plugin.fts.a.a.l)localIterator.next()).content);
      }
      ai.d(new b.4.1(this, paramj, localArrayList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.4
 * JD-Core Version:    0.7.0.1
 */