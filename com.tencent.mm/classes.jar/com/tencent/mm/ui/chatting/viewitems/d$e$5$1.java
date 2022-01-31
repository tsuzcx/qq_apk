package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$e$5$1
  implements Runnable
{
  d$e$5$1(d.e.5 param5, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(32842);
    if (!this.val$bitmap.isRecycled()) {
      this.zTb.zSV.zSD.setImageBitmap(this.val$bitmap);
    }
    AppMethodBeat.o(32842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e.5.1
 * JD-Core Version:    0.7.0.1
 */