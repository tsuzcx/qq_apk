package com.tencent.mm.plugin.selectrecord.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.plugin.selectrecord.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  implements v
{
  public final void Qm(int paramInt)
  {
    AppMethodBeat.i(187908);
    com.tencent.mm.plugin.selectrecord.b.a.eSu().CWX = paramInt;
    com.tencent.mm.plugin.selectrecord.b.a locala = com.tencent.mm.plugin.selectrecord.b.a.eSu();
    locala.CWO.eNb = locala.CWP;
    locala.CWO.eNc = locala.CWQ;
    locala.CWO.eNd = locala.CWR;
    locala.CWO.eNe = locala.CWS;
    locala.CWO.eNf = locala.CWT;
    locala.CWO.eNg = locala.CWU;
    locala.CWO.eNh = locala.CWV;
    locala.CWO.eNk = locala.CWX;
    locala.CWO.eNl = locala.CWY;
    locala.CWO.eNn = locala.CXc;
    locala.CWO.eNo = locala.CXd;
    locala.CWO.eNq = locala.CWZ;
    locala.CWO.eNr = locala.CXa;
    locala.CWO.eNs = locala.CXb;
    Log.d("MicroMsg.selectrecord.SelectRecordReportManager", "%s", new Object[] { locala.CWO.abW() });
    locala.CWO.bfK();
    AppMethodBeat.o(187908);
  }
  
  public final void a(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(187907);
    com.tencent.mm.plugin.selectrecord.e.b.a(paramLong, paramMap, paramString, null);
    AppMethodBeat.o(187907);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(187909);
    c.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramString2);
    AppMethodBeat.o(187909);
  }
  
  public final void aA(String paramString, long paramLong)
  {
    AppMethodBeat.i(187910);
    com.tencent.mm.plugin.selectrecord.d.a locala = new com.tencent.mm.plugin.selectrecord.d.a();
    locala.field_historyId = paramString;
    locala.field_msgId = paramLong;
    boolean bool = ((PluginSelectRecord)g.ah(PluginSelectRecord.class)).getSelectRecordStorage().a(locala);
    Log.i("MicroMsg.recordSelect.SelectRecordService", "saveHistoryIdToMsgIf msgId:%s historyId:%s result:%s", new Object[] { Long.valueOf(paramLong), Util.nullAs(paramString, ""), Boolean.valueOf(bool) });
    AppMethodBeat.o(187910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.a.a
 * JD-Core Version:    0.7.0.1
 */