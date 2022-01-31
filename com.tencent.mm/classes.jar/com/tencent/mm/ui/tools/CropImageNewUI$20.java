package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class CropImageNewUI$20
  implements MenuItem.OnMenuItemClickListener
{
  CropImageNewUI$20(CropImageNewUI paramCropImageNewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.vYH, 1, false);
    paramMenuItem.phH = new CropImageNewUI.20.1(this);
    paramMenuItem.phI = new CropImageNewUI.20.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.20
 * JD-Core Version:    0.7.0.1
 */