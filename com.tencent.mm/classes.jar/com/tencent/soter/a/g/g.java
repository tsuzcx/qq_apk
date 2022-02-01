package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g JXV = null;
  private Handler JWQ;
  HandlerThread JXW;
  Handler JXX;
  
  private g()
  {
    AppMethodBeat.i(40);
    this.JXX = null;
    this.JWQ = null;
    if (this.JXW == null)
    {
      this.JXW = new HandlerThread("SoterGenKeyHandlerThreadName");
      this.JXW.start();
      if (this.JXW.getLooper() == null) {
        break label94;
      }
    }
    for (this.JXX = new Handler(this.JXW.getLooper());; this.JXX = new Handler(Looper.getMainLooper()))
    {
      this.JWQ = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(40);
      return;
      label94:
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g fDP()
  {
    AppMethodBeat.i(41);
    if (JXV == null) {
      try
      {
        if (JXV == null) {
          JXV = new g();
        }
        g localg1 = JXV;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(41);
      }
    }
    g localg2 = JXV;
    AppMethodBeat.o(41);
    return localg2;
  }
  
  public final void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(42);
    this.JXX.post(paramRunnable);
    AppMethodBeat.o(42);
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(44);
    this.JWQ.post(paramRunnable);
    AppMethodBeat.o(44);
  }
  
  public final void o(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(43);
    this.JXX.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(43);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */