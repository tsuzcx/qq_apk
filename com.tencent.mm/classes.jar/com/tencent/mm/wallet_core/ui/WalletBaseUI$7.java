package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WalletBaseUI$7
  implements View.OnFocusChangeListener
{
  WalletBaseUI$7(WalletBaseUI paramWalletBaseUI, boolean paramBoolean1, boolean paramBoolean2, View paramView, EditText paramEditText, int paramInt, View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramView.isFocused()) && (!this.eYg))
    {
      ((InputMethodManager)this.wCn.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ah().postDelayed(new WalletBaseUI.7.1(this, paramView), 300L);
    }
    for (;;)
    {
      if (this.wCo != null) {
        this.wCo.onFocusChange(paramView, paramBoolean);
      }
      return;
      new ah().postDelayed(new WalletBaseUI.7.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.7
 * JD-Core Version:    0.7.0.1
 */