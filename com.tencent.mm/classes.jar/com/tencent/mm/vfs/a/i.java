package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class i<T>
  implements Iterator<T>
{
  private final h.a agBB;
  private final Iterator<? extends T> agBt;
  private boolean mCalled = false;
  
  i(Iterator<? extends T> paramIterator, h.a parama)
  {
    this.agBt = paramIterator;
    this.agBB = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(238517);
    boolean bool = this.agBt.hasNext();
    if ((!bool) && (!this.mCalled))
    {
      this.agBB.jKE();
      this.mCalled = true;
    }
    AppMethodBeat.o(238517);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(238524);
    try
    {
      Object localObject = this.agBt.next();
      AppMethodBeat.o(238524);
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      if (!this.mCalled)
      {
        this.agBB.jKE();
        this.mCalled = true;
      }
      AppMethodBeat.o(238524);
      throw localNoSuchElementException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.a.i
 * JD-Core Version:    0.7.0.1
 */