package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c
  extends d
{
  public c()
  {
    AppMethodBeat.i(74924);
    a.w("Vending.NoLooperScheduler", "This is not a handler thread! %s", new Object[] { Thread.currentThread() });
    AppMethodBeat.o(74924);
  }
  
  public final void arrange(Runnable paramRunnable)
  {
    AppMethodBeat.i(74925);
    a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
    AppMethodBeat.o(74925);
  }
  
  public final void arrangeInterval(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(74926);
    a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
    paramRunnable.run();
    AppMethodBeat.o(74926);
  }
  
  public final void cancel() {}
  
  public final String getType()
  {
    AppMethodBeat.i(74927);
    String str = Thread.currentThread().toString();
    AppMethodBeat.o(74927);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.h.c
 * JD-Core Version:    0.7.0.1
 */