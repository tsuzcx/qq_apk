package com.tencent.mm.plugin.story.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/StoryBrowseUI$onCreate$2$onGalleryExitFromTop$1$1"})
final class StoryBrowseUI$b$a
  implements Runnable
{
  StoryBrowseUI$b$a(StoryBrowseUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(109988);
    new ak().post((Runnable)new StoryBrowseUI.b.a.1(this));
    AppMethodBeat.o(109988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryBrowseUI.b.a
 * JD-Core Version:    0.7.0.1
 */