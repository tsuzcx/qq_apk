package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class BizChatConversationUI$a$4
  implements MenuItem.OnMenuItemClickListener
{
  BizChatConversationUI$a$4(BizChatConversationUI.a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
    paramMenuItem = new Intent(this.veW.getContext(), BizChatSearchUI.class);
    paramMenuItem.putExtra("enterprise_biz_name", BizChatConversationUI.a.a(this.veW));
    paramMenuItem.putExtra("biz_chat_search_scene", 1);
    paramMenuItem.putExtra("biz_chat_search_text", "");
    paramMenuItem.addFlags(67108864);
    this.veW.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.a.4
 * JD-Core Version:    0.7.0.1
 */