package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class c<T>
  implements Iterable<T>
{
  private final Iterable<? extends T> agBr;
  private final a<T> agBx;
  
  public c(Iterable<? extends T> paramIterable, a<T> parama)
  {
    this.agBr = paramIterable;
    this.agBx = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(238528);
    d locald = new d(this.agBr.iterator(), this.agBx);
    AppMethodBeat.o(238528);
    return locald;
  }
  
  public static abstract interface a<T>
  {
    public abstract boolean fB(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.c
 * JD-Core Version:    0.7.0.1
 */