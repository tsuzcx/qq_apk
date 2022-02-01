package com.tencent.mm.sdk;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mm.sdk.b.a.c;
import com.tencent.mm.sdk.b.d;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.l;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends k
{
  private String YF = null;
  HashMap<b, LinkedList<Runnable>> YG = new HashMap();
  
  public a(Looper paramLooper, l paraml)
  {
    super(paramLooper, paraml);
  }
  
  public a(l paraml)
  {
    super(paraml);
  }
  
  public a(String paramString, l paraml)
  {
    super(Looper.getMainLooper(), null, paraml);
    this.YF = paramString;
  }
  
  private boolean ll()
  {
    return !TextUtils.isEmpty(this.YF);
  }
  
  public final Looper lm()
  {
    if (ll()) {
      return null;
    }
    return super.getLooper();
  }
  
  public final boolean sendMessageAtTime(final Message paramMessage, long paramLong)
  {
    if (ll())
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          a.this.dispatchMessage(paramMessage);
          a.a(a.this, paramMessage, this);
        }
      };
      synchronized (this.YG)
      {
        b localb = new b(this, paramMessage.what, paramMessage.obj, paramMessage.getCallback());
        if (!this.YG.containsKey(localb))
        {
          HashMap localHashMap2 = this.YG;
          paramMessage = new LinkedList();
          localHashMap2.put(localb, paramMessage);
          paramMessage.add(local1);
          d.aav.a(local1, this.YF, paramLong - SystemClock.uptimeMillis());
          return true;
        }
        paramMessage = (LinkedList)this.YG.get(localb);
      }
    }
    return super.sendMessageAtTime(paramMessage, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a
 * JD-Core Version:    0.7.0.1
 */