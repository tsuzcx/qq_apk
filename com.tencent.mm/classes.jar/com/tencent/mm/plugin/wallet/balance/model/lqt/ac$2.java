package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class ac$2
  implements a<Void, c.a<buo>>
{
  ac$2(ac paramac) {}
  
  private Void a(c.a<buo> parama)
  {
    AppMethodBeat.i(182503);
    ad.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.atq(((buo)parama.gUK).zFY);
      v.dYO().a((buo)parama.gUK);
      s.zEV.a(((buo)parama.gUK).DRF, false);
    }
    if (ac.d(this.zFP) != null) {
      ac.d(this.zFP).resume();
    }
    parama = HPQ;
    AppMethodBeat.o(182503);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ac.2
 * JD-Core Version:    0.7.0.1
 */