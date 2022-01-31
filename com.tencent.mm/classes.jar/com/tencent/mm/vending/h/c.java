package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
  extends d
{
  public c()
  {
    AppMethodBeat.i(126127);
    a.printErrStackTrace("Vending.NoLooperScheduler", new Exception("This is not a handler thread!"), "This is not a handler thread!", new Object[0]);
    AppMethodBeat.o(126127);
  }
  
  public final void cancel() {}
  
  public final String getType()
  {
    AppMethodBeat.i(126130);
    String str = Thread.currentThread().toString();
    AppMethodBeat.o(126130);
    return str;
  }
  
  public final void n(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(126129);
    a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
    AppMethodBeat.o(126129);
  }
  
  public final void o(Runnable paramRunnable)
  {
    AppMethodBeat.i(126128);
    a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
    AppMethodBeat.o(126128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.h.c
 * JD-Core Version:    0.7.0.1
 */