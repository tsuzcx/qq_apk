package com.tencent.mm.plugin.nearby.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nearby.a.c;

final class NearbySayHiListUI$6
  implements View.OnClickListener
{
  NearbySayHiListUI$6(NearbySayHiListUI paramNearbySayHiListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55500);
    NearbySayHiListUI.a(this.pdR, new c(2, 0.0F, 0.0F, 0, 0, "", ""));
    g.Rc().a(NearbySayHiListUI.f(this.pdR), 0);
    paramView = this.pdR;
    AppCompatActivity localAppCompatActivity = this.pdR.getContext();
    this.pdR.getString(2131297087);
    NearbySayHiListUI.a(paramView, com.tencent.mm.ui.base.h.b(localAppCompatActivity, this.pdR.getString(2131301752), true, new NearbySayHiListUI.6.1(this)));
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(11429, "0");
    AppMethodBeat.o(55500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.6
 * JD-Core Version:    0.7.0.1
 */