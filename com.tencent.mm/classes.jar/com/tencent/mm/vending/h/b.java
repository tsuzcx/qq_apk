package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements a
{
  public Handler mHandler;
  
  public b(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public final void c(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(74912);
    this.mHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(74912);
  }
  
  public final void fS()
  {
    AppMethodBeat.i(74914);
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(74914);
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(74913);
    Looper localLooper = this.mHandler.getLooper();
    AppMethodBeat.o(74913);
    return localLooper;
  }
  
  public final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(74911);
    this.mHandler.post(paramRunnable);
    AppMethodBeat.o(74911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.b
 * JD-Core Version:    0.7.0.1
 */