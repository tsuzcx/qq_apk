package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletBaseUI$8
  implements View.OnClickListener
{
  WalletBaseUI$8(WalletBaseUI paramWalletBaseUI, boolean paramBoolean, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    if ((!this.wCn.lMr.isShown()) && (!this.eYg))
    {
      this.wCn.cNi();
      this.wCn.IZ(this.eYk);
    }
    while (!this.eYg) {
      return;
    }
    this.wCn.VH();
    ((InputMethodManager)this.wCn.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.8
 * JD-Core Version:    0.7.0.1
 */