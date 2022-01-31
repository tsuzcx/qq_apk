package com.tencent.mm.vending.g;

import android.os.Handler;
import android.os.Looper;

public final class i
  extends d
{
  private Looper ZG;
  private a aaj;
  private String aak;
  
  private i(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
  }
  
  private i(Looper paramLooper, a parama, String paramString)
  {
    this.ZG = paramLooper;
    this.aaj = parama;
    this.aak = paramString;
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
      this.aaj.b(paramRunnable, paramLong);
      return;
    }
    this.aaj.d(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    this.aaj.d(paramRunnable);
  }
  
  public final Looper getLooper()
  {
    return this.ZG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.i
 * JD-Core Version:    0.7.0.1
 */