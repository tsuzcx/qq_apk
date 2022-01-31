package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class b
  implements a
{
  public Handler a;
  
  public b(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public final void c(Runnable paramRunnable, long paramLong)
  {
    this.a.postDelayed(paramRunnable, paramLong);
  }
  
  public final void dD()
  {
    this.a.removeCallbacksAndMessages(null);
  }
  
  public final void f(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
  
  public final Looper getLooper()
  {
    return this.a.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.b
 * JD-Core Version:    0.7.0.1
 */