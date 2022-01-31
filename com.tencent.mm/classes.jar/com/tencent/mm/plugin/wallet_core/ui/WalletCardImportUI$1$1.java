package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletCardImportUI$1$1
  implements Runnable
{
  WalletCardImportUI$1$1(WalletCardImportUI.1 param1, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(47264);
    if (this.upi != WalletCardImportUI.a(this.upj.uph).getVisibility()) {
      WalletCardImportUI.a(this.upj.uph).setVisibility(this.upi);
    }
    AppMethodBeat.o(47264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.1.1
 * JD-Core Version:    0.7.0.1
 */