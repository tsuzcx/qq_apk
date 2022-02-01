package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RemoteService
  extends Service
{
  private c.a ackY;
  
  public RemoteService()
  {
    AppMethodBeat.i(152742);
    this.ackY = new RemoteService.1(this);
    AppMethodBeat.o(152742);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(152743);
    new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
    paramIntent = this.ackY;
    AppMethodBeat.o(152743);
    return paramIntent;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(152746);
    new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
    super.onDestroy();
    AppMethodBeat.o(152746);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(152744);
    new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
    super.onRebind(paramIntent);
    AppMethodBeat.o(152744);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(152745);
    new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(152745);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.remoteservice.RemoteService
 * JD-Core Version:    0.7.0.1
 */