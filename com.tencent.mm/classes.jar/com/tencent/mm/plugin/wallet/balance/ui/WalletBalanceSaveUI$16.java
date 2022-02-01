package com.tencent.mm.plugin.wallet.balance.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletBalanceSaveUI$16
  implements TextWatcher
{
  WalletBalanceSaveUI$16(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(276487);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    paramEditable = paramEditable.toString();
    int i = paramEditable.indexOf(".");
    int j = paramEditable.length();
    if ((i >= 0) && (j - i > 3)) {
      WalletFormView.a(this.Ooq.tZh.getContentEt(), paramEditable, i + 3, j);
    }
    for (;;)
    {
      WalletBalanceSaveUI.f(this.Ooq);
      AppMethodBeat.o(276487);
      return;
      if (i > 10) {
        WalletFormView.a(this.Ooq.tZh.getContentEt(), paramEditable, 10, i);
      } else if ((i == -1) && (j > 10)) {
        WalletFormView.a(this.Ooq.tZh.getContentEt(), paramEditable, 10, j);
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.16
 * JD-Core Version:    0.7.0.1
 */