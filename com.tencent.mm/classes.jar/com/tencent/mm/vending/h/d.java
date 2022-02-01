package com.tencent.mm.vending.h;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d
{
  public static final h LFn = new h(Looper.getMainLooper(), "Vending.UI");
  public static final h LFo = new h(b.fSG().LFz.getLooper(), "Vending.LOGIC");
  public static final h LFp = new h(a.fSF().LFx.getLooper(), "Vending.HEAVY_WORK");
  
  static
  {
    g.fSD();
  }
  
  public static d fSC()
  {
    return g.fSC();
  }
  
  public abstract void cancel();
  
  public abstract void g(Runnable paramRunnable, long paramLong);
  
  public abstract String getType();
  
  public abstract void u(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.d
 * JD-Core Version:    0.7.0.1
 */