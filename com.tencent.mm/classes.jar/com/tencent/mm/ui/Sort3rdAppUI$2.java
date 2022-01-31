package com.tencent.mm.ui;

import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

final class Sort3rdAppUI$2
  implements DragSortListView.h
{
  Sort3rdAppUI$2(Sort3rdAppUI paramSort3rdAppUI) {}
  
  public final void cg(int paramInt1, int paramInt2)
  {
    f localf = (f)Sort3rdAppUI.a(this.uQV).getItem(paramInt1);
    Sort3rdAppUI.a(this.uQV).remove(localf);
    Sort3rdAppUI.a(this.uQV).insert(localf, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.2
 * JD-Core Version:    0.7.0.1
 */