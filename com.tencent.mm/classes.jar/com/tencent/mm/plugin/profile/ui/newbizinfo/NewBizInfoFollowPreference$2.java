package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;

final class NewBizInfoFollowPreference$2
  implements View.OnClickListener
{
  NewBizInfoFollowPreference$2(NewBizInfoFollowPreference paramNewBizInfoFollowPreference) {}
  
  public final void onClick(View paramView)
  {
    if ((NewBizInfoFollowPreference.a(this.mZG) != null) && ((NewBizInfoFollowPreference.a(this.mZG) instanceof b)))
    {
      paramView = (b)NewBizInfoFollowPreference.a(this.mZG);
      ((com.tencent.mm.pluginsdk.g)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.g.class)).a(paramView.mVy, paramView.mZy, paramView.dnp, true, new b.3(paramView));
      c.cg(paramView.dnp.field_username, 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.2
 * JD-Core Version:    0.7.0.1
 */