package com.tencent.mm.wallet_core.ui.formview;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletFormView$1
  implements TextWatcher
{
  private boolean pXO = false;
  
  WalletFormView$1(WalletFormView paramWalletFormView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(49410);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    boolean bool = this.AZr.asv();
    if (WalletFormView.i(this.AZr) != null)
    {
      if (bool != this.pXO)
      {
        WalletFormView.i(this.AZr).onInputValidChange(bool);
        this.pXO = this.AZr.asv();
      }
      if (((WalletFormView.i(this.AZr) instanceof WalletFormView.b)) && (bool)) {
        WalletFormView.i(this.AZr);
      }
    }
    WalletFormView.j(this.AZr);
    AppMethodBeat.o(49410);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142680);
    if (WalletFormView.h(this.AZr) != null) {
      WalletFormView.h(this.AZr).m(paramCharSequence);
    }
    AppMethodBeat.o(142680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView.1
 * JD-Core Version:    0.7.0.1
 */