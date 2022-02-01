package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class i
  extends d
{
  private a adK;
  private String adL;
  private Looper adg;
  
  private i(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
  }
  
  private i(Looper paramLooper, a parama, String paramString)
  {
    this.adg = paramLooper;
    this.adK = parama;
    this.adL = paramString;
  }
  
  public i(Looper paramLooper, String paramString)
  {
    this(new Handler(paramLooper), paramString);
  }
  
  private i(a parama, String paramString)
  {
    this(parama.getLooper(), parama, paramString);
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.adK.b(paramRunnable, paramLong);
      return;
    }
    this.adK.n(paramRunnable);
  }
  
  public final void d(Runnable paramRunnable)
  {
    this.adK.n(paramRunnable);
  }
  
  public final Looper getLooper()
  {
    return this.adg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.i
 * JD-Core Version:    0.7.0.1
 */