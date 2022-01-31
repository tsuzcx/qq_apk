package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.b.b.ae;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class u$2
  implements Runnable
{
  u$2(u paramu) {}
  
  public final void run()
  {
    y.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
    u.a(this.vrk).setVisibility(0);
    u.a(this.vrk, 1);
    if (((ae)this.vrk.byx.ac(ae.class)).cFn()) {
      this.vrk.Hc(1);
    }
    for (;;)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(u.a(this.vrk).getWidth(), 0.0F, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.vrk.byx.vtz.getContext(), 17432581));
      u.a(this.vrk).startAnimation(localTranslateAnimation);
      return;
      if (u.b(this.vrk)) {
        this.vrk.Hc(3);
      } else {
        this.vrk.Hc(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.u.2
 * JD-Core Version:    0.7.0.1
 */