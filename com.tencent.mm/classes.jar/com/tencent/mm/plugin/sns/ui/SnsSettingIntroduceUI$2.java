package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.as;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.e.g;

final class SnsSettingIntroduceUI$2
  implements View.OnClickListener
{
  SnsSettingIntroduceUI$2(SnsSettingIntroduceUI paramSnsSettingIntroduceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39243);
    paramView = new as();
    paramView.cod.index = 3;
    a.ymk.l(paramView);
    paramView = new Intent();
    d.b(this.rVL.getContext(), "setting", ".ui.setting.SettingsUI", paramView);
    paramView = new Intent();
    paramView.putExtra("enter_scene", e.g.yVf);
    d.b(this.rVL.getContext(), "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    h.qsU.e(14090, new Object[] { Integer.valueOf(2) });
    this.rVL.finish();
    AppMethodBeat.o(39243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI.2
 * JD-Core Version:    0.7.0.1
 */