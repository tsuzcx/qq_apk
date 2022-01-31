package com.tencent.mm.vending.g;

import android.os.Looper;
import com.tencent.mm.vending.h.a;
import com.tencent.mm.vending.h.b;

public abstract class d
{
  public static final i aaa = new i(Looper.getMainLooper(), "Vending.UI");
  public static final i aab = new i(b.lJ().getLooper(), "Vending.LOGIC");
  public static final i aac = new i(a.lI().getLooper(), "Vending.HEAVY_WORK");
  
  static
  {
    h.lx();
  }
  
  public static d lG()
  {
    try
    {
      d locald = h.lG();
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void a(Runnable paramRunnable, long paramLong);
  
  public abstract void b(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.g.d
 * JD-Core Version:    0.7.0.1
 */