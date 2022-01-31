package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ChatFooter$16
  implements n.a
{
  ChatFooter$16(ChatFooter paramChatFooter) {}
  
  public final void amd(String paramString)
  {
    AppMethodBeat.i(155426);
    if (ChatFooter.i(this.vXU) != null) {
      ChatFooter.i(this.vXU).SE(paramString);
    }
    for (;;)
    {
      ChatFooter.ai(this.vXU).reset();
      AppMethodBeat.o(155426);
      return;
      ab.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
    }
  }
  
  public final void dns()
  {
    AppMethodBeat.i(155425);
    ChatFooter.ah(this.vXU);
    AppMethodBeat.o(155425);
  }
  
  public final void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(155427);
    if (paramBoolean)
    {
      if (this.vXU.vWK != null)
      {
        ab.d("MicroMsg.ChatFooter", "onVoiceStart start");
        this.vXU.vWK.j(Boolean.TRUE);
        AppMethodBeat.o(155427);
      }
    }
    else if (this.vXU.vWK != null)
    {
      ab.d("MicroMsg.ChatFooter", "onVoiceStart end");
      this.vXU.vWK.j(Boolean.FALSE);
    }
    AppMethodBeat.o(155427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.16
 * JD-Core Version:    0.7.0.1
 */