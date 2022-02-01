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
    int j = this.val$editText.getSelectionStart();
    int k = this.val$editText.getSelectionEnd();
    if (bt.isNullOrNil(this.Byq))
    {
      this.val$editText.setText("");
      AppMethodBeat.o(73146);
      return;
    }
    this.val$editText.setText(this.Byq);
    EditText localEditText = this.val$editText;
    int i = j;
    if (j > this.Byq.length()) {
      i = this.Byq.length();
    }
    j = k;
    if (k > this.Byq.length()) {
      j = this.Byq.length();
    }
    localEditText.setSelection(i, j);
    AppMethodBeat.o(73146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.formview.WalletFormView.4
 * JD-Core Version:    0.7.0.1
 */