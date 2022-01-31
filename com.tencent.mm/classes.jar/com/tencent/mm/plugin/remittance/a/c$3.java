package com.tencent.mm.plugin.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import java.util.Map;

final class c$3
  implements k.a
{
  c$3(c paramc) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(44426);
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = com.tencent.mm.model.c.c.abU().me("100324");
      if ((!paramString.isValid()) || (!"1".equals(paramString.dvN().get("open")))) {
        break label172;
      }
    }
    label172:
    for (int i = 1;; i = 0)
    {
      paramString = g.RL().Ru();
      paramString.set(ac.a.yIJ, Integer.valueOf(i));
      int j = ((Integer)paramString.get(ac.a.yIK, Integer.valueOf(0))).intValue();
      ab.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j == 0)
      {
        com.tencent.mm.x.c.PJ().b(ac.a.yIE, true);
        paramString.set(ac.a.yIK, Integer.valueOf(1));
        g.RL().Ru().set(ac.a.yIF, Boolean.FALSE);
      }
      AppMethodBeat.o(44426);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.c.3
 * JD-Core Version:    0.7.0.1
 */