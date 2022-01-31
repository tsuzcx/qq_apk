package com.tencent.mm.plugin.story.image2video;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$VideoLoopTask$run$2$1"})
final class StoryFakeVideoPlayView$d$a
  implements Runnable
{
  StoryFakeVideoPlayView$d$a(StoryFakeVideoPlayView.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(151026);
    StoryFakeVideoPlayView.a locala = this.stG.stF.getCallback();
    if (locala != null) {
      locala.mG();
    }
    this.stG.stF.setCallback(null);
    AppMethodBeat.o(151026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView.d.a
 * JD-Core Version:    0.7.0.1
 */