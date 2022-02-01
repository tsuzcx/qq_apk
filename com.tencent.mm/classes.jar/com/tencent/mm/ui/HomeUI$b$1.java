package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

final class HomeUI$b$1
  implements View.OnClickListener
{
  HomeUI$b$1(HomeUI.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33224);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    com.tencent.mm.plugin.newtips.a.gtf().aeI(3);
    h.OAn.kvStat(10919, "0");
    HomeUI.u(this.adBr.adBf);
    if (HomeUI.adAr.booleanValue())
    {
      paramView = this.adBr.adBf;
      localObject = Boolean.TRUE;
      HomeUI.a(paramView, (Boolean)localObject, (Boolean)localObject);
    }
    if (HomeUI.adAs.booleanValue()) {
      HomeUI.a(this.adBr.adBf, Boolean.TRUE, Boolean.FALSE);
    }
    if (!WeChatEnvironment.isMonkeyEnv())
    {
      long l = Util.nowMilliSecond();
      if (l - HomeUI.v(this.adBr.adBf) <= 10000L) {
        break label190;
      }
      HomeUI.a(this.adBr.adBf, l);
      HomeUI.w(this.adBr.adBf);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(33224);
      return;
      label190:
      HomeUI.x(this.adBr.adBf);
      if (HomeUI.y(this.adBr.adBf) >= 5)
      {
        Log.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
        WeChatEnvironment.setMonkeyEnv(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.b.1
 * JD-Core Version:    0.7.0.1
 */