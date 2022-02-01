package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class t$4
  implements a<Void, a.a<ceo>>
{
  t$4(t paramt, b paramb) {}
  
  private Void a(a.a<ceo> parama)
  {
    AppMethodBeat.i(182501);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.aFj(((ceo)parama.hQv).CPZ);
      s.COW.a(((ceo)parama.hQv).Hrl, true);
      s.COW.a((ceo)parama.hQv);
    }
    for (;;)
    {
      this.cnt.resume();
      parama = LEs;
      AppMethodBeat.o(182501);
      return parama;
      parama = ak.getContext().getString(2131765901);
      Toast.makeText(ak.getContext(), parama, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.4
 * JD-Core Version:    0.7.0.1
 */