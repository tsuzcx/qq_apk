package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.Map;

final class k$4$1
  implements Runnable
{
  k$4$1(k.4 param4, String paramString, e.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(43356);
    s locals = k.bYG();
    String str2 = this.gWF;
    long l = this.fkG.eyJ.pIG;
    ab.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(l)));
    ab.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str2)));
    label160:
    String str1;
    Map localMap;
    if (!TextUtils.isEmpty(str2))
    {
      if ((locals.piV == null) || (locals.piV.size() == 0)) {
        ab.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
      }
      for (;;)
      {
        i = 0;
        if (i == 0) {
          break;
        }
        ab.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(l)));
        AppMethodBeat.o(43356);
        return;
        i = 0;
        for (;;)
        {
          if (i >= locals.piV.size()) {
            break label160;
          }
          if (((Long)locals.piV.get(i)).longValue() == l)
          {
            i = 1;
            break;
          }
          i += 1;
        }
      }
      str1 = null;
      localMap = br.F(str2, "sysmsg");
      if (localMap == null) {
        break label384;
      }
      str1 = (String)localMap.get(".sysmsg.paymsg.ack_key");
    }
    label384:
    for (int i = bo.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);; i = -1)
    {
      if (a.bZX())
      {
        ab.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", new Object[] { Integer.valueOf(i) });
        if ((i == 7) || (i == 10))
        {
          locals.Wj(str2);
          locals.Wk(str2);
        }
      }
      for (;;)
      {
        if (locals.piV.size() > 10) {
          locals.piV.remove(locals.piV.size() - 1);
        }
        locals.piV.add(0, Long.valueOf(l));
        AppMethodBeat.o(43356);
        return;
        if (g.fH(str1, str2))
        {
          ab.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
          h.qsU.idkeyStat(135L, 70L, 1L, true);
          locals.Wj(str2);
          locals.Wk(str2);
          continue;
          g.fH(str1, str2);
          locals.Wj(str2);
          locals.Wk(str2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.k.4.1
 * JD-Core Version:    0.7.0.1
 */