package com.tencent.mm.plugin.textstatus.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
final class TextStatusEditActivity$ay
  implements DialogInterface.OnClickListener
{
  public static final ay MMM;
  
  static
  {
    AppMethodBeat.i(236987);
    MMM = new ay();
    AppMethodBeat.o(236987);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(236984);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(236984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.ay
 * JD-Core Version:    0.7.0.1
 */