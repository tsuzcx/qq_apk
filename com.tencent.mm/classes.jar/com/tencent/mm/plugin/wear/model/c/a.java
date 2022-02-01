package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.protocal.protobuf.ect;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;

public final class a
{
  public static final void VS(int paramInt)
  {
    AppMethodBeat.i(30052);
    g.yhR.idkeyStat(249L, paramInt, 1L, false);
    AppMethodBeat.o(30052);
  }
  
  public static final void iP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30051);
    ect localect = com.tencent.mm.plugin.wear.model.a.eKv().DwN.Dxz;
    if (localect != null)
    {
      ad.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      g.yhR.f(11632, new Object[] { Integer.valueOf(paramInt1), localect.nDt, localect.HOF, Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(30051);
  }
  
  public static final void uM(boolean paramBoolean)
  {
    AppMethodBeat.i(30053);
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
    g.yhR.b(localArrayList, false);
    AppMethodBeat.o(30053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c.a
 * JD-Core Version:    0.7.0.1
 */