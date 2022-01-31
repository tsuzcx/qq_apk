package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;
import com.tencent.mm.plugin.remittance.bankcard.model.c;

final class BankRemitBankcardInputUI$22
  implements TextWatcher
{
  BankRemitBankcardInputUI$22(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    BankRemitBankcardInputUI.c(this.nwd);
    BankRemitBankcardInputUI.d(this.nwd);
    if ((BankRemitBankcardInputUI.e(this.nwd)) && (BankRemitBankcardInputUI.f(this.nwd) != null)) {
      BankRemitBankcardInputUI.h(this.nwd).getFilter().filter(paramEditable.toString(), BankRemitBankcardInputUI.g(this.nwd));
    }
    for (;;)
    {
      if (BankRemitBankcardInputUI.i(this.nwd)) {
        BankRemitBankcardInputUI.j(this.nwd);
      }
      BankRemitBankcardInputUI.k(this.nwd);
      BankRemitBankcardInputUI.l(this.nwd);
      return;
      BankRemitBankcardInputUI.a(this.nwd, true);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.22
 * JD-Core Version:    0.7.0.1
 */