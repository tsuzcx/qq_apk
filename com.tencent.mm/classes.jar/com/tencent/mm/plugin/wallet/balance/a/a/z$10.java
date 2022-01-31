package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class z$10
  implements a<Void, a.a<bhf>>
{
  z$10(z paramz) {}
  
  private Void d(a.a<bhf> parama)
  {
    AppMethodBeat.i(45316);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ab.aeP(((bhf)parama.fsN).tNy);
      p.tMy.a(((bhf)parama.fsN).xwj, true);
      p.tMy.a((bhf)parama.fsN);
    }
    if (z.d(this.tNq) != null) {
      z.d(this.tNq).resume();
    }
    parama = AOo;
    AppMethodBeat.o(45316);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.z.10
 * JD-Core Version:    0.7.0.1
 */