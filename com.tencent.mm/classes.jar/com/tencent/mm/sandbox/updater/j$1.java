package com.tencent.mm.sandbox.updater;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;

final class j$1
  implements Runnable
{
  j$1(j paramj, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(32765);
    ((NotificationManager)this.acoI.mContext.getSystemService("notification")).cancel(99);
    Log.d("MicroMsg.UpdaterManager", "finishType == " + this.acoH);
    if ((this.acoH == 2) && (this.acoI.acmZ == 1))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
      this.acoI.mContext.sendBroadcast(localIntent, WeChatPermissions.PERMISSION_MM_MESSAGE());
    }
    AppMethodBeat.o(32765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.j.1
 * JD-Core Version:    0.7.0.1
 */