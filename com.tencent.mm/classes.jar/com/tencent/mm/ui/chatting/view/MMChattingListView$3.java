package com.tencent.mm.ui.chatting.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMChattingListView$3
  extends AnimatorListenerAdapter
{
  MMChattingListView$3(MMChattingListView paramMMChattingListView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(32763);
    super.onAnimationEnd(paramAnimator);
    MMChattingListView.a(this.zQW).setEmpty();
    AppMethodBeat.o(32763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.MMChattingListView.3
 * JD-Core Version:    0.7.0.1
 */