package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class NearbySayHiListUI$7
  implements MMSlideDelView.c
{
  NearbySayHiListUI$7(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(55501);
    int i = NearbySayHiListUI.d(this.pdR).getPositionForView(paramView);
    AppMethodBeat.o(55501);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.7
 * JD-Core Version:    0.7.0.1
 */