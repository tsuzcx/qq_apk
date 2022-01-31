package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

final class ChattingUIFragment$6
  implements Runnable
{
  ChattingUIFragment$6(ChattingUIFragment paramChattingUIFragment, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(30836);
    if ((this.gpF) && (ChattingUIFragment.a(this.zBB).bim()))
    {
      ab.i("MicroMsg.ChattingUIFragment", "scrollToLastImpl: isAtBottom in post");
      AppMethodBeat.o(30836);
      return;
    }
    k.a(ChattingUIFragment.b(this.zBB), this.euv - 1, -this.fzv, true);
    AppMethodBeat.o(30836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.6
 * JD-Core Version:    0.7.0.1
 */