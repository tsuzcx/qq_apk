package com.tencent.mm.plugin.wallet_core.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletBankcardIdUI$6
  implements TextWatcher
{
  WalletBankcardIdUI$6(WalletBankcardIdUI paramWalletBankcardIdUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(47166);
    if ((this.unn.ung.asv()) && (!WalletBankcardIdUI.b(this.unn)))
    {
      WalletBankcardIdUI.c(this.unn);
      this.unn.ung.cfK();
    }
    AppMethodBeat.o(47166);
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.6
 * JD-Core Version:    0.7.0.1
 */