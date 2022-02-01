package com.tencent.mm.plugin.story.ui.sns;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryView.b;
import com.tencent.mm.sdk.platformtools.aq;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
public final class c$b
  implements StoryGalleryView.b
{
  public final void aqN()
  {
    long l1 = 0L;
    AppMethodBeat.i(119952);
    View localView = c.a(this.Bpj);
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
      localView.animate().translationY(localView.getHeight()).setDuration(l1).withEndAction((Runnable)new a(this)).start();
      AppMethodBeat.o(119952);
      return;
      AppMethodBeat.o(119952);
      return;
      label104:
      l1 = l2;
    }
  }
  
  public final void bG(float paramFloat) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1"})
  static final class a
    implements Runnable
  {
    a(c.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(119951);
      new aq().post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(119950);
          if (this.Bpl.Bpk.Bpj.isShowing()) {
            this.Bpl.Bpk.Bpj.cancel();
          }
          AppMethodBeat.o(119950);
        }
      });
      AppMethodBeat.o(119951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c.b
 * JD-Core Version:    0.7.0.1
 */