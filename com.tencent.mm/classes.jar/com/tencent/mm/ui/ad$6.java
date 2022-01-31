package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class ad$6
  implements Animation.AnimationListener
{
  ad$6(ad paramad, Runnable paramRunnable) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.uPW.isAnimating = false;
    this.uPW.uPK.setVisibility(8);
    au.DS().cre();
    ai.Fd(0);
    this.uQd.run();
    this.uPW.tryResetChattingSwipeStatus();
    y.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    this.uPW.isAnimating = true;
    au.DS().crc();
    ai.Fd(-8);
    this.uPW.z(true, 0);
    y.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ad.6
 * JD-Core Version:    0.7.0.1
 */