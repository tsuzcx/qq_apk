package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class BaseConversationUI$3
  implements MessageQueue.IdleHandler
{
  BaseConversationUI$3(BaseConversationUI paramBaseConversationUI) {}
  
  public final boolean queueIdle()
  {
    long l = System.currentTimeMillis();
    if (BaseConversationUI.access$200(this.vPi) == null) {
      if ((this.vPi.conversationFm == null) || (bk.bl(this.vPi.conversationFm.getUserName()))) {
        break label117;
      }
    }
    label117:
    for (Object localObject = this.vPi.conversationFm.getUserName();; localObject = q.Gj())
    {
      localObject = new Intent().putExtra("Chat_User", (String)localObject);
      BaseConversationUI.access$300(this.vPi, (Intent)localObject, true);
      BaseConversationUI.access$200(this.vPi).setVisibility(8);
      this.vPi.resumeMainFragment();
      y.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.3
 * JD-Core Version:    0.7.0.1
 */