package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemoteService
  extends Service
{
  private c.a uaC = new RemoteService.1(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
    return this.uaC;
  }
  
  public void onDestroy()
  {
    new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
    super.onRebind(paramIntent);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.remoteservice.RemoteService
 * JD-Core Version:    0.7.0.1
 */