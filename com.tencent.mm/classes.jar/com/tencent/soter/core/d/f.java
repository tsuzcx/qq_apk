package com.tencent.soter.core.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

public final class f
{
  private static Handler BmO = null;
  CountDownLatch vJT = null;
  
  static void d(Runnable paramRunnable)
  {
    AppMethodBeat.i(73090);
    if (BmO == null) {
      BmO = new Handler(Looper.getMainLooper());
    }
    BmO.post(paramRunnable);
    AppMethodBeat.o(73090);
  }
  
  public final void countDown()
  {
    AppMethodBeat.i(73089);
    if (this.vJT != null)
    {
      this.vJT.countDown();
      this.vJT = null;
    }
    AppMethodBeat.o(73089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.soter.core.d.f
 * JD-Core Version:    0.7.0.1
 */