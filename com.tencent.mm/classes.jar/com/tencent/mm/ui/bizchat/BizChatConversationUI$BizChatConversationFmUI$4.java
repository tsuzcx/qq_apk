package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class BizChatConversationUI$BizChatConversationFmUI$4
  implements MenuItem.OnMenuItemClickListener
{
  BizChatConversationUI$BizChatConversationFmUI$4(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(33916);
    Log.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
    Object localObject = new Intent(this.PaS.getContext(), BizChatSearchUI.class);
    ((Intent)localObject).putExtra("enterprise_biz_name", BizChatConversationUI.BizChatConversationFmUI.a(this.PaS));
    ((Intent)localObject).putExtra("biz_chat_search_scene", 1);
    ((Intent)localObject).putExtra("biz_chat_search_text", "");
    ((Intent)localObject).addFlags(67108864);
    paramMenuItem = this.PaS;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33916);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.4
 * JD-Core Version:    0.7.0.1
 */