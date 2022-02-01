package com.tencent.mm.sdk.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;

public class EventCenter$SilenceNoLooperScheduler
  extends d
{
  public void arrange(Runnable paramRunnable)
  {
    AppMethodBeat.i(125183);
    paramRunnable.run();
    AppMethodBeat.o(125183);
  }
  
  public void arrangeInterval(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(125184);
    paramRunnable.run();
    AppMethodBeat.o(125184);
  }
  
  public void cancel() {}
  
  public String getType()
  {
    AppMethodBeat.i(125185);
    String str = Thread.currentThread().toString();
    AppMethodBeat.o(125185);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EventCenter.SilenceNoLooperScheduler
 * JD-Core Version:    0.7.0.1
 */