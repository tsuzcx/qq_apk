package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.r;

public final class a
  extends c
{
  public final String getName()
  {
    return "RequestLogTask";
  }
  
  protected final void send()
  {
    AppMethodBeat.i(30124);
    com.tencent.mm.plugin.wear.model.a.ewt();
    r.a(20009, null, false);
    com.tencent.mm.plugin.wear.model.a.ewt();
    r.a(20017, null, false);
    AppMethodBeat.o(30124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.a
 * JD-Core Version:    0.7.0.1
 */