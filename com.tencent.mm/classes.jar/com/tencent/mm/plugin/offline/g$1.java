package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

final class g$1
  implements f
{
  g$1(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(43312);
    Map localMap;
    if (((paramm instanceof d)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (d)paramm;
      g.access$002(paramm.pla);
      if (g.access$000() == 0) {
        g.access$002(g.access$100());
      }
      ab.i(g.access$200(), "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[] { paramm.plb, paramm.pkZ });
      if ((bo.isNullOrNil(paramm.pkZ)) || (bo.isNullOrNil(paramm.plb))) {
        break label317;
      }
      if (g.fH(paramm.plb, paramm.pkZ))
      {
        ab.i(g.access$200(), "from cgi");
        if (br.F(paramm.pkZ, "sysmsg") == null)
        {
          AppMethodBeat.o(43312);
          return;
        }
        h.qsU.idkeyStat(135L, 71L, 1L, true);
        k.bYF();
        paramString = k.bYG();
        paramm = paramm.pkZ;
        ab.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
        if (!TextUtils.isEmpty(paramm))
        {
          localMap = br.F(paramm, "sysmsg");
          if (localMap == null) {
            break label328;
          }
          localMap.get(".sysmsg.paymsg.ack_key");
        }
      }
    }
    label317:
    label328:
    for (paramInt1 = bo.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; paramInt1 = -1)
    {
      if ((a.bZX()) && (paramInt1 != 7) && (paramInt1 != 10))
      {
        ab.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
        paramString.Wj(paramm);
        paramString.Wk(paramm);
      }
      for (;;)
      {
        ab.i(g.access$200(), "mIntercal=" + g.access$000());
        paramString = g.a(this.pkr);
        long l = g.access$000();
        paramString.ag(l, l);
        AppMethodBeat.o(43312);
        return;
        ab.i(g.access$200(), "OfflineGetMsgLogic msg is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g.1
 * JD-Core Version:    0.7.0.1
 */