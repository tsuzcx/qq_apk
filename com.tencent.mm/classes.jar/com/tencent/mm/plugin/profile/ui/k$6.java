package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.o;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.KeyValuePreference;

final class k$6
  extends KeyValuePreference
{
  k$6(k paramk, Context paramContext, c.b paramb)
  {
    super(paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.mXQ != null) {
      if ((this.mXH.action != 2) && (this.mXH.action != 3)) {
        break label102;
      }
    }
    label102:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mXQ.setTextColor(ae.getResources().getColorStateList(R.e.phone_item_text_color));
      }
      if ((this.vcZ != null) && (!TextUtils.isEmpty(this.mXH.bVO)))
      {
        this.vcZ.setVisibility(0);
        o.ON().a(this.mXH.bVO, this.vcZ);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k.6
 * JD-Core Version:    0.7.0.1
 */