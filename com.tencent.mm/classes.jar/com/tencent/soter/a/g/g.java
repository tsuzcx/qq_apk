package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g ZtP = null;
  private Handler ZsL;
  HandlerThread ZtQ;
  Handler ZtR;
  
  private g()
  {
    AppMethodBeat.i(40);
    this.ZtR = null;
    this.ZsL = null;
    if (this.ZtQ == null)
    {
      this.ZtQ = new HandlerThread("SoterGenKeyHandlerThreadName");
      this.ZtQ.start();
      if (this.ZtQ.getLooper() == null) {
        break label94;
      }
    }
    for (this.ZtR = new Handler(this.ZtQ.getLooper());; this.ZtR = new Handler(Looper.getMainLooper()))
    {
      this.ZsL = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(40);
      return;
      label94:
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g ipq()
  {
    AppMethodBeat.i(41);
    if (ZtP == null) {
      try
      {
        if (ZtP == null) {
          ZtP = new g();
        }
        g localg1 = ZtP;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(41);
      }
    }
    g localg2 = ZtP;
    AppMethodBeat.o(41);
    return localg2;
  }
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(42);
    this.ZtR.post(paramRunnable);
    AppMethodBeat.o(42);
  }
  
  public final void l(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(43);
    this.ZtR.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(43);
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(44);
    this.ZsL.post(paramRunnable);
    AppMethodBeat.o(44);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */