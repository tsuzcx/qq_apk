package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nc;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(266710);
    nc localnc = new nc();
    localnc.vx(paramString1);
    localnc.jdc = paramInt1;
    localnc.jdd = paramInt2;
    localnc.jde = paramInt3;
    localnc.jdf = paramInt4;
    localnc.jdg = paramInt5;
    localnc.jdb = paramLong;
    localnc.vy(paramString2);
    Log.d("MicroMsg.selectrecord.SelectRecordReporter", "reportShareRoomHistoryRevoke %s", new Object[] { localnc.aIF() });
    localnc.bMH();
    AppMethodBeat.o(266710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.e
 * JD-Core Version:    0.7.0.1
 */