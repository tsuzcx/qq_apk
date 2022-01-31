package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.a;

final class WalletPwdConfirmUI$4
  implements a
{
  WalletPwdConfirmUI$4(WalletPwdConfirmUI paramWalletPwdConfirmUI, ScrollView paramScrollView) {}
  
  public final void onVisibleStateChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47541);
    if (paramBoolean)
    {
      WalletPwdConfirmUI.a(this.usw, this.usx, WalletPwdConfirmUI.b(this.usw));
      AppMethodBeat.o(47541);
      return;
    }
    this.usx.scrollTo(0, 0);
    AppMethodBeat.o(47541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.4
 * JD-Core Version:    0.7.0.1
 */