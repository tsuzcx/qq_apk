package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;

final class ChattingUIFragment$13
  implements Runnable
{
  ChattingUIFragment$13(ChattingUIFragment paramChattingUIFragment) {}
  
  public final void run()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(30843);
    ab.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", new Object[] { Boolean.valueOf(this.zBB.isCurrentActivity) });
    if (this.zBB.isCurrentActivity)
    {
      ChattingUIFragment.g(this.zBB);
      AppMethodBeat.o(30843);
      return;
    }
    Object localObject;
    if ((this.zBB.thisActivity() instanceof LauncherUI))
    {
      localObject = (LauncherUI)this.zBB.thisActivity();
      if (localObject != null)
      {
        if (!this.zBB.isSupportNavigationSwipeBack()) {}
        for (;;)
        {
          ((LauncherUI)localObject).closeChatting(bool1);
          AppMethodBeat.o(30843);
          return;
          bool1 = false;
        }
      }
      ab.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
      AppMethodBeat.o(30843);
      return;
    }
    if ((this.zBB.thisActivity() instanceof BaseConversationUI))
    {
      localObject = (BaseConversationUI)this.zBB.thisActivity();
      if (localObject != null) {
        if (this.zBB.isSupportNavigationSwipeBack()) {
          break label179;
        }
      }
    }
    label179:
    for (bool1 = bool2;; bool1 = false)
    {
      ((BaseConversationUI)localObject).closeChatting(bool1);
      AppMethodBeat.o(30843);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUIFragment.13
 * JD-Core Version:    0.7.0.1
 */