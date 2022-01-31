package com.tencent.mm.ui.base;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HorizontalListView$1
  extends DataSetObserver
{
  HorizontalListView$1(HorizontalListView paramHorizontalListView) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(106309);
    synchronized (this.zhR)
    {
      HorizontalListView.a(this.zhR);
      this.zhR.invalidate();
      this.zhR.requestLayout();
      AppMethodBeat.o(106309);
      return;
    }
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(106310);
    HorizontalListView.b(this.zhR);
    this.zhR.invalidate();
    this.zhR.requestLayout();
    AppMethodBeat.o(106310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView.1
 * JD-Core Version:    0.7.0.1
 */