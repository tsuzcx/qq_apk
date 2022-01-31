package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class d$1
  implements AdapterView.OnItemClickListener
{
  d$1(AdapterView.OnItemClickListener paramOnItemClickListener, d.a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.mTA != null) {
      this.mTA.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    this.mTB.mTD = paramInt;
    this.mTB.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.d.1
 * JD-Core Version:    0.7.0.1
 */