package com.tencent.mm.pluginsdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  private CountDownLatch BNN = null;
  
  public final void b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(30934);
    ad.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.BNN == null) {
      this.BNN = new CountDownLatch(1);
    }
    aq.f(paramRunnable);
    ad.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.BNN != null) {
      try
      {
        this.BNN.await(paramLong, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(30934);
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        ad.w("MicroMsg.SyncJob", paramRunnable.getMessage());
        ad.printErrStackTrace("MicroMsg.SyncJob", paramRunnable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30934);
  }
  
  public final void countDown()
  {
    AppMethodBeat.i(30933);
    if (this.BNN != null)
    {
      this.BNN.countDown();
      this.BNN = null;
    }
    AppMethodBeat.o(30933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.b
 * JD-Core Version:    0.7.0.1
 */