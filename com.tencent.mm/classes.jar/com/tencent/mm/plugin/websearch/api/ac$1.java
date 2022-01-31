package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ue;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.cku;
import com.tencent.mm.protocal.c.ckv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class ac$1
  implements f
{
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof u))
    {
      g.Dk().b(1948, ac.bLp());
      paramString = new ue();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label152;
      }
      Object localObject = (u)paramm;
      paramm = ((u)localObject).qTS;
      localObject = ((u)localObject).qTR;
      y.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramm.sEb });
      if (ac.fq(((cku)localObject).jxi, paramm.sEb) != ac.a.qUq) {
        break label141;
      }
      paramString.ceE.result = 0;
    }
    for (;;)
    {
      a.udP.m(paramString);
      return;
      label141:
      paramString.ceE.result = -1;
      continue;
      label152:
      paramString.ceE.result = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac.1
 * JD-Core Version:    0.7.0.1
 */