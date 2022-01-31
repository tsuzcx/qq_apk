package com.tencent.mm.ui.conversation;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d;

final class k$1
  implements AbsListView.OnScrollListener
{
  k$1(k paramk) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(34573);
    if (paramInt == 2) {
      d.dAt().eJ(MainUI.class.getName() + ".Listview", 4);
    }
    if (paramInt == 0)
    {
      if (this.AlJ.AgN == null)
      {
        AppMethodBeat.o(34573);
        return;
      }
      k.a(this.AlJ, -1);
      AppMethodBeat.o(34573);
      return;
    }
    this.AlJ.dMY();
    AppMethodBeat.o(34573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.k.1
 * JD-Core Version:    0.7.0.1
 */