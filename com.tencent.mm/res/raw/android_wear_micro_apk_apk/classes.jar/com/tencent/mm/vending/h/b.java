package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class b
  implements a
{
  private Handler adA;
  
  public b(Handler paramHandler)
  {
    this.adA = paramHandler;
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    this.adA.postDelayed(paramRunnable, paramLong);
  }
  
  public final Looper getLooper()
  {
    return this.adA.getLooper();
  }
  
  public final void n(Runnable paramRunnable)
  {
    this.adA.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.b
 * JD-Core Version:    0.7.0.1
 */