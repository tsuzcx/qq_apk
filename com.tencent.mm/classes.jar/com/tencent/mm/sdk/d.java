package com.tencent.mm.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bg;

public class d<T>
  extends bg<T>
{
  private final Object mLock;
  
  public d(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(51962);
    this.mLock = new Object();
    AppMethodBeat.o(51962);
  }
  
  public final T acquire()
  {
    AppMethodBeat.i(51963);
    synchronized (this.mLock)
    {
      Object localObject2 = super.acquire();
      AppMethodBeat.o(51963);
      return localObject2;
    }
  }
  
  public final boolean release(T paramT)
  {
    AppMethodBeat.i(51964);
    synchronized (this.mLock)
    {
      boolean bool = super.release(paramT);
      AppMethodBeat.o(51964);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.d
 * JD-Core Version:    0.7.0.1
 */