package com.tencent.soter.a.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;

public class g
{
  private static volatile g ahyI = null;
  private Handler ahxy;
  HandlerThread ahyJ;
  Handler ahyK;
  
  private g()
  {
    AppMethodBeat.i(40);
    this.ahyK = null;
    this.ahxy = null;
    if (this.ahyJ == null)
    {
      this.ahyJ = new HandlerThread("SoterGenKeyHandlerThreadName");
      this.ahyJ.start();
      if (this.ahyJ.getLooper() == null) {
        break label94;
      }
    }
    for (this.ahyK = new Handler(this.ahyJ.getLooper());; this.ahyK = new Handler(Looper.getMainLooper()))
    {
      this.ahxy = new Handler(Looper.getMainLooper());
      AppMethodBeat.o(40);
      return;
      label94:
      d.e("Soter.SoterTaskThread", "soter: task looper is null! use main looper as the task looper", new Object[0]);
    }
  }
  
  public static g jYG()
  {
    AppMethodBeat.i(41);
    if (ahyI == null) {
      try
      {
        if (ahyI == null) {
          ahyI = new g();
        }
        g localg1 = ahyI;
        return localg1;
      }
      finally
      {
        AppMethodBeat.o(41);
      }
    }
    g localg2 = ahyI;
    AppMethodBeat.o(41);
    return localg2;
  }
  
  public final void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(42);
    this.ahyK.post(paramRunnable);
    AppMethodBeat.o(42);
  }
  
  public final void m(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(43);
    this.ahyK.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(43);
  }
  
  public final void postToMainThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(44);
    this.ahxy.post(paramRunnable);
    AppMethodBeat.o(44);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.g.g
 * JD-Core Version:    0.7.0.1
 */