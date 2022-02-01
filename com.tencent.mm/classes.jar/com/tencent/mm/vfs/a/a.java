package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class a<S, T>
  implements Iterable<T>
{
  private final Iterable<? extends S> ReP;
  private final a<S, ? extends T> ReQ;
  
  public a(Iterable<? extends S> paramIterable, a<S, ? extends T> parama)
  {
    this.ReP = paramIterable;
    this.ReQ = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(187769);
    b localb = new b(this.ReP.iterator(), this.ReQ);
    AppMethodBeat.o(187769);
    return localb;
  }
  
  public static abstract interface a<S, T>
  {
    public abstract Iterable<? extends T> eq(S paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.a
 * JD-Core Version:    0.7.0.1
 */