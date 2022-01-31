package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.transvoice.ui.b.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.o;

final class ChatFooter$9
  implements b.d
{
  ChatFooter$9(ChatFooter paramChatFooter) {}
  
  public final boolean a(String paramString, Long paramLong)
  {
    AppMethodBeat.i(155415);
    ab.i("MicroMsg.ChatFooter", "onVoiceMsgSend, fileName: %s.", new Object[] { paramString });
    if (paramLong != null) {}
    for (int i = paramLong.intValue();; i = 0)
    {
      if (ChatFooter.i(this.vXU) != null)
      {
        boolean bool = ChatFooter.i(this.vXU).cA(paramString, i);
        AppMethodBeat.o(155415);
        return bool;
      }
      AppMethodBeat.o(155415);
      return false;
    }
  }
  
  public final void aey(final String paramString)
  {
    AppMethodBeat.i(155414);
    this.vXU.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(155412);
        ab.i("MicroMsg.ChatFooter", "onTxtMsgSend, msg is null or nil? %s.", new Object[] { Boolean.valueOf(bo.isNullOrNil(paramString)) });
        if ((ChatFooter.i(ChatFooter.9.this.vXU) != null) && (!bo.isNullOrNil(paramString))) {
          ChatFooter.i(ChatFooter.9.this.vXU).SE(paramString);
        }
        AppMethodBeat.o(155412);
      }
    }, 200L);
    AppMethodBeat.o(155414);
  }
  
  public final void aez(String paramString)
  {
    AppMethodBeat.i(155416);
    if (ChatFooter.i(this.vXU) != null) {
      ChatFooter.i(this.vXU).SF(paramString);
    }
    AppMethodBeat.o(155416);
  }
  
  public final void cLc()
  {
    AppMethodBeat.i(155413);
    if (ChatFooter.s(this.vXU).isShowing()) {
      ChatFooter.s(this.vXU).dismiss();
    }
    ChatFooter.t(this.vXU);
    AppMethodBeat.o(155413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.9
 * JD-Core Version:    0.7.0.1
 */