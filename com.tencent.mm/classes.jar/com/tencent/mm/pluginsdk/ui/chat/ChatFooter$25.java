package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class ChatFooter$25
  extends ah
{
  ChatFooter$25(ChatFooter paramChatFooter) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ChatFooter.f(this.sgd, true);
    paramMessage = ChatFooter.n(this.sgd).getLayoutParams();
    int i = ChatFooter.n(this.sgd).getBottom() - ChatFooter.n(this.sgd).getTop();
    if (this.sgd.cnD())
    {
      if (ChatFooter.o(this.sgd) != null) {
        ChatFooter.o(this.sgd).setVisibility(8);
      }
      this.sgd.setAppPanelVisible(8);
      ChatFooter.n(this.sgd).setVisibility(4);
    }
    if (i <= 3)
    {
      ChatFooter.f(this.sgd, false);
      ChatFooter.n(this.sgd).setVisibility(8);
      ChatFooter.d(this.sgd, this.sgd.getKeyBordHeightPX());
      return;
    }
    paramMessage.height = Math.max(i - 60, 1);
    y.e("MicroMsg.ChatFooter", "mBottomPanelAnim:bottomPanel height:" + paramMessage.height);
    ChatFooter.n(this.sgd).setLayoutParams(paramMessage);
    ChatFooter.K(this.sgd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.25
 * JD-Core Version:    0.7.0.1
 */