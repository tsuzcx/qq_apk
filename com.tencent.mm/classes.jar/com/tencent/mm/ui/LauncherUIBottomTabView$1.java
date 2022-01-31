package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.jm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class LauncherUIBottomTabView$1
  implements View.OnClickListener
{
  private final long peu = 300L;
  
  LauncherUIBottomTabView$1(LauncherUIBottomTabView paramLauncherUIBottomTabView) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if ((LauncherUIBottomTabView.a(this.uLD) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUIBottomTabView.b(this.uLD) <= 300L))
    {
      y.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
      LauncherUIBottomTabView.c(this.uLD).removeMessages(0);
      a.udP.m(new jm());
      LauncherUIBottomTabView.a(this.uLD, System.currentTimeMillis());
      LauncherUIBottomTabView.a(this.uLD, i);
      return;
    }
    if (LauncherUIBottomTabView.d(this.uLD) != null)
    {
      if ((i != 0) || (LauncherUIBottomTabView.a(this.uLD) != 0))
      {
        y.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
        LauncherUIBottomTabView.a(this.uLD, System.currentTimeMillis());
        LauncherUIBottomTabView.a(this.uLD, i);
        LauncherUIBottomTabView.d(this.uLD).qc(i);
        return;
      }
      y.v("MicroMsg.LauncherUITabView", "do double click check");
      LauncherUIBottomTabView.c(this.uLD).sendEmptyMessageDelayed(0, 300L);
    }
    LauncherUIBottomTabView.a(this.uLD, System.currentTimeMillis());
    LauncherUIBottomTabView.a(this.uLD, i);
    y.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramView.getTag() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUIBottomTabView.1
 * JD-Core Version:    0.7.0.1
 */