package com.tencent.mm.pluginsdk.ui.chat;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.R.g;

final class ChatFooter$26
  implements View.OnFocusChangeListener
{
  ChatFooter$26(ChatFooter paramChatFooter) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ChatFooter.c(this.sgd).setBackground(this.sgd.getResources().getDrawable(R.g.input_bar_bg_active));
      return;
    }
    ChatFooter.c(this.sgd).setBackground(this.sgd.getResources().getDrawable(R.g.input_bar_bg_normal));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.26
 * JD-Core Version:    0.7.0.1
 */