package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
{
  private Looper LEf;
  private Handler LEg;
  byte[] LEh;
  a LEi;
  private Handler mVendingHandler;
  private Looper mVendingLooper;
  
  public c(Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(74945);
    this.LEh = new byte[0];
    this.LEf = paramLooper1;
    this.mVendingLooper = paramLooper2;
    this.LEg = new Handler(this.LEf)
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
        synchronized (c.this.LEh)
        {
          if (c.this.LEi != null) {
            c.this.LEi.synchronizing(paramAnonymousMessage.what, paramAnonymousMessage.obj);
          }
          c.this.LEh.notify();
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
    if (Looper.myLooper() == this.LEf)
    {
      if (this.LEi == null)
      {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
        AppMethodBeat.o(74946);
        return;
      }
      this.LEi.fSo();
      synchronized (this.LEh)
      {
        this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(paramInt, paramObject));
      }
    }
    try
    {
      this.LEh.wait();
      label79:
      this.LEi.fSp();
      AppMethodBeat.o(74946);
      return;
      paramObject = finally;
      AppMethodBeat.o(74946);
      throw paramObject;
      if (Looper.myLooper() == this.mVendingLooper)
      {
        this.LEg.sendMessageAtFrontOfQueue(this.LEg.obtainMessage(paramInt, paramObject));
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
    public abstract void fSo();
    
    public abstract void fSp();
    
    public abstract void synchronizing(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */