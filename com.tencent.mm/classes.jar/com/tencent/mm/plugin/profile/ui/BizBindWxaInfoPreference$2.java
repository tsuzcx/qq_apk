package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ai.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.ui.base.preference.Preference;

final class BizBindWxaInfoPreference$2
  implements View.OnClickListener
{
  BizBindWxaInfoPreference$2(BizBindWxaInfoPreference paramBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    ((f)g.r(f.class)).a(this.mVo.mContext, BizBindWxaInfoPreference.a(this.mVo).field_username, BizBindWxaInfoPreference.a(this.mVo).field_appId, BizBindWxaInfoPreference.b(this.mVo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference.2
 * JD-Core Version:    0.7.0.1
 */