package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class PreviewLastHdHeadImg$1
  implements MenuItem.OnMenuItemClickListener
{
  PreviewLastHdHeadImg$1(PreviewLastHdHeadImg paramPreviewLastHdHeadImg) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.nSv, 1, false);
    paramMenuItem.phH = new PreviewLastHdHeadImg.1.1(this);
    paramMenuItem.phI = new PreviewLastHdHeadImg.1.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewLastHdHeadImg.1
 * JD-Core Version:    0.7.0.1
 */