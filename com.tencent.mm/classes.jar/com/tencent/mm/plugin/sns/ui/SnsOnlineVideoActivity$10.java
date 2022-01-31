package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

final class SnsOnlineVideoActivity$10
  implements MenuItem.OnMenuItemClickListener
{
  SnsOnlineVideoActivity$10(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    h.a(this.pbr, i.j.sns_upload_browse_del, i.j.app_tip, new SnsOnlineVideoActivity.10.1(this), new SnsOnlineVideoActivity.10.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.10
 * JD-Core Version:    0.7.0.1
 */