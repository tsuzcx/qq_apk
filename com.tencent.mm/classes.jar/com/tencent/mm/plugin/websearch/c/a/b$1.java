package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class b$1
  implements l
{
  b$1(b paramb) {}
  
  public final void b(j paramj)
  {
    a locala = (a)paramj.kxg.kwb;
    if (locala == null) {
      return;
    }
    CountDownLatch localCountDownLatch = (CountDownLatch)this.qWd.qWa.remove(locala);
    switch (paramj.aYY)
    {
    }
    for (;;)
    {
      localCountDownLatch.countDown();
      return;
      if ((paramj.kxh == null) || (paramj.kxh.size() == 0))
      {
        y.i("FTSMatchContact", "local contact search size 0");
        locala.da(Collections.emptyList());
        localCountDownLatch.countDown();
        return;
      }
      locala.da(paramj.kxh);
      continue;
      locala.da(Collections.emptyList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.b.1
 * JD-Core Version:    0.7.0.1
 */