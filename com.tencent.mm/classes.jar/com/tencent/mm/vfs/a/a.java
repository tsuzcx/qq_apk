package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class a<S, T>
  implements Iterable<T>
{
  private final Iterable<? extends S> agBr;
  private final a<S, ? extends T> agBs;
  
  public a(Iterable<? extends S> paramIterable, a<S, ? extends T> parama)
  {
    this.agBr = paramIterable;
    this.agBs = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(238542);
    b localb = new b(this.agBr.iterator(), this.agBs);
    AppMethodBeat.o(238542);
    return localb;
  }
  
  public static abstract interface a<S, T>
  {
    public abstract Iterable<? extends T> gU(S paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.a
 * JD-Core Version:    0.7.0.1
 */