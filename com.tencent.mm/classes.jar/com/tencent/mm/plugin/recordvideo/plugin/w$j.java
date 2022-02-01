package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
public final class w$j
  implements DialogInterface.OnClickListener
{
  public static final j BRI;
  
  static
  {
    AppMethodBeat.i(237315);
    BRI = new j();
    AppMethodBeat.o(237315);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(237314);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(237314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w.j
 * JD-Core Version:    0.7.0.1
 */