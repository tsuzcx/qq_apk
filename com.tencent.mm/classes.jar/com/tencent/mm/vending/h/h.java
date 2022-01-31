package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends d
{
  public a APc;
  Looper b;
  public String c;
  
  public h(Handler paramHandler, String paramString)
  {
    this(new b(paramHandler), paramString);
    AppMethodBeat.i(126118);
    AppMethodBeat.o(126118);
  }
  
  private h(Looper paramLooper, a parama, String paramString)
  {
    this.b = paramLooper;
    this.APc = parama;
    this.c = paramString;
  }
  
  public h(Looper paramLooper, String paramString)
  {
    this(new Handler(paramLooper), paramString);
    AppMethodBeat.i(126120);
    AppMethodBeat.o(126120);
  }
  
  public h(a parama, String paramString)
  {
    this(parama.getLooper(), parama, paramString);
    AppMethodBeat.i(126119);
    AppMethodBeat.o(126119);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(126121);
    this.APc.dU();
    AppMethodBeat.o(126121);
  }
  
  public final String getType()
  {
    return this.c;
  }
  
  public final void n(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(126123);
    if (paramLong >= 0L)
    {
      this.APc.d(paramRunnable, paramLong);
      AppMethodBeat.o(126123);
      return;
    }
    this.APc.post(paramRunnable);
    AppMethodBeat.o(126123);
  }
  
  public final void o(Runnable paramRunnable)
  {
    AppMethodBeat.i(126122);
    this.APc.post(paramRunnable);
    AppMethodBeat.o(126122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.h
 * JD-Core Version:    0.7.0.1
 */