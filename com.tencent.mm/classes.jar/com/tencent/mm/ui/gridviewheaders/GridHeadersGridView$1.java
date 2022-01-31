package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GridHeadersGridView$1
  extends DataSetObserver
{
  GridHeadersGridView$1(GridHeadersGridView paramGridHeadersGridView) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(107360);
    GridHeadersGridView.a(this.Ape);
    AppMethodBeat.o(107360);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(107361);
    GridHeadersGridView.a(this.Ape);
    AppMethodBeat.o(107361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.1
 * JD-Core Version:    0.7.0.1
 */