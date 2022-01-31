package com.tencent.mm.ui.bizchat;

import android.content.res.Resources;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.g;

final class BizChatConversationUI$a$5$1
  implements n.c
{
  BizChatConversationUI$a$5$1(BizChatConversationUI.a.5 param5) {}
  
  public final void a(l paraml)
  {
    if (BizChatConversationUI.a.l(this.veX.veW) == 1)
    {
      paraml.ak(2, R.l.enterprise_wework_open_menu, R.k.actionbar_goto_wework_icon);
      g.m(this.veX.veW.getContext(), BizChatConversationUI.a.a(this.veX.veW), 6);
    }
    paraml.ak(1, R.l.bizchat_new_chat, R.k.actionbar_create_biz_chat_icon);
    paraml.a(4, this.veX.veW.getResources().getString(R.l.bizchat_fav), an.an(this.veX.veW.getContext(), R.k.actionbar_facefriend_icon));
    paraml.a(3, this.veX.veW.getResources().getString(R.l.actionbar_title_setting), an.an(this.veX.veW.getContext(), R.k.actionbar_setting_icon));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.5.1
 * JD-Core Version:    0.7.0.1
 */