package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
final class p$b$2
  implements DialogInterface.OnClickListener
{
  public static final 2 FDM;
  
  static
  {
    AppMethodBeat.i(201357);
    FDM = new 2();
    AppMethodBeat.o(201357);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(201356);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(201356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.p.b.2
 * JD-Core Version:    0.7.0.1
 */