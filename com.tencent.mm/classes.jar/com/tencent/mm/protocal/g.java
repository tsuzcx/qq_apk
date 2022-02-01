package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g
{
  public static void ik(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91309);
    if (paramInt1 >= 0) {
      h.OAn.idkeyStat(320L, paramInt1 + paramInt2, 1L, true);
    }
    AppMethodBeat.o(91309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.g
 * JD-Core Version:    0.7.0.1
 */