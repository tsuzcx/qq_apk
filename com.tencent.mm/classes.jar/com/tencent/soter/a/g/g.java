package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g BnK = null;
  private Handler BmO;
  private Handler BnL;
  
  private g()
  {
    AppMethodBeat.i(10489);
    this.BnL = null;
    this.BmO = null;
    HandlerThread localHandlerThread = new HandlerThread("SoterGenKeyHandlerThreadName");
    localHandlerThread.start();
    if (localHandlerThread.getLooper() != null) {}
    for (this.BnL = new Handler(localHandlerThread.getLooper());; this.BnL = new Handler(Looper.getMainLooper()))
    {
      this.BmO = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(10489);
      return;
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g dVG()
  {
    AppMethodBeat.i(10490);
    if (BnK == null) {
      try
      {
        if (BnK == null) {
          BnK = new g();
        }
        g localg1 = BnK;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(10490);
      }
    }
    g localg2 = BnK;
    AppMethodBeat.o(10490);
    return localg2;
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(10491);
    this.BnL.post(paramRunnable);
    AppMethodBeat.o(10491);
  }
  
  public final void d(Runnable paramRunnable)
  {
    AppMethodBeat.i(10493);
    this.BmO.post(paramRunnable);
    AppMethodBeat.o(10493);
  }
  
  public final void t(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(10492);
    this.BnL.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(10492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */