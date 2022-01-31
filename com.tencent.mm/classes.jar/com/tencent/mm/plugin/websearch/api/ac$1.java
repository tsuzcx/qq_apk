package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cyj;
import com.tencent.mm.protocal.protobuf.cyk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ac$1
  implements f
{
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124152);
    ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof u))
    {
      g.Rc().b(1948, ac.cyR());
      paramString = new wa();
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label162;
      }
      Object localObject = (u)paramm;
      paramm = ((u)localObject).uJa;
      localObject = ((u)localObject).uIZ;
      ab.i("MicroMsg.WebSearch.WebSearchConfigLogic", "getWebSearchConfig onSceneEnd %s", new Object[] { paramm.wAa });
      if (ac.hj(((cyj)localObject).lGH, paramm.wAa) != ac.a.uJB) {
        break label151;
      }
      paramString.cNr.result = 0;
    }
    for (;;)
    {
      a.ymk.l(paramString);
      AppMethodBeat.o(124152);
      return;
      label151:
      paramString.cNr.result = -1;
      continue;
      label162:
      paramString.cNr.result = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac.1
 * JD-Core Version:    0.7.0.1
 */