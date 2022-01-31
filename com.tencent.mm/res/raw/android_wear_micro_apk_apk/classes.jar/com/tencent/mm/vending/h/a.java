package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public final class a
{
  private static a aan = new a();
  private HandlerThread aal = new HandlerThread("Vending-HeavyWorkThread", 10);
  private Handler aam;
  
  private a()
  {
    this.aal.start();
    this.aam = new Handler(this.aal.getLooper());
  }
  
  public static a lI()
  {
    return aan;
  }
  
  public final Looper getLooper()
  {
    return this.aal.getLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.a
 * JD-Core Version:    0.7.0.1
 */