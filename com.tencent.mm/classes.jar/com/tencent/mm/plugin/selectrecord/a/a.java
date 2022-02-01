package com.tencent.mm.plugin.selectrecord.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.plugin.selectrecord.PluginSelectRecord;
import com.tencent.mm.plugin.selectrecord.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  implements y
{
  public final void Wz(int paramInt)
  {
    AppMethodBeat.i(255188);
    com.tencent.mm.plugin.selectrecord.b.a.fFx().JcD = paramInt;
    com.tencent.mm.plugin.selectrecord.b.a locala = com.tencent.mm.plugin.selectrecord.b.a.fFx();
    locala.Jcu.gNf = locala.Jcv;
    locala.Jcu.gNg = locala.Jcw;
    locala.Jcu.gNh = locala.Jcx;
    locala.Jcu.gNi = locala.Jcy;
    locala.Jcu.gNj = locala.Jcz;
    locala.Jcu.gNk = locala.JcA;
    locala.Jcu.gNl = locala.JcB;
    locala.Jcu.gNo = locala.JcD;
    locala.Jcu.gNp = locala.JcE;
    locala.Jcu.gNr = locala.JcI;
    locala.Jcu.gNs = locala.JcJ;
    locala.Jcu.gNu = locala.JcF;
    locala.Jcu.gNv = locala.JcG;
    locala.Jcu.gNw = locala.JcH;
    Log.d("MicroMsg.selectrecord.SelectRecordReportManager", "%s", new Object[] { locala.Jcu.agI() });
    locala.Jcu.bpa();
    AppMethodBeat.o(255188);
  }
  
  public final void a(long paramLong, Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(255187);
    com.tencent.mm.plugin.selectrecord.e.b.a(paramLong, paramMap, paramString, null);
    AppMethodBeat.o(255187);
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, String paramString2)
  {
    AppMethodBeat.i(255190);
    c.a(paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramString2);
    AppMethodBeat.o(255190);
  }
  
  public final void aC(String paramString, long paramLong)
  {
    AppMethodBeat.i(255192);
    com.tencent.mm.plugin.selectrecord.d.a locala = new com.tencent.mm.plugin.selectrecord.d.a();
    locala.field_historyId = paramString;
    locala.field_msgId = paramLong;
    boolean bool = ((PluginSelectRecord)h.ag(PluginSelectRecord.class)).getSelectRecordStorage().a(locala);
    Log.i("MicroMsg.recordSelect.SelectRecordService", "saveHistoryIdToMsgIf msgId:%s historyId:%s result:%s", new Object[] { Long.valueOf(paramLong), Util.nullAs(paramString, ""), Boolean.valueOf(bool) });
    AppMethodBeat.o(255192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.a.a
 * JD-Core Version:    0.7.0.1
 */