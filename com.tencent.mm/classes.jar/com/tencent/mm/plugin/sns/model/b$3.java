package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(36101);
    if (b.b(this.rdk) != null)
    {
      Iterator localIterator = b.b(this.rdk).iterator();
      while (localIterator.hasNext())
      {
        b.a locala = (b.a)localIterator.next();
        if (locala != null) {
          locala.gi(this.Cq, this.val$path);
        }
      }
    }
    AppMethodBeat.o(36101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.3
 * JD-Core Version:    0.7.0.1
 */