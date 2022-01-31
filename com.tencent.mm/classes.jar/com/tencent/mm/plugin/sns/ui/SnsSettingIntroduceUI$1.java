package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;

final class SnsSettingIntroduceUI$1
  implements View.OnClickListener
{
  SnsSettingIntroduceUI$1(SnsSettingIntroduceUI paramSnsSettingIntroduceUI) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(14090, new Object[] { Integer.valueOf(3) });
    d.b(this.pdb, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.a(this.pdb));
    this.pdb.finish();
    this.pdb.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI.1
 * JD-Core Version:    0.7.0.1
 */