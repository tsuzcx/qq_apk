package com.tencent.mm.plugin.nearby.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class NearbySayHiListUI$6
  implements View.OnClickListener
{
  NearbySayHiListUI$6(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void onClick(View paramView)
  {
    NearbySayHiListUI.a(this.mDP, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
    g.Dk().a(NearbySayHiListUI.f(this.mDP), 0);
    paramView = this.mDP;
    AppCompatActivity localAppCompatActivity = this.mDP.mController.uMN;
    this.mDP.getString(b.h.app_tip);
    NearbySayHiListUI.a(paramView, com.tencent.mm.ui.base.h.b(localAppCompatActivity, this.mDP.getString(b.h.nearby_friend_clearing_location), true, new NearbySayHiListUI.6.1(this)));
    com.tencent.mm.plugin.report.service.h.nFQ.aC(11429, "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.6
 * JD-Core Version:    0.7.0.1
 */