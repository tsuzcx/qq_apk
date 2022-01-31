package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class c$2
  extends Handler
{
  c$2(c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    synchronized (this.a.e)
    {
      if (this.a.wtm != null) {
        this.a.wtm.synchronizing(paramMessage.what, paramMessage.obj);
      }
      this.a.e.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.c.2
 * JD-Core Version:    0.7.0.1
 */