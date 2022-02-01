package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public class a<S, T>
  implements Iterable<T>
{
  private final Iterable<? extends S> LIN;
  private final a<S, ? extends T> LIO;
  
  public a(Iterable<? extends S> paramIterable, a<S, ? extends T> parama)
  {
    this.LIN = paramIterable;
    this.LIO = parama;
  }
  
  public Iterator<T> iterator()
  {
    AppMethodBeat.i(193455);
    b localb = new b(this.LIN.iterator(), this.LIO);
    AppMethodBeat.o(193455);
    return localb;
  }
  
  public static abstract interface a<S, T>
  {
    public abstract Iterable<? extends T> em(S paramS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.a
 * JD-Core Version:    0.7.0.1
 */