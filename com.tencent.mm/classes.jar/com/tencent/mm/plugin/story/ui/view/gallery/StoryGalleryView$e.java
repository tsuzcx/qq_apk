package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeInMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
public final class StoryGalleryView$e
  extends AnimatorListenerAdapter
{
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(110789);
    StoryGalleryView.f(this.sTX).setVisibility(0);
    AppMethodBeat.o(110789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.e
 * JD-Core Version:    0.7.0.1
 */