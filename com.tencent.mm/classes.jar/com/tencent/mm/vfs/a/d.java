package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class d<T>
  implements Iterator<T>
{
  private final Iterator<? extends T> agBt;
  private T agBv;
  private boolean agBw;
  private final c.a<T> agBx;
  
  d(Iterator<? extends T> paramIterator, c.a<T> parama)
  {
    this.agBt = paramIterator;
    this.agBx = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(238520);
    if (this.agBw)
    {
      AppMethodBeat.o(238520);
      return true;
    }
    while (this.agBt.hasNext())
    {
      Object localObject = this.agBt.next();
      if (!this.agBx.fB(localObject))
      {
        this.agBv = localObject;
        this.agBw = true;
        AppMethodBeat.o(238520);
        return true;
      }
    }
    AppMethodBeat.o(238520);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(238531);
    if ((!this.agBw) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(238531);
      throw ((Throwable)localObject);
    }
    Object localObject = this.agBv;
    this.agBv = null;
    this.agBw = false;
    AppMethodBeat.o(238531);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.d
 * JD-Core Version:    0.7.0.1
 */