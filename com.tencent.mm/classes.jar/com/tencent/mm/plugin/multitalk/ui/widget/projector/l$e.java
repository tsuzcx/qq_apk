package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
final class l$e
  implements DialogInterface.OnClickListener
{
  public static final e FDc;
  
  static
  {
    AppMethodBeat.i(201367);
    FDc = new e();
    AppMethodBeat.o(201367);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(201364);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(201364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.l.e
 * JD-Core Version:    0.7.0.1
 */