package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class a
{
  private static a adO = new a();
  private HandlerThread adM = new HandlerThread("Vending-HeavyWorkThread", 10);
  private Handler adN;
  
  private a()
  {
    this.adM.start();
    this.adN = new Handler(this.adM.getLooper());
  }
  
  public static a mv()
  {
    return adO;
  }
  
  public final Looper getLooper()
  {
    return this.adM.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */