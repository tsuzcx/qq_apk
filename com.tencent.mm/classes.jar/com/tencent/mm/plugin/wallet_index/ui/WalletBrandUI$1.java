package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;

final class WalletBrandUI$1
  implements DialogInterface.OnCancelListener
{
  WalletBrandUI$1(WalletBrandUI paramWalletBrandUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48244);
    g.RM();
    g.RK().eHt.a(WalletBrandUI.a(this.uBc));
    this.uBc.finish();
    AppMethodBeat.o(48244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.1
 * JD-Core Version:    0.7.0.1
 */