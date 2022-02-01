package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;
import java.io.IOException;
import java.math.RoundingMode;

final class WalletLqtSaveFetchUI$20$2
  implements com.tencent.mm.vending.c.a<Void, dhj>
{
  WalletLqtSaveFetchUI$20$2(WalletLqtSaveFetchUI.20 param20, int paramInt) {}
  
  private Void a(dhj paramdhj)
  {
    AppMethodBeat.i(213989);
    if (paramdhj == null)
    {
      Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed, qryPurchaseResultRes is null");
      AppMethodBeat.o(213989);
      return null;
    }
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", new Object[] { Integer.valueOf(paramdhj.MLH) });
    this.HBU.HBI.fNV();
    Object localObject = new Intent(this.HBU.HBI, WalletLqtSaveFetchFinishUI.class);
    ((Intent)localObject).putExtra("key_amount", f.a(this.HBW, "100", 2, RoundingMode.HALF_UP));
    ((Intent)localObject).putExtra("key_mode", 1);
    ((Intent)localObject).putExtra("profile_date_wording", paramdhj.MLJ);
    ((Intent)localObject).putExtra("profile_upgrade_wording", paramdhj.MLI);
    if (paramdhj.MLK != null) {}
    try
    {
      ((Intent)localObject).putExtra("key_guide_cell", paramdhj.MLK.toByteArray());
      ((Intent)localObject).putExtra("entrance_type", this.HBU.HBI.getIntent().getIntExtra("entrance_type", 0));
      paramdhj = this.HBU.HBI;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramdhj, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramdhj.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramdhj, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.HBU.HBI.finish();
      paramdhj = QZL;
      AppMethodBeat.o(213989);
      return paramdhj;
    }
    catch (IOException paramdhj)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramdhj, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.20.2
 * JD-Core Version:    0.7.0.1
 */