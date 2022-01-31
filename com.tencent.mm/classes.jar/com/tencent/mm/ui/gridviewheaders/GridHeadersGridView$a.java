package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GridHeadersGridView$a
  extends GridHeadersGridView.f
  implements Runnable
{
  private GridHeadersGridView$a(GridHeadersGridView paramGridHeadersGridView)
  {
    super(paramGridHeadersGridView, (byte)0);
  }
  
  public final void run()
  {
    AppMethodBeat.i(107363);
    View localView = this.Ape.QK(this.Ape.Apc);
    boolean bool1;
    if (localView != null)
    {
      GridHeadersGridView.a(this.Ape, this.Ape.Apc);
      if ((!dNo()) || (this.Ape.zhO)) {
        break label156;
      }
      GridHeadersGridView localGridHeadersGridView = this.Ape;
      if (localGridHeadersGridView.AoY == null) {
        break label151;
      }
      bool1 = localGridHeadersGridView.AoY.dNm();
      bool2 = bool1;
      if (bool1)
      {
        if (localView != null) {
          localView.sendAccessibilityEvent(2);
        }
        localGridHeadersGridView.performHapticFeedback(0);
      }
    }
    label151:
    label156:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (bool2)
      {
        this.Ape.anS = -2;
        this.Ape.setPressed(false);
        localView.setPressed(false);
        AppMethodBeat.o(107363);
        return;
      }
      this.Ape.anS = 2;
      AppMethodBeat.o(107363);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.a
 * JD-Core Version:    0.7.0.1
 */