package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class c<T>
  implements Iterable<T>
{
  private final Iterable<? extends T> ReP;
  private final a<T> ReV;
  
  public c(Iterable<? extends T> paramIterable, a<T> parama)
  {
    this.ReP = paramIterable;
    this.ReV = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(187773);
    d locald = new d(this.ReP.iterator(), this.ReV);
    AppMethodBeat.o(187773);
    return locald;
  }
  
  public static abstract interface a<T>
  {
    public abstract boolean dm(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.c
 * JD-Core Version:    0.7.0.1
 */