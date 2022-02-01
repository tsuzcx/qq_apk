package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final i adB = new i(Looper.getMainLooper(), "Vending.UI");
  public static final i adC = new i(b.mw().getLooper(), "Vending.LOGIC");
  public static final i adD = new i(a.mv().getLooper(), "Vending.HEAVY_WORK");
  
  static
  {
    h.me();
  }
  
  public static d mt()
  {
    try
    {
      d locald = h.mt();
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public abstract void a(Runnable paramRunnable, long paramLong);
  
  public abstract void d(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.d
 * JD-Core Version:    0.7.0.1
 */