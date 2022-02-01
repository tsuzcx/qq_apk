package com.tencent.mm.wallet_core.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$3
  implements Runnable
{
  WalletBaseUI$3(WalletBaseUI paramWalletBaseUI, EditText paramEditText) {}
  
  public final void run()
  {
    AppMethodBeat.i(72964);
    if (this.val$hintTv.findFocus() == null) {
      this.val$hintTv.requestFocus();
    }
    AppMethodBeat.o(72964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.3
 * JD-Core Version:    0.7.0.1
 */