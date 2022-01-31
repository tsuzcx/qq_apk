package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.scanner.util.q.a;

final class ProductUI$15
  implements View.OnClickListener
{
  ProductUI$15(ProductUI paramProductUI, q.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81098);
    ProductUI.a(this.qyh, 10003, this.qyj.field_introlink);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.qyj.field_introlink);
    paramView.putExtra("geta8key_scene", ProductUI.m(this.qyh));
    d.b(this.qyh.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(81098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.15
 * JD-Core Version:    0.7.0.1
 */