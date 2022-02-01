package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.wallet_core.c.aa;

final class t$1
  implements com.tencent.mm.vending.c.a<Void, c.a<cju>>
{
  t$1(t paramt, b paramb) {}
  
  private Void a(c.a<cju> parama)
  {
    AppMethodBeat.i(182499);
    ac.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finish, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (cju)parama.hvj;
      ac.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(parama.nWx), parama.nWy });
      if (parama.nWx == 0)
      {
        ae.ayI(parama.AYl);
        ((com.tencent.mm.plugin.wxpay.a.a)g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ah.a.GQo, Long.valueOf(parama.Foc));
        this.cda.F(new Object[] { parama });
        h.wUl.idkeyStat(663L, 0L, 1L, false);
      }
    }
    for (;;)
    {
      parama = Jql;
      AppMethodBeat.o(182499);
      return parama;
      this.cda.eb(parama.nWy);
      h.wUl.idkeyStat(663L, 1L, 1L, false);
      continue;
      this.cda.eb(Boolean.FALSE);
      h.wUl.idkeyStat(663L, 2L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.1
 * JD-Core Version:    0.7.0.1
 */