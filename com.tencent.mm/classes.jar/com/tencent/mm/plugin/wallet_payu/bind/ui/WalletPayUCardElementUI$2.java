package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.text.Editable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUCardElementUI$2
  extends WalletPayUCardElementUI.a
{
  WalletPayUCardElementUI$2(WalletPayUCardElementUI paramWalletPayUCardElementUI)
  {
    super(paramWalletPayUCardElementUI, (byte)0);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(48361);
    WalletPayUCardElementUI.a(this.uCg, WalletPayUCardElementUI.b(this.uCg), paramEditable);
    AppMethodBeat.o(48361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.2
 * JD-Core Version:    0.7.0.1
 */