package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class o$8
  implements DialogInterface.OnDismissListener
{
  o$8(Bitmap paramBitmap) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31350);
    if ((this.val$bmp == null) || (this.val$bmp.isRecycled()))
    {
      AppMethodBeat.o(31350);
      return;
    }
    ad.i("MicroMsg.MMConfirmDialog", "bitmap recycle %s", new Object[] { this.val$bmp.toString() });
    this.val$bmp.recycle();
    AppMethodBeat.o(31350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.o.8
 * JD-Core Version:    0.7.0.1
 */