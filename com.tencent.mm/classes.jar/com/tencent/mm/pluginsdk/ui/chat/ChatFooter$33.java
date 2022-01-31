package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class ChatFooter$33
  extends ak
{
  ChatFooter$33(ChatFooter paramChatFooter) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(156069);
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(156069);
      return;
      ChatFooter.f(this.vXU, true);
      paramMessage = ChatFooter.at(this.vXU).getLayoutParams();
      int i = ChatFooter.at(this.vXU).getBottom() - ChatFooter.at(this.vXU).getTop();
      if (this.vXU.doB())
      {
        if (ChatFooter.q(this.vXU) != null) {
          ChatFooter.q(this.vXU).setVisibility(8);
        }
        this.vXU.setAppPanelVisible(8);
        ChatFooter.at(this.vXU).setVisibility(4);
      }
      if (i <= 3)
      {
        ChatFooter.f(this.vXU, false);
        ChatFooter.at(this.vXU).setVisibility(4);
        ChatFooter.b(this.vXU, this.vXU.getKeyBordHeightPX());
        AppMethodBeat.o(156069);
        return;
      }
      paramMessage.height = Math.max(i - 60, 1);
      ab.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramMessage.height);
      ChatFooter.at(this.vXU).setLayoutParams(paramMessage);
      ChatFooter.au(this.vXU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.33
 * JD-Core Version:    0.7.0.1
 */