package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$b$2
  implements Runnable
{
  h$b$2(h.b paramb, ImageView paramImageView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(81062);
    this.lHj.setImageBitmap(this.val$bitmap);
    this.lHj.setBackgroundColor(0);
    AppMethodBeat.o(81062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h.b.2
 * JD-Core Version:    0.7.0.1
 */