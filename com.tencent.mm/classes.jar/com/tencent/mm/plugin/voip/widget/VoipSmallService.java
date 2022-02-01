package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;

public class VoipSmallService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(115792);
    ad.i("MicroMsg.VoipSmallService", "VoipSmallService onBind");
    paramIntent = (Notification)paramIntent.getParcelableExtra("notification");
    if ((d.ly(26)) && (paramIntent != null)) {
      startForeground(40, paramIntent);
    }
    AppMethodBeat.o(115792);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(115794);
    ad.i("MicroMsg.VoipSmallService", "VoipSmallService onCreate");
    AppMethodBeat.o(115794);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115795);
    ad.i("MicroMsg.VoipSmallService", "VoipSmallService onDestroy");
    AppMethodBeat.o(115795);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(115793);
    ad.i("MicroMsg.VoipSmallService", "VoipSmallService onUnbind");
    stopSelf();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(115793);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipSmallService
 * JD-Core Version:    0.7.0.1
 */