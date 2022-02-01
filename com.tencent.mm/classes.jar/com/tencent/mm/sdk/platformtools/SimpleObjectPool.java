package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SimpleObjectPool<T>
{
  private static final String TAG = "MicroMsg.SimpleObjectPool";
  private Object[] mPool;
  private int mPoolSize;
  
  public SimpleObjectPool(int paramInt)
  {
    AppMethodBeat.i(157835);
    if (paramInt <= 0)
    {
      Log.e("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
      AppMethodBeat.o(157835);
      return;
    }
    this.mPool = new Object[paramInt];
    AppMethodBeat.o(157835);
  }
  
  private boolean isInPool(T paramT)
  {
    if (this.mPool == null) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.mPoolSize)
      {
        if (this.mPool[i] == paramT) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public T acquire()
  {
    if (this.mPool == null) {}
    while (this.mPoolSize <= 0) {
      return null;
    }
    int i = this.mPoolSize - 1;
    Object localObject = this.mPool[i];
    this.mPool[i] = null;
    this.mPoolSize -= 1;
    return localObject;
  }
  
  protected void put(T paramT)
  {
    AppMethodBeat.i(189293);
    if (this.mPool == null)
    {
      AppMethodBeat.o(189293);
      return;
    }
    if ((!isInPool(paramT)) && (this.mPoolSize < this.mPool.length))
    {
      this.mPool[this.mPoolSize] = paramT;
      this.mPoolSize += 1;
    }
    AppMethodBeat.o(189293);
  }
  
  public void putWithoutCheck(T paramT)
  {
    if (this.mPool == null) {}
    while (this.mPoolSize >= this.mPool.length) {
      return;
    }
    this.mPool[this.mPoolSize] = paramT;
    this.mPoolSize += 1;
  }
  
  public boolean release(T paramT)
  {
    AppMethodBeat.i(157836);
    if (this.mPool == null)
    {
      AppMethodBeat.o(157836);
      return false;
    }
    if (isInPool(paramT))
    {
      AppMethodBeat.o(157836);
      return false;
    }
    if ((this.mPoolSize < this.mPool.length) && (this.mPoolSize >= 0))
    {
      this.mPool[this.mPoolSize] = paramT;
      this.mPoolSize += 1;
      AppMethodBeat.o(157836);
      return true;
    }
    Log.e("MicroMsg.SimpleObjectPool", "error index %d %d", new Object[] { Integer.valueOf(this.mPoolSize), Integer.valueOf(this.mPool.length) });
    AppMethodBeat.o(157836);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SimpleObjectPool
 * JD-Core Version:    0.7.0.1
 */