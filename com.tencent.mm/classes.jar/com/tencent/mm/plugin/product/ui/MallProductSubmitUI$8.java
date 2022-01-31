package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.c;

final class MallProductSubmitUI$8
  implements AdapterView.OnItemClickListener
{
  MallProductSubmitUI$8(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44146);
    this.pxb.dismissDialog(1);
    MallProductSubmitUI.b(this.pxb).Bm(paramInt);
    MallProductSubmitUI.a(this.pxb);
    AppMethodBeat.o(44146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.8
 * JD-Core Version:    0.7.0.1
 */