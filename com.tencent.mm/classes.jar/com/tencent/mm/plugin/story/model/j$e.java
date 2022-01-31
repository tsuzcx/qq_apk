package com.tencent.mm.plugin.story.model;

import a.l;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class j$e
  implements Runnable
{
  j$e(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(109081);
    Looper.prepare();
    j.a(this.svq, new ak());
    Looper.loop();
    AppMethodBeat.o(109081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.j.e
 * JD-Core Version:    0.7.0.1
 */