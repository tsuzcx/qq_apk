package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;

final class a$1
  extends c
{
  a$1(a parama) {}
  
  public final String getName()
  {
    return "PhoneStartTask";
  }
  
  public final void send()
  {
    AppMethodBeat.i(26265);
    r.a(20001, null, false);
    r.a(20008, null, false);
    AppMethodBeat.o(26265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.1
 * JD-Core Version:    0.7.0.1
 */