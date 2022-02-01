package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

final class ah$1
  implements e.a
{
  ah$1(long paramLong1, long paramLong2, int paramInt, Bankcard paramBankcard) {}
  
  public final void aT(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(70446);
    if (paramMap != null)
    {
      long l1 = bs.a((Long)paramMap.get("wallet_balance_version"), -1L);
      long l2 = bs.a((Long)paramMap.get("wallet_balance_last_update_time"), -1L);
      if ((l2 < 0L) || (l1 < 0L) || (l2 + this.BAi > bs.Gn()) || (this.BAj >= l1))
      {
        e.a(new e.c[] { new e.c("wallet_balance_version", Long.valueOf(this.BAj)), new e.c("wallet_balance_last_update_time", Long.valueOf(bs.Gn())), new e.c("wallet_balance", Double.valueOf(this.BAg / 100.0D)) });
        this.BAk.Buo = (this.BAg / 100.0D);
        AppMethodBeat.o(70446);
        return;
      }
      ac.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
    }
    AppMethodBeat.o(70446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ah.1
 * JD-Core Version:    0.7.0.1
 */