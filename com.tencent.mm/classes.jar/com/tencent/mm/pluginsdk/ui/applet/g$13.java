package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.c;

final class g$13
  implements DialogInterface.OnClickListener
{
  g$13(c paramc, q.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27651);
    this.jMO.dismiss();
    if (this.jMQ != null) {
      this.jMQ.a(false, null, 0);
    }
    AppMethodBeat.o(27651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.13
 * JD-Core Version:    0.7.0.1
 */