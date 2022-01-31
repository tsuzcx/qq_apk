package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.e.g;

final class at$2
  implements View.OnClickListener
{
  at$2(at paramat) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39202);
    paramView = new Intent();
    paramView.putExtra("enter_scene", e.g.yVg);
    d.b(at.a(this.rUG), "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    h.qsU.e(14098, new Object[] { Integer.valueOf(8) });
    AppMethodBeat.o(39202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.2
 * JD-Core Version:    0.7.0.1
 */