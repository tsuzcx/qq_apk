package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.math.RoundingMode;

final class WalletLqtSaveFetchUI$13$2
  implements com.tencent.mm.vending.c.a<Void, cen>
{
  WalletLqtSaveFetchUI$13$2(WalletLqtSaveFetchUI.13 param13, int paramInt) {}
  
  private Void a(cen paramcen)
  {
    AppMethodBeat.i(68985);
    ad.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(paramcen.Eav) });
    this.zMk.zMe.dZI();
    Object localObject = new Intent(this.zMk.zMe, WalletLqtSaveFetchFinishUI.class);
    ((Intent)localObject).putExtra("key_amount", e.b(this.zMm, "100", RoundingMode.HALF_UP));
    ((Intent)localObject).putExtra("key_mode", 1);
    ((Intent)localObject).putExtra("profile_date_wording", paramcen.Eax);
    ((Intent)localObject).putExtra("profile_upgrade_wording", paramcen.Eaw);
    if (paramcen.Eay != null) {}
    try
    {
      ((Intent)localObject).putExtra("key_guide_cell", paramcen.Eay.toByteArray());
      ((Intent)localObject).putExtra("entrance_type", this.zMk.zMe.getIntent().getIntExtra("entrance_type", 0));
      paramcen = this.zMk.zMe;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramcen, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$20$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramcen.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramcen, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$20$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.zMk.zMe.finish();
      paramcen = HPQ;
      AppMethodBeat.o(68985);
      return paramcen;
    }
    catch (IOException paramcen)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramcen, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.13.2
 * JD-Core Version:    0.7.0.1
 */