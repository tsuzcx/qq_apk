package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g MoN = null;
  private Handler MnI;
  HandlerThread MoO;
  Handler MoP;
  
  private g()
  {
    AppMethodBeat.i(40);
    this.MoP = null;
    this.MnI = null;
    if (this.MoO == null)
    {
      this.MoO = new HandlerThread("SoterGenKeyHandlerThreadName");
      this.MoO.start();
      if (this.MoO.getLooper() == null) {
        break label94;
      }
    }
    for (this.MoP = new Handler(this.MoO.getLooper());; this.MoP = new Handler(Looper.getMainLooper()))
    {
      this.MnI = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(40);
      return;
      label94:
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g fZG()
  {
    AppMethodBeat.i(41);
    if (MoN == null) {
      try
      {
        if (MoN == null) {
          MoN = new g();
        }
        g localg1 = MoN;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(41);
      }
    }
    g localg2 = MoN;
    AppMethodBeat.o(41);
    return localg2;
  }
  
  public final void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(42);
    this.MoP.post(paramRunnable);
    AppMethodBeat.o(42);
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(44);
    this.MnI.post(paramRunnable);
    AppMethodBeat.o(44);
  }
  
  public final void p(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(43);
    this.MoP.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(43);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */