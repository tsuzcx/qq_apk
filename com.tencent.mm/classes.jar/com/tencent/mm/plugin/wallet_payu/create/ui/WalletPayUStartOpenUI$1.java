package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUStartOpenUI$1
  implements TextWatcher
{
  WalletPayUStartOpenUI$1(WalletPayUStartOpenUI paramWalletPayUStartOpenUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(48395);
    WalletPayUStartOpenUI.a(this.uCF);
    AppMethodBeat.o(48395);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI.1
 * JD-Core Version:    0.7.0.1
 */