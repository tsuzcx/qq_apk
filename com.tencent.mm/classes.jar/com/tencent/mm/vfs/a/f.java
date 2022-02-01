package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class f<S, T>
  implements Iterable<T>
{
  private final Iterable<? extends S> ReP;
  private final a<S, T> ReY;
  
  public f(Iterable<? extends S> paramIterable, a<S, T> parama)
  {
    this.ReP = paramIterable;
    this.ReY = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(187779);
    g localg = new g(this.ReP.iterator(), this.ReY);
    AppMethodBeat.o(187779);
    return localg;
  }
  
  public static abstract interface a<S, T>
  {
    public abstract T er(S paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.f
 * JD-Core Version:    0.7.0.1
 */