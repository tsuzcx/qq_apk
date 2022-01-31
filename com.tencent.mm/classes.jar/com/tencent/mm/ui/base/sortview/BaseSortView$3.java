package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseSortView$3
  implements AdapterView.OnItemLongClickListener
{
  BaseSortView$3(BaseSortView paramBaseSortView) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107306);
    if (BaseSortView.d(this.zsH) != null)
    {
      boolean bool = BaseSortView.d(this.zsH).onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
      AppMethodBeat.o(107306);
      return bool;
    }
    AppMethodBeat.o(107306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView.3
 * JD-Core Version:    0.7.0.1
 */