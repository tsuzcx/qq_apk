package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a
{
  public static final void CE(boolean paramBoolean)
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
    h.IzE.b(localArrayList, false);
    AppMethodBeat.o(30053);
  }
  
  public static final void amT(int paramInt)
  {
    AppMethodBeat.i(30052);
    h.IzE.idkeyStat(249L, paramInt, 1L, false);
    AppMethodBeat.o(30052);
  }
  
  public static final void lp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30051);
    fjj localfjj = com.tencent.mm.plugin.wear.model.a.gOt().PrM.Psx;
    if (localfjj != null)
    {
      Log.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.IzE.a(11632, new Object[] { Integer.valueOf(paramInt1), localfjj.rVH, localfjj.UIA, Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(30051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c.a
 * JD-Core Version:    0.7.0.1
 */