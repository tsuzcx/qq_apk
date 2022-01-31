package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class BankRemitMoneyInputUI$1
  implements TextWatcher
{
  BankRemitMoneyInputUI$1(BankRemitMoneyInputUI paramBankRemitMoneyInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(44630);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 2)) {
      paramEditable.delete(i + 3, j);
    }
    paramEditable = paramEditable.toString();
    if ((!bo.isNullOrNil(paramEditable)) && (bo.getDouble(paramEditable, 0.0D) > 0.0D)) {
      BankRemitMoneyInputUI.a(this.qij).setVisibility(0);
    }
    for (;;)
    {
      BankRemitMoneyInputUI.a(this.qij, paramEditable);
      BankRemitMoneyInputUI.b(this.qij);
      AppMethodBeat.o(44630);
      return;
      BankRemitMoneyInputUI.a(this.qij).setVisibility(8);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.1
 * JD-Core Version:    0.7.0.1
 */