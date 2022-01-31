package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class a
{
  private static a wuf = new a();
  public HandlerThread a = new HandlerThread("Vending-HeavyWorkThread", 10);
  private Handler b;
  
  private a()
  {
    this.a.start();
    this.b = new Handler(this.a.getLooper());
  }
  
  public static a cLf()
  {
    return wuf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.i.a
 * JD-Core Version:    0.7.0.1
 */