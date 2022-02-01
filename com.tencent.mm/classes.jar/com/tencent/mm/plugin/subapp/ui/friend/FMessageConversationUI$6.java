package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;

final class FMessageConversationUI$6
  implements MenuItem.OnMenuItemClickListener
{
  FMessageConversationUI$6(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(29042);
    Object localObject = new Intent(this.SGh, AddMoreFriendsUI.class);
    ((Intent)localObject).putExtra("invite_friend_scene", 3);
    paramMenuItem = this.SGh;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$6", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/plugin/subapp/ui/friend/FMessageConversationUI$6", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(29042);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.6
 * JD-Core Version:    0.7.0.1
 */