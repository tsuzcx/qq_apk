package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ic;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(187920);
    ic localic = new ic();
    localic.vL(paramString1);
    localic.eMQ = paramInt1;
    localic.eMR = paramInt2;
    localic.eMS = paramInt3;
    localic.eMT = paramInt4;
    localic.eMU = paramInt5;
    localic.eMP = paramLong;
    localic.vM(paramString2);
    Log.d("MicroMsg.selectrecord.SelectRecordReporter", "reportShareRoomHistoryRevoke %s", new Object[] { localic.abW() });
    localic.bfK();
    AppMethodBeat.o(187920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.c
 * JD-Core Version:    0.7.0.1
 */