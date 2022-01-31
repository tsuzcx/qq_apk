package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;

final class FMessageConversationUI$7
  implements MenuItem.OnMenuItemClickListener
{
  FMessageConversationUI$7(FMessageConversationUI paramFMessageConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent(this.pwx, AddMoreFriendsUI.class);
    paramMenuItem.putExtra("invite_friend_scene", 3);
    this.pwx.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.7
 * JD-Core Version:    0.7.0.1
 */