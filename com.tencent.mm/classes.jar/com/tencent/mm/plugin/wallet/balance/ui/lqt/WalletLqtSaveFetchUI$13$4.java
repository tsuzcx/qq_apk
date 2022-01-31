package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;

final class WalletLqtSaveFetchUI$13$4
  implements a<Void, bsv>
{
  WalletLqtSaveFetchUI$13$4(WalletLqtSaveFetchUI.13 param13, int paramInt) {}
  
  private Void a(bsv parambsv)
  {
    AppMethodBeat.i(155084);
    ab.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { parambsv, Boolean.valueOf(parambsv.xGr), Boolean.valueOf(parambsv.xGs) });
    if ((parambsv.xGr) && (parambsv.xGs))
    {
      parambsv = new Intent(this.tSf.tRZ, WalletLqtSaveFetchFinishUI.class);
      parambsv.putExtra("key_amount", e.b(this.tSg, "100", RoundingMode.HALF_UP));
      parambsv.putExtra("key_mode", 2);
      this.tSf.tRZ.startActivity(parambsv);
    }
    for (;;)
    {
      this.tSf.tRZ.finish();
      parambsv = AOo;
      AppMethodBeat.o(155084);
      return parambsv;
      Intent localIntent = new Intent(this.tSf.tRZ, WalletLqtSaveFetchFinishProgressUI.class);
      try
      {
        localIntent.putExtra("key_redeem_res", parambsv.toByteArray());
        this.tSf.tRZ.startActivity(localIntent);
      }
      catch (Exception parambsv)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", parambsv, "pass redeemFundRes error: %s", new Object[] { parambsv.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13.4
 * JD-Core Version:    0.7.0.1
 */