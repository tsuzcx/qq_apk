package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.es;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(207396);
    es locales = new es();
    locales.nW(paramString1);
    locales.eiu = paramInt1;
    locales.eiv = paramInt2;
    locales.eiw = paramInt3;
    locales.eix = paramInt4;
    locales.eiy = paramInt5;
    locales.eit = paramLong;
    locales.nX(paramString2);
    ad.d("MicroMsg.selectrecord.SelectRecordReporter", "reportShareRoomHistoryRevoke %s", new Object[] { locales.RE() });
    locales.aLk();
    AppMethodBeat.o(207396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.b
 * JD-Core Version:    0.7.0.1
 */