package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.o;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.KeyValuePreference;

public final class a$2
  extends KeyValuePreference
{
  public a$2(Context paramContext, c.b paramb)
  {
    super(paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23251);
    super.onBindView(paramView);
    if (this.pAD != null) {
      if ((this.pxG.action != 2) && (this.pxG.action != 3)) {
        break label113;
      }
    }
    label113:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.pAD.setTextColor(ah.getResources().getColorStateList(2131690781));
      }
      if ((this.zry != null) && (!TextUtils.isEmpty(this.pxG.cDz)))
      {
        this.zry.setVisibility(0);
        o.ahG().a(this.pxG.cDz, this.zry);
      }
      AppMethodBeat.o(23251);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.2
 * JD-Core Version:    0.7.0.1
 */