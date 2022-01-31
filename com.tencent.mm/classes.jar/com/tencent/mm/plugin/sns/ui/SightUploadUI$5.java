package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.m.b;
import com.tencent.mm.ui.tools.a.c;

final class SightUploadUI$5
  implements MenuItem.OnMenuItemClickListener
{
  SightUploadUI$5(SightUploadUI paramSightUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (this.oTB.isFinishing()) {
      return false;
    }
    SightUploadUI.a(this.oTB, SightUploadUI.a(this.oTB).getText().toString());
    int i = SightUploadUI.a(this.oTB).getPasterLen();
    paramMenuItem = c.d(SightUploadUI.a(this.oTB)).Ig(b.Ac());
    paramMenuItem.wfM = true;
    paramMenuItem.a(new SightUploadUI.5.1(this, i));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.5
 * JD-Core Version:    0.7.0.1
 */