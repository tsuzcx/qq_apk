package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;

final class HomeUI$6
  implements View.OnLongClickListener
{
  HomeUI$6(HomeUI paramHomeUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(232553);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/HomeUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    if ((BuildInfo.DEBUG) || (CrashReportFactory.hasDebuger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      HomeUI.o(this.ODr);
    }
    a.a(false, this, "com/tencent/mm/ui/HomeUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(232553);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.6
 * JD-Core Version:    0.7.0.1
 */