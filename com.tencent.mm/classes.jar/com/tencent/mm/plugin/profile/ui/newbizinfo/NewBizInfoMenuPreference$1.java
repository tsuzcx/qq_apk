package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.e;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class NewBizInfoMenuPreference$1
  implements View.OnClickListener
{
  NewBizInfoMenuPreference$1(NewBizInfoMenuPreference paramNewBizInfoMenuPreference, e parame) {}
  
  public final void onClick(View paramView)
  {
    if (this.mZO == null)
    {
      y.w("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo is null, err");
      return;
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cg(NewBizInfoMenuPreference.a(this.mZP).field_username, 1100);
    y.i("MicroMsg.NewBizInfoServicePreference", "onClick serviceInfo.type:%d", new Object[] { Integer.valueOf(this.mZO.type) });
    switch (this.mZO.type)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      return;
    case 0: 
      NewBizInfoMenuPreference.a(this.mZP, this.mZO);
      return;
    case 2: 
      com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.a(this.mZO, NewBizInfoMenuPreference.b(this.mZP));
      b.a(NewBizInfoMenuPreference.a(this.mZP).field_username, this.mZO.id, this.mZO.key, b.nat, this.mZO.name, b.dD(NewBizInfoMenuPreference.c(this.mZP).indexOf(this.mZO), -1), this.mZO.ceb);
      return;
    }
    com.tencent.mm.plugin.profile.ui.newbizinfo.b.c.a(this.mZO, NewBizInfoMenuPreference.b(this.mZP), NewBizInfoMenuPreference.a(this.mZP).field_username);
    b.a(NewBizInfoMenuPreference.a(this.mZP).field_username, this.mZO.id, this.mZO.key, b.nat, this.mZO.name, b.dD(NewBizInfoMenuPreference.c(this.mZP).indexOf(this.mZO), -1), this.mZO.value);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMenuPreference.1
 * JD-Core Version:    0.7.0.1
 */