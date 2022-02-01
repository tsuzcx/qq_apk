package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class d
{
  private Looper aguo;
  private Handler agup;
  private byte[] aguq;
  a agur;
  private Handler mVendingHandler;
  private Looper mVendingLooper;
  
  public d(Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(74945);
    this.aguq = new byte[0];
    this.aguo = paramLooper1;
    this.mVendingLooper = paramLooper2;
    this.agup = new Handler(this.aguo)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74959);
        d.this.R(paramAnonymousMessage.what, paramAnonymousMessage.obj);
        AppMethodBeat.o(74959);
      }
    };
    this.mVendingHandler = new Handler(this.mVendingLooper)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74950);
        synchronized (d.a(d.this))
        {
          if (d.b(d.this) != null) {
            d.b(d.this).synchronizing(paramAnonymousMessage.what, paramAnonymousMessage.obj);
          }
          d.a(d.this).notify();
          AppMethodBeat.o(74950);
          return;
        }
      }
    };
    AppMethodBeat.o(74945);
  }
  
  public final void R(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(74946);
    if (Looper.myLooper() == this.aguo)
    {
      if (this.agur == null)
      {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
        AppMethodBeat.o(74946);
        return;
      }
      this.agur.jJG();
      synchronized (this.aguq)
      {
        this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(paramInt, paramObject));
      }
    }
    try
    {
      this.aguq.wait();
      label79:
      this.agur.jJH();
      AppMethodBeat.o(74946);
      return;
      paramObject = finally;
      AppMethodBeat.o(74946);
      throw paramObject;
      if (Looper.myLooper() == this.mVendingLooper)
      {
        this.agup.sendMessageAtFrontOfQueue(this.agup.obtainMessage(paramInt, paramObject));
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
    public abstract void jJG();
    
    public abstract void jJH();
    
    public abstract void synchronizing(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.vending.base.d
 * JD-Core Version:    0.7.0.1
 */