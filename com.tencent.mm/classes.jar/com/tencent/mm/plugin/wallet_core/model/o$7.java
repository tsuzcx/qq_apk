package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Map;

final class o$7
  implements bx.a
{
  o$7(o paramo) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    Map localMap = bn.s(parama, "sysmsg");
    if (localMap == null) {}
    do
    {
      do
      {
        return;
        i = bk.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        y.i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = " + i);
        switch (i)
        {
        default: 
          return;
        case 16: 
          i = bk.getInt((String)localMap.get(".sysmsg.paymsg.Flag"), 0);
          y.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
          if (i != 1) {
            break;
          }
          y.i("MicroMsg.SubCoreWalletCore", "open wallet");
          q.Gt();
          return;
        case 17: 
          i = bk.getInt((String)localMap.get(".sysmsg.paymsg.WalletType"), -1);
          y.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
        }
      } while (i < 0);
      g.DQ();
      g.DP().Dz().o(339975, Integer.valueOf(i));
      return;
    } while (i != 2);
    y.i("MicroMsg.SubCoreWalletCore", "close wallet");
    int i = q.Gp();
    g.DQ();
    g.DP().Dz().o(40, Integer.valueOf(i & 0xFFFF7FFF));
    return;
    y.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", new Object[] { parama });
    g.DQ();
    g.DS().O(new o.7.1(this, localMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.o.7
 * JD-Core Version:    0.7.0.1
 */