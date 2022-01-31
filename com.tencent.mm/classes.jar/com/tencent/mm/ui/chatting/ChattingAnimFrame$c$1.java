package com.tencent.mm.ui.chatting;

import android.view.animation.Animation;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.y;

final class ChattingAnimFrame$c$1
  extends ChattingAnimFrame.a
{
  ChattingAnimFrame$c$1(ChattingAnimFrame.c paramc, ChattingAnimFrame paramChattingAnimFrame)
  {
    super(paramc.viK);
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.viV;
    if (paramAnimation.viT != null)
    {
      paramAnimation.viT.post(new ChattingAnimFrame.c.2(paramAnimation));
      return;
    }
    y.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame.c.1
 * JD-Core Version:    0.7.0.1
 */