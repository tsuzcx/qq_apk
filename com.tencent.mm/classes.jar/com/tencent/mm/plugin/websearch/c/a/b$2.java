package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class b$2
  implements l
{
  b$2(b paramb) {}
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(91369);
    a locala = (a)paramj.mSV.mRQ;
    if (locala == null)
    {
      AppMethodBeat.o(91369);
      return;
    }
    c.a locala1 = (c.a)this.uLp.jFd.remove(locala);
    if (locala1 == null)
    {
      AppMethodBeat.o(91369);
      return;
    }
    switch (paramj.bpE)
    {
    }
    for (;;)
    {
      locala1.cZV();
      AppMethodBeat.o(91369);
      return;
      if ((paramj.mSW == null) || (paramj.mSW.size() == 0))
      {
        ab.i("FTSMatchContact", "local contact search size 0");
        locala1.cZV();
        AppMethodBeat.o(91369);
        return;
      }
      locala.ee(paramj.mSW);
      continue;
      locala.ee(Collections.emptyList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.b.2
 * JD-Core Version:    0.7.0.1
 */