package com.tencent.mm.vending.h;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final h HEAVY_WORK;
  public static final h LOGIC;
  public static final h UI = new h(Looper.getMainLooper(), "Vending.UI");
  
  static
  {
    LOGIC = new h(b.jJZ().agvC.getLooper(), "Vending.LOGIC");
    HEAVY_WORK = new h(a.jJY().agvA.getLooper(), "Vending.HEAVY_WORK");
    g.jJW();
  }
  
  public static d current()
  {
    return g.current();
  }
  
  public static d find(String paramString)
  {
    return g.bDR(paramString);
  }
  
  public abstract void arrange(Runnable paramRunnable);
  
  public abstract void arrangeInterval(Runnable paramRunnable, long paramLong);
  
  public abstract void cancel();
  
  public abstract String getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vending.h.d
 * JD-Core Version:    0.7.0.1
 */