package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g RRl = null;
  private Handler RQg;
  HandlerThread RRm;
  Handler RRn;
  
  private g()
  {
    AppMethodBeat.i(40);
    this.RRn = null;
    this.RQg = null;
    if (this.RRm == null)
    {
      this.RRm = new HandlerThread("SoterGenKeyHandlerThreadName");
      this.RRm.start();
      if (this.RRm.getLooper() == null) {
        break label94;
      }
    }
    for (this.RRn = new Handler(this.RRm.getLooper());; this.RRn = new Handler(Looper.getMainLooper()))
    {
      this.RQg = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(40);
      return;
      label94:
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g hlR()
  {
    AppMethodBeat.i(41);
    if (RRl == null) {
      try
      {
        if (RRl == null) {
          RRl = new g();
        }
        g localg1 = RRl;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(41);
      }
    }
    g localg2 = RRl;
    AppMethodBeat.o(41);
    return localg2;
  }
  
  public final void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(42);
    this.RRn.post(paramRunnable);
    AppMethodBeat.o(42);
  }
  
  public final void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(43);
    this.RRn.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(43);
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(44);
    this.RQg.post(paramRunnable);
    AppMethodBeat.o(44);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */