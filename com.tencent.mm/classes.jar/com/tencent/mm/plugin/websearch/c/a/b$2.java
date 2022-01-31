package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class b$2
  implements l
{
  b$2(b paramb) {}
  
  public final void b(j paramj)
  {
    a locala = (a)paramj.kxg.kwb;
    if (locala == null) {}
    c.a locala1;
    do
    {
      return;
      locala1 = (c.a)this.qWd.hLB.remove(locala);
    } while (locala1 == null);
    switch (paramj.aYY)
    {
    }
    for (;;)
    {
      locala1.bZZ();
      return;
      if ((paramj.kxh == null) || (paramj.kxh.size() == 0))
      {
        y.i("FTSMatchContact", "local contact search size 0");
        locala1.bZZ();
        return;
      }
      locala.da(paramj.kxh);
      continue;
      locala.da(Collections.emptyList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.b.2
 * JD-Core Version:    0.7.0.1
 */