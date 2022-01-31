package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Button;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;

final class ChatFooter$9
  implements View.OnKeyListener
{
  ChatFooter$9(ChatFooter paramChatFooter) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getAction())
    {
    }
    do
    {
      do
      {
        return false;
      } while (((paramInt != 23) && (paramInt != 66)) || (ChatFooter.v(this.sgd)) || (ChatFooter.u(this.sgd)));
      ChatFooter.d(this.sgd, true);
      ChatFooter.s(this.sgd).setBackgroundDrawable(a.g(this.sgd.getContext(), R.g.record_shape_press));
      ChatFooter.s(this.sgd).setText(R.l.chatfooter_releasetofinish);
      if (ChatFooter.j(this.sgd) != null) {
        ChatFooter.j(this.sgd).bhi();
      }
      ChatFooter.s(this.sgd).setContentDescription(this.sgd.getContext().getString(R.l.chat_footer_switch_press_btn));
      return false;
    } while ((paramInt != 23) && (paramInt != 66));
    ChatFooter.s(this.sgd).setBackgroundDrawable(a.g(this.sgd.getContext(), R.g.record_shape_normal));
    ChatFooter.s(this.sgd).setText(R.l.chatfooter_presstorcd);
    if (ChatFooter.j(this.sgd) != null) {
      ChatFooter.j(this.sgd).bhf();
    }
    ChatFooter.d(this.sgd, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.9
 * JD-Core Version:    0.7.0.1
 */