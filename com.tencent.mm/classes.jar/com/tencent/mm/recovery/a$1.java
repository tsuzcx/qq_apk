package com.tencent.mm.recovery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends a.a
{
  a$1(String paramString)
  {
    super(paramString);
  }
  
  public final void iQw()
  {
    AppMethodBeat.i(242748);
    btJ(".cmd.diagnostic.MemoryHook.$enable");
    btJ(".cmd.diagnostic.PthreadHook.$enable");
    btI(".cmd.diagnostic.MemoryHook.crash");
    btI(".cmd.diagnostic.PthreadHook.crash");
    AppMethodBeat.o(242748);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.recovery.a.1
 * JD-Core Version:    0.7.0.1
 */