package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.k.d;

final class WalletBankcardDetailUI$8
  implements k.d
{
  WalletBankcardDetailUI$8(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void qz(int paramInt)
  {
    AppMethodBeat.i(69085);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(69085);
      return;
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.Vkn.getString(a.i.wallet_bankcard_detail_bankphone_number)));
      ((Intent)localObject).addFlags(268435456);
      WalletBankcardDetailUI localWalletBankcardDetailUI = this.Vkn;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localWalletBankcardDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletBankcardDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localWalletBankcardDetailUI, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.8
 * JD-Core Version:    0.7.0.1
 */