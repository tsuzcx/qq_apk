package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class d<T>
  implements Iterator<T>
{
  private final Iterator<T> LIP;
  private T LIR;
  private boolean LIS;
  private final c.a<T> LIT;
  
  d(Iterator<T> paramIterator, c.a<T> parama)
  {
    this.LIP = paramIterator;
    this.LIT = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(193460);
    if (this.LIS)
    {
      AppMethodBeat.o(193460);
      return true;
    }
    while (this.LIP.hasNext())
    {
      Object localObject = this.LIP.next();
      if (!this.LIT.en(localObject))
      {
        this.LIR = localObject;
        this.LIS = true;
        AppMethodBeat.o(193460);
        return true;
      }
    }
    AppMethodBeat.o(193460);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(193461);
    if ((!this.LIS) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(193461);
      throw ((Throwable)localObject);
    }
    Object localObject = this.LIR;
    this.LIR = null;
    this.LIS = false;
    AppMethodBeat.o(193461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.d
 * JD-Core Version:    0.7.0.1
 */