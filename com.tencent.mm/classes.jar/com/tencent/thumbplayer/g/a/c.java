package com.tencent.thumbplayer.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  implements b
{
  private ArrayList<a> ZEA;
  
  public c()
  {
    AppMethodBeat.i(221560);
    this.ZEA = new ArrayList();
    AppMethodBeat.o(221560);
  }
  
  public final b a(a parama)
  {
    AppMethodBeat.i(221561);
    if (this.ZEA == null) {
      this.ZEA = new ArrayList();
    }
    if (!this.ZEA.contains(parama))
    {
      parama.bbp();
      this.ZEA.add(parama);
    }
    AppMethodBeat.o(221561);
    return this;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(221563);
    if (this.ZEA != null)
    {
      Iterator localIterator = this.ZEA.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
        }
      }
    }
    AppMethodBeat.o(221563);
  }
  
  public final void bbp() {}
  
  public final void onDetach() {}
  
  public final void release()
  {
    AppMethodBeat.i(221565);
    if (this.ZEA != null)
    {
      Iterator localIterator = this.ZEA.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.onDetach();
        }
        localIterator.remove();
      }
    }
    this.ZEA = null;
    AppMethodBeat.o(221565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.c
 * JD-Core Version:    0.7.0.1
 */