package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ai;

final class BankRemitBankcardInputUI$24
  implements TextWatcher
{
  BankRemitBankcardInputUI$24(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    BankRemitBankcardInputUI.n(this.nwd);
    ai.l(new Runnable()
    {
      public final void run()
      {
        BankRemitBankcardInputUI.k(BankRemitBankcardInputUI.24.this.nwd);
      }
    }, 200L);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.24
 * JD-Core Version:    0.7.0.1
 */