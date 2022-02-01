package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class i<T>
  implements Iterator<T>
{
  private final Iterator<? extends T> ReR;
  private final h.a<T> ReZ;
  private boolean mCalled = false;
  
  i(Iterator<? extends T> paramIterator, h.a<T> parama)
  {
    this.ReR = paramIterator;
    this.ReZ = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(187783);
    boolean bool = this.ReR.hasNext();
    if ((!bool) && (!this.mCalled))
    {
      this.ReZ.hen();
      this.mCalled = true;
    }
    AppMethodBeat.o(187783);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(187784);
    try
    {
      Object localObject = this.ReR.next();
      AppMethodBeat.o(187784);
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      if (!this.mCalled)
      {
        this.ReZ.hen();
        this.mCalled = true;
      }
      AppMethodBeat.o(187784);
      throw localNoSuchElementException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a.i
 * JD-Core Version:    0.7.0.1
 */