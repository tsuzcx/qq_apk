package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.ui.base.h;

final class AttachDownloadPage$2
  implements MenuItem.OnMenuItemClickListener
{
  AttachDownloadPage$2(AttachDownloadPage paramAttachDownloadPage) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.nfL;
    String str = this.nfL.getString(b.j.plugin_favorite_opt);
    AttachDownloadPage.2.1 local1 = new AttachDownloadPage.2.1(this);
    h.a(paramMenuItem, "", new String[] { str }, "", false, local1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.AttachDownloadPage.2
 * JD-Core Version:    0.7.0.1
 */