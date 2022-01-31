package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

final class ChatFooter$6
  implements View.OnClickListener
{
  ChatFooter$6(ChatFooter paramChatFooter) {}
  
  public final void onClick(View paramView)
  {
    if (ChatFooter.j(this.sgd) != null) {
      ChatFooter.j(this.sgd).bhj();
    }
    if ((!ChatFooter.n(this.sgd).cbz) && (ChatFooter.o(this.sgd) != null) && (ChatFooter.o(this.sgd).getVisibility() == 0))
    {
      this.sgd.showVKB();
      return;
    }
    if (ChatFooter.p(this.sgd)) {
      this.sgd.sk();
    }
    this.sgd.cng();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.6
 * JD-Core Version:    0.7.0.1
 */