package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class LauncherUITabView$1
  implements View.OnClickListener
{
  private final long rXi = 300L;
  
  LauncherUITabView$1(LauncherUITabView paramLauncherUITabView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29515);
    int i = ((Integer)paramView.getTag()).intValue();
    if ((LauncherUITabView.a(this.yZX) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(this.yZX) <= 300L))
    {
      ab.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
      LauncherUITabView.c(this.yZX).removeMessages(0);
      a.ymk.l(new jv());
      LauncherUITabView.a(this.yZX, System.currentTimeMillis());
      LauncherUITabView.a(this.yZX, i);
      AppMethodBeat.o(29515);
      return;
    }
    if (LauncherUITabView.d(this.yZX) != null)
    {
      if ((i != 0) || (LauncherUITabView.a(this.yZX) != 0))
      {
        LauncherUITabView.a(this.yZX, System.currentTimeMillis());
        LauncherUITabView.a(this.yZX, i);
        LauncherUITabView.d(this.yZX).onTabClick(i);
        AppMethodBeat.o(29515);
        return;
      }
      LauncherUITabView.c(this.yZX).sendEmptyMessageDelayed(0, 300L);
    }
    LauncherUITabView.a(this.yZX, System.currentTimeMillis());
    LauncherUITabView.a(this.yZX, i);
    ab.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramView.getTag() });
    AppMethodBeat.o(29515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView.1
 * JD-Core Version:    0.7.0.1
 */