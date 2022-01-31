package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$1
  implements AdapterView.OnItemClickListener
{
  DynamicGridView$1(DynamicGridView paramDynamicGridView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(40343);
    if ((!this.slD.lNb) && (this.slD.isEnabled()) && (DynamicGridView.a(this.slD) != null)) {
      DynamicGridView.a(this.slD).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(40343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.1
 * JD-Core Version:    0.7.0.1
 */