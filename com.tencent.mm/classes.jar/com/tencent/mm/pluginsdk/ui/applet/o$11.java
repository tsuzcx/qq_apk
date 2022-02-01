package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.d;

final class o$11
  implements DialogInterface.OnClickListener
{
  o$11(d paramd, y.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31354);
    this.shK.dismiss();
    if (this.shM != null) {
      this.shM.a(false, null, 0);
    }
    AppMethodBeat.o(31354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.11
 * JD-Core Version:    0.7.0.1
 */