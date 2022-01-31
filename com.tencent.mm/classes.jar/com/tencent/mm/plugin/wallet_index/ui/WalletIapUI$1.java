package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.w;

final class WalletIapUI$1
  implements d
{
  WalletIapUI$1(WalletIapUI paramWalletIapUI) {}
  
  public final void a(com.tencent.mm.plugin.wallet_index.c.b paramb, com.tencent.mm.plugin.wallet_index.b.a.c paramc)
  {
    y.i("MicroMsg.WalletIapUI", "Pay Purchase finished: " + paramb + ", purchase: " + paramc);
    if ((WalletIapUI.a(this.qMn) instanceof a))
    {
      if (paramc != null) {
        w.c(paramc.qKZ, paramc.iZD, paramc.qLf, paramb.ljp, paramb.ljq);
      }
    }
    else
    {
      if (!paramb.isFailure()) {
        break label251;
      }
      y.i("MicroMsg.WalletIapUI", "back to preview UI, reason: purchase finish , errCode: " + paramb.ljp + " , errMsg: " + paramb.ljq);
      if (paramb.ljp != 1) {
        break label237;
      }
      WalletIapUI.a(this.qMn, 1001);
    }
    for (;;)
    {
      paramc = new Intent();
      paramc.putExtra("key_err_code", paramb.ljp);
      paramc.putExtra("key_err_msg", paramb.ljq);
      paramc.putExtra("key_launch_ts", a.qLy);
      paramc.putExtra("key_gw_error_code", paramb.qLg);
      this.qMn.setResult(-1, paramc);
      this.qMn.finish();
      return;
      a locala = (a)WalletIapUI.a(this.qMn);
      w.c(locala.qLC, locala.iZD, locala.qLf, paramb.ljp, paramb.ljq);
      break;
      label237:
      WalletIapUI.a(this.qMn, 1002);
    }
    label251:
    if (!paramb.bXy())
    {
      if (paramc != null)
      {
        y.i("MicroMsg.WalletIapUI", "verify purchase! productId:" + paramc.iZD + ",billNo:" + paramc.qLc);
        g.DQ();
        g.DO().dJT.a(WalletIapUI.b(this.qMn).a(paramc, false), 0);
        WalletIapUI.b(this.qMn, 2);
        WalletIapUI.c(this.qMn);
        return;
      }
      WalletIapUI.a(this.qMn, 1002);
      paramb = new Intent();
      paramc = com.tencent.mm.plugin.wallet_index.c.b.aP(6, "");
      paramb.putExtra("key_err_code", paramc.ljp);
      paramb.putExtra("key_err_msg", paramc.ljq);
      paramb.putExtra("key_launch_ts", a.qLy);
      paramb.putExtra("key_gw_error_code", paramc.qLg);
      this.qMn.setResult(-1, paramb);
      this.qMn.finish();
      return;
    }
    WalletIapUI.b(this.qMn, 3);
    y.i("MicroMsg.WalletIapUI", "start to restore the purchase!");
    WalletIapUI.a(this.qMn).c(this.qMn, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.1
 * JD-Core Version:    0.7.0.1
 */