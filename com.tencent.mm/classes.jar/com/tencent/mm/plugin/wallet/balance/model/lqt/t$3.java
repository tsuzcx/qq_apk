package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

final class t$3
  implements a<Void, a.a<cdw>>
{
  t$3(t paramt, b paramb) {}
  
  private Void a(a.a<cdw> parama)
  {
    AppMethodBeat.i(182500);
    ad.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ae.aDQ(((cdw)parama.hNC).Cyu);
      v.eCj().a((cdw)parama.hNC);
      s locals = s.Cxr;
      String str = ((cdw)parama.hNC).GXM;
      ajj localajj = ((cdw)parama.hNC).GXN;
      locals.Cxo = str;
      locals.Cxp = localajj;
      s.Cxr.a(((cdw)parama.hNC).GXL, false);
    }
    for (;;)
    {
      this.cnr.resume();
      parama = LhQ;
      AppMethodBeat.o(182500);
      return parama;
      parama = aj.getContext().getString(2131765901);
      Toast.makeText(aj.getContext(), parama, 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.3
 * JD-Core Version:    0.7.0.1
 */