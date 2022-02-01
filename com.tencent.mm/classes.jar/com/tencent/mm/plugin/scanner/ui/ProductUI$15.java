package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.util.q.a;

final class ProductUI$15
  implements View.OnClickListener
{
  ProductUI$15(ProductUI paramProductUI, q.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51869);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    ProductUI.a(this.OZW, 10003, this.OZY.field_introlink);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.OZY.field_introlink);
    paramView.putExtra("geta8key_scene", ProductUI.m(this.OZW));
    c.b(this.OZW.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.15
 * JD-Core Version:    0.7.0.1
 */