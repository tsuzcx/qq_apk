package com.tencent.mm.service;

import android.content.Intent;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public abstract class MMIntentService
  extends MMService
{
  private volatile a IiV;
  private String mName;
  
  public MMIntentService(String paramString)
  {
    this.mName = paramString;
  }
  
  public final void onCreate()
  {
    super.onCreate();
    this.IiV = new a(a.aZF("close-db-while-crash"));
  }
  
  public final void onDestroy()
  {
    this.IiV.getSerial().quit();
  }
  
  protected abstract void onHandleIntent(Intent paramIntent);
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    Message localMessage = this.IiV.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramIntent;
    this.IiV.sendMessage(localMessage);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return 2;
  }
  
  final class a
    extends ap
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
      ad.i(localMMIntentService.getTag(), "%s stopSelf() startId = %d mStartId = %d", new Object[] { "MicroMsg.MMService", Integer.valueOf(i), Integer.valueOf(localMMIntentService.cFz) });
      if (i == localMMIntentService.cFz) {
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