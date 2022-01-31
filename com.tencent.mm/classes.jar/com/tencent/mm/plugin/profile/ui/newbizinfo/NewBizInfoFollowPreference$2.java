package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.pluginsdk.h;

final class NewBizInfoFollowPreference$2
  implements View.OnClickListener
{
  NewBizInfoFollowPreference$2(NewBizInfoFollowPreference paramNewBizInfoFollowPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23850);
    if ((NewBizInfoFollowPreference.a(this.pDx) != null) && ((NewBizInfoFollowPreference.a(this.pDx) instanceof b)))
    {
      paramView = (b)NewBizInfoFollowPreference.a(this.pDx);
      ((h)g.E(h.class)).a(paramView.pyd, paramView.pDe, paramView.contact, true, new b.7(paramView));
      c.cZ(paramView.contact.field_username, 1000);
    }
    AppMethodBeat.o(23850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoFollowPreference.2
 * JD-Core Version:    0.7.0.1
 */