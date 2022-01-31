package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements w.a
{
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(80543);
    e.Pt();
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.WelabUpdater", "Update Error: %d, %d, next update will be performed %d(s) later", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(86400) });
      e.access$100();
      e.kM(86400);
      e.access$300();
      AppMethodBeat.o(80543);
      return 0;
    }
    paramString = (afi)paramb.fsW.fta;
    e.access$100();
    e.kN(paramString.Timestamp);
    e.kM(paramString.wYF);
    e.V(paramString.wYG);
    e.W(paramString.wYE);
    e.access$300();
    ab.i("MicroMsg.WelabUpdater", "Update Interval: %d", new Object[] { Integer.valueOf(paramString.wYF) });
    AppMethodBeat.o(80543);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.1
 * JD-Core Version:    0.7.0.1
 */