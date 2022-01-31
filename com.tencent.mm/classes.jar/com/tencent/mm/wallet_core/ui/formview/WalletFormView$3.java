package com.tencent.mm.wallet_core.ui.formview;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class WalletFormView$3
  implements TextWatcher
{
  WalletFormView$3(WalletFormView paramWalletFormView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(142681);
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((this.AZs >= 0) && (i >= 0) && (j - i > this.AZs)) {
      paramEditable.delete(this.AZs + i + 1, j);
    }
    if (this.AZt >= 0)
    {
      int k = WalletFormView.k(this.AZr).getSelectionStart();
      if (i > this.AZt)
      {
        if ((!bo.hl(k, -1)) && (i - this.AZt > 0) && (k - (i - this.AZt) >= 0))
        {
          paramEditable.delete(k - (i - 7), k);
          AppMethodBeat.o(142681);
        }
      }
      else if ((bo.hl(i, -1)) && (j > this.AZt) && (k >= 0) && (k - (j - this.AZt) >= 0)) {
        paramEditable.delete(k - (j - this.AZt), k);
      }
    }
    AppMethodBeat.o(142681);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView.3
 * JD-Core Version:    0.7.0.1
 */