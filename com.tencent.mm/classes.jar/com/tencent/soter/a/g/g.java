package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g Iwm = null;
  private Handler Ivh;
  HandlerThread Iwn;
  Handler Iwo;
  
  private g()
  {
    AppMethodBeat.i(40);
    this.Iwo = null;
    this.Ivh = null;
    if (this.Iwn == null)
    {
      this.Iwn = new HandlerThread("SoterGenKeyHandlerThreadName");
      this.Iwn.start();
      if (this.Iwn.getLooper() == null) {
        break label94;
      }
    }
    for (this.Iwo = new Handler(this.Iwn.getLooper());; this.Iwo = new Handler(Looper.getMainLooper()))
    {
      this.Ivh = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(40);
      return;
      label94:
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g fnz()
  {
    AppMethodBeat.i(41);
    if (Iwm == null) {
      try
      {
        if (Iwm == null) {
          Iwm = new g();
        }
        g localg1 = Iwm;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(41);
      }
    }
    g localg2 = Iwm;
    AppMethodBeat.o(41);
    return localg2;
  }
  
  public final void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(42);
    this.Iwo.post(paramRunnable);
    AppMethodBeat.o(42);
  }
  
  public final void f(Runnable paramRunnable)
  {
    AppMethodBeat.i(44);
    this.Ivh.post(paramRunnable);
    AppMethodBeat.o(44);
  }
  
  public final void o(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(43);
    this.Iwo.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(43);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */