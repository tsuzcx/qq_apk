package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
{
  private Looper JpY;
  private Handler JpZ;
  byte[] Jqa;
  a Jqb;
  private Handler mVendingHandler;
  private Looper mVendingLooper;
  
  public c(Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(74945);
    this.Jqa = new byte[0];
    this.JpY = paramLooper1;
    this.mVendingLooper = paramLooper2;
    this.JpZ = new Handler(this.JpY)
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
        synchronized (c.this.Jqa)
        {
          if (c.this.Jqb != null) {
            c.this.Jqb.synchronizing(paramAnonymousMessage.what, paramAnonymousMessage.obj);
          }
          c.this.Jqa.notify();
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
    if (Looper.myLooper() == this.JpY)
    {
      if (this.Jqb == null)
      {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
        AppMethodBeat.o(74946);
        return;
      }
      this.Jqb.fxg();
      synchronized (this.Jqa)
      {
        this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(paramInt, paramObject));
      }
    }
    try
    {
      this.Jqa.wait();
      label79:
      this.Jqb.fxh();
      AppMethodBeat.o(74946);
      return;
      paramObject = finally;
      AppMethodBeat.o(74946);
      throw paramObject;
      if (Looper.myLooper() == this.mVendingLooper)
      {
        this.JpZ.sendMessageAtFrontOfQueue(this.JpZ.obtainMessage(paramInt, paramObject));
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
    public abstract void fxg();
    
    public abstract void fxh();
    
    public abstract void synchronizing(int paramInt, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */