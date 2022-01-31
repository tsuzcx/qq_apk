package com.tencent.mm.vending.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class n
{
  private Handler YP;
  private Looper ZF;
  private Looper ZG;
  private Handler ZH;
  private byte[] ZI = new byte[0];
  private o ZJ;
  
  public n(Looper paramLooper1, Looper paramLooper2)
  {
    this.ZF = paramLooper1;
    this.ZG = paramLooper2;
    this.ZH = new Handler(this.ZF)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        n.this.b(paramAnonymousMessage.what, paramAnonymousMessage.obj);
      }
    };
    this.YP = new Handler(this.ZG)
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
            localo.lz();
          }
          n.a(n.this).notify();
          return;
        }
      }
    };
  }
  
  public final void a(o paramo)
  {
    this.ZJ = paramo;
  }
  
  public final void b(int paramInt, Object paramObject)
  {
    if (Looper.myLooper() == this.ZF) {
      if (this.ZJ != null) {}
    }
    while (Looper.myLooper() != this.ZG)
    {
      return;
      this.ZJ.ly();
      synchronized (this.ZI)
      {
        this.YP.sendMessageAtFrontOfQueue(this.YP.obtainMessage(paramInt, paramObject));
        try
        {
          this.ZI.wait();
          this.ZJ.lA();
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
    this.ZH.sendMessageAtFrontOfQueue(this.ZH.obtainMessage(paramInt, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.a.n
 * JD-Core Version:    0.7.0.1
 */