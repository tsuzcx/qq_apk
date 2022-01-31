package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.y;

public class VoipForegroundService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    y.i("MicroMsg.VoipForegroundService", "VoipForegroundService onBind");
    return null;
  }
  
  public void onCreate()
  {
    y.i("MicroMsg.VoipForegroundService", "VoipForegroundService onCreate");
    startForeground(-1235, new Notification());
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.VoipForegroundService", "VoipForegroundService onDestroy");
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    y.i("MicroMsg.VoipForegroundService", "VoipForegroundService onUnbind");
    stopSelf();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoipForegroundService
 * JD-Core Version:    0.7.0.1
 */