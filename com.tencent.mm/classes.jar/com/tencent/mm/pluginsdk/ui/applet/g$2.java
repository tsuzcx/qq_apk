package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$2
  implements DialogInterface.OnClickListener
{
  g$2(q.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27640);
    if (this.vTq != null) {
      this.vTq.a(false, null, 0);
    }
    AppMethodBeat.o(27640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.2
 * JD-Core Version:    0.7.0.1
 */