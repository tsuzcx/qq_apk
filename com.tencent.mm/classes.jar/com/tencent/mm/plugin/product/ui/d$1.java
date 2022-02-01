package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements AdapterView.OnItemClickListener
{
  d$1(AdapterView.OnItemClickListener paramOnItemClickListener, d.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(66956);
    if (this.vGj != null) {
      this.vGj.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    this.vGk.vGl = paramInt;
    this.vGk.notifyDataSetChanged();
    AppMethodBeat.o(66956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.d.1
 * JD-Core Version:    0.7.0.1
 */