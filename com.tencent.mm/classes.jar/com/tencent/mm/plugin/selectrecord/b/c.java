package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eu;
import com.tencent.mm.sdk.platformtools.ae;

public final class c
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(193998);
    eu localeu = new eu();
    localeu.or(paramString1);
    localeu.eke = paramInt1;
    localeu.ekf = paramInt2;
    localeu.ekg = paramInt3;
    localeu.ekh = paramInt4;
    localeu.eki = paramInt5;
    localeu.ekd = paramLong;
    localeu.os(paramString2);
    ae.d("MicroMsg.selectrecord.SelectRecordReporter", "reportShareRoomHistoryRevoke %s", new Object[] { localeu.RD() });
    localeu.aLH();
    AppMethodBeat.o(193998);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.c
 * JD-Core Version:    0.7.0.1
 */