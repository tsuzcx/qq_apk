package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProductFurtherInfoUI$a$1
  implements Runnable
{
  ProductFurtherInfoUI$a$1(ProductFurtherInfoUI.a parama, ImageView paramImageView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(81048);
    this.lHj.setImageBitmap(this.val$bitmap);
    this.lHj.setBackgroundColor(0);
    AppMethodBeat.o(81048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductFurtherInfoUI.a.1
 * JD-Core Version:    0.7.0.1
 */