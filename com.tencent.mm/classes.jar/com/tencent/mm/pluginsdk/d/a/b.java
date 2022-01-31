package com.tencent.mm.pluginsdk.d.a;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  private CountDownLatch rSV = null;
  
  public final void b(long paramLong, Runnable paramRunnable)
  {
    y.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.rSV == null) {
      this.rSV = new CountDownLatch(1);
    }
    ai.d(paramRunnable);
    y.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.rSV != null) {}
    try
    {
      this.rSV.await(paramLong, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException paramRunnable)
    {
      y.w("MicroMsg.SyncJob", paramRunnable.getMessage());
      y.printErrStackTrace("MicroMsg.SyncJob", paramRunnable, "", new Object[0]);
    }
  }
  
  public final void countDown()
  {
    if (this.rSV != null)
    {
      this.rSV.countDown();
      this.rSV = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.b
 * JD-Core Version:    0.7.0.1
 */