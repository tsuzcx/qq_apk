package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.ui.base.preference.Preference;

final class BizBindWxaInfoPreference$1
  implements View.OnClickListener
{
  BizBindWxaInfoPreference$1(BizBindWxaInfoPreference paramBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23294);
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof String)))
    {
      AppMethodBeat.o(23294);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1020;
    localAppBrandStatObject.cmF = BizBindWxaInfoPreference.a(this.pxT).field_username;
    ((j)g.E(j.class)).a(this.pxT.mContext, (String)paramView, null, 0, 0, null, localAppBrandStatObject, BizBindWxaInfoPreference.a(this.pxT).field_appId);
    AppMethodBeat.o(23294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference.1
 * JD-Core Version:    0.7.0.1
 */