package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.jm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class LauncherUITabView$1
  implements View.OnClickListener
{
  private final long peu = 300L;
  
  LauncherUITabView$1(LauncherUITabView paramLauncherUITabView) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    if ((LauncherUITabView.a(this.uLS) == i) && (i == 0) && (System.currentTimeMillis() - LauncherUITabView.b(this.uLS) <= 300L))
    {
      y.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
      LauncherUITabView.c(this.uLS).removeMessages(0);
      a.udP.m(new jm());
      LauncherUITabView.a(this.uLS, System.currentTimeMillis());
      LauncherUITabView.a(this.uLS, i);
      return;
    }
    if (LauncherUITabView.d(this.uLS) != null)
    {
      if ((i != 0) || (LauncherUITabView.a(this.uLS) != 0))
      {
        LauncherUITabView.a(this.uLS, System.currentTimeMillis());
        LauncherUITabView.a(this.uLS, i);
        LauncherUITabView.d(this.uLS).qc(i);
        return;
      }
      LauncherUITabView.c(this.uLS).sendEmptyMessageDelayed(0, 300L);
    }
    LauncherUITabView.a(this.uLS, System.currentTimeMillis());
    LauncherUITabView.a(this.uLS, i);
    y.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[] { (Integer)paramView.getTag() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUITabView.1
 * JD-Core Version:    0.7.0.1
 */