package com.tencent.mm.search.c;

import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/search/ui/SimilarEmojiDialog$galleryScale$1", "Lcom/tencent/mm/search/gesture/IOnGalleryScale;", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-emojisdk_release"})
public final class b$b
  implements com.tencent.mm.search.d.b
{
  public final void dKU()
  {
    long l1 = 0L;
    AppMethodBeat.i(202410);
    c localc = b.a(this.EZw);
    localc.setEnabled(false);
    long l2 = ((localc.getHeight() - localc.getTranslationY()) / localc.getHeight() * 300.0F);
    if (l2 < 0L) {}
    for (;;)
    {
      localc.animate().translationY(localc.getHeight()).setDuration(l1).withEndAction((Runnable)new b.b.a(this)).start();
      AppMethodBeat.o(202410);
      return;
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.search.c.b.b
 * JD-Core Version:    0.7.0.1
 */