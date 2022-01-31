package com.tencent.mm.plugin.story.ui.sns;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/sns/StoryEntranceDialog$galleryScale$1$onGalleryExitFromTop$1$1$1"})
final class b$b$a$1
  implements Runnable
{
  b$b$a$1(b.b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(110235);
    if (this.sKp.sKo.sKn.isShowing()) {
      this.sKp.sKo.sKn.cancel();
    }
    AppMethodBeat.o(110235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b.b.a.1
 * JD-Core Version:    0.7.0.1
 */