package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ProductUI$15
  implements View.OnClickListener
{
  ProductUI$15(ProductUI paramProductUI, o.a parama) {}
  
  public final void onClick(View paramView)
  {
    ProductUI.a(this.nKF, 10003, this.nKG.field_introlink);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.nKG.field_introlink);
    paramView.putExtra("geta8key_scene", ProductUI.k(this.nKF));
    d.b(this.nKF.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ProductUI.15
 * JD-Core Version:    0.7.0.1
 */