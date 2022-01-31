package com.tencent.mm.ui.chatting.c;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.d.a;

final class u$2
  implements Runnable
{
  u$2(u paramu) {}
  
  public final void run()
  {
    AppMethodBeat.i(31541);
    ab.i("MicroMsg.HistoryMsgTongueComponent", "show animation! GoBackToHistoryMsgLayout!!!");
    u.a(this.zGP).setVisibility(0);
    u.a(this.zGP, 1);
    if (((af)this.zGP.caz.ay(af.class)).dJj()) {
      this.zGP.PG(1);
    }
    for (;;)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(u.a(this.zGP).getWidth(), 0.0F, 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.zGP.caz.zJz.getContext(), 17432581));
      u.a(this.zGP).startAnimation(localTranslateAnimation);
      AppMethodBeat.o(31541);
      return;
      if (u.b(this.zGP)) {
        this.zGP.PG(3);
      } else {
        this.zGP.PG(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.u.2
 * JD-Core Version:    0.7.0.1
 */