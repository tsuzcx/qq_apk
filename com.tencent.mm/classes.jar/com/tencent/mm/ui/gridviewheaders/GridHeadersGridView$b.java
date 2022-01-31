package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class GridHeadersGridView$b
  implements Runnable
{
  GridHeadersGridView$b(GridHeadersGridView paramGridHeadersGridView) {}
  
  public final void run()
  {
    AppMethodBeat.i(107364);
    if (this.Ape.anS == 0)
    {
      this.Ape.anS = 1;
      View localView = this.Ape.QK(this.Ape.Apc);
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (!this.Ape.zhO)
        {
          localView.setPressed(true);
          this.Ape.setPressed(true);
          this.Ape.refreshDrawableState();
          int i = ViewConfiguration.getLongPressTimeout();
          if (this.Ape.isLongClickable())
          {
            if (this.Ape.AoL == null) {
              this.Ape.AoL = new GridHeadersGridView.a(this.Ape, (byte)0);
            }
            this.Ape.AoL.dNn();
            GridHeadersGridView.d(this.Ape).postDelayed(this.Ape.AoL, i);
            AppMethodBeat.o(107364);
            return;
          }
          this.Ape.anS = 2;
          AppMethodBeat.o(107364);
          return;
        }
        this.Ape.anS = 2;
      }
    }
    AppMethodBeat.o(107364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.b
 * JD-Core Version:    0.7.0.1
 */