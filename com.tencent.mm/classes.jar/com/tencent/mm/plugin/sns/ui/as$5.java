package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.e.e;

final class as$5
  implements View.OnClickListener
{
  as$5(as paramas) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("enter_scene", e.e.uHT);
    d.b(as.a(this.pbW), "setting", ".ui.setting.SettingsPrivacyUI", paramView);
    h.nFQ.f(14098, new Object[] { Integer.valueOf(8) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.5
 * JD-Core Version:    0.7.0.1
 */