package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.d;
import java.util.List;

final class MallProductReceiptUI$3
  implements View.OnClickListener
{
  MallProductReceiptUI$3(MallProductReceiptUI paramMallProductReceiptUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44092);
    paramView = MallProductReceiptUI.c(this.pwk);
    paramView.puo.clear();
    paramView.cbo();
    MallProductReceiptUI.d(this.pwk).notifyDataSetChanged();
    AppMethodBeat.o(44092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI.3
 * JD-Core Version:    0.7.0.1
 */