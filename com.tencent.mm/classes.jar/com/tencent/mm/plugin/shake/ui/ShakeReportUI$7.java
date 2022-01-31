package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ShakeReportUI$7
  implements View.OnClickListener
{
  ShakeReportUI$7(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24784);
    if (!ShakeReportUI.u(this.qRs))
    {
      AppMethodBeat.o(24784);
      return;
    }
    ShakeReportUI.b(this.qRs, false);
    ShakeReportUI.c(this.qRs, true);
    ShakeReportUI.d(this.qRs, false);
    paramView = this.qRs.getContext();
    String str = this.qRs.getString(2131303593);
    ShakeReportUI.7.1 local1 = new ShakeReportUI.7.1(this);
    ShakeReportUI.7.2 local2 = new ShakeReportUI.7.2(this);
    h.a(paramView, null, new String[] { str }, "", local1, local2);
    AppMethodBeat.o(24784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.7
 * JD-Core Version:    0.7.0.1
 */