package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RemoteService
  extends Service
{
  private c.a yis;
  
  public RemoteService()
  {
    AppMethodBeat.i(80225);
    this.yis = new RemoteService.1(this);
    AppMethodBeat.o(80225);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(80226);
    new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
    paramIntent = this.yis;
    AppMethodBeat.o(80226);
    return paramIntent;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80229);
    new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
    super.onDestroy();
    AppMethodBeat.o(80229);
  }
  
  public void onRebind(Intent paramIntent)
  {
    AppMethodBeat.i(80227);
    new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
    super.onRebind(paramIntent);
    AppMethodBeat.o(80227);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    AppMethodBeat.i(80228);
    new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
    boolean bool = super.onUnbind(paramIntent);
    AppMethodBeat.o(80228);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.remoteservice.RemoteService
 * JD-Core Version:    0.7.0.1
 */