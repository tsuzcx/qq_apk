package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g
{
  public static void gK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(56666);
    if (paramInt1 >= 0) {
      h.qsU.idkeyStat(320L, paramInt1 + paramInt2, 1L, true);
    }
    AppMethodBeat.o(56666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.g
 * JD-Core Version:    0.7.0.1
 */