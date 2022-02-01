package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class t$4
  implements a<Void, c.a<bzd>>
{
  t$4(t paramt, b paramb) {}
  
  private Void a(c.a<bzd> parama)
  {
    AppMethodBeat.i(182501);
    ac.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.ayI(((bzd)parama.hvj).AYl);
      s.AXi.a(((bzd)parama.hvj).FnZ, true);
      s.AXi.a((bzd)parama.hvj);
    }
    for (;;)
    {
      this.cda.resume();
      parama = Jql;
      AppMethodBeat.o(182501);
      return parama;
      parama = ai.getContext().getString(2131765901);
      Toast.makeText(ai.getContext(), parama, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.4
 * JD-Core Version:    0.7.0.1
 */