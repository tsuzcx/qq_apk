package com.tencent.mm.wear.a.b;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.wear.a.c.d;

public class a
  extends Handler
{
  public static final a amv = new a(Looper.getMainLooper());
  
  public a()
  {
    d.c("MicroMsg.MMHandler", "Create MMHandler", new Object[0]);
  }
  
  public a(Looper paramLooper)
  {
    super(paramLooper);
    d.c("MicroMsg.MMHandler", "Create MMHandler: looper=%s", new Object[] { q.O(paramLooper) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.b.a
 * JD-Core Version:    0.7.0.1
 */