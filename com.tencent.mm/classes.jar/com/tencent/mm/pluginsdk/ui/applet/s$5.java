package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$5
  implements DialogInterface.OnCancelListener
{
  s$5(s params) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79793);
    this.vUx.onStop();
    if (this.vUx.vUr != null) {
      this.vUx.vUr.bL(false);
    }
    AppMethodBeat.o(79793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.5
 * JD-Core Version:    0.7.0.1
 */