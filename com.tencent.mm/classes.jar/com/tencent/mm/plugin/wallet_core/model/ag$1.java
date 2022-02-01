package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

final class ag$1
  implements cc.a
{
  ag$1(ag paramag) {}
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(70436);
    parama = z.a(parama.fXi.DPV);
    ac.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(parama)));
    Map localMap = bv.L(parama, "sysmsg");
    int i = bs.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
    Object[] arrayOfObject = new Object[1];
    if (!ag.a(this.BAc, i, localMap, parama, arrayOfObject)) {
      ag.a(i, localMap, arrayOfObject);
    }
    AppMethodBeat.o(70436);
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag.1
 * JD-Core Version:    0.7.0.1
 */