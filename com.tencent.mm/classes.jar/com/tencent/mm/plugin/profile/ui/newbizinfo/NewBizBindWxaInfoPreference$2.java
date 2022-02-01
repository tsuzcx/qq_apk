package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.ui.base.preference.Preference;

final class NewBizBindWxaInfoPreference$2
  implements View.OnClickListener
{
  NewBizBindWxaInfoPreference$2(NewBizBindWxaInfoPreference paramNewBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27479);
    ((p)g.ab(p.class)).a(this.uFu.mContext, NewBizBindWxaInfoPreference.a(this.uFu).field_username, NewBizBindWxaInfoPreference.a(this.uFu).field_appId, NewBizBindWxaInfoPreference.b(this.uFu));
    AppMethodBeat.o(27479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.2
 * JD-Core Version:    0.7.0.1
 */