package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class DynamicGridView$1
  implements AdapterView.OnItemClickListener
{
  DynamicGridView$1(DynamicGridView paramDynamicGridView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.pqL.jDC) && (this.pqL.isEnabled()) && (DynamicGridView.a(this.pqL) != null)) {
      DynamicGridView.a(this.pqL).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.1
 * JD-Core Version:    0.7.0.1
 */