package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class f<S, T>
  implements Iterable<T>
{
  private final Iterable<? extends S> YFJ;
  private final a<S, T> YFS;
  
  public f(Iterable<? extends S> paramIterable, a<S, T> parama)
  {
    this.YFJ = paramIterable;
    this.YFS = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(237075);
    g localg = new g(this.YFJ.iterator(), this.YFS);
    AppMethodBeat.o(237075);
    return localg;
  }
  
  public static abstract interface a<S, T>
  {
    public abstract T ex(S paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.f
 * JD-Core Version:    0.7.0.1
 */