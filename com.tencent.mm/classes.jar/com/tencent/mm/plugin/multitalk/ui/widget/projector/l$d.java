package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
final class l$d
  implements DialogInterface.OnClickListener
{
  l$d(l paraml) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(203592);
    l.a(this.FDa);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(203592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.l.d
 * JD-Core Version:    0.7.0.1
 */