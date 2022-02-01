package com.tencent.mm.wallet_core.ui.formview;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

final class WalletFormView$4
  implements Runnable
{
  WalletFormView$4(EditText paramEditText, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(73146);
    int j = this.val$editText.getSelectionStart();
    int k = this.val$editText.getSelectionEnd();
    if (Util.isNullOrNil(this.HEG))
    {
      this.val$editText.setText("");
      AppMethodBeat.o(73146);
      return;
    }
    this.val$editText.setText(this.HEG);
    EditText localEditText = this.val$editText;
    int i = j;
    if (j > this.HEG.length()) {
      i = this.HEG.length();
    }
    j = k;
    if (k > this.HEG.length()) {
      j = this.HEG.length();
    }
    localEditText.setSelection(i, j);
    AppMethodBeat.o(73146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView.4
 * JD-Core Version:    0.7.0.1
 */