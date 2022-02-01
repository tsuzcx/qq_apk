package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class g<S, T>
  implements Iterator<T>
{
  private final Iterator<? extends S> YFL;
  private T YFN;
  private boolean YFO;
  private final f.a<S, T> YFS;
  
  g(Iterator<? extends S> paramIterator, f.a<S, T> parama)
  {
    this.YFL = paramIterator;
    this.YFS = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(237087);
    if (this.YFO)
    {
      AppMethodBeat.o(237087);
      return true;
    }
    if (this.YFL.hasNext())
    {
      Object localObject = this.YFL.next();
      this.YFN = this.YFS.ex(localObject);
      this.YFO = true;
      AppMethodBeat.o(237087);
      return true;
    }
    AppMethodBeat.o(237087);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(237089);
    if ((!this.YFO) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(237089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.YFN;
    this.YFN = null;
    this.YFO = false;
    AppMethodBeat.o(237089);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.g
 * JD-Core Version:    0.7.0.1
 */