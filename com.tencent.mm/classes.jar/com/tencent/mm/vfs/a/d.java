package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class d<T>
  implements Iterator<T>
{
  private final Iterator<? extends T> ReR;
  private T ReT;
  private boolean ReU;
  private final c.a<T> ReV;
  
  d(Iterator<? extends T> paramIterator, c.a<T> parama)
  {
    this.ReR = paramIterator;
    this.ReV = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(187774);
    if (this.ReU)
    {
      AppMethodBeat.o(187774);
      return true;
    }
    while (this.ReR.hasNext())
    {
      Object localObject = this.ReR.next();
      if (!this.ReV.dm(localObject))
      {
        this.ReT = localObject;
        this.ReU = true;
        AppMethodBeat.o(187774);
        return true;
      }
    }
    AppMethodBeat.o(187774);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(187775);
    if ((!this.ReU) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(187775);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ReT;
    this.ReT = null;
    this.ReU = false;
    AppMethodBeat.o(187775);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.d
 * JD-Core Version:    0.7.0.1
 */