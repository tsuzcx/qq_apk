package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class i<T>
  implements Iterator<T>
{
  private final Iterator<? extends T> YFL;
  private final h.a YFT;
  private boolean mCalled = false;
  
  i(Iterator<? extends T> paramIterator, h.a parama)
  {
    this.YFL = paramIterator;
    this.YFT = parama;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(237110);
    boolean bool = this.YFL.hasNext();
    if ((!bool) && (!this.mCalled))
    {
      this.YFT.ifx();
      this.mCalled = true;
    }
    AppMethodBeat.o(237110);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(237111);
    try
    {
      Object localObject = this.YFL.next();
      AppMethodBeat.o(237111);
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      if (!this.mCalled)
      {
        this.YFT.ifx();
        this.mCalled = true;
      }
      AppMethodBeat.o(237111);
      throw localNoSuchElementException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.a.i
 * JD-Core Version:    0.7.0.1
 */