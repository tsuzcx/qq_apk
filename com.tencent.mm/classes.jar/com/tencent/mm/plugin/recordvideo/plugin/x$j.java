package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
public final class x$j
  implements DialogInterface.OnClickListener
{
  public static final j HOx;
  
  static
  {
    AppMethodBeat.i(217550);
    HOx = new j();
    AppMethodBeat.o(217550);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(217549);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(217549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.x.j
 * JD-Core Version:    0.7.0.1
 */