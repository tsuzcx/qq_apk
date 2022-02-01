package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class ac$10
  implements a<Void, c.a<bum>>
{
  ac$10(ac paramac) {}
  
  private Void a(c.a<bum> parama)
  {
    AppMethodBeat.i(182504);
    ad.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.atq(((bum)parama.gUK).zFY);
      s.zEV.a(((bum)parama.gUK).DRF, true);
      s.zEV.a((bum)parama.gUK);
    }
    if (ac.d(this.zFP) != null) {
      ac.d(this.zFP).resume();
    }
    parama = HPQ;
    AppMethodBeat.o(182504);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ac.10
 * JD-Core Version:    0.7.0.1
 */