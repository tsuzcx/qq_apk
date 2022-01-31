package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class ad$7
  implements Runnable
{
  ad$7(ad paramad) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    au.DS().cre();
    ai.Fd(0);
    this.uPW.ohK.onSwipe(1.0F);
    if (this.uPW.uPK != null) {
      this.uPW.uPK.cJm();
    }
    this.uPW.uPS.cyU();
    this.uPW.tryResetChattingSwipeStatus();
    y.i("MicroMsg.LauncherUI.NewChattingTabUI", "doJobOnChattingAnimEnd cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public final String toString()
  {
    return super.toString() + "|chattingView_onAnimationEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ad.7
 * JD-Core Version:    0.7.0.1
 */