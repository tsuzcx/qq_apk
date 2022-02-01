package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class t$4
  implements a<Void, a.a<cdu>>
{
  t$4(t paramt, b paramb) {}
  
  private Void a(a.a<cdu> parama)
  {
    AppMethodBeat.i(182501);
    ad.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.aDQ(((cdu)parama.hNC).Cyu);
      s.Cxr.a(((cdu)parama.hNC).GXL, true);
      s.Cxr.a((cdu)parama.hNC);
    }
    for (;;)
    {
      this.cnr.resume();
      parama = LhQ;
      AppMethodBeat.o(182501);
      return parama;
      parama = aj.getContext().getString(2131765901);
      Toast.makeText(aj.getContext(), parama, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.4
 * JD-Core Version:    0.7.0.1
 */