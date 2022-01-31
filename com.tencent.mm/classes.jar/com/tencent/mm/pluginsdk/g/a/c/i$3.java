package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

final class i$3
  implements Runnable
{
  i$3(i parami, List paramList, m paramm, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(79573);
    Iterator localIterator = this.vOm.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (bo.nullAsNil(locald.avS()).equals(this.gWk.groupId)) {
        locald.alF(this.vNc);
      }
    }
    AppMethodBeat.o(79573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.i.3
 * JD-Core Version:    0.7.0.1
 */