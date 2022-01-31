package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

final class Sort3rdAppUI$2
  implements DragSortListView.h
{
  Sort3rdAppUI$2(Sort3rdAppUI paramSort3rdAppUI) {}
  
  public final void dp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29898);
    f localf = (f)Sort3rdAppUI.a(this.zfh).getItem(paramInt1);
    Sort3rdAppUI.a(this.zfh).remove(localf);
    Sort3rdAppUI.a(this.zfh).insert(localf, paramInt2);
    AppMethodBeat.o(29898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.2
 * JD-Core Version:    0.7.0.1
 */