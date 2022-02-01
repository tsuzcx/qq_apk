package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class t$3
  implements a<Void, c.a<bzf>>
{
  t$3(t paramt, b paramb) {}
  
  private Void a(c.a<bzf> parama)
  {
    AppMethodBeat.i(182500);
    ac.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.ayI(((bzf)parama.hvj).AYl);
      v.eok().a((bzf)parama.hvj);
      s locals = s.AXi;
      String str = ((bzf)parama.hvj).Foa;
      agt localagt = ((bzf)parama.hvj).Fob;
      locals.AXf = str;
      locals.AXg = localagt;
      s.AXi.a(((bzf)parama.hvj).FnZ, false);
    }
    for (;;)
    {
      this.cda.resume();
      parama = Jql;
      AppMethodBeat.o(182500);
      return parama;
      parama = ai.getContext().getString(2131765901);
      Toast.makeText(ai.getContext(), parama, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.3
 * JD-Core Version:    0.7.0.1
 */