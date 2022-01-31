package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.ah;

final class GridHeadersGridView$b
  implements Runnable
{
  GridHeadersGridView$b(GridHeadersGridView paramGridHeadersGridView) {}
  
  public final void run()
  {
    if (this.vWW.alA == 0)
    {
      this.vWW.alA = 1;
      View localView = this.vWW.HY(this.vWW.vWU);
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.vWW.uTo) {
          break label157;
        }
        localView.setPressed(true);
        this.vWW.setPressed(true);
        this.vWW.refreshDrawableState();
        int i = ViewConfiguration.getLongPressTimeout();
        if (!this.vWW.isLongClickable()) {
          break label148;
        }
        if (this.vWW.vWD == null) {
          this.vWW.vWD = new GridHeadersGridView.a(this.vWW, (byte)0);
        }
        this.vWW.vWD.cID();
        GridHeadersGridView.d(this.vWW).postDelayed(this.vWW.vWD, i);
      }
    }
    return;
    label148:
    this.vWW.alA = 2;
    return;
    label157:
    this.vWW.alA = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.b
 * JD-Core Version:    0.7.0.1
 */