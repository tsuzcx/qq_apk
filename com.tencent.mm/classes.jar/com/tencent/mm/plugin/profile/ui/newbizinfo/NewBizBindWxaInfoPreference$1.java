package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.Preference;

final class NewBizBindWxaInfoPreference$1
  implements View.OnClickListener
{
  NewBizBindWxaInfoPreference$1(NewBizBindWxaInfoPreference paramNewBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27478);
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof String)))
    {
      ad.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
      AppMethodBeat.o(27478);
      return;
    }
    ad.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[] { (String)paramView });
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1020;
    localAppBrandStatObject.dbt = NewBizBindWxaInfoPreference.a(this.uFu).field_username;
    ((n)g.ab(n.class)).a(this.uFu.mContext, (String)paramView, null, 0, 0, null, localAppBrandStatObject, NewBizBindWxaInfoPreference.a(this.uFu).field_appId);
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bO(NewBizBindWxaInfoPreference.a(this.uFu).field_username, 500);
    AppMethodBeat.o(27478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.1
 * JD-Core Version:    0.7.0.1
 */