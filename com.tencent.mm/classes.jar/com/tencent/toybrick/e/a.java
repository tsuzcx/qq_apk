package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.HandlerThread;

public final class a
{
  private static a xbs = new a();
  private HandlerThread mThread;
  private a xbt;
  private Handler xbu;
  
  public static a cRa()
  {
    return xbs;
  }
  
  public final void execute(Runnable paramRunnable)
  {
    if (this.xbt == null)
    {
      if ((this.mThread == null) || (!this.mThread.isAlive()))
      {
        this.mThread = new HandlerThread("WhenHandler");
        this.mThread.start();
        this.xbu = new Handler(this.mThread.getLooper());
      }
      this.xbu.post(paramRunnable);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.toybrick.e.a
 * JD-Core Version:    0.7.0.1
 */