package com.tencent.mm.vending.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.vending.f.a;

public final class n
{
  private Handler acp;
  private Looper adf;
  private Looper adg;
  private Handler adh;
  private byte[] adi = new byte[0];
  private o adj;
  
  public n(Looper paramLooper1, Looper paramLooper2)
  {
    this.adf = paramLooper1;
    this.adg = paramLooper2;
    this.adh = new Handler(this.adf)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        n.this.b(paramAnonymousMessage.what, paramAnonymousMessage.obj);
      }
    };
    this.acp = new Handler(this.adg)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        synchronized (n.a(n.this))
        {
          if (n.b(n.this) != null)
          {
            o localo = n.b(n.this);
            int i = paramAnonymousMessage.what;
            paramAnonymousMessage = paramAnonymousMessage.obj;
            localo.mg();
          }
          n.a(n.this).notify();
          return;
        }
      }
    };
  }
  
  public final void a(o paramo)
  {
    this.adj = paramo;
  }
  
  public final void b(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == this.adf) {
      if (this.adj == null) {
        a.mp();
      }
    }
    while (Looper.myLooper() != this.adg)
    {
      return;
      this.adj.mf();
      synchronized (this.adi)
      {
        this.acp.sendMessageAtFrontOfQueue(this.acp.obtainMessage(paramInt, paramObject));
        try
        {
          this.adi.wait();
          this.adj.mh();
          return;
        }
        catch (InterruptedException paramObject)
        {
          for (;;)
          {
            paramObject.printStackTrace();
          }
        }
      }
    }
    this.adh.sendMessageAtFrontOfQueue(this.adh.obtainMessage(paramInt, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.a.n
 * JD-Core Version:    0.7.0.1
 */