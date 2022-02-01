package com.tencent.mm.pluginsdk.model;

import android.app.PendingIntent;
import android.app.PendingIntent.OnFinished;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class q$1
  implements PendingIntent.OnFinished
{
  q$1(q paramq) {}
  
  public final void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(217549);
    ae.i("MicroMsg.QQBrowserHelper", "onSendFinished resultCode: %d, , resultData: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    AppMethodBeat.o(217549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.q.1
 * JD-Core Version:    0.7.0.1
 */