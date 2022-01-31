package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$9
  implements DialogInterface.OnDismissListener
{
  g$9(Bitmap paramBitmap) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(27647);
    if ((this.val$bmp == null) || (this.val$bmp.isRecycled()))
    {
      AppMethodBeat.o(27647);
      return;
    }
    AppMethodBeat.o(27647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.9
 * JD-Core Version:    0.7.0.1
 */