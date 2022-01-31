package com.tencent.qqmusic.mediaplayer.util;

public class WaitNotify
{
  private static final String TAG = "WaitNotify";
  private volatile boolean isWaiting = false;
  private MonitorObject myMonitorObject = new MonitorObject();
  private volatile boolean wasSignalled = false;
  
  public void doNotify()
  {
    Logger.d("WaitNotify", "doNotify " + Thread.currentThread().getName());
    synchronized (this.myMonitorObject)
    {
      this.wasSignalled = true;
      Logger.d("WaitNotify", "doNotify internal " + Thread.currentThread().getName());
      this.myMonitorObject.notifyAll();
      Logger.d("WaitNotify", "doNotify over " + Thread.currentThread().getName());
      return;
    }
  }
  
  public void doWait()
  {
    Logger.d("WaitNotify", "doWait " + Thread.currentThread().getName());
    synchronized (this.myMonitorObject)
    {
      this.wasSignalled = false;
      for (;;)
      {
        boolean bool = this.wasSignalled;
        if (!bool) {
          try
          {
            Logger.d("WaitNotify", "doWait internal " + Thread.currentThread().getName());
            this.isWaiting = true;
            this.myMonitorObject.wait();
            Logger.d("WaitNotify", "doWait wake " + Thread.currentThread().getName());
          }
          catch (InterruptedException localInterruptedException)
          {
            Logger.e("WaitNotify", localInterruptedException.toString());
          }
        }
      }
    }
    this.isWaiting = false;
  }
  
  public boolean isWaiting()
  {
    return this.isWaiting;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.WaitNotify
 * JD-Core Version:    0.7.0.1
 */