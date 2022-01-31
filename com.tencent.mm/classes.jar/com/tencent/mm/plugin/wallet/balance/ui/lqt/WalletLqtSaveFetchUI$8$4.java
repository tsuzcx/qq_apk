package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.protocal.c.bjw;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;

final class WalletLqtSaveFetchUI$8$4
  implements a<Void, bjw>
{
  WalletLqtSaveFetchUI$8$4(WalletLqtSaveFetchUI.8 param8, int paramInt) {}
  
  private Void a(bjw parambjw)
  {
    y.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { parambjw, Boolean.valueOf(parambjw.tDD), Boolean.valueOf(parambjw.tDE) });
    if ((parambjw.tDD) && (parambjw.tDE))
    {
      parambjw = new Intent(this.qje.qiZ, WalletLqtSaveFetchFinishUI.class);
      parambjw.putExtra("key_amount", this.qjf / 100.0D);
      parambjw.putExtra("key_mode", 2);
      this.qje.qiZ.startActivity(parambjw);
    }
    for (;;)
    {
      this.qje.qiZ.finish();
      return wtt;
      Intent localIntent = new Intent(this.qje.qiZ, WalletLqtSaveFetchFinishProgressUI.class);
      try
      {
        localIntent.putExtra("key_redeem_res", parambjw.toByteArray());
        this.qje.qiZ.startActivity(localIntent);
      }
      catch (Exception parambjw)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", parambjw, "pass redeemFundRes error: %s", new Object[] { parambjw.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.8.4
 * JD-Core Version:    0.7.0.1
 */