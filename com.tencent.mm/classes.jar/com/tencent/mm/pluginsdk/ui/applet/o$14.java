package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$14
  implements DialogInterface.OnClickListener
{
  o$14(y.a parama, View paramView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(232194);
    if (this.Kfe != null) {
      this.Kfe.a(true, o.gj(this.val$view), o.gk(this.val$view));
    }
    AppMethodBeat.o(232194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.14
 * JD-Core Version:    0.7.0.1
 */