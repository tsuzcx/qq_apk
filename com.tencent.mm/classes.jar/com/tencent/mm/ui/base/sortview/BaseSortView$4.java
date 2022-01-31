package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseSortView$4
  implements AdapterView.OnItemSelectedListener
{
  BaseSortView$4(BaseSortView paramBaseSortView) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107307);
    if (BaseSortView.e(this.zsH) != null) {
      BaseSortView.e(this.zsH).onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(107307);
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(107308);
    if (BaseSortView.e(this.zsH) != null) {
      BaseSortView.e(this.zsH).onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(107308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView.4
 * JD-Core Version:    0.7.0.1
 */