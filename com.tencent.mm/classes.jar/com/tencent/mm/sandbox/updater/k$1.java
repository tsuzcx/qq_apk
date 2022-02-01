package com.tencent.mm.sandbox.updater;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class k$1
  implements Runnable
{
  k$1(k paramk, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(32765);
    ((NotificationManager)this.Isz.mContext.getSystemService("notification")).cancel(99);
    ae.d("MicroMsg.UpdaterManager", "finishType == " + this.Isy);
    if ((this.Isy == 2) && (this.Isz.IqR == 1))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
      this.Isz.mContext.sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
    }
    AppMethodBeat.o(32765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.k.1
 * JD-Core Version:    0.7.0.1
 */