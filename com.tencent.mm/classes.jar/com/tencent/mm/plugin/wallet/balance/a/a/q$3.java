package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class q$3
  implements a<Void, a.a<bhh>>
{
  q$3(q paramq, b paramb) {}
  
  private Void d(a.a<bhh> parama)
  {
    AppMethodBeat.i(45263);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ab.aeP(((bhh)parama.fsN).tNy);
      s.cQR().a((bhh)parama.fsN);
      p.tMy.tMw = ((bhh)parama.fsN).xwk;
      p.tMy.a(((bhh)parama.fsN).xwj, false);
    }
    for (;;)
    {
      this.bDR.resume();
      parama = AOo;
      AppMethodBeat.o(45263);
      return parama;
      parama = ah.getContext().getString(2131305682);
      Toast.makeText(ah.getContext(), parama, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.q.3
 * JD-Core Version:    0.7.0.1
 */