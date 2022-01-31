package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class NormalUserFooterPreference$a$1
  implements MenuItem.OnMenuItemClickListener
{
  NormalUserFooterPreference$a$1(NormalUserFooterPreference.a parama) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(NormalUserFooterPreference.b(this.mYE.mYC), 1, false);
    paramMenuItem.phI = new NormalUserFooterPreference.a.1.1(this);
    paramMenuItem.phH = new NormalUserFooterPreference.a.1.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1
 * JD-Core Version:    0.7.0.1
 */