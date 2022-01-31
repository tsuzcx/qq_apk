package com.tencent.mm.ui.chatting;

import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;

final class y$8
  implements Runnable
{
  y$8(y paramy) {}
  
  public final void run()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.vmb.isCurrentActivity) {
      y.f(this.vmb);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!(this.vmb.thisActivity() instanceof LauncherUI)) {
            break;
          }
          localObject = (LauncherUI)this.vmb.thisActivity();
        } while (localObject == null);
        if (!this.vmb.isSupportNavigationSwipeBack()) {}
        for (;;)
        {
          ((LauncherUI)localObject).closeChatting(bool1);
          return;
          bool1 = false;
        }
      } while (!(this.vmb.thisActivity() instanceof BaseConversationUI));
      localObject = (BaseConversationUI)this.vmb.thisActivity();
    } while (localObject == null);
    if (!this.vmb.isSupportNavigationSwipeBack()) {}
    for (bool1 = bool2;; bool1 = false)
    {
      ((BaseConversationUI)localObject).closeChatting(bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y.8
 * JD-Core Version:    0.7.0.1
 */