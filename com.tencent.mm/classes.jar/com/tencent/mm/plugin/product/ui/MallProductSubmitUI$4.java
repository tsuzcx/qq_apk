package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MallProductSubmitUI$4
  implements View.OnClickListener
{
  MallProductSubmitUI$4(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67049);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = MallProductSubmitUI.d(this.wOJ);
    localObject = new Intent();
    ((Intent)localObject).putExtra("launch_from_webview", true);
    d.a(paramView.kbt, "address", ".ui.WalletSelectAddrUI", (Intent)localObject, 1, false);
    a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.4
 * JD-Core Version:    0.7.0.1
 */