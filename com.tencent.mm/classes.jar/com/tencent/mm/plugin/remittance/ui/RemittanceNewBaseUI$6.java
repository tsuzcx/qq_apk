package com.tencent.mm.plugin.remittance.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class RemittanceNewBaseUI$6
  implements TextWatcher
{
  RemittanceNewBaseUI$6(RemittanceNewBaseUI paramRemittanceNewBaseUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(142231);
    double d = bo.getDouble(paramEditable.toString(), 0.0D);
    if ((!this.qqR.kRl.asv()) || (d < 0.01D))
    {
      RemittanceNewBaseUI.a(this.qqR, false);
      AppMethodBeat.o(142231);
      return;
    }
    RemittanceNewBaseUI.a(this.qqR, true);
    AppMethodBeat.o(142231);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceNewBaseUI.6
 * JD-Core Version:    0.7.0.1
 */