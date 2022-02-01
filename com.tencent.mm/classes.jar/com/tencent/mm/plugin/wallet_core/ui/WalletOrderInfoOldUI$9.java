package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.d;

final class WalletOrderInfoOldUI$9
  implements h.d
{
  WalletOrderInfoOldUI$9(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void oj(int paramInt)
  {
    AppMethodBeat.i(71051);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(71051);
      return;
      WalletOrderInfoOldUI.a(this.Iir, false);
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.Iir.APz));
      ((Intent)localObject).addFlags(268435456);
      WalletOrderInfoOldUI localWalletOrderInfoOldUI = this.Iir;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localWalletOrderInfoOldUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletOrderInfoOldUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localWalletOrderInfoOldUI, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoOldUI$7", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.9
 * JD-Core Version:    0.7.0.1
 */