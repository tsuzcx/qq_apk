package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class g<S, T>
  implements Iterator<T>
{
  private final f.a<S, T> agBA;
  private final Iterator<? extends S> agBt;
  private T agBv;
  private boolean agBw;
  
  g(Iterator<? extends S> paramIterator, f.a<S, T> parama)
  {
    this.agBt = paramIterator;
    this.agBA = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(238513);
    if (this.agBw)
    {
      AppMethodBeat.o(238513);
      return true;
    }
    if (this.agBt.hasNext())
    {
      Object localObject = this.agBt.next();
      this.agBv = this.agBA.aY(localObject);
      this.agBw = true;
      AppMethodBeat.o(238513);
      return true;
    }
    AppMethodBeat.o(238513);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(238519);
    if ((!this.agBw) && (!hasNext()))
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(238519);
      throw ((Throwable)localObject);
    }
    Object localObject = this.agBv;
    this.agBv = null;
    this.agBw = false;
    AppMethodBeat.o(238519);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.g
 * JD-Core Version:    0.7.0.1
 */