package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class LauncherUIBottomTabView$1
  implements View.OnClickListener
{
  private final long rXi = 300L;
  
  LauncherUIBottomTabView$1(LauncherUIBottomTabView paramLauncherUIBottomTabView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29486);
    int i = ((Integer)paramView.getTag()).intValue();
    if ((LauncherUIBottomTabView.a(this.yZI) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(this.yZI) <= 300L))
    {
      ab.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
      LauncherUIBottomTabView.c(this.yZI).removeMessages(0);
      a.ymk.l(new jv());
      LauncherUIBottomTabView.a(this.yZI, System.currentTimeMillis());
      LauncherUIBottomTabView.a(this.yZI, i);
      AppMethodBeat.o(29486);
      return;
    }
    if (LauncherUIBottomTabView.d(this.yZI) != null)
    {
      if ((i != 0) || (LauncherUIBottomTabView.a(this.yZI) != 0))
      {
        ab.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
        LauncherUIBottomTabView.a(this.yZI, System.currentTimeMillis());
        LauncherUIBottomTabView.a(this.yZI, i);
        LauncherUIBottomTabView.d(this.yZI).onTabClick(i);
        AppMethodBeat.o(29486);
        return;
      }
      ab.v("MicroMsg.LauncherUITabView", "do double click check");
      LauncherUIBottomTabView.c(this.yZI).sendEmptyMessageDelayed(0, 300L);
    }
    LauncherUIBottomTabView.a(this.yZI, System.currentTimeMillis());
    LauncherUIBottomTabView.a(this.yZI, i);
    ab.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramView.getTag() });
    AppMethodBeat.o(29486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView.1
 * JD-Core Version:    0.7.0.1
 */