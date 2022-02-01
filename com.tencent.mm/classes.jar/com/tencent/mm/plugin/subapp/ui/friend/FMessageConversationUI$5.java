package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;

final class FMessageConversationUI$5
  implements MenuItem.OnMenuItemClickListener
{
  FMessageConversationUI$5(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(29041);
    Object localObject = new Intent(this.BiI, AddMoreFriendsUI.class);
    ((Intent)localObject).putExtra("invite_friend_scene", 3);
    paramMenuItem = this.BiI;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$5", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(29041);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.5
 * JD-Core Version:    0.7.0.1
 */