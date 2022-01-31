package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.a.a;
import com.tencent.mm.protocal.c.bac;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class o$10
  implements a<Void, a.a<bac>>
{
  o$10(o paramo) {}
  
  private Void d(a.a<bac> parama)
  {
    y.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      i.qfx.a(((bac)parama.ecw).tvY, true);
    }
    if (o.c(this.qgd) != null) {
      o.c(this.qgd).resume();
    }
    return wtt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.o.10
 * JD-Core Version:    0.7.0.1
 */