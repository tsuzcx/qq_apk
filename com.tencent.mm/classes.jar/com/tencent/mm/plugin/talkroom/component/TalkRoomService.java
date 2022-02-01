package com.tencent.mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class TalkRoomService
  extends Service
{
  private g yIq;
  
  static
  {
    AppMethodBeat.i(29430);
    ad.i("MicroMsg.TalkRoomService", Thread.currentThread().getId());
    AppMethodBeat.o(29430);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(29428);
    ad.d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
    paramIntent = this.yIq;
    AppMethodBeat.o(29428);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(29425);
    ad.d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    if (Build.VERSION.SDK_INT < 18) {
      startForeground(9999, new Notification());
    }
    if (this.yIq == null) {
      this.yIq = new g();
    }
    AppMethodBeat.o(29425);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29426);
    ad.d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
    super.onDestroy();
    AppMethodBeat.o(29426);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(29429);
    ad.d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
    AppMethodBeat.o(29429);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(29427);
    ad.d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(29427);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.TalkRoomService
 * JD-Core Version:    0.7.0.1
 */