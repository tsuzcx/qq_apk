package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.z;

final class WalletIapUI$2
  implements d
{
  WalletIapUI$2(WalletIapUI paramWalletIapUI) {}
  
  public final void a(com.tencent.mm.plugin.wallet_index.c.b paramb, com.tencent.mm.plugin.wallet_index.b.a.c paramc)
  {
    AppMethodBeat.i(48273);
    ab.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramb + ", purchase: " + paramc);
    if ((WalletIapUI.b(this.uBu) instanceof a))
    {
      if (paramc != null) {
        z.d(paramc.uzV, paramc.liu, paramc.uAb, paramb.nGE, paramb.nGF);
      }
    }
    else
    {
      if (!paramb.cXe()) {
        break label261;
      }
      ab.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + paramb.nGE + " , errMsg: " + paramb.nGF);
      if (paramb.nGE != 1) {
        break label247;
      }
      WalletIapUI.a(this.uBu, 1001);
    }
    for (;;)
    {
      paramc = new Intent();
      paramc.putExtra("key_err_code", paramb.nGE);
      paramc.putExtra("key_err_msg", paramb.nGF);
      paramc.putExtra("key_launch_ts", a.uAu);
      paramc.putExtra("key_gw_error_code", paramb.uAc);
      this.uBu.setResult(-1, paramc);
      this.uBu.finish();
      AppMethodBeat.o(48273);
      return;
      a locala = (a)WalletIapUI.b(this.uBu);
      z.d(locala.uAy, locala.liu, locala.uAb, paramb.nGE, paramb.nGF);
      break;
      label247:
      WalletIapUI.a(this.uBu, 1002);
    }
    label261:
    if (!paramb.cXd())
    {
      if (paramc != null)
      {
        ab.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramc.liu + ",billNo:" + paramc.uzY);
        g.RM();
        g.RK().eHt.a(WalletIapUI.d(this.uBu).a(paramc, false), 0);
        WalletIapUI.b(this.uBu, 2);
        WalletIapUI.e(this.uBu);
        AppMethodBeat.o(48273);
        return;
      }
      WalletIapUI.a(this.uBu, 1002);
      paramb = new Intent();
      paramc = com.tencent.mm.plugin.wallet_index.c.b.bu(6, "");
      paramb.putExtra("key_err_code", paramc.nGE);
      paramb.putExtra("key_err_msg", paramc.nGF);
      paramb.putExtra("key_launch_ts", a.uAu);
      paramb.putExtra("key_gw_error_code", paramc.uAc);
      this.uBu.setResult(-1, paramb);
      this.uBu.finish();
      AppMethodBeat.o(48273);
      return;
    }
    WalletIapUI.b(this.uBu, 3);
    ab.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
    WalletIapUI.b(this.uBu).b(this.uBu, false);
    AppMethodBeat.o(48273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.2
 * JD-Core Version:    0.7.0.1
 */