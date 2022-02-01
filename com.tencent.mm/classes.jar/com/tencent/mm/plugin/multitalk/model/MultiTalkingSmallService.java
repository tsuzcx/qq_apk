package com.tencent.mm.plugin.multitalk.model;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;

public class MultiTalkingSmallService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(114612);
    ad.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onBind");
    paramIntent = (Notification)paramIntent.getParcelableExtra("notification");
    if ((d.ly(26)) && (paramIntent != null)) {
      startForeground(43, paramIntent);
    }
    AppMethodBeat.o(114612);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(114614);
    ad.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onCreate");
    AppMethodBeat.o(114614);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(114615);
    ad.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onDestroy");
    AppMethodBeat.o(114615);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(114613);
    ad.i("MicroMsg.MultiTalkingSmallService", "MultiTalkingSmallService onUnbind");
    stopSelf();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(114613);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.MultiTalkingSmallService
 * JD-Core Version:    0.7.0.1
 */