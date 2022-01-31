package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.t;

final class bq
  extends Handler
{
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      int i = paramMessage.what;
      Log.e("TransformedResultImpl", 70 + "TransformationResultHandler received unknown message type: " + i);
      return;
    case 0: 
      t localt1 = (t)paramMessage.obj;
      paramMessage = bp.f(this.Pw);
      if (localt1 == null) {}
      for (;;)
      {
        try
        {
          bp.a(bp.g(this.Pw), new Status(13, "Transform returned null"));
          return;
        }
        finally {}
        if ((localt2 instanceof bk)) {
          bp.a(bp.g(this.Pw), ((bk)localt2).gC());
        } else {
          bp.g(this.Pw).a(localt2);
        }
      }
    }
    RuntimeException localRuntimeException = (RuntimeException)paramMessage.obj;
    paramMessage = String.valueOf(localRuntimeException.getMessage());
    if (paramMessage.length() != 0) {}
    for (paramMessage = "Runtime exception on the transformation worker thread: ".concat(paramMessage);; paramMessage = new String("Runtime exception on the transformation worker thread: "))
    {
      Log.e("TransformedResultImpl", paramMessage);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bq
 * JD-Core Version:    0.7.0.1
 */