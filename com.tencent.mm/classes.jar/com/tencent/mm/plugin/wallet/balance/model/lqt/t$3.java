package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class t$3
  implements a<Void, a.a<ceq>>
{
  t$3(t paramt, b paramb) {}
  
  private Void a(a.a<ceq> parama)
  {
    AppMethodBeat.i(182500);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.aFj(((ceq)parama.hQv).CPZ);
      v.eFR().a((ceq)parama.hQv);
      s locals = s.COW;
      String str = ((ceq)parama.hQv).Hrm;
      ajt localajt = ((ceq)parama.hQv).Hrn;
      locals.COT = str;
      locals.COU = localajt;
      s.COW.a(((ceq)parama.hQv).Hrl, false);
    }
    for (;;)
    {
      this.cnt.resume();
      parama = LEs;
      AppMethodBeat.o(182500);
      return parama;
      parama = ak.getContext().getString(2131765901);
      Toast.makeText(ak.getContext(), parama, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.3
 * JD-Core Version:    0.7.0.1
 */