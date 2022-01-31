package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class WalletBaseUI$12$1
  implements Runnable
{
  WalletBaseUI$12$1(WalletBaseUI.12 param12, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(142670);
    if ((!this.AYB.AYz.mWcKeyboard.isShown()) && (this.bTJ.isShown()))
    {
      if ((this.AYB.val$isShowFirstTime) || (!WalletBaseUI.12.a(this.AYB))) {
        this.AYB.AYz.showNormalStWcKb();
      }
      WalletBaseUI.12.b(this.AYB);
    }
    this.AYB.AYz.mWcKeyboard.setInputEditText(this.AYB.nje);
    ((InputMethodManager)this.AYB.AYz.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.bTJ.getWindowToken(), 0);
    AppMethodBeat.o(142670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.12.1
 * JD-Core Version:    0.7.0.1
 */