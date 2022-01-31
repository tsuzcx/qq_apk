package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(91368);
    a locala = (a)paramj.mSV.mRQ;
    if (locala == null)
    {
      AppMethodBeat.o(91368);
      return;
    }
    CountDownLatch localCountDownLatch = (CountDownLatch)this.uLp.uLm.remove(locala);
    switch (paramj.bpE)
    {
    }
    for (;;)
    {
      localCountDownLatch.countDown();
      AppMethodBeat.o(91368);
      return;
      if ((paramj.mSW == null) || (paramj.mSW.size() == 0))
      {
        ab.i("FTSMatchContact", "local contact search size 0");
        locala.ee(Collections.emptyList());
        localCountDownLatch.countDown();
        AppMethodBeat.o(91368);
        return;
      }
      locala.ee(paramj.mSW);
      continue;
      locala.ee(Collections.emptyList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.b.1
 * JD-Core Version:    0.7.0.1
 */