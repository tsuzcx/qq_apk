package com.tencent.mm.plugin.wallet.balance.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletBalanceFetchUI$18
  implements TextWatcher
{
  WalletBalanceFetchUI$18(WalletBalanceFetchUI paramWalletBalanceFetchUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(45378);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    str.length();
    int j = str.lastIndexOf(".");
    int k = str.length();
    if ((i >= 0) && (k - i > 3)) {
      paramEditable.delete(i + 3, k);
    }
    for (;;)
    {
      WalletBalanceFetchUI.a(this.tOj, bo.getDouble(paramEditable.toString(), 0.0D));
      WalletBalanceFetchUI.i(this.tOj);
      WalletBalanceFetchUI.cRc();
      WalletBalanceFetchUI.j(this.tOj);
      AppMethodBeat.o(45378);
      return;
      if (j != i) {
        paramEditable.delete(j, k);
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.18
 * JD-Core Version:    0.7.0.1
 */