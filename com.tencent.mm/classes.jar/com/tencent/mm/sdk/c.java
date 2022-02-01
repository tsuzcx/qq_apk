package com.tencent.mm.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bm;

public class c<T>
  extends bm<T>
{
  private final Object mLock;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(157515);
    this.mLock = new Object();
    AppMethodBeat.o(157515);
  }
  
  public final T acquire()
  {
    AppMethodBeat.i(157516);
    synchronized (this.mLock)
    {
      Object localObject2 = super.acquire();
      AppMethodBeat.o(157516);
      return localObject2;
    }
  }
  
  public final boolean release(T paramT)
  {
    AppMethodBeat.i(157517);
    synchronized (this.mLock)
    {
      boolean bool = super.release(paramT);
      AppMethodBeat.o(157517);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.c
 * JD-Core Version:    0.7.0.1
 */