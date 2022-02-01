package com.tencent.mm.pluginsdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  private CountDownLatch DfX = null;
  
  public final void c(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(30934);
    ac.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.DfX == null) {
      this.DfX = new CountDownLatch(1);
    }
    ap.f(paramRunnable);
    ac.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.DfX != null) {
      try
      {
        this.DfX.await(paramLong, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(30934);
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        ac.w("MicroMsg.SyncJob", paramRunnable.getMessage());
        ac.printErrStackTrace("MicroMsg.SyncJob", paramRunnable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30934);
  }
  
  public final void countDown()
  {
    AppMethodBeat.i(30933);
    if (this.DfX != null)
    {
      this.DfX.countDown();
      this.DfX = null;
    }
    AppMethodBeat.o(30933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.b
 * JD-Core Version:    0.7.0.1
 */