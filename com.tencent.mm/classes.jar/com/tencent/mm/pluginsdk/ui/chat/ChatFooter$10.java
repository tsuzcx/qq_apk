package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import com.tencent.mm.R.g;
import com.tencent.mm.h.b.a.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;

final class ChatFooter$10
  implements ChatFooterPanel.a
{
  ChatFooter$10(ChatFooter paramChatFooter) {}
  
  public final void append(String paramString)
  {
    ChatFooter.A(this.sgd);
    ChatFooter.c(this.sgd).setVisibility(0);
    ChatFooter.s(this.sgd).setVisibility(8);
    ChatFooter.a(this.sgd, true);
    ChatFooter.c(this.sgd, R.g.chatting_setmode_voice_btn);
    try
    {
      ChatFooter.a(this.sgd).aex(paramString);
      this.sgd.sfp.cfG += 1L;
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ChatFooter", paramString, "", new Object[0]);
      }
    }
  }
  
  public final void asj()
  {
    ChatFooter.A(this.sgd);
    ChatFooter.c(this.sgd).setVisibility(0);
    ChatFooter.s(this.sgd).setVisibility(8);
    ChatFooter.a(this.sgd, true);
    ChatFooter.c(this.sgd, R.g.chatting_setmode_voice_btn);
    ChatFooter.a(this.sgd).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
    ChatFooter.a(this.sgd).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    this.sgd.sfp.cfG -= 1L;
  }
  
  public final void bgv()
  {
    ChatFooter.A(this.sgd);
    ChatFooter.c(this.sgd).setVisibility(0);
    ChatFooter.s(this.sgd).setVisibility(8);
    ChatFooter.a(this.sgd, true);
    ChatFooter.c(this.sgd, R.g.chatting_setmode_voice_btn);
    if (ChatFooter.i(this.sgd) != null) {
      ChatFooter.i(this.sgd).performClick();
    }
  }
  
  public final void hp(boolean paramBoolean)
  {
    ChatFooter.A(this.sgd);
    ChatFooter.c(this.sgd).setVisibility(0);
    ChatFooter.s(this.sgd).setVisibility(8);
    ChatFooter.c(this.sgd, R.g.chatting_setmode_voice_btn);
    if (ChatFooter.a(this.sgd) != null) {
      this.sgd.setToSendTextColor(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.10
 * JD-Core Version:    0.7.0.1
 */