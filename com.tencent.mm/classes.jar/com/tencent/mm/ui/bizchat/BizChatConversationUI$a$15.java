package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.z;
import com.tencent.mm.ui.base.n.d;

final class BizChatConversationUI$a$15
  implements n.d
{
  BizChatConversationUI$a$15(BizChatConversationUI.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      BizChatConversationUI.a.a(this.veW, BizChatConversationUI.a.e(this.veW));
      return;
    case 1: 
      paramMenuItem = z.MB().bK(BizChatConversationUI.a.e(this.veW));
      paramMenuItem.field_unReadCount = 1;
      paramMenuItem.field_atCount = 0;
      z.MB().b(paramMenuItem);
      com.tencent.mm.modelstat.b.eBD.N(paramMenuItem.field_brandUserName, true);
      return;
    case 2: 
      z.MB().bM(BizChatConversationUI.a.e(this.veW));
      paramMenuItem = z.MB().bK(BizChatConversationUI.a.e(this.veW));
      com.tencent.mm.modelstat.b.eBD.N(paramMenuItem.field_brandUserName, false);
      return;
    }
    paramMenuItem = z.MB().bK(BizChatConversationUI.a.e(this.veW));
    if (z.MB().bN(BizChatConversationUI.a.e(this.veW)))
    {
      z.MB().bP(BizChatConversationUI.a.e(this.veW));
      com.tencent.mm.modelstat.b.eBD.c(true, paramMenuItem.field_brandUserName, false);
      return;
    }
    z.MB().bO(BizChatConversationUI.a.e(this.veW));
    com.tencent.mm.modelstat.b.eBD.c(true, paramMenuItem.field_brandUserName, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.15
 * JD-Core Version:    0.7.0.1
 */