package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.y;

final class ProductUI$7
  implements Runnable
{
  ProductUI$7(ProductUI paramProductUI, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if ((this.mNE.equals(ProductUI.a(this.nKF).field_thumburl)) && (ProductUI.q(this.nKF) != null)) {
      y.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + this.mNE);
    }
    try
    {
      ProductUI.q(this.nKF).setImageBitmap(this.ara);
      ProductUI.q(this.nKF).setBackgroundDrawable(null);
      ProductUI.q(this.nKF).setBackgroundColor(-1);
      ProductUI.r(this.nKF);
      ProductUI.s(this.nKF);
      if ((this.mNE.equals(ProductUI.a(this.nKF).field_headerbackgroundurl)) && (ProductUI.t(this.nKF) != null)) {
        ProductUI.t(this.nKF).setImageBitmap(this.ara);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[] { localException.getLocalizedMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.7
 * JD-Core Version:    0.7.0.1
 */