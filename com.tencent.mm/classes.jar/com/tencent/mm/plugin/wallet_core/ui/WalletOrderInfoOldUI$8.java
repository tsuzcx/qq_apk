package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k.d;

final class WalletOrderInfoOldUI$8
  implements k.d
{
  WalletOrderInfoOldUI$8(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void qz(int paramInt)
  {
    AppMethodBeat.i(71051);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(71051);
      return;
      WalletOrderInfoOldUI.a(this.VRm, false);
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.VRm.MFC));
      ((Intent)localObject).addFlags(268435456);
      WalletOrderInfoOldUI localWalletOrderInfoOldUI = this.VRm;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localWalletOrderInfoOldUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletOrderInfoOldUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localWalletOrderInfoOldUI, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.8
 * JD-Core Version:    0.7.0.1
 */