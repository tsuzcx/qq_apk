package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductUI$8
  implements Runnable
{
  MallProductUI$8(MallProductUI paramMallProductUI, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(44165);
    MallProductUI.g(this.pxl).setImageBitmap(this.val$bitmap);
    AppMethodBeat.o(44165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.8
 * JD-Core Version:    0.7.0.1
 */