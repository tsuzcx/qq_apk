package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.c;

final class MallProductSubmitUI$8
  implements AdapterView.OnItemClickListener
{
  MallProductSubmitUI$8(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mUW.dismissDialog(1);
    MallProductSubmitUI.b(this.mUW).vM(paramInt);
    MallProductSubmitUI.a(this.mUW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.8
 * JD-Core Version:    0.7.0.1
 */