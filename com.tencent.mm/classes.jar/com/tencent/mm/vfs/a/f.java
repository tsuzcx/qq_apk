package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class f<S, T>
  implements Iterable<T>
{
  private final a<S, T> agBA;
  private final Iterable<? extends S> agBr;
  
  public f(Iterable<? extends S> paramIterable, a<S, T> parama)
  {
    this.agBr = paramIterable;
    this.agBA = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(238526);
    g localg = new g(this.agBr.iterator(), this.agBA);
    AppMethodBeat.o(238526);
    return localg;
  }
  
  public static abstract interface a<S, T>
  {
    public abstract T aY(S paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.f
 * JD-Core Version:    0.7.0.1
 */