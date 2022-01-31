package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_index.c.b;
import com.tencent.mm.sdk.platformtools.y;

final class WalletIapUI$2
  implements d
{
  WalletIapUI$2(WalletIapUI paramWalletIapUI) {}
  
  public final void a(b paramb, com.tencent.mm.plugin.wallet_index.b.a.c paramc)
  {
    y.d("MicroMsg.WalletIapUI", "Consume finished: " + paramb + ", purchase: " + paramc);
    if (paramb.isFailure())
    {
      WalletIapUI.a(this.qMn, 1002);
      y.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Fail ! ");
    }
    for (;;)
    {
      paramc = new Intent();
      paramc.putExtra("key_err_code", paramb.ljp);
      paramc.putExtra("key_err_msg", paramb.ljq);
      paramc.putStringArrayListExtra("key_response_product_ids", WalletIapUI.b(this.qMn).qLF);
      paramc.putStringArrayListExtra("key_response_series_ids", WalletIapUI.b(this.qMn).qLG);
      paramc.putExtra("key_launch_ts", a.qLy);
      this.qMn.setResult(-1, paramc);
      this.qMn.finish();
      return;
      WalletIapUI.a(this.qMn, 1000);
      y.d("MicroMsg.WalletIapUI", "back to preview UI, reason: consume Success ! ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.2
 * JD-Core Version:    0.7.0.1
 */