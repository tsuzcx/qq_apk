package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class h<T>
  implements Iterable<T>
{
  private final Iterable<? extends T> YFJ;
  private final a YFT;
  
  public h(Iterable<? extends T> paramIterable, a parama)
  {
    this.YFJ = paramIterable;
    this.YFT = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(237109);
    i locali = new i(this.YFJ.iterator(), this.YFT);
    AppMethodBeat.o(237109);
    return locali;
  }
  
  public static abstract interface a
  {
    public abstract void ifx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.h
 * JD-Core Version:    0.7.0.1
 */