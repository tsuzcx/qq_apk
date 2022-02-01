package com.tencent.mm.pluginsdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  private CountDownLatch Fcr = null;
  
  public final void c(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(30934);
    ae.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.Fcr == null) {
      this.Fcr = new CountDownLatch(1);
    }
    ar.f(paramRunnable);
    ae.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.Fcr != null) {
      try
      {
        this.Fcr.await(paramLong, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(30934);
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        ae.w("MicroMsg.SyncJob", paramRunnable.getMessage());
        ae.printErrStackTrace("MicroMsg.SyncJob", paramRunnable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30934);
  }
  
  public final void countDown()
  {
    AppMethodBeat.i(30933);
    if (this.Fcr != null)
    {
      this.Fcr.countDown();
      this.Fcr = null;
    }
    AppMethodBeat.o(30933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.b
 * JD-Core Version:    0.7.0.1
 */