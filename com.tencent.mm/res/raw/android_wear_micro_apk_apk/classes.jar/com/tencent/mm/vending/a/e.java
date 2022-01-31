package com.tencent.mm.vending.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e<_Index>
{
  private Handler YX;
  HashMap<_Index, g> Zm = new HashMap();
  private f<_Index> Zn = null;
  private AtomicBoolean Zo = new AtomicBoolean(false);
  byte[] Zp = new byte[0];
  
  protected e(Looper paramLooper, f<_Index> paramf)
  {
    this.Zn = paramf;
    this.YX = new Handler(paramLooper)
    {
      public final void handleMessage(Message arg1)
      {
        if (e.a(e.this).get())
        {
          e.b(e.this).cancel();
          return;
        }
        Object localObject1 = ???.obj;
        e.b(e.this).K(localObject1);
        synchronized (e.this.Zp)
        {
          e.this.Zm.put(localObject1, g.Zt);
          return;
        }
      }
    };
  }
  
  protected final void L(_Index param_Index)
  {
    if (this.Zo.get()) {
      return;
    }
    synchronized (this.Zp)
    {
      this.Zm.put(param_Index, g.Zs);
      this.YX.sendMessageAtFrontOfQueue(this.YX.obtainMessage(0, param_Index));
      return;
    }
  }
  
  protected final void lB()
  {
    this.YX.removeCallbacksAndMessages(null);
    synchronized (this.Zp)
    {
      this.Zm.clear();
      this.Zn.cancel();
      return;
    }
  }
  
  protected final void stop()
  {
    this.Zo.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.a.e
 * JD-Core Version:    0.7.0.1
 */