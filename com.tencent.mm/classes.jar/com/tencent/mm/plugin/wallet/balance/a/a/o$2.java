package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ah.a.a;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class o$2
  implements a<Void, a.a<bae>>
{
  o$2(o paramo) {}
  
  private Void d(a.a<bae> parama)
  {
    y.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      l.bTj().a((bae)parama.ecw);
      i.qfx.a(((bae)parama.ecw).tvY, false);
    }
    if (o.c(this.qgd) != null) {
      o.c(this.qgd).resume();
    }
    return wtt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.o.2
 * JD-Core Version:    0.7.0.1
 */