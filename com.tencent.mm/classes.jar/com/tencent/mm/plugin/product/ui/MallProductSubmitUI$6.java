package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;

final class MallProductSubmitUI$6
  implements View.OnClickListener
{
  MallProductSubmitUI$6(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(67051);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = MallProductSubmitUI.d(this.MTz);
    localObject = new Intent(paramView.mContext, MallProductReceiptUI.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramView.mContext, c.a(4, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/product/ui/MallProductHelper", "goEditInvoice", "()V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductSubmitUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(67051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.6
 * JD-Core Version:    0.7.0.1
 */