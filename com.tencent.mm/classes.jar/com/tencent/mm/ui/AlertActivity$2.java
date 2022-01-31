package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class AlertActivity$2
  implements DialogInterface.OnCancelListener
{
  AlertActivity$2(AlertActivity paramAlertActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (AlertActivity.b(this.uGx) != null) {
      AlertActivity.b(this.uGx).onCancel(paramDialogInterface);
    }
    this.uGx.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity.2
 * JD-Core Version:    0.7.0.1
 */