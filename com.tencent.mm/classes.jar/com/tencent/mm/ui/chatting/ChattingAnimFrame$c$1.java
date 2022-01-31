package com.tencent.mm.ui.chatting;

import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.ab;

final class ChattingAnimFrame$c$1
  extends ChattingAnimFrame.a
{
  ChattingAnimFrame$c$1(ChattingAnimFrame.c paramc, ChattingAnimFrame paramChattingAnimFrame)
  {
    super(paramc.zxE);
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(30513);
    paramAnimation = this.zxV;
    if (paramAnimation.zxT != null)
    {
      paramAnimation.zxT.post(new ChattingAnimFrame.c.2(paramAnimation));
      AppMethodBeat.o(30513);
      return;
    }
    ab.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
    AppMethodBeat.o(30513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame.c.1
 * JD-Core Version:    0.7.0.1
 */