package com.tencent.mm.ui.base.sortview;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseSortView$1
  extends DataSetObserver
{
  BaseSortView$1(BaseSortView paramBaseSortView) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(107304);
    if (BaseSortView.a(this.zsH) != null) {
      BaseSortView.a(this.zsH).aS(BaseSortView.b(this.zsH).zsD);
    }
    AppMethodBeat.o(107304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView.1
 * JD-Core Version:    0.7.0.1
 */