package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class JSAPIUploadLogHelperUI$2
  implements DialogInterface.OnDismissListener
{
  JSAPIUploadLogHelperUI$2(JSAPIUploadLogHelperUI paramJSAPIUploadLogHelperUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(29439);
    if (!this.yYK.isFinishing()) {
      this.yYK.finish();
    }
    AppMethodBeat.o(29439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI.2
 * JD-Core Version:    0.7.0.1
 */