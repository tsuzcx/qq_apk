package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
{
  private Looper LhD;
  private Handler LhE;
  byte[] LhF;
  a LhG;
  private Handler mVendingHandler;
  private Looper mVendingLooper;
  
  public c(Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(74945);
    this.LhF = new byte[0];
    this.LhD = paramLooper1;
    this.mVendingLooper = paramLooper2;
    this.LhE = new Handler(this.LhD)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74959);
        c.this.q(paramAnonymousMessage.what, paramAnonymousMessage.obj);
        AppMethodBeat.o(74959);
      }
    };
    this.mVendingHandler = new Handler(this.mVendingLooper)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74950);
        synchronized (c.this.LhF)
        {
          if (c.this.LhG != null) {
            c.this.LhG.synchronizing(paramAnonymousMessage.what, paramAnonymousMessage.obj);
          }
          c.this.LhF.notify();
          AppMethodBeat.o(74950);
          return;
        }
      }
    };
    AppMethodBeat.o(74945);
  }
  
  public final void q(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(74946);
    if (Looper.myLooper() == this.LhD)
    {
      if (this.LhG == null)
      {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
        AppMethodBeat.o(74946);
        return;
      }
      this.LhG.fNT();
      synchronized (this.LhF)
      {
        this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(paramInt, paramObject));
      }
    }
    try
    {
      this.LhF.wait();
      label79:
      this.LhG.fNU();
      AppMethodBeat.o(74946);
      return;
      paramObject = finally;
      AppMethodBeat.o(74946);
      throw paramObject;
      if (Looper.myLooper() == this.mVendingLooper)
      {
        this.LhE.sendMessageAtFrontOfQueue(this.LhE.obtainMessage(paramInt, paramObject));
        AppMethodBeat.o(74946);
        return;
      }
      AppMethodBeat.o(74946);
      return;
    }
    catch (InterruptedException paramObject)
    {
      break label79;
    }
  }
  
  public static abstract interface a
  {
    public abstract void fNT();
    
    public abstract void fNU();
    
    public abstract void synchronizing(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */