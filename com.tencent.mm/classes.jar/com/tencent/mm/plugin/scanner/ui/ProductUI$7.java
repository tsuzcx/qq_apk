package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.ab;

final class ProductUI$7
  implements Runnable
{
  ProductUI$7(ProductUI paramProductUI, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(81087);
    if ((this.pnT.equals(ProductUI.a(this.qyh).field_thumburl)) && (ProductUI.s(this.qyh) != null)) {
      ab.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + this.pnT);
    }
    try
    {
      ProductUI.s(this.qyh).setImageBitmap(this.val$bitmap);
      ProductUI.s(this.qyh).setBackgroundDrawable(null);
      ProductUI.s(this.qyh).setBackgroundColor(-1);
      ProductUI.t(this.qyh);
      ProductUI.u(this.qyh);
      if ((this.pnT.equals(ProductUI.a(this.qyh).field_headerbackgroundurl)) && (ProductUI.v(this.qyh) != null)) {
        ProductUI.v(this.qyh).setImageBitmap(this.val$bitmap);
      }
      AppMethodBeat.o(81087);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[] { localException.getLocalizedMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.7
 * JD-Core Version:    0.7.0.1
 */