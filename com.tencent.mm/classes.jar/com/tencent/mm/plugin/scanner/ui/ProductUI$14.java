package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.bo;

final class ProductUI$14
  implements View.OnClickListener
{
  ProductUI$14(ProductUI paramProductUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81097);
    if ((ProductUI.a(this.qyh) != null) && (!bo.isNullOrNil(ProductUI.a(this.qyh).field_certificationurl)))
    {
      ProductUI.a(this.qyh, 10002, ProductUI.a(this.qyh).field_certificationurl);
      ProductUI.a(this.qyh, ProductUI.a(this.qyh).field_certificationurl);
    }
    AppMethodBeat.o(81097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.14
 * JD-Core Version:    0.7.0.1
 */