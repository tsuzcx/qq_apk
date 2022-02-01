package com.tencent.mm.plugin.selectrecord.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nd;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.plugin.selectrecord.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class a
  implements y
{
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(266690);
    e.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramString2);
    AppMethodBeat.o(266690);
  }
  
  public final boolean a(cc paramcc, Map<String, String> paramMap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(266676);
    boolean bool = com.tencent.mm.plugin.selectrecord.e.b.a(paramcc, paramMap, paramString1, paramString2, null);
    AppMethodBeat.o(266676);
    return bool;
  }
  
  public final void aaB(int paramInt)
  {
    AppMethodBeat.i(266684);
    com.tencent.mm.plugin.selectrecord.b.a.gUF().Pms = paramInt;
    com.tencent.mm.plugin.selectrecord.b.a locala = com.tencent.mm.plugin.selectrecord.b.a.gUF();
    locala.Pmj.jdn = locala.Pmk;
    locala.Pmj.jdo = locala.Pml;
    locala.Pmj.jdp = locala.Pmm;
    locala.Pmj.jdq = locala.Pmn;
    locala.Pmj.jdr = locala.Pmo;
    locala.Pmj.jds = locala.Pmp;
    locala.Pmj.jdt = locala.Pmq;
    locala.Pmj.jdw = locala.Pms;
    locala.Pmj.jdx = locala.Pmt;
    locala.Pmj.jdz = locala.Pmx;
    locala.Pmj.jdA = locala.Pmy;
    locala.Pmj.jdC = locala.Pmu;
    locala.Pmj.jdD = locala.Pmv;
    locala.Pmj.jdE = locala.Pmw;
    Log.d("MicroMsg.selectrecord.SelectRecordReportManager", "%s", new Object[] { locala.Pmj.aIF() });
    locala.Pmj.bMH();
    AppMethodBeat.o(266684);
  }
  
  public final void f(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(266699);
    com.tencent.mm.plugin.selectrecord.d.a locala = new com.tencent.mm.plugin.selectrecord.d.a();
    locala.field_historyId = paramString1;
    locala.field_msgId = paramLong;
    locala.field_talker = paramString2;
    boolean bool = ((PluginSelectRecord)h.az(PluginSelectRecord.class)).getSelectRecordStorage().a(locala);
    Log.i("MicroMsg.selectRecord.SelectRecordService", "saveHistoryIdToMsgIf msgId:%s historyId:%s result:%s", new Object[] { Long.valueOf(paramLong), Util.nullAs(paramString1, ""), Boolean.valueOf(bool) });
    AppMethodBeat.o(266699);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.a.a
 * JD-Core Version:    0.7.0.1
 */