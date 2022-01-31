package com.tencent.mm.plugin.story.ui.view.gallery;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class n$b$a
  implements Runnable
{
  n$b$a(n.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(151315);
    this.sUk.sUj.setAlpha(1.0F);
    this.sUk.sUj.getFakeLayer().mu(n.a(this.sUk.sUj));
    n.a locala = n.sUi;
    ab.i(n.access$getTAG$cp(), "imageVideoView onPrepared");
    AppMethodBeat.o(151315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n.b.a
 * JD-Core Version:    0.7.0.1
 */