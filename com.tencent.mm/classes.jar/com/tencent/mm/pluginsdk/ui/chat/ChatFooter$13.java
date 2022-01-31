package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.y;

final class ChatFooter$13
  implements n.a
{
  ChatFooter$13(ChatFooter paramChatFooter) {}
  
  public final void TG(String paramString)
  {
    if (ChatFooter.j(this.sgd) != null) {
      ChatFooter.j(this.sgd).GU(paramString);
    }
    for (;;)
    {
      ChatFooter.D(this.sgd).reset();
      return;
      y.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
    }
  }
  
  public final void cfM()
  {
    ChatFooter.C(this.sgd);
  }
  
  public final void lr(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.sgd.sfr != null)
      {
        y.d("MicroMsg.ChatFooter", "onVoiceStart start");
        this.sgd.sfr.h(Boolean.valueOf(true));
      }
    }
    while (this.sgd.sfr == null) {
      return;
    }
    y.d("MicroMsg.ChatFooter", "onVoiceStart end");
    this.sgd.sfr.h(Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.13
 * JD-Core Version:    0.7.0.1
 */