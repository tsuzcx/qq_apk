package com.tencent.mm.plugin.profile.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.q;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.sdk.platformtools.ak;
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
    if (this.xif != null) {
      if ((this.xfe.action != 2) && (this.xfe.action != 3)) {
        break label113;
      }
    }
    label113:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.xif.setTextColor(ak.getResources().getColorStateList(2131100733));
      }
      if ((this.JNF != null) && (!TextUtils.isEmpty(this.xfe.dEM)))
      {
        this.JNF.setVisibility(0);
        q.aJb().loadImage(this.xfe.dEM, this.JNF);
      }
      AppMethodBeat.o(26867);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.a.2
 * JD-Core Version:    0.7.0.1
 */