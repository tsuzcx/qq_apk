package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;

final class NewBizBindWxaInfoPreference$1
  implements View.OnClickListener
{
  NewBizBindWxaInfoPreference$1(NewBizBindWxaInfoPreference paramNewBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23827);
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof String)))
    {
      ab.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
      AppMethodBeat.o(23827);
      return;
    }
    ab.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[] { (String)paramView });
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1020;
    localAppBrandStatObject.cmF = NewBizBindWxaInfoPreference.a(this.pDr).field_username;
    ((j)g.E(j.class)).a(this.pDr.mContext, (String)paramView, null, 0, 0, null, localAppBrandStatObject, NewBizBindWxaInfoPreference.a(this.pDr).field_appId);
    c.cZ(NewBizBindWxaInfoPreference.a(this.pDr).field_username, 500);
    AppMethodBeat.o(23827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.1
 * JD-Core Version:    0.7.0.1
 */