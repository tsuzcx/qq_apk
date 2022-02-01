package com.tencent.mm.plugin.selectrecord.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.plugin.selectrecord.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class a
  implements v
{
  public final void Kk(int paramInt)
  {
    AppMethodBeat.i(193986);
    com.tencent.mm.plugin.selectrecord.b.a.dQt().ySh = paramInt;
    com.tencent.mm.plugin.selectrecord.b.a locala = com.tencent.mm.plugin.selectrecord.b.a.dQt();
    locala.yRY.ekp = locala.yRZ;
    locala.yRY.ekq = locala.ySa;
    locala.yRY.ekr = locala.ySb;
    locala.yRY.eks = locala.ySc;
    locala.yRY.ekt = locala.ySd;
    locala.yRY.eku = locala.ySe;
    locala.yRY.ekv = locala.ySf;
    locala.yRY.eky = locala.ySh;
    locala.yRY.ekz = locala.ySi;
    locala.yRY.ekB = locala.ySm;
    locala.yRY.ekC = locala.ySn;
    locala.yRY.ekE = locala.ySj;
    locala.yRY.ekF = locala.ySk;
    locala.yRY.ekG = locala.ySl;
    ae.d("MicroMsg.selectrecord.SelectRecordReportManager", "%s", new Object[] { locala.yRY.RD() });
    locala.yRY.aLH();
    AppMethodBeat.o(193986);
  }
  
  public final void a(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(193985);
    com.tencent.mm.plugin.selectrecord.e.b.a(paramLong, paramMap, paramString, null);
    AppMethodBeat.o(193985);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(193987);
    c.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramString2);
    AppMethodBeat.o(193987);
  }
  
  public final void aA(String paramString, long paramLong)
  {
    AppMethodBeat.i(193988);
    com.tencent.mm.plugin.selectrecord.d.a locala = new com.tencent.mm.plugin.selectrecord.d.a();
    locala.field_historyId = paramString;
    locala.field_msgId = paramLong;
    boolean bool = ((PluginSelectRecord)g.ad(PluginSelectRecord.class)).getSelectRecordStorage().a(locala);
    ae.i("MicroMsg.recordSelect.SelectRecordService", "saveHistoryIdToMsgIf msgId:%s historyId:%s result:%s", new Object[] { Long.valueOf(paramLong), bu.bI(paramString, ""), Boolean.valueOf(bool) });
    AppMethodBeat.o(193988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.a.a
 * JD-Core Version:    0.7.0.1
 */