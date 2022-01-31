package com.tencent.mm.ui.gridviewheaders;

import android.view.View;

final class GridHeadersGridView$e
  extends GridHeadersGridView.f
  implements Runnable
{
  int vWZ;
  
  private GridHeadersGridView$e(GridHeadersGridView paramGridHeadersGridView)
  {
    super(paramGridHeadersGridView, (byte)0);
  }
  
  public final void run()
  {
    if (this.vWW.uTo) {}
    View localView;
    GridHeadersGridView localGridHeadersGridView;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.vWW.vWT == null) || (this.vWW.vWT.getCount() <= 0) || (this.vWZ == -1) || (this.vWZ >= this.vWW.vWT.getCount()) || (!cIE()));
        localView = this.vWW.HY(this.vWZ);
      } while (localView == null);
      localGridHeadersGridView = this.vWW;
      GridHeadersGridView.a(this.vWW, this.vWZ);
    } while (localGridHeadersGridView.vWP == null);
    localGridHeadersGridView.playSoundEffect(0);
    if (localView != null) {
      localView.sendAccessibilityEvent(1);
    }
    localGridHeadersGridView.vWP.cE(localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.e
 * JD-Core Version:    0.7.0.1
 */