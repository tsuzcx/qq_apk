package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class c<T>
  implements Iterable<T>
{
  private final Iterable<? extends T> YFJ;
  private final a<T> YFP;
  
  public c(Iterable<? extends T> paramIterable, a<T> parama)
  {
    this.YFJ = paramIterable;
    this.YFP = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(237053);
    d locald = new d(this.YFJ.iterator(), this.YFP);
    AppMethodBeat.o(237053);
    return locald;
  }
  
  public static abstract interface a<T>
  {
    public abstract boolean dr(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.c
 * JD-Core Version:    0.7.0.1
 */