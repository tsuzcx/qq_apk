package com.tencent.mm.ui.chatting;

import android.view.animation.AnimationSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;

final class ChattingAnimFrame$c
  extends AnimationSet
{
  int mSize;
  private long zxS;
  MMAnimateView zxT;
  
  public ChattingAnimFrame$c(ChattingAnimFrame paramChattingAnimFrame, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    super(false);
    AppMethodBeat.i(30515);
    this.mSize = paramInt2;
    switch (paramInt1)
    {
    default: 
      addAnimation(new ChattingAnimFrame.b(paramChattingAnimFrame, 0, this.mSize));
    }
    for (;;)
    {
      setAnimationListener(new ChattingAnimFrame.c.1(this, paramChattingAnimFrame));
      this.zxS = (500L + paramLong);
      reset();
      setDuration(ChattingAnimFrame.Po(paramInt1));
      AppMethodBeat.o(30515);
      return;
      addAnimation(new ChattingAnimFrame.b(paramChattingAnimFrame, 999, this.mSize));
      addAnimation(new ChattingAnimFrame.b(paramChattingAnimFrame, paramInt1, this.mSize));
      continue;
      addAnimation(new ChattingAnimFrame.b(paramChattingAnimFrame, paramInt1, this.mSize, paramBoolean));
      addAnimation(new ChattingAnimFrame.b(paramChattingAnimFrame, 999, this.mSize));
      continue;
      addAnimation(new ChattingAnimFrame.b(paramChattingAnimFrame, paramInt1, this.mSize));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame.c
 * JD-Core Version:    0.7.0.1
 */