package com.tencent.mm.pluginsdk.ui.applet;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class b$1
  implements DialogInterface.OnCancelListener
{
  b$1(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.sbU.faz != null)
    {
      this.sbU.faz.dismiss();
      this.sbU.faz = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b.1
 * JD-Core Version:    0.7.0.1
 */