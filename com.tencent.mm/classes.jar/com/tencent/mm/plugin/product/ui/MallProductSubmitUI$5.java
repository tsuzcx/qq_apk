package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MallProductSubmitUI$5
  implements View.OnClickListener
{
  MallProductSubmitUI$5(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67050);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.BbZ.showDialog(1);
    a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.5
 * JD-Core Version:    0.7.0.1
 */