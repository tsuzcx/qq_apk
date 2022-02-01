package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class h<T>
  implements Iterable<T>
{
  private final a agBB;
  private final Iterable<? extends T> agBr;
  
  public h(Iterable<? extends T> paramIterable, a parama)
  {
    this.agBr = paramIterable;
    this.agBB = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(238523);
    i locali = new i(this.agBr.iterator(), this.agBB);
    AppMethodBeat.o(238523);
    return locali;
  }
  
  public static abstract interface a
  {
    public abstract void jKE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.h
 * JD-Core Version:    0.7.0.1
 */