package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.y;

public class VoipSmallService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    y.i("MicroMsg.VoipSmallService", "VoipSmallService onBind");
    return null;
  }
  
  public void onCreate()
  {
    y.i("MicroMsg.VoipSmallService", "VoipSmallService onCreate");
    startForeground(-1234, new Notification());
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.VoipSmallService", "VoipSmallService onDestroy");
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    y.i("MicroMsg.VoipSmallService", "VoipSmallService onUnbind");
    stopSelf();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipSmallService
 * JD-Core Version:    0.7.0.1
 */