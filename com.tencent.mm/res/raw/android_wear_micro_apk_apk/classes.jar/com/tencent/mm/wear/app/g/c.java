package com.tencent.mm.wear.app.g;

import java.util.concurrent.BlockingQueue;

final class c
  implements Runnable
{
  private boolean ahs;
  
  private c(b paramb) {}
  
  public final void run()
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMWorker", "start worker runnable %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    try
    {
      for (;;)
      {
        a locala = (a)b.a(this.amq).take();
        if (this.ahs) {
          break;
        }
        if (locala != null) {
          try
          {
            locala.run();
          }
          catch (Exception localException)
          {
            com.tencent.mm.wear.a.c.d.a("MicroMsg.MMWorker", localException);
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Object localObject = null;
      }
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMWorker", "stop worker runnable %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
    }
  }
  
  public final void stop()
  {
    this.ahs = true;
    b.a(this.amq).add(new d(this, (byte)0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.g.c
 * JD-Core Version:    0.7.0.1
 */