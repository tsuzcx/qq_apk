package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WaitNotify
{
  private static final String TAG = "WaitNotify";
  private volatile boolean isWaiting;
  private final MonitorObject myMonitorObject;
  private volatile boolean wasSignalled;
  
  public WaitNotify()
  {
    AppMethodBeat.i(114159);
    this.myMonitorObject = new MonitorObject();
    this.wasSignalled = false;
    this.isWaiting = false;
    AppMethodBeat.o(114159);
  }
  
  public void doNotify()
  {
    AppMethodBeat.i(114162);
    Logger.d("WaitNotify", "doNotify " + Thread.currentThread().getName());
    synchronized (this.myMonitorObject)
    {
      this.wasSignalled = true;
      Logger.d("WaitNotify", "doNotify internal " + Thread.currentThread().getName());
      this.myMonitorObject.notifyAll();
      Logger.d("WaitNotify", "doNotify over " + Thread.currentThread().getName());
      AppMethodBeat.o(114162);
      return;
    }
  }
  
  public void doWait()
  {
    AppMethodBeat.i(114160);
    doWait(9223372036854775807L, 0, new WaitListener()
    {
      public boolean keepWaiting()
      {
        return true;
      }
    });
    AppMethodBeat.o(114160);
  }
  
  public void doWait(long paramLong, int paramInt, WaitListener paramWaitListener)
  {
    AppMethodBeat.i(114161);
    Logger.d("WaitNotify", "doWait " + Thread.currentThread().getName());
    synchronized (this.myMonitorObject)
    {
      this.wasSignalled = false;
      int i = 0;
      boolean bool = this.wasSignalled;
      if (!bool) {}
      try
      {
        Logger.d("WaitNotify", "doWait internal " + Thread.currentThread().getName() + " " + i);
        this.isWaiting = true;
        if (i < paramInt)
        {
          this.myMonitorObject.wait(paramLong, 0);
          if (!paramWaitListener.keepWaiting())
          {
            doNotify();
            this.isWaiting = false;
            AppMethodBeat.o(114161);
          }
        }
        else
        {
          this.myMonitorObject.wait();
        }
        Logger.d("WaitNotify", "doWait wake " + Thread.currentThread().getName() + " " + i);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Logger.e("WaitNotify", localInterruptedException.toString());
        }
      }
      i += 1;
    }
  }
  
  public boolean isWaiting()
  {
    return this.isWaiting;
  }
  
  public static abstract interface WaitListener
  {
    public abstract boolean keepWaiting();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.WaitNotify
 * JD-Core Version:    0.7.0.1
 */