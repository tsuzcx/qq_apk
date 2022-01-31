package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.tools.TestTimeForChatting;

final class ad$5
  implements OnLayoutChangedLinearLayout.a
{
  long start = 0L;
  
  ad$5(ad paramad) {}
  
  public final void cAa()
  {
    if (this.uPW.mChattingInAnim == null)
    {
      this.uPW.mChattingInAnim = AnimationUtils.loadAnimation(this.uPW.ohK, MMFragmentActivity.a.uOe);
      this.uPW.mChattingInAnim.setAnimationListener(new ad.5.1(this));
    }
    if (this.uPW.mNeedChattingAnim)
    {
      this.uPW.uPK.setOndispatchDraw(new ad.5.2(this));
      this.uPW.mNeedChattingAnim = false;
    }
    for (;;)
    {
      this.uPW.uPN.vbj = null;
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
      return;
      ad.a(this.uPW);
      ad.b(this.uPW);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.ad.5
 * JD-Core Version:    0.7.0.1
 */