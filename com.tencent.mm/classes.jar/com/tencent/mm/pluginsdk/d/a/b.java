package com.tencent.mm.pluginsdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b
{
  private CountDownLatch JTq = null;
  
  public final void c(long paramLong, Runnable paramRunnable)
  {
    AppMethodBeat.i(30934);
    Log.i("MicroMsg.SyncJob", "doAsSyncJob");
    if (this.JTq == null) {
      this.JTq = new CountDownLatch(1);
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    Log.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
    if (this.JTq != null) {
      try
      {
        this.JTq.await(paramLong, TimeUnit.MILLISECONDS);
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
  
  public final void countDown()
  {
    AppMethodBeat.i(30933);
    if (this.JTq != null)
    {
      this.JTq.countDown();
      this.JTq = null;
    }
    AppMethodBeat.o(30933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.a.b
 * JD-Core Version:    0.7.0.1
 */