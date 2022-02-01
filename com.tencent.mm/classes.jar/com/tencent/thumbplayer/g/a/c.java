package com.tencent.thumbplayer.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  implements b
{
  private ArrayList<a> ahJD;
  
  public c()
  {
    AppMethodBeat.i(227213);
    this.ahJD = new ArrayList();
    AppMethodBeat.o(227213);
  }
  
  public final b a(a parama)
  {
    AppMethodBeat.i(227219);
    if (this.ahJD == null) {
      this.ahJD = new ArrayList();
    }
    if (!this.ahJD.contains(parama))
    {
      parama.bwk();
      this.ahJD.add(parama);
    }
    AppMethodBeat.o(227219);
    return this;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(227236);
    if (this.ahJD != null)
    {
      Iterator localIterator = this.ahJD.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
        }
      }
    }
    AppMethodBeat.o(227236);
  }
  
  public final void bwk() {}
  
  public final void onDetach() {}
  
  public final void release()
  {
    AppMethodBeat.i(227240);
    if (this.ahJD != null)
    {
      Iterator localIterator = this.ahJD.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.onDetach();
        }
        localIterator.remove();
      }
    }
    this.ahJD = null;
    AppMethodBeat.o(227240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.c
 * JD-Core Version:    0.7.0.1
 */