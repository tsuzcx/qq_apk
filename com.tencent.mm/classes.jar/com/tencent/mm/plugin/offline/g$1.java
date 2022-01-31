package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class g$1
  implements f
{
  g$1(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (((paramm instanceof d)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (d)paramm;
      g.access$002(paramm.mKJ);
      if (g.access$000() == 0) {
        g.access$002(g.access$100());
      }
      y.i(g.BG(), "NetSceneOfflineGetMsg: ackkey: %s, appMsg: %s", new Object[] { paramm.mKK, paramm.mKI });
      if ((bk.bl(paramm.mKI)) || (bk.bl(paramm.mKK))) {
        break label302;
      }
      if (!g.em(paramm.mKK, paramm.mKI)) {
        break label255;
      }
      y.i(g.BG(), "from cgi");
      if (bn.s(paramm.mKI, "sysmsg") != null) {}
    }
    else
    {
      return;
    }
    h.nFQ.a(135L, 71L, 1L, true);
    k.bpX();
    paramString = k.bpY();
    paramm = paramm.mKI;
    y.i("MicroMsg.WalletOfflineMsgManager", "notifyMsgFromCgi");
    Map localMap;
    if (!TextUtils.isEmpty(paramm))
    {
      localMap = bn.s(paramm, "sysmsg");
      if (localMap == null) {
        break label313;
      }
      localMap.get(".sysmsg.paymsg.ack_key");
    }
    label302:
    label313:
    for (paramInt1 = bk.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; paramInt1 = -1)
    {
      if ((a.bri()) && (paramInt1 != 7) && (paramInt1 != 10))
      {
        y.i("MicroMsg.WalletOfflineMsgManager", "process msg from pull");
        paramString.Kk(paramm);
        paramString.Kl(paramm);
      }
      for (;;)
      {
        label255:
        y.i(g.BG(), "mIntercal=" + g.access$000());
        paramString = g.a(this.mKc);
        long l = g.access$000();
        paramString.S(l, l);
        return;
        y.i(g.BG(), "OfflineGetMsgLogic msg is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.g.1
 * JD-Core Version:    0.7.0.1
 */