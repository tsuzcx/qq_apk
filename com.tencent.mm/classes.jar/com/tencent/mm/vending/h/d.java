package com.tencent.mm.vending.h;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final h AOW = new h(Looper.getMainLooper(), "Vending.UI");
  public static final h AOX = new h(b.dQw().a.getLooper(), "Vending.LOGIC");
  public static final h AOY = new h(a.dQv().a.getLooper(), "Vending.HEAVY_WORK");
  
  static
  {
    g.a();
  }
  
  public static d dQu()
  {
    try
    {
      d locald = g.dQu();
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void cancel();
  
  public abstract String getType();
  
  public abstract void n(Runnable paramRunnable, long paramLong);
  
  public abstract void o(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.d
 * JD-Core Version:    0.7.0.1
 */