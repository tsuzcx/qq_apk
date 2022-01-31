package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class a$1$1
  implements a.a
{
  a$1$1(a.1 param1, boolean paramBoolean) {}
  
  public final void a(com.tencent.mm.plugin.wallet_index.c.b paramb, com.tencent.mm.plugin.wallet_index.b.a.b paramb1)
  {
    AppMethodBeat.i(48218);
    ab.d("MicroMsg.GoogleWallet", "Query inventory finished.");
    if ((paramb.cXe()) || (paramb1 == null))
    {
      ab.w("MicroMsg.GoogleWallet", "Failed to query inventory: ".concat(String.valueOf(paramb)));
      AppMethodBeat.o(48218);
      return;
    }
    ab.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
    a.a(this.uAA.uAz, paramb1);
    paramb = a.c(this.uAA.uAz);
    ArrayList localArrayList = new ArrayList(paramb1.uzT.keySet());
    paramb.uAF.clear();
    paramb.uAF.addAll(localArrayList);
    paramb = new ArrayList(paramb1.uzT.values());
    if (paramb.size() > 0)
    {
      paramb = paramb.iterator();
      while (paramb.hasNext())
      {
        paramb1 = (com.tencent.mm.plugin.wallet_index.b.a.c)paramb.next();
        ab.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + paramb1.liu + ",billNo:" + paramb1.uzY);
        g.RM();
        g.RK().eHt.a(a.c(this.uAA.uAz).a(paramb1, true), 0);
      }
      AppMethodBeat.o(48218);
      return;
    }
    ab.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
    if (!this.nGl) {
      ab.d("MicroMsg.GoogleWallet", "unknown_purchase");
    }
    for (paramb = com.tencent.mm.plugin.wallet_index.c.b.bu(5, "");; paramb = com.tencent.mm.plugin.wallet_index.c.b.bu(0, ""))
    {
      if (a.d(this.uAA.uAz) != null) {
        a.d(this.uAA.uAz).a(paramb, null);
      }
      AppMethodBeat.o(48218);
      return;
      ab.d("MicroMsg.GoogleWallet", "result ok");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.a.1.1
 * JD-Core Version:    0.7.0.1
 */