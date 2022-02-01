package com.tencent.thumbplayer.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  implements b
{
  private ArrayList<a> Mzg;
  
  public c()
  {
    AppMethodBeat.i(194820);
    this.Mzg = new ArrayList();
    AppMethodBeat.o(194820);
  }
  
  public final b a(a parama)
  {
    AppMethodBeat.i(194821);
    if (this.Mzg == null) {
      this.Mzg = new ArrayList();
    }
    if (!this.Mzg.contains(parama)) {
      this.Mzg.add(parama);
    }
    AppMethodBeat.o(194821);
    return this;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(194822);
    if (this.Mzg != null)
    {
      Iterator localIterator = this.Mzg.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
        }
      }
    }
    AppMethodBeat.o(194822);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194823);
    if (this.Mzg != null)
    {
      Iterator localIterator = this.Mzg.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        localIterator.remove();
      }
    }
    this.Mzg = null;
    AppMethodBeat.o(194823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.c
 * JD-Core Version:    0.7.0.1
 */