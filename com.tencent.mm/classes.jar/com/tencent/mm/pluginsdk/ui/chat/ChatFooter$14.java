package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;

final class ChatFooter$14
  implements ChatFooterPanel.a
{
  ChatFooter$14(ChatFooter paramChatFooter) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(155422);
    ChatFooter.ad(this.vXU);
    ChatFooter.ae(this.vXU).setVisibility(0);
    ChatFooter.u(this.vXU).setVisibility(8);
    ChatFooter.a(this.vXU, true);
    ChatFooter.af(this.vXU);
    InputConnection localInputConnection = ChatFooter.a(this.vXU).getInputConnection();
    if (localInputConnection != null)
    {
      localInputConnection.sendKeyEvent(new KeyEvent(0, 67));
      localInputConnection.sendKeyEvent(new KeyEvent(1, 67));
    }
    this.vXU.vWI.cOn -= 1L;
    AppMethodBeat.o(155422);
  }
  
  public final void append(String paramString)
  {
    AppMethodBeat.i(155423);
    ChatFooter.ad(this.vXU);
    ChatFooter.ae(this.vXU).setVisibility(0);
    ChatFooter.u(this.vXU).setVisibility(8);
    ChatFooter.a(this.vXU, true);
    ChatFooter.af(this.vXU);
    try
    {
      ChatFooter.a(this.vXU).avk(paramString);
      this.vXU.vWI.cOn += 1L;
      AppMethodBeat.o(155423);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ChatFooter", paramString, "", new Object[0]);
      }
    }
  }
  
  public final void bag()
  {
    AppMethodBeat.i(155420);
    ChatFooter.ad(this.vXU);
    ChatFooter.ae(this.vXU).setVisibility(0);
    ChatFooter.u(this.vXU).setVisibility(8);
    ChatFooter.a(this.vXU, true);
    ChatFooter.af(this.vXU);
    if (ChatFooter.h(this.vXU) != null) {
      ChatFooter.h(this.vXU).performClick();
    }
    AppMethodBeat.o(155420);
  }
  
  public final void fT(boolean paramBoolean)
  {
    AppMethodBeat.i(155421);
    ab.i("MicroMsg.ChatFooter", "onToSendTextEnable: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (ChatFooter.m(this.vXU) == 2)
    {
      ChatFooter.ad(this.vXU);
      ChatFooter.ae(this.vXU).setVisibility(0);
      ChatFooter.u(this.vXU).setVisibility(8);
      ChatFooter.af(this.vXU);
      if (ChatFooter.a(this.vXU) != null) {
        this.vXU.setToSendTextColor(paramBoolean);
      }
    }
    AppMethodBeat.o(155421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.14
 * JD-Core Version:    0.7.0.1
 */