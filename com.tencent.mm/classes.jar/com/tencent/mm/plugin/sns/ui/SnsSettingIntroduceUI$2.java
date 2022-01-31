package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ap;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.s;

final class SnsSettingIntroduceUI$2
  implements View.OnClickListener
{
  SnsSettingIntroduceUI$2(SnsSettingIntroduceUI paramSnsSettingIntroduceUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new ap();
    paramView.bGO.index = 3;
    a.udP.m(paramView);
    paramView = new Intent();
    d.b(this.pdb.mController.uMN, "setting", ".ui.setting.SettingsUI", paramView);
    paramView = new Intent();
    paramView.putExtra("enter_scene", e.e.uHS);
    d.b(this.pdb.mController.uMN, "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    h.nFQ.f(14090, new Object[] { Integer.valueOf(2) });
    this.pdb.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI.2
 * JD-Core Version:    0.7.0.1
 */