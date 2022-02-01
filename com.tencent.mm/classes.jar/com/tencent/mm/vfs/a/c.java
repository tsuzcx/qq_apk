package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class c<T>
  implements Iterable<T>
{
  private final Iterable<T> LIN;
  private final a<T> LIT;
  
  public c(Iterable<T> paramIterable, a<T> parama)
  {
    this.LIN = paramIterable;
    this.LIT = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(193459);
    d locald = new d(this.LIN.iterator(), this.LIT);
    AppMethodBeat.o(193459);
    return locald;
  }
  
  public static abstract interface a<T>
  {
    public abstract boolean en(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.c
 * JD-Core Version:    0.7.0.1
 */