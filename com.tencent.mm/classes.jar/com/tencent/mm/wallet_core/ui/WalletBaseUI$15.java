package com.tencent.mm.wallet_core.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBaseUI$15
  implements View.OnClickListener
{
  WalletBaseUI$15(WalletBaseUI paramWalletBaseUI, boolean paramBoolean, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49255);
    if ((!this.AYz.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      this.AYz.showTenpayKB();
      this.AYz.setKBMode(this.val$editMode);
      AppMethodBeat.o(49255);
      return;
    }
    if (this.val$isShowSysKB)
    {
      this.AYz.hideTenpayKB();
      ((InputMethodManager)this.AYz.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
    }
    AppMethodBeat.o(49255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.15
 * JD-Core Version:    0.7.0.1
 */