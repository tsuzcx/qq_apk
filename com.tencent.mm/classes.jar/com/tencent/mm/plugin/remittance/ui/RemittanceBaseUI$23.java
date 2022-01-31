package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.ag.b;
import com.tencent.mm.plugin.wxpay.a.e;

final class RemittanceBaseUI$23
  implements Runnable
{
  RemittanceBaseUI$23(RemittanceBaseUI paramRemittanceBaseUI) {}
  
  public final void run()
  {
    Bitmap localBitmap = b.a(this.nAH.djD, false, -1);
    if (localBitmap == null)
    {
      this.nAH.nAa.setImageResource(a.e.default_avatar);
      return;
    }
    this.nAH.nAa.setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.23
 * JD-Core Version:    0.7.0.1
 */