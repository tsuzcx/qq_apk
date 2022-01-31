package com.tencent.mm.sdk;

import com.tencent.mm.sdk.platformtools.bc;

public class b<T>
  extends bc<T>
{
  private final Object mLock = new Object();
  
  public b(int paramInt)
  {
    super(paramInt);
  }
  
  public final boolean D(T paramT)
  {
    synchronized (this.mLock)
    {
      boolean bool = super.D(paramT);
      return bool;
    }
  }
  
  public final T de()
  {
    synchronized (this.mLock)
    {
      Object localObject2 = super.de();
      return localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.b
 * JD-Core Version:    0.7.0.1
 */