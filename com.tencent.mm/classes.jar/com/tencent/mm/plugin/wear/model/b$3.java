package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;

final class b$3
  implements n.b
{
  b$3(b paramb) {}
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(26276);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.Wear.WearBizLogic", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(26276);
      return;
    }
    paramn = (String)paramObject;
    if ((paramn != null) && (paramn.equals("gh_43f2581f6fd6")))
    {
      if ((!b.cYz()) && (this.uGP.uGM))
      {
        this.uGP.uGM = false;
        AppMethodBeat.o(26276);
        return;
      }
      if ((b.cYz()) && (!this.uGP.uGM)) {
        this.uGP.connect();
      }
    }
    AppMethodBeat.o(26276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b.3
 * JD-Core Version:    0.7.0.1
 */