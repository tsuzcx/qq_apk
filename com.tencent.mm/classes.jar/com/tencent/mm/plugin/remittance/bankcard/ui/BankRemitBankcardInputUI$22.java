package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.widget.Filter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.c;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitBankcardInputUI$22
  implements TextWatcher
{
  BankRemitBankcardInputUI$22(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(44536);
    BankRemitBankcardInputUI.c(this.qhe);
    BankRemitBankcardInputUI.d(this.qhe);
    if ((BankRemitBankcardInputUI.e(this.qhe)) && (BankRemitBankcardInputUI.f(this.qhe) != null)) {
      BankRemitBankcardInputUI.h(this.qhe).getFilter().filter(paramEditable.toString(), BankRemitBankcardInputUI.g(this.qhe));
    }
    for (;;)
    {
      if (BankRemitBankcardInputUI.i(this.qhe)) {
        BankRemitBankcardInputUI.j(this.qhe);
      }
      BankRemitBankcardInputUI.k(this.qhe);
      BankRemitBankcardInputUI.l(this.qhe);
      if ((BankRemitBankcardInputUI.m(this.qhe)) && (BankRemitBankcardInputUI.n(this.qhe).getInputLength() <= BankRemitBankcardInputUI.o(this.qhe)))
      {
        BankRemitBankcardInputUI.n(this.qhe).setMaxInputLength(BankRemitBankcardInputUI.o(this.qhe));
        BankRemitBankcardInputUI.n(this.qhe).setFilters(new InputFilter[] { new InputFilter.LengthFilter(BankRemitBankcardInputUI.o(this.qhe)) });
      }
      AppMethodBeat.o(44536);
      return;
      BankRemitBankcardInputUI.a(this.qhe, true);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.22
 * JD-Core Version:    0.7.0.1
 */