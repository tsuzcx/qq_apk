package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

final class ag$3
  implements e.a
{
  ag$3(ag paramag, long paramLong1, long paramLong2, int paramInt1, int paramInt2, Map paramMap) {}
  
  public final void al(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(46919);
    if (paramMap != null)
    {
      long l1 = bo.a((Long)paramMap.get("wallet_balance_version"), -1L);
      long l2 = bo.a((Long)paramMap.get("wallet_balance_last_update_time"), -1L);
      if ((l2 < 0L) || (l1 < 0L) || (l2 + this.ult > bo.yB()) || (this.oxV >= l1))
      {
        e.a(new e.c[] { new e.c("wallet_balance_version", Long.valueOf(this.oxV)), new e.c("wallet_balance_last_update_time", Long.valueOf(bo.yB())), new e.c("wallet_balance", Double.valueOf(this.ulu / 100.0D)) });
        ag.e(this.ulv, this.bQD);
        AppMethodBeat.o(46919);
        return;
      }
      ab.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
    }
    AppMethodBeat.o(46919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag.3
 * JD-Core Version:    0.7.0.1
 */