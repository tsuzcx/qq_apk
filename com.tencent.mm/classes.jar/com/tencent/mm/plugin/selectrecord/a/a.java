package com.tencent.mm.plugin.selectrecord.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class a
  implements u
{
  public final void JL(int paramInt)
  {
    AppMethodBeat.i(207391);
    com.tencent.mm.plugin.selectrecord.b.a.dNa().yCg = paramInt;
    com.tencent.mm.plugin.selectrecord.b.a locala = com.tencent.mm.plugin.selectrecord.b.a.dNa();
    locala.yBX.eiH = locala.yBY;
    locala.yBX.eiI = locala.yBZ;
    locala.yBX.eiJ = locala.yCa;
    locala.yBX.eiK = locala.yCb;
    locala.yBX.eiL = locala.yCc;
    locala.yBX.eiM = locala.yCd;
    locala.yBX.eiN = locala.yCe;
    locala.yBX.eiQ = locala.yCg;
    locala.yBX.eiR = locala.yCh;
    locala.yBX.eiT = locala.yCl;
    locala.yBX.eiU = locala.yCm;
    locala.yBX.eiW = locala.yCi;
    locala.yBX.eiX = locala.yCj;
    locala.yBX.eiY = locala.yCk;
    ad.d("MicroMsg.selectrecord.SelectRecordReportManager", "%s", new Object[] { locala.yBX.RE() });
    locala.yBX.aLk();
    AppMethodBeat.o(207391);
  }
  
  public final void a(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(207390);
    com.tencent.mm.plugin.selectrecord.d.b.a(paramLong, paramMap, paramString, null);
    AppMethodBeat.o(207390);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(207392);
    com.tencent.mm.plugin.selectrecord.b.b.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramString2);
    AppMethodBeat.o(207392);
  }
  
  public final void cq(String paramString, long paramLong)
  {
    AppMethodBeat.i(221244);
    com.tencent.mm.plugin.selectrecord.e.a locala = new com.tencent.mm.plugin.selectrecord.e.a();
    locala.field_historyId = paramString;
    locala.field_msgId = paramLong;
    boolean bool = ((PluginSelectRecord)g.ad(PluginSelectRecord.class)).getSelectRecordStorage().a(locala);
    ad.i("MicroMsg.recordSelect.SelectRecordService", "saveHistoryIdToMsgIf msgId:%s historyId:%s result:%s", new Object[] { Long.valueOf(paramLong), bt.bI(paramString, ""), Boolean.valueOf(bool) });
    AppMethodBeat.o(221244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.a.a
 * JD-Core Version:    0.7.0.1
 */