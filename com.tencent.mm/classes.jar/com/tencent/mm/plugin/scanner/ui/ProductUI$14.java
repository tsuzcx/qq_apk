package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.platformtools.bk;

final class ProductUI$14
  implements View.OnClickListener
{
  ProductUI$14(ProductUI paramProductUI) {}
  
  public final void onClick(View paramView)
  {
    if ((ProductUI.a(this.nKF) != null) && (!bk.bl(ProductUI.a(this.nKF).field_certificationurl)))
    {
      ProductUI.a(this.nKF, 10002, ProductUI.a(this.nKF).field_certificationurl);
      ProductUI.a(this.nKF, ProductUI.a(this.nKF).field_certificationurl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.14
 * JD-Core Version:    0.7.0.1
 */