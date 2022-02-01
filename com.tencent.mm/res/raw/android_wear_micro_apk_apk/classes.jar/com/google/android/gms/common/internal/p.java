package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicInteger;

final class p
  extends Handler
{
  public p(l paraml, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private static void a(Message paramMessage)
  {
    ((q)paramMessage.obj).unregister();
  }
  
  private static boolean b(Message paramMessage)
  {
    return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    PendingIntent localPendingIntent = null;
    if (this.Lz.Lw.get() != paramMessage.arg1)
    {
      if (b(paramMessage)) {
        a(paramMessage);
      }
      return;
    }
    if (((paramMessage.what == 1) || (paramMessage.what == 5)) && (!this.Lz.isConnecting()))
    {
      a(paramMessage);
      return;
    }
    if (paramMessage.what == 3)
    {
      if ((paramMessage.obj instanceof PendingIntent)) {
        localPendingIntent = (PendingIntent)paramMessage.obj;
      }
      paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
      this.Lz.Ln.c(paramMessage);
      this.Lz.a(paramMessage);
      return;
    }
    if (paramMessage.what == 4)
    {
      l.a(this.Lz, 4);
      if (l.b(this.Lz) != null) {
        l.b(this.Lz).bx(paramMessage.arg2);
      }
      this.Lz.bx(paramMessage.arg2);
      l.a(this.Lz, 4, 1, null);
      return;
    }
    if ((paramMessage.what == 2) && (!this.Lz.isConnected()))
    {
      a(paramMessage);
      return;
    }
    if (b(paramMessage))
    {
      ((q)paramMessage.obj).hu();
      return;
    }
    int i = paramMessage.what;
    Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.p
 * JD-Core Version:    0.7.0.1
 */