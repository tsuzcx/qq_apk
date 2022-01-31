package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class ag$1
  implements bz.a
{
  ag$1(ag paramag) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(46917);
    parama = aa.a(parama.eyJ.woR);
    ab.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(parama)));
    parama = br.F(parama, "sysmsg");
    int i = bo.getInt((String)parama.get(".sysmsg.paymsg.PayMsgType"), -1);
    if (!ag.a(this.ulr, i, parama)) {
      ag.e(i, parama);
    }
    AppMethodBeat.o(46917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag.1
 * JD-Core Version:    0.7.0.1
 */