package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;

final class g$10
  implements DialogInterface.OnDismissListener
{
  g$10(Bitmap paramBitmap) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.val$bmp == null) || (this.val$bmp.isRecycled())) {
      return;
    }
    this.val$bmp.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.10
 * JD-Core Version:    0.7.0.1
 */