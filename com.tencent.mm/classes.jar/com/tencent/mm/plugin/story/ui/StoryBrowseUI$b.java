package com.tencent.mm.plugin.story.ui;

import a.l;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
public final class StoryBrowseUI$b
  implements StoryGalleryView.b
{
  public final void bh(float paramFloat)
  {
    AppMethodBeat.i(109989);
    ImageView localImageView = StoryBrowseUI.a(this.sHk);
    if (localImageView != null)
    {
      localImageView.setAlpha(paramFloat);
      AppMethodBeat.o(109989);
      return;
    }
    AppMethodBeat.o(109989);
  }
  
  public final void cFn()
  {
    long l1 = 0L;
    AppMethodBeat.i(109990);
    StoryGalleryView localStoryGalleryView = StoryBrowseUI.b(this.sHk);
    long l2;
    if (localStoryGalleryView != null)
    {
      localStoryGalleryView.setEnabled(false);
      l2 = ((localStoryGalleryView.getHeight() - localStoryGalleryView.getTranslationY()) / localStoryGalleryView.getHeight() * 300.0F);
      if (l2 >= 0L) {
        break label161;
      }
    }
    for (;;)
    {
      Object localObject = StoryBrowseUI.a(this.sHk);
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(l1);
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).start();
            }
          }
        }
      }
      localStoryGalleryView.animate().translationY(localStoryGalleryView.getHeight()).setDuration(l1).withEndAction((Runnable)new StoryBrowseUI.b.a(this)).start();
      AppMethodBeat.o(109990);
      return;
      AppMethodBeat.o(109990);
      return;
      label161:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI.b
 * JD-Core Version:    0.7.0.1
 */