package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class NewBizInfoMenuPreference$3
  implements n.d
{
  NewBizInfoMenuPreference$3(NewBizInfoMenuPreference paramNewBizInfoMenuPreference, e parame) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = (e)this.mZO.nap.get(paramInt);
    if (paramMenuItem.type == 2)
    {
      c.a(paramMenuItem, NewBizInfoMenuPreference.b(this.mZP));
      b.a(NewBizInfoMenuPreference.a(this.mZP).field_username, this.mZO.id, this.mZO.key, b.nat, this.mZO.name, b.dD(NewBizInfoMenuPreference.c(this.mZP).indexOf(this.mZO), paramInt), this.mZO.ceb);
    }
    while (paramMenuItem.type != 5) {
      return;
    }
    c.a(paramMenuItem, NewBizInfoMenuPreference.b(this.mZP), NewBizInfoMenuPreference.a(this.mZP).field_username);
    b.a(NewBizInfoMenuPreference.a(this.mZP).field_username, this.mZO.id, this.mZO.key, b.nat, this.mZO.name, b.dD(NewBizInfoMenuPreference.c(this.mZP).indexOf(this.mZO), paramInt), this.mZO.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.3
 * JD-Core Version:    0.7.0.1
 */