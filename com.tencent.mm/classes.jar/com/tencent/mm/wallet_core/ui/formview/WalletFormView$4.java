package com.tencent.mm.wallet_core.ui.formview;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

final class WalletFormView$4
  implements Runnable
{
  WalletFormView$4(EditText paramEditText, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(73146);
    int j = this.sWC.getSelectionStart();
    int k = this.sWC.getSelectionEnd();
    if (bs.isNullOrNil(this.AgE))
    {
      this.sWC.setText("");
      AppMethodBeat.o(73146);
      return;
    }
    this.sWC.setText(this.AgE);
    EditText localEditText = this.sWC;
    int i = j;
    if (j > this.AgE.length()) {
      i = this.AgE.length();
    }
    j = k;
    if (k > this.AgE.length()) {
      j = this.AgE.length();
    }
    localEditText.setSelection(i, j);
    AppMethodBeat.o(73146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView.4
 * JD-Core Version:    0.7.0.1
 */