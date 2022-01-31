package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.text.Editable;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUCardElementUI$3
  extends WalletPayUCardElementUI.a
{
  WalletPayUCardElementUI$3(WalletPayUCardElementUI paramWalletPayUCardElementUI)
  {
    super(paramWalletPayUCardElementUI, (byte)0);
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(48362);
    WalletPayUCardElementUI.a(this.uCg, WalletPayUCardElementUI.c(this.uCg), paramEditable);
    AppMethodBeat.o(48362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI.3
 * JD-Core Version:    0.7.0.1
 */