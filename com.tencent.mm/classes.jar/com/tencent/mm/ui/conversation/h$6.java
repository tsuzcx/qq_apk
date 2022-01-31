package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class h$6
  extends AnimatorListenerAdapter
{
  h$6(h paramh, View paramView, h.f paramf) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(34358);
    super.onAnimationEnd(paramAnimator);
    h.a(this.Akm, this.Akn, this.Akp);
    ab.i("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] setBackground back!");
    AppMethodBeat.o(34358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.h.6
 * JD-Core Version:    0.7.0.1
 */