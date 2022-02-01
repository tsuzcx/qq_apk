package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;

final class WalletLqtPlanAddUI$27
  implements TextWatcher
{
  WalletLqtPlanAddUI$27(WalletLqtPlanAddUI paramWalletLqtPlanAddUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(68861);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 2)) {
      paramEditable.delete(i + 3, j);
    }
    WalletLqtPlanAddUI.h(this.Hzj);
    WalletLqtPlanAddUI.c(this.Hzj);
    if (j == 0)
    {
      WalletLqtPlanAddUI.b(this.Hzj).DH(false);
      AppMethodBeat.o(68861);
      return;
    }
    WalletLqtPlanAddUI.b(this.Hzj).DH(true);
    AppMethodBeat.o(68861);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI.27
 * JD-Core Version:    0.7.0.1
 */