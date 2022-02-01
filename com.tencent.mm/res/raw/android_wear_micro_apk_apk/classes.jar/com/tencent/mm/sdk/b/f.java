package com.tencent.mm.sdk.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.b.c.c;

final class f
{
  private static HandlerThread aaJ = c.H("OrderWorker");
  private static Handler aaK = new Handler(aaJ.getLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      if ((paramAnonymousMessage.what == d.aaB) && (d.lI() != null))
      {
        d.lI();
        paramAnonymousMessage = paramAnonymousMessage.obj;
      }
    }
  };
  
  static
  {
    if (!aaJ.isAlive()) {
      aaJ.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.f
 * JD-Core Version:    0.7.0.1
 */