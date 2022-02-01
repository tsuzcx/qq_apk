package com.tencent.mm.plugin.webview.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static void XA(int paramInt)
  {
    AppMethodBeat.i(224466);
    aK(paramInt, 1L);
    AppMethodBeat.o(224466);
  }
  
  public static void Xz(int paramInt)
  {
    AppMethodBeat.i(103128);
    e(974, paramInt, 1, false);
    AppMethodBeat.o(103128);
  }
  
  public static void aK(int paramInt, long paramLong)
  {
    AppMethodBeat.i(103133);
    g.yxI.n(1009L, paramInt, paramLong);
    AppMethodBeat.o(103133);
  }
  
  public static void e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(103131);
    ae.i("ConstantsPreload", "id:%d, key:%d, valye:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    g.yxI.idkeyStat(paramInt1, paramInt2, paramInt3, false);
    if ((paramBoolean) && (paramInt1 != 908) && (paramInt1 != 0)) {
      g.yxI.idkeyStat(908L, paramInt2, paramInt3, false);
    }
    g.yxI.f(15792, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(103131);
  }
  
  public static void gi(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186127);
    e(paramInt1, paramInt2, 1, true);
    AppMethodBeat.o(186127);
  }
  
  public static void ja(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(103130);
    e(908, paramInt1, paramInt2, true);
    AppMethodBeat.o(103130);
  }
  
  public static void md(int paramInt)
  {
    AppMethodBeat.i(103127);
    e(908, paramInt, 1, true);
    AppMethodBeat.o(103127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.g.a
 * JD-Core Version:    0.7.0.1
 */