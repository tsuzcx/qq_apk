package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class s$3
  implements DialogInterface.OnClickListener
{
  s$3(s params) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(79791);
    if (this.vUx.gwf != null)
    {
      this.vUx.gwf.dismiss();
      this.vUx.gwf = null;
    }
    this.vUx.onStop();
    if (this.vUx.vUr != null) {
      this.vUx.vUr.bL(false);
    }
    AppMethodBeat.o(79791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s.3
 * JD-Core Version:    0.7.0.1
 */