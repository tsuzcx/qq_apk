package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k.d;

final class WalletBindCardResultUI$7
  implements k.d
{
  WalletBindCardResultUI$7(WalletBindCardResultUI paramWalletBindCardResultUI) {}
  
  public final void qz(int paramInt)
  {
    AppMethodBeat.i(70754);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(70754);
      return;
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletBindCardResultUI.i(this.VMC)));
      ((Intent)localObject).addFlags(268435456);
      WalletBindCardResultUI localWalletBindCardResultUI = this.VMC;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localWalletBindCardResultUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletBindCardResultUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localWalletBindCardResultUI, "com/tencent/mm/plugin/wallet_core/ui/WalletBindCardResultUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBindCardResultUI.7
 * JD-Core Version:    0.7.0.1
 */