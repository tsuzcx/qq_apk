package com.tencent.mm.vending.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.vending.f.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e<_Index>
{
  HashMap<_Index, g> acM = new HashMap();
  private f<_Index> acN = null;
  private AtomicBoolean acO = new AtomicBoolean(false);
  byte[] acP = new byte[0];
  private Handler acx;
  
  protected e(Looper paramLooper, f<_Index> paramf)
  {
    this.acN = paramf;
    this.acx = new Handler(paramLooper)
    {
      public final void handleMessage(Message arg1)
      {
        if (e.a(e.this).get())
        {
          e.b(e.this).cancel();
          return;
        }
        Object localObject1 = ???.obj;
        e.b(e.this).T(localObject1);
        synchronized (e.this.acP)
        {
          e.this.acM.put(localObject1, g.acT);
          return;
        }
      }
    };
  }
  
  protected final void U(_Index param_Index)
  {
    if (this.acO.get()) {
      return;
    }
    synchronized (this.acP)
    {
      this.acM.put(param_Index, g.acS);
      this.acx.sendMessageAtFrontOfQueue(this.acx.obtainMessage(0, param_Index));
      return;
    }
  }
  
  protected final void mi()
  {
    this.acx.removeCallbacksAndMessages(null);
    a.mq();
    synchronized (this.acP)
    {
      this.acM.clear();
      this.acN.cancel();
      return;
    }
  }
  
  protected final void stop()
  {
    this.acO.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.a.e
 * JD-Core Version:    0.7.0.1
 */