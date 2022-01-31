package com.tencent.mm.plugin.sight.encode.ui;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;

final class MainSightForwardContainerView$4
  implements Runnable
{
  MainSightForwardContainerView$4(MainSightForwardContainerView paramMainSightForwardContainerView) {}
  
  public final void run()
  {
    if ((!MainSightForwardContainerView.b(this.ohP)) || ((MainSightForwardContainerView.a(this.ohP) != null) && (MainSightForwardContainerView.a(this.ohP).oik.bBK()))) {
      MainSightForwardContainerView.c(this.ohP);
    }
    do
    {
      return;
      MainSightForwardContainerView.d(this.ohP).setVisibility(0);
    } while ((MainSightForwardContainerView.a(this.ohP) == null) || (MainSightForwardContainerView.a(this.ohP).bBQ()) || (MainSightForwardContainerView.e(this.ohP).getVisibility() == 0));
    MainSightForwardContainerView.e(this.ohP).setVisibility(0);
    MainSightForwardContainerView.e(this.ohP).startAnimation(AnimationUtils.loadAnimation(MainSightForwardContainerView.f(this.ohP), R.a.fast_faded_in));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.4
 * JD-Core Version:    0.7.0.1
 */