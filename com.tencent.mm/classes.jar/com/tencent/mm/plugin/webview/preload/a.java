package com.tencent.mm.plugin.webview.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static void JY(int paramInt)
  {
    AppMethodBeat.i(80438);
    d(974, paramInt, 1, false);
    AppMethodBeat.o(80438);
  }
  
  public static void JZ(int paramInt)
  {
    AppMethodBeat.i(80442);
    ai(paramInt, 1L);
    AppMethodBeat.o(80442);
  }
  
  public static void ai(int paramInt, long paramLong)
  {
    AppMethodBeat.i(80443);
    h.qsU.j(1009L, paramInt, paramLong);
    AppMethodBeat.o(80443);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(80441);
    ab.i("ConstantsPreload", "id:%d, key:%d, valye:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    h.qsU.idkeyStat(paramInt1, paramInt2, paramInt3, false);
    if ((paramBoolean) && (paramInt1 != 908) && (paramInt1 != 0)) {
      h.qsU.idkeyStat(908L, paramInt2, paramInt3, false);
    }
    h.qsU.e(15792, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(80441);
  }
  
  public static void gK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(156916);
    d(paramInt1, paramInt2, 1, true);
    AppMethodBeat.o(156916);
  }
  
  public static void gL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80440);
    d(908, paramInt1, paramInt2, true);
    AppMethodBeat.o(80440);
  }
  
  public static void kS(int paramInt)
  {
    AppMethodBeat.i(80437);
    d(908, paramInt, 1, true);
    AppMethodBeat.o(80437);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.preload.a
 * JD-Core Version:    0.7.0.1
 */