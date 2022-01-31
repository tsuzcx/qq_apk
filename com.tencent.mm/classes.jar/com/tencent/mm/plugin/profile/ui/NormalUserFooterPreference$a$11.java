package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

final class NormalUserFooterPreference$a$11
  implements MenuItem.OnMenuItemClickListener
{
  NormalUserFooterPreference$a$11(NormalUserFooterPreference.a parama, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new d(NormalUserFooterPreference.b(this.mYE.mYC), 1, false);
    paramMenuItem.phI = new NormalUserFooterPreference.a.11.1(this);
    paramMenuItem.phH = new NormalUserFooterPreference.a.11.2(this);
    paramMenuItem.cfU();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11
 * JD-Core Version:    0.7.0.1
 */