package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class WalletBankcardDetailUI$8
  implements h.c
{
  WalletBankcardDetailUI$8(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void kG(int paramInt)
  {
    AppMethodBeat.i(69085);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(69085);
      return;
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.Bfy.getString(2131765040)));
      ((Intent)localObject).addFlags(268435456);
      WalletBankcardDetailUI localWalletBankcardDetailUI = this.Bfy;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localWalletBankcardDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletBankcardDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localWalletBankcardDetailUI, "com/tencent/mm/plugin/wallet/bind/ui/WalletBankcardDetailUI$8", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.8
 * JD-Core Version:    0.7.0.1
 */