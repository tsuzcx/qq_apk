package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h.b;

final class BankRemitMoneyInputUI$8$1
  implements h.b
{
  BankRemitMoneyInputUI$8$1(BankRemitMoneyInputUI.8 param8) {}
  
  public final boolean m(CharSequence paramCharSequence)
  {
    if (!bk.bl(paramCharSequence.toString()))
    {
      BankRemitMoneyInputUI.c(this.nxk.nxh, paramCharSequence.toString());
      BankRemitMoneyInputUI.i(this.nxk.nxh);
    }
    for (;;)
    {
      return true;
      BankRemitMoneyInputUI.c(this.nxk.nxh, null);
      BankRemitMoneyInputUI.i(this.nxk.nxh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.8.1
 * JD-Core Version:    0.7.0.1
 */