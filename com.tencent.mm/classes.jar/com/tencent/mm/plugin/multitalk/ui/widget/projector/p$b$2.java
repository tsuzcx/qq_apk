package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
final class p$b$2
  implements DialogInterface.OnClickListener
{
  public static final 2 zYa;
  
  static
  {
    AppMethodBeat.i(240052);
    zYa = new 2();
    AppMethodBeat.o(240052);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(240051);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(240051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.p.b.2
 * JD-Core Version:    0.7.0.1
 */