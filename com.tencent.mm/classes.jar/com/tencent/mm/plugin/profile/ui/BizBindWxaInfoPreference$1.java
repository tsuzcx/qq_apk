package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.base.preference.Preference;

final class BizBindWxaInfoPreference$1
  implements View.OnClickListener
{
  BizBindWxaInfoPreference$1(BizBindWxaInfoPreference paramBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof String))) {
      return;
    }
    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
    localAppBrandStatObject.scene = 1020;
    localAppBrandStatObject.bFv = BizBindWxaInfoPreference.a(this.mVo).field_username;
    ((com.tencent.mm.plugin.appbrand.r.d)g.r(com.tencent.mm.plugin.appbrand.r.d.class)).a(this.mVo.mContext, (String)paramView, null, 0, 0, null, localAppBrandStatObject, BizBindWxaInfoPreference.a(this.mVo).field_appId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference.1
 * JD-Core Version:    0.7.0.1
 */