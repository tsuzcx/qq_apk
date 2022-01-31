package com.tencent.mm.ui.conversation;

import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.g;

final class EnterpriseConversationUI$a$15$1
  implements n.c
{
  EnterpriseConversationUI$a$15$1(EnterpriseConversationUI.a.15 param15) {}
  
  public final void a(l paraml)
  {
    if (EnterpriseConversationUI.a.e(this.vSY.vSW) == 1)
    {
      paraml.ak(2, R.l.enterprise_wework_open_menu, R.k.actionbar_goto_wework_icon);
      g.m(this.vSY.vSW.getContext(), EnterpriseConversationUI.a.c(this.vSY.vSW), 5);
    }
    paraml.ak(3, R.l.contact_info_send_card_biz, R.k.ofm_send_icon);
    paraml.ak(4, R.l.enterprise_disable, R.k.actionbar_goto_disabled_biz_icon);
    paraml.ak(5, R.l.actionbar_title_setting, R.k.actionbar_setting_icon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.15.1
 * JD-Core Version:    0.7.0.1
 */