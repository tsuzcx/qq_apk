package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class a
{
  public static final void IR(int paramInt)
  {
    AppMethodBeat.i(26370);
    h.qsU.idkeyStat(249L, paramInt, 1L, false);
    AppMethodBeat.o(26370);
  }
  
  public static final void gD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(26369);
    cwy localcwy = com.tencent.mm.plugin.wear.model.a.cYy().uGC.uGT.uHH;
    if (localcwy != null)
    {
      ab.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.qsU.e(11632, new Object[] { Integer.valueOf(paramInt1), localcwy.jJF, localcwy.yeD, Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(26369);
  }
  
  public static final void og(boolean paramBoolean)
  {
    AppMethodBeat.i(26371);
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(249);
    localIDKey.SetKey(12);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    if (paramBoolean)
    {
      localIDKey = new IDKey();
      localIDKey.SetID(249);
      localIDKey.SetKey(13);
      localIDKey.SetValue(1L);
      localArrayList.add(localIDKey);
    }
    h.qsU.b(localArrayList, false);
    AppMethodBeat.o(26371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c.a
 * JD-Core Version:    0.7.0.1
 */