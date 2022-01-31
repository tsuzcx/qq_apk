package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class b
{
  private static b wug = new b();
  public HandlerThread a = new HandlerThread("Vending-LogicThread");
  private Handler b;
  
  private b()
  {
    this.a.start();
    this.b = new Handler(this.a.getLooper());
  }
  
  public static b cLg()
  {
    return wug;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.b
 * JD-Core Version:    0.7.0.1
 */