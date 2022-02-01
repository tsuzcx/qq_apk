package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.br.c;
import com.tencent.mm.ui.bizchat.BizChatSearchUI;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$11
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$11(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38561);
    ag.bah();
    Object localObject = f.MX(EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj));
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj));
      paramMenuItem.addFlags(67108864);
      c.b(this.Qfj.getContext(), "brandservice", ".ui.EnterpriseBizSearchUI", paramMenuItem);
    }
    for (;;)
    {
      AppMethodBeat.o(38561);
      return true;
      paramMenuItem = new Intent(this.Qfj.getContext(), BizChatSearchUI.class);
      paramMenuItem.putExtra("enterprise_biz_name", (String)localObject);
      paramMenuItem.putExtra("enterprise_biz_father_name", EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.Qfj));
      paramMenuItem.putExtra("biz_chat_search_scene", 1);
      paramMenuItem.putExtra("biz_chat_search_text", "");
      paramMenuItem.addFlags(67108864);
      localObject = this.Qfj;
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMenuItem.axQ(), "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((EnterpriseConversationUI.EnterpriseConversationFmUI)localObject).startActivity((Intent)paramMenuItem.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.11
 * JD-Core Version:    0.7.0.1
 */