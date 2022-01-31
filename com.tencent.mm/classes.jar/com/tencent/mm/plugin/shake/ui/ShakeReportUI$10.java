package com.tencent.mm.plugin.shake.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.d.a.h;
import java.util.ArrayList;
import java.util.List;

final class ShakeReportUI$10
  implements Animation.AnimationListener
{
  ShakeReportUI$10(ShakeReportUI paramShakeReportUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(24788);
    ShakeReportUI.f(this.qRs, true);
    ShakeReportUI.g(this.qRs, false);
    if (!ShakeReportUI.C(this.qRs))
    {
      ShakeReportUI.a(this.qRs, true);
      ShakeReportUI.d(this.qRs, true);
      ShakeReportUI.D(this.qRs);
      if (ShakeReportUI.E(this.qRs).qNc != 3) {
        break label103;
      }
      a.aiu();
    }
    for (;;)
    {
      ShakeReportUI.E(this.qRs).qNd.start();
      ShakeReportUI.e(this.qRs, false);
      AppMethodBeat.o(24788);
      return;
      label103:
      if (ShakeReportUI.E(this.qRs).qNc == 5)
      {
        paramAnimation = ShakeReportUI.E(this.qRs).qNd;
        if ((paramAnimation != null) && ((paramAnimation instanceof h)))
        {
          paramAnimation = (h)paramAnimation;
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(ShakeReportUI.cmn());
          paramAnimation.qOW = localArrayList;
        }
      }
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    AppMethodBeat.i(24787);
    ShakeReportUI.c(this.qRs, false);
    ShakeReportUI.e(this.qRs, true);
    ShakeReportUI.f(this.qRs, false);
    ShakeReportUI.g(this.qRs, true);
    ShakeReportUI.B(this.qRs);
    AppMethodBeat.o(24787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.10
 * JD-Core Version:    0.7.0.1
 */