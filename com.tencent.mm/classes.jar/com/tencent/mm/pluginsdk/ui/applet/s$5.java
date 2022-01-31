package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class s$5
  implements DialogInterface.OnCancelListener
{
  s$5(s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.sds.onStop();
    if (this.sds.sdo != null) {
      this.sds.sdo.bl(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.5
 * JD-Core Version:    0.7.0.1
 */