package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConversationWithAppBrandListView$12
  implements Animator.AnimatorListener
{
  ConversationWithAppBrandListView$12(ConversationWithAppBrandListView paramConversationWithAppBrandListView) {}
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    AppMethodBeat.i(38408);
    ConversationWithAppBrandListView.k(this.IDx);
    AppMethodBeat.o(38408);
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(38407);
    ConversationWithAppBrandListView.k(this.IDx);
    AppMethodBeat.o(38407);
  }
  
  public final void onAnimationRepeat(Animator paramAnimator) {}
  
  public final void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.12
 * JD-Core Version:    0.7.0.1
 */