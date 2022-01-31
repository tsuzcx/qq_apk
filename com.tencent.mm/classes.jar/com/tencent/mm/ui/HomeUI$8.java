package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bp;

final class HomeUI$8
  implements View.OnClickListener
{
  HomeUI$8(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153766);
    h.qsU.kvStat(10919, "0");
    HomeUI.n(this.yYw);
    if (HomeUI.yXL.booleanValue())
    {
      paramView = this.yYw;
      Boolean localBoolean = Boolean.TRUE;
      HomeUI.a(paramView, localBoolean, localBoolean);
    }
    if (HomeUI.yXM.booleanValue()) {
      HomeUI.a(this.yYw, Boolean.TRUE, Boolean.FALSE);
    }
    if (!bp.dsd())
    {
      long l = ah.aoy();
      if (l - HomeUI.o(this.yYw) > 10000L)
      {
        HomeUI.a(this.yYw, l);
        HomeUI.p(this.yYw);
        AppMethodBeat.o(153766);
        return;
      }
      HomeUI.q(this.yYw);
      if (HomeUI.r(this.yYw) >= 5)
      {
        ab.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
        bp.pN(true);
      }
    }
    AppMethodBeat.o(153766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.8
 * JD-Core Version:    0.7.0.1
 */