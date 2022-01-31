package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class h
  extends d
{
  Looper b;
  public String c;
  public a wue;
  
  public h(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
  }
  
  private h(Looper paramLooper, a parama, String paramString)
  {
    this.b = paramLooper;
    this.wue = parama;
    this.c = paramString;
  }
  
  public h(Looper paramLooper, String paramString)
  {
    this(new Handler(paramLooper), paramString);
  }
  
  public h(a parama, String paramString)
  {
    this(parama.getLooper(), parama, paramString);
  }
  
  public final void cancel()
  {
    this.wue.dD();
  }
  
  public final String getType()
  {
    return this.c;
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.wue.c(paramRunnable, paramLong);
      return;
    }
    this.wue.f(paramRunnable);
  }
  
  public final void k(Runnable paramRunnable)
  {
    this.wue.f(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.h
 * JD-Core Version:    0.7.0.1
 */