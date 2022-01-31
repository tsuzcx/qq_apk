package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class aa$1
  implements bx.a
{
  aa$1(aa paramaa) {}
  
  public final void a(e.a parama)
  {
    parama = com.tencent.mm.platformtools.aa.a(parama.dBs.svH);
    y.d("MicroMsg.WalletPushNotifyManager", "PayMsg:" + parama);
    parama = bn.s(parama, "sysmsg");
    int i = bk.getInt((String)parama.get(".sysmsg.paymsg.PayMsgType"), -1);
    if (!aa.a(this.qyG, i, parama)) {
      aa.d(i, parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa.1
 * JD-Core Version:    0.7.0.1
 */