package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$d$3$1
  implements Runnable
{
  d$d$3$1(d.d.3 param3, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(32825);
    if (!this.val$bitmap.isRecycled()) {
      this.zSX.zSV.zSD.setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(32825);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.3.1
 * JD-Core Version:    0.7.0.1
 */