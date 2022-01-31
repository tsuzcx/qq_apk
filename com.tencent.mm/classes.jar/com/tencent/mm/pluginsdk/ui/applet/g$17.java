package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$17
  implements DialogInterface.OnClickListener
{
  g$17(q.a parama, View paramView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27655);
    if (this.vTq != null) {
      this.vTq.a(true, g.eA(this.val$view), g.eB(this.val$view));
    }
    AppMethodBeat.o(27655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.17
 * JD-Core Version:    0.7.0.1
 */