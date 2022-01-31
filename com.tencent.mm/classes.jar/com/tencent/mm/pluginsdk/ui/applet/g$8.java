package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$8
  implements PopupWindow.OnDismissListener
{
  g$8(Bitmap paramBitmap) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(27646);
    if ((this.val$bmp == null) || (this.val$bmp.isRecycled()))
    {
      AppMethodBeat.o(27646);
      return;
    }
    AppMethodBeat.o(27646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.8
 * JD-Core Version:    0.7.0.1
 */