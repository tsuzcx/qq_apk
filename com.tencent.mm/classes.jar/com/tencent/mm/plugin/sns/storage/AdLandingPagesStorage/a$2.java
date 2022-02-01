package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class a$2
  extends MMHandler
{
  a$2(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(96291);
    if (paramMessage.what == 10008) {
      Log.w("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.QIE.QIx);
      this.QIE.QIy = false;
      AppMethodBeat.o(96291);
      return;
    }
    catch (Exception paramMessage)
    {
      for (;;)
      {
        Log.e("MicroMsg.AdDownloadApkMgr", "unregister package receiver, exp=" + paramMessage.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.2
 * JD-Core Version:    0.7.0.1
 */