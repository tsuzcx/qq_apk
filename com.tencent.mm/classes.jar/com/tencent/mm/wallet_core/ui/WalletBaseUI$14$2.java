package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$14$2
  implements Runnable
{
  WalletBaseUI$14$2(WalletBaseUI.14 param14) {}
  
  public final void run()
  {
    AppMethodBeat.i(142675);
    this.AYC.AYz.hideTenpayKB();
    if (this.AYC.val$isShowSysKB) {
      ((InputMethodManager)this.AYC.AYz.getContext().getSystemService("input_method")).showSoftInput(this.AYC.val$hintTv, 0);
    }
    AppMethodBeat.o(142675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.14.2
 * JD-Core Version:    0.7.0.1
 */