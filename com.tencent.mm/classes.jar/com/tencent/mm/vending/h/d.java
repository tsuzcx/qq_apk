package com.tencent.mm.vending.h;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final h wtY = new h(Looper.getMainLooper(), "Vending.UI");
  public static final h wtZ = new h(b.cLg().a.getLooper(), "Vending.LOGIC");
  public static final h wua = new h(a.cLf().a.getLooper(), "Vending.HEAVY_WORK");
  
  static
  {
    g.a();
  }
  
  public static d cLe()
  {
    try
    {
      d locald = g.cLe();
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
  
  public abstract void j(Runnable paramRunnable, long paramLong);
  
  public abstract void k(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.d
 * JD-Core Version:    0.7.0.1
 */