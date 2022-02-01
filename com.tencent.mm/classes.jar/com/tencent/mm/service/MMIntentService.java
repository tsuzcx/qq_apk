package com.tencent.mm.service;

import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.j.a;

public abstract class MMIntentService
  extends MMService
{
  private volatile a acwq;
  private String mName;
  
  public MMIntentService(String paramString)
  {
    this.mName = paramString;
  }
  
  public final void onCreate()
  {
    super.onCreate();
    this.acwq = new a(a.bFV("close-db-while-crash"));
  }
  
  public final void onDestroy()
  {
    this.acwq.getSerial().quit();
  }
  
  protected abstract void onHandleIntent(Intent paramIntent);
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    Message localMessage = this.acwq.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramIntent;
    this.acwq.sendMessage(localMessage);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return 2;
  }
  
  final class a
    extends MMHandler
  {
    public a(a parama)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(125309);
      MMIntentService.this.onHandleIntent((Intent)paramMessage.obj);
      MMIntentService localMMIntentService = MMIntentService.this;
      int i = paramMessage.arg1;
      Log.i(localMMIntentService.getTag(), "%s stopSelf() startId = %d mStartId = %d", new Object[] { "MicroMsg.MMService", Integer.valueOf(i), Integer.valueOf(localMMIntentService.eZg) });
      if (i == localMMIntentService.eZg) {
        localMMIntentService.r(new Intent(), "stop");
      }
      AppMethodBeat.o(125309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.MMIntentService
 * JD-Core Version:    0.7.0.1
 */