package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

final class NewBizBindWxaInfoPreference$1
  implements View.OnClickListener
{
  NewBizBindWxaInfoPreference$1(NewBizBindWxaInfoPreference paramNewBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof String)))
    {
      y.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
      return;
    }
    y.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[] { (String)paramView });
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1020;
    localAppBrandStatObject.bFv = NewBizBindWxaInfoPreference.a(this.mZC).field_username;
    ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(this.mZC.mContext, (String)paramView, null, 0, 0, null, localAppBrandStatObject, NewBizBindWxaInfoPreference.a(this.mZC).field_appId);
    c.cg(NewBizBindWxaInfoPreference.a(this.mZC).field_username, 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference.1
 * JD-Core Version:    0.7.0.1
 */