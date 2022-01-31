package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.c;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.g;

final class BizChatConversationUI$a$5$2
  implements n.d
{
  BizChatConversationUI$a$5$2(BizChatConversationUI.a.5 param5) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      BizChatConversationUI.a.m(this.veX.veW);
      return;
    case 2: 
      g.n(this.veX.veW.getContext(), BizChatConversationUI.a.a(this.veX.veW), 6);
      return;
    case 3: 
      if (bk.bl(BizChatConversationUI.a.c(this.veX.veW)))
      {
        paramMenuItem = z.My().kQ(BizChatConversationUI.a.a(this.veX.veW));
        BizChatConversationUI.a.a(this.veX.veW, paramMenuItem.LG());
      }
      if ((!bk.bl(BizChatConversationUI.a.c(this.veX.veW))) && (z.MK().kC(BizChatConversationUI.a.c(this.veX.veW))))
      {
        z.MH();
        c.a(BizChatConversationUI.a.c(this.veX.veW), null);
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", BizChatConversationUI.a.a(this.veX.veW));
      com.tencent.mm.br.d.b(this.veX.veW.thisActivity(), "profile", ".ui.ContactInfoUI", paramMenuItem);
      return;
    }
    if (!bk.bl(BizChatConversationUI.a.a(this.veX.veW)))
    {
      paramMenuItem = new Intent(this.veX.veW.getContext(), BizChatFavUI.class);
      paramMenuItem.putExtra("Contact_User", BizChatConversationUI.a.a(this.veX.veW));
      paramMenuItem.addFlags(67108864);
      this.veX.veW.startActivity(paramMenuItem);
      return;
    }
    y.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.5.2
 * JD-Core Version:    0.7.0.1
 */