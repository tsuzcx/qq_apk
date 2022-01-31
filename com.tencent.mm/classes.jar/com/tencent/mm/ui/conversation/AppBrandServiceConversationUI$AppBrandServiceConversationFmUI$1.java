package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.ServiceNotifySettingsUI;

final class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$1(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI paramAppBrandServiceConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent(this.vOR.getContext(), ServiceNotifySettingsUI.class);
    paramMenuItem.putExtra("mode", 1);
    paramMenuItem.putExtra("scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.access$000(this.vOR));
    this.vOR.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.1
 * JD-Core Version:    0.7.0.1
 */