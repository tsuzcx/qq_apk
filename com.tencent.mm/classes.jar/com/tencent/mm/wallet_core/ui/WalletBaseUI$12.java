package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class WalletBaseUI$12
  implements View.OnFocusChangeListener
{
  private boolean owT = true;
  
  WalletBaseUI$12(WalletBaseUI paramWalletBaseUI, boolean paramBoolean, EditText paramEditText, View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(142672);
    if (paramBoolean)
    {
      ((InputMethodManager)this.AYz.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ak().postDelayed(new WalletBaseUI.12.1(this, paramView), 300L);
    }
    for (;;)
    {
      if (this.AYA != null) {
        this.AYA.onFocusChange(paramView, paramBoolean);
      }
      AppMethodBeat.o(142672);
      return;
      new ak().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(142671);
          WalletBaseUI.12.this.AYz.hideWcKb();
          AppMethodBeat.o(142671);
        }
      }, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.12
 * JD-Core Version:    0.7.0.1
 */