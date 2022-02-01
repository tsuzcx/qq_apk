package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
{
  private Looper HPD;
  private Handler HPE;
  byte[] HPF;
  a HPG;
  private Handler mVendingHandler;
  private Looper mVendingLooper;
  
  public c(Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(74945);
    this.HPF = new byte[0];
    this.HPD = paramLooper1;
    this.mVendingLooper = paramLooper2;
    this.HPE = new Handler(this.HPD)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74959);
        c.this.r(paramAnonymousMessage.what, paramAnonymousMessage.obj);
        AppMethodBeat.o(74959);
      }
    };
    this.mVendingHandler = new Handler(this.mVendingLooper)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74950);
        synchronized (c.this.HPF)
        {
          if (c.this.HPG != null) {
            c.this.HPG.synchronizing(paramAnonymousMessage.what, paramAnonymousMessage.obj);
          }
          c.this.HPF.notify();
          AppMethodBeat.o(74950);
          return;
        }
      }
    };
    AppMethodBeat.o(74945);
  }
  
  public final void r(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(74946);
    if (Looper.myLooper() == this.HPD)
    {
      if (this.HPG == null)
      {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
        AppMethodBeat.o(74946);
        return;
      }
      this.HPG.fhe();
      synchronized (this.HPF)
      {
        this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(paramInt, paramObject));
      }
    }
    try
    {
      this.HPF.wait();
      label79:
      this.HPG.fhf();
      AppMethodBeat.o(74946);
      return;
      paramObject = finally;
      AppMethodBeat.o(74946);
      throw paramObject;
      if (Looper.myLooper() == this.mVendingLooper)
      {
        this.HPE.sendMessageAtFrontOfQueue(this.HPE.obtainMessage(paramInt, paramObject));
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
    public abstract void fhe();
    
    public abstract void fhf();
    
    public abstract void synchronizing(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */