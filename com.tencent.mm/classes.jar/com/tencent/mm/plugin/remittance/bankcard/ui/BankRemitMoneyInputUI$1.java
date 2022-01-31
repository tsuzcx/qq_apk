package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.bk;

final class BankRemitMoneyInputUI$1
  implements TextWatcher
{
  BankRemitMoneyInputUI$1(BankRemitMoneyInputUI paramBankRemitMoneyInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
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
    if ((!bk.bl(paramEditable)) && (bk.getDouble(paramEditable, 0.0D) > 0.0D)) {
      BankRemitMoneyInputUI.a(this.nxh).setVisibility(0);
    }
    for (;;)
    {
      BankRemitMoneyInputUI.a(this.nxh, paramEditable);
      BankRemitMoneyInputUI.b(this.nxh);
      return;
      BankRemitMoneyInputUI.a(this.nxh).setVisibility(8);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.1
 * JD-Core Version:    0.7.0.1
 */