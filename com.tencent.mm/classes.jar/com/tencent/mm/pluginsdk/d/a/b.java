package com.tencent.mm.pluginsdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  private CountDownLatch vJT = null;
  
  public final void b(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(27231);
    ab.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.vJT == null) {
      this.vJT = new CountDownLatch(1);
    }
    al.d(paramRunnable);
    ab.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.vJT != null) {
      try
      {
        this.vJT.await(paramLong, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(27231);
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        ab.w("MicroMsg.SyncJob", paramRunnable.getMessage());
        ab.printErrStackTrace("MicroMsg.SyncJob", paramRunnable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(27231);
  }
  
  public final void countDown()
  {
    AppMethodBeat.i(27230);
    if (this.vJT != null)
    {
      this.vJT.countDown();
      this.vJT = null;
    }
    AppMethodBeat.o(27230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.b
 * JD-Core Version:    0.7.0.1
 */