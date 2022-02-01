package com.tencent.mm.wallet_core.ui.formview;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class WalletFormView$4
  implements Runnable
{
  WalletFormView$4(EditText paramEditText, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(73146);
    int j = this.rOM.getSelectionStart();
    int k = this.rOM.getSelectionEnd();
    if (bt.isNullOrNil(this.ySP))
    {
      this.rOM.setText("");
      AppMethodBeat.o(73146);
      return;
    }
    this.rOM.setText(this.ySP);
    EditText localEditText = this.rOM;
    int i = j;
    if (j > this.ySP.length()) {
      i = this.ySP.length();
    }
    j = k;
    if (k > this.ySP.length()) {
      j = this.ySP.length();
    }
    localEditText.setSelection(i, j);
    AppMethodBeat.o(73146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView.4
 * JD-Core Version:    0.7.0.1
 */