package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletBaseUI$7$2
  implements Runnable
{
  WalletBaseUI$7$2(WalletBaseUI.7 param7) {}
  
  public final void run()
  {
    this.wCp.wCn.VH();
    if (this.wCp.eYg) {
      ((InputMethodManager)this.wCp.wCn.mController.uMN.getSystemService("input_method")).showSoftInput(this.wCp.eYi, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.7.2
 * JD-Core Version:    0.7.0.1
 */