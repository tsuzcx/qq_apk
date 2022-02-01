package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.util.q.a;
import com.tencent.mm.sdk.platformtools.Util;

final class ProductUI$14
  implements View.OnClickListener
{
  ProductUI$14(ProductUI paramProductUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51868);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/ui/ProductUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((ProductUI.a(this.OZW) != null) && (!Util.isNullOrNil(ProductUI.a(this.OZW).field_certificationurl)))
    {
      ProductUI.a(this.OZW, 10002, ProductUI.a(this.OZW).field_certificationurl);
      ProductUI.a(this.OZW, ProductUI.a(this.OZW).field_certificationurl);
    }
    a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.14
 * JD-Core Version:    0.7.0.1
 */