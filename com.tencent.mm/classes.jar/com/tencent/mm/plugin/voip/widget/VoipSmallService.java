package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class VoipSmallService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(5167);
    ab.i("MicroMsg.VoipSmallService", "VoipSmallService onBind");
    paramIntent = (Notification)paramIntent.getParcelableExtra("notification");
    if ((b.fv(26)) && (paramIntent != null)) {
      startForeground(40, paramIntent);
    }
    AppMethodBeat.o(5167);
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(5169);
    ab.i("MicroMsg.VoipSmallService", "VoipSmallService onCreate");
    AppMethodBeat.o(5169);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(5170);
    ab.i("MicroMsg.VoipSmallService", "VoipSmallService onDestroy");
    AppMethodBeat.o(5170);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(5168);
    ab.i("MicroMsg.VoipSmallService", "VoipSmallService onUnbind");
    stopSelf();
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(5168);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipSmallService
 * JD-Core Version:    0.7.0.1
 */