package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kj;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(255273);
    kj localkj = new kj();
    localkj.Bk(paramString1);
    localkj.gMU = paramInt1;
    localkj.gMV = paramInt2;
    localkj.gMW = paramInt3;
    localkj.gMX = paramInt4;
    localkj.gMY = paramInt5;
    localkj.gMT = paramLong;
    localkj.Bl(paramString2);
    Log.d("MicroMsg.selectrecord.SelectRecordReporter", "reportShareRoomHistoryRevoke %s", new Object[] { localkj.agI() });
    localkj.bpa();
    AppMethodBeat.o(255273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.c
 * JD-Core Version:    0.7.0.1
 */