package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class b
{
  private static b aao = new b();
  private HandlerThread aal = new HandlerThread("Vending-LogicThread");
  private Handler aam;
  
  private b()
  {
    this.aal.start();
    this.aam = new Handler(this.aal.getLooper());
  }
  
  public static b lJ()
  {
    return aao;
  }
  
  public final Looper getLooper()
  {
    return this.aal.getLooper();
  }
  
  public final boolean isRunning()
  {
    return this.aal.isAlive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.b
 * JD-Core Version:    0.7.0.1
 */