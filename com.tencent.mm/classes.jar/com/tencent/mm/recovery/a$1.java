package com.tencent.mm.recovery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends a.a
{
  a$1(String paramString)
  {
    super(paramString);
  }
  
  public final void guu()
  {
    AppMethodBeat.i(193889);
    bhA(".cmd.diagnostic.MemoryHook.$enable");
    bhA(".cmd.diagnostic.PthreadHook.$enable");
    bhz(".cmd.diagnostic.MemoryHook.crash");
    bhz(".cmd.diagnostic.PthreadHook.crash");
    AppMethodBeat.o(193889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.recovery.a.1
 * JD-Core Version:    0.7.0.1
 */