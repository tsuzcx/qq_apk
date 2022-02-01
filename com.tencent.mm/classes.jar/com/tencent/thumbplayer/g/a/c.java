package com.tencent.thumbplayer.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  implements b
{
  private ArrayList<a> SbP;
  
  public c()
  {
    AppMethodBeat.i(189518);
    this.SbP = new ArrayList();
    AppMethodBeat.o(189518);
  }
  
  public final b a(a parama)
  {
    AppMethodBeat.i(189519);
    if (this.SbP == null) {
      this.SbP = new ArrayList();
    }
    if (!this.SbP.contains(parama))
    {
      parama.aSs();
      this.SbP.add(parama);
    }
    AppMethodBeat.o(189519);
    return this;
  }
  
  public final void aSs() {}
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(189520);
    if (this.SbP != null)
    {
      Iterator localIterator = this.SbP.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
        }
      }
    }
    AppMethodBeat.o(189520);
  }
  
  public final void onDetach() {}
  
  public final void release()
  {
    AppMethodBeat.i(189521);
    if (this.SbP != null)
    {
      Iterator localIterator = this.SbP.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.onDetach();
        }
        localIterator.remove();
      }
    }
    this.SbP = null;
    AppMethodBeat.o(189521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.c
 * JD-Core Version:    0.7.0.1
 */