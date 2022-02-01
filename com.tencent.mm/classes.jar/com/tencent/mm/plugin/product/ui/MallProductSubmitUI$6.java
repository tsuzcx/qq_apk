package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MallProductSubmitUI$6
  implements View.OnClickListener
{
  MallProductSubmitUI$6(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67051);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = MallProductSubmitUI.d(this.wOJ);
    localObject = new Intent(paramView.kbt, MallProductReceiptUI.class);
    paramView.kbt.startActivityForResult((Intent)localObject, 4);
    a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.6
 * JD-Core Version:    0.7.0.1
 */