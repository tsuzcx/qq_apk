package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class ChatFooter$45
  implements a
{
  ChatFooter$45(ChatFooter paramChatFooter) {}
  
  public final void amf(final String paramString)
  {
    AppMethodBeat.i(27820);
    ab.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramString });
    if ((bo.isNullOrNil(ChatFooter.c(this.vXU).getTalkerUserName())) || (bo.isNullOrNil(paramString)))
    {
      ab.e("MicroMsg.ChatFooter", "onImageReceived, error args");
      AppMethodBeat.o(27820);
      return;
    }
    h.a(this.vXU.getContext(), this.vXU.getContext().getString(2131299516), "", new DialogInterface.OnClickListener()new ChatFooter.45.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(27819);
        boolean bool = r.g(paramString, ChatFooter.c(ChatFooter.45.this.vXU).getTalkerUserName(), true);
        paramAnonymousDialogInterface = ChatFooter.45.this.vXU;
        if (bool) {}
        for (;;)
        {
          ChatFooter.a(paramAnonymousDialogInterface, paramAnonymousInt, paramString);
          AppMethodBeat.o(27819);
          return;
          paramAnonymousInt = 0;
        }
      }
    }, new ChatFooter.45.2(this));
    AppMethodBeat.o(27820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.45
 * JD-Core Version:    0.7.0.1
 */