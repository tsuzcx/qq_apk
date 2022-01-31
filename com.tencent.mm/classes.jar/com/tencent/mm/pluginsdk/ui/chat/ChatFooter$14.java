package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import android.widget.Button;
import com.tencent.mm.R.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.o;

final class ChatFooter$14
  extends ah
{
  ChatFooter$14(ChatFooter paramChatFooter) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (ChatFooter.E(this.sgd) != null)
    {
      ChatFooter.E(this.sgd).dismiss();
      ChatFooter.s(this.sgd).setBackgroundDrawable(a.g(this.sgd.getContext(), R.g.record_shape_normal));
      ChatFooter.s(this.sgd).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.14
 * JD-Core Version:    0.7.0.1
 */