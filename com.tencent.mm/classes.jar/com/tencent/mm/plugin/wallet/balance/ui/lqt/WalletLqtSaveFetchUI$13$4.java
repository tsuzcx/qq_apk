package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;
import java.math.RoundingMode;

final class WalletLqtSaveFetchUI$13$4
  implements com.tencent.mm.vending.c.a<Void, cie>
{
  WalletLqtSaveFetchUI$13$4(WalletLqtSaveFetchUI.13 param13, int paramInt) {}
  
  private Void a(cie paramcie)
  {
    AppMethodBeat.i(68989);
    ad.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { paramcie, Boolean.valueOf(paramcie.EdA), Boolean.valueOf(paramcie.EdB) });
    this.zMk.zMe.dZI();
    Object localObject;
    if ((paramcie.EdA) && (paramcie.EdB))
    {
      localObject = new Intent(this.zMk.zMe, WalletLqtSaveFetchFinishUI.class);
      ((Intent)localObject).putExtra("key_amount", e.b(this.zMm, "100", RoundingMode.HALF_UP));
      ((Intent)localObject).putExtra("key_mode", 2);
      paramcie = this.zMk.zMe;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramcie, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$20$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramcie.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramcie, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$20$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      this.zMk.zMe.finish();
      paramcie = HPQ;
      AppMethodBeat.o(68989);
      return paramcie;
      localObject = new Intent(this.zMk.zMe, WalletLqtSaveFetchFinishProgressUI.class);
      try
      {
        ((Intent)localObject).putExtra("key_redeem_res", paramcie.toByteArray());
        paramcie = this.zMk.zMe;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramcie, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$20$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramcie.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramcie, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$20$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      catch (Exception paramcie)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramcie, "pass redeemFundRes error: %s", new Object[] { paramcie.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13.4
 * JD-Core Version:    0.7.0.1
 */