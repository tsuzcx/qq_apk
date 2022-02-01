package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$1
  implements AdapterView.OnItemClickListener
{
  d$1(AdapterView.OnItemClickListener paramOnItemClickListener, d.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(66956);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/plugin/product/ui/MallListDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    if (this.xdd != null) {
      this.xdd.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    this.xde.xdf = paramInt;
    this.xde.notifyDataSetChanged();
    a.a(this, "com/tencent/mm/plugin/product/ui/MallListDialog$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(66956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.d.1
 * JD-Core Version:    0.7.0.1
 */