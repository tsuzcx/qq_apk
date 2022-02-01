package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g LRQ = null;
  private Handler LQL;
  HandlerThread LRR;
  Handler LRS;
  
  private g()
  {
    AppMethodBeat.i(40);
    this.LRS = null;
    this.LQL = null;
    if (this.LRR == null)
    {
      this.LRR = new HandlerThread("SoterGenKeyHandlerThreadName");
      this.LRR.start();
      if (this.LRR.getLooper() == null) {
        break label94;
      }
    }
    for (this.LRS = new Handler(this.LRR.getLooper());; this.LRS = new Handler(Looper.getMainLooper()))
    {
      this.LQL = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(40);
      return;
      label94:
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g fVh()
  {
    AppMethodBeat.i(41);
    if (LRQ == null) {
      try
      {
        if (LRQ == null) {
          LRQ = new g();
        }
        g localg1 = LRQ;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(41);
      }
    }
    g localg2 = LRQ;
    AppMethodBeat.o(41);
    return localg2;
  }
  
  public final void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(42);
    this.LRS.post(paramRunnable);
    AppMethodBeat.o(42);
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(44);
    this.LQL.post(paramRunnable);
    AppMethodBeat.o(44);
  }
  
  public final void p(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(43);
    this.LRS.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(43);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */