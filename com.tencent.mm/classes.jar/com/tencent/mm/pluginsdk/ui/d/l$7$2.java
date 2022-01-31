package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

final class l$7$2
  implements DialogInterface.OnCancelListener
{
  l$7$2(l.7 param7) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.sjQ.sjL != null) {
      this.sjQ.sjL.onDismiss(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.7.2
 * JD-Core Version:    0.7.0.1
 */