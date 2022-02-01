package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;

public final class a
  implements com.tencent.mm.plugin.sns.c.a
{
  public final void y(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(94884);
    paramString = new com.tencent.mm.modelstat.h(paramInt1, paramString, paramInt2);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
    AppMethodBeat.o(94884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a
 * JD-Core Version:    0.7.0.1
 */