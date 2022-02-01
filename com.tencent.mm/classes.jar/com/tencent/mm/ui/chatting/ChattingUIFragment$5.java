package com.tencent.mm.ui.chatting;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e;
import com.tencent.mm.plugin.i.a.aj;

final class ChattingUIFragment$5
  implements e
{
  ChattingUIFragment$5(ChattingUIFragment paramChattingUIFragment)
  {
    AppMethodBeat.i(34707);
    AppMethodBeat.o(34707);
  }
  
  public final void b(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232892);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(232892);
      return;
    }
    if ((paramInt1 < 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(232892);
      return;
    }
    paramAbsListView = this.Pjy.Pjp;
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(232892);
      return;
    }
    ((aj)g.ah(aj.class)).report21053(ChattingUIFragment.b(this.Pjy), paramAbsListView, c.e.sFn.state, paramInt1, paramInt2, 2L, "temp_6", 1, false);
    AppMethodBeat.o(232892);
  }
  
  public final void c(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232893);
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(232893);
      return;
    }
    paramAbsListView = this.Pjy.Pjp;
    if (paramAbsListView == null)
    {
      AppMethodBeat.o(232893);
      return;
    }
    ((aj)g.ah(aj.class)).report21053(ChattingUIFragment.b(this.Pjy), paramAbsListView, c.e.sFn.state, paramInt1, paramInt2, 2L, "temp_6", 1, false);
    AppMethodBeat.o(232893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.5
 * JD-Core Version:    0.7.0.1
 */