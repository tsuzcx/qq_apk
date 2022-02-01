package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wear.model.d;
import com.tencent.mm.plugin.wear.model.e.i;
import com.tencent.mm.protocal.protobuf.gfx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class a
{
  public static final void Ij(boolean paramBoolean)
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
    h.OAn.b(localArrayList, false);
    AppMethodBeat.o(30053);
  }
  
  public static final void asK(int paramInt)
  {
    AppMethodBeat.i(30052);
    h.OAn.idkeyStat(249L, paramInt, 1L, false);
    AppMethodBeat.o(30052);
  }
  
  public static final void kK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30051);
    gfx localgfx = com.tencent.mm.plugin.wear.model.a.inI().Wiz.Wjk;
    if (localgfx != null)
    {
      Log.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      h.OAn.b(11632, new Object[] { Integer.valueOf(paramInt1), localgfx.vgX, localgfx.accJ, Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(30051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.c.a
 * JD-Core Version:    0.7.0.1
 */