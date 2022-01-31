package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MainTabUI;

final class m$10
  implements Runnable
{
  m$10(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(34607);
    Object localObject = this.AlR;
    LauncherUI localLauncherUI = (LauncherUI)((m)localObject).cup;
    if ((localLauncherUI == null) || (localLauncherUI.yYT.getMainTabUI().Sl == 0))
    {
      localObject = ((m)localObject).All;
      if (((ConversationListView)localObject).getFirstVisiblePosition() > ((ConversationListView)localObject).getFirstHeaderVisible() + 16) {
        ((ConversationListView)localObject).setSelection(((ConversationListView)localObject).getFirstHeaderVisible() + 16);
      }
      ((ConversationListView)localObject).post(new ConversationListView.2((ConversationListView)localObject));
    }
    AppMethodBeat.o(34607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.10
 * JD-Core Version:    0.7.0.1
 */