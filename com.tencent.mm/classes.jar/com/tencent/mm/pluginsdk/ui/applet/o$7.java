package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class o$7
  implements DialogInterface.OnDismissListener
{
  o$7(Bitmap paramBitmap) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(196118);
    if ((this.val$bmp == null) || (this.val$bmp.isRecycled()))
    {
      AppMethodBeat.o(196118);
      return;
    }
    AppMethodBeat.o(196118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.7
 * JD-Core Version:    0.7.0.1
 */