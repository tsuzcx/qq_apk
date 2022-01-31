package com.tencent.mm.vending.g;

import android.os.Handler;
import android.os.Looper;

public final class b
  implements a
{
  private Handler ZZ;
  
  public b(Handler paramHandler)
  {
    this.ZZ = paramHandler;
  }
  
  public final void b(Runnable paramRunnable, long paramLong)
  {
    this.ZZ.postDelayed(paramRunnable, paramLong);
  }
  
  public final void d(Runnable paramRunnable)
  {
    this.ZZ.post(paramRunnable);
  }
  
  public final Looper getLooper()
  {
    return this.ZZ.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.b
 * JD-Core Version:    0.7.0.1
 */