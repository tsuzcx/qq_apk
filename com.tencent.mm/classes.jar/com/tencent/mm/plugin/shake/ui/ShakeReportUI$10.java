package com.tencent.mm.plugin.shake.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.av.a;
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
    ShakeReportUI.f(this.odm, true);
    ShakeReportUI.g(this.odm, false);
    if (!ShakeReportUI.A(this.odm))
    {
      ShakeReportUI.a(this.odm, true);
      ShakeReportUI.d(this.odm, true);
      ShakeReportUI.B(this.odm);
      if (ShakeReportUI.C(this.odm).nYS != 3) {
        break label91;
      }
      a.Ps();
    }
    for (;;)
    {
      ShakeReportUI.C(this.odm).nYT.start();
      ShakeReportUI.e(this.odm, false);
      return;
      label91:
      if (ShakeReportUI.C(this.odm).nYS == 5)
      {
        paramAnimation = ShakeReportUI.C(this.odm).nYT;
        if ((paramAnimation != null) && ((paramAnimation instanceof h)))
        {
          paramAnimation = (h)paramAnimation;
          ArrayList localArrayList = new ArrayList();
          localArrayList.addAll(ShakeReportUI.bAR());
          paramAnimation.oaN = localArrayList;
        }
      }
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    ShakeReportUI.c(this.odm, false);
    ShakeReportUI.e(this.odm, true);
    ShakeReportUI.f(this.odm, false);
    ShakeReportUI.g(this.odm, true);
    ShakeReportUI.z(this.odm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.10
 * JD-Core Version:    0.7.0.1
 */