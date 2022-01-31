package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import a.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryVideoView$b$a$1
  implements Runnable
{
  StoryVideoView$b$a$1(StoryVideoView.b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(110908);
    ab.i(StoryVideoView.a(this.sVh.sVg.sVf), "onTextureUpdate");
    if (StoryVideoView.f(this.sVh.sVg.sVf) == null)
    {
      AppMethodBeat.o(110908);
      return;
    }
    StoryVideoView.h(this.sVh.sVg.sVf);
    Object localObject = StoryVideoView.f(this.sVh.sVg.sVf);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(110908);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setAlpha(1.0F);
    AppMethodBeat.o(110908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView.b.a.1
 * JD-Core Version:    0.7.0.1
 */