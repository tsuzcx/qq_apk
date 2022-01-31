package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WcPayRealnameVerifyIdInputUI$13
  implements TextWatcher
{
  WcPayRealnameVerifyIdInputUI$13(WcPayRealnameVerifyIdInputUI paramWcPayRealnameVerifyIdInputUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(142430);
    WcPayRealnameVerifyIdInputUI.a(this.udw, paramEditable.toString());
    paramEditable = WcPayRealnameVerifyIdInputUI.b(this.udw);
    String str = WcPayRealnameVerifyIdInputUI.c(this.udw).getText();
    paramEditable.udG.setValue(str);
    AppMethodBeat.o(142430);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.13
 * JD-Core Version:    0.7.0.1
 */