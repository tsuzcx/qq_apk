package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;

final class SnsSettingIntroduceUI$1
  implements View.OnClickListener
{
  SnsSettingIntroduceUI$1(SnsSettingIntroduceUI paramSnsSettingIntroduceUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39242);
    h.qsU.e(14090, new Object[] { Integer.valueOf(3) });
    d.b(this.rVL, "sns", ".ui.SnsTimeLineUI", SnsSettingIntroduceUI.a(this.rVL));
    this.rVL.finish();
    this.rVL.overridePendingTransition(0, 0);
    AppMethodBeat.o(39242);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingIntroduceUI.1
 * JD-Core Version:    0.7.0.1
 */