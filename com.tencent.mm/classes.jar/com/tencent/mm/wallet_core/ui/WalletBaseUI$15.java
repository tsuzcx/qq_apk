package com.tencent.mm.wallet_core.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$15
  implements Runnable
{
  WalletBaseUI$15(WalletBaseUI paramWalletBaseUI, EditText paramEditText) {}
  
  public final void run()
  {
    AppMethodBeat.i(72976);
    if (this.val$editText.findFocus() == null) {
      this.val$editText.requestFocus();
    }
    AppMethodBeat.o(72976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.15
 * JD-Core Version:    0.7.0.1
 */