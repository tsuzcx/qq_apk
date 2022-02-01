package com.tencent.mm.pluginsdk.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  private CountDownLatch QSv = null;
  
  public final void Sz()
  {
    AppMethodBeat.i(30933);
    if (this.QSv != null)
    {
      this.QSv.countDown();
      this.QSv = null;
    }
    AppMethodBeat.o(30933);
  }
  
  public final void c(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(30934);
    Log.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.QSv == null) {
      this.QSv = new CountDownLatch(1);
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    Log.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.QSv != null) {
      try
      {
        this.QSv.await(paramLong, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(30934);
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        Log.w("MicroMsg.SyncJob", paramRunnable.getMessage());
        Log.printErrStackTrace("MicroMsg.SyncJob", paramRunnable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(30934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.e.a.b
 * JD-Core Version:    0.7.0.1
 */