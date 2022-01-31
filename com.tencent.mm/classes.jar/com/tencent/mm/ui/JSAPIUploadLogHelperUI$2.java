package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class JSAPIUploadLogHelperUI$2
  implements DialogInterface.OnDismissListener
{
  JSAPIUploadLogHelperUI$2(JSAPIUploadLogHelperUI paramJSAPIUploadLogHelperUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.uKI.isFinishing()) {
      this.uKI.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.JSAPIUploadLogHelperUI.2
 * JD-Core Version:    0.7.0.1
 */