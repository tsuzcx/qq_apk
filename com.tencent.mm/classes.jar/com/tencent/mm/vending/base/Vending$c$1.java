package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

final class Vending$c$1
  extends Handler
{
  Vending$c$1(Vending.c paramc, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message arg1)
  {
    if (this.wtd.wtc.get())
    {
      this.wtd.wtb.cancel();
      return;
    }
    Object localObject1 = ???.obj;
    this.wtd.wtb.cf(localObject1);
    synchronized (this.wtd.b)
    {
      this.wtd.a.put(localObject1, Vending.c.b.wtg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.c.1
 * JD-Core Version:    0.7.0.1
 */