package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Map;

final class k$4$1
  implements Runnable
{
  k$4$1(k.4 param4, String paramString, e.a parama) {}
  
  public final void run()
  {
    s locals = k.bpY();
    String str2 = this.fEp;
    long l = this.dUx.dBs.ndp;
    y.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :" + l);
    y.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :" + str2);
    if (!TextUtils.isEmpty(str2))
    {
      if (locals.fr(l)) {
        y.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:" + l);
      }
    }
    else {
      return;
    }
    String str1 = null;
    Map localMap = bn.s(str2, "sysmsg");
    if (localMap != null) {
      str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
    }
    for (int i = bk.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
    {
      if (a.bri())
      {
        y.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
        if ((i == 7) || (i == 10))
        {
          locals.Kk(str2);
          locals.Kl(str2);
        }
      }
      for (;;)
      {
        if (locals.mIG.size() > 10) {
          locals.mIG.remove(locals.mIG.size() - 1);
        }
        locals.mIG.add(0, Long.valueOf(l));
        return;
        if (g.em(str1, str2))
        {
          y.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
          h.nFQ.a(135L, 70L, 1L, true);
          locals.Kk(str2);
          locals.Kl(str2);
          continue;
          g.em(str1, str2);
          locals.Kk(str2);
          locals.Kl(str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k.4.1
 * JD-Core Version:    0.7.0.1
 */