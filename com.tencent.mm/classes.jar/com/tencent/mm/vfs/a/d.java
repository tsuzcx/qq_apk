package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class d<T>
  implements Iterator<T>
{
  private final Iterator<? extends T> YFL;
  private T YFN;
  private boolean YFO;
  private final c.a<T> YFP;
  
  d(Iterator<? extends T> paramIterator, c.a<T> parama)
  {
    this.YFL = paramIterator;
    this.YFP = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(237055);
    if (this.YFO)
    {
      AppMethodBeat.o(237055);
      return true;
    }
    while (this.YFL.hasNext())
    {
      Object localObject = this.YFL.next();
      if (!this.YFP.dr(localObject))
      {
        this.YFN = localObject;
        this.YFO = true;
        AppMethodBeat.o(237055);
        return true;
      }
    }
    AppMethodBeat.o(237055);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(237056);
    if ((!this.YFO) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(237056);
      throw ((Throwable)localObject);
    }
    Object localObject = this.YFN;
    this.YFN = null;
    this.YFO = false;
    AppMethodBeat.o(237056);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.d
 * JD-Core Version:    0.7.0.1
 */