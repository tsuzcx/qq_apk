package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.api.x;

public final class l<R extends w>
  extends Handler
{
  public l()
  {
    this(Looper.getMainLooper());
  }
  
  public l(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void a(x<? super R> paramx, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramx, paramR)));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      Log.wtf("BasePendingResult", 45 + "Don't know how to handle message: " + i, new Exception());
      return;
    case 1: 
      Object localObject = (Pair)paramMessage.obj;
      paramMessage = (x)((Pair)localObject).first;
      localObject = (w)((Pair)localObject).second;
      try
      {
        paramMessage.a((w)localObject);
        return;
      }
      catch (RuntimeException paramMessage)
      {
        k.d((w)localObject);
        throw paramMessage;
      }
    }
    ((k)paramMessage.obj).b(Status.HO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.l
 * JD-Core Version:    0.7.0.1
 */