package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class SightUploadUI$4
  implements MenuItem.OnMenuItemClickListener
{
  SightUploadUI$4(SightUploadUI paramSightUploadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.oTB.mController.uMN;
    String str = this.oTB.getString(i.j.sight_save_tips);
    SightUploadUI.4.1 local1 = new SightUploadUI.4.1(this);
    h.a(paramMenuItem, null, new String[] { str }, null, local1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SightUploadUI.4
 * JD-Core Version:    0.7.0.1
 */