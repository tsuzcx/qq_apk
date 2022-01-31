package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.ui.widget.a.d;

final class b$2
  implements MenuItem.OnMenuItemClickListener
{
  b$2(b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(this.mZA.mZy, 1, false);
    paramMenuItem.phH = new b.2.1(this);
    paramMenuItem.phI = new b.2.2(this);
    paramMenuItem.cfU();
    c.cg(this.mZA.dnp.field_username, 600);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.2
 * JD-Core Version:    0.7.0.1
 */