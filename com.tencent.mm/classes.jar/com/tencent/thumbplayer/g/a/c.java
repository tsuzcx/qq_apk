package com.tencent.thumbplayer.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
  implements b
{
  private ArrayList<a> KiW;
  
  public c()
  {
    AppMethodBeat.i(188120);
    this.KiW = new ArrayList();
    AppMethodBeat.o(188120);
  }
  
  public final b a(a parama)
  {
    AppMethodBeat.i(188121);
    if (this.KiW == null) {
      this.KiW = new ArrayList();
    }
    if (!this.KiW.contains(parama)) {
      this.KiW.add(parama);
    }
    AppMethodBeat.o(188121);
    return this;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(188122);
    if (this.KiW != null)
    {
      Iterator localIterator = this.KiW.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
        }
      }
    }
    AppMethodBeat.o(188122);
  }
  
  public final void release()
  {
    AppMethodBeat.i(188123);
    if (this.KiW != null)
    {
      Iterator localIterator = this.KiW.iterator();
      while (localIterator.hasNext())
      {
        localIterator.next();
        localIterator.remove();
      }
    }
    this.KiW = null;
    AppMethodBeat.o(188123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.c
 * JD-Core Version:    0.7.0.1
 */