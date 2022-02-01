package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class a<S, T>
  implements Iterable<T>
{
  private final Iterable<? extends S> YFJ;
  private final a<S, ? extends T> YFK;
  
  public a(Iterable<? extends S> paramIterable, a<S, ? extends T> parama)
  {
    this.YFJ = paramIterable;
    this.YFK = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(237037);
    b localb = new b(this.YFJ.iterator(), this.YFK);
    AppMethodBeat.o(237037);
    return localb;
  }
  
  public static abstract interface a<S, T>
  {
    public abstract Iterable<? extends T> ew(S paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.a
 * JD-Core Version:    0.7.0.1
 */