package com.google.android.gms.internal;

import java.util.concurrent.locks.Lock;

abstract class ag
  implements Runnable
{
  private ag(aa paramaa) {}
  
  protected abstract void iC();
  
  public void run()
  {
    aa.c(this.Pw).lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool) {
        return;
      }
      iC();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      aa.d(this.Pw).b(localRuntimeException);
      return;
    }
    finally
    {
      aa.c(this.Pw).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ag
 * JD-Core Version:    0.7.0.1
 */