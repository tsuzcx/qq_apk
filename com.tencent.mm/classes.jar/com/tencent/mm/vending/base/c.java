package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
{
  private Looper AOg;
  c.a AOh;
  private Looper b;
  private Handler c;
  private Handler d;
  byte[] e;
  
  public c(Looper paramLooper1, Looper paramLooper2)
  {
    AppMethodBeat.i(126148);
    this.e = new byte[0];
    this.AOg = paramLooper1;
    this.b = paramLooper2;
    this.c = new Handler(this.AOg)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(126162);
        c.this.t(paramAnonymousMessage.what, paramAnonymousMessage.obj);
        AppMethodBeat.o(126162);
      }
    };
    this.d = new c.2(this, this.b);
    AppMethodBeat.o(126148);
  }
  
  public final void t(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(126149);
    if (Looper.myLooper() == this.AOg)
    {
      if (this.AOh == null)
      {
        a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
        AppMethodBeat.o(126149);
        return;
      }
      this.AOh.dQg();
      synchronized (this.e)
      {
        this.d.sendMessageAtFrontOfQueue(this.d.obtainMessage(paramInt, paramObject));
      }
    }
    try
    {
      this.e.wait();
      label79:
      this.AOh.dQh();
      AppMethodBeat.o(126149);
      return;
      paramObject = finally;
      AppMethodBeat.o(126149);
      throw paramObject;
      if (Looper.myLooper() == this.b)
      {
        this.c.sendMessageAtFrontOfQueue(this.c.obtainMessage(paramInt, paramObject));
        AppMethodBeat.o(126149);
        return;
      }
      AppMethodBeat.o(126149);
      return;
    }
    catch (InterruptedException paramObject)
    {
      break label79;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.base.c
 * JD-Core Version:    0.7.0.1
 */