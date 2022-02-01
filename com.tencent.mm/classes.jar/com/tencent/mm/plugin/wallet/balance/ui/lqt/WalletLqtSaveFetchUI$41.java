package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.f;
import java.math.RoundingMode;

final class WalletLqtSaveFetchUI$41
  implements com.tencent.mm.vending.c.a<Void, dlv>
{
  WalletLqtSaveFetchUI$41(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, int paramInt) {}
  
  private Void a(dlv paramdlv)
  {
    AppMethodBeat.i(214017);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", new Object[] { paramdlv, Boolean.valueOf(paramdlv.MPt), Boolean.valueOf(paramdlv.MPu) });
    this.HBI.fNV();
    Object localObject;
    if ((paramdlv.MPt) && (paramdlv.MPu))
    {
      localObject = new Intent(this.HBI, WalletLqtSaveFetchFinishUI.class);
      ((Intent)localObject).putExtra("key_amount", f.a(this.HBW, "100", 2, RoundingMode.HALF_UP));
      ((Intent)localObject).putExtra("key_mode", 2);
      paramdlv = this.HBI;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramdlv, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramdlv.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramdlv, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      this.HBI.finish();
      paramdlv = QZL;
      AppMethodBeat.o(214017);
      return paramdlv;
      localObject = new Intent(this.HBI, WalletLqtSaveFetchFinishProgressNewUI.class);
      try
      {
        ((Intent)localObject).putExtra("key_redeem_res", paramdlv.toByteArray());
        paramdlv = this.HBI;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramdlv, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramdlv.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramdlv, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      catch (Exception paramdlv)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", paramdlv, "pass redeemFundRes error: %s", new Object[] { paramdlv.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.41
 * JD-Core Version:    0.7.0.1
 */