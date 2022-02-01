package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class WalletOrderInfoOldUI$9
  implements h.c
{
  WalletOrderInfoOldUI$9(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void kM(int paramInt)
  {
    AppMethodBeat.i(71051);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(71051);
      return;
      WalletOrderInfoOldUI.a(this.AoQ, false);
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.AoQ.upF));
      ((Intent)localObject).addFlags(268435456);
      WalletOrderInfoOldUI localWalletOrderInfoOldUI = this.AoQ;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localWalletOrderInfoOldUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletOrderInfoOldUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localWalletOrderInfoOldUI, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.9
 * JD-Core Version:    0.7.0.1
 */