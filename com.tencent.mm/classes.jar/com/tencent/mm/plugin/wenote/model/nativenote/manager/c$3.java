package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import java.util.ArrayList;
import java.util.Iterator;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(26716);
    int i;
    synchronized (this.vyj)
    {
      if (c.d(this.vyj) == null)
      {
        AppMethodBeat.o(26716);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = c.d(this.vyj).iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc1 = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        if (localc1.getType() != 1) {
          i += 1;
        } else {
          localStringBuilder.append(((i)localc1).content);
        }
      }
    }
    c.a(this.vyj, com.tencent.mm.plugin.wenote.b.c.ajU(localObject.toString()));
    c.b(this.vyj, i);
    AppMethodBeat.o(26716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c.3
 * JD-Core Version:    0.7.0.1
 */