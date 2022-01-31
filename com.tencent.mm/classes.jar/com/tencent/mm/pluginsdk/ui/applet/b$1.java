package com.tencent.mm.pluginsdk.ui.applet;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements DialogInterface.OnCancelListener
{
  b$1(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27624);
    if (this.vTc.gsr != null)
    {
      this.vTc.gsr.dismiss();
      this.vTc.gsr = null;
    }
    AppMethodBeat.o(27624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b.1
 * JD-Core Version:    0.7.0.1
 */