package com.tencent.mm.ui.widget.c;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.l;

final class a$2
  implements View.OnLongClickListener
{
  a$2(a parama, View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(112756);
    ak.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
    a.a(this.AIL).clear();
    a.a(this.AIL, paramView);
    this.AIK.onCreateContextMenu(a.a(this.AIL), paramView, null);
    if ((paramView.getTag(2131820681) instanceof int[]))
    {
      paramView = (int[])paramView.getTag(2131820681);
      if (paramView == null) {
        this.AIL.dq(0, 0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112756);
      return true;
      this.AIL.dq(paramView[0], paramView[1]);
      continue;
      this.AIL.dq(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c.a.2
 * JD-Core Version:    0.7.0.1
 */