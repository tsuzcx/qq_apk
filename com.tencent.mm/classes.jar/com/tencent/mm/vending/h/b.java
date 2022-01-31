package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements a
{
  public Handler a;
  
  public b(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public final void d(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(126115);
    this.a.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(126115);
  }
  
  public final void dU()
  {
    AppMethodBeat.i(126117);
    this.a.removeCallbacksAndMessages(null);
    AppMethodBeat.o(126117);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(126116);
    Looper localLooper = this.a.getLooper();
    AppMethodBeat.o(126116);
    return localLooper;
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(126114);
    this.a.post(paramRunnable);
    AppMethodBeat.o(126114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.b
 * JD-Core Version:    0.7.0.1
 */