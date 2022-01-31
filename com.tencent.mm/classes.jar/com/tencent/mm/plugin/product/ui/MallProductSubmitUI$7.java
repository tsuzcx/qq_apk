package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallProductSubmitUI$7
  implements Runnable
{
  MallProductSubmitUI$7(MallProductSubmitUI paramMallProductSubmitUI, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(44145);
    MallProductSubmitUI.e(this.pxb).setImageBitmap(this.val$bitmap);
    AppMethodBeat.o(44145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.7
 * JD-Core Version:    0.7.0.1
 */