package com.tencent.mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.y;

public class TalkRoomService
  extends Service
{
  private g pAj;
  
  static
  {
    y.i("MicroMsg.TalkRoomService", Thread.currentThread().getId());
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    y.d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
    return this.pAj;
  }
  
  public void onCreate()
  {
    y.d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    if (Build.VERSION.SDK_INT < 18) {
      startForeground(9999, new Notification());
    }
    if (this.pAj == null) {
      this.pAj = new g();
    }
  }
  
  public void onDestroy()
  {
    y.d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    y.d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    y.d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.TalkRoomService
 * JD-Core Version:    0.7.0.1
 */