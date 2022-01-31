package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.ah;

final class ChatFooter$19
  implements a.a
{
  ChatFooter$19(ChatFooter paramChatFooter, boolean paramBoolean) {}
  
  public final void run()
  {
    Message localMessage = new Message();
    localMessage.what = 1002;
    localMessage.obj = Boolean.valueOf(this.gUe);
    ChatFooter.I(this.sgd).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.19
 * JD-Core Version:    0.7.0.1
 */