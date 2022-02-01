package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
final class l$e
  implements DialogInterface.OnClickListener
{
  public static final e zXu;
  
  static
  {
    AppMethodBeat.i(240028);
    zXu = new e();
    AppMethodBeat.o(240028);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(240027);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(240027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.l.e
 * JD-Core Version:    0.7.0.1
 */