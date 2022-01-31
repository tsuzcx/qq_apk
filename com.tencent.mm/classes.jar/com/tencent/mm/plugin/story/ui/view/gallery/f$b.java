package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class f$b
  implements Runnable
{
  f$b(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(110732);
    ab.d(f.access$getTAG$cp(), "MSG_STORY_LONG_PRESS_CHECK");
    if (this.sSq.sSn)
    {
      a locala = this.sSq.sSm;
      if (locala == null) {
        break label64;
      }
      if (((Boolean)locala.invoke()).booleanValue() == true) {
        f.a(this.sSq);
      }
    }
    AppMethodBeat.o(110732);
    return;
    label64:
    AppMethodBeat.o(110732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.f.b
 * JD-Core Version:    0.7.0.1
 */