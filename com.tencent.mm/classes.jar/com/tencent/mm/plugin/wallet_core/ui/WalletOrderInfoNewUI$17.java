package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k.d;

final class WalletOrderInfoNewUI$17
  implements k.d
{
  WalletOrderInfoNewUI$17(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void qz(int paramInt)
  {
    AppMethodBeat.i(301213);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(301213);
      return;
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletOrderInfoNewUI.D(this.VQz)));
      ((Intent)localObject).addFlags(268435456);
      WalletOrderInfoNewUI localWalletOrderInfoNewUI = this.VQz;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localWalletOrderInfoNewUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$26", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletOrderInfoNewUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localWalletOrderInfoNewUI, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$26", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.17
 * JD-Core Version:    0.7.0.1
 */