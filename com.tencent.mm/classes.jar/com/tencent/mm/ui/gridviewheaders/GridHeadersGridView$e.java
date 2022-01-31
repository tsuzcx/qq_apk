package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GridHeadersGridView$e
  extends GridHeadersGridView.f
  implements Runnable
{
  int Aph;
  
  private GridHeadersGridView$e(GridHeadersGridView paramGridHeadersGridView)
  {
    super(paramGridHeadersGridView, (byte)0);
  }
  
  public final void run()
  {
    AppMethodBeat.i(107365);
    if (this.Ape.zhO)
    {
      AppMethodBeat.o(107365);
      return;
    }
    if ((this.Ape.Apb != null) && (this.Ape.Apb.getCount() > 0) && (this.Aph != -1) && (this.Aph < this.Ape.Apb.getCount()) && (dNo()))
    {
      View localView = this.Ape.QK(this.Aph);
      if (localView != null)
      {
        GridHeadersGridView localGridHeadersGridView = this.Ape;
        GridHeadersGridView.a(this.Ape, this.Aph);
        if (localGridHeadersGridView.AoX != null)
        {
          localGridHeadersGridView.playSoundEffect(0);
          if (localView != null) {
            localView.sendAccessibilityEvent(1);
          }
          localGridHeadersGridView.AoX.di(localView);
        }
      }
    }
    AppMethodBeat.o(107365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.e
 * JD-Core Version:    0.7.0.1
 */