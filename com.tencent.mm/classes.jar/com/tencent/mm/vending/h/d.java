package com.tencent.mm.vending.h;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final h HQL = new h(Looper.getMainLooper(), "Vending.UI");
  public static final h HQM = new h(b.fhw().HQX.getLooper(), "Vending.LOGIC");
  public static final h HQN = new h(a.fhv().HQV.getLooper(), "Vending.HEAVY_WORK");
  
  static
  {
    g.fht();
  }
  
  public static d fhs()
  {
    return g.fhs();
  }
  
  public abstract void cancel();
  
  public abstract void f(Runnable paramRunnable, long paramLong);
  
  public abstract String getType();
  
  public abstract void v(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.d
 * JD-Core Version:    0.7.0.1
 */