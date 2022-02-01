package com.tencent.mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class TalkRoomService
  extends Service
{
  private f Mjy;
  
  static
  {
    AppMethodBeat.i(29430);
    Log.i("MicroMsg.TalkRoomService", Thread.currentThread().getId());
    AppMethodBeat.o(29430);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(29428);
    Log.d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
    paramIntent = this.Mjy;
    AppMethodBeat.o(29428);
    return paramIntent;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(29425);
    Log.d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
    super.onCreate();
    if (Build.VERSION.SDK_INT < 18) {
      startForeground(9999, new Notification());
    }
    if (this.Mjy == null) {
      this.Mjy = new f();
    }
    AppMethodBeat.o(29425);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29426);
    Log.d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
    super.onDestroy();
    AppMethodBeat.o(29426);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(29429);
    Log.d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
    super.onRebind(paramIntent);
    AppMethodBeat.o(29429);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(29427);
    Log.d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(29427);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.component.TalkRoomService
 * JD-Core Version:    0.7.0.1
 */