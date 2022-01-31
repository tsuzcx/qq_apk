package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class PreviewHdHeadImg$1
  implements MenuItem.OnMenuItemClickListener
{
  PreviewHdHeadImg$1(PreviewHdHeadImg paramPreviewHdHeadImg) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.nSq, 1, false);
    paramMenuItem.phH = new PreviewHdHeadImg.1.1(this);
    paramMenuItem.phI = new PreviewHdHeadImg.1.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PreviewHdHeadImg.1
 * JD-Core Version:    0.7.0.1
 */