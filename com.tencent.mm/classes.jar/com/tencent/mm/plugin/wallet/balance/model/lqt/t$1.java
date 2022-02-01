package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.wallet_core.c.aa;

final class t$1
  implements com.tencent.mm.vending.c.a<Void, a.a<cpo>>
{
  t$1(t paramt, b paramb) {}
  
  private Void a(a.a<cpo> parama)
  {
    AppMethodBeat.i(182499);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finish, errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (cpo)parama.hQv;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(parama.oGt), parama.oGu });
      if (parama.oGt == 0)
      {
        ae.aFj(parama.CPZ);
        ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(am.a.IXi, Long.valueOf(parama.Hro));
        this.cnt.F(new Object[] { parama });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(663L, 0L, 1L, false);
      }
    }
    for (;;)
    {
      parama = LEs;
      AppMethodBeat.o(182499);
      return parama;
      this.cnt.ef(parama.oGu);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(663L, 1L, 1L, false);
      continue;
      this.cnt.ef(Boolean.FALSE);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(663L, 2L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.t.1
 * JD-Core Version:    0.7.0.1
 */