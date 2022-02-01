package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.KeyValuePreference;

public final class a$2
  extends KeyValuePreference
{
  public a$2(Context paramContext, b.b paramb)
  {
    super(paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26867);
    super.onBindView(paramView);
    if (this.GZI != null) {
      if ((this.GWI.action != 2) && (this.GWI.action != 3)) {
        break label114;
      }
    }
    label114:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.GZI.setTextColor(MMApplicationContext.getResources().getColorStateList(R.e.dkD));
      }
      if ((this.WrQ != null) && (!TextUtils.isEmpty(this.GWI.icon)))
      {
        this.WrQ.setVisibility(0);
        q.bml().loadImage(this.GWI.icon, this.WrQ);
      }
      AppMethodBeat.o(26867);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.2
 * JD-Core Version:    0.7.0.1
 */