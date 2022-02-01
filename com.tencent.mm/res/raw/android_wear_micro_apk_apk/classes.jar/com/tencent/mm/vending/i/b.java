package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class b
{
  private static b adP = new b();
  private HandlerThread adM = new HandlerThread("Vending-LogicThread");
  private Handler adN;
  
  private b()
  {
    this.adM.start();
    this.adN = new Handler(this.adM.getLooper());
  }
  
  public static b mw()
  {
    return adP;
  }
  
  public final Looper getLooper()
  {
    return this.adM.getLooper();
  }
  
  public final boolean isRunning()
  {
    return this.adM.isAlive();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */