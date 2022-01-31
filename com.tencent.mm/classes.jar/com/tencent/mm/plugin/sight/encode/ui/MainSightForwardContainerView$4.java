package com.tencent.mm.plugin.sight.encode.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MainSightForwardContainerView$4
  implements Runnable
{
  MainSightForwardContainerView$4(MainSightForwardContainerView paramMainSightForwardContainerView) {}
  
  public final void run()
  {
    AppMethodBeat.i(25037);
    if ((!MainSightForwardContainerView.b(this.qWc)) || ((MainSightForwardContainerView.a(this.qWc) != null) && (MainSightForwardContainerView.a(this.qWc).qWx.cnk())))
    {
      MainSightForwardContainerView.c(this.qWc);
      AppMethodBeat.o(25037);
      return;
    }
    MainSightForwardContainerView.d(this.qWc).setVisibility(0);
    if ((MainSightForwardContainerView.a(this.qWc) != null) && (!MainSightForwardContainerView.a(this.qWc).cnr()) && (MainSightForwardContainerView.e(this.qWc).getVisibility() != 0))
    {
      MainSightForwardContainerView.e(this.qWc).setVisibility(0);
      MainSightForwardContainerView.e(this.qWc).startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.f(this.qWc), 2131034181));
    }
    AppMethodBeat.o(25037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.4
 * JD-Core Version:    0.7.0.1
 */