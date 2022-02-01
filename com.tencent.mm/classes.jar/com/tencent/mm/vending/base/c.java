package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
{
  private Looper QZA;
  private Handler QZB;
  byte[] QZC;
  a QZD;
  private Handler mVendingHandler;
  private Looper mVendingLooper;
  
  public c(Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(74945);
    this.QZC = new byte[0];
    this.QZA = paramLooper1;
    this.mVendingLooper = paramLooper2;
    this.QZB = new Handler(this.QZA)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74959);
        c.this.t(paramAnonymousMessage.what, paramAnonymousMessage.obj);
        AppMethodBeat.o(74959);
      }
    };
    this.mVendingHandler = new Handler(this.mVendingLooper)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74950);
        synchronized (c.this.QZC)
        {
          if (c.this.QZD != null) {
            c.this.QZD.synchronizing(paramAnonymousMessage.what, paramAnonymousMessage.obj);
          }
          c.this.QZC.notify();
          AppMethodBeat.o(74950);
          return;
        }
      }
    };
    AppMethodBeat.o(74945);
  }
  
  public final void t(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(74946);
    if (Looper.myLooper() == this.QZA)
    {
      if (this.QZD == null)
      {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
        AppMethodBeat.o(74946);
        return;
      }
      this.QZD.hds();
      synchronized (this.QZC)
      {
        this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(paramInt, paramObject));
      }
    }
    try
    {
      this.QZC.wait();
      label79:
      this.QZD.hdt();
      AppMethodBeat.o(74946);
      return;
      paramObject = finally;
      AppMethodBeat.o(74946);
      throw paramObject;
      if (Looper.myLooper() == this.mVendingLooper)
      {
        this.QZB.sendMessageAtFrontOfQueue(this.QZB.obtainMessage(paramInt, paramObject));
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
    public abstract void hds();
    
    public abstract void hdt();
    
    public abstract void synchronizing(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */