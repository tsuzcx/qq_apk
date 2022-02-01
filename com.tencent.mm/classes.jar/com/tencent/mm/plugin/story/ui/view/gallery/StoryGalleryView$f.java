package com.tencent.mm.plugin.story.ui.view.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeOutMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
public final class StoryGalleryView$f
  extends AnimatorListenerAdapter
{
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(120440);
    StoryGalleryView.i(this.FGW).setVisibility(8);
    AppMethodBeat.o(120440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.f
 * JD-Core Version:    0.7.0.1
 */