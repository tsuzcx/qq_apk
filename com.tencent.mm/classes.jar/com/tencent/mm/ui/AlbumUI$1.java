package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;

final class AlbumUI$1
  implements DoubleTabView.a
{
  AlbumUI$1(AlbumUI paramAlbumUI) {}
  
  public final void onTabClick(int paramInt)
  {
    AppMethodBeat.i(29105);
    AlbumUI.a(this.yTx).setCurrentItem(paramInt, true);
    AppMethodBeat.o(29105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI.1
 * JD-Core Version:    0.7.0.1
 */