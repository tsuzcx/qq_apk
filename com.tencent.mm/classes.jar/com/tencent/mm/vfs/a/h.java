package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class h<T>
  implements Iterable<T>
{
  private final Iterable<? extends T> ReP;
  private final a<T> ReZ;
  
  public h(Iterable<? extends T> paramIterable, a<T> parama)
  {
    this.ReP = paramIterable;
    this.ReZ = parama;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(187782);
    i locali = new i(this.ReP.iterator(), this.ReZ);
    AppMethodBeat.o(187782);
    return locali;
  }
  
  public static abstract interface a<T>
  {
    public abstract void hen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.h
 * JD-Core Version:    0.7.0.1
 */