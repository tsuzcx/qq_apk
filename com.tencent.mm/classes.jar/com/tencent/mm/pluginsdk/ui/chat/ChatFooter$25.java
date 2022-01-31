package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.sdk.platformtools.ak;

final class ChatFooter$25
  implements a.a
{
  ChatFooter$25(ChatFooter paramChatFooter, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(27816);
    Message localMessage = new Message();
    localMessage.what = 1002;
    localMessage.obj = Boolean.valueOf(this.iLL);
    ChatFooter.an(this.vXU).sendMessage(localMessage);
    AppMethodBeat.o(27816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.25
 * JD-Core Version:    0.7.0.1
 */