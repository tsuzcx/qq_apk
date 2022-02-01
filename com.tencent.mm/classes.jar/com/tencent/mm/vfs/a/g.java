package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class g<S, T>
  implements Iterator<T>
{
  private final Iterator<? extends S> ReR;
  private T ReT;
  private boolean ReU;
  private final f.a<S, T> ReY;
  
  g(Iterator<? extends S> paramIterator, f.a<S, T> parama)
  {
    this.ReR = paramIterator;
    this.ReY = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(187780);
    if (this.ReU)
    {
      AppMethodBeat.o(187780);
      return true;
    }
    if (this.ReR.hasNext())
    {
      Object localObject = this.ReR.next();
      this.ReT = this.ReY.er(localObject);
      this.ReU = true;
      AppMethodBeat.o(187780);
      return true;
    }
    AppMethodBeat.o(187780);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(187781);
    if ((!this.ReU) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(187781);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ReT;
    this.ReT = null;
    this.ReU = false;
    AppMethodBeat.o(187781);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.g
 * JD-Core Version:    0.7.0.1
 */