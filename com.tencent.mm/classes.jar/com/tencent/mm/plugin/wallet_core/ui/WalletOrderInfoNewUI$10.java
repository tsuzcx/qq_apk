package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.d;

final class WalletOrderInfoNewUI$10
  implements h.d
{
  WalletOrderInfoNewUI$10(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void oj(int paramInt)
  {
    AppMethodBeat.i(70997);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(70997);
      return;
      Object localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + WalletOrderInfoNewUI.y(this.IhU)));
      ((Intent)localObject).addFlags(268435456);
      WalletOrderInfoNewUI localWalletOrderInfoNewUI = this.IhU;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localWalletOrderInfoNewUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$20", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localWalletOrderInfoNewUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localWalletOrderInfoNewUI, "com/tencent/mm/plugin/wallet_core/ui/WalletOrderInfoNewUI$20", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.10
 * JD-Core Version:    0.7.0.1
 */