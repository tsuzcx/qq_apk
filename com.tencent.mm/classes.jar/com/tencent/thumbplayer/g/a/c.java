package com.tencent.thumbplayer.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  implements b
{
  private ArrayList<a> Mcl;
  
  public c()
  {
    AppMethodBeat.i(192142);
    this.Mcl = new ArrayList();
    AppMethodBeat.o(192142);
  }
  
  public final b a(a parama)
  {
    AppMethodBeat.i(192143);
    if (this.Mcl == null) {
      this.Mcl = new ArrayList();
    }
    if (!this.Mcl.contains(parama)) {
      this.Mcl.add(parama);
    }
    AppMethodBeat.o(192143);
    return this;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(192144);
    if (this.Mcl != null)
    {
      Iterator localIterator = this.Mcl.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
        }
      }
    }
    AppMethodBeat.o(192144);
  }
  
  public final void release()
  {
    AppMethodBeat.i(192145);
    if (this.Mcl != null)
    {
      Iterator localIterator = this.Mcl.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        localIterator.remove();
      }
    }
    this.Mcl = null;
    AppMethodBeat.o(192145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.c
 * JD-Core Version:    0.7.0.1
 */