package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.Map;

final class ah$1
  implements e.a
{
  ah$1(long paramLong1, long paramLong2, int paramInt, Bankcard paramBankcard) {}
  
  public final void al(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(46926);
    if (paramMap != null)
    {
      long l1 = bo.a((Long)paramMap.get("wallet_balance_version"), -1L);
      long l2 = bo.a((Long)paramMap.get("wallet_balance_last_update_time"), -1L);
      if ((l2 < 0L) || (l1 < 0L) || (l2 + this.ulw > bo.yB()) || (this.ulx >= l1))
      {
        e.a(new e.c[] { new e.c("wallet_balance_version", Long.valueOf(this.ulx)), new e.c("wallet_balance_last_update_time", Long.valueOf(bo.yB())), new e.c("wallet_balance", Double.valueOf(this.ulu / 100.0D)) });
        this.uly.ufM = (this.ulu / 100.0D);
        AppMethodBeat.o(46926);
        return;
      }
      ab.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
    }
    AppMethodBeat.o(46926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ah.1
 * JD-Core Version:    0.7.0.1
 */