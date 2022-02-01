package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsBaseGalleryUI$11
  extends AnimatorListenerAdapter
{
  SnsBaseGalleryUI$11(SnsBaseGalleryUI paramSnsBaseGalleryUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(226616);
    SnsBaseGalleryUI.f(this.KOi).setAlpha(0.0F);
    AppMethodBeat.o(226616);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(226612);
    SnsBaseGalleryUI.f(this.KOi).setAlpha(0.0F);
    AppMethodBeat.o(226612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.11
 * JD-Core Version:    0.7.0.1
 */