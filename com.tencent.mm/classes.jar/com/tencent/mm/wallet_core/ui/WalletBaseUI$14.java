package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class WalletBaseUI$14
  implements View.OnFocusChangeListener
{
  WalletBaseUI$14(WalletBaseUI paramWalletBaseUI, boolean paramBoolean1, boolean paramBoolean2, View paramView, EditText paramEditText, int paramInt, View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142676);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)this.AYz.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ak().postDelayed(new WalletBaseUI.14.1(this, paramView), 300L);
    }
    for (;;)
    {
      if (this.AYA != null) {
        this.AYA.onFocusChange(paramView, paramBoolean);
      }
      AppMethodBeat.o(142676);
      return;
      new ak().postDelayed(new WalletBaseUI.14.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.14
 * JD-Core Version:    0.7.0.1
 */