package com.tencent.mm.vending.h;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final h Jrg = new h(Looper.getMainLooper(), "Vending.UI");
  public static final h Jrh = new h(b.fxy().Jrs.getLooper(), "Vending.LOGIC");
  public static final h Jri = new h(a.fxx().Jrq.getLooper(), "Vending.HEAVY_WORK");
  
  static
  {
    g.fxv();
  }
  
  public static d fxu()
  {
    return g.fxu();
  }
  
  public abstract void cancel();
  
  public abstract void f(Runnable paramRunnable, long paramLong);
  
  public abstract String getType();
  
  public abstract void w(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.d
 * JD-Core Version:    0.7.0.1
 */