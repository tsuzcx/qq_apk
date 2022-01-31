package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.a.pv;
import com.tencent.mm.sdk.b.a;

final class SightUploadUI$3
  implements MenuItem.OnMenuItemClickListener
{
  SightUploadUI$3(SightUploadUI paramSightUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new pv();
    paramMenuItem.bZp.type = 0;
    paramMenuItem.bZp.bZr = false;
    a.udP.m(paramMenuItem);
    this.oTB.XM();
    this.oTB.finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.3
 * JD-Core Version:    0.7.0.1
 */