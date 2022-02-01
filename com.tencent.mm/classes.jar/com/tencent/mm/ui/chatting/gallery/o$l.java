package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
final class o$l
  implements DialogInterface.OnClickListener
{
  public static final l WVr;
  
  static
  {
    AppMethodBeat.i(290996);
    WVr = new l();
    AppMethodBeat.o(290996);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(290993);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.cancel();
      AppMethodBeat.o(290993);
      return;
    }
    AppMethodBeat.o(290993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.o.l
 * JD-Core Version:    0.7.0.1
 */