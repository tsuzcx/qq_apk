package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class ChatFooter$27
  implements a
{
  ChatFooter$27(ChatFooter paramChatFooter) {}
  
  public final void Wz(String paramString)
  {
    y.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", new Object[] { paramString });
    if ((bk.bl(ChatFooter.d(this.sgd).getTalkerUserName())) || (bk.bl(paramString)))
    {
      y.e("MicroMsg.ChatFooter", "onImageReceived, error args");
      return;
    }
    h.a(this.sgd.getContext(), this.sgd.getContext().getString(R.l.ext_accessories_send_spen_image), "", new ChatFooter.27.1(this, paramString), new ChatFooter.27.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.27
 * JD-Core Version:    0.7.0.1
 */