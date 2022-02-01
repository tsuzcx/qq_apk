package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class ao
  extends Handler
{
  ao(am paramam, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      Log.w("GACStateManager", 31 + "Unknown message id: " + i);
      return;
    case 1: 
      ((an)paramMessage.obj).c(this.Qe);
      return;
    }
    throw ((RuntimeException)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ao
 * JD-Core Version:    0.7.0.1
 */