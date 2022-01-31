package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBrandUI$a$1
  implements DialogInterface.OnClickListener
{
  WalletBrandUI$a$1(WalletBrandUI.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(48249);
    this.uBe.uBc.setResult(0);
    this.uBe.uBc.finish();
    AppMethodBeat.o(48249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI.a.1
 * JD-Core Version:    0.7.0.1
 */