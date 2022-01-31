package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a.a;
import com.tencent.mm.sdk.platformtools.y;
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
    y.d("MicroMsg.GoogleWallet", "Query inventory finished.");
    if ((paramb.isFailure()) || (paramb1 == null)) {
      y.w("MicroMsg.GoogleWallet", "Failed to query inventory: " + paramb);
    }
    for (;;)
    {
      return;
      y.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
      a.a(this.qLE.qLD, paramb1);
      paramb = a.b(this.qLE.qLD);
      ArrayList localArrayList = new ArrayList(paramb1.qKX.keySet());
      paramb.qLJ.clear();
      paramb.qLJ.addAll(localArrayList);
      paramb = new ArrayList(paramb1.qKX.values());
      if (paramb.size() > 0)
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          paramb1 = (com.tencent.mm.plugin.wallet_index.b.a.c)paramb.next();
          y.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + paramb1.iZD + ",billNo:" + paramb1.qLc);
          g.DQ();
          g.DO().dJT.a(a.b(this.qLE.qLD).a(paramb1, true), 0);
        }
      }
      else
      {
        y.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
        if (!this.liW) {
          y.d("MicroMsg.GoogleWallet", "unknown_purchase");
        }
        for (paramb = com.tencent.mm.plugin.wallet_index.c.b.aP(5, ""); a.c(this.qLE.qLD) != null; paramb = com.tencent.mm.plugin.wallet_index.c.b.aP(0, ""))
        {
          a.c(this.qLE.qLD).a(paramb, null);
          return;
          y.d("MicroMsg.GoogleWallet", "result ok");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.a.1.1
 * JD-Core Version:    0.7.0.1
 */