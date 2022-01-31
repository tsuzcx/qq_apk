package com.tencent.mm.plugin.story.ui.sns;

import a.l;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
public final class b$b
  implements StoryGalleryView.b
{
  public final void bh(float paramFloat) {}
  
  public final void cFn()
  {
    long l1 = 0L;
    AppMethodBeat.i(110237);
    View localView = b.a(this.sKn);
    long l2;
    if (localView != null)
    {
      localView.setEnabled(false);
      l2 = ((localView.getHeight() - localView.getTranslationY()) / localView.getHeight() * 300.0F);
      if (l2 >= 0L) {
        break label104;
      }
    }
    for (;;)
    {
      localView.animate().translationY(localView.getHeight()).setDuration(l1).withEndAction((Runnable)new b.b.a(this)).start();
      AppMethodBeat.o(110237);
      return;
      AppMethodBeat.o(110237);
      return;
      label104:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b.b
 * JD-Core Version:    0.7.0.1
 */