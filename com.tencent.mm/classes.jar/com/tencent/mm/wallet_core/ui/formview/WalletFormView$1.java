package com.tencent.mm.wallet_core.ui.formview;

import android.text.Editable;
import android.text.TextWatcher;

final class WalletFormView$1
  implements TextWatcher
{
  private boolean nsA = false;
  
  WalletFormView$1(WalletFormView paramWalletFormView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = this.wDc.YL();
    if ((WalletFormView.h(this.wDc) != null) && (bool != this.nsA))
    {
      WalletFormView.h(this.wDc).gG(bool);
      this.nsA = this.wDc.YL();
    }
    WalletFormView.i(this.wDc);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView.1
 * JD-Core Version:    0.7.0.1
 */