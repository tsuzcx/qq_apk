package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

final class SnsUploadBrowseUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SnsUploadBrowseUI$3(SnsUploadBrowseUI paramSnsUploadBrowseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.piJ, i.j.sns_gallery_del, i.j.app_tip, new SnsUploadBrowseUI.3.1(this), new SnsUploadBrowseUI.3.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadBrowseUI.3
 * JD-Core Version:    0.7.0.1
 */