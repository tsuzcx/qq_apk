package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsBaseGalleryUI$1
  extends AnimatorListenerAdapter
{
  SnsBaseGalleryUI$1(SnsBaseGalleryUI paramSnsBaseGalleryUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(98481);
    SnsBaseGalleryUI.a(this.yIG).setAlpha(0.0F);
    AppMethodBeat.o(98481);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(98480);
    SnsBaseGalleryUI.a(this.yIG).setAlpha(0.0F);
    AppMethodBeat.o(98480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI.1
 * JD-Core Version:    0.7.0.1
 */