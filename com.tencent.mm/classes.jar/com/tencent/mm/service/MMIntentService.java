package com.tencent.mm.service;

import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class MMIntentService
  extends MMService
{
  private String mName;
  private volatile Looper ytH;
  private volatile a ytI;
  
  public MMIntentService(String paramString)
  {
    this.mName = paramString;
  }
  
  public final void onCreate()
  {
    super.onCreate();
    HandlerThread localHandlerThread = new HandlerThread("IntentService[" + this.mName + "]");
    localHandlerThread.start();
    this.ytH = localHandlerThread.getLooper();
    this.ytI = new a(this.ytH);
  }
  
  public final void onDestroy()
  {
    this.ytH.quit();
  }
  
  protected abstract void onHandleIntent(Intent paramIntent);
  
  public final void onStart(Intent paramIntent, int paramInt)
  {
    Message localMessage = this.ytI.obtainMessage();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramIntent;
    this.ytI.sendMessage(localMessage);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    onStart(paramIntent, paramInt2);
    return 2;
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(115272);
      MMIntentService.this.onHandleIntent((Intent)paramMessage.obj);
      MMIntentService localMMIntentService = MMIntentService.this;
      int i = paramMessage.arg1;
      ab.i(localMMIntentService.getTag(), "%s stopSelf() startId = %d mStartId = %d", new Object[] { "MicroMsg.MMService", Integer.valueOf(i), Integer.valueOf(localMMIntentService.bOJ) });
      if (i == localMMIntentService.bOJ) {
        localMMIntentService.q(new Intent(), "stop");
      }
      AppMethodBeat.o(115272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.service.MMIntentService
 * JD-Core Version:    0.7.0.1
 */