package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

final class l$6
  implements DialogInterface.OnCancelListener
{
  l$6(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.sjL != null) {
      this.sjL.onDismiss(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.6
 * JD-Core Version:    0.7.0.1
 */