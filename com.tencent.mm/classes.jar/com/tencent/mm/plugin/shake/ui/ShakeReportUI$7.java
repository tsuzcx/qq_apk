package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class ShakeReportUI$7
  implements View.OnClickListener
{
  ShakeReportUI$7(ShakeReportUI paramShakeReportUI) {}
  
  public final void onClick(View paramView)
  {
    if (!ShakeReportUI.t(this.odm)) {
      return;
    }
    ShakeReportUI.b(this.odm, false);
    ShakeReportUI.c(this.odm, true);
    ShakeReportUI.d(this.odm, false);
    paramView = this.odm.mController.uMN;
    String str = this.odm.getString(R.l.shake_item_change_bgimg);
    ShakeReportUI.7.1 local1 = new ShakeReportUI.7.1(this);
    ShakeReportUI.7.2 local2 = new ShakeReportUI.7.2(this);
    h.a(paramView, null, new String[] { str }, "", local1, local2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.7
 * JD-Core Version:    0.7.0.1
 */