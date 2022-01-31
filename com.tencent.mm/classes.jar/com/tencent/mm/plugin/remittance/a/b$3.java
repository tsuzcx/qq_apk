package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import java.util.Map;

final class b$3
  implements j.a
{
  b$3(b paramb) {}
  
  public final void a(String paramString, l paraml)
  {
    if ((paramString != null) && (paramString.length() > 0) && ("event_updated".equals(paramString)))
    {
      paramString = com.tencent.mm.model.c.c.IX().fJ("100324");
      if ((!paramString.isValid()) || (!"1".equals(paramString.ctr().get("open")))) {
        break label163;
      }
    }
    label163:
    for (int i = 1;; i = 0)
    {
      paramString = g.DP().Dz();
      paramString.c(ac.a.uyz, Integer.valueOf(i));
      int j = ((Integer)paramString.get(ac.a.uyA, Integer.valueOf(0))).intValue();
      y.i("MicroMsg.SubCoreRemittance", "receive abtest open bank remit: %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (j == 0)
      {
        com.tencent.mm.y.c.BS().b(ac.a.uyu, true);
        paramString.c(ac.a.uyA, Integer.valueOf(1));
        g.DP().Dz().c(ac.a.uyv, Boolean.valueOf(false));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.a.b.3
 * JD-Core Version:    0.7.0.1
 */