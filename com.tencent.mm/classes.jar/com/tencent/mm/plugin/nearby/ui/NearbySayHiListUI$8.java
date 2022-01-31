package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class NearbySayHiListUI$8
  implements MMSlideDelView.g
{
  NearbySayHiListUI$8(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55502);
    NearbySayHiListUI.d(this.pdR).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(55502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.8
 * JD-Core Version:    0.7.0.1
 */