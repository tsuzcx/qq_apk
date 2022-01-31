package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class BaseConversationUI$3
  implements MessageQueue.IdleHandler
{
  BaseConversationUI$3(BaseConversationUI paramBaseConversationUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(34047);
    long l = System.currentTimeMillis();
    if (BaseConversationUI.access$200(this.AgT) == null) {
      if ((this.AgT.conversationFm == null) || (bo.isNullOrNil(this.AgT.conversationFm.getUserName()))) {
        break label127;
      }
    }
    label127:
    for (Object localObject = this.AgT.conversationFm.getUserName();; localObject = r.Zn())
    {
      localObject = new Intent().putExtra("Chat_User", (String)localObject);
      BaseConversationUI.access$300(this.AgT, (Intent)localObject, true);
      BaseConversationUI.access$200(this.AgT).setVisibility(8);
      this.AgT.resumeMainFragment();
      ab.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(34047);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI.3
 * JD-Core Version:    0.7.0.1
 */