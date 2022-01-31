package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryVideoView$c
  implements Runnable
{
  StoryVideoView$c(StoryVideoView paramStoryVideoView, bw parambw, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(110913);
    ab.i(StoryVideoView.a(this.sVf), "reportStopLocalVideo");
    a locala = d.Zo(StoryVideoView.k(this.sVf));
    if (locala != null)
    {
      bw localbw = this.sVi.eo(locala.eVA);
      j.b localb = j.svi;
      localbw.em(j.b.cAB().mW(this.sxP)).et(locala.videoBitrate).ake();
    }
    AppMethodBeat.o(110913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.StoryVideoView.c
 * JD-Core Version:    0.7.0.1
 */