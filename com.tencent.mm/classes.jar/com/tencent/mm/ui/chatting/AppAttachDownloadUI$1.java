package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;

final class AppAttachDownloadUI$1
  implements MenuItem.OnMenuItemClickListener
{
  AppAttachDownloadUI$1(AppAttachDownloadUI paramAppAttachDownloadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (AppAttachDownloadUI.a(this.vgK) != null) {
      au.Dk().c(AppAttachDownloadUI.a(this.vgK));
    }
    this.vgK.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */