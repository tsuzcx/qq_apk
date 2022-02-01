package com.tencent.mm.service;

import android.content.Intent;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public abstract class MMIntentService
  extends MMService
{
  private volatile a IDg;
  private String mName;
  
  public MMIntentService(String paramString)
  {
    this.mName = paramString;
  }
  
  public final void onCreate()
  {
    super.onCreate();
    this.IDg = new a(a.bbi("close-db-while-crash"));
  }
  
  public final void onDestroy()
  {
    this.IDg.getSerial().quit();
  }
  
  protected abstract void onHandleIntent(Intent paramIntent);
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    Message localMessage = this.IDg.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramIntent;
    this.IDg.sendMessage(localMessage);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return 2;
  }
  
  final class a
    extends aq
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
      ae.i(localMMIntentService.getTag(), "%s stopSelf() startId = %d mStartId = %d", new Object[] { "MicroMsg.MMService", Integer.valueOf(i), Integer.valueOf(localMMIntentService.cGi) });
      if (i == localMMIntentService.cGi) {
        localMMIntentService.s(new Intent(), "stop");
      }
      AppMethodBeat.o(125309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.service.MMIntentService
 * JD-Core Version:    0.7.0.1
 */