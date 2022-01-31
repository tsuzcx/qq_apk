package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.ui.base.preference.Preference;

final class BizBindWxaInfoPreference$2
  implements View.OnClickListener
{
  BizBindWxaInfoPreference$2(BizBindWxaInfoPreference paramBizBindWxaInfoPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23295);
    ((l)g.E(l.class)).a(this.pxT.mContext, BizBindWxaInfoPreference.a(this.pxT).field_username, BizBindWxaInfoPreference.a(this.pxT).field_appId, BizBindWxaInfoPreference.b(this.pxT));
    AppMethodBeat.o(23295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference.2
 * JD-Core Version:    0.7.0.1
 */