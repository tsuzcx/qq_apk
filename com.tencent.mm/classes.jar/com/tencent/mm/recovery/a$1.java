package com.tencent.mm.recovery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends a.a
{
  a$1(String paramString)
  {
    super(paramString);
  }
  
  public final void hpS()
  {
    AppMethodBeat.i(202394);
    btS(".cmd.diagnostic.MemoryHook.$enable");
    btS(".cmd.diagnostic.PthreadHook.$enable");
    btR(".cmd.diagnostic.MemoryHook.crash");
    btR(".cmd.diagnostic.PthreadHook.crash");
    AppMethodBeat.o(202394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.recovery.a.1
 * JD-Core Version:    0.7.0.1
 */