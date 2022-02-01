package com.tencent.mm.plugin.subapp.ui.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$4
  extends AnimatorListenerAdapter
{
  a$4(a parama) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(29060);
    this.zRj.qOY.setAlpha(0.0F);
    AppMethodBeat.o(29060);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(29059);
    this.zRj.qOY.setAlpha(0.0F);
    AppMethodBeat.o(29059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a.4
 * JD-Core Version:    0.7.0.1
 */