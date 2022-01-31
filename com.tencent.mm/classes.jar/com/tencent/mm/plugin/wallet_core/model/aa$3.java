package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

final class aa$3
  implements e.a
{
  aa$3(aa paramaa, long paramLong1, long paramLong2, int paramInt1, int paramInt2, Map paramMap) {}
  
  public final void Q(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      long l1 = bk.a((Long)paramMap.get("wallet_balance_version"), -1L);
      long l2 = bk.a((Long)paramMap.get("wallet_balance_last_update_time"), -1L);
      if ((l2 < 0L) || (l1 < 0L) || (l2 + this.qyJ > bk.UZ()) || (this.qyK >= l1))
      {
        e.a(new e.c[] { new e.c("wallet_balance_version", Long.valueOf(this.qyK)), new e.c("wallet_balance_last_update_time", Long.valueOf(bk.UZ())), new e.c("wallet_balance", Double.valueOf(this.qyL / 100.0D)) });
        aa.d(this.qyM, this.qyI);
      }
    }
    else
    {
      return;
    }
    y.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa.3
 * JD-Core Version:    0.7.0.1
 */