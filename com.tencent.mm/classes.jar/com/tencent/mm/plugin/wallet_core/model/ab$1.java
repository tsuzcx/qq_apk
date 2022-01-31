package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

final class ab$1
  implements e.a
{
  ab$1(long paramLong1, long paramLong2, int paramInt, Bankcard paramBankcard) {}
  
  public final void Q(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      long l1 = bk.a((Long)paramMap.get("wallet_balance_version"), -1L);
      long l2 = bk.a((Long)paramMap.get("wallet_balance_last_update_time"), -1L);
      if ((l2 < 0L) || (l1 < 0L) || (l2 + this.qyN > bk.UZ()) || (this.qyO >= l1))
      {
        e.a(new e.c[] { new e.c("wallet_balance_version", Long.valueOf(this.qyO)), new e.c("wallet_balance_last_update_time", Long.valueOf(bk.UZ())), new e.c("wallet_balance", Double.valueOf(this.qyL / 100.0D)) });
        this.qyP.qty = (this.qyL / 100.0D);
      }
    }
    else
    {
      return;
    }
    y.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ab.1
 * JD-Core Version:    0.7.0.1
 */