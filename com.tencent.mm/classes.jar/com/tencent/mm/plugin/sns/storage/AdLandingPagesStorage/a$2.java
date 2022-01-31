package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

final class a$2
  extends ak
{
  a$2(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(36927);
    if (paramMessage.what == 10008)
    {
      ab.i("MicroMsg.AdDownloadApkMgr", "unregister package receiver");
      ah.getContext().unregisterReceiver(this.rrw.rrp);
      this.rrw.rrq = false;
    }
    AppMethodBeat.o(36927);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.2
 * JD-Core Version:    0.7.0.1
 */