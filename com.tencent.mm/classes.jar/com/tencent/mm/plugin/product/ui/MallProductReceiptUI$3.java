package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.product.b.d;
import java.util.List;

final class MallProductReceiptUI$3
  implements View.OnClickListener
{
  MallProductReceiptUI$3(MallProductReceiptUI paramMallProductReceiptUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = MallProductReceiptUI.c(this.mUe);
    paramView.mSh.clear();
    paramView.bsi();
    MallProductReceiptUI.d(this.mUe).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductReceiptUI.3
 * JD-Core Version:    0.7.0.1
 */